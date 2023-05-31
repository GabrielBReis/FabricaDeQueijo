package entidades;

import Enumeracao.TipoCliente;

public class Cliente {
	
	private Integer ID;
	private Integer Telefone;
	private Integer Endereco;
	private TipoCliente Tipo;
	
	public Cliente(Integer iD, Integer Telefone, TipoCliente tipo, Integer endereco) {
		this.setID(iD);
		this.setTelefone(Telefone);
		this.setEndereco(endereco);
		this.setTipo(tipo);
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

	public Integer getEndereco() {
		return Endereco;
	}

	public void setEndereco(Integer endereco) {
		Endereco = endereco;
	}	

}
