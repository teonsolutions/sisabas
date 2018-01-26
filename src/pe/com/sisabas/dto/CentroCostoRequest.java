package pe.com.sisabas.dto;

public class CentroCostoRequest {
	private String codigoUnidadEjecuta;
	private Integer idPeriodo;
	public String getCodigoUnidadEjecuta() {
		return codigoUnidadEjecuta;
	}
	public void setCodigoUnidadEjecuta(String codigoUnidadEjecuta) {
		this.codigoUnidadEjecuta = codigoUnidadEjecuta;
	}
	public Integer getIdPeriodo() {
		return idPeriodo;
	}
	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
}
