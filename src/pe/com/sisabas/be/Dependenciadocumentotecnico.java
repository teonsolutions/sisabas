
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Ubigeo Documento Técnico]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Dependenciadocumentotecnico extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer iddependenciadocumentotecnico;
	/**[Documento Técnico]*/
	private java.lang.Integer iddocumentotecnico;
	private Documentotecnico documentotecnicoIddocumentotecnico;
	/**[Dirección]*/
	private java.lang.String direccion;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario de Creación]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha de Modificación]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario de Modificación]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Dependenciadocumentotecnico() {}

	public Dependenciadocumentotecnico(java.lang.Integer iddependenciadocumentotecnico) {
		this.iddependenciadocumentotecnico=iddependenciadocumentotecnico;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Dependenciadocumentotecnico)
			return ((Dependenciadocumentotecnico)obj).getIddependenciadocumentotecnico().equals(this.getIddependenciadocumentotecnico()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.iddependenciadocumentotecnico!=null)?("iddependenciadocumentotecnico:\t" + this.iddependenciadocumentotecnico+"\n"):"" ).concat(
			(this.iddocumentotecnico!=null)?("iddocumentotecnico:\t" + this.iddocumentotecnico+"\n"):"" ).concat(
			(this.direccion!=null)?("direccion:\t" + this.direccion+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.iddependenciadocumentotecnico!=null)?("iddependenciadocumentotecnico:\t" + this.iddependenciadocumentotecnico+"\n"):"" ).concat(
			(this.iddocumentotecnico!=null)?("iddocumentotecnico:\t" + this.iddocumentotecnico+"\n"):"" ).concat(
			(this.documentotecnicoIddocumentotecnico!=null)?("documentotecnicoIddocumentotecnico:\t" + this.documentotecnicoIddocumentotecnico.toString()+"\n"):"" ).concat(
			(this.direccion!=null)?("direccion:\t" + this.direccion+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
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


	 public java.lang.Integer getIddependenciadocumentotecnico() {
		return iddependenciadocumentotecnico;
	}

	public void setIddependenciadocumentotecnico(java.lang.Integer iddependenciadocumentotecnico) {
		this.iddependenciadocumentotecnico = iddependenciadocumentotecnico;
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

	 public java.lang.String getDireccion() {
		return direccion;
	}

	public void setDireccion(java.lang.String direccion) {
		this.direccion = direccion;
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

	 public java.lang.String getEstadoauditoria() {
		return estadoauditoria;
	}

	public void setEstadoauditoria(java.lang.String estadoauditoria) {
		this.estadoauditoria = estadoauditoria;
	}

}
