package pe.com.sisabas.be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SeguimientoResponse extends SysTabla  implements  Serializable,Cloneable{
	
	private static final long serialVersionUID = 1L;
	
	private String anio;
	private String id;
	private String nroSinad;
	private String nroPedido;
	private String tipoBien;
	private String nroConsolidado;
	private String descripcion;
	private String valorContratacion;
	private String codTipoProceso;
	private String nroProceso;
	private String nroContrato;
	private String nroOrden;
	private String etapa;
	private String estado;
	
	
	
	
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNroSinad() {
		return nroSinad;
	}
	public void setNroSinad(String nroSinad) {
		this.nroSinad = nroSinad;
	}
	public String getNroPedido() {
		return nroPedido;
	}
	public void setNroPedido(String nroPedido) {
		this.nroPedido = nroPedido;
	}
	public String getTipoBien() {
		return tipoBien;
	}
	public void setTipoBien(String tipoBien) {
		this.tipoBien = tipoBien;
	}
	public String getNroConsolidado() {
		return nroConsolidado;
	}
	public void setNroConsolidado(String nroConsolidado) {
		this.nroConsolidado = nroConsolidado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getValorContratacion() {
		return valorContratacion;
	}
	public void setValorContratacion(String valorContratacion) {
		this.valorContratacion = valorContratacion;
	}
	public String getCodTipoProceso() {
		return codTipoProceso;
	}
	public void setCodTipoProceso(String codTipoProceso) {
		this.codTipoProceso = codTipoProceso;
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
	public String getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(String nroOrden) {
		this.nroOrden = nroOrden;
	}
	public String getEtapa() {
		return etapa;
	}
	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


	
	
	

}
