
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
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.business.MiembrocomiteporprocesoBusiness;
import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Persona;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;



@Component(value ="miembrocomiteporproceso")
@Scope(value = "session")
public class MiembrocomiteporprocesoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Miembrocomiteporproceso miembrocomiteporprocesoB;
	private Miembrocomiteporproceso miembrocomiteporproceso;
	private Miembrocomiteporproceso selectedMiembrocomiteporproceso;
	private List<Miembrocomiteporproceso> listaMiembrocomiteporproceso;
	public List<Gentabla> listaGentablaIdcatalogotipomiembro;
	public List<Gentabla> listaGentablaIdcatalogoestadomiembrocomite;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public MiembrocomiteporprocesoBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_MIEMBROCOMITEPOR";
	public MiembrocomiteporprocesoController(){
			miembrocomiteporproceso = new Miembrocomiteporproceso();
			miembrocomiteporproceso.setComiteprocesoIdcomiteproceso(new Comiteproceso());
			miembrocomiteporproceso.setPersonaIdpersona(new Persona());

	}


	@PostConstruct
	public void init(){
		try {
			miembrocomiteporprocesoB = new Miembrocomiteporproceso();
			tituloBase = "Miembro Comite por Proceso » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			miembrocomiteporprocesoB.setComiteprocesoIdcomiteproceso(new Comiteproceso());
			miembrocomiteporprocesoB.setPersonaIdpersona(new Persona());

			listaIdcatalogotipomiembroKeys= new ArrayList<String>();
			listaIdcatalogoestadomiembrocomiteKeys= new ArrayList<String>();

			listaGentablaIdcatalogotipomiembro = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.CAMI));
			listaGentablaIdcatalogoestadomiembrocomite = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EMCO));

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
			List<String> ordenListaCampos=new ArrayList<String>();
			ordenListaCampos.add("A1.IDMIEMBROCOMITEPROCESO");
			miembrocomiteporprocesoB.setOrdenListaCampos(ordenListaCampos);
			miembrocomiteporprocesoB.setOrdenTipo("DESC");

			//Add conditions IN clause
			miembrocomiteporprocesoB.addConditionInIdcatalogotipomiembro(listaIdcatalogotipomiembroKeys);
			miembrocomiteporprocesoB.addConditionInIdcatalogoestadomiembrocomite(listaIdcatalogoestadomiembrocomiteKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(miembrocomiteporprocesoB); //pasa a mayusculas los datos para la busqueda
			listaMiembrocomiteporproceso = business.selectDynamicFull(miembrocomiteporprocesoB);
			setEsSeleccionado(false);
			setSelectedMiembrocomiteporproceso(null);
			if (listaMiembrocomiteporproceso.size() == 0)
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
			titulo = "Miembro Comite por Proceso » " + REGISTRAR;
			miembrocomiteporproceso = new Miembrocomiteporproceso();

			miembrocomiteporproceso.setBooleanesnotificado(false);

			miembrocomiteporproceso.setIdmiembrocomiteproceso(new java.lang.Integer(0));
			miembrocomiteporproceso.setIdmiembrocomiteproceso((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_MIEMBROCOMITEPORPROCESO).longValue());
			miembrocomiteporproceso.setComiteprocesoIdcomiteproceso(new Comiteproceso());
			miembrocomiteporproceso.setPersonaIdpersona(new Persona());


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
			updateCharToBoolean(miembrocomiteporproceso);
			miembrocomiteporproceso.roundBigDecimals();
			accion = EDITAR;
			titulo = "Miembro Comite por Proceso » " + EDITAR;


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
			miembrocomiteporproceso.roundBigDecimals();
			accion = DETALLE;
			titulo = "Miembro Comite por Proceso » " + DETALLE;

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
			titulo = "Miembro Comite por Proceso » " + IMPRIMIR;

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
			if(miembrocomiteporproceso.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "Miembro Comite por Proceso » " + accion;

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
			Miembrocomiteporproceso record= new Miembrocomiteporproceso();
			if(miembrocomiteporproceso.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdmiembrocomiteproceso(miembrocomiteporproceso.getIdmiembrocomiteproceso());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsMiembrocomiteporprocesoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsMiembrocomiteporprocesoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsMiembrocomiteporprocesoA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			miembrocomiteporproceso.setGentablaIdcatalogotipomiembro(gentablaBusiness.selectByPrimaryKeyBasicFromList(miembrocomiteporproceso.getIdcatalogotipomiembro(),listaGentablaIdcatalogotipomiembro));
			miembrocomiteporproceso.setGentablaIdcatalogoestadomiembrocomite(gentablaBusiness.selectByPrimaryKeyBasicFromList(miembrocomiteporproceso.getIdcatalogoestadomiembrocomite(),listaGentablaIdcatalogoestadomiembrocomite));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				miembrocomiteporproceso.setUsuariocreacionauditoria(getUserLogin());
				miembrocomiteporproceso.setEquipoauditoria(getRemoteAddr());
				miembrocomiteporproceso.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(miembrocomiteporproceso);
			}else{
				miembrocomiteporproceso.setUsuariomodificacionauditoria(getUserLogin());
				miembrocomiteporproceso.setEquipoauditoria(getRemoteAddr());
				miembrocomiteporproceso.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(miembrocomiteporproceso);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsMiembrocomiteporprocesoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsMiembrocomiteporprocesoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsMiembrocomiteporprocesoR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			miembrocomiteporproceso.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(miembrocomiteporproceso);
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
		if (selectedMiembrocomiteporproceso == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			miembrocomiteporproceso = (Miembrocomiteporproceso)selectedMiembrocomiteporproceso.clone();
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

	public void loadMainIdcomiteproceso(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainComiteproceso.event...");
			pe.com.sisabas.be.Comiteproceso item= (pe.com.sisabas.be.Comiteproceso) event.getObject();
			logger.debug("loadmiembrocomiteporproceso.event...:"+item.getIdcomiteproceso());
			miembrocomiteporprocesoB.setIdcomiteproceso(item.getIdcomiteproceso());
			miembrocomiteporprocesoB.setComiteprocesoIdcomiteproceso(item);
			logger.debug("loadComiteproceso.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdcomiteproceso(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegComiteproceso.event...");
			pe.com.sisabas.be.Comiteproceso item= (pe.com.sisabas.be.Comiteproceso) event.getObject();
			logger.debug("loadmiembrocomiteporproceso.event...:"+item.getIdcomiteproceso());
			miembrocomiteporproceso.setIdcomiteproceso(item.getIdcomiteproceso());
			miembrocomiteporproceso.setComiteprocesoIdcomiteproceso(item);
			logger.debug("loadComiteproceso.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdcomiteproceso() {
		try {
			miembrocomiteporprocesoB.setIdcomiteproceso(null);
			miembrocomiteporprocesoB.setComiteprocesoIdcomiteproceso(new Comiteproceso());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdcomiteproceso() {
		try {
			miembrocomiteporproceso.setIdcomiteproceso(null);
			miembrocomiteporproceso.setComiteprocesoIdcomiteproceso(new Comiteproceso());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdpersona(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainPersona.event...");
			pe.com.sisabas.be.Persona item= (pe.com.sisabas.be.Persona) event.getObject();
			logger.debug("loadmiembrocomiteporproceso.event...:"+item.getIdpersona());
			miembrocomiteporprocesoB.setIdpersona(item.getIdpersona());
			miembrocomiteporprocesoB.setPersonaIdpersona(item);
			logger.debug("loadPersona.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdpersona(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPersona.event...");
			pe.com.sisabas.be.Persona item= (pe.com.sisabas.be.Persona) event.getObject();
			logger.debug("loadmiembrocomiteporproceso.event...:"+item.getIdpersona());
			miembrocomiteporproceso.setIdpersona(item.getIdpersona());
			miembrocomiteporproceso.setPersonaIdpersona(item);
			logger.debug("loadPersona.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpersona() {
		try {
			miembrocomiteporprocesoB.setIdpersona(null);
			miembrocomiteporprocesoB.setPersonaIdpersona(new Persona());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	
	
	
	public void resetRegIdpersona() {
		try {
			miembrocomiteporproceso.setIdpersona(null);
			miembrocomiteporproceso.setPersonaIdpersona(new Persona());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/miembrocomiteporproceso/miembrocomiteporprocesoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmMiembrocomiteporprocesoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmMiembrocomiteporprocesoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Miembrocomiteporproceso record) throws Exception {
		if( miembrocomiteporproceso.getEsnotificado()!=null  && miembrocomiteporproceso.getEsnotificado().equalsIgnoreCase("1")){
			miembrocomiteporproceso.setBooleanesnotificado(true);
		}else {
			miembrocomiteporproceso.setBooleanesnotificado(false);
		}

	}

	public void setMiembrocomiteporproceso(Miembrocomiteporproceso miembrocomiteporproceso){
		this.miembrocomiteporproceso=miembrocomiteporproceso;
	}

	public Miembrocomiteporproceso getMiembrocomiteporproceso(){
		return miembrocomiteporproceso;
	}

	public void setMiembrocomiteporprocesoB(Miembrocomiteporproceso miembrocomiteporprocesoB){
		this.miembrocomiteporprocesoB = miembrocomiteporprocesoB;
	}

	public Miembrocomiteporproceso getMiembrocomiteporprocesoB(){
		return miembrocomiteporprocesoB;
	}

	public void setSelectedMiembrocomiteporproceso(Miembrocomiteporproceso selectedMiembrocomiteporproceso){
		this.selectedMiembrocomiteporproceso = selectedMiembrocomiteporproceso;
	}

	public Miembrocomiteporproceso getSelectedMiembrocomiteporproceso(){
		return selectedMiembrocomiteporproceso;
	}

	public void setListaMiembrocomiteporproceso(List<Miembrocomiteporproceso> listaMiembrocomiteporproceso){
		this.listaMiembrocomiteporproceso=listaMiembrocomiteporproceso;
	}

	public List<Miembrocomiteporproceso> getListaMiembrocomiteporproceso(){
		return listaMiembrocomiteporproceso;
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

	public void setListaGentablaIdcatalogotipomiembro(List<Gentabla> listaGentablaIdcatalogotipomiembro){
		this.listaGentablaIdcatalogotipomiembro=listaGentablaIdcatalogotipomiembro;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipomiembro(){
		return listaGentablaIdcatalogotipomiembro;
	}

	public void setListaGentablaIdcatalogoestadomiembrocomite(List<Gentabla> listaGentablaIdcatalogoestadomiembrocomite){
		this.listaGentablaIdcatalogoestadomiembrocomite=listaGentablaIdcatalogoestadomiembrocomite;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadomiembrocomite(){
		return listaGentablaIdcatalogoestadomiembrocomite;
	}


	private List<String> listaIdcatalogotipomiembroKeys;
	private String valuesIdcatalogotipomiembro;
	public void handleChangeIdcatalogotipomiembro(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogotipomiembro();
		}else{
			listaIdcatalogotipomiembroKeys=new ArrayList<String>();
			valuesIdcatalogotipomiembro=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogotipomiembro(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogotipomiembroKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogotipomiembro) {
			listaIdcatalogotipomiembroKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogotipomiembro=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogotipomiembro(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogotipomiembroKeys) {
			sbTmp.append(getValueIdcatalogotipomiembro(key)+", ");
		}
		valuesIdcatalogotipomiembro=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogotipomiembroKeys.size()==0)
			valuesIdcatalogotipomiembro=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogotipomiembro(String key){
		for (Gentabla s : listaGentablaIdcatalogotipomiembro) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogotipomiembroKeys() {
		return listaIdcatalogotipomiembroKeys;
	}

	public void setListaIdcatalogotipomiembroKeys(List<String> listaIdcatalogotipomiembroKeys) {
		this.listaIdcatalogotipomiembroKeys = listaIdcatalogotipomiembroKeys;
	}

	 public String getValuesIdcatalogotipomiembro() {
		return valuesIdcatalogotipomiembro;
	}

	public void setValuesIdcatalogotipomiembro(String valuesIdcatalogotipomiembro) {
		this.valuesIdcatalogotipomiembro = valuesIdcatalogotipomiembro;
	}

///////////////////////////////

	private List<String> listaIdcatalogoestadomiembrocomiteKeys;
	private String valuesIdcatalogoestadomiembrocomite;
	public void handleChangeIdcatalogoestadomiembrocomite(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogoestadomiembrocomite();
		}else{
			listaIdcatalogoestadomiembrocomiteKeys=new ArrayList<String>();
			valuesIdcatalogoestadomiembrocomite=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogoestadomiembrocomite(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogoestadomiembrocomiteKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogoestadomiembrocomite) {
			listaIdcatalogoestadomiembrocomiteKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogoestadomiembrocomite=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogoestadomiembrocomite(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogoestadomiembrocomiteKeys) {
			sbTmp.append(getValueIdcatalogoestadomiembrocomite(key)+", ");
		}
		valuesIdcatalogoestadomiembrocomite=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogoestadomiembrocomiteKeys.size()==0)
			valuesIdcatalogoestadomiembrocomite=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogoestadomiembrocomite(String key){
		for (Gentabla s : listaGentablaIdcatalogoestadomiembrocomite) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogoestadomiembrocomiteKeys() {
		return listaIdcatalogoestadomiembrocomiteKeys;
	}

	public void setListaIdcatalogoestadomiembrocomiteKeys(List<String> listaIdcatalogoestadomiembrocomiteKeys) {
		this.listaIdcatalogoestadomiembrocomiteKeys = listaIdcatalogoestadomiembrocomiteKeys;
	}

	 public String getValuesIdcatalogoestadomiembrocomite() {
		return valuesIdcatalogoestadomiembrocomite;
	}

	public void setValuesIdcatalogoestadomiembrocomite(String valuesIdcatalogoestadomiembrocomite) {
		this.valuesIdcatalogoestadomiembrocomite = valuesIdcatalogoestadomiembrocomite;
	}

///////////////////////////////



}

