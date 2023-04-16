package entidades;

import java.util.Date;

public class Producao {
	
	private Integer ID;
	private Date Data;
	
	public Producao() {
	}

	public Producao(Integer iD, Date data) {
		setID(iD);
		setData(data);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}
	
	
	
	

}
