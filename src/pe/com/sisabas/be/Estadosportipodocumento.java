
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Estados Por Tipo Documento]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Estadosportipodocumento extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idestadosportipodocumento;
	/**[Estados Por Etapa]*/
	private java.lang.Integer idestadosporetapa;
	private Estadosporetapa estadosporetapaIdestadosporetapa;
	/**[Tipo de Documento]*/
	private java.lang.Integer idtipodocumento;
	private Tipodocumento tipodocumentoIdtipodocumento;
	/**[Estados Por Documento Siga]*/
	private java.lang.Integer idestadospordocumentosiga;
	private Estadospordocumentosiga estadospordocumentosigaIdestadospordocumentosiga;
	/**[*][Fecha de Creación de Auditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario de Creación]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][FechaModificacionAuditoria]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][UsuarioModificacionAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][EquipoAuditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Estadosportipodocumento() {}

	public Estadosportipodocumento(java.lang.Integer idestadosportipodocumento) {
		this.idestadosportipodocumento=idestadosportipodocumento;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Estadosportipodocumento)
			return ((Estadosportipodocumento)obj).getIdestadosportipodocumento().equals(this.getIdestadosportipodocumento()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idestadosportipodocumento!=null)?("idestadosportipodocumento:\t" + this.idestadosportipodocumento+"\n"):"" ).concat(
			(this.idestadosporetapa!=null)?("idestadosporetapa:\t" + this.idestadosporetapa+"\n"):"" ).concat(
			(this.idtipodocumento!=null)?("idtipodocumento:\t" + this.idtipodocumento+"\n"):"" ).concat(
			(this.idestadospordocumentosiga!=null)?("idestadospordocumentosiga:\t" + this.idestadospordocumentosiga+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idestadosportipodocumento!=null)?("idestadosportipodocumento:\t" + this.idestadosportipodocumento+"\n"):"" ).concat(
			(this.idestadosporetapa!=null)?("idestadosporetapa:\t" + this.idestadosporetapa+"\n"):"" ).concat(
			(this.estadosporetapaIdestadosporetapa!=null)?("estadosporetapaIdestadosporetapa:\t" + this.estadosporetapaIdestadosporetapa.toString()+"\n"):"" ).concat(
			(this.idtipodocumento!=null)?("idtipodocumento:\t" + this.idtipodocumento+"\n"):"" ).concat(
			(this.tipodocumentoIdtipodocumento!=null)?("tipodocumentoIdtipodocumento:\t" + this.tipodocumentoIdtipodocumento.toString()+"\n"):"" ).concat(
			(this.idestadospordocumentosiga!=null)?("idestadospordocumentosiga:\t" + this.idestadospordocumentosiga+"\n"):"" ).concat(
			(this.estadospordocumentosigaIdestadospordocumentosiga!=null)?("estadospordocumentosigaIdestadospordocumentosiga:\t" + this.estadospordocumentosigaIdestadospordocumentosiga.toString()+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIdestadosporetapaInKeys;
	public void addConditionInIdestadosporetapa(List<String> list){
		if(list==null || list.size()==0){
			idestadosporetapa=null;
			listaIdestadosporetapaInKeys=null;
			return;
		}
		if(list.size()==1){
			idestadosporetapa=Integer.parseInt(list.get(0));
			listaIdestadosporetapaInKeys=null;
		}else{
			idestadosporetapa=null;
			listaIdestadosporetapaInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdestadosporetapaInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdestadosporetapaInKeys() {
		return listaIdestadosporetapaInKeys;
	}

	private List<java.lang.Integer> listaIdtipodocumentoInKeys;
	public void addConditionInIdtipodocumento(List<String> list){
		if(list==null || list.size()==0){
			idtipodocumento=null;
			listaIdtipodocumentoInKeys=null;
			return;
		}
		if(list.size()==1){
			idtipodocumento=Integer.parseInt(list.get(0));
			listaIdtipodocumentoInKeys=null;
		}else{
			idtipodocumento=null;
			listaIdtipodocumentoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdtipodocumentoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdtipodocumentoInKeys() {
		return listaIdtipodocumentoInKeys;
	}

	private List<java.lang.Integer> listaIdestadospordocumentosigaInKeys;
	public void addConditionInIdestadospordocumentosiga(List<String> list){
		if(list==null || list.size()==0){
			idestadospordocumentosiga=null;
			listaIdestadospordocumentosigaInKeys=null;
			return;
		}
		if(list.size()==1){
			idestadospordocumentosiga=Integer.parseInt(list.get(0));
			listaIdestadospordocumentosigaInKeys=null;
		}else{
			idestadospordocumentosiga=null;
			listaIdestadospordocumentosigaInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdestadospordocumentosigaInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdestadospordocumentosigaInKeys() {
		return listaIdestadospordocumentosigaInKeys;
	}


	 public java.lang.Integer getIdestadosportipodocumento() {
		return idestadosportipodocumento;
	}

	public void setIdestadosportipodocumento(java.lang.Integer idestadosportipodocumento) {
		this.idestadosportipodocumento = idestadosportipodocumento;
	}

	 public java.lang.Integer getIdestadosporetapa() {
		return idestadosporetapa;
	}

	public void setIdestadosporetapa(java.lang.Integer idestadosporetapa) {
		this.idestadosporetapa = idestadosporetapa;
	}

	 public Estadosporetapa getEstadosporetapaIdestadosporetapa() {
		return estadosporetapaIdestadosporetapa;
	}

	public void setEstadosporetapaIdestadosporetapa(Estadosporetapa estadosporetapaIdestadosporetapa) {
		this.estadosporetapaIdestadosporetapa = estadosporetapaIdestadosporetapa;
	}

	 public java.lang.Integer getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(java.lang.Integer idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	 public Tipodocumento getTipodocumentoIdtipodocumento() {
		return tipodocumentoIdtipodocumento;
	}

	public void setTipodocumentoIdtipodocumento(Tipodocumento tipodocumentoIdtipodocumento) {
		this.tipodocumentoIdtipodocumento = tipodocumentoIdtipodocumento;
	}

	 public java.lang.Integer getIdestadospordocumentosiga() {
		return idestadospordocumentosiga;
	}

	public void setIdestadospordocumentosiga(java.lang.Integer idestadospordocumentosiga) {
		this.idestadospordocumentosiga = idestadospordocumentosiga;
	}

	 public Estadospordocumentosiga getEstadospordocumentosigaIdestadospordocumentosiga() {
		return estadospordocumentosigaIdestadospordocumentosiga;
	}

	public void setEstadospordocumentosigaIdestadospordocumentosiga(Estadospordocumentosiga estadospordocumentosigaIdestadospordocumentosiga) {
		this.estadospordocumentosigaIdestadospordocumentosiga = estadospordocumentosigaIdestadospordocumentosiga;
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
