package pe.com.sisabas.dto;

import java.io.Serializable;

public class CuadroComparativoItemsDto implements Serializable,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idDetallePedido;
	private Integer idPedido;
	private String nombreItem;
	private Integer unidadMedida;
	private Integer cantidadAprobadaSiga;
	private Double precioReferencial;
	
	public Integer getIdDetallePedido() {
		return idDetallePedido;
	}


	public void setIdDetallePedido(Integer idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}


	public Integer getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}


	public String getNombreItem() {
		return nombreItem;
	}


	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}


	public Integer getUnidadMedida() {
		return unidadMedida;
	}


	public void setUnidadMedida(Integer unidadMedida) {
		this.unidadMedida = unidadMedida;
	}


	public Integer getCantidadAprobadaSiga() {
		return cantidadAprobadaSiga;
	}


	public void setCantidadAprobadaSiga(Integer cantidadAprobadaSiga) {
		this.cantidadAprobadaSiga = cantidadAprobadaSiga;
	}


	public Double getPrecioReferencial() {
		return precioReferencial;
	}


	public void setPrecioReferencial(Double precioReferencial) {
		this.precioReferencial = precioReferencial;
	}


	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
}
