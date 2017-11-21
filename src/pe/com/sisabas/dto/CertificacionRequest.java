package pe.com.sisabas.dto;

public class CertificacionRequest {
	private Integer anio;
	private Integer idUnidadEjecutoraSiaf;
	private Integer nroCP;
	
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getIdUnidadEjecutoraSiaf() {
		return idUnidadEjecutoraSiaf;
	}
	public void setIdUnidadEjecutoraSiaf(Integer idUnidadEjecutoraSiaf) {
		this.idUnidadEjecutoraSiaf = idUnidadEjecutoraSiaf;
	}
	public Integer getNroCP() {
		return nroCP;
	}
	public void setNroCP(Integer nroCP) {
		this.nroCP = nroCP;
	}

}
