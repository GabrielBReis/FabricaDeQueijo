package entidades;

import java.util.Date;

import Enumeracao.StatusQualidade;

public class Resultado {
	
	private Integer ID;
	private Date Data;
	private Teste TipoTeste;
	private Integer LoteMateriaPrima;
	private Float Nota;
	private StatusQualidade Aprovacao;
	
	public Resultado() {
		
	}

	public Resultado(Integer id, Date data, Teste tipoTeste, Integer loteMateriaPrima, Float nota, StatusQualidade aprovacao) {
		setID(id);
		setData(data);
		setTipoTeste(tipoTeste);
		setLoteMateriaPrima(loteMateriaPrima);
		setNota(nota);
		setAprovacao(aprovacao);
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

	public Teste getTipoTeste() {
		return TipoTeste;
	}

	public void setTipoTeste(Teste tipoTeste) {
		TipoTeste = tipoTeste;
	}

	public Integer getLoteMateriaPrima() {
		return LoteMateriaPrima;
	}

	public void setLoteMateriaPrima(Integer loteMateriaPrima) {
		LoteMateriaPrima = loteMateriaPrima;
	}

	public Float getNota() {
		return Nota;
	}

	public void setNota(Float nota) {
		Nota = nota;
	}

	public StatusQualidade getAprovacao() {
		return Aprovacao;
	}

	public void setAprovacao(StatusQualidade aprovacao) {
		Aprovacao = aprovacao;
	}

}
