//O projeto deve ter menus para cadastro das entidades, contemplando: Inclusão, Alteração, Exclusão,
//Consulta e Listagem dos elementos cadastrados
//O projeto precisa considerar a execução da lógica de negócio para solucionar o problema. 
//O projeto deve contemplar relatórios básicos relacionados a lógica do negócio.

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

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection conexaoBanco = null;		
		ResultSet resultSet = null;
		Statement statement = null;
		
		System.out.println("Selecione a opção desejada: ");
		System.out.println("1 - Realizar novo cadastro\n"
						 + "2 - Registrar venda\n"
						 + "3 - Registrar entrada de matéria prima\n"
						 + "4 - Registrar testagem de matéria prima\n"
						 + "5 - Registrar produção\n"
						 + "6 - Atualização de estoque\n"
						 + "7 - Sair");
		
		int opcao = scanner.nextInt();

		switch (opcao) {
		
			case 1:
				System.out.println("Selecione o tipo de cadastro desejado:\n" 
									+ "1 - Cliente a partir do CPF\n"
									+ "2 - Cliente a partir do CNPJ\n"
									+ "3 - Funcionário");
				
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
					
					try {
						conexaoBanco = DB.getConnection();
						
						PreparedStatement inserirTelefone = conexaoBanco.prepareStatement("insert into telefones (ddd, numero) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
						PreparedStatement inserirEndereco = conexaoBanco.prepareStatement("insert into enderecos (numero, logradouro) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
						
						inserirTelefone.setString(1, telefone.getDDD());
						inserirTelefone.setString(2, telefone.getNumero());
						int telefonesAcrescentados = inserirTelefone.executeUpdate();
						
						if (telefonesAcrescentados > 0) {
							ResultSet chavesGeradasTelefone = inserirTelefone.getGeneratedKeys();   
							while (chavesGeradasTelefone.next()) {
								int idTelefone = chavesGeradasTelefone.getInt(1);
								cliente.setTelefone(idTelefone);
							}
						}
						
						else {
							System.out.println("Nenhum telefone acrescentado!");
						}	
						
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
						}	
						
						PreparedStatement inserirCliente = conexaoBanco.prepareStatement("insert into clientes (id_tel, id_end) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
						inserirCliente.setInt(1, cliente.getNumero());
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
						
						PreparedStatement inserirClienteFisico = conexaoBanco.prepareStatement("insert into pessoa_fisica (nome, cpf, id_cliente) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
						inserirClienteFisico.setString(1, cliente.getNome());
						inserirClienteFisico.setString(2, cliente.getCPF());
						inserirClienteFisico.setInt(3, cliente.getID());
						int clientesFiscosAcrescentados = inserirClienteFisico.executeUpdate();
						
					} catch (SQLException e) {
						e.printStackTrace();
						
					} finally {
						DB.closeResultSet(resultSet);
						DB.closeStatement(statement);
						DB.closeConnection();
					}
					
					System.out.println("Cliente cadastrado!");
					System.out.println("Nome: " + cliente.getNome());
					System.out.println("CPF: " + cliente.getCPF());
					System.out.println("Telefone: " + cliente.getNumero());
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
