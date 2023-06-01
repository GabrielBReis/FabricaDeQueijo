package entidades;

import java.util.Date;

import Enumeracao.FormaDePagamento;

public class Compra {
	
	private Integer ID;
	private Date Data;
	private FormaDePagamento FormaPagamento;
	private Integer Cliente;
	
	public Compra() {
		
	}

	public Compra( Integer id, Date data, FormaDePagamento formaPagamento, Integer cliente) {
		this.setID(id);
		this.setData(data);
		this.setTipoPagamento(formaPagamento);
		this.setCliente(cliente);
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public FormaDePagamento getFormaPagamento() {
		return FormaPagamento;
	}

	public void setTipoPagamento(FormaDePagamento formaPagamento) {
		FormaPagamento = formaPagamento;
	}

	public Integer getCliente() {
		return Cliente;
	}

	public void setCliente(Integer cliente) {
		Cliente = cliente;
	}
	
}
