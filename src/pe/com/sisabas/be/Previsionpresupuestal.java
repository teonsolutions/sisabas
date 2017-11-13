
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[PrevisionPresupuestal]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Previsionpresupuestal extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idprevisionpresupuestal;
	/**[Pac Consolidado]*/
	private java.lang.Integer idpacconsolidado;
	private Pacconsolidado pacconsolidadoIdpacconsolidado;
	/**[Número de previsión]*/
	private java.lang.String nroprevision;
	/**[Número documento Ppto]*/
	private java.lang.String nrodocumentoppto;
	/**[Número Documento Oga]*/
	private java.lang.String nrodocumentooga;
	/**[Fecha de Autorización]*/
	private java.util.Date fechaautorizacion;
	private java.util.Date fechaautorizacionini;
	private java.util.Date fechaautorizacionfin;
	/**[Anio]*/
	private java.lang.String anio;
	/**[Monto Previsión]*/
	private java.math.BigDecimal montoprevision;
	private java.math.BigDecimal montoprevisionini;
	private java.math.BigDecimal montoprevisionfin;
	/**[Monto Previsión Contrato]*/
	private java.math.BigDecimal montoprevisioncontrato;
	private java.math.BigDecimal montoprevisioncontratoini;
	private java.math.BigDecimal montoprevisioncontratofin;
	/**[Monto de Ampliación]*/
	private java.math.BigDecimal montoampliacion;
	private java.math.BigDecimal montoampliacionini;
	private java.math.BigDecimal montoampliacionfin;
	/**[Monto Anulación]*/
	private java.math.BigDecimal montoanulacion;
	private java.math.BigDecimal montoanulacionini;
	private java.math.BigDecimal montoanulacionfin;
	/**[*][Fecha de Creación de Auditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][UsuarioCreaciónAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha de Modificación]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario de modificación de Auditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][Equipo Auditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa Auditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Previsionpresupuestal() {}

	public Previsionpresupuestal(java.lang.Integer idprevisionpresupuestal) {
		this.idprevisionpresupuestal=idprevisionpresupuestal;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Previsionpresupuestal)
			return ((Previsionpresupuestal)obj).getIdprevisionpresupuestal().equals(this.getIdprevisionpresupuestal()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idprevisionpresupuestal!=null)?("idprevisionpresupuestal:\t" + this.idprevisionpresupuestal+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.nroprevision!=null)?("nroprevision:\t" + this.nroprevision+"\n"):"" ).concat(
			(this.nrodocumentoppto!=null)?("nrodocumentoppto:\t" + this.nrodocumentoppto+"\n"):"" ).concat(
			(this.nrodocumentooga!=null)?("nrodocumentooga:\t" + this.nrodocumentooga+"\n"):"" ).concat(
			(this.fechaautorizacion!=null)?("fechaautorizacion:\t" + this.fechaautorizacion+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.montoprevision!=null)?("montoprevision:\t" + this.montoprevision+"\n"):"" ).concat(
			(this.montoprevisioncontrato!=null)?("montoprevisioncontrato:\t" + this.montoprevisioncontrato+"\n"):"" ).concat(
			(this.montoampliacion!=null)?("montoampliacion:\t" + this.montoampliacion+"\n"):"" ).concat(
			(this.montoanulacion!=null)?("montoanulacion:\t" + this.montoanulacion+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idprevisionpresupuestal!=null)?("idprevisionpresupuestal:\t" + this.idprevisionpresupuestal+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.pacconsolidadoIdpacconsolidado!=null)?("pacconsolidadoIdpacconsolidado:\t" + this.pacconsolidadoIdpacconsolidado.toString()+"\n"):"" ).concat(
			(this.nroprevision!=null)?("nroprevision:\t" + this.nroprevision+"\n"):"" ).concat(
			(this.nrodocumentoppto!=null)?("nrodocumentoppto:\t" + this.nrodocumentoppto+"\n"):"" ).concat(
			(this.nrodocumentooga!=null)?("nrodocumentooga:\t" + this.nrodocumentooga+"\n"):"" ).concat(
			(this.fechaautorizacion!=null)?("fechaautorizacion:\t" + this.fechaautorizacion+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.montoprevision!=null)?("montoprevision:\t" + this.montoprevision+"\n"):"" ).concat(
			(this.montoprevisioncontrato!=null)?("montoprevisioncontrato:\t" + this.montoprevisioncontrato+"\n"):"" ).concat(
			(this.montoampliacion!=null)?("montoampliacion:\t" + this.montoampliacion+"\n"):"" ).concat(
			(this.montoanulacion!=null)?("montoanulacion:\t" + this.montoanulacion+"\n"):"" ).concat(
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
		if(this.montoprevision!=null)
			montoprevision=Utils.round(montoprevision);
		if(this.montoprevisioncontrato!=null)
			montoprevisioncontrato=Utils.round(montoprevisioncontrato);
		if(this.montoampliacion!=null)
			montoampliacion=Utils.round(montoampliacion);
		if(this.montoanulacion!=null)
			montoanulacion=Utils.round(montoanulacion);

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


	 public java.lang.Integer getIdprevisionpresupuestal() {
		return idprevisionpresupuestal;
	}

	public void setIdprevisionpresupuestal(java.lang.Integer idprevisionpresupuestal) {
		this.idprevisionpresupuestal = idprevisionpresupuestal;
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

	 public java.lang.String getNroprevision() {
		return nroprevision;
	}

	public void setNroprevision(java.lang.String nroprevision) {
		this.nroprevision = nroprevision;
	}

	 public java.lang.String getNrodocumentoppto() {
		return nrodocumentoppto;
	}

	public void setNrodocumentoppto(java.lang.String nrodocumentoppto) {
		this.nrodocumentoppto = nrodocumentoppto;
	}

	 public java.lang.String getNrodocumentooga() {
		return nrodocumentooga;
	}

	public void setNrodocumentooga(java.lang.String nrodocumentooga) {
		this.nrodocumentooga = nrodocumentooga;
	}

	 public java.util.Date getFechaautorizacion() {
		return fechaautorizacion;
	}

	public void setFechaautorizacion(java.util.Date fechaautorizacion) {
		this.fechaautorizacion = fechaautorizacion;
	}

	 public java.util.Date getFechaautorizacionini() {
		return fechaautorizacionini;
	}

	public void setFechaautorizacionini(java.util.Date fechaautorizacionini) {
		this.fechaautorizacionini = fechaautorizacionini;
	}

	 public java.util.Date getFechaautorizacionfin() {
		return fechaautorizacionfin;
	}

	public void setFechaautorizacionfin(java.util.Date fechaautorizacionfin) {
		this.fechaautorizacionfin = fechaautorizacionfin;
	}

	 public java.lang.String getAnio() {
		return anio;
	}

	public void setAnio(java.lang.String anio) {
		this.anio = anio;
	}

	 public java.math.BigDecimal getMontoprevision() {
		return montoprevision;
	}

	public void setMontoprevision(java.math.BigDecimal montoprevision) {
		this.montoprevision = montoprevision;
	}

	 public java.math.BigDecimal getMontoprevisionini() {
		return montoprevisionini;
	}

	public void setMontoprevisionini(java.math.BigDecimal montoprevisionini) {
		this.montoprevisionini = montoprevisionini;
	}

	 public java.math.BigDecimal getMontoprevisionfin() {
		return montoprevisionfin;
	}

	public void setMontoprevisionfin(java.math.BigDecimal montoprevisionfin) {
		this.montoprevisionfin = montoprevisionfin;
	}

	 public java.math.BigDecimal getMontoprevisioncontrato() {
		return montoprevisioncontrato;
	}

	public void setMontoprevisioncontrato(java.math.BigDecimal montoprevisioncontrato) {
		this.montoprevisioncontrato = montoprevisioncontrato;
	}

	 public java.math.BigDecimal getMontoprevisioncontratoini() {
		return montoprevisioncontratoini;
	}

	public void setMontoprevisioncontratoini(java.math.BigDecimal montoprevisioncontratoini) {
		this.montoprevisioncontratoini = montoprevisioncontratoini;
	}

	 public java.math.BigDecimal getMontoprevisioncontratofin() {
		return montoprevisioncontratofin;
	}

	public void setMontoprevisioncontratofin(java.math.BigDecimal montoprevisioncontratofin) {
		this.montoprevisioncontratofin = montoprevisioncontratofin;
	}

	 public java.math.BigDecimal getMontoampliacion() {
		return montoampliacion;
	}

	public void setMontoampliacion(java.math.BigDecimal montoampliacion) {
		this.montoampliacion = montoampliacion;
	}

	 public java.math.BigDecimal getMontoampliacionini() {
		return montoampliacionini;
	}

	public void setMontoampliacionini(java.math.BigDecimal montoampliacionini) {
		this.montoampliacionini = montoampliacionini;
	}

	 public java.math.BigDecimal getMontoampliacionfin() {
		return montoampliacionfin;
	}

	public void setMontoampliacionfin(java.math.BigDecimal montoampliacionfin) {
		this.montoampliacionfin = montoampliacionfin;
	}

	 public java.math.BigDecimal getMontoanulacion() {
		return montoanulacion;
	}

	public void setMontoanulacion(java.math.BigDecimal montoanulacion) {
		this.montoanulacion = montoanulacion;
	}

	 public java.math.BigDecimal getMontoanulacionini() {
		return montoanulacionini;
	}

	public void setMontoanulacionini(java.math.BigDecimal montoanulacionini) {
		this.montoanulacionini = montoanulacionini;
	}

	 public java.math.BigDecimal getMontoanulacionfin() {
		return montoanulacionfin;
	}

	public void setMontoanulacionfin(java.math.BigDecimal montoanulacionfin) {
		this.montoanulacionfin = montoanulacionfin;
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
