package entidades;

import Enumeracao.TipoCliente;

public class Cliente {
	
	private Integer ID;
	private String Nome;
	private Integer Telefone;
	private TipoCliente Tipo;
	private Integer Enderco;
	
	public Cliente(Integer iD, String nome, Integer Telefone, TipoCliente tipo, Integer enderco) {
		this.setID(iD);
		this.setNome(nome);
		this.setTelefone(Telefone);
		this.setTipo(tipo);
		this.setEnderco(enderco);
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getNumero() {
		return Telefone;
	}

	public void setTelefone(Integer telefone) {
		Telefone = telefone;
	}

	public TipoCliente getTipo() {
		return Tipo;
	}

	public void setTipo(TipoCliente tipo) {
		Tipo = tipo;
	}

	public Integer getEnderco() {
		return Enderco;
	}

	public void setEnderco(Integer enderco) {
		Enderco = enderco;
	}
	
	
	

}
