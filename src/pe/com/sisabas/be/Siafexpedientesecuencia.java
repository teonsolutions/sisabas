
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[SiafExpedienteSecuencia]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Siafexpedientesecuencia extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[IdSiafExpedienteSecuencia]*/
	private java.lang.Integer idsiafexpedientesecuencia;
	/**[IdLog]*/
	private java.lang.Integer idlog;
	private Siaflog siaflogIdlog;
	/**[FechaCarga]*/
	private java.lang.Integer fechacarga;
	/**[Anio]*/
	private java.lang.String anio;
	/**[SecEjec]*/
	private java.lang.String secejec;
	/**[Expediente]*/
	private java.lang.String expediente;
	/**[AnioProceso]*/
	private java.lang.String anioproceso;
	/**[CodigoDocumento]*/
	private java.lang.String codigodocumento;
	/**[NumeroDocumento]*/
	private java.lang.String numerodocumento;
	/**[MontoNacional]*/
	private java.math.BigDecimal montonacional;
	private java.math.BigDecimal montonacionalini;
	private java.math.BigDecimal montonacionalfin;
	/**[MesProceso]*/
	private java.lang.String mesproceso;
	/**[FechaDocumento]*/
	private java.util.Date fechadocumento;
	private java.util.Date fechadocumentoini;
	private java.util.Date fechadocumentofin;
	/**[Ciclo]*/
	private java.lang.String ciclo;
	/**[Fase]*/
	private java.lang.String fase;
	/**[FechaCreacionAuditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[UsuarioCreacionAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[FechaModificacionAuditoria]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[UsuarioModificacionAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][EquipoAuditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[IdVCertificacion]*/
	private java.lang.Integer idvcertificacion;
	private Vcertificacion vcertificacionIdvcertificacion;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Siafexpedientesecuencia() {}

	public Siafexpedientesecuencia(java.lang.Integer idsiafexpedientesecuencia) {
		this.idsiafexpedientesecuencia=idsiafexpedientesecuencia;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Siafexpedientesecuencia)
			return ((Siafexpedientesecuencia)obj).getIdsiafexpedientesecuencia().equals(this.getIdsiafexpedientesecuencia()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idsiafexpedientesecuencia!=null)?("idsiafexpedientesecuencia:\t" + this.idsiafexpedientesecuencia+"\n"):"" ).concat(
			(this.idlog!=null)?("idlog:\t" + this.idlog+"\n"):"" ).concat(
			(this.fechacarga!=null)?("fechacarga:\t" + this.fechacarga+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.expediente!=null)?("expediente:\t" + this.expediente+"\n"):"" ).concat(
			(this.anioproceso!=null)?("anioproceso:\t" + this.anioproceso+"\n"):"" ).concat(
			(this.codigodocumento!=null)?("codigodocumento:\t" + this.codigodocumento+"\n"):"" ).concat(
			(this.numerodocumento!=null)?("numerodocumento:\t" + this.numerodocumento+"\n"):"" ).concat(
			(this.montonacional!=null)?("montonacional:\t" + this.montonacional+"\n"):"" ).concat(
			(this.mesproceso!=null)?("mesproceso:\t" + this.mesproceso+"\n"):"" ).concat(
			(this.fechadocumento!=null)?("fechadocumento:\t" + this.fechadocumento+"\n"):"" ).concat(
			(this.ciclo!=null)?("ciclo:\t" + this.ciclo+"\n"):"" ).concat(
			(this.fase!=null)?("fase:\t" + this.fase+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.idvcertificacion!=null)?("idvcertificacion:\t" + this.idvcertificacion+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idsiafexpedientesecuencia!=null)?("idsiafexpedientesecuencia:\t" + this.idsiafexpedientesecuencia+"\n"):"" ).concat(
			(this.idlog!=null)?("idlog:\t" + this.idlog+"\n"):"" ).concat(
			(this.siaflogIdlog!=null)?("siaflogIdlog:\t" + this.siaflogIdlog.toString()+"\n"):"" ).concat(
			(this.fechacarga!=null)?("fechacarga:\t" + this.fechacarga+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.expediente!=null)?("expediente:\t" + this.expediente+"\n"):"" ).concat(
			(this.anioproceso!=null)?("anioproceso:\t" + this.anioproceso+"\n"):"" ).concat(
			(this.codigodocumento!=null)?("codigodocumento:\t" + this.codigodocumento+"\n"):"" ).concat(
			(this.numerodocumento!=null)?("numerodocumento:\t" + this.numerodocumento+"\n"):"" ).concat(
			(this.montonacional!=null)?("montonacional:\t" + this.montonacional+"\n"):"" ).concat(
			(this.mesproceso!=null)?("mesproceso:\t" + this.mesproceso+"\n"):"" ).concat(
			(this.fechadocumento!=null)?("fechadocumento:\t" + this.fechadocumento+"\n"):"" ).concat(
			(this.ciclo!=null)?("ciclo:\t" + this.ciclo+"\n"):"" ).concat(
			(this.fase!=null)?("fase:\t" + this.fase+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.idvcertificacion!=null)?("idvcertificacion:\t" + this.idvcertificacion+"\n"):"" ).concat(
			(this.vcertificacionIdvcertificacion!=null)?("vcertificacionIdvcertificacion:\t" + this.vcertificacionIdvcertificacion.toString()+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public static final boolean HAVE_BIGDECIMALS=true;
	public void roundBigDecimals(){
		if(this.montonacional!=null)
			montonacional=Utils.round(montonacional);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.Integer> listaIdlogInKeys;
	public void addConditionInIdlog(List<String> list){
		if(list==null || list.size()==0){
			idlog=null;
			listaIdlogInKeys=null;
			return;
		}
		if(list.size()==1){
			idlog=Integer.parseInt(list.get(0));
			listaIdlogInKeys=null;
		}else{
			idlog=null;
			listaIdlogInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdlogInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdlogInKeys() {
		return listaIdlogInKeys;
	}

	private List<java.lang.Integer> listaIdvcertificacionInKeys;
	public void addConditionInIdvcertificacion(List<String> list){
		if(list==null || list.size()==0){
			idvcertificacion=null;
			listaIdvcertificacionInKeys=null;
			return;
		}
		if(list.size()==1){
			idvcertificacion=Integer.parseInt(list.get(0));
			listaIdvcertificacionInKeys=null;
		}else{
			idvcertificacion=null;
			listaIdvcertificacionInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdvcertificacionInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdvcertificacionInKeys() {
		return listaIdvcertificacionInKeys;
	}


	 public java.lang.Integer getIdsiafexpedientesecuencia() {
		return idsiafexpedientesecuencia;
	}

	public void setIdsiafexpedientesecuencia(java.lang.Integer idsiafexpedientesecuencia) {
		this.idsiafexpedientesecuencia = idsiafexpedientesecuencia;
	}

	 public java.lang.Integer getIdlog() {
		return idlog;
	}

	public void setIdlog(java.lang.Integer idlog) {
		this.idlog = idlog;
	}

	 public Siaflog getSiaflogIdlog() {
		return siaflogIdlog;
	}

	public void setSiaflogIdlog(Siaflog siaflogIdlog) {
		this.siaflogIdlog = siaflogIdlog;
	}

	 public java.lang.Integer getFechacarga() {
		return fechacarga;
	}

	public void setFechacarga(java.lang.Integer fechacarga) {
		this.fechacarga = fechacarga;
	}

	 public java.lang.String getAnio() {
		return anio;
	}

	public void setAnio(java.lang.String anio) {
		this.anio = anio;
	}

	 public java.lang.String getSecejec() {
		return secejec;
	}

	public void setSecejec(java.lang.String secejec) {
		this.secejec = secejec;
	}

	 public java.lang.String getExpediente() {
		return expediente;
	}

	public void setExpediente(java.lang.String expediente) {
		this.expediente = expediente;
	}

	 public java.lang.String getAnioproceso() {
		return anioproceso;
	}

	public void setAnioproceso(java.lang.String anioproceso) {
		this.anioproceso = anioproceso;
	}

	 public java.lang.String getCodigodocumento() {
		return codigodocumento;
	}

	public void setCodigodocumento(java.lang.String codigodocumento) {
		this.codigodocumento = codigodocumento;
	}

	 public java.lang.String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(java.lang.String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	 public java.math.BigDecimal getMontonacional() {
		return montonacional;
	}

	public void setMontonacional(java.math.BigDecimal montonacional) {
		this.montonacional = montonacional;
	}

	 public java.math.BigDecimal getMontonacionalini() {
		return montonacionalini;
	}

	public void setMontonacionalini(java.math.BigDecimal montonacionalini) {
		this.montonacionalini = montonacionalini;
	}

	 public java.math.BigDecimal getMontonacionalfin() {
		return montonacionalfin;
	}

	public void setMontonacionalfin(java.math.BigDecimal montonacionalfin) {
		this.montonacionalfin = montonacionalfin;
	}

	 public java.lang.String getMesproceso() {
		return mesproceso;
	}

	public void setMesproceso(java.lang.String mesproceso) {
		this.mesproceso = mesproceso;
	}

	 public java.util.Date getFechadocumento() {
		return fechadocumento;
	}

	public void setFechadocumento(java.util.Date fechadocumento) {
		this.fechadocumento = fechadocumento;
	}

	 public java.util.Date getFechadocumentoini() {
		return fechadocumentoini;
	}

	public void setFechadocumentoini(java.util.Date fechadocumentoini) {
		this.fechadocumentoini = fechadocumentoini;
	}

	 public java.util.Date getFechadocumentofin() {
		return fechadocumentofin;
	}

	public void setFechadocumentofin(java.util.Date fechadocumentofin) {
		this.fechadocumentofin = fechadocumentofin;
	}

	 public java.lang.String getCiclo() {
		return ciclo;
	}

	public void setCiclo(java.lang.String ciclo) {
		this.ciclo = ciclo;
	}

	 public java.lang.String getFase() {
		return fase;
	}

	public void setFase(java.lang.String fase) {
		this.fase = fase;
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

	 public java.lang.Integer getIdvcertificacion() {
		return idvcertificacion;
	}

	public void setIdvcertificacion(java.lang.Integer idvcertificacion) {
		this.idvcertificacion = idvcertificacion;
	}

	 public Vcertificacion getVcertificacionIdvcertificacion() {
		return vcertificacionIdvcertificacion;
	}

	public void setVcertificacionIdvcertificacion(Vcertificacion vcertificacionIdvcertificacion) {
		this.vcertificacionIdvcertificacion = vcertificacionIdvcertificacion;
	}

	 public java.lang.String getEstadoauditoria() {
		return estadoauditoria;
	}

	public void setEstadoauditoria(java.lang.String estadoauditoria) {
		this.estadoauditoria = estadoauditoria;
	}

}
