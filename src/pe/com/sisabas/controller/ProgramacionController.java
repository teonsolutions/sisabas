package pe.com.sisabas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.taglibs.standard.lang.jstl.Evaluator;
import org.omg.CORBA.TRANSACTION_MODE;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.aop.target.CommonsPoolTargetSource;
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
import pe.com.sisabas.resources.UtilsSecurity;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicuusuario;

import java.rmi.RemoteException;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.be.Cuadrocomparativofuente;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.be.Entregable;
import pe.com.sisabas.business.CuadrocomparativofuenteBusiness;
import pe.com.sisabas.business.DocumentotecnicoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.ProgramacionBusiness;
import pe.com.sisabas.dto.CompraDirectaDatosGeneralesDto;
import pe.com.sisabas.dto.CuadroComparativoItemsDto;
import pe.com.sisabas.dto.CuadroComparativoRequest;
import pe.com.sisabas.dto.CuadroComparativoVrDto;
import pe.com.sisabas.dto.EvaluacionDocumentoRequest;
import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.Lugar;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.PacItemsDto;
import pe.com.sisabas.dto.PedidosPaoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.SeguimientoPagosResponse;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Orden;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.be.Requisitosconformidad;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;

import pe.com.sisabas.resources.controller.BaseController;

@Component(value = "programacion")
@Scope(value = "session")
public class ProgramacionController extends BaseController {
	private static final long serialVersionUID = 1L;

	// PROPERTIES
	private List<PaoResponse> listaPao;
	private PaoResponse selectedPao;
	private PaoRequest searchParam;
	private PaoResponse currentPao;
	private String tituloBase; // titulo de la opcion
	private String tituloParam;// titulo que llega como parametro (derivada
								// padre)
	// To functionality
	private boolean disabledTabEstudioMercado;
	private boolean disabledTabOrden;

	private String idOpcionText = "OPC_PAO";
	public List<Gentabla> listaGentablaIdcatalogoestadopac;
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<Gentabla> listaGentablaIdcatalogotiponecesidad;
	public List<Gentabla> listaGentablaIdcatalogotipocontratacion;
	private Cuadrocomparativofuente selectedCuadrocomparativofuente;
	public List<Gentabla> listaGentablaIdcatalogotipofuente;
	public List<Gentabla> listaGentablaIdcatalogomonedafuente;
	public List<Gentabla> listaGentablaIdcatalogoestadoentregable;
	public List<Gentabla> listaGentablaIdcatalogotipodocumento;

	// Direct
	public static String SUCCESS_ORDEN = "/pages/pao/ordenRegistrar.xhtml?faces-redirect=true;";

	// Estudio del mercado
	private List<Cuadrocomparativofuente> listaCuadrocomparativofuente;
	private Cuadrocomparativofuente cuadrocomparativofuente;
	private List<CuadroComparativoItemsDto> listaCuadroComparativoItems;
	private List<CuadroComparativoVrDto> listaCuadroComparativoVrFinal;
	private List<OrdenDto> listaOrden;
	private List<SeguimientoPagosResponse> listaSeguimientoPagosSiaf;
	private List<Entregable> listaEntregable;	
	private Requisitosconformidad requisitosconformidad;

	private boolean esSeleccionadoFuente;
	private String tituloFuente;
	private String tituloControlProducto;
	private boolean esSeleccionadoRequisito;

	// BUSINESS SECTION
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;

	@Autowired
	public GentablaBusiness gentablaBusiness;

	@Autowired
	public ProgramacionBusiness programacionBusiness;

	@Autowired
	public CuadrocomparativofuenteBusiness cuadroComparativoFuenteBusiness;

	public ProgramacionController() {

	}

	/* seleccionado */
	public void seleccionItemFuente(SelectEvent e) {
		esSeleccionadoFuente = true;
	}
	
	public void seleccionItemRequisito(SelectEvent e){
		esSeleccionadoRequisito = true;
	}

