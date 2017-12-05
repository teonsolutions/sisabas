package pe.com.sisabas.dto;

import java.io.Serializable;
import java.util.Date;

public class PacConsolidadoDto implements Serializable,Cloneable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPacConsolidado;
	private Integer nroConsolid;
	private String nroPac;
	private String idCatalogoTipoNecesidad;
	private String idCatalogoTipoContratacion;
	private Integer estadoRequerimiento;
	private String estadoRequerimientoDesc;
	private Double valorEstimadoContratacion;
	private Integer esItemUnico;
	private Integer nroItems;
	private String tipoProcesoInicial;
	private String tipoProcesoInicialDesc;
	private String idCatalogoEstadoPac;
	private Integer unidadMedida;
	private String unidadMedidaDesc;
	private String descripcionPac;
	private Integer cantidad;
	private Integer mesPrevistoConvocatoria;
	private String idTipoBien;
	private String tipoBienDesc;
	private Integer nroVersionPac;
	private Date fechaResolucionPac;
	private Date fechaModificacionSeace;
	private Date fechaRecepcionDocumentoTecnico;
	private String nombreEspecialistaVR;
	private String resolucionPac;
	private String documentoNoProgramado;
	
	
		

	public Integer getIdPacConsolidado() {
		return idPacConsolidado;
	}




	public void setIdPacConsolidado(Integer idPacConsolidado) {
		this.idPacConsolidado = idPacConsolidado;
	}




	public Integer getNroConsolid() {
		return nroConsolid;
	}




	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}




	public String getNroPac() {
		return nroPac;
	}




	public void setNroPac(String nroPac) {
		this.nroPac = nroPac;
	}




	public String getIdCatalogoTipoNecesidad() {
		return idCatalogoTipoNecesidad;
	}




	public void setIdCatalogoTipoNecesidad(String idCatalogoTipoNecesidad) {
		this.idCatalogoTipoNecesidad = idCatalogoTipoNecesidad;
	}




	public String getIdCatalogoTipoContratacion() {
		return idCatalogoTipoContratacion;
	}




	public void setIdCatalogoTipoContratacion(String idCatalogoTipoContratacion) {
		this.idCatalogoTipoContratacion = idCatalogoTipoContratacion;
	}




	public Integer getEstadoRequerimiento() {
		return estadoRequerimiento;
	}




	public void setEstadoRequerimiento(Integer estadoRequerimiento) {
		this.estadoRequerimiento = estadoRequerimiento;
	}




	public String getEstadoRequerimientoDesc() {
		return estadoRequerimientoDesc;
	}




	public void setEstadoRequerimientoDesc(String estadoRequerimientoDesc) {
		this.estadoRequerimientoDesc = estadoRequerimientoDesc;
	}




	public Double getValorEstimadoContratacion() {
		return valorEstimadoContratacion;
	}




	public void setValorEstimadoContratacion(Double valorEstimadoContratacion) {
		this.valorEstimadoContratacion = valorEstimadoContratacion;
	}




	public Integer getEsItemUnico() {
		return esItemUnico;
	}




	public void setEsItemUnico(Integer esItemUnico) {
		this.esItemUnico = esItemUnico;
	}




	public Integer getNroItems() {
		return nroItems;
	}




	public void setNroItems(Integer nroItems) {
		this.nroItems = nroItems;
	}




	public String getTipoProcesoInicial() {
		return tipoProcesoInicial;
	}




	public void setTipoProcesoInicial(String tipoProcesoInicial) {
		this.tipoProcesoInicial = tipoProcesoInicial;
	}




	public String getTipoProcesoInicialDesc() {
		return tipoProcesoInicialDesc;
	}




	public void setTipoProcesoInicialDesc(String tipoProcesoInicialDesc) {
		this.tipoProcesoInicialDesc = tipoProcesoInicialDesc;
	}




	public String getIdCatalogoEstadoPac() {
		return idCatalogoEstadoPac;
	}




	public void setIdCatalogoEstadoPac(String idCatalogoEstadoPac) {
		this.idCatalogoEstadoPac = idCatalogoEstadoPac;
	}




	public Integer getUnidadMedida() {
		return unidadMedida;
	}




	public void setUnidadMedida(Integer unidadMedida) {
		this.unidadMedida = unidadMedida;
	}




	public String getUnidadMedidaDesc() {
		return unidadMedidaDesc;
	}




	public void setUnidadMedidaDesc(String unidadMedidaDesc) {
		this.unidadMedidaDesc = unidadMedidaDesc;
	}




	public String getDescripcionPac() {
		return descripcionPac;
	}




	public void setDescripcionPac(String descripcionPac) {
		this.descripcionPac = descripcionPac;
	}




	public Integer getCantidad() {
		return cantidad;
	}




	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}




	public Integer getMesPrevistoConvocatoria() {
		return mesPrevistoConvocatoria;
	}




	public void setMesPrevistoConvocatoria(Integer mesPrevistoConvocatoria) {
		this.mesPrevistoConvocatoria = mesPrevistoConvocatoria;
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




	public Integer getNroVersionPac() {
		return nroVersionPac;
	}




	public void setNroVersionPac(Integer nroVersionPac) {
		this.nroVersionPac = nroVersionPac;
	}




	public Date getFechaResolucionPac() {
		return fechaResolucionPac;
	}




	public void setFechaResolucionPac(Date fechaResolucionPac) {
		this.fechaResolucionPac = fechaResolucionPac;
	}




	public Date getFechaModificacionSeace() {
		return fechaModificacionSeace;
	}




	public void setFechaModificacionSeace(Date fechaModificacionSeace) {
		this.fechaModificacionSeace = fechaModificacionSeace;
	}




	public Date getFechaRecepcionDocumentoTecnico() {
		return fechaRecepcionDocumentoTecnico;
	}




	public void setFechaRecepcionDocumentoTecnico(Date fechaRecepcionDocumentoTecnico) {
		this.fechaRecepcionDocumentoTecnico = fechaRecepcionDocumentoTecnico;
	}




	public String getNombreEspecialistaVR() {
		return nombreEspecialistaVR;
	}




	public void setNombreEspecialistaVR(String nombreEspecialistaVR) {
		this.nombreEspecialistaVR = nombreEspecialistaVR;
	}




	public String getResolucionPac() {
		return resolucionPac;
	}




	public void setResolucionPac(String resolucionPac) {
		this.resolucionPac = resolucionPac;
	}




	public String getDocumentoNoProgramado() {
		return documentoNoProgramado;
	}




	public void setDocumentoNoProgramado(String documentoNoProgramado) {
		this.documentoNoProgramado = documentoNoProgramado;
	}




	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
}
