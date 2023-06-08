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

public class EnderecoDaoJDBC implements EnderecoDao{

    private Connection conexaoBanco;
	
	public EnderecoDaoJDBC(Connection conn) {
		this.conexaoBanco = conn;
	}

    @Override
    public void insert(Endereco endereco, Cliente cliente) {
        PreparedStatement inserirEndereco = null;
        try{
            inserirEndereco = conexaoBanco.prepareStatement("insert into enderecos (numero, logradouro) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
            inserirEndereco.setString(1, endereco.getNumero());
            inserirEndereco.setString(2, endereco.getLogradouro());
            int enderecosAcrescentados = inserirEndereco.executeUpdate();
            if (enderecosAcrescentados > 0) {
                ResultSet chavesGeradasEndereco = inserirEndereco.getGeneratedKeys();   
                while (chavesGeradasEndereco.next()) {
                    int idEndereco = chavesGeradasEndereco.getInt(1);
                    cliente.setEndereco(idEndereco);
                }
            }
            else {
                System.out.println("Nenhum endereço acrescentado!");
                //throw new UnsupportedOperationException("Unimplemented method 'insert'");
            }
        }catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(inserirEndereco);
		} 
    }

    @Override
    public void update(Endereco obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Endereco id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Endereco findById(Endereco id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Endereco> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    
}
