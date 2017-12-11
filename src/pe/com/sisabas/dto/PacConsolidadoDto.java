package pe.com.sisabas.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PacConsolidadoDto implements Serializable,Cloneable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPacConsolidado;
	private Integer nroConsolid;
	private Date fechaPao;
	private String nroPac;
	private String idCatalogoTipoNecesidad;
	private String idCatalogoTipoContratacion;
	private Integer estadoRequerimiento;
	private String estadoRequerimientoDesc;
	private Double valorEstimadoContratacion;
	private Integer esItemUnico;
	private Integer nroItems;
	private String tipoProcesoInicial;
	private String tipoProcesoInicialDesc;
	private String idCatalogoEstadoPac;
	private Integer unidadMedida;
	private String unidadMedidaDesc;
	private String descripcionPac;
	private Integer cantidad;
	private String mesPrevistoConvocatoria;
	private String idTipoBien;
	private String tipoBienDesc;
	private Integer nroVersionPac;
	private Date fechaResolucionPac;
	private Date fechaModificacionSeace;
	private Date fechaRecepcionDocumentoTecnico;
	private String nombreEspecialistaVR;
	private String resolucionPac;
	private String documentoNoProgramado;
	private List<CertificacionItemsDto> certificacionItems;
	private Date fechaCP;
	private Integer nroCP;
	private Double montoCP;
	private Integer idComiteProceso;

	private List<PedidosPaoResponse> pedidos;
	private List<PacItemsDto> items;
		
	private Integer anio;
	private String codigoCentroCosto;
	private String tipoNecesidad;
	private String idTipoContratacion;
	private String idTipoNecesidad;
	private int idUnidadEjecutora;
		
	//APROBACION
	private String codigoTipoProceso;
	private Integer nroProceso;
	private Integer nroConvocatoria;
	private String tiempoServicio;
	private Date fechaSolicitudAprobacionExpediente;
	private Date fechaAprobacionExpediente;	
	private boolean aprobado;
	
	/*
	CodigoTipoProceso
	NroProceso
	NroConvocatoria
	TiempoServicio
	FechaSolicitudAprobacionExpediente
	FechaAprobacionExpediente	 
	 */
	
	

	public Integer getIdPacConsolidado() {
		return idPacConsolidado;
	}




	public void setIdPacConsolidado(Integer idPacConsolidado) {
		this.idPacConsolidado = idPacConsolidado;
	}




	public Integer getNroConsolid() {
		return nroConsolid;
	}




	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}




	public Date getFechaPao() {
		return fechaPao;
	}




	public void setFechaPao(Date fechaPao) {
		this.fechaPao = fechaPao;
	}




	public String getNroPac() {
		return nroPac;
	}




	public void setNroPac(String nroPac) {
		this.nroPac = nroPac;
	}




	public String getIdCatalogoTipoNecesidad() {
		return idCatalogoTipoNecesidad;
	}




	public void setIdCatalogoTipoNecesidad(String idCatalogoTipoNecesidad) {
		this.idCatalogoTipoNecesidad = idCatalogoTipoNecesidad;
	}




	public String getIdCatalogoTipoContratacion() {
		return idCatalogoTipoContratacion;
	}




	public void setIdCatalogoTipoContratacion(String idCatalogoTipoContratacion) {
		this.idCatalogoTipoContratacion = idCatalogoTipoContratacion;
	}




	public Integer getEstadoRequerimiento() {
		return estadoRequerimiento;
	}




	public void setEstadoRequerimiento(Integer estadoRequerimiento) {
		this.estadoRequerimiento = estadoRequerimiento;
	}




	public String getEstadoRequerimientoDesc() {
		return estadoRequerimientoDesc;
	}




	public void setEstadoRequerimientoDesc(String estadoRequerimientoDesc) {
		this.estadoRequerimientoDesc = estadoRequerimientoDesc;
	}




	public Double getValorEstimadoContratacion() {
		return valorEstimadoContratacion;
	}




	public void setValorEstimadoContratacion(Double valorEstimadoContratacion) {
		this.valorEstimadoContratacion = valorEstimadoContratacion;
	}




	public Integer getEsItemUnico() {
		return esItemUnico;
	}




	public void setEsItemUnico(Integer esItemUnico) {
		this.esItemUnico = esItemUnico;
	}




	public Integer getNroItems() {
		return nroItems;
	}




	public void setNroItems(Integer nroItems) {
		this.nroItems = nroItems;
	}




	public String getTipoProcesoInicial() {
		return tipoProcesoInicial;
	}




	public void setTipoProcesoInicial(String tipoProcesoInicial) {
		this.tipoProcesoInicial = tipoProcesoInicial;
	}




	public String getTipoProcesoInicialDesc() {
		return tipoProcesoInicialDesc;
	}




	public void setTipoProcesoInicialDesc(String tipoProcesoInicialDesc) {
		this.tipoProcesoInicialDesc = tipoProcesoInicialDesc;
	}




	public String getIdCatalogoEstadoPac() {
		return idCatalogoEstadoPac;
	}




	public void setIdCatalogoEstadoPac(String idCatalogoEstadoPac) {
		this.idCatalogoEstadoPac = idCatalogoEstadoPac;
	}




	public Integer getUnidadMedida() {
		return unidadMedida;
	}




	public void setUnidadMedida(Integer unidadMedida) {
		this.unidadMedida = unidadMedida;
	}




	public String getUnidadMedidaDesc() {
		return unidadMedidaDesc;
	}




	public void setUnidadMedidaDesc(String unidadMedidaDesc) {
		this.unidadMedidaDesc = unidadMedidaDesc;
	}




	public String getDescripcionPac() {
		return descripcionPac;
	}




	public void setDescripcionPac(String descripcionPac) {
		this.descripcionPac = descripcionPac;
	}




	public Integer getCantidad() {
		return cantidad;
	}




	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}




	public String getMesPrevistoConvocatoria() {
		return mesPrevistoConvocatoria;
	}




	public void setMesPrevistoConvocatoria(String mesPrevistoConvocatoria) {
		this.mesPrevistoConvocatoria = mesPrevistoConvocatoria;
	}




	public String getIdTipoBien() {
		return idTipoBien;
	}




	public void setIdTipoBien(String idTipoBien) {
		this.idTipoBien = idTipoBien;
	}




	public String getTipoBienDesc() {
		return tipoBienDesc;
	}




	public void setTipoBienDesc(String tipoBienDesc) {
		this.tipoBienDesc = tipoBienDesc;
	}




	public Integer getNroVersionPac() {
		return nroVersionPac;
	}




	public void setNroVersionPac(Integer nroVersionPac) {
		this.nroVersionPac = nroVersionPac;
	}




	public Date getFechaResolucionPac() {
		return fechaResolucionPac;
	}




	public void setFechaResolucionPac(Date fechaResolucionPac) {
		this.fechaResolucionPac = fechaResolucionPac;
	}




	public Date getFechaModificacionSeace() {
		return fechaModificacionSeace;
	}




	public void setFechaModificacionSeace(Date fechaModificacionSeace) {
		this.fechaModificacionSeace = fechaModificacionSeace;
	}




	public Date getFechaRecepcionDocumentoTecnico() {
		return fechaRecepcionDocumentoTecnico;
	}




	public void setFechaRecepcionDocumentoTecnico(Date fechaRecepcionDocumentoTecnico) {
		this.fechaRecepcionDocumentoTecnico = fechaRecepcionDocumentoTecnico;
	}




	public String getNombreEspecialistaVR() {
		return nombreEspecialistaVR;
	}




	public void setNombreEspecialistaVR(String nombreEspecialistaVR) {
		this.nombreEspecialistaVR = nombreEspecialistaVR;
	}




	public String getResolucionPac() {
		return resolucionPac;
	}




	public void setResolucionPac(String resolucionPac) {
		this.resolucionPac = resolucionPac;
	}




	public String getDocumentoNoProgramado() {
		return documentoNoProgramado;
	}




	public void setDocumentoNoProgramado(String documentoNoProgramado) {
		this.documentoNoProgramado = documentoNoProgramado;
	}




	public List<CertificacionItemsDto> getCertificacionItems() {
		return certificacionItems;
	}




	public void setCertificacionItems(List<CertificacionItemsDto> certificacionItems) {
		this.certificacionItems = certificacionItems;
	}




	public Date getFechaCP() {
		return fechaCP;
	}




	public void setFechaCP(Date fechaCP) {
		this.fechaCP = fechaCP;
	}




	public Integer getNroCP() {
		return nroCP;
	}




	public void setNroCP(Integer nroCP) {
		this.nroCP = nroCP;
	}




	public Double getMontoCP() {
		return montoCP;
	}




	public void setMontoCP(Double montoCP) {
		this.montoCP = montoCP;
	}


	public Integer getIdComiteProceso() {
		return idComiteProceso;
	}




	public void setIdComiteProceso(Integer idComiteProceso) {
		this.idComiteProceso = idComiteProceso;
	}

	public List<PedidosPaoResponse> getPedidos() {
		return pedidos;
	}




	public void setPedidos(List<PedidosPaoResponse> pedidos) {
		this.pedidos = pedidos;
	}




	public List<PacItemsDto> getItems() {
		return items;
	}




	public void setItems(List<PacItemsDto> items) {
		this.items = items;
	}




	public Integer getAnio() {
		return anio;
	}




	public void setAnio(Integer anio) {
		this.anio = anio;
	}




	public String getCodigoCentroCosto() {
		return codigoCentroCosto;
	}




	public void setCodigoCentroCosto(String codigoCentroCosto) {
		this.codigoCentroCosto = codigoCentroCosto;
	}




	public String getTipoNecesidad() {
		return tipoNecesidad;
	}




	public void setTipoNecesidad(String tipoNecesidad) {
		this.tipoNecesidad = tipoNecesidad;
	}




	public String getIdTipoContratacion() {
		return idTipoContratacion;
	}




	public void setIdTipoContratacion(String idTipoContratacion) {
		this.idTipoContratacion = idTipoContratacion;
	}




	public String getIdTipoNecesidad() {
		return idTipoNecesidad;
	}




	public void setIdTipoNecesidad(String idTipoNecesidad) {
		this.idTipoNecesidad = idTipoNecesidad;
	}




	public int getIdUnidadEjecutora() {
		return idUnidadEjecutora;
	}




	public void setIdUnidadEjecutora(int idUnidadEjecutora) {
		this.idUnidadEjecutora = idUnidadEjecutora;
	}




	public String getCodigoTipoProceso() {
		return codigoTipoProceso;
	}




	public void setCodigoTipoProceso(String codigoTipoProceso) {
		this.codigoTipoProceso = codigoTipoProceso;
	}




	public Integer getNroProceso() {
		return nroProceso;
	}




	public void setNroProceso(Integer nroProceso) {
		this.nroProceso = nroProceso;
	}




	public Integer getNroConvocatoria() {
		return nroConvocatoria;
	}




	public void setNroConvocatoria(Integer nroConvocatoria) {
		this.nroConvocatoria = nroConvocatoria;
	}




	public String getTiempoServicio() {
		return tiempoServicio;
	}




	public void setTiempoServicio(String tiempoServicio) {
		this.tiempoServicio = tiempoServicio;
	}




	public Date getFechaSolicitudAprobacionExpediente() {
		return fechaSolicitudAprobacionExpediente;
	}




	public void setFechaSolicitudAprobacionExpediente(Date fechaSolicitudAprobacionExpediente) {
		this.fechaSolicitudAprobacionExpediente = fechaSolicitudAprobacionExpediente;
	}




	public Date getFechaAprobacionExpediente() {
		return fechaAprobacionExpediente;
	}




	public void setFechaAprobacionExpediente(Date fechaAprobacionExpediente) {
		this.fechaAprobacionExpediente = fechaAprobacionExpediente;
	}


	public boolean isAprobado() {
		return aprobado;
	}




	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}




	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
}
