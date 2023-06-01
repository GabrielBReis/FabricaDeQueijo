package entidades;

import Enumeracao.TipoCliente;

public class ClienteJuridico extends Cliente {
	
	private Integer IdPessoaJuridica;
	private char[] CNPJ = new char[11];
	private String RazaoSocial;

	
	public ClienteJuridico(Integer id, Integer numero, TipoCliente tipoCliente, Integer endereco) {
		super(id, numero, tipoCliente, endereco);
	}

	public ClienteJuridico(Integer idCliente, TipoCliente tipoCliente, Integer telefone, Integer endereco, 
						   Integer idPessoaJuridica, String razaoSocial, char[] cnpj) {
		
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

	public char[] getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(char[] cnpj) {
		CNPJ = cnpj;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
	
}
