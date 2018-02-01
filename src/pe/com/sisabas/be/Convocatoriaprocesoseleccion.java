
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[ConvocatoriaProcesoSeleccion]
*@author Gandalf
*@since 30/01/2018
*@version gandalf 4.0*/
public class Convocatoriaprocesoseleccion extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idconvocatoriaproceso;
	/**[Proceso de Selección]*/
	private java.lang.Integer idprocesoseleccion;
	private Procesoseleccion procesoseleccionIdprocesoseleccion;
	/**[Número de Convocatoria]*/
	private java.lang.Integer nroconvocatoria;
	/**[Secuencia]*/
	private java.lang.Integer secuencia;
	/**[Valor de referencia]*/
	private java.math.BigDecimal valorreferencia;
	private java.math.BigDecimal valorreferenciaini;
	private java.math.BigDecimal valorreferenciafin;
	/**[Estado Convocatoria][ECPR]*/
	private java.lang.String idcatalogoestadoconvocatoria;
	private Gentabla gentablaIdcatalogoestadoconvocatoria;
	/**[Estado Convocatoria Item]*/
	private java.lang.Integer estadoconvocatoriaitem;
	/**[Fecha Inicio]*/
	private java.util.Date fechainicio;
	private java.util.Date fechainicioini;
	private java.util.Date fechainiciofin;
	/**[Fecha Fin]*/
	private java.util.Date fechafin;
	private java.util.Date fechafinini;
	private java.util.Date fechafinfin;
	/**[Principal]*/
	private java.lang.String principal;
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
	private List<Resultadoprocesoseleccion> listaResultadoprocesoseleccion;
	private List<Calendarioprocesoseleccion> listaCalendarioprocesoseleccion;

	public Convocatoriaprocesoseleccion() {}

	public Convocatoriaprocesoseleccion(java.lang.Integer idconvocatoriaproceso) {
		this.idconvocatoriaproceso=idconvocatoriaproceso;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Convocatoriaprocesoseleccion)
			return ((Convocatoriaprocesoseleccion)obj).getIdconvocatoriaproceso().equals(this.getIdconvocatoriaproceso()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idconvocatoriaproceso!=null)?("idconvocatoriaproceso:\t" + this.idconvocatoriaproceso+"\n"):"" ).concat(
			(this.idprocesoseleccion!=null)?("idprocesoseleccion:\t" + this.idprocesoseleccion+"\n"):"" ).concat(
			(this.nroconvocatoria!=null)?("nroconvocatoria:\t" + this.nroconvocatoria+"\n"):"" ).concat(
			(this.secuencia!=null)?("secuencia:\t" + this.secuencia+"\n"):"" ).concat(
			(this.valorreferencia!=null)?("valorreferencia:\t" + this.valorreferencia+"\n"):"" ).concat(
			(this.idcatalogoestadoconvocatoria!=null)?("idcatalogoestadoconvocatoria:\t" + this.idcatalogoestadoconvocatoria+"\n"):"" ).concat(
			(this.estadoconvocatoriaitem!=null)?("estadoconvocatoriaitem:\t" + this.estadoconvocatoriaitem+"\n"):"" ).concat(
			(this.fechainicio!=null)?("fechainicio:\t" + this.fechainicio+"\n"):"" ).concat(
			(this.fechafin!=null)?("fechafin:\t" + this.fechafin+"\n"):"" ).concat(
			(this.principal!=null)?("principal:\t" + this.principal+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idconvocatoriaproceso!=null)?("idconvocatoriaproceso:\t" + this.idconvocatoriaproceso+"\n"):"" ).concat(
			(this.idprocesoseleccion!=null)?("idprocesoseleccion:\t" + this.idprocesoseleccion+"\n"):"" ).concat(
			(this.procesoseleccionIdprocesoseleccion!=null)?("procesoseleccionIdprocesoseleccion:\t" + this.procesoseleccionIdprocesoseleccion.toString()+"\n"):"" ).concat(
			(this.nroconvocatoria!=null)?("nroconvocatoria:\t" + this.nroconvocatoria+"\n"):"" ).concat(
			(this.secuencia!=null)?("secuencia:\t" + this.secuencia+"\n"):"" ).concat(
			(this.valorreferencia!=null)?("valorreferencia:\t" + this.valorreferencia+"\n"):"" ).concat(
			(this.idcatalogoestadoconvocatoria!=null)?("idcatalogoestadoconvocatoria:\t" + this.idcatalogoestadoconvocatoria+"\n"):"" ).concat(
			(this.gentablaIdcatalogoestadoconvocatoria!=null)?("gentablaIdcatalogoestadoconvocatoria:\t" + this.gentablaIdcatalogoestadoconvocatoria.toString()+"\n"):"" ).concat(
			(this.estadoconvocatoriaitem!=null)?("estadoconvocatoriaitem:\t" + this.estadoconvocatoriaitem+"\n"):"" ).concat(
			(this.fechainicio!=null)?("fechainicio:\t" + this.fechainicio+"\n"):"" ).concat(
			(this.fechafin!=null)?("fechafin:\t" + this.fechafin+"\n"):"" ).concat(
			(this.principal!=null)?("principal:\t" + this.principal+"\n"):"" ).concat(
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
		if(this.valorreferencia!=null)
			valorreferencia=Utils.round(valorreferencia);

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

	private List<java.lang.String> listaIdcatalogoestadoconvocatoriaInKeys;
	public void addConditionInIdcatalogoestadoconvocatoria(List<String> list){
		if(list==null || list.size()==0){
			idcatalogoestadoconvocatoria=null;
			idcatalogoestadoconvocatoria=null;
			listaIdcatalogoestadoconvocatoriaInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogoestadoconvocatoria=list.get(0);
			listaIdcatalogoestadoconvocatoriaInKeys=null;
		}else{
			idcatalogoestadoconvocatoria=null;
			listaIdcatalogoestadoconvocatoriaInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogoestadoconvocatoriaInKeys() {
		return listaIdcatalogoestadoconvocatoriaInKeys;
	}


	 public java.lang.Integer getIdconvocatoriaproceso() {
		return idconvocatoriaproceso;
	}

	public void setIdconvocatoriaproceso(java.lang.Integer idconvocatoriaproceso) {
		this.idconvocatoriaproceso = idconvocatoriaproceso;
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

	 public java.lang.Integer getNroconvocatoria() {
		return nroconvocatoria;
	}

	public void setNroconvocatoria(java.lang.Integer nroconvocatoria) {
		this.nroconvocatoria = nroconvocatoria;
	}

	 public java.lang.Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(java.lang.Integer secuencia) {
		this.secuencia = secuencia;
	}

	 public java.math.BigDecimal getValorreferencia() {
		return valorreferencia;
	}

	public void setValorreferencia(java.math.BigDecimal valorreferencia) {
		this.valorreferencia = valorreferencia;
	}

	 public java.math.BigDecimal getValorreferenciaini() {
		return valorreferenciaini;
	}

	public void setValorreferenciaini(java.math.BigDecimal valorreferenciaini) {
		this.valorreferenciaini = valorreferenciaini;
	}

	 public java.math.BigDecimal getValorreferenciafin() {
		return valorreferenciafin;
	}

	public void setValorreferenciafin(java.math.BigDecimal valorreferenciafin) {
		this.valorreferenciafin = valorreferenciafin;
	}

	 public java.lang.String getIdcatalogoestadoconvocatoria() {
		return idcatalogoestadoconvocatoria;
	}

	public void setIdcatalogoestadoconvocatoria(java.lang.String idcatalogoestadoconvocatoria) {
		this.idcatalogoestadoconvocatoria = idcatalogoestadoconvocatoria;
	}

	 public Gentabla getGentablaIdcatalogoestadoconvocatoria() {
		return gentablaIdcatalogoestadoconvocatoria;
	}

	public void setGentablaIdcatalogoestadoconvocatoria(Gentabla gentablaIdcatalogoestadoconvocatoria) {
		this.gentablaIdcatalogoestadoconvocatoria = gentablaIdcatalogoestadoconvocatoria;
	}

	 public java.lang.Integer getEstadoconvocatoriaitem() {
		return estadoconvocatoriaitem;
	}

	public void setEstadoconvocatoriaitem(java.lang.Integer estadoconvocatoriaitem) {
		this.estadoconvocatoriaitem = estadoconvocatoriaitem;
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

	 public java.lang.String getPrincipal() {
		return principal;
	}

	public void setPrincipal(java.lang.String principal) {
		this.principal = principal;
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

	 public List<Resultadoprocesoseleccion> getListaResultadoprocesoseleccion() {
		return listaResultadoprocesoseleccion;
	}

	public void setListaResultadoprocesoseleccion(List<Resultadoprocesoseleccion> listaResultadoprocesoseleccion) {
		this.listaResultadoprocesoseleccion = listaResultadoprocesoseleccion;
	}

	 public List<Calendarioprocesoseleccion> getListaCalendarioprocesoseleccion() {
		return listaCalendarioprocesoseleccion;
	}

	public void setListaCalendarioprocesoseleccion(List<Calendarioprocesoseleccion> listaCalendarioprocesoseleccion) {
		this.listaCalendarioprocesoseleccion = listaCalendarioprocesoseleccion;
	}

}
