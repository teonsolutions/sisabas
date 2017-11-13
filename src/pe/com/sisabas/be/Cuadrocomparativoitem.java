
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[CuadroComparativoItem]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Cuadrocomparativoitem extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[IdCuadroComparativoItem]*/
	private java.lang.Integer idcuadrocomparativoitem;
	/**[Cuadro Comparativo]*/
	private java.lang.Integer idcuadrocomparativofuente;
	private Cuadrocomparativofuente cuadrocomparativofuenteIdcuadrocomparativofuente;
	/**[Detalle pedido]*/
	private java.lang.Integer iddetallepedido;
	private Detallepedido detallepedidoIddetallepedido;
	/**[Precio Total]*/
	private java.math.BigDecimal precioreferencial;
	private java.math.BigDecimal precioreferencialini;
	private java.math.BigDecimal precioreferencialfin;
	/**[*][Fecha de Creación de Auditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][UsuarioCreaciónAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha de Modificación]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario de modificación de Auditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][Equipo Auditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa Auditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;
	private List<Cuadrocomparativovr> listaCuadrocomparativovr;

	public Cuadrocomparativoitem() {}

	public Cuadrocomparativoitem(java.lang.Integer idcuadrocomparativoitem) {
		this.idcuadrocomparativoitem=idcuadrocomparativoitem;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Cuadrocomparativoitem)
			return ((Cuadrocomparativoitem)obj).getIdcuadrocomparativoitem().equals(this.getIdcuadrocomparativoitem()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idcuadrocomparativoitem!=null)?("idcuadrocomparativoitem:\t" + this.idcuadrocomparativoitem+"\n"):"" ).concat(
			(this.idcuadrocomparativofuente!=null)?("idcuadrocomparativofuente:\t" + this.idcuadrocomparativofuente+"\n"):"" ).concat(
			(this.iddetallepedido!=null)?("iddetallepedido:\t" + this.iddetallepedido+"\n"):"" ).concat(
			(this.precioreferencial!=null)?("precioreferencial:\t" + this.precioreferencial+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idcuadrocomparativoitem!=null)?("idcuadrocomparativoitem:\t" + this.idcuadrocomparativoitem+"\n"):"" ).concat(
			(this.idcuadrocomparativofuente!=null)?("idcuadrocomparativofuente:\t" + this.idcuadrocomparativofuente+"\n"):"" ).concat(
			(this.cuadrocomparativofuenteIdcuadrocomparativofuente!=null)?("cuadrocomparativofuenteIdcuadrocomparativofuente:\t" + this.cuadrocomparativofuenteIdcuadrocomparativofuente.toString()+"\n"):"" ).concat(
			(this.iddetallepedido!=null)?("iddetallepedido:\t" + this.iddetallepedido+"\n"):"" ).concat(
			(this.detallepedidoIddetallepedido!=null)?("detallepedidoIddetallepedido:\t" + this.detallepedidoIddetallepedido.toString()+"\n"):"" ).concat(
			(this.precioreferencial!=null)?("precioreferencial:\t" + this.precioreferencial+"\n"):"" ).concat(
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
		if(this.precioreferencial!=null)
			precioreferencial=Utils.round(precioreferencial);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.Integer> listaIdcuadrocomparativofuenteInKeys;
	public void addConditionInIdcuadrocomparativofuente(List<String> list){
		if(list==null || list.size()==0){
			idcuadrocomparativofuente=null;
			listaIdcuadrocomparativofuenteInKeys=null;
			return;
		}
		if(list.size()==1){
			idcuadrocomparativofuente=Integer.parseInt(list.get(0));
			listaIdcuadrocomparativofuenteInKeys=null;
		}else{
			idcuadrocomparativofuente=null;
			listaIdcuadrocomparativofuenteInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdcuadrocomparativofuenteInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdcuadrocomparativofuenteInKeys() {
		return listaIdcuadrocomparativofuenteInKeys;
	}

	private List<java.lang.Integer> listaIddetallepedidoInKeys;
	public void addConditionInIddetallepedido(List<String> list){
		if(list==null || list.size()==0){
			iddetallepedido=null;
			listaIddetallepedidoInKeys=null;
			return;
		}
		if(list.size()==1){
			iddetallepedido=Integer.parseInt(list.get(0));
			listaIddetallepedidoInKeys=null;
		}else{
			iddetallepedido=null;
			listaIddetallepedidoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIddetallepedidoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIddetallepedidoInKeys() {
		return listaIddetallepedidoInKeys;
	}


	 public java.lang.Integer getIdcuadrocomparativoitem() {
		return idcuadrocomparativoitem;
	}

	public void setIdcuadrocomparativoitem(java.lang.Integer idcuadrocomparativoitem) {
		this.idcuadrocomparativoitem = idcuadrocomparativoitem;
	}

	 public java.lang.Integer getIdcuadrocomparativofuente() {
		return idcuadrocomparativofuente;
	}

	public void setIdcuadrocomparativofuente(java.lang.Integer idcuadrocomparativofuente) {
		this.idcuadrocomparativofuente = idcuadrocomparativofuente;
	}

	 public Cuadrocomparativofuente getCuadrocomparativofuenteIdcuadrocomparativofuente() {
		return cuadrocomparativofuenteIdcuadrocomparativofuente;
	}

	public void setCuadrocomparativofuenteIdcuadrocomparativofuente(Cuadrocomparativofuente cuadrocomparativofuenteIdcuadrocomparativofuente) {
		this.cuadrocomparativofuenteIdcuadrocomparativofuente = cuadrocomparativofuenteIdcuadrocomparativofuente;
	}

	 public java.lang.Integer getIddetallepedido() {
		return iddetallepedido;
	}

	public void setIddetallepedido(java.lang.Integer iddetallepedido) {
		this.iddetallepedido = iddetallepedido;
	}

	 public Detallepedido getDetallepedidoIddetallepedido() {
		return detallepedidoIddetallepedido;
	}

	public void setDetallepedidoIddetallepedido(Detallepedido detallepedidoIddetallepedido) {
		this.detallepedidoIddetallepedido = detallepedidoIddetallepedido;
	}

	 public java.math.BigDecimal getPrecioreferencial() {
		return precioreferencial;
	}

	public void setPrecioreferencial(java.math.BigDecimal precioreferencial) {
		this.precioreferencial = precioreferencial;
	}

	 public java.math.BigDecimal getPrecioreferencialini() {
		return precioreferencialini;
	}

	public void setPrecioreferencialini(java.math.BigDecimal precioreferencialini) {
		this.precioreferencialini = precioreferencialini;
	}

	 public java.math.BigDecimal getPrecioreferencialfin() {
		return precioreferencialfin;
	}

	public void setPrecioreferencialfin(java.math.BigDecimal precioreferencialfin) {
		this.precioreferencialfin = precioreferencialfin;
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

	 public List<Cuadrocomparativovr> getListaCuadrocomparativovr() {
		return listaCuadrocomparativovr;
	}

	public void setListaCuadrocomparativovr(List<Cuadrocomparativovr> listaCuadrocomparativovr) {
		this.listaCuadrocomparativovr = listaCuadrocomparativovr;
	}

}
