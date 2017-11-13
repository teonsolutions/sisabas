
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Pac Consolidacion]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Pacconsolidado extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idpacconsolidado;
	/**[Comité Proceso]*/
	private java.lang.Integer idcomiteproceso;
	private Comiteproceso comiteprocesoIdcomiteproceso;
	/**[Grupo Documento]*/
	private java.lang.Integer idgrupodocumento;
	private Grupodocumento grupodocumentoIdgrupodocumento;
	/**[Nro Consolid]*/
	private java.lang.String nroconsolid;
	/**[Item Único]*/
	private java.lang.Integer esitemunico;
	/**[Antecedente Id Pac ConsolidIn]*/
	private java.lang.Integer antecedenteidpacconsolidin;
	/**[Antecedente Proceso Pac Dsc]*/
	private java.lang.String antecedenteprocesopacdsc;
	/**[Número Pac]*/
	private java.lang.String nropac;
	/**[Estado Pac][EPAC]*/
	private java.lang.String idcatalogoestadopac;
	private Gentabla gentablaIdcatalogoestadopac;
	/**[Tipo de Proceso Inicial]*/
	private java.lang.String codigotipoprocesoinicial;
	/**[Código Tipo Bien][TIBI]*/
	private java.lang.String idcatalogotipobien;
	private Gentabla gentablaIdcatalogotipobien;
	/**[Tipo Necesidad][TINE]*/
	private java.lang.String idcatalogotiponecesidad;
	private Gentabla gentablaIdcatalogotiponecesidad;
	/**[Tipo Contratación][TCON]*/
	private java.lang.String idcatalogotipocontratacion;
	private Gentabla gentablaIdcatalogotipocontratacion;
	/**[Número Items]*/
	private java.lang.Integer nroitems;
	/**[Descripción de Pac]*/
	private java.lang.String descpac;
	/**[Unidad de medida]*/
	private java.lang.Integer unidadmedida;
	/**[Cantidad]*/
	private java.lang.Integer cantidad;
	/**[Valor Estimación Contratacion]*/
	private java.math.BigDecimal valorestimadocontracion;
	private java.math.BigDecimal valorestimadocontracionini;
	private java.math.BigDecimal valorestimadocontracionfin;
	/**[Mes Previsto Convocatoria]*/
	private java.lang.Integer mesprevistoconvocatoria;
	/**[Nombre Especialista VR]*/
	private java.lang.String nombreespecialistavr;
	/**[Fecha Recepción Documento Técnico]*/
	private java.util.Date fecharecepciondocumentotecnico;
	private java.util.Date fecharecepciondocumentotecnicoini;
	private java.util.Date fecharecepciondocumentotecnicofin;
	/**[Fecha Asignación Especialista]*/
	private java.util.Date fechaasignacionespecialista;
	private java.util.Date fechaasignacionespecialistaini;
	private java.util.Date fechaasignacionespecialistafin;
	/**[Fecha de Envío Area Consultas Observaciones]*/
	private java.util.Date fechaenvioareausuariaobservacion;
	private java.util.Date fechaenvioareausuariaobservacionini;
	private java.util.Date fechaenvioareausuariaobservacionfin;
	/**[Fecha Abs del Area Usuaria Observación]*/
	private java.util.Date fechaabsconsultasobservaciones;
	private java.util.Date fechaabsconsultasobservacionesini;
	private java.util.Date fechaabsconsultasobservacionesfin;
	/**[Fecha Elaboración Epom]*/
	private java.util.Date fechaelaboracionepom;
	private java.util.Date fechaelaboracionepomini;
	private java.util.Date fechaelaboracionepomfin;
	/**[Fecha Notificación Epom]*/
	private java.util.Date fechanotificacionepom;
	private java.util.Date fechanotificacionepomini;
	private java.util.Date fechanotificacionepomfin;
	/**[Tiempo Demora Epom]*/
	private java.lang.Integer tiempodemoraepom;
	/**[Tiempo Elaboración Epom]*/
	private java.lang.Integer tiempoelaboracionepom;
	/**[Fecha Solicitud CP]*/
	private java.util.Date fechasolicitudcp;
	private java.util.Date fechasolicitudcpini;
	private java.util.Date fechasolicitudcpfin;
	/**[Fecha CP]*/
	private java.util.Date fechacp;
	private java.util.Date fechacpini;
	private java.util.Date fechacpfin;
	/**[Nro CP]*/
	private java.lang.Integer nrocp;
	/**[Monto CP]*/
	private java.math.BigDecimal montocp;
	private java.math.BigDecimal montocpini;
	private java.math.BigDecimal montocpfin;
	/**[Tiene Previsión][boolean]*/
	private java.lang.String tieneprevision;
	private Boolean booleantieneprevision;
	/**[Rebajado]*/
	private java.lang.Integer esrebajado;
	/**[Monto Rebajado]*/
	private java.math.BigDecimal montorebajado;
	private java.math.BigDecimal montorebajadoini;
	private java.math.BigDecimal montorebajadofin;
	/**[Nro Versión Pac]*/
	private java.lang.Integer nroversionpac;
	/**[Fecha Resolución Pac]*/
	private java.util.Date fecharesolucionpac;
	private java.util.Date fecharesolucionpacini;
	private java.util.Date fecharesolucionpacfin;
	/**[Fecha Modificación Seace]*/
	private java.util.Date fechamodificacionseace;
	private java.util.Date fechamodificacionseaceini;
	private java.util.Date fechamodificacionseacefin;
	/**[Código tipo Proceso]*/
	private java.lang.String codigotipoproceso;
	/**[Número Proceso]*/
	private java.math.BigDecimal nroproceso;
	private java.math.BigDecimal nroprocesoini;
	private java.math.BigDecimal nroprocesofin;
	/**[Número Convocatoria]*/
	private java.lang.Integer nroconvocatoria;
	/**[Tiempo de servicio]*/
	private java.lang.String tiemposervicio;
	/**[Estado de Requerimiento]*/
	private java.lang.Integer estadorequerimiento;
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
	/**[Fecha Solicitud Aprobación Expediente]*/
	private java.util.Date fechasolicitudaprobacionexpediente;
	private java.util.Date fechasolicitudaprobacionexpedienteini;
	private java.util.Date fechasolicitudaprobacionexpedientefin;
	/**[Fecha Aprobación de Expediente]*/
	private java.util.Date fechaaprobacionexpediente;
	private java.util.Date fechaaprobacionexpedienteini;
	private java.util.Date fechaaprobacionexpedientefin;
	/**[Ejercicio]*/
	private java.lang.Integer anio;
	/**[Codigo Unidad Ejecutora]*/
	private java.lang.Integer idunidadejecutora;
	private Unidadejecutora unidadejecutoraIdunidadejecutora;
	/**[Flag Aprobación Estandarizacion][boolean]*/
	private java.lang.String flagaprobacionestandarizacion;
	private Boolean booleanflagaprobacionestandarizacion;
	/**[Documento de Aprobación de Estandarización]*/
	private java.lang.String docaprobacionestandarizacion;
	/**[Fecha Aprobación Estandarización]*/
	private java.util.Date fechaaprobacionestandarizacion;
	private java.util.Date fechaaprobacionestandarizacionini;
	private java.util.Date fechaaprobacionestandarizacionfin;
	/**[Fecha Emisión Resumen Ejecutivo]*/
	private java.util.Date fechaemisionresumenejecutivo;
	private java.util.Date fechaemisionresumenejecutivoini;
	private java.util.Date fechaemisionresumenejecutivofin;
	/**[Detalle Honorarios]*/
	private java.lang.String detallehonorarios;
	/**[Resolución Pac]*/
	private java.lang.String resolucionpac;
	/**[Documento no programado]*/
	private java.lang.String documentonoprogramado;
	/**[Documento Epom]*/
	private java.lang.String documentoepom;
	/**[Sistema Contratación]*/
	private java.lang.String sistemacontratacion;
	/**[Modalidad Selección][boolean]*/
	private java.lang.String modalidadseleccion;
	private Boolean booleanmodalidadseleccion;
	/**[Modalidad Contratación][boolean]*/
	private java.lang.String modalidadcontratacion;
	private Boolean booleanmodalidadcontratacion;
	/**[Reajuste][boolean]*/
	private java.lang.String reajuste;
	private Boolean booleanreajuste;
	/**[Flag CD][boolean]*/
	private java.lang.String flagcd;
	private Boolean booleanflagcd;
	/**[Objeto Procedimiento]*/
	private java.lang.String objetoprocedimiento;
	/**[Indagación de Valor Estimado][boolean]*/
	private java.lang.String indagacionvalorestimado;
	private Boolean booleanindagacionvalorestimado;
	/**[Número de Ruc]*/
	private java.lang.String nroruc;
	/**[Número Proceso Proveedor]*/
	private java.lang.Integer nroprocesoproveedor;
	/**[*][EquipoAuditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[Certificacion]*/
	private java.lang.Integer vcertificacion;
	private Vcertificacion vcertificacionVcertificacion;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;
	/**[visIdSigaPaacConsolidado]*/
	private java.lang.Integer visidsigapaacconsolidado;
	private Vissigapaacconsolidado vissigapaacconsolidadoVisidsigapaacconsolidado;
	private List<Requisitosconformidad> listaRequisitosconformidad;
	private List<Orden> listaOrden;
	private List<Sinadporpacconsolidado> listaSinadporpacconsolidado;
	private List<Certificadopresupuestal> listaCertificadopresupuestal;
	private List<Previsionpresupuestal> listaPrevisionpresupuestal;
	private List<Cuadrocomparativofuente> listaCuadrocomparativofuente;

	public Pacconsolidado() {}

	public Pacconsolidado(java.lang.Integer idpacconsolidado) {
		this.idpacconsolidado=idpacconsolidado;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Pacconsolidado)
			return ((Pacconsolidado)obj).getIdpacconsolidado().equals(this.getIdpacconsolidado()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.idcomiteproceso!=null)?("idcomiteproceso:\t" + this.idcomiteproceso+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.nroconsolid!=null)?("nroconsolid:\t" + this.nroconsolid+"\n"):"" ).concat(
			(this.esitemunico!=null)?("esitemunico:\t" + this.esitemunico+"\n"):"" ).concat(
			(this.antecedenteidpacconsolidin!=null)?("antecedenteidpacconsolidin:\t" + this.antecedenteidpacconsolidin+"\n"):"" ).concat(
			(this.antecedenteprocesopacdsc!=null)?("antecedenteprocesopacdsc:\t" + this.antecedenteprocesopacdsc+"\n"):"" ).concat(
			(this.nropac!=null)?("nropac:\t" + this.nropac+"\n"):"" ).concat(
			(this.idcatalogoestadopac!=null)?("idcatalogoestadopac:\t" + this.idcatalogoestadopac+"\n"):"" ).concat(
			(this.codigotipoprocesoinicial!=null)?("codigotipoprocesoinicial:\t" + this.codigotipoprocesoinicial+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.idcatalogotiponecesidad!=null)?("idcatalogotiponecesidad:\t" + this.idcatalogotiponecesidad+"\n"):"" ).concat(
			(this.idcatalogotipocontratacion!=null)?("idcatalogotipocontratacion:\t" + this.idcatalogotipocontratacion+"\n"):"" ).concat(
			(this.nroitems!=null)?("nroitems:\t" + this.nroitems+"\n"):"" ).concat(
			(this.descpac!=null)?("descpac:\t" + this.descpac+"\n"):"" ).concat(
			(this.unidadmedida!=null)?("unidadmedida:\t" + this.unidadmedida+"\n"):"" ).concat(
			(this.cantidad!=null)?("cantidad:\t" + this.cantidad+"\n"):"" ).concat(
			(this.valorestimadocontracion!=null)?("valorestimadocontracion:\t" + this.valorestimadocontracion+"\n"):"" ).concat(
			(this.mesprevistoconvocatoria!=null)?("mesprevistoconvocatoria:\t" + this.mesprevistoconvocatoria+"\n"):"" ).concat(
			(this.nombreespecialistavr!=null)?("nombreespecialistavr:\t" + this.nombreespecialistavr+"\n"):"" ).concat(
			(this.fecharecepciondocumentotecnico!=null)?("fecharecepciondocumentotecnico:\t" + this.fecharecepciondocumentotecnico+"\n"):"" ).concat(
			(this.fechaasignacionespecialista!=null)?("fechaasignacionespecialista:\t" + this.fechaasignacionespecialista+"\n"):"" ).concat(
			(this.fechaenvioareausuariaobservacion!=null)?("fechaenvioareausuariaobservacion:\t" + this.fechaenvioareausuariaobservacion+"\n"):"" ).concat(
			(this.fechaabsconsultasobservaciones!=null)?("fechaabsconsultasobservaciones:\t" + this.fechaabsconsultasobservaciones+"\n"):"" ).concat(
			(this.fechaelaboracionepom!=null)?("fechaelaboracionepom:\t" + this.fechaelaboracionepom+"\n"):"" ).concat(
			(this.fechanotificacionepom!=null)?("fechanotificacionepom:\t" + this.fechanotificacionepom+"\n"):"" ).concat(
			(this.tiempodemoraepom!=null)?("tiempodemoraepom:\t" + this.tiempodemoraepom+"\n"):"" ).concat(
			(this.tiempoelaboracionepom!=null)?("tiempoelaboracionepom:\t" + this.tiempoelaboracionepom+"\n"):"" ).concat(
			(this.fechasolicitudcp!=null)?("fechasolicitudcp:\t" + this.fechasolicitudcp+"\n"):"" ).concat(
			(this.fechacp!=null)?("fechacp:\t" + this.fechacp+"\n"):"" ).concat(
			(this.nrocp!=null)?("nrocp:\t" + this.nrocp+"\n"):"" ).concat(
			(this.montocp!=null)?("montocp:\t" + this.montocp+"\n"):"" ).concat(
			(this.tieneprevision!=null)?("tieneprevision:\t" + this.tieneprevision+"\n"):"" ).concat(
			(this.esrebajado!=null)?("esrebajado:\t" + this.esrebajado+"\n"):"" ).concat(
			(this.montorebajado!=null)?("montorebajado:\t" + this.montorebajado+"\n"):"" ).concat(
			(this.nroversionpac!=null)?("nroversionpac:\t" + this.nroversionpac+"\n"):"" ).concat(
			(this.fecharesolucionpac!=null)?("fecharesolucionpac:\t" + this.fecharesolucionpac+"\n"):"" ).concat(
			(this.fechamodificacionseace!=null)?("fechamodificacionseace:\t" + this.fechamodificacionseace+"\n"):"" ).concat(
			(this.codigotipoproceso!=null)?("codigotipoproceso:\t" + this.codigotipoproceso+"\n"):"" ).concat(
			(this.nroproceso!=null)?("nroproceso:\t" + this.nroproceso+"\n"):"" ).concat(
			(this.nroconvocatoria!=null)?("nroconvocatoria:\t" + this.nroconvocatoria+"\n"):"" ).concat(
			(this.tiemposervicio!=null)?("tiemposervicio:\t" + this.tiemposervicio+"\n"):"" ).concat(
			(this.estadorequerimiento!=null)?("estadorequerimiento:\t" + this.estadorequerimiento+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.fechasolicitudaprobacionexpediente!=null)?("fechasolicitudaprobacionexpediente:\t" + this.fechasolicitudaprobacionexpediente+"\n"):"" ).concat(
			(this.fechaaprobacionexpediente!=null)?("fechaaprobacionexpediente:\t" + this.fechaaprobacionexpediente+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.flagaprobacionestandarizacion!=null)?("flagaprobacionestandarizacion:\t" + this.flagaprobacionestandarizacion+"\n"):"" ).concat(
			(this.docaprobacionestandarizacion!=null)?("docaprobacionestandarizacion:\t" + this.docaprobacionestandarizacion+"\n"):"" ).concat(
			(this.fechaaprobacionestandarizacion!=null)?("fechaaprobacionestandarizacion:\t" + this.fechaaprobacionestandarizacion+"\n"):"" ).concat(
			(this.fechaemisionresumenejecutivo!=null)?("fechaemisionresumenejecutivo:\t" + this.fechaemisionresumenejecutivo+"\n"):"" ).concat(
			(this.detallehonorarios!=null)?("detallehonorarios:\t" + this.detallehonorarios+"\n"):"" ).concat(
			(this.resolucionpac!=null)?("resolucionpac:\t" + this.resolucionpac+"\n"):"" ).concat(
			(this.documentonoprogramado!=null)?("documentonoprogramado:\t" + this.documentonoprogramado+"\n"):"" ).concat(
			(this.documentoepom!=null)?("documentoepom:\t" + this.documentoepom+"\n"):"" ).concat(
			(this.sistemacontratacion!=null)?("sistemacontratacion:\t" + this.sistemacontratacion+"\n"):"" ).concat(
			(this.modalidadseleccion!=null)?("modalidadseleccion:\t" + this.modalidadseleccion+"\n"):"" ).concat(
			(this.modalidadcontratacion!=null)?("modalidadcontratacion:\t" + this.modalidadcontratacion+"\n"):"" ).concat(
			(this.reajuste!=null)?("reajuste:\t" + this.reajuste+"\n"):"" ).concat(
			(this.flagcd!=null)?("flagcd:\t" + this.flagcd+"\n"):"" ).concat(
			(this.objetoprocedimiento!=null)?("objetoprocedimiento:\t" + this.objetoprocedimiento+"\n"):"" ).concat(
			(this.indagacionvalorestimado!=null)?("indagacionvalorestimado:\t" + this.indagacionvalorestimado+"\n"):"" ).concat(
			(this.nroruc!=null)?("nroruc:\t" + this.nroruc+"\n"):"" ).concat(
			(this.nroprocesoproveedor!=null)?("nroprocesoproveedor:\t" + this.nroprocesoproveedor+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.vcertificacion!=null)?("vcertificacion:\t" + this.vcertificacion+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"" ).concat(
			(this.visidsigapaacconsolidado!=null)?("visidsigapaacconsolidado:\t" + this.visidsigapaacconsolidado+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.idcomiteproceso!=null)?("idcomiteproceso:\t" + this.idcomiteproceso+"\n"):"" ).concat(
			(this.comiteprocesoIdcomiteproceso!=null)?("comiteprocesoIdcomiteproceso:\t" + this.comiteprocesoIdcomiteproceso.toString()+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.grupodocumentoIdgrupodocumento!=null)?("grupodocumentoIdgrupodocumento:\t" + this.grupodocumentoIdgrupodocumento.toString()+"\n"):"" ).concat(
			(this.nroconsolid!=null)?("nroconsolid:\t" + this.nroconsolid+"\n"):"" ).concat(
			(this.esitemunico!=null)?("esitemunico:\t" + this.esitemunico+"\n"):"" ).concat(
			(this.antecedenteidpacconsolidin!=null)?("antecedenteidpacconsolidin:\t" + this.antecedenteidpacconsolidin+"\n"):"" ).concat(
			(this.antecedenteprocesopacdsc!=null)?("antecedenteprocesopacdsc:\t" + this.antecedenteprocesopacdsc+"\n"):"" ).concat(
			(this.nropac!=null)?("nropac:\t" + this.nropac+"\n"):"" ).concat(
			(this.idcatalogoestadopac!=null)?("idcatalogoestadopac:\t" + this.idcatalogoestadopac+"\n"):"" ).concat(
			(this.gentablaIdcatalogoestadopac!=null)?("gentablaIdcatalogoestadopac:\t" + this.gentablaIdcatalogoestadopac.toString()+"\n"):"" ).concat(
			(this.codigotipoprocesoinicial!=null)?("codigotipoprocesoinicial:\t" + this.codigotipoprocesoinicial+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipobien!=null)?("gentablaIdcatalogotipobien:\t" + this.gentablaIdcatalogotipobien.toString()+"\n"):"" ).concat(
			(this.idcatalogotiponecesidad!=null)?("idcatalogotiponecesidad:\t" + this.idcatalogotiponecesidad+"\n"):"" ).concat(
			(this.gentablaIdcatalogotiponecesidad!=null)?("gentablaIdcatalogotiponecesidad:\t" + this.gentablaIdcatalogotiponecesidad.toString()+"\n"):"" ).concat(
			(this.idcatalogotipocontratacion!=null)?("idcatalogotipocontratacion:\t" + this.idcatalogotipocontratacion+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipocontratacion!=null)?("gentablaIdcatalogotipocontratacion:\t" + this.gentablaIdcatalogotipocontratacion.toString()+"\n"):"" ).concat(
			(this.nroitems!=null)?("nroitems:\t" + this.nroitems+"\n"):"" ).concat(
			(this.descpac!=null)?("descpac:\t" + this.descpac+"\n"):"" ).concat(
			(this.unidadmedida!=null)?("unidadmedida:\t" + this.unidadmedida+"\n"):"" ).concat(
			(this.cantidad!=null)?("cantidad:\t" + this.cantidad+"\n"):"" ).concat(
			(this.valorestimadocontracion!=null)?("valorestimadocontracion:\t" + this.valorestimadocontracion+"\n"):"" ).concat(
			(this.mesprevistoconvocatoria!=null)?("mesprevistoconvocatoria:\t" + this.mesprevistoconvocatoria+"\n"):"" ).concat(
			(this.nombreespecialistavr!=null)?("nombreespecialistavr:\t" + this.nombreespecialistavr+"\n"):"" ).concat(
			(this.fecharecepciondocumentotecnico!=null)?("fecharecepciondocumentotecnico:\t" + this.fecharecepciondocumentotecnico+"\n"):"" ).concat(
			(this.fechaasignacionespecialista!=null)?("fechaasignacionespecialista:\t" + this.fechaasignacionespecialista+"\n"):"" ).concat(
			(this.fechaenvioareausuariaobservacion!=null)?("fechaenvioareausuariaobservacion:\t" + this.fechaenvioareausuariaobservacion+"\n"):"" ).concat(
			(this.fechaabsconsultasobservaciones!=null)?("fechaabsconsultasobservaciones:\t" + this.fechaabsconsultasobservaciones+"\n"):"" ).concat(
			(this.fechaelaboracionepom!=null)?("fechaelaboracionepom:\t" + this.fechaelaboracionepom+"\n"):"" ).concat(
			(this.fechanotificacionepom!=null)?("fechanotificacionepom:\t" + this.fechanotificacionepom+"\n"):"" ).concat(
			(this.tiempodemoraepom!=null)?("tiempodemoraepom:\t" + this.tiempodemoraepom+"\n"):"" ).concat(
			(this.tiempoelaboracionepom!=null)?("tiempoelaboracionepom:\t" + this.tiempoelaboracionepom+"\n"):"" ).concat(
			(this.fechasolicitudcp!=null)?("fechasolicitudcp:\t" + this.fechasolicitudcp+"\n"):"" ).concat(
			(this.fechacp!=null)?("fechacp:\t" + this.fechacp+"\n"):"" ).concat(
			(this.nrocp!=null)?("nrocp:\t" + this.nrocp+"\n"):"" ).concat(
			(this.montocp!=null)?("montocp:\t" + this.montocp+"\n"):"" ).concat(
			(this.tieneprevision!=null)?("tieneprevision:\t" + this.tieneprevision+"\n"):"" ).concat(
			(this.esrebajado!=null)?("esrebajado:\t" + this.esrebajado+"\n"):"" ).concat(
			(this.montorebajado!=null)?("montorebajado:\t" + this.montorebajado+"\n"):"" ).concat(
			(this.nroversionpac!=null)?("nroversionpac:\t" + this.nroversionpac+"\n"):"" ).concat(
			(this.fecharesolucionpac!=null)?("fecharesolucionpac:\t" + this.fecharesolucionpac+"\n"):"" ).concat(
			(this.fechamodificacionseace!=null)?("fechamodificacionseace:\t" + this.fechamodificacionseace+"\n"):"" ).concat(
			(this.codigotipoproceso!=null)?("codigotipoproceso:\t" + this.codigotipoproceso+"\n"):"" ).concat(
			(this.nroproceso!=null)?("nroproceso:\t" + this.nroproceso+"\n"):"" ).concat(
			(this.nroconvocatoria!=null)?("nroconvocatoria:\t" + this.nroconvocatoria+"\n"):"" ).concat(
			(this.tiemposervicio!=null)?("tiemposervicio:\t" + this.tiemposervicio+"\n"):"" ).concat(
			(this.estadorequerimiento!=null)?("estadorequerimiento:\t" + this.estadorequerimiento+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.fechasolicitudaprobacionexpediente!=null)?("fechasolicitudaprobacionexpediente:\t" + this.fechasolicitudaprobacionexpediente+"\n"):"" ).concat(
			(this.fechaaprobacionexpediente!=null)?("fechaaprobacionexpediente:\t" + this.fechaaprobacionexpediente+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.unidadejecutoraIdunidadejecutora!=null)?("unidadejecutoraIdunidadejecutora:\t" + this.unidadejecutoraIdunidadejecutora.toString()+"\n"):"" ).concat(
			(this.flagaprobacionestandarizacion!=null)?("flagaprobacionestandarizacion:\t" + this.flagaprobacionestandarizacion+"\n"):"" ).concat(
			(this.docaprobacionestandarizacion!=null)?("docaprobacionestandarizacion:\t" + this.docaprobacionestandarizacion+"\n"):"" ).concat(
			(this.fechaaprobacionestandarizacion!=null)?("fechaaprobacionestandarizacion:\t" + this.fechaaprobacionestandarizacion+"\n"):"" ).concat(
			(this.fechaemisionresumenejecutivo!=null)?("fechaemisionresumenejecutivo:\t" + this.fechaemisionresumenejecutivo+"\n"):"" ).concat(
			(this.detallehonorarios!=null)?("detallehonorarios:\t" + this.detallehonorarios+"\n"):"" ).concat(
			(this.resolucionpac!=null)?("resolucionpac:\t" + this.resolucionpac+"\n"):"" ).concat(
			(this.documentonoprogramado!=null)?("documentonoprogramado:\t" + this.documentonoprogramado+"\n"):"" ).concat(
			(this.documentoepom!=null)?("documentoepom:\t" + this.documentoepom+"\n"):"" ).concat(
			(this.sistemacontratacion!=null)?("sistemacontratacion:\t" + this.sistemacontratacion+"\n"):"" ).concat(
			(this.modalidadseleccion!=null)?("modalidadseleccion:\t" + this.modalidadseleccion+"\n"):"" ).concat(
			(this.modalidadcontratacion!=null)?("modalidadcontratacion:\t" + this.modalidadcontratacion+"\n"):"" ).concat(
			(this.reajuste!=null)?("reajuste:\t" + this.reajuste+"\n"):"" ).concat(
			(this.flagcd!=null)?("flagcd:\t" + this.flagcd+"\n"):"" ).concat(
			(this.objetoprocedimiento!=null)?("objetoprocedimiento:\t" + this.objetoprocedimiento+"\n"):"" ).concat(
			(this.indagacionvalorestimado!=null)?("indagacionvalorestimado:\t" + this.indagacionvalorestimado+"\n"):"" ).concat(
			(this.nroruc!=null)?("nroruc:\t" + this.nroruc+"\n"):"" ).concat(
			(this.nroprocesoproveedor!=null)?("nroprocesoproveedor:\t" + this.nroprocesoproveedor+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.vcertificacion!=null)?("vcertificacion:\t" + this.vcertificacion+"\n"):"" ).concat(
			(this.vcertificacionVcertificacion!=null)?("vcertificacionVcertificacion:\t" + this.vcertificacionVcertificacion.toString()+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"" ).concat(
			(this.visidsigapaacconsolidado!=null)?("visidsigapaacconsolidado:\t" + this.visidsigapaacconsolidado+"\n"):"" ).concat(
			(this.vissigapaacconsolidadoVisidsigapaacconsolidado!=null)?("vissigapaacconsolidadoVisidsigapaacconsolidado:\t" + this.vissigapaacconsolidadoVisidsigapaacconsolidado.toString()+"\n"):"");
	 }

	public static final boolean HAVE_BIGDECIMALS=true;
	public void roundBigDecimals(){
		if(this.valorestimadocontracion!=null)
			valorestimadocontracion=Utils.round(valorestimadocontracion);
		if(this.montocp!=null)
			montocp=Utils.round(montocp);
		if(this.montorebajado!=null)
			montorebajado=Utils.round(montorebajado);
		if(this.nroproceso!=null)
			nroproceso=Utils.round(nroproceso);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
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

	private List<java.lang.String> listaIdcatalogoestadopacInKeys;
	public void addConditionInIdcatalogoestadopac(List<String> list){
		if(list==null || list.size()==0){
			idcatalogoestadopac=null;
			idcatalogoestadopac=null;
			listaIdcatalogoestadopacInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogoestadopac=list.get(0);
			listaIdcatalogoestadopacInKeys=null;
		}else{
			idcatalogoestadopac=null;
			listaIdcatalogoestadopacInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogoestadopacInKeys() {
		return listaIdcatalogoestadopacInKeys;
	}

	private List<java.lang.String> listaIdcatalogotipobienInKeys;
	public void addConditionInIdcatalogotipobien(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipobien=null;
			idcatalogotipobien=null;
			listaIdcatalogotipobienInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipobien=list.get(0);
			listaIdcatalogotipobienInKeys=null;
		}else{
			idcatalogotipobien=null;
			listaIdcatalogotipobienInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipobienInKeys() {
		return listaIdcatalogotipobienInKeys;
	}

	private List<java.lang.String> listaIdcatalogotiponecesidadInKeys;
	public void addConditionInIdcatalogotiponecesidad(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotiponecesidad=null;
			idcatalogotiponecesidad=null;
			listaIdcatalogotiponecesidadInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotiponecesidad=list.get(0);
			listaIdcatalogotiponecesidadInKeys=null;
		}else{
			idcatalogotiponecesidad=null;
			listaIdcatalogotiponecesidadInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotiponecesidadInKeys() {
		return listaIdcatalogotiponecesidadInKeys;
	}

	private List<java.lang.String> listaIdcatalogotipocontratacionInKeys;
	public void addConditionInIdcatalogotipocontratacion(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipocontratacion=null;
			idcatalogotipocontratacion=null;
			listaIdcatalogotipocontratacionInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipocontratacion=list.get(0);
			listaIdcatalogotipocontratacionInKeys=null;
		}else{
			idcatalogotipocontratacion=null;
			listaIdcatalogotipocontratacionInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipocontratacionInKeys() {
		return listaIdcatalogotipocontratacionInKeys;
	}

	private List<java.lang.Integer> listaIdunidadejecutoraInKeys;
	public void addConditionInIdunidadejecutora(List<String> list){
		if(list==null || list.size()==0){
			idunidadejecutora=null;
			listaIdunidadejecutoraInKeys=null;
			return;
		}
		if(list.size()==1){
			idunidadejecutora=Integer.parseInt(list.get(0));
			listaIdunidadejecutoraInKeys=null;
		}else{
			idunidadejecutora=null;
			listaIdunidadejecutoraInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdunidadejecutoraInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdunidadejecutoraInKeys() {
		return listaIdunidadejecutoraInKeys;
	}

	private List<java.lang.Integer> listaVcertificacionInKeys;
	public void addConditionInVcertificacion(List<String> list){
		if(list==null || list.size()==0){
			vcertificacion=null;
			listaVcertificacionInKeys=null;
			return;
		}
		if(list.size()==1){
			vcertificacion=Integer.parseInt(list.get(0));
			listaVcertificacionInKeys=null;
		}else{
			vcertificacion=null;
			listaVcertificacionInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaVcertificacionInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaVcertificacionInKeys() {
		return listaVcertificacionInKeys;
	}

	private List<java.lang.Integer> listaVisidsigapaacconsolidadoInKeys;
	public void addConditionInVisidsigapaacconsolidado(List<String> list){
		if(list==null || list.size()==0){
			visidsigapaacconsolidado=null;
			listaVisidsigapaacconsolidadoInKeys=null;
			return;
		}
		if(list.size()==1){
			visidsigapaacconsolidado=Integer.parseInt(list.get(0));
			listaVisidsigapaacconsolidadoInKeys=null;
		}else{
			visidsigapaacconsolidado=null;
			listaVisidsigapaacconsolidadoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaVisidsigapaacconsolidadoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaVisidsigapaacconsolidadoInKeys() {
		return listaVisidsigapaacconsolidadoInKeys;
	}


	 public java.lang.Integer getIdpacconsolidado() {
		return idpacconsolidado;
	}

	public void setIdpacconsolidado(java.lang.Integer idpacconsolidado) {
		this.idpacconsolidado = idpacconsolidado;
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

	 public java.lang.String getNroconsolid() {
		return nroconsolid;
	}

	public void setNroconsolid(java.lang.String nroconsolid) {
		this.nroconsolid = nroconsolid;
	}

	 public java.lang.Integer getEsitemunico() {
		return esitemunico;
	}

	public void setEsitemunico(java.lang.Integer esitemunico) {
		this.esitemunico = esitemunico;
	}

	 public java.lang.Integer getAntecedenteidpacconsolidin() {
		return antecedenteidpacconsolidin;
	}

	public void setAntecedenteidpacconsolidin(java.lang.Integer antecedenteidpacconsolidin) {
		this.antecedenteidpacconsolidin = antecedenteidpacconsolidin;
	}

	 public java.lang.String getAntecedenteprocesopacdsc() {
		return antecedenteprocesopacdsc;
	}

	public void setAntecedenteprocesopacdsc(java.lang.String antecedenteprocesopacdsc) {
		this.antecedenteprocesopacdsc = antecedenteprocesopacdsc;
	}

	 public java.lang.String getNropac() {
		return nropac;
	}

	public void setNropac(java.lang.String nropac) {
		this.nropac = nropac;
	}

	 public java.lang.String getIdcatalogoestadopac() {
		return idcatalogoestadopac;
	}

	public void setIdcatalogoestadopac(java.lang.String idcatalogoestadopac) {
		this.idcatalogoestadopac = idcatalogoestadopac;
	}

	 public Gentabla getGentablaIdcatalogoestadopac() {
		return gentablaIdcatalogoestadopac;
	}

	public void setGentablaIdcatalogoestadopac(Gentabla gentablaIdcatalogoestadopac) {
		this.gentablaIdcatalogoestadopac = gentablaIdcatalogoestadopac;
	}

	 public java.lang.String getCodigotipoprocesoinicial() {
		return codigotipoprocesoinicial;
	}

	public void setCodigotipoprocesoinicial(java.lang.String codigotipoprocesoinicial) {
		this.codigotipoprocesoinicial = codigotipoprocesoinicial;
	}

	 public java.lang.String getIdcatalogotipobien() {
		return idcatalogotipobien;
	}

	public void setIdcatalogotipobien(java.lang.String idcatalogotipobien) {
		this.idcatalogotipobien = idcatalogotipobien;
	}

	 public Gentabla getGentablaIdcatalogotipobien() {
		return gentablaIdcatalogotipobien;
	}

	public void setGentablaIdcatalogotipobien(Gentabla gentablaIdcatalogotipobien) {
		this.gentablaIdcatalogotipobien = gentablaIdcatalogotipobien;
	}

	 public java.lang.String getIdcatalogotiponecesidad() {
		return idcatalogotiponecesidad;
	}

	public void setIdcatalogotiponecesidad(java.lang.String idcatalogotiponecesidad) {
		this.idcatalogotiponecesidad = idcatalogotiponecesidad;
	}

	 public Gentabla getGentablaIdcatalogotiponecesidad() {
		return gentablaIdcatalogotiponecesidad;
	}

	public void setGentablaIdcatalogotiponecesidad(Gentabla gentablaIdcatalogotiponecesidad) {
		this.gentablaIdcatalogotiponecesidad = gentablaIdcatalogotiponecesidad;
	}

	 public java.lang.String getIdcatalogotipocontratacion() {
		return idcatalogotipocontratacion;
	}

	public void setIdcatalogotipocontratacion(java.lang.String idcatalogotipocontratacion) {
		this.idcatalogotipocontratacion = idcatalogotipocontratacion;
	}

	 public Gentabla getGentablaIdcatalogotipocontratacion() {
		return gentablaIdcatalogotipocontratacion;
	}

	public void setGentablaIdcatalogotipocontratacion(Gentabla gentablaIdcatalogotipocontratacion) {
		this.gentablaIdcatalogotipocontratacion = gentablaIdcatalogotipocontratacion;
	}

	 public java.lang.Integer getNroitems() {
		return nroitems;
	}

	public void setNroitems(java.lang.Integer nroitems) {
		this.nroitems = nroitems;
	}

	 public java.lang.String getDescpac() {
		return descpac;
	}

	public void setDescpac(java.lang.String descpac) {
		this.descpac = descpac;
	}

	 public java.lang.Integer getUnidadmedida() {
		return unidadmedida;
	}

	public void setUnidadmedida(java.lang.Integer unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	 public java.lang.Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(java.lang.Integer cantidad) {
		this.cantidad = cantidad;
	}

	 public java.math.BigDecimal getValorestimadocontracion() {
		return valorestimadocontracion;
	}

	public void setValorestimadocontracion(java.math.BigDecimal valorestimadocontracion) {
		this.valorestimadocontracion = valorestimadocontracion;
	}

	 public java.math.BigDecimal getValorestimadocontracionini() {
		return valorestimadocontracionini;
	}

	public void setValorestimadocontracionini(java.math.BigDecimal valorestimadocontracionini) {
		this.valorestimadocontracionini = valorestimadocontracionini;
	}

	 public java.math.BigDecimal getValorestimadocontracionfin() {
		return valorestimadocontracionfin;
	}

	public void setValorestimadocontracionfin(java.math.BigDecimal valorestimadocontracionfin) {
		this.valorestimadocontracionfin = valorestimadocontracionfin;
	}

	 public java.lang.Integer getMesprevistoconvocatoria() {
		return mesprevistoconvocatoria;
	}

	public void setMesprevistoconvocatoria(java.lang.Integer mesprevistoconvocatoria) {
		this.mesprevistoconvocatoria = mesprevistoconvocatoria;
	}

	 public java.lang.String getNombreespecialistavr() {
		return nombreespecialistavr;
	}

	public void setNombreespecialistavr(java.lang.String nombreespecialistavr) {
		this.nombreespecialistavr = nombreespecialistavr;
	}

	 public java.util.Date getFecharecepciondocumentotecnico() {
		return fecharecepciondocumentotecnico;
	}

	public void setFecharecepciondocumentotecnico(java.util.Date fecharecepciondocumentotecnico) {
		this.fecharecepciondocumentotecnico = fecharecepciondocumentotecnico;
	}

	 public java.util.Date getFecharecepciondocumentotecnicoini() {
		return fecharecepciondocumentotecnicoini;
	}

	public void setFecharecepciondocumentotecnicoini(java.util.Date fecharecepciondocumentotecnicoini) {
		this.fecharecepciondocumentotecnicoini = fecharecepciondocumentotecnicoini;
	}

	 public java.util.Date getFecharecepciondocumentotecnicofin() {
		return fecharecepciondocumentotecnicofin;
	}

	public void setFecharecepciondocumentotecnicofin(java.util.Date fecharecepciondocumentotecnicofin) {
		this.fecharecepciondocumentotecnicofin = fecharecepciondocumentotecnicofin;
	}

	 public java.util.Date getFechaasignacionespecialista() {
		return fechaasignacionespecialista;
	}

	public void setFechaasignacionespecialista(java.util.Date fechaasignacionespecialista) {
		this.fechaasignacionespecialista = fechaasignacionespecialista;
	}

	 public java.util.Date getFechaasignacionespecialistaini() {
		return fechaasignacionespecialistaini;
	}

	public void setFechaasignacionespecialistaini(java.util.Date fechaasignacionespecialistaini) {
		this.fechaasignacionespecialistaini = fechaasignacionespecialistaini;
	}

	 public java.util.Date getFechaasignacionespecialistafin() {
		return fechaasignacionespecialistafin;
	}

	public void setFechaasignacionespecialistafin(java.util.Date fechaasignacionespecialistafin) {
		this.fechaasignacionespecialistafin = fechaasignacionespecialistafin;
	}

	 public java.util.Date getFechaenvioareausuariaobservacion() {
		return fechaenvioareausuariaobservacion;
	}

	public void setFechaenvioareausuariaobservacion(java.util.Date fechaenvioareausuariaobservacion) {
		this.fechaenvioareausuariaobservacion = fechaenvioareausuariaobservacion;
	}

	 public java.util.Date getFechaenvioareausuariaobservacionini() {
		return fechaenvioareausuariaobservacionini;
	}

	public void setFechaenvioareausuariaobservacionini(java.util.Date fechaenvioareausuariaobservacionini) {
		this.fechaenvioareausuariaobservacionini = fechaenvioareausuariaobservacionini;
	}

	 public java.util.Date getFechaenvioareausuariaobservacionfin() {
		return fechaenvioareausuariaobservacionfin;
	}

	public void setFechaenvioareausuariaobservacionfin(java.util.Date fechaenvioareausuariaobservacionfin) {
		this.fechaenvioareausuariaobservacionfin = fechaenvioareausuariaobservacionfin;
	}

	 public java.util.Date getFechaabsconsultasobservaciones() {
		return fechaabsconsultasobservaciones;
	}

	public void setFechaabsconsultasobservaciones(java.util.Date fechaabsconsultasobservaciones) {
		this.fechaabsconsultasobservaciones = fechaabsconsultasobservaciones;
	}

	 public java.util.Date getFechaabsconsultasobservacionesini() {
		return fechaabsconsultasobservacionesini;
	}

	public void setFechaabsconsultasobservacionesini(java.util.Date fechaabsconsultasobservacionesini) {
		this.fechaabsconsultasobservacionesini = fechaabsconsultasobservacionesini;
	}

	 public java.util.Date getFechaabsconsultasobservacionesfin() {
		return fechaabsconsultasobservacionesfin;
	}

	public void setFechaabsconsultasobservacionesfin(java.util.Date fechaabsconsultasobservacionesfin) {
		this.fechaabsconsultasobservacionesfin = fechaabsconsultasobservacionesfin;
	}

	 public java.util.Date getFechaelaboracionepom() {
		return fechaelaboracionepom;
	}

	public void setFechaelaboracionepom(java.util.Date fechaelaboracionepom) {
		this.fechaelaboracionepom = fechaelaboracionepom;
	}

	 public java.util.Date getFechaelaboracionepomini() {
		return fechaelaboracionepomini;
	}

	public void setFechaelaboracionepomini(java.util.Date fechaelaboracionepomini) {
		this.fechaelaboracionepomini = fechaelaboracionepomini;
	}

	 public java.util.Date getFechaelaboracionepomfin() {
		return fechaelaboracionepomfin;
	}

	public void setFechaelaboracionepomfin(java.util.Date fechaelaboracionepomfin) {
		this.fechaelaboracionepomfin = fechaelaboracionepomfin;
	}

	 public java.util.Date getFechanotificacionepom() {
		return fechanotificacionepom;
	}

	public void setFechanotificacionepom(java.util.Date fechanotificacionepom) {
		this.fechanotificacionepom = fechanotificacionepom;
	}

	 public java.util.Date getFechanotificacionepomini() {
		return fechanotificacionepomini;
	}

	public void setFechanotificacionepomini(java.util.Date fechanotificacionepomini) {
		this.fechanotificacionepomini = fechanotificacionepomini;
	}

	 public java.util.Date getFechanotificacionepomfin() {
		return fechanotificacionepomfin;
	}

	public void setFechanotificacionepomfin(java.util.Date fechanotificacionepomfin) {
		this.fechanotificacionepomfin = fechanotificacionepomfin;
	}

	 public java.lang.Integer getTiempodemoraepom() {
		return tiempodemoraepom;
	}

	public void setTiempodemoraepom(java.lang.Integer tiempodemoraepom) {
		this.tiempodemoraepom = tiempodemoraepom;
	}

	 public java.lang.Integer getTiempoelaboracionepom() {
		return tiempoelaboracionepom;
	}

	public void setTiempoelaboracionepom(java.lang.Integer tiempoelaboracionepom) {
		this.tiempoelaboracionepom = tiempoelaboracionepom;
	}

	 public java.util.Date getFechasolicitudcp() {
		return fechasolicitudcp;
	}

	public void setFechasolicitudcp(java.util.Date fechasolicitudcp) {
		this.fechasolicitudcp = fechasolicitudcp;
	}

	 public java.util.Date getFechasolicitudcpini() {
		return fechasolicitudcpini;
	}

	public void setFechasolicitudcpini(java.util.Date fechasolicitudcpini) {
		this.fechasolicitudcpini = fechasolicitudcpini;
	}

	 public java.util.Date getFechasolicitudcpfin() {
		return fechasolicitudcpfin;
	}

	public void setFechasolicitudcpfin(java.util.Date fechasolicitudcpfin) {
		this.fechasolicitudcpfin = fechasolicitudcpfin;
	}

	 public java.util.Date getFechacp() {
		return fechacp;
	}

	public void setFechacp(java.util.Date fechacp) {
		this.fechacp = fechacp;
	}

	 public java.util.Date getFechacpini() {
		return fechacpini;
	}

	public void setFechacpini(java.util.Date fechacpini) {
		this.fechacpini = fechacpini;
	}

	 public java.util.Date getFechacpfin() {
		return fechacpfin;
	}

	public void setFechacpfin(java.util.Date fechacpfin) {
		this.fechacpfin = fechacpfin;
	}

	 public java.lang.Integer getNrocp() {
		return nrocp;
	}

	public void setNrocp(java.lang.Integer nrocp) {
		this.nrocp = nrocp;
	}

	 public java.math.BigDecimal getMontocp() {
		return montocp;
	}

	public void setMontocp(java.math.BigDecimal montocp) {
		this.montocp = montocp;
	}

	 public java.math.BigDecimal getMontocpini() {
		return montocpini;
	}

	public void setMontocpini(java.math.BigDecimal montocpini) {
		this.montocpini = montocpini;
	}

	 public java.math.BigDecimal getMontocpfin() {
		return montocpfin;
	}

	public void setMontocpfin(java.math.BigDecimal montocpfin) {
		this.montocpfin = montocpfin;
	}

	 public java.lang.String getTieneprevision() {
		return tieneprevision;
	}

	public void setTieneprevision(java.lang.String tieneprevision) {
		this.tieneprevision = tieneprevision;
	}

	 public Boolean getBooleantieneprevision() {
		return booleantieneprevision;
	}

	public void setBooleantieneprevision(Boolean booleantieneprevision) {
		this.booleantieneprevision = booleantieneprevision;
	}

	 public java.lang.Integer getEsrebajado() {
		return esrebajado;
	}

	public void setEsrebajado(java.lang.Integer esrebajado) {
		this.esrebajado = esrebajado;
	}

	 public java.math.BigDecimal getMontorebajado() {
		return montorebajado;
	}

	public void setMontorebajado(java.math.BigDecimal montorebajado) {
		this.montorebajado = montorebajado;
	}

	 public java.math.BigDecimal getMontorebajadoini() {
		return montorebajadoini;
	}

	public void setMontorebajadoini(java.math.BigDecimal montorebajadoini) {
		this.montorebajadoini = montorebajadoini;
	}

	 public java.math.BigDecimal getMontorebajadofin() {
		return montorebajadofin;
	}

	public void setMontorebajadofin(java.math.BigDecimal montorebajadofin) {
		this.montorebajadofin = montorebajadofin;
	}

	 public java.lang.Integer getNroversionpac() {
		return nroversionpac;
	}

	public void setNroversionpac(java.lang.Integer nroversionpac) {
		this.nroversionpac = nroversionpac;
	}

	 public java.util.Date getFecharesolucionpac() {
		return fecharesolucionpac;
	}

	public void setFecharesolucionpac(java.util.Date fecharesolucionpac) {
		this.fecharesolucionpac = fecharesolucionpac;
	}

	 public java.util.Date getFecharesolucionpacini() {
		return fecharesolucionpacini;
	}

	public void setFecharesolucionpacini(java.util.Date fecharesolucionpacini) {
		this.fecharesolucionpacini = fecharesolucionpacini;
	}

	 public java.util.Date getFecharesolucionpacfin() {
		return fecharesolucionpacfin;
	}

	public void setFecharesolucionpacfin(java.util.Date fecharesolucionpacfin) {
		this.fecharesolucionpacfin = fecharesolucionpacfin;
	}

	 public java.util.Date getFechamodificacionseace() {
		return fechamodificacionseace;
	}

	public void setFechamodificacionseace(java.util.Date fechamodificacionseace) {
		this.fechamodificacionseace = fechamodificacionseace;
	}

	 public java.util.Date getFechamodificacionseaceini() {
		return fechamodificacionseaceini;
	}

	public void setFechamodificacionseaceini(java.util.Date fechamodificacionseaceini) {
		this.fechamodificacionseaceini = fechamodificacionseaceini;
	}

	 public java.util.Date getFechamodificacionseacefin() {
		return fechamodificacionseacefin;
	}

	public void setFechamodificacionseacefin(java.util.Date fechamodificacionseacefin) {
		this.fechamodificacionseacefin = fechamodificacionseacefin;
	}

	 public java.lang.String getCodigotipoproceso() {
		return codigotipoproceso;
	}

	public void setCodigotipoproceso(java.lang.String codigotipoproceso) {
		this.codigotipoproceso = codigotipoproceso;
	}

	 public java.math.BigDecimal getNroproceso() {
		return nroproceso;
	}

	public void setNroproceso(java.math.BigDecimal nroproceso) {
		this.nroproceso = nroproceso;
	}

	 public java.math.BigDecimal getNroprocesoini() {
		return nroprocesoini;
	}

	public void setNroprocesoini(java.math.BigDecimal nroprocesoini) {
		this.nroprocesoini = nroprocesoini;
	}

	 public java.math.BigDecimal getNroprocesofin() {
		return nroprocesofin;
	}

	public void setNroprocesofin(java.math.BigDecimal nroprocesofin) {
		this.nroprocesofin = nroprocesofin;
	}

	 public java.lang.Integer getNroconvocatoria() {
		return nroconvocatoria;
	}

	public void setNroconvocatoria(java.lang.Integer nroconvocatoria) {
		this.nroconvocatoria = nroconvocatoria;
	}

	 public java.lang.String getTiemposervicio() {
		return tiemposervicio;
	}

	public void setTiemposervicio(java.lang.String tiemposervicio) {
		this.tiemposervicio = tiemposervicio;
	}

	 public java.lang.Integer getEstadorequerimiento() {
		return estadorequerimiento;
	}

	public void setEstadorequerimiento(java.lang.Integer estadorequerimiento) {
		this.estadorequerimiento = estadorequerimiento;
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

	 public java.util.Date getFechasolicitudaprobacionexpediente() {
		return fechasolicitudaprobacionexpediente;
	}

	public void setFechasolicitudaprobacionexpediente(java.util.Date fechasolicitudaprobacionexpediente) {
		this.fechasolicitudaprobacionexpediente = fechasolicitudaprobacionexpediente;
	}

	 public java.util.Date getFechasolicitudaprobacionexpedienteini() {
		return fechasolicitudaprobacionexpedienteini;
	}

	public void setFechasolicitudaprobacionexpedienteini(java.util.Date fechasolicitudaprobacionexpedienteini) {
		this.fechasolicitudaprobacionexpedienteini = fechasolicitudaprobacionexpedienteini;
	}

	 public java.util.Date getFechasolicitudaprobacionexpedientefin() {
		return fechasolicitudaprobacionexpedientefin;
	}

	public void setFechasolicitudaprobacionexpedientefin(java.util.Date fechasolicitudaprobacionexpedientefin) {
		this.fechasolicitudaprobacionexpedientefin = fechasolicitudaprobacionexpedientefin;
	}

	 public java.util.Date getFechaaprobacionexpediente() {
		return fechaaprobacionexpediente;
	}

	public void setFechaaprobacionexpediente(java.util.Date fechaaprobacionexpediente) {
		this.fechaaprobacionexpediente = fechaaprobacionexpediente;
	}

	 public java.util.Date getFechaaprobacionexpedienteini() {
		return fechaaprobacionexpedienteini;
	}

	public void setFechaaprobacionexpedienteini(java.util.Date fechaaprobacionexpedienteini) {
		this.fechaaprobacionexpedienteini = fechaaprobacionexpedienteini;
	}

	 public java.util.Date getFechaaprobacionexpedientefin() {
		return fechaaprobacionexpedientefin;
	}

	public void setFechaaprobacionexpedientefin(java.util.Date fechaaprobacionexpedientefin) {
		this.fechaaprobacionexpedientefin = fechaaprobacionexpedientefin;
	}

	 public java.lang.Integer getAnio() {
		return anio;
	}

	public void setAnio(java.lang.Integer anio) {
		this.anio = anio;
	}

	 public java.lang.Integer getIdunidadejecutora() {
		return idunidadejecutora;
	}

	public void setIdunidadejecutora(java.lang.Integer idunidadejecutora) {
		this.idunidadejecutora = idunidadejecutora;
	}

	 public Unidadejecutora getUnidadejecutoraIdunidadejecutora() {
		return unidadejecutoraIdunidadejecutora;
	}

	public void setUnidadejecutoraIdunidadejecutora(Unidadejecutora unidadejecutoraIdunidadejecutora) {
		this.unidadejecutoraIdunidadejecutora = unidadejecutoraIdunidadejecutora;
	}

	 public java.lang.String getFlagaprobacionestandarizacion() {
		return flagaprobacionestandarizacion;
	}

	public void setFlagaprobacionestandarizacion(java.lang.String flagaprobacionestandarizacion) {
		this.flagaprobacionestandarizacion = flagaprobacionestandarizacion;
	}

	 public Boolean getBooleanflagaprobacionestandarizacion() {
		return booleanflagaprobacionestandarizacion;
	}

	public void setBooleanflagaprobacionestandarizacion(Boolean booleanflagaprobacionestandarizacion) {
		this.booleanflagaprobacionestandarizacion = booleanflagaprobacionestandarizacion;
	}

	 public java.lang.String getDocaprobacionestandarizacion() {
		return docaprobacionestandarizacion;
	}

	public void setDocaprobacionestandarizacion(java.lang.String docaprobacionestandarizacion) {
		this.docaprobacionestandarizacion = docaprobacionestandarizacion;
	}

	 public java.util.Date getFechaaprobacionestandarizacion() {
		return fechaaprobacionestandarizacion;
	}

	public void setFechaaprobacionestandarizacion(java.util.Date fechaaprobacionestandarizacion) {
		this.fechaaprobacionestandarizacion = fechaaprobacionestandarizacion;
	}

	 public java.util.Date getFechaaprobacionestandarizacionini() {
		return fechaaprobacionestandarizacionini;
	}

	public void setFechaaprobacionestandarizacionini(java.util.Date fechaaprobacionestandarizacionini) {
		this.fechaaprobacionestandarizacionini = fechaaprobacionestandarizacionini;
	}

	 public java.util.Date getFechaaprobacionestandarizacionfin() {
		return fechaaprobacionestandarizacionfin;
	}

	public void setFechaaprobacionestandarizacionfin(java.util.Date fechaaprobacionestandarizacionfin) {
		this.fechaaprobacionestandarizacionfin = fechaaprobacionestandarizacionfin;
	}

	 public java.util.Date getFechaemisionresumenejecutivo() {
		return fechaemisionresumenejecutivo;
	}

	public void setFechaemisionresumenejecutivo(java.util.Date fechaemisionresumenejecutivo) {
		this.fechaemisionresumenejecutivo = fechaemisionresumenejecutivo;
	}

	 public java.util.Date getFechaemisionresumenejecutivoini() {
		return fechaemisionresumenejecutivoini;
	}

	public void setFechaemisionresumenejecutivoini(java.util.Date fechaemisionresumenejecutivoini) {
		this.fechaemisionresumenejecutivoini = fechaemisionresumenejecutivoini;
	}

	 public java.util.Date getFechaemisionresumenejecutivofin() {
		return fechaemisionresumenejecutivofin;
	}

	public void setFechaemisionresumenejecutivofin(java.util.Date fechaemisionresumenejecutivofin) {
		this.fechaemisionresumenejecutivofin = fechaemisionresumenejecutivofin;
	}

	 public java.lang.String getDetallehonorarios() {
		return detallehonorarios;
	}

	public void setDetallehonorarios(java.lang.String detallehonorarios) {
		this.detallehonorarios = detallehonorarios;
	}

	 public java.lang.String getResolucionpac() {
		return resolucionpac;
	}

	public void setResolucionpac(java.lang.String resolucionpac) {
		this.resolucionpac = resolucionpac;
	}

	 public java.lang.String getDocumentonoprogramado() {
		return documentonoprogramado;
	}

	public void setDocumentonoprogramado(java.lang.String documentonoprogramado) {
		this.documentonoprogramado = documentonoprogramado;
	}

	 public java.lang.String getDocumentoepom() {
		return documentoepom;
	}

	public void setDocumentoepom(java.lang.String documentoepom) {
		this.documentoepom = documentoepom;
	}

	 public java.lang.String getSistemacontratacion() {
		return sistemacontratacion;
	}

	public void setSistemacontratacion(java.lang.String sistemacontratacion) {
		this.sistemacontratacion = sistemacontratacion;
	}

	 public java.lang.String getModalidadseleccion() {
		return modalidadseleccion;
	}

	public void setModalidadseleccion(java.lang.String modalidadseleccion) {
		this.modalidadseleccion = modalidadseleccion;
	}

	 public Boolean getBooleanmodalidadseleccion() {
		return booleanmodalidadseleccion;
	}

	public void setBooleanmodalidadseleccion(Boolean booleanmodalidadseleccion) {
		this.booleanmodalidadseleccion = booleanmodalidadseleccion;
	}

	 public java.lang.String getModalidadcontratacion() {
		return modalidadcontratacion;
	}

	public void setModalidadcontratacion(java.lang.String modalidadcontratacion) {
		this.modalidadcontratacion = modalidadcontratacion;
	}

	 public Boolean getBooleanmodalidadcontratacion() {
		return booleanmodalidadcontratacion;
	}

	public void setBooleanmodalidadcontratacion(Boolean booleanmodalidadcontratacion) {
		this.booleanmodalidadcontratacion = booleanmodalidadcontratacion;
	}

	 public java.lang.String getReajuste() {
		return reajuste;
	}

	public void setReajuste(java.lang.String reajuste) {
		this.reajuste = reajuste;
	}

	 public Boolean getBooleanreajuste() {
		return booleanreajuste;
	}

	public void setBooleanreajuste(Boolean booleanreajuste) {
		this.booleanreajuste = booleanreajuste;
	}

	 public java.lang.String getFlagcd() {
		return flagcd;
	}

	public void setFlagcd(java.lang.String flagcd) {
		this.flagcd = flagcd;
	}

	 public Boolean getBooleanflagcd() {
		return booleanflagcd;
	}

	public void setBooleanflagcd(Boolean booleanflagcd) {
		this.booleanflagcd = booleanflagcd;
	}

	 public java.lang.String getObjetoprocedimiento() {
		return objetoprocedimiento;
	}

	public void setObjetoprocedimiento(java.lang.String objetoprocedimiento) {
		this.objetoprocedimiento = objetoprocedimiento;
	}

	 public java.lang.String getIndagacionvalorestimado() {
		return indagacionvalorestimado;
	}

	public void setIndagacionvalorestimado(java.lang.String indagacionvalorestimado) {
		this.indagacionvalorestimado = indagacionvalorestimado;
	}

	 public Boolean getBooleanindagacionvalorestimado() {
		return booleanindagacionvalorestimado;
	}

	public void setBooleanindagacionvalorestimado(Boolean booleanindagacionvalorestimado) {
		this.booleanindagacionvalorestimado = booleanindagacionvalorestimado;
	}

	 public java.lang.String getNroruc() {
		return nroruc;
	}

	public void setNroruc(java.lang.String nroruc) {
		this.nroruc = nroruc;
	}

	 public java.lang.Integer getNroprocesoproveedor() {
		return nroprocesoproveedor;
	}

	public void setNroprocesoproveedor(java.lang.Integer nroprocesoproveedor) {
		this.nroprocesoproveedor = nroprocesoproveedor;
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

	 public java.lang.Integer getVcertificacion() {
		return vcertificacion;
	}

	public void setVcertificacion(java.lang.Integer vcertificacion) {
		this.vcertificacion = vcertificacion;
	}

	 public Vcertificacion getVcertificacionVcertificacion() {
		return vcertificacionVcertificacion;
	}

	public void setVcertificacionVcertificacion(Vcertificacion vcertificacionVcertificacion) {
		this.vcertificacionVcertificacion = vcertificacionVcertificacion;
	}

	 public java.lang.String getEstadoauditoria() {
		return estadoauditoria;
	}

	public void setEstadoauditoria(java.lang.String estadoauditoria) {
		this.estadoauditoria = estadoauditoria;
	}

	 public java.lang.Integer getVisidsigapaacconsolidado() {
		return visidsigapaacconsolidado;
	}

	public void setVisidsigapaacconsolidado(java.lang.Integer visidsigapaacconsolidado) {
		this.visidsigapaacconsolidado = visidsigapaacconsolidado;
	}

	 public Vissigapaacconsolidado getVissigapaacconsolidadoVisidsigapaacconsolidado() {
		return vissigapaacconsolidadoVisidsigapaacconsolidado;
	}

	public void setVissigapaacconsolidadoVisidsigapaacconsolidado(Vissigapaacconsolidado vissigapaacconsolidadoVisidsigapaacconsolidado) {
		this.vissigapaacconsolidadoVisidsigapaacconsolidado = vissigapaacconsolidadoVisidsigapaacconsolidado;
	}

	 public List<Requisitosconformidad> getListaRequisitosconformidad() {
		return listaRequisitosconformidad;
	}

	public void setListaRequisitosconformidad(List<Requisitosconformidad> listaRequisitosconformidad) {
		this.listaRequisitosconformidad = listaRequisitosconformidad;
	}

	 public List<Orden> getListaOrden() {
		return listaOrden;
	}

	public void setListaOrden(List<Orden> listaOrden) {
		this.listaOrden = listaOrden;
	}

	 public List<Sinadporpacconsolidado> getListaSinadporpacconsolidado() {
		return listaSinadporpacconsolidado;
	}

	public void setListaSinadporpacconsolidado(List<Sinadporpacconsolidado> listaSinadporpacconsolidado) {
		this.listaSinadporpacconsolidado = listaSinadporpacconsolidado;
	}

	 public List<Certificadopresupuestal> getListaCertificadopresupuestal() {
		return listaCertificadopresupuestal;
	}

	public void setListaCertificadopresupuestal(List<Certificadopresupuestal> listaCertificadopresupuestal) {
		this.listaCertificadopresupuestal = listaCertificadopresupuestal;
	}

	 public List<Previsionpresupuestal> getListaPrevisionpresupuestal() {
		return listaPrevisionpresupuestal;
	}

	public void setListaPrevisionpresupuestal(List<Previsionpresupuestal> listaPrevisionpresupuestal) {
		this.listaPrevisionpresupuestal = listaPrevisionpresupuestal;
	}

	 public List<Cuadrocomparativofuente> getListaCuadrocomparativofuente() {
		return listaCuadrocomparativofuente;
	}

	public void setListaCuadrocomparativofuente(List<Cuadrocomparativofuente> listaCuadrocomparativofuente) {
		this.listaCuadrocomparativofuente = listaCuadrocomparativofuente;
	}

}
