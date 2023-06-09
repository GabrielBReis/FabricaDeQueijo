package ImplementacaoDAO;

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
import entidades.Cliente;

public class ClienteDaoJDBC implements ClienteDao {

    private Connection conexaoBanco;

    public ClienteDaoJDBC(Connection conn) {
        this.conexaoBanco = conn;
    }

    @Override
    public void insert(Cliente cliente) {
        PreparedStatement inserirCliente = null;
        try {
            inserirCliente = conexaoBanco.prepareStatement("INSERT INTO clientes (id_tel, id_end) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            inserirCliente.setInt(1, cliente.getTelefone());
            inserirCliente.setString(2, cliente.getEndereco());
            int clientesAcrescentados = inserirCliente.executeUpdate();

            if (clientesAcrescentados > 0) {
                ResultSet chavesGeradasCliente = inserirCliente.getGeneratedKeys();
                if (chavesGeradasCliente.next()) {
                    int idCliente = chavesGeradasCliente.getInt(1);
                    cliente.setID(idCliente);
                }
                DB.closeResultSet(chavesGeradasCliente);
            } else {
                System.out.println("Nenhum endereço acrescentado!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(inserirCliente);
        }
    }

    @Override
    public void update(Cliente cliente) {
        PreparedStatement atualizarCliente = null;
        try {
            atualizarCliente = conexaoBanco.prepareStatement("UPDATE clientes SET id_tel = ?, id_end = ? WHERE id_cliente = ?");
            atualizarCliente.setInt(1, cliente.getTelefone());
            atualizarCliente.setString(2, cliente.getEndereco());
            atualizarCliente.setInt(3, cliente.getID());
            atualizarCliente.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(atualizarCliente);
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        PreparedStatement deletarCliente = null;
        try {
            deletarCliente = conexaoBanco.prepareStatement("DELETE FROM clientes WHERE id_cliente = ?");
            deletarCliente.setInt(1, id);
            deletarCliente.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(deletarCliente);
        }
    }

    @Override
    public Cliente findById(Integer id) {
        PreparedStatement encontrarCliente = null;
        ResultSet resultado = null;
        try {
            encontrarCliente = conexaoBanco.prepareStatement("SELECT * FROM clientes WHERE id_cliente = ?");
            encontrarCliente.setInt(1, id);
            resultado = encontrarCliente.executeQuery();

            if (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(resultado.getInt("id_cliente"));
                cliente.setTelefone(resultado.getInt("id_tel"));
                cliente.setEndereco(resultado.getString("id_end"));
                return cliente;
            }

            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultado);
            DB.closeStatement(encontrarCliente);
        }
    }

    @Override
    public List<Cliente> findAll() {
        PreparedStatement encontrarClientes = null;
        ResultSet resultado = null;
        try {
            encontrarClientes = conexaoBanco.prepareStatement("SELECT * FROM clientes");
            resultado = encontrarClientes.executeQuery();

            List<Cliente> clientes = new ArrayList<>();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(resultado.getInt("id_cliente"));
                cliente.setTelefone(resultado.getInt("id_tel"));
                cliente.setEndereco(resultado.getString("id_end"));
                clientes.add(cliente);
            }

            return clientes;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultado);
            DB.closeStatement(encontrarClientes);
        }
    }
}
