package ImplementacaoDAO;

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
// import db.DbIntegrityException;
// import entidades.Departamento;
import entidades.Cliente;

public class ClienteDaoJDBC implements ClienteDao{
    
	private Connection conn;
	
	public ClienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Cliente cliente) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO cliente (Nome) VALUES (?)",
			Statement.RETURN_GENERATED_KEYS); // para retornar o Id do novo departamento inserido
			st.setInt(1, cliente.getID());
						
			int linhasAfetadas = st.executeUpdate();
			
			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();  // pega o Id gerado
				if (rs.next()) {
					int id = rs.getInt(1);
					cliente.setID(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro inesperado! Nenhuma inserção ocorreu");
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
	public void update(Cliente cliente) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE departamento SET Telefone = ? WHERE Id = ? "); 
			st.setInt(1, cliente.getTelefone());
			st.setInt(2, cliente.getID());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}	
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM departamento WHERE id = ?"); 
			st.setInt(1, id);
			int linhasAfetadas = st.executeUpdate();
			if (linhasAfetadas == 0) {
				throw new DbException("Nenhuma exclusão ocorreu! Id inexistente");
			}
		}
		catch (SQLException e) {
			throw new Exception(e.getMessage());  //Não podem ser deletados departamentos que tenham vendedores
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Cliente findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT departamento.* FROM departamento "
					+ " WHERE departamento.Id = ?");
			st.setInt(1,id);
			rs = st.executeQuery();
			if (rs.next()) {
				Cliente departamento = instanciaDepartamento(rs);
				return departamento;
			}
		} 
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
	}

	@Override
	public List<Cliente> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT departamento.* FROM departamento ORDER BY Nome");
			
			rs = st.executeQuery();
			
			// criar uma lista para colocar todos os vendedores de um departamento
			List <Cliente> lista = new ArrayList<>();
			
			while (rs.next()) {
				Cliente departamento = instanciaDepartamento(rs);
				lista.add(departamento);
			}
			return lista;
		} 
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	public Cliente instanciaDepartamento(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setID(rs.getInt("Id"));
		cliente.setTelefone(rs.getInt("Nome"));
		return cliente;
	}

    
}
