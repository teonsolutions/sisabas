
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[SeccionesDocumentoTecnico]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Seccionesdocumentotecnico extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idseccionesdocumentotecnico;
	/**[Catálogo de Tipo Documento Técnico]*/
	private java.lang.String idcatalogotipodocumentotecnico;
	private Gentabla gentablaIdcatalogotipodocumentotecnico;
	/**[Catálogo Tipo TDR][TITD]*/
	private java.lang.String idcatalogotipotdr;
	private Gentabla gentablaIdcatalogotipotdr;
	/**[Descripción Sección]*/
	private java.lang.String descripcionseccion;
	/**[*][Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Seccionesdocumentotecnico() {}

	public Seccionesdocumentotecnico(java.lang.Integer idseccionesdocumentotecnico) {
		this.idseccionesdocumentotecnico=idseccionesdocumentotecnico;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Seccionesdocumentotecnico)
			return ((Seccionesdocumentotecnico)obj).getIdseccionesdocumentotecnico().equals(this.getIdseccionesdocumentotecnico()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idseccionesdocumentotecnico!=null)?("idseccionesdocumentotecnico:\t" + this.idseccionesdocumentotecnico+"\n"):"" ).concat(
			(this.idcatalogotipodocumentotecnico!=null)?("idcatalogotipodocumentotecnico:\t" + this.idcatalogotipodocumentotecnico+"\n"):"" ).concat(
			(this.idcatalogotipotdr!=null)?("idcatalogotipotdr:\t" + this.idcatalogotipotdr+"\n"):"" ).concat(
			(this.descripcionseccion!=null)?("descripcionseccion:\t" + this.descripcionseccion+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idseccionesdocumentotecnico!=null)?("idseccionesdocumentotecnico:\t" + this.idseccionesdocumentotecnico+"\n"):"" ).concat(
			(this.idcatalogotipodocumentotecnico!=null)?("idcatalogotipodocumentotecnico:\t" + this.idcatalogotipodocumentotecnico+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipodocumentotecnico!=null)?("gentablaIdcatalogotipodocumentotecnico:\t" + this.gentablaIdcatalogotipodocumentotecnico.toString()+"\n"):"" ).concat(
			(this.idcatalogotipotdr!=null)?("idcatalogotipotdr:\t" + this.idcatalogotipotdr+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipotdr!=null)?("gentablaIdcatalogotipotdr:\t" + this.gentablaIdcatalogotipotdr.toString()+"\n"):"" ).concat(
			(this.descripcionseccion!=null)?("descripcionseccion:\t" + this.descripcionseccion+"\n"):"" ).concat(
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

	private List<java.lang.String> listaIdcatalogotipodocumentotecnicoInKeys;
	public void addConditionInIdcatalogotipodocumentotecnico(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipodocumentotecnico=null;
			idcatalogotipodocumentotecnico=null;
			listaIdcatalogotipodocumentotecnicoInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipodocumentotecnico=list.get(0);
			listaIdcatalogotipodocumentotecnicoInKeys=null;
		}else{
			idcatalogotipodocumentotecnico=null;
			listaIdcatalogotipodocumentotecnicoInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipodocumentotecnicoInKeys() {
		return listaIdcatalogotipodocumentotecnicoInKeys;
	}

	private List<java.lang.String> listaIdcatalogotipotdrInKeys;
	public void addConditionInIdcatalogotipotdr(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipotdr=null;
			idcatalogotipotdr=null;
			listaIdcatalogotipotdrInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipotdr=list.get(0);
			listaIdcatalogotipotdrInKeys=null;
		}else{
			idcatalogotipotdr=null;
			listaIdcatalogotipotdrInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipotdrInKeys() {
		return listaIdcatalogotipotdrInKeys;
	}


	 public java.lang.Integer getIdseccionesdocumentotecnico() {
		return idseccionesdocumentotecnico;
	}

	public void setIdseccionesdocumentotecnico(java.lang.Integer idseccionesdocumentotecnico) {
		this.idseccionesdocumentotecnico = idseccionesdocumentotecnico;
	}

	 public java.lang.String getIdcatalogotipodocumentotecnico() {
		return idcatalogotipodocumentotecnico;
	}

	public void setIdcatalogotipodocumentotecnico(java.lang.String idcatalogotipodocumentotecnico) {
		this.idcatalogotipodocumentotecnico = idcatalogotipodocumentotecnico;
	}

	 public Gentabla getGentablaIdcatalogotipodocumentotecnico() {
		return gentablaIdcatalogotipodocumentotecnico;
	}

	public void setGentablaIdcatalogotipodocumentotecnico(Gentabla gentablaIdcatalogotipodocumentotecnico) {
		this.gentablaIdcatalogotipodocumentotecnico = gentablaIdcatalogotipodocumentotecnico;
	}

	 public java.lang.String getIdcatalogotipotdr() {
		return idcatalogotipotdr;
	}

	public void setIdcatalogotipotdr(java.lang.String idcatalogotipotdr) {
		this.idcatalogotipotdr = idcatalogotipotdr;
	}

	 public Gentabla getGentablaIdcatalogotipotdr() {
		return gentablaIdcatalogotipotdr;
	}

	public void setGentablaIdcatalogotipotdr(Gentabla gentablaIdcatalogotipotdr) {
		this.gentablaIdcatalogotipotdr = gentablaIdcatalogotipotdr;
	}

	 public java.lang.String getDescripcionseccion() {
		return descripcionseccion;
	}

	public void setDescripcionseccion(java.lang.String descripcionseccion) {
		this.descripcionseccion = descripcionseccion;
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
