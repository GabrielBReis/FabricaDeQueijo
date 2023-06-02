package entidades;

import Enumeracao.TipoCliente;

public class ClienteJuridico extends Cliente {
	
	private Integer IdPessoaJuridica;
	private String CNPJ;
	private String RazaoSocial;

	public ClienteJuridico() {
		
	}
	
	public ClienteJuridico(Integer id, Integer numero, TipoCliente tipoCliente, Integer endereco) {
		super(id, numero, tipoCliente, endereco);
	}

	public ClienteJuridico(Integer idCliente, TipoCliente tipoCliente, Integer telefone, Integer endereco, 
						   Integer idPessoaJuridica, String razaoSocial, String cnpj) {
		
		super(idCliente, telefone, tipoCliente, endereco);
		this.setIdPessoaJuridica(idPessoaJuridica);
		this.setRazaoSocial(razaoSocial);
		this.setCNPJ(cnpj);
	}
	
	public Integer getIdPessoaJuridica() {
		return IdPessoaJuridica;
	}

	public void setIdPessoaJuridica(Integer idPessoaJuridica) {
		IdPessoaJuridica = idPessoaJuridica;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cnpj) {
		CNPJ = cnpj;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
	
}
