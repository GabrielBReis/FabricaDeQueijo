package Aplicacao;

import java.util.Scanner;

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

	public Telefone cadastroTelefone(){
		Scanner scanner = new Scanner(System.in);
		Telefone telefone = new Telefone();
		System.out.println("Digite o ddd: ");
		String ddd = scanner.next();
		telefone.setDDD(ddd);
		System.out.println("Digite o telefone: ");
		String numeroTelefone = scanner.next();
		telefone.setNumero(numeroTelefone);
		return telefone;
	}
    
}
