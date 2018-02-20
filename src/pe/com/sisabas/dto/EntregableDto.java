package pe.com.sisabas.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EntregableDto implements  Serializable,Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String proveido;
	private Date fecha;
	private String descripcion;
	private String plazo;
	private BigDecimal importe;
	private BigDecimal montoPenalidad;
	private String observacion;
	private String estado;
	private Integer idOrden;
	private Integer idGrupoDocumento;
	private String nroProveido;
	private String nroEntregable;
	private BigDecimal montoEntregable;
	private String Idcatalogoestadoentregable;
	private Integer anio;
	
	//auditoria
	private String equipoAuditoria;
	private String programaAuditoria;
	private String usuarioAuditoria;
	
	public String getProveido() {
		return proveido;
	}
	public void setProveido(String proveido) {
		this.proveido = proveido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPlazo() {
		return plazo;
	}
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public BigDecimal getMontoPenalidad() {
		return montoPenalidad;
	}
	public void setMontoPenalidad(BigDecimal montoPenalidad) {
		this.montoPenalidad = montoPenalidad;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Integer getIdGrupoDocumento() {
		return idGrupoDocumento;
	}
	public void setIdGrupoDocumento(Integer idGrupoDocumento) {
		this.idGrupoDocumento = idGrupoDocumento;
	}
	public Integer getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}
	public String getNroProveido() {
		return nroProveido;
	}
	public void setNroProveido(String nroProveido) {
		this.nroProveido = nroProveido;
	}
	public String getNroEntregable() {
		return nroEntregable;
	}
	public void setNroEntregable(String nroEntregable) {
		this.nroEntregable = nroEntregable;
	}
	public BigDecimal getMontoEntregable() {
		return montoEntregable;
	}
	public void setMontoEntregable(BigDecimal montoEntregable) {
		this.montoEntregable = montoEntregable;
	}
	public String getIdcatalogoestadoentregable() {
		return Idcatalogoestadoentregable;
	}
	public void setIdcatalogoestadoentregable(String idcatalogoestadoentregable) {
		Idcatalogoestadoentregable = idcatalogoestadoentregable;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
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
	public String getUsuarioAuditoria() {
		return usuarioAuditoria;
	}
	public void setUsuarioAuditoria(String usuarioAuditoria) {
		this.usuarioAuditoria = usuarioAuditoria;
	}
	
	

}
