package pe.com.sisabas.dto;

import java.util.Date;

public class SeguimientoPagosResponse {
	private String ciclo;
	private String fase;
	private String tipoDocumentoDesc;
	private String nroDocumento;
	private Date fechaDocumento;
	private Double monto;
	
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
	public Date getFechaDocumento() {
		return fechaDocumento;
	}
	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	
}
