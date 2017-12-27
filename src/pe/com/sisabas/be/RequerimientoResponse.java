package pe.com.sisabas.be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import pe.com.sisabas.resources.Utils;

public class RequerimientoResponse extends SysTabla  implements  Serializable,Cloneable{
	
	private static final long serialVersionUID = 1L;

	private Integer idPedido;                         
	private String nroPedido;                    
	private String motivoPedido;         
	private String idTipoBien;             
	private String tipobien;        
	private BigDecimal montoPedido;      
	private Date fechaPedido;         
	private String estadoRequerimiento;
	private String estadoSiga;    
	private String desEstadoIn;       
	private Integer estadoPedidoIn;  
	private Integer secFunc;       
	private String codigoCentroCosto;    
	private String nombreDependencia;    
	private Integer idDocumentoTecnico;  
	private Integer numeroSinad;         
	private Integer anioSinad;       
	private String numeroExpedienteSinad;
	private Integer poIAsociado;
	private String descTipoTDR; 
	private Integer rowtotal;
	private String tipoDocumentoSinad;
	private String numeroDocumentoSinad;
	private String formatoFecha;
	
	
	//atributos programado

	private String nroPac;
	private Integer nroConsolid;
	private Integer tienePao;
	
	
	public String getFormatoFecha() {
		return formatoFecha;
	}


	public void setFormatoFecha(String formatoFecha) {
		this.formatoFecha = formatoFecha;
	}


	public RequerimientoResponse() {
		
	}
	
	
	@Override
	public String toString() {
		return ((this.idPedido!=null)?("idPedido:\t" + this.idPedido+"\n"):"" ).concat(
				(this.nroPedido!=null)?("nroPedido:\t" + this.nroPedido+"\n"):"" ).concat(
				(this.motivoPedido!=null)?("motivoPedido:\t" + this.motivoPedido+"\n"):"" ).concat(
				(this.idTipoBien!=null)?("idTipoBien:\t" + this.idTipoBien+"\n"):"" ).concat(
				(this.tipobien!=null)?("tipobien:\t" + this.tipobien+"\n"):"" ).concat(
				(this.montoPedido!=null)?("montoPedido:\t" + this.montoPedido+"\n"):"" ).concat(
				(this.fechaPedido!=null)?("fechaPedido:\t" + this.fechaPedido+"\n"):"" ).concat(
				(this.estadoRequerimiento!=null)?("estadoRequerimiento:\t" + this.estadoRequerimiento+"\n"):"" ).concat(
				(this.estadoSiga!=null)?("estadoSiga:\t" + this.estadoSiga+"\n"):"" ).concat(
				(this.desEstadoIn!=null)?("desEstadoIn:\t" + this.desEstadoIn+"\n"):"" ).concat(
				(this.estadoPedidoIn!=null)?("estadoPedidoIn:\t" + this.estadoPedidoIn+"\n"):"" ).concat(
				(this.secFunc!=null)?("secFunc:\t" + this.secFunc+"\n"):"" ).concat(
				(this.codigoCentroCosto!=null)?("codigoCentroCosto:\t" + this.codigoCentroCosto+"\n"):"" ).concat(
				(this.nombreDependencia!=null)?("nombreDependencia:\t" + this.nombreDependencia+"\n"):"" ).concat(
				(this.idDocumentoTecnico!=null)?("idDocumentoTecnico:\t" + this.idDocumentoTecnico+"\n"):"" ).concat(
				(this.numeroSinad!=null)?("numeroSinad:\t" + this.numeroSinad+"\n"):"" ).concat(
				(this.anioSinad!=null)?("anioSinad:\t" + this.anioSinad+"\n"):"" ).concat(
				(this.numeroExpedienteSinad!=null)?("numeroExpedienteSinad:\t" + this.numeroExpedienteSinad+"\n"):"" ).concat(
				(this.poIAsociado!=null)?("poIAsociado:\t" + this.poIAsociado+"\n"):"").concat(
				(this.descTipoTDR!=null)?("descTipoTDR:\t" + this.descTipoTDR+"\n"):"" ).concat(
				(this.rowtotal!=null)?("rowtotal:\t" + this.rowtotal+"\n"):"" ).concat(
				(this.tipoDocumentoSinad!=null)?("tipoDocumentoSinad:\t" + this.tipoDocumentoSinad+"\n"):"" ).concat(
				(this.numeroDocumentoSinad!=null)?("numeroDocumentoSinad:\t" + this.numeroDocumentoSinad+"\n"):"" );
	}


