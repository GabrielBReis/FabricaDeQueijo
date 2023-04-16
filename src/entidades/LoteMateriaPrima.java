package entidades;

import java.util.Date;

public class LoteMateriaPrima {
	
	private Integer ID;
	private Date Data;
	private Float Quantidade;
	
	public LoteMateriaPrima() {
	}

	public LoteMateriaPrima(Integer iD, Date data, Float quantidade) {
		setID(iD);
		setData(data);
		setQuantidade(quantidade);
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

	public void setID(Integer iD) {
		ID = iD;
	}

	public Float getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(float quantidade) {
		Quantidade = quantidade;
	}
	
	
	
	

}
