
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Miembro Comite por Proceso]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Miembrocomiteporproceso extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idmiembrocomiteproceso;
	/**[ComitéProceso]*/
	private java.lang.Integer idcomiteproceso;
	private Comiteproceso comiteprocesoIdcomiteproceso;
	/**[Persona]*/
	private java.lang.Integer idpersona;
	private Persona personaIdpersona;
	/**[TipoMiembro][CAMI]*/
	private java.lang.String idcatalogotipomiembro;
	private Gentabla gentablaIdcatalogotipomiembro;
	/**[Correo]*/
	private java.lang.String correo;
	/**[Teléfono]*/
	private java.lang.String telefono;
	/**[Anexo]*/
	private java.lang.String anexo;
	/**[Celular]*/
	private java.lang.String celular;
	/**[Notificado][boolean]*/
	private java.lang.String esnotificado;
	private Boolean booleanesnotificado;
	/**[Código Oficina Usuaria]*/
	private java.lang.String codigooficinausuaria;
	/**[Nombre Oficina Usuaria]*/
	private java.lang.String nombreoficinausuaria;
	/**[Estado Miembro Comite][EMCO]*/
	private java.lang.String idcatalogoestadomiembrocomite;
	private Gentabla gentablaIdcatalogoestadomiembrocomite;
	/**[Especialista Asignado]*/
	private java.lang.String esespecialistaasignado;
	/**[*][FechaCreacionAuditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][UsuarioCreacionAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][FechaModificacionAuditoria]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][UsuarioModificacionAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][IP/Nombre Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa/Clase]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Miembrocomiteporproceso() {}

	public Miembrocomiteporproceso(java.lang.Integer idmiembrocomiteproceso) {
		this.idmiembrocomiteproceso=idmiembrocomiteproceso;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Miembrocomiteporproceso)
			return ((Miembrocomiteporproceso)obj).getIdmiembrocomiteproceso().equals(this.getIdmiembrocomiteproceso()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idmiembrocomiteproceso!=null)?("idmiembrocomiteproceso:\t" + this.idmiembrocomiteproceso+"\n"):"" ).concat(
			(this.idcomiteproceso!=null)?("idcomiteproceso:\t" + this.idcomiteproceso+"\n"):"" ).concat(
			(this.idpersona!=null)?("idpersona:\t" + this.idpersona+"\n"):"" ).concat(
			(this.idcatalogotipomiembro!=null)?("idcatalogotipomiembro:\t" + this.idcatalogotipomiembro+"\n"):"" ).concat(
			(this.correo!=null)?("correo:\t" + this.correo+"\n"):"" ).concat(
			(this.telefono!=null)?("telefono:\t" + this.telefono+"\n"):"" ).concat(
			(this.anexo!=null)?("anexo:\t" + this.anexo+"\n"):"" ).concat(
			(this.celular!=null)?("celular:\t" + this.celular+"\n"):"" ).concat(
			(this.esnotificado!=null)?("esnotificado:\t" + this.esnotificado+"\n"):"" ).concat(
			(this.codigooficinausuaria!=null)?("codigooficinausuaria:\t" + this.codigooficinausuaria+"\n"):"" ).concat(
			(this.nombreoficinausuaria!=null)?("nombreoficinausuaria:\t" + this.nombreoficinausuaria+"\n"):"" ).concat(
			(this.idcatalogoestadomiembrocomite!=null)?("idcatalogoestadomiembrocomite:\t" + this.idcatalogoestadomiembrocomite+"\n"):"" ).concat(
			(this.esespecialistaasignado!=null)?("esespecialistaasignado:\t" + this.esespecialistaasignado+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idmiembrocomiteproceso!=null)?("idmiembrocomiteproceso:\t" + this.idmiembrocomiteproceso+"\n"):"" ).concat(
			(this.idcomiteproceso!=null)?("idcomiteproceso:\t" + this.idcomiteproceso+"\n"):"" ).concat(
			(this.comiteprocesoIdcomiteproceso!=null)?("comiteprocesoIdcomiteproceso:\t" + this.comiteprocesoIdcomiteproceso.toString()+"\n"):"" ).concat(
			(this.idpersona!=null)?("idpersona:\t" + this.idpersona+"\n"):"" ).concat(
			(this.personaIdpersona!=null)?("personaIdpersona:\t" + this.personaIdpersona.toString()+"\n"):"" ).concat(
			(this.idcatalogotipomiembro!=null)?("idcatalogotipomiembro:\t" + this.idcatalogotipomiembro+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipomiembro!=null)?("gentablaIdcatalogotipomiembro:\t" + this.gentablaIdcatalogotipomiembro.toString()+"\n"):"" ).concat(
			(this.correo!=null)?("correo:\t" + this.correo+"\n"):"" ).concat(
			(this.telefono!=null)?("telefono:\t" + this.telefono+"\n"):"" ).concat(
			(this.anexo!=null)?("anexo:\t" + this.anexo+"\n"):"" ).concat(
			(this.celular!=null)?("celular:\t" + this.celular+"\n"):"" ).concat(
			(this.esnotificado!=null)?("esnotificado:\t" + this.esnotificado+"\n"):"" ).concat(
			(this.codigooficinausuaria!=null)?("codigooficinausuaria:\t" + this.codigooficinausuaria+"\n"):"" ).concat(
			(this.nombreoficinausuaria!=null)?("nombreoficinausuaria:\t" + this.nombreoficinausuaria+"\n"):"" ).concat(
			(this.idcatalogoestadomiembrocomite!=null)?("idcatalogoestadomiembrocomite:\t" + this.idcatalogoestadomiembrocomite+"\n"):"" ).concat(
			(this.gentablaIdcatalogoestadomiembrocomite!=null)?("gentablaIdcatalogoestadomiembrocomite:\t" + this.gentablaIdcatalogoestadomiembrocomite.toString()+"\n"):"" ).concat(
			(this.esespecialistaasignado!=null)?("esespecialistaasignado:\t" + this.esespecialistaasignado+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIdcomiteprocesoInKeys;
	public void addConditionInIdcomiteproceso(List<String> list){
		if(list==null || list.size()==0){
			idcomiteproceso=null;
			listaIdcomiteprocesoInKeys=null;
			return;
		}
		if(list.size()==1){
			idcomiteproceso=Integer.parseInt(list.get(0));
			listaIdcomiteprocesoInKeys=null;
		}else{
			idcomiteproceso=null;
			listaIdcomiteprocesoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdcomiteprocesoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdcomiteprocesoInKeys() {
		return listaIdcomiteprocesoInKeys;
	}

	private List<java.lang.Integer> listaIdpersonaInKeys;
	public void addConditionInIdpersona(List<String> list){
		if(list==null || list.size()==0){
			idpersona=null;
			listaIdpersonaInKeys=null;
			return;
		}
		if(list.size()==1){
			idpersona=Integer.parseInt(list.get(0));
			listaIdpersonaInKeys=null;
		}else{
			idpersona=null;
			listaIdpersonaInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdpersonaInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdpersonaInKeys() {
		return listaIdpersonaInKeys;
	}

	private List<java.lang.String> listaIdcatalogotipomiembroInKeys;
	public void addConditionInIdcatalogotipomiembro(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipomiembro=null;
			idcatalogotipomiembro=null;
			listaIdcatalogotipomiembroInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipomiembro=list.get(0);
			listaIdcatalogotipomiembroInKeys=null;
		}else{
			idcatalogotipomiembro=null;
			listaIdcatalogotipomiembroInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipomiembroInKeys() {
		return listaIdcatalogotipomiembroInKeys;
	}

	private List<java.lang.String> listaIdcatalogoestadomiembrocomiteInKeys;
	public void addConditionInIdcatalogoestadomiembrocomite(List<String> list){
		if(list==null || list.size()==0){
			idcatalogoestadomiembrocomite=null;
			idcatalogoestadomiembrocomite=null;
			listaIdcatalogoestadomiembrocomiteInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogoestadomiembrocomite=list.get(0);
			listaIdcatalogoestadomiembrocomiteInKeys=null;
		}else{
			idcatalogoestadomiembrocomite=null;
			listaIdcatalogoestadomiembrocomiteInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogoestadomiembrocomiteInKeys() {
		return listaIdcatalogoestadomiembrocomiteInKeys;
	}


	 public java.lang.Integer getIdmiembrocomiteproceso() {
		return idmiembrocomiteproceso;
	}

	public void setIdmiembrocomiteproceso(java.lang.Integer idmiembrocomiteproceso) {
		this.idmiembrocomiteproceso = idmiembrocomiteproceso;
	}

	 public java.lang.Integer getIdcomiteproceso() {
		return idcomiteproceso;
	}

	public void setIdcomiteproceso(java.lang.Integer idcomiteproceso) {
		this.idcomiteproceso = idcomiteproceso;
	}

	 public Comiteproceso getComiteprocesoIdcomiteproceso() {
		return comiteprocesoIdcomiteproceso;
	}

	public void setComiteprocesoIdcomiteproceso(Comiteproceso comiteprocesoIdcomiteproceso) {
		this.comiteprocesoIdcomiteproceso = comiteprocesoIdcomiteproceso;
	}

	 public java.lang.Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(java.lang.Integer idpersona) {
		this.idpersona = idpersona;
	}

	 public Persona getPersonaIdpersona() {
		return personaIdpersona;
	}

	public void setPersonaIdpersona(Persona personaIdpersona) {
		this.personaIdpersona = personaIdpersona;
	}

	 public java.lang.String getIdcatalogotipomiembro() {
		return idcatalogotipomiembro;
	}

	public void setIdcatalogotipomiembro(java.lang.String idcatalogotipomiembro) {
		this.idcatalogotipomiembro = idcatalogotipomiembro;
	}

	 public Gentabla getGentablaIdcatalogotipomiembro() {
		return gentablaIdcatalogotipomiembro;
	}

	public void setGentablaIdcatalogotipomiembro(Gentabla gentablaIdcatalogotipomiembro) {
		this.gentablaIdcatalogotipomiembro = gentablaIdcatalogotipomiembro;
	}

	 public java.lang.String getCorreo() {
		return correo;
	}

	public void setCorreo(java.lang.String correo) {
		this.correo = correo;
	}

	 public java.lang.String getTelefono() {
		return telefono;
	}

	public void setTelefono(java.lang.String telefono) {
		this.telefono = telefono;
	}

	 public java.lang.String getAnexo() {
		return anexo;
	}

	public void setAnexo(java.lang.String anexo) {
		this.anexo = anexo;
	}

	 public java.lang.String getCelular() {
		return celular;
	}

	public void setCelular(java.lang.String celular) {
		this.celular = celular;
	}

	 public java.lang.String getEsnotificado() {
		return esnotificado;
	}

	public void setEsnotificado(java.lang.String esnotificado) {
		this.esnotificado = esnotificado;
	}

	 public Boolean getBooleanesnotificado() {
		return booleanesnotificado;
	}

	public void setBooleanesnotificado(Boolean booleanesnotificado) {
		this.booleanesnotificado = booleanesnotificado;
	}

	 public java.lang.String getCodigooficinausuaria() {
		return codigooficinausuaria;
	}

	public void setCodigooficinausuaria(java.lang.String codigooficinausuaria) {
		this.codigooficinausuaria = codigooficinausuaria;
	}

	 public java.lang.String getNombreoficinausuaria() {
		return nombreoficinausuaria;
	}

	public void setNombreoficinausuaria(java.lang.String nombreoficinausuaria) {
		this.nombreoficinausuaria = nombreoficinausuaria;
	}

	 public java.lang.String getIdcatalogoestadomiembrocomite() {
		return idcatalogoestadomiembrocomite;
	}

	public void setIdcatalogoestadomiembrocomite(java.lang.String idcatalogoestadomiembrocomite) {
		this.idcatalogoestadomiembrocomite = idcatalogoestadomiembrocomite;
	}

	 public Gentabla getGentablaIdcatalogoestadomiembrocomite() {
		return gentablaIdcatalogoestadomiembrocomite;
	}

	public void setGentablaIdcatalogoestadomiembrocomite(Gentabla gentablaIdcatalogoestadomiembrocomite) {
		this.gentablaIdcatalogoestadomiembrocomite = gentablaIdcatalogoestadomiembrocomite;
	}

	 public java.lang.String getEsespecialistaasignado() {
		return esespecialistaasignado;
	}

	public void setEsespecialistaasignado(java.lang.String esespecialistaasignado) {
		this.esespecialistaasignado = esespecialistaasignado;
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
