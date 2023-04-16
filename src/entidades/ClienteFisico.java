package entidades;

import Enumeracao.TipoCliente;

public class ClienteFisico extends Cliente {
	
	private Integer CPF;
	
	public ClienteFisico(Integer iD, String nome, Integer numero, TipoCliente tipo, Integer enderco, Integer cPF) {
		super(iD, nome, numero, tipo, enderco);
		this.setCPF(cPF);
	}


	public ClienteFisico(Integer iD, String nome, Integer numero, TipoCliente tipo, Integer enderco) {
		super(iD, nome, numero, tipo, enderco);
		// TODO Auto-generated constructor stub
	}


	public Integer getCPF() {
		return CPF;
	}


	public void setCPF(Integer cPF) {
		CPF = cPF;
	}

}
