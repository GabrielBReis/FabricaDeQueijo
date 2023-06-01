package entidades;

public class LoteProduto {
	
	private Integer ID;
	private Integer Lote;
	private Float QuantidadeKG;
	
	public LoteProduto() {
		
	}

	public LoteProduto(Integer id, Integer lote, Float quantidadeKg) {
		setID(id);
		setLote(lote);
		setQuantidade(quantidadeKg);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public Integer getLote() {
		return Lote;
	}

	public void setLote(Integer lote) {
		Lote = lote;
	}

	public Float getQuantidade() {
		return QuantidadeKG;
	}

	public void setQuantidade(Float quantidadeKg) {
		QuantidadeKG = quantidadeKg;
	}	
	

}
