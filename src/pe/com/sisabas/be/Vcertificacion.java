
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[VCertificacion]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Vcertificacion extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer vcertificacion;
	/**[Código Unidad Ejecutora]*/
	private java.lang.String codigounidadejecutora;
	/**[Anio]*/
	private java.math.BigDecimal anio;
	private java.math.BigDecimal anioini;
	private java.math.BigDecimal aniofin;
	/**[Sec Ejec]*/
	private java.math.BigDecimal secejec;
	private java.math.BigDecimal secejecini;
	private java.math.BigDecimal secejecfin;
	/**[Número Certificado]*/
	private java.math.BigDecimal nrocertifica;
	private java.math.BigDecimal nrocertificaini;
	private java.math.BigDecimal nrocertificafin;
	/**[Caso]*/
	private java.lang.String caso;
	/**[Fecha Registro]*/
	private java.util.Date fechareg;
	private java.util.Date fecharegini;
	private java.util.Date fecharegfin;
	/**[*][Fecha de Creación de Auditoria]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][UsuarioCreaciónAuditoria]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha de Modificación]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario de modificación de Auditoria]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][Equipo Auditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa Auditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Vcertificacion() {}

	public Vcertificacion(java.lang.Integer vcertificacion) {
		this.vcertificacion=vcertificacion;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Vcertificacion)
			return ((Vcertificacion)obj).getVcertificacion().equals(this.getVcertificacion()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.vcertificacion!=null)?("vcertificacion:\t" + this.vcertificacion+"\n"):"" ).concat(
			(this.codigounidadejecutora!=null)?("codigounidadejecutora:\t" + this.codigounidadejecutora+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.nrocertifica!=null)?("nrocertifica:\t" + this.nrocertifica+"\n"):"" ).concat(
			(this.caso!=null)?("caso:\t" + this.caso+"\n"):"" ).concat(
			(this.fechareg!=null)?("fechareg:\t" + this.fechareg+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.vcertificacion!=null)?("vcertificacion:\t" + this.vcertificacion+"\n"):"" ).concat(
			(this.codigounidadejecutora!=null)?("codigounidadejecutora:\t" + this.codigounidadejecutora+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.nrocertifica!=null)?("nrocertifica:\t" + this.nrocertifica+"\n"):"" ).concat(
			(this.caso!=null)?("caso:\t" + this.caso+"\n"):"" ).concat(
			(this.fechareg!=null)?("fechareg:\t" + this.fechareg+"\n"):"" ).concat(
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

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }


	 public java.lang.Integer getVcertificacion() {
		return vcertificacion;
	}

	public void setVcertificacion(java.lang.Integer vcertificacion) {
		this.vcertificacion = vcertificacion;
	}

	 public java.lang.String getCodigounidadejecutora() {
		return codigounidadejecutora;
	}

	public void setCodigounidadejecutora(java.lang.String codigounidadejecutora) {
		this.codigounidadejecutora = codigounidadejecutora;
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

	 public java.lang.String getCaso() {
		return caso;
	}

	public void setCaso(java.lang.String caso) {
		this.caso = caso;
	}

	 public java.util.Date getFechareg() {
		return fechareg;
	}

	public void setFechareg(java.util.Date fechareg) {
		this.fechareg = fechareg;
	}

	 public java.util.Date getFecharegini() {
		return fecharegini;
	}

	public void setFecharegini(java.util.Date fecharegini) {
		this.fecharegini = fecharegini;
	}

	 public java.util.Date getFecharegfin() {
		return fecharegfin;
	}

	public void setFecharegfin(java.util.Date fecharegfin) {
		this.fecharegfin = fecharegfin;
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
