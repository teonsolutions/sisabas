package pe.com.sisabas.be;

import java.io.Serializable;
import java.util.Date;

public class SegEstadoReqResponse extends SysTabla  implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;
	
	private String orden;
	private String estado;
	private String descripcionEstado;
	private Date fechaCreacion;
	private String oficina;
	private String idDocumento;
	private Date fechaDma;
	private String especialista;
	
	
	
	
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getOficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	public String getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}
	public Date getFechaDma() {
		return fechaDma;
	}
	public void setFechaDma(Date fechaDma) {
		this.fechaDma = fechaDma;
	}
	public String getEspecialista() {
		return especialista;
	}
	public void setEspecialista(String especialista) {
		this.especialista = especialista;
	}
	
	
	
	

}
