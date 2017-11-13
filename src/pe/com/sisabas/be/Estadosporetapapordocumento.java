
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[Estados por etapa por documento]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Estadosporetapapordocumento extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[ID]*/
	private java.lang.Integer idestadosporetapapordocumento;
	/**[Estados Por Tipo Documento]*/
	private java.lang.Integer idestadosportipodocumento;
	private Estadosportipodocumento estadosportipodocumentoIdestadosportipodocumento;
	/**[Grupo Documento]*/
	private java.lang.Integer idgrupodocumento;
	private Grupodocumento grupodocumentoIdgrupodocumento;
	/**[Documento]*/
	private java.lang.Integer nrodocumento;
	/**[Fecha Ingreso]*/
	private java.util.Date fechaingreso;
	private java.util.Date fechaingresoini;
	private java.util.Date fechaingresofin;
	/**[Fecha Salida]*/
	private java.util.Date fechasalida;
	private java.util.Date fechasalidaini;
	private java.util.Date fechasalidafin;
	/**[Usuario Responsable Ingreso]*/
	private java.lang.Long usuarioresponsableingreso;
	/**[Usuario Responsable Salida]*/
	private java.lang.Long usuarioresponsablesalida;
	/**[Id Tipo Documento]*/
	private java.lang.Integer idtipodocumento;
	private Tipodocumento tipodocumentoIdtipodocumento;
	/**[*][Fecha de Creación]*/
	private java.util.Date fechacreacionauditoria;
	private java.util.Date fechacreacionauditoriaini;
	private java.util.Date fechacreacionauditoriafin;
	/**[*][Usuario Creacion]*/
	private java.lang.String usuariocreacionauditoria;
	/**[*][Fecha de última modificacion]*/
	private java.util.Date fechamodificacionauditoria;
	private java.util.Date fechamodificacionauditoriaini;
	private java.util.Date fechamodificacionauditoriafin;
	/**[*][Usuario de última modificacion]*/
	private java.lang.String usuariomodificacionauditoria;
	/**[*][IP/Nombre Equipo]*/
	private java.lang.String equipoauditoria;
	/**[*][Programa/Clase]*/
	private java.lang.String programaauditoria;
	/**[*][EstadoAuditoria]*/
	private java.lang.String estadoauditoria;

	public Estadosporetapapordocumento() {}

	public Estadosporetapapordocumento(java.lang.Integer idestadosporetapapordocumento) {
		this.idestadosporetapapordocumento=idestadosporetapapordocumento;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Estadosporetapapordocumento)
			return ((Estadosporetapapordocumento)obj).getIdestadosporetapapordocumento().equals(this.getIdestadosporetapapordocumento()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.idestadosporetapapordocumento!=null)?("idestadosporetapapordocumento:\t" + this.idestadosporetapapordocumento+"\n"):"" ).concat(
			(this.idestadosportipodocumento!=null)?("idestadosportipodocumento:\t" + this.idestadosportipodocumento+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.nrodocumento!=null)?("nrodocumento:\t" + this.nrodocumento+"\n"):"" ).concat(
			(this.fechaingreso!=null)?("fechaingreso:\t" + this.fechaingreso+"\n"):"" ).concat(
			(this.fechasalida!=null)?("fechasalida:\t" + this.fechasalida+"\n"):"" ).concat(
			(this.usuarioresponsableingreso!=null)?("usuarioresponsableingreso:\t" + this.usuarioresponsableingreso+"\n"):"" ).concat(
			(this.usuarioresponsablesalida!=null)?("usuarioresponsablesalida:\t" + this.usuarioresponsablesalida+"\n"):"" ).concat(
			(this.idtipodocumento!=null)?("idtipodocumento:\t" + this.idtipodocumento+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.idestadosporetapapordocumento!=null)?("idestadosporetapapordocumento:\t" + this.idestadosporetapapordocumento+"\n"):"" ).concat(
			(this.idestadosportipodocumento!=null)?("idestadosportipodocumento:\t" + this.idestadosportipodocumento+"\n"):"" ).concat(
			(this.estadosportipodocumentoIdestadosportipodocumento!=null)?("estadosportipodocumentoIdestadosportipodocumento:\t" + this.estadosportipodocumentoIdestadosportipodocumento.toString()+"\n"):"" ).concat(
			(this.idgrupodocumento!=null)?("idgrupodocumento:\t" + this.idgrupodocumento+"\n"):"" ).concat(
			(this.grupodocumentoIdgrupodocumento!=null)?("grupodocumentoIdgrupodocumento:\t" + this.grupodocumentoIdgrupodocumento.toString()+"\n"):"" ).concat(
			(this.nrodocumento!=null)?("nrodocumento:\t" + this.nrodocumento+"\n"):"" ).concat(
			(this.fechaingreso!=null)?("fechaingreso:\t" + this.fechaingreso+"\n"):"" ).concat(
			(this.fechasalida!=null)?("fechasalida:\t" + this.fechasalida+"\n"):"" ).concat(
			(this.usuarioresponsableingreso!=null)?("usuarioresponsableingreso:\t" + this.usuarioresponsableingreso+"\n"):"" ).concat(
			(this.usuarioresponsablesalida!=null)?("usuarioresponsablesalida:\t" + this.usuarioresponsablesalida+"\n"):"" ).concat(
			(this.idtipodocumento!=null)?("idtipodocumento:\t" + this.idtipodocumento+"\n"):"" ).concat(
			(this.tipodocumentoIdtipodocumento!=null)?("tipodocumentoIdtipodocumento:\t" + this.tipodocumentoIdtipodocumento.toString()+"\n"):"" ).concat(
			(this.fechacreacionauditoria!=null)?("fechacreacionauditoria:\t" + this.fechacreacionauditoria+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIdestadosportipodocumentoInKeys;
	public void addConditionInIdestadosportipodocumento(List<String> list){
		if(list==null || list.size()==0){
			idestadosportipodocumento=null;
			listaIdestadosportipodocumentoInKeys=null;
			return;
		}
		if(list.size()==1){
			idestadosportipodocumento=Integer.parseInt(list.get(0));
			listaIdestadosportipodocumentoInKeys=null;
		}else{
			idestadosportipodocumento=null;
			listaIdestadosportipodocumentoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdestadosportipodocumentoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdestadosportipodocumentoInKeys() {
		return listaIdestadosportipodocumentoInKeys;
	}

	private List<java.lang.Integer> listaIdgrupodocumentoInKeys;
	public void addConditionInIdgrupodocumento(List<String> list){
		if(list==null || list.size()==0){
			idgrupodocumento=null;
			listaIdgrupodocumentoInKeys=null;
			return;
		}
		if(list.size()==1){
			idgrupodocumento=Integer.parseInt(list.get(0));
			listaIdgrupodocumentoInKeys=null;
		}else{
			idgrupodocumento=null;
			listaIdgrupodocumentoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdgrupodocumentoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdgrupodocumentoInKeys() {
		return listaIdgrupodocumentoInKeys;
	}

	private List<java.lang.Integer> listaIdtipodocumentoInKeys;
	public void addConditionInIdtipodocumento(List<String> list){
		if(list==null || list.size()==0){
			idtipodocumento=null;
			listaIdtipodocumentoInKeys=null;
			return;
		}
		if(list.size()==1){
			idtipodocumento=Integer.parseInt(list.get(0));
			listaIdtipodocumentoInKeys=null;
		}else{
			idtipodocumento=null;
			listaIdtipodocumentoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIdtipodocumentoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIdtipodocumentoInKeys() {
		return listaIdtipodocumentoInKeys;
	}


	 public java.lang.Integer getIdestadosporetapapordocumento() {
		return idestadosporetapapordocumento;
	}

	public void setIdestadosporetapapordocumento(java.lang.Integer idestadosporetapapordocumento) {
		this.idestadosporetapapordocumento = idestadosporetapapordocumento;
	}

	 public java.lang.Integer getIdestadosportipodocumento() {
		return idestadosportipodocumento;
	}

	public void setIdestadosportipodocumento(java.lang.Integer idestadosportipodocumento) {
		this.idestadosportipodocumento = idestadosportipodocumento;
	}

	 public Estadosportipodocumento getEstadosportipodocumentoIdestadosportipodocumento() {
		return estadosportipodocumentoIdestadosportipodocumento;
	}

	public void setEstadosportipodocumentoIdestadosportipodocumento(Estadosportipodocumento estadosportipodocumentoIdestadosportipodocumento) {
		this.estadosportipodocumentoIdestadosportipodocumento = estadosportipodocumentoIdestadosportipodocumento;
	}

	 public java.lang.Integer getIdgrupodocumento() {
		return idgrupodocumento;
	}

	public void setIdgrupodocumento(java.lang.Integer idgrupodocumento) {
		this.idgrupodocumento = idgrupodocumento;
	}

	 public Grupodocumento getGrupodocumentoIdgrupodocumento() {
		return grupodocumentoIdgrupodocumento;
	}

	public void setGrupodocumentoIdgrupodocumento(Grupodocumento grupodocumentoIdgrupodocumento) {
		this.grupodocumentoIdgrupodocumento = grupodocumentoIdgrupodocumento;
	}

	 public java.lang.Integer getNrodocumento() {
		return nrodocumento;
	}

	public void setNrodocumento(java.lang.Integer nrodocumento) {
		this.nrodocumento = nrodocumento;
	}

	 public java.util.Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(java.util.Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	 public java.util.Date getFechaingresoini() {
		return fechaingresoini;
	}

	public void setFechaingresoini(java.util.Date fechaingresoini) {
		this.fechaingresoini = fechaingresoini;
	}

	 public java.util.Date getFechaingresofin() {
		return fechaingresofin;
	}

	public void setFechaingresofin(java.util.Date fechaingresofin) {
		this.fechaingresofin = fechaingresofin;
	}

	 public java.util.Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(java.util.Date fechasalida) {
		this.fechasalida = fechasalida;
	}

	 public java.util.Date getFechasalidaini() {
		return fechasalidaini;
	}

	public void setFechasalidaini(java.util.Date fechasalidaini) {
		this.fechasalidaini = fechasalidaini;
	}

	 public java.util.Date getFechasalidafin() {
		return fechasalidafin;
	}

	public void setFechasalidafin(java.util.Date fechasalidafin) {
		this.fechasalidafin = fechasalidafin;
	}

	 public java.lang.Long getUsuarioresponsableingreso() {
		return usuarioresponsableingreso;
	}

	public void setUsuarioresponsableingreso(java.lang.Long usuarioresponsableingreso) {
		this.usuarioresponsableingreso = usuarioresponsableingreso;
	}

	 public java.lang.Long getUsuarioresponsablesalida() {
		return usuarioresponsablesalida;
	}

	public void setUsuarioresponsablesalida(java.lang.Long usuarioresponsablesalida) {
		this.usuarioresponsablesalida = usuarioresponsablesalida;
	}

	 public java.lang.Integer getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(java.lang.Integer idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	 public Tipodocumento getTipodocumentoIdtipodocumento() {
		return tipodocumentoIdtipodocumento;
	}

	public void setTipodocumentoIdtipodocumento(Tipodocumento tipodocumentoIdtipodocumento) {
		this.tipodocumentoIdtipodocumento = tipodocumentoIdtipodocumento;
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
