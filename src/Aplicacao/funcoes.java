package Aplicacao;

import java.util.Scanner;

import Enumeracao.TipoCliente;
import entidades.ClienteFisico;
import entidades.ClienteJuridico;
import entidades.Endereco;
import entidades.Telefone;

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

	static void menu(){
		System.out.println("Selecione a operação desejada:\n" 
									+ "1 - Cadastro\n"
									+ "2 - Atualização de Dados\n"
									+ "3 - Deletar Dados\n"
									+ "4 - Imprimir base de Dados\n");
	}


	static void menuCadastroCliente(){
		System.out.println("Selecione o tipo de cadastro desejado:\n" 
									+ "1 - Cliente a partir do CPF\n"
									+ "2 - Cliente a partir do CNPJ\n"
									+ "3 - Funcionário");
				
	}

	static void menuUpdateCliente(){
		System.out.println("Selecione o tipo que deseja atualizar desejado:\n" 
									+ "1 - Cliente a partir do CPF\n"
									+ "2 - Cliente a partir do CNPJ\n"
									+ "3 - Funcionário");
				
	}

	static void menuUpdateClienteFisico(){
		System.out.println("Selecione o tipo que deseja atualizar desejado:\n" 
									+ "1 - Nome ou CPF\n"
									+ "2 - Endereço\n"
									+ "3 - telefone");
				
	}

	static void menuDeleteClienteFisico(){
		System.out.println("Selecione o tipo que deseja atualizar desejado:\n" 
									+ "1 - Nome ou CPF\n"
									+ "2 - Endereço\n"
									+ "3 - telefone");
				
	}

	static ClienteFisico preencherClienteFisico(Scanner scanner) {
        ClienteFisico clienteFisico = new ClienteFisico();
        clienteFisico.setTipo(TipoCliente.FISICA);

        System.out.println("Digite o CPF (apenas números):");
        String cpf = scanner.next();
        clienteFisico.setCPF(cpf);

        System.out.println("Nome: ");
        String nome = scanner.next();
        clienteFisico.setNome(nome);

        // Outros campos e atribuições específicas do Cliente Físico...

        return clienteFisico;
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

        System.out.println("Digite o número: ");
        String numeroTelefone = scanner.next();
        telefone.setNumero(numeroTelefone);

        return telefone;
    }

    static Endereco preencherEndereco(Scanner scanner) {
        Endereco endereco = new Endereco();

        System.out.println("Número do endereço: ");
        String numeroEndereco = scanner.next();
        endereco.setNumero(numeroEndereco);

        System.out.println("Logradouro: ");
        String logradouro = scanner.next();
        endereco.setLogradouro(logradouro);

        return endereco;
    }
    
}
