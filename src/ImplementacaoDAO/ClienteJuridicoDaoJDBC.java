package ImplementacaoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteJuridicoDao;
import db.DB;
import db.DbException;
import entidades.Cliente;
import entidades.ClienteJuridico;

public class ClienteJuridicoDaoJDBC implements ClienteJuridicoDao {

    private Connection conexaoClienteJuridico;
	
    public ClienteJuridicoDaoJDBC(Connection conexaoBanco) {
        this.conexaoClienteJuridico = conexaoBanco;
    }

    @Override
    public void insert(Cliente cliente, ClienteJuridico clienteJuridico) {
        PreparedStatement inserirClienteJuridico = null;       
        try{
            inserirClienteJuridico = conexaoClienteJuridico.prepareStatement("INSERT INTO pessoa_juridico () VALUES (?, ?, ?)", 
            															Statement.RETURN_GENERATED_KEYS);
           
            int clientesFisicosAcrescentados = inserirClienteJuridico.executeUpdate();

            if (clientesFisicosAcrescentados > 0) {
                ResultSet resultado = inserirClienteJuridico.getGeneratedKeys();
                
                if (resultado.next()) {
                    int idClienteJuridico = resultado.getInt(1);
                    cliente.setID(idClienteJuridico);
                }
                
                DB.closeResultSet(resultado);
            }
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
            
        } finally {
            DB.closeStatement(inserirClienteJuridico);
        }
    }

    @Override
    public void update(ClienteJuridico objeto) {
        PreparedStatement atualizarClienteJuridico = null;
        
        try{
            atualizarClienteJuridico = conexaoClienteJuridico.prepareStatement("UPDATE pessoa_juridico SET ");
            atualizarClienteJuridico.executeUpdate();
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
            
        } finally {
            DB.closeStatement(atualizarClienteJuridico);
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        PreparedStatement deletarClienteJuridico = null;
        try{
            deletarClienteJuridico = conexaoClienteJuridico.prepareStatement("DELETE FROM pessoa_juridico WHERE id_pf = ?");
            deletarClienteJuridico.setInt(1, id);
            deletarClienteJuridico.executeUpdate();
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
            
        } finally {
            DB.closeStatement(deletarClienteJuridico);
        }
    }

    @Override
    public Cliente findById(Integer id) {
        PreparedStatement encontrarClienteJuridico = null;
        ResultSet resultado = null;
        try{
            encontrarClienteJuridico = conexaoClienteJuridico.prepareStatement("SELECT * FROM pessoa_juridico WHERE id_pf = ?");
            encontrarClienteJuridico.setInt(1, id);
            resultado = encontrarClienteJuridico.executeQuery();

            if (resultado.next()) {
                ClienteJuridico cliente = new ClienteJuridico();
                return cliente;
            }

            return null;
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
            
        } finally {
            DB.closeResultSet(resultado);
            DB.closeStatement(encontrarClienteJuridico);
        }
    
    }

    @Override
    public List<ClienteJuridico> findAll() {
        PreparedStatement encontrarClientesJuridico = null;
        ResultSet resultado = null;
        
        try {
            encontrarClientesJuridico = conexaoClienteJuridico.prepareStatement("SELECT * FROM pessoa_juridica");
            resultado = encontrarClientesJuridico.executeQuery();

            List<ClienteJuridico> clientesJuridico = new ArrayList<>();

            while (resultado.next()) {
                ClienteJuridico cliente = new ClienteJuridico();
                clientesJuridico.add(cliente);
            }

            return clientesJuridico;
            
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
            
        } finally {
            DB.closeResultSet(resultado);
            DB.closeStatement(encontrarClientesJuridico);
        }
    }

}