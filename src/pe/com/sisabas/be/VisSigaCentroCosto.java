
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


public class VisSigaCentroCosto extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	
	private java.lang.String codigoUnidadEjecutora;
	private java.lang.String anio;
	private java.lang.String secEjec;
	private java.lang.String codigocentrocosto;
	private java.lang.String nombredependencia;
	private java.lang.String abreviadoDependencia;
	private java.lang.String sede;
	private java.lang.String pliego;
	private java.lang.String tipoDependencia;
	private java.lang.String estado;
	private java.lang.String orden;
	private java.lang.String centroSbn;
	
	
	
	
	public VisSigaCentroCosto() {}

	public VisSigaCentroCosto(java.lang.String codigocentrocosto) {
		this.codigocentrocosto=codigocentrocosto;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof VisSigaCentroCosto)
			return ((VisSigaCentroCosto)obj).getCodigocentrocosto().equals(this.getCodigocentrocosto()) ;
		else
			return false;
	 }


	public static final boolean HAVE_BIGDECIMALS=false;
	public void roundBigDecimals(){

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	public String getCodigoUnidadEjecutora() {
		return codigoUnidadEjecutora;
	}

	public void setCodigoUnidadEjecutora(String codigoUnidadEjecutora) {
		this.codigoUnidadEjecutora = codigoUnidadEjecutora;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getSecEjec() {
		return secEjec;
	}

	public void setSecEjec(String secEjec) {
		this.secEjec = secEjec;
	}

	public java.lang.String getCodigocentrocosto() {
		return codigocentrocosto;
	}

	public void setCodigocentrocosto(java.lang.String codigocentrocosto) {
		this.codigocentrocosto = codigocentrocosto;
	}

	public java.lang.String getNombredependencia() {
		return nombredependencia;
	}

	public void setNombredependencia(java.lang.String nombredependencia) {
		this.nombredependencia = nombredependencia;
	}

	public java.lang.String getAbreviadoDependencia() {
		return abreviadoDependencia;
	}

	public void setAbreviadoDependencia(java.lang.String abreviadoDependencia) {
		this.abreviadoDependencia = abreviadoDependencia;
	}

	public java.lang.String getSede() {
		return sede;
	}

	public void setSede(java.lang.String sede) {
		this.sede = sede;
	}

	public java.lang.String getPliego() {
		return pliego;
	}

	public void setPliego(java.lang.String pliego) {
		this.pliego = pliego;
	}

	public java.lang.String getTipoDependencia() {
		return tipoDependencia;
	}

	public void setTipoDependencia(java.lang.String tipoDependencia) {
		this.tipoDependencia = tipoDependencia;
	}

	public java.lang.String getEstado() {
		return estado;
	}

	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	public java.lang.String getOrden() {
		return orden;
	}

	public void setOrden(java.lang.String orden) {
		this.orden = orden;
	}

	public java.lang.String getCentroSbn() {
		return centroSbn;
	}

	public void setCentroSbn(java.lang.String centroSbn) {
		this.centroSbn = centroSbn;
	}

	
	



}
