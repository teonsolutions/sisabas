package pe.com.sisabas.dto;

public class Lugar {
	
	private Integer idDependenciaDocumentoTecnico;
	public Integer getIdDependenciaDocumentoTecnico() {
		return idDependenciaDocumentoTecnico;
	}
	public void setIdDependenciaDocumentoTecnico(Integer idDependenciaDocumentoTecnico) {
		this.idDependenciaDocumentoTecnico = idDependenciaDocumentoTecnico;
	}
	private String dependencia;
	private String direccion;
	
	private int index;
	
	public String getDependencia() {
		return dependencia;
	}
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Lugar() {
		
	}
	
	
	
}
