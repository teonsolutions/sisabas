package pe.com.sisabas.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import pe.com.sisabas.be.Miembrocomiteporproceso;

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
	private String nroAnexo;
	private String rutaAnexo;
	
	private  boolean booleano;
	
	
	private List<Lugar> prestaciones;
	private List<Lugar> prestacionesEliminar;
	private List<Pago> pagos; 
	private List<Pago> pagosEliminar; 
	
	private List<Miembrocomiteporproceso> comites;
	private List<Miembrocomiteporproceso> comitesEliminar;
	
	
	private List<ComiteDto> comitesDto;
	private List<ComiteDto> comitesDtoEliminar;

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
	
	public String getNroAnexo() {
		return nroAnexo;
	}

	public void setNroAnexo(String nroAnexo) {
		this.nroAnexo = nroAnexo;
	}
	
	public List<Lugar> getPrestacionesEliminar() {
		return prestacionesEliminar;
	}

	public void setPrestacionesEliminar(List<Lugar> prestacionesEliminar) {
		this.prestacionesEliminar = prestacionesEliminar;
	}
	
	public List<Pago> getPagosEliminar() {
		return pagosEliminar;
	}

	public void setPagosEliminar(List<Pago> pagosEliminar) {
		this.pagosEliminar = pagosEliminar;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	public List<Miembrocomiteporproceso> getComites() {
		return comites;
	}

	public void setComites(List<Miembrocomiteporproceso> comites) {
		this.comites = comites;
	}

	public List<Miembrocomiteporproceso> getComitesEliminar() {
		return comitesEliminar;
	}

	public void setComitesEliminar(List<Miembrocomiteporproceso> comitesEliminar) {
		this.comitesEliminar = comitesEliminar;
	}

	public List<ComiteDto> getComitesDto() {
		return comitesDto;
	}

	public void setComitesDto(List<ComiteDto> comitesDto) {
		this.comitesDto = comitesDto;
	}

	public List<ComiteDto> getComitesDtoEliminar() {
		return comitesDtoEliminar;
	}

	public void setComitesDtoEliminar(List<ComiteDto> comitesDtoEliminar) {
		this.comitesDtoEliminar = comitesDtoEliminar;
	}

	public boolean isBooleano() {
		return booleano;
	}

	public void setBooleano(boolean booleano) {
		this.booleano = booleano;
	}

	public String getRutaAnexo() {
		return rutaAnexo;
	}

	public void setRutaAnexo(String rutaAnexo) {
		this.rutaAnexo = rutaAnexo;
	}

	
	
	
}
