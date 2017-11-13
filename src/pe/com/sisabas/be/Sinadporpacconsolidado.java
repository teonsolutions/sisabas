
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Sinad Por Pac Consolidado]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Sinadporpacconsolidado extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idsinad;
	/**[Pac Consolid In]*/
	private java.lang.Integer idpacconsolidado;
	private Pacconsolidado pacconsolidadoIdpacconsolidado;
	/**[Numero Sinad]*/
	private java.lang.Integer numerosinad;
	/**[Número Expediente]*/
	private java.lang.String numeroexpediente;
	/**[Año Expediente]*/
	private java.lang.Integer anioexpediente;
	/**[Código Sede Expediente]*/
	private java.lang.Integer codigosedeexpediente;
	/**[Descripción Tipo Documento]*/
	private java.lang.String descripciontipodocumento;
	/**[Descripción Oficina Expediente]*/
	private java.lang.String descripcionoficinaexpediente;
	/**[Número de Documento]*/
	private java.lang.String numerodocumento;
	/**[Principal][boolean]*/
	private java.lang.String esprincipal;
	private Boolean booleanesprincipal;
	/**[Nuevo Asignado][boolean]*/
	private java.lang.String esnuevoasignado;
	private Boolean booleanesnuevoasignado;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario de Creación]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][IP/Nombre Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa/Clase]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Sinadporpacconsolidado() {}

	public Sinadporpacconsolidado(java.lang.Integer idsinad) {
		this.idsinad=idsinad;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Sinadporpacconsolidado)
			return ((Sinadporpacconsolidado)obj).getIdsinad().equals(this.getIdsinad()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idsinad!=null)?("idsinad:\t" + this.idsinad+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.numerosinad!=null)?("numerosinad:\t" + this.numerosinad+"\n"):"" ).concat(
			(this.numeroexpediente!=null)?("numeroexpediente:\t" + this.numeroexpediente+"\n"):"" ).concat(
			(this.anioexpediente!=null)?("anioexpediente:\t" + this.anioexpediente+"\n"):"" ).concat(
			(this.codigosedeexpediente!=null)?("codigosedeexpediente:\t" + this.codigosedeexpediente+"\n"):"" ).concat(
			(this.descripciontipodocumento!=null)?("descripciontipodocumento:\t" + this.descripciontipodocumento+"\n"):"" ).concat(
			(this.descripcionoficinaexpediente!=null)?("descripcionoficinaexpediente:\t" + this.descripcionoficinaexpediente+"\n"):"" ).concat(
			(this.numerodocumento!=null)?("numerodocumento:\t" + this.numerodocumento+"\n"):"" ).concat(
			(this.esprincipal!=null)?("esprincipal:\t" + this.esprincipal+"\n"):"" ).concat(
			(this.esnuevoasignado!=null)?("esnuevoasignado:\t" + this.esnuevoasignado+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idsinad!=null)?("idsinad:\t" + this.idsinad+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.pacconsolidadoIdpacconsolidado!=null)?("pacconsolidadoIdpacconsolidado:\t" + this.pacconsolidadoIdpacconsolidado.toString()+"\n"):"" ).concat(
			(this.numerosinad!=null)?("numerosinad:\t" + this.numerosinad+"\n"):"" ).concat(
			(this.numeroexpediente!=null)?("numeroexpediente:\t" + this.numeroexpediente+"\n"):"" ).concat(
			(this.anioexpediente!=null)?("anioexpediente:\t" + this.anioexpediente+"\n"):"" ).concat(
			(this.codigosedeexpediente!=null)?("codigosedeexpediente:\t" + this.codigosedeexpediente+"\n"):"" ).concat(
			(this.descripciontipodocumento!=null)?("descripciontipodocumento:\t" + this.descripciontipodocumento+"\n"):"" ).concat(
			(this.descripcionoficinaexpediente!=null)?("descripcionoficinaexpediente:\t" + this.descripcionoficinaexpediente+"\n"):"" ).concat(
			(this.numerodocumento!=null)?("numerodocumento:\t" + this.numerodocumento+"\n"):"" ).concat(
			(this.esprincipal!=null)?("esprincipal:\t" + this.esprincipal+"\n"):"" ).concat(
			(this.esnuevoasignado!=null)?("esnuevoasignado:\t" + this.esnuevoasignado+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIdpacconsolidadoInKeys;
	public void addConditionInIdpacconsolidado(List<String> list){
		if(list==null || list.size()==0){
			idpacconsolidado=null;
			listaIdpacconsolidadoInKeys=null;
			return;
		}
		if(list.size()==1){
			idpacconsolidado=Integer.parseInt(list.get(0));
			listaIdpacconsolidadoInKeys=null;
		}else{
			idpacconsolidado=null;
			listaIdpacconsolidadoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdpacconsolidadoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdpacconsolidadoInKeys() {
		return listaIdpacconsolidadoInKeys;
	}


	 public java.lang.Integer getIdsinad() {
		return idsinad;
	}

	public void setIdsinad(java.lang.Integer idsinad) {
		this.idsinad = idsinad;
	}

	 public java.lang.Integer getIdpacconsolidado() {
		return idpacconsolidado;
	}

	public void setIdpacconsolidado(java.lang.Integer idpacconsolidado) {
		this.idpacconsolidado = idpacconsolidado;
	}

	 public Pacconsolidado getPacconsolidadoIdpacconsolidado() {
		return pacconsolidadoIdpacconsolidado;
	}

	public void setPacconsolidadoIdpacconsolidado(Pacconsolidado pacconsolidadoIdpacconsolidado) {
		this.pacconsolidadoIdpacconsolidado = pacconsolidadoIdpacconsolidado;
	}

	 public java.lang.Integer getNumerosinad() {
		return numerosinad;
	}

	public void setNumerosinad(java.lang.Integer numerosinad) {
		this.numerosinad = numerosinad;
	}

	 public java.lang.String getNumeroexpediente() {
		return numeroexpediente;
	}

	public void setNumeroexpediente(java.lang.String numeroexpediente) {
		this.numeroexpediente = numeroexpediente;
	}

	 public java.lang.Integer getAnioexpediente() {
		return anioexpediente;
	}

	public void setAnioexpediente(java.lang.Integer anioexpediente) {
		this.anioexpediente = anioexpediente;
	}

	 public java.lang.Integer getCodigosedeexpediente() {
		return codigosedeexpediente;
	}

	public void setCodigosedeexpediente(java.lang.Integer codigosedeexpediente) {
		this.codigosedeexpediente = codigosedeexpediente;
	}

	 public java.lang.String getDescripciontipodocumento() {
		return descripciontipodocumento;
	}

	public void setDescripciontipodocumento(java.lang.String descripciontipodocumento) {
		this.descripciontipodocumento = descripciontipodocumento;
	}

	 public java.lang.String getDescripcionoficinaexpediente() {
		return descripcionoficinaexpediente;
	}

	public void setDescripcionoficinaexpediente(java.lang.String descripcionoficinaexpediente) {
		this.descripcionoficinaexpediente = descripcionoficinaexpediente;
	}

	 public java.lang.String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(java.lang.String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	 public java.lang.String getEsprincipal() {
		return esprincipal;
	}

	public void setEsprincipal(java.lang.String esprincipal) {
		this.esprincipal = esprincipal;
	}

	 public Boolean getBooleanesprincipal() {
		return booleanesprincipal;
	}

	public void setBooleanesprincipal(Boolean booleanesprincipal) {
		this.booleanesprincipal = booleanesprincipal;
	}

	 public java.lang.String getEsnuevoasignado() {
		return esnuevoasignado;
	}

	public void setEsnuevoasignado(java.lang.String esnuevoasignado) {
		this.esnuevoasignado = esnuevoasignado;
	}

	 public Boolean getBooleanesnuevoasignado() {
		return booleanesnuevoasignado;
	}

	public void setBooleanesnuevoasignado(Boolean booleanesnuevoasignado) {
		this.booleanesnuevoasignado = booleanesnuevoasignado;
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
