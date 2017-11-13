
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[CertificadoPresupuestal]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Certificadopresupuestal extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[IdCertificadoPresupuestal]*/
	private java.lang.Integer idcertificadopresupuestal;
	
	
	/**[IdPacConsolidado]*/
	private java.lang.Integer idpacconsolidado;
	private Pacconsolidado pacconsolidadoIdpacconsolidado;
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
	/**[FechaCertificado]*/
	private java.util.Date fechacertifica;
	private java.util.Date fechacertificaini;
	private java.util.Date fechacertificafin;
	/**[FechaAprobacion]*/
	private java.util.Date fechaaprobacion;
	private java.util.Date fechaaprobacionini;
	private java.util.Date fechaaprobacionfin;
	/**[MontoNacional]*/
	private java.math.BigDecimal montonacional;
	private java.math.BigDecimal montonacionalini;
	private java.math.BigDecimal montonacionalfin;
	/**[MesProceso]*/
	private java.lang.String mesproceso;
	/**[EstadoCertifica]*/
	private java.lang.String estadocertifica;
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
	private List<Detallecertificadopresupuestal> listaDetallecertificadopresupuestal;

	public Certificadopresupuestal() {}

	public Certificadopresupuestal(java.lang.Integer idcertificadopresupuestal) {
		this.idcertificadopresupuestal=idcertificadopresupuestal;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Certificadopresupuestal)
			return ((Certificadopresupuestal)obj).getIdcertificadopresupuestal().equals(this.getIdcertificadopresupuestal()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idcertificadopresupuestal!=null)?("idcertificadopresupuestal:\t" + this.idcertificadopresupuestal+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.nrocertifica!=null)?("nrocertifica:\t" + this.nrocertifica+"\n"):"" ).concat(
			(this.fechacertifica!=null)?("fechacertifica:\t" + this.fechacertifica+"\n"):"" ).concat(
			(this.fechaaprobacion!=null)?("fechaaprobacion:\t" + this.fechaaprobacion+"\n"):"" ).concat(
			(this.montonacional!=null)?("montonacional:\t" + this.montonacional+"\n"):"" ).concat(
			(this.mesproceso!=null)?("mesproceso:\t" + this.mesproceso+"\n"):"" ).concat(
			(this.estadocertifica!=null)?("estadocertifica:\t" + this.estadocertifica+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idcertificadopresupuestal!=null)?("idcertificadopresupuestal:\t" + this.idcertificadopresupuestal+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.pacconsolidadoIdpacconsolidado!=null)?("pacconsolidadoIdpacconsolidado:\t" + this.pacconsolidadoIdpacconsolidado.toString()+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.nrocertifica!=null)?("nrocertifica:\t" + this.nrocertifica+"\n"):"" ).concat(
			(this.fechacertifica!=null)?("fechacertifica:\t" + this.fechacertifica+"\n"):"" ).concat(
			(this.fechaaprobacion!=null)?("fechaaprobacion:\t" + this.fechaaprobacion+"\n"):"" ).concat(
			(this.montonacional!=null)?("montonacional:\t" + this.montonacional+"\n"):"" ).concat(
			(this.mesproceso!=null)?("mesproceso:\t" + this.mesproceso+"\n"):"" ).concat(
			(this.estadocertifica!=null)?("estadocertifica:\t" + this.estadocertifica+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIdpacconsolidadoInKeys;
	public void addConditionInIdpacconsolidado(List<String> list){
		if(list==null || list.size()==0){
			idpacconsolidado=null;
			listaIdpacconsolidadoInKeys=null;
			return;
		}
		if(list.size()==1){
			idpacconsolidado=Integer.parseInt(list.get(0));
			listaIdpacconsolidadoInKeys=null;
		}else{
			idpacconsolidado=null;
			listaIdpacconsolidadoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdpacconsolidadoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdpacconsolidadoInKeys() {
		return listaIdpacconsolidadoInKeys;
	}


	 public java.lang.Integer getIdcertificadopresupuestal() {
		return idcertificadopresupuestal;
	}

	public void setIdcertificadopresupuestal(java.lang.Integer idcertificadopresupuestal) {
		this.idcertificadopresupuestal = idcertificadopresupuestal;
	}

	 public java.lang.Integer getIdpacconsolidado() {
		return idpacconsolidado;
	}

	public void setIdpacconsolidado(java.lang.Integer idpacconsolidado) {
		this.idpacconsolidado = idpacconsolidado;
	}

	 public Pacconsolidado getPacconsolidadoIdpacconsolidado() {
		return pacconsolidadoIdpacconsolidado;
	}

	public void setPacconsolidadoIdpacconsolidado(Pacconsolidado pacconsolidadoIdpacconsolidado) {
		this.pacconsolidadoIdpacconsolidado = pacconsolidadoIdpacconsolidado;
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

	 public java.util.Date getFechacertifica() {
		return fechacertifica;
	}

	public void setFechacertifica(java.util.Date fechacertifica) {
		this.fechacertifica = fechacertifica;
	}

	 public java.util.Date getFechacertificaini() {
		return fechacertificaini;
	}

	public void setFechacertificaini(java.util.Date fechacertificaini) {
		this.fechacertificaini = fechacertificaini;
	}

	 public java.util.Date getFechacertificafin() {
		return fechacertificafin;
	}

	public void setFechacertificafin(java.util.Date fechacertificafin) {
		this.fechacertificafin = fechacertificafin;
	}

	 public java.util.Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(java.util.Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}

	 public java.util.Date getFechaaprobacionini() {
		return fechaaprobacionini;
	}

	public void setFechaaprobacionini(java.util.Date fechaaprobacionini) {
		this.fechaaprobacionini = fechaaprobacionini;
	}

	 public java.util.Date getFechaaprobacionfin() {
		return fechaaprobacionfin;
	}

	public void setFechaaprobacionfin(java.util.Date fechaaprobacionfin) {
		this.fechaaprobacionfin = fechaaprobacionfin;
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

	 public java.lang.String getEstadocertifica() {
		return estadocertifica;
	}

	public void setEstadocertifica(java.lang.String estadocertifica) {
		this.estadocertifica = estadocertifica;
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

	 public List<Detallecertificadopresupuestal> getListaDetallecertificadopresupuestal() {
		return listaDetallecertificadopresupuestal;
	}

	public void setListaDetallecertificadopresupuestal(List<Detallecertificadopresupuestal> listaDetallecertificadopresupuestal) {
		this.listaDetallecertificadopresupuestal = listaDetallecertificadopresupuestal;
	}

}
