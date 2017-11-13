
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[CuadroComparativoFuente]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Cuadrocomparativofuente extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[id]*/
	private java.lang.Integer idcuadrocomparativofuente;
	/**[PacConsolidado]*/
	private java.lang.Integer idpacconsolidado;
	private Pacconsolidado pacconsolidadoIdpacconsolidado;
	/**[Catalogo Tipofuente][TIFU]*/
	private java.lang.String idcatalogotipofuente;
	private Gentabla gentablaIdcatalogotipofuente;
	/**[Tipo bien][TIBI]*/
	private java.lang.String idcatalogotipobien;
	private Gentabla gentablaIdcatalogotipobien;
	/**[Proveedor]*/
	private java.math.BigDecimal proveedor;
	private java.math.BigDecimal proveedorini;
	private java.math.BigDecimal proveedorfin;
	/**[Ruc Proveedor]*/
	private java.lang.String rucproveedor;
	/**[Nombre Proveedor]*/
	private java.lang.String nombreproveedor;
	/**[Nombre Contacto]*/
	private java.lang.String nombrecontacto;
	/**[Telefono Proveedor]*/
	private java.lang.String telefonoproveedor;
	/**[Correo Proveedor]*/
	private java.lang.String correoproveedor;
	/**[Entidad Convocante]*/
	private java.lang.String entidadconvocante;
	/**[Tipo numero proceso]*/
	private java.lang.String tiponumeroproceso;
	/**[Fecha Consentimiento Buena Pro]*/
	private java.util.Date fechaconsentimientobuenapro;
	private java.util.Date fechaconsentimientobuenaproini;
	private java.util.Date fechaconsentimientobuenaprofin;
	/**[Marca]*/
	private java.lang.String marca;
	/**[Modelo]*/
	private java.lang.String modelo;
	/**[Procedencia]*/
	private java.lang.String procedencia;
	/**[Año Fabricacion]*/
	private java.lang.String aniofabricacion;
	/**[Garantía comercial]*/
	private java.lang.String garantiacomercial;
	/**[Plazo de Entrega]*/
	private java.lang.Integer plazoentrega;
	/**[Forma de pago]*/
	private java.lang.String formapago;
	/**[Moneda Fuente][MOFU]*/
	private java.lang.String idcatalogomonedafuente;
	private Gentabla gentablaIdcatalogomonedafuente;
	/**[Precio Unitario Moneda Consignada]*/
	private java.lang.String preciounitariomonedaconsignada;
	/**[Tipo de cambio]*/
	private java.math.BigDecimal tipocambio;
	private java.math.BigDecimal tipocambioini;
	private java.math.BigDecimal tipocambiofin;
	/**[Fecha de solicitud]*/
	private java.util.Date fechasolicitud;
	private java.util.Date fechasolicitudini;
	private java.util.Date fechasolicitudfin;
	/**[Veces Reitero Solicitud]*/
	private java.lang.Integer vecesreiterosolicitud;
	/**[Fecha Repecion]*/
	private java.util.Date fecharecepcion;
	private java.util.Date fecharecepcionini;
	private java.util.Date fecharecepcionfin;
	/**[Proveedor dedica Contratación][BOOLEAN]*/
	private java.lang.String proveedordedicacontratacion;
	private Boolean booleanproveedordedicacontratacion;
	/**[Usuario participo RTM][BOOLEAN]*/
	private java.lang.String usuarioparticiportm;
	private Boolean booleanusuarioparticiportm;
	/**[Cumple RTM][BOOLEAN]*/
	private java.lang.String cumplertm;
	private Boolean booleancumplertm;
	/**[SeTomoEncuenta][BOOLEAN]*/
	private java.lang.String setomoencuenta;
	private Boolean booleansetomoencuenta;
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
	private List<Cuadrocomparativoitem> listaCuadrocomparativoitem;

	public Cuadrocomparativofuente() {}

	public Cuadrocomparativofuente(java.lang.Integer idcuadrocomparativofuente) {
		this.idcuadrocomparativofuente=idcuadrocomparativofuente;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Cuadrocomparativofuente)
			return ((Cuadrocomparativofuente)obj).getIdcuadrocomparativofuente().equals(this.getIdcuadrocomparativofuente()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idcuadrocomparativofuente!=null)?("idcuadrocomparativofuente:\t" + this.idcuadrocomparativofuente+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.idcatalogotipofuente!=null)?("idcatalogotipofuente:\t" + this.idcatalogotipofuente+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.proveedor!=null)?("proveedor:\t" + this.proveedor+"\n"):"" ).concat(
			(this.rucproveedor!=null)?("rucproveedor:\t" + this.rucproveedor+"\n"):"" ).concat(
			(this.nombreproveedor!=null)?("nombreproveedor:\t" + this.nombreproveedor+"\n"):"" ).concat(
			(this.nombrecontacto!=null)?("nombrecontacto:\t" + this.nombrecontacto+"\n"):"" ).concat(
			(this.telefonoproveedor!=null)?("telefonoproveedor:\t" + this.telefonoproveedor+"\n"):"" ).concat(
			(this.correoproveedor!=null)?("correoproveedor:\t" + this.correoproveedor+"\n"):"" ).concat(
			(this.entidadconvocante!=null)?("entidadconvocante:\t" + this.entidadconvocante+"\n"):"" ).concat(
			(this.tiponumeroproceso!=null)?("tiponumeroproceso:\t" + this.tiponumeroproceso+"\n"):"" ).concat(
			(this.fechaconsentimientobuenapro!=null)?("fechaconsentimientobuenapro:\t" + this.fechaconsentimientobuenapro+"\n"):"" ).concat(
			(this.marca!=null)?("marca:\t" + this.marca+"\n"):"" ).concat(
			(this.modelo!=null)?("modelo:\t" + this.modelo+"\n"):"" ).concat(
			(this.procedencia!=null)?("procedencia:\t" + this.procedencia+"\n"):"" ).concat(
			(this.aniofabricacion!=null)?("aniofabricacion:\t" + this.aniofabricacion+"\n"):"" ).concat(
			(this.garantiacomercial!=null)?("garantiacomercial:\t" + this.garantiacomercial+"\n"):"" ).concat(
			(this.plazoentrega!=null)?("plazoentrega:\t" + this.plazoentrega+"\n"):"" ).concat(
			(this.formapago!=null)?("formapago:\t" + this.formapago+"\n"):"" ).concat(
			(this.idcatalogomonedafuente!=null)?("idcatalogomonedafuente:\t" + this.idcatalogomonedafuente+"\n"):"" ).concat(
			(this.preciounitariomonedaconsignada!=null)?("preciounitariomonedaconsignada:\t" + this.preciounitariomonedaconsignada+"\n"):"" ).concat(
			(this.tipocambio!=null)?("tipocambio:\t" + this.tipocambio+"\n"):"" ).concat(
			(this.fechasolicitud!=null)?("fechasolicitud:\t" + this.fechasolicitud+"\n"):"" ).concat(
			(this.vecesreiterosolicitud!=null)?("vecesreiterosolicitud:\t" + this.vecesreiterosolicitud+"\n"):"" ).concat(
			(this.fecharecepcion!=null)?("fecharecepcion:\t" + this.fecharecepcion+"\n"):"" ).concat(
			(this.proveedordedicacontratacion!=null)?("proveedordedicacontratacion:\t" + this.proveedordedicacontratacion+"\n"):"" ).concat(
			(this.usuarioparticiportm!=null)?("usuarioparticiportm:\t" + this.usuarioparticiportm+"\n"):"" ).concat(
			(this.cumplertm!=null)?("cumplertm:\t" + this.cumplertm+"\n"):"" ).concat(
			(this.setomoencuenta!=null)?("setomoencuenta:\t" + this.setomoencuenta+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idcuadrocomparativofuente!=null)?("idcuadrocomparativofuente:\t" + this.idcuadrocomparativofuente+"\n"):"" ).concat(
			(this.idpacconsolidado!=null)?("idpacconsolidado:\t" + this.idpacconsolidado+"\n"):"" ).concat(
			(this.pacconsolidadoIdpacconsolidado!=null)?("pacconsolidadoIdpacconsolidado:\t" + this.pacconsolidadoIdpacconsolidado.toString()+"\n"):"" ).concat(
			(this.idcatalogotipofuente!=null)?("idcatalogotipofuente:\t" + this.idcatalogotipofuente+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipofuente!=null)?("gentablaIdcatalogotipofuente:\t" + this.gentablaIdcatalogotipofuente.toString()+"\n"):"" ).concat(
			(this.idcatalogotipobien!=null)?("idcatalogotipobien:\t" + this.idcatalogotipobien+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipobien!=null)?("gentablaIdcatalogotipobien:\t" + this.gentablaIdcatalogotipobien.toString()+"\n"):"" ).concat(
			(this.proveedor!=null)?("proveedor:\t" + this.proveedor+"\n"):"" ).concat(
			(this.rucproveedor!=null)?("rucproveedor:\t" + this.rucproveedor+"\n"):"" ).concat(
			(this.nombreproveedor!=null)?("nombreproveedor:\t" + this.nombreproveedor+"\n"):"" ).concat(
			(this.nombrecontacto!=null)?("nombrecontacto:\t" + this.nombrecontacto+"\n"):"" ).concat(
			(this.telefonoproveedor!=null)?("telefonoproveedor:\t" + this.telefonoproveedor+"\n"):"" ).concat(
			(this.correoproveedor!=null)?("correoproveedor:\t" + this.correoproveedor+"\n"):"" ).concat(
			(this.entidadconvocante!=null)?("entidadconvocante:\t" + this.entidadconvocante+"\n"):"" ).concat(
			(this.tiponumeroproceso!=null)?("tiponumeroproceso:\t" + this.tiponumeroproceso+"\n"):"" ).concat(
			(this.fechaconsentimientobuenapro!=null)?("fechaconsentimientobuenapro:\t" + this.fechaconsentimientobuenapro+"\n"):"" ).concat(
			(this.marca!=null)?("marca:\t" + this.marca+"\n"):"" ).concat(
			(this.modelo!=null)?("modelo:\t" + this.modelo+"\n"):"" ).concat(
			(this.procedencia!=null)?("procedencia:\t" + this.procedencia+"\n"):"" ).concat(
			(this.aniofabricacion!=null)?("aniofabricacion:\t" + this.aniofabricacion+"\n"):"" ).concat(
			(this.garantiacomercial!=null)?("garantiacomercial:\t" + this.garantiacomercial+"\n"):"" ).concat(
			(this.plazoentrega!=null)?("plazoentrega:\t" + this.plazoentrega+"\n"):"" ).concat(
			(this.formapago!=null)?("formapago:\t" + this.formapago+"\n"):"" ).concat(
			(this.idcatalogomonedafuente!=null)?("idcatalogomonedafuente:\t" + this.idcatalogomonedafuente+"\n"):"" ).concat(
			(this.gentablaIdcatalogomonedafuente!=null)?("gentablaIdcatalogomonedafuente:\t" + this.gentablaIdcatalogomonedafuente.toString()+"\n"):"" ).concat(
			(this.preciounitariomonedaconsignada!=null)?("preciounitariomonedaconsignada:\t" + this.preciounitariomonedaconsignada+"\n"):"" ).concat(
			(this.tipocambio!=null)?("tipocambio:\t" + this.tipocambio+"\n"):"" ).concat(
			(this.fechasolicitud!=null)?("fechasolicitud:\t" + this.fechasolicitud+"\n"):"" ).concat(
			(this.vecesreiterosolicitud!=null)?("vecesreiterosolicitud:\t" + this.vecesreiterosolicitud+"\n"):"" ).concat(
			(this.fecharecepcion!=null)?("fecharecepcion:\t" + this.fecharecepcion+"\n"):"" ).concat(
			(this.proveedordedicacontratacion!=null)?("proveedordedicacontratacion:\t" + this.proveedordedicacontratacion+"\n"):"" ).concat(
			(this.usuarioparticiportm!=null)?("usuarioparticiportm:\t" + this.usuarioparticiportm+"\n"):"" ).concat(
			(this.cumplertm!=null)?("cumplertm:\t" + this.cumplertm+"\n"):"" ).concat(
			(this.setomoencuenta!=null)?("setomoencuenta:\t" + this.setomoencuenta+"\n"):"" ).concat(
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
		if(this.proveedor!=null)
			proveedor=Utils.round(proveedor);
		if(this.tipocambio!=null)
			tipocambio=Utils.round(tipocambio);

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

	private List<java.lang.String> listaIdcatalogotipofuenteInKeys;
	public void addConditionInIdcatalogotipofuente(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipofuente=null;
			idcatalogotipofuente=null;
			listaIdcatalogotipofuenteInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipofuente=list.get(0);
			listaIdcatalogotipofuenteInKeys=null;
		}else{
			idcatalogotipofuente=null;
			listaIdcatalogotipofuenteInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipofuenteInKeys() {
		return listaIdcatalogotipofuenteInKeys;
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

	private List<java.lang.String> listaIdcatalogomonedafuenteInKeys;
	public void addConditionInIdcatalogomonedafuente(List<String> list){
		if(list==null || list.size()==0){
			idcatalogomonedafuente=null;
			idcatalogomonedafuente=null;
			listaIdcatalogomonedafuenteInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogomonedafuente=list.get(0);
			listaIdcatalogomonedafuenteInKeys=null;
		}else{
			idcatalogomonedafuente=null;
			listaIdcatalogomonedafuenteInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogomonedafuenteInKeys() {
		return listaIdcatalogomonedafuenteInKeys;
	}


	 public java.lang.Integer getIdcuadrocomparativofuente() {
		return idcuadrocomparativofuente;
	}

	public void setIdcuadrocomparativofuente(java.lang.Integer idcuadrocomparativofuente) {
		this.idcuadrocomparativofuente = idcuadrocomparativofuente;
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

	 public java.lang.String getIdcatalogotipofuente() {
		return idcatalogotipofuente;
	}

	public void setIdcatalogotipofuente(java.lang.String idcatalogotipofuente) {
		this.idcatalogotipofuente = idcatalogotipofuente;
	}

	 public Gentabla getGentablaIdcatalogotipofuente() {
		return gentablaIdcatalogotipofuente;
	}

	public void setGentablaIdcatalogotipofuente(Gentabla gentablaIdcatalogotipofuente) {
		this.gentablaIdcatalogotipofuente = gentablaIdcatalogotipofuente;
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

	 public java.math.BigDecimal getProveedor() {
		return proveedor;
	}

	public void setProveedor(java.math.BigDecimal proveedor) {
		this.proveedor = proveedor;
	}

	 public java.math.BigDecimal getProveedorini() {
		return proveedorini;
	}

	public void setProveedorini(java.math.BigDecimal proveedorini) {
		this.proveedorini = proveedorini;
	}

	 public java.math.BigDecimal getProveedorfin() {
		return proveedorfin;
	}

	public void setProveedorfin(java.math.BigDecimal proveedorfin) {
		this.proveedorfin = proveedorfin;
	}

	 public java.lang.String getRucproveedor() {
		return rucproveedor;
	}

	public void setRucproveedor(java.lang.String rucproveedor) {
		this.rucproveedor = rucproveedor;
	}

	 public java.lang.String getNombreproveedor() {
		return nombreproveedor;
	}

	public void setNombreproveedor(java.lang.String nombreproveedor) {
		this.nombreproveedor = nombreproveedor;
	}

	 public java.lang.String getNombrecontacto() {
		return nombrecontacto;
	}

	public void setNombrecontacto(java.lang.String nombrecontacto) {
		this.nombrecontacto = nombrecontacto;
	}

	 public java.lang.String getTelefonoproveedor() {
		return telefonoproveedor;
	}

	public void setTelefonoproveedor(java.lang.String telefonoproveedor) {
		this.telefonoproveedor = telefonoproveedor;
	}

	 public java.lang.String getCorreoproveedor() {
		return correoproveedor;
	}

	public void setCorreoproveedor(java.lang.String correoproveedor) {
		this.correoproveedor = correoproveedor;
	}

	 public java.lang.String getEntidadconvocante() {
		return entidadconvocante;
	}

	public void setEntidadconvocante(java.lang.String entidadconvocante) {
		this.entidadconvocante = entidadconvocante;
	}

	 public java.lang.String getTiponumeroproceso() {
		return tiponumeroproceso;
	}

	public void setTiponumeroproceso(java.lang.String tiponumeroproceso) {
		this.tiponumeroproceso = tiponumeroproceso;
	}

	 public java.util.Date getFechaconsentimientobuenapro() {
		return fechaconsentimientobuenapro;
	}

	public void setFechaconsentimientobuenapro(java.util.Date fechaconsentimientobuenapro) {
		this.fechaconsentimientobuenapro = fechaconsentimientobuenapro;
	}

	 public java.util.Date getFechaconsentimientobuenaproini() {
		return fechaconsentimientobuenaproini;
	}

	public void setFechaconsentimientobuenaproini(java.util.Date fechaconsentimientobuenaproini) {
		this.fechaconsentimientobuenaproini = fechaconsentimientobuenaproini;
	}

	 public java.util.Date getFechaconsentimientobuenaprofin() {
		return fechaconsentimientobuenaprofin;
	}

	public void setFechaconsentimientobuenaprofin(java.util.Date fechaconsentimientobuenaprofin) {
		this.fechaconsentimientobuenaprofin = fechaconsentimientobuenaprofin;
	}

	 public java.lang.String getMarca() {
		return marca;
	}

	public void setMarca(java.lang.String marca) {
		this.marca = marca;
	}

	 public java.lang.String getModelo() {
		return modelo;
	}

	public void setModelo(java.lang.String modelo) {
		this.modelo = modelo;
	}

	 public java.lang.String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(java.lang.String procedencia) {
		this.procedencia = procedencia;
	}

	 public java.lang.String getAniofabricacion() {
		return aniofabricacion;
	}

	public void setAniofabricacion(java.lang.String aniofabricacion) {
		this.aniofabricacion = aniofabricacion;
	}

	 public java.lang.String getGarantiacomercial() {
		return garantiacomercial;
	}

	public void setGarantiacomercial(java.lang.String garantiacomercial) {
		this.garantiacomercial = garantiacomercial;
	}

	 public java.lang.Integer getPlazoentrega() {
		return plazoentrega;
	}

	public void setPlazoentrega(java.lang.Integer plazoentrega) {
		this.plazoentrega = plazoentrega;
	}

	 public java.lang.String getFormapago() {
		return formapago;
	}

	public void setFormapago(java.lang.String formapago) {
		this.formapago = formapago;
	}

	 public java.lang.String getIdcatalogomonedafuente() {
		return idcatalogomonedafuente;
	}

	public void setIdcatalogomonedafuente(java.lang.String idcatalogomonedafuente) {
		this.idcatalogomonedafuente = idcatalogomonedafuente;
	}

	 public Gentabla getGentablaIdcatalogomonedafuente() {
		return gentablaIdcatalogomonedafuente;
	}

	public void setGentablaIdcatalogomonedafuente(Gentabla gentablaIdcatalogomonedafuente) {
		this.gentablaIdcatalogomonedafuente = gentablaIdcatalogomonedafuente;
	}

	 public java.lang.String getPreciounitariomonedaconsignada() {
		return preciounitariomonedaconsignada;
	}

	public void setPreciounitariomonedaconsignada(java.lang.String preciounitariomonedaconsignada) {
		this.preciounitariomonedaconsignada = preciounitariomonedaconsignada;
	}

	 public java.math.BigDecimal getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(java.math.BigDecimal tipocambio) {
		this.tipocambio = tipocambio;
	}

	 public java.math.BigDecimal getTipocambioini() {
		return tipocambioini;
	}

	public void setTipocambioini(java.math.BigDecimal tipocambioini) {
		this.tipocambioini = tipocambioini;
	}

	 public java.math.BigDecimal getTipocambiofin() {
		return tipocambiofin;
	}

	public void setTipocambiofin(java.math.BigDecimal tipocambiofin) {
		this.tipocambiofin = tipocambiofin;
	}

	 public java.util.Date getFechasolicitud() {
		return fechasolicitud;
	}

	public void setFechasolicitud(java.util.Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	 public java.util.Date getFechasolicitudini() {
		return fechasolicitudini;
	}

	public void setFechasolicitudini(java.util.Date fechasolicitudini) {
		this.fechasolicitudini = fechasolicitudini;
	}

	 public java.util.Date getFechasolicitudfin() {
		return fechasolicitudfin;
	}

	public void setFechasolicitudfin(java.util.Date fechasolicitudfin) {
		this.fechasolicitudfin = fechasolicitudfin;
	}

	 public java.lang.Integer getVecesreiterosolicitud() {
		return vecesreiterosolicitud;
	}

	public void setVecesreiterosolicitud(java.lang.Integer vecesreiterosolicitud) {
		this.vecesreiterosolicitud = vecesreiterosolicitud;
	}

	 public java.util.Date getFecharecepcion() {
		return fecharecepcion;
	}

	public void setFecharecepcion(java.util.Date fecharecepcion) {
		this.fecharecepcion = fecharecepcion;
	}

	 public java.util.Date getFecharecepcionini() {
		return fecharecepcionini;
	}

	public void setFecharecepcionini(java.util.Date fecharecepcionini) {
		this.fecharecepcionini = fecharecepcionini;
	}

	 public java.util.Date getFecharecepcionfin() {
		return fecharecepcionfin;
	}

	public void setFecharecepcionfin(java.util.Date fecharecepcionfin) {
		this.fecharecepcionfin = fecharecepcionfin;
	}

	 public java.lang.String getProveedordedicacontratacion() {
		return proveedordedicacontratacion;
	}

	public void setProveedordedicacontratacion(java.lang.String proveedordedicacontratacion) {
		this.proveedordedicacontratacion = proveedordedicacontratacion;
	}

	 public Boolean getBooleanproveedordedicacontratacion() {
		return booleanproveedordedicacontratacion;
	}

	public void setBooleanproveedordedicacontratacion(Boolean booleanproveedordedicacontratacion) {
		this.booleanproveedordedicacontratacion = booleanproveedordedicacontratacion;
	}

	 public java.lang.String getUsuarioparticiportm() {
		return usuarioparticiportm;
	}

	public void setUsuarioparticiportm(java.lang.String usuarioparticiportm) {
		this.usuarioparticiportm = usuarioparticiportm;
	}

	 public Boolean getBooleanusuarioparticiportm() {
		return booleanusuarioparticiportm;
	}

	public void setBooleanusuarioparticiportm(Boolean booleanusuarioparticiportm) {
		this.booleanusuarioparticiportm = booleanusuarioparticiportm;
	}

	 public java.lang.String getCumplertm() {
		return cumplertm;
	}

	public void setCumplertm(java.lang.String cumplertm) {
		this.cumplertm = cumplertm;
	}

	 public Boolean getBooleancumplertm() {
		return booleancumplertm;
	}

	public void setBooleancumplertm(Boolean booleancumplertm) {
		this.booleancumplertm = booleancumplertm;
	}

	 public java.lang.String getSetomoencuenta() {
		return setomoencuenta;
	}

	public void setSetomoencuenta(java.lang.String setomoencuenta) {
		this.setomoencuenta = setomoencuenta;
	}

	 public Boolean getBooleansetomoencuenta() {
		return booleansetomoencuenta;
	}

	public void setBooleansetomoencuenta(Boolean booleansetomoencuenta) {
		this.booleansetomoencuenta = booleansetomoencuenta;
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

	 public List<Cuadrocomparativoitem> getListaCuadrocomparativoitem() {
		return listaCuadrocomparativoitem;
	}

	public void setListaCuadrocomparativoitem(List<Cuadrocomparativoitem> listaCuadrocomparativoitem) {
		this.listaCuadrocomparativoitem = listaCuadrocomparativoitem;
	}

}
