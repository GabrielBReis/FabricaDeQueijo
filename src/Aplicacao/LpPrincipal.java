package Aplicacao;

import java.util.List;
import java.util.Scanner;
import Enumeracao.TipoCliente;
import ImplementacaoDAO.*;
import entidades.*;

public class LpPrincipal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
		Cliente cliente = new Cliente();
		int opcao,id;
		funcoes.menu();
		opcao = scanner.nextInt();
		switch (opcao) {
			case 1://Cadastro
				funcoes.menuCadastroCliente();
				opcao = scanner.nextInt();
				switch (opcao) {
					case 1:
						cliente.setTipo(TipoCliente.FISICA);
						ClienteFisico clienteFisico = funcoes.preencherClienteFisico(scanner);
						Telefone telefone = funcoes.preencherTelefone(scanner);
						TelefoneDAOJDBC telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
						telefoneDao.insert(telefone);
						Endereco endereco = funcoes.preencherEndereco(scanner);
						EnderecoDaoJDBC enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
						enderecoDao.insert(endereco);
						cliente.setTelefone(telefone.getID());
						cliente.setEndereco(endereco.getID());
						ClienteDaoJDBC clienteDao = (ClienteDaoJDBC) DaoFactory.createClienteDao();
						clienteDao.insert(cliente);
						clienteFisico.setTelefone(cliente.getTelefone());
						clienteFisico.setEndereco(cliente.getEndereco());
						ClienteFisicoDaoJDBC clienteFisicoDao = (ClienteFisicoDaoJDBC) DaoFactory.createClienteFisicoDao();
						clienteFisicoDao.insert(cliente, clienteFisico);
						System.out.println("Cliente cadastrado!");
						System.out.println("Nome: " + clienteFisico.getNome());
						System.out.println("CPF: " + clienteFisico.getCPF());
						System.out.println("Telefone: " + clienteFisico.getTelefone());
						System.out.println("Endereco: " + clienteFisico.getEndereco());
						break;
					case 2:
						cliente.setTipo(TipoCliente.JURIDICA);
						ClienteJuridico clienteJuridico = funcoes.preencherClienteJuridico(scanner);
						telefone = funcoes.preencherTelefone(scanner);
						telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
						telefoneDao.insert(telefone);
						endereco = funcoes.preencherEndereco(scanner);
						enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
						enderecoDao.insert(endereco);
						cliente.setTelefone(telefone.getID());
						cliente.setEndereco(endereco.getID());
						clienteDao = (ClienteDaoJDBC) DaoFactory.createClienteDao();
						clienteDao.insert(cliente);
						clienteJuridico.setTelefone(cliente.getTelefone());
						clienteJuridico.setEndereco(cliente.getEndereco());
						ClienteJuridicoDaoJDBC clienteJuridicoDao = (ClienteJuridicoDaoJDBC) DaoFactory.createClienteJuridicoDao();
						clienteJuridicoDao.insert(cliente, clienteJuridico);
						System.out.println("Cliente cadastrado!");
						System.out.println("Razão Social: " + clienteJuridico.getRazaoSocial());
						System.out.println("CNPJ: " + clienteJuridico.getCNPJ());
						System.out.println("Telefone: " + clienteJuridico.getTelefone());
						System.out.println("Endereco: " + clienteJuridico.getEndereco());
						break;

					case 3:
						break;

					default:
						System.out.println("Opção inválida");
						System.out.println("Selecione o tipo de cadastro desejado:\n"
								+ "1 - Cliente a partir do CPF\n"
								+ "2 - Cliente a partir do CNPJ\n"
								+ "3 - Funcionário");
						opcao = scanner.nextInt();
						break;
				}
				break;
			case 2: //Atualização de Dados
				funcoes.menuUpdateCliente();
				opcao = scanner.nextInt();
				switch(opcao){
					case 1:
						funcoes.menuUpdateClienteFisico();
						opcao = scanner.nextInt();
						switch(opcao){
							case 1:
								ClienteFisico clienteFisico = funcoes.preencherClienteFisico(scanner);
								ClienteFisicoDaoJDBC clienteFisicoDao = (ClienteFisicoDaoJDBC) DaoFactory.createClienteFisicoDao();
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								clienteFisicoDao.findById(id);
								clienteFisicoDao.update(clienteFisico);
								break;
							case 2:
								Endereco endereco = funcoes.preencherEndereco(scanner);
								EnderecoDaoJDBC enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								enderecoDao.findById(id);
								enderecoDao.update(endereco);
								break;
							case 3:
								Telefone telefone = funcoes.preencherTelefone(scanner);
								TelefoneDAOJDBC telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								telefoneDao.findById(id);
								telefoneDao.update(telefone);
								break;
							default:
							 	System.out.println("Invalido!");
								break;
						}
						break;
					// case 2:
					// 	break;
					// case 3:
					// 	break;
					default:
						break;
				}
				break;
			case 3://Deletar Dados
				funcoes.menuDeleteClienteFisico();
						opcao = scanner.nextInt();
						switch(opcao){
							case 1:
								ClienteFisicoDaoJDBC clienteFisicoDao = (ClienteFisicoDaoJDBC) DaoFactory.createClienteFisicoDao();
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								clienteFisicoDao.deleteById(id);
								break;
							case 2:
								EnderecoDaoJDBC enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								enderecoDao.deleteById(id);
								break;
							case 3:
								TelefoneDAOJDBC telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								telefoneDao.deleteById(id);
								break;
							default:
							 	System.out.println("Invalido!");
								break;
						}
				break;
			case 4://Imprimir base de Dados
				opcao = scanner.nextInt();
						switch(opcao){
							case 1:
								ClienteFisicoDaoJDBC clienteFisicoDao = (ClienteFisicoDaoJDBC) DaoFactory.createClienteFisicoDao();
								 List<ClienteFisico> clientesFisicos = clienteFisicoDao.findAll();
								 for (ClienteFisico clienteFisico : clientesFisicos) {
									System.out.println(clienteFisico);
								 }
								break;
							case 2:
								EnderecoDaoJDBC enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
								 List<Endereco> enderecos = enderecoDao.findAll();
								 for (Endereco endereco : enderecos) {
									System.out.println(endereco);
								 }
								break;
							case 3:
								TelefoneDAOJDBC telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
								List<Telefone> telefones = telefoneDao.findAll();
								for (Telefone telefone : telefones) {
									System.out.println(telefone);
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
        scanner.close();
    }
}
