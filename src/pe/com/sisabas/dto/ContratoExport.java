package pe.com.sisabas.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContratoExport implements  Serializable,Cloneable{


	private static final long serialVersionUID = 1L;
	
	private Integer ejercicio;
	private Integer idProcesoSeleccion;
	private String tipoBien;
    private Integer nroConsolid;
    private Integer nroProceso;
    private String codTipoProceso;
    private String tipoProceso;
    private String centroCostos;
    private Integer nroContrato;
    private String nroDocumento;
    private Date fechaContrato;
    private String fechaContratoStr;
    private Integer idDocumento;
    private Integer idPacConsolidado;
    private String dniEspEjecucion;
    private String nomEspEjecucion;
    private Integer idTipoContrato;
    private String tipoContrato;
    private Integer idContrato;
    private String estado;
    private String tipoContratoTb;
    private Integer anoProceso;
    private Integer registrado;
    private Integer estadoContrato;
    private String estadoDocumentacion;
    private String estadoDocumentacionDesc;
    private Integer rowTotal;
    
    private String formatoFecha;
    private Integer numero;
	
	public Integer getIdProcesoSeleccion() {
		return idProcesoSeleccion;
	}

	public void setIdProcesoSeleccion(Integer idProcesoSeleccion) {
		this.idProcesoSeleccion = idProcesoSeleccion;
	}

	public String getTipoBien() {
		return tipoBien;
	}

	public void setTipoBien(String tipoBien) {
		this.tipoBien = tipoBien;
	}

	public Integer getNroConsolid() {
		return nroConsolid;
	}

	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}

	public Integer getNroProceso() {
		return nroProceso;
	}

	public void setNroProceso(Integer nroProceso) {
		this.nroProceso = nroProceso;
	}

	public String getCodTipoProceso() {
		return codTipoProceso;
	}

	public void setCodTipoProceso(String codTipoProceso) {
		this.codTipoProceso = codTipoProceso;
	}

	public String getTipoProceso() {
		return tipoProceso;
	}

	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	public String getCentroCostos() {
		return centroCostos;
	}

	public void setCentroCostos(String centroCostos) {
		this.centroCostos = centroCostos;
	}

	public Integer getNroContrato() {
		return nroContrato;
	}

	public void setNroContrato(Integer nroContrato) {
		this.nroContrato = nroContrato;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public String getFechaContratoStr() {
		return fechaContratoStr;
	}

	public void setFechaContratoStr(String fechaContratoStr) {
		this.fechaContratoStr = fechaContratoStr;
	}

	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public Integer getIdPacConsolidado() {
		return idPacConsolidado;
	}

	public void setIdPacConsolidado(Integer idPacConsolidado) {
		this.idPacConsolidado = idPacConsolidado;
	}

	public String getDniEspEjecucion() {
		return dniEspEjecucion;
	}

	public void setDniEspEjecucion(String dniEspEjecucion) {
		this.dniEspEjecucion = dniEspEjecucion;
	}

	public String getNomEspEjecucion() {
		return nomEspEjecucion;
	}

	public void setNomEspEjecucion(String nomEspEjecucion) {
		this.nomEspEjecucion = nomEspEjecucion;
	}

	public Integer getIdTipoContrato() {
		return idTipoContrato;
	}

	public void setIdTipoContrato(Integer idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoContratoTb() {
		return tipoContratoTb;
	}

	public void setTipoContratoTb(String tipoContratoTb) {
		this.tipoContratoTb = tipoContratoTb;
	}

	public Integer getAnoProceso() {
		return anoProceso;
	}

	public void setAnoProceso(Integer anoProceso) {
		this.anoProceso = anoProceso;
	}

	public Integer getRegistrado() {
		return registrado;
	}

	public void setRegistrado(Integer registrado) {
		this.registrado = registrado;
	}

	public Integer getEstadoContrato() {
		return estadoContrato;
	}

	public void setEstadoContrato(Integer estadoContrato) {
		this.estadoContrato = estadoContrato;
	}

	public String getEstadoDocumentacion() {
		return estadoDocumentacion;
	}

	public void setEstadoDocumentacion(String estadoDocumentacion) {
		this.estadoDocumentacion = estadoDocumentacion;
	}

	public String getEstadoDocumentacionDesc() {
		return estadoDocumentacionDesc;
	}

	public void setEstadoDocumentacionDesc(String estadoDocumentacionDesc) {
		this.estadoDocumentacionDesc = estadoDocumentacionDesc;
	}

	public Integer getRowTotal() {
		return rowTotal;
	}

	public void setRowTotal(Integer rowTotal) {
		this.rowTotal = rowTotal;
	}

	public String getFormatoFecha() {
		return formatoFecha;
	}

	public void setFormatoFecha(String formatoFecha) {
		this.formatoFecha = formatoFecha;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	
    public void formatoFecha(){
		
		this.formatoFecha=new SimpleDateFormat("dd-MM-yyyy").format(fechaContrato);

	}

	public Integer getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Integer ejercicio) {
		this.ejercicio = ejercicio;
	}
	

}
