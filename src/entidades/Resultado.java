package entidades;

import java.util.Date;

import Enumeracao.StatusQualidade;

public class Resultado {
	
	private Integer ID;
	private Date Data;
	private Float Nota;
	private StatusQualidade Status;
	
	public Resultado() {
	}

	public Resultado(Integer iD, Date data, Float nota, StatusQualidade status) {
		setID(iD);
		setData(data);
		setNota(nota);
		setStatus(status);
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

	public Float getNota() {
		return Nota;
	}

	public void setNota(Float nota) {
		Nota = nota;
	}

	public StatusQualidade getStatus() {
		return Status;
	}

	public void setStatus(StatusQualidade status) {
		Status = status;
	}
	
	
	
	

}
