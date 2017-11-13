
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[visSigaPaacConsolidado]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Vissigapaacconsolidado extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[visIdSigaPaacConsolidado]*/
	private java.lang.Integer visidsigapaacconsolidado;
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
	/**[TipoConsolid]*/
	private java.lang.String tipoconsolid;
	/**[NroConsolid]*/
	private java.math.BigDecimal nroconsolid;
	private java.math.BigDecimal nroconsolidini;
	private java.math.BigDecimal nroconsolidfin;
	/**[EstadoPaac]*/
	private java.lang.String estadopaac;
	/**[NroCertifica]*/
	private java.math.BigDecimal nrocertifica;
	private java.math.BigDecimal nrocertificaini;
	private java.math.BigDecimal nrocertificafin;
	/**[ModalCompra]*/
	private java.lang.String modalcompra;
	/**[FechaCons]*/
	private java.util.Date fechacons;
	private java.util.Date fechaconsini;
	private java.util.Date fechaconsfin;
	/**[NroPaac]*/
	private java.lang.String nropaac;
	/**[MesInicial]*/
	private java.lang.String mesinicial;
	/**[MesFinal]*/
	private java.lang.String mesfinal;
	/**[MesPropuesto]*/
	private java.lang.String mespropuesto;
	/**[TipoBien]*/
	private java.lang.String tipobien;
	/**[FlagPaac]*/
	private java.lang.String flagpaac;
	/**[TipoProceso]*/
	private java.lang.String tipoproceso;
	/**[DescripcionTipoProceso]*/
	private java.lang.String descripciontipoproceso;
	/**[Objeto]*/
	private java.lang.String objeto;
	/**[EspecificacionTecnicas]*/
	private java.lang.String especificaciontecnicas;
	/**[ValorMoneda]*/
	private java.math.BigDecimal valormoneda;
	private java.math.BigDecimal valormonedaini;
	private java.math.BigDecimal valormonedafin;
	/**[ValorPlan]*/
	private java.math.BigDecimal valorplan;
	private java.math.BigDecimal valorplanini;
	private java.math.BigDecimal valorplanfin;
	/**[Pais]*/
	private java.lang.String pais;
	/**[Departamento]*/
	private java.lang.String departamento;
	/**[Provincia]*/
	private java.lang.String provincia;
	/**[Distrito]*/
	private java.lang.String distrito;
	/**[ExpSiga]*/
	private java.math.BigDecimal expsiga;
	private java.math.BigDecimal expsigaini;
	private java.math.BigDecimal expsigafin;
	/**[ExpSiaf]*/
	private java.math.BigDecimal expsiaf;
	private java.math.BigDecimal expsiafini;
	private java.math.BigDecimal expsiaffin;
	/**[ExpSiafTipoEjec]*/
	private java.lang.String expsiaftipoejec;
	/**[FechaTipoEjec]*/
	private java.util.Date fechatipoejec;
	private java.util.Date fechatipoejecini;
	private java.util.Date fechatipoejecfin;
	/**[ModalidadCsc]*/
	private java.lang.String modalidadcsc;
	/**[CodSnip]*/
	private java.lang.String codsnip;
	/**[DocViaSnip]*/
	private java.lang.String docviasnip;
	/**[FechaReg]*/
	private java.util.Date fechareg;
	private java.util.Date fecharegini;
	private java.util.Date fecharegfin;
	/**[FechaMod]*/
	private java.util.Date fechamod;
	private java.util.Date fechamodini;
	private java.util.Date fechamodfin;
	/**[TipoContratacion]*/
	private java.lang.String tipocontratacion;
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

	public Vissigapaacconsolidado() {}

	public Vissigapaacconsolidado(java.lang.Integer visidsigapaacconsolidado) {
		this.visidsigapaacconsolidado=visidsigapaacconsolidado;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Vissigapaacconsolidado)
			return ((Vissigapaacconsolidado)obj).getVisidsigapaacconsolidado().equals(this.getVisidsigapaacconsolidado()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.visidsigapaacconsolidado!=null)?("visidsigapaacconsolidado:\t" + this.visidsigapaacconsolidado+"\n"):"" ).concat(
			(this.codigounidadejecutora!=null)?("codigounidadejecutora:\t" + this.codigounidadejecutora+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.tipoconsolid!=null)?("tipoconsolid:\t" + this.tipoconsolid+"\n"):"" ).concat(
			(this.nroconsolid!=null)?("nroconsolid:\t" + this.nroconsolid+"\n"):"" ).concat(
			(this.estadopaac!=null)?("estadopaac:\t" + this.estadopaac+"\n"):"" ).concat(
			(this.nrocertifica!=null)?("nrocertifica:\t" + this.nrocertifica+"\n"):"" ).concat(
			(this.modalcompra!=null)?("modalcompra:\t" + this.modalcompra+"\n"):"" ).concat(
			(this.fechacons!=null)?("fechacons:\t" + this.fechacons+"\n"):"" ).concat(
			(this.nropaac!=null)?("nropaac:\t" + this.nropaac+"\n"):"" ).concat(
			(this.mesinicial!=null)?("mesinicial:\t" + this.mesinicial+"\n"):"" ).concat(
			(this.mesfinal!=null)?("mesfinal:\t" + this.mesfinal+"\n"):"" ).concat(
			(this.mespropuesto!=null)?("mespropuesto:\t" + this.mespropuesto+"\n"):"" ).concat(
			(this.tipobien!=null)?("tipobien:\t" + this.tipobien+"\n"):"" ).concat(
			(this.flagpaac!=null)?("flagpaac:\t" + this.flagpaac+"\n"):"" ).concat(
			(this.tipoproceso!=null)?("tipoproceso:\t" + this.tipoproceso+"\n"):"" ).concat(
			(this.descripciontipoproceso!=null)?("descripciontipoproceso:\t" + this.descripciontipoproceso+"\n"):"" ).concat(
			(this.objeto!=null)?("objeto:\t" + this.objeto+"\n"):"" ).concat(
			(this.especificaciontecnicas!=null)?("especificaciontecnicas:\t" + this.especificaciontecnicas+"\n"):"" ).concat(
			(this.valormoneda!=null)?("valormoneda:\t" + this.valormoneda+"\n"):"" ).concat(
			(this.valorplan!=null)?("valorplan:\t" + this.valorplan+"\n"):"" ).concat(
			(this.pais!=null)?("pais:\t" + this.pais+"\n"):"" ).concat(
			(this.departamento!=null)?("departamento:\t" + this.departamento+"\n"):"" ).concat(
			(this.provincia!=null)?("provincia:\t" + this.provincia+"\n"):"" ).concat(
			(this.distrito!=null)?("distrito:\t" + this.distrito+"\n"):"" ).concat(
			(this.expsiga!=null)?("expsiga:\t" + this.expsiga+"\n"):"" ).concat(
			(this.expsiaf!=null)?("expsiaf:\t" + this.expsiaf+"\n"):"" ).concat(
			(this.expsiaftipoejec!=null)?("expsiaftipoejec:\t" + this.expsiaftipoejec+"\n"):"" ).concat(
			(this.fechatipoejec!=null)?("fechatipoejec:\t" + this.fechatipoejec+"\n"):"" ).concat(
			(this.modalidadcsc!=null)?("modalidadcsc:\t" + this.modalidadcsc+"\n"):"" ).concat(
			(this.codsnip!=null)?("codsnip:\t" + this.codsnip+"\n"):"" ).concat(
			(this.docviasnip!=null)?("docviasnip:\t" + this.docviasnip+"\n"):"" ).concat(
			(this.fechareg!=null)?("fechareg:\t" + this.fechareg+"\n"):"" ).concat(
			(this.fechamod!=null)?("fechamod:\t" + this.fechamod+"\n"):"" ).concat(
			(this.tipocontratacion!=null)?("tipocontratacion:\t" + this.tipocontratacion+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.visidsigapaacconsolidado!=null)?("visidsigapaacconsolidado:\t" + this.visidsigapaacconsolidado+"\n"):"" ).concat(
			(this.codigounidadejecutora!=null)?("codigounidadejecutora:\t" + this.codigounidadejecutora+"\n"):"" ).concat(
			(this.anio!=null)?("anio:\t" + this.anio+"\n"):"" ).concat(
			(this.secejec!=null)?("secejec:\t" + this.secejec+"\n"):"" ).concat(
			(this.tipoconsolid!=null)?("tipoconsolid:\t" + this.tipoconsolid+"\n"):"" ).concat(
			(this.nroconsolid!=null)?("nroconsolid:\t" + this.nroconsolid+"\n"):"" ).concat(
			(this.estadopaac!=null)?("estadopaac:\t" + this.estadopaac+"\n"):"" ).concat(
			(this.nrocertifica!=null)?("nrocertifica:\t" + this.nrocertifica+"\n"):"" ).concat(
			(this.modalcompra!=null)?("modalcompra:\t" + this.modalcompra+"\n"):"" ).concat(
			(this.fechacons!=null)?("fechacons:\t" + this.fechacons+"\n"):"" ).concat(
			(this.nropaac!=null)?("nropaac:\t" + this.nropaac+"\n"):"" ).concat(
			(this.mesinicial!=null)?("mesinicial:\t" + this.mesinicial+"\n"):"" ).concat(
			(this.mesfinal!=null)?("mesfinal:\t" + this.mesfinal+"\n"):"" ).concat(
			(this.mespropuesto!=null)?("mespropuesto:\t" + this.mespropuesto+"\n"):"" ).concat(
			(this.tipobien!=null)?("tipobien:\t" + this.tipobien+"\n"):"" ).concat(
			(this.flagpaac!=null)?("flagpaac:\t" + this.flagpaac+"\n"):"" ).concat(
			(this.tipoproceso!=null)?("tipoproceso:\t" + this.tipoproceso+"\n"):"" ).concat(
			(this.descripciontipoproceso!=null)?("descripciontipoproceso:\t" + this.descripciontipoproceso+"\n"):"" ).concat(
			(this.objeto!=null)?("objeto:\t" + this.objeto+"\n"):"" ).concat(
			(this.especificaciontecnicas!=null)?("especificaciontecnicas:\t" + this.especificaciontecnicas+"\n"):"" ).concat(
			(this.valormoneda!=null)?("valormoneda:\t" + this.valormoneda+"\n"):"" ).concat(
			(this.valorplan!=null)?("valorplan:\t" + this.valorplan+"\n"):"" ).concat(
			(this.pais!=null)?("pais:\t" + this.pais+"\n"):"" ).concat(
			(this.departamento!=null)?("departamento:\t" + this.departamento+"\n"):"" ).concat(
			(this.provincia!=null)?("provincia:\t" + this.provincia+"\n"):"" ).concat(
			(this.distrito!=null)?("distrito:\t" + this.distrito+"\n"):"" ).concat(
			(this.expsiga!=null)?("expsiga:\t" + this.expsiga+"\n"):"" ).concat(
			(this.expsiaf!=null)?("expsiaf:\t" + this.expsiaf+"\n"):"" ).concat(
			(this.expsiaftipoejec!=null)?("expsiaftipoejec:\t" + this.expsiaftipoejec+"\n"):"" ).concat(
			(this.fechatipoejec!=null)?("fechatipoejec:\t" + this.fechatipoejec+"\n"):"" ).concat(
			(this.modalidadcsc!=null)?("modalidadcsc:\t" + this.modalidadcsc+"\n"):"" ).concat(
			(this.codsnip!=null)?("codsnip:\t" + this.codsnip+"\n"):"" ).concat(
			(this.docviasnip!=null)?("docviasnip:\t" + this.docviasnip+"\n"):"" ).concat(
			(this.fechareg!=null)?("fechareg:\t" + this.fechareg+"\n"):"" ).concat(
			(this.fechamod!=null)?("fechamod:\t" + this.fechamod+"\n"):"" ).concat(
			(this.tipocontratacion!=null)?("tipocontratacion:\t" + this.tipocontratacion+"\n"):"" ).concat(
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
		if(this.nroconsolid!=null)
			nroconsolid=Utils.round(nroconsolid);
		if(this.nrocertifica!=null)
			nrocertifica=Utils.round(nrocertifica);
		if(this.valormoneda!=null)
			valormoneda=Utils.round(valormoneda);
		if(this.valorplan!=null)
			valorplan=Utils.round(valorplan);
		if(this.expsiga!=null)
			expsiga=Utils.round(expsiga);
		if(this.expsiaf!=null)
			expsiaf=Utils.round(expsiaf);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }


	 public java.lang.Integer getVisidsigapaacconsolidado() {
		return visidsigapaacconsolidado;
	}

	public void setVisidsigapaacconsolidado(java.lang.Integer visidsigapaacconsolidado) {
		this.visidsigapaacconsolidado = visidsigapaacconsolidado;
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

	 public java.lang.String getTipoconsolid() {
		return tipoconsolid;
	}

	public void setTipoconsolid(java.lang.String tipoconsolid) {
		this.tipoconsolid = tipoconsolid;
	}

	 public java.math.BigDecimal getNroconsolid() {
		return nroconsolid;
	}

	public void setNroconsolid(java.math.BigDecimal nroconsolid) {
		this.nroconsolid = nroconsolid;
	}

	 public java.math.BigDecimal getNroconsolidini() {
		return nroconsolidini;
	}

	public void setNroconsolidini(java.math.BigDecimal nroconsolidini) {
		this.nroconsolidini = nroconsolidini;
	}

	 public java.math.BigDecimal getNroconsolidfin() {
		return nroconsolidfin;
	}

	public void setNroconsolidfin(java.math.BigDecimal nroconsolidfin) {
		this.nroconsolidfin = nroconsolidfin;
	}

	 public java.lang.String getEstadopaac() {
		return estadopaac;
	}

	public void setEstadopaac(java.lang.String estadopaac) {
		this.estadopaac = estadopaac;
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

	 public java.lang.String getModalcompra() {
		return modalcompra;
	}

	public void setModalcompra(java.lang.String modalcompra) {
		this.modalcompra = modalcompra;
	}

	 public java.util.Date getFechacons() {
		return fechacons;
	}

	public void setFechacons(java.util.Date fechacons) {
		this.fechacons = fechacons;
	}

	 public java.util.Date getFechaconsini() {
		return fechaconsini;
	}

	public void setFechaconsini(java.util.Date fechaconsini) {
		this.fechaconsini = fechaconsini;
	}

	 public java.util.Date getFechaconsfin() {
		return fechaconsfin;
	}

	public void setFechaconsfin(java.util.Date fechaconsfin) {
		this.fechaconsfin = fechaconsfin;
	}

	 public java.lang.String getNropaac() {
		return nropaac;
	}

	public void setNropaac(java.lang.String nropaac) {
		this.nropaac = nropaac;
	}

	 public java.lang.String getMesinicial() {
		return mesinicial;
	}

	public void setMesinicial(java.lang.String mesinicial) {
		this.mesinicial = mesinicial;
	}

	 public java.lang.String getMesfinal() {
		return mesfinal;
	}

	public void setMesfinal(java.lang.String mesfinal) {
		this.mesfinal = mesfinal;
	}

	 public java.lang.String getMespropuesto() {
		return mespropuesto;
	}

	public void setMespropuesto(java.lang.String mespropuesto) {
		this.mespropuesto = mespropuesto;
	}

	 public java.lang.String getTipobien() {
		return tipobien;
	}

	public void setTipobien(java.lang.String tipobien) {
		this.tipobien = tipobien;
	}

	 public java.lang.String getFlagpaac() {
		return flagpaac;
	}

	public void setFlagpaac(java.lang.String flagpaac) {
		this.flagpaac = flagpaac;
	}

	 public java.lang.String getTipoproceso() {
		return tipoproceso;
	}

	public void setTipoproceso(java.lang.String tipoproceso) {
		this.tipoproceso = tipoproceso;
	}

	 public java.lang.String getDescripciontipoproceso() {
		return descripciontipoproceso;
	}

	public void setDescripciontipoproceso(java.lang.String descripciontipoproceso) {
		this.descripciontipoproceso = descripciontipoproceso;
	}

	 public java.lang.String getObjeto() {
		return objeto;
	}

	public void setObjeto(java.lang.String objeto) {
		this.objeto = objeto;
	}

	 public java.lang.String getEspecificaciontecnicas() {
		return especificaciontecnicas;
	}

	public void setEspecificaciontecnicas(java.lang.String especificaciontecnicas) {
		this.especificaciontecnicas = especificaciontecnicas;
	}

	 public java.math.BigDecimal getValormoneda() {
		return valormoneda;
	}

	public void setValormoneda(java.math.BigDecimal valormoneda) {
		this.valormoneda = valormoneda;
	}

	 public java.math.BigDecimal getValormonedaini() {
		return valormonedaini;
	}

	public void setValormonedaini(java.math.BigDecimal valormonedaini) {
		this.valormonedaini = valormonedaini;
	}

	 public java.math.BigDecimal getValormonedafin() {
		return valormonedafin;
	}

	public void setValormonedafin(java.math.BigDecimal valormonedafin) {
		this.valormonedafin = valormonedafin;
	}

	 public java.math.BigDecimal getValorplan() {
		return valorplan;
	}

	public void setValorplan(java.math.BigDecimal valorplan) {
		this.valorplan = valorplan;
	}

	 public java.math.BigDecimal getValorplanini() {
		return valorplanini;
	}

	public void setValorplanini(java.math.BigDecimal valorplanini) {
		this.valorplanini = valorplanini;
	}

	 public java.math.BigDecimal getValorplanfin() {
		return valorplanfin;
	}

	public void setValorplanfin(java.math.BigDecimal valorplanfin) {
		this.valorplanfin = valorplanfin;
	}

	 public java.lang.String getPais() {
		return pais;
	}

	public void setPais(java.lang.String pais) {
		this.pais = pais;
	}

	 public java.lang.String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(java.lang.String departamento) {
		this.departamento = departamento;
	}

	 public java.lang.String getProvincia() {
		return provincia;
	}

	public void setProvincia(java.lang.String provincia) {
		this.provincia = provincia;
	}

	 public java.lang.String getDistrito() {
		return distrito;
	}

	public void setDistrito(java.lang.String distrito) {
		this.distrito = distrito;
	}

	 public java.math.BigDecimal getExpsiga() {
		return expsiga;
	}

	public void setExpsiga(java.math.BigDecimal expsiga) {
		this.expsiga = expsiga;
	}

	 public java.math.BigDecimal getExpsigaini() {
		return expsigaini;
	}

	public void setExpsigaini(java.math.BigDecimal expsigaini) {
		this.expsigaini = expsigaini;
	}

	 public java.math.BigDecimal getExpsigafin() {
		return expsigafin;
	}

	public void setExpsigafin(java.math.BigDecimal expsigafin) {
		this.expsigafin = expsigafin;
	}

	 public java.math.BigDecimal getExpsiaf() {
		return expsiaf;
	}

	public void setExpsiaf(java.math.BigDecimal expsiaf) {
		this.expsiaf = expsiaf;
	}

	 public java.math.BigDecimal getExpsiafini() {
		return expsiafini;
	}

	public void setExpsiafini(java.math.BigDecimal expsiafini) {
		this.expsiafini = expsiafini;
	}

	 public java.math.BigDecimal getExpsiaffin() {
		return expsiaffin;
	}

	public void setExpsiaffin(java.math.BigDecimal expsiaffin) {
		this.expsiaffin = expsiaffin;
	}

	 public java.lang.String getExpsiaftipoejec() {
		return expsiaftipoejec;
	}

	public void setExpsiaftipoejec(java.lang.String expsiaftipoejec) {
		this.expsiaftipoejec = expsiaftipoejec;
	}

	 public java.util.Date getFechatipoejec() {
		return fechatipoejec;
	}

	public void setFechatipoejec(java.util.Date fechatipoejec) {
		this.fechatipoejec = fechatipoejec;
	}

	 public java.util.Date getFechatipoejecini() {
		return fechatipoejecini;
	}

	public void setFechatipoejecini(java.util.Date fechatipoejecini) {
		this.fechatipoejecini = fechatipoejecini;
	}

	 public java.util.Date getFechatipoejecfin() {
		return fechatipoejecfin;
	}

	public void setFechatipoejecfin(java.util.Date fechatipoejecfin) {
		this.fechatipoejecfin = fechatipoejecfin;
	}

	 public java.lang.String getModalidadcsc() {
		return modalidadcsc;
	}

	public void setModalidadcsc(java.lang.String modalidadcsc) {
		this.modalidadcsc = modalidadcsc;
	}

	 public java.lang.String getCodsnip() {
		return codsnip;
	}

	public void setCodsnip(java.lang.String codsnip) {
		this.codsnip = codsnip;
	}

	 public java.lang.String getDocviasnip() {
		return docviasnip;
	}

	public void setDocviasnip(java.lang.String docviasnip) {
		this.docviasnip = docviasnip;
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

	 public java.util.Date getFechamod() {
		return fechamod;
	}

	public void setFechamod(java.util.Date fechamod) {
		this.fechamod = fechamod;
	}

	 public java.util.Date getFechamodini() {
		return fechamodini;
	}

	public void setFechamodini(java.util.Date fechamodini) {
		this.fechamodini = fechamodini;
	}

	 public java.util.Date getFechamodfin() {
		return fechamodfin;
	}

	public void setFechamodfin(java.util.Date fechamodfin) {
		this.fechamodfin = fechamodfin;
	}

	 public java.lang.String getTipocontratacion() {
		return tipocontratacion;
	}

	public void setTipocontratacion(java.lang.String tipocontratacion) {
		this.tipocontratacion = tipocontratacion;
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
