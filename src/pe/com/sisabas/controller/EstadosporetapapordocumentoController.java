
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
import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.business.EstadosporetapapordocumentoBusiness;
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.be.Tipodocumento;



@Component(value ="estadosporetapapordocumento")
@Scope(value = "session")
public class EstadosporetapapordocumentoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Estadosporetapapordocumento estadosporetapapordocumentoB;
	private Estadosporetapapordocumento estadosporetapapordocumento;
	private Estadosporetapapordocumento selectedEstadosporetapapordocumento;
	private List<Estadosporetapapordocumento> listaEstadosporetapapordocumento;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public EstadosporetapapordocumentoBusiness business;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_ESTADOSPORETAPAP";
	public EstadosporetapapordocumentoController(){
			estadosporetapapordocumento = new Estadosporetapapordocumento();
			estadosporetapapordocumento.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			estadosporetapapordocumento.setTipodocumentoIdtipodocumento(new Tipodocumento());

	}


	@PostConstruct
	public void init(){
		try {
			estadosporetapapordocumentoB = new Estadosporetapapordocumento();
			tituloBase = "Estados por etapa por documento » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			estadosporetapapordocumentoB.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			estadosporetapapordocumentoB.setTipodocumentoIdtipodocumento(new Tipodocumento());



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
			ordenListaCampos.add("A1.IDESTADOSPORETAPAPORDOCUMENTO");
			estadosporetapapordocumentoB.setOrdenListaCampos(ordenListaCampos);
			estadosporetapapordocumentoB.setOrdenTipo("DESC");

			//Add conditions IN clause

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(estadosporetapapordocumentoB); //pasa a mayusculas los datos para la busqueda
			listaEstadosporetapapordocumento = business.selectDynamicFull(estadosporetapapordocumentoB);
			setEsSeleccionado(false);
			setSelectedEstadosporetapapordocumento(null);
			if (listaEstadosporetapapordocumento.size() == 0)
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
			titulo = "Estados por etapa por documento » " + REGISTRAR;
			estadosporetapapordocumento = new Estadosporetapapordocumento();


			estadosporetapapordocumento.setIdestadosporetapapordocumento(new java.lang.Integer(0));
			estadosporetapapordocumento.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());
			estadosporetapapordocumento.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			estadosporetapapordocumento.setTipodocumentoIdtipodocumento(new Tipodocumento());


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
			updateCharToBoolean(estadosporetapapordocumento);
			estadosporetapapordocumento.roundBigDecimals();
			accion = EDITAR;
			titulo = "Estados por etapa por documento » " + EDITAR;


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
			estadosporetapapordocumento.roundBigDecimals();
			accion = DETALLE;
			titulo = "Estados por etapa por documento » " + DETALLE;

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
			titulo = "Estados por etapa por documento » " + IMPRIMIR;

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
			if(estadosporetapapordocumento.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "Estados por etapa por documento » " + accion;

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
			Estadosporetapapordocumento record= new Estadosporetapapordocumento();
			if(estadosporetapapordocumento.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdestadosporetapapordocumento(estadosporetapapordocumento.getIdestadosporetapapordocumento());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEstadosporetapapordocumentoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEstadosporetapapordocumentoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsEstadosporetapapordocumentoA", e);
		}
	}

	public void setTemporalVars() throws Exception{

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				estadosporetapapordocumento.setUsuariocreacionauditoria(getUserLogin());
				estadosporetapapordocumento.setEquipoauditoria(getRemoteAddr());
				estadosporetapapordocumento.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(estadosporetapapordocumento);
			}else{
				estadosporetapapordocumento.setUsuariomodificacionauditoria(getUserLogin());
				estadosporetapapordocumento.setEquipoauditoria(getRemoteAddr());
				estadosporetapapordocumento.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(estadosporetapapordocumento);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEstadosporetapapordocumentoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsEstadosporetapapordocumentoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsEstadosporetapapordocumentoR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			estadosporetapapordocumento.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(estadosporetapapordocumento);
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
		if (selectedEstadosporetapapordocumento == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			estadosporetapapordocumento = (Estadosporetapapordocumento)selectedEstadosporetapapordocumento.clone();
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

	public void loadMainIdgrupodocumento(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainGrupodocumento.event...");
			pe.com.sisabas.be.Grupodocumento item= (pe.com.sisabas.be.Grupodocumento) event.getObject();
			logger.debug("loadestadosporetapapordocumento.event...:"+item.getIdgrupodocumento());
			estadosporetapapordocumentoB.setIdgrupodocumento(item.getIdgrupodocumento());
			estadosporetapapordocumentoB.setGrupodocumentoIdgrupodocumento(item);
			logger.debug("loadGrupodocumento.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdgrupodocumento(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegGrupodocumento.event...");
			pe.com.sisabas.be.Grupodocumento item= (pe.com.sisabas.be.Grupodocumento) event.getObject();
			logger.debug("loadestadosporetapapordocumento.event...:"+item.getIdgrupodocumento());
			estadosporetapapordocumento.setIdgrupodocumento(item.getIdgrupodocumento());
			estadosporetapapordocumento.setGrupodocumentoIdgrupodocumento(item);
			logger.debug("loadGrupodocumento.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdgrupodocumento() {
		try {
			estadosporetapapordocumentoB.setIdgrupodocumento(null);
			estadosporetapapordocumentoB.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdgrupodocumento() {
		try {
			estadosporetapapordocumento.setIdgrupodocumento(null);
			estadosporetapapordocumento.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdtipodocumento(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainTipodocumento.event...");
			pe.com.sisabas.be.Tipodocumento item= (pe.com.sisabas.be.Tipodocumento) event.getObject();
			logger.debug("loadestadosporetapapordocumento.event...:"+item.getIdtipodocumento());
			estadosporetapapordocumentoB.setIdtipodocumento(item.getIdtipodocumento());
			estadosporetapapordocumentoB.setTipodocumentoIdtipodocumento(item);
			logger.debug("loadTipodocumento.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdtipodocumento(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegTipodocumento.event...");
			pe.com.sisabas.be.Tipodocumento item= (pe.com.sisabas.be.Tipodocumento) event.getObject();
			logger.debug("loadestadosporetapapordocumento.event...:"+item.getIdtipodocumento());
			estadosporetapapordocumento.setIdtipodocumento(item.getIdtipodocumento());
			estadosporetapapordocumento.setTipodocumentoIdtipodocumento(item);
			logger.debug("loadTipodocumento.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdtipodocumento() {
		try {
			estadosporetapapordocumentoB.setIdtipodocumento(null);
			estadosporetapapordocumentoB.setTipodocumentoIdtipodocumento(new Tipodocumento());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdtipodocumento() {
		try {
			estadosporetapapordocumento.setIdtipodocumento(null);
			estadosporetapapordocumento.setTipodocumentoIdtipodocumento(new Tipodocumento());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/estadosporetapapordocumento/estadosporetapapordocumentoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmEstadosporetapapordocumentoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmEstadosporetapapordocumentoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Estadosporetapapordocumento record) throws Exception {
	}

	public void setEstadosporetapapordocumento(Estadosporetapapordocumento estadosporetapapordocumento){
		this.estadosporetapapordocumento=estadosporetapapordocumento;
	}

	public Estadosporetapapordocumento getEstadosporetapapordocumento(){
		return estadosporetapapordocumento;
	}

	public void setEstadosporetapapordocumentoB(Estadosporetapapordocumento estadosporetapapordocumentoB){
		this.estadosporetapapordocumentoB = estadosporetapapordocumentoB;
	}

	public Estadosporetapapordocumento getEstadosporetapapordocumentoB(){
		return estadosporetapapordocumentoB;
	}

	public void setSelectedEstadosporetapapordocumento(Estadosporetapapordocumento selectedEstadosporetapapordocumento){
		this.selectedEstadosporetapapordocumento = selectedEstadosporetapapordocumento;
	}

	public Estadosporetapapordocumento getSelectedEstadosporetapapordocumento(){
		return selectedEstadosporetapapordocumento;
	}

	public void setListaEstadosporetapapordocumento(List<Estadosporetapapordocumento> listaEstadosporetapapordocumento){
		this.listaEstadosporetapapordocumento=listaEstadosporetapapordocumento;
	}

	public List<Estadosporetapapordocumento> getListaEstadosporetapapordocumento(){
		return listaEstadosporetapapordocumento;
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

