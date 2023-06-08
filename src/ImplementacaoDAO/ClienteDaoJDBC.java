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
    
	private Connection conexaoBanco;
	
	public ClienteDaoJDBC(Connection conn) {
		this.conexaoBanco = conn;
	}
	
	@Override
	public void insert(Cliente cliente) {
		PreparedStatement inserirCliente = null;
        try{
            inserirCliente = conexaoBanco.prepareStatement("insert into clientes (id_tel, id_end) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
			inserirCliente.setInt(1, cliente.getTelefone());
			inserirCliente.setInt(2, cliente.getEndereco());
			int clientesAcrescentados = inserirCliente.executeUpdate();

			if (clientesAcrescentados > 0) {
				ResultSet chavesGeradasCliente = inserirCliente.getGeneratedKeys();   
				while (chavesGeradasCliente.next()) {
					int idCliente = chavesGeradasCliente.getInt(1);
					cliente.setID(idCliente);
				}
			}
			
			else {
				System.out.println("Nenhum endereço acrescentado!");
			}	
        }catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(inserirCliente);
		} 
	}

	@Override
	public void update(Cliente cliente) {
		// PreparedStatement st = null;
		// try {
		// 	st = conn.prepareStatement("UPDATE cliente SET Telefone = ? WHERE Id = ? "); 
		// 	st.setInt(1, cliente.getTelefone());
		// 	st.setInt(2, cliente.getID());
		// 	st.executeUpdate();
		// }
		// catch (SQLException e) {
		// 	throw new DbException(e.getMessage());
		// }
		// finally {
		// 	DB.closeStatement(st);
		// }	
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// PreparedStatement st = null;
		// try {
		// 	st = conn.prepareStatement("DELETE FROM cliente WHERE id = ?"); 
		// 	st.setInt(1, id);
		// 	int linhasAfetadas = st.executeUpdate();
		// 	if (linhasAfetadas == 0) {
		// 		throw new DbException("Nenhuma exclusão ocorreu! Id inexistente");
		// 	}
		// }
		// catch (SQLException e) {
		// 	throw new Exception(e.getMessage());  //Não podem ser deletados departamentos que tenham vendedores
		// }
		// finally {
		// 	DB.closeStatement(st);
		// }
	}

	@Override
	public Cliente findById(Integer id) {
		return null;
		// PreparedStatement st = null;
		// ResultSet rs = null;
		// try {
		// 	st = conn.prepareStatement("SELECT cliente.* FROM departamento "
		// 			+ " WHERE cliente.Id = ?");
		// 	st.setInt(1,id);
		// 	rs = st.executeQuery();
		// 	if (rs.next()) {
		// 		Cliente departamento = instanciaDepartamento(rs);
		// 		return departamento;
		// 	}
		// } 
		// catch (SQLException e){
		// 	throw new DbException(e.getMessage());
		// }
		// finally {
		// 	DB.closeStatement(st);
		// 	DB.closeResultSet(rs);
		// }
		// return null;
	}

	@Override
	public List<Cliente> findAll() {
		return null;
		// PreparedStatement st = null;
		// ResultSet rs = null;
		// try {
		// 	st = conn.prepareStatement(
		// 			"SELECT departamento.* FROM departamento ORDER BY Nome");
			
		// 	rs = st.executeQuery();
			
		// 	// criar uma lista para colocar todos os vendedores de um departamento
		// 	List <Cliente> lista = new ArrayList<>();
			
		// 	while (rs.next()) {
		// 		Cliente departamento = instanciaDepartamento(rs);
		// 		lista.add(departamento);
		// 	}
		// 	return lista;
		// } 
		// catch (SQLException e){
		// 	throw new DbException(e.getMessage());
		// }
		// finally {
		// 	DB.closeStatement(st);
		// 	DB.closeResultSet(rs);
		// }
	}

	public Cliente instanciaDepartamento(ResultSet cliente) throws SQLException {
		// Cliente cliente = new Cliente();
		// cliente.setID(rs.getInt("ID"));
		// cliente.setTelefone(rs.getInt("Telefone"));
		return (Cliente) cliente;
	}

    
}
