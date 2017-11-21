package pe.com.sisabas.dto;

import java.io.Serializable;
import java.util.Date;

public class RecepcionDTResponse implements Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEstadosPorEtapaPorDocumento;
	private Date fechaRecepcion;
	private String nombreUsuario;
	
	public Integer getIdEstadosPorEtapaPorDocumento() {
		return idEstadosPorEtapaPorDocumento;
	}

	public void setIdEstadosPorEtapaPorDocumento(Integer idEstadosPorEtapaPorDocumento) {
		this.idEstadosPorEtapaPorDocumento = idEstadosPorEtapaPorDocumento;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
}
