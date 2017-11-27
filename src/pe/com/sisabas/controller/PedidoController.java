
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
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.business.PedidoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.PeriodoBusiness;
import pe.com.sisabas.be.Periodo;
import pe.com.sisabas.be.Vcentrocosto;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Unidadejecutora;
import pe.com.sisabas.be.Vispedido;



@Component(value ="pedido")
@Scope(value = "session")
public class PedidoController extends BaseController {

	private static final long serialVersionUID = 1L;
	private StreamedContent file;
	private Pedido pedidoB;
	private Pedido pedido;
	private Pedido selectedPedido;
	private List<Pedido> listaPedido;
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<Periodo> listaPeriodoIdperiodo;
	public List<Gentabla> listaGentablaIdcatalogotiponecesidad;
	public List<Gentabla> listaGentablaIdcatalogotipoet;

	private String accion;
	private String titulo;
	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	
	private String esDerivada="0";
	
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public PedidoBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;

	@Autowired
	public PeriodoBusiness periodoBusiness;



	//Nota: idOpcion, sicuopcion estan en BaseController
	private String idOpcionText = "OPC_PEDIDO";
	public PedidoController(){
			pedido = new Pedido();
			pedido.setVcentrocostoCodigocentrocosto(new Vcentrocosto());
			pedido.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
			pedido.setVispedidoIdvpedido(new Vispedido());

	}


