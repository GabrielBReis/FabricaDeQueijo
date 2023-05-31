package entidades;

import Enumeracao.TipoCliente;

public class ClienteJuridico extends Cliente {
	
	private Integer IdPessoaJuridica;
	private Integer CNPJ;
	private String RazaoSocial;

	
	public ClienteJuridico(Integer id, Integer numero, TipoCliente tipo, Integer endereco) {
		super(id, numero, tipo, endereco);
	}

	public ClienteJuridico(Integer idCliente, TipoCliente tipo, Integer telefone, Integer endereco, 
						   Integer idPessoaJuridica, String razaoSocial, Integer cnpj) {
		super(idCliente, telefone, tipo, endereco);
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

	public Integer getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(Integer cnpj) {
		CNPJ = cnpj;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
	
}
