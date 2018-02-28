package pe.com.sisabas.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ContratoDto implements  Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idContrato;
	private String tienePrevision;
	private Integer plazoEjecucion;
	private Integer cantidadArmadas;
	private String dniAbogado;
	private String nombreAbogado;
	private String idCatalogoSistemaAdquisicion;
	private Date fechaRecepcionExpediente;
	private BigDecimal montoContrato;
	private Integer nroContrato;
	private String nroCcp;
	private BigDecimal montoCertificacion;
	private Integer nroItems;
	private String dniEspecialistaEjecucion;
	private String nombreEspecialista;
	private String rutaContrato;
	private Integer idUnidadEjecutora;
	private Integer idGrupoDocumento;
	private String idCatalogoTipoContrato;
	private Integer secuenciaContrato;
	private String idCatalogoTipoBien;
	private Integer idProveedor;
	private Integer estadoContrato;
	private Date fechaInicial;
	private Date fechaFin;
	private String moneda;
	private Date fechaContrato;
	private String sinadContrato;
	private Integer anioSinadcContrato;
	private String numeroExpediente;
	private Integer anio;
    private Integer nroConsolid;
    private String idCatalogoEstadoDocumentacion;
    
    private Integer nroProceso;
    
    //Auditoria
    
    private Date fechaCreacionAuditoria;
    private String usuarioCreacionAuditoria;
    private String usuarioModificacionAuditoria;
    private String equipoAuditoria;
    private String programaAuditoria;
	private String estadoAudtoria;
	
	private Date fechamodificacionauditoria;
	
	
	private List<OrdenDto> listaOrden;
	private List<OrdenDto> ordenesEliminar;
	
	
	public String getTienePrevision() {
		return tienePrevision;
	}
	public void setTienePrevision(String tienePrevision) {
		this.tienePrevision = tienePrevision;
	}
	public Integer getPlazoEjecucion() {
		return plazoEjecucion;
	}
	public void setPlazoEjecucion(Integer plazoEjecucion) {
		this.plazoEjecucion = plazoEjecucion;
	}
	public Integer getCantidadArmadas() {
		return cantidadArmadas;
	}
	public void setCantidadArmadas(Integer cantidadArmadas) {
		this.cantidadArmadas = cantidadArmadas;
	}
	public String getDniAbogado() {
		return dniAbogado;
	}
	public void setDniAbogado(String dniAbogado) {
		this.dniAbogado = dniAbogado;
	}
	public String getNombreAbogado() {
		return nombreAbogado;
	}
	public void setNombreAbogado(String nombreAbogado) {
		this.nombreAbogado = nombreAbogado;
	}
	public String getIdCatalogoSistemaAdquisicion() {
		return idCatalogoSistemaAdquisicion;
	}
	public void setIdCatalogoSistemaAdquisicion(String idCatalogoSistemaAdquisicion) {
		this.idCatalogoSistemaAdquisicion = idCatalogoSistemaAdquisicion;
	}
	public Date getFechaRecepcionExpediente() {
		return fechaRecepcionExpediente;
	}
	public void setFechaRecepcionExpediente(Date fechaRecepcionExpediente) {
		this.fechaRecepcionExpediente = fechaRecepcionExpediente;
	}
	public BigDecimal getMontoContrato() {
		return montoContrato;
	}
	public void setMontoContrato(BigDecimal montoContrato) {
		this.montoContrato = montoContrato;
	}
	public Integer getNroContrato() {
		return nroContrato;
	}
	public void setNroContrato(Integer nroContrato) {
		this.nroContrato = nroContrato;
	}
	public String getNroCcp() {
		return nroCcp;
	}
	public void setNroCcp(String nroCcp) {
		this.nroCcp = nroCcp;
	}
	public BigDecimal getMontoCertificacion() {
		return montoCertificacion;
	}
	public void setMontoCertificacion(BigDecimal montoCertificacion) {
		this.montoCertificacion = montoCertificacion;
	}
	public List<OrdenDto> getListaOrden() {
		return listaOrden;
	}
	public void setListaOrden(List<OrdenDto> listaOrden) {
		this.listaOrden = listaOrden;
	}
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public Integer getNroItems() {
		return nroItems;
	}
	public void setNroItems(Integer nroItems) {
		this.nroItems = nroItems;
	}
	public String getDniEspecialistaEjecucion() {
		return dniEspecialistaEjecucion;
	}
	public void setDniEspecialistaEjecucion(String dniEspecialistaEjecucion) {
		this.dniEspecialistaEjecucion = dniEspecialistaEjecucion;
	}
	public String getNombreEspecialista() {
		return nombreEspecialista;
	}
	public void setNombreEspecialista(String nombreEspecialista) {
		this.nombreEspecialista = nombreEspecialista;
	}
	public String getRutaContrato() {
		return rutaContrato;
	}
	public void setRutaContrato(String rutaContrato) {
		this.rutaContrato = rutaContrato;
	}
	public Date getFechamodificacionauditoria() {
		return fechamodificacionauditoria;
	}
	public void setFechamodificacionauditoria(Date fechamodificacionauditoria) {
		this.fechamodificacionauditoria = fechamodificacionauditoria;
	}
	public Integer getIdUnidadEjecutora() {
		return idUnidadEjecutora;
	}
	public void setIdUnidadEjecutora(Integer idUnidadEjecutora) {
		this.idUnidadEjecutora = idUnidadEjecutora;
	}
	public Integer getIdGrupoDocumento() {
		return idGrupoDocumento;
	}
	public void setIdGrupoDocumento(Integer idGrupoDocumento) {
		this.idGrupoDocumento = idGrupoDocumento;
	}
	public String getIdCatalogoTipoContrato() {
		return idCatalogoTipoContrato;
	}
	public void setIdCatalogoTipoContrato(String idCatalogoTipoContrato) {
		this.idCatalogoTipoContrato = idCatalogoTipoContrato;
	}
	public Integer getSecuenciaContrato() {
		return secuenciaContrato;
	}
	public void setSecuenciaContrato(Integer secuenciaContrato) {
		this.secuenciaContrato = secuenciaContrato;
	}
	public String getIdCatalogoTipoBien() {
		return idCatalogoTipoBien;
	}
	public void setIdCatalogoTipoBien(String idCatalogoTipoBien) {
		this.idCatalogoTipoBien = idCatalogoTipoBien;
	}
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public Integer getEstadoContrato() {
		return estadoContrato;
	}
	public void setEstadoContrato(Integer estadoContrato) {
		this.estadoContrato = estadoContrato;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public String getSinadContrato() {
		return sinadContrato;
	}
	public void setSinadContrato(String sinadContrato) {
		this.sinadContrato = sinadContrato;
	}
	public Integer getAnioSinadcContrato() {
		return anioSinadcContrato;
	}
	public void setAnioSinadcContrato(Integer anioSinadcContrato) {
		this.anioSinadcContrato = anioSinadcContrato;
	}
	public String getNumeroExpediente() {
		return numeroExpediente;
	}
	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getNroConsolid() {
		return nroConsolid;
	}
	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}
	public String getIdCatalogoEstadoDocumentacion() {
		return idCatalogoEstadoDocumentacion;
	}
	public void setIdCatalogoEstadoDocumentacion(String idCatalogoEstadoDocumentacion) {
		this.idCatalogoEstadoDocumentacion = idCatalogoEstadoDocumentacion;
	}
	public Date getFechaCreacionAuditoria() {
		return fechaCreacionAuditoria;
	}
	public void setFechaCreacionAuditoria(Date fechaCreacionAuditoria) {
		this.fechaCreacionAuditoria = fechaCreacionAuditoria;
	}
	public String getUsuarioCreacionAuditoria() {
		return usuarioCreacionAuditoria;
	}
	public void setUsuarioCreacionAuditoria(String usuarioCreacionAuditoria) {
		this.usuarioCreacionAuditoria = usuarioCreacionAuditoria;
	}
	public String getUsuarioModificacionAuditoria() {
		return usuarioModificacionAuditoria;
	}
	public void setUsuarioModificacionAuditoria(String usuarioModificacionAuditoria) {
		this.usuarioModificacionAuditoria = usuarioModificacionAuditoria;
	}
	public String getEquipoAuditoria() {
		return equipoAuditoria;
	}
	public void setEquipoAuditoria(String equipoAuditoria) {
		this.equipoAuditoria = equipoAuditoria;
	}
	public String getProgramaAuditoria() {
		return programaAuditoria;
	}
	public void setProgramaAuditoria(String programaAuditoria) {
		this.programaAuditoria = programaAuditoria;
	}
	public String getEstadoAudtoria() {
		return estadoAudtoria;
	}
	public void setEstadoAudtoria(String estadoAudtoria) {
		this.estadoAudtoria = estadoAudtoria;
	}
	public Integer getNroProceso() {
		return nroProceso;
	}
	public void setNroProceso(Integer nroProceso) {
		this.nroProceso = nroProceso;
	}
	public List<OrdenDto> getOrdenesEliminar() {
		return ordenesEliminar;
	}
	public void setOrdenesEliminar(List<OrdenDto> ordenesEliminar) {
		this.ordenesEliminar = ordenesEliminar;
	}
	
	
	
}
