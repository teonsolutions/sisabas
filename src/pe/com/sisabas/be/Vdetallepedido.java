
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[VDetallePedido]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Vdetallepedido extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[IdVDetallePedido]*/
	private java.lang.Integer idvdetallepedido;
	/**[IdVPedido]*/
	private java.lang.Integer idvpedido;
	private Vispedido vispedidoIdvpedido;
	/**[Código Unidad Ejecutora]*/
	private java.lang.String codigounidadejecutora;
	/**[Anio]*/
	private java.math.BigDecimal anio;
	private java.math.BigDecimal anioini;
	private java.math.BigDecimal aniofin;
	/**[SecEjec]*/
	private java.math.BigDecimal secejec;
	private java.math.BigDecimal secejecini;
	private java.math.BigDecimal secejecfin;
	/**[NroCuadro]*/
	private java.math.BigDecimal nrocuadro;
	private java.math.BigDecimal nrocuadroini;
	private java.math.BigDecimal nrocuadrofin;
	/**[CentroCosto]*/
	private java.lang.String centrocosto;
	/**[TipoBien]*/
	private java.lang.String tipobien;
	/**[NroPedido]*/
	private java.lang.String nropedido;
	/**[GrupoBien]*/
	private java.lang.String grupobien;
	/**[ClaseBien]*/
	private java.lang.String clasebien;
	/**[FamiliaBien]*/
	private java.lang.String familiabien;
	/**[ItemBien]*/
	private java.lang.String itembien;
	/**[UnidadMedida]*/
	private java.math.BigDecimal unidadmedida;
	private java.math.BigDecimal unidadmedidaini;
	private java.math.BigDecimal unidadmedidafin;
	/**[NombreItem]*/
	private java.lang.String nombreitem;
	/**[CantidadSolicitada]*/
	private java.math.BigDecimal cantidadsolicitada;
	private java.math.BigDecimal cantidadsolicitadaini;
	private java.math.BigDecimal cantidadsolicitadafin;
	/**[CantidadAprobada]*/
	private java.math.BigDecimal cantidadaprobada;
	private java.math.BigDecimal cantidadaprobadaini;
	private java.math.BigDecimal cantidadaprobadafin;
	/**[CantidadAtendida]*/
	private java.math.BigDecimal cantidadatendida;
	private java.math.BigDecimal cantidadatendidaini;
	private java.math.BigDecimal cantidadatendidafin;
	/**[PrecioUnitario]*/
	private java.math.BigDecimal preciounitario;
	private java.math.BigDecimal preciounitarioini;
	private java.math.BigDecimal preciounitariofin;
	/**[ValorTotal]*/
	private java.math.BigDecimal valortotal;
	private java.math.BigDecimal valortotalini;
	private java.math.BigDecimal valortotalfin;
	/**[TipoTarea]*/
	private java.lang.String tipotarea;
	/**[NivelTarea]*/
	private java.lang.String niveltarea;
	/**[CodigoTarea]*/
	private java.math.BigDecimal codigotarea;
	private java.math.BigDecimal codigotareaini;
	private java.math.BigDecimal codigotareafin;
	/**[EstadoPendiente]*/
	private java.lang.String estadopendiente;
	/**[IdClasificador]*/
	private java.lang.String idclasificador;
	/**[Clasificador]*/
	private java.lang.String clasificador;
	/**[CodigoTipoBien]*/
	private java.lang.Integer codigotipobien;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario Creación]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha de Modificación]*/
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

	public Vdetallepedido() {}

	public Vdetallepedido(java.lang.Integer idvdetallepedido) {
		this.idvdetallepedido=idvdetallepedido;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Vdetallepedido)
			return ((Vdetallepedido)obj).getIdvdetallepedido().equals(this.getIdvdetallepedido()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idvdetallepedido!=null)?("idvdetallepedido:\t" + this.idvdetallepedido+"\n"):"" ).concat(
			(this.idvpedido!=null)?("idvpedido:\t" + this.idvpedido+"\n"):"" ).concat(
			(this.codigounidadejecutora!=null)?("codigounidadejecutora:\t" + this.codigounidadejecutora+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.nrocuadro!=null)?("nrocuadro:\t" + this.nrocuadro+"\n"):"" ).concat(
			(this.centrocosto!=null)?("centrocosto:\t" + this.centrocosto+"\n"):"" ).concat(
			(this.tipobien!=null)?("tipobien:\t" + this.tipobien+"\n"):"" ).concat(
			(this.nropedido!=null)?("nropedido:\t" + this.nropedido+"\n"):"" ).concat(
			(this.grupobien!=null)?("grupobien:\t" + this.grupobien+"\n"):"" ).concat(
			(this.clasebien!=null)?("clasebien:\t" + this.clasebien+"\n"):"" ).concat(
			(this.familiabien!=null)?("familiabien:\t" + this.familiabien+"\n"):"" ).concat(
			(this.itembien!=null)?("itembien:\t" + this.itembien+"\n"):"" ).concat(
			(this.unidadmedida!=null)?("unidadmedida:\t" + this.unidadmedida+"\n"):"" ).concat(
			(this.nombreitem!=null)?("nombreitem:\t" + this.nombreitem+"\n"):"" ).concat(
			(this.cantidadsolicitada!=null)?("cantidadsolicitada:\t" + this.cantidadsolicitada+"\n"):"" ).concat(
			(this.cantidadaprobada!=null)?("cantidadaprobada:\t" + this.cantidadaprobada+"\n"):"" ).concat(
			(this.cantidadatendida!=null)?("cantidadatendida:\t" + this.cantidadatendida+"\n"):"" ).concat(
			(this.preciounitario!=null)?("preciounitario:\t" + this.preciounitario+"\n"):"" ).concat(
			(this.valortotal!=null)?("valortotal:\t" + this.valortotal+"\n"):"" ).concat(
			(this.tipotarea!=null)?("tipotarea:\t" + this.tipotarea+"\n"):"" ).concat(
			(this.niveltarea!=null)?("niveltarea:\t" + this.niveltarea+"\n"):"" ).concat(
			(this.codigotarea!=null)?("codigotarea:\t" + this.codigotarea+"\n"):"" ).concat(
			(this.estadopendiente!=null)?("estadopendiente:\t" + this.estadopendiente+"\n"):"" ).concat(
			(this.idclasificador!=null)?("idclasificador:\t" + this.idclasificador+"\n"):"" ).concat(
			(this.clasificador!=null)?("clasificador:\t" + this.clasificador+"\n"):"" ).concat(
			(this.codigotipobien!=null)?("codigotipobien:\t" + this.codigotipobien+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idvdetallepedido!=null)?("idvdetallepedido:\t" + this.idvdetallepedido+"\n"):"" ).concat(
			(this.idvpedido!=null)?("idvpedido:\t" + this.idvpedido+"\n"):"" ).concat(
			(this.vispedidoIdvpedido!=null)?("vispedidoIdvpedido:\t" + this.vispedidoIdvpedido.toString()+"\n"):"" ).concat(
			(this.codigounidadejecutora!=null)?("codigounidadejecutora:\t" + this.codigounidadejecutora+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.nrocuadro!=null)?("nrocuadro:\t" + this.nrocuadro+"\n"):"" ).concat(
			(this.centrocosto!=null)?("centrocosto:\t" + this.centrocosto+"\n"):"" ).concat(
			(this.tipobien!=null)?("tipobien:\t" + this.tipobien+"\n"):"" ).concat(
			(this.nropedido!=null)?("nropedido:\t" + this.nropedido+"\n"):"" ).concat(
			(this.grupobien!=null)?("grupobien:\t" + this.grupobien+"\n"):"" ).concat(
			(this.clasebien!=null)?("clasebien:\t" + this.clasebien+"\n"):"" ).concat(
			(this.familiabien!=null)?("familiabien:\t" + this.familiabien+"\n"):"" ).concat(
			(this.itembien!=null)?("itembien:\t" + this.itembien+"\n"):"" ).concat(
			(this.unidadmedida!=null)?("unidadmedida:\t" + this.unidadmedida+"\n"):"" ).concat(
			(this.nombreitem!=null)?("nombreitem:\t" + this.nombreitem+"\n"):"" ).concat(
			(this.cantidadsolicitada!=null)?("cantidadsolicitada:\t" + this.cantidadsolicitada+"\n"):"" ).concat(
			(this.cantidadaprobada!=null)?("cantidadaprobada:\t" + this.cantidadaprobada+"\n"):"" ).concat(
			(this.cantidadatendida!=null)?("cantidadatendida:\t" + this.cantidadatendida+"\n"):"" ).concat(
			(this.preciounitario!=null)?("preciounitario:\t" + this.preciounitario+"\n"):"" ).concat(
			(this.valortotal!=null)?("valortotal:\t" + this.valortotal+"\n"):"" ).concat(
			(this.tipotarea!=null)?("tipotarea:\t" + this.tipotarea+"\n"):"" ).concat(
			(this.niveltarea!=null)?("niveltarea:\t" + this.niveltarea+"\n"):"" ).concat(
			(this.codigotarea!=null)?("codigotarea:\t" + this.codigotarea+"\n"):"" ).concat(
			(this.estadopendiente!=null)?("estadopendiente:\t" + this.estadopendiente+"\n"):"" ).concat(
			(this.idclasificador!=null)?("idclasificador:\t" + this.idclasificador+"\n"):"" ).concat(
			(this.clasificador!=null)?("clasificador:\t" + this.clasificador+"\n"):"" ).concat(
			(this.codigotipobien!=null)?("codigotipobien:\t" + this.codigotipobien+"\n"):"" ).concat(
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
		if(this.anio!=null)
			anio=Utils.round(anio);
		if(this.secejec!=null)
			secejec=Utils.round(secejec);
		if(this.nrocuadro!=null)
			nrocuadro=Utils.round(nrocuadro);
		if(this.unidadmedida!=null)
			unidadmedida=Utils.round(unidadmedida);
		if(this.cantidadsolicitada!=null)
			cantidadsolicitada=Utils.round(cantidadsolicitada);
		if(this.cantidadaprobada!=null)
			cantidadaprobada=Utils.round(cantidadaprobada);
		if(this.cantidadatendida!=null)
			cantidadatendida=Utils.round(cantidadatendida);
		if(this.preciounitario!=null)
			preciounitario=Utils.round(preciounitario);
		if(this.valortotal!=null)
			valortotal=Utils.round(valortotal);
		if(this.codigotarea!=null)
			codigotarea=Utils.round(codigotarea);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
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


	 public java.lang.Integer getIdvdetallepedido() {
		return idvdetallepedido;
	}

	public void setIdvdetallepedido(java.lang.Integer idvdetallepedido) {
		this.idvdetallepedido = idvdetallepedido;
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

	 public java.lang.String getCodigounidadejecutora() {
		return codigounidadejecutora;
	}

	public void setCodigounidadejecutora(java.lang.String codigounidadejecutora) {
		this.codigounidadejecutora = codigounidadejecutora;
	}

	 public java.math.BigDecimal getAnio() {
		return anio;
	}

	public void setAnio(java.math.BigDecimal anio) {
		this.anio = anio;
	}

	 public java.math.BigDecimal getAnioini() {
		return anioini;
	}

	public void setAnioini(java.math.BigDecimal anioini) {
		this.anioini = anioini;
	}

	 public java.math.BigDecimal getAniofin() {
		return aniofin;
	}

	public void setAniofin(java.math.BigDecimal aniofin) {
		this.aniofin = aniofin;
	}

	 public java.math.BigDecimal getSecejec() {
		return secejec;
	}

	public void setSecejec(java.math.BigDecimal secejec) {
		this.secejec = secejec;
	}

	 public java.math.BigDecimal getSecejecini() {
		return secejecini;
	}

	public void setSecejecini(java.math.BigDecimal secejecini) {
		this.secejecini = secejecini;
	}

	 public java.math.BigDecimal getSecejecfin() {
		return secejecfin;
	}

	public void setSecejecfin(java.math.BigDecimal secejecfin) {
		this.secejecfin = secejecfin;
	}

	 public java.math.BigDecimal getNrocuadro() {
		return nrocuadro;
	}

	public void setNrocuadro(java.math.BigDecimal nrocuadro) {
		this.nrocuadro = nrocuadro;
	}

	 public java.math.BigDecimal getNrocuadroini() {
		return nrocuadroini;
	}

	public void setNrocuadroini(java.math.BigDecimal nrocuadroini) {
		this.nrocuadroini = nrocuadroini;
	}

	 public java.math.BigDecimal getNrocuadrofin() {
		return nrocuadrofin;
	}

	public void setNrocuadrofin(java.math.BigDecimal nrocuadrofin) {
		this.nrocuadrofin = nrocuadrofin;
	}

	 public java.lang.String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(java.lang.String centrocosto) {
		this.centrocosto = centrocosto;
	}

	 public java.lang.String getTipobien() {
		return tipobien;
	}

	public void setTipobien(java.lang.String tipobien) {
		this.tipobien = tipobien;
	}

	 public java.lang.String getNropedido() {
		return nropedido;
	}

	public void setNropedido(java.lang.String nropedido) {
		this.nropedido = nropedido;
	}

	 public java.lang.String getGrupobien() {
		return grupobien;
	}

	public void setGrupobien(java.lang.String grupobien) {
		this.grupobien = grupobien;
	}

	 public java.lang.String getClasebien() {
		return clasebien;
	}

	public void setClasebien(java.lang.String clasebien) {
		this.clasebien = clasebien;
	}

	 public java.lang.String getFamiliabien() {
		return familiabien;
	}

	public void setFamiliabien(java.lang.String familiabien) {
		this.familiabien = familiabien;
	}

	 public java.lang.String getItembien() {
		return itembien;
	}

	public void setItembien(java.lang.String itembien) {
		this.itembien = itembien;
	}

	 public java.math.BigDecimal getUnidadmedida() {
		return unidadmedida;
	}

	public void setUnidadmedida(java.math.BigDecimal unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	 public java.math.BigDecimal getUnidadmedidaini() {
		return unidadmedidaini;
	}

	public void setUnidadmedidaini(java.math.BigDecimal unidadmedidaini) {
		this.unidadmedidaini = unidadmedidaini;
	}

	 public java.math.BigDecimal getUnidadmedidafin() {
		return unidadmedidafin;
	}

	public void setUnidadmedidafin(java.math.BigDecimal unidadmedidafin) {
		this.unidadmedidafin = unidadmedidafin;
	}

	 public java.lang.String getNombreitem() {
		return nombreitem;
	}

	public void setNombreitem(java.lang.String nombreitem) {
		this.nombreitem = nombreitem;
	}

	 public java.math.BigDecimal getCantidadsolicitada() {
		return cantidadsolicitada;
	}

	public void setCantidadsolicitada(java.math.BigDecimal cantidadsolicitada) {
		this.cantidadsolicitada = cantidadsolicitada;
	}

	 public java.math.BigDecimal getCantidadsolicitadaini() {
		return cantidadsolicitadaini;
	}

	public void setCantidadsolicitadaini(java.math.BigDecimal cantidadsolicitadaini) {
		this.cantidadsolicitadaini = cantidadsolicitadaini;
	}

	 public java.math.BigDecimal getCantidadsolicitadafin() {
		return cantidadsolicitadafin;
	}

	public void setCantidadsolicitadafin(java.math.BigDecimal cantidadsolicitadafin) {
		this.cantidadsolicitadafin = cantidadsolicitadafin;
	}

	 public java.math.BigDecimal getCantidadaprobada() {
		return cantidadaprobada;
	}

	public void setCantidadaprobada(java.math.BigDecimal cantidadaprobada) {
		this.cantidadaprobada = cantidadaprobada;
	}

	 public java.math.BigDecimal getCantidadaprobadaini() {
		return cantidadaprobadaini;
	}

	public void setCantidadaprobadaini(java.math.BigDecimal cantidadaprobadaini) {
		this.cantidadaprobadaini = cantidadaprobadaini;
	}

	 public java.math.BigDecimal getCantidadaprobadafin() {
		return cantidadaprobadafin;
	}

	public void setCantidadaprobadafin(java.math.BigDecimal cantidadaprobadafin) {
		this.cantidadaprobadafin = cantidadaprobadafin;
	}

	 public java.math.BigDecimal getCantidadatendida() {
		return cantidadatendida;
	}

	public void setCantidadatendida(java.math.BigDecimal cantidadatendida) {
		this.cantidadatendida = cantidadatendida;
	}

	 public java.math.BigDecimal getCantidadatendidaini() {
		return cantidadatendidaini;
	}

	public void setCantidadatendidaini(java.math.BigDecimal cantidadatendidaini) {
		this.cantidadatendidaini = cantidadatendidaini;
	}

	 public java.math.BigDecimal getCantidadatendidafin() {
		return cantidadatendidafin;
	}

	public void setCantidadatendidafin(java.math.BigDecimal cantidadatendidafin) {
		this.cantidadatendidafin = cantidadatendidafin;
	}

	 public java.math.BigDecimal getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(java.math.BigDecimal preciounitario) {
		this.preciounitario = preciounitario;
	}

	 public java.math.BigDecimal getPreciounitarioini() {
		return preciounitarioini;
	}

	public void setPreciounitarioini(java.math.BigDecimal preciounitarioini) {
		this.preciounitarioini = preciounitarioini;
	}

	 public java.math.BigDecimal getPreciounitariofin() {
		return preciounitariofin;
	}

	public void setPreciounitariofin(java.math.BigDecimal preciounitariofin) {
		this.preciounitariofin = preciounitariofin;
	}

	 public java.math.BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(java.math.BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	 public java.math.BigDecimal getValortotalini() {
		return valortotalini;
	}

	public void setValortotalini(java.math.BigDecimal valortotalini) {
		this.valortotalini = valortotalini;
	}

	 public java.math.BigDecimal getValortotalfin() {
		return valortotalfin;
	}

	public void setValortotalfin(java.math.BigDecimal valortotalfin) {
		this.valortotalfin = valortotalfin;
	}

	 public java.lang.String getTipotarea() {
		return tipotarea;
	}

	public void setTipotarea(java.lang.String tipotarea) {
		this.tipotarea = tipotarea;
	}

	 public java.lang.String getNiveltarea() {
		return niveltarea;
	}

	public void setNiveltarea(java.lang.String niveltarea) {
		this.niveltarea = niveltarea;
	}

	 public java.math.BigDecimal getCodigotarea() {
		return codigotarea;
	}

	public void setCodigotarea(java.math.BigDecimal codigotarea) {
		this.codigotarea = codigotarea;
	}

	 public java.math.BigDecimal getCodigotareaini() {
		return codigotareaini;
	}

	public void setCodigotareaini(java.math.BigDecimal codigotareaini) {
		this.codigotareaini = codigotareaini;
	}

	 public java.math.BigDecimal getCodigotareafin() {
		return codigotareafin;
	}

	public void setCodigotareafin(java.math.BigDecimal codigotareafin) {
		this.codigotareafin = codigotareafin;
	}

	 public java.lang.String getEstadopendiente() {
		return estadopendiente;
	}

	public void setEstadopendiente(java.lang.String estadopendiente) {
		this.estadopendiente = estadopendiente;
	}

	 public java.lang.String getIdclasificador() {
		return idclasificador;
	}

	public void setIdclasificador(java.lang.String idclasificador) {
		this.idclasificador = idclasificador;
	}

	 public java.lang.String getClasificador() {
		return clasificador;
	}

	public void setClasificador(java.lang.String clasificador) {
		this.clasificador = clasificador;
	}

	 public java.lang.Integer getCodigotipobien() {
		return codigotipobien;
	}

	public void setCodigotipobien(java.lang.Integer codigotipobien) {
		this.codigotipobien = codigotipobien;
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
