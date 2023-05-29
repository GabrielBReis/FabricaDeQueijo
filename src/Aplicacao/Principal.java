package Aplicacao;
import java.sql.Connection;

import db.DB;
public class Principal {

	public static void main(String[] args) {
		Connection conn = DB.getConnection(); 
		System.out.println("Conexão realizada");
		DB.closeConnection();
		System.out.println("Conexão fechada");

	}

}
