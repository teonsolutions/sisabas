
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
import pe.com.sisabas.be.Sinadporpacconsolidado;
import pe.com.sisabas.business.SinadporpacconsolidadoBusiness;
import pe.com.sisabas.be.Pacconsolidado;



@Component(value ="sinadporpacconsolidado")
@Scope(value = "session")
public class SinadporpacconsolidadoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Sinadporpacconsolidado sinadporpacconsolidadoB;
	private Sinadporpacconsolidado sinadporpacconsolidado;
	private Sinadporpacconsolidado selectedSinadporpacconsolidado;
	private List<Sinadporpacconsolidado> listaSinadporpacconsolidado;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public SinadporpacconsolidadoBusiness business;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_SINADPORPACCONSO";
	public SinadporpacconsolidadoController(){
			sinadporpacconsolidado = new Sinadporpacconsolidado();
			sinadporpacconsolidado.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());

	}


	@PostConstruct
	public void init(){
		try {
			sinadporpacconsolidadoB = new Sinadporpacconsolidado();
			tituloBase = "Sinad Por Pac Consolidado » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			sinadporpacconsolidadoB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());



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
			ordenListaCampos.add("A1.IDSINAD");
			sinadporpacconsolidadoB.setOrdenListaCampos(ordenListaCampos);
			sinadporpacconsolidadoB.setOrdenTipo("DESC");

			//Add conditions IN clause

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(sinadporpacconsolidadoB); //pasa a mayusculas los datos para la busqueda
			listaSinadporpacconsolidado = business.selectDynamicFull(sinadporpacconsolidadoB);
			setEsSeleccionado(false);
			setSelectedSinadporpacconsolidado(null);
			if (listaSinadporpacconsolidado.size() == 0)
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
			titulo = "Sinad Por Pac Consolidado » " + REGISTRAR;
			sinadporpacconsolidado = new Sinadporpacconsolidado();

			sinadporpacconsolidado.setBooleanesprincipal(false);
			sinadporpacconsolidado.setBooleanesnuevoasignado(false);

			sinadporpacconsolidado.setIdsinad(new java.lang.Integer(0));
			sinadporpacconsolidado.setIdsinad((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_SINADPORPACCONSOLIDADO).longValue());
			sinadporpacconsolidado.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());

			sinadporpacconsolidado.setIdpacconsolidado(sinadporpacconsolidadoB.getIdpacconsolidado());

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

	public void init(pe.com.sisabas.be.Pacconsolidado pacconsolidado) throws Exception{
		init();
		sinadporpacconsolidadoB.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
		sinadporpacconsolidadoB.setPacconsolidadoIdpacconsolidado(pacconsolidado);
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Pacconsolidado pacconsolidado) throws Exception{
		init();
		sinadporpacconsolidadoB.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
		sinadporpacconsolidadoB.setPacconsolidadoIdpacconsolidado(pacconsolidado);
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(sinadporpacconsolidado);
			sinadporpacconsolidado.roundBigDecimals();
			accion = EDITAR;
			titulo = "Sinad Por Pac Consolidado » " + EDITAR;


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
			sinadporpacconsolidado.roundBigDecimals();
			accion = DETALLE;
			titulo = "Sinad Por Pac Consolidado » " + DETALLE;

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
			titulo = "Sinad Por Pac Consolidado » " + IMPRIMIR;

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
			if(sinadporpacconsolidado.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "Sinad Por Pac Consolidado » " + accion;

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
			Sinadporpacconsolidado record= new Sinadporpacconsolidado();
			if(sinadporpacconsolidado.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdsinad(sinadporpacconsolidado.getIdsinad());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSinadporpacconsolidadoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSinadporpacconsolidadoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsSinadporpacconsolidadoA", e);
		}
	}

	public void setTemporalVars() throws Exception{

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				sinadporpacconsolidado.setUsuariocreacionauditoria(getUserLogin());
				sinadporpacconsolidado.setEquipoauditoria(getRemoteAddr());
				sinadporpacconsolidado.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(sinadporpacconsolidado);
			}else{
				sinadporpacconsolidado.setEquipoauditoria(getRemoteAddr());
				sinadporpacconsolidado.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(sinadporpacconsolidado);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSinadporpacconsolidadoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsSinadporpacconsolidadoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsSinadporpacconsolidadoR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			business.deleteByPrimaryKeyBasic(sinadporpacconsolidado);
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
		if (selectedSinadporpacconsolidado == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			sinadporpacconsolidado = (Sinadporpacconsolidado)selectedSinadporpacconsolidado.clone();
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

	public void loadMainIdpacconsolidado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainPacconsolidado.event...");
			pe.com.sisabas.be.Pacconsolidado item= (pe.com.sisabas.be.Pacconsolidado) event.getObject();
			logger.debug("loadsinadporpacconsolidado.event...:"+item.getIdpacconsolidado());
			sinadporpacconsolidadoB.setIdpacconsolidado(item.getIdpacconsolidado());
			sinadporpacconsolidadoB.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdpacconsolidado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPacconsolidado.event...");
			pe.com.sisabas.be.Pacconsolidado item= (pe.com.sisabas.be.Pacconsolidado) event.getObject();
			logger.debug("loadsinadporpacconsolidado.event...:"+item.getIdpacconsolidado());
			sinadporpacconsolidado.setIdpacconsolidado(item.getIdpacconsolidado());
			sinadporpacconsolidado.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpacconsolidado() {
		try {
			sinadporpacconsolidadoB.setIdpacconsolidado(null);
			sinadporpacconsolidadoB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdpacconsolidado() {
		try {
			sinadporpacconsolidado.setIdpacconsolidado(null);
			sinadporpacconsolidado.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/sinadporpacconsolidado/sinadporpacconsolidadoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmSinadporpacconsolidadoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmSinadporpacconsolidadoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Sinadporpacconsolidado record) throws Exception {
		if( sinadporpacconsolidado.getEsprincipal()!=null  && sinadporpacconsolidado.getEsprincipal().equalsIgnoreCase("1")){
			sinadporpacconsolidado.setBooleanesprincipal(true);
		}else {
			sinadporpacconsolidado.setBooleanesprincipal(false);
		}

		if( sinadporpacconsolidado.getEsnuevoasignado()!=null  && sinadporpacconsolidado.getEsnuevoasignado().equalsIgnoreCase("1")){
			sinadporpacconsolidado.setBooleanesnuevoasignado(true);
		}else {
			sinadporpacconsolidado.setBooleanesnuevoasignado(false);
		}

	}

	public void setSinadporpacconsolidado(Sinadporpacconsolidado sinadporpacconsolidado){
		this.sinadporpacconsolidado=sinadporpacconsolidado;
	}

	public Sinadporpacconsolidado getSinadporpacconsolidado(){
		return sinadporpacconsolidado;
	}

	public void setSinadporpacconsolidadoB(Sinadporpacconsolidado sinadporpacconsolidadoB){
		this.sinadporpacconsolidadoB = sinadporpacconsolidadoB;
	}

	public Sinadporpacconsolidado getSinadporpacconsolidadoB(){
		return sinadporpacconsolidadoB;
	}

	public void setSelectedSinadporpacconsolidado(Sinadporpacconsolidado selectedSinadporpacconsolidado){
		this.selectedSinadporpacconsolidado = selectedSinadporpacconsolidado;
	}

	public Sinadporpacconsolidado getSelectedSinadporpacconsolidado(){
		return selectedSinadporpacconsolidado;
	}

	public void setListaSinadporpacconsolidado(List<Sinadporpacconsolidado> listaSinadporpacconsolidado){
		this.listaSinadporpacconsolidado=listaSinadporpacconsolidado;
	}

	public List<Sinadporpacconsolidado> getListaSinadporpacconsolidado(){
		return listaSinadporpacconsolidado;
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




}

