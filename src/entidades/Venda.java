package entidades;

public class Venda {
	
	private Integer ID;
	private Integer QuantidadeKG;
	private Float Valor;
	private Integer Estoque;
	private Integer Compra;
	
	public Venda() {
		
	}

	public Venda(Integer iD, Integer quantidadeKg, Float valor, Integer estoque, Integer compra) {
		setID(iD);
		setQuantidade(quantidadeKg);
		setValor(valor);
		setEstoque(estoque);
		setCompra(compra);
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

	public Integer getEstoque() {
		return Estoque;
	}

	public void setEstoque(Integer estoque) {
		Estoque = estoque;
	}

	public Integer getCompra() {
		return Compra;
	}

	public void setCompra(Integer compra) {
		Compra = compra;
	}

}
