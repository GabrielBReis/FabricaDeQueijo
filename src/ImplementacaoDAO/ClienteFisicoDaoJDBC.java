package ImplementacaoDAO;

import java.util.List;
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
        try{
            PreparedStatement inserirClienteFisico = conexaoBanco.prepareStatement("insert into pessoa_fisica (nome, cpf, id_cliente) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
						inserirClienteFisico.setString(1, cliente.getNome());
						inserirClienteFisico.setString(2, cliente.getCPF());
						inserirClienteFisico.setInt(3, cliente.getID());
						int clientesFiscosAcrescentados = inserirClienteFisico.executeUpdate();
        }catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(inserirEndereco);
		} 
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(ClienteFisico obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Cliente findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<ClienteFisico> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

   
    
}
