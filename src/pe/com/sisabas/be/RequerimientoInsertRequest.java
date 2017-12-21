package pe.com.sisabas.be;

import java.io.Serializable;

public class RequerimientoInsertRequest extends SysTabla  implements  Serializable,Cloneable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private String nroPedido;
	private String codUnidadEjecutora;
	private Integer anoEje;
	private String tipoBien;
	private Integer idPeriodo;
	private String usuarioCreacion;
	private String tipoNecesidad;
	private Integer idUnidadEjectura;
	private Integer nroConsolid;
	
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
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public String getTipoNecesidad() {
		return tipoNecesidad;
	}
	public void setTipoNecesidad(String tipoNecesidad) {
		this.tipoNecesidad = tipoNecesidad;
	}
	public Integer getIdUnidadEjectura() {
		return idUnidadEjectura;
	}
	public void setIdUnidadEjectura(Integer idUnidadEjectura) {
		this.idUnidadEjectura = idUnidadEjectura;
	}
	public Integer getNroConsolid() {
		return nroConsolid;
	}
	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}
	
	

}
