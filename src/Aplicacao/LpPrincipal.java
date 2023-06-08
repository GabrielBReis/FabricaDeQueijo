package Aplicacao;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import db.DB;
import entidades.*;
import Enumeracao.*;
import ImplementacaoDAO.ClienteDaoJDBC;
import Aplicacao.funcoes;

public class LpPrincipal{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		Connection conexaoBanco = null;		
		ResultSet resultSet = null;
		Statement statement = null;
		funcoes func = new funcoes();
		
		func.ApresentaMenu();
		
		int opcao = scanner.nextInt();

		switch (opcao) {
		
			case 1:
				func.CadastroCliente();
				int opcaoCadastro = scanner.nextInt();
				
				if(opcaoCadastro == 1) {
					ClienteFisico cliente = new ClienteFisico();					
					cliente.setTipo(TipoCliente.FISICA);
					
					System.out.println("Digite o CPF (apenas números):");
					String cpf = scanner.next();
					cliente.setCPF(cpf);
					
					System.out.println("Nome:");
					String nome = scanner.next();
					cliente.setNome(nome);
					
					Telefone telefone = new Telefone();
					System.out.println("Digite o ddd: ");
					String ddd = scanner.next();
					telefone.setDDD(ddd);
					System.out.println("Digite o telefone: ");
					String numeroTelefone = scanner.next();
					telefone.setNumero(numeroTelefone);
					
					Endereco endereco = new Endereco();
					System.out.println("Número do endereço:");
					String numeroEndereco = scanner.next();
					endereco.setNumero(numeroEndereco);
					System.out.println("Logradouro: ");
					
					String logradouro = scanner.next();
					endereco.setLogradouro(logradouro);

                    ClienteDaoJDBC clienteJdbc = new ClienteDaoJDBC(conexaoBanco);
					
					
					System.out.println("Cliente cadastrado!");
					System.out.println("Nome: " + cliente.getNome());
					System.out.println("CPF: " + cliente.getCPF());
					System.out.println("Telefone: " + cliente.getTelefone());
					System.out.println("Endereco: " + cliente.getEndereco());
					
					
				} else if (opcaoCadastro == 2) {
					Cliente cliente = new ClienteJuridico();
					
				} else if (opcaoCadastro == 3) {
					Funcionario funcionario = new Funcionario();
					
				} else {
					System.out.println("Opção inválida");
					System.out.println("Selecione o tipo de cadastro desejado:\n" 
							+ "1 - Cliente a partir do CPF\n"
							+ "2 - Cliente a partir do CNPJ\n"
							+ "3 - Funcionário");
					opcaoCadastro = scanner.nextInt();					
				}
			
			case 2:
				Venda venda = new Venda();
				
			case 3:
				LoteMateriaPrima loteMateriaPrima = new LoteMateriaPrima();
				
			case 4:
				Resultado resultado = new Resultado();
			
			case 5:
				Producao producao = new Producao();
			
			case 6:
				Estoque estoque = new Estoque();
			
			case 7:
				break;
			
			default:
				break;
		}
	}
	
}
