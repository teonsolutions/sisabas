package pe.com.sisabas.be;

import java.io.Serializable;

public class SeguimientoRequest extends SysTabla  implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;
	
	/*
	 ALTER PROCEDURE [abas].[paSeguimientoRequerimiento]
			 @EJERCICIO INT
			,@ID_TIPO_NECESIDAD VARCHAR(10) 
			,@ID_TIPO_DOCUMENTO INT 
			,@NRO_DOCUMENTO VARCHAR(20) =NULL
			,@TIPO_BIEN VARCHAR(10)=NULL  
			  
	 */
	
	private int ejercicio;
	
	private String tipoNecesidad;
	
	private String tipoDocumento;
	
	private String numeroDocumento;
	
	private String tipoBien;
	
	
	

	public int getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(int ejercicio) {
		this.ejercicio = ejercicio;
	}
	public String getTipoNecesidad() {
		return tipoNecesidad;
	}
	public void setTipoNecesidad(String tipoNecesidad) {
		this.tipoNecesidad = tipoNecesidad;
	}
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