	@PostConstruct
	public void init(){
		try {
			pedidoB = new Pedido();
			tituloBase = "PedidoIn » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			pedidoB.setVcentrocostoCodigocentrocosto(new Vcentrocosto());
			pedidoB.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
			pedidoB.setVispedidoIdvpedido(new Vispedido());

			listaIdcatalogotipobienKeys= new ArrayList<String>();
			listaIdperiodoKeys= new ArrayList<String>();
			listaIdcatalogotiponecesidadKeys= new ArrayList<String>();

			listaGentablaIdcatalogotipobien = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaPeriodoIdperiodo = periodoBusiness.selectDynamicBasic(new Periodo());
			listaGentablaIdcatalogotiponecesidad = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TINE));
			listaGentablaIdcatalogotipoet = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIET));
			

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
			List<String> ordenListaCampos = Arrays.asList("A1.nropedido");
			pedidoB.setOrdenListaCampos(ordenListaCampos);
			pedidoB.setOrdenTipo("DESC");

			//Add conditions IN clause
			pedidoB.addConditionInIdcatalogotipobien(listaIdcatalogotipobienKeys);
			pedidoB.addConditionInIdperiodo(listaIdperiodoKeys);
			pedidoB.addConditionInIdcatalogotiponecesidad(listaIdcatalogotiponecesidadKeys);

			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(pedidoB); //pasa a mayusculas los datos para la busqueda
			listaPedido = business.selectDynamicFull(pedidoB);
			setEsSeleccionado(false);
			setSelectedPedido(null);
			if (listaPedido.size() == 0)
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
			titulo = "PedidoIn » " + REGISTRAR;
			pedido = new Pedido();

			pedido.setBooleantiposinad(false);

			pedido.setIdpedido(new java.lang.Integer(0));
			pedido.setIdpedido((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_PEDIDO).longValue());
			pedido.setVcentrocostoCodigocentrocosto(new Vcentrocosto());
			pedido.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
			pedido.setVispedidoIdvpedido(new Vispedido());
			
			pedido.setIdcatalogotipobien(Constantes.tabla.TIBI3);


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
	DetallepedidoController detallepedidoController;
	public String irDetallepedido() {
		boolean validado=false;
		try {
			securityControlValidate("btnDetallepedido");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			detallepedidoController.setTituloParam(paramTitulo);
			detallepedidoController.init(pedido);

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
		if(validado) return "/pages/detallepedido/detallepedidoBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	@Autowired
	DocumentotecnicoController documentotecnicoController;
	public String irDocumentotecnico() {
		boolean validado=false;
		try {
			securityControlValidate("btnDocumentotecnico");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			documentotecnicoController.setTituloParam(paramTitulo);
			documentotecnicoController.init(pedido);

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
		if(validado) return "/pages/documentotecnico/documentotecnicoBuscar.xhtml?faces-redirect=true";
		else return null;
	}

	public String load() {
		return"/pages/pedido/pedidoBuscar.xhtml?faces-redirect=true";
	}

	public void irEditar() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditar");
			resetRegisterForm();
			validateSelectedRow();
			updateCharToBoolean(pedido);
			pedido.roundBigDecimals();
			accion = EDITAR;
			titulo = "PedidoIn » " + EDITAR;


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
			pedido.roundBigDecimals();
			accion = DETALLE;
			titulo = "PedidoIn » " + DETALLE;

			String paramTitulo = new String((tituloParam!=null?tituloParam:"")+" "+tituloBase);
			detallepedidoController.setTituloParam(paramTitulo);
			detallepedidoController.initDerivedTable(pedido);

			documentotecnicoController.setTituloParam(paramTitulo);
			documentotecnicoController.initDerivedTable(pedido);

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
			titulo = "PedidoIn » " + IMPRIMIR;

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
			if(pedido.getEstadoauditoria().equals("1")){
				accion = ANULAR;
			}else{
				accion = ACTIVAR;
			}
			titulo = "PedidoIn » " + accion;

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
			Pedido record= new Pedido();
			if(pedido.getEstadoauditoria().equals("1")){
				record.setEstadoauditoria("0");
			}else{
				record.setEstadoauditoria("1");
			}
			record.setIdpedido(pedido.getIdpedido());
			record.setUsuariomodificacionauditoria(getUserLogin());
			business.updateByPrimaryKeySelectiveBasic(record);

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPedidoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPedidoA", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPedidoA", e);
		}
	}

	public void setTemporalVars() throws Exception{
			pedido.setGentablaIdcatalogotipobien(gentablaBusiness.selectByPrimaryKeyBasicFromList(pedido.getIdcatalogotipobien(),listaGentablaIdcatalogotipobien));
			pedido.setPeriodoIdperiodo(periodoBusiness.selectByPrimaryKeyBasicFromList(pedido.getIdperiodo(),listaPeriodoIdperiodo));
			pedido.setGentablaIdcatalogotiponecesidad(gentablaBusiness.selectByPrimaryKeyBasicFromList(pedido.getIdcatalogotiponecesidad(),listaGentablaIdcatalogotiponecesidad));

	}
	public void aceptar() {
			REGISTER_INIT();
		try {
			if (accion.equals(REGISTRAR)){
				pedido.setUsuariocreacionauditoria(getUserLogin());
				pedido.setEquipoauditoria(getRemoteAddr());
				pedido.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.insertBasic(pedido);
			}else{
				pedido.setUsuariomodificacionauditoria(getUserLogin());
				pedido.setEquipoauditoria(getRemoteAddr());
				pedido.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				business.updateByPrimaryKeyBasic(pedido);
			}

			showGrowlMessageSuccessfullyCompletedAction();
			buscar();

			REGISTER_SUCCESS();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPedidoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsPedidoR", e.getMessage(),
			FacesMessage.SEVERITY_ERROR);
		} catch(DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),Messages.getString("exception.dataintegrity.message.detail"),
			FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsPedidoR", e);
		}
	}

	public void eliminar() {
		try {
			validateSelectedRow();
			pedido.setUsuariomodificacionauditoria(getUserLogin());
			business.deleteByPrimaryKeyBasic(pedido);
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
		if (selectedPedido == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			pedido = (Pedido)selectedPedido.clone();
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

	public void loadMainCodigocentrocosto(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainVcentrocosto.event...");
			pe.com.sisabas.be.Vcentrocosto item= (pe.com.sisabas.be.Vcentrocosto) event.getObject();
			logger.debug("loadpedido.event...:"+item.getCodigocentrocosto());
			pedidoB.setCodigocentrocosto(item.getCodigocentrocosto());
			pedidoB.setVcentrocostoCodigocentrocosto(item);
			logger.debug("loadVcentrocosto.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegCodigocentrocosto(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegVcentrocosto.event...");
			pe.com.sisabas.be.Vcentrocosto item= (pe.com.sisabas.be.Vcentrocosto) event.getObject();
			logger.debug("loadpedido.event...:"+item.getCodigocentrocosto());
			pedido.setCodigocentrocosto(item.getCodigocentrocosto());
			pedido.setVcentrocostoCodigocentrocosto(item);
			logger.debug("loadVcentrocosto.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainCodigocentrocosto() {
		try {
			pedidoB.setCodigocentrocosto(null);
			pedidoB.setVcentrocostoCodigocentrocosto(new Vcentrocosto());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegCodigocentrocosto() {
		try {
			pedido.setCodigocentrocosto(null);
			pedido.setVcentrocostoCodigocentrocosto(new Vcentrocosto());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdunidadejecutora(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainUnidadejecutora.event...");
			pe.com.sisabas.be.Unidadejecutora item= (pe.com.sisabas.be.Unidadejecutora) event.getObject();
			logger.debug("loadpedido.event...:"+item.getIdunidadejecutora());
			pedidoB.setIdunidadejecutora(item.getIdunidadejecutora());
			pedidoB.setUnidadejecutoraIdunidadejecutora(item);
			logger.debug("loadUnidadejecutora.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdunidadejecutora(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegUnidadejecutora.event...");
			pe.com.sisabas.be.Unidadejecutora item= (pe.com.sisabas.be.Unidadejecutora) event.getObject();
			logger.debug("loadpedido.event...:"+item.getIdunidadejecutora());
			pedido.setIdunidadejecutora(item.getIdunidadejecutora());
			pedido.setUnidadejecutoraIdunidadejecutora(item);
			logger.debug("loadUnidadejecutora.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdunidadejecutora() {
		try {
			pedidoB.setIdunidadejecutora(null);
			pedidoB.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdunidadejecutora() {
		try {
			pedido.setIdunidadejecutora(null);
			pedido.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void loadMainIdvpedido(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainVispedido.event...");
			pe.com.sisabas.be.Vispedido item= (pe.com.sisabas.be.Vispedido) event.getObject();
			logger.debug("loadpedido.event...:"+item.getIdvpedido());
			pedidoB.setIdvpedido(item.getIdvpedido());
			pedidoB.setVispedidoIdvpedido(item);
			logger.debug("loadVispedido.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void loadRegIdvpedido(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadRegVispedido.event...");
			pe.com.sisabas.be.Vispedido item= (pe.com.sisabas.be.Vispedido) event.getObject();
			logger.debug("loadpedido.event...:"+item.getIdvpedido());
			pedido.setIdvpedido(item.getIdvpedido());
			pedido.setVispedidoIdvpedido(item);
			logger.debug("loadVispedido.event...ok");
			resetRegisterForm();
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdvpedido() {
		try {
			pedidoB.setIdvpedido(null);
			pedidoB.setVispedidoIdvpedido(new Vispedido());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	public void resetRegIdvpedido() {
		try {
			pedido.setIdvpedido(null);
			pedido.setVispedidoIdvpedido(new Vispedido());
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}



	public String loadPage(){
		buscar();
		return "/pages/pedido/pedidoBuscar.xhtml?faces-redirect=true";
	}

	public void resetRegisterForm(){
		reset("frmPedidoRegistrar:panelC");
	}
	public void resetAnulacionForm(){
		reset("frmPedidoAnular:panelDetailC");
	}


	public void updateCharToBoolean(Pedido record) throws Exception {
		if( pedido.getTiposinad()!=null  && pedido.getTiposinad().equalsIgnoreCase("1")){
			pedido.setBooleantiposinad(true);
		}else {
			pedido.setBooleantiposinad(false);
		}

	}

	public void setPedido(Pedido pedido){
		this.pedido=pedido;
	}

	public Pedido getPedido(){
		return pedido;
	}

	public void setPedidoB(Pedido pedidoB){
		this.pedidoB = pedidoB;
	}

	public Pedido getPedidoB(){
		return pedidoB;
	}

	public void setSelectedPedido(Pedido selectedPedido){
		this.selectedPedido = selectedPedido;
	}

	public Pedido getSelectedPedido(){
		return selectedPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido){
		this.listaPedido=listaPedido;
	}

	public List<Pedido> getListaPedido(){
		return listaPedido;
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

	public void setListaPeriodoIdperiodo(List<Periodo> listaPeriodoIdperiodo){
		this.listaPeriodoIdperiodo=listaPeriodoIdperiodo;
	}

	public List<Periodo> getListaPeriodoIdperiodo(){
		return listaPeriodoIdperiodo;
	}

	public void setListaGentablaIdcatalogotiponecesidad(List<Gentabla> listaGentablaIdcatalogotiponecesidad){
		this.listaGentablaIdcatalogotiponecesidad=listaGentablaIdcatalogotiponecesidad;
	}

	public List<Gentabla> getListaGentablaIdcatalogotiponecesidad(){
		return listaGentablaIdcatalogotiponecesidad;
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

	private List<String> listaIdperiodoKeys;
	private String valuesIdperiodo;
	public void handleChangeIdperiodo(ToggleSelectEvent toggle){
		if(toggle.isSelected()){
			addAllItemsIdperiodo();
		}else{
			listaIdperiodoKeys=new ArrayList<String>();
			valuesIdperiodo=Messages.getString("selectmanycheckbox.noitems");
		}
	}
	private void addAllItemsIdperiodo(){
		StringBuilder sbTmp=new StringBuilder("");
		listaIdperiodoKeys=new ArrayList<String>();
		for (Periodo s : listaPeriodoIdperiodo) {
			listaIdperiodoKeys.add(String.valueOf(s.getIdperiodo()));
			sbTmp.append(s.getNombreperiodo()+", ");
		}
		valuesIdperiodo=Utils.borrarComitaFinal(sbTmp.toString());
	}
	public void getValuesListenerIdperiodo(){
		StringBuilder sbTmp=new StringBuilder("");
		for (String key : listaIdperiodoKeys) {
			sbTmp.append(getValueIdperiodo(key)+", ");
		}
		valuesIdperiodo=Utils.borrarComitaFinal(sbTmp.toString());
		if(listaIdperiodoKeys.size()==0)
			valuesIdperiodo=Messages.getString("selectmanycheckbox.noitems");
	}
	private String getValueIdperiodo(String key){
		for (Periodo s : listaPeriodoIdperiodo) {
			if(String.valueOf(s.getIdperiodo()).equalsIgnoreCase(key))
				return s.getNombreperiodo().toString();
			}
		return "";
	}
	 public List<String> getListaIdperiodoKeys() {
		return listaIdperiodoKeys;
	}

	public void setListaIdperiodoKeys(List<String> listaIdperiodoKeys) {
		this.listaIdperiodoKeys = listaIdperiodoKeys;
	}

	 public String getValuesIdperiodo() {
		return valuesIdperiodo;
	}

	public void setValuesIdperiodo(String valuesIdperiodo) {
		this.valuesIdperiodo = valuesIdperiodo;
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


	public List<Gentabla> getListaGentablaIdcatalogotipoet() {
		return listaGentablaIdcatalogotipoet;
	}


	public void setListaGentablaIdcatalogotipoet(List<Gentabla> listaGentablaIdcatalogotipoet) {
		this.listaGentablaIdcatalogotipoet = listaGentablaIdcatalogotipoet;
	}

	
	
	
///////////////////////////////



}

