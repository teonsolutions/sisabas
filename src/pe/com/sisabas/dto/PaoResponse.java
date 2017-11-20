package pe.com.sisabas.dto;

import java.io.Serializable;
import java.util.List;

public class PaoResponse implements  Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPacConsolid;
	private Integer idAntecedentePacConsolid;
	private String nroPac;
	private Integer nroConsolid;
	private String especificacionTecnica;
	private int idTipoNecesidad;
	private String tipoNecesidadDesc;
	private String tipoContratacionDesc;
	private String tipoProcesoDesc;
	private Integer nroProceso;
	private String estadoProcesoDesc;
	private String tipoBienDesc;
	private double valorMoneda;
	private String numeroSinad;
	private Integer estadoRequerimiento;
	private String estadoRequerimientoDesc;
	private String idDocumentos;
	private int rowTotal;
	private List<PedidosPaoResponse> pedidos;
	private CompraDirectaDatosGeneralesDto compraDirecta;

	public Integer getIdPacConsolid() {
		return idPacConsolid;
	}
	public void setIdPacConsolid(Integer idPacConsolid) {
		this.idPacConsolid = idPacConsolid;
	}
	public Integer getIdAntecedentePacConsolid() {
		return idAntecedentePacConsolid;
	}
	public void setIdAntecedentePacConsolid(Integer idAntecedentePacConsolid) {
		this.idAntecedentePacConsolid = idAntecedentePacConsolid;
	}
	public String getNroPac() {
		return nroPac;
	}
	public void setNroPac(String nroPac) {
		this.nroPac = nroPac;
	}
	public Integer getNroConsolid() {
		return nroConsolid;
	}
	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}
	public String getEspecificacionTecnica() {
		return especificacionTecnica;
	}
	public void setEspecificacionTecnica(String especificacionTecnica) {
		this.especificacionTecnica = especificacionTecnica;
	}
	public int getIdTipoNecesidad() {
		return idTipoNecesidad;
	}
	public void setIdTipoNecesidad(int idTipoNecesidad) {
		this.idTipoNecesidad = idTipoNecesidad;
	}
	public String getTipoNecesidadDesc() {
		return tipoNecesidadDesc;
	}
	public void setTipoNecesidadDesc(String tipoNecesidadDesc) {
		this.tipoNecesidadDesc = tipoNecesidadDesc;
	}
	public String getTipoContratacionDesc() {
		return tipoContratacionDesc;
	}
	public void setTipoContratacionDesc(String tipoContratacionDesc) {
		this.tipoContratacionDesc = tipoContratacionDesc;
	}
	public String getTipoProcesoDesc() {
		return tipoProcesoDesc;
	}
	public void setTipoProcesoDesc(String tipoProcesoDesc) {
		this.tipoProcesoDesc = tipoProcesoDesc;
	}
	public Integer getNroProceso() {
		return nroProceso;
	}
	public void setNroProceso(Integer nroProceso) {
		this.nroProceso = nroProceso;
	}
	public String getEstadoProcesoDesc() {
		return estadoProcesoDesc;
	}
	public void setEstadoProcesoDesc(String estadoProcesoDesc) {
		this.estadoProcesoDesc = estadoProcesoDesc;
	}
	public String getTipoBienDesc() {
		return tipoBienDesc;
	}
	public void setTipoBienDesc(String tipoBienDesc) {
		this.tipoBienDesc = tipoBienDesc;
	}
	public double getValorMoneda() {
		return valorMoneda;
	}
	public void setValorMoneda(double valorMoneda) {
		this.valorMoneda = valorMoneda;
	}
	public String getNumeroSinad() {
		return numeroSinad;
	}
	public void setNumeroSinad(String numeroSinad) {
		this.numeroSinad = numeroSinad;
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
	public String getIdDocumentos() {
		return idDocumentos;
	}
	public void setIdDocumentos(String idDocumentos) {
		this.idDocumentos = idDocumentos;
	}
	public int getRowTotal() {
		return rowTotal;
	}
	public void setRowTotal(int rowTotal) {
		this.rowTotal = rowTotal;
	}

	public List<PedidosPaoResponse> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<PedidosPaoResponse> pedidos) {
		this.pedidos = pedidos;
	}
	
	public CompraDirectaDatosGeneralesDto getCompraDirecta() {
		return compraDirecta;
	}
	public void setCompraDirecta(CompraDirectaDatosGeneralesDto compraDirecta) {
		this.compraDirecta = compraDirecta;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }		
}
