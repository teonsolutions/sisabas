package pe.com.sisabas.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdendaDto implements Serializable,Cloneable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idAdenda;
	private Integer idContrato;
	private Integer nroAdenda;
	private String motivo;
	private BigDecimal monto;
	private Date fechaInicio;
	private Date fechaFin;	
    private Integer estadoAdenda;
    private String tipo;
    private String ruta;
    private String nombreArchivo;
    
  //auditoria
	
  	private String equipoAuditoria;
  	private String programaAuditoria;
  	private String usuarioAuditoria;
  	private Date fechaCreacionAudioria;
  	private String usuarioCreacionAuditoria;
    
    
	public Integer getIdAdenda() {
		return idAdenda;
	}
	public void setIdAdenda(Integer idAdenda) {
		this.idAdenda = idAdenda;
	}
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public Integer getNroAdenda() {
		return nroAdenda;
	}
	public void setNroAdenda(Integer nroAdenda) {
		this.nroAdenda = nroAdenda;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Integer getEstadoAdenda() {
		return estadoAdenda;
	}
	public void setEstadoAdenda(Integer estadoAdenda) {
		this.estadoAdenda = estadoAdenda;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
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
	public Date getFechaCreacionAudioria() {
		return fechaCreacionAudioria;
	}
	public void setFechaCreacionAudioria(Date fechaCreacionAudioria) {
		this.fechaCreacionAudioria = fechaCreacionAudioria;
	}
	public String getUsuarioCreacionAuditoria() {
		return usuarioCreacionAuditoria;
	}
	public void setUsuarioCreacionAuditoria(String usuarioCreacionAuditoria) {
		this.usuarioCreacionAuditoria = usuarioCreacionAuditoria;
	}
    
    
	
}
