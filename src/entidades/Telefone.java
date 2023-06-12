package entidades;

public class Telefone {
	private Integer ID;
	private String DDD;
	private String Numero;
	
	public Telefone() {
		
	}

	public Telefone(Integer id, String ddd, String numero) {
		ID = id;
		DDD = ddd;
		Numero = numero;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public String getDDD() {
		return DDD;
	}

	public void setDDD(String ddd) {
		DDD = ddd;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	@Override
	public String toString() {
		return getDDD() + " " + getNumero();
	}
}
