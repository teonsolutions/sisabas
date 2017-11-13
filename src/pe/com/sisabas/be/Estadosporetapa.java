
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Estados Por Etapa][boolean]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Estadosporetapa extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idestadoporetapa;
	/**[Etapa Administrativa]*/
	private java.lang.Integer idetapaadministrativa;
	private Etapagestionadministrativa etapagestionadministrativaIdetapaadministrativa;
	/**[Descripción de estado por etapa]*/
	private java.lang.String descripcionestadoporetapa;
	/**[Estado][boolean]*/
	private java.lang.String estadoauditoria;
	private Boolean booleanestadoauditoria;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][UsuarioCreaciónAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha de Modificación]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][UsuarioModificacionAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][Equipo Auditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa Auditoria]*/
	private java.lang.String programaauditoria;

	public Estadosporetapa() {}

	public Estadosporetapa(java.lang.Integer idestadoporetapa) {
		this.idestadoporetapa=idestadoporetapa;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Estadosporetapa)
			return ((Estadosporetapa)obj).getIdestadoporetapa().equals(this.getIdestadoporetapa()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idestadoporetapa!=null)?("idestadoporetapa:\t" + this.idestadoporetapa+"\n"):"" ).concat(
			(this.idetapaadministrativa!=null)?("idetapaadministrativa:\t" + this.idetapaadministrativa+"\n"):"" ).concat(
			(this.descripcionestadoporetapa!=null)?("descripcionestadoporetapa:\t" + this.descripcionestadoporetapa+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idestadoporetapa!=null)?("idestadoporetapa:\t" + this.idestadoporetapa+"\n"):"" ).concat(
			(this.idetapaadministrativa!=null)?("idetapaadministrativa:\t" + this.idetapaadministrativa+"\n"):"" ).concat(
			(this.etapagestionadministrativaIdetapaadministrativa!=null)?("etapagestionadministrativaIdetapaadministrativa:\t" + this.etapagestionadministrativaIdetapaadministrativa.toString()+"\n"):"" ).concat(
			(this.descripcionestadoporetapa!=null)?("descripcionestadoporetapa:\t" + this.descripcionestadoporetapa+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIdetapaadministrativaInKeys;
	public void addConditionInIdetapaadministrativa(List<String> list){
		if(list==null || list.size()==0){
			idetapaadministrativa=null;
			listaIdetapaadministrativaInKeys=null;
			return;
		}
		if(list.size()==1){
			idetapaadministrativa=Integer.parseInt(list.get(0));
			listaIdetapaadministrativaInKeys=null;
		}else{
			idetapaadministrativa=null;
			listaIdetapaadministrativaInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdetapaadministrativaInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdetapaadministrativaInKeys() {
		return listaIdetapaadministrativaInKeys;
	}


	 public java.lang.Integer getIdestadoporetapa() {
		return idestadoporetapa;
	}

	public void setIdestadoporetapa(java.lang.Integer idestadoporetapa) {
		this.idestadoporetapa = idestadoporetapa;
	}

	 public java.lang.Integer getIdetapaadministrativa() {
		return idetapaadministrativa;
	}

	public void setIdetapaadministrativa(java.lang.Integer idetapaadministrativa) {
		this.idetapaadministrativa = idetapaadministrativa;
	}

	 public Etapagestionadministrativa getEtapagestionadministrativaIdetapaadministrativa() {
		return etapagestionadministrativaIdetapaadministrativa;
	}

	public void setEtapagestionadministrativaIdetapaadministrativa(Etapagestionadministrativa etapagestionadministrativaIdetapaadministrativa) {
		this.etapagestionadministrativaIdetapaadministrativa = etapagestionadministrativaIdetapaadministrativa;
	}

	 public java.lang.String getDescripcionestadoporetapa() {
		return descripcionestadoporetapa;
	}

	public void setDescripcionestadoporetapa(java.lang.String descripcionestadoporetapa) {
		this.descripcionestadoporetapa = descripcionestadoporetapa;
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

}
