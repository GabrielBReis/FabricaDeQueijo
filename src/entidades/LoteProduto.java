package entidades;

public class LoteProduto {
	
	private Integer ID;
	private Integer Lote;
	private Float Quantidade;
	
	public LoteProduto() {
	}

	public LoteProduto(Integer iD, Integer lote, Float quantidade) {
		setID(iD);
		setLote(lote);
		setQuantidade(quantidade);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getLote() {
		return Lote;
	}

	public void setLote(Integer lote) {
		Lote = lote;
	}

	public Float getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(Float quantidade) {
		Quantidade = quantidade;
	}
	
	
	
	

}
