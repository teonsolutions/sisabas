package pe.com.sisabas.dto;

import java.util.Date;

public class ProcesoResultadoItemDesiertoDto {
	private Integer idresultadoproceso;
	private Integer idconvocatoriaproceso;
	private String nroitem;
	private String nombreitem;
	private String nroruc;
	private String nombreproveedor;
	private String idcatalogoestadoresultado;
	private Integer estadoprocesoitem;
	private Double valorreferencial;
	private String descripcionestado;
	private Date fecharemision;
	private String usuarioasignado;
	private String numeroadjsimplificada;
	private String esprocesado;
	
	//additional
	private boolean selected;
	
	public Integer getIdresultadoproceso() {
		return idresultadoproceso;
	}
	public void setIdresultadoproceso(Integer idresultadoproceso) {
		this.idresultadoproceso = idresultadoproceso;
	}
	public Integer getIdconvocatoriaproceso() {
		return idconvocatoriaproceso;
	}
	public void setIdconvocatoriaproceso(Integer idconvocatoriaproceso) {
		this.idconvocatoriaproceso = idconvocatoriaproceso;
	}
	public String getNroitem() {
		return nroitem;
	}
	public void setNroitem(String nroitem) {
		this.nroitem = nroitem;
	}
	public String getNombreitem() {
		return nombreitem;
	}
	public void setNombreitem(String nombreitem) {
		this.nombreitem = nombreitem;
	}
	public String getNroruc() {
		return nroruc;
	}
	public void setNroruc(String nroruc) {
		this.nroruc = nroruc;
	}
	public String getNombreproveedor() {
		return nombreproveedor;
	}
	public void setNombreproveedor(String nombreproveedor) {
		this.nombreproveedor = nombreproveedor;
	}
	public String getIdcatalogoestadoresultado() {
		return idcatalogoestadoresultado;
	}
	public void setIdcatalogoestadoresultado(String idcatalogoestadoresultado) {
		this.idcatalogoestadoresultado = idcatalogoestadoresultado;
	}
	public Integer getEstadoprocesoitem() {
		return estadoprocesoitem;
	}
	public void setEstadoprocesoitem(Integer estadoprocesoitem) {
		this.estadoprocesoitem = estadoprocesoitem;
	}
	public Double getValorreferencial() {
		return valorreferencial;
	}
	public void setValorreferencial(Double valorreferencial) {
		this.valorreferencial = valorreferencial;
	}
	public String getDescripcionestado() {
		return descripcionestado;
	}
	public void setDescripcionestado(String descripcionestado) {
		this.descripcionestado = descripcionestado;
	}
	public Date getFecharemision() {
		return fecharemision;
	}
	public void setFecharemision(Date fecharemision) {
		this.fecharemision = fecharemision;
	}
	public String getUsuarioasignado() {
		return usuarioasignado;
	}
	public void setUsuarioasignado(String usuarioasignado) {
		this.usuarioasignado = usuarioasignado;
	}
	public String getNumeroadjsimplificada() {
		return numeroadjsimplificada;
	}
	public void setNumeroadjsimplificada(String numeroadjsimplificada) {
		this.numeroadjsimplificada = numeroadjsimplificada;
	}
	public String getEsprocesado() {
		return esprocesado;
	}
	public void setEsprocesado(String esprocesado) {
		this.esprocesado = esprocesado;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
