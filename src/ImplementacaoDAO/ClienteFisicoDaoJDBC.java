package ImplementacaoDAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import db.DB;
import db.DbException;
import entidades.Cliente;
import entidades.ClienteFisico;
import dao.ClienteFisicoDao;

public class ClienteFisicoDaoJDBC implements ClienteFisicoDao {

    private Connection conexaoClienteFisico;
	
    public ClienteFisicoDaoJDBC(Connection conexaoBanco) {
        this.conexaoClienteFisico = conexaoBanco;
    }

    @Override
    public void insert(Cliente cliente, ClienteFisico clienteFisico) {
        PreparedStatement inserirClienteFisico = null;
        
        try{
            inserirClienteFisico = conexaoClienteFisico.prepareStatement("INSERT INTO pessoa_fisica (nome, cpf, id_cliente) VALUES (?, ?, ?)", 
            															Statement.RETURN_GENERATED_KEYS);
            inserirClienteFisico.setString(1, clienteFisico.getNome());
            inserirClienteFisico.setString(2, clienteFisico.getCPF());
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
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
            
        } finally {
            DB.closeStatement(inserirClienteFisico);
        }
    }

    @Override
    public void update(ClienteFisico clienteFisico) {
        PreparedStatement atualizarClienteFisico = null;
        
        try{
            atualizarClienteFisico = conexaoClienteFisico.prepareStatement("UPDATE pessoa_fisica SET nome = ?, cpf = ? WHERE id_pf = ?");
            atualizarClienteFisico.setString(1, clienteFisico.getNome());
            atualizarClienteFisico.setString(2, clienteFisico.getCPF());
            atualizarClienteFisico.setInt(3, clienteFisico.getID());
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
        
        try{
            deletarClienteFisico = conexaoClienteFisico.prepareStatement("DELETE FROM pessoa_fisica WHERE id_pf = ?");
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
        
        try{
            encontrarClienteFisico = conexaoClienteFisico.prepareStatement("SELECT * FROM pessoa_fisica WHERE id_pf = ?");
            encontrarClienteFisico.setInt(1, id);
            resultado = encontrarClienteFisico.executeQuery();

            if (resultado.next()) {
                ClienteFisico cliente = new ClienteFisico();
                cliente.setID(resultado.getInt("id_pf"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCPF(resultado.getString("cpf"));

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
            encontrarClientesFisicos = conexaoClienteFisico.prepareStatement("SELECT * FROM pessoa_fisica");
            resultado = encontrarClientesFisicos.executeQuery();

            List<ClienteFisico> clientesFisicos = new ArrayList<>();

            while (resultado.next()) {
                ClienteFisico cliente = new ClienteFisico();
                cliente.setID(resultado.getInt("id_pf"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setCPF(resultado.getString("cpf"));

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
