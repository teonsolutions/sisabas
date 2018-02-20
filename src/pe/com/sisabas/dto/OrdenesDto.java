package pe.com.sisabas.dto;

import java.util.Date;

public class OrdenesDto {
	
	private Date fechaOrden;
	private String nroOrden;
	private String moneda;
	private Integer estadoOrden;
	private Integer idContrato;
	private String nroProceso;
	private String nroContrato;
	private Date fechaInicioPrestacion;
	private String idCatalogoTipoBien;
	private Date fechaFinPrestacion;
	private Integer plazoEjecucion;
	private Integer anio;
	public Date getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public String getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(String nroOrden) {
		this.nroOrden = nroOrden;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Integer getEstadoOrden() {
		return estadoOrden;
	}
	public void setEstadoOrden(Integer estadoOrden) {
		this.estadoOrden = estadoOrden;
	}
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public String getNroProceso() {
		return nroProceso;
	}
	public void setNroProceso(String nroProceso) {
		this.nroProceso = nroProceso;
	}
	public String getNroContrato() {
		return nroContrato;
	}
	public void setNroContrato(String nroContrato) {
		this.nroContrato = nroContrato;
	}
	public Date getFechaInicioPrestacion() {
		return fechaInicioPrestacion;
	}
	public void setFechaInicioPrestacion(Date fechaInicioPrestacion) {
		this.fechaInicioPrestacion = fechaInicioPrestacion;
	}
	public String getIdCatalogoTipoBien() {
		return idCatalogoTipoBien;
	}
	public void setIdCatalogoTipoBien(String idCatalogoTipoBien) {
		this.idCatalogoTipoBien = idCatalogoTipoBien;
	}
	public Date getFechaFinPrestacion() {
		return fechaFinPrestacion;
	}
	public void setFechaFinPrestacion(Date fechaFinPrestacion) {
		this.fechaFinPrestacion = fechaFinPrestacion;
	}
	public Integer getPlazoEjecucion() {
		return plazoEjecucion;
	}
	public void setPlazoEjecucion(Integer plazoEjecucion) {
		this.plazoEjecucion = plazoEjecucion;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
    
}
