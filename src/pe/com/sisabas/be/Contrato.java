
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Contrato]
*@author Gandalf
*@since 30/01/2018
*@version gandalf 4.0*/
public class Contrato extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[Id]*/
	private java.lang.Integer idcontrato;
	/**[Unidad Ejecutora]*/
	private java.lang.Integer idunidadejecutora;
	private Unidadejecutora unidadejecutoraIdunidadejecutora;
	/**[Numero de Items]*/
	private java.lang.Integer nroitems;
	/**[Sistema Adquisicion][SIAD]*/
	private java.lang.String idcatalogosistemaadquisicion;
	private Gentabla gentablaIdcatalogosistemaadquisicion;
	/**[Grupo documento]*/
	private java.lang.Integer idgrupodocumento;
	private Grupodocumento grupodocumentoIdgrupodocumento;
	/**[Tipo Contrato][TICO]*/
	private java.lang.String idcatalogotipocontrato;
	private Gentabla gentablaIdcatalogotipocontrato;
	/**[Número Contrato]*/
	private java.lang.Integer nrocontrato;
	/**[Secuencia Contrato]*/
	private java.lang.Integer secuenciacontrato;
	/**[Numero CPP]*/
	private java.lang.String nroccp;
	/**[Tipo Bien][TIBI]*/
	private java.lang.String idcatalogotipobien;
	private Gentabla gentablaIdcatalogotipobien;
	/**[Proveedor]*/
	private java.lang.Integer idproveedor;
	/**[Estado Contrato]*/
	private java.lang.Integer estadocontrato;
	/**[Fecha Inicial]*/
	private java.util.Date fechainicial;
	private java.util.Date fechainicialini;
	private java.util.Date fechainicialfin;
	/**[Fecha Fin]*/
	private java.util.Date fechafin;
	private java.util.Date fechafinini;
	private java.util.Date fechafinfin;
	/**[Moneda]*/
	private java.lang.String moneda;
	/**[Monto Contrato]*/
	private java.math.BigDecimal montocontrato;
	private java.math.BigDecimal montocontratoini;
	private java.math.BigDecimal montocontratofin;
	/**[Monto Certificacion]*/
	private java.math.BigDecimal montocertificacion;
	private java.math.BigDecimal montocertificacionini;
	private java.math.BigDecimal montocertificacionfin;
	/**[Fecha Contrato]*/
	private java.util.Date fechacontrato;
	private java.util.Date fechacontratoini;
	private java.util.Date fechacontratofin;
	/**[Tiene Prevision]*/
	private java.lang.String tieneprevision;
	/**[Plazo Ejecucion]*/
	private java.lang.Integer plazoejecucion;
	/**[Cantidad Armadas]*/
	private java.lang.Integer cantidadarmadas;
	/**[Fecha Recepcion Expediente]*/
	private java.util.Date fecharecepcionexpediente;
	private java.util.Date fecharecepcionexpedienteini;
	private java.util.Date fecharecepcionexpedientefin;
	/**[Dni Abogado]*/
	private java.lang.String dniabogado;
	/**[Dni Especialista Ejecucion]*/
	private java.lang.String dniespecialistaejecucion;
	/**[Sinad Contrato]*/
	private java.lang.String sinadcontrato;
	/**[Anio Sinad Contrato]*/
	private java.lang.Integer aniosinadcontrato;
	/**[Nombre Abogado]*/
	private java.lang.String nombreabogado;
	/**[Nombre Especialista]*/
	private java.lang.String nombreespecialista;
	/**[Numero Expediente]*/
	private java.lang.String numeroexpediente;
	/**[Anio]*/
	private java.lang.Integer anio;
	/**[Numero Consolidado]*/
	private java.lang.Integer nroconsolid;
	/**[Ruta Contrato]*/
	private java.lang.String rutacontrato;
	/**[Estado Documentacion]*/
	private java.lang.String idcatalogoestadodocumentacion;
	private Gentabla gentablaIdcatalogoestadodocumentacion;
	/**[*][Fecha Creacion Auditoria]*/
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
	private List<Adenda> listaAdenda;
	private List<Previsionporcontrato> listaPrevisionporcontrato;

	public Contrato() {}

	public Contrato(java.lang.Integer idcontrato) {
		this.idcontrato=idcontrato;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Contrato)
			return ((Contrato)obj).getIdcontrato().equals(this.getIdcontrato()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idcontrato!=null)?("idcontrato:\t" + this.idcontrato+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.nroitems!=null)?("nroitems:\t" + this.nroitems+"\n"):"" ).concat(
			(this.idcatalogosistemaadquisicion!=null)?("idcatalogosistemaadquisicion:\t" + this.idcatalogosistemaadquisicion+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.idcatalogotipocontrato!=null)?("idcatalogotipocontrato:\t" + this.idcatalogotipocontrato+"\n"):"" ).concat(
			(this.nrocontrato!=null)?("nrocontrato:\t" + this.nrocontrato+"\n"):"" ).concat(
			(this.secuenciacontrato!=null)?("secuenciacontrato:\t" + this.secuenciacontrato+"\n"):"" ).concat(
			(this.nroccp!=null)?("nroccp:\t" + this.nroccp+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.idproveedor!=null)?("idproveedor:\t" + this.idproveedor+"\n"):"" ).concat(
			(this.estadocontrato!=null)?("estadocontrato:\t" + this.estadocontrato+"\n"):"" ).concat(
			(this.fechainicial!=null)?("fechainicial:\t" + this.fechainicial+"\n"):"" ).concat(
			(this.fechafin!=null)?("fechafin:\t" + this.fechafin+"\n"):"" ).concat(
			(this.moneda!=null)?("moneda:\t" + this.moneda+"\n"):"" ).concat(
			(this.montocontrato!=null)?("montocontrato:\t" + this.montocontrato+"\n"):"" ).concat(
			(this.montocertificacion!=null)?("montocertificacion:\t" + this.montocertificacion+"\n"):"" ).concat(
			(this.fechacontrato!=null)?("fechacontrato:\t" + this.fechacontrato+"\n"):"" ).concat(
			(this.tieneprevision!=null)?("tieneprevision:\t" + this.tieneprevision+"\n"):"" ).concat(
			(this.plazoejecucion!=null)?("plazoejecucion:\t" + this.plazoejecucion+"\n"):"" ).concat(
			(this.cantidadarmadas!=null)?("cantidadarmadas:\t" + this.cantidadarmadas+"\n"):"" ).concat(
			(this.fecharecepcionexpediente!=null)?("fecharecepcionexpediente:\t" + this.fecharecepcionexpediente+"\n"):"" ).concat(
			(this.dniabogado!=null)?("dniabogado:\t" + this.dniabogado+"\n"):"" ).concat(
			(this.dniespecialistaejecucion!=null)?("dniespecialistaejecucion:\t" + this.dniespecialistaejecucion+"\n"):"" ).concat(
			(this.sinadcontrato!=null)?("sinadcontrato:\t" + this.sinadcontrato+"\n"):"" ).concat(
			(this.aniosinadcontrato!=null)?("aniosinadcontrato:\t" + this.aniosinadcontrato+"\n"):"" ).concat(
			(this.nombreabogado!=null)?("nombreabogado:\t" + this.nombreabogado+"\n"):"" ).concat(
			(this.nombreespecialista!=null)?("nombreespecialista:\t" + this.nombreespecialista+"\n"):"" ).concat(
			(this.numeroexpediente!=null)?("numeroexpediente:\t" + this.numeroexpediente+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.nroconsolid!=null)?("nroconsolid:\t" + this.nroconsolid+"\n"):"" ).concat(
			(this.rutacontrato!=null)?("rutacontrato:\t" + this.rutacontrato+"\n"):"" ).concat(
			(this.idcatalogoestadodocumentacion!=null)?("idcatalogoestadodocumentacion:\t" + this.idcatalogoestadodocumentacion+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idcontrato!=null)?("idcontrato:\t" + this.idcontrato+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.unidadejecutoraIdunidadejecutora!=null)?("unidadejecutoraIdunidadejecutora:\t" + this.unidadejecutoraIdunidadejecutora.toString()+"\n"):"" ).concat(
			(this.nroitems!=null)?("nroitems:\t" + this.nroitems+"\n"):"" ).concat(
			(this.idcatalogosistemaadquisicion!=null)?("idcatalogosistemaadquisicion:\t" + this.idcatalogosistemaadquisicion+"\n"):"" ).concat(
			(this.gentablaIdcatalogosistemaadquisicion!=null)?("gentablaIdcatalogosistemaadquisicion:\t" + this.gentablaIdcatalogosistemaadquisicion.toString()+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.grupodocumentoIdgrupodocumento!=null)?("grupodocumentoIdgrupodocumento:\t" + this.grupodocumentoIdgrupodocumento.toString()+"\n"):"" ).concat(
			(this.idcatalogotipocontrato!=null)?("idcatalogotipocontrato:\t" + this.idcatalogotipocontrato+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipocontrato!=null)?("gentablaIdcatalogotipocontrato:\t" + this.gentablaIdcatalogotipocontrato.toString()+"\n"):"" ).concat(
			(this.nrocontrato!=null)?("nrocontrato:\t" + this.nrocontrato+"\n"):"" ).concat(
			(this.secuenciacontrato!=null)?("secuenciacontrato:\t" + this.secuenciacontrato+"\n"):"" ).concat(
			(this.nroccp!=null)?("nroccp:\t" + this.nroccp+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipobien!=null)?("gentablaIdcatalogotipobien:\t" + this.gentablaIdcatalogotipobien.toString()+"\n"):"" ).concat(
			(this.idproveedor!=null)?("idproveedor:\t" + this.idproveedor+"\n"):"" ).concat(
			(this.estadocontrato!=null)?("estadocontrato:\t" + this.estadocontrato+"\n"):"" ).concat(
			(this.fechainicial!=null)?("fechainicial:\t" + this.fechainicial+"\n"):"" ).concat(
			(this.fechafin!=null)?("fechafin:\t" + this.fechafin+"\n"):"" ).concat(
			(this.moneda!=null)?("moneda:\t" + this.moneda+"\n"):"" ).concat(
			(this.montocontrato!=null)?("montocontrato:\t" + this.montocontrato+"\n"):"" ).concat(
			(this.montocertificacion!=null)?("montocertificacion:\t" + this.montocertificacion+"\n"):"" ).concat(
			(this.fechacontrato!=null)?("fechacontrato:\t" + this.fechacontrato+"\n"):"" ).concat(
			(this.tieneprevision!=null)?("tieneprevision:\t" + this.tieneprevision+"\n"):"" ).concat(
			(this.plazoejecucion!=null)?("plazoejecucion:\t" + this.plazoejecucion+"\n"):"" ).concat(
			(this.cantidadarmadas!=null)?("cantidadarmadas:\t" + this.cantidadarmadas+"\n"):"" ).concat(
			(this.fecharecepcionexpediente!=null)?("fecharecepcionexpediente:\t" + this.fecharecepcionexpediente+"\n"):"" ).concat(
			(this.dniabogado!=null)?("dniabogado:\t" + this.dniabogado+"\n"):"" ).concat(
			(this.dniespecialistaejecucion!=null)?("dniespecialistaejecucion:\t" + this.dniespecialistaejecucion+"\n"):"" ).concat(
			(this.sinadcontrato!=null)?("sinadcontrato:\t" + this.sinadcontrato+"\n"):"" ).concat(
			(this.aniosinadcontrato!=null)?("aniosinadcontrato:\t" + this.aniosinadcontrato+"\n"):"" ).concat(
			(this.nombreabogado!=null)?("nombreabogado:\t" + this.nombreabogado+"\n"):"" ).concat(
			(this.nombreespecialista!=null)?("nombreespecialista:\t" + this.nombreespecialista+"\n"):"" ).concat(
			(this.numeroexpediente!=null)?("numeroexpediente:\t" + this.numeroexpediente+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.nroconsolid!=null)?("nroconsolid:\t" + this.nroconsolid+"\n"):"" ).concat(
			(this.rutacontrato!=null)?("rutacontrato:\t" + this.rutacontrato+"\n"):"" ).concat(
			(this.idcatalogoestadodocumentacion!=null)?("idcatalogoestadodocumentacion:\t" + this.idcatalogoestadodocumentacion+"\n"):"" ).concat(
			(this.gentablaIdcatalogoestadodocumentacion!=null)?("gentablaIdcatalogoestadodocumentacion:\t" + this.gentablaIdcatalogoestadodocumentacion.toString()+"\n"):"" ).concat(
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
		if(this.montocontrato!=null)
			montocontrato=Utils.round(montocontrato);
		if(this.montocertificacion!=null)
			montocertificacion=Utils.round(montocertificacion);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
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

	private List<java.lang.String> listaIdcatalogosistemaadquisicionInKeys;
	public void addConditionInIdcatalogosistemaadquisicion(List<String> list){
		if(list==null || list.size()==0){
			idcatalogosistemaadquisicion=null;
			idcatalogosistemaadquisicion=null;
			listaIdcatalogosistemaadquisicionInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogosistemaadquisicion=list.get(0);
			listaIdcatalogosistemaadquisicionInKeys=null;
		}else{
			idcatalogosistemaadquisicion=null;
			listaIdcatalogosistemaadquisicionInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogosistemaadquisicionInKeys() {
		return listaIdcatalogosistemaadquisicionInKeys;
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

	private List<java.lang.String> listaIdcatalogotipocontratoInKeys;
	public void addConditionInIdcatalogotipocontrato(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipocontrato=null;
			idcatalogotipocontrato=null;
			listaIdcatalogotipocontratoInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipocontrato=list.get(0);
			listaIdcatalogotipocontratoInKeys=null;
		}else{
			idcatalogotipocontrato=null;
			listaIdcatalogotipocontratoInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipocontratoInKeys() {
		return listaIdcatalogotipocontratoInKeys;
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

	private List<java.lang.String> listaIdcatalogoestadodocumentacionInKeys;
	public void addConditionInIdcatalogoestadodocumentacion(List<String> list){
		if(list==null || list.size()==0){
			idcatalogoestadodocumentacion=null;
			idcatalogoestadodocumentacion=null;
			listaIdcatalogoestadodocumentacionInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogoestadodocumentacion=list.get(0);
			listaIdcatalogoestadodocumentacionInKeys=null;
		}else{
			idcatalogoestadodocumentacion=null;
			listaIdcatalogoestadodocumentacionInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogoestadodocumentacionInKeys() {
		return listaIdcatalogoestadodocumentacionInKeys;
	}


	 public java.lang.Integer getIdcontrato() {
		return idcontrato;
	}

	public void setIdcontrato(java.lang.Integer idcontrato) {
		this.idcontrato = idcontrato;
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

	 public java.lang.Integer getNroitems() {
		return nroitems;
	}

	public void setNroitems(java.lang.Integer nroitems) {
		this.nroitems = nroitems;
	}

	 public java.lang.String getIdcatalogosistemaadquisicion() {
		return idcatalogosistemaadquisicion;
	}

	public void setIdcatalogosistemaadquisicion(java.lang.String idcatalogosistemaadquisicion) {
		this.idcatalogosistemaadquisicion = idcatalogosistemaadquisicion;
	}

	 public Gentabla getGentablaIdcatalogosistemaadquisicion() {
		return gentablaIdcatalogosistemaadquisicion;
	}

	public void setGentablaIdcatalogosistemaadquisicion(Gentabla gentablaIdcatalogosistemaadquisicion) {
		this.gentablaIdcatalogosistemaadquisicion = gentablaIdcatalogosistemaadquisicion;
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

	 public java.lang.String getIdcatalogotipocontrato() {
		return idcatalogotipocontrato;
	}

	public void setIdcatalogotipocontrato(java.lang.String idcatalogotipocontrato) {
		this.idcatalogotipocontrato = idcatalogotipocontrato;
	}

	 public Gentabla getGentablaIdcatalogotipocontrato() {
		return gentablaIdcatalogotipocontrato;
	}

	public void setGentablaIdcatalogotipocontrato(Gentabla gentablaIdcatalogotipocontrato) {
		this.gentablaIdcatalogotipocontrato = gentablaIdcatalogotipocontrato;
	}

	 public java.lang.Integer getNrocontrato() {
		return nrocontrato;
	}

	public void setNrocontrato(java.lang.Integer nrocontrato) {
		this.nrocontrato = nrocontrato;
	}

	 public java.lang.Integer getSecuenciacontrato() {
		return secuenciacontrato;
	}

	public void setSecuenciacontrato(java.lang.Integer secuenciacontrato) {
		this.secuenciacontrato = secuenciacontrato;
	}

	 public java.lang.String getNroccp() {
		return nroccp;
	}

	public void setNroccp(java.lang.String nroccp) {
		this.nroccp = nroccp;
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

	 public java.lang.Integer getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(java.lang.Integer idproveedor) {
		this.idproveedor = idproveedor;
	}

	 public java.lang.Integer getEstadocontrato() {
		return estadocontrato;
	}

	public void setEstadocontrato(java.lang.Integer estadocontrato) {
		this.estadocontrato = estadocontrato;
	}

	 public java.util.Date getFechainicial() {
		return fechainicial;
	}

	public void setFechainicial(java.util.Date fechainicial) {
		this.fechainicial = fechainicial;
	}

	 public java.util.Date getFechainicialini() {
		return fechainicialini;
	}

	public void setFechainicialini(java.util.Date fechainicialini) {
		this.fechainicialini = fechainicialini;
	}

	 public java.util.Date getFechainicialfin() {
		return fechainicialfin;
	}

	public void setFechainicialfin(java.util.Date fechainicialfin) {
		this.fechainicialfin = fechainicialfin;
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

	 public java.lang.String getMoneda() {
		return moneda;
	}

	public void setMoneda(java.lang.String moneda) {
		this.moneda = moneda;
	}

	 public java.math.BigDecimal getMontocontrato() {
		return montocontrato;
	}

	public void setMontocontrato(java.math.BigDecimal montocontrato) {
		this.montocontrato = montocontrato;
	}

	 public java.math.BigDecimal getMontocontratoini() {
		return montocontratoini;
	}

	public void setMontocontratoini(java.math.BigDecimal montocontratoini) {
		this.montocontratoini = montocontratoini;
	}

	 public java.math.BigDecimal getMontocontratofin() {
		return montocontratofin;
	}

	public void setMontocontratofin(java.math.BigDecimal montocontratofin) {
		this.montocontratofin = montocontratofin;
	}

	 public java.math.BigDecimal getMontocertificacion() {
		return montocertificacion;
	}

	public void setMontocertificacion(java.math.BigDecimal montocertificacion) {
		this.montocertificacion = montocertificacion;
	}

	 public java.math.BigDecimal getMontocertificacionini() {
		return montocertificacionini;
	}

	public void setMontocertificacionini(java.math.BigDecimal montocertificacionini) {
		this.montocertificacionini = montocertificacionini;
	}

	 public java.math.BigDecimal getMontocertificacionfin() {
		return montocertificacionfin;
	}

	public void setMontocertificacionfin(java.math.BigDecimal montocertificacionfin) {
		this.montocertificacionfin = montocertificacionfin;
	}

	 public java.util.Date getFechacontrato() {
		return fechacontrato;
	}

	public void setFechacontrato(java.util.Date fechacontrato) {
		this.fechacontrato = fechacontrato;
	}

	 public java.util.Date getFechacontratoini() {
		return fechacontratoini;
	}

	public void setFechacontratoini(java.util.Date fechacontratoini) {
		this.fechacontratoini = fechacontratoini;
	}

	 public java.util.Date getFechacontratofin() {
		return fechacontratofin;
	}

	public void setFechacontratofin(java.util.Date fechacontratofin) {
		this.fechacontratofin = fechacontratofin;
	}

	 public java.lang.String getTieneprevision() {
		return tieneprevision;
	}

	public void setTieneprevision(java.lang.String tieneprevision) {
		this.tieneprevision = tieneprevision;
	}

	 public java.lang.Integer getPlazoejecucion() {
		return plazoejecucion;
	}

	public void setPlazoejecucion(java.lang.Integer plazoejecucion) {
		this.plazoejecucion = plazoejecucion;
	}

	 public java.lang.Integer getCantidadarmadas() {
		return cantidadarmadas;
	}

	public void setCantidadarmadas(java.lang.Integer cantidadarmadas) {
		this.cantidadarmadas = cantidadarmadas;
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

	 public java.lang.String getDniabogado() {
		return dniabogado;
	}

	public void setDniabogado(java.lang.String dniabogado) {
		this.dniabogado = dniabogado;
	}

	 public java.lang.String getDniespecialistaejecucion() {
		return dniespecialistaejecucion;
	}

	public void setDniespecialistaejecucion(java.lang.String dniespecialistaejecucion) {
		this.dniespecialistaejecucion = dniespecialistaejecucion;
	}

	 public java.lang.String getSinadcontrato() {
		return sinadcontrato;
	}

	public void setSinadcontrato(java.lang.String sinadcontrato) {
		this.sinadcontrato = sinadcontrato;
	}

	 public java.lang.Integer getAniosinadcontrato() {
		return aniosinadcontrato;
	}

	public void setAniosinadcontrato(java.lang.Integer aniosinadcontrato) {
		this.aniosinadcontrato = aniosinadcontrato;
	}

	 public java.lang.String getNombreabogado() {
		return nombreabogado;
	}

	public void setNombreabogado(java.lang.String nombreabogado) {
		this.nombreabogado = nombreabogado;
	}

	 public java.lang.String getNombreespecialista() {
		return nombreespecialista;
	}

	public void setNombreespecialista(java.lang.String nombreespecialista) {
		this.nombreespecialista = nombreespecialista;
	}

	 public java.lang.String getNumeroexpediente() {
		return numeroexpediente;
	}

	public void setNumeroexpediente(java.lang.String numeroexpediente) {
		this.numeroexpediente = numeroexpediente;
	}

	 public java.lang.Integer getAnio() {
		return anio;
	}

	public void setAnio(java.lang.Integer anio) {
		this.anio = anio;
	}

	 public java.lang.Integer getNroconsolid() {
		return nroconsolid;
	}

	public void setNroconsolid(java.lang.Integer nroconsolid) {
		this.nroconsolid = nroconsolid;
	}

	 public java.lang.String getRutacontrato() {
		return rutacontrato;
	}

	public void setRutacontrato(java.lang.String rutacontrato) {
		this.rutacontrato = rutacontrato;
	}

	 public java.lang.String getIdcatalogoestadodocumentacion() {
		return idcatalogoestadodocumentacion;
	}

	public void setIdcatalogoestadodocumentacion(java.lang.String idcatalogoestadodocumentacion) {
		this.idcatalogoestadodocumentacion = idcatalogoestadodocumentacion;
	}

	 public Gentabla getGentablaIdcatalogoestadodocumentacion() {
		return gentablaIdcatalogoestadodocumentacion;
	}

	public void setGentablaIdcatalogoestadodocumentacion(Gentabla gentablaIdcatalogoestadodocumentacion) {
		this.gentablaIdcatalogoestadodocumentacion = gentablaIdcatalogoestadodocumentacion;
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

	 public List<Adenda> getListaAdenda() {
		return listaAdenda;
	}

	public void setListaAdenda(List<Adenda> listaAdenda) {
		this.listaAdenda = listaAdenda;
	}

	 public List<Previsionporcontrato> getListaPrevisionporcontrato() {
		return listaPrevisionporcontrato;
	}

	public void setListaPrevisionporcontrato(List<Previsionporcontrato> listaPrevisionporcontrato) {
		this.listaPrevisionporcontrato = listaPrevisionporcontrato;
	}

}
