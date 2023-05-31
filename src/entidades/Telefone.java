package entidades;

public class Telefone {
	private Integer ID;
	private char[] DDD = new char[2];
	private char[] Numero = new char[9];
	
	public Telefone() {
		
	}

	public Telefone(Integer id, char[] ddd, char[] numero) {
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

	public char[] getDDD() {
		return DDD;
	}

	public void setDDD(char[] ddd) {
		DDD = ddd;
	}

	public char[] getNumero() {
		return Numero;
	}

	public void setNumero(char[] numero) {
		Numero = numero;
	}

}
