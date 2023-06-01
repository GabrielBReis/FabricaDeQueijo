package entidades;

import java.util.Date;

public class Producao {
	
	private Integer ID;
	private Date Data;
	private float QuantidadeLitros;
	private Integer LoteMateriaPrima;
	private Integer FuncionarioResponsavel;
	
	public Producao() {
		
	}

	public Producao(Integer id, Date data, float quantidadeLitros, Integer loteMateriaPrima, Integer funcionarioResponsavel) {
		setID(id);
		setData(data);
		setQuantidadeLitros(quantidadeLitros);
		setLoteMateriaPrima(loteMateriaPrima);
		setFuncionarioResponsavel(funcionarioResponsavel);
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

	public Integer getLoteMateriaPrima() {
		return LoteMateriaPrima;
	}

	public void setLoteMateriaPrima(Integer loteMateriaPrima) {
		LoteMateriaPrima = loteMateriaPrima;
	}

	public Integer getFuncionarioResponsavel() {
		return FuncionarioResponsavel;
	}

	public void setFuncionarioResponsavel(Integer funcionarioResponsavel) {
		FuncionarioResponsavel = funcionarioResponsavel;
	}
	
}
