package pe.com.sisabas.dto;

import java.io.Serializable;

public class PacItemsDto implements  Serializable,Cloneable {
	private String item;
	private String nombreItem;
	private Double cantidad;
	private Double monto;
	private Integer unidadMedida;
	
	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getNombreItem() {
		return nombreItem;
	}


	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}


	public Double getCantidad() {
		return cantidad;
	}


	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}


	public Double getMonto() {
		return monto;
	}


	public void setMonto(Double monto) {
		this.monto = monto;
	}


	public Integer getUnidadMedida() {
		return unidadMedida;
	}


	public void setUnidadMedida(Integer unidadMedida) {
		this.unidadMedida = unidadMedida;
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }
}
