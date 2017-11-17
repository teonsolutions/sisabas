package pe.com.sisabas.be;

import java.io.Serializable;

public class RequerimientoItemResponse extends SysTabla  implements  Serializable,Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPedido;
	private Integer idDetallePedido;
	private String grupoBien;
	private String claseBien;
	private String familiaBien;
	private String itemBien;
	private String unidadMedida;
	private String nombreItem;
	private Integer cantSolicitada;
	private Integer cantAprobada;
	private Integer cantAtendida;
	private Integer precioUnitario;
	private Integer valortotal;
	private String descripcionEstadoSiga;
	private String idClasificador;
	private String clasificador;
	private String tipoBien;
	private Integer codigoTareaPlanin;
	private Integer secFun;
	private String nombreTarea;
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Integer getIdDetallePedido() {
		return idDetallePedido;
	}
	public void setIdDetallePedido(Integer idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}
	public String getGrupoBien() {
		return grupoBien;
	}
	public void setGrupoBien(String grupoBien) {
		this.grupoBien = grupoBien;
	}
	public String getClaseBien() {
		return claseBien;
	}
	public void setClaseBien(String claseBien) {
		this.claseBien = claseBien;
	}
	public String getFamiliaBien() {
		return familiaBien;
	}
	public void setFamiliaBien(String familiaBien) {
		this.familiaBien = familiaBien;
	}
	public String getItemBien() {
		return itemBien;
	}
	public void setItemBien(String itemBien) {
		this.itemBien = itemBien;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public String getNombreItem() {
		return nombreItem;
	}
	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}
	public Integer getCantSolicitada() {
		return cantSolicitada;
	}
	public void setCantSolicitada(Integer cantSolicitada) {
		this.cantSolicitada = cantSolicitada;
	}
	public Integer getCantAprobada() {
		return cantAprobada;
	}
	public void setCantAprobada(Integer cantAprobada) {
		this.cantAprobada = cantAprobada;
	}
	public Integer getCantAtendida() {
		return cantAtendida;
	}
	public void setCantAtendida(Integer cantAtendida) {
		this.cantAtendida = cantAtendida;
	}
	public Integer getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Integer getValortotal() {
		return valortotal;
	}
	public void setValortotal(Integer valortotal) {
		this.valortotal = valortotal;
	}
	public String getDescripcionEstadoSiga() {
		return descripcionEstadoSiga;
	}
	public void setDescripcionEstadoSiga(String descripcionEstadoSiga) {
		this.descripcionEstadoSiga = descripcionEstadoSiga;
	}
	public String getIdClasificador() {
		return idClasificador;
	}
	public void setIdClasificador(String idClasificador) {
		this.idClasificador = idClasificador;
	}
	public String getClasificador() {
		return clasificador;
	}
	public void setClasificador(String clasificador) {
		this.clasificador = clasificador;
	}
	public String getTipoBien() {
		return tipoBien;
	}
	public void setTipoBien(String tipoBien) {
		this.tipoBien = tipoBien;
	}
	public Integer getCodigoTareaPlanin() {
		return codigoTareaPlanin;
	}
	public void setCodigoTareaPlanin(Integer codigoTareaPlanin) {
		this.codigoTareaPlanin = codigoTareaPlanin;
	}
	public Integer getSecFun() {
		return secFun;
	}
	public void setSecFun(Integer secFun) {
		this.secFun = secFun;
	}
	public String getNombreTarea() {
		return nombreTarea;
	}
	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
	
	
	

}
