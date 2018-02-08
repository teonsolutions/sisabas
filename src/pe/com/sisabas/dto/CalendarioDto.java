package pe.com.sisabas.dto;

import pe.com.sisabas.be.Convocatoriaprocesoseleccion;
import pe.com.sisabas.be.Gentabla;

public class CalendarioDto {
	private static final long serialVersionUID = 1L;

	private java.lang.Integer idcalendarioproceso;
	private java.lang.Integer idconvocatoriaproceso;
	private java.lang.String idcatalogocodigocalendario;
	private java.lang.String nombrecalendario;
	private java.util.Date fechainicio;
	private java.util.Date fechafin;
	private java.util.Date fechpublicacion;
	private java.lang.String idcatalogoestadopublicacion;
	private java.lang.String descripcionestado;
	
	public java.lang.Integer getIdcalendarioproceso() {
		return idcalendarioproceso;
	}
	public void setIdcalendarioproceso(java.lang.Integer idcalendarioproceso) {
		this.idcalendarioproceso = idcalendarioproceso;
	}
	public java.lang.Integer getIdconvocatoriaproceso() {
		return idconvocatoriaproceso;
	}
	public void setIdconvocatoriaproceso(java.lang.Integer idconvocatoriaproceso) {
		this.idconvocatoriaproceso = idconvocatoriaproceso;
	}
	public java.lang.String getIdcatalogocodigocalendario() {
		return idcatalogocodigocalendario;
	}
	public void setIdcatalogocodigocalendario(java.lang.String idcatalogocodigocalendario) {
		this.idcatalogocodigocalendario = idcatalogocodigocalendario;
	}
	public java.lang.String getNombrecalendario() {
		return nombrecalendario;
	}
	public void setNombrecalendario(java.lang.String nombrecalendario) {
		this.nombrecalendario = nombrecalendario;
	}
	public java.util.Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(java.util.Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public java.util.Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(java.util.Date fechafin) {
		this.fechafin = fechafin;
	}
	public java.util.Date getFechpublicacion() {
		return fechpublicacion;
	}
	public void setFechpublicacion(java.util.Date fechpublicacion) {
		this.fechpublicacion = fechpublicacion;
	}
	public java.lang.String getIdcatalogoestadopublicacion() {
		return idcatalogoestadopublicacion;
	}
	public void setIdcatalogoestadopublicacion(java.lang.String idcatalogoestadopublicacion) {
		this.idcatalogoestadopublicacion = idcatalogoestadopublicacion;
	}
	public java.lang.String getDescripcionestado() {
		return descripcionestado;
	}
	public void setDescripcionestado(java.lang.String descripcionestado) {
		this.descripcionestado = descripcionestado;
	}
	
	
}
