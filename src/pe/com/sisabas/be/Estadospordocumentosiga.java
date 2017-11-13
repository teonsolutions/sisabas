
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Estados por documento Siga]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Estadospordocumentosiga extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idestadospordocumentosiga;
	/**[Tipo de documento Siga]*/
	private java.lang.String idcatalogotipodocumentosiga;
	private Gentabla gentablaIdcatalogotipodocumentosiga;
	/**[Código de Estado por Documento Siga]*/
	private java.lang.String codigoestadopordocumentosiga;
	/**[Descripción de estados por documento Siga]*/
	private java.lang.String descripcionestadospordocumentosiga;
	/**[Tipo de proceso]*/
	private java.lang.String codigotipoproceso;
	/**[*][FechaCreaciónAuditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][UsuarioCreaciónAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][FechaModificaciónAuditoria]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][UsuarioModificaciónAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][EquipoAuditoría]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoría]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Estadospordocumentosiga() {}

	public Estadospordocumentosiga(java.lang.Integer idestadospordocumentosiga) {
		this.idestadospordocumentosiga=idestadospordocumentosiga;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Estadospordocumentosiga)
			return ((Estadospordocumentosiga)obj).getIdestadospordocumentosiga().equals(this.getIdestadospordocumentosiga()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idestadospordocumentosiga!=null)?("idestadospordocumentosiga:\t" + this.idestadospordocumentosiga+"\n"):"" ).concat(
			(this.idcatalogotipodocumentosiga!=null)?("idcatalogotipodocumentosiga:\t" + this.idcatalogotipodocumentosiga+"\n"):"" ).concat(
			(this.codigoestadopordocumentosiga!=null)?("codigoestadopordocumentosiga:\t" + this.codigoestadopordocumentosiga+"\n"):"" ).concat(
			(this.descripcionestadospordocumentosiga!=null)?("descripcionestadospordocumentosiga:\t" + this.descripcionestadospordocumentosiga+"\n"):"" ).concat(
			(this.codigotipoproceso!=null)?("codigotipoproceso:\t" + this.codigotipoproceso+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idestadospordocumentosiga!=null)?("idestadospordocumentosiga:\t" + this.idestadospordocumentosiga+"\n"):"" ).concat(
			(this.idcatalogotipodocumentosiga!=null)?("idcatalogotipodocumentosiga:\t" + this.idcatalogotipodocumentosiga+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipodocumentosiga!=null)?("gentablaIdcatalogotipodocumentosiga:\t" + this.gentablaIdcatalogotipodocumentosiga.toString()+"\n"):"" ).concat(
			(this.codigoestadopordocumentosiga!=null)?("codigoestadopordocumentosiga:\t" + this.codigoestadopordocumentosiga+"\n"):"" ).concat(
			(this.descripcionestadospordocumentosiga!=null)?("descripcionestadospordocumentosiga:\t" + this.descripcionestadospordocumentosiga+"\n"):"" ).concat(
			(this.codigotipoproceso!=null)?("codigotipoproceso:\t" + this.codigotipoproceso+"\n"):"" ).concat(
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

	private List<java.lang.String> listaIdcatalogotipodocumentosigaInKeys;
	public void addConditionInIdcatalogotipodocumentosiga(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipodocumentosiga=null;
			idcatalogotipodocumentosiga=null;
			listaIdcatalogotipodocumentosigaInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipodocumentosiga=list.get(0);
			listaIdcatalogotipodocumentosigaInKeys=null;
		}else{
			idcatalogotipodocumentosiga=null;
			listaIdcatalogotipodocumentosigaInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipodocumentosigaInKeys() {
		return listaIdcatalogotipodocumentosigaInKeys;
	}


	 public java.lang.Integer getIdestadospordocumentosiga() {
		return idestadospordocumentosiga;
	}

	public void setIdestadospordocumentosiga(java.lang.Integer idestadospordocumentosiga) {
		this.idestadospordocumentosiga = idestadospordocumentosiga;
	}

	 public java.lang.String getIdcatalogotipodocumentosiga() {
		return idcatalogotipodocumentosiga;
	}

	public void setIdcatalogotipodocumentosiga(java.lang.String idcatalogotipodocumentosiga) {
		this.idcatalogotipodocumentosiga = idcatalogotipodocumentosiga;
	}

	 public Gentabla getGentablaIdcatalogotipodocumentosiga() {
		return gentablaIdcatalogotipodocumentosiga;
	}

	public void setGentablaIdcatalogotipodocumentosiga(Gentabla gentablaIdcatalogotipodocumentosiga) {
		this.gentablaIdcatalogotipodocumentosiga = gentablaIdcatalogotipodocumentosiga;
	}

	 public java.lang.String getCodigoestadopordocumentosiga() {
		return codigoestadopordocumentosiga;
	}

	public void setCodigoestadopordocumentosiga(java.lang.String codigoestadopordocumentosiga) {
		this.codigoestadopordocumentosiga = codigoestadopordocumentosiga;
	}

	 public java.lang.String getDescripcionestadospordocumentosiga() {
		return descripcionestadospordocumentosiga;
	}

	public void setDescripcionestadospordocumentosiga(java.lang.String descripcionestadospordocumentosiga) {
		this.descripcionestadospordocumentosiga = descripcionestadospordocumentosiga;
	}

	 public java.lang.String getCodigotipoproceso() {
		return codigotipoproceso;
	}

	public void setCodigotipoproceso(java.lang.String codigotipoproceso) {
		this.codigotipoproceso = codigotipoproceso;
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