	@PostConstruct
	public void init() {
		try {
			searchParam = new PaoRequest(); // search parameters
			tituloBase = "PAO » ";
			if (SICU_SECURITY_ENABLE) {
				idOpcion = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}

			// ´Fill combo filters

			/*
			 * listaIdcatalogotipodocumentotecnicoKeys= new ArrayList<String>();
			 * listaIdcatalogotipotdrKeys= new ArrayList<String>();
			 * 
			 * listaGentablaIdcatalogotipodocumentotecnico =
			 * gentablaBusiness.selectDynamicBasic(new Gentabla());
			 * listaGentablaIdcatalogotipotdr =
			 * gentablaBusiness.selectDynamicBasic(new
			 * Gentabla().getObjBusqueda(Constantes.tabla.TITD));
			 */

			listaGentablaIdcatalogoestadopac = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EPAC));
			listaGentablaIdcatalogotipobien = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaGentablaIdcatalogotiponecesidad = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TINE));
			listaGentablaIdcatalogotipocontratacion = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TCON));
			listaGentablaIdcatalogotipodocumento = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.DPRO));			

			// Estudio del mercado
			listaGentablaIdcatalogotipofuente = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIFU));
			listaGentablaIdcatalogomonedafuente = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.MOFU));

			// Orden
			listaGentablaIdcatalogoestadoentregable = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EENT));			

		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	// METHODS
	public void buscarPao() {

		try {
			this.searchParam.setCodigoUnidadEjecutora(Constantes.unidadEjecutora.PRONIED);
			this.searchParam.setAnio(2017);
			this.searchParam.setPageNumber(1);
			this.searchParam.setPageSize(10);

			this.listaPao = programacionBusiness.getPaoListado(searchParam);
			this.setEsSeleccionado(false);
			if (listaPao.size() == 0)
				addMessageKey("msgsForm", Messages.getString("no.records.found"), FacesMessage.SEVERITY_INFO);

		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	// METHODS
	public void buscarFuente() {
		try {
			Cuadrocomparativofuente param = new Cuadrocomparativofuente();
			param.setIdpacconsolidado(this.currentPao.getIdPacConsolid());
			listaCuadrocomparativofuente = cuadroComparativoFuenteBusiness.selectDynamicFull(param);
			setEsSeleccionadoFuente(false);
			setSelectedCuadrocomparativofuente(null);
			if (listaCuadrocomparativofuente.size() == 0)
				addMessageKey("msgsForm", Messages.getString("no.records.found"), FacesMessage.SEVERITY_INFO);

		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscarOrden() {
		try {
			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			PaoRequest request = new PaoRequest();
			request.setAnio(usuario.getPeriodo().getAnio());
			request.setNroConsolid(currentPao.getNroConsolid());
			request.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);

			listaOrden = programacionBusiness.getCompraDirectaOrden(request);
			// setEsSeleccionadoFuente(false);
			// setSelectedCuadrocomparativofuente(null);
			if (listaOrden.size() == 0) {
				addMessageKey("msgsForm", Messages.getString("no.records.found"), FacesMessage.SEVERITY_INFO);
			} else {
				int nroExpediente = listaOrden.get(0).getNroExpedienteSiaf();
				request.setNroExpedienteSiaf(nroExpediente);
				listaSeguimientoPagosSiaf = programacionBusiness.getSeguimientoPagosSiaf(request);
			}

			// get orden registered in abas
			List<Orden> ordenDetail = programacionBusiness.getOrdenByPacConsolid(currentPao.getIdPacConsolid());
			// Obtiene entregables, hay un solo orden por Pac consolidado
			Integer armadas = null;
			if (ordenDetail.get(0).getIdorden() != null) {
				listaEntregable = programacionBusiness.getEntegablesByOrden(ordenDetail.get(0).getIdorden());
				armadas = listaEntregable.size() > 0 ? listaEntregable.size() : null;
			}

			for (int i = 0; i < listaOrden.size(); i++) {
				for (int j = 0; j < ordenDetail.size(); j++) {
					if (listaOrden.get(i).getNroOrden().toString().trim()
							.equals(ordenDetail.get(j).getNroorden().trim())) {
						listaOrden.get(i).setIdOrden(ordenDetail.get(j).getIdorden());
						listaOrden.get(i).setIdPacConsolidado(ordenDetail.get(j).getIdpacconsolidado());
						listaOrden.get(i).setFechaInicioPrestacion(ordenDetail.get(j).getFechainicioprestacion());
						listaOrden.get(i).setFechaFinPrestacion(ordenDetail.get(j).getFechafinprestacion());
						listaOrden.get(i).setPlazo(ordenDetail.get(j).getPlazoejecucion());
						listaOrden.get(i).setArmadas(armadas); // DEBE SER
																// ENTREGABLES
																// // .LENGHT
					}
				}
			}

			// Genera entregables
			// generateEntregable(2);
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetRegisterForm() {
		reset("frmCuadrocomparativofuenteRegistrar:panelC");
	}

	public void resetRegisterFormRequisito() {
		reset("resetRegisterFormRequisito:panelC");
	}
	
	public void validateSelectedRow() throws UnselectedRowException, CloneNotSupportedException {
		if (this.selectedPao == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			this.setCurrentPao((PaoResponse) this.selectedPao.clone());
	}

	public void validateSelectedRowFuente() throws UnselectedRowException, CloneNotSupportedException {
		if (this.selectedCuadrocomparativofuente == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			this.setCuadrocomparativofuente((Cuadrocomparativofuente) this.selectedCuadrocomparativofuente.clone());
	}

	public String ordenRegistrar() {
		logger.debug("paoRegistrar....");
		try {

			validateSelectedRow();
			if (this.esSeleccionado) {

			}
			if (this.currentPao == null) {
				this.currentPao = new PaoResponse();
			}

			this.setDisabledTabEstudioMercado(
					this.currentPao.getIdPacConsolid() == null || this.currentPao.getIdPacConsolid() == 0);
			this.setDisabledTabOrden(
					this.currentPao.getIdPacConsolid() == null || this.currentPao.getIdPacConsolid() == 0);

			PaoRequest record = new PaoRequest();
			record.setIdUnidadEjecutora(1);
			record.setAnio(2017);
			record.setNroConsolid(this.currentPao.getNroConsolid());
			record.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);
			CompraDirectaDatosGeneralesDto cd = programacionBusiness.getCompraDirectaDatosGenerales(record);
			this.currentPao.setCompraDirecta(cd);

			/*
			 * } catch (RemoteException e) { STATUS_ERROR();
			 * addMessageKey("msgsForm",
			 * Messages.getString("sicu.remote.exeption"),e.getMessage(),
			 * FacesMessage.SEVERITY_ERROR); return "/login.xhtml"; } catch
			 * (ValidateException e) { addMessage(e.getMessage(),
			 * FacesMessage.SEVERITY_ERROR); return "/login.xhtml";
			 */

			// Estudio del Mercado
			buscarFuente();
			buscarValorReferencialFinal();
			buscarOrden();

		} catch (Exception e) {
			addErrorMessage(e);
			return "/login.xhtml";
		}

		return SUCCESS_ORDEN;
	}

	public void guardarDatosGenerales() {
		REGISTER_INIT();
		try {

			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			if (usuario == null) {
				REGISTER_ERROR();
				addMessageKey("msgsDocumentotecnicoR", "Teminó la sesión", FacesMessage.SEVERITY_ERROR);
				return;
			}

			CompraDirectaDatosGeneralesDto compraDirecta = this.currentPao.getCompraDirecta();
			if (!compraDirecta.getEstadoRequerimiento().equals(Constantes.estadosPorEtapa.EN_GIRO_DE_ORDEN)) {
				securityControlValidate("btnGuadarDatosGenerales");

				CompraDirectaDatosGeneralesDto cDirecta = (CompraDirectaDatosGeneralesDto) compraDirecta.clone();
				cDirecta.setIdTipoNecesidad(this.currentPao.getIdTipoNecesidad());
				cDirecta.setIdUnidadEjecutora(Constantes.unidadEjecutora.ID_UNIDAD_EJECUTORA_ABAS);
				cDirecta.setAnio(usuario.getPeriodo().getAnio());
				cDirecta.setCodigoCentroCosto(usuario.getPeriodo().getCodigoCentroCosto());
				cDirecta.setIdTipoContratacion(Constantes.tipoContratacion.NO_PAC);
				cDirecta.setTipoProceso(Constantes.maestroProcesoSiga.ADJUDIACION_SIN_PROCESO);

				// VALIDAR SI ESTÁ EN GIRO DE ORDEN O ESTUDIO DEL MERCADO
				cDirecta.setEstadoRequerimiento(Constantes.estadosPorEtapa.EN_GIRO_DE_ORDEN);

				TransactionRequest<CompraDirectaDatosGeneralesDto> transactionRequest = new TransactionRequest<CompraDirectaDatosGeneralesDto>();
				transactionRequest.setUsuarioAuditoria("PRUEBA");
				transactionRequest.setEquipoAuditoria("MI PC");
				transactionRequest.setEntityTransaction(cDirecta);
				Resultado result = programacionBusiness.grabarCompraDirecta(transactionRequest);

				REGISTER_SUCCESS();
				buscarPao();
			}
			showGrowlMessageSuccessfullyCompletedAction();
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsDocumentotecnicoR", e);
		}
	}

	public void guardarOrden() {
		REGISTER_INIT();
		try {

			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			if (usuario == null) {
				REGISTER_ERROR();
				addMessageKey("msgsDocumentotecnicoR", "Teminó la sesión", FacesMessage.SEVERITY_ERROR);
				return;
			}

			for (int i = 0; i < listaOrden.size(); i++) {
				listaOrden.get(i).setAnio(usuario.getPeriodo().getAnio());
				listaOrden.get(i).setCodigoCentroCosto(usuario.getPeriodo().getCodigoCentroCosto());
				listaOrden.get(i).setIdPacConsolidado(currentPao.getIdPacConsolid());
				listaOrden.get(i).setMoneda(Constantes.moneda.SOLES);
				listaOrden.get(i).setIdUnidadEjecutora(Constantes.unidadEjecutora.ID_UNIDAD_EJECUTORA_ABAS);
			}
			listaOrden.get(0).setEntegables(listaEntregable); // se asume hay un
																// sólo orden
																// por pac
																// consolidado

			TransactionRequest<List<OrdenDto>> request = new TransactionRequest<List<OrdenDto>>();
			request.setUsuarioAuditoria("PRUEBA");
			request.setEquipoAuditoria("MI PC");
			request.setEntityTransaction(listaOrden);
			programacionBusiness.grabarOrden(request);
			REGISTER_SUCCESS();
			showGrowlMessageSuccessfullyCompletedAction();

		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsDocumentotecnicoR", e.getMessage(), FacesMessage.SEVERITY_ERROR);

		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsDocumentotecnicoR", e);
		}
	}

	public void irRegistrarFuente() {
		STATUS_INIT();
		try {

			securityControlValidate("btnNuevoEM");
			resetRegisterForm();
			this.tituloFuente = "Cuadro comprarativo » " + REGISTRAR;
			this.cuadrocomparativofuente = new Cuadrocomparativofuente();
			this.cuadrocomparativofuente.setBooleanproveedordedicacontratacion(false);
			this.cuadrocomparativofuente.setBooleanusuarioparticiportm(false);
			this.cuadrocomparativofuente.setBooleancumplertm(false);
			this.cuadrocomparativofuente.setBooleansetomoencuenta(false);
			this.cuadrocomparativofuente.setIdcuadrocomparativofuente(new java.lang.Integer(0));
			this.cuadrocomparativofuente.setIdcuadrocomparativofuente(0);

			// Items del cuadro comparativo
			CuadroComparativoRequest request = new CuadroComparativoRequest();
			request.setIdPacConsolidado(this.currentPao.getIdPacConsolid());
			request.setIdCuadroComparativoFuente(this.cuadrocomparativofuente.getIdcuadrocomparativofuente());
			this.listaCuadroComparativoItems = this.programacionBusiness.getCuadroComparativoItemsByConsolid(request);

			STATUS_SUCCESS();
			REGISTER_INIT();
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}
	
	public void irRegistrarControl() {
		STATUS_INIT();
		try {
			securityControlValidate("btnNuevoControl");
			resetRegisterFormRequisito();
			this.tituloControlProducto = "Control de producto » " + REGISTRAR;
			requisitosconformidad = new Requisitosconformidad();
			requisitosconformidad.setIdrequisitoconformidad(0);
			STATUS_SUCCESS();
			REGISTER_INIT();
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}	

	public void irEditarFuente() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEditarEM");
			resetRegisterForm();
			validateSelectedRowFuente();
			updateCharToBoolean(cuadrocomparativofuente);
			cuadrocomparativofuente.roundBigDecimals();
			this.tituloFuente = "Cuadro comprarativo » " + EDITAR;

			// Items del cuadro comparativo
			CuadroComparativoRequest request = new CuadroComparativoRequest();
			request.setIdPacConsolidado(this.currentPao.getIdPacConsolid());
			request.setIdCuadroComparativoFuente(this.cuadrocomparativofuente.getIdcuadrocomparativofuente());
			this.listaCuadroComparativoItems = this.programacionBusiness.getCuadroComparativoItems(request);

			STATUS_SUCCESS();
			REGISTER_INIT();
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void irEliminarFuente() {
		STATUS_INIT();
		try {
			securityControlValidate("btnEliminarEM");
			validateSelectedRowFuente();

			STATUS_SUCCESS();
		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			STATUS_ERROR();
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			STATUS_ERROR();
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void eliminarFuente() {
		try {
			validateSelectedRowFuente();

			/*
			 * cuadrocomparativofuente.setUsuariomodificacionauditoria(
			 * getUserLogin());
			 * cuadroComparativoFuenteBusiness.deleteByPrimaryKeyBasic(
			 * cuadrocomparativofuente);
			 */
			TransactionRequest<Cuadrocomparativofuente> request = new TransactionRequest<Cuadrocomparativofuente>();
			request.setEntityTransaction(cuadrocomparativofuente);
			programacionBusiness.eliminarCuadroComparativo(request);

			showGrowlMessageSuccessfullyCompletedAction();
			buscarFuente();
		} catch (ValidateException e) {
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (UnselectedRowException e) {
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void updateCharToBoolean(Cuadrocomparativofuente record) throws Exception {
		if (cuadrocomparativofuente.getProveedordedicacontratacion() != null
				&& cuadrocomparativofuente.getProveedordedicacontratacion().equalsIgnoreCase("1")) {
			cuadrocomparativofuente.setBooleanproveedordedicacontratacion(true);
		} else {
			cuadrocomparativofuente.setBooleanproveedordedicacontratacion(false);
		}

		if (cuadrocomparativofuente.getUsuarioparticiportm() != null
				&& cuadrocomparativofuente.getUsuarioparticiportm().equalsIgnoreCase("1")) {
			cuadrocomparativofuente.setBooleanusuarioparticiportm(true);
		} else {
			cuadrocomparativofuente.setBooleanusuarioparticiportm(false);
		}

		if (cuadrocomparativofuente.getCumplertm() != null
				&& cuadrocomparativofuente.getCumplertm().equalsIgnoreCase("1")) {
			cuadrocomparativofuente.setBooleancumplertm(true);
		} else {
			cuadrocomparativofuente.setBooleancumplertm(false);
		}

		if (cuadrocomparativofuente.getSetomoencuenta() != null
				&& cuadrocomparativofuente.getSetomoencuenta().equalsIgnoreCase("1")) {
			cuadrocomparativofuente.setBooleansetomoencuenta(true);
		} else {
			cuadrocomparativofuente.setBooleansetomoencuenta(false);
		}

	}

	public void aceptarFuente() {
		REGISTER_INIT();
		try {
			if (this.cuadrocomparativofuente.getIdcuadrocomparativofuente() == null
					|| this.cuadrocomparativofuente.getIdcuadrocomparativofuente() == 0) {
				this.cuadrocomparativofuente.setUsuariocreacionauditoria(getUserLogin());
				this.cuadrocomparativofuente.setEquipoauditoria(getRemoteAddr());
				this.cuadrocomparativofuente
						.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				this.cuadrocomparativofuente.setIdpacconsolidado(this.getCurrentPao().getIdPacConsolid());

				this.cuadrocomparativofuente.setIdcatalogotipobien(this.currentPao.getIdTipoBien());

				/*
				 * this.cuadrocomparativofuente.setIdcuadrocomparativofuente((
				 * int) utilsBusiness
				 * .getNextSeq(pe.com.sisabas.resources.Sequence.
				 * SEQ_CUADROCOMPARATIVOFUENTE).longValue());
				 * this.cuadroComparativoFuenteBusiness.insertBasic(this.
				 * cuadrocomparativofuente);
				 */

			} else {
				this.cuadrocomparativofuente.setUsuariomodificacionauditoria(getUserLogin());
				this.cuadrocomparativofuente.setEquipoauditoria(getRemoteAddr());
				this.cuadrocomparativofuente
						.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
				/*
				 * this.cuadroComparativoFuenteBusiness.updateByPrimaryKeyBasic(
				 * this.cuadrocomparativofuente);
				 */
			}

			TransactionRequest<Cuadrocomparativofuente> request = new TransactionRequest<Cuadrocomparativofuente>();
			request.setEquipoAuditoria(getRemoteAddr());
			request.setUsuarioAuditoria(getUserLogin());
			request.setEntityTransaction(this.cuadrocomparativofuente);
			programacionBusiness.grabarCuadroComparativo(request, this.listaCuadroComparativoItems);
			showGrowlMessageSuccessfullyCompletedAction();
			buscarFuente();
			buscarValorReferencialFinal();

			REGISTER_SUCCESS();
			showGrowlMessageSuccessfullyCompletedAction();

		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativofuenteR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativofuenteR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsCuadrocomparativofuenteR", e);
		}
	}

	public void aceptarControl() {
		REGISTER_INIT();
		try {
			if (this.requisitosconformidad.getIdrequisitoconformidad() == null
					|| this.requisitosconformidad.getIdrequisitoconformidad() == 0) {
				if (this.currentPao.getListaRequisitosConformidad() == null)
					this.currentPao.setListaRequisitosConformidad(new ArrayList<Requisitosconformidad>());
				this.currentPao.getListaRequisitosConformidad().add(this.requisitosconformidad);				
			}

			REGISTER_SUCCESS();
			showGrowlMessageSuccessfullyCompletedAction();
/*
		} catch (ValidateException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativofuenteR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (BusinessException e) {
			REGISTER_ERROR();
			addMessageKey("msgsCuadrocomparativofuenteR", e.getMessage(), FacesMessage.SEVERITY_ERROR);
			*/
		} catch (DataIntegrityViolationException e) {
			addMessageKey("msgsForm", Messages.getString("exception.dataintegrity.message.title"),
					Messages.getString("exception.dataintegrity.message.detail"), FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			REGISTER_ERROR();
			addErrorMessageKey("msgsCuadrocomparativofuenteR", e);
		}
	}
	
	public void buscarValorReferencialFinal() {
		try {

			listaCuadroComparativoVrFinal = programacionBusiness
					.getCuadroComparativoVrFinal(currentPao.getIdPacConsolid());
			if (listaCuadroComparativoVrFinal.size() == 0)
				addMessageKey("msgsForm", Messages.getString("no.records.found"), FacesMessage.SEVERITY_INFO);

		} catch (SecuritySessionExpiredException e) {
			redirectSessionExpiredPage();
		} catch (SecurityRestrictedControlException e) {
			addMessageKey("msgsForm", Messages.getString("no.access"), e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (SecurityValidateException e) {
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"), e.getMessage(),
					FacesMessage.SEVERITY_ERROR);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	private void generateEntregable(int armadas) {
		int pago = 1;
		if (listaEntregable == null)
			listaEntregable = new ArrayList<Entregable>();
		int nroEntregables = this.listaEntregable.size();

		if (armadas > nroEntregables) {
			for (int i = 1; i <= armadas - nroEntregables; i++) {
				Entregable item = new Entregable();
				item.setNroentregable("Pago " + (i + nroEntregables));
				this.listaEntregable.add(item);
				pago++;
			}
		} else if (armadas < nroEntregables) {
			this.listaEntregable.clear();
			// nroEntregables - armadas
			for (int i = 1; i <= armadas; i++) {
				Entregable item = new Entregable();
				item.setNroentregable("Pago " + (i));
				this.listaEntregable.add(item);
				pago++;
			}
		}
	}

	// DATATABLE EDITABLE
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se editó correctamente",
				"Orden: " + ((OrdenDto) event.getObject()).getNroOrden());

		// Cal final date
		Integer plazo = ((OrdenDto) event.getObject()).getPlazo();
		Integer armadas = ((OrdenDto) event.getObject()).getArmadas();
		if (plazo != null) {
			Date inicio = ((OrdenDto) event.getObject()).getFechaInicioPrestacion();
			Calendar c = Calendar.getInstance();
			c.setTime(inicio);
			c.add(c.DATE, plazo);
			Date fin = c.getTime();
			((OrdenDto) event.getObject()).setFechaFinPrestacion(fin);
		}

		generateEntregable(armadas);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló la edición",
				"Orden: " + ((OrdenDto) event.getObject()).getNroOrden());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	// PROPERTIES
	public List<PaoResponse> getListaPao() {
		return listaPao;
	}

	public void setListaPao(List<PaoResponse> listaPao) {
		this.listaPao = listaPao;
	}

	public PaoResponse getSelectedPao() {
		return selectedPao;
	}

	public void setSelectedPao(PaoResponse selectedPao) {
		this.selectedPao = selectedPao;
	}

	public PaoRequest getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(PaoRequest searchParam) {
		this.searchParam = searchParam;
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

	public PaoResponse getCurrentPao() {
		return currentPao;
	}

	public void setCurrentPao(PaoResponse currentPao) {
		this.currentPao = currentPao;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadopac() {
		return listaGentablaIdcatalogoestadopac;
	}

	public void setListaGentablaIdcatalogoestadopac(List<Gentabla> listaGentablaIdcatalogoestadopac) {
		this.listaGentablaIdcatalogoestadopac = listaGentablaIdcatalogoestadopac;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipobien() {
		return listaGentablaIdcatalogotipobien;
	}

	public void setListaGentablaIdcatalogotipobien(List<Gentabla> listaGentablaIdcatalogotipobien) {
		this.listaGentablaIdcatalogotipobien = listaGentablaIdcatalogotipobien;
	}

	public List<Gentabla> getListaGentablaIdcatalogotiponecesidad() {
		return listaGentablaIdcatalogotiponecesidad;
	}

	public void setListaGentablaIdcatalogotiponecesidad(List<Gentabla> listaGentablaIdcatalogotiponecesidad) {
		this.listaGentablaIdcatalogotiponecesidad = listaGentablaIdcatalogotiponecesidad;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipocontratacion() {
		return listaGentablaIdcatalogotipocontratacion;
	}

	public void setListaGentablaIdcatalogotipocontratacion(List<Gentabla> listaGentablaIdcatalogotipocontratacion) {
		this.listaGentablaIdcatalogotipocontratacion = listaGentablaIdcatalogotipocontratacion;
	}

	public boolean isDisabledTabEstudioMercado() {
		return disabledTabEstudioMercado;
	}

	public void setDisabledTabEstudioMercado(boolean disabledTabEstudioMercado) {
		this.disabledTabEstudioMercado = disabledTabEstudioMercado;
	}

	public boolean isDisabledTabOrden() {
		return disabledTabOrden;
	}

	public void setDisabledTabOrden(boolean disabledTabOrden) {
		this.disabledTabOrden = disabledTabOrden;
	}

	public Cuadrocomparativofuente getCuadrocomparativofuente() {
		return cuadrocomparativofuente;
	}

	public void setCuadrocomparativofuente(Cuadrocomparativofuente cuadrocomparativofuente) {
		this.cuadrocomparativofuente = cuadrocomparativofuente;
	}

	public List<Cuadrocomparativofuente> getListaCuadrocomparativofuente() {
		return listaCuadrocomparativofuente;
	}

	public void setListaCuadrocomparativofuente(List<Cuadrocomparativofuente> listaCuadrocomparativofuente) {
		this.listaCuadrocomparativofuente = listaCuadrocomparativofuente;
	}

	public Cuadrocomparativofuente getSelectedCuadrocomparativofuente() {
		return selectedCuadrocomparativofuente;
	}

	public void setSelectedCuadrocomparativofuente(Cuadrocomparativofuente selectedCuadrocomparativofuente) {
		this.selectedCuadrocomparativofuente = selectedCuadrocomparativofuente;
	}

	public boolean isEsSeleccionadoFuente() {
		return esSeleccionadoFuente;
	}

	public void setEsSeleccionadoFuente(boolean esSeleccionadoFuente) {
		this.esSeleccionadoFuente = esSeleccionadoFuente;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipofuente() {
		return listaGentablaIdcatalogotipofuente;
	}

	public void setListaGentablaIdcatalogotipofuente(List<Gentabla> listaGentablaIdcatalogotipofuente) {
		this.listaGentablaIdcatalogotipofuente = listaGentablaIdcatalogotipofuente;
	}

	public List<Gentabla> getListaGentablaIdcatalogomonedafuente() {
		return listaGentablaIdcatalogomonedafuente;
	}

	public void setListaGentablaIdcatalogomonedafuente(List<Gentabla> listaGentablaIdcatalogomonedafuente) {
		this.listaGentablaIdcatalogomonedafuente = listaGentablaIdcatalogomonedafuente;
	}

	public String getTituloFuente() {
		return tituloFuente;
	}

	public void setTituloFuente(String tituloFuente) {
		this.tituloFuente = tituloFuente;
	}

	public List<CuadroComparativoItemsDto> getListaCuadroComparativoItems() {
		return listaCuadroComparativoItems;
	}

	public void setListaCuadroComparativoItems(List<CuadroComparativoItemsDto> listaCuadroComparativoItems) {
		this.listaCuadroComparativoItems = listaCuadroComparativoItems;
	}

	public List<CuadroComparativoVrDto> getListaCuadroComparativoVrFinal() {
		return listaCuadroComparativoVrFinal;
	}

	public void setListaCuadroComparativoVrFinal(List<CuadroComparativoVrDto> listaCuadroComparativoVrFinal) {
		this.listaCuadroComparativoVrFinal = listaCuadroComparativoVrFinal;
	}

	public List<OrdenDto> getListaOrden() {
		return listaOrden;
	}

	public void setListaOrden(List<OrdenDto> listaOrden) {
		this.listaOrden = listaOrden;
	}

	public List<SeguimientoPagosResponse> getListaSeguimientoPagosSiaf() {
		return listaSeguimientoPagosSiaf;
	}

	public void setListaSeguimientoPagosSiaf(List<SeguimientoPagosResponse> listaSeguimientoPagosSiaf) {
		this.listaSeguimientoPagosSiaf = listaSeguimientoPagosSiaf;
	}

	public List<Entregable> getListaEntregable() {
		return listaEntregable;
	}

	public void setListaEntregable(List<Entregable> listaEntregable) {
		this.listaEntregable = listaEntregable;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadoentregable() {
		return listaGentablaIdcatalogoestadoentregable;
	}

	public void setListaGentablaIdcatalogoestadoentregable(List<Gentabla> listaGentablaIdcatalogoestadoentregable) {
		this.listaGentablaIdcatalogoestadoentregable = listaGentablaIdcatalogoestadoentregable;
	}
	
	public List<Gentabla> getListaGentablaIdcatalogotipodocumento() {
		return listaGentablaIdcatalogotipodocumento;
	}

	public void setListaGentablaIdcatalogotipodocumento(List<Gentabla> listaGentablaIdcatalogotipodocumento) {
		this.listaGentablaIdcatalogotipodocumento = listaGentablaIdcatalogotipodocumento;
	}	

	public Requisitosconformidad getRequisitosconformidad() {
		return requisitosconformidad;
	}

	public void setRequisitosconformidad(Requisitosconformidad requisitosconformidad) {
		this.requisitosconformidad = requisitosconformidad;
	}
	
	public String getTituloControlProducto() {
		return tituloControlProducto;
	}

	public void setTituloControlProducto(String tituloControlProducto) {
		this.tituloControlProducto = tituloControlProducto;
	}
	
	public boolean isEsSeleccionadoRequisito() {
		return esSeleccionadoRequisito;
	}

	public void setEsSeleccionadoRequisito(boolean esSeleccionadoRequisito) {
		this.esSeleccionadoRequisito = esSeleccionadoRequisito;
	}
}
