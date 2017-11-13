
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
import pe.com.sisabas.be.Orden;
import pe.com.sisabas.business.OrdenBusiness;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Unidadejecutora;



@Component(value ="orden")
@Scope(value = "session")
public class OrdenController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Orden ordenB;
	private Orden orden;
	private Orden selectedOrden;
	private List<Orden> listaOrden;
	public List<Gentabla> listaGentablaIdcatalogotipobien;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public OrdenBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_ORDEN";
	public OrdenController(){
			orden = new Orden();
			orden.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
			orden.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			orden.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());

	}


	@PostConstruct
	public void init(){
		try {
			ordenB = new Orden();
			tituloBase = "Orden » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			ordenB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
			ordenB.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			ordenB.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());

			listaIdcatalogotipobienKeys= new ArrayList<String>();

			listaGentablaIdcatalogotipobien = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));

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
			ordenListaCampos.add("A1.IDORDEN");
			ordenB.setOrdenListaCampos(ordenListaCampos);
			ordenB.setOrdenTipo("DESC");

			//Add conditions IN clause
			ordenB.addConditionInIdcatalogotipobien(listaIdcatalogotipobienKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(ordenB); //pasa a mayusculas los datos para la busqueda
			listaOrden = business.selectDynamicFull(ordenB);
			setEsSeleccionado(false);
			setSelectedOrden(null);
			if (listaOrden.size() == 0)
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
			titulo = "Orden » " + REGISTRAR;
			orden = new Orden();


			orden.setIdorden(new java.lang.Integer(0));
			orden.setIdorden((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ORDEN).longValue());
			orden.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
			orden.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			orden.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());

			orden.setIdpacconsolidado(ordenB.getIdpacconsolidado());

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

	@Autowired
	EntregableController entregableController;
	public String irEntregable() {
		boolean validado=false;
		try {
			securityControlValidate("btnEntregable");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			entregableController.setTituloParam(paramTitulo);
			entregableController.init(orden);

			validado=true;
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
			addMessageKey("msgsForm", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
			return null;
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
			return null;
		}
		if(validado) return "/pages/entregable/entregableBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	public String load() {
		return"/pages/orden/ordenBuscar.xhtml?faces-redirect=true";
	}

	public void init(pe.com.sisabas.be.Pacconsolidado pacconsolidado) throws Exception{
		init();
		ordenB.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
		ordenB.setPacconsolidadoIdpacconsolidado(pacconsolidado);
		esDerivada = "1";
		buscar();
	}

	public void initDerivedTable(pe.com.sisabas.be.Pacconsolidado pacconsolidado) throws Exception{
		init();
		ordenB.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
		ordenB.setPacconsolidadoIdpacconsolidado(pacconsolidado);
		esDerivada = "1";
		buscar();
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(orden);
			orden.roundBigDecimals();
			accion = EDITAR;
			titulo = "Orden » " + EDITAR;


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
			orden.roundBigDecimals();
			accion = DETALLE;
			titulo = "Orden » " + DETALLE;

			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			entregableController.setTituloParam(paramTitulo);
			entregableController.initDerivedTable(orden);

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
			titulo = "Orden » " + IMPRIMIR;

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
			if(orden.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "Orden » " + accion;

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
			Orden record= new Orden();
			if(orden.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdorden(orden.getIdorden());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsOrdenA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsOrdenA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsOrdenA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			orden.setGentablaIdcatalogotipobien(gentablaBusiness.selectByPrimaryKeyBasicFromList(orden.getIdcatalogotipobien(),listaGentablaIdcatalogotipobien));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				orden.setUsuariocreacionauditoria(getUserLogin());
				orden.setEquipoauditoria(getRemoteAddr());
				orden.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(orden);
			}else{
				orden.setUsuariomodificacionauditoria(getUserLogin());
				orden.setEquipoauditoria(getRemoteAddr());
				orden.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(orden);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsOrdenR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsOrdenR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsOrdenR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			orden.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(orden);
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
		if (selectedOrden == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			orden = (Orden)selectedOrden.clone();
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
			logger.debug("loadorden.event...:"+item.getIdpacconsolidado());
			ordenB.setIdpacconsolidado(item.getIdpacconsolidado());
			ordenB.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdpacconsolidado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegPacconsolidado.event...");
			pe.com.sisabas.be.Pacconsolidado item= (pe.com.sisabas.be.Pacconsolidado) event.getObject();
			logger.debug("loadorden.event...:"+item.getIdpacconsolidado());
			orden.setIdpacconsolidado(item.getIdpacconsolidado());
			orden.setPacconsolidadoIdpacconsolidado(item);
			logger.debug("loadPacconsolidado.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpacconsolidado() {
		try {
			ordenB.setIdpacconsolidado(null);
			ordenB.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdpacconsolidado() {
		try {
			orden.setIdpacconsolidado(null);
			orden.setPacconsolidadoIdpacconsolidado(new Pacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdgrupodocumento(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainGrupodocumento.event...");
			pe.com.sisabas.be.Grupodocumento item= (pe.com.sisabas.be.Grupodocumento) event.getObject();
			logger.debug("loadorden.event...:"+item.getIdgrupodocumento());
			ordenB.setIdgrupodocumento(item.getIdgrupodocumento());
			ordenB.setGrupodocumentoIdgrupodocumento(item);
			logger.debug("loadGrupodocumento.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdgrupodocumento(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegGrupodocumento.event...");
			pe.com.sisabas.be.Grupodocumento item= (pe.com.sisabas.be.Grupodocumento) event.getObject();
			logger.debug("loadorden.event...:"+item.getIdgrupodocumento());
			orden.setIdgrupodocumento(item.getIdgrupodocumento());
			orden.setGrupodocumentoIdgrupodocumento(item);
			logger.debug("loadGrupodocumento.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdgrupodocumento() {
		try {
			ordenB.setIdgrupodocumento(null);
			ordenB.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdgrupodocumento() {
		try {
			orden.setIdgrupodocumento(null);
			orden.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdunidadejecutora(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainUnidadejecutora.event...");
			pe.com.sisabas.be.Unidadejecutora item= (pe.com.sisabas.be.Unidadejecutora) event.getObject();
			logger.debug("loadorden.event...:"+item.getIdunidadejecutora());
			ordenB.setIdunidadejecutora(item.getIdunidadejecutora());
			ordenB.setUnidadejecutoraIdunidadejecutora(item);
			logger.debug("loadUnidadejecutora.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdunidadejecutora(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegUnidadejecutora.event...");
			pe.com.sisabas.be.Unidadejecutora item= (pe.com.sisabas.be.Unidadejecutora) event.getObject();
			logger.debug("loadorden.event...:"+item.getIdunidadejecutora());
			orden.setIdunidadejecutora(item.getIdunidadejecutora());
			orden.setUnidadejecutoraIdunidadejecutora(item);
			logger.debug("loadUnidadejecutora.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdunidadejecutora() {
		try {
			ordenB.setIdunidadejecutora(null);
			ordenB.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdunidadejecutora() {
		try {
			orden.setIdunidadejecutora(null);
			orden.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/orden/ordenBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmOrdenRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmOrdenAnular:panelDetailC");
	}


	public void updateCharToBoolean(Orden record) throws Exception {
	}

	public void setOrden(Orden orden){
		this.orden=orden;
	}

	public Orden getOrden(){
		return orden;
	}

	public void setOrdenB(Orden ordenB){
		this.ordenB = ordenB;
	}

	public Orden getOrdenB(){
		return ordenB;
	}

	public void setSelectedOrden(Orden selectedOrden){
		this.selectedOrden = selectedOrden;
	}

	public Orden getSelectedOrden(){
		return selectedOrden;
	}

	public void setListaOrden(List<Orden> listaOrden){
		this.listaOrden=listaOrden;
	}

	public List<Orden> getListaOrden(){
		return listaOrden;
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



}

