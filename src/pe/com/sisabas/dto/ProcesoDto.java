package pe.com.sisabas.dto;

import java.io.Serializable;
import java.util.Date;

public class ProcesoDto implements  Serializable,Cloneable {
	private Integer idProcesoSeleccion;
	private Integer idGrupoDocumento;
	private Integer idPacConsolidado;
	private Integer nroProceso;
	private Integer nroConsolid;
	private String tipoBienDesc;
	private String codigoTipoProceso;
	private String tipoProcesoDesc;
	private String glosa;
	private Double valorEstimadoContratacion;
	private Date fechaRegistro;
	private Integer proceso;
	private String estadoproceso;
	private String estadoSiga;
	private String idEstadoSiga;
	private Integer anio;
	private Date fechaEnvioEjecucion;
	private Integer idEstadoProceso;
	private String dniEspecialistaProceso;
	private String nombreEspecialistaProceso;
	private String comiteNotificado;
	private Integer idComiteProceso;
	private String comiteRecompuesto;
	private Integer correlativo;
	private String existeSiga;
	private String tipoModalidad;
	
	public Integer getIdProcesoSeleccion() {
		return idProcesoSeleccion;
	}
	public void setIdProcesoSeleccion(Integer idProcesoSeleccion) {
		this.idProcesoSeleccion = idProcesoSeleccion;
	}
	public Integer getIdGrupoDocumento() {
		return idGrupoDocumento;
	}
	public void setIdGrupoDocumento(Integer idGrupoDocumento) {
		this.idGrupoDocumento = idGrupoDocumento;
	}
	public Integer getIdPacConsolidado() {
		return idPacConsolidado;
	}
	public void setIdPacConsolidado(Integer idPacConsolidado) {
		this.idPacConsolidado = idPacConsolidado;
	}
	public Integer getNroProceso() {
		return nroProceso;
	}
	public void setNroProceso(Integer nroProceso) {
		this.nroProceso = nroProceso;
	}
	public Integer getNroConsolid() {
		return nroConsolid;
	}
	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}
	public String getTipoBienDesc() {
		return tipoBienDesc;
	}
	public void setTipoBienDesc(String tipoBienDesc) {
		this.tipoBienDesc = tipoBienDesc;
	}	
	public String getCodigoTipoProceso() {
		return codigoTipoProceso;
	}
	public void setCodigoTipoProceso(String codigoTipoProceso) {
		this.codigoTipoProceso = codigoTipoProceso;
	}
	public String getTipoProcesoDesc() {
		return tipoProcesoDesc;
	}
	public void setTipoProcesoDesc(String tipoProcesoDesc) {
		this.tipoProcesoDesc = tipoProcesoDesc;
	}
	public String getGlosa() {
		return glosa;
	}
	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}
	public Double getValorEstimadoContratacion() {
		return valorEstimadoContratacion;
	}
	public void setValorEstimadoContratacion(Double valorEstimadoContratacion) {
		this.valorEstimadoContratacion = valorEstimadoContratacion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Integer getProceso() {
		return proceso;
	}
	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}
	public String getEstadoproceso() {
		return estadoproceso;
	}
	public void setEstadoproceso(String estadoproceso) {
		this.estadoproceso = estadoproceso;
	}
	public String getEstadoSiga() {
		return estadoSiga;
	}
	public void setEstadoSiga(String estadoSiga) {
		this.estadoSiga = estadoSiga;
	}
	public String getIdEstadoSiga() {
		return idEstadoSiga;
	}
	public void setIdEstadoSiga(String idEstadoSiga) {
		this.idEstadoSiga = idEstadoSiga;
	}	
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Date getFechaEnvioEjecucion() {
		return fechaEnvioEjecucion;
	}
	public void setFechaEnvioEjecucion(Date fechaEnvioEjecucion) {
		this.fechaEnvioEjecucion = fechaEnvioEjecucion;
	}
	public Integer getIdEstadoProceso() {
		return idEstadoProceso;
	}
	public void setIdEstadoProceso(Integer idEstadoProceso) {
		this.idEstadoProceso = idEstadoProceso;
	}	
	public String getDniEspecialistaProceso() {
		return dniEspecialistaProceso;
	}
	public void setDniEspecialistaProceso(String dniEspecialistaProceso) {
		this.dniEspecialistaProceso = dniEspecialistaProceso;
	}
	public String getNombreEspecialistaProceso() {
		return nombreEspecialistaProceso;
	}
	public void setNombreEspecialistaProceso(String nombreEspecialistaProceso) {
		this.nombreEspecialistaProceso = nombreEspecialistaProceso;
	}
	public String getComiteNotificado() {
		return comiteNotificado;
	}
	public void setComiteNotificado(String comiteNotificado) {
		this.comiteNotificado = comiteNotificado;
	}
	public Integer getIdComiteProceso() {
		return idComiteProceso;
	}
	public void setIdComiteProceso(Integer idComiteProceso) {
		this.idComiteProceso = idComiteProceso;
	}
	public String getComiteRecompuesto() {
		return comiteRecompuesto;
	}
	public void setComiteRecompuesto(String comiteRecompuesto) {
		this.comiteRecompuesto = comiteRecompuesto;
	}
	public Integer getCorrelativo() {
		return correlativo;
	}
	public void setCorrelativo(Integer correlativo) {
		this.correlativo = correlativo;
	}
	public String getTipoModalidad() {
		return tipoModalidad;
	}
	public void setTipoModalidad(String tipoModalidad) {
		this.tipoModalidad = tipoModalidad;
	}
	public String getExisteSiga() {
		return existeSiga;
	}
	public void setExisteSiga(String existeSiga) {
		this.existeSiga = existeSiga;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
		
}
