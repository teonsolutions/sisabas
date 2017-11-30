package pe.com.sisabas.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import pe.com.sisabas.be.Entregable;

public class OrdenDto implements Serializable,Cloneable{
	private Integer idOrden;
	private Integer nroOrden;
	private Date fechaOrden;
	private String idTipoBien;
	private String tipoBienDesc;
	private String nroRuc;
	private String nombreProveedor;
	private Double totalFactSoles;
	private Integer nroExpedienteSiaf;
	private String idEstadoSiaf;
	private String estadoSiafDesc;
		
	//Additional
	private Double importeDevengado;
	private Integer armadas;
	private Date fechaInicioPrestacion;
	private Integer plazo;
	private Date fechaFinPrestacion;
	private Integer anio;
	private Integer anioOrden;
	private Integer estadoOrden;
	private String moneda;
	private String codigoCentroCosto;
	private Integer idPacConsolidado;
	private Integer idUnidadEjecutora;
	private List<Entregable> entegables;


	public Integer getIdOrden() {
		return idOrden;
	}


	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}
	
	public Integer getNroOrden() {
		return nroOrden;
	}


	public void setNroOrden(Integer nroOrden) {
		this.nroOrden = nroOrden;
	}


	public Date getFechaOrden() {
		return fechaOrden;
	}


	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}


	public String getIdTipoBien() {
		return idTipoBien;
	}


	public void setIdTipoBien(String idTipoBien) {
		this.idTipoBien = idTipoBien;
	}


	public String getTipoBienDesc() {
		return tipoBienDesc;
	}


	public void setTipoBienDesc(String tipoBienDesc) {
		this.tipoBienDesc = tipoBienDesc;
	}


	public String getNroRuc() {
		return nroRuc;
	}


	public void setNroRuc(String nroRuc) {
		this.nroRuc = nroRuc;
	}


	public String getNombreProveedor() {
		return nombreProveedor;
	}


	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}


	public Double getTotalFactSoles() {
		return totalFactSoles;
	}


	public void setTotalFactSoles(Double totalFactSoles) {
		this.totalFactSoles = totalFactSoles;
	}


	public Integer getNroExpedienteSiaf() {
		return nroExpedienteSiaf;
	}


	public void setNroExpedienteSiaf(Integer nroExpedienteSiaf) {
		this.nroExpedienteSiaf = nroExpedienteSiaf;
	}


	public String getIdEstadoSiaf() {
		return idEstadoSiaf;
	}


	public void setIdEstadoSiaf(String idEstadoSiaf) {
		this.idEstadoSiaf = idEstadoSiaf;
	}


	public String getEstadoSiafDesc() {
		return estadoSiafDesc;
	}


	public void setEstadoSiafDesc(String estadoSiafDesc) {
		this.estadoSiafDesc = estadoSiafDesc;
	}
	
	public Double getImporteDevengado() {
		return importeDevengado;
	}


	public void setImporteDevengado(Double importeDevengado) {
		this.importeDevengado = importeDevengado;
	}

	public Integer getArmadas() {
		return armadas;
	}


	public void setArmadas(Integer armadas) {
		this.armadas = armadas;
	}


	public Date getFechaInicioPrestacion() {
		return fechaInicioPrestacion;
	}


	public void setFechaInicioPrestacion(Date fechaInicioPrestacion) {
		this.fechaInicioPrestacion = fechaInicioPrestacion;
	}


	public Integer getPlazo() {
		return plazo;
	}


	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}


	public Date getFechaFinPrestacion() {
		return fechaFinPrestacion;
	}


	public void setFechaFinPrestacion(Date fechaFinPrestacion) {
		this.fechaFinPrestacion = fechaFinPrestacion;
	}

	public Integer getAnioOrden() {
		return anioOrden;
	}

	public Integer getAnio() {
		return anio;
	}


	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public void setAnioOrden(Integer anioOrden) {
		this.anioOrden = anioOrden;
	}
	
	public Integer getEstadoOrden() {
		return estadoOrden;
	}


	public void setEstadoOrden(Integer estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

	public String getMoneda() {
		return moneda;
	}


	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getCodigoCentroCosto() {
		return codigoCentroCosto;
	}


	public void setCodigoCentroCosto(String codigoCentroCosto) {
		this.codigoCentroCosto = codigoCentroCosto;
	}

	public Integer getIdPacConsolidado() {
		return idPacConsolidado;
	}


	public void setIdPacConsolidado(Integer idPacConsolidado) {
		this.idPacConsolidado = idPacConsolidado;
	}

	public Integer getIdUnidadEjecutora() {
		return idUnidadEjecutora;
	}


	public void setIdUnidadEjecutora(Integer idUnidadEjecutora) {
		this.idUnidadEjecutora = idUnidadEjecutora;
	}

	public List<Entregable> getEntegables() {
		return entegables;
	}


	public void setEntegables(List<Entregable> entegables) {
		this.entegables = entegables;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
}
