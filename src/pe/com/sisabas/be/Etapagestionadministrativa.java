
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Etapa de gestion administrativa]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Etapagestionadministrativa extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[EtapaAdministrativa]*/
	private java.lang.Integer idetapaadministrativa;
	/**[Descripci�n Etapa Administrativa]*/
	private java.lang.String descripcionetapaadministrativa;
	/**[Estado Etapa Administrativa]*/
	private java.lang.Integer estadoetapaadministrativa;
	/**[*][Fecha de Creaci�n]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario de Creaci�n]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha de Modificaci�n]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario de Modificaci�n]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Etapagestionadministrativa() {}

	public Etapagestionadministrativa(java.lang.Integer idetapaadministrativa) {
		this.idetapaadministrativa=idetapaadministrativa;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Etapagestionadministrativa)
			return ((Etapagestionadministrativa)obj).getIdetapaadministrativa().equals(this.getIdetapaadministrativa()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idetapaadministrativa!=null)?("idetapaadministrativa:\t" + this.idetapaadministrativa+"\n"):"" ).concat(
			(this.descripcionetapaadministrativa!=null)?("descripcionetapaadministrativa:\t" + this.descripcionetapaadministrativa+"\n"):"" ).concat(
			(this.estadoetapaadministrativa!=null)?("estadoetapaadministrativa:\t" + this.estadoetapaadministrativa+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idetapaadministrativa!=null)?("idetapaadministrativa:\t" + this.idetapaadministrativa+"\n"):"" ).concat(
			(this.descripcionetapaadministrativa!=null)?("descripcionetapaadministrativa:\t" + this.descripcionetapaadministrativa+"\n"):"" ).concat(
			(this.estadoetapaadministrativa!=null)?("estadoetapaadministrativa:\t" + this.estadoetapaadministrativa+"\n"):"" ).concat(
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


	 public java.lang.Integer getIdetapaadministrativa() {
		return idetapaadministrativa;
	}

	public void setIdetapaadministrativa(java.lang.Integer idetapaadministrativa) {
		this.idetapaadministrativa = idetapaadministrativa;
	}

	 public java.lang.String getDescripcionetapaadministrativa() {
		return descripcionetapaadministrativa;
	}

	public void setDescripcionetapaadministrativa(java.lang.String descripcionetapaadministrativa) {
		this.descripcionetapaadministrativa = descripcionetapaadministrativa;
	}

	 public java.lang.Integer getEstadoetapaadministrativa() {
		return estadoetapaadministrativa;
	}

	public void setEstadoetapaadministrativa(java.lang.Integer estadoetapaadministrativa) {
		this.estadoetapaadministrativa = estadoetapaadministrativa;
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
