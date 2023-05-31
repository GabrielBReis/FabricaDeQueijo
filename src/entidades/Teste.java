package entidades;

public class Teste {
	
	private Integer ID;
	private String NomeTeste;
	private String Descricao;
	
	public Teste(){
		
	}

	public Teste(Integer id, String nomeTeste, String descricao) {
		setID(id);
		setNomeTeste(nomeTeste);
		setDescricao(descricao);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public String getNomeTeste() {
		return NomeTeste;
	}

	public void setNomeTeste(String nomeTeste) {
		NomeTeste = nomeTeste;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}	
	
}
