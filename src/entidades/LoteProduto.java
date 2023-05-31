package entidades;

public class LoteProduto {
	
	private Integer ID;
	private Integer Lote;
	private Float Quantidade;
	
	public LoteProduto() {
		
	}

	public LoteProduto(Integer id, Integer lote, Float quantidade) {
		setID(id);
		setLote(lote);
		setQuantidade(quantidade);
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
		return Quantidade;
	}

	public void setQuantidade(Float quantidade) {
		Quantidade = quantidade;
	}
	
	
	
	

}
