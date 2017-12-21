package pe.com.sisabas.be;

import java.io.Serializable;
import java.util.Date;

public class RequerimientoRequest extends SysTabla  implements  Serializable,Cloneable{
	
	private static final long serialVersionUID = 1L;
	
	public String tipoNecesidad;
	public String codigoUnidadEjecutora;
	public Integer anoEje;
	public String pedido;
	public String tipoBien;
	public Integer tipoContratacion;
	public String nroExpediente;  
	public String estado;
	public String centroCosto;
	public Integer pagenumber;
	public Integer pageSize;
	

	
	public String getCodigoUnidadEjecutora() {
		return codigoUnidadEjecutora;
	}
	public void setCodigoUnidadEjecutora(String codigoUnidadEjecutora) {
		this.codigoUnidadEjecutora = codigoUnidadEjecutora;
	}
	public Integer getAnoEje() {
		return anoEje;
	}
	public void setAnoEje(Integer anoEje) {
		this.anoEje = anoEje;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public String getTipoBien() {
		return tipoBien;
	}
	public void setTipoBien(String tipoBien) {
		this.tipoBien = tipoBien;
	}
	public Integer getTipoContratacion() {
		return tipoContratacion;
	}
	public void setTipoContratacion(Integer tipoContratacion) {
		this.tipoContratacion = tipoContratacion;
	}
	public String getNroExpediente() {
		return nroExpediente;
	}
	public void setNroExpediente(String nroExpediente) {
		this.nroExpediente = nroExpediente;
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
	public Integer getPagenumber() {
		return pagenumber;
	}
	public void setPagenumber(Integer pagenumber) {
		this.pagenumber = pagenumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getTipoNecesidad() {
		return tipoNecesidad;
	}
	public void setTipoNecesidad(String tipoNecesidad) {
		this.tipoNecesidad = tipoNecesidad;
	}

	

}
