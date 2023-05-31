package entidades;

import java.util.Date;

import Enumeracao.FormaDePagamento;

public class Compra {
	
	private Integer ID;
	private Date Data;
	private FormaDePagamento FormaPagamento;
	//private Cliente Cliente;
	
	public Compra() {
		
	}

	public Compra( Integer id, Date data, FormaDePagamento formaPagamento) {
		this.setID(id);
		this.setData(data);
		this.setTipoPagamento(formaPagamento);
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
	
}
