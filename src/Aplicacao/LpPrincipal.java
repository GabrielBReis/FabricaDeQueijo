package Aplicacao;

import java.util.List;
import java.util.Scanner;
import ImplementacaoDAO.*;
import entidades.*;

public class LpPrincipal {
    public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		TelefoneDAOJDBC telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
		EnderecoDaoJDBC enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
		ClienteFisicoDaoJDBC clienteFisicoDao = (ClienteFisicoDaoJDBC) DaoFactory.createClienteFisicoDao();
		ClienteFisico clienteFisico = funcoes.preencherClienteFisico(scanner);
		Endereco endereco = funcoes.preencherEndereco(scanner);
		Telefone telefone = funcoes.preencherTelefone(scanner);
		int opcao,id;
		funcoes.menu();
		opcao = scanner.nextInt();
		switch (opcao) {
			case 1://Cadastro
				funcoes.menuCadastroCliente();
				opcao = scanner.nextInt();
				funcoes.SwitchCadastro(opcao, scanner);
				// switch (opcao) {
				// 	case 1: // Cliente Fisico
				// 		funcoes.CadastroClienteFisico(scanner);
				// 		Cliente cliente = new Cliente();
				// 		cliente.setTipo(TipoCliente.FISICA);
				// 		ClienteFisico clienteFisico = funcoes.preencherClienteFisico(scanner);
				// 		Telefone telefone = funcoes.preencherTelefone(scanner);
				// 		TelefoneDAOJDBC telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
				// 		telefoneDao.insert(telefone);
				// 		Endereco endereco = funcoes.preencherEndereco(scanner);
				// 		EnderecoDaoJDBC enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
				// 		enderecoDao.insert(endereco);
				// 		cliente.setTelefone(telefone.getID());
				// 		cliente.setEndereco(endereco.getID());
				// 		ClienteDaoJDBC clienteDao = (ClienteDaoJDBC) DaoFactory.createClienteDao();
				// 		clienteDao.insert(cliente);
				// 		clienteFisico.setTelefone(cliente.getTelefone());
				// 		clienteFisico.setEndereco(cliente.getEndereco());
				// 		ClienteFisicoDaoJDBC clienteFisicoDao = (ClienteFisicoDaoJDBC) DaoFactory.createClienteFisicoDao();
				// 		clienteFisicoDao.insert(cliente, clienteFisico);
				// 		System.out.println("Cliente cadastrado!");
				// 		System.out.println("Nome: " + clienteFisico.getNome());
				// 		System.out.println("CPF: " + clienteFisico.getCPF());
				// 		System.out.println("Telefone: " + clienteFisico.getTelefone());
				// 		System.out.println("Endereco: " + clienteFisico.getEndereco());
				// 		break;
				// 	case 2: // Cliente Juridico
				// 		funcoes.CadastroClienteJuridico(scanner);
				// 		Cliente cliente = new Cliente();
				// 		cliente.setTipo(TipoCliente.JURIDICA);
				// 		ClienteJuridico clienteJuridico = funcoes.preencherClienteJuridico(scanner);
				// 		Telefone telefone = funcoes.preencherTelefone(scanner);
				// 		TelefoneDAOJDBC telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
				// 		telefoneDao.insert(telefone);
				// 		Endereco endereco = funcoes.preencherEndereco(scanner);
				// 		EnderecoDaoJDBC enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
				// 		enderecoDao.insert(endereco);
				// 		cliente.setTelefone(telefone.getID());
				// 		cliente.setEndereco(endereco.getID());
				// 		ClienteDaoJDBC clienteDao = (ClienteDaoJDBC) DaoFactory.createClienteDao();
				// 		clienteDao.insert(cliente);
				// 		clienteJuridico.setTelefone(cliente.getTelefone());
				// 		clienteJuridico.setEndereco(cliente.getEndereco());
				// 		ClienteJuridicoDaoJDBC clienteJuridicoDao = (ClienteJuridicoDaoJDBC) DaoFactory.createClienteJuridicoDao();
				// 		clienteJuridicoDao.insert(cliente, clienteJuridico);
				// 		System.out.println("Cliente cadastrado!");
				// 		System.out.println("Razão Social: " + clienteJuridico.getRazaoSocial());
				// 		System.out.println("CNPJ: " + clienteJuridico.getCNPJ());
				// 		System.out.println("Telefone: " + clienteJuridico.getTelefone());
				// 		System.out.println("Endereco: " + clienteJuridico.getEndereco());
				// 		break;

				// 	case 3: // Funcionario
				// 		break;

				// 	default:
				// 		System.out.println("Opção inválida");
				// 		funcoes.menuCadastroCliente();
				// 		opcao = scanner.nextInt();
				// 		break;
				// }
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
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								clienteFisico = funcoes.preencherClienteFisico(scanner);
								// ClienteFisico clienteFisico = funcoes.preencherClienteFisico(scanner);
								// ClienteFisicoDaoJDBC clienteFisicoDao = (ClienteFisicoDaoJDBC) DaoFactory.createClienteFisicoDao();
								clienteFisicoDao.findById(id);
								clienteFisicoDao.update(clienteFisico);
								break;
							case 2:
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								endereco = funcoes.preencherEndereco(scanner);
								//Endereco endereco = funcoes.preencherEndereco(scanner);
								// EnderecoDaoJDBC enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
								enderecoDao.findById(id);
								enderecoDao.update(endereco);
								break;
							case 3:
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								telefone = funcoes.preencherTelefone(scanner);
								//Telefone telefone = funcoes.preencherTelefone(scanner);
								// TelefoneDAOJDBC telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
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
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								//clienteFisicoDao.findById(id).getTelefone().
								telefoneDao.deleteById(clienteFisicoDao.findById(id).getTelefone());
								enderecoDao.deleteById(clienteFisicoDao.findById(id).getEndereco());
								clienteFisicoDao.deleteById(id);
								break;
							case 2:
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								enderecoDao.deleteById(clienteFisicoDao.findById(id).getEndereco());
								break;
							case 3:
								System.out.println("Digite o Id do cliente: ");
								id = scanner.nextInt();
								telefoneDao.deleteById(clienteFisicoDao.findById(id).getTelefone());
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
								// ClienteFisicoDaoJDBC clienteFisicoDao = (ClienteFisicoDaoJDBC) DaoFactory.createClienteFisicoDao();
								 List<ClienteFisico> clientesFisicos = clienteFisicoDao.findAll();
								for (ClienteFisico clienteFisico2 : clientesFisicos) {
									System.out.println(clienteFisico2);
								}
								break;
							case 2:
								// EnderecoDaoJDBC enderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
								 List<Endereco> enderecos = enderecoDao.findAll();
								for (Endereco endereco2 : enderecos) {
									System.out.println(endereco2);
								}
								break;
							case 3:
								// TelefoneDAOJDBC telefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
								List<Telefone> telefones = telefoneDao.findAll();
								for (Telefone telefone2 : telefones) {
									System.out.println(telefone2);
								}
								break;
							case 4:
								clientesFisicos = clienteFisicoDao.findAll();
								 for (ClienteFisico clienteFisico2 : clientesFisicos) {
									System.out.println(clienteFisico2);
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
