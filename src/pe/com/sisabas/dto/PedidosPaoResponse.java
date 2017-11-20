package pe.com.sisabas.dto;

import java.io.Serializable;
import java.util.Date;

public class PedidosPaoResponse implements  Serializable,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPedidoPorPacConsolidado;
	private Integer idPacConsolidado;
	private Integer idPedido;
	private Integer estadoPedido;
	private String descripcionEstadoPorEtapa;
	private String numeroSinad;
	private Integer anioSinad;
	private String numeroExpedienteSinad;
	private String tipoDocumentoSinad;
	private String numeroDocumentoSinad;
	private String tipoBienDesc;
	private String nroPedido;
	private Date fechaPedido;
	private String motivoPedido;
	private String centroCosto;
	private String centroCostoDesc;
	private String tipoEtTdrDesc;
	private Integer idSinad;
	private String esPrincipal;
	private String idCatalogoTipoTdr;
	
	public Integer getIdPedidoPorPacConsolidado() {
		return idPedidoPorPacConsolidado;
	}



	public void setIdPedidoPorPacConsolidado(Integer idPedidoPorPacConsolidado) {
		this.idPedidoPorPacConsolidado = idPedidoPorPacConsolidado;
	}



	public Integer getIdPacConsolidado() {
		return idPacConsolidado;
	}



	public void setIdPacConsolidado(Integer idPacConsolidado) {
		this.idPacConsolidado = idPacConsolidado;
	}



	public Integer getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}



	public Integer getEstadoPedido() {
		return estadoPedido;
	}



	public void setEstadoPedido(Integer estadoPedido) {
		this.estadoPedido = estadoPedido;
	}



	public String getDescripcionEstadoPorEtapa() {
		return descripcionEstadoPorEtapa;
	}



	public void setDescripcionEstadoPorEtapa(String descripcionEstadoPorEtapa) {
		this.descripcionEstadoPorEtapa = descripcionEstadoPorEtapa;
	}



	public String getNumeroSinad() {
		return numeroSinad;
	}



	public void setNumeroSinad(String numeroSinad) {
		this.numeroSinad = numeroSinad;
	}



	public Integer getAnioSinad() {
		return anioSinad;
	}



	public void setAnioSinad(Integer anioSinad) {
		this.anioSinad = anioSinad;
	}



	public String getNumeroExpedienteSinad() {
		return numeroExpedienteSinad;
	}



	public void setNumeroExpedienteSinad(String numeroExpedienteSinad) {
		this.numeroExpedienteSinad = numeroExpedienteSinad;
	}



	public String getTipoDocumentoSinad() {
		return tipoDocumentoSinad;
	}



	public void setTipoDocumentoSinad(String tipoDocumentoSinad) {
		this.tipoDocumentoSinad = tipoDocumentoSinad;
	}



	public String getNumeroDocumentoSinad() {
		return numeroDocumentoSinad;
	}



	public void setNumeroDocumentoSinad(String numeroDocumentoSinad) {
		this.numeroDocumentoSinad = numeroDocumentoSinad;
	}



	public String getTipoBienDesc() {
		return tipoBienDesc;
	}



	public void setTipoBienDesc(String tipoBienDesc) {
		this.tipoBienDesc = tipoBienDesc;
	}



	public String getNroPedido() {
		return nroPedido;
	}



	public void setNroPedido(String nroPedido) {
		this.nroPedido = nroPedido;
	}



	public Date getFechaPedido() {
		return fechaPedido;
	}



	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}



	public String getMotivoPedido() {
		return motivoPedido;
	}



	public void setMotivoPedido(String motivoPedido) {
		this.motivoPedido = motivoPedido;
	}



	public String getCentroCosto() {
		return centroCosto;
	}



	public void setCentroCosto(String centroCosto) {
		this.centroCosto = centroCosto;
	}



	public String getCentroCostoDesc() {
		return centroCostoDesc;
	}



	public void setCentroCostoDesc(String centroCostoDesc) {
		this.centroCostoDesc = centroCostoDesc;
	}



	public String getTipoEtTdrDesc() {
		return tipoEtTdrDesc;
	}



	public void setTipoEtTdrDesc(String tipoEtTdrDesc) {
		this.tipoEtTdrDesc = tipoEtTdrDesc;
	}



	public Integer getIdSinad() {
		return idSinad;
	}



	public void setIdSinad(Integer idSinad) {
		this.idSinad = idSinad;
	}



	public String getEsPrincipal() {
		return esPrincipal;
	}



	public void setEsPrincipal(String esPrincipal) {
		this.esPrincipal = esPrincipal;
	}



	public String getIdCatalogoTipoTdr() {
		return idCatalogoTipoTdr;
	}



	public void setIdCatalogoTipoTdr(String idCatalogoTipoTdr) {
		this.idCatalogoTipoTdr = idCatalogoTipoTdr;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }			
}
