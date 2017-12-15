
package pe.com.sisabas.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.dao.DataIntegrityViolationException;

import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.UnselectedRowException;
import pe.com.sisabas.exception.ValidateException;

import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.service.SicuCallService;
import java.rmi.RemoteException;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.be.Pacprogramado;
import pe.com.sisabas.business.PacprogramadoBusiness;
import pe.com.sisabas.be.Unidadejecutora;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;



@Component(value ="pacprogramado")
@Scope(value = "session")
public class PacprogramadoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Pacprogramado pacprogramadoB;
	private Pacprogramado pacprogramado;
	private Pacprogramado selectedPacprogramado;
	private List<Pacprogramado> listaPacprogramado;
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<Gentabla> listaGentablaIdcatalogoestado;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public PacprogramadoBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_PACPROGRAMADO";
	public PacprogramadoController(){
			pacprogramado = new Pacprogramado();
			pacprogramado.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());

	}


	@PostConstruct
	public void init(){
		try {
			pacprogramadoB = new Pacprogramado();
			tituloBase = "PacProgramado » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			pacprogramadoB.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());

			listaIdcatalogotipobienKeys= new ArrayList<String>();
			listaIdcatalogoestadoKeys= new ArrayList<String>();

			listaGentablaIdcatalogotipobien = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaGentablaIdcatalogoestado = gentablaBusiness.selectDynamicBasic(new Gentabla());

		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm",e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			List<String> ordenListaCampos = Arrays.asList("A1.nroconsolid");
			pacprogramadoB.setOrdenListaCampos(ordenListaCampos);
			pacprogramadoB.setOrdenTipo("DESC");

			//Add conditions IN clause
			pacprogramadoB.addConditionInIdcatalogotipobien(listaIdcatalogotipobienKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(pacprogramadoB); //pasa a mayusculas los datos para la busqueda
			listaPacprogramado = business.selectDynamicFull(pacprogramadoB);
			setEsSeleccionado(false);
			setSelectedPacprogramado(null);
			if (listaPacprogramado.size() == 0)
			addMessageKey("msgsForm",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void irRegistrar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnNuevo");
			resetRegisterForm();
			accion = REGISTRAR;
			titulo = "PacProgramado » " + REGISTRAR;
			pacprogramado = new Pacprogramado();


			pacprogramado.setIdpacprogramado(new java.lang.Integer(0));
			pacprogramado.setIdpacprogramado((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_PACPROGRAMADO).longValue());
			pacprogramado.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());


			STATUS_SUCCESS();
			REGISTER_INIT();
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(pacprogramado);
			pacprogramado.roundBigDecimals();
			accion = EDITAR;
			titulo = "PacProgramado » " + EDITAR;


			STATUS_SUCCESS();
			REGISTER_INIT();
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void irEliminar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEliminar");
			validateSelectedRow();

			STATUS_SUCCESS();
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void irDetalle() {
		STATUS_INIT();
		
		try {
			securityControlValidate("btnDetalle");
			validateSelectedRow();
			pacprogramado.roundBigDecimals();
			accion = DETALLE;
			titulo = "PacProgramado » " + DETALLE;

			STATUS_SUCCESS();
			
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void irImprimir() {
		STATUS_INIT();
		try {
			securityControlValidate("btnImprimir");
			//resetRegisterForm();
			accion = IMPRIMIR;
			titulo = "PacProgramado » " + IMPRIMIR;

			STATUS_SUCCESS();
			REGISTER_INIT();
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void irAnular() {
		STATUS_INIT();
		try {
			securityControlValidate("btnAnularActivar");
			//resetRegisterForm();
			resetAnulacionForm();
			validateSelectedRow();
			if(pacprogramado.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "PacProgramado » " + accion;

			STATUS_SUCCESS();
			REGISTER_INIT();
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void anular() {
		try {
			Pacprogramado record= new Pacprogramado();
			if(pacprogramado.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdpacprogramado(pacprogramado.getIdpacprogramado());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPacprogramadoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPacprogramadoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPacprogramadoA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			pacprogramado.setGentablaIdcatalogotipobien(gentablaBusiness.selectByPrimaryKeyBasicFromList(pacprogramado.getIdcatalogotipobien(),listaGentablaIdcatalogotipobien));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				pacprogramado.setUsuariocreacionauditoria(getUserLogin());
				pacprogramado.setEquipoauditoria(getRemoteAddr());
				pacprogramado.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(pacprogramado);
			}else{
				pacprogramado.setUsuariomodificacionauditoria(getUserLogin());
				pacprogramado.setEquipoauditoria(getRemoteAddr());
				pacprogramado.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(pacprogramado);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPacprogramadoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPacprogramadoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPacprogramadoR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			pacprogramado.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(pacprogramado);
			showGrowlMessageSuccessfullyCompletedAction();
			buscar();
		} catch (ValidateException e) {
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void validateSelectedRow() throws UnselectedRowException, CloneNotSupportedException {
		if (selectedPacprogramado == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			pacprogramado = (Pacprogramado)selectedPacprogramado.clone();
	}

	public void makeFile() {
		try {
			File fileTMP = new File("D://temp/reporte.txt");
			InputStream stream = new FileInputStream(fileTMP);
			this.file = new DefaultStreamedContent(stream, "application/text",
			"reporte.txt");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadMainIdunidadejecutora(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainUnidadejecutora.event...");
			pe.com.sisabas.be.Unidadejecutora item= (pe.com.sisabas.be.Unidadejecutora) event.getObject();
			logger.debug("loadpacprogramado.event...:"+item.getIdunidadejecutora());
			pacprogramadoB.setIdunidadejecutora(item.getIdunidadejecutora());
			pacprogramadoB.setUnidadejecutoraIdunidadejecutora(item);
			logger.debug("loadUnidadejecutora.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdunidadejecutora(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegUnidadejecutora.event...");
			pe.com.sisabas.be.Unidadejecutora item= (pe.com.sisabas.be.Unidadejecutora) event.getObject();
			logger.debug("loadpacprogramado.event...:"+item.getIdunidadejecutora());
			pacprogramado.setIdunidadejecutora(item.getIdunidadejecutora());
			pacprogramado.setUnidadejecutoraIdunidadejecutora(item);
			logger.debug("loadUnidadejecutora.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdunidadejecutora() {
		try {
			pacprogramadoB.setIdunidadejecutora(null);
			pacprogramadoB.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdunidadejecutora() {
		try {
			pacprogramado.setIdunidadejecutora(null);
			pacprogramado.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/pacprogramado/pacprogramadoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmPacprogramadoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmPacprogramadoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Pacprogramado record) throws Exception {
	}

	public void setPacprogramado(Pacprogramado pacprogramado){
		this.pacprogramado=pacprogramado;
	}

	public Pacprogramado getPacprogramado(){
		return pacprogramado;
	}

	public void setPacprogramadoB(Pacprogramado pacprogramadoB){
		this.pacprogramadoB = pacprogramadoB;
	}

	public Pacprogramado getPacprogramadoB(){
		return pacprogramadoB;
	}

	public void setSelectedPacprogramado(Pacprogramado selectedPacprogramado){
		this.selectedPacprogramado = selectedPacprogramado;
	}

	public Pacprogramado getSelectedPacprogramado(){
		return selectedPacprogramado;
	}

	public void setListaPacprogramado(List<Pacprogramado> listaPacprogramado){
		this.listaPacprogramado=listaPacprogramado;
	}

	public List<Pacprogramado> getListaPacprogramado(){
		return listaPacprogramado;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getAccion() {
		return accion;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public StreamedContent getFile() {
		return file;
	}

	public String getEsDerivada() {
		return esDerivada;
	}

	public void setEsDerivada(String esDerivada) {
		this.esDerivada = esDerivada;
	}

	public String getTituloBase() {
		return tituloBase;
	}

	public void setTituloBase(String tituloBase) {
		this.tituloBase = tituloBase;
	}

	public String getTituloParam() {
		return tituloParam;
	}

	public void setTituloParam(String tituloParam) {
		this.tituloParam = tituloParam;
	}

	public void setListaGentablaIdcatalogotipobien(List<Gentabla> listaGentablaIdcatalogotipobien){
		this.listaGentablaIdcatalogotipobien=listaGentablaIdcatalogotipobien;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipobien(){
		return listaGentablaIdcatalogotipobien;
	}

	public void setListaGentablaIdcatalogoestado(List<Gentabla> listaGentablaIdcatalogoestado){
		this.listaGentablaIdcatalogoestado=listaGentablaIdcatalogoestado;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestado(){
		return listaGentablaIdcatalogoestado;
	}


	private List<String> listaIdcatalogotipobienKeys;
	private String valuesIdcatalogotipobien;
	public void handleChangeIdcatalogotipobien(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogotipobien();
		}else{
			listaIdcatalogotipobienKeys=new ArrayList<String>();
			valuesIdcatalogotipobien=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogotipobien(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogotipobienKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogotipobien) {
			listaIdcatalogotipobienKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogotipobien=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogotipobien(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogotipobienKeys) {
			sbTmp.append(getValueIdcatalogotipobien(key)+", ");
		}
		valuesIdcatalogotipobien=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogotipobienKeys.size()==0)
			valuesIdcatalogotipobien=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogotipobien(String key){
		for (Gentabla s : listaGentablaIdcatalogotipobien) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogotipobienKeys() {
		return listaIdcatalogotipobienKeys;
	}

	public void setListaIdcatalogotipobienKeys(List<String> listaIdcatalogotipobienKeys) {
		this.listaIdcatalogotipobienKeys = listaIdcatalogotipobienKeys;
	}

	 public String getValuesIdcatalogotipobien() {
		return valuesIdcatalogotipobien;
	}

	public void setValuesIdcatalogotipobien(String valuesIdcatalogotipobien) {
		this.valuesIdcatalogotipobien = valuesIdcatalogotipobien;
	}

///////////////////////////////

	private List<String> listaIdcatalogoestadoKeys;
	private String valuesIdcatalogoestado;
	public void handleChangeIdcatalogoestado(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogoestado();
		}else{
			listaIdcatalogoestadoKeys=new ArrayList<String>();
			valuesIdcatalogoestado=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogoestado(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogoestadoKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogoestado) {
			listaIdcatalogoestadoKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogoestado=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogoestado(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogoestadoKeys) {
			sbTmp.append(getValueIdcatalogoestado(key)+", ");
		}
		valuesIdcatalogoestado=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogoestadoKeys.size()==0)
			valuesIdcatalogoestado=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogoestado(String key){
		for (Gentabla s : listaGentablaIdcatalogoestado) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogoestadoKeys() {
		return listaIdcatalogoestadoKeys;
	}

	public void setListaIdcatalogoestadoKeys(List<String> listaIdcatalogoestadoKeys) {
		this.listaIdcatalogoestadoKeys = listaIdcatalogoestadoKeys;
	}

	 public String getValuesIdcatalogoestado() {
		return valuesIdcatalogoestado;
	}

	public void setValuesIdcatalogoestado(String valuesIdcatalogoestado) {
		this.valuesIdcatalogoestado = valuesIdcatalogoestado;
	}

///////////////////////////////



}

