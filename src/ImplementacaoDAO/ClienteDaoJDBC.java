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

    private Connection conexaoCliente;

    public ClienteDaoJDBC(Connection conexaoBanco) {
        this.conexaoCliente = conexaoBanco;
    }

    @Override
    public void insert(Cliente cliente) {
    	
        PreparedStatement inserirCliente = null;
        
        try{
        	inserirCliente = conexaoCliente.prepareStatement("INSERT INTO clientes (id_telefone, id_endereco) VALUES (?, ?)",
                    										Statement.RETURN_GENERATED_KEYS);
            inserirCliente.setInt(1, cliente.getTelefone());
            inserirCliente.setInt(2, cliente.getEndereco());
            int clientesAcrescentados = inserirCliente.executeUpdate();

            if (clientesAcrescentados > 0) {
                ResultSet chavesGeradasCliente = inserirCliente.getGeneratedKeys();
                
                if (chavesGeradasCliente.next()) {
                    int idCliente = chavesGeradasCliente.getInt(1);
                    cliente.setID(idCliente);
                }
                
                DB.closeResultSet(chavesGeradasCliente);
                
            } else {
                System.out.println("Nenhum cliente acrescentado!");
                
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
        
        try{
            atualizarCliente = conexaoCliente.prepareStatement("UPDATE clientes SET id_tel = ?, id_end = ? WHERE id_cliente = ?");
            atualizarCliente.setInt(1, cliente.getTelefone());
            atualizarCliente.setInt(2, cliente.getEndereco());
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
        
        try{
            deletarCliente = conexaoCliente.prepareStatement("DELETE FROM clientes WHERE id_cliente = ?");
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
            encontrarCliente = conexaoCliente.prepareStatement("SELECT * FROM clientes WHERE id_cliente = ?");
            encontrarCliente.setInt(1, id);
            resultado = encontrarCliente.executeQuery();

            if (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(resultado.getInt("id_cliente"));
                cliente.setTelefone(resultado.getInt("id_tel"));
                cliente.setEndereco(resultado.getInt("id_end"));
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
        
        try{
            encontrarClientes = conexaoCliente.prepareStatement("SELECT * FROM clientes");
            resultado = encontrarClientes.executeQuery();

            List<Cliente> clientes = new ArrayList<>();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(resultado.getInt("id_cliente"));
                cliente.setTelefone(resultado.getInt("id_tel"));
                cliente.setEndereco(resultado.getInt("id_end"));
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
