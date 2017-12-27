package pe.com.sisabas.dto;

public class ObservacionDocumentoTecnicoDto {
	private Integer idobservacionesdocumentotecnico;
	private Integer idseccionesdocumentotecnico;
	private String observacion;
	private String descripcionseccion;
	public Integer getIdobservacionesdocumentotecnico() {
		return idobservacionesdocumentotecnico;
	}
	public void setIdobservacionesdocumentotecnico(Integer idobservacionesdocumentotecnico) {
		this.idobservacionesdocumentotecnico = idobservacionesdocumentotecnico;
	}
	public Integer getIdseccionesdocumentotecnico() {
		return idseccionesdocumentotecnico;
	}
	public void setIdseccionesdocumentotecnico(Integer idseccionesdocumentotecnico) {
		this.idseccionesdocumentotecnico = idseccionesdocumentotecnico;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getDescripcionseccion() {
		return descripcionseccion;
	}
	public void setDescripcionseccion(String descripcionseccion) {
		this.descripcionseccion = descripcionseccion;
	}
	
}
