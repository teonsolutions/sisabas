
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[SiafLog]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Siaflog extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idlog;
	/**[FechaCarga]*/
	private java.lang.Integer fechacarga;
	/**[IdUnidadEjecutora]*/
	private java.lang.Integer idunidadejecutora;
	/**[Periodicidad]*/
	private java.lang.String periodicidad;
	/**[FechaInicio]*/
	private java.util.Date fechainicio;
	private java.util.Date fechainicioini;
	private java.util.Date fechainiciofin;
	/**[FechaFin]*/
	private java.util.Date fechafin;
	private java.util.Date fechafinini;
	private java.util.Date fechafinfin;
	/**[Estado]*/
	private java.lang.String estado;
	/**[DescripcionEstado]*/
	private java.lang.String descripcionestado;
	/**[FechaCreacionAuditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[UsuarioCreacionAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[FechaModificacionAuditoria]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[UsuarioModificacionAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][EquipoAuditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Siaflog() {}

	public Siaflog(java.lang.Integer idlog) {
		this.idlog=idlog;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Siaflog)
			return ((Siaflog)obj).getIdlog().equals(this.getIdlog()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idlog!=null)?("idlog:\t" + this.idlog+"\n"):"" ).concat(
			(this.fechacarga!=null)?("fechacarga:\t" + this.fechacarga+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.periodicidad!=null)?("periodicidad:\t" + this.periodicidad+"\n"):"" ).concat(
			(this.fechainicio!=null)?("fechainicio:\t" + this.fechainicio+"\n"):"" ).concat(
			(this.fechafin!=null)?("fechafin:\t" + this.fechafin+"\n"):"" ).concat(
			(this.estado!=null)?("estado:\t" + this.estado+"\n"):"" ).concat(
			(this.descripcionestado!=null)?("descripcionestado:\t" + this.descripcionestado+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idlog!=null)?("idlog:\t" + this.idlog+"\n"):"" ).concat(
			(this.fechacarga!=null)?("fechacarga:\t" + this.fechacarga+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.periodicidad!=null)?("periodicidad:\t" + this.periodicidad+"\n"):"" ).concat(
			(this.fechainicio!=null)?("fechainicio:\t" + this.fechainicio+"\n"):"" ).concat(
			(this.fechafin!=null)?("fechafin:\t" + this.fechafin+"\n"):"" ).concat(
			(this.estado!=null)?("estado:\t" + this.estado+"\n"):"" ).concat(
			(this.descripcionestado!=null)?("descripcionestado:\t" + this.descripcionestado+"\n"):"" ).concat(
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


	 public java.lang.Integer getIdlog() {
		return idlog;
	}

	public void setIdlog(java.lang.Integer idlog) {
		this.idlog = idlog;
	}

	 public java.lang.Integer getFechacarga() {
		return fechacarga;
	}

	public void setFechacarga(java.lang.Integer fechacarga) {
		this.fechacarga = fechacarga;
	}

	 public java.lang.Integer getIdunidadejecutora() {
		return idunidadejecutora;
	}

	public void setIdunidadejecutora(java.lang.Integer idunidadejecutora) {
		this.idunidadejecutora = idunidadejecutora;
	}

	 public java.lang.String getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(java.lang.String periodicidad) {
		this.periodicidad = periodicidad;
	}

	 public java.util.Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(java.util.Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	 public java.util.Date getFechainicioini() {
		return fechainicioini;
	}

	public void setFechainicioini(java.util.Date fechainicioini) {
		this.fechainicioini = fechainicioini;
	}

	 public java.util.Date getFechainiciofin() {
		return fechainiciofin;
	}

	public void setFechainiciofin(java.util.Date fechainiciofin) {
		this.fechainiciofin = fechainiciofin;
	}

	 public java.util.Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(java.util.Date fechafin) {
		this.fechafin = fechafin;
	}

	 public java.util.Date getFechafinini() {
		return fechafinini;
	}

	public void setFechafinini(java.util.Date fechafinini) {
		this.fechafinini = fechafinini;
	}

	 public java.util.Date getFechafinfin() {
		return fechafinfin;
	}

	public void setFechafinfin(java.util.Date fechafinfin) {
		this.fechafinfin = fechafinfin;
	}

	 public java.lang.String getEstado() {
		return estado;
	}

	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	 public java.lang.String getDescripcionestado() {
		return descripcionestado;
	}

	public void setDescripcionestado(java.lang.String descripcionestado) {
		this.descripcionestado = descripcionestado;
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
