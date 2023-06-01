package entidades;

import Enumeracao.TipoCliente;

public class ClienteFisico extends Cliente {
	
	private Integer IdPessoaFisica;
	private char[] CPF = new char[11];
	private String Nome;
	

	public ClienteFisico(Integer id, Integer telefone, TipoCliente tipoCliente, Integer endereco) {
		super(id, telefone, tipoCliente, endereco);
	}
	
	public ClienteFisico(Integer id, Integer telefone, TipoCliente tipoCliente, Integer endereco, Integer idPessoaFisica, char[] cpf, String nome) {
		super(id, telefone, tipoCliente, endereco);
		this.setIdPessoaFisica(idPessoaFisica);
		this.setCPF(cpf);
		this.setNome(nome);
	}
	
	public Integer getIdPessoaFisica() {
		return IdPessoaFisica;
	}

	public void setIdPessoaFisica(Integer idPessoaFisica) {
		IdPessoaFisica = idPessoaFisica;
	}

	public char[] getCPF() {
		return CPF;
	}

	public void setCPF(char[] cpf) {
		CPF = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

}
