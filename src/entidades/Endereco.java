package entidades;

public class Endereco {
	private Integer ID;
	private String Numero;
	private String Logradouro;
	
	public Endereco() {

	}

	public Endereco(Integer id, String numero, String logradouro) {
		ID = id;
		Numero = numero;
		Logradouro = logradouro;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
	
	

}
