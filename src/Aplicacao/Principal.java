//O projeto deve ter menus para cadastro das entidades, contemplando: Inclusão, Alteração, Exclusão,
//Consulta e Listagem dos elementos cadastrados
//O projeto precisa considerar a execução da lógica de negócio para solucionar o problema. 
//O projeto deve contemplar relatórios básicos relacionados a lógica do negócio.

package Aplicacao;
import java.sql.Connection;
import java.util.Scanner;

import db.DB;
import entidades.*;
import Enumeracao.*;

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Connection conexaoBanco = DB.getConnection();
			
		} finally {
			System.out.println("Conexão com banco de dados realizada com sucesso");
		}
		
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
