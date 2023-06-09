package ImplementacaoDAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import db.DB;
import db.DbException;

import dao.EnderecoDao;
import entidades.Endereco;
import entidades.Cliente;

import dao.ClienteFisicoDao;
import entidades.ClienteFisico;

public class ClienteFisicoDaoJDBC implements ClienteFisicoDao {

    private Connection conexaoBanco;
	
    public ClienteFisicoDaoJDBC(Connection conn) {
        this.conexaoBanco = conn;
    }

    @Override
    public void insert(ClienteFisico cliente) {
        PreparedStatement inserirEndereco = null;
        try {
            PreparedStatement inserirClienteFisico = conexaoBanco.prepareStatement("INSERT INTO pessoa_fisica (nome, cpf, id_cliente) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            inserirClienteFisico.setString(1, cliente.getNome());
            inserirClienteFisico.setString(2, cliente.getCPF());
            inserirClienteFisico.setInt(3, cliente.getID());
            int clientesFisicosAcrescentados = inserirClienteFisico.executeUpdate();

            if (clientesFisicosAcrescentados > 0) {
                ResultSet resultado = inserirClienteFisico.getGeneratedKeys();
                if (resultado.next()) {
                    int idClienteFisico = resultado.getInt(1);
                    cliente.setID(idClienteFisico);
                }
                DB.closeResultSet(resultado);
            }

            EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
            enderecoDao.insert(cliente.getEndereco(), cliente);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(inserirEndereco);
        }
    }

    @Override
    public void update(ClienteFisico cliente) {
        PreparedStatement atualizarClienteFisico = null;
        try {
            atualizarClienteFisico = conexaoBanco.prepareStatement("UPDATE pessoa_fisica SET nome = ?, cpf = ? WHERE id_cliente = ?");
            atualizarClienteFisico.setString(1, cliente.getNome());
            atualizarClienteFisico.setString(2, cliente.getCPF());
            atualizarClienteFisico.setInt(3, cliente.getID());

            atualizarClienteFisico.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(atualizarClienteFisico);
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        PreparedStatement deletarClienteFisico = null;
        try {
            deletarClienteFisico = conexaoBanco.prepareStatement("DELETE FROM pessoa_fisica WHERE id_cliente = ?");
            deletarClienteFisico.setInt(1, id);

            deletarClienteFisico.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(deletarClienteFisico);
        }
    }

    @Override
    public ClienteFisico findById(Integer id) {
        PreparedStatement encontrarClienteFisico = null;
        ResultSet resultado = null;
        try {
            encontrarClienteFisico = conexaoBanco.prepareStatement("SELECT * FROM pessoa_fisica WHERE id_cliente = ?");
            encontrarClienteFisico.setInt(1, id);
            resultado = encontrarClienteFisico.executeQuery();

            if (resultado.next()) {
                ClienteFisico cliente = new ClienteFisico();
                cliente.setID(resultado.getInt("id_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCPF(resultado.getString("cpf"));

                EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
                Endereco endereco = enderecoDao.findByCliente(cliente);
                cliente.setEndereco(endereco);

                return cliente;
            }

            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultado);
            DB.closeStatement(encontrarClienteFisico);
        }
    }

    @Override
    public List<ClienteFisico> findAll() {
        PreparedStatement encontrarClientesFisicos = null;
        ResultSet resultado = null;
        try {
            encontrarClientesFisicos = conexaoBanco.prepareStatement("SELECT * FROM pessoa_fisica");
            resultado = encontrarClientesFisicos.executeQuery();

            List<ClienteFisico> clientesFisicos = new ArrayList<>();

            while (resultado.next()) {
                ClienteFisico cliente = new ClienteFisico();
                cliente.setID(resultado.getInt("id_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCPF(resultado.getString("cpf"));

                EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();
                Endereco endereco = enderecoDao.findById(cliente.getID());
                cliente.setEndereco(endereco);

                clientesFisicos.add(cliente);
            }

            return clientesFisicos;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultado);
            DB.closeStatement(encontrarClientesFisicos);
        }
    }
}
