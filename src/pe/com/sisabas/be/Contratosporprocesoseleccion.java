
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[ContratosPorProcesoSeleccion]
*@author Gandalf
*@since 30/01/2018
*@version gandalf 4.0*/
public class Contratosporprocesoseleccion extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[Id]*/
	private java.lang.Integer idcontratoporproceso;
	/**[Proceso Selección]*/
	private java.lang.Integer idprocesoseleccion;
	private Procesoseleccion procesoseleccionIdprocesoseleccion;
	/**[Contrato]*/
	private java.lang.Integer idcontrato;
	private Contrato contratoIdcontrato;
	/**[*][FechaCreacionAuditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][UsuarioCreacionAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][FechaModificaciónAuditoria]*/
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

	public Contratosporprocesoseleccion() {}

	public Contratosporprocesoseleccion(java.lang.Integer idcontratoporproceso) {
		this.idcontratoporproceso=idcontratoporproceso;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Contratosporprocesoseleccion)
			return ((Contratosporprocesoseleccion)obj).getIdcontratoporproceso().equals(this.getIdcontratoporproceso()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idcontratoporproceso!=null)?("idcontratoporproceso:\t" + this.idcontratoporproceso+"\n"):"" ).concat(
			(this.idprocesoseleccion!=null)?("idprocesoseleccion:\t" + this.idprocesoseleccion+"\n"):"" ).concat(
			(this.idcontrato!=null)?("idcontrato:\t" + this.idcontrato+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idcontratoporproceso!=null)?("idcontratoporproceso:\t" + this.idcontratoporproceso+"\n"):"" ).concat(
			(this.idprocesoseleccion!=null)?("idprocesoseleccion:\t" + this.idprocesoseleccion+"\n"):"" ).concat(
			(this.procesoseleccionIdprocesoseleccion!=null)?("procesoseleccionIdprocesoseleccion:\t" + this.procesoseleccionIdprocesoseleccion.toString()+"\n"):"" ).concat(
			(this.idcontrato!=null)?("idcontrato:\t" + this.idcontrato+"\n"):"" ).concat(
			(this.contratoIdcontrato!=null)?("contratoIdcontrato:\t" + this.contratoIdcontrato.toString()+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIdprocesoseleccionInKeys;
	public void addConditionInIdprocesoseleccion(List<String> list){
		if(list==null || list.size()==0){
			idprocesoseleccion=null;
			listaIdprocesoseleccionInKeys=null;
			return;
		}
		if(list.size()==1){
			idprocesoseleccion=Integer.parseInt(list.get(0));
			listaIdprocesoseleccionInKeys=null;
		}else{
			idprocesoseleccion=null;
			listaIdprocesoseleccionInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdprocesoseleccionInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdprocesoseleccionInKeys() {
		return listaIdprocesoseleccionInKeys;
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


	 public java.lang.Integer getIdcontratoporproceso() {
		return idcontratoporproceso;
	}

	public void setIdcontratoporproceso(java.lang.Integer idcontratoporproceso) {
		this.idcontratoporproceso = idcontratoporproceso;
	}

	 public java.lang.Integer getIdprocesoseleccion() {
		return idprocesoseleccion;
	}

	public void setIdprocesoseleccion(java.lang.Integer idprocesoseleccion) {
		this.idprocesoseleccion = idprocesoseleccion;
	}

	 public Procesoseleccion getProcesoseleccionIdprocesoseleccion() {
		return procesoseleccionIdprocesoseleccion;
	}

	public void setProcesoseleccionIdprocesoseleccion(Procesoseleccion procesoseleccionIdprocesoseleccion) {
		this.procesoseleccionIdprocesoseleccion = procesoseleccionIdprocesoseleccion;
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
