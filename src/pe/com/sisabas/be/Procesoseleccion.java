
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[ProcesoSeleccion]
*@author Gandalf
*@since 30/01/2018
*@version gandalf 4.0*/
public class Procesoseleccion extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[id]*/
	private java.lang.Integer idprocesoseleccion;
	/**[GrupoDocumento]*/
	private java.lang.Integer idgrupodocumento;
	private Grupodocumento grupodocumentoIdgrupodocumento;
	/**[PacConsolidado]*/
	private java.lang.Integer idpacconsolidado;
	private Pacconsolidado pacconsolidadoIdpacconsolidado;
	/**[CodigoTipoProceso]*/
	private java.lang.String codigotipoproceso;
	/**[NroProceso]*/
	private java.lang.Integer nroproceso;
	/**[Descripcion Proceso Seleccion]*/
	private java.lang.String descripcionprocesoseleccion;
	/**[Número Consolidado]*/
	private java.lang.Integer nroconsolid;
	/**[Tipo Modalidad][TIMO]*/
	private java.lang.String idcatalogotipomodalidad;
	private Gentabla gentablaIdcatalogotipomodalidad;
	/**[Fecha Recepcion Expediente]*/
	private java.util.Date fecharecepcionexpediente;
	private java.util.Date fecharecepcionexpedienteini;
	private java.util.Date fecharecepcionexpedientefin;
	/**[Dni Especialidad Proceso]*/
	private java.lang.String dniespecialidadproceso;
	/**[Nombre Especialidad Proceso]*/
	private java.lang.String nombreexpecialistaproceso;
	/**[Fecha Acta Proyecto Base]*/
	private java.util.Date fechaactaproyectobase;
	private java.util.Date fechaactaproyectobaseini;
	private java.util.Date fechaactaproyectobasefin;
	/**[Numero Acta Proyecto Base]*/
	private java.lang.String nroactaproyectobase;
	/**[Fecha Observacion Base]*/
	private java.util.Date fechaobservacionbase;
	private java.util.Date fechaobservacionbaseini;
	private java.util.Date fechaobservacionbasefin;
	/**[Observaciones Proyecto Bases]*/
	private java.lang.String observacionesproyectobases;
	/**[Fecha Subsanacion Base]*/
	private java.util.Date fechasubsanacionbase;
	private java.util.Date fechasubsanacionbaseini;
	private java.util.Date fechasubsanacionbasefin;
	/**[Fecha Aprobacion Base]*/
	private java.util.Date fechaaprobacionbase;
	private java.util.Date fechaaprobacionbaseini;
	private java.util.Date fechaaprobacionbasefin;
	/**[Modalidad Ejecución]*/
	private java.lang.String modalidadejecucion;
	/**[Numeración Formato Bases]*/
	private java.lang.Integer numeracionformatobases;
	/**[Anio Formato Bases]*/
	private java.lang.Integer anioformatobases;
	/**[Fecha Elevacion Observacion]*/
	private java.util.Date fechaelevacionobservacion;
	private java.util.Date fechaelevacionobservacionini;
	private java.util.Date fechaelevacionobservacionfin;
	/**[Fecha Pronunciamiento]*/
	private java.util.Date fechapronunciamiento;
	private java.util.Date fechapronunciamientoini;
	private java.util.Date fechapronunciamientofin;
	/**[Fecha Apelacion]*/
	private java.util.Date fechaapelacion;
	private java.util.Date fechaapelacionini;
	private java.util.Date fechaapelacionfin;
	/**[Fecha Resolucion Apelacion]*/
	private java.util.Date fecharesolucionapelacion;
	private java.util.Date fecharesolucionapelacionini;
	private java.util.Date fecharesolucionapelacionfin;
	/**[Fecha Publicacion Consentimiento]*/
	private java.util.Date fechapublicacionconsentimiento;
	private java.util.Date fechapublicacionconsentimientoini;
	private java.util.Date fechapublicacionconsentimientofin;
	/**[Observaciones]*/
	private java.lang.String observaciones;
	/**[Fecha Envio Programacion]*/
	private java.util.Date fechaenvioprogramacion;
	private java.util.Date fechaenvioprogramacionini;
	private java.util.Date fechaenvioprogramacionfin;
	/**[Fecha Envio Ejecucion]*/
	private java.util.Date fechaenvioejecucion;
	private java.util.Date fechaenvioejecucionini;
	private java.util.Date fechaenvioejecucionfin;
	/**[Fecha Integracion Bases]*/
	private java.util.Date fechaintegracionbases;
	private java.util.Date fechaintegracionbasesini;
	private java.util.Date fechaintegracionbasesfin;
	/**[Fecha Desierta]*/
	private java.util.Date fechadesierta;
	private java.util.Date fechadesiertaini;
	private java.util.Date fechadesiertafin;
	/**[Estado Proceso]*/
	private java.lang.Integer estadoproceso;
	/**[Id Sinad]*/
	private java.lang.Integer idsinad;
	/**[Anio]*/
	private java.lang.Integer anio;
	/**[Comite Notificado]*/
	private java.lang.String comitenotificado;
	/**[Sistema Contratacion][SIAD]*/
	private java.lang.String idcatalogosistemacontratacion;
	private Gentabla gentablaIdcatalogosistemacontratacion;
	/**[Comite Proceso]*/
	private java.lang.Integer idcomiteproceso;
	private Comiteproceso comiteprocesoIdcomiteproceso;
	/**[Comite Recompuesto]*/
	private java.lang.String comiterecompuesto;
	/**[*][Fecha de Notificacion]*/
	private java.util.Date fechanotificacioncomite;
	private java.util.Date fechanotificacioncomiteini;
	private java.util.Date fechanotificacioncomitefin;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario de Creacion]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][FechaModificacionAuditoria]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario de última modificacion]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][IP/Nombre Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa/Clase]*/
	private java.lang.String programaauditoria;
	/**[*][Estado Auditoria]*/
	private java.lang.String estadoauditoria;
	private List<Convocatoriaprocesoseleccion> listaConvocatoriaprocesoseleccion;
	private List<Contratosporprocesoseleccion> listaContratosporprocesoseleccion;

	public Procesoseleccion() {}

	public Procesoseleccion(java.lang.Integer idprocesoseleccion) {
		this.idprocesoseleccion=idprocesoseleccion;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Procesoseleccion)
			return ((Procesoseleccion)obj).getIdprocesoseleccion().equals(this.getIdprocesoseleccion()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idprocesoseleccion!=null)?("idprocesoseleccion:\t" + this.idprocesoseleccion+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.codigotipoproceso!=null)?("codigotipoproceso:\t" + this.codigotipoproceso+"\n"):"" ).concat(
			(this.nroproceso!=null)?("nroproceso:\t" + this.nroproceso+"\n"):"" ).concat(
			(this.descripcionprocesoseleccion!=null)?("descripcionprocesoseleccion:\t" + this.descripcionprocesoseleccion+"\n"):"" ).concat(
			(this.nroconsolid!=null)?("nroconsolid:\t" + this.nroconsolid+"\n"):"" ).concat(
			(this.idcatalogotipomodalidad!=null)?("idcatalogotipomodalidad:\t" + this.idcatalogotipomodalidad+"\n"):"" ).concat(
			(this.fecharecepcionexpediente!=null)?("fecharecepcionexpediente:\t" + this.fecharecepcionexpediente+"\n"):"" ).concat(
			(this.dniespecialidadproceso!=null)?("dniespecialidadproceso:\t" + this.dniespecialidadproceso+"\n"):"" ).concat(
			(this.nombreexpecialistaproceso!=null)?("nombreexpecialistaproceso:\t" + this.nombreexpecialistaproceso+"\n"):"" ).concat(
			(this.fechaactaproyectobase!=null)?("fechaactaproyectobase:\t" + this.fechaactaproyectobase+"\n"):"" ).concat(
			(this.nroactaproyectobase!=null)?("nroactaproyectobase:\t" + this.nroactaproyectobase+"\n"):"" ).concat(
			(this.fechaobservacionbase!=null)?("fechaobservacionbase:\t" + this.fechaobservacionbase+"\n"):"" ).concat(
			(this.observacionesproyectobases!=null)?("observacionesproyectobases:\t" + this.observacionesproyectobases+"\n"):"" ).concat(
			(this.fechasubsanacionbase!=null)?("fechasubsanacionbase:\t" + this.fechasubsanacionbase+"\n"):"" ).concat(
			(this.fechaaprobacionbase!=null)?("fechaaprobacionbase:\t" + this.fechaaprobacionbase+"\n"):"" ).concat(
			(this.modalidadejecucion!=null)?("modalidadejecucion:\t" + this.modalidadejecucion+"\n"):"" ).concat(
			(this.numeracionformatobases!=null)?("numeracionformatobases:\t" + this.numeracionformatobases+"\n"):"" ).concat(
			(this.anioformatobases!=null)?("anioformatobases:\t" + this.anioformatobases+"\n"):"" ).concat(
			(this.fechaelevacionobservacion!=null)?("fechaelevacionobservacion:\t" + this.fechaelevacionobservacion+"\n"):"" ).concat(
			(this.fechapronunciamiento!=null)?("fechapronunciamiento:\t" + this.fechapronunciamiento+"\n"):"" ).concat(
			(this.fechaapelacion!=null)?("fechaapelacion:\t" + this.fechaapelacion+"\n"):"" ).concat(
			(this.fecharesolucionapelacion!=null)?("fecharesolucionapelacion:\t" + this.fecharesolucionapelacion+"\n"):"" ).concat(
			(this.fechapublicacionconsentimiento!=null)?("fechapublicacionconsentimiento:\t" + this.fechapublicacionconsentimiento+"\n"):"" ).concat(
			(this.observaciones!=null)?("observaciones:\t" + this.observaciones+"\n"):"" ).concat(
			(this.fechaenvioprogramacion!=null)?("fechaenvioprogramacion:\t" + this.fechaenvioprogramacion+"\n"):"" ).concat(
			(this.fechaenvioejecucion!=null)?("fechaenvioejecucion:\t" + this.fechaenvioejecucion+"\n"):"" ).concat(
			(this.fechaintegracionbases!=null)?("fechaintegracionbases:\t" + this.fechaintegracionbases+"\n"):"" ).concat(
			(this.fechadesierta!=null)?("fechadesierta:\t" + this.fechadesierta+"\n"):"" ).concat(
			(this.estadoproceso!=null)?("estadoproceso:\t" + this.estadoproceso+"\n"):"" ).concat(
			(this.idsinad!=null)?("idsinad:\t" + this.idsinad+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.comitenotificado!=null)?("comitenotificado:\t" + this.comitenotificado+"\n"):"" ).concat(
			(this.idcatalogosistemacontratacion!=null)?("idcatalogosistemacontratacion:\t" + this.idcatalogosistemacontratacion+"\n"):"" ).concat(
			(this.idcomiteproceso!=null)?("idcomiteproceso:\t" + this.idcomiteproceso+"\n"):"" ).concat(
			(this.comiterecompuesto!=null)?("comiterecompuesto:\t" + this.comiterecompuesto+"\n"):"" ).concat(
			(this.fechanotificacioncomite!=null)?("fechanotificacioncomite:\t" + this.fechanotificacioncomite+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idprocesoseleccion!=null)?("idprocesoseleccion:\t" + this.idprocesoseleccion+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.grupodocumentoIdgrupodocumento!=null)?("grupodocumentoIdgrupodocumento:\t" + this.grupodocumentoIdgrupodocumento.toString()+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.pacconsolidadoIdpacconsolidado!=null)?("pacconsolidadoIdpacconsolidado:\t" + this.pacconsolidadoIdpacconsolidado.toString()+"\n"):"" ).concat(
			(this.codigotipoproceso!=null)?("codigotipoproceso:\t" + this.codigotipoproceso+"\n"):"" ).concat(
			(this.nroproceso!=null)?("nroproceso:\t" + this.nroproceso+"\n"):"" ).concat(
			(this.descripcionprocesoseleccion!=null)?("descripcionprocesoseleccion:\t" + this.descripcionprocesoseleccion+"\n"):"" ).concat(
			(this.nroconsolid!=null)?("nroconsolid:\t" + this.nroconsolid+"\n"):"" ).concat(
			(this.idcatalogotipomodalidad!=null)?("idcatalogotipomodalidad:\t" + this.idcatalogotipomodalidad+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipomodalidad!=null)?("gentablaIdcatalogotipomodalidad:\t" + this.gentablaIdcatalogotipomodalidad.toString()+"\n"):"" ).concat(
			(this.fecharecepcionexpediente!=null)?("fecharecepcionexpediente:\t" + this.fecharecepcionexpediente+"\n"):"" ).concat(
			(this.dniespecialidadproceso!=null)?("dniespecialidadproceso:\t" + this.dniespecialidadproceso+"\n"):"" ).concat(
			(this.nombreexpecialistaproceso!=null)?("nombreexpecialistaproceso:\t" + this.nombreexpecialistaproceso+"\n"):"" ).concat(
			(this.fechaactaproyectobase!=null)?("fechaactaproyectobase:\t" + this.fechaactaproyectobase+"\n"):"" ).concat(
			(this.nroactaproyectobase!=null)?("nroactaproyectobase:\t" + this.nroactaproyectobase+"\n"):"" ).concat(
			(this.fechaobservacionbase!=null)?("fechaobservacionbase:\t" + this.fechaobservacionbase+"\n"):"" ).concat(
			(this.observacionesproyectobases!=null)?("observacionesproyectobases:\t" + this.observacionesproyectobases+"\n"):"" ).concat(
			(this.fechasubsanacionbase!=null)?("fechasubsanacionbase:\t" + this.fechasubsanacionbase+"\n"):"" ).concat(
			(this.fechaaprobacionbase!=null)?("fechaaprobacionbase:\t" + this.fechaaprobacionbase+"\n"):"" ).concat(
			(this.modalidadejecucion!=null)?("modalidadejecucion:\t" + this.modalidadejecucion+"\n"):"" ).concat(
			(this.numeracionformatobases!=null)?("numeracionformatobases:\t" + this.numeracionformatobases+"\n"):"" ).concat(
			(this.anioformatobases!=null)?("anioformatobases:\t" + this.anioformatobases+"\n"):"" ).concat(
			(this.fechaelevacionobservacion!=null)?("fechaelevacionobservacion:\t" + this.fechaelevacionobservacion+"\n"):"" ).concat(
			(this.fechapronunciamiento!=null)?("fechapronunciamiento:\t" + this.fechapronunciamiento+"\n"):"" ).concat(
			(this.fechaapelacion!=null)?("fechaapelacion:\t" + this.fechaapelacion+"\n"):"" ).concat(
			(this.fecharesolucionapelacion!=null)?("fecharesolucionapelacion:\t" + this.fecharesolucionapelacion+"\n"):"" ).concat(
			(this.fechapublicacionconsentimiento!=null)?("fechapublicacionconsentimiento:\t" + this.fechapublicacionconsentimiento+"\n"):"" ).concat(
			(this.observaciones!=null)?("observaciones:\t" + this.observaciones+"\n"):"" ).concat(
			(this.fechaenvioprogramacion!=null)?("fechaenvioprogramacion:\t" + this.fechaenvioprogramacion+"\n"):"" ).concat(
			(this.fechaenvioejecucion!=null)?("fechaenvioejecucion:\t" + this.fechaenvioejecucion+"\n"):"" ).concat(
			(this.fechaintegracionbases!=null)?("fechaintegracionbases:\t" + this.fechaintegracionbases+"\n"):"" ).concat(
			(this.fechadesierta!=null)?("fechadesierta:\t" + this.fechadesierta+"\n"):"" ).concat(
			(this.estadoproceso!=null)?("estadoproceso:\t" + this.estadoproceso+"\n"):"" ).concat(
			(this.idsinad!=null)?("idsinad:\t" + this.idsinad+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.comitenotificado!=null)?("comitenotificado:\t" + this.comitenotificado+"\n"):"" ).concat(
			(this.idcatalogosistemacontratacion!=null)?("idcatalogosistemacontratacion:\t" + this.idcatalogosistemacontratacion+"\n"):"" ).concat(
			(this.gentablaIdcatalogosistemacontratacion!=null)?("gentablaIdcatalogosistemacontratacion:\t" + this.gentablaIdcatalogosistemacontratacion.toString()+"\n"):"" ).concat(
			(this.idcomiteproceso!=null)?("idcomiteproceso:\t" + this.idcomiteproceso+"\n"):"" ).concat(
			(this.comiteprocesoIdcomiteproceso!=null)?("comiteprocesoIdcomiteproceso:\t" + this.comiteprocesoIdcomiteproceso.toString()+"\n"):"" ).concat(
			(this.comiterecompuesto!=null)?("comiterecompuesto:\t" + this.comiterecompuesto+"\n"):"" ).concat(
			(this.fechanotificacioncomite!=null)?("fechanotificacioncomite:\t" + this.fechanotificacioncomite+"\n"):"" ).concat(
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

	private List<java.lang.String> listaIdcatalogotipomodalidadInKeys;
	public void addConditionInIdcatalogotipomodalidad(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipomodalidad=null;
			idcatalogotipomodalidad=null;
			listaIdcatalogotipomodalidadInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipomodalidad=list.get(0);
			listaIdcatalogotipomodalidadInKeys=null;
		}else{
			idcatalogotipomodalidad=null;
			listaIdcatalogotipomodalidadInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipomodalidadInKeys() {
		return listaIdcatalogotipomodalidadInKeys;
	}

	private List<java.lang.String> listaIdcatalogosistemacontratacionInKeys;
	public void addConditionInIdcatalogosistemacontratacion(List<String> list){
		if(list==null || list.size()==0){
			idcatalogosistemacontratacion=null;
			idcatalogosistemacontratacion=null;
			listaIdcatalogosistemacontratacionInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogosistemacontratacion=list.get(0);
			listaIdcatalogosistemacontratacionInKeys=null;
		}else{
			idcatalogosistemacontratacion=null;
			listaIdcatalogosistemacontratacionInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogosistemacontratacionInKeys() {
		return listaIdcatalogosistemacontratacionInKeys;
	}

	private List<java.lang.Integer> listaIdcomiteprocesoInKeys;
	public void addConditionInIdcomiteproceso(List<String> list){
		if(list==null || list.size()==0){
			idcomiteproceso=null;
			listaIdcomiteprocesoInKeys=null;
			return;
		}
		if(list.size()==1){
			idcomiteproceso=Integer.parseInt(list.get(0));
			listaIdcomiteprocesoInKeys=null;
		}else{
			idcomiteproceso=null;
			listaIdcomiteprocesoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdcomiteprocesoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdcomiteprocesoInKeys() {
		return listaIdcomiteprocesoInKeys;
	}


	 public java.lang.Integer getIdprocesoseleccion() {
		return idprocesoseleccion;
	}

	public void setIdprocesoseleccion(java.lang.Integer idprocesoseleccion) {
		this.idprocesoseleccion = idprocesoseleccion;
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

	 public java.lang.String getCodigotipoproceso() {
		return codigotipoproceso;
	}

	public void setCodigotipoproceso(java.lang.String codigotipoproceso) {
		this.codigotipoproceso = codigotipoproceso;
	}

	 public java.lang.Integer getNroproceso() {
		return nroproceso;
	}

	public void setNroproceso(java.lang.Integer nroproceso) {
		this.nroproceso = nroproceso;
	}

	 public java.lang.String getDescripcionprocesoseleccion() {
		return descripcionprocesoseleccion;
	}

	public void setDescripcionprocesoseleccion(java.lang.String descripcionprocesoseleccion) {
		this.descripcionprocesoseleccion = descripcionprocesoseleccion;
	}

	 public java.lang.Integer getNroconsolid() {
		return nroconsolid;
	}

	public void setNroconsolid(java.lang.Integer nroconsolid) {
		this.nroconsolid = nroconsolid;
	}

	 public java.lang.String getIdcatalogotipomodalidad() {
		return idcatalogotipomodalidad;
	}

	public void setIdcatalogotipomodalidad(java.lang.String idcatalogotipomodalidad) {
		this.idcatalogotipomodalidad = idcatalogotipomodalidad;
	}

	 public Gentabla getGentablaIdcatalogotipomodalidad() {
		return gentablaIdcatalogotipomodalidad;
	}

	public void setGentablaIdcatalogotipomodalidad(Gentabla gentablaIdcatalogotipomodalidad) {
		this.gentablaIdcatalogotipomodalidad = gentablaIdcatalogotipomodalidad;
	}

	 public java.util.Date getFecharecepcionexpediente() {
		return fecharecepcionexpediente;
	}

	public void setFecharecepcionexpediente(java.util.Date fecharecepcionexpediente) {
		this.fecharecepcionexpediente = fecharecepcionexpediente;
	}

	 public java.util.Date getFecharecepcionexpedienteini() {
		return fecharecepcionexpedienteini;
	}

	public void setFecharecepcionexpedienteini(java.util.Date fecharecepcionexpedienteini) {
		this.fecharecepcionexpedienteini = fecharecepcionexpedienteini;
	}

	 public java.util.Date getFecharecepcionexpedientefin() {
		return fecharecepcionexpedientefin;
	}

	public void setFecharecepcionexpedientefin(java.util.Date fecharecepcionexpedientefin) {
		this.fecharecepcionexpedientefin = fecharecepcionexpedientefin;
	}

	 public java.lang.String getDniespecialidadproceso() {
		return dniespecialidadproceso;
	}

	public void setDniespecialidadproceso(java.lang.String dniespecialidadproceso) {
		this.dniespecialidadproceso = dniespecialidadproceso;
	}

	 public java.lang.String getNombreexpecialistaproceso() {
		return nombreexpecialistaproceso;
	}

	public void setNombreexpecialistaproceso(java.lang.String nombreexpecialistaproceso) {
		this.nombreexpecialistaproceso = nombreexpecialistaproceso;
	}

	 public java.util.Date getFechaactaproyectobase() {
		return fechaactaproyectobase;
	}

	public void setFechaactaproyectobase(java.util.Date fechaactaproyectobase) {
		this.fechaactaproyectobase = fechaactaproyectobase;
	}

	 public java.util.Date getFechaactaproyectobaseini() {
		return fechaactaproyectobaseini;
	}

	public void setFechaactaproyectobaseini(java.util.Date fechaactaproyectobaseini) {
		this.fechaactaproyectobaseini = fechaactaproyectobaseini;
	}

	 public java.util.Date getFechaactaproyectobasefin() {
		return fechaactaproyectobasefin;
	}

	public void setFechaactaproyectobasefin(java.util.Date fechaactaproyectobasefin) {
		this.fechaactaproyectobasefin = fechaactaproyectobasefin;
	}

	 public java.lang.String getNroactaproyectobase() {
		return nroactaproyectobase;
	}

	public void setNroactaproyectobase(java.lang.String nroactaproyectobase) {
		this.nroactaproyectobase = nroactaproyectobase;
	}

	 public java.util.Date getFechaobservacionbase() {
		return fechaobservacionbase;
	}

	public void setFechaobservacionbase(java.util.Date fechaobservacionbase) {
		this.fechaobservacionbase = fechaobservacionbase;
	}

	 public java.util.Date getFechaobservacionbaseini() {
		return fechaobservacionbaseini;
	}

	public void setFechaobservacionbaseini(java.util.Date fechaobservacionbaseini) {
		this.fechaobservacionbaseini = fechaobservacionbaseini;
	}

	 public java.util.Date getFechaobservacionbasefin() {
		return fechaobservacionbasefin;
	}

	public void setFechaobservacionbasefin(java.util.Date fechaobservacionbasefin) {
		this.fechaobservacionbasefin = fechaobservacionbasefin;
	}

	 public java.lang.String getObservacionesproyectobases() {
		return observacionesproyectobases;
	}

	public void setObservacionesproyectobases(java.lang.String observacionesproyectobases) {
		this.observacionesproyectobases = observacionesproyectobases;
	}

	 public java.util.Date getFechasubsanacionbase() {
		return fechasubsanacionbase;
	}

	public void setFechasubsanacionbase(java.util.Date fechasubsanacionbase) {
		this.fechasubsanacionbase = fechasubsanacionbase;
	}

	 public java.util.Date getFechasubsanacionbaseini() {
		return fechasubsanacionbaseini;
	}

	public void setFechasubsanacionbaseini(java.util.Date fechasubsanacionbaseini) {
		this.fechasubsanacionbaseini = fechasubsanacionbaseini;
	}

	 public java.util.Date getFechasubsanacionbasefin() {
		return fechasubsanacionbasefin;
	}

	public void setFechasubsanacionbasefin(java.util.Date fechasubsanacionbasefin) {
		this.fechasubsanacionbasefin = fechasubsanacionbasefin;
	}

	 public java.util.Date getFechaaprobacionbase() {
		return fechaaprobacionbase;
	}

	public void setFechaaprobacionbase(java.util.Date fechaaprobacionbase) {
		this.fechaaprobacionbase = fechaaprobacionbase;
	}

	 public java.util.Date getFechaaprobacionbaseini() {
		return fechaaprobacionbaseini;
	}

	public void setFechaaprobacionbaseini(java.util.Date fechaaprobacionbaseini) {
		this.fechaaprobacionbaseini = fechaaprobacionbaseini;
	}

	 public java.util.Date getFechaaprobacionbasefin() {
		return fechaaprobacionbasefin;
	}

	public void setFechaaprobacionbasefin(java.util.Date fechaaprobacionbasefin) {
		this.fechaaprobacionbasefin = fechaaprobacionbasefin;
	}

	 public java.lang.String getModalidadejecucion() {
		return modalidadejecucion;
	}

	public void setModalidadejecucion(java.lang.String modalidadejecucion) {
		this.modalidadejecucion = modalidadejecucion;
	}

	 public java.lang.Integer getNumeracionformatobases() {
		return numeracionformatobases;
	}

	public void setNumeracionformatobases(java.lang.Integer numeracionformatobases) {
		this.numeracionformatobases = numeracionformatobases;
	}

	 public java.lang.Integer getAnioformatobases() {
		return anioformatobases;
	}

	public void setAnioformatobases(java.lang.Integer anioformatobases) {
		this.anioformatobases = anioformatobases;
	}

	 public java.util.Date getFechaelevacionobservacion() {
		return fechaelevacionobservacion;
	}

	public void setFechaelevacionobservacion(java.util.Date fechaelevacionobservacion) {
		this.fechaelevacionobservacion = fechaelevacionobservacion;
	}

	 public java.util.Date getFechaelevacionobservacionini() {
		return fechaelevacionobservacionini;
	}

	public void setFechaelevacionobservacionini(java.util.Date fechaelevacionobservacionini) {
		this.fechaelevacionobservacionini = fechaelevacionobservacionini;
	}

	 public java.util.Date getFechaelevacionobservacionfin() {
		return fechaelevacionobservacionfin;
	}

	public void setFechaelevacionobservacionfin(java.util.Date fechaelevacionobservacionfin) {
		this.fechaelevacionobservacionfin = fechaelevacionobservacionfin;
	}

	 public java.util.Date getFechapronunciamiento() {
		return fechapronunciamiento;
	}

	public void setFechapronunciamiento(java.util.Date fechapronunciamiento) {
		this.fechapronunciamiento = fechapronunciamiento;
	}

	 public java.util.Date getFechapronunciamientoini() {
		return fechapronunciamientoini;
	}

	public void setFechapronunciamientoini(java.util.Date fechapronunciamientoini) {
		this.fechapronunciamientoini = fechapronunciamientoini;
	}

	 public java.util.Date getFechapronunciamientofin() {
		return fechapronunciamientofin;
	}

	public void setFechapronunciamientofin(java.util.Date fechapronunciamientofin) {
		this.fechapronunciamientofin = fechapronunciamientofin;
	}

	 public java.util.Date getFechaapelacion() {
		return fechaapelacion;
	}

	public void setFechaapelacion(java.util.Date fechaapelacion) {
		this.fechaapelacion = fechaapelacion;
	}

	 public java.util.Date getFechaapelacionini() {
		return fechaapelacionini;
	}

	public void setFechaapelacionini(java.util.Date fechaapelacionini) {
		this.fechaapelacionini = fechaapelacionini;
	}

	 public java.util.Date getFechaapelacionfin() {
		return fechaapelacionfin;
	}

	public void setFechaapelacionfin(java.util.Date fechaapelacionfin) {
		this.fechaapelacionfin = fechaapelacionfin;
	}

	 public java.util.Date getFecharesolucionapelacion() {
		return fecharesolucionapelacion;
	}

	public void setFecharesolucionapelacion(java.util.Date fecharesolucionapelacion) {
		this.fecharesolucionapelacion = fecharesolucionapelacion;
	}

	 public java.util.Date getFecharesolucionapelacionini() {
		return fecharesolucionapelacionini;
	}

	public void setFecharesolucionapelacionini(java.util.Date fecharesolucionapelacionini) {
		this.fecharesolucionapelacionini = fecharesolucionapelacionini;
	}

	 public java.util.Date getFecharesolucionapelacionfin() {
		return fecharesolucionapelacionfin;
	}

	public void setFecharesolucionapelacionfin(java.util.Date fecharesolucionapelacionfin) {
		this.fecharesolucionapelacionfin = fecharesolucionapelacionfin;
	}

	 public java.util.Date getFechapublicacionconsentimiento() {
		return fechapublicacionconsentimiento;
	}

	public void setFechapublicacionconsentimiento(java.util.Date fechapublicacionconsentimiento) {
		this.fechapublicacionconsentimiento = fechapublicacionconsentimiento;
	}

	 public java.util.Date getFechapublicacionconsentimientoini() {
		return fechapublicacionconsentimientoini;
	}

	public void setFechapublicacionconsentimientoini(java.util.Date fechapublicacionconsentimientoini) {
		this.fechapublicacionconsentimientoini = fechapublicacionconsentimientoini;
	}

	 public java.util.Date getFechapublicacionconsentimientofin() {
		return fechapublicacionconsentimientofin;
	}

	public void setFechapublicacionconsentimientofin(java.util.Date fechapublicacionconsentimientofin) {
		this.fechapublicacionconsentimientofin = fechapublicacionconsentimientofin;
	}

	 public java.lang.String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(java.lang.String observaciones) {
		this.observaciones = observaciones;
	}

	 public java.util.Date getFechaenvioprogramacion() {
		return fechaenvioprogramacion;
	}

	public void setFechaenvioprogramacion(java.util.Date fechaenvioprogramacion) {
		this.fechaenvioprogramacion = fechaenvioprogramacion;
	}

	 public java.util.Date getFechaenvioprogramacionini() {
		return fechaenvioprogramacionini;
	}

	public void setFechaenvioprogramacionini(java.util.Date fechaenvioprogramacionini) {
		this.fechaenvioprogramacionini = fechaenvioprogramacionini;
	}

	 public java.util.Date getFechaenvioprogramacionfin() {
		return fechaenvioprogramacionfin;
	}

	public void setFechaenvioprogramacionfin(java.util.Date fechaenvioprogramacionfin) {
		this.fechaenvioprogramacionfin = fechaenvioprogramacionfin;
	}

	 public java.util.Date getFechaenvioejecucion() {
		return fechaenvioejecucion;
	}

	public void setFechaenvioejecucion(java.util.Date fechaenvioejecucion) {
		this.fechaenvioejecucion = fechaenvioejecucion;
	}

	 public java.util.Date getFechaenvioejecucionini() {
		return fechaenvioejecucionini;
	}

	public void setFechaenvioejecucionini(java.util.Date fechaenvioejecucionini) {
		this.fechaenvioejecucionini = fechaenvioejecucionini;
	}

	 public java.util.Date getFechaenvioejecucionfin() {
		return fechaenvioejecucionfin;
	}

	public void setFechaenvioejecucionfin(java.util.Date fechaenvioejecucionfin) {
		this.fechaenvioejecucionfin = fechaenvioejecucionfin;
	}

	 public java.util.Date getFechaintegracionbases() {
		return fechaintegracionbases;
	}

	public void setFechaintegracionbases(java.util.Date fechaintegracionbases) {
		this.fechaintegracionbases = fechaintegracionbases;
	}

	 public java.util.Date getFechaintegracionbasesini() {
		return fechaintegracionbasesini;
	}

	public void setFechaintegracionbasesini(java.util.Date fechaintegracionbasesini) {
		this.fechaintegracionbasesini = fechaintegracionbasesini;
	}

	 public java.util.Date getFechaintegracionbasesfin() {
		return fechaintegracionbasesfin;
	}

	public void setFechaintegracionbasesfin(java.util.Date fechaintegracionbasesfin) {
		this.fechaintegracionbasesfin = fechaintegracionbasesfin;
	}

	 public java.util.Date getFechadesierta() {
		return fechadesierta;
	}

	public void setFechadesierta(java.util.Date fechadesierta) {
		this.fechadesierta = fechadesierta;
	}

	 public java.util.Date getFechadesiertaini() {
		return fechadesiertaini;
	}

	public void setFechadesiertaini(java.util.Date fechadesiertaini) {
		this.fechadesiertaini = fechadesiertaini;
	}

	 public java.util.Date getFechadesiertafin() {
		return fechadesiertafin;
	}

	public void setFechadesiertafin(java.util.Date fechadesiertafin) {
		this.fechadesiertafin = fechadesiertafin;
	}

	 public java.lang.Integer getEstadoproceso() {
		return estadoproceso;
	}

	public void setEstadoproceso(java.lang.Integer estadoproceso) {
		this.estadoproceso = estadoproceso;
	}

	 public java.lang.Integer getIdsinad() {
		return idsinad;
	}

	public void setIdsinad(java.lang.Integer idsinad) {
		this.idsinad = idsinad;
	}

	 public java.lang.Integer getAnio() {
		return anio;
	}

	public void setAnio(java.lang.Integer anio) {
		this.anio = anio;
	}

	 public java.lang.String getComitenotificado() {
		return comitenotificado;
	}

	public void setComitenotificado(java.lang.String comitenotificado) {
		this.comitenotificado = comitenotificado;
	}

	 public java.lang.String getIdcatalogosistemacontratacion() {
		return idcatalogosistemacontratacion;
	}

	public void setIdcatalogosistemacontratacion(java.lang.String idcatalogosistemacontratacion) {
		this.idcatalogosistemacontratacion = idcatalogosistemacontratacion;
	}

	 public Gentabla getGentablaIdcatalogosistemacontratacion() {
		return gentablaIdcatalogosistemacontratacion;
	}

	public void setGentablaIdcatalogosistemacontratacion(Gentabla gentablaIdcatalogosistemacontratacion) {
		this.gentablaIdcatalogosistemacontratacion = gentablaIdcatalogosistemacontratacion;
	}

	 public java.lang.Integer getIdcomiteproceso() {
		return idcomiteproceso;
	}

	public void setIdcomiteproceso(java.lang.Integer idcomiteproceso) {
		this.idcomiteproceso = idcomiteproceso;
	}

	 public Comiteproceso getComiteprocesoIdcomiteproceso() {
		return comiteprocesoIdcomiteproceso;
	}

	public void setComiteprocesoIdcomiteproceso(Comiteproceso comiteprocesoIdcomiteproceso) {
		this.comiteprocesoIdcomiteproceso = comiteprocesoIdcomiteproceso;
	}

	 public java.lang.String getComiterecompuesto() {
		return comiterecompuesto;
	}

	public void setComiterecompuesto(java.lang.String comiterecompuesto) {
		this.comiterecompuesto = comiterecompuesto;
	}

	 public java.util.Date getFechanotificacioncomite() {
		return fechanotificacioncomite;
	}

	public void setFechanotificacioncomite(java.util.Date fechanotificacioncomite) {
		this.fechanotificacioncomite = fechanotificacioncomite;
	}

	 public java.util.Date getFechanotificacioncomiteini() {
		return fechanotificacioncomiteini;
	}

	public void setFechanotificacioncomiteini(java.util.Date fechanotificacioncomiteini) {
		this.fechanotificacioncomiteini = fechanotificacioncomiteini;
	}

	 public java.util.Date getFechanotificacioncomitefin() {
		return fechanotificacioncomitefin;
	}

	public void setFechanotificacioncomitefin(java.util.Date fechanotificacioncomitefin) {
		this.fechanotificacioncomitefin = fechanotificacioncomitefin;
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

	 public List<Convocatoriaprocesoseleccion> getListaConvocatoriaprocesoseleccion() {
		return listaConvocatoriaprocesoseleccion;
	}

	public void setListaConvocatoriaprocesoseleccion(List<Convocatoriaprocesoseleccion> listaConvocatoriaprocesoseleccion) {
		this.listaConvocatoriaprocesoseleccion = listaConvocatoriaprocesoseleccion;
	}

	 public List<Contratosporprocesoseleccion> getListaContratosporprocesoseleccion() {
		return listaContratosporprocesoseleccion;
	}

	public void setListaContratosporprocesoseleccion(List<Contratosporprocesoseleccion> listaContratosporprocesoseleccion) {
		this.listaContratosporprocesoseleccion = listaContratosporprocesoseleccion;
	}

}
