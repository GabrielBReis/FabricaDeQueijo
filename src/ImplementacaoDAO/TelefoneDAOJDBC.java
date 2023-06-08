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
// import dao.DepartamentoDao;
import db.DB;
import db.DbException;

import dao.TelefoneDao;
import entidades.Cliente;
import entidades.Telefone;

public class TelefoneDAOJDBC implements TelefoneDao{

    private Connection conexaoBanco;
	
	public TelefoneDAOJDBC(Connection conn) {
		this.conexaoBanco = conn;
	}

    @Override
    public void insert(Telefone telefone, Cliente cliente) {
        PreparedStatement st = null;
        try{
            st = conexaoBanco.prepareStatement("insert into telefones (ddd, numero) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, telefone.getDDD());
            st.setString(2, telefone.getNumero());
            int telefonesAcrescentados = st.executeUpdate();
            
            if (telefonesAcrescentados > 0) {
                ResultSet chavesGeradasTelefone = st.getGeneratedKeys();   
                while (chavesGeradasTelefone.next()) {
                    int idTelefone = chavesGeradasTelefone.getInt(1);
                    cliente.setTelefone(idTelefone);
                }
            }else {
                System.out.println("Nenhum telefone acrescentado!");
                //throw new UnsupportedOperationException("Unimplemented method 'insert'");
            }	
        }
        catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
        
    }

    @Override
    public void update(Telefone obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Telefone id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Telefone findById(Telefone id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Telefone> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


    
}
