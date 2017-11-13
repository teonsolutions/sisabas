
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[CuadroComparativoVR]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Cuadrocomparativovr extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[IdCuadroComparativoVR]*/
	private java.lang.Integer idcuadrocomparativovr;
	/**[IdCuadroComparativoItem]*/
	private java.lang.Integer idcuadrocomparativoitem;
	private Cuadrocomparativoitem cuadrocomparativoitemIdcuadrocomparativoitem;
	/**[IdCatalogoProcedimientoVR][PRVR]*/
	private java.lang.String idcatalogoprocedimientovr;
	private Gentabla gentablaIdcatalogoprocedimientovr;
	/**[ValorReferencialItem]*/
	private java.math.BigDecimal valorreferencialitem;
	private java.math.BigDecimal valorreferencialitemini;
	private java.math.BigDecimal valorreferencialitemfin;
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

	public Cuadrocomparativovr() {}

	public Cuadrocomparativovr(java.lang.Integer idcuadrocomparativovr) {
		this.idcuadrocomparativovr=idcuadrocomparativovr;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Cuadrocomparativovr)
			return ((Cuadrocomparativovr)obj).getIdcuadrocomparativovr().equals(this.getIdcuadrocomparativovr()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idcuadrocomparativovr!=null)?("idcuadrocomparativovr:\t" + this.idcuadrocomparativovr+"\n"):"" ).concat(
			(this.idcuadrocomparativoitem!=null)?("idcuadrocomparativoitem:\t" + this.idcuadrocomparativoitem+"\n"):"" ).concat(
			(this.idcatalogoprocedimientovr!=null)?("idcatalogoprocedimientovr:\t" + this.idcatalogoprocedimientovr+"\n"):"" ).concat(
			(this.valorreferencialitem!=null)?("valorreferencialitem:\t" + this.valorreferencialitem+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idcuadrocomparativovr!=null)?("idcuadrocomparativovr:\t" + this.idcuadrocomparativovr+"\n"):"" ).concat(
			(this.idcuadrocomparativoitem!=null)?("idcuadrocomparativoitem:\t" + this.idcuadrocomparativoitem+"\n"):"" ).concat(
			(this.cuadrocomparativoitemIdcuadrocomparativoitem!=null)?("cuadrocomparativoitemIdcuadrocomparativoitem:\t" + this.cuadrocomparativoitemIdcuadrocomparativoitem.toString()+"\n"):"" ).concat(
			(this.idcatalogoprocedimientovr!=null)?("idcatalogoprocedimientovr:\t" + this.idcatalogoprocedimientovr+"\n"):"" ).concat(
			(this.gentablaIdcatalogoprocedimientovr!=null)?("gentablaIdcatalogoprocedimientovr:\t" + this.gentablaIdcatalogoprocedimientovr.toString()+"\n"):"" ).concat(
			(this.valorreferencialitem!=null)?("valorreferencialitem:\t" + this.valorreferencialitem+"\n"):"" ).concat(
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
		if(this.valorreferencialitem!=null)
			valorreferencialitem=Utils.round(valorreferencialitem);

	 }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }

	private List<java.lang.Integer> listaIdcuadrocomparativoitemInKeys;
	public void addConditionInIdcuadrocomparativoitem(List<String> list){
		if(list==null || list.size()==0){
			idcuadrocomparativoitem=null;
			listaIdcuadrocomparativoitemInKeys=null;
			return;
		}
		if(list.size()==1){
			idcuadrocomparativoitem=Integer.parseInt(list.get(0));
			listaIdcuadrocomparativoitemInKeys=null;
		}else{
			idcuadrocomparativoitem=null;
			listaIdcuadrocomparativoitemInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdcuadrocomparativoitemInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdcuadrocomparativoitemInKeys() {
		return listaIdcuadrocomparativoitemInKeys;
	}

	private List<java.lang.String> listaIdcatalogoprocedimientovrInKeys;
	public void addConditionInIdcatalogoprocedimientovr(List<String> list){
		if(list==null || list.size()==0){
			idcatalogoprocedimientovr=null;
			idcatalogoprocedimientovr=null;
			listaIdcatalogoprocedimientovrInKeys=null;
			return;
		}
		if(list.size()==1){
			idcatalogoprocedimientovr=list.get(0);
			listaIdcatalogoprocedimientovrInKeys=null;
		}else{
			idcatalogoprocedimientovr=null;
			listaIdcatalogoprocedimientovrInKeys=list;
		}
	}
	 public List<java.lang.String> getListaIdcatalogoprocedimientovrInKeys() {
		return listaIdcatalogoprocedimientovrInKeys;
	}


	 public java.lang.Integer getIdcuadrocomparativovr() {
		return idcuadrocomparativovr;
	}

	public void setIdcuadrocomparativovr(java.lang.Integer idcuadrocomparativovr) {
		this.idcuadrocomparativovr = idcuadrocomparativovr;
	}

	 public java.lang.Integer getIdcuadrocomparativoitem() {
		return idcuadrocomparativoitem;
	}

	public void setIdcuadrocomparativoitem(java.lang.Integer idcuadrocomparativoitem) {
		this.idcuadrocomparativoitem = idcuadrocomparativoitem;
	}

	 public Cuadrocomparativoitem getCuadrocomparativoitemIdcuadrocomparativoitem() {
		return cuadrocomparativoitemIdcuadrocomparativoitem;
	}

	public void setCuadrocomparativoitemIdcuadrocomparativoitem(Cuadrocomparativoitem cuadrocomparativoitemIdcuadrocomparativoitem) {
		this.cuadrocomparativoitemIdcuadrocomparativoitem = cuadrocomparativoitemIdcuadrocomparativoitem;
	}

	 public java.lang.String getIdcatalogoprocedimientovr() {
		return idcatalogoprocedimientovr;
	}

	public void setIdcatalogoprocedimientovr(java.lang.String idcatalogoprocedimientovr) {
		this.idcatalogoprocedimientovr = idcatalogoprocedimientovr;
	}

	 public Gentabla getGentablaIdcatalogoprocedimientovr() {
		return gentablaIdcatalogoprocedimientovr;
	}

	public void setGentablaIdcatalogoprocedimientovr(Gentabla gentablaIdcatalogoprocedimientovr) {
		this.gentablaIdcatalogoprocedimientovr = gentablaIdcatalogoprocedimientovr;
	}

	 public java.math.BigDecimal getValorreferencialitem() {
		return valorreferencialitem;
	}

	public void setValorreferencialitem(java.math.BigDecimal valorreferencialitem) {
		this.valorreferencialitem = valorreferencialitem;
	}

	 public java.math.BigDecimal getValorreferencialitemini() {
		return valorreferencialitemini;
	}

	public void setValorreferencialitemini(java.math.BigDecimal valorreferencialitemini) {
		this.valorreferencialitemini = valorreferencialitemini;
	}

	 public java.math.BigDecimal getValorreferencialitemfin() {
		return valorreferencialitemfin;
	}

	public void setValorreferencialitemfin(java.math.BigDecimal valorreferencialitemfin) {
		this.valorreferencialitemfin = valorreferencialitemfin;
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
