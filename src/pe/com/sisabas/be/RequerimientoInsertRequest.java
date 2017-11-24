package pe.com.sisabas.be;

import java.io.Serializable;

public class RequerimientoInsertRequest extends SysTabla  implements  Serializable,Cloneable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private String nroPedido;
	private String codUnidadEjecutora;
	private Integer anoEje;
	private String tipoBien;
	private Integer idPeriodo;
	
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
	public Integer getAnoEje() {
		return anoEje;
	}
	public void setAnoEje(Integer anoEje) {
		this.anoEje = anoEje;
	}
	public String getTipoBien() {
		return tipoBien;
	}
	public void setTipoBien(String tipoBien) {
		this.tipoBien = tipoBien;
	}
	public Integer getIdPeriodo() {
		return idPeriodo;
	}
	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	

}
