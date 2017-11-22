package pe.com.sisabas.service;

/***
 * Para guardar periodo activo en una sesion
 * @author ACALDAS
 *
 */
public class Sicuperiodo implements java.io.Serializable{
	public String getCodigoCentroCosto() {
		return codigoCentroCosto;
	}
	public void setCodigoCentroCosto(String codigoCentroCosto) {
		this.codigoCentroCosto = codigoCentroCosto;
	}
	public String getNombreCentroCosto() {
		return nombreCentroCosto;
	}
	public void setNombreCentroCosto(String nombreCentroCosto) {
		this.nombreCentroCosto = nombreCentroCosto;
	}
	public Integer getIdPeriodo() {
		return idPeriodo;
	}
	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	private String codigoCentroCosto;
	private String nombreCentroCosto;
	private Integer idPeriodo;
	private Integer anio;	
}
