package pe.com.sisabas.dto;

import java.util.List;

public class ProcesoResultadoItemDto {
	private Integer idresultadoproceso;
	private Integer idconvocatoriaproceso;
	private String nroitem;
	private String nombreitem;
	private String nroruc;
	private String nombreproveedor;
	private String idcatalogoestadoresultado;
	private Integer estadoprocesoitem;
	private Double valorreferencial;
	private Double montoadjudicado;
	private Double cantidad;
	private Integer unidadmedida;
	private String descripcionestado;
	private Integer destino;
	
	//additional
	private String observacion;
	private List<ItemIntResponse> destinos;
	private String destinodescripcion;
	
	public Integer getIdresultadoproceso() {
		return idresultadoproceso;
	}
	public void setIdresultadoproceso(Integer idresultadoproceso) {
		this.idresultadoproceso = idresultadoproceso;
	}
	public Integer getIdconvocatoriaproceso() {
		return idconvocatoriaproceso;
	}
	public void setIdconvocatoriaproceso(Integer idconvocatoriaproceso) {
		this.idconvocatoriaproceso = idconvocatoriaproceso;
	}
	public String getNroitem() {
		return nroitem;
	}
	public void setNroitem(String nroitem) {
		this.nroitem = nroitem;
	}
	public String getNombreitem() {
		return nombreitem;
	}
	public void setNombreitem(String nombreitem) {
		this.nombreitem = nombreitem;
	}
	public String getNroruc() {
		return nroruc;
	}
	public void setNroruc(String nroruc) {
		this.nroruc = nroruc;
	}
	public String getNombreproveedor() {
		return nombreproveedor;
	}
	public void setNombreproveedor(String nombreproveedor) {
		this.nombreproveedor = nombreproveedor;
	}
	public String getIdcatalogoestadoresultado() {
		return idcatalogoestadoresultado;
	}
	public void setIdcatalogoestadoresultado(String idcatalogoestadoresultado) {
		this.idcatalogoestadoresultado = idcatalogoestadoresultado;
	}
	public Integer getEstadoprocesoitem() {
		return estadoprocesoitem;
	}
	public void setEstadoprocesoitem(Integer estadoprocesoitem) {
		this.estadoprocesoitem = estadoprocesoitem;
	}
	public Double getValorreferencial() {
		return valorreferencial;
	}
	public void setValorreferencial(Double valorreferencial) {
		this.valorreferencial = valorreferencial;
	}
	public Double getMontoadjudicado() {
		return montoadjudicado;
	}
	public void setMontoadjudicado(Double montoadjudicado) {
		this.montoadjudicado = montoadjudicado;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getUnidadmedida() {
		return unidadmedida;
	}
	public void setUnidadmedida(Integer unidadmedida) {
		this.unidadmedida = unidadmedida;
	}
	public String getDescripcionestado() {
		return descripcionestado;
	}
	public void setDescripcionestado(String descripcionestado) {
		this.descripcionestado = descripcionestado;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public List<ItemIntResponse> getDestinos() {
		return destinos;
	}
	public void setDestinos(List<ItemIntResponse> destinos) {
		this.destinos = destinos;
	}
	public Integer getDestino() {
		return destino;
	}
	public void setDestino(Integer destino) {
		this.destino = destino;
	}
	public String getDestinodescripcion() {
		return destinodescripcion;
	}
	public void setDestinodescripcion(String destinodescripcion) {
		this.destinodescripcion = destinodescripcion;
	}	
	
}
