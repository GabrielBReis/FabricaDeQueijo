package entidades;

import java.util.Date;

public class Producao {
	
	private Integer ID;
	private Date Data;
	private float QuantidadeLitros;
	//private LoteMateriaPrima LoteMateriaPrima;
	//private Funcionario FuncionarioResponsavel;
	
	public Producao() {
		
	}

	public Producao(Integer id, Date data, float quantidadeLitros) {
		setID(id);
		setData(data);
		setQuantidadeLitros(quantidadeLitros);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public float getQuantidadeLitros() {
		return QuantidadeLitros;
	}

	public void setQuantidadeLitros(float quantidadeLitros) {
		QuantidadeLitros = quantidadeLitros;
	}


}
