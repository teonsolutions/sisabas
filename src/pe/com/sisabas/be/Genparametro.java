
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Parámetro]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Genparametro extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[Código]*/
	private java.lang.String vchparamcodigo;
	/**[Valor]*/
	private java.lang.String vchparamvalor;
	/**[Descripción]*/
	private java.lang.String vchparamdescri;
	/**[Descripción Adicional]*/
	private java.lang.String vchparamdescriadi;
	/**[Grupo][GGPA]*/
	private java.lang.String vchparamgrupo;
	private Gentabla gentablaVchparamgrupo;
	/**[Estado]*/
	private java.lang.String estadoauditoria;
	/**[*][Usuario de Creacion]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Usuario de última modificacion]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Fecha de última modificacion]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][IP/Nombre Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa/Clase]*/
	private java.lang.String programaauditoria;

	public Genparametro() {}

	public Genparametro(java.lang.String vchparamcodigo) {
		this.vchparamcodigo=vchparamcodigo;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Genparametro)
			return ((Genparametro)obj).getVchparamcodigo().equals(this.getVchparamcodigo()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.vchparamcodigo!=null)?("vchparamcodigo:\t" + this.vchparamcodigo+"\n"):"" ).concat(
			(this.vchparamvalor!=null)?("vchparamvalor:\t" + this.vchparamvalor+"\n"):"" ).concat(
			(this.vchparamdescri!=null)?("vchparamdescri:\t" + this.vchparamdescri+"\n"):"" ).concat(
			(this.vchparamdescriadi!=null)?("vchparamdescriadi:\t" + this.vchparamdescriadi+"\n"):"" ).concat(
			(this.vchparamgrupo!=null)?("vchparamgrupo:\t" + this.vchparamgrupo+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.vchparamcodigo!=null)?("vchparamcodigo:\t" + this.vchparamcodigo+"\n"):"" ).concat(
			(this.vchparamvalor!=null)?("vchparamvalor:\t" + this.vchparamvalor+"\n"):"" ).concat(
			(this.vchparamdescri!=null)?("vchparamdescri:\t" + this.vchparamdescri+"\n"):"" ).concat(
			(this.vchparamdescriadi!=null)?("vchparamdescriadi:\t" + this.vchparamdescriadi+"\n"):"" ).concat(
			(this.vchparamgrupo!=null)?("vchparamgrupo:\t" + this.vchparamgrupo+"\n"):"" ).concat(
			(this.gentablaVchparamgrupo!=null)?("gentablaVchparamgrupo:\t" + this.gentablaVchparamgrupo.toString()+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"");
	 }

	public static final boolean HAVE_BIGDECIMALS=false;
	public void roundBigDecimals(){

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.String> listaVchparamgrupoInKeys;
	public void addConditionInVchparamgrupo(List<String> list){
		if(list==null || list.size()==0){
			vchparamgrupo=null;
			vchparamgrupo=null;
			listaVchparamgrupoInKeys=null;
			return;
		}
		if(list.size()==1){
			vchparamgrupo=list.get(0);
			listaVchparamgrupoInKeys=null;
		}else{
			vchparamgrupo=null;
			listaVchparamgrupoInKeys=list;
		}
	}
	 public List<java.lang.String> getListaVchparamgrupoInKeys() {
		return listaVchparamgrupoInKeys;
	}


	 public java.lang.String getVchparamcodigo() {
		return vchparamcodigo;
	}

	public void setVchparamcodigo(java.lang.String vchparamcodigo) {
		this.vchparamcodigo = vchparamcodigo;
	}

	 public java.lang.String getVchparamvalor() {
		return vchparamvalor;
	}

	public void setVchparamvalor(java.lang.String vchparamvalor) {
		this.vchparamvalor = vchparamvalor;
	}

	 public java.lang.String getVchparamdescri() {
		return vchparamdescri;
	}

	public void setVchparamdescri(java.lang.String vchparamdescri) {
		this.vchparamdescri = vchparamdescri;
	}

	 public java.lang.String getVchparamdescriadi() {
		return vchparamdescriadi;
	}

	public void setVchparamdescriadi(java.lang.String vchparamdescriadi) {
		this.vchparamdescriadi = vchparamdescriadi;
	}

	 public java.lang.String getVchparamgrupo() {
		return vchparamgrupo;
	}

	public void setVchparamgrupo(java.lang.String vchparamgrupo) {
		this.vchparamgrupo = vchparamgrupo;
	}

	 public Gentabla getGentablaVchparamgrupo() {
		return gentablaVchparamgrupo;
	}

	public void setGentablaVchparamgrupo(Gentabla gentablaVchparamgrupo) {
		this.gentablaVchparamgrupo = gentablaVchparamgrupo;
	}

	 public java.lang.String getEstadoauditoria() {
		return estadoauditoria;
	}

	public void setEstadoauditoria(java.lang.String estadoauditoria) {
		this.estadoauditoria = estadoauditoria;
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

}
