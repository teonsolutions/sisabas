package pe.com.sisabas.be;

import java.io.Serializable;

public class RequerimientoItemRequest extends SysTabla  implements  Serializable,Cloneable{
	
	private String nroPedido;
	private String codUnidadEjecutora;
	private Integer ejercicio;
	private String tipoBien;
	
	public String getNroPedido() {
		return nroPedido;
	}
	public void setNroPedido(String nroPedido) {
		this.nroPedido = nroPedido;
	}
	public String getCodUnidadEjecutora() {
		return codUnidadEjecutora;
	}
	public void setCodUnidadEjecutora(String codUnidadEjecutora) {
		this.codUnidadEjecutora = codUnidadEjecutora;
	}
	public Integer getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(Integer ejercicio) {
		this.ejercicio = ejercicio;
	}
	public String getTipoBien() {
		return tipoBien;
	}
	public void setTipoBien(String tipoBien) {
		this.tipoBien = tipoBien;
	}
	
	
}
