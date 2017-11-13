
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[DetalleCertificadoPresupuestal]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Detallecertificadopresupuestal extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[IdDetalleCertificadoPresupuestal]*/
	private java.lang.Integer iddetallecertificadopresupuestal;
	/**[IdCertificadoPresupuestal]*/
	private java.lang.Integer idcertificadopresupuestal;
	private Certificadopresupuestal certificadopresupuestalIdcertificadopresupuestal;
	/**[Anio]*/
	private java.math.BigDecimal anio;
	private java.math.BigDecimal anioini;
	private java.math.BigDecimal aniofin;
	/**[SecEjec]*/
	private java.math.BigDecimal secejec;
	private java.math.BigDecimal secejecini;
	private java.math.BigDecimal secejecfin;
	/**[NroCertifica]*/
	private java.math.BigDecimal nrocertifica;
	private java.math.BigDecimal nrocertificaini;
	private java.math.BigDecimal nrocertificafin;
	/**[FuenteFinancimiento]*/
	private java.lang.String fuentefinancimiento;
	/**[Secuencia]*/
	private java.lang.String secuencia;
	/**[Clasificador]*/
	private java.lang.String clasificador;
	/**[CodigoCentroCosto]*/
	private java.lang.String codigocentrocosto;
	/**[MontoNacional]*/
	private java.math.BigDecimal montonacional;
	private java.math.BigDecimal montonacionalini;
	private java.math.BigDecimal montonacionalfin;
	/**[*][FechaCreacionAuditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][UsuarioCreacionAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][FechaModificacionAuditoria]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][UsuarioModificacionAuditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][EquipoAuditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Detallecertificadopresupuestal() {}

	public Detallecertificadopresupuestal(java.lang.Integer iddetallecertificadopresupuestal) {
		this.iddetallecertificadopresupuestal=iddetallecertificadopresupuestal;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Detallecertificadopresupuestal)
			return ((Detallecertificadopresupuestal)obj).getIddetallecertificadopresupuestal().equals(this.getIddetallecertificadopresupuestal()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.iddetallecertificadopresupuestal!=null)?("iddetallecertificadopresupuestal:\t" + this.iddetallecertificadopresupuestal+"\n"):"" ).concat(
			(this.idcertificadopresupuestal!=null)?("idcertificadopresupuestal:\t" + this.idcertificadopresupuestal+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.nrocertifica!=null)?("nrocertifica:\t" + this.nrocertifica+"\n"):"" ).concat(
			(this.fuentefinancimiento!=null)?("fuentefinancimiento:\t" + this.fuentefinancimiento+"\n"):"" ).concat(
			(this.secuencia!=null)?("secuencia:\t" + this.secuencia+"\n"):"" ).concat(
			(this.clasificador!=null)?("clasificador:\t" + this.clasificador+"\n"):"" ).concat(
			(this.codigocentrocosto!=null)?("codigocentrocosto:\t" + this.codigocentrocosto+"\n"):"" ).concat(
			(this.montonacional!=null)?("montonacional:\t" + this.montonacional+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.iddetallecertificadopresupuestal!=null)?("iddetallecertificadopresupuestal:\t" + this.iddetallecertificadopresupuestal+"\n"):"" ).concat(
			(this.idcertificadopresupuestal!=null)?("idcertificadopresupuestal:\t" + this.idcertificadopresupuestal+"\n"):"" ).concat(
			(this.certificadopresupuestalIdcertificadopresupuestal!=null)?("certificadopresupuestalIdcertificadopresupuestal:\t" + this.certificadopresupuestalIdcertificadopresupuestal.toString()+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.nrocertifica!=null)?("nrocertifica:\t" + this.nrocertifica+"\n"):"" ).concat(
			(this.fuentefinancimiento!=null)?("fuentefinancimiento:\t" + this.fuentefinancimiento+"\n"):"" ).concat(
			(this.secuencia!=null)?("secuencia:\t" + this.secuencia+"\n"):"" ).concat(
			(this.clasificador!=null)?("clasificador:\t" + this.clasificador+"\n"):"" ).concat(
			(this.codigocentrocosto!=null)?("codigocentrocosto:\t" + this.codigocentrocosto+"\n"):"" ).concat(
			(this.montonacional!=null)?("montonacional:\t" + this.montonacional+"\n"):"" ).concat(
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
		if(this.anio!=null)
			anio=Utils.round(anio);
		if(this.secejec!=null)
			secejec=Utils.round(secejec);
		if(this.nrocertifica!=null)
			nrocertifica=Utils.round(nrocertifica);
		if(this.montonacional!=null)
			montonacional=Utils.round(montonacional);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.Integer> listaIdcertificadopresupuestalInKeys;
	public void addConditionInIdcertificadopresupuestal(List<String> list){
		if(list==null || list.size()==0){
			idcertificadopresupuestal=null;
			listaIdcertificadopresupuestalInKeys=null;
			return;
		}
		if(list.size()==1){
			idcertificadopresupuestal=Integer.parseInt(list.get(0));
			listaIdcertificadopresupuestalInKeys=null;
		}else{
			idcertificadopresupuestal=null;
			listaIdcertificadopresupuestalInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdcertificadopresupuestalInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdcertificadopresupuestalInKeys() {
		return listaIdcertificadopresupuestalInKeys;
	}


	 public java.lang.Integer getIddetallecertificadopresupuestal() {
		return iddetallecertificadopresupuestal;
	}

	public void setIddetallecertificadopresupuestal(java.lang.Integer iddetallecertificadopresupuestal) {
		this.iddetallecertificadopresupuestal = iddetallecertificadopresupuestal;
	}

	 public java.lang.Integer getIdcertificadopresupuestal() {
		return idcertificadopresupuestal;
	}

	public void setIdcertificadopresupuestal(java.lang.Integer idcertificadopresupuestal) {
		this.idcertificadopresupuestal = idcertificadopresupuestal;
	}

	 public Certificadopresupuestal getCertificadopresupuestalIdcertificadopresupuestal() {
		return certificadopresupuestalIdcertificadopresupuestal;
	}

	public void setCertificadopresupuestalIdcertificadopresupuestal(Certificadopresupuestal certificadopresupuestalIdcertificadopresupuestal) {
		this.certificadopresupuestalIdcertificadopresupuestal = certificadopresupuestalIdcertificadopresupuestal;
	}

	 public java.math.BigDecimal getAnio() {
		return anio;
	}

	public void setAnio(java.math.BigDecimal anio) {
		this.anio = anio;
	}

	 public java.math.BigDecimal getAnioini() {
		return anioini;
	}

	public void setAnioini(java.math.BigDecimal anioini) {
		this.anioini = anioini;
	}

	 public java.math.BigDecimal getAniofin() {
		return aniofin;
	}

	public void setAniofin(java.math.BigDecimal aniofin) {
		this.aniofin = aniofin;
	}

	 public java.math.BigDecimal getSecejec() {
		return secejec;
	}

	public void setSecejec(java.math.BigDecimal secejec) {
		this.secejec = secejec;
	}

	 public java.math.BigDecimal getSecejecini() {
		return secejecini;
	}

	public void setSecejecini(java.math.BigDecimal secejecini) {
		this.secejecini = secejecini;
	}

	 public java.math.BigDecimal getSecejecfin() {
		return secejecfin;
	}

	public void setSecejecfin(java.math.BigDecimal secejecfin) {
		this.secejecfin = secejecfin;
	}

	 public java.math.BigDecimal getNrocertifica() {
		return nrocertifica;
	}

	public void setNrocertifica(java.math.BigDecimal nrocertifica) {
		this.nrocertifica = nrocertifica;
	}

	 public java.math.BigDecimal getNrocertificaini() {
		return nrocertificaini;
	}

	public void setNrocertificaini(java.math.BigDecimal nrocertificaini) {
		this.nrocertificaini = nrocertificaini;
	}

	 public java.math.BigDecimal getNrocertificafin() {
		return nrocertificafin;
	}

	public void setNrocertificafin(java.math.BigDecimal nrocertificafin) {
		this.nrocertificafin = nrocertificafin;
	}

	 public java.lang.String getFuentefinancimiento() {
		return fuentefinancimiento;
	}

	public void setFuentefinancimiento(java.lang.String fuentefinancimiento) {
		this.fuentefinancimiento = fuentefinancimiento;
	}

	 public java.lang.String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(java.lang.String secuencia) {
		this.secuencia = secuencia;
	}

	 public java.lang.String getClasificador() {
		return clasificador;
	}

	public void setClasificador(java.lang.String clasificador) {
		this.clasificador = clasificador;
	}

	 public java.lang.String getCodigocentrocosto() {
		return codigocentrocosto;
	}

	public void setCodigocentrocosto(java.lang.String codigocentrocosto) {
		this.codigocentrocosto = codigocentrocosto;
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
