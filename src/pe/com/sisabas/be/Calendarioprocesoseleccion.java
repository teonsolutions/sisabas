
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[CalendarioProcesoSeleccion]
*@author Gandalf
*@since 30/01/2018
*@version gandalf 4.0*/
public class Calendarioprocesoseleccion extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idcalendarioproceso;
	/**[Convocatoria  Proceso]*/
	private java.lang.Integer idconvocatoriaproceso;
	private Convocatoriaprocesoseleccion convocatoriaprocesoseleccionIdconvocatoriaproceso;
	/**[Codigo Calendario][APRO]  */
	private java.lang.String idcatalogocodigocalendario;
	private Gentabla gentablaIdcatalogocodigocalendario;
	/**[NombreCalendario]*/
	private java.lang.String nombrecalendario;
	/**[Fecha Inicio]*/
	private java.util.Date fechainicio;
	private java.util.Date fechainicioini;
	private java.util.Date fechainiciofin;
	/**[Fecha Fin]*/
	private java.util.Date fechafin;
	private java.util.Date fechafinini;
	private java.util.Date fechafinfin;
	/**[Fecha Publicacion]*/
	private java.util.Date fechpublicacion;
	private java.util.Date fechpublicacionini;
	private java.util.Date fechpublicacionfin;
	/**[Estado Publicacion][EEPR]*/
	private java.lang.String idcatalogoestadopublicacion;
	private Gentabla gentablaIdcatalogoestadopublicacion;
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

	public Calendarioprocesoseleccion() {}

	public Calendarioprocesoseleccion(java.lang.Integer idcalendarioproceso) {
		this.idcalendarioproceso=idcalendarioproceso;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Calendarioprocesoseleccion)
			return ((Calendarioprocesoseleccion)obj).getIdcalendarioproceso().equals(this.getIdcalendarioproceso()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idcalendarioproceso!=null)?("idcalendarioproceso:\t" + this.idcalendarioproceso+"\n"):"" ).concat(
			(this.idconvocatoriaproceso!=null)?("idconvocatoriaproceso:\t" + this.idconvocatoriaproceso+"\n"):"" ).concat(
			(this.idcatalogocodigocalendario!=null)?("idcatalogocodigocalendario:\t" + this.idcatalogocodigocalendario+"\n"):"" ).concat(
			(this.nombrecalendario!=null)?("nombrecalendario:\t" + this.nombrecalendario+"\n"):"" ).concat(
			(this.fechainicio!=null)?("fechainicio:\t" + this.fechainicio+"\n"):"" ).concat(
			(this.fechafin!=null)?("fechafin:\t" + this.fechafin+"\n"):"" ).concat(
			(this.fechpublicacion!=null)?("fechpublicacion:\t" + this.fechpublicacion+"\n"):"" ).concat(
			(this.idcatalogoestadopublicacion!=null)?("idcatalogoestadopublicacion:\t" + this.idcatalogoestadopublicacion+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idcalendarioproceso!=null)?("idcalendarioproceso:\t" + this.idcalendarioproceso+"\n"):"" ).concat(
			(this.idconvocatoriaproceso!=null)?("idconvocatoriaproceso:\t" + this.idconvocatoriaproceso+"\n"):"" ).concat(
			(this.convocatoriaprocesoseleccionIdconvocatoriaproceso!=null)?("convocatoriaprocesoseleccionIdconvocatoriaproceso:\t" + this.convocatoriaprocesoseleccionIdconvocatoriaproceso.toString()+"\n"):"" ).concat(
			(this.idcatalogocodigocalendario!=null)?("idcatalogocodigocalendario:\t" + this.idcatalogocodigocalendario+"\n"):"" ).concat(
			(this.gentablaIdcatalogocodigocalendario!=null)?("gentablaIdcatalogocodigocalendario:\t" + this.gentablaIdcatalogocodigocalendario.toString()+"\n"):"" ).concat(
			(this.nombrecalendario!=null)?("nombrecalendario:\t" + this.nombrecalendario+"\n"):"" ).concat(
			(this.fechainicio!=null)?("fechainicio:\t" + this.fechainicio+"\n"):"" ).concat(
			(this.fechafin!=null)?("fechafin:\t" + this.fechafin+"\n"):"" ).concat(
			(this.fechpublicacion!=null)?("fechpublicacion:\t" + this.fechpublicacion+"\n"):"" ).concat(
			(this.idcatalogoestadopublicacion!=null)?("idcatalogoestadopublicacion:\t" + this.idcatalogoestadopublicacion+"\n"):"" ).concat(
			(this.gentablaIdcatalogoestadopublicacion!=null)?("gentablaIdcatalogoestadopublicacion:\t" + this.gentablaIdcatalogoestadopublicacion.toString()+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIdconvocatoriaprocesoInKeys;
	public void addConditionInIdconvocatoriaproceso(List<String> list){
		if(list==null || list.size()==0){
			idconvocatoriaproceso=null;
			listaIdconvocatoriaprocesoInKeys=null;
			return;
		}
		if(list.size()==1){
			idconvocatoriaproceso=Integer.parseInt(list.get(0));
			listaIdconvocatoriaprocesoInKeys=null;
		}else{
			idconvocatoriaproceso=null;
			listaIdconvocatoriaprocesoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdconvocatoriaprocesoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdconvocatoriaprocesoInKeys() {
		return listaIdconvocatoriaprocesoInKeys;
	}

	private List<java.lang.String> listaIdcatalogocodigocalendarioInKeys;
	public void addConditionInIdcatalogocodigocalendario(List<String> list){
		if(list==null || list.size()==0){
			idcatalogocodigocalendario=null;
			idcatalogocodigocalendario=null;
			listaIdcatalogocodigocalendarioInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogocodigocalendario=list.get(0);
			listaIdcatalogocodigocalendarioInKeys=null;
		}else{
			idcatalogocodigocalendario=null;
			listaIdcatalogocodigocalendarioInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogocodigocalendarioInKeys() {
		return listaIdcatalogocodigocalendarioInKeys;
	}

	private List<java.lang.String> listaIdcatalogoestadopublicacionInKeys;
	public void addConditionInIdcatalogoestadopublicacion(List<String> list){
		if(list==null || list.size()==0){
			idcatalogoestadopublicacion=null;
			idcatalogoestadopublicacion=null;
			listaIdcatalogoestadopublicacionInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogoestadopublicacion=list.get(0);
			listaIdcatalogoestadopublicacionInKeys=null;
		}else{
			idcatalogoestadopublicacion=null;
			listaIdcatalogoestadopublicacionInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogoestadopublicacionInKeys() {
		return listaIdcatalogoestadopublicacionInKeys;
	}


	 public java.lang.Integer getIdcalendarioproceso() {
		return idcalendarioproceso;
	}

	public void setIdcalendarioproceso(java.lang.Integer idcalendarioproceso) {
		this.idcalendarioproceso = idcalendarioproceso;
	}

	 public java.lang.Integer getIdconvocatoriaproceso() {
		return idconvocatoriaproceso;
	}

	public void setIdconvocatoriaproceso(java.lang.Integer idconvocatoriaproceso) {
		this.idconvocatoriaproceso = idconvocatoriaproceso;
	}

	 public Convocatoriaprocesoseleccion getConvocatoriaprocesoseleccionIdconvocatoriaproceso() {
		return convocatoriaprocesoseleccionIdconvocatoriaproceso;
	}

	public void setConvocatoriaprocesoseleccionIdconvocatoriaproceso(Convocatoriaprocesoseleccion convocatoriaprocesoseleccionIdconvocatoriaproceso) {
		this.convocatoriaprocesoseleccionIdconvocatoriaproceso = convocatoriaprocesoseleccionIdconvocatoriaproceso;
	}

	 public java.lang.String getIdcatalogocodigocalendario() {
		return idcatalogocodigocalendario;
	}

	public void setIdcatalogocodigocalendario(java.lang.String idcatalogocodigocalendario) {
		this.idcatalogocodigocalendario = idcatalogocodigocalendario;
	}

	 public Gentabla getGentablaIdcatalogocodigocalendario() {
		return gentablaIdcatalogocodigocalendario;
	}

	public void setGentablaIdcatalogocodigocalendario(Gentabla gentablaIdcatalogocodigocalendario) {
		this.gentablaIdcatalogocodigocalendario = gentablaIdcatalogocodigocalendario;
	}

	 public java.lang.String getNombrecalendario() {
		return nombrecalendario;
	}

	public void setNombrecalendario(java.lang.String nombrecalendario) {
		this.nombrecalendario = nombrecalendario;
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

	 public java.util.Date getFechpublicacion() {
		return fechpublicacion;
	}

	public void setFechpublicacion(java.util.Date fechpublicacion) {
		this.fechpublicacion = fechpublicacion;
	}

	 public java.util.Date getFechpublicacionini() {
		return fechpublicacionini;
	}

	public void setFechpublicacionini(java.util.Date fechpublicacionini) {
		this.fechpublicacionini = fechpublicacionini;
	}

	 public java.util.Date getFechpublicacionfin() {
		return fechpublicacionfin;
	}

	public void setFechpublicacionfin(java.util.Date fechpublicacionfin) {
		this.fechpublicacionfin = fechpublicacionfin;
	}

	 public java.lang.String getIdcatalogoestadopublicacion() {
		return idcatalogoestadopublicacion;
	}

	public void setIdcatalogoestadopublicacion(java.lang.String idcatalogoestadopublicacion) {
		this.idcatalogoestadopublicacion = idcatalogoestadopublicacion;
	}

	 public Gentabla getGentablaIdcatalogoestadopublicacion() {
		return gentablaIdcatalogoestadopublicacion;
	}

	public void setGentablaIdcatalogoestadopublicacion(Gentabla gentablaIdcatalogoestadopublicacion) {
		this.gentablaIdcatalogoestadopublicacion = gentablaIdcatalogoestadopublicacion;
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
