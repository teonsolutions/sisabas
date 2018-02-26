package pe.com.sisabas.dto;

public class ContratoSigaRequest {
	private Integer annio;
	private Integer nroConsolid;
	private String nroRuc;
	private Integer idUnidadEjecutoraSiaf;
	public Integer getAnnio() {
		return annio;
	}
	public void setAnnio(Integer annio) {
		this.annio = annio;
	}
	public Integer getNroConsolid() {
		return nroConsolid;
	}
	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}
	public String getNroRuc() {
		return nroRuc;
	}
	public void setNroRuc(String nroRuc) {
		this.nroRuc = nroRuc;
	}
	public Integer getIdUnidadEjecutoraSiaf() {
		return idUnidadEjecutoraSiaf;
	}
	public void setIdUnidadEjecutoraSiaf(Integer idUnidadEjecutoraSiaf) {
		this.idUnidadEjecutoraSiaf = idUnidadEjecutoraSiaf;
	}

}
