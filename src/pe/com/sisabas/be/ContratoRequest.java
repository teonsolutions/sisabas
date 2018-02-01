package pe.com.sisabas.be;

import java.io.Serializable;
import java.util.Date;

public class ContratoRequest extends SysTabla implements Serializable,Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer ejercicio;
	private Integer codUnidEjecutora;
	private String numeroContrato;
	private Integer numeroProceso;
	private String tipoBien;
	private Date fechaContrato;
	private String tipoProceso;
	private String centroCosto;
	private String estado;
	private String sinadContrato;
	private Integer pageNumber;
	private Integer pageSize;
	
	
	public String getSinadContrato() {
		return sinadContrato;
	}
	public void setSinadContrato(String sinadContrato) {
		this.sinadContrato = sinadContrato;
	}
	
	public String getTipoProceso() {
		return tipoProceso;
	}
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}
	public Integer getNumeroProceso() {
		return numeroProceso;
	}
	public void setNumeroProceso(Integer numeroProceso) {
		this.numeroProceso = numeroProceso;
	}
	public String getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public String getTipoBien() {
		return tipoBien;
	}
	public void setTipoBien(String tipoBien) {
		this.tipoBien = tipoBien;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCentroCosto() {
		return centroCosto;
	}
	public void setCentroCosto(String centroCosto) {
		this.centroCosto = centroCosto;
	}
	public Integer getCodUnidEjecutora() {
		return codUnidEjecutora;
	}
	public void setCodUnidEjecutora(Integer codUnidEjecutora) {
		this.codUnidEjecutora = codUnidEjecutora;
	}
	public Integer getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(Integer ejercicio) {
		this.ejercicio = ejercicio;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
    

	
}
