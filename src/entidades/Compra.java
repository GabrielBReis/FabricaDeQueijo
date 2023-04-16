package entidades;

import java.util.Date;

import Enumeracao.FormaDePagamento;

public class Compra {
	
	private Date data;
	private Integer ID;
	private FormaDePagamento TipoPagamento;
	
	
	public Compra() {
	}

	public Compra(Date data, Integer iD, FormaDePagamento tipoPagamento) {
		this.setData(data);
		this.setID(iD);
		this.setTipoPagamento(tipoPagamento);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public FormaDePagamento getTipoPagamento() {
		return TipoPagamento;
	}

	public void setTipoPagamento(FormaDePagamento tipoPagamento) {
		TipoPagamento = tipoPagamento;
	}
	
	

}
