
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[ResultadoProcesoSeleccion]
*@author Gandalf
*@since 30/01/2018
*@version gandalf 4.0*/
public class Resultadoprocesoseleccion extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idresultadoproceso;
	/**[ConvocatoriaProceso]*/
	private java.lang.Integer idconvocatoriaproceso;
	private Convocatoriaprocesoseleccion convocatoriaprocesoseleccionIdconvocatoriaproceso;
	/**[ResultadoProcesoPadre]*/
	private java.lang.Integer idresultadoprocesopadre;
	private Resultadoprocesoseleccion resultadoprocesoseleccionIdresultadoprocesopadre;
	/**[NroItem]*/
	private java.lang.String nroitem;
	/**[NombreItem]*/
	private java.lang.String nombreitem;
	/**[NroRuc]*/
	private java.lang.String nroruc;
	/**[NombreProveedor]*/
	private java.lang.String nombreproveedor;
	/**[Estado Resultado][EPRI]*/
	private java.lang.String idcatalogoestadoresultado;
	private Gentabla gentablaIdcatalogoestadoresultado;
	/**[Estado Proceso Item]*/
	private java.lang.Integer estadoprocesoitem;
	/**[Valor Referencial]*/
	private java.math.BigDecimal valorreferencial;
	private java.math.BigDecimal valorreferencialini;
	private java.math.BigDecimal valorreferencialfin;
	/**[Monto Adjudicado]*/
	private java.math.BigDecimal montoadjudicado;
	private java.math.BigDecimal montoadjudicadoini;
	private java.math.BigDecimal montoadjudicadofin;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario de Creacion]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][FechaModificacionAuditoria]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario de última modificacion]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][IP/Nombre Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa/Clase]*/
	private java.lang.String programaauditoria;
	/**[*][Estado Auditoria]*/
	private java.lang.String estadoauditoria;
	private List<Resultadoprocesoporusuario> listaResultadoprocesoporusuario;

	public Resultadoprocesoseleccion() {}

	public Resultadoprocesoseleccion(java.lang.Integer idresultadoproceso) {
		this.idresultadoproceso=idresultadoproceso;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Resultadoprocesoseleccion)
			return ((Resultadoprocesoseleccion)obj).getIdresultadoproceso().equals(this.getIdresultadoproceso()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idresultadoproceso!=null)?("idresultadoproceso:\t" + this.idresultadoproceso+"\n"):"" ).concat(
			(this.idconvocatoriaproceso!=null)?("idconvocatoriaproceso:\t" + this.idconvocatoriaproceso+"\n"):"" ).concat(
			(this.idresultadoprocesopadre!=null)?("idresultadoprocesopadre:\t" + this.idresultadoprocesopadre+"\n"):"" ).concat(
			(this.nroitem!=null)?("nroitem:\t" + this.nroitem+"\n"):"" ).concat(
			(this.nombreitem!=null)?("nombreitem:\t" + this.nombreitem+"\n"):"" ).concat(
			(this.nroruc!=null)?("nroruc:\t" + this.nroruc+"\n"):"" ).concat(
			(this.nombreproveedor!=null)?("nombreproveedor:\t" + this.nombreproveedor+"\n"):"" ).concat(
			(this.idcatalogoestadoresultado!=null)?("idcatalogoestadoresultado:\t" + this.idcatalogoestadoresultado+"\n"):"" ).concat(
			(this.estadoprocesoitem!=null)?("estadoprocesoitem:\t" + this.estadoprocesoitem+"\n"):"" ).concat(
			(this.valorreferencial!=null)?("valorreferencial:\t" + this.valorreferencial+"\n"):"" ).concat(
			(this.montoadjudicado!=null)?("montoadjudicado:\t" + this.montoadjudicado+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idresultadoproceso!=null)?("idresultadoproceso:\t" + this.idresultadoproceso+"\n"):"" ).concat(
			(this.idconvocatoriaproceso!=null)?("idconvocatoriaproceso:\t" + this.idconvocatoriaproceso+"\n"):"" ).concat(
			(this.convocatoriaprocesoseleccionIdconvocatoriaproceso!=null)?("convocatoriaprocesoseleccionIdconvocatoriaproceso:\t" + this.convocatoriaprocesoseleccionIdconvocatoriaproceso.toString()+"\n"):"" ).concat(
			(this.idresultadoprocesopadre!=null)?("idresultadoprocesopadre:\t" + this.idresultadoprocesopadre+"\n"):"" ).concat(
			(this.resultadoprocesoseleccionIdresultadoprocesopadre!=null)?("resultadoprocesoseleccionIdresultadoprocesopadre:\t" + this.resultadoprocesoseleccionIdresultadoprocesopadre.toString()+"\n"):"" ).concat(
			(this.nroitem!=null)?("nroitem:\t" + this.nroitem+"\n"):"" ).concat(
			(this.nombreitem!=null)?("nombreitem:\t" + this.nombreitem+"\n"):"" ).concat(
			(this.nroruc!=null)?("nroruc:\t" + this.nroruc+"\n"):"" ).concat(
			(this.nombreproveedor!=null)?("nombreproveedor:\t" + this.nombreproveedor+"\n"):"" ).concat(
			(this.idcatalogoestadoresultado!=null)?("idcatalogoestadoresultado:\t" + this.idcatalogoestadoresultado+"\n"):"" ).concat(
			(this.gentablaIdcatalogoestadoresultado!=null)?("gentablaIdcatalogoestadoresultado:\t" + this.gentablaIdcatalogoestadoresultado.toString()+"\n"):"" ).concat(
			(this.estadoprocesoitem!=null)?("estadoprocesoitem:\t" + this.estadoprocesoitem+"\n"):"" ).concat(
			(this.valorreferencial!=null)?("valorreferencial:\t" + this.valorreferencial+"\n"):"" ).concat(
			(this.montoadjudicado!=null)?("montoadjudicado:\t" + this.montoadjudicado+"\n"):"" ).concat(
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
		if(this.valorreferencial!=null)
			valorreferencial=Utils.round(valorreferencial);
		if(this.montoadjudicado!=null)
			montoadjudicado=Utils.round(montoadjudicado);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.Integer> listaIdconvocatoriaprocesoInKeys;
	public void addConditionInIdconvocatoriaproceso(List<String> list){
		if(list==null || list.size()==0){
			idconvocatoriaproceso=null;
			listaIdconvocatoriaprocesoInKeys=null;
			return;
		}
		if(list.size()==1){
			idconvocatoriaproceso=Integer.parseInt(list.get(0));
			listaIdconvocatoriaprocesoInKeys=null;
		}else{
			idconvocatoriaproceso=null;
			listaIdconvocatoriaprocesoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdconvocatoriaprocesoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdconvocatoriaprocesoInKeys() {
		return listaIdconvocatoriaprocesoInKeys;
	}

	private List<java.lang.Integer> listaIdresultadoprocesopadreInKeys;
	public void addConditionInIdresultadoprocesopadre(List<String> list){
		if(list==null || list.size()==0){
			idresultadoprocesopadre=null;
			listaIdresultadoprocesopadreInKeys=null;
			return;
		}
		if(list.size()==1){
			idresultadoprocesopadre=Integer.parseInt(list.get(0));
			listaIdresultadoprocesopadreInKeys=null;
		}else{
			idresultadoprocesopadre=null;
			listaIdresultadoprocesopadreInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdresultadoprocesopadreInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdresultadoprocesopadreInKeys() {
		return listaIdresultadoprocesopadreInKeys;
	}

	private List<java.lang.String> listaIdcatalogoestadoresultadoInKeys;
	public void addConditionInIdcatalogoestadoresultado(List<String> list){
		if(list==null || list.size()==0){
			idcatalogoestadoresultado=null;
			idcatalogoestadoresultado=null;
			listaIdcatalogoestadoresultadoInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogoestadoresultado=list.get(0);
			listaIdcatalogoestadoresultadoInKeys=null;
		}else{
			idcatalogoestadoresultado=null;
			listaIdcatalogoestadoresultadoInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogoestadoresultadoInKeys() {
		return listaIdcatalogoestadoresultadoInKeys;
	}


	 public java.lang.Integer getIdresultadoproceso() {
		return idresultadoproceso;
	}

	public void setIdresultadoproceso(java.lang.Integer idresultadoproceso) {
		this.idresultadoproceso = idresultadoproceso;
	}

	 public java.lang.Integer getIdconvocatoriaproceso() {
		return idconvocatoriaproceso;
	}

	public void setIdconvocatoriaproceso(java.lang.Integer idconvocatoriaproceso) {
		this.idconvocatoriaproceso = idconvocatoriaproceso;
	}

	 public Convocatoriaprocesoseleccion getConvocatoriaprocesoseleccionIdconvocatoriaproceso() {
		return convocatoriaprocesoseleccionIdconvocatoriaproceso;
	}

	public void setConvocatoriaprocesoseleccionIdconvocatoriaproceso(Convocatoriaprocesoseleccion convocatoriaprocesoseleccionIdconvocatoriaproceso) {
		this.convocatoriaprocesoseleccionIdconvocatoriaproceso = convocatoriaprocesoseleccionIdconvocatoriaproceso;
	}

	 public java.lang.Integer getIdresultadoprocesopadre() {
		return idresultadoprocesopadre;
	}

	public void setIdresultadoprocesopadre(java.lang.Integer idresultadoprocesopadre) {
		this.idresultadoprocesopadre = idresultadoprocesopadre;
	}

	 public Resultadoprocesoseleccion getResultadoprocesoseleccionIdresultadoprocesopadre() {
		return resultadoprocesoseleccionIdresultadoprocesopadre;
	}

	public void setResultadoprocesoseleccionIdresultadoprocesopadre(Resultadoprocesoseleccion resultadoprocesoseleccionIdresultadoprocesopadre) {
		this.resultadoprocesoseleccionIdresultadoprocesopadre = resultadoprocesoseleccionIdresultadoprocesopadre;
	}

	 public java.lang.String getNroitem() {
		return nroitem;
	}

	public void setNroitem(java.lang.String nroitem) {
		this.nroitem = nroitem;
	}

	 public java.lang.String getNombreitem() {
		return nombreitem;
	}

	public void setNombreitem(java.lang.String nombreitem) {
		this.nombreitem = nombreitem;
	}

	 public java.lang.String getNroruc() {
		return nroruc;
	}

	public void setNroruc(java.lang.String nroruc) {
		this.nroruc = nroruc;
	}

	 public java.lang.String getNombreproveedor() {
		return nombreproveedor;
	}

	public void setNombreproveedor(java.lang.String nombreproveedor) {
		this.nombreproveedor = nombreproveedor;
	}

	 public java.lang.String getIdcatalogoestadoresultado() {
		return idcatalogoestadoresultado;
	}

	public void setIdcatalogoestadoresultado(java.lang.String idcatalogoestadoresultado) {
		this.idcatalogoestadoresultado = idcatalogoestadoresultado;
	}

	 public Gentabla getGentablaIdcatalogoestadoresultado() {
		return gentablaIdcatalogoestadoresultado;
	}

	public void setGentablaIdcatalogoestadoresultado(Gentabla gentablaIdcatalogoestadoresultado) {
		this.gentablaIdcatalogoestadoresultado = gentablaIdcatalogoestadoresultado;
	}

	 public java.lang.Integer getEstadoprocesoitem() {
		return estadoprocesoitem;
	}

	public void setEstadoprocesoitem(java.lang.Integer estadoprocesoitem) {
		this.estadoprocesoitem = estadoprocesoitem;
	}

	 public java.math.BigDecimal getValorreferencial() {
		return valorreferencial;
	}

	public void setValorreferencial(java.math.BigDecimal valorreferencial) {
		this.valorreferencial = valorreferencial;
	}

	 public java.math.BigDecimal getValorreferencialini() {
		return valorreferencialini;
	}

	public void setValorreferencialini(java.math.BigDecimal valorreferencialini) {
		this.valorreferencialini = valorreferencialini;
	}

	 public java.math.BigDecimal getValorreferencialfin() {
		return valorreferencialfin;
	}

	public void setValorreferencialfin(java.math.BigDecimal valorreferencialfin) {
		this.valorreferencialfin = valorreferencialfin;
	}

	 public java.math.BigDecimal getMontoadjudicado() {
		return montoadjudicado;
	}

	public void setMontoadjudicado(java.math.BigDecimal montoadjudicado) {
		this.montoadjudicado = montoadjudicado;
	}

	 public java.math.BigDecimal getMontoadjudicadoini() {
		return montoadjudicadoini;
	}

	public void setMontoadjudicadoini(java.math.BigDecimal montoadjudicadoini) {
		this.montoadjudicadoini = montoadjudicadoini;
	}

	 public java.math.BigDecimal getMontoadjudicadofin() {
		return montoadjudicadofin;
	}

	public void setMontoadjudicadofin(java.math.BigDecimal montoadjudicadofin) {
		this.montoadjudicadofin = montoadjudicadofin;
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

	 public List<Resultadoprocesoporusuario> getListaResultadoprocesoporusuario() {
		return listaResultadoprocesoporusuario;
	}

	public void setListaResultadoprocesoporusuario(List<Resultadoprocesoporusuario> listaResultadoprocesoporusuario) {
		this.listaResultadoprocesoporusuario = listaResultadoprocesoporusuario;
	}

}
