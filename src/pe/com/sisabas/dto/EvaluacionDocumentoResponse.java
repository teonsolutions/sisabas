package pe.com.sisabas.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class EvaluacionDocumentoResponse implements  Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer iddocumentotecnico;
	private Integer idpedido;
	private Integer idPacProgramado;
	private String nroDocumento;
	private String descripcion;
	private String idcatalogotiponecesidad;
	private String tipoNecesidadDesc;
	private String tipoBienDesc;
	private BigDecimal monto;
	private String estadoDesc;
	private String numeroExpedienteSinad;
	private String estadoPedidoIn;
	private String rutaAnexo;
	private String idCatalogoTipoDocumentoTecnico;
	private java.util.Date fechaModificacionAuditoria;
	private List<ObservacionDocumentoTecnicoDto> observaciones;	
	
	public Integer getIddocumentotecnico() {
		return iddocumentotecnico;
	}
	public void setIddocumentotecnico(Integer iddocumentotecnico) {
		this.iddocumentotecnico = iddocumentotecnico;
	}
	public Integer getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}
	public Integer getIdPacProgramado() {
		return idPacProgramado;
	}
	public void setIdPacProgramado(Integer idPacProgramado) {
		this.idPacProgramado = idPacProgramado;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIdcatalogotiponecesidad() {
		return idcatalogotiponecesidad;
	}
	public void setIdcatalogotiponecesidad(String idcatalogotiponecesidad) {
		this.idcatalogotiponecesidad = idcatalogotiponecesidad;
	}	
	public String getTipoNecesidadDesc() {
		return tipoNecesidadDesc;
	}
	public void setTipoNecesidadDesc(String tipoNecesidadDesc) {
		this.tipoNecesidadDesc = tipoNecesidadDesc;
	}
	public String getTipoBienDesc() {
		return tipoBienDesc;
	}
	public void setTipoBienDesc(String tipoBienDesc) {
		this.tipoBienDesc = tipoBienDesc;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public String getEstadoDesc() {
		return estadoDesc;
	}
	public void setEstadoDesc(String estadoDesc) {
		this.estadoDesc = estadoDesc;
	}
	public String getNumeroExpedienteSinad() {
		return numeroExpedienteSinad;
	}
	public void setNumeroExpedienteSinad(String numeroExpedienteSinad) {
		this.numeroExpedienteSinad = numeroExpedienteSinad;
	}
	public String getEstadoPedidoIn() {
		return estadoPedidoIn;
	}
	public void setEstadoPedidoIn(String estadoPedidoIn) {
		this.estadoPedidoIn = estadoPedidoIn;
	}
	public String getRutaAnexo() {
		return rutaAnexo;
	}
	public void setRutaAnexo(String rutaAnexo) {
		this.rutaAnexo = rutaAnexo;
	}
	public String getIdCatalogoTipoDocumentoTecnico() {
		return idCatalogoTipoDocumentoTecnico;
	}
	public void setIdCatalogoTipoDocumentoTecnico(String idCatalogoTipoDocumentoTecnico) {
		this.idCatalogoTipoDocumentoTecnico = idCatalogoTipoDocumentoTecnico;
	}
	public java.util.Date getFechaModificacionAuditoria() {
		return fechaModificacionAuditoria;
	}
	public void setFechaModificacionAuditoria(java.util.Date fechaModificacionAuditoria) {
		this.fechaModificacionAuditoria = fechaModificacionAuditoria;
	}	
	
	public List<ObservacionDocumentoTecnicoDto> getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(List<ObservacionDocumentoTecnicoDto> observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
}
