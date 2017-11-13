
package pe.com.sisabas.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.com.sisabas.resources.Utils;


/**[ItinerarioConvenioMarco]
*@author Gandalf
*@since 07/11/2017
*@version gandalf 4.0*/
public class Itinerarioconveniomarco extends SysTabla implements  Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/**[IdItinerarioConvenioMarco]*/
	private java.lang.Integer iditinerarioconveniomarco;
	/**[IdDocumentoTecnico]*/
	private java.lang.Integer iddocumentotecnico;
	private Documentotecnico documentotecnicoIddocumentotecnico;
	/**[TipoItinerario]*/
	private java.lang.String tipoitinerario;
	/**[CiudadOrigen]*/
	private java.lang.String ciudadorigen;
	/**[FechaSalida]*/
	private java.util.Date fechasalida;
	private java.util.Date fechasalidaini;
	private java.util.Date fechasalidafin;
	/**[HoraSalida]*/
	private java.util.Date horasalida;
	private java.util.Date horasalidaini;
	private java.util.Date horasalidafin;
	/**[CiudadDestino]*/
	private java.lang.String ciudaddestino;
	/**[FechaRetorno]*/
	private java.util.Date fechareterno;
	private java.util.Date fechareternoini;
	private java.util.Date fechareternofin;
	/**[HoraRetorno]*/
	private java.util.Date horaretorno;
	private java.util.Date horaretornoini;
	private java.util.Date horaretornofin;
	/**[DNI]*/
	private java.lang.String dni;
	/**[ApellidoPaterno]*/
	private java.lang.String apellidopaterno;
	/**[ApellidoMaterno]*/
	private java.lang.String apellidomaterno;
	/**[Nombers]*/
	private java.lang.String nombers;
	/**[Correo]*/
	private java.lang.String correo;
	/**[Telefono]*/
	private java.lang.String telefono;
	/**[TipoContratoPersonal]*/
	private java.lang.String tipocontratopersonal;
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

	public Itinerarioconveniomarco() {}

	public Itinerarioconveniomarco(java.lang.Integer iditinerarioconveniomarco) {
		this.iditinerarioconveniomarco=iditinerarioconveniomarco;
	 }

	@Override
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Itinerarioconveniomarco)
			return ((Itinerarioconveniomarco)obj).getIditinerarioconveniomarco().equals(this.getIditinerarioconveniomarco()) ;
		else
			return false;
	 }

	@Override
	public String toString(){
		 return ((this.iditinerarioconveniomarco!=null)?("iditinerarioconveniomarco:\t" + this.iditinerarioconveniomarco+"\n"):"" ).concat(
			(this.iddocumentotecnico!=null)?("iddocumentotecnico:\t" + this.iddocumentotecnico+"\n"):"" ).concat(
			(this.tipoitinerario!=null)?("tipoitinerario:\t" + this.tipoitinerario+"\n"):"" ).concat(
			(this.ciudadorigen!=null)?("ciudadorigen:\t" + this.ciudadorigen+"\n"):"" ).concat(
			(this.fechasalida!=null)?("fechasalida:\t" + this.fechasalida+"\n"):"" ).concat(
			(this.horasalida!=null)?("horasalida:\t" + this.horasalida+"\n"):"" ).concat(
			(this.ciudaddestino!=null)?("ciudaddestino:\t" + this.ciudaddestino+"\n"):"" ).concat(
			(this.fechareterno!=null)?("fechareterno:\t" + this.fechareterno+"\n"):"" ).concat(
			(this.horaretorno!=null)?("horaretorno:\t" + this.horaretorno+"\n"):"" ).concat(
			(this.dni!=null)?("dni:\t" + this.dni+"\n"):"" ).concat(
			(this.apellidopaterno!=null)?("apellidopaterno:\t" + this.apellidopaterno+"\n"):"" ).concat(
			(this.apellidomaterno!=null)?("apellidomaterno:\t" + this.apellidomaterno+"\n"):"" ).concat(
			(this.nombers!=null)?("nombers:\t" + this.nombers+"\n"):"" ).concat(
			(this.correo!=null)?("correo:\t" + this.correo+"\n"):"" ).concat(
			(this.telefono!=null)?("telefono:\t" + this.telefono+"\n"):"" ).concat(
			(this.tipocontratopersonal!=null)?("tipocontratopersonal:\t" + this.tipocontratopersonal+"\n"):"" ).concat(
			(this.usuariocreacionauditoria!=null)?("usuariocreacionauditoria:\t" + this.usuariocreacionauditoria+"\n"):"" ).concat(
			(this.fechamodificacionauditoria!=null)?("fechamodificacionauditoria:\t" + this.fechamodificacionauditoria+"\n"):"" ).concat(
			(this.usuariomodificacionauditoria!=null)?("usuariomodificacionauditoria:\t" + this.usuariomodificacionauditoria+"\n"):"" ).concat(
			(this.equipoauditoria!=null)?("equipoauditoria:\t" + this.equipoauditoria+"\n"):"" ).concat(
			(this.programaauditoria!=null)?("programaauditoria:\t" + this.programaauditoria+"\n"):"" ).concat(
			(this.estadoauditoria!=null)?("estadoauditoria:\t" + this.estadoauditoria+"\n"):"");
	 }

	public String toStringFull(){
		 return ((this.iditinerarioconveniomarco!=null)?("iditinerarioconveniomarco:\t" + this.iditinerarioconveniomarco+"\n"):"" ).concat(
			(this.iddocumentotecnico!=null)?("iddocumentotecnico:\t" + this.iddocumentotecnico+"\n"):"" ).concat(
			(this.documentotecnicoIddocumentotecnico!=null)?("documentotecnicoIddocumentotecnico:\t" + this.documentotecnicoIddocumentotecnico.toString()+"\n"):"" ).concat(
			(this.tipoitinerario!=null)?("tipoitinerario:\t" + this.tipoitinerario+"\n"):"" ).concat(
			(this.ciudadorigen!=null)?("ciudadorigen:\t" + this.ciudadorigen+"\n"):"" ).concat(
			(this.fechasalida!=null)?("fechasalida:\t" + this.fechasalida+"\n"):"" ).concat(
			(this.horasalida!=null)?("horasalida:\t" + this.horasalida+"\n"):"" ).concat(
			(this.ciudaddestino!=null)?("ciudaddestino:\t" + this.ciudaddestino+"\n"):"" ).concat(
			(this.fechareterno!=null)?("fechareterno:\t" + this.fechareterno+"\n"):"" ).concat(
			(this.horaretorno!=null)?("horaretorno:\t" + this.horaretorno+"\n"):"" ).concat(
			(this.dni!=null)?("dni:\t" + this.dni+"\n"):"" ).concat(
			(this.apellidopaterno!=null)?("apellidopaterno:\t" + this.apellidopaterno+"\n"):"" ).concat(
			(this.apellidomaterno!=null)?("apellidomaterno:\t" + this.apellidomaterno+"\n"):"" ).concat(
			(this.nombers!=null)?("nombers:\t" + this.nombers+"\n"):"" ).concat(
			(this.correo!=null)?("correo:\t" + this.correo+"\n"):"" ).concat(
			(this.telefono!=null)?("telefono:\t" + this.telefono+"\n"):"" ).concat(
			(this.tipocontratopersonal!=null)?("tipocontratopersonal:\t" + this.tipocontratopersonal+"\n"):"" ).concat(
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

	private List<java.lang.Integer> listaIddocumentotecnicoInKeys;
	public void addConditionInIddocumentotecnico(List<String> list){
		if(list==null || list.size()==0){
			iddocumentotecnico=null;
			listaIddocumentotecnicoInKeys=null;
			return;
		}
		if(list.size()==1){
			iddocumentotecnico=Integer.parseInt(list.get(0));
			listaIddocumentotecnicoInKeys=null;
		}else{
			iddocumentotecnico=null;
			listaIddocumentotecnicoInKeys=new ArrayList<java.lang.Integer>();
			for (String s : list) {
			listaIddocumentotecnicoInKeys.add(new java.lang.Integer(s));
			}
		}
	}
	 public List<java.lang.Integer> getListaIddocumentotecnicoInKeys() {
		return listaIddocumentotecnicoInKeys;
	}


	 public java.lang.Integer getIditinerarioconveniomarco() {
		return iditinerarioconveniomarco;
	}

	public void setIditinerarioconveniomarco(java.lang.Integer iditinerarioconveniomarco) {
		this.iditinerarioconveniomarco = iditinerarioconveniomarco;
	}

	 public java.lang.Integer getIddocumentotecnico() {
		return iddocumentotecnico;
	}

	public void setIddocumentotecnico(java.lang.Integer iddocumentotecnico) {
		this.iddocumentotecnico = iddocumentotecnico;
	}

	 public Documentotecnico getDocumentotecnicoIddocumentotecnico() {
		return documentotecnicoIddocumentotecnico;
	}

	public void setDocumentotecnicoIddocumentotecnico(Documentotecnico documentotecnicoIddocumentotecnico) {
		this.documentotecnicoIddocumentotecnico = documentotecnicoIddocumentotecnico;
	}

	 public java.lang.String getTipoitinerario() {
		return tipoitinerario;
	}

	public void setTipoitinerario(java.lang.String tipoitinerario) {
		this.tipoitinerario = tipoitinerario;
	}

	 public java.lang.String getCiudadorigen() {
		return ciudadorigen;
	}

	public void setCiudadorigen(java.lang.String ciudadorigen) {
		this.ciudadorigen = ciudadorigen;
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

	 public java.util.Date getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(java.util.Date horasalida) {
		this.horasalida = horasalida;
	}

	 public java.util.Date getHorasalidaini() {
		return horasalidaini;
	}

	public void setHorasalidaini(java.util.Date horasalidaini) {
		this.horasalidaini = horasalidaini;
	}

	 public java.util.Date getHorasalidafin() {
		return horasalidafin;
	}

	public void setHorasalidafin(java.util.Date horasalidafin) {
		this.horasalidafin = horasalidafin;
	}

	 public java.lang.String getCiudaddestino() {
		return ciudaddestino;
	}

	public void setCiudaddestino(java.lang.String ciudaddestino) {
		this.ciudaddestino = ciudaddestino;
	}

	 public java.util.Date getFechareterno() {
		return fechareterno;
	}

	public void setFechareterno(java.util.Date fechareterno) {
		this.fechareterno = fechareterno;
	}

	 public java.util.Date getFechareternoini() {
		return fechareternoini;
	}

	public void setFechareternoini(java.util.Date fechareternoini) {
		this.fechareternoini = fechareternoini;
	}

	 public java.util.Date getFechareternofin() {
		return fechareternofin;
	}

	public void setFechareternofin(java.util.Date fechareternofin) {
		this.fechareternofin = fechareternofin;
	}

	 public java.util.Date getHoraretorno() {
		return horaretorno;
	}

	public void setHoraretorno(java.util.Date horaretorno) {
		this.horaretorno = horaretorno;
	}

	 public java.util.Date getHoraretornoini() {
		return horaretornoini;
	}

	public void setHoraretornoini(java.util.Date horaretornoini) {
		this.horaretornoini = horaretornoini;
	}

	 public java.util.Date getHoraretornofin() {
		return horaretornofin;
	}

	public void setHoraretornofin(java.util.Date horaretornofin) {
		this.horaretornofin = horaretornofin;
	}

	 public java.lang.String getDni() {
		return dni;
	}

	public void setDni(java.lang.String dni) {
		this.dni = dni;
	}

	 public java.lang.String getApellidopaterno() {
		return apellidopaterno;
	}

	public void setApellidopaterno(java.lang.String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	 public java.lang.String getApellidomaterno() {
		return apellidomaterno;
	}

	public void setApellidomaterno(java.lang.String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	 public java.lang.String getNombers() {
		return nombers;
	}

	public void setNombers(java.lang.String nombers) {
		this.nombers = nombers;
	}

	 public java.lang.String getCorreo() {
		return correo;
	}

	public void setCorreo(java.lang.String correo) {
		this.correo = correo;
	}

	 public java.lang.String getTelefono() {
		return telefono;
	}

	public void setTelefono(java.lang.String telefono) {
		this.telefono = telefono;
	}

	 public java.lang.String getTipocontratopersonal() {
		return tipocontratopersonal;
	}

	public void setTipocontratopersonal(java.lang.String tipocontratopersonal) {
		this.tipocontratopersonal = tipocontratopersonal;
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
