
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Documento tecnico]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Documentotecnico extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer iddocumentotecnico;
	/**[Pedido In]*/
	private java.lang.Integer idpedido;
	private Pedido pedidoIdpedido;
	/**[Pac Programado]*/
	private java.lang.Integer idpacprogramado;
	private Pacprogramado pacprogramadoIdpacprogramado;
	/**[Comité Proceso]*/
	private java.lang.Integer idcomiteproceso;
	private Comiteproceso comiteprocesoIdcomiteproceso;
	/**[Denominación de Contratación]*/
	private java.lang.String denominacioncontratacion;
	/**[Finalidad Pública]*/
	private java.lang.String finalidadpublica;
	/**[Número(Pac)]*/
	private java.lang.Integer nropac;
	/**[Objeto de Contratación]*/
	private java.lang.String objetocontratacion;
	/**[Centro de costo]*/
	private java.lang.String centrocosto;
	/**[Antecedentes]*/
	private java.lang.String antecedentes;
	/**[Dni Responsable]*/
	private java.lang.String dniresponsable;
	/**[Nombre de responsable]*/
	private java.lang.String nombreresponsable;
	/**[Número de Anexo Responsable]*/
	private java.lang.String nroanexoresponsable;
	/**[Correo Responsable]*/
	private java.lang.String correoresponsable;
	/**[Tipo de documento técnico][TSDP]*/
	private java.lang.String idcatalogotipodocumentotecnico;
	private Gentabla gentablaIdcatalogotipodocumentotecnico;
	/**[Tipo Tdr][TITD]*/
	private java.lang.String idcatalogotipotdr;
	private Gentabla gentablaIdcatalogotipotdr;
	
	
	
	
	
	
	
	/**[Ruta Anexo]*/
	private java.lang.String rutaanexo;
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
	/**[Ubigeo]*/
	private java.lang.String ubigeo;
	/**[Dirección]*/
	private java.lang.String direccion;
	/**[Numero Sinad]*/
	private java.lang.Integer numerosinad;
	/**[Año de Expediente]*/
	private java.lang.Integer anioexpediente;
	/**[Número de Expediente]*/
	private java.lang.String numeroexpediente;
	/**[Tiene Comité][boolean]*/
	private java.lang.String tienecomite;
	private Boolean booleantienecomite;
	/**[Tipo Itinerario]*/
	private java.lang.String tipoitinerario;
	/**[Número Pedido ]*/
	private java.lang.String nropedidoitinerario;
	/**[Año Pedido Itinerario]*/
	private java.lang.Integer aniopedidoitinerario;
	/**[UE Pedido Itinerario]*/
	private java.lang.String uepedidoitinerario;
	/**[Justificación Pedido Itinerario]*/
	private java.lang.String justificacionpedidoitinerario;
	/**[Itinerario Origen Registrado][boolean]*/
	private java.lang.String itinerarioorigenregistrado;
	private Boolean booleanitinerarioorigenregistrado;
	/**[*][EquipoAuditoria]*/
	private java.lang.String equipoauditoria;
	/**[*][ProgramaAuditoria]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;
	private List<Plazopagodocumentotecnico> listaPlazopagodocumentotecnico;
	private List<Dependenciadocumentotecnico> listaDependenciadocumentotecnico;
	private List<Itinerarioconveniomarco> listaItinerarioconveniomarco;
	private List<Observacionesdocumentotecnico> listaObservacionesdocumentotecnico;

	public Documentotecnico() {}

	public Documentotecnico(java.lang.Integer iddocumentotecnico) {
		this.iddocumentotecnico=iddocumentotecnico;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Documentotecnico)
			return ((Documentotecnico)obj).getIddocumentotecnico().equals(this.getIddocumentotecnico()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.iddocumentotecnico!=null)?("iddocumentotecnico:\t" + this.iddocumentotecnico+"\n"):"" ).concat(
			(this.idpedido!=null)?("idpedido:\t" + this.idpedido+"\n"):"" ).concat(
			(this.idpacprogramado!=null)?("idpacprogramado:\t" + this.idpacprogramado+"\n"):"" ).concat(
			(this.idcomiteproceso!=null)?("idcomiteproceso:\t" + this.idcomiteproceso+"\n"):"" ).concat(
			(this.denominacioncontratacion!=null)?("denominacioncontratacion:\t" + this.denominacioncontratacion+"\n"):"" ).concat(
			(this.finalidadpublica!=null)?("finalidadpublica:\t" + this.finalidadpublica+"\n"):"" ).concat(
			(this.nropac!=null)?("nropac:\t" + this.nropac+"\n"):"" ).concat(
			(this.objetocontratacion!=null)?("objetocontratacion:\t" + this.objetocontratacion+"\n"):"" ).concat(
			(this.centrocosto!=null)?("centrocosto:\t" + this.centrocosto+"\n"):"" ).concat(
			(this.antecedentes!=null)?("antecedentes:\t" + this.antecedentes+"\n"):"" ).concat(
			(this.dniresponsable!=null)?("dniresponsable:\t" + this.dniresponsable+"\n"):"" ).concat(
			(this.nombreresponsable!=null)?("nombreresponsable:\t" + this.nombreresponsable+"\n"):"" ).concat(
			(this.nroanexoresponsable!=null)?("nroanexoresponsable:\t" + this.nroanexoresponsable+"\n"):"" ).concat(
			(this.correoresponsable!=null)?("correoresponsable:\t" + this.correoresponsable+"\n"):"" ).concat(
			(this.idcatalogotipodocumentotecnico!=null)?("idcatalogotipodocumentotecnico:\t" + this.idcatalogotipodocumentotecnico+"\n"):"" ).concat(
			(this.idcatalogotipotdr!=null)?("idcatalogotipotdr:\t" + this.idcatalogotipotdr+"\n"):"" ).concat(
			(this.rutaanexo!=null)?("rutaanexo:\t" + this.rutaanexo+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.ubigeo!=null)?("ubigeo:\t" + this.ubigeo+"\n"):"" ).concat(
			(this.direccion!=null)?("direccion:\t" + this.direccion+"\n"):"" ).concat(
			(this.numerosinad!=null)?("numerosinad:\t" + this.numerosinad+"\n"):"" ).concat(
			(this.anioexpediente!=null)?("anioexpediente:\t" + this.anioexpediente+"\n"):"" ).concat(
			(this.numeroexpediente!=null)?("numeroexpediente:\t" + this.numeroexpediente+"\n"):"" ).concat(
			(this.tienecomite!=null)?("tienecomite:\t" + this.tienecomite+"\n"):"" ).concat(
			(this.tipoitinerario!=null)?("tipoitinerario:\t" + this.tipoitinerario+"\n"):"" ).concat(
			(this.nropedidoitinerario!=null)?("nropedidoitinerario:\t" + this.nropedidoitinerario+"\n"):"" ).concat(
			(this.aniopedidoitinerario!=null)?("aniopedidoitinerario:\t" + this.aniopedidoitinerario+"\n"):"" ).concat(
			(this.uepedidoitinerario!=null)?("uepedidoitinerario:\t" + this.uepedidoitinerario+"\n"):"" ).concat(
			(this.justificacionpedidoitinerario!=null)?("justificacionpedidoitinerario:\t" + this.justificacionpedidoitinerario+"\n"):"" ).concat(
			(this.itinerarioorigenregistrado!=null)?("itinerarioorigenregistrado:\t" + this.itinerarioorigenregistrado+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.iddocumentotecnico!=null)?("iddocumentotecnico:\t" + this.iddocumentotecnico+"\n"):"" ).concat(
			(this.idpedido!=null)?("idpedido:\t" + this.idpedido+"\n"):"" ).concat(
			(this.pedidoIdpedido!=null)?("pedidoIdpedido:\t" + this.pedidoIdpedido.toString()+"\n"):"" ).concat(
			(this.idpacprogramado!=null)?("idpacprogramado:\t" + this.idpacprogramado+"\n"):"" ).concat(
			(this.pacprogramadoIdpacprogramado!=null)?("pacprogramadoIdpacprogramado:\t" + this.pacprogramadoIdpacprogramado.toString()+"\n"):"" ).concat(
			(this.idcomiteproceso!=null)?("idcomiteproceso:\t" + this.idcomiteproceso+"\n"):"" ).concat(
			(this.comiteprocesoIdcomiteproceso!=null)?("comiteprocesoIdcomiteproceso:\t" + this.comiteprocesoIdcomiteproceso.toString()+"\n"):"" ).concat(
			(this.denominacioncontratacion!=null)?("denominacioncontratacion:\t" + this.denominacioncontratacion+"\n"):"" ).concat(
			(this.finalidadpublica!=null)?("finalidadpublica:\t" + this.finalidadpublica+"\n"):"" ).concat(
			(this.nropac!=null)?("nropac:\t" + this.nropac+"\n"):"" ).concat(
			(this.objetocontratacion!=null)?("objetocontratacion:\t" + this.objetocontratacion+"\n"):"" ).concat(
			(this.centrocosto!=null)?("centrocosto:\t" + this.centrocosto+"\n"):"" ).concat(
			(this.antecedentes!=null)?("antecedentes:\t" + this.antecedentes+"\n"):"" ).concat(
			(this.dniresponsable!=null)?("dniresponsable:\t" + this.dniresponsable+"\n"):"" ).concat(
			(this.nombreresponsable!=null)?("nombreresponsable:\t" + this.nombreresponsable+"\n"):"" ).concat(
			(this.nroanexoresponsable!=null)?("nroanexoresponsable:\t" + this.nroanexoresponsable+"\n"):"" ).concat(
			(this.correoresponsable!=null)?("correoresponsable:\t" + this.correoresponsable+"\n"):"" ).concat(
			(this.idcatalogotipodocumentotecnico!=null)?("idcatalogotipodocumentotecnico:\t" + this.idcatalogotipodocumentotecnico+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipodocumentotecnico!=null)?("gentablaIdcatalogotipodocumentotecnico:\t" + this.gentablaIdcatalogotipodocumentotecnico.toString()+"\n"):"" ).concat(
			(this.idcatalogotipotdr!=null)?("idcatalogotipotdr:\t" + this.idcatalogotipotdr+"\n"):"" ).concat(
			(this.gentablaIdcatalogotipotdr!=null)?("gentablaIdcatalogotipotdr:\t" + this.gentablaIdcatalogotipotdr.toString()+"\n"):"" ).concat(
			(this.rutaanexo!=null)?("rutaanexo:\t" + this.rutaanexo+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.ubigeo!=null)?("ubigeo:\t" + this.ubigeo+"\n"):"" ).concat(
			(this.direccion!=null)?("direccion:\t" + this.direccion+"\n"):"" ).concat(
			(this.numerosinad!=null)?("numerosinad:\t" + this.numerosinad+"\n"):"" ).concat(
			(this.anioexpediente!=null)?("anioexpediente:\t" + this.anioexpediente+"\n"):"" ).concat(
			(this.numeroexpediente!=null)?("numeroexpediente:\t" + this.numeroexpediente+"\n"):"" ).concat(
			(this.tienecomite!=null)?("tienecomite:\t" + this.tienecomite+"\n"):"" ).concat(
			(this.tipoitinerario!=null)?("tipoitinerario:\t" + this.tipoitinerario+"\n"):"" ).concat(
			(this.nropedidoitinerario!=null)?("nropedidoitinerario:\t" + this.nropedidoitinerario+"\n"):"" ).concat(
			(this.aniopedidoitinerario!=null)?("aniopedidoitinerario:\t" + this.aniopedidoitinerario+"\n"):"" ).concat(
			(this.uepedidoitinerario!=null)?("uepedidoitinerario:\t" + this.uepedidoitinerario+"\n"):"" ).concat(
			(this.justificacionpedidoitinerario!=null)?("justificacionpedidoitinerario:\t" + this.justificacionpedidoitinerario+"\n"):"" ).concat(
			(this.itinerarioorigenregistrado!=null)?("itinerarioorigenregistrado:\t" + this.itinerarioorigenregistrado+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public static final boolean HAVE_BIGDECIMALS=false;
	public void roundBigDecimals(){

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.Integer> listaIdpedidoInKeys;
	public void addConditionInIdpedido(List<String> list){
		if(list==null || list.size()==0){
			idpedido=null;
			listaIdpedidoInKeys=null;
			return;
		}
		if(list.size()==1){
			idpedido=Integer.parseInt(list.get(0));
			listaIdpedidoInKeys=null;
		}else{
			idpedido=null;
			listaIdpedidoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdpedidoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdpedidoInKeys() {
		return listaIdpedidoInKeys;
	}

	private List<java.lang.Integer> listaIdpacprogramadoInKeys;
	public void addConditionInIdpacprogramado(List<String> list){
		if(list==null || list.size()==0){
			idpacprogramado=null;
			listaIdpacprogramadoInKeys=null;
			return;
		}
		if(list.size()==1){
			idpacprogramado=Integer.parseInt(list.get(0));
			listaIdpacprogramadoInKeys=null;
		}else{
			idpacprogramado=null;
			listaIdpacprogramadoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdpacprogramadoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdpacprogramadoInKeys() {
		return listaIdpacprogramadoInKeys;
	}

	private List<java.lang.Integer> listaIdcomiteprocesoInKeys;
	public void addConditionInIdcomiteproceso(List<String> list){
		if(list==null || list.size()==0){
			idcomiteproceso=null;
			listaIdcomiteprocesoInKeys=null;
			return;
		}
		if(list.size()==1){
			idcomiteproceso=Integer.parseInt(list.get(0));
			listaIdcomiteprocesoInKeys=null;
		}else{
			idcomiteproceso=null;
			listaIdcomiteprocesoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdcomiteprocesoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdcomiteprocesoInKeys() {
		return listaIdcomiteprocesoInKeys;
	}

	private List<java.lang.String> listaIdcatalogotipodocumentotecnicoInKeys;
	public void addConditionInIdcatalogotipodocumentotecnico(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipodocumentotecnico=null;
			idcatalogotipodocumentotecnico=null;
			listaIdcatalogotipodocumentotecnicoInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipodocumentotecnico=list.get(0);
			listaIdcatalogotipodocumentotecnicoInKeys=null;
		}else{
			idcatalogotipodocumentotecnico=null;
			listaIdcatalogotipodocumentotecnicoInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipodocumentotecnicoInKeys() {
		return listaIdcatalogotipodocumentotecnicoInKeys;
	}

	private List<java.lang.String> listaIdcatalogotipotdrInKeys;
	public void addConditionInIdcatalogotipotdr(List<String> list){
		if(list==null || list.size()==0){
			idcatalogotipotdr=null;
			idcatalogotipotdr=null;
			listaIdcatalogotipotdrInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogotipotdr=list.get(0);
			listaIdcatalogotipotdrInKeys=null;
		}else{
			idcatalogotipotdr=null;
			listaIdcatalogotipotdrInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogotipotdrInKeys() {
		return listaIdcatalogotipotdrInKeys;
	}


	 public java.lang.Integer getIddocumentotecnico() {
		return iddocumentotecnico;
	}

	public void setIddocumentotecnico(java.lang.Integer iddocumentotecnico) {
		this.iddocumentotecnico = iddocumentotecnico;
	}

	 public java.lang.Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(java.lang.Integer idpedido) {
		this.idpedido = idpedido;
	}

	 public Pedido getPedidoIdpedido() {
		return pedidoIdpedido;
	}

	public void setPedidoIdpedido(Pedido pedidoIdpedido) {
		this.pedidoIdpedido = pedidoIdpedido;
	}

	 public java.lang.Integer getIdpacprogramado() {
		return idpacprogramado;
	}

	public void setIdpacprogramado(java.lang.Integer idpacprogramado) {
		this.idpacprogramado = idpacprogramado;
	}

	 public Pacprogramado getPacprogramadoIdpacprogramado() {
		return pacprogramadoIdpacprogramado;
	}

	public void setPacprogramadoIdpacprogramado(Pacprogramado pacprogramadoIdpacprogramado) {
		this.pacprogramadoIdpacprogramado = pacprogramadoIdpacprogramado;
	}

	 public java.lang.Integer getIdcomiteproceso() {
		return idcomiteproceso;
	}

	public void setIdcomiteproceso(java.lang.Integer idcomiteproceso) {
		this.idcomiteproceso = idcomiteproceso;
	}

	 public Comiteproceso getComiteprocesoIdcomiteproceso() {
		return comiteprocesoIdcomiteproceso;
	}

	public void setComiteprocesoIdcomiteproceso(Comiteproceso comiteprocesoIdcomiteproceso) {
		this.comiteprocesoIdcomiteproceso = comiteprocesoIdcomiteproceso;
	}

	 public java.lang.String getDenominacioncontratacion() {
		return denominacioncontratacion;
	}

	public void setDenominacioncontratacion(java.lang.String denominacioncontratacion) {
		this.denominacioncontratacion = denominacioncontratacion;
	}

	 public java.lang.String getFinalidadpublica() {
		return finalidadpublica;
	}

	public void setFinalidadpublica(java.lang.String finalidadpublica) {
		this.finalidadpublica = finalidadpublica;
	}

	 public java.lang.Integer getNropac() {
		return nropac;
	}

	public void setNropac(java.lang.Integer nropac) {
		this.nropac = nropac;
	}

	 public java.lang.String getObjetocontratacion() {
		return objetocontratacion;
	}

	public void setObjetocontratacion(java.lang.String objetocontratacion) {
		this.objetocontratacion = objetocontratacion;
	}

	 public java.lang.String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(java.lang.String centrocosto) {
		this.centrocosto = centrocosto;
	}

	 public java.lang.String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(java.lang.String antecedentes) {
		this.antecedentes = antecedentes;
	}

	 public java.lang.String getDniresponsable() {
		return dniresponsable;
	}

	public void setDniresponsable(java.lang.String dniresponsable) {
		this.dniresponsable = dniresponsable;
	}

	 public java.lang.String getNombreresponsable() {
		return nombreresponsable;
	}

	public void setNombreresponsable(java.lang.String nombreresponsable) {
		this.nombreresponsable = nombreresponsable;
	}

	 public java.lang.String getNroanexoresponsable() {
		return nroanexoresponsable;
	}

	public void setNroanexoresponsable(java.lang.String nroanexoresponsable) {
		this.nroanexoresponsable = nroanexoresponsable;
	}

	 public java.lang.String getCorreoresponsable() {
		return correoresponsable;
	}

	public void setCorreoresponsable(java.lang.String correoresponsable) {
		this.correoresponsable = correoresponsable;
	}

	 public java.lang.String getIdcatalogotipodocumentotecnico() {
		return idcatalogotipodocumentotecnico;
	}

	public void setIdcatalogotipodocumentotecnico(java.lang.String idcatalogotipodocumentotecnico) {
		this.idcatalogotipodocumentotecnico = idcatalogotipodocumentotecnico;
	}

	 public Gentabla getGentablaIdcatalogotipodocumentotecnico() {
		return gentablaIdcatalogotipodocumentotecnico;
	}

	public void setGentablaIdcatalogotipodocumentotecnico(Gentabla gentablaIdcatalogotipodocumentotecnico) {
		this.gentablaIdcatalogotipodocumentotecnico = gentablaIdcatalogotipodocumentotecnico;
	}

	 public java.lang.String getIdcatalogotipotdr() {
		return idcatalogotipotdr;
	}

	public void setIdcatalogotipotdr(java.lang.String idcatalogotipotdr) {
		this.idcatalogotipotdr = idcatalogotipotdr;
	}

	 public Gentabla getGentablaIdcatalogotipotdr() {
		return gentablaIdcatalogotipotdr;
	}

	public void setGentablaIdcatalogotipotdr(Gentabla gentablaIdcatalogotipotdr) {
		this.gentablaIdcatalogotipotdr = gentablaIdcatalogotipotdr;
	}

	 public java.lang.String getRutaanexo() {
		return rutaanexo;
	}

	public void setRutaanexo(java.lang.String rutaanexo) {
		this.rutaanexo = rutaanexo;
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

	 public java.lang.String getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(java.lang.String ubigeo) {
		this.ubigeo = ubigeo;
	}

	 public java.lang.String getDireccion() {
		return direccion;
	}

	public void setDireccion(java.lang.String direccion) {
		this.direccion = direccion;
	}

	 public java.lang.Integer getNumerosinad() {
		return numerosinad;
	}

	public void setNumerosinad(java.lang.Integer numerosinad) {
		this.numerosinad = numerosinad;
	}

	 public java.lang.Integer getAnioexpediente() {
		return anioexpediente;
	}

	public void setAnioexpediente(java.lang.Integer anioexpediente) {
		this.anioexpediente = anioexpediente;
	}

	 public java.lang.String getNumeroexpediente() {
		return numeroexpediente;
	}

	public void setNumeroexpediente(java.lang.String numeroexpediente) {
		this.numeroexpediente = numeroexpediente;
	}

	 public java.lang.String getTienecomite() {
		return tienecomite;
	}

	public void setTienecomite(java.lang.String tienecomite) {
		this.tienecomite = tienecomite;
	}

	 public Boolean getBooleantienecomite() {
		return booleantienecomite;
	}

	public void setBooleantienecomite(Boolean booleantienecomite) {
		this.booleantienecomite = booleantienecomite;
	}

	 public java.lang.String getTipoitinerario() {
		return tipoitinerario;
	}

	public void setTipoitinerario(java.lang.String tipoitinerario) {
		this.tipoitinerario = tipoitinerario;
	}

	 public java.lang.String getNropedidoitinerario() {
		return nropedidoitinerario;
	}

	public void setNropedidoitinerario(java.lang.String nropedidoitinerario) {
		this.nropedidoitinerario = nropedidoitinerario;
	}

	 public java.lang.Integer getAniopedidoitinerario() {
		return aniopedidoitinerario;
	}

	public void setAniopedidoitinerario(java.lang.Integer aniopedidoitinerario) {
		this.aniopedidoitinerario = aniopedidoitinerario;
	}

	 public java.lang.String getUepedidoitinerario() {
		return uepedidoitinerario;
	}

	public void setUepedidoitinerario(java.lang.String uepedidoitinerario) {
		this.uepedidoitinerario = uepedidoitinerario;
	}

	 public java.lang.String getJustificacionpedidoitinerario() {
		return justificacionpedidoitinerario;
	}

	public void setJustificacionpedidoitinerario(java.lang.String justificacionpedidoitinerario) {
		this.justificacionpedidoitinerario = justificacionpedidoitinerario;
	}

	 public java.lang.String getItinerarioorigenregistrado() {
		return itinerarioorigenregistrado;
	}

	public void setItinerarioorigenregistrado(java.lang.String itinerarioorigenregistrado) {
		this.itinerarioorigenregistrado = itinerarioorigenregistrado;
	}

	 public Boolean getBooleanitinerarioorigenregistrado() {
		return booleanitinerarioorigenregistrado;
	}

	public void setBooleanitinerarioorigenregistrado(Boolean booleanitinerarioorigenregistrado) {
		this.booleanitinerarioorigenregistrado = booleanitinerarioorigenregistrado;
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

	 public List<Plazopagodocumentotecnico> getListaPlazopagodocumentotecnico() {
		return listaPlazopagodocumentotecnico;
	}

	public void setListaPlazopagodocumentotecnico(List<Plazopagodocumentotecnico> listaPlazopagodocumentotecnico) {
		this.listaPlazopagodocumentotecnico = listaPlazopagodocumentotecnico;
	}

	 public List<Dependenciadocumentotecnico> getListaDependenciadocumentotecnico() {
		return listaDependenciadocumentotecnico;
	}

	public void setListaDependenciadocumentotecnico(List<Dependenciadocumentotecnico> listaDependenciadocumentotecnico) {
		this.listaDependenciadocumentotecnico = listaDependenciadocumentotecnico;
	}

	 public List<Itinerarioconveniomarco> getListaItinerarioconveniomarco() {
		return listaItinerarioconveniomarco;
	}

	public void setListaItinerarioconveniomarco(List<Itinerarioconveniomarco> listaItinerarioconveniomarco) {
		this.listaItinerarioconveniomarco = listaItinerarioconveniomarco;
	}

	 public List<Observacionesdocumentotecnico> getListaObservacionesdocumentotecnico() {
		return listaObservacionesdocumentotecnico;
	}

	public void setListaObservacionesdocumentotecnico(List<Observacionesdocumentotecnico> listaObservacionesdocumentotecnico) {
		this.listaObservacionesdocumentotecnico = listaObservacionesdocumentotecnico;
	}

}
