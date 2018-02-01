
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Adenda]
*@author Gandalf
*@since 30/01/2018
*@version gandalf 4.0*/
public class Adenda extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idadenda;
	/**[Contrato]*/
	private java.lang.Integer idcontrato;
	private Contrato contratoIdcontrato;
	/**[Número Adenda]*/
	private java.lang.Integer nroadenda;
	/**[Motivo Adenda]*/
	private java.lang.String motivoadenda;
	/**[Monto Adenda]*/
	private java.math.BigDecimal montoadenda;
	private java.math.BigDecimal montoadendaini;
	private java.math.BigDecimal montoadendafin;
	/**[Fecha Inicio Adenda]*/
	private java.util.Date fechainicioadenda;
	private java.util.Date fechainicioadendaini;
	private java.util.Date fechainicioadendafin;
	/**[Fecha Fin Adenda]*/
	private java.util.Date fechafinadenda;
	private java.util.Date fechafinadendaini;
	private java.util.Date fechafinadendafin;
	/**[Estado Adenda]*/
	private java.lang.Integer estadoadenda;
	/**[Ruta Adenda]*/
	private java.lang.String rutaadenda;
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
	/**[*][UsuarioModificaciónAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][EquipoAuditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Adenda() {}

	public Adenda(java.lang.Integer idadenda) {
		this.idadenda=idadenda;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Adenda)
			return ((Adenda)obj).getIdadenda().equals(this.getIdadenda()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idadenda!=null)?("idadenda:\t" + this.idadenda+"\n"):"" ).concat(
			(this.idcontrato!=null)?("idcontrato:\t" + this.idcontrato+"\n"):"" ).concat(
			(this.nroadenda!=null)?("nroadenda:\t" + this.nroadenda+"\n"):"" ).concat(
			(this.motivoadenda!=null)?("motivoadenda:\t" + this.motivoadenda+"\n"):"" ).concat(
			(this.montoadenda!=null)?("montoadenda:\t" + this.montoadenda+"\n"):"" ).concat(
			(this.fechainicioadenda!=null)?("fechainicioadenda:\t" + this.fechainicioadenda+"\n"):"" ).concat(
			(this.fechafinadenda!=null)?("fechafinadenda:\t" + this.fechafinadenda+"\n"):"" ).concat(
			(this.estadoadenda!=null)?("estadoadenda:\t" + this.estadoadenda+"\n"):"" ).concat(
			(this.rutaadenda!=null)?("rutaadenda:\t" + this.rutaadenda+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idadenda!=null)?("idadenda:\t" + this.idadenda+"\n"):"" ).concat(
			(this.idcontrato!=null)?("idcontrato:\t" + this.idcontrato+"\n"):"" ).concat(
			(this.contratoIdcontrato!=null)?("contratoIdcontrato:\t" + this.contratoIdcontrato.toString()+"\n"):"" ).concat(
			(this.nroadenda!=null)?("nroadenda:\t" + this.nroadenda+"\n"):"" ).concat(
			(this.motivoadenda!=null)?("motivoadenda:\t" + this.motivoadenda+"\n"):"" ).concat(
			(this.montoadenda!=null)?("montoadenda:\t" + this.montoadenda+"\n"):"" ).concat(
			(this.fechainicioadenda!=null)?("fechainicioadenda:\t" + this.fechainicioadenda+"\n"):"" ).concat(
			(this.fechafinadenda!=null)?("fechafinadenda:\t" + this.fechafinadenda+"\n"):"" ).concat(
			(this.estadoadenda!=null)?("estadoadenda:\t" + this.estadoadenda+"\n"):"" ).concat(
			(this.rutaadenda!=null)?("rutaadenda:\t" + this.rutaadenda+"\n"):"" ).concat(
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
		if(this.montoadenda!=null)
			montoadenda=Utils.round(montoadenda);

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


	 public java.lang.Integer getIdadenda() {
		return idadenda;
	}

	public void setIdadenda(java.lang.Integer idadenda) {
		this.idadenda = idadenda;
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

	 public java.lang.Integer getNroadenda() {
		return nroadenda;
	}

	public void setNroadenda(java.lang.Integer nroadenda) {
		this.nroadenda = nroadenda;
	}

	 public java.lang.String getMotivoadenda() {
		return motivoadenda;
	}

	public void setMotivoadenda(java.lang.String motivoadenda) {
		this.motivoadenda = motivoadenda;
	}

	 public java.math.BigDecimal getMontoadenda() {
		return montoadenda;
	}

	public void setMontoadenda(java.math.BigDecimal montoadenda) {
		this.montoadenda = montoadenda;
	}

	 public java.math.BigDecimal getMontoadendaini() {
		return montoadendaini;
	}

	public void setMontoadendaini(java.math.BigDecimal montoadendaini) {
		this.montoadendaini = montoadendaini;
	}

	 public java.math.BigDecimal getMontoadendafin() {
		return montoadendafin;
	}

	public void setMontoadendafin(java.math.BigDecimal montoadendafin) {
		this.montoadendafin = montoadendafin;
	}

	 public java.util.Date getFechainicioadenda() {
		return fechainicioadenda;
	}

	public void setFechainicioadenda(java.util.Date fechainicioadenda) {
		this.fechainicioadenda = fechainicioadenda;
	}

	 public java.util.Date getFechainicioadendaini() {
		return fechainicioadendaini;
	}

	public void setFechainicioadendaini(java.util.Date fechainicioadendaini) {
		this.fechainicioadendaini = fechainicioadendaini;
	}

	 public java.util.Date getFechainicioadendafin() {
		return fechainicioadendafin;
	}

	public void setFechainicioadendafin(java.util.Date fechainicioadendafin) {
		this.fechainicioadendafin = fechainicioadendafin;
	}

	 public java.util.Date getFechafinadenda() {
		return fechafinadenda;
	}

	public void setFechafinadenda(java.util.Date fechafinadenda) {
		this.fechafinadenda = fechafinadenda;
	}

	 public java.util.Date getFechafinadendaini() {
		return fechafinadendaini;
	}

	public void setFechafinadendaini(java.util.Date fechafinadendaini) {
		this.fechafinadendaini = fechafinadendaini;
	}

	 public java.util.Date getFechafinadendafin() {
		return fechafinadendafin;
	}

	public void setFechafinadendafin(java.util.Date fechafinadendafin) {
		this.fechafinadendafin = fechafinadendafin;
	}

	 public java.lang.Integer getEstadoadenda() {
		return estadoadenda;
	}

	public void setEstadoadenda(java.lang.Integer estadoadenda) {
		this.estadoadenda = estadoadenda;
	}

	 public java.lang.String getRutaadenda() {
		return rutaadenda;
	}

	public void setRutaadenda(java.lang.String rutaadenda) {
		this.rutaadenda = rutaadenda;
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
