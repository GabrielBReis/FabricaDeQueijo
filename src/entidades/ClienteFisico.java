package entidades;

import Enumeracao.TipoCliente;

public class ClienteFisico extends Cliente {
	
	private Integer IdPessoaFisica;
	private Integer CPF;
	private String Nome;
	

	public ClienteFisico(Integer id, Integer telefone, TipoCliente tipo, Integer endereco) {
		super(id, telefone, tipo, endereco);
	}
	
	public ClienteFisico(Integer id, Integer telefone, TipoCliente tipo, Integer endereco, Integer idPessoaFisica, Integer cpf, String nome) {
		super(id, telefone, tipo, endereco);
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

	public Integer getCPF() {
		return CPF;
	}

	public void setCPF(Integer cpf) {
		CPF = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

}
