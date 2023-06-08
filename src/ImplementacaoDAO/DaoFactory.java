package ImplementacaoDAO;

import dao.ClienteDao;
import dao.ClienteFisicoDao;
import dao.EnderecoDao;
import dao.TelefoneDao;
import db.DB;


public class DaoFactory {

    public static ClienteDao createClienteDao() {
		return new ClienteDaoJDBC(DB.getConnection());
	}
	
	public static ClienteFisicoDao createClienteFisicoDao() {
		return new ClienteFisicoDaoJDBC(DB.getConnection());
	}

    public static EnderecoDao createEnderecoDao() {
		return new EnderecoDaoJDBC(DB.getConnection());
	}
	
	public static TelefoneDao createTelefoneDao() {
		return new TelefoneDaoJDBC(DB.getConnection());
	}
}
