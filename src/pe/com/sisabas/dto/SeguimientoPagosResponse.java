package pe.com.sisabas.dto;

import java.util.Date;

public class SeguimientoPagosResponse {

	private String expediente;
	private String anioProceso;
	private String mesProceso;
	private String ciclo;
	private String fase;
	private String tipoDocumentoDesc;
	private String nroDocumento;
	private String fechaDocumento;
	private Double monto;
	
	public String getExpediente() {
		return expediente;
	}
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	public String getAnioProceso() {
		return anioProceso;
	}
	public void setAnioProceso(String anioProceso) {
		this.anioProceso = anioProceso;
	}
	public String getMesProceso() {
		return mesProceso;
	}
	public void setMesProceso(String mesProceso) {
		this.mesProceso = mesProceso;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getTipoDocumentoDesc() {
		return tipoDocumentoDesc;
	}
	public void setTipoDocumentoDesc(String tipoDocumentoDesc) {
		this.tipoDocumentoDesc = tipoDocumentoDesc;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getFechaDocumento() {
		return fechaDocumento;
	}
	public void setFechaDocumento(String fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	
}
