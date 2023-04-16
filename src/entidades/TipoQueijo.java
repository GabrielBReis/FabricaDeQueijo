package entidades;

public class TipoQueijo {
	
	private Integer ID;
	private String Descricao;
	
	public TipoQueijo() {
	}

	public TipoQueijo(Integer iD, String descricao) {
		setID(iD);
		setDescricao(descricao);
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}
	
	
	
	

}
