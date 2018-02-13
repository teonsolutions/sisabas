package pe.com.sisabas.dto;

public class SegRequest {
	
	private String codUnidadEjecutora;
	private Integer idEjercicio;
	private String idTipoProceso;
    private Integer idContrato;
	public String getCodUnidadEjecutora() {
		return codUnidadEjecutora;
	}
	public void setCodUnidadEjecutora(String codUnidadEjecutora) {
		this.codUnidadEjecutora = codUnidadEjecutora;
	}
	public Integer getIdEjercicio() {
		return idEjercicio;
	}
	public void setIdEjercicio(Integer idEjercicio) {
		this.idEjercicio = idEjercicio;
	}
	public String getIdTipoProceso() {
		return idTipoProceso;
	}
	public void setIdTipoProceso(String idTipoProceso) {
		this.idTipoProceso = idTipoProceso;
	}
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
    
    
}
