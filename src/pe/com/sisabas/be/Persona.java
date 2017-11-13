
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Persona]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Persona extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idpersona;
	/**[Tipo Documento][TIDO]*/
	private java.lang.String idcatalogotipodocumento;
	private Gentabla gentablaIdcatalogotipodocumento;
	/**[Numero Documento]*/
	private java.lang.String numerodocumento;
	/**[Nombres]*/
	private java.lang.String nombres;
	/**[Apellido Paterno]*/
	private java.lang.String apellidopaterno;
	/**[Apellido Materno]*/
	private java.lang.String apellidomaterno;
	/**[Dirección]*/
	private java.lang.String direccion;
	/**[*][Estado Auditoria]*/
	private java.lang.String estadoauditoria;
	/**[*][UsuarioCreacionAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][UsuarioModificacionAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][FechaCreacionAuditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][FechaModificaciónAuditoria]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][EquipoAuditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;

	public Persona() {}

	public Persona(java.lang.Integer idpersona) {
		this.idpersona=idpersona;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Persona)
			return ((Persona)obj).getIdpersona().equals(this.getIdpersona()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idpersona!=null)?("idpersona:\t" + this.idpersona+"\n"):"" ).concat(
			(this.idcatalogotipodocumento!=null)?("idcatalogotipodocumento:\t" + this.idcatalogotipodocumento+"\n"):"" ).concat(
			(this.numerodocumento!=null)?("numerodocumento:\t" + this.numerodocumento+"\n"):"" ).concat(
			(this.nombres!=null)?("nombres:\t" + this.nombres+"\n"):"" ).concat(
			(this.apellidopaterno!=null)?("apellidopaterno:\t" + this.apellidopaterno+"\n"):"" ).concat(
			(this.apellidomaterno!=null)?("apellidomaterno:\t" + this.apellidomaterno+"\n"):"" ).concat(
			(this.direccion!=null)?("direccion:\t" + this.direccion+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idpersona!=null)?("idpersona:\t" + this.idpersona+"\n"):"" ).concat(
			(this.idcatalogotipodocumento!=null)?("idcatalogotipodocumento:\t" + this.idcatalogotipodocumento+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipodocumento!=null)?("gentablaIdcatalogotipodocumento:\t" + this.gentablaIdcatalogotipodocumento.toString()+"\n"):"" ).concat(
			(this.numerodocumento!=null)?("numerodocumento:\t" + this.numerodocumento+"\n"):"" ).concat(
			(this.nombres!=null)?("nombres:\t" + this.nombres+"\n"):"" ).concat(
			(this.apellidopaterno!=null)?("apellidopaterno:\t" + this.apellidopaterno+"\n"):"" ).concat(
			(this.apellidomaterno!=null)?("apellidomaterno:\t" + this.apellidomaterno+"\n"):"" ).concat(
			(this.direccion!=null)?("direccion:\t" + this.direccion+"\n"):"" ).concat(
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

	private List<java.lang.String> listaIdcatalogotipodocumentoInKeys;
	public void addConditionInIdcatalogotipodocumento(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipodocumento=null;
			idcatalogotipodocumento=null;
			listaIdcatalogotipodocumentoInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipodocumento=list.get(0);
			listaIdcatalogotipodocumentoInKeys=null;
		}else{
			idcatalogotipodocumento=null;
			listaIdcatalogotipodocumentoInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipodocumentoInKeys() {
		return listaIdcatalogotipodocumentoInKeys;
	}


	 public java.lang.Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(java.lang.Integer idpersona) {
		this.idpersona = idpersona;
	}

	 public java.lang.String getIdcatalogotipodocumento() {
		return idcatalogotipodocumento;
	}

	public void setIdcatalogotipodocumento(java.lang.String idcatalogotipodocumento) {
		this.idcatalogotipodocumento = idcatalogotipodocumento;
	}

	 public Gentabla getGentablaIdcatalogotipodocumento() {
		return gentablaIdcatalogotipodocumento;
	}

	public void setGentablaIdcatalogotipodocumento(Gentabla gentablaIdcatalogotipodocumento) {
		this.gentablaIdcatalogotipodocumento = gentablaIdcatalogotipodocumento;
	}

	 public java.lang.String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(java.lang.String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	 public java.lang.String getNombres() {
		return nombres;
	}

	public void setNombres(java.lang.String nombres) {
		this.nombres = nombres;
	}

	 public java.lang.String getApellidopaterno() {
		return apellidopaterno;
	}

	public void setApellidopaterno(java.lang.String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	 public java.lang.String getApellidomaterno() {
		return apellidomaterno;
	}

	public void setApellidomaterno(java.lang.String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	 public java.lang.String getDireccion() {
		return direccion;
	}

	public void setDireccion(java.lang.String direccion) {
		this.direccion = direccion;
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
