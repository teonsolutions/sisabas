
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[PedidoIn]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Pedido extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[*][Id pedido]*/
	private java.lang.Integer idpedido;
	/**[Nro pedido]*/
	private java.lang.String nropedido;
	/**[Tipo de bien(SIGA)][TIBI]*/
	private java.lang.String idcatalogotipobien;
	private Gentabla gentablaIdcatalogotipobien;
	/**[Periódo]*/
	private java.lang.Integer idperiodo;
	private Periodo periodoIdperiodo;
	/**[Centro costo]*/
	private java.lang.String codigocentrocosto;
	private Vcentrocosto vcentrocostoCodigocentrocosto;
	/**[*][Ejercicio]*/
	private java.lang.Integer anio;
	/**[Nombre de dependencia]*/
	private java.lang.String nombredependencia;
	/**[Descripción]*/
	private java.lang.String descripcionpedidosiga;
	/**[Monto del Pedido]*/
	private java.math.BigDecimal montopedido;
	private java.math.BigDecimal montopedidoini;
	private java.math.BigDecimal montopedidofin;
	/**[Estado pedido][EPED]*/
	private java.lang.Integer estadopedido;
	/**[Número Sindad]*/
	private java.lang.Integer numerosinad;
	/**[Año Sinad]*/
	private java.lang.Integer aniosinad;
	/**[Número de expediente (SINAD)]*/
	private java.lang.String numeroexpedientesinad;
	/**[Fecha pedido]*/
	private java.util.Date fechapedido;
	private java.util.Date fechapedidoini;
	private java.util.Date fechapedidofin;
	/**[*][Fecha creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario creación]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha modificación]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario modificación]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[Tipo de Necesidad][TINE]*/
	private java.lang.String idcatalogotiponecesidad;
	private Gentabla gentablaIdcatalogotiponecesidad;
	/**[Unidad Ejecutora]*/
	private java.lang.Integer idunidadejecutora;
	private Unidadejecutora unidadejecutoraIdunidadejecutora;
	/**[*][Tipo de Documento]*/
	private java.lang.String tipodocumentosinad;
	/**[*][Número de Documento]*/
	private java.lang.String numerodocumentosinad;
	/**[Tipo de Sinad][boolean]*/
	private java.lang.String tiposinad;
	private Boolean booleantiposinad;
	/**[*][Equipo auditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa auditoria]*/
	private java.lang.String programaauditoria;
	/**[Idv Pedido]*/
	private java.lang.Integer idvpedido;
	private Vispedido vispedidoIdvpedido;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;
	private List<Detallepedido> listaDetallepedido;
	private List<Documentotecnico> listaDocumentotecnico;

	public Pedido() {}

	public Pedido(java.lang.Integer idpedido) {
		this.idpedido=idpedido;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Pedido)
			return ((Pedido)obj).getIdpedido().equals(this.getIdpedido()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idpedido!=null)?("idpedido:\t" + this.idpedido+"\n"):"" ).concat(
			(this.nropedido!=null)?("nropedido:\t" + this.nropedido+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.idperiodo!=null)?("idperiodo:\t" + this.idperiodo+"\n"):"" ).concat(
			(this.codigocentrocosto!=null)?("codigocentrocosto:\t" + this.codigocentrocosto+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.nombredependencia!=null)?("nombredependencia:\t" + this.nombredependencia+"\n"):"" ).concat(
			(this.descripcionpedidosiga!=null)?("descripcionpedidosiga:\t" + this.descripcionpedidosiga+"\n"):"" ).concat(
			(this.montopedido!=null)?("montopedido:\t" + this.montopedido+"\n"):"" ).concat(
			(this.estadopedido!=null)?("estadopedido:\t" + this.estadopedido+"\n"):"" ).concat(
			(this.numerosinad!=null)?("numerosinad:\t" + this.numerosinad+"\n"):"" ).concat(
			(this.aniosinad!=null)?("aniosinad:\t" + this.aniosinad+"\n"):"" ).concat(
			(this.numeroexpedientesinad!=null)?("numeroexpedientesinad:\t" + this.numeroexpedientesinad+"\n"):"" ).concat(
			(this.fechapedido!=null)?("fechapedido:\t" + this.fechapedido+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.idcatalogotiponecesidad!=null)?("idcatalogotiponecesidad:\t" + this.idcatalogotiponecesidad+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.tipodocumentosinad!=null)?("tipodocumentosinad:\t" + this.tipodocumentosinad+"\n"):"" ).concat(
			(this.numerodocumentosinad!=null)?("numerodocumentosinad:\t" + this.numerodocumentosinad+"\n"):"" ).concat(
			(this.tiposinad!=null)?("tiposinad:\t" + this.tiposinad+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.idvpedido!=null)?("idvpedido:\t" + this.idvpedido+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idpedido!=null)?("idpedido:\t" + this.idpedido+"\n"):"" ).concat(
			(this.nropedido!=null)?("nropedido:\t" + this.nropedido+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipobien!=null)?("gentablaIdcatalogotipobien:\t" + this.gentablaIdcatalogotipobien.toString()+"\n"):"" ).concat(
			(this.idperiodo!=null)?("idperiodo:\t" + this.idperiodo+"\n"):"" ).concat(
			(this.periodoIdperiodo!=null)?("periodoIdperiodo:\t" + this.periodoIdperiodo.toString()+"\n"):"" ).concat(
			(this.codigocentrocosto!=null)?("codigocentrocosto:\t" + this.codigocentrocosto+"\n"):"" ).concat(
			(this.vcentrocostoCodigocentrocosto!=null)?("vcentrocostoCodigocentrocosto:\t" + this.vcentrocostoCodigocentrocosto.toString()+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.nombredependencia!=null)?("nombredependencia:\t" + this.nombredependencia+"\n"):"" ).concat(
			(this.descripcionpedidosiga!=null)?("descripcionpedidosiga:\t" + this.descripcionpedidosiga+"\n"):"" ).concat(
			(this.montopedido!=null)?("montopedido:\t" + this.montopedido+"\n"):"" ).concat(
			(this.estadopedido!=null)?("estadopedido:\t" + this.estadopedido+"\n"):"" ).concat(
			(this.numerosinad!=null)?("numerosinad:\t" + this.numerosinad+"\n"):"" ).concat(
			(this.aniosinad!=null)?("aniosinad:\t" + this.aniosinad+"\n"):"" ).concat(
			(this.numeroexpedientesinad!=null)?("numeroexpedientesinad:\t" + this.numeroexpedientesinad+"\n"):"" ).concat(
			(this.fechapedido!=null)?("fechapedido:\t" + this.fechapedido+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.idcatalogotiponecesidad!=null)?("idcatalogotiponecesidad:\t" + this.idcatalogotiponecesidad+"\n"):"" ).concat(
			(this.gentablaIdcatalogotiponecesidad!=null)?("gentablaIdcatalogotiponecesidad:\t" + this.gentablaIdcatalogotiponecesidad.toString()+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.unidadejecutoraIdunidadejecutora!=null)?("unidadejecutoraIdunidadejecutora:\t" + this.unidadejecutoraIdunidadejecutora.toString()+"\n"):"" ).concat(
			(this.tipodocumentosinad!=null)?("tipodocumentosinad:\t" + this.tipodocumentosinad+"\n"):"" ).concat(
			(this.numerodocumentosinad!=null)?("numerodocumentosinad:\t" + this.numerodocumentosinad+"\n"):"" ).concat(
			(this.tiposinad!=null)?("tiposinad:\t" + this.tiposinad+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.idvpedido!=null)?("idvpedido:\t" + this.idvpedido+"\n"):"" ).concat(
			(this.vispedidoIdvpedido!=null)?("vispedidoIdvpedido:\t" + this.vispedidoIdvpedido.toString()+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public static final boolean HAVE_BIGDECIMALS=true;
	public void roundBigDecimals(){
		if(this.montopedido!=null)
			montopedido=Utils.round(montopedido);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
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

	private List<java.lang.Integer> listaIdperiodoInKeys;
	public void addConditionInIdperiodo(List<String> list){
		if(list==null || list.size()==0){
			idperiodo=null;
			listaIdperiodoInKeys=null;
			return;
		}
		if(list.size()==1){
			idperiodo=Integer.parseInt(list.get(0));
			listaIdperiodoInKeys=null;
		}else{
			idperiodo=null;
			listaIdperiodoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdperiodoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdperiodoInKeys() {
		return listaIdperiodoInKeys;
	}

	private List<java.lang.String> listaCodigocentrocostoInKeys;
	public void addConditionInCodigocentrocosto(List<String> list){
		if(list==null || list.size()==0){
			codigocentrocosto=null;
			codigocentrocosto=null;
			listaCodigocentrocostoInKeys=null;
			return;
		}
		if(list.size()==1){
			codigocentrocosto=list.get(0);
			listaCodigocentrocostoInKeys=null;
		}else{
			codigocentrocosto=null;
			listaCodigocentrocostoInKeys=list;
		}
	}
	 public List<java.lang.String> getListaCodigocentrocostoInKeys() {
		return listaCodigocentrocostoInKeys;
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

	private List<java.lang.Integer> listaIdvpedidoInKeys;
	public void addConditionInIdvpedido(List<String> list){
		if(list==null || list.size()==0){
			idvpedido=null;
			listaIdvpedidoInKeys=null;
			return;
		}
		if(list.size()==1){
			idvpedido=Integer.parseInt(list.get(0));
			listaIdvpedidoInKeys=null;
		}else{
			idvpedido=null;
			listaIdvpedidoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdvpedidoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdvpedidoInKeys() {
		return listaIdvpedidoInKeys;
	}


	 public java.lang.Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(java.lang.Integer idpedido) {
		this.idpedido = idpedido;
	}

	 public java.lang.String getNropedido() {
		return nropedido;
	}

	public void setNropedido(java.lang.String nropedido) {
		this.nropedido = nropedido;
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

	 public java.lang.Integer getIdperiodo() {
		return idperiodo;
	}

	public void setIdperiodo(java.lang.Integer idperiodo) {
		this.idperiodo = idperiodo;
	}

	 public Periodo getPeriodoIdperiodo() {
		return periodoIdperiodo;
	}

	public void setPeriodoIdperiodo(Periodo periodoIdperiodo) {
		this.periodoIdperiodo = periodoIdperiodo;
	}

	 public java.lang.String getCodigocentrocosto() {
		return codigocentrocosto;
	}

	public void setCodigocentrocosto(java.lang.String codigocentrocosto) {
		this.codigocentrocosto = codigocentrocosto;
	}

	 public Vcentrocosto getVcentrocostoCodigocentrocosto() {
		return vcentrocostoCodigocentrocosto;
	}

	public void setVcentrocostoCodigocentrocosto(Vcentrocosto vcentrocostoCodigocentrocosto) {
		this.vcentrocostoCodigocentrocosto = vcentrocostoCodigocentrocosto;
	}

	 public java.lang.Integer getAnio() {
		return anio;
	}

	public void setAnio(java.lang.Integer anio) {
		this.anio = anio;
	}

	 public java.lang.String getNombredependencia() {
		return nombredependencia;
	}

	public void setNombredependencia(java.lang.String nombredependencia) {
		this.nombredependencia = nombredependencia;
	}

	 public java.lang.String getDescripcionpedidosiga() {
		return descripcionpedidosiga;
	}

	public void setDescripcionpedidosiga(java.lang.String descripcionpedidosiga) {
		this.descripcionpedidosiga = descripcionpedidosiga;
	}

	 public java.math.BigDecimal getMontopedido() {
		return montopedido;
	}

	public void setMontopedido(java.math.BigDecimal montopedido) {
		this.montopedido = montopedido;
	}

	 public java.math.BigDecimal getMontopedidoini() {
		return montopedidoini;
	}

	public void setMontopedidoini(java.math.BigDecimal montopedidoini) {
		this.montopedidoini = montopedidoini;
	}

	 public java.math.BigDecimal getMontopedidofin() {
		return montopedidofin;
	}

	public void setMontopedidofin(java.math.BigDecimal montopedidofin) {
		this.montopedidofin = montopedidofin;
	}

	 public java.lang.Integer getEstadopedido() {
		return estadopedido;
	}

	public void setEstadopedido(java.lang.Integer estadopedido) {
		this.estadopedido = estadopedido;
	}

	 public java.lang.Integer getNumerosinad() {
		return numerosinad;
	}

	public void setNumerosinad(java.lang.Integer numerosinad) {
		this.numerosinad = numerosinad;
	}

	 public java.lang.Integer getAniosinad() {
		return aniosinad;
	}

	public void setAniosinad(java.lang.Integer aniosinad) {
		this.aniosinad = aniosinad;
	}

	 public java.lang.String getNumeroexpedientesinad() {
		return numeroexpedientesinad;
	}

	public void setNumeroexpedientesinad(java.lang.String numeroexpedientesinad) {
		this.numeroexpedientesinad = numeroexpedientesinad;
	}

	 public java.util.Date getFechapedido() {
		return fechapedido;
	}

	public void setFechapedido(java.util.Date fechapedido) {
		this.fechapedido = fechapedido;
	}

	 public java.util.Date getFechapedidoini() {
		return fechapedidoini;
	}

	public void setFechapedidoini(java.util.Date fechapedidoini) {
		this.fechapedidoini = fechapedidoini;
	}

	 public java.util.Date getFechapedidofin() {
		return fechapedidofin;
	}

	public void setFechapedidofin(java.util.Date fechapedidofin) {
		this.fechapedidofin = fechapedidofin;
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

	 public java.lang.String getTipodocumentosinad() {
		return tipodocumentosinad;
	}

	public void setTipodocumentosinad(java.lang.String tipodocumentosinad) {
		this.tipodocumentosinad = tipodocumentosinad;
	}

	 public java.lang.String getNumerodocumentosinad() {
		return numerodocumentosinad;
	}

	public void setNumerodocumentosinad(java.lang.String numerodocumentosinad) {
		this.numerodocumentosinad = numerodocumentosinad;
	}

	 public java.lang.String getTiposinad() {
		return tiposinad;
	}

	public void setTiposinad(java.lang.String tiposinad) {
		this.tiposinad = tiposinad;
	}

	 public Boolean getBooleantiposinad() {
		return booleantiposinad;
	}

	public void setBooleantiposinad(Boolean booleantiposinad) {
		this.booleantiposinad = booleantiposinad;
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

	 public java.lang.Integer getIdvpedido() {
		return idvpedido;
	}

	public void setIdvpedido(java.lang.Integer idvpedido) {
		this.idvpedido = idvpedido;
	}

	 public Vispedido getVispedidoIdvpedido() {
		return vispedidoIdvpedido;
	}

	public void setVispedidoIdvpedido(Vispedido vispedidoIdvpedido) {
		this.vispedidoIdvpedido = vispedidoIdvpedido;
	}

	 public java.lang.String getEstadoauditoria() {
		return estadoauditoria;
	}

	public void setEstadoauditoria(java.lang.String estadoauditoria) {
		this.estadoauditoria = estadoauditoria;
	}

	 public List<Detallepedido> getListaDetallepedido() {
		return listaDetallepedido;
	}

	public void setListaDetallepedido(List<Detallepedido> listaDetallepedido) {
		this.listaDetallepedido = listaDetallepedido;
	}

	 public List<Documentotecnico> getListaDocumentotecnico() {
		return listaDocumentotecnico;
	}

	public void setListaDocumentotecnico(List<Documentotecnico> listaDocumentotecnico) {
		this.listaDocumentotecnico = listaDocumentotecnico;
	}

}
