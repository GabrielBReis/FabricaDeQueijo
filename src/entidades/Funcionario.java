package entidades;


public class Funcionario {
	
	private Integer ID;
	private char[] CPF = new char[11];
	private char[] NIT = new char[11];
	private String Nome;
	private Integer Telefone;
	private Integer Endereco;
	//private String Setor;
	
	public Funcionario() {
		
	}

	public Funcionario(Integer id, String nome, Integer telefone, Integer endereco, char[] cpf, char[] nit) {
		this.setID(id);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEnderco(endereco);
		this.setCPF(cpf);
		this.setNIT(nit);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Integer getTelefone() {
		return Telefone;
	}

	public void setTelefone(Integer telefone) {
		Telefone = telefone;
	}

	public Integer getEndereco() {
		return Endereco;
	}

	public void setEnderco(Integer endereco) {
		Endereco = endereco;
	}

	public char[] getCPF() {
		return CPF;
	}

	public void setCPF(char[] cpf) {
		CPF = cpf;
	}

	public char[] getNIT() {
		return NIT;
	}

	public void setNIT(char[] nit) {
		NIT = nit;
	}
	
}
