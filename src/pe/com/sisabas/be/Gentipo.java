
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Tabla Tipo]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Gentipo extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[Código]*/
	private java.lang.String vchtipcodigo;
	/**[Descripción]*/
	private java.lang.String vchtipdescripcion;
	/**[Adicional]*/
	private java.lang.String vchtipdesadicional;
	/**[Estado][boolean]*/
	private java.lang.String estadoauditoria;
	private Boolean booleanestadoauditoria;
	/**[*][Usuario Creación]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Usuario de Modificación]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Fecha de Modificación]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][IP/Nombre Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa/Clase]*/
	private java.lang.String programaauditoria;
	/**[intganempid]*/
	private java.lang.Integer intganempid;
	private List<Gentabla> listaGentabla;

	public Gentipo() {}

	public Gentipo(java.lang.String vchtipcodigo) {
		this.vchtipcodigo=vchtipcodigo;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Gentipo)
			return ((Gentipo)obj).getVchtipcodigo().equals(this.getVchtipcodigo()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.vchtipcodigo!=null)?("vchtipcodigo:\t" + this.vchtipcodigo+"\n"):"" ).concat(
			(this.vchtipdescripcion!=null)?("vchtipdescripcion:\t" + this.vchtipdescripcion+"\n"):"" ).concat(
			(this.vchtipdesadicional!=null)?("vchtipdesadicional:\t" + this.vchtipdesadicional+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.intganempid!=null)?("intganempid:\t" + this.intganempid+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.vchtipcodigo!=null)?("vchtipcodigo:\t" + this.vchtipcodigo+"\n"):"" ).concat(
			(this.vchtipdescripcion!=null)?("vchtipdescripcion:\t" + this.vchtipdescripcion+"\n"):"" ).concat(
			(this.vchtipdesadicional!=null)?("vchtipdesadicional:\t" + this.vchtipdesadicional+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.intganempid!=null)?("intganempid:\t" + this.intganempid+"\n"):"");
	 }

	public static final boolean HAVE_BIGDECIMALS=false;
	public void roundBigDecimals(){

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }


	 public java.lang.String getVchtipcodigo() {
		return vchtipcodigo;
	}

	public void setVchtipcodigo(java.lang.String vchtipcodigo) {
		this.vchtipcodigo = vchtipcodigo;
	}

	 public java.lang.String getVchtipdescripcion() {
		return vchtipdescripcion;
	}

	public void setVchtipdescripcion(java.lang.String vchtipdescripcion) {
		this.vchtipdescripcion = vchtipdescripcion;
	}

	 public java.lang.String getVchtipdesadicional() {
		return vchtipdesadicional;
	}

	public void setVchtipdesadicional(java.lang.String vchtipdesadicional) {
		this.vchtipdesadicional = vchtipdesadicional;
	}

	 public java.lang.String getEstadoauditoria() {
		return estadoauditoria;
	}

	public void setEstadoauditoria(java.lang.String estadoauditoria) {
		this.estadoauditoria = estadoauditoria;
	}

	 public Boolean getBooleanestadoauditoria() {
		return booleanestadoauditoria;
	}

	public void setBooleanestadoauditoria(Boolean booleanestadoauditoria) {
		this.booleanestadoauditoria = booleanestadoauditoria;
	}

	 public java.lang.String getUsuariocreacionauditoria() {
		return usuariocreacionauditoria;
	}

	public void setUsuariocreacionauditoria(java.lang.String usuariocreacionauditoria) {
		this.usuariocreacionauditoria = usuariocreacionauditoria;
	}

	 public java.lang.String getUsuariomodificacionauditoria() {
		return usuariomodificacionauditoria;
	}

	public void setUsuariomodificacionauditoria(java.lang.String usuariomodificacionauditoria) {
		this.usuariomodificacionauditoria = usuariomodificacionauditoria;
	}

	 public java.util.Date getFechacreacionauditoria() {
		return fechacreacionauditoria;
	}

	public void setFechacreacionauditoria(java.util.Date fechacreacionauditoria) {
		this.fechacreacionauditoria = fechacreacionauditoria;
	}

	 public java.util.Date getFechacreacionauditoriaini() {
		return fechacreacionauditoriaini;
	}

	public void setFechacreacionauditoriaini(java.util.Date fechacreacionauditoriaini) {
		this.fechacreacionauditoriaini = fechacreacionauditoriaini;
	}

	 public java.util.Date getFechacreacionauditoriafin() {
		return fechacreacionauditoriafin;
	}

	public void setFechacreacionauditoriafin(java.util.Date fechacreacionauditoriafin) {
		this.fechacreacionauditoriafin = fechacreacionauditoriafin;
	}

	 public java.util.Date getFechamodificacionauditoria() {
		return fechamodificacionauditoria;
	}

	public void setFechamodificacionauditoria(java.util.Date fechamodificacionauditoria) {
		this.fechamodificacionauditoria = fechamodificacionauditoria;
	}

	 public java.util.Date getFechamodificacionauditoriaini() {
		return fechamodificacionauditoriaini;
	}

	public void setFechamodificacionauditoriaini(java.util.Date fechamodificacionauditoriaini) {
		this.fechamodificacionauditoriaini = fechamodificacionauditoriaini;
	}

	 public java.util.Date getFechamodificacionauditoriafin() {
		return fechamodificacionauditoriafin;
	}

	public void setFechamodificacionauditoriafin(java.util.Date fechamodificacionauditoriafin) {
		this.fechamodificacionauditoriafin = fechamodificacionauditoriafin;
	}

	 public java.lang.String getEquipoauditoria() {
		return equipoauditoria;
	}

	public void setEquipoauditoria(java.lang.String equipoauditoria) {
		this.equipoauditoria = equipoauditoria;
	}

	 public java.lang.String getProgramaauditoria() {
		return programaauditoria;
	}

	public void setProgramaauditoria(java.lang.String programaauditoria) {
		this.programaauditoria = programaauditoria;
	}

	 public java.lang.Integer getIntganempid() {
		return intganempid;
	}

	public void setIntganempid(java.lang.Integer intganempid) {
		this.intganempid = intganempid;
	}

	 public List<Gentabla> getListaGentabla() {
		return listaGentabla;
	}

	public void setListaGentabla(List<Gentabla> listaGentabla) {
		this.listaGentabla = listaGentabla;
	}

}
