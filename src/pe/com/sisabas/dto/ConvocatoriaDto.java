package pe.com.sisabas.dto;
import java.util.List;

public class ConvocatoriaDto {
	private static final long serialVersionUID = 1L;
	
	private java.lang.Integer idconvocatoriaproceso;
	private java.lang.Integer nroconvocatoria;
	private java.lang.Integer secuencia;
	private java.lang.Double valorreferencia;
	private java.lang.String idcatalogoestadoconvocatoria;
	private java.lang.String descripcionestado;
	private java.lang.Integer estadoconvocatoriaitem;	
	private java.util.Date fechainicio;
	private java.util.Date fechafin;
	private List<CalendarioDto> listaCalendario;
	
	public java.lang.Integer getIdconvocatoriaproceso() {
		return idconvocatoriaproceso;
	}
	public void setIdconvocatoriaproceso(java.lang.Integer idconvocatoriaproceso) {
		this.idconvocatoriaproceso = idconvocatoriaproceso;
	}
	public java.lang.Integer getNroconvocatoria() {
		return nroconvocatoria;
	}
	public void setNroconvocatoria(java.lang.Integer nroconvocatoria) {
		this.nroconvocatoria = nroconvocatoria;
	}
	public java.lang.Integer getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(java.lang.Integer secuencia) {
		this.secuencia = secuencia;
	}
	public java.lang.Double getValorreferencia() {
		return valorreferencia;
	}
	public void setValorreferencia(java.lang.Double valorreferencia) {
		this.valorreferencia = valorreferencia;
	}
	public java.lang.String getIdcatalogoestadoconvocatoria() {
		return idcatalogoestadoconvocatoria;
	}
	public void setIdcatalogoestadoconvocatoria(java.lang.String idcatalogoestadoconvocatoria) {
		this.idcatalogoestadoconvocatoria = idcatalogoestadoconvocatoria;
	}
	public java.lang.String getDescripcionestado() {
		return descripcionestado;
	}
	public void setDescripcionestado(java.lang.String descripcionestado) {
		this.descripcionestado = descripcionestado;
	}
	public java.lang.Integer getEstadoconvocatoriaitem() {
		return estadoconvocatoriaitem;
	}
	public void setEstadoconvocatoriaitem(java.lang.Integer estadoconvocatoriaitem) {
		this.estadoconvocatoriaitem = estadoconvocatoriaitem;
	}
	public java.util.Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(java.util.Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public java.util.Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(java.util.Date fechafin) {
		this.fechafin = fechafin;
	}
	public List<CalendarioDto> getListaCalendario() {
		return listaCalendario;
	}
	public void setListaCalendario(List<CalendarioDto> listaCalendario) {
		this.listaCalendario = listaCalendario;
	}
	
	
}
