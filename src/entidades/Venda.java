package entidades;

public class Venda {
	
	private Integer ID;
	private Integer Quantidade;
	private Float Valor;
	
	public Venda() {
		
	}

	public Venda(Integer iD, Integer quantidade, Float valor) {
		setID(iD);
		setQuantidade(quantidade);
		setValor(valor);
	}

	public Integer getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		Quantidade = quantidade;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Float getValor() {
		return Valor;
	}

	public void setValor(Float valor) {
		Valor = valor;
	}
	
	
	
	

}
