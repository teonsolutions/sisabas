package pe.com.sisabas.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EspecificacionTecnicaDto implements  Serializable,Cloneable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer idPedido;
	private Integer iddocumentotecnico;
	private Date fechacreacionauditoria;
	private String usuarioAuditoria;
		
	/** Documentacion Tecnica**/
	private String denominacioncontratacion;
	private String finalidadpublica;
	private String objetocontratacion;
	private String antecedentes;
	private String tipoEsp;
	private Integer nroPac;
	
	
	private List<Lugar> prestaciones;
	private List<Pago> pagos; 


	public Integer getNroPac() {
		return nroPac;
	}

	public void setNroPac(Integer nroPac) {
		this.nroPac = nroPac;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public List<Lugar> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(List<Lugar> prestaciones) {
		this.prestaciones = prestaciones;
	}

	public String getTipoEsp() {
		return tipoEsp;
	}

	public void setTipoEsp(String tipoEsp) {
		this.tipoEsp = tipoEsp;
	}

	public String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

	public String getDenominacioncontratacion() {
		return denominacioncontratacion;
	}

	public void setDenominacioncontratacion(String denominacioncontratacion) {
		this.denominacioncontratacion = denominacioncontratacion;
	}

	public String getFinalidadpublica() {
		return finalidadpublica;
	}

	public void setFinalidadpublica(String finalidadpublica) {
		this.finalidadpublica = finalidadpublica;
	}

	public String getObjetocontratacion() {
		return objetocontratacion;
	}

	public void setObjetocontratacion(String objetocontratacion) {
		this.objetocontratacion = objetocontratacion;
	}

	public String getUsuarioAuditoria() {
		return usuarioAuditoria;
	}

	public void setUsuarioAuditoria(String usuarioAuditoria) {
		this.usuarioAuditoria = usuarioAuditoria;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	
	public Integer getIddocumentotecnico() {
		return iddocumentotecnico;
	}

	public void setIddocumentotecnico(Integer iddocumentotecnico) {
		this.iddocumentotecnico = iddocumentotecnico;
	}
	

	public Date getFechacreacionauditoria() {
		return fechacreacionauditoria;
	}

	public void setFechacreacionauditoria(Date fechacreacionauditoria) {
		this.fechacreacionauditoria = fechacreacionauditoria;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }	
	
	
	
}