	public static final boolean HAVE_BIGDECIMALS=true;
	public void roundBigDecimals(){
		if(this.montoPedido!=null)
			montoPedido=Utils.round(montoPedido);
		if(this.montoPedido!=null)
			montoPedido=Utils.round(montoPedido);

	 }
	

	
	public void formatoFecha(){
		
		this.formatoFecha=new SimpleDateFormat("dd-MM-yyyy").format(fechaPedido);

	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }
	
	
	
	public Integer getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}


	public String getNroPedido() {
		return nroPedido;
	}


	public void setNroPedido(String nroPedido) {
		this.nroPedido = nroPedido;
	}


	public String getMotivoPedido() {
		return motivoPedido;
	}


	public void setMotivoPedido(String motivoPedido) {
		this.motivoPedido = motivoPedido;
	}


	public String getIdTipoBien() {
		return idTipoBien;
	}


	public void setIdTipoBien(String idTipoBien) {
		this.idTipoBien = idTipoBien;
	}


	public String getTipobien() {
		return tipobien;
	}


	public void setTipobien(String tipobien) {
		this.tipobien = tipobien;
	}


	public BigDecimal getMontoPedido() {
		return montoPedido;
	}


	public void setMontoPedido(BigDecimal montoPedido) {
		this.montoPedido = montoPedido;
	}


	public Date getFechaPedido() {
		return fechaPedido;
	}


	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}


	public String getEstadoRequerimiento() {
		return estadoRequerimiento;
	}


	public void setEstadoRequerimiento(String estadoRequerimiento) {
		this.estadoRequerimiento = estadoRequerimiento;
	}


	public String getEstadoSiga() {
		return estadoSiga;
	}


	public void setEstadoSiga(String estadoSiga) {
		this.estadoSiga = estadoSiga;
	}


	public String getDesEstadoIn() {
		return desEstadoIn;
	}


	public void setDesEstadoIn(String desEstadoIn) {
		this.desEstadoIn = desEstadoIn;
	}


	public Integer getEstadoPedidoIn() {
		return estadoPedidoIn;
	}


	public void setEstadoPedidoIn(Integer estadoPedidoIn) {
		this.estadoPedidoIn = estadoPedidoIn;
	}


	public Integer getSecFunc() {
		return secFunc;
	}


	public void setSecFunc(Integer secFunc) {
		this.secFunc = secFunc;
	}


	public String getCodigoCentroCosto() {
		return codigoCentroCosto;
	}


	public void setCodigoCentroCosto(String codigoCentroCosto) {
		this.codigoCentroCosto = codigoCentroCosto;
	}


	public String getNombreDependencia() {
		return nombreDependencia;
	}


	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}


	public Integer getIdDocumentoTecnico() {
		return idDocumentoTecnico;
	}


	public void setIdDocumentoTecnico(Integer idDocumentoTecnico) {
		this.idDocumentoTecnico = idDocumentoTecnico;
	}


	public Integer getNumeroSinad() {
		return numeroSinad;
	}


	public void setNumeroSinad(Integer numeroSinad) {
		this.numeroSinad = numeroSinad;
	}


	public Integer getAnioSinad() {
		return anioSinad;
	}


	public void setAnioSinad(Integer anioSinad) {
		this.anioSinad = anioSinad;
	}


	public String getNumeroExpedienteSinad() {
		return numeroExpedienteSinad;
	}


	public void setNumeroExpedienteSinad(String numeroExpedienteSinad) {
		this.numeroExpedienteSinad = numeroExpedienteSinad;
	}


	public Integer getPoIAsociado() {
		return poIAsociado;
	}


	public void setPoIAsociado(Integer poIAsociado) {
		this.poIAsociado = poIAsociado;
	}


	public String getDescTipoTDR() {
		return descTipoTDR;
	}


	public void setDescTipoTDR(String descTipoTDR) {
		this.descTipoTDR = descTipoTDR;
	}


	public Integer getRowtotal() {
		return rowtotal;
	}


	public void setRowtotal(Integer rowtotal) {
		this.rowtotal = rowtotal;
	}


	public String getTipoDocumentoSinad() {
		return tipoDocumentoSinad;
	}


	public void setTipoDocumentoSinad(String tipoDocumentoSinad) {
		this.tipoDocumentoSinad = tipoDocumentoSinad;
	}


	public String getNumeroDocumentoSinad() {
		return numeroDocumentoSinad;
	}


	public void setNumeroDocumentoSinad(String numeroDocumentoSinad) {
		this.numeroDocumentoSinad = numeroDocumentoSinad;
	}



	public Integer getTienePao() {
		return tienePao;
	}


	public void setTienePao(Integer tienePao) {
		this.tienePao = tienePao;
	}


	public Integer getNroConsolid() {
		return nroConsolid;
	}


	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}


	public String getNroPac() {
		return nroPac;
	}


	public void setNroPac(String nroPac) {
		this.nroPac = nroPac;
	}



	
	
	
	
}
