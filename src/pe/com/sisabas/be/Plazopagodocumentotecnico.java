
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Plazo Pago Documento Tecnico]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Plazopagodocumentotecnico extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idplazopagodocumentotecnico;
	/**[Documento Técnico]*/
	private java.lang.Integer iddocumentotecnico;
	private Documentotecnico documentotecnicoIddocumentotecnico;
	/**[Cronograma]*/
	private java.lang.String cronograma;
	/**[Plazo]*/
	private java.lang.Integer plazo;
	/**[Nivel Avance]*/
	private java.lang.String nivelavance;
	/**[Porcentaje Avance]*/
	private java.math.BigDecimal porcentajeavance;
	private java.math.BigDecimal porcentajeavanceini;
	private java.math.BigDecimal porcentajeavancefin;
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
	/**[*][EquipoAuditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Plazopagodocumentotecnico() {}

	public Plazopagodocumentotecnico(java.lang.Integer idplazopagodocumentotecnico) {
		this.idplazopagodocumentotecnico=idplazopagodocumentotecnico;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Plazopagodocumentotecnico)
			return ((Plazopagodocumentotecnico)obj).getIdplazopagodocumentotecnico().equals(this.getIdplazopagodocumentotecnico()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idplazopagodocumentotecnico!=null)?("idplazopagodocumentotecnico:\t" + this.idplazopagodocumentotecnico+"\n"):"" ).concat(
			(this.iddocumentotecnico!=null)?("iddocumentotecnico:\t" + this.iddocumentotecnico+"\n"):"" ).concat(
			(this.cronograma!=null)?("cronograma:\t" + this.cronograma+"\n"):"" ).concat(
			(this.plazo!=null)?("plazo:\t" + this.plazo+"\n"):"" ).concat(
			(this.nivelavance!=null)?("nivelavance:\t" + this.nivelavance+"\n"):"" ).concat(
			(this.porcentajeavance!=null)?("porcentajeavance:\t" + this.porcentajeavance+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idplazopagodocumentotecnico!=null)?("idplazopagodocumentotecnico:\t" + this.idplazopagodocumentotecnico+"\n"):"" ).concat(
			(this.iddocumentotecnico!=null)?("iddocumentotecnico:\t" + this.iddocumentotecnico+"\n"):"" ).concat(
			(this.documentotecnicoIddocumentotecnico!=null)?("documentotecnicoIddocumentotecnico:\t" + this.documentotecnicoIddocumentotecnico.toString()+"\n"):"" ).concat(
			(this.cronograma!=null)?("cronograma:\t" + this.cronograma+"\n"):"" ).concat(
			(this.plazo!=null)?("plazo:\t" + this.plazo+"\n"):"" ).concat(
			(this.nivelavance!=null)?("nivelavance:\t" + this.nivelavance+"\n"):"" ).concat(
			(this.porcentajeavance!=null)?("porcentajeavance:\t" + this.porcentajeavance+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public static final boolean HAVE_BIGDECIMALS=true;
	public void roundBigDecimals(){
		if(this.porcentajeavance!=null)
			porcentajeavance=Utils.round(porcentajeavance);

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


	 public java.lang.Integer getIdplazopagodocumentotecnico() {
		return idplazopagodocumentotecnico;
	}

	public void setIdplazopagodocumentotecnico(java.lang.Integer idplazopagodocumentotecnico) {
		this.idplazopagodocumentotecnico = idplazopagodocumentotecnico;
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

	 public java.lang.String getCronograma() {
		return cronograma;
	}

	public void setCronograma(java.lang.String cronograma) {
		this.cronograma = cronograma;
	}

	 public java.lang.Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(java.lang.Integer plazo) {
		this.plazo = plazo;
	}

	 public java.lang.String getNivelavance() {
		return nivelavance;
	}

	public void setNivelavance(java.lang.String nivelavance) {
		this.nivelavance = nivelavance;
	}

	 public java.math.BigDecimal getPorcentajeavance() {
		return porcentajeavance;
	}

	public void setPorcentajeavance(java.math.BigDecimal porcentajeavance) {
		this.porcentajeavance = porcentajeavance;
	}

	 public java.math.BigDecimal getPorcentajeavanceini() {
		return porcentajeavanceini;
	}

	public void setPorcentajeavanceini(java.math.BigDecimal porcentajeavanceini) {
		this.porcentajeavanceini = porcentajeavanceini;
	}

	 public java.math.BigDecimal getPorcentajeavancefin() {
		return porcentajeavancefin;
	}

	public void setPorcentajeavancefin(java.math.BigDecimal porcentajeavancefin) {
		this.porcentajeavancefin = porcentajeavancefin;
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
