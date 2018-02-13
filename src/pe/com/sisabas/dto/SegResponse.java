package pe.com.sisabas.dto;

import java.math.BigDecimal;
import java.util.Date;

public class SegResponse {
	
	private String tipoBien;
	private String nombreTipoBien;
	private Integer idProcesoSeleccion;
    private Integer idPacConsolidado;
    private Integer nroProceso;
	private Integer idContrato;
	private Integer ejercicio;
	private Date fechaReg;
	private Integer montoProceso;
    private String descAbreviada;
    private String codTipoProceso;
    private String tipoProceso;
	private String nroDocumento;
	private Integer nroContrato;
	private Date fechaContrato;
	private Integer item;
	private Date fechaInicial;
	private Integer registrado;
	private String idCatalogoTipoContrato;
	private Date fechaFinal;
	private Integer nroConsolid;
	private String especTecnicas;
	private String estadoProceso;
	private String nroRuc;
	private String nombreProv;
	private Integer proveedor;
	private Integer nroCp;
	private BigDecimal montoCp;
	private String moneda;
	private Integer montoContrato;
	private Integer idDocumento;
	private String secContrato;
	private Date fechaRecepcionExpediente;
	private Integer plazoEjecucion;
	private String nombreAbogado;
	private String dniAbogado;
	private Integer cantidadArmadas;
	private String idCatalogoSistemaAdquisicion;
	
	public String getTipoBien() {
		return tipoBien;
	}
	public void setTipoBien(String tipoBien) {
		this.tipoBien = tipoBien;
	}
	public String getNombreTipoBien() {
		return nombreTipoBien;
	}
	public void setNombreTipoBien(String nombreTipoBien) {
		this.nombreTipoBien = nombreTipoBien;
	}
	public Integer getIdProcesoSeleccion() {
		return idProcesoSeleccion;
	}
	public void setIdProcesoSeleccion(Integer idProcesoSeleccion) {
		this.idProcesoSeleccion = idProcesoSeleccion;
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
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public Integer getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(Integer ejercicio) {
		this.ejercicio = ejercicio;
	}
	public Date getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	public Integer getMontoProceso() {
		return montoProceso;
	}
	public void setMontoProceso(Integer montoProceso) {
		this.montoProceso = montoProceso;
	}
	public String getDescAbreviada() {
		return descAbreviada;
	}
	public void setDescAbreviada(String descAbreviada) {
		this.descAbreviada = descAbreviada;
	}
	public String getCodTipoProceso() {
		return codTipoProceso;
	}
	public void setCodTipoProceso(String codTipoProceso) {
		this.codTipoProceso = codTipoProceso;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public Integer getNroContrato() {
		return nroContrato;
	}
	public void setNroContrato(Integer nroContrato) {
		this.nroContrato = nroContrato;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public Integer getItem() {
		return item;
	}
	public void setItem(Integer item) {
		this.item = item;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Integer getRegistrado() {
		return registrado;
	}
	public void setRegistrado(Integer registrado) {
		this.registrado = registrado;
	}
	public String getIdCatalogoTipoContrato() {
		return idCatalogoTipoContrato;
	}
	public void setIdCatalogoTipoContrato(String idCatalogoTipoContrato) {
		this.idCatalogoTipoContrato = idCatalogoTipoContrato;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Integer getNroConsolid() {
		return nroConsolid;
	}
	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}
	public String getEspecTecnicas() {
		return especTecnicas;
	}
	public void setEspecTecnicas(String especTecnicas) {
		this.especTecnicas = especTecnicas;
	}
	public String getEstadoProceso() {
		return estadoProceso;
	}
	public void setEstadoProceso(String estadoProceso) {
		this.estadoProceso = estadoProceso;
	}
	public String getNroRuc() {
		return nroRuc;
	}
	public void setNroRuc(String nroRuc) {
		this.nroRuc = nroRuc;
	}
	public String getNombreProv() {
		return nombreProv;
	}
	public void setNombreProv(String nombreProv) {
		this.nombreProv = nombreProv;
	}
	public Integer getProveedor() {
		return proveedor;
	}
	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}
	public Integer getNroCp() {
		return nroCp;
	}
	public void setNroCp(Integer nroCp) {
		this.nroCp = nroCp;
	}
	public BigDecimal getMontoCp() {
		return montoCp;
	}
	public void setMontoCp(BigDecimal montoCp) {
		this.montoCp = montoCp;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Integer getMontoContrato() {
		return montoContrato;
	}
	public void setMontoContrato(Integer montoContrato) {
		this.montoContrato = montoContrato;
	}
	public Integer getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getSecContrato() {
		return secContrato;
	}
	public void setSecContrato(String secContrato) {
		this.secContrato = secContrato;
	}
	public Date getFechaRecepcionExpediente() {
		return fechaRecepcionExpediente;
	}
	public void setFechaRecepcionExpediente(Date fechaRecepcionExpediente) {
		this.fechaRecepcionExpediente = fechaRecepcionExpediente;
	}
	public String getTipoProceso() {
		return tipoProceso;
	}
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}
	public Integer getPlazoEjecucion() {
		return plazoEjecucion;
	}
	public void setPlazoEjecucion(Integer plazoEjecucion) {
		this.plazoEjecucion = plazoEjecucion;
	}
	public String getNombreAbogado() {
		return nombreAbogado;
	}
	public void setNombreAbogado(String nombreAbogado) {
		this.nombreAbogado = nombreAbogado;
	}
	public String getDniAbogado() {
		return dniAbogado;
	}
	public void setDniAbogado(String dniAbogado) {
		this.dniAbogado = dniAbogado;
	}
	public Integer getCantidadArmadas() {
		return cantidadArmadas;
	}
	public void setCantidadArmadas(Integer cantidadArmadas) {
		this.cantidadArmadas = cantidadArmadas;
	}
	public String getIdCatalogoSistemaAdquisicion() {
		return idCatalogoSistemaAdquisicion;
	}
	public void setIdCatalogoSistemaAdquisicion(String idCatalogoSistemaAdquisicion) {
		this.idCatalogoSistemaAdquisicion = idCatalogoSistemaAdquisicion;
	}
	
	
	
}
