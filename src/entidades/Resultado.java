package entidades;

import java.util.Date;

import Enumeracao.StatusQualidade;

public class Resultado {
	
	private Integer ID;
	private Date Data;
	private Teste TipoTeste;
	private LoteMateriaPrima LoteMateriaPrima;
	private Float Nota;
	private StatusQualidade Aprovacao;
	
	public Resultado() {
		
	}

	public Resultado(Integer id, Date data, Float nota, StatusQualidade aprovacao) {
		setID(id);
		setData(data);
		setNota(nota);
		setStatus(aprovacao);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
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
		return Aprovacao;
	}

	public void setStatus(StatusQualidade aprovacao) {
		Aprovacao = aprovacao;
	}
	
	
	
	

}
