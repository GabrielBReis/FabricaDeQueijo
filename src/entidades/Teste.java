package entidades;

import Enumeracao.TipoTeste;

public class Teste {
	
	private Integer ID;
	private String Descricao;
	private TipoTeste tipo;
	
	public Teste() {
	}

	public Teste(Integer iD, String descricao, TipoTeste tipo) {
		setID(iD);
		setDescricao(descricao);
		this.setTipo(tipo);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public TipoTeste getTipo() {
		return tipo;
	}

	public void setTipo(TipoTeste tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
