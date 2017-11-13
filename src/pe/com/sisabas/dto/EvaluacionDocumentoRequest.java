package pe.com.sisabas.dto;

import org.primefaces.push.Status.STATUS;

public class EvaluacionDocumentoRequest {
	private String idcatalogotiponecesidad;
	private String idcatalogotipobien;
	private int estadoPedido;
	private String nroDocumento;
	private String numeroSinad;
	private int idUnidadEjecutora;
	private int anio;
	private String descripcionSiga;
	private String descripcionOficinas;
	private int pageNumber;
	private int pageSize;
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getIdUnidadEjecutora() {
		return idUnidadEjecutora;
	}
	public void setIdUnidadEjecutora(int idUnidadEjecutora) {
		this.idUnidadEjecutora = idUnidadEjecutora;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getDescripcionSiga() {
		return descripcionSiga;
	}
	public void setDescripcionSiga(String descripcionSiga) {
		this.descripcionSiga = descripcionSiga;
	}
	public String getDescripcionOficinas() {
		return descripcionOficinas;
	}
	public void setDescripcionOficinas(String descripcionOficinas) {
		this.descripcionOficinas = descripcionOficinas;
	}

	
	public String getIdcatalogotiponecesidad() {
		return idcatalogotiponecesidad;
	}
	public void setIdcatalogotiponecesidad(String idcatalogotiponecesidad) {
		this.idcatalogotiponecesidad = idcatalogotiponecesidad;
	}
	public String getIdcatalogotipobien() {
		return idcatalogotipobien;
	}
	public void setIdcatalogotipobien(String idcatalogotipobien) {
		this.idcatalogotipobien = idcatalogotipobien;
	}
	public int getEstadoPedido() {
		return estadoPedido;
	}
	public void setEstadoPedido(int estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getNumeroSinad() {
		return numeroSinad;
	}
	public void setNumeroSinad(String numeroSinad) {
		this.numeroSinad = numeroSinad;
	}
	
}
