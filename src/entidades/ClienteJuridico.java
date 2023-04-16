package entidades;

import Enumeracao.TipoCliente;

public class ClienteJuridico extends Cliente {
	
	private String RazaoSocial;
	private Integer CNPJ;
	
	public ClienteJuridico(Integer iD, String nome, Integer numero, TipoCliente tipo, Integer enderco) {
		super(iD, nome, numero, tipo, enderco);
		// TODO Auto-generated constructor stub
	}

	public ClienteJuridico(Integer iD, String nome, Integer numero, TipoCliente tipo, Integer enderco,
			String razaoSocial, Integer cNPJ) {
		super(iD, nome, numero, tipo, enderco);
		this.setRazaoSocial(razaoSocial);
		this.setCNPJ(cNPJ);
	}

	public Integer getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(Integer cNPJ) {
		CNPJ = cNPJ;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
	
}
