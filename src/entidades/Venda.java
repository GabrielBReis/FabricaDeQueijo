package entidades;

public class Venda {
	
	private Integer ID;
	private Integer QuantidadeKG;
	private Float Valor;
	//private Estoque Estoque;
	//private Compra Compra;
	
	public Venda() {
		
	}

	public Venda(Integer iD, Integer quantidadeKg, Float valor) {
		setID(iD);
		setQuantidade(quantidadeKg);
		setValor(valor);
	}

	public Integer getQuantidadeKg() {
		return QuantidadeKG;
	}

	public void setQuantidade(Integer quantidadeKg) {
		QuantidadeKG = quantidadeKg;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public Float getValor() {
		return Valor;
	}

	public void setValor(Float valor) {
		Valor = valor;
	}
		

}
