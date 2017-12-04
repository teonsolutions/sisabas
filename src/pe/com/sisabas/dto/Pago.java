package pe.com.sisabas.dto;

import java.math.BigDecimal;

public class Pago {
	
	private Integer idDependenciaDocumentoTecnico;
	private int numero;
	private BigDecimal porcentaje;
	
	private String cronograma;
	private Integer plazo;
	private String nivel;
	
	
	
	public String getCronograma() {
		return cronograma;
	}
	public void setCronograma(String cronograma) {
		this.cronograma = cronograma;
	}
	public Integer getPlazo() {
		return plazo;
	}
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Integer getIdDependenciaDocumentoTecnico() {
		return idDependenciaDocumentoTecnico;
	}
	public void setIdDependenciaDocumentoTecnico(Integer idDependenciaDocumentoTecnico) {
		this.idDependenciaDocumentoTecnico = idDependenciaDocumentoTecnico;
	}
	
	
	

}
