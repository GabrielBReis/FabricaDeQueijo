package entidades;

import Enumeracao.TipoQueijo;

public class Estoque {
	private Integer ID;
	private float QuantidadeKG;
	private Integer Lote;
	private TipoQueijo TipoQueijo;
	
	public Estoque() {

	}

	public Estoque(Integer id, float quantidadeKG, Integer lote, TipoQueijo tipoQueijo) {
		ID = id;
		QuantidadeKG = quantidadeKG;
		Lote = lote;
		TipoQueijo = tipoQueijo;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public float getQuantidadeKG() {
		return QuantidadeKG;
	}

	public void setQuantidadeKG(float quantidadeKG) {
		QuantidadeKG = quantidadeKG;
	}

	public Integer getLote() {
		return Lote;
	}

	public void setLote(Integer lote) {
		Lote = lote;
	}

	public TipoQueijo getTipoQueijo() {
		return TipoQueijo;
	}

	public void setTipoQueijo(TipoQueijo tipoQueijo) {
		TipoQueijo = tipoQueijo;
	}
	
}
