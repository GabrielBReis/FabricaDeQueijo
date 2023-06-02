package entidades;

public class Funcionario {
	
	private Integer ID;
	private String CPF;
	private String NIT;
	private String Nome;
	private Integer Telefone;
	private Integer Endereco;
	
	public Funcionario() {
		
	}

	public Funcionario(Integer id, String nome, Integer telefone, Integer endereco, String cpf, String nit) {
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		CPF = cpf;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nit) {
		NIT = nit;
	}
	
}
