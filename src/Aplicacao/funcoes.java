package Aplicacao;
import java.util.Scanner;
import Enumeracao.TipoCliente;
import entidades.ClienteFisico;
import entidades.Endereco;
import entidades.Telefone;
public class funcoes {

    public void ApresentaMenu(){
        System.out.println("Selecione a opção desejada: ");
		System.out.println("1 - Realizar novo cadastro\n"
						 + "2 - Registrar venda\n"
						 + "3 - Registrar entrada de matéria prima\n"
						 + "4 - Registrar testagem de matéria prima\n"
						 + "5 - Registrar produção\n"
						 + "6 - Atualização de estoque\n"
						 + "7 - Sair");
    }


	public void CadastroCliente(){
		System.out.println("Selecione o tipo de cadastro desejado:\n" 
									+ "1 - Cliente a partir do CPF\n"
									+ "2 - Cliente a partir do CNPJ\n"
									+ "3 - Funcionário");
				
	}
    
	


    public ClienteFisico cadastrarClienteFisico() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Cadastro de Cliente Físico");
        
        // Solicitar informações do cliente
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        // Criar uma instância de ClienteFisico
        ClienteFisico cliente = new ClienteFisico();
        
        // Definir os valores do cliente
        cliente.setCPF(cpf);
        cliente.setNome(nome);
        
        // Chamar as funções de cadastro e atribuir os valores retornados
        Telefone telefone = cadastrarTelefone();
        cliente.setDDD(telefone.getDDD());
        cliente.setTelefone(telefone.getNumero());
        
        Endereco endereco = cadastrarEndereco();
        cliente.setNumeroEndereco(endereco.getNumero());
        cliente.setLogradouro(endereco.getLogradouro());
        
        scanner.close();
        
        // Retornar o objeto ClienteFisico preenchido
        return cliente;
    }
    
    public Telefone cadastrarTelefone() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Cadastro de Telefone");
        
        // Solicitar informações de telefone
        System.out.print("DDD: ");
        int ddd = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        
        scanner.close();
        
        // Criar uma instância de Telefone
        Telefone telefone = new Telefone(ddd, numero);
        
        // Retornar o objeto Telefone preenchido
        return telefone;
    }
    
    public Endereco cadastrarEndereco() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Cadastro de Endereço");
        
        // Solicitar informações de endereço
        System.out.print("Número do Endereço: ");
        int numeroEndereco = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        
        System.out.print("Logradouro: ");
        String logradouro = scanner.nextLine();
        
        scanner.close();
        
        // Criar uma instância de Endereco
        Endereco endereco = new Endereco(numeroEndereco, logradouro);
        
        // Retornar o objeto Endereco preenchido
        return endereco;
    }
}


