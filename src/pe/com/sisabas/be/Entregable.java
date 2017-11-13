
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Entregable]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Entregable extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer identregable;
	/**[Orden]*/
	private java.lang.Integer idorden;
	private Orden ordenIdorden;
	/**[Número Proveido]*/
	private java.lang.String nroproveido;
	/**[Número Entregable]*/
	private java.lang.String nroentregable;
	/**[Plazo Entregable]*/
	private java.lang.String plazoentregable;
	/**[Monto Entregable]*/
	private java.math.BigDecimal montoentregable;
	private java.math.BigDecimal montoentregableini;
	private java.math.BigDecimal montoentregablefin;
	/**[Monto Penalidad Entregable]*/
	private java.math.BigDecimal montopenalidadentregable;
	private java.math.BigDecimal montopenalidadentregableini;
	private java.math.BigDecimal montopenalidadentregablefin;
	/**[Fecha Presentación Entregable]*/
	private java.util.Date fechapresentacionentregable;
	private java.util.Date fechapresentacionentregableini;
	private java.util.Date fechapresentacionentregablefin;
	/**[Observaciones Entregables]*/
	private java.lang.String observacionesentregable;
	/**[Estado Entregable][EENT]*/
	private java.lang.String idcatalogoestadoentregable;
	private Gentabla gentablaIdcatalogoestadoentregable;
	/**[Grupo Documento]*/
	private java.lang.Integer idgrupodocumento;
	private Grupodocumento grupodocumentoIdgrupodocumento;
	/**[Ejercicio]*/
	private java.lang.Integer anio;
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
	/**[*][UsuarioModificaciónAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][EquipoAuditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Entregable() {}

	public Entregable(java.lang.Integer identregable) {
		this.identregable=identregable;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Entregable)
			return ((Entregable)obj).getIdentregable().equals(this.getIdentregable()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.identregable!=null)?("identregable:\t" + this.identregable+"\n"):"" ).concat(
			(this.idorden!=null)?("idorden:\t" + this.idorden+"\n"):"" ).concat(
			(this.nroproveido!=null)?("nroproveido:\t" + this.nroproveido+"\n"):"" ).concat(
			(this.nroentregable!=null)?("nroentregable:\t" + this.nroentregable+"\n"):"" ).concat(
			(this.plazoentregable!=null)?("plazoentregable:\t" + this.plazoentregable+"\n"):"" ).concat(
			(this.montoentregable!=null)?("montoentregable:\t" + this.montoentregable+"\n"):"" ).concat(
			(this.montopenalidadentregable!=null)?("montopenalidadentregable:\t" + this.montopenalidadentregable+"\n"):"" ).concat(
			(this.fechapresentacionentregable!=null)?("fechapresentacionentregable:\t" + this.fechapresentacionentregable+"\n"):"" ).concat(
			(this.observacionesentregable!=null)?("observacionesentregable:\t" + this.observacionesentregable+"\n"):"" ).concat(
			(this.idcatalogoestadoentregable!=null)?("idcatalogoestadoentregable:\t" + this.idcatalogoestadoentregable+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.identregable!=null)?("identregable:\t" + this.identregable+"\n"):"" ).concat(
			(this.idorden!=null)?("idorden:\t" + this.idorden+"\n"):"" ).concat(
			(this.ordenIdorden!=null)?("ordenIdorden:\t" + this.ordenIdorden.toString()+"\n"):"" ).concat(
			(this.nroproveido!=null)?("nroproveido:\t" + this.nroproveido+"\n"):"" ).concat(
			(this.nroentregable!=null)?("nroentregable:\t" + this.nroentregable+"\n"):"" ).concat(
			(this.plazoentregable!=null)?("plazoentregable:\t" + this.plazoentregable+"\n"):"" ).concat(
			(this.montoentregable!=null)?("montoentregable:\t" + this.montoentregable+"\n"):"" ).concat(
			(this.montopenalidadentregable!=null)?("montopenalidadentregable:\t" + this.montopenalidadentregable+"\n"):"" ).concat(
			(this.fechapresentacionentregable!=null)?("fechapresentacionentregable:\t" + this.fechapresentacionentregable+"\n"):"" ).concat(
			(this.observacionesentregable!=null)?("observacionesentregable:\t" + this.observacionesentregable+"\n"):"" ).concat(
			(this.idcatalogoestadoentregable!=null)?("idcatalogoestadoentregable:\t" + this.idcatalogoestadoentregable+"\n"):"" ).concat(
			(this.gentablaIdcatalogoestadoentregable!=null)?("gentablaIdcatalogoestadoentregable:\t" + this.gentablaIdcatalogoestadoentregable.toString()+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.grupodocumentoIdgrupodocumento!=null)?("grupodocumentoIdgrupodocumento:\t" + this.grupodocumentoIdgrupodocumento.toString()+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
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
		if(this.montoentregable!=null)
			montoentregable=Utils.round(montoentregable);
		if(this.montopenalidadentregable!=null)
			montopenalidadentregable=Utils.round(montopenalidadentregable);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.Integer> listaIdordenInKeys;
	public void addConditionInIdorden(List<String> list){
		if(list==null || list.size()==0){
			idorden=null;
			listaIdordenInKeys=null;
			return;
		}
		if(list.size()==1){
			idorden=Integer.parseInt(list.get(0));
			listaIdordenInKeys=null;
		}else{
			idorden=null;
			listaIdordenInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdordenInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdordenInKeys() {
		return listaIdordenInKeys;
	}

	private List<java.lang.String> listaIdcatalogoestadoentregableInKeys;
	public void addConditionInIdcatalogoestadoentregable(List<String> list){
		if(list==null || list.size()==0){
			idcatalogoestadoentregable=null;
			idcatalogoestadoentregable=null;
			listaIdcatalogoestadoentregableInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogoestadoentregable=list.get(0);
			listaIdcatalogoestadoentregableInKeys=null;
		}else{
			idcatalogoestadoentregable=null;
			listaIdcatalogoestadoentregableInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogoestadoentregableInKeys() {
		return listaIdcatalogoestadoentregableInKeys;
	}

	private List<java.lang.Integer> listaIdgrupodocumentoInKeys;
	public void addConditionInIdgrupodocumento(List<String> list){
		if(list==null || list.size()==0){
			idgrupodocumento=null;
			listaIdgrupodocumentoInKeys=null;
			return;
		}
		if(list.size()==1){
			idgrupodocumento=Integer.parseInt(list.get(0));
			listaIdgrupodocumentoInKeys=null;
		}else{
			idgrupodocumento=null;
			listaIdgrupodocumentoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdgrupodocumentoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdgrupodocumentoInKeys() {
		return listaIdgrupodocumentoInKeys;
	}


	 public java.lang.Integer getIdentregable() {
		return identregable;
	}

	public void setIdentregable(java.lang.Integer identregable) {
		this.identregable = identregable;
	}

	 public java.lang.Integer getIdorden() {
		return idorden;
	}

	public void setIdorden(java.lang.Integer idorden) {
		this.idorden = idorden;
	}

	 public Orden getOrdenIdorden() {
		return ordenIdorden;
	}

	public void setOrdenIdorden(Orden ordenIdorden) {
		this.ordenIdorden = ordenIdorden;
	}

	 public java.lang.String getNroproveido() {
		return nroproveido;
	}

	public void setNroproveido(java.lang.String nroproveido) {
		this.nroproveido = nroproveido;
	}

	 public java.lang.String getNroentregable() {
		return nroentregable;
	}

	public void setNroentregable(java.lang.String nroentregable) {
		this.nroentregable = nroentregable;
	}

	 public java.lang.String getPlazoentregable() {
		return plazoentregable;
	}

	public void setPlazoentregable(java.lang.String plazoentregable) {
		this.plazoentregable = plazoentregable;
	}

	 public java.math.BigDecimal getMontoentregable() {
		return montoentregable;
	}

	public void setMontoentregable(java.math.BigDecimal montoentregable) {
		this.montoentregable = montoentregable;
	}

	 public java.math.BigDecimal getMontoentregableini() {
		return montoentregableini;
	}

	public void setMontoentregableini(java.math.BigDecimal montoentregableini) {
		this.montoentregableini = montoentregableini;
	}

	 public java.math.BigDecimal getMontoentregablefin() {
		return montoentregablefin;
	}

	public void setMontoentregablefin(java.math.BigDecimal montoentregablefin) {
		this.montoentregablefin = montoentregablefin;
	}

	 public java.math.BigDecimal getMontopenalidadentregable() {
		return montopenalidadentregable;
	}

	public void setMontopenalidadentregable(java.math.BigDecimal montopenalidadentregable) {
		this.montopenalidadentregable = montopenalidadentregable;
	}

	 public java.math.BigDecimal getMontopenalidadentregableini() {
		return montopenalidadentregableini;
	}

	public void setMontopenalidadentregableini(java.math.BigDecimal montopenalidadentregableini) {
		this.montopenalidadentregableini = montopenalidadentregableini;
	}

	 public java.math.BigDecimal getMontopenalidadentregablefin() {
		return montopenalidadentregablefin;
	}

	public void setMontopenalidadentregablefin(java.math.BigDecimal montopenalidadentregablefin) {
		this.montopenalidadentregablefin = montopenalidadentregablefin;
	}

	 public java.util.Date getFechapresentacionentregable() {
		return fechapresentacionentregable;
	}

	public void setFechapresentacionentregable(java.util.Date fechapresentacionentregable) {
		this.fechapresentacionentregable = fechapresentacionentregable;
	}

	 public java.util.Date getFechapresentacionentregableini() {
		return fechapresentacionentregableini;
	}

	public void setFechapresentacionentregableini(java.util.Date fechapresentacionentregableini) {
		this.fechapresentacionentregableini = fechapresentacionentregableini;
	}

	 public java.util.Date getFechapresentacionentregablefin() {
		return fechapresentacionentregablefin;
	}

	public void setFechapresentacionentregablefin(java.util.Date fechapresentacionentregablefin) {
		this.fechapresentacionentregablefin = fechapresentacionentregablefin;
	}

	 public java.lang.String getObservacionesentregable() {
		return observacionesentregable;
	}

	public void setObservacionesentregable(java.lang.String observacionesentregable) {
		this.observacionesentregable = observacionesentregable;
	}

	 public java.lang.String getIdcatalogoestadoentregable() {
		return idcatalogoestadoentregable;
	}

	public void setIdcatalogoestadoentregable(java.lang.String idcatalogoestadoentregable) {
		this.idcatalogoestadoentregable = idcatalogoestadoentregable;
	}

	 public Gentabla getGentablaIdcatalogoestadoentregable() {
		return gentablaIdcatalogoestadoentregable;
	}

	public void setGentablaIdcatalogoestadoentregable(Gentabla gentablaIdcatalogoestadoentregable) {
		this.gentablaIdcatalogoestadoentregable = gentablaIdcatalogoestadoentregable;
	}

	 public java.lang.Integer getIdgrupodocumento() {
		return idgrupodocumento;
	}

	public void setIdgrupodocumento(java.lang.Integer idgrupodocumento) {
		this.idgrupodocumento = idgrupodocumento;
	}

	 public Grupodocumento getGrupodocumentoIdgrupodocumento() {
		return grupodocumentoIdgrupodocumento;
	}

	public void setGrupodocumentoIdgrupodocumento(Grupodocumento grupodocumentoIdgrupodocumento) {
		this.grupodocumentoIdgrupodocumento = grupodocumentoIdgrupodocumento;
	}

	 public java.lang.Integer getAnio() {
		return anio;
	}

	public void setAnio(java.lang.Integer anio) {
		this.anio = anio;
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
