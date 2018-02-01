
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[EvaluacionDocumento]
*@author Gandalf
*@since 30/01/2018
*@version gandalf 4.0*/
public class Evaluaciondocumento extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idevaluaciondocumento;
	/**[Contrato]*/
	private java.lang.Integer idcontrato;
	private Contrato contratoIdcontrato;
	/**[Estado Documentacion]*/
	private java.lang.String idcatalogoestadodocumentacion;
	private Gentabla gentablaIdcatalogoestadodocumentacion;
	/**[*][FechaCreacionAuditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][UsuarioCreaciónAuditoria]*/
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

	public Evaluaciondocumento() {}

	public Evaluaciondocumento(java.lang.Integer idevaluaciondocumento) {
		this.idevaluaciondocumento=idevaluaciondocumento;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Evaluaciondocumento)
			return ((Evaluaciondocumento)obj).getIdevaluaciondocumento().equals(this.getIdevaluaciondocumento()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idevaluaciondocumento!=null)?("idevaluaciondocumento:\t" + this.idevaluaciondocumento+"\n"):"" ).concat(
			(this.idcontrato!=null)?("idcontrato:\t" + this.idcontrato+"\n"):"" ).concat(
			(this.idcatalogoestadodocumentacion!=null)?("idcatalogoestadodocumentacion:\t" + this.idcatalogoestadodocumentacion+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idevaluaciondocumento!=null)?("idevaluaciondocumento:\t" + this.idevaluaciondocumento+"\n"):"" ).concat(
			(this.idcontrato!=null)?("idcontrato:\t" + this.idcontrato+"\n"):"" ).concat(
			(this.contratoIdcontrato!=null)?("contratoIdcontrato:\t" + this.contratoIdcontrato.toString()+"\n"):"" ).concat(
			(this.idcatalogoestadodocumentacion!=null)?("idcatalogoestadodocumentacion:\t" + this.idcatalogoestadodocumentacion+"\n"):"" ).concat(
			(this.gentablaIdcatalogoestadodocumentacion!=null)?("gentablaIdcatalogoestadodocumentacion:\t" + this.gentablaIdcatalogoestadodocumentacion.toString()+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIdcontratoInKeys;
	public void addConditionInIdcontrato(List<String> list){
		if(list==null || list.size()==0){
			idcontrato=null;
			listaIdcontratoInKeys=null;
			return;
		}
		if(list.size()==1){
			idcontrato=Integer.parseInt(list.get(0));
			listaIdcontratoInKeys=null;
		}else{
			idcontrato=null;
			listaIdcontratoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdcontratoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdcontratoInKeys() {
		return listaIdcontratoInKeys;
	}

	private List<java.lang.String> listaIdcatalogoestadodocumentacionInKeys;
	public void addConditionInIdcatalogoestadodocumentacion(List<String> list){
		if(list==null || list.size()==0){
			idcatalogoestadodocumentacion=null;
			idcatalogoestadodocumentacion=null;
			listaIdcatalogoestadodocumentacionInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogoestadodocumentacion=list.get(0);
			listaIdcatalogoestadodocumentacionInKeys=null;
		}else{
			idcatalogoestadodocumentacion=null;
			listaIdcatalogoestadodocumentacionInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogoestadodocumentacionInKeys() {
		return listaIdcatalogoestadodocumentacionInKeys;
	}


	 public java.lang.Integer getIdevaluaciondocumento() {
		return idevaluaciondocumento;
	}

	public void setIdevaluaciondocumento(java.lang.Integer idevaluaciondocumento) {
		this.idevaluaciondocumento = idevaluaciondocumento;
	}

	 public java.lang.Integer getIdcontrato() {
		return idcontrato;
	}

	public void setIdcontrato(java.lang.Integer idcontrato) {
		this.idcontrato = idcontrato;
	}

	 public Contrato getContratoIdcontrato() {
		return contratoIdcontrato;
	}

	public void setContratoIdcontrato(Contrato contratoIdcontrato) {
		this.contratoIdcontrato = contratoIdcontrato;
	}

	 public java.lang.String getIdcatalogoestadodocumentacion() {
		return idcatalogoestadodocumentacion;
	}

	public void setIdcatalogoestadodocumentacion(java.lang.String idcatalogoestadodocumentacion) {
		this.idcatalogoestadodocumentacion = idcatalogoestadodocumentacion;
	}

	 public Gentabla getGentablaIdcatalogoestadodocumentacion() {
		return gentablaIdcatalogoestadodocumentacion;
	}

	public void setGentablaIdcatalogoestadodocumentacion(Gentabla gentablaIdcatalogoestadodocumentacion) {
		this.gentablaIdcatalogoestadodocumentacion = gentablaIdcatalogoestadodocumentacion;
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
