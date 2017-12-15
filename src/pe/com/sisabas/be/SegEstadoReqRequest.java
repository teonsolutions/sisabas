package pe.com.sisabas.be;

import java.io.Serializable;

public class SegEstadoReqRequest extends SysTabla  implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;
	
	/*
		ALTER PROCEDURE [abas].[paSeguimientoEstadoRequerimiento]
		(
			@ID_TIPO_DOCUMENTO		INT,
			@ID_DOCUMENTO			INT,
			@NRO_CONSOLID			VARCHAR(10) = NULL
		)
		AS
			  
	 */
	
	private int idTipoDocumento;
	private int idDocumento;
	private String nroConsolidado;
	
	
	
	
	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public int getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getNroConsolidado() {
		return nroConsolidado;
	}
	public void setNroConsolidado(String nroConsolidado) {
		this.nroConsolidado = nroConsolidado;
	}
	
	

	
	

}
