
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[PacProgramado]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Pacprogramado extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idpacprogramado;
	/**[anio]*/
	private java.lang.Integer anio;
	/**[Unidad Ejecutora]*/
	private java.lang.Integer idunidadejecutora;
	private Unidadejecutora unidadejecutoraIdunidadejecutora;
	/**[Numero consolidacion]*/
	private java.lang.String nroconsolid;
	/**[Especificación Técnica]*/
	private java.lang.String especificaciontecnica;
	/**[Tipo bien][TIBI]*/
	private java.lang.String idcatalogotipobien;
	private Gentabla gentablaIdcatalogotipobien;
	/**[Monto PAO]*/
	private java.math.BigDecimal montopao;
	private java.math.BigDecimal montopaoini;
	private java.math.BigDecimal montopaofin;
	/**[Código Centro Costo]*/
	private java.lang.String codigocentrocosto;
	/**[Nombre de dependencia]*/
	private java.lang.String nombredependencia;
	/**[Estado]*/
	private java.lang.Integer estado;	
	/**[Tipo documento Sinad]*/
	private java.lang.String tipodocumentosinad;
	/**[Número documento Sinad]*/
	private java.lang.String numerodocumentosinad;
	/**[Número Sinad]*/
	private java.lang.Integer numerosinad;
	/**[Año Sinad]*/
	private java.lang.Integer aniosinad;
	/**[Número Expediente Sinad]*/
	private java.lang.String numeroexpedientesinad;
	/**[*][Fecha creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario creación]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha modificación]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario modificación]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][Equipo auditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa auditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Pacprogramado() {}

	public Pacprogramado(java.lang.Integer idpacprogramado) {
		this.idpacprogramado=idpacprogramado;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Pacprogramado)
			return ((Pacprogramado)obj).getIdpacprogramado().equals(this.getIdpacprogramado()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idpacprogramado!=null)?("idpacprogramado:\t" + this.idpacprogramado+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.nroconsolid!=null)?("nroconsolid:\t" + this.nroconsolid+"\n"):"" ).concat(
			(this.especificaciontecnica!=null)?("especificaciontecnica:\t" + this.especificaciontecnica+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.montopao!=null)?("montopao:\t" + this.montopao+"\n"):"" ).concat(
			(this.codigocentrocosto!=null)?("codigocentrocosto:\t" + this.codigocentrocosto+"\n"):"" ).concat(
			(this.nombredependencia!=null)?("nombredependencia:\t" + this.nombredependencia+"\n"):"" ).concat(
			(this.tipodocumentosinad!=null)?("tipodocumentosinad:\t" + this.tipodocumentosinad+"\n"):"" ).concat(
			(this.numerodocumentosinad!=null)?("numerodocumentosinad:\t" + this.numerodocumentosinad+"\n"):"" ).concat(
			(this.numerosinad!=null)?("numerosinad:\t" + this.numerosinad+"\n"):"" ).concat(
			(this.aniosinad!=null)?("aniosinad:\t" + this.aniosinad+"\n"):"" ).concat(
			(this.numeroexpedientesinad!=null)?("numeroexpedientesinad:\t" + this.numeroexpedientesinad+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idpacprogramado!=null)?("idpacprogramado:\t" + this.idpacprogramado+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.idunidadejecutora!=null)?("idunidadejecutora:\t" + this.idunidadejecutora+"\n"):"" ).concat(
			(this.unidadejecutoraIdunidadejecutora!=null)?("unidadejecutoraIdunidadejecutora:\t" + this.unidadejecutoraIdunidadejecutora.toString()+"\n"):"" ).concat(
			(this.nroconsolid!=null)?("nroconsolid:\t" + this.nroconsolid+"\n"):"" ).concat(
			(this.especificaciontecnica!=null)?("especificaciontecnica:\t" + this.especificaciontecnica+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipobien!=null)?("gentablaIdcatalogotipobien:\t" + this.gentablaIdcatalogotipobien.toString()+"\n"):"" ).concat(
			(this.montopao!=null)?("montopao:\t" + this.montopao+"\n"):"" ).concat(
			(this.codigocentrocosto!=null)?("codigocentrocosto:\t" + this.codigocentrocosto+"\n"):"" ).concat(
			(this.nombredependencia!=null)?("nombredependencia:\t" + this.nombredependencia+"\n"):"" ).concat(
			(this.tipodocumentosinad!=null)?("tipodocumentosinad:\t" + this.tipodocumentosinad+"\n"):"" ).concat(
			(this.numerodocumentosinad!=null)?("numerodocumentosinad:\t" + this.numerodocumentosinad+"\n"):"" ).concat(
			(this.numerosinad!=null)?("numerosinad:\t" + this.numerosinad+"\n"):"" ).concat(
			(this.aniosinad!=null)?("aniosinad:\t" + this.aniosinad+"\n"):"" ).concat(
			(this.numeroexpedientesinad!=null)?("numeroexpedientesinad:\t" + this.numeroexpedientesinad+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public static final boolean HAVE_BIGDECIMALS=true;
	public void roundBigDecimals(){
		if(this.montopao!=null)
			montopao=Utils.round(montopao);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.Integer> listaIdunidadejecutoraInKeys;
	public void addConditionInIdunidadejecutora(List<String> list){
		if(list==null || list.size()==0){
			idunidadejecutora=null;
			listaIdunidadejecutoraInKeys=null;
			return;
		}
		if(list.size()==1){
			idunidadejecutora=Integer.parseInt(list.get(0));
			listaIdunidadejecutoraInKeys=null;
		}else{
			idunidadejecutora=null;
			listaIdunidadejecutoraInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdunidadejecutoraInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdunidadejecutoraInKeys() {
		return listaIdunidadejecutoraInKeys;
	}

	private List<java.lang.String> listaIdcatalogotipobienInKeys;
	public void addConditionInIdcatalogotipobien(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipobien=null;
			idcatalogotipobien=null;
			listaIdcatalogotipobienInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipobien=list.get(0);
			listaIdcatalogotipobienInKeys=null;
		}else{
			idcatalogotipobien=null;
			listaIdcatalogotipobienInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipobienInKeys() {
		return listaIdcatalogotipobienInKeys;
	}

	 public java.lang.Integer getIdpacprogramado() {
		return idpacprogramado;
	}

	public void setIdpacprogramado(java.lang.Integer idpacprogramado) {
		this.idpacprogramado = idpacprogramado;
	}

	 public java.lang.Integer getAnio() {
		return anio;
	}

	public void setAnio(java.lang.Integer anio) {
		this.anio = anio;
	}

	 public java.lang.Integer getIdunidadejecutora() {
		return idunidadejecutora;
	}

	public void setIdunidadejecutora(java.lang.Integer idunidadejecutora) {
		this.idunidadejecutora = idunidadejecutora;
	}

	 public Unidadejecutora getUnidadejecutoraIdunidadejecutora() {
		return unidadejecutoraIdunidadejecutora;
	}

	public void setUnidadejecutoraIdunidadejecutora(Unidadejecutora unidadejecutoraIdunidadejecutora) {
		this.unidadejecutoraIdunidadejecutora = unidadejecutoraIdunidadejecutora;
	}

	 public java.lang.String getNroconsolid() {
		return nroconsolid;
	}

	public void setNroconsolid(java.lang.String nroconsolid) {
		this.nroconsolid = nroconsolid;
	}

	 public java.lang.String getEspecificaciontecnica() {
		return especificaciontecnica;
	}

	public void setEspecificaciontecnica(java.lang.String especificaciontecnica) {
		this.especificaciontecnica = especificaciontecnica;
	}

	 public java.lang.String getIdcatalogotipobien() {
		return idcatalogotipobien;
	}

	public void setIdcatalogotipobien(java.lang.String idcatalogotipobien) {
		this.idcatalogotipobien = idcatalogotipobien;
	}

	 public Gentabla getGentablaIdcatalogotipobien() {
		return gentablaIdcatalogotipobien;
	}

	public void setGentablaIdcatalogotipobien(Gentabla gentablaIdcatalogotipobien) {
		this.gentablaIdcatalogotipobien = gentablaIdcatalogotipobien;
	}

	 public java.math.BigDecimal getMontopao() {
		return montopao;
	}

	public void setMontopao(java.math.BigDecimal montopao) {
		this.montopao = montopao;
	}

	 public java.math.BigDecimal getMontopaoini() {
		return montopaoini;
	}

	public void setMontopaoini(java.math.BigDecimal montopaoini) {
		this.montopaoini = montopaoini;
	}

	 public java.math.BigDecimal getMontopaofin() {
		return montopaofin;
	}

	public void setMontopaofin(java.math.BigDecimal montopaofin) {
		this.montopaofin = montopaofin;
	}

	 public java.lang.String getCodigocentrocosto() {
		return codigocentrocosto;
	}

	public void setCodigocentrocosto(java.lang.String codigocentrocosto) {
		this.codigocentrocosto = codigocentrocosto;
	}

	 public java.lang.String getNombredependencia() {
		return nombredependencia;
	}

	public void setNombredependencia(java.lang.String nombredependencia) {
		this.nombredependencia = nombredependencia;
	}

	 public java.lang.Integer getEstado() {
		return estado;
	}

	public void setEstado(java.lang.Integer estado) {
		this.estado = estado;
	}

	 public java.lang.String getTipodocumentosinad() {
		return tipodocumentosinad;
	}

	public void setTipodocumentosinad(java.lang.String tipodocumentosinad) {
		this.tipodocumentosinad = tipodocumentosinad;
	}

	 public java.lang.String getNumerodocumentosinad() {
		return numerodocumentosinad;
	}

	public void setNumerodocumentosinad(java.lang.String numerodocumentosinad) {
		this.numerodocumentosinad = numerodocumentosinad;
	}

	 public java.lang.Integer getNumerosinad() {
		return numerosinad;
	}

	public void setNumerosinad(java.lang.Integer numerosinad) {
		this.numerosinad = numerosinad;
	}

	 public java.lang.Integer getAniosinad() {
		return aniosinad;
	}

	public void setAniosinad(java.lang.Integer aniosinad) {
		this.aniosinad = aniosinad;
	}

	 public java.lang.String getNumeroexpedientesinad() {
		return numeroexpedientesinad;
	}

	public void setNumeroexpedientesinad(java.lang.String numeroexpedientesinad) {
		this.numeroexpedientesinad = numeroexpedientesinad;
	}

	 public java.util.Date getFechacreacionauditoria() {
		return fechacreacionauditoria;
	}

	public void setFechacreacionauditoria(java.util.Date fechacreacionauditoria) {
		this.fechacreacionauditoria = fechacreacionauditoria;
	}

	 public java.util.Date getFechacreacionauditoriaini() {
		return fechacreacionauditoriaini;
	}

	public void setFechacreacionauditoriaini(java.util.Date fechacreacionauditoriaini) {
		this.fechacreacionauditoriaini = fechacreacionauditoriaini;
	}

	 public java.util.Date getFechacreacionauditoriafin() {
		return fechacreacionauditoriafin;
	}

	public void setFechacreacionauditoriafin(java.util.Date fechacreacionauditoriafin) {
		this.fechacreacionauditoriafin = fechacreacionauditoriafin;
	}

	 public java.lang.String getUsuariocreacionauditoria() {
		return usuariocreacionauditoria;
	}

	public void setUsuariocreacionauditoria(java.lang.String usuariocreacionauditoria) {
		this.usuariocreacionauditoria = usuariocreacionauditoria;
	}

	 public java.util.Date getFechamodificacionauditoria() {
		return fechamodificacionauditoria;
	}

	public void setFechamodificacionauditoria(java.util.Date fechamodificacionauditoria) {
		this.fechamodificacionauditoria = fechamodificacionauditoria;
	}

	 public java.util.Date getFechamodificacionauditoriaini() {
		return fechamodificacionauditoriaini;
	}

	public void setFechamodificacionauditoriaini(java.util.Date fechamodificacionauditoriaini) {
		this.fechamodificacionauditoriaini = fechamodificacionauditoriaini;
	}

	 public java.util.Date getFechamodificacionauditoriafin() {
		return fechamodificacionauditoriafin;
	}

	public void setFechamodificacionauditoriafin(java.util.Date fechamodificacionauditoriafin) {
		this.fechamodificacionauditoriafin = fechamodificacionauditoriafin;
	}

	 public java.lang.String getUsuariomodificacionauditoria() {
		return usuariomodificacionauditoria;
	}

	public void setUsuariomodificacionauditoria(java.lang.String usuariomodificacionauditoria) {
		this.usuariomodificacionauditoria = usuariomodificacionauditoria;
	}

	 public java.lang.String getEquipoauditoria() {
		return equipoauditoria;
	}

	public void setEquipoauditoria(java.lang.String equipoauditoria) {
		this.equipoauditoria = equipoauditoria;
	}

	 public java.lang.String getProgramaauditoria() {
		return programaauditoria;
	}

	public void setProgramaauditoria(java.lang.String programaauditoria) {
		this.programaauditoria = programaauditoria;
	}

	 public java.lang.String getEstadoauditoria() {
		return estadoauditoria;
	}

	public void setEstadoauditoria(java.lang.String estadoauditoria) {
		this.estadoauditoria = estadoauditoria;
	}

}
