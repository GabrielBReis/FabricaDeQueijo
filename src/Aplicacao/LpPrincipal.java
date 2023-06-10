package Aplicacao;

import java.util.Scanner;
import Enumeracao.TipoCliente;
import ImplementacaoDAO.ClienteDaoJDBC;
import ImplementacaoDAO.ClienteFisicoDaoJDBC;
import ImplementacaoDAO.DaoFactory;
import ImplementacaoDAO.EnderecoDaoJDBC;
import ImplementacaoDAO.TelefoneDAOJDBC;
import entidades.Cliente;
import entidades.ClienteFisico;
import entidades.ClienteJuridico;
import entidades.Endereco;
import entidades.Funcionario;
import entidades.Telefone;

public class LpPrincipal{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
		funcoes func = new funcoes();
		
		func.menuCadastroCliente();
		int opcao = scanner.nextInt();
		
		Cliente cliente = new Cliente();
		
		switch (opcao) {
		
			case 1:
				cliente.setTipo(TipoCliente.FISICA);
				
				ClienteFisico clienteFisico = new ClienteFisico();					
				clienteFisico.setTipo(TipoCliente.FISICA);
				
				System.out.println("Digite o CPF (apenas números):");
				String cpf = scanner.next();
				clienteFisico.setCPF(cpf);
				
				System.out.println("Nome: ");
				String nome = scanner.next();
				clienteFisico.setNome(nome);
				
				Telefone telefone = new Telefone();
				System.out.println("Digite o ddd: ");
				String ddd = scanner.next();
				telefone.setDDD(ddd);
				System.out.println("Digite o número: ");
				String numeroTelefone = scanner.next();
				telefone.setNumero(numeroTelefone);
				
				TelefoneDAOJDBC TelefoneDao = (TelefoneDAOJDBC) DaoFactory.createTelefoneDao();
                TelefoneDao.insert(telefone);
				
				Endereco endereco = new Endereco();
				System.out.println("Número do endereço: ");
				String numeroEndereco = scanner.next();
				endereco.setNumero(numeroEndereco);
				System.out.println("Logradouro: ");				
				String logradouro = scanner.next();
				endereco.setLogradouro(logradouro);
				
                EnderecoDaoJDBC EnderecoDao = (EnderecoDaoJDBC) DaoFactory.createEnderecoDao();
                EnderecoDao.insert(endereco);
                
                cliente.setTelefone(telefone.getID());
                cliente.setEndereco(endereco.getID());
                ClienteDaoJDBC ClienteDao = (ClienteDaoJDBC) DaoFactory.createClienteDao();
                ClienteDao.insert(cliente);
                
                clienteFisico.setTelefone(cliente.getTelefone());
                clienteFisico.setEndereco(cliente.getEndereco());
                ClienteFisicoDaoJDBC ClienteFisicoDao = (ClienteFisicoDaoJDBC) DaoFactory.createClienteFisicoDao();
                ClienteFisicoDao.insert(cliente, clienteFisico);
	
				System.out.println("Cliente cadastrado!");
				System.out.println("Nome: " + clienteFisico.getNome());
				System.out.println("CPF: " + clienteFisico.getCPF());
				System.out.println("Telefone: " + clienteFisico.getTelefone());
				System.out.println("Endereco: " + clienteFisico.getEndereco());
				
                break;
			
			case 2:
				Cliente clienteJuridico = new ClienteJuridico();
                break;
				
			case 3:
				Funcionario funcionario = new Funcionario();
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
		
		scanner.close();
	}
	
}
