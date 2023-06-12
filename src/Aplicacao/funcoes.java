package Aplicacao;

import java.util.Scanner;
import Enumeracao.*;
import ImplementacaoDAO.*;
import entidades.*;

public class funcoes {

    static void ApresentaMenuPrincipal(){
        System.out.println("Selecione a opção desejada: ");
		System.out.println("1 - Realizar novo cadastro\n"
						 + "2 - Registrar venda\n"
						 + "3 - Registrar entrada de matéria prima\n"
						 + "4 - Registrar testagem de matéria prima\n"
						 + "5 - Registrar produção\n"
						 + "6 - Atualização de estoque\n"
						 + "7 - Sair");
    }

	static void menuCliente(){
		System.out.println("Selecione a operação desejada:\n" 
									+ "1 - Cadastro\n"
									+ "2 - Atualização de Dados\n"
									+ "3 - Deletar Dados\n"
									+ "4 - Imprimir base de Dados\n"
									+ "5- Sair");
	}

	static void menuCadastroCliente(){
		System.out.println("Selecione o tipo de cadastro desejado:\n" 
									+ "1 - Cliente a partir do CPF");
				
	}

	static void menuUpdateCliente(){
		System.out.println("Selecione o tipo de cadastro que deseja atualizar:\n" 
									+ "1 - Cliente a partir do CPF\n"
									+ "2 - Cliente a partir do CNPJ\n"
									+ "3 - Telefone");
				
	}

	static void menuUpdateClienteFisico(){
		System.out.println("Selecione o dado que deseja atualizar:\n" 
									+ "1 - Nome ou CPF\n"
									+ "2 - Endereço\n"
									+ "3 - Telefone");
				
	}

	static void menuDeleteClienteFisico(){
		System.out.println("Selecione o tipo de cadastro que deseja excluir:\n" 
									+ "1 - Nome ou CPF\n"
									+ "2 - Endereço\n"
									+ "3 - Telefone");
				
	}
	
	static void menuSelect(){
		System.out.println("Selecione a classe que deseja consultar:\n" 
									+ "1 - Clientes CPF\n"
									+ "2 - Endereços\n"
									+ "3 - Telefones");
				
	}

	static ClienteFisico preencherClienteFisico(Scanner scanner) {
        ClienteFisico clienteFisico = new ClienteFisico();
        clienteFisico.setTipo(TipoCliente.FISICA);

        System.out.println("Digite o CPF (apenas números):");
        String cpf = scanner.next();
        clienteFisico.setCPF(cpf);

        scanner.nextLine();
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        clienteFisico.setNome(nome);

        return clienteFisico;
    }
	
	static ClienteFisico updateClienteFisico(Scanner scanner, ClienteFisico clienteFisico) {
        System.out.println("Digite o CPF (apenas números):");
        String cpf = scanner.next();
        clienteFisico.setCPF(cpf);

        System.out.println("Nome: ");
        String nome = scanner.next();
        clienteFisico.setNome(nome);

        return clienteFisico;
    }
	
	static Endereco updateEndereco(Scanner scanner, Endereco endereco) {
		scanner.nextLine();
		System.out.println("Número:");
        String numero = scanner.nextLine();
        endereco.setNumero(numero);

        System.out.println("Logradouro: ");
        String logradouro = scanner.nextLine();
        endereco.setLogradouro(logradouro);

        return endereco;
    }
	
	static Telefone updateTelefone(Scanner scanner, Telefone telefone) {
        System.out.println("DDD: ");
        String ddd = scanner.next();
        telefone.setDDD(ddd);

        System.out.println("Número do telefone: ");
        String numero = scanner.next();
        telefone.setNumero(numero);

        return telefone;
    }

	static ClienteJuridico preencherClienteJuridico(Scanner scanner) {
        ClienteJuridico clienteJuridico = new ClienteJuridico();
        clienteJuridico.setTipo(TipoCliente.JURIDICA);

        System.out.println("Digite o CNPJ (apenas números):");
        String cnpj = scanner.next();
        clienteJuridico.setCNPJ(cnpj);

        System.out.println("Razão Social: ");
        String razaoSocial = scanner.next();
        clienteJuridico.setRazaoSocial(razaoSocial);

        // Outros campos e atribuições específicas do Cliente Jurídico...

        return clienteJuridico;
    }

    static Telefone preencherTelefone(Scanner scanner) {
        Telefone telefone = new Telefone();

        System.out.println("Digite o DDD: ");
        String ddd = scanner.next();
        telefone.setDDD(ddd);

        System.out.println("Digite o número do telefone: ");
        String numeroTelefone = scanner.next();
        telefone.setNumero(numeroTelefone);

        return telefone;
    }

    static Endereco preencherEndereco(Scanner scanner) {
        Endereco endereco = new Endereco();

        System.out.println("Número do endereço: ");
        String numeroEndereco = scanner.next();
        endereco.setNumero(numeroEndereco);

        scanner.nextLine();
        System.out.println("Logradouro: ");
        String logradouro = scanner.nextLine();
        endereco.setLogradouro(logradouro);

        return endereco;
    }

    static void CadastroClienteFisico(Scanner scanner){
        Cliente cliente = new Cliente();
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
        System.out.println("Telefone: " + telefone.getDDD() + " " + telefone.getNumero());
        System.out.println("Endereco: " + endereco.getLogradouro() + ", nº" + endereco.getNumero());
    }

    static void CadastroClienteJuridico(Scanner scanner){
        Cliente cliente = new Cliente();
        cliente.setTipo(TipoCliente.JURIDICA);
        
        ClienteJuridico clienteJuridico = funcoes.preencherClienteJuridico(scanner);
        
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
        
        clienteJuridico.setTelefone(cliente.getTelefone());
        clienteJuridico.setEndereco(cliente.getEndereco());
        
        ClienteJuridicoDaoJDBC clienteJuridicoDao = (ClienteJuridicoDaoJDBC) DaoFactory.createClienteJuridicoDao();
        clienteJuridicoDao.insert(cliente, clienteJuridico);
        
        System.out.println("Cliente cadastrado!");
        System.out.println("Razão Social: " + clienteJuridico.getRazaoSocial());
        System.out.println("CNPJ: " + clienteJuridico.getCNPJ());
        System.out.println("Telefone: " + telefone.getDDD() + " " + telefone.getNumero());
        System.out.println("Endereco: " + endereco.getLogradouro() + ", nº" + endereco.getNumero());
    }
    
    public static void SwitchCadastro(int opcao, Scanner scanner) {
        switch (opcao) {
			case 1: // Cliente Fisico
				CadastroClienteFisico(scanner);
				break;
				
			case 2: // Cliente Juridico
				CadastroClienteJuridico(scanner);
				break;
	
			default:
				System.out.println("Opção inválida");
				funcoes.menuCadastroCliente();
				opcao = scanner.nextInt();
				break;
		}
    }
    
}
