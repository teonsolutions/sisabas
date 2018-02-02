package pe.com.sisabas.dto;

public class EstadoRequerimientoResponse {
	private Integer id;
	private String descripcion;
	private Integer idEstadosPorTipoDocumento;
	public EstadoRequerimientoResponse(){
		
	}
	
	public EstadoRequerimientoResponse(Integer idEstadoPorEtapa, String descripcion, Integer idEstadosPorTipoDocumento){
		this.id = idEstadoPorEtapa;
		this.descripcion = descripcion;
		this.idEstadosPorTipoDocumento = idEstadosPorTipoDocumento;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdEstadosPorTipoDocumento() {
		return idEstadosPorTipoDocumento;
	}
	public void setIdEstadosPorTipoDocumento(Integer idEstadosPorTipoDocumento) {
		this.idEstadosPorTipoDocumento = idEstadosPorTipoDocumento;
	}
	
}
