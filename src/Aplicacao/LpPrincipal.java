package Aplicacao;

import java.util.List;
import java.util.Scanner;
import ImplementacaoDAO.*;
import entidades.*;

public class LpPrincipal {
    public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		//Cria conexões com banco para as entidades
		TelefoneDAOJDBC telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
		EnderecoDaoJDBC enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
		ClienteFisicoDaoJDBC clienteFisicoDao = (ClienteFisicoDaoJDBC) DaoFactory.createClienteFisicoDao();
		
		ClienteFisico clienteFisico = null;//funcoes.preencherClienteFisico(scanner);
		Endereco endereco = null; //funcoes.preencherEndereco(scanner);
		Telefone telefone = null; //funcoes.preencherTelefone(scanner);
		
		int opcao, id;
		
		opcao = 0;
		
		while(opcao != 5) {
			scanner.nextLine();	
			funcoes.menuCliente();
			opcao = scanner.nextInt();
			
			switch (opcao) {
			
				case 1://Cadastro
					
					funcoes.menuCadastroCliente();
					opcao = scanner.nextInt();
					
					funcoes.SwitchCadastro(opcao, scanner);
					
					break;
					
				case 2: //Atualização de Dados
					//funcoes.menuUpdateCliente();
					opcao = 1;
					
					switch(opcao){
					
						case 1:
							funcoes.menuUpdateClienteFisico();
							opcao = scanner.nextInt();
							
							switch(opcao){
								case 1:
									System.out.println("Digite o ID do cliente: ");
									id = scanner.nextInt();
									clienteFisico = clienteFisicoDao.findById(id);								
									clienteFisico = funcoes.updateClienteFisico(scanner, clienteFisico);
									clienteFisicoDao.update(clienteFisico);
									break;
									
								case 2:
									System.out.println("Digite o Id do endereco: ");
									id = scanner.nextInt();
									endereco = enderecoDao.findById(id);
									endereco = funcoes.updateEndereco(scanner, endereco);
									enderecoDao.update(endereco);
									break;
									
								case 3:
									
									System.out.println("Digite o Id do telefone: ");
									id = scanner.nextInt();
									telefone = telefoneDao.findById(id);
									telefone = funcoes.updateTelefone(scanner, telefone);
									telefoneDao.update(telefone);
									break;
									
								default:
								 	System.out.println("Inválido!");
									break;
							}
							
							break;
							
						default:
							break;
					}
					
					break;
					
				case 3://Deletar Dados
					
					funcoes.menuDeleteClienteFisico();
					opcao = scanner.nextInt();
					
						switch(opcao){
							case 1:	
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								clienteFisicoDao.deleteById(id);
								break;
								
							case 2:
								System.out.println("Digite o Id do endereco: ");
								id = scanner.nextInt();
								enderecoDao.deleteById(clienteFisicoDao.findById(id).getEndereco());
								break;
								
							case 3:
								System.out.println("Digite o Id do telefone: ");
								id = scanner.nextInt();
								telefoneDao.deleteById(clienteFisicoDao.findById(id).getTelefone());
								break;
								
							default:
							 	System.out.println("Invalido!");
								break;
							}
					break;
					
				case 4://Imprimir base de Dados
					funcoes.menuSelect();
					opcao = scanner.nextInt();
					
						switch(opcao){
							case 1:
								 List<ClienteFisico> clientesFisicos = clienteFisicoDao.findAll();
								for (ClienteFisico clienteFisico2 : clientesFisicos) {
									System.out.println(clienteFisico2);
									System.out.println("------------------------------");
								}
								break;
								
							case 2:
								 List<Endereco> enderecos = enderecoDao.findAll();
								for (Endereco endereco2 : enderecos) {
									System.out.println(endereco2);
									System.out.println("------------------------------");
								}
								break;
								
							case 3:
								List<Telefone> telefones = telefoneDao.findAll();
								for (Telefone telefone2 : telefones) {
									System.out.println(telefone2);
									System.out.println("------------------------------");
								}
								break;
															
							default:
							 	System.out.println("Invalido!");
								break;
							}
					break;
					
				default:
					break;
			}
		
		}
		
        scanner.close();
    }
}
