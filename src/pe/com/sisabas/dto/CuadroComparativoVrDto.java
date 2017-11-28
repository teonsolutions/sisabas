package pe.com.sisabas.dto;

import java.io.Serializable;

public class CuadroComparativoVrDto implements Serializable,Cloneable {
	private static final long serialVersionUID = 1L;
	private Integer idCuadroComparativoVR;
	private Integer idPacConsolidado;
	private Integer idDetallePedido;
	private Integer idPedido;
	private String nombreItem;
	private Integer unidadMedida;
	private Integer cantidadAprobadaSiga;
	private Integer cantidadSolicitadaSiga;
	private Double valorReferencialItem;
	private Double valorReferencialTotal;
	private String procedimientoVrDesc;
	
	public Integer getIdCuadroComparativoVR() {
		return idCuadroComparativoVR;
	}
	public void setIdCuadroComparativoVR(Integer idCuadroComparativoVR) {
		this.idCuadroComparativoVR = idCuadroComparativoVR;
	}
	public Integer getIdPacConsolidado() {
		return idPacConsolidado;
	}
	public void setIdPacConsolidado(Integer idPacConsolidado) {
		this.idPacConsolidado = idPacConsolidado;
	}
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
	public Integer getCantidadSolicitadaSiga() {
		return cantidadSolicitadaSiga;
	}
	public void setCantidadSolicitadaSiga(Integer cantidadSolicitadaSiga) {
		this.cantidadSolicitadaSiga = cantidadSolicitadaSiga;
	}
	public Double getValorReferencialItem() {
		return valorReferencialItem;
	}
	public void setValorReferencialItem(Double valorReferencialItem) {
		this.valorReferencialItem = valorReferencialItem;
	}
	public Double getValorReferencialTotal() {
		return valorReferencialTotal;
	}
	public void setValorReferencialTotal(Double valorReferencialTotal) {
		this.valorReferencialTotal = valorReferencialTotal;
	}
	public String getProcedimientoVrDesc() {
		return procedimientoVrDesc;
	}
	public void setProcedimientoVrDesc(String procedimientoVrDesc) {
		this.procedimientoVrDesc = procedimientoVrDesc;
	}	

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
}
