package entidades;


public class Funcionario {
	
	private Integer ID;
	private String Nome;
	private Integer Telefone;
	private Integer Enderco;
	private Integer CPF;
	private Integer NIT;
	
	
	public Funcionario() {
	}

	public Funcionario(Integer iD, String nome, Integer telefone, Integer enderco, Integer cPF, Integer nIT) {
		this.setID(iD);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEnderco(enderco);
		this.setCPF(cPF);
		this.setNIT(nIT);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
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

	public Integer getEnderco() {
		return Enderco;
	}

	public void setEnderco(Integer enderco) {
		Enderco = enderco;
	}

	public Integer getCPF() {
		return CPF;
	}

	public void setCPF(Integer cPF) {
		CPF = cPF;
	}

	public Integer getNIT() {
		return NIT;
	}

	public void setNIT(Integer nIT) {
		NIT = nIT;
	}
	
	
	

}
