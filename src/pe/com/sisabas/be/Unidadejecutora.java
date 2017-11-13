
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Unidad Ejecutora]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Unidadejecutora extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idunidadejecutora;
	/**[Código de Unidad Ejecutora]*/
	private java.lang.String codigounidadejecutora;
	/**[Nombre de Unidad Ejecutora]*/
	private java.lang.String nombreunidadejecutora;
	/**[Código Siaf Unidad Ejecutora]*/
	private java.lang.String codigosiafunidadejecutora;
	/**[Ubicación Datos Siaf]*/
	private java.lang.String ubicaciondatossiaf;
	/**[*][FechaCreacionAuditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][UsuarioCreaciónAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][FechaModificaciónAuditoria]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][UsuarioModificaciónAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][EquipoAuditoría]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoría]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Unidadejecutora() {}

	public Unidadejecutora(java.lang.Integer idunidadejecutora) {
		this.idunidadejecutora=idunidadejecutora;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Unidadejecutora)
			return ((Unidadejecutora)obj).getIdunidadejecutora().equals(this.getIdunidadejecutora()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.codigounidadejecutora!=null)?("codigounidadejecutora:\t" + this.codigounidadejecutora+"\n"):"" ).concat(
			(this.nombreunidadejecutora!=null)?("nombreunidadejecutora:\t" + this.nombreunidadejecutora+"\n"):"" ).concat(
			(this.codigosiafunidadejecutora!=null)?("codigosiafunidadejecutora:\t" + this.codigosiafunidadejecutora+"\n"):"" ).concat(
			(this.ubicaciondatossiaf!=null)?("ubicaciondatossiaf:\t" + this.ubicaciondatossiaf+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.codigounidadejecutora!=null)?("codigounidadejecutora:\t" + this.codigounidadejecutora+"\n"):"" ).concat(
			(this.nombreunidadejecutora!=null)?("nombreunidadejecutora:\t" + this.nombreunidadejecutora+"\n"):"" ).concat(
			(this.codigosiafunidadejecutora!=null)?("codigosiafunidadejecutora:\t" + this.codigosiafunidadejecutora+"\n"):"" ).concat(
			(this.ubicaciondatossiaf!=null)?("ubicaciondatossiaf:\t" + this.ubicaciondatossiaf+"\n"):"" ).concat(
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


	 public java.lang.Integer getIdunidadejecutora() {
		return idunidadejecutora;
	}

	public void setIdunidadejecutora(java.lang.Integer idunidadejecutora) {
		this.idunidadejecutora = idunidadejecutora;
	}

	 public java.lang.String getCodigounidadejecutora() {
		return codigounidadejecutora;
	}

	public void setCodigounidadejecutora(java.lang.String codigounidadejecutora) {
		this.codigounidadejecutora = codigounidadejecutora;
	}

	 public java.lang.String getNombreunidadejecutora() {
		return nombreunidadejecutora;
	}

	public void setNombreunidadejecutora(java.lang.String nombreunidadejecutora) {
		this.nombreunidadejecutora = nombreunidadejecutora;
	}

	 public java.lang.String getCodigosiafunidadejecutora() {
		return codigosiafunidadejecutora;
	}

	public void setCodigosiafunidadejecutora(java.lang.String codigosiafunidadejecutora) {
		this.codigosiafunidadejecutora = codigosiafunidadejecutora;
	}

	 public java.lang.String getUbicaciondatossiaf() {
		return ubicaciondatossiaf;
	}

	public void setUbicaciondatossiaf(java.lang.String ubicaciondatossiaf) {
		this.ubicaciondatossiaf = ubicaciondatossiaf;
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
