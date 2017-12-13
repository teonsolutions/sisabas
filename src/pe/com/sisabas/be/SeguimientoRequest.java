package pe.com.sisabas.be;

import java.io.Serializable;

public class SeguimientoRequest extends SysTabla  implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;
	
	
	private String tipoDocumento;
	
	private String numeroDocumento;
	
	private String tipoBien;
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getTipoBien() {
		return tipoBien;
	}
	public void setTipoBien(String tipoBien) {
		this.tipoBien = tipoBien;
	}
	

	
	

}
