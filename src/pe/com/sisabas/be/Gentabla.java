
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Tabla General]
*@author Gandalf
*@since 30/10/2017
*@version gandalf 4.0*/
public class Gentabla extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	private java.lang.String orden;
	/**[Código]*/
	private java.lang.String vchregcodigo;
	/**[Descripción]*/
	private java.lang.String vchregdescri;
	/**[Abreviado]*/
	private java.lang.String vchregabreviado;
	/**[Tipo]*/
	private java.lang.String vchtipcodigo;
	private Gentipo gentipoVchtipcodigo;
	/**[Orden]*/
	private java.lang.Integer intregorden;
	/**[Otro 1]*/
	private java.lang.String vchtabotro1;
	/**[Otro 2]*/
	private java.lang.String vchtabotro2;
	/**[Otro 3]*/
	private java.lang.String vchtabotro3;
	/**[Otro 4]*/
	private java.lang.String vchtabotro4;
	/**[Estado][boolean]*/
	private java.lang.String estadoauditoria;
	private Boolean booleanestadoauditoria;
	/**[*][Usuario de Creación]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Usuario de última modificación]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Fecha de última modificación]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][IP/Nombre Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa/Clase]*/
	private java.lang.String programaauditoria;
	/**[intganempid]*/
	private java.lang.Integer intganempid;
	
	
	///////////////////////////////////////////fer/////////////////////////////////////////
	
	public Gentabla() {}
	

	//////////////////////////////////////////////////////////////////////////////////////


	public Gentabla getObjBusqueda(String vchtipcodigo){
		this.vchtipcodigo=vchtipcodigo;
		return this;
	}

	public java.lang.String getOrden() {
		return orden;
	}


	public void setOrden(java.lang.String orden) {
		this.orden = orden;
	}

	public Gentabla(java.lang.String vchregcodigo) {
		this.vchregcodigo=vchregcodigo;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Gentabla)
			return ((Gentabla)obj).getVchregcodigo().equals(this.getVchregcodigo()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.vchregcodigo!=null)?("vchregcodigo:\t" + this.vchregcodigo+"\n"):"" ).concat(
			(this.vchregdescri!=null)?("vchregdescri:\t" + this.vchregdescri+"\n"):"" ).concat(
			(this.vchregabreviado!=null)?("vchregabreviado:\t" + this.vchregabreviado+"\n"):"" ).concat(
			(this.vchtipcodigo!=null)?("vchtipcodigo:\t" + this.vchtipcodigo+"\n"):"" ).concat(
			(this.intregorden!=null)?("intregorden:\t" + this.intregorden+"\n"):"" ).concat(
			(this.vchtabotro1!=null)?("vchtabotro1:\t" + this.vchtabotro1+"\n"):"" ).concat(
			(this.vchtabotro2!=null)?("vchtabotro2:\t" + this.vchtabotro2+"\n"):"" ).concat(
			(this.vchtabotro3!=null)?("vchtabotro3:\t" + this.vchtabotro3+"\n"):"" ).concat(
			(this.vchtabotro4!=null)?("vchtabotro4:\t" + this.vchtabotro4+"\n"):"" ).concat(
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
		 return ((this.vchregcodigo!=null)?("vchregcodigo:\t" + this.vchregcodigo+"\n"):"" ).concat(
			(this.vchregdescri!=null)?("vchregdescri:\t" + this.vchregdescri+"\n"):"" ).concat(
			(this.vchregabreviado!=null)?("vchregabreviado:\t" + this.vchregabreviado+"\n"):"" ).concat(
			(this.vchtipcodigo!=null)?("vchtipcodigo:\t" + this.vchtipcodigo+"\n"):"" ).concat(
			(this.gentipoVchtipcodigo!=null)?("gentipoVchtipcodigo:\t" + this.gentipoVchtipcodigo.toString()+"\n"):"" ).concat(
			(this.intregorden!=null)?("intregorden:\t" + this.intregorden+"\n"):"" ).concat(
			(this.vchtabotro1!=null)?("vchtabotro1:\t" + this.vchtabotro1+"\n"):"" ).concat(
			(this.vchtabotro2!=null)?("vchtabotro2:\t" + this.vchtabotro2+"\n"):"" ).concat(
			(this.vchtabotro3!=null)?("vchtabotro3:\t" + this.vchtabotro3+"\n"):"" ).concat(
			(this.vchtabotro4!=null)?("vchtabotro4:\t" + this.vchtabotro4+"\n"):"" ).concat(
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

	private List<java.lang.String> listaVchtipcodigoInKeys;
	public void addConditionInVchtipcodigo(List<String> list){
		if(list==null || list.size()==0){
			vchtipcodigo=null;
			vchtipcodigo=null;
			listaVchtipcodigoInKeys=null;
			return;
		}
		if(list.size()==1){
			vchtipcodigo=list.get(0);
			listaVchtipcodigoInKeys=null;
		}else{
			vchtipcodigo=null;
			listaVchtipcodigoInKeys=list;
		}
	}
	 public List<java.lang.String> getListaVchtipcodigoInKeys() {
		return listaVchtipcodigoInKeys;
	}


	 public java.lang.String getVchregcodigo() {
		return vchregcodigo;
	}

	public void setVchregcodigo(java.lang.String vchregcodigo) {
		this.vchregcodigo = vchregcodigo;
	}

	 public java.lang.String getVchregdescri() {
		return vchregdescri;
	}

	public void setVchregdescri(java.lang.String vchregdescri) {
		this.vchregdescri = vchregdescri;
	}

	 public java.lang.String getVchregabreviado() {
		return vchregabreviado;
	}

	public void setVchregabreviado(java.lang.String vchregabreviado) {
		this.vchregabreviado = vchregabreviado;
	}

	 public java.lang.String getVchtipcodigo() {
		return vchtipcodigo;
	}

	public void setVchtipcodigo(java.lang.String vchtipcodigo) {
		this.vchtipcodigo = vchtipcodigo;
	}

	 public Gentipo getGentipoVchtipcodigo() {
		return gentipoVchtipcodigo;
	}

	public void setGentipoVchtipcodigo(Gentipo gentipoVchtipcodigo) {
		this.gentipoVchtipcodigo = gentipoVchtipcodigo;
	}

	 public java.lang.Integer getIntregorden() {
		return intregorden;
	}

	public void setIntregorden(java.lang.Integer intregorden) {
		this.intregorden = intregorden;
	}

	 public java.lang.String getVchtabotro1() {
		return vchtabotro1;
	}

	public void setVchtabotro1(java.lang.String vchtabotro1) {
		this.vchtabotro1 = vchtabotro1;
	}

	 public java.lang.String getVchtabotro2() {
		return vchtabotro2;
	}

	public void setVchtabotro2(java.lang.String vchtabotro2) {
		this.vchtabotro2 = vchtabotro2;
	}

	 public java.lang.String getVchtabotro3() {
		return vchtabotro3;
	}

	public void setVchtabotro3(java.lang.String vchtabotro3) {
		this.vchtabotro3 = vchtabotro3;
	}

	 public java.lang.String getVchtabotro4() {
		return vchtabotro4;
	}

	public void setVchtabotro4(java.lang.String vchtabotro4) {
		this.vchtabotro4 = vchtabotro4;
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

}
