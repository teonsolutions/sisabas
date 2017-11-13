
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Detalle pedido In]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Detallepedido extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer iddetallepedido;
	/**[Pedido In]*/
	private java.lang.Integer idpedido;
	private Pedido pedidoIdpedido;
	/**[Grupo Bien]*/
	private java.lang.String grupobien;
	/**[Clase Bien]*/
	private java.lang.String clasebien;
	/**[Familia Bien]*/
	private java.lang.String familiabien;
	/**[Item Bien]*/
	private java.lang.String itembien;
	/**[Nombre Item]*/
	private java.lang.String nombreitem;
	/**[Unidad de medida]*/
	private java.lang.Integer unidadmedida;
	/**[Cantidad Aprobada Siga]*/
	private java.lang.Integer cantidadaprobadasiga;
	/**[Cantidad Solicitada Siga]*/
	private java.lang.Integer cantidadsolicitadasiga;
	/**[Cantidad Atendida Siga]*/
	private java.lang.Integer cantidadatendidasiga;
	/**[Precio unitario]*/
	private java.math.BigDecimal preciounitario;
	private java.math.BigDecimal preciounitarioini;
	private java.math.BigDecimal preciounitariofin;
	/**[Valor Total]*/
	private java.math.BigDecimal valortotal;
	private java.math.BigDecimal valortotalini;
	private java.math.BigDecimal valortotalfin;
	/**[Estado Pedido Siga]*/
	private java.lang.Integer estadopedidosiga;
	/**[Id Clasificador]*/
	private java.lang.String codigoclasificador;
	/**[Codigo Tarea Siga]*/
	private java.lang.String codigotareasiga;
	/**[Codigo Tarea Planin]*/
	private java.lang.String codigotareaplanin;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario Creación]*/
	private java.lang.String usuariocreacionauditoria;
	/**[Clasificar]*/
	private java.lang.String clasificador;
	/**[Observado por CP]*/
	private java.lang.Integer observadoporcp;
	/**[Fecha Observado por CP]*/
	private java.util.Date fechaobservadoporcp;
	private java.util.Date fechaobservadoporcpini;
	private java.util.Date fechaobservadoporcpfin;
	/**[Fecha Retirado Por CP]*/
	private java.util.Date fecharetiradoporcp;
	private java.util.Date fecharetiradoporcpini;
	private java.util.Date fecharetiradoporcpfin;
	/**[*][Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Detallepedido() {}

	public Detallepedido(java.lang.Integer iddetallepedido) {
		this.iddetallepedido=iddetallepedido;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Detallepedido)
			return ((Detallepedido)obj).getIddetallepedido().equals(this.getIddetallepedido()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.iddetallepedido!=null)?("iddetallepedido:\t" + this.iddetallepedido+"\n"):"" ).concat(
			(this.idpedido!=null)?("idpedido:\t" + this.idpedido+"\n"):"" ).concat(
			(this.grupobien!=null)?("grupobien:\t" + this.grupobien+"\n"):"" ).concat(
			(this.clasebien!=null)?("clasebien:\t" + this.clasebien+"\n"):"" ).concat(
			(this.familiabien!=null)?("familiabien:\t" + this.familiabien+"\n"):"" ).concat(
			(this.itembien!=null)?("itembien:\t" + this.itembien+"\n"):"" ).concat(
			(this.nombreitem!=null)?("nombreitem:\t" + this.nombreitem+"\n"):"" ).concat(
			(this.unidadmedida!=null)?("unidadmedida:\t" + this.unidadmedida+"\n"):"" ).concat(
			(this.cantidadaprobadasiga!=null)?("cantidadaprobadasiga:\t" + this.cantidadaprobadasiga+"\n"):"" ).concat(
			(this.cantidadsolicitadasiga!=null)?("cantidadsolicitadasiga:\t" + this.cantidadsolicitadasiga+"\n"):"" ).concat(
			(this.cantidadatendidasiga!=null)?("cantidadatendidasiga:\t" + this.cantidadatendidasiga+"\n"):"" ).concat(
			(this.preciounitario!=null)?("preciounitario:\t" + this.preciounitario+"\n"):"" ).concat(
			(this.valortotal!=null)?("valortotal:\t" + this.valortotal+"\n"):"" ).concat(
			(this.estadopedidosiga!=null)?("estadopedidosiga:\t" + this.estadopedidosiga+"\n"):"" ).concat(
			(this.codigoclasificador!=null)?("codigoclasificador:\t" + this.codigoclasificador+"\n"):"" ).concat(
			(this.codigotareasiga!=null)?("codigotareasiga:\t" + this.codigotareasiga+"\n"):"" ).concat(
			(this.codigotareaplanin!=null)?("codigotareaplanin:\t" + this.codigotareaplanin+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.clasificador!=null)?("clasificador:\t" + this.clasificador+"\n"):"" ).concat(
			(this.observadoporcp!=null)?("observadoporcp:\t" + this.observadoporcp+"\n"):"" ).concat(
			(this.fechaobservadoporcp!=null)?("fechaobservadoporcp:\t" + this.fechaobservadoporcp+"\n"):"" ).concat(
			(this.fecharetiradoporcp!=null)?("fecharetiradoporcp:\t" + this.fecharetiradoporcp+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.iddetallepedido!=null)?("iddetallepedido:\t" + this.iddetallepedido+"\n"):"" ).concat(
			(this.idpedido!=null)?("idpedido:\t" + this.idpedido+"\n"):"" ).concat(
			(this.pedidoIdpedido!=null)?("pedidoIdpedido:\t" + this.pedidoIdpedido.toString()+"\n"):"" ).concat(
			(this.grupobien!=null)?("grupobien:\t" + this.grupobien+"\n"):"" ).concat(
			(this.clasebien!=null)?("clasebien:\t" + this.clasebien+"\n"):"" ).concat(
			(this.familiabien!=null)?("familiabien:\t" + this.familiabien+"\n"):"" ).concat(
			(this.itembien!=null)?("itembien:\t" + this.itembien+"\n"):"" ).concat(
			(this.nombreitem!=null)?("nombreitem:\t" + this.nombreitem+"\n"):"" ).concat(
			(this.unidadmedida!=null)?("unidadmedida:\t" + this.unidadmedida+"\n"):"" ).concat(
			(this.cantidadaprobadasiga!=null)?("cantidadaprobadasiga:\t" + this.cantidadaprobadasiga+"\n"):"" ).concat(
			(this.cantidadsolicitadasiga!=null)?("cantidadsolicitadasiga:\t" + this.cantidadsolicitadasiga+"\n"):"" ).concat(
			(this.cantidadatendidasiga!=null)?("cantidadatendidasiga:\t" + this.cantidadatendidasiga+"\n"):"" ).concat(
			(this.preciounitario!=null)?("preciounitario:\t" + this.preciounitario+"\n"):"" ).concat(
			(this.valortotal!=null)?("valortotal:\t" + this.valortotal+"\n"):"" ).concat(
			(this.estadopedidosiga!=null)?("estadopedidosiga:\t" + this.estadopedidosiga+"\n"):"" ).concat(
			(this.codigoclasificador!=null)?("codigoclasificador:\t" + this.codigoclasificador+"\n"):"" ).concat(
			(this.codigotareasiga!=null)?("codigotareasiga:\t" + this.codigotareasiga+"\n"):"" ).concat(
			(this.codigotareaplanin!=null)?("codigotareaplanin:\t" + this.codigotareaplanin+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.clasificador!=null)?("clasificador:\t" + this.clasificador+"\n"):"" ).concat(
			(this.observadoporcp!=null)?("observadoporcp:\t" + this.observadoporcp+"\n"):"" ).concat(
			(this.fechaobservadoporcp!=null)?("fechaobservadoporcp:\t" + this.fechaobservadoporcp+"\n"):"" ).concat(
			(this.fecharetiradoporcp!=null)?("fecharetiradoporcp:\t" + this.fecharetiradoporcp+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public static final boolean HAVE_BIGDECIMALS=true;
	public void roundBigDecimals(){
		if(this.preciounitario!=null)
			preciounitario=Utils.round(preciounitario);
		if(this.valortotal!=null)
			valortotal=Utils.round(valortotal);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.Integer> listaIdpedidoInKeys;
	public void addConditionInIdpedido(List<String> list){
		if(list==null || list.size()==0){
			idpedido=null;
			listaIdpedidoInKeys=null;
			return;
		}
		if(list.size()==1){
			idpedido=Integer.parseInt(list.get(0));
			listaIdpedidoInKeys=null;
		}else{
			idpedido=null;
			listaIdpedidoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdpedidoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdpedidoInKeys() {
		return listaIdpedidoInKeys;
	}


	 public java.lang.Integer getIddetallepedido() {
		return iddetallepedido;
	}

	public void setIddetallepedido(java.lang.Integer iddetallepedido) {
		this.iddetallepedido = iddetallepedido;
	}

	 public java.lang.Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(java.lang.Integer idpedido) {
		this.idpedido = idpedido;
	}

	 public Pedido getPedidoIdpedido() {
		return pedidoIdpedido;
	}

	public void setPedidoIdpedido(Pedido pedidoIdpedido) {
		this.pedidoIdpedido = pedidoIdpedido;
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

	 public java.lang.String getNombreitem() {
		return nombreitem;
	}

	public void setNombreitem(java.lang.String nombreitem) {
		this.nombreitem = nombreitem;
	}

	 public java.lang.Integer getUnidadmedida() {
		return unidadmedida;
	}

	public void setUnidadmedida(java.lang.Integer unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	 public java.lang.Integer getCantidadaprobadasiga() {
		return cantidadaprobadasiga;
	}

	public void setCantidadaprobadasiga(java.lang.Integer cantidadaprobadasiga) {
		this.cantidadaprobadasiga = cantidadaprobadasiga;
	}

	 public java.lang.Integer getCantidadsolicitadasiga() {
		return cantidadsolicitadasiga;
	}

	public void setCantidadsolicitadasiga(java.lang.Integer cantidadsolicitadasiga) {
		this.cantidadsolicitadasiga = cantidadsolicitadasiga;
	}

	 public java.lang.Integer getCantidadatendidasiga() {
		return cantidadatendidasiga;
	}

	public void setCantidadatendidasiga(java.lang.Integer cantidadatendidasiga) {
		this.cantidadatendidasiga = cantidadatendidasiga;
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

	 public java.lang.Integer getEstadopedidosiga() {
		return estadopedidosiga;
	}

	public void setEstadopedidosiga(java.lang.Integer estadopedidosiga) {
		this.estadopedidosiga = estadopedidosiga;
	}

	 public java.lang.String getCodigoclasificador() {
		return codigoclasificador;
	}

	public void setCodigoclasificador(java.lang.String codigoclasificador) {
		this.codigoclasificador = codigoclasificador;
	}

	 public java.lang.String getCodigotareasiga() {
		return codigotareasiga;
	}

	public void setCodigotareasiga(java.lang.String codigotareasiga) {
		this.codigotareasiga = codigotareasiga;
	}

	 public java.lang.String getCodigotareaplanin() {
		return codigotareaplanin;
	}

	public void setCodigotareaplanin(java.lang.String codigotareaplanin) {
		this.codigotareaplanin = codigotareaplanin;
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

	 public java.lang.String getClasificador() {
		return clasificador;
	}

	public void setClasificador(java.lang.String clasificador) {
		this.clasificador = clasificador;
	}

	 public java.lang.Integer getObservadoporcp() {
		return observadoporcp;
	}

	public void setObservadoporcp(java.lang.Integer observadoporcp) {
		this.observadoporcp = observadoporcp;
	}

	 public java.util.Date getFechaobservadoporcp() {
		return fechaobservadoporcp;
	}

	public void setFechaobservadoporcp(java.util.Date fechaobservadoporcp) {
		this.fechaobservadoporcp = fechaobservadoporcp;
	}

	 public java.util.Date getFechaobservadoporcpini() {
		return fechaobservadoporcpini;
	}

	public void setFechaobservadoporcpini(java.util.Date fechaobservadoporcpini) {
		this.fechaobservadoporcpini = fechaobservadoporcpini;
	}

	 public java.util.Date getFechaobservadoporcpfin() {
		return fechaobservadoporcpfin;
	}

	public void setFechaobservadoporcpfin(java.util.Date fechaobservadoporcpfin) {
		this.fechaobservadoporcpfin = fechaobservadoporcpfin;
	}

	 public java.util.Date getFecharetiradoporcp() {
		return fecharetiradoporcp;
	}

	public void setFecharetiradoporcp(java.util.Date fecharetiradoporcp) {
		this.fecharetiradoporcp = fecharetiradoporcp;
	}

	 public java.util.Date getFecharetiradoporcpini() {
		return fecharetiradoporcpini;
	}

	public void setFecharetiradoporcpini(java.util.Date fecharetiradoporcpini) {
		this.fecharetiradoporcpini = fecharetiradoporcpini;
	}

	 public java.util.Date getFecharetiradoporcpfin() {
		return fecharetiradoporcpfin;
	}

	public void setFecharetiradoporcpfin(java.util.Date fecharetiradoporcpfin) {
		this.fecharetiradoporcpfin = fecharetiradoporcpfin;
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
