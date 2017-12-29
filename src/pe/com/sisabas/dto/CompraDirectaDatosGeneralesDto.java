package pe.com.sisabas.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CompraDirectaDatosGeneralesDto implements  Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Query
	private Integer idPacConsolid;
	private String nroConsolid;
	private Date fechaPao;
	private String idTipoBien;
	private Double valorMoneda;
	private String especificacionTecnica;
	private Date fechaCP;
	private Integer nroCP;
	private Double montoCP;
	private BigDecimal nroProceso;
	private String flagCD;
	private Date fechaDocumentoTecnico;
	private Integer estadoRequerimiento;
	private String nroRuc;
	private String nroProcesoProveedor;
	private List<PedidosPaoResponse> pedidos;
	private List<PacItemsDto> items;
	private List<CertificacionItemsDto> certificacionItems;
	
	//Adicionales para grabar informacion
	private Integer anio;
	private String codigoCentroCosto;
	private String tipoNecesidad;
	private String idTipoContratacion;
	private String idTipoNecesidad;
	private int idUnidadEjecutora; 
	private String tipoProceso;
	private List<RequisitoConformidadDto> listaRequisitosConformidad;
	
	private Integer unidadMedida;
	private Integer cantidad;

	public Integer getIdPacConsolid() {
		return idPacConsolid;
	}

	public void setIdPacConsolid(Integer idPacConsolid) {
		this.idPacConsolid = idPacConsolid;
	}



	public String getNroConsolid() {
		return nroConsolid;
	}



	public void setNroConsolid(String nroConsolid) {
		this.nroConsolid = nroConsolid;
	}



	public Date getFechaPao() {
		return fechaPao;
	}



	public void setFechaPao(Date fechaPao) {
		this.fechaPao = fechaPao;
	}

	public Double getValorMoneda() {
		return valorMoneda;
	}



	public void setValorMoneda(Double valorMoneda) {
		this.valorMoneda = valorMoneda;
	}



	public String getEspecificacionTecnica() {
		return especificacionTecnica;
	}



	public void setEspecificacionTecnica(String especificacionTecnica) {
		this.especificacionTecnica = especificacionTecnica;
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



	public BigDecimal getNroProceso() {
		return nroProceso;
	}



	public void setNroProceso(BigDecimal nroProceso) {
		this.nroProceso = nroProceso;
	}



	public String getFlagCD() {
		return flagCD;
	}



	public void setFlagCD(String flagCD) {
		this.flagCD = flagCD;
	}



	public Date getFechaDocumentoTecnico() {
		return fechaDocumentoTecnico;
	}



	public void setFechaDocumentoTecnico(Date fechaDocumentoTecnico) {
		this.fechaDocumentoTecnico = fechaDocumentoTecnico;
	}



	public Integer getEstadoRequerimiento() {
		return estadoRequerimiento;
	}



	public void setEstadoRequerimiento(Integer estadoRequerimiento) {
		this.estadoRequerimiento = estadoRequerimiento;
	}



	public String getNroRuc() {
		return nroRuc;
	}



	public void setNroRuc(String nroRuc) {
		this.nroRuc = nroRuc;
	}



	public String getNroProcesoProveedor() {
		return nroProcesoProveedor;
	}



	public void setNroProcesoProveedor(String nroProcesoProveedor) {
		this.nroProcesoProveedor = nroProcesoProveedor;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public List<CertificacionItemsDto> getCertificacionItems() {
		return certificacionItems;
	}

	public void setCertificacionItems(List<CertificacionItemsDto> certificacionItems) {
		this.certificacionItems = certificacionItems;
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

	public String getIdTipoBien() {
		return idTipoBien;
	}

	public void setIdTipoBien(String idTipoBien) {
		this.idTipoBien = idTipoBien;
	}

	public int getIdUnidadEjecutora() {
		return idUnidadEjecutora;
	}

	public void setIdUnidadEjecutora(int idUnidadEjecutora) {
		this.idUnidadEjecutora = idUnidadEjecutora;
	}
	
	public String getTipoProceso() {
		return tipoProceso;
	}

	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}
	
	public List<RequisitoConformidadDto> getListaRequisitosConformidad() {
		return listaRequisitosConformidad;
	}

	public void setListaRequisitosConformidad(List<RequisitoConformidadDto> listaRequisitosConformidad) {
		this.listaRequisitosConformidad = listaRequisitosConformidad;
	}
		
	public Integer getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(Integer unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
}
