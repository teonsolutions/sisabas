package pe.com.sisabas.dto;

public class ContratoSigaResponse {
	private String nroRuc;
	private String tipoContrato;
	private Integer nroContrato;
	private String secContrato;
	private Integer proveedor;
	private String nombreProveedor;
	private Double valorMoneda;
	
	public String getNroRuc() {
		return nroRuc;
	}
	public void setNroRuc(String nroRuc) {
		this.nroRuc = nroRuc;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public Integer getNroContrato() {
		return nroContrato;
	}
	public void setNroContrato(Integer nroContrato) {
		this.nroContrato = nroContrato;
	}
	public String getSecContrato() {
		return secContrato;
	}
	public void setSecContrato(String secContrato) {
		this.secContrato = secContrato;
	}
	public Integer getProveedor() {
		return proveedor;
	}
	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public Double getValorMoneda() {
		return valorMoneda;
	}
	public void setValorMoneda(Double valorMoneda) {
		this.valorMoneda = valorMoneda;
	}	
	
		
}
