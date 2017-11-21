package pe.com.sisabas.dto;

import java.io.Serializable;

public class CertificacionItemsDto implements Serializable,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer nroCP;
	private String fuenteFinanciamiento;
	private String secuenciaFunc;
	private String clasificador;
	private Double valor;
	
	public Integer getNroCP() {
		return nroCP;
	}



	public void setNroCP(Integer nroCP) {
		this.nroCP = nroCP;
	}



	public String getFuenteFinanciamiento() {
		return fuenteFinanciamiento;
	}



	public void setFuenteFinanciamiento(String fuenteFinanciamiento) {
		this.fuenteFinanciamiento = fuenteFinanciamiento;
	}



	public String getSecuenciaFunc() {
		return secuenciaFunc;
	}



	public void setSecuenciaFunc(String secuenciaFunc) {
		this.secuenciaFunc = secuenciaFunc;
	}



	public String getClasificador() {
		return clasificador;
	}



	public void setClasificador(String clasificador) {
		this.clasificador = clasificador;
	}



	public Double getValor() {
		return valor;
	}



	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
}
