
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[VPedidoSiga]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Vispedido extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[IdPedidoSiga]*/
	private java.lang.Integer idvpedido;
	/**[CodigoUnidadEjecutora]*/
	private java.lang.String codigounidadejecutora;
	/**[Anio]*/
	private java.math.BigDecimal anio;
	private java.math.BigDecimal anioini;
	private java.math.BigDecimal aniofin;
	/**[SecEjec]*/
	private java.math.BigDecimal secejec;
	private java.math.BigDecimal secejecini;
	private java.math.BigDecimal secejecfin;
	/**[TipoBien]*/
	private java.lang.String tipobien;
	/**[TipoPedido][boolean]*/
	private java.lang.String tipopedido;
	private Boolean booleantipopedido;
	/**[NroPedido]*/
	private java.lang.String nropedido;
	/**[CodigoCentroCosto]*/
	private java.lang.String codigocentrocosto;
	/**[NombreDependencia]*/
	private java.lang.String nombredependencia;
	/**[FechaPedido]*/
	private java.util.Date fechapedido;
	private java.util.Date fechapedidoini;
	private java.util.Date fechapedidofin;
	/**[FechaAprobacion]*/
	private java.util.Date fechaaprobacion;
	private java.util.Date fechaaprobacionini;
	private java.util.Date fechaaprobacionfin;
	/**[MotivoPedido]*/
	private java.lang.String motivopedido;
	/**[SecFunc]*/
	private java.math.BigDecimal secfunc;
	private java.math.BigDecimal secfuncini;
	private java.math.BigDecimal secfuncfin;
	/**[TipoTarea][boolean]*/
	private java.lang.String tipotarea;
	private Boolean booleantipotarea;
	/**[NivelTarea][boolean]*/
	private java.lang.String niveltarea;
	private Boolean booleanniveltarea;
	/**[CodigoTarea]*/
	private java.math.BigDecimal codigotarea;
	private java.math.BigDecimal codigotareaini;
	private java.math.BigDecimal codigotareafin;
	/**[MesPedido]*/
	private java.lang.String mespedido;
	/**[Estado][boolean]*/
	private java.lang.String estado;
	private Boolean booleanestado;
	/**[*][UsuarioCreacionAuditoria]*/
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

	public Vispedido() {}

	public Vispedido(java.lang.Integer idvpedido) {
		this.idvpedido=idvpedido;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Vispedido)
			return ((Vispedido)obj).getIdvpedido().equals(this.getIdvpedido()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idvpedido!=null)?("idvpedido:\t" + this.idvpedido+"\n"):"" ).concat(
			(this.codigounidadejecutora!=null)?("codigounidadejecutora:\t" + this.codigounidadejecutora+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.tipobien!=null)?("tipobien:\t" + this.tipobien+"\n"):"" ).concat(
			(this.tipopedido!=null)?("tipopedido:\t" + this.tipopedido+"\n"):"" ).concat(
			(this.nropedido!=null)?("nropedido:\t" + this.nropedido+"\n"):"" ).concat(
			(this.codigocentrocosto!=null)?("codigocentrocosto:\t" + this.codigocentrocosto+"\n"):"" ).concat(
			(this.nombredependencia!=null)?("nombredependencia:\t" + this.nombredependencia+"\n"):"" ).concat(
			(this.fechapedido!=null)?("fechapedido:\t" + this.fechapedido+"\n"):"" ).concat(
			(this.fechaaprobacion!=null)?("fechaaprobacion:\t" + this.fechaaprobacion+"\n"):"" ).concat(
			(this.motivopedido!=null)?("motivopedido:\t" + this.motivopedido+"\n"):"" ).concat(
			(this.secfunc!=null)?("secfunc:\t" + this.secfunc+"\n"):"" ).concat(
			(this.tipotarea!=null)?("tipotarea:\t" + this.tipotarea+"\n"):"" ).concat(
			(this.niveltarea!=null)?("niveltarea:\t" + this.niveltarea+"\n"):"" ).concat(
			(this.codigotarea!=null)?("codigotarea:\t" + this.codigotarea+"\n"):"" ).concat(
			(this.mespedido!=null)?("mespedido:\t" + this.mespedido+"\n"):"" ).concat(
			(this.estado!=null)?("estado:\t" + this.estado+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idvpedido!=null)?("idvpedido:\t" + this.idvpedido+"\n"):"" ).concat(
			(this.codigounidadejecutora!=null)?("codigounidadejecutora:\t" + this.codigounidadejecutora+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.tipobien!=null)?("tipobien:\t" + this.tipobien+"\n"):"" ).concat(
			(this.tipopedido!=null)?("tipopedido:\t" + this.tipopedido+"\n"):"" ).concat(
			(this.nropedido!=null)?("nropedido:\t" + this.nropedido+"\n"):"" ).concat(
			(this.codigocentrocosto!=null)?("codigocentrocosto:\t" + this.codigocentrocosto+"\n"):"" ).concat(
			(this.nombredependencia!=null)?("nombredependencia:\t" + this.nombredependencia+"\n"):"" ).concat(
			(this.fechapedido!=null)?("fechapedido:\t" + this.fechapedido+"\n"):"" ).concat(
			(this.fechaaprobacion!=null)?("fechaaprobacion:\t" + this.fechaaprobacion+"\n"):"" ).concat(
			(this.motivopedido!=null)?("motivopedido:\t" + this.motivopedido+"\n"):"" ).concat(
			(this.secfunc!=null)?("secfunc:\t" + this.secfunc+"\n"):"" ).concat(
			(this.tipotarea!=null)?("tipotarea:\t" + this.tipotarea+"\n"):"" ).concat(
			(this.niveltarea!=null)?("niveltarea:\t" + this.niveltarea+"\n"):"" ).concat(
			(this.codigotarea!=null)?("codigotarea:\t" + this.codigotarea+"\n"):"" ).concat(
			(this.mespedido!=null)?("mespedido:\t" + this.mespedido+"\n"):"" ).concat(
			(this.estado!=null)?("estado:\t" + this.estado+"\n"):"" ).concat(
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
		if(this.secfunc!=null)
			secfunc=Utils.round(secfunc);
		if(this.codigotarea!=null)
			codigotarea=Utils.round(codigotarea);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }


	 public java.lang.Integer getIdvpedido() {
		return idvpedido;
	}

	public void setIdvpedido(java.lang.Integer idvpedido) {
		this.idvpedido = idvpedido;
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

	 public java.lang.String getTipobien() {
		return tipobien;
	}

	public void setTipobien(java.lang.String tipobien) {
		this.tipobien = tipobien;
	}

	 public java.lang.String getTipopedido() {
		return tipopedido;
	}

	public void setTipopedido(java.lang.String tipopedido) {
		this.tipopedido = tipopedido;
	}

	 public Boolean getBooleantipopedido() {
		return booleantipopedido;
	}

	public void setBooleantipopedido(Boolean booleantipopedido) {
		this.booleantipopedido = booleantipopedido;
	}

	 public java.lang.String getNropedido() {
		return nropedido;
	}

	public void setNropedido(java.lang.String nropedido) {
		this.nropedido = nropedido;
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

	 public java.util.Date getFechapedido() {
		return fechapedido;
	}

	public void setFechapedido(java.util.Date fechapedido) {
		this.fechapedido = fechapedido;
	}

	 public java.util.Date getFechapedidoini() {
		return fechapedidoini;
	}

	public void setFechapedidoini(java.util.Date fechapedidoini) {
		this.fechapedidoini = fechapedidoini;
	}

	 public java.util.Date getFechapedidofin() {
		return fechapedidofin;
	}

	public void setFechapedidofin(java.util.Date fechapedidofin) {
		this.fechapedidofin = fechapedidofin;
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

	 public java.lang.String getMotivopedido() {
		return motivopedido;
	}

	public void setMotivopedido(java.lang.String motivopedido) {
		this.motivopedido = motivopedido;
	}

	 public java.math.BigDecimal getSecfunc() {
		return secfunc;
	}

	public void setSecfunc(java.math.BigDecimal secfunc) {
		this.secfunc = secfunc;
	}

	 public java.math.BigDecimal getSecfuncini() {
		return secfuncini;
	}

	public void setSecfuncini(java.math.BigDecimal secfuncini) {
		this.secfuncini = secfuncini;
	}

	 public java.math.BigDecimal getSecfuncfin() {
		return secfuncfin;
	}

	public void setSecfuncfin(java.math.BigDecimal secfuncfin) {
		this.secfuncfin = secfuncfin;
	}

	 public java.lang.String getTipotarea() {
		return tipotarea;
	}

	public void setTipotarea(java.lang.String tipotarea) {
		this.tipotarea = tipotarea;
	}

	 public Boolean getBooleantipotarea() {
		return booleantipotarea;
	}

	public void setBooleantipotarea(Boolean booleantipotarea) {
		this.booleantipotarea = booleantipotarea;
	}

	 public java.lang.String getNiveltarea() {
		return niveltarea;
	}

	public void setNiveltarea(java.lang.String niveltarea) {
		this.niveltarea = niveltarea;
	}

	 public Boolean getBooleanniveltarea() {
		return booleanniveltarea;
	}

	public void setBooleanniveltarea(Boolean booleanniveltarea) {
		this.booleanniveltarea = booleanniveltarea;
	}

	 public java.math.BigDecimal getCodigotarea() {
		return codigotarea;
	}

	public void setCodigotarea(java.math.BigDecimal codigotarea) {
		this.codigotarea = codigotarea;
	}

	 public java.math.BigDecimal getCodigotareaini() {
		return codigotareaini;
	}

	public void setCodigotareaini(java.math.BigDecimal codigotareaini) {
		this.codigotareaini = codigotareaini;
	}

	 public java.math.BigDecimal getCodigotareafin() {
		return codigotareafin;
	}

	public void setCodigotareafin(java.math.BigDecimal codigotareafin) {
		this.codigotareafin = codigotareafin;
	}

	 public java.lang.String getMespedido() {
		return mespedido;
	}

	public void setMespedido(java.lang.String mespedido) {
		this.mespedido = mespedido;
	}

	 public java.lang.String getEstado() {
		return estado;
	}

	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	 public Boolean getBooleanestado() {
		return booleanestado;
	}

	public void setBooleanestado(Boolean booleanestado) {
		this.booleanestado = booleanestado;
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
