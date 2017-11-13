
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[ObservacionesDocumentoTecnico]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Observacionesdocumentotecnico extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idobservacionesdocumentotecnico;
	/**[Documento Técnico]*/
	private java.lang.Integer iddocumentotecnico;
	private Documentotecnico documentotecnicoIddocumentotecnico;
	/**[Secciones Documento Técnico]*/
	private java.lang.Integer idseccionesdocumentotecnico;
	private Seccionesdocumentotecnico seccionesdocumentotecnicoIdseccionesdocumentotecnico;
	/**[Observación]*/
	private java.lang.String observacion;
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
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Observacionesdocumentotecnico() {}

	public Observacionesdocumentotecnico(java.lang.Integer idobservacionesdocumentotecnico) {
		this.idobservacionesdocumentotecnico=idobservacionesdocumentotecnico;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Observacionesdocumentotecnico)
			return ((Observacionesdocumentotecnico)obj).getIdobservacionesdocumentotecnico().equals(this.getIdobservacionesdocumentotecnico()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idobservacionesdocumentotecnico!=null)?("idobservacionesdocumentotecnico:\t" + this.idobservacionesdocumentotecnico+"\n"):"" ).concat(
			(this.iddocumentotecnico!=null)?("iddocumentotecnico:\t" + this.iddocumentotecnico+"\n"):"" ).concat(
			(this.idseccionesdocumentotecnico!=null)?("idseccionesdocumentotecnico:\t" + this.idseccionesdocumentotecnico+"\n"):"" ).concat(
			(this.observacion!=null)?("observacion:\t" + this.observacion+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idobservacionesdocumentotecnico!=null)?("idobservacionesdocumentotecnico:\t" + this.idobservacionesdocumentotecnico+"\n"):"" ).concat(
			(this.iddocumentotecnico!=null)?("iddocumentotecnico:\t" + this.iddocumentotecnico+"\n"):"" ).concat(
			(this.documentotecnicoIddocumentotecnico!=null)?("documentotecnicoIddocumentotecnico:\t" + this.documentotecnicoIddocumentotecnico.toString()+"\n"):"" ).concat(
			(this.idseccionesdocumentotecnico!=null)?("idseccionesdocumentotecnico:\t" + this.idseccionesdocumentotecnico+"\n"):"" ).concat(
			(this.seccionesdocumentotecnicoIdseccionesdocumentotecnico!=null)?("seccionesdocumentotecnicoIdseccionesdocumentotecnico:\t" + this.seccionesdocumentotecnicoIdseccionesdocumentotecnico.toString()+"\n"):"" ).concat(
			(this.observacion!=null)?("observacion:\t" + this.observacion+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIddocumentotecnicoInKeys;
	public void addConditionInIddocumentotecnico(List<String> list){
		if(list==null || list.size()==0){
			iddocumentotecnico=null;
			listaIddocumentotecnicoInKeys=null;
			return;
		}
		if(list.size()==1){
			iddocumentotecnico=Integer.parseInt(list.get(0));
			listaIddocumentotecnicoInKeys=null;
		}else{
			iddocumentotecnico=null;
			listaIddocumentotecnicoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIddocumentotecnicoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIddocumentotecnicoInKeys() {
		return listaIddocumentotecnicoInKeys;
	}

	private List<java.lang.Integer> listaIdseccionesdocumentotecnicoInKeys;
	public void addConditionInIdseccionesdocumentotecnico(List<String> list){
		if(list==null || list.size()==0){
			idseccionesdocumentotecnico=null;
			listaIdseccionesdocumentotecnicoInKeys=null;
			return;
		}
		if(list.size()==1){
			idseccionesdocumentotecnico=Integer.parseInt(list.get(0));
			listaIdseccionesdocumentotecnicoInKeys=null;
		}else{
			idseccionesdocumentotecnico=null;
			listaIdseccionesdocumentotecnicoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdseccionesdocumentotecnicoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdseccionesdocumentotecnicoInKeys() {
		return listaIdseccionesdocumentotecnicoInKeys;
	}


	 public java.lang.Integer getIdobservacionesdocumentotecnico() {
		return idobservacionesdocumentotecnico;
	}

	public void setIdobservacionesdocumentotecnico(java.lang.Integer idobservacionesdocumentotecnico) {
		this.idobservacionesdocumentotecnico = idobservacionesdocumentotecnico;
	}

	 public java.lang.Integer getIddocumentotecnico() {
		return iddocumentotecnico;
	}

	public void setIddocumentotecnico(java.lang.Integer iddocumentotecnico) {
		this.iddocumentotecnico = iddocumentotecnico;
	}

	 public Documentotecnico getDocumentotecnicoIddocumentotecnico() {
		return documentotecnicoIddocumentotecnico;
	}

	public void setDocumentotecnicoIddocumentotecnico(Documentotecnico documentotecnicoIddocumentotecnico) {
		this.documentotecnicoIddocumentotecnico = documentotecnicoIddocumentotecnico;
	}

	 public java.lang.Integer getIdseccionesdocumentotecnico() {
		return idseccionesdocumentotecnico;
	}

	public void setIdseccionesdocumentotecnico(java.lang.Integer idseccionesdocumentotecnico) {
		this.idseccionesdocumentotecnico = idseccionesdocumentotecnico;
	}

	 public Seccionesdocumentotecnico getSeccionesdocumentotecnicoIdseccionesdocumentotecnico() {
		return seccionesdocumentotecnicoIdseccionesdocumentotecnico;
	}

	public void setSeccionesdocumentotecnicoIdseccionesdocumentotecnico(Seccionesdocumentotecnico seccionesdocumentotecnicoIdseccionesdocumentotecnico) {
		this.seccionesdocumentotecnicoIdseccionesdocumentotecnico = seccionesdocumentotecnicoIdseccionesdocumentotecnico;
	}

	 public java.lang.String getObservacion() {
		return observacion;
	}

	public void setObservacion(java.lang.String observacion) {
		this.observacion = observacion;
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
