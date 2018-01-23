package pe.com.sisabas.dto;

public class ProcesoRequest {
	private String idTipoProceso;
	private String idTipoBien;
	private Integer estadoProceso;
	private Integer nroProceso;
	private Integer nroPao;
	private Integer idUnidadEjecutora;
	private Integer idUnidadEjecutoraSiaf;
	
	public String getIdTipoProceso() {
		return idTipoProceso;
	}
	public void setIdTipoProceso(String idTipoProceso) {
		this.idTipoProceso = idTipoProceso;
	}
	public String getIdTipoBien() {
		return idTipoBien;
	}
	public void setIdTipoBien(String idTipoBien) {
		this.idTipoBien = idTipoBien;
	}
	public Integer getEstadoProceso() {
		return estadoProceso;
	}
	public void setEstadoProceso(Integer estadoProceso) {
		this.estadoProceso = estadoProceso;
	}
	public Integer getNroProceso() {
		return nroProceso;
	}
	public void setNroProceso(Integer nroProceso) {
		this.nroProceso = nroProceso;
	}
	public Integer getNroPao() {
		return nroPao;
	}
	public void setNroPao(Integer nroPao) {
		this.nroPao = nroPao;
	}
	public Integer getIdUnidadEjecutora() {
		return idUnidadEjecutora;
	}
	public void setIdUnidadEjecutora(Integer idUnidadEjecutora) {
		this.idUnidadEjecutora = idUnidadEjecutora;
	}
	public Integer getIdUnidadEjecutoraSiaf() {
		return idUnidadEjecutoraSiaf;
	}
	public void setIdUnidadEjecutoraSiaf(Integer idUnidadEjecutoraSiaf) {
		this.idUnidadEjecutoraSiaf = idUnidadEjecutoraSiaf;
	}
	
		
}
