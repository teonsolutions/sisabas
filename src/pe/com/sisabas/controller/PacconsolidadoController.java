
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
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.business.PacconsolidadoBusiness;
import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Unidadejecutora;
import pe.com.sisabas.be.Vcertificacion;
import pe.com.sisabas.be.Vissigapaacconsolidado;



@Component(value ="pacconsolidado")
@Scope(value = "session")
public class PacconsolidadoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Pacconsolidado pacconsolidadoB;
	private Pacconsolidado pacconsolidado;
	private Pacconsolidado selectedPacconsolidado;
	private List<Pacconsolidado> listaPacconsolidado;
	public List<Gentabla> listaGentablaIdcatalogoestadopac;
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<Gentabla> listaGentablaIdcatalogotiponecesidad;
	public List<Gentabla> listaGentablaIdcatalogotipocontratacion;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public PacconsolidadoBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_PACCONSOLIDADO";
	public PacconsolidadoController(){
			pacconsolidado = new Pacconsolidado();
			pacconsolidado.setComiteprocesoIdcomiteproceso(new Comiteproceso());
			pacconsolidado.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			pacconsolidado.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
			pacconsolidado.setVcertificacionVcertificacion(new Vcertificacion());
			pacconsolidado.setVissigapaacconsolidadoVisidsigapaacconsolidado(new Vissigapaacconsolidado());

	}


	@PostConstruct
	public void init(){
		try {
			pacconsolidadoB = new Pacconsolidado();
			tituloBase = "Pac Consolidacion » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			pacconsolidadoB.setComiteprocesoIdcomiteproceso(new Comiteproceso());
			pacconsolidadoB.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			pacconsolidadoB.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
			pacconsolidadoB.setVcertificacionVcertificacion(new Vcertificacion());
			pacconsolidadoB.setVissigapaacconsolidadoVisidsigapaacconsolidado(new Vissigapaacconsolidado());

			listaIdcatalogoestadopacKeys= new ArrayList<String>();
			listaIdcatalogotipobienKeys= new ArrayList<String>();
			listaIdcatalogotiponecesidadKeys= new ArrayList<String>();
			listaIdcatalogotipocontratacionKeys= new ArrayList<String>();

			listaGentablaIdcatalogoestadopac = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EPAC));
			listaGentablaIdcatalogotipobien = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaGentablaIdcatalogotiponecesidad = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TINE));
			listaGentablaIdcatalogotipocontratacion = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TCON));

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
			pacconsolidadoB.setOrdenListaCampos(ordenListaCampos);
			pacconsolidadoB.setOrdenTipo("DESC");

			//Add conditions IN clause
			pacconsolidadoB.addConditionInIdcatalogoestadopac(listaIdcatalogoestadopacKeys);
			pacconsolidadoB.addConditionInIdcatalogotipobien(listaIdcatalogotipobienKeys);
			pacconsolidadoB.addConditionInIdcatalogotiponecesidad(listaIdcatalogotiponecesidadKeys);
			pacconsolidadoB.addConditionInIdcatalogotipocontratacion(listaIdcatalogotipocontratacionKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(pacconsolidadoB); //pasa a mayusculas los datos para la busqueda
			listaPacconsolidado = business.selectDynamicFull(pacconsolidadoB);
			setEsSeleccionado(false);
			setSelectedPacconsolidado(null);
			if (listaPacconsolidado.size() == 0)
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
			titulo = "Pac Consolidacion » " + REGISTRAR;
			pacconsolidado = new Pacconsolidado();

			pacconsolidado.setBooleantieneprevision(false);
			pacconsolidado.setBooleanflagaprobacionestandarizacion(false);
			pacconsolidado.setBooleanmodalidadseleccion(false);
			pacconsolidado.setBooleanmodalidadcontratacion(false);
			pacconsolidado.setBooleanreajuste(false);
			pacconsolidado.setBooleanflagcd(false);
			pacconsolidado.setBooleanindagacionvalorestimado(false);

			pacconsolidado.setIdpacconsolidado(new java.lang.Integer(0));
			pacconsolidado.setIdpacconsolidado((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_PACCONSOLIDADO).longValue());
			pacconsolidado.setComiteprocesoIdcomiteproceso(new Comiteproceso());
			pacconsolidado.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			pacconsolidado.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
			pacconsolidado.setVcertificacionVcertificacion(new Vcertificacion());
			pacconsolidado.setVissigapaacconsolidadoVisidsigapaacconsolidado(new Vissigapaacconsolidado());


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
	RequisitosconformidadController requisitosconformidadController;
	public String irRequisitosconformidad() {
		boolean validado=false;
		try {
			securityControlValidate("btnRequisitosconformidad");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			requisitosconformidadController.setTituloParam(paramTitulo);
			requisitosconformidadController.init(pacconsolidado);

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
		if(validado) return "/pages/requisitosconformidad/requisitosconformidadBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	@Autowired
	OrdenController ordenController;
	public String irOrden() {
		boolean validado=false;
		try {
			securityControlValidate("btnOrden");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			ordenController.setTituloParam(paramTitulo);
			ordenController.init(pacconsolidado);

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
		if(validado) return "/pages/orden/ordenBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	@Autowired
	SinadporpacconsolidadoController sinadporpacconsolidadoController;
	public String irSinadporpacconsolidado() {
		boolean validado=false;
		try {
			securityControlValidate("btnSinadporpacconsolidado");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			sinadporpacconsolidadoController.setTituloParam(paramTitulo);
			sinadporpacconsolidadoController.init(pacconsolidado);

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
		if(validado) return "/pages/sinadporpacconsolidado/sinadporpacconsolidadoBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	@Autowired
	CertificadopresupuestalController certificadopresupuestalController;
	public String irCertificadopresupuestal() {
		boolean validado=false;
		try {
			securityControlValidate("btnCertificadopresupuestal");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			certificadopresupuestalController.setTituloParam(paramTitulo);
			certificadopresupuestalController.init(pacconsolidado);

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
		if(validado) return "/pages/certificadopresupuestal/certificadopresupuestalBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	@Autowired
	PrevisionpresupuestalController previsionpresupuestalController;
	public String irPrevisionpresupuestal() {
		boolean validado=false;
		try {
			securityControlValidate("btnPrevisionpresupuestal");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			previsionpresupuestalController.setTituloParam(paramTitulo);
			previsionpresupuestalController.init(pacconsolidado);

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
		if(validado) return "/pages/previsionpresupuestal/previsionpresupuestalBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	@Autowired
	CuadrocomparativofuenteController cuadrocomparativofuenteController;
	public String irCuadrocomparativofuente() {
		boolean validado=false;
		try {
			securityControlValidate("btnCuadrocomparativofuente");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			cuadrocomparativofuenteController.setTituloParam(paramTitulo);
			cuadrocomparativofuenteController.init(pacconsolidado);

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
		if(validado) return "/pages/cuadrocomparativofuente/cuadrocomparativofuenteBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	public String load() {
		return"/pages/pacconsolidado/pacconsolidadoBuscar.xhtml?faces-redirect=true";
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(pacconsolidado);
			pacconsolidado.roundBigDecimals();
			accion = EDITAR;
			titulo = "Pac Consolidacion » " + EDITAR;


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
			pacconsolidado.roundBigDecimals();
			accion = DETALLE;
			titulo = "Pac Consolidacion » " + DETALLE;

			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			requisitosconformidadController.setTituloParam(paramTitulo);
			requisitosconformidadController.initDerivedTable(pacconsolidado);

			ordenController.setTituloParam(paramTitulo);
			ordenController.initDerivedTable(pacconsolidado);

			sinadporpacconsolidadoController.setTituloParam(paramTitulo);
			sinadporpacconsolidadoController.initDerivedTable(pacconsolidado);

			certificadopresupuestalController.setTituloParam(paramTitulo);
			certificadopresupuestalController.initDerivedTable(pacconsolidado);

			previsionpresupuestalController.setTituloParam(paramTitulo);
			previsionpresupuestalController.initDerivedTable(pacconsolidado);

			cuadrocomparativofuenteController.setTituloParam(paramTitulo);
			cuadrocomparativofuenteController.initDerivedTable(pacconsolidado);

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
			titulo = "Pac Consolidacion » " + IMPRIMIR;

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
			if(pacconsolidado.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "Pac Consolidacion » " + accion;

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
			Pacconsolidado record= new Pacconsolidado();
			if(pacconsolidado.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdpacconsolidado(pacconsolidado.getIdpacconsolidado());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPacconsolidadoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPacconsolidadoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPacconsolidadoA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			pacconsolidado.setGentablaIdcatalogoestadopac(gentablaBusiness.selectByPrimaryKeyBasicFromList(pacconsolidado.getIdcatalogoestadopac(),listaGentablaIdcatalogoestadopac));
			pacconsolidado.setGentablaIdcatalogotipobien(gentablaBusiness.selectByPrimaryKeyBasicFromList(pacconsolidado.getIdcatalogotipobien(),listaGentablaIdcatalogotipobien));
			pacconsolidado.setGentablaIdcatalogotiponecesidad(gentablaBusiness.selectByPrimaryKeyBasicFromList(pacconsolidado.getIdcatalogotiponecesidad(),listaGentablaIdcatalogotiponecesidad));
			pacconsolidado.setGentablaIdcatalogotipocontratacion(gentablaBusiness.selectByPrimaryKeyBasicFromList(pacconsolidado.getIdcatalogotipocontratacion(),listaGentablaIdcatalogotipocontratacion));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				pacconsolidado.setUsuariocreacionauditoria(getUserLogin());
				pacconsolidado.setEquipoauditoria(getRemoteAddr());
				pacconsolidado.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(pacconsolidado);
			}else{
				pacconsolidado.setUsuariomodificacionauditoria(getUserLogin());
				pacconsolidado.setEquipoauditoria(getRemoteAddr());
				pacconsolidado.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(pacconsolidado);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPacconsolidadoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPacconsolidadoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPacconsolidadoR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			pacconsolidado.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(pacconsolidado);
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
		if (selectedPacconsolidado == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			pacconsolidado = (Pacconsolidado)selectedPacconsolidado.clone();
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
			logger.debug("loadpacconsolidado.event...:"+item.getIdcomiteproceso());
			pacconsolidadoB.setIdcomiteproceso(item.getIdcomiteproceso());
			pacconsolidadoB.setComiteprocesoIdcomiteproceso(item);
			logger.debug("loadComiteproceso.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdcomiteproceso(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegComiteproceso.event...");
			pe.com.sisabas.be.Comiteproceso item= (pe.com.sisabas.be.Comiteproceso) event.getObject();
			logger.debug("loadpacconsolidado.event...:"+item.getIdcomiteproceso());
			pacconsolidado.setIdcomiteproceso(item.getIdcomiteproceso());
			pacconsolidado.setComiteprocesoIdcomiteproceso(item);
			logger.debug("loadComiteproceso.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdcomiteproceso() {
		try {
			pacconsolidadoB.setIdcomiteproceso(null);
			pacconsolidadoB.setComiteprocesoIdcomiteproceso(new Comiteproceso());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdcomiteproceso() {
		try {
			pacconsolidado.setIdcomiteproceso(null);
			pacconsolidado.setComiteprocesoIdcomiteproceso(new Comiteproceso());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdgrupodocumento(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainGrupodocumento.event...");
			pe.com.sisabas.be.Grupodocumento item= (pe.com.sisabas.be.Grupodocumento) event.getObject();
			logger.debug("loadpacconsolidado.event...:"+item.getIdgrupodocumento());
			pacconsolidadoB.setIdgrupodocumento(item.getIdgrupodocumento());
			pacconsolidadoB.setGrupodocumentoIdgrupodocumento(item);
			logger.debug("loadGrupodocumento.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdgrupodocumento(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegGrupodocumento.event...");
			pe.com.sisabas.be.Grupodocumento item= (pe.com.sisabas.be.Grupodocumento) event.getObject();
			logger.debug("loadpacconsolidado.event...:"+item.getIdgrupodocumento());
			pacconsolidado.setIdgrupodocumento(item.getIdgrupodocumento());
			pacconsolidado.setGrupodocumentoIdgrupodocumento(item);
			logger.debug("loadGrupodocumento.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdgrupodocumento() {
		try {
			pacconsolidadoB.setIdgrupodocumento(null);
			pacconsolidadoB.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdgrupodocumento() {
		try {
			pacconsolidado.setIdgrupodocumento(null);
			pacconsolidado.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdunidadejecutora(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainUnidadejecutora.event...");
			pe.com.sisabas.be.Unidadejecutora item= (pe.com.sisabas.be.Unidadejecutora) event.getObject();
			logger.debug("loadpacconsolidado.event...:"+item.getIdunidadejecutora());
			pacconsolidadoB.setIdunidadejecutora(item.getIdunidadejecutora());
			pacconsolidadoB.setUnidadejecutoraIdunidadejecutora(item);
			logger.debug("loadUnidadejecutora.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdunidadejecutora(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegUnidadejecutora.event...");
			pe.com.sisabas.be.Unidadejecutora item= (pe.com.sisabas.be.Unidadejecutora) event.getObject();
			logger.debug("loadpacconsolidado.event...:"+item.getIdunidadejecutora());
			pacconsolidado.setIdunidadejecutora(item.getIdunidadejecutora());
			pacconsolidado.setUnidadejecutoraIdunidadejecutora(item);
			logger.debug("loadUnidadejecutora.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdunidadejecutora() {
		try {
			pacconsolidadoB.setIdunidadejecutora(null);
			pacconsolidadoB.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdunidadejecutora() {
		try {
			pacconsolidado.setIdunidadejecutora(null);
			pacconsolidado.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainVcertificacion(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainVcertificacion.event...");
			pe.com.sisabas.be.Vcertificacion item= (pe.com.sisabas.be.Vcertificacion) event.getObject();
			logger.debug("loadpacconsolidado.event...:"+item.getVcertificacion());
			pacconsolidadoB.setVcertificacion(item.getVcertificacion());
			pacconsolidadoB.setVcertificacionVcertificacion(item);
			logger.debug("loadVcertificacion.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegVcertificacion(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegVcertificacion.event...");
			pe.com.sisabas.be.Vcertificacion item= (pe.com.sisabas.be.Vcertificacion) event.getObject();
			logger.debug("loadpacconsolidado.event...:"+item.getVcertificacion());
			pacconsolidado.setVcertificacion(item.getVcertificacion());
			pacconsolidado.setVcertificacionVcertificacion(item);
			logger.debug("loadVcertificacion.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainVcertificacion() {
		try {
			pacconsolidadoB.setVcertificacion(null);
			pacconsolidadoB.setVcertificacionVcertificacion(new Vcertificacion());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegVcertificacion() {
		try {
			pacconsolidado.setVcertificacion(null);
			pacconsolidado.setVcertificacionVcertificacion(new Vcertificacion());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainVisidsigapaacconsolidado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainVissigapaacconsolidado.event...");
			pe.com.sisabas.be.Vissigapaacconsolidado item= (pe.com.sisabas.be.Vissigapaacconsolidado) event.getObject();
			logger.debug("loadpacconsolidado.event...:"+item.getVisidsigapaacconsolidado());
			pacconsolidadoB.setVisidsigapaacconsolidado(item.getVisidsigapaacconsolidado());
			pacconsolidadoB.setVissigapaacconsolidadoVisidsigapaacconsolidado(item);
			logger.debug("loadVissigapaacconsolidado.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegVisidsigapaacconsolidado(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegVissigapaacconsolidado.event...");
			pe.com.sisabas.be.Vissigapaacconsolidado item= (pe.com.sisabas.be.Vissigapaacconsolidado) event.getObject();
			logger.debug("loadpacconsolidado.event...:"+item.getVisidsigapaacconsolidado());
			pacconsolidado.setVisidsigapaacconsolidado(item.getVisidsigapaacconsolidado());
			pacconsolidado.setVissigapaacconsolidadoVisidsigapaacconsolidado(item);
			logger.debug("loadVissigapaacconsolidado.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainVisidsigapaacconsolidado() {
		try {
			pacconsolidadoB.setVisidsigapaacconsolidado(null);
			pacconsolidadoB.setVissigapaacconsolidadoVisidsigapaacconsolidado(new Vissigapaacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegVisidsigapaacconsolidado() {
		try {
			pacconsolidado.setVisidsigapaacconsolidado(null);
			pacconsolidado.setVissigapaacconsolidadoVisidsigapaacconsolidado(new Vissigapaacconsolidado());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/pacconsolidado/pacconsolidadoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmPacconsolidadoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmPacconsolidadoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Pacconsolidado record) throws Exception {
		if( pacconsolidado.getTieneprevision()!=null  && pacconsolidado.getTieneprevision().equalsIgnoreCase("1")){
			pacconsolidado.setBooleantieneprevision(true);
		}else {
			pacconsolidado.setBooleantieneprevision(false);
		}

		if( pacconsolidado.getFlagaprobacionestandarizacion()!=null  && pacconsolidado.getFlagaprobacionestandarizacion().equalsIgnoreCase("1")){
			pacconsolidado.setBooleanflagaprobacionestandarizacion(true);
		}else {
			pacconsolidado.setBooleanflagaprobacionestandarizacion(false);
		}

		if( pacconsolidado.getModalidadseleccion()!=null  && pacconsolidado.getModalidadseleccion().equalsIgnoreCase("1")){
			pacconsolidado.setBooleanmodalidadseleccion(true);
		}else {
			pacconsolidado.setBooleanmodalidadseleccion(false);
		}

		if( pacconsolidado.getModalidadcontratacion()!=null  && pacconsolidado.getModalidadcontratacion().equalsIgnoreCase("1")){
			pacconsolidado.setBooleanmodalidadcontratacion(true);
		}else {
			pacconsolidado.setBooleanmodalidadcontratacion(false);
		}

		if( pacconsolidado.getReajuste()!=null  && pacconsolidado.getReajuste().equalsIgnoreCase("1")){
			pacconsolidado.setBooleanreajuste(true);
		}else {
			pacconsolidado.setBooleanreajuste(false);
		}

		if( pacconsolidado.getFlagcd()!=null  && pacconsolidado.getFlagcd().equalsIgnoreCase("1")){
			pacconsolidado.setBooleanflagcd(true);
		}else {
			pacconsolidado.setBooleanflagcd(false);
		}

		if( pacconsolidado.getIndagacionvalorestimado()!=null  && pacconsolidado.getIndagacionvalorestimado().equalsIgnoreCase("1")){
			pacconsolidado.setBooleanindagacionvalorestimado(true);
		}else {
			pacconsolidado.setBooleanindagacionvalorestimado(false);
		}

	}

	public void setPacconsolidado(Pacconsolidado pacconsolidado){
		this.pacconsolidado=pacconsolidado;
	}

	public Pacconsolidado getPacconsolidado(){
		return pacconsolidado;
	}

	public void setPacconsolidadoB(Pacconsolidado pacconsolidadoB){
		this.pacconsolidadoB = pacconsolidadoB;
	}

	public Pacconsolidado getPacconsolidadoB(){
		return pacconsolidadoB;
	}

	public void setSelectedPacconsolidado(Pacconsolidado selectedPacconsolidado){
		this.selectedPacconsolidado = selectedPacconsolidado;
	}

	public Pacconsolidado getSelectedPacconsolidado(){
		return selectedPacconsolidado;
	}

	public void setListaPacconsolidado(List<Pacconsolidado> listaPacconsolidado){
		this.listaPacconsolidado=listaPacconsolidado;
	}

	public List<Pacconsolidado> getListaPacconsolidado(){
		return listaPacconsolidado;
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

	public void setListaGentablaIdcatalogoestadopac(List<Gentabla> listaGentablaIdcatalogoestadopac){
		this.listaGentablaIdcatalogoestadopac=listaGentablaIdcatalogoestadopac;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadopac(){
		return listaGentablaIdcatalogoestadopac;
	}

	public void setListaGentablaIdcatalogotipobien(List<Gentabla> listaGentablaIdcatalogotipobien){
		this.listaGentablaIdcatalogotipobien=listaGentablaIdcatalogotipobien;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipobien(){
		return listaGentablaIdcatalogotipobien;
	}

	public void setListaGentablaIdcatalogotiponecesidad(List<Gentabla> listaGentablaIdcatalogotiponecesidad){
		this.listaGentablaIdcatalogotiponecesidad=listaGentablaIdcatalogotiponecesidad;
	}

	public List<Gentabla> getListaGentablaIdcatalogotiponecesidad(){
		return listaGentablaIdcatalogotiponecesidad;
	}

	public void setListaGentablaIdcatalogotipocontratacion(List<Gentabla> listaGentablaIdcatalogotipocontratacion){
		this.listaGentablaIdcatalogotipocontratacion=listaGentablaIdcatalogotipocontratacion;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipocontratacion(){
		return listaGentablaIdcatalogotipocontratacion;
	}


	private List<String> listaIdcatalogoestadopacKeys;
	private String valuesIdcatalogoestadopac;
	public void handleChangeIdcatalogoestadopac(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogoestadopac();
		}else{
			listaIdcatalogoestadopacKeys=new ArrayList<String>();
			valuesIdcatalogoestadopac=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogoestadopac(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogoestadopacKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogoestadopac) {
			listaIdcatalogoestadopacKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogoestadopac=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogoestadopac(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogoestadopacKeys) {
			sbTmp.append(getValueIdcatalogoestadopac(key)+", ");
		}
		valuesIdcatalogoestadopac=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogoestadopacKeys.size()==0)
			valuesIdcatalogoestadopac=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogoestadopac(String key){
		for (Gentabla s : listaGentablaIdcatalogoestadopac) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogoestadopacKeys() {
		return listaIdcatalogoestadopacKeys;
	}

	public void setListaIdcatalogoestadopacKeys(List<String> listaIdcatalogoestadopacKeys) {
		this.listaIdcatalogoestadopacKeys = listaIdcatalogoestadopacKeys;
	}

	 public String getValuesIdcatalogoestadopac() {
		return valuesIdcatalogoestadopac;
	}

	public void setValuesIdcatalogoestadopac(String valuesIdcatalogoestadopac) {
		this.valuesIdcatalogoestadopac = valuesIdcatalogoestadopac;
	}

///////////////////////////////

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

	private List<String> listaIdcatalogotiponecesidadKeys;
	private String valuesIdcatalogotiponecesidad;
	public void handleChangeIdcatalogotiponecesidad(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogotiponecesidad();
		}else{
			listaIdcatalogotiponecesidadKeys=new ArrayList<String>();
			valuesIdcatalogotiponecesidad=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogotiponecesidad(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogotiponecesidadKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogotiponecesidad) {
			listaIdcatalogotiponecesidadKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogotiponecesidad=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogotiponecesidad(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogotiponecesidadKeys) {
			sbTmp.append(getValueIdcatalogotiponecesidad(key)+", ");
		}
		valuesIdcatalogotiponecesidad=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogotiponecesidadKeys.size()==0)
			valuesIdcatalogotiponecesidad=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogotiponecesidad(String key){
		for (Gentabla s : listaGentablaIdcatalogotiponecesidad) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogotiponecesidadKeys() {
		return listaIdcatalogotiponecesidadKeys;
	}

	public void setListaIdcatalogotiponecesidadKeys(List<String> listaIdcatalogotiponecesidadKeys) {
		this.listaIdcatalogotiponecesidadKeys = listaIdcatalogotiponecesidadKeys;
	}

	 public String getValuesIdcatalogotiponecesidad() {
		return valuesIdcatalogotiponecesidad;
	}

	public void setValuesIdcatalogotiponecesidad(String valuesIdcatalogotiponecesidad) {
		this.valuesIdcatalogotiponecesidad = valuesIdcatalogotiponecesidad;
	}

///////////////////////////////

	private List<String> listaIdcatalogotipocontratacionKeys;
	private String valuesIdcatalogotipocontratacion;
	public void handleChangeIdcatalogotipocontratacion(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdcatalogotipocontratacion();
		}else{
			listaIdcatalogotipocontratacionKeys=new ArrayList<String>();
			valuesIdcatalogotipocontratacion=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdcatalogotipocontratacion(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdcatalogotipocontratacionKeys=new ArrayList<String>();
		for (Gentabla s : listaGentablaIdcatalogotipocontratacion) {
			listaIdcatalogotipocontratacionKeys.add(String.valueOf(s.getVchregcodigo()));
			sbTmp.append(s.getVchregdescri()+", ");
		}
		valuesIdcatalogotipocontratacion=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdcatalogotipocontratacion(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdcatalogotipocontratacionKeys) {
			sbTmp.append(getValueIdcatalogotipocontratacion(key)+", ");
		}
		valuesIdcatalogotipocontratacion=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdcatalogotipocontratacionKeys.size()==0)
			valuesIdcatalogotipocontratacion=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdcatalogotipocontratacion(String key){
		for (Gentabla s : listaGentablaIdcatalogotipocontratacion) {
			if(String.valueOf(s.getVchregcodigo()).equalsIgnoreCase(key))
				return s.getVchregdescri().toString();
			}
		return "";
	}
	 public List<String> getListaIdcatalogotipocontratacionKeys() {
		return listaIdcatalogotipocontratacionKeys;
	}

	public void setListaIdcatalogotipocontratacionKeys(List<String> listaIdcatalogotipocontratacionKeys) {
		this.listaIdcatalogotipocontratacionKeys = listaIdcatalogotipocontratacionKeys;
	}

	 public String getValuesIdcatalogotipocontratacion() {
		return valuesIdcatalogotipocontratacion;
	}

	public void setValuesIdcatalogotipocontratacion(String valuesIdcatalogotipocontratacion) {
		this.valuesIdcatalogotipocontratacion = valuesIdcatalogotipocontratacion;
	}

///////////////////////////////



}

