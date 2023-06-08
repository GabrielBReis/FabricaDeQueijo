package entidades;

import Enumeracao.TipoCliente;

public class Cliente {
	
	private Integer ID;
	private Integer Telefone;
	private Integer Endereco;
	private TipoCliente TipoCliente;
	
	public Cliente() {
		
	}
	
	public Cliente(Integer id, Integer telefone, TipoCliente tipoCliente, Integer endereco) {
		this.setID(id);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setTipo(tipoCliente);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public Integer getTelefone() {
		return Telefone;
	}

	public void setTelefone(Integer telefone) {
		Telefone = telefone;
	}

	public TipoCliente getTipo() {
		return TipoCliente;
	}

	public void setTipo(TipoCliente tipoCliente) {
		TipoCliente = tipoCliente;
	}

	public Integer getEndereco() {
		return Endereco;
	}

	public void setEndereco(Integer endereco) {
		Endereco = endereco;
	}	

}
