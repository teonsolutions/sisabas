
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[ResultadoProcesoPorUsuario]
*@author Gandalf
*@since 30/01/2018
*@version gandalf 4.0*/
public class Resultadoprocesoporusuario extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idresultadoprocesousuario;
	/**[Resultado Proceso]*/
	private java.lang.Integer idresultadoproceso;
	private Resultadoprocesoseleccion resultadoprocesoseleccionIdresultadoproceso;
	/**[Número de Item]*/
	private java.lang.String nroitem;
	/**[NombreItem]*/
	private java.lang.String nombreitem;
	/**[Usuario Asignado]*/
	private java.lang.String usuarioasignado;
	/**[Numero Documento]*/
	private java.lang.String numerodocumento;
	/**[Numero Adj Simplificada]*/
	private java.lang.String numeroadjsimplificada;
	/**[Es activo]*/
	private java.lang.String esactivo;
	/**[Es Procesado]*/
	private java.lang.String esprocesado;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario de Creación]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha de última modificación]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario de última modificación]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][IP/Nombre Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa/Clase]*/
	private java.lang.String programaauditoria;
	/**[*][Estado Auditoria]*/
	private java.lang.String estadoauditoria;

	public Resultadoprocesoporusuario() {}

	public Resultadoprocesoporusuario(java.lang.Integer idresultadoprocesousuario) {
		this.idresultadoprocesousuario=idresultadoprocesousuario;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Resultadoprocesoporusuario)
			return ((Resultadoprocesoporusuario)obj).getIdresultadoprocesousuario().equals(this.getIdresultadoprocesousuario()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idresultadoprocesousuario!=null)?("idresultadoprocesousuario:\t" + this.idresultadoprocesousuario+"\n"):"" ).concat(
			(this.idresultadoproceso!=null)?("idresultadoproceso:\t" + this.idresultadoproceso+"\n"):"" ).concat(
			(this.nroitem!=null)?("nroitem:\t" + this.nroitem+"\n"):"" ).concat(
			(this.nombreitem!=null)?("nombreitem:\t" + this.nombreitem+"\n"):"" ).concat(
			(this.usuarioasignado!=null)?("usuarioasignado:\t" + this.usuarioasignado+"\n"):"" ).concat(
			(this.numerodocumento!=null)?("numerodocumento:\t" + this.numerodocumento+"\n"):"" ).concat(
			(this.numeroadjsimplificada!=null)?("numeroadjsimplificada:\t" + this.numeroadjsimplificada+"\n"):"" ).concat(
			(this.esactivo!=null)?("esactivo:\t" + this.esactivo+"\n"):"" ).concat(
			(this.esprocesado!=null)?("esprocesado:\t" + this.esprocesado+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idresultadoprocesousuario!=null)?("idresultadoprocesousuario:\t" + this.idresultadoprocesousuario+"\n"):"" ).concat(
			(this.idresultadoproceso!=null)?("idresultadoproceso:\t" + this.idresultadoproceso+"\n"):"" ).concat(
			(this.resultadoprocesoseleccionIdresultadoproceso!=null)?("resultadoprocesoseleccionIdresultadoproceso:\t" + this.resultadoprocesoseleccionIdresultadoproceso.toString()+"\n"):"" ).concat(
			(this.nroitem!=null)?("nroitem:\t" + this.nroitem+"\n"):"" ).concat(
			(this.nombreitem!=null)?("nombreitem:\t" + this.nombreitem+"\n"):"" ).concat(
			(this.usuarioasignado!=null)?("usuarioasignado:\t" + this.usuarioasignado+"\n"):"" ).concat(
			(this.numerodocumento!=null)?("numerodocumento:\t" + this.numerodocumento+"\n"):"" ).concat(
			(this.numeroadjsimplificada!=null)?("numeroadjsimplificada:\t" + this.numeroadjsimplificada+"\n"):"" ).concat(
			(this.esactivo!=null)?("esactivo:\t" + this.esactivo+"\n"):"" ).concat(
			(this.esprocesado!=null)?("esprocesado:\t" + this.esprocesado+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public static final boolean HAVE_BIGDECIMALS=false;
	public void roundBigDecimals(){

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.Integer> listaIdresultadoprocesoInKeys;
	public void addConditionInIdresultadoproceso(List<String> list){
		if(list==null || list.size()==0){
			idresultadoproceso=null;
			listaIdresultadoprocesoInKeys=null;
			return;
		}
		if(list.size()==1){
			idresultadoproceso=Integer.parseInt(list.get(0));
			listaIdresultadoprocesoInKeys=null;
		}else{
			idresultadoproceso=null;
			listaIdresultadoprocesoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdresultadoprocesoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdresultadoprocesoInKeys() {
		return listaIdresultadoprocesoInKeys;
	}


	 public java.lang.Integer getIdresultadoprocesousuario() {
		return idresultadoprocesousuario;
	}

	public void setIdresultadoprocesousuario(java.lang.Integer idresultadoprocesousuario) {
		this.idresultadoprocesousuario = idresultadoprocesousuario;
	}

	 public java.lang.Integer getIdresultadoproceso() {
		return idresultadoproceso;
	}

	public void setIdresultadoproceso(java.lang.Integer idresultadoproceso) {
		this.idresultadoproceso = idresultadoproceso;
	}

	 public Resultadoprocesoseleccion getResultadoprocesoseleccionIdresultadoproceso() {
		return resultadoprocesoseleccionIdresultadoproceso;
	}

	public void setResultadoprocesoseleccionIdresultadoproceso(Resultadoprocesoseleccion resultadoprocesoseleccionIdresultadoproceso) {
		this.resultadoprocesoseleccionIdresultadoproceso = resultadoprocesoseleccionIdresultadoproceso;
	}

	 public java.lang.String getNroitem() {
		return nroitem;
	}

	public void setNroitem(java.lang.String nroitem) {
		this.nroitem = nroitem;
	}

	 public java.lang.String getNombreitem() {
		return nombreitem;
	}

	public void setNombreitem(java.lang.String nombreitem) {
		this.nombreitem = nombreitem;
	}

	 public java.lang.String getUsuarioasignado() {
		return usuarioasignado;
	}

	public void setUsuarioasignado(java.lang.String usuarioasignado) {
		this.usuarioasignado = usuarioasignado;
	}

	 public java.lang.String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(java.lang.String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	 public java.lang.String getNumeroadjsimplificada() {
		return numeroadjsimplificada;
	}

	public void setNumeroadjsimplificada(java.lang.String numeroadjsimplificada) {
		this.numeroadjsimplificada = numeroadjsimplificada;
	}

	 public java.lang.String getEsactivo() {
		return esactivo;
	}

	public void setEsactivo(java.lang.String esactivo) {
		this.esactivo = esactivo;
	}

	 public java.lang.String getEsprocesado() {
		return esprocesado;
	}

	public void setEsprocesado(java.lang.String esprocesado) {
		this.esprocesado = esprocesado;
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

	 public java.lang.String getUsuariocreacionauditoria() {
		return usuariocreacionauditoria;
	}

	public void setUsuariocreacionauditoria(java.lang.String usuariocreacionauditoria) {
		this.usuariocreacionauditoria = usuariocreacionauditoria;
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

	 public java.lang.String getUsuariomodificacionauditoria() {
		return usuariomodificacionauditoria;
	}

	public void setUsuariomodificacionauditoria(java.lang.String usuariomodificacionauditoria) {
		this.usuariomodificacionauditoria = usuariomodificacionauditoria;
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

	 public java.lang.String getEstadoauditoria() {
		return estadoauditoria;
	}

	public void setEstadoauditoria(java.lang.String estadoauditoria) {
		this.estadoauditoria = estadoauditoria;
	}

}
