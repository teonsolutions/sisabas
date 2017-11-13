
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Orden]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Orden extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idorden;
	/**[Pac ConsolidIn]*/
	private java.lang.Integer idpacconsolidado;
	private Pacconsolidado pacconsolidadoIdpacconsolidado;
	/**[Grupo Documento]*/
	private java.lang.Integer idgrupodocumento;
	private Grupodocumento grupodocumentoIdgrupodocumento;
	/**[Número de Orden]*/
	private java.lang.String nroorden;
	/**[Fecha Orden]*/
	private java.util.Date fechaorden;
	private java.util.Date fechaordenini;
	private java.util.Date fechaordenfin;
	/**[Año Orden]*/
	private java.lang.Integer anioorden;
	/**[Estado Orden]*/
	private java.lang.Integer estadoorden;
	/**[Número Expediente Siaf]*/
	private java.lang.String nroexpedientesiaf;
	/**[Moneda]*/
	private java.lang.String moneda;
	/**[Monto Orden]*/
	private java.math.BigDecimal montoorden;
	private java.math.BigDecimal montoordenini;
	private java.math.BigDecimal montoordenfin;
	/**[Número de Proceso]*/
	private java.lang.String nroproceso;
	/**[Número de Contrato]*/
	private java.lang.String nrocontrato;
	/**[Estado Expediente Siaf]*/
	private java.lang.Integer estadoexpedientesiaf;
	/**[Fecha Inicio Prestación]*/
	private java.util.Date fechainicioprestacion;
	private java.util.Date fechainicioprestacionini;
	private java.util.Date fechainicioprestacionfin;
	/**[Catálogo Tipo Bien][TIBI]*/
	private java.lang.String idcatalogotipobien;
	private Gentabla gentablaIdcatalogotipobien;
	/**[Fecha Fin Prestación]*/
	private java.util.Date fechafinprestacion;
	private java.util.Date fechafinprestacionini;
	private java.util.Date fechafinprestacionfin;
	/**[Ejercicio]*/
	private java.lang.Integer anio;
	/**[Codigo Unidad Ejecutora]*/
	private java.lang.Integer idunidadejecutora;
	private Unidadejecutora unidadejecutoraIdunidadejecutora;
	/**[Plazo Ejecución]*/
	private java.lang.Integer plazoejecucion;
	/**[*][Fecha de Creación]*/
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
	private List<Entregable> listaEntregable;

	public Orden() {}

	public Orden(java.lang.Integer idorden) {
		this.idorden=idorden;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Orden)
			return ((Orden)obj).getIdorden().equals(this.getIdorden()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idorden!=null)?("idorden:\t" + this.idorden+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.nroorden!=null)?("nroorden:\t" + this.nroorden+"\n"):"" ).concat(
			(this.fechaorden!=null)?("fechaorden:\t" + this.fechaorden+"\n"):"" ).concat(
			(this.anioorden!=null)?("anioorden:\t" + this.anioorden+"\n"):"" ).concat(
			(this.estadoorden!=null)?("estadoorden:\t" + this.estadoorden+"\n"):"" ).concat(
			(this.nroexpedientesiaf!=null)?("nroexpedientesiaf:\t" + this.nroexpedientesiaf+"\n"):"" ).concat(
			(this.moneda!=null)?("moneda:\t" + this.moneda+"\n"):"" ).concat(
			(this.montoorden!=null)?("montoorden:\t" + this.montoorden+"\n"):"" ).concat(
			(this.nroproceso!=null)?("nroproceso:\t" + this.nroproceso+"\n"):"" ).concat(
			(this.nrocontrato!=null)?("nrocontrato:\t" + this.nrocontrato+"\n"):"" ).concat(
			(this.estadoexpedientesiaf!=null)?("estadoexpedientesiaf:\t" + this.estadoexpedientesiaf+"\n"):"" ).concat(
			(this.fechainicioprestacion!=null)?("fechainicioprestacion:\t" + this.fechainicioprestacion+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.fechafinprestacion!=null)?("fechafinprestacion:\t" + this.fechafinprestacion+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.plazoejecucion!=null)?("plazoejecucion:\t" + this.plazoejecucion+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idorden!=null)?("idorden:\t" + this.idorden+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.pacconsolidadoIdpacconsolidado!=null)?("pacconsolidadoIdpacconsolidado:\t" + this.pacconsolidadoIdpacconsolidado.toString()+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.grupodocumentoIdgrupodocumento!=null)?("grupodocumentoIdgrupodocumento:\t" + this.grupodocumentoIdgrupodocumento.toString()+"\n"):"" ).concat(
			(this.nroorden!=null)?("nroorden:\t" + this.nroorden+"\n"):"" ).concat(
			(this.fechaorden!=null)?("fechaorden:\t" + this.fechaorden+"\n"):"" ).concat(
			(this.anioorden!=null)?("anioorden:\t" + this.anioorden+"\n"):"" ).concat(
			(this.estadoorden!=null)?("estadoorden:\t" + this.estadoorden+"\n"):"" ).concat(
			(this.nroexpedientesiaf!=null)?("nroexpedientesiaf:\t" + this.nroexpedientesiaf+"\n"):"" ).concat(
			(this.moneda!=null)?("moneda:\t" + this.moneda+"\n"):"" ).concat(
			(this.montoorden!=null)?("montoorden:\t" + this.montoorden+"\n"):"" ).concat(
			(this.nroproceso!=null)?("nroproceso:\t" + this.nroproceso+"\n"):"" ).concat(
			(this.nrocontrato!=null)?("nrocontrato:\t" + this.nrocontrato+"\n"):"" ).concat(
			(this.estadoexpedientesiaf!=null)?("estadoexpedientesiaf:\t" + this.estadoexpedientesiaf+"\n"):"" ).concat(
			(this.fechainicioprestacion!=null)?("fechainicioprestacion:\t" + this.fechainicioprestacion+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipobien!=null)?("gentablaIdcatalogotipobien:\t" + this.gentablaIdcatalogotipobien.toString()+"\n"):"" ).concat(
			(this.fechafinprestacion!=null)?("fechafinprestacion:\t" + this.fechafinprestacion+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.unidadejecutoraIdunidadejecutora!=null)?("unidadejecutoraIdunidadejecutora:\t" + this.unidadejecutoraIdunidadejecutora.toString()+"\n"):"" ).concat(
			(this.plazoejecucion!=null)?("plazoejecucion:\t" + this.plazoejecucion+"\n"):"" ).concat(
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
		if(this.montoorden!=null)
			montoorden=Utils.round(montoorden);

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


	 public java.lang.Integer getIdorden() {
		return idorden;
	}

	public void setIdorden(java.lang.Integer idorden) {
		this.idorden = idorden;
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

	 public java.lang.String getNroorden() {
		return nroorden;
	}

	public void setNroorden(java.lang.String nroorden) {
		this.nroorden = nroorden;
	}

	 public java.util.Date getFechaorden() {
		return fechaorden;
	}

	public void setFechaorden(java.util.Date fechaorden) {
		this.fechaorden = fechaorden;
	}

	 public java.util.Date getFechaordenini() {
		return fechaordenini;
	}

	public void setFechaordenini(java.util.Date fechaordenini) {
		this.fechaordenini = fechaordenini;
	}

	 public java.util.Date getFechaordenfin() {
		return fechaordenfin;
	}

	public void setFechaordenfin(java.util.Date fechaordenfin) {
		this.fechaordenfin = fechaordenfin;
	}

	 public java.lang.Integer getAnioorden() {
		return anioorden;
	}

	public void setAnioorden(java.lang.Integer anioorden) {
		this.anioorden = anioorden;
	}

	 public java.lang.Integer getEstadoorden() {
		return estadoorden;
	}

	public void setEstadoorden(java.lang.Integer estadoorden) {
		this.estadoorden = estadoorden;
	}

	 public java.lang.String getNroexpedientesiaf() {
		return nroexpedientesiaf;
	}

	public void setNroexpedientesiaf(java.lang.String nroexpedientesiaf) {
		this.nroexpedientesiaf = nroexpedientesiaf;
	}

	 public java.lang.String getMoneda() {
		return moneda;
	}

	public void setMoneda(java.lang.String moneda) {
		this.moneda = moneda;
	}

	 public java.math.BigDecimal getMontoorden() {
		return montoorden;
	}

	public void setMontoorden(java.math.BigDecimal montoorden) {
		this.montoorden = montoorden;
	}

	 public java.math.BigDecimal getMontoordenini() {
		return montoordenini;
	}

	public void setMontoordenini(java.math.BigDecimal montoordenini) {
		this.montoordenini = montoordenini;
	}

	 public java.math.BigDecimal getMontoordenfin() {
		return montoordenfin;
	}

	public void setMontoordenfin(java.math.BigDecimal montoordenfin) {
		this.montoordenfin = montoordenfin;
	}

	 public java.lang.String getNroproceso() {
		return nroproceso;
	}

	public void setNroproceso(java.lang.String nroproceso) {
		this.nroproceso = nroproceso;
	}

	 public java.lang.String getNrocontrato() {
		return nrocontrato;
	}

	public void setNrocontrato(java.lang.String nrocontrato) {
		this.nrocontrato = nrocontrato;
	}

	 public java.lang.Integer getEstadoexpedientesiaf() {
		return estadoexpedientesiaf;
	}

	public void setEstadoexpedientesiaf(java.lang.Integer estadoexpedientesiaf) {
		this.estadoexpedientesiaf = estadoexpedientesiaf;
	}

	 public java.util.Date getFechainicioprestacion() {
		return fechainicioprestacion;
	}

	public void setFechainicioprestacion(java.util.Date fechainicioprestacion) {
		this.fechainicioprestacion = fechainicioprestacion;
	}

	 public java.util.Date getFechainicioprestacionini() {
		return fechainicioprestacionini;
	}

	public void setFechainicioprestacionini(java.util.Date fechainicioprestacionini) {
		this.fechainicioprestacionini = fechainicioprestacionini;
	}

	 public java.util.Date getFechainicioprestacionfin() {
		return fechainicioprestacionfin;
	}

	public void setFechainicioprestacionfin(java.util.Date fechainicioprestacionfin) {
		this.fechainicioprestacionfin = fechainicioprestacionfin;
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

	 public java.util.Date getFechafinprestacion() {
		return fechafinprestacion;
	}

	public void setFechafinprestacion(java.util.Date fechafinprestacion) {
		this.fechafinprestacion = fechafinprestacion;
	}

	 public java.util.Date getFechafinprestacionini() {
		return fechafinprestacionini;
	}

	public void setFechafinprestacionini(java.util.Date fechafinprestacionini) {
		this.fechafinprestacionini = fechafinprestacionini;
	}

	 public java.util.Date getFechafinprestacionfin() {
		return fechafinprestacionfin;
	}

	public void setFechafinprestacionfin(java.util.Date fechafinprestacionfin) {
		this.fechafinprestacionfin = fechafinprestacionfin;
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

	 public java.lang.Integer getPlazoejecucion() {
		return plazoejecucion;
	}

	public void setPlazoejecucion(java.lang.Integer plazoejecucion) {
		this.plazoejecucion = plazoejecucion;
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

	 public List<Entregable> getListaEntregable() {
		return listaEntregable;
	}

	public void setListaEntregable(List<Entregable> listaEntregable) {
		this.listaEntregable = listaEntregable;
	}

}
