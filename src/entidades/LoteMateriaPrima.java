package entidades;

import java.util.Date;

public class LoteMateriaPrima {
	
	private Integer ID;
	private Date Data;
	private Float QuantidadeLitros;
	
	public LoteMateriaPrima() {
		
	}

	public LoteMateriaPrima(Integer id, Date data, Float quantidadeLitros) {
		setID(id);
		setData(data);
		setQuantidadeLitros(quantidadeLitros);
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public Float getQuantidadeLitros() {
		return QuantidadeLitros;
	}

	public void setQuantidadeLitros(float quantidadeLitros) {
		QuantidadeLitros = quantidadeLitros;
	}	

}
