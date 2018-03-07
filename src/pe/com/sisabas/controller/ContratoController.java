package pe.com.sisabas.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Adenda;
import pe.com.sisabas.be.Contrato;
import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;
import pe.com.sisabas.be.Entregable;
import pe.com.sisabas.be.Evaluaciondocumento;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.be.Orden;
import pe.com.sisabas.be.Procesoseleccion;
import pe.com.sisabas.be.Unidadejecutora;
import pe.com.sisabas.business.AdendaBusiness;
import pe.com.sisabas.business.ContratoBusiness;
import pe.com.sisabas.business.EntregableBusiness;
import pe.com.sisabas.business.EvaluaciondocumentoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.OrdenBusiness;
import pe.com.sisabas.business.ProcesoseleccionBusiness;
import pe.com.sisabas.business.ProgramacionBusiness;
import pe.com.sisabas.business.VcentrocostoBusiness;
import pe.com.sisabas.dto.AdendaDto;
import pe.com.sisabas.dto.CentroCostoRequest;
import pe.com.sisabas.dto.CentroCostoResponse;
import pe.com.sisabas.dto.ContratoDto;
import pe.com.sisabas.dto.ContratoExport;
import pe.com.sisabas.dto.EntregableDto;
import pe.com.sisabas.dto.EstadoRequerimientoResponse;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.OrdenListaDto;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.SegRequest;
import pe.com.sisabas.dto.SegResponse;
import pe.com.sisabas.dto.SeguimientoPagosResponse;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.exception.UnselectedRowException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.Sicuusuario;

@Component(value = "contrato")
@Scope(value = "session")
public class ContratoController extends BaseController {
	
	private boolean value1;
	private boolean value2;
	private boolean value3;
	private boolean value4;
	private boolean value5;
	private boolean value6;
	private boolean value7;
	private boolean value8;
	private boolean value9;
	private boolean value10;
	private boolean value11;
	private boolean value12;
	
	private Integer seqContrato;

	private static List<EntregableDto> listaEntregable=new ArrayList<>();

	private static List<SeguimientoPagosResponse> detallePago=new ArrayList<>();

    private boolean adicionales = false;
	
	private Sicuusuario usuario;

	private static final long serialVersionUID = 1L;

	private boolean avanzado = false;

	private boolean value;

	private List<String> listaIdcatalogosistemaadquisicionKeys;

	public List<Gentabla> listaGentablaIdcatalogoestadodocumentacion;

	private static List<OrdenDto> listaOrden = new ArrayList<>();
	private static List<OrdenDto> ordenesEliminar = new ArrayList<>();
	private static List<AdendaDto> listaAdendas = new ArrayList<>();

	private List<OrdenDto> listaOrden2 = new ArrayList<>();

	private PaoResponse currentPao;

	private Contrato contratoB;

	private List<Integer> listaAnio;

	private OrdenListaDto ordenListaDto;
	private OrdenDto selectOrden;

	private OrdenDto orden1;
	
	private AdendaDto selectAdenda;

	private List<OrdenDto> selectListaOrden;

	@Autowired
	private ContratoBusiness contratoBusiness;
	
	@Autowired
	private OrdenBusiness ordenBusiness;

	@Autowired
	private ProcesoseleccionBusiness procesoseleccionBusiness;
	
	@Autowired
	private EntregableBusiness entregableBusiness;
	
	@Autowired
	private AdendaBusiness adendaBusiness;
	
	@Autowired
	AdendaController adendaController;

	private ContratoRequest contratoRequest;

	private ContratoResponse contratoResponse;

	private SegRequest segRequest;
	private SegResponse segResponse;
	private List<SegResponse> listaSeguimiento = new ArrayList<>();
	private List<SeguimientoPagosResponse> listaSeguimientoPagosSiaf;
	private List<SeguimientoPagosResponse> listaSeguimientoPagosSiafT;
	private Procesoseleccion procesoSeleccion;

	private Contrato contrato;
	private Contrato selectedContrato;

	private List<ContratoResponse> listaContratos = new ArrayList<ContratoResponse>();
	private List<ContratoExport> listaExport = new ArrayList<ContratoExport>();

	public List<EstadoRequerimientoResponse> listaEstadoRequerimiento;
	public List<CentroCostoResponse> listaCentroCosto;

	public List<Gentabla> listaEstadoFaseI;
	public List<Gentabla> listaEstadoFaseII;
	public List<Gentabla> listaGentablaIdcatalogosistemaadquisicion;

	private String tituloBase;
	private String tituloParam;
	private String estadodocumentacion;
	private Evaluaciondocumento evaldocumento;

	@Autowired
	public EvaluaciondocumentoBusiness evalDocumentoBusiness;

	@Autowired
	public GentablaBusiness gentablaBusiness;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Autowired
	public VcentrocostoBusiness vcentrocostoBusiness;

	@Autowired
	public ProgramacionBusiness programacionBusiness;

	private String pdfURL = "/resources/pdfs/fer.pdf";
	private String pdf = "fer.pdf";

	public ContratoController() {
		contrato = new Contrato();
		contrato.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
		contrato.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
		contrato.setGentablaIdcatalogoestadodocumentacion(new Gentabla());

	}

	@PostConstruct
	public void init() {

		try {

			setSegResponse(new SegResponse());
			procesoSeleccion = new Procesoseleccion();
			evaldocumento = new Evaluaciondocumento();
			contratoB = new Contrato();
			listaAnio = new ArrayList<Integer>();
			tituloBase = "Contrato » ";

			contratoB.setUnidadejecutoraIdunidadejecutora(new Unidadejecutora());
			contratoB.setGrupodocumentoIdgrupodocumento(new Grupodocumento());
			contratoB.setGentablaIdcatalogoestadodocumentacion(new Gentabla());

		    usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			listaIdcatalogosistemaadquisicionKeys = new ArrayList<String>();

			listaGentablaIdcatalogosistemaadquisicion = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.SIAD));
			listaEstadoFaseI = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EEFI));
			listaEstadoFaseII = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.EFII));

			contratoRequest = new ContratoRequest();
			contratoResponse = new ContratoResponse();

			segRequest = new SegRequest();
			ordenListaDto = new OrdenListaDto();

			CentroCostoRequest param = new CentroCostoRequest();
			param.setCodigoUnidadEjecuta(Constantes.unidadEjecutora.PRONIED);
			param.setIdPeriodo(usuario.getPeriodo().getIdPeriodo());
			listaCentroCosto = vcentrocostoBusiness.getCentroCosto(param);

			listaEstadoRequerimiento = gentablaBusiness
					.getEstadoRequerimiento(Constantes.etapaAdministrativa.EJECUCION_CONTRACTUAL);

			listaGentablaIdcatalogoestadodocumentacion = gentablaBusiness.selectDynamicBasic(new Gentabla());

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

	public boolean isAvanzado() {
		return avanzado;
	}

	public void setAvanzado(boolean avanzado) {
		this.avanzado = avanzado;
	}

	public void mostrar() {
		this.avanzado = true;

	}

	public void ocultar() {
		this.avanzado = false;

	}
	
	public void generarAdenda(){
		System.out.println("Size es :"+ContratoController.listaAdendas.size());
		int tam = ContratoController.listaAdendas.size();
		
		AdendaDto adendaDto = new AdendaDto();
		adendaDto.setTipo("ADENDA");
		adendaDto.setNroAdenda(tam +1);
		
		
		
		ContratoController.listaAdendas.add(adendaDto);
		
		
		
	}
	
	
	
	public void actualizarContrato() {

		try {
			if (listaSeguimiento.size() > 0) {	
				
				

				ContratoDto contratoDto = new ContratoDto();
				
				
				
				Contrato contrato1 = new Contrato();
				int idContrato;
				idContrato = listaSeguimiento.get(0).getIdContrato();
				System.out.println("Id contrato :"+idContrato);
				
				contrato1 = contratoBusiness.selectByPrimaryKeyBasic(idContrato);

				
				//recuperado
				
				contratoDto.setIdContrato(idContrato);
				
				System.out.println("El id contrato(1) es == "+contratoDto.getIdContrato());
				
				contratoDto.setIdUnidadEjecutora(contrato1.getIdunidadejecutora());
				contratoDto.setNroItems(contrato1.getNroitems());
				contratoDto.setIdGrupoDocumento(contrato1.getIdgrupodocumento());
				contratoDto.setIdCatalogoTipoContrato(contrato1.getIdcatalogotipocontrato());
				contratoDto.setNroContrato(contrato1.getNrocontrato());
				
				contratoDto.setSecuenciaContrato(contrato1.getSecuenciacontrato());
				contratoDto.setNroCcp(contrato1.getNroccp());
				contratoDto.setIdCatalogoTipoBien(contrato1.getIdcatalogotipobien());
				contratoDto.setIdProveedor(contrato1.getIdproveedor());
				contratoDto.setEstadoContrato(contrato1.getEstadocontrato());
				contratoDto.setIdProveedor(contrato1.getIdproveedor());
				contratoDto.setEstadoContrato(contrato1.getEstadocontrato());
				contratoDto.setFechaInicial(contrato1.getFechainicial());
				contratoDto.setFechaFin(contrato1.getFechafin());
				contratoDto.setMoneda(Constantes.moneda.SOLES);
				contratoDto.setMontoContrato(contrato1.getMontocontrato());
				contratoDto.setMontoCertificacion(contrato1.getMontocertificacion());
				contratoDto.setFechaContrato(contrato1.getFechacontrato());
				contratoDto.setTienePrevision(contrato1.getTieneprevision());
				contratoDto.setCantidadArmadas(contrato1.getCantidadarmadas());
				contratoDto.setFechaRecepcionExpediente(contrato1.getFecharecepcionexpediente());
				contratoDto.setDniEspecialistaEjecucion(contrato1.getDniespecialistaejecucion());
				contratoDto.setSinadContrato(contrato1.getSinadcontrato());
				contratoDto.setAnioSinadcContrato(contrato1.getAniosinadcontrato());
				contratoDto.setNombreEspecialista(contrato1.getNombreespecialista());
				contratoDto.setNumeroExpediente(contrato1.getNumeroexpediente());
				contratoDto.setAnio(contrato1.getAnio());
				contratoDto.setNroConsolid(contrato1.getNroconsolid());
				contratoDto.setIdCatalogoEstadoDocumentacion(contrato1.getIdcatalogoestadodocumentacion());
				contratoDto.setFechaCreacionAuditoria(contrato1.getFechacreacionauditoria());
				contratoDto.setUsuarioCreacionAuditoria(contrato1.getUsuariocreacionauditoria());
				contratoDto.setFechamodificacionauditoria(contrato1.getFechamodificacionauditoria());
				contratoDto.setUsuarioModificacionAuditoria(contrato1.getUsuariomodificacionauditoria());
				contratoDto.setEquipoAuditoria(contrato1.getEquipoauditoria());
				contratoDto.setProgramaAuditoria(contrato1.getProgramaauditoria());
				contratoDto.setEstadoAudtoria(contrato1.getEstadoauditoria());
				
				
				//nuevas
				
				contratoDto.setIdCatalogoSistemaAdquisicion(listaSeguimiento.get(0).getIdCatalogoSistemaAdquisicion());
				contratoDto.setPlazoEjecucion(listaSeguimiento.get(0).getPlazoEjecucion());
				contratoDto.setDniAbogado(listaSeguimiento.get(0).getDniAbogado());
				contratoDto.setNombreAbogado(listaSeguimiento.get(0).getNombreAbogado());
				contratoDto.setRutaContrato(this.contrato.getRutacontrato());
				
				contratoDto.setNroProceso(listaSeguimiento.get(0).getNroProceso());
			    
				for (int i = 0; i < listaOrden.size(); i++) {
				
					//listaOrden.get(i).setEntregables(listaEntregable);
					listaOrden.get(i).setUsuarioCreacionAuditoria(getUserLogin());
					listaOrden.get(i).setEquipoAuditoria(getRemoteAddr());
					
				}
				
				for (int i = 0; i < listaAdendas.size(); i++) {
					
					//listaOrden.get(i).setEntregables(listaEntregable);
					listaAdendas.get(i).setUsuarioCreacionAuditoria(getUserLogin());
					listaAdendas.get(i).setEquipoAuditoria(getRemoteAddr());
					
				}
				
				contratoDto.setListaOrden(listaOrden);
				contratoDto.setOrdenesEliminar(ordenesEliminar);
				contratoDto.setListaAdendas(listaAdendas);
				
				contratoBusiness.actualizarContrato(contratoDto);
				showGrowlMessageSuccessfullyCompletedAction();
					
			
			}

		} catch (Exception e) {
			System.err.println("Error :"+e.getMessage());
		
		}

	}
	

	
	
	private void generateEntregable1(int armadas, OrdenDto ordenDto) {
		
		if (listaEntregable == null)
			 listaEntregable = new ArrayList<EntregableDto>();
		
		int nroEntregables = this.listaEntregable.size();

		if (armadas > nroEntregables) {
			for (int i = 1; i <= armadas - nroEntregables; i++) {
				EntregableDto item = new EntregableDto();
				item.setDescripcion("Pago " + (i + nroEntregables));
				item.setIdGrupoDocumento(ordenDto.getIdGrupoDocumento());
				item.setUsuarioAuditoria(getUserLogin());
				item.setIdOrden(orden1.getIdOrden());
				ContratoController.listaEntregable.add(item);
				item.setEquipoAuditoria(getRemoteAddr());

				
			}
		} else if (armadas < nroEntregables) {
			ContratoController.listaEntregable.clear();
			// nroEntregables - armadas
			for (int i = 1; i <= armadas; i++) {
				EntregableDto item = new EntregableDto();
				item.setDescripcion("Pago " + (i));
				item.setIdGrupoDocumento(ordenDto.getIdGrupoDocumento());
				item.setUsuarioAuditoria(getUserLogin());
				item.setEquipoAuditoria(getRemoteAddr());
				item.setIdOrden(orden1.getIdOrden());
				
				ContratoController.listaEntregable.add(item);

			}
		}		
		ordenDto.setEntregables(listaEntregable);
		
	}

	
	public void guardaContrato(){
		
		try {
			ContratoDto contratoDto = new ContratoDto();
			Contrato contrato1 = contratoBusiness.selectByPrimaryKeyBasic(seqContrato);
		   	
			contratoDto.setIdContrato(contrato1.getIdcontrato());
			contratoDto.setNroItems(contrato1.getNroitems());
			contratoDto.setTienePrevision(contrato1.getTieneprevision());
			contratoDto.setPlazoEjecucion(contrato1.getPlazoejecucion());
			contratoDto.setCantidadArmadas(contrato1.getCantidadarmadas());
			contratoDto.setDniAbogado(contrato1.getDniabogado());
			contratoDto.setNombreAbogado(contrato1.getNombreabogado());
			contratoDto.setDniEspecialistaEjecucion(contrato1.getDniespecialistaejecucion());
			contratoDto.setNombreAbogado(contrato1.getNombreabogado());
			contratoDto.setIdCatalogoSistemaAdquisicion(contrato1.getIdcatalogosistemaadquisicion());
			contratoDto.setFechaRecepcionExpediente(contrato1.getFecharecepcionexpediente());
			contratoDto.setMontoContrato(contrato1.getMontocontrato());
			contratoDto.setNroContrato(contrato1.getNrocontrato());
			contratoDto.setNroCcp(contrato1.getNroccp());
			contratoDto.setMontoCertificacion(contrato1.getMontocertificacion());
			contratoDto.setListaOrden(listaOrden);
		    
			contratoBusiness.actualizarContrato(contratoDto);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}
	

	
	
	public void buscarContratos() {
		try {
			// Todos

			contratoRequest.setEjercicio(2017);
			contratoRequest.setCodUnidEjecutora(Integer.parseInt(Constantes.unidadEjecutora.PRONIED));
			// contratoRequest.setCentroCosto(usuario.getPeriodo().getCodigoCentroCosto());
			contratoRequest.setEstado("0");
			contratoRequest.setPageNumber(1);
			contratoRequest.setPageSize(10);

			// contratoRequest
			listaContratos = contratoBusiness.selectDynamicFull(contratoRequest);
			System.out.println("El tamanio es " + listaContratos.size());

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

	
	public void handleFileUpload(FileUploadEvent event) {

		try {
			UploadedFile file = event.getFile();
			System.err.println("-------file-----: " + file.getFileName());
			String destination;
			HashMap<String, String> map = getMapPathFotosClinica();
			destination = map.get("path");
			System.err.println("-------destination-----: " + destination);
			if (destination == null) {
				addErrorMessage("warning.noseobtuvopath");
			} else {
				pdfURL = map.get("url") + file.getFileName();
				pdf = file.getFileName();
				System.err.println("-------pdfURL-----: " + pdfURL);
				System.err.println("-------pdf-----: " + pdf);
				if (copyFile(file.getFileName(), file.getInputstream(), destination)) {
				}
			}

			FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
			// this.documentotecnico.setRutaanexo("D:\\svn\\trunk\\WebContent\\upload\\"+
			// event.getFile().getFileName());
			this.contrato.setRutacontrato(destination + pdf);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			addErrorMessage("handleFileUpload()" + e.getLocalizedMessage());
		}
	}
	
	public void handleFileUpload2(FileUploadEvent event) {

		System.out.println("Valor posicion es "+selectAdenda.getNroAdenda());
		try {
			UploadedFile file = event.getFile();
			System.err.println("-------file-----: " + file.getFileName());
			String destination;
			HashMap<String, String> map = getMapPathFotosClinica();
			destination = map.get("path");
			System.err.println("-------destination-----: " + destination);
			if (destination == null) {
				addErrorMessage("warning.noseobtuvopath");
			} else {
				pdfURL = map.get("url") + file.getFileName();
				pdf = file.getFileName();
				System.err.println("-------pdfURL-----: " + pdfURL);
				System.err.println("-------pdf-----: " + pdf);
				if (copyFile(file.getFileName(), file.getInputstream(), destination)) {
				}
			}

			FacesMessage msg = new FacesMessage("Exito", event.getFile().getFileName() + " cargado correctamente.");
			// this.documentotecnico.setRutaanexo("D:\\svn\\trunk\\WebContent\\upload\\"+
			// event.getFile().getFileName());
			this.contrato.setRutacontrato(destination + pdf);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			//agregar nombre para mostrar en adendas
			this.selectAdenda.setRuta(destination + pdf);
			this.selectAdenda.setNombreArchivo(pdf);
			
			
			
		} catch (Exception e) {
			addErrorMessage("handleFileUpload()" + e.getLocalizedMessage());
		}
	}
	
	
	public String obtenerArchivo(String cadena){
		String valor = null;
		String [] archivo = cadena.split("/");
		if(archivo.length ==3)
			valor = archivo[2];
		return valor;
	}
	
	

	public void obtenerSeguimiento() {

		try {
			this.adicionales = false;
			
			//limpiar inicio

			listaEntregable.clear();
			listaOrden.clear();
			
			
			//.....
			
			
			listaAnio = contratoBusiness.listEjercicio();
			System.out.println("****************** el tamanio es " + listaAnio.size());

			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");

			procesoSeleccion = procesoseleccionBusiness.selectByPrimaryKeyBasic(contratoResponse.getIdProcesoSeleccion());
			System.err.println("Metodo obtenerSeguimiento");
			segRequest.setCodUnidadEjecutora(Constantes.unidadEjecutora.PRONIED);
			segRequest.setIdContrato(contratoResponse.getIdContrato());
			segRequest.setIdEjercicio(1);
			segRequest.setIdTipoProceso(procesoSeleccion.getCodigotipoproceso());
			System.err.println("id contrato es:" + segRequest.getIdContrato());
			System.err.println("tipo de proceso es:" + segRequest.getIdTipoProceso());

			listaSeguimiento = contratoBusiness.ObtenerSeguimiento(segRequest);

			
			/********************************** cargar orden ***********************/
			List<Orden> tempListaOrden=new ArrayList<>();
			System.out.println("get id contrato :"+contratoResponse.getIdContrato());
			
			tempListaOrden = ordenBusiness.getOrdenByIdContrato(contratoResponse.getIdContrato());
			if(tempListaOrden.size()>0){
				
				listaOrden.clear();
				
			     System.out.println("Tamanio de orden cargado es :"+tempListaOrden.size());
			     for(int i=0;i<tempListaOrden.size();i++){
			    	OrdenDto ordenDto = new OrdenDto();
			    	ordenDto.setIdOrden(tempListaOrden.get(i).getIdorden());
			    	ordenDto.setIdGrupoDocumento(tempListaOrden.get(i).getIdgrupodocumento());
			    	ordenDto.setNroOrden(tempListaOrden.get(i).getNroorden());
			    	ordenDto.setFechaOrden(tempListaOrden.get(i).getFechaorden());
			    	ordenDto.setAnioOrden(tempListaOrden.get(i).getAnioorden());
			    	
			    	ordenDto.setIdEstadoSiaf(tempListaOrden.get(i).getEstadoexpedientesiaf().toString());
			    	
			    	ordenDto.setNroExpedienteSiaf(Integer.parseInt(tempListaOrden.get(i).getNroexpedientesiaf()));
			    	ordenDto.setMoneda(tempListaOrden.get(i).getMoneda());
			    	ordenDto.setMontoOrden(tempListaOrden.get(i).getMontoorden());
			    	ordenDto.setNroProceso(tempListaOrden.get(i).getNroproceso());
			    	ordenDto.setNroContrato(tempListaOrden.get(i).getNrocontrato());
			    	ordenDto.setFechaInicioPrestacion(tempListaOrden.get(i).getFechainicioprestacion());
			    	ordenDto.setIdCatalogoTipoBien(tempListaOrden.get(i).getIdcatalogotipobien());
			    	ordenDto.setFechaFinPrestacion(tempListaOrden.get(i).getFechafinprestacion());
			    	ordenDto.setAnio(tempListaOrden.get(i).getAnio());
			    	ordenDto.setIdUnidadEjecutora(tempListaOrden.get(i).getIdunidadejecutora());
			    	ordenDto.setPlazo(tempListaOrden.get(i).getPlazoejecucion());
			    	ordenDto.setIdContrato(tempListaOrden.get(i).getIdcontrato());
			    	ordenDto.setFechaCreacionAudioria(tempListaOrden.get(i).getFechacreacionauditoria());
			    	ordenDto.setUsuarioCreacionAuditoria(tempListaOrden.get(i).getUsuariocreacionauditoria());
			    	ordenDto.setEquipoAuditoria(tempListaOrden.get(i).getEquipoauditoria());
			    	ordenDto.setPosicion(i+1);

			    	if(tempListaOrden.get(i).getIdcatalogotipobien().equals("TIBI1"))
			    		ordenDto.setTipoBienDesc("BIEN");
			    	if(tempListaOrden.get(i).getIdcatalogotipobien().equals("TIBI2"))
			    		ordenDto.setTipoBienDesc("SERVICIO");
			    	
			    	if(tempListaOrden.get(i).getEstadoexpedientesiaf()==0)
			    		ordenDto.setEstadoSiafDesc("PENDIENTE");
			    	if(tempListaOrden.get(i).getEstadoexpedientesiaf()==1)
			    		ordenDto.setEstadoSiafDesc("EN PROCESO");
			    	if(tempListaOrden.get(i).getEstadoexpedientesiaf()==2)
			    		ordenDto.setEstadoSiafDesc("APROBADO");
			    	
			    	ordenDto.setTotalFactSoles(tempListaOrden.get(i).getMontoorden().doubleValue());
			    	
			    	
			    	
			    	PaoRequest requestPao = new PaoRequest();

					requestPao.setAnio(usuario.getPeriodo().getAnio());
					requestPao.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);
					requestPao.setNroExpedienteSiaf(ordenDto.getNroExpedienteSiaf());
					
					listaSeguimientoPagosSiafT = programacionBusiness.getSeguimientoPagosSiaf(requestPao);
			    	
					// sum monto devengado y pagado
					Double montoDevengado = 0.00;
					Double montoPagado = 0.00;
					for (SeguimientoPagosResponse pagoSiaf : listaSeguimientoPagosSiafT) {
						if ((pagoSiaf.getFase() + "").equals("DEVENGADO"))
							montoDevengado += pagoSiaf.getMonto();

						if ((pagoSiaf.getFase() + "").equals("PAGADO"))
							montoPagado += pagoSiaf.getMonto();
					}
			    	
					ordenDto.setImporteDevengado(montoDevengado);
					ordenDto.setImportePagado(montoPagado);
			    	
					
					
			    	
					//cargar entregable
					
					List<Entregable> tempListaEntregable = new ArrayList<>();
					tempListaEntregable = entregableBusiness.getEntegablesByOrden(ordenDto.getIdOrden());
					if(tempListaEntregable.size()>0){
						listaEntregable.clear();
						System.out.println("Tamanio de entregable cargado es :"+tempListaEntregable.size());
						for (int j = 0; j < tempListaEntregable.size(); j++) {
							EntregableDto entregableDto = new EntregableDto();
							
							entregableDto.setIdEntregable(tempListaEntregable.get(j).getIdentregable());
							entregableDto.setIdOrden(tempListaEntregable.get(j).getIdorden());
							entregableDto.setNroProveido(tempListaEntregable.get(j).getNroproveido());
							entregableDto.setFecha(tempListaEntregable.get(j).getFechapresentacionentregable());
							entregableDto.setDescripcion(tempListaEntregable.get(j).getNroentregable());
							entregableDto.setPlazo(tempListaEntregable.get(j).getPlazoentregable());
							entregableDto.setImporte(tempListaEntregable.get(j).getMontoentregable());
							entregableDto.setMontoPenalidad(tempListaEntregable.get(j).getMontopenalidadentregable());
							entregableDto.setObservacion(tempListaEntregable.get(j).getObservacionesentregable());
							//entregableDto.setEstado(tempListaEntregable.get(j).getes);
							
							if(tempListaEntregable.get(j).getIdcatalogoestadoentregable()!=null){
							
								if(tempListaEntregable.get(j).getIdcatalogoestadoentregable().equals("EENT1")){
									entregableDto.setEstado("ADQUISICIÓN CONFORME");
								}
								
								if(tempListaEntregable.get(j).getIdcatalogoestadoentregable().equals("EENT2")){
									entregableDto.setEstado("REMITIDO CONTABILIDAD");
								}
										
								if(tempListaEntregable.get(j).getIdcatalogoestadoentregable().equals("EENT3")){
									entregableDto.setEstado("PAGADO");
								}
							}
							
							ContratoController.listaEntregable.add(entregableDto);
							
						}
						
					}
					
					
					
					
					ordenDto.setArmadas(tempListaEntregable.size());
			    	ContratoController.listaOrden.add(ordenDto);
			    				    	
			    	
			     }		
			
			}
			


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void obtenerSeguimiento2() {

		try {
			
			this.adicionales = true;
			
			
			
			//limpiar inicio
            if(listaEntregable!=null)
			 listaEntregable.clear();
            if(listaOrden!=null)
			 listaOrden.clear();
			
			
			//.....
			
			
			listaAnio = contratoBusiness.listEjercicio();
			System.out.println("****************** el tamanio es " + listaAnio.size());

			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");

			procesoSeleccion = procesoseleccionBusiness.selectByPrimaryKeyBasic(contratoResponse.getIdProcesoSeleccion());
			System.err.println("Metodo obtenerSeguimiento");
			segRequest.setCodUnidadEjecutora(Constantes.unidadEjecutora.PRONIED);
			segRequest.setIdContrato(contratoResponse.getIdContrato());
			segRequest.setIdEjercicio(1);
			segRequest.setIdTipoProceso(procesoSeleccion.getCodigotipoproceso());
			System.err.println("id contrato es:" + segRequest.getIdContrato());
			System.err.println("tipo de proceso es:" + segRequest.getIdTipoProceso());

			listaSeguimiento = contratoBusiness.ObtenerSeguimiento(segRequest);

			
			/********************************** cargar orden ***********************/
			List<Orden> tempListaOrden=new ArrayList<>();
			System.out.println("get id contrato :"+contratoResponse.getIdContrato());
			
			tempListaOrden = ordenBusiness.getOrdenByIdContrato(contratoResponse.getIdContrato());
			if(tempListaOrden.size()>0){
				
				listaOrden.clear();
				
			     System.out.println("Tamanio de orden cargado es :"+tempListaOrden.size());
			     for(int i=0;i<tempListaOrden.size();i++){
			    	OrdenDto ordenDto = new OrdenDto();
			    	ordenDto.setIdOrden(tempListaOrden.get(i).getIdorden());
			    	ordenDto.setIdGrupoDocumento(tempListaOrden.get(i).getIdgrupodocumento());
			    	ordenDto.setNroOrden(tempListaOrden.get(i).getNroorden());
			    	ordenDto.setFechaOrden(tempListaOrden.get(i).getFechaorden());
			    	ordenDto.setAnioOrden(tempListaOrden.get(i).getAnioorden());
			    	
			    	ordenDto.setIdEstadoSiaf(tempListaOrden.get(i).getEstadoexpedientesiaf().toString());
			    	
			    	ordenDto.setNroExpedienteSiaf(Integer.parseInt(tempListaOrden.get(i).getNroexpedientesiaf()));
			    	ordenDto.setMoneda(tempListaOrden.get(i).getMoneda());
			    	ordenDto.setMontoOrden(tempListaOrden.get(i).getMontoorden());
			    	ordenDto.setNroProceso(tempListaOrden.get(i).getNroproceso());
			    	ordenDto.setNroContrato(tempListaOrden.get(i).getNrocontrato());
			    	ordenDto.setFechaInicioPrestacion(tempListaOrden.get(i).getFechainicioprestacion());
			    	ordenDto.setIdCatalogoTipoBien(tempListaOrden.get(i).getIdcatalogotipobien());
			    	ordenDto.setFechaFinPrestacion(tempListaOrden.get(i).getFechafinprestacion());
			    	ordenDto.setAnio(tempListaOrden.get(i).getAnio());
			    	ordenDto.setIdUnidadEjecutora(tempListaOrden.get(i).getIdunidadejecutora());
			    	ordenDto.setPlazo(tempListaOrden.get(i).getPlazoejecucion());
			    	ordenDto.setIdContrato(tempListaOrden.get(i).getIdcontrato());
			    	ordenDto.setFechaCreacionAudioria(tempListaOrden.get(i).getFechacreacionauditoria());
			    	ordenDto.setUsuarioCreacionAuditoria(tempListaOrden.get(i).getUsuariocreacionauditoria());
			    	ordenDto.setEquipoAuditoria(tempListaOrden.get(i).getEquipoauditoria());
			    	ordenDto.setPosicion(i+1);

			    	if(tempListaOrden.get(i).getIdcatalogotipobien().equals("TIBI1"))
			    		ordenDto.setTipoBienDesc("BIEN");
			    	if(tempListaOrden.get(i).getIdcatalogotipobien().equals("TIBI2"))
			    		ordenDto.setTipoBienDesc("SERVICIO");
			    	
			    	if(tempListaOrden.get(i).getEstadoexpedientesiaf()==0)
			    		ordenDto.setEstadoSiafDesc("PENDIENTE");
			    	if(tempListaOrden.get(i).getEstadoexpedientesiaf()==1)
			    		ordenDto.setEstadoSiafDesc("EN PROCESO");
			    	if(tempListaOrden.get(i).getEstadoexpedientesiaf()==2)
			    		ordenDto.setEstadoSiafDesc("APROBADO");
			    	
			    	ordenDto.setTotalFactSoles(tempListaOrden.get(i).getMontoorden().doubleValue());
			    	
			    	
			    	
			    	PaoRequest requestPao = new PaoRequest();

					requestPao.setAnio(usuario.getPeriodo().getAnio());
					requestPao.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);
					requestPao.setNroExpedienteSiaf(ordenDto.getNroExpedienteSiaf());
					
					listaSeguimientoPagosSiafT = programacionBusiness.getSeguimientoPagosSiaf(requestPao);
			    	
					// sum monto devengado y pagado
					Double montoDevengado = 0.00;
					Double montoPagado = 0.00;
					for (SeguimientoPagosResponse pagoSiaf : listaSeguimientoPagosSiafT) {
						if ((pagoSiaf.getFase() + "").equals("DEVENGADO"))
							montoDevengado += pagoSiaf.getMonto();

						if ((pagoSiaf.getFase() + "").equals("PAGADO"))
							montoPagado += pagoSiaf.getMonto();
					}
			    	
					ordenDto.setImporteDevengado(montoDevengado);
					ordenDto.setImportePagado(montoPagado);
			    	
					
					
			    	
					//cargar entregable
					
					List<Entregable> tempListaEntregable = new ArrayList<>();
					tempListaEntregable = entregableBusiness.getEntegablesByOrden(ordenDto.getIdOrden());
					if(tempListaEntregable.size()>0){
						listaEntregable.clear();
						System.out.println("Tamanio de entregable cargado es :"+tempListaEntregable.size());
						for (int j = 0; j < tempListaEntregable.size(); j++) {
							EntregableDto entregableDto = new EntregableDto();
							
							entregableDto.setIdEntregable(tempListaEntregable.get(j).getIdentregable());
							entregableDto.setIdOrden(tempListaEntregable.get(j).getIdorden());
							entregableDto.setNroProveido(tempListaEntregable.get(j).getNroproveido());
							entregableDto.setFecha(tempListaEntregable.get(j).getFechapresentacionentregable());
							entregableDto.setDescripcion(tempListaEntregable.get(j).getNroentregable());
							entregableDto.setPlazo(tempListaEntregable.get(j).getPlazoentregable());
							entregableDto.setImporte(tempListaEntregable.get(j).getMontoentregable());
							entregableDto.setMontoPenalidad(tempListaEntregable.get(j).getMontopenalidadentregable());
							entregableDto.setObservacion(tempListaEntregable.get(j).getObservacionesentregable());
							//entregableDto.setEstado(tempListaEntregable.get(j).getes);
							
							if(tempListaEntregable.get(j).getIdcatalogoestadoentregable()!=null){
							
								if(tempListaEntregable.get(j).getIdcatalogoestadoentregable().equals("EENT1")){
									entregableDto.setEstado("ADQUISICIÓN CONFORME");
								}
								
								if(tempListaEntregable.get(j).getIdcatalogoestadoentregable().equals("EENT2")){
									entregableDto.setEstado("REMITIDO CONTABILIDAD");
								}
										
								if(tempListaEntregable.get(j).getIdcatalogoestadoentregable().equals("EENT3")){
									entregableDto.setEstado("PAGADO");
								}
							}
							
							ContratoController.listaEntregable.add(entregableDto);
							
						}
						
					}
					
					
					/**********cargar adendas******/
					List<Adenda> tempListaAdenda=new ArrayList<>();
					System.out.println("get id contrato :"+contratoResponse.getIdContrato());
					tempListaAdenda = adendaBusiness.getAdendaByIdContrato(contratoResponse.getIdContrato());
					
                    if(tempListaAdenda.size()>0){
                    	
                    	listaAdendas.clear();
        				System.out.println("Tamanio de adenda cargado es :"+tempListaAdenda.size());
       			     
        				
        				for(int j=0;j<tempListaAdenda.size();j++){
        					AdendaDto adendaDto = new AdendaDto();
        					adendaDto.setIdAdenda(tempListaAdenda.get(j).getIdadenda());
        					adendaDto.setIdContrato(tempListaAdenda.get(j).getIdcontrato());
        					adendaDto.setNroAdenda(tempListaAdenda.get(j).getNroadenda());
        					adendaDto.setMotivo(tempListaAdenda.get(j).getMotivoadenda());
        					adendaDto.setMonto(tempListaAdenda.get(j).getMontoadenda());
        					adendaDto.setFechaInicio(tempListaAdenda.get(j).getFechainicioadenda());
        					adendaDto.setFechaFin(tempListaAdenda.get(j).getFechafinadenda());
        					adendaDto.setRuta(tempListaAdenda.get(j).getRutaadenda());
        					adendaDto.setUsuarioCreacionAuditoria(tempListaAdenda.get(j).getEstadoauditoria());
        					adendaDto.setTipo("Adenda");
        					adendaDto.setNombreArchivo(obtenerArchivo(adendaDto.getRuta()));
        					ContratoController.listaAdendas.add(adendaDto);
        					
        				}
	
                    	
                    }
					
					
					/******************************/
							
					
					ordenDto.setArmadas(tempListaEntregable.size());
			    	ContratoController.listaOrden.add(ordenDto);
			    				    	
			    	
			     }		
			
			}
			


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public void ordenBuscar() {
		try {
			//ordenListaDto.setEjercicio(ordenListaDto.getEjercicio());
			//ordenListaDto.setNroOrden(ordenListaDto.getNroOrden());
			listaOrden2 = ordenBusiness.getListaOrden(ordenListaDto);
			
			for(int i = 0; i<listaOrden2.size(); i++){
				
				listaOrden2.get(i).setPosicion(i+1);
				
			}
			
			

		} catch (Exception e) {
			// TODO: handle exception

		}

	}
	
	
   public void eliminarOrden(OrdenDto orDto) throws Exception{
	   
	    List<Entregable> entregables=entregableBusiness.getEntegablesByOrden(orDto.getIdOrden());
	    if(entregables!=null){
	    	orDto.setEntegables(entregables);
	    }

	    
    	ContratoController.ordenesEliminar.add(orDto);
    	System.out.println("tam1"+listaOrden.size());
    	
    	ContratoController.listaOrden.remove(orDto);
    	System.out.println("tam2"+listaOrden.size());
    	
    	FacesMessage msg = new FacesMessage("Mensaje!","Se eliminó orden correctamente.");
	    FacesContext.getCurrentInstance().addMessage(null, msg);
	    
	    
	    if(listaSeguimientoPagosSiaf!=null){
	    	listaSeguimientoPagosSiaf.clear();
	    }
	    
    } 


	public void agregarOrden() {

		try {
			
			
			System.err.println("U :"+selectOrden.getNroOrden());
			System.err.println(selectOrden.getIdTipoBien());
			System.err.println(selectOrden.getTipoBienDesc());

			String nroOrden =selectOrden.getNroOrden();
			String tipoBien =selectOrden.getTipoBienDesc();
			boolean existe = false;
			
		
			for (int i =0;i<ContratoController.listaOrden.size()&&existe==false;i++){
				
			   if(nroOrden.equals(ContratoController.listaOrden.get(i).getNroOrden()) && 
				  tipoBien.equals(ContratoController.listaOrden.get(i).getTipoBienDesc()))
			   {
				   existe = true; 
				   FacesMessage msg = new FacesMessage("Mensaje!","No se pudo agregar orden, ya está seleccionado.");
				   FacesContext.getCurrentInstance().addMessage(null, msg);
				   
			   }
			}
			
		    if(existe==false){
		    	
		    	ContratoController.listaOrden.add(this.selectOrden);
		    	
		    	
		    }
		    selectOrden = new OrdenDto();

			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			PaoRequest request = new PaoRequest();
			request.setAnio(usuario.getPeriodo().getAnio());
			request.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);
            
			
			
			
		

			for (int i = 0; i < listaOrden.size(); i++) {

				int nroExpediente = listaOrden.get(i).getNroExpedienteSiaf();

				request.setNroExpedienteSiaf(nroExpediente);
				
				
				listaSeguimientoPagosSiafT = programacionBusiness.getSeguimientoPagosSiaf(request);
				
				
				if(listaSeguimientoPagosSiafT!=null && listaSeguimientoPagosSiafT.size()>0){
					
					SeguimientoPagosResponse seguimientoPagosResponse =new SeguimientoPagosResponse();
					
					seguimientoPagosResponse.setCiclo(listaSeguimientoPagosSiafT.get(i).getCiclo());
					seguimientoPagosResponse.setFase(listaSeguimientoPagosSiafT.get(i).getFase());
					seguimientoPagosResponse.setTipoDocumentoDesc(listaSeguimientoPagosSiafT.get(i).getTipoDocumentoDesc());
					seguimientoPagosResponse.setNroDocumento(listaSeguimientoPagosSiafT.get(i).getNroDocumento());
					seguimientoPagosResponse.setFechaDocumento(listaSeguimientoPagosSiafT.get(i).getFechaDocumento());
					seguimientoPagosResponse.setMonto(listaSeguimientoPagosSiafT.get(i).getMonto());
					
					
					ContratoController.detallePago.add(seguimientoPagosResponse);
				
					System.err.println("******Tamanio de Siaffffffffffffffffff******** "+ listaSeguimientoPagosSiafT.size() +" **********");
					System.err.println("******detallePago******** "+ ContratoController.detallePago.size() +" **********");
				}
				

				// sum monto devengado y pagado
				Double montoDevengado = 0.00;
				Double montoPagado = 0.00;
				for (SeguimientoPagosResponse pagoSiaf : listaSeguimientoPagosSiafT) {
					if ((pagoSiaf.getFase() + "").equals("DEVENGADO"))
						montoDevengado += pagoSiaf.getMonto();

					if ((pagoSiaf.getFase() + "").equals("PAGADO"))
						montoPagado += pagoSiaf.getMonto();
				}

				// set monto orden

				ContratoController.listaOrden.get(i).setImporteDevengado(montoDevengado);
				ContratoController.listaOrden.get(i).setImportePagado(montoPagado);
				ContratoController.listaOrden.get(i).setPosicion(i + 1);
				ContratoController.listaOrden.get(i).setAnioOrden(Integer.parseInt(ordenListaDto.getEjercicio()));
				ContratoController.listaOrden.get(i).setAnio(Integer.parseInt(ordenListaDto.getEjercicio()));
				ContratoController.listaOrden.get(i).setMoneda(Constantes.moneda.SOLES);
				ContratoController.listaOrden.get(i).setIdCatalogoTipoBien(listaOrden.get(i).getIdTipoBien());
				ContratoController.listaOrden.get(i).setNroExpedienteSiaf(listaOrden.get(i).getNroExpedienteSiaf());
				ContratoController.listaOrden.get(i).setEstadoSiafDesc(listaOrden.get(i).getEstadoSiafDesc());
				ContratoController.listaOrden.get(i).setUsuarioAuditoria(getUserLogin());
				ContratoController.listaOrden.get(i).setIdUnidadEjecutora(Constantes.unidadEjecutora.ID_UNIDAD_EJECUTORA_ABAS);
				ContratoController.listaOrden.get(i).setEquipoAuditoria(getRemoteAddr());
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void actualizaObservada(){
		
		
		try {
			System.out.println("actualizando: "+contratoResponse.getIdContrato());
			Contrato contrato =new Contrato();
			
			contrato = contratoBusiness.selectByPrimaryKeyBasic(contratoResponse.getIdContrato());

			contrato.setIdgrupodocumento(contratoResponse.getIdDocumento());
			contrato.setDniespecialistaejecucion(contratoResponse.getDniEspEjecucion());
			contrato.setNombreespecialista(contratoResponse.getNomEspEjecucion());
			contrato.setFecharecepcionexpediente(new Date());
			contrato.setNroconsolid(contratoResponse.getNroConsolid());
			contrato.setNrocontrato(contratoResponse.getNroContrato());
			contrato.setAnio(contratoResponse.getAnoProceso());
			contrato.setEstadocontrato(contratoResponse.getEstadoContrato());
			contrato.setIdunidadejecutora(Constantes.unidadEjecutora.ID_UNIDAD_EJECUTORA_ABAS);
			//contrato.setFechacreacionauditoria(Utils.currentTimeStamp());
			contrato.setFechamodificacionauditoria(Utils.currentTimeStamp());
			contrato.setUsuariocreacionauditoria(getUserLogin());
			// contrato.setGentablaIdcatalogoestadodocumentacion(gentablaIdcatalogoestadodocumentacion);
			contrato.setIdcatalogoestadodocumentacion(this.estadodocumentacion);
			contrato.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
			contrato.setEquipoauditoria(getRemoteAddr());
			// contrato.setGentablaIdcatalogoestadodocumentacion(gentablaBusiness.selectByPrimaryKeyBasicFromList(contrato.getIdcatalogoestadodocumentacion(),listaGentablaIdcatalogoestadodocumentacion));
			contratoBusiness.updateByPrimaryKeyBasic(contrato);
			/*
			 * System.out.println("el valor del idContrato es "
			 * +contrato.getIdcontrato());
			 */
			buscarContratos();

			// contratoBusiness.selectByPrimaryKeyBasic(requerimientoResponse.getIdPedido());

			/*
			 * evaldocumento.setIdevaluaciondocumento(((int)utilsBusiness.
			 * getNextSeq(Sequence.SEQ_EVALUACIONDOCUMENTO).longValue()));
			 * evaldocumento.setIdcontrato(contrato.getIdcontrato());
			 * evaldocumento.setIdcatalogoestadodocumentacion(contrato.
			 * getIdcatalogoestadodocumentacion());
			 * evalDocumentoBusiness.insertBasic(evaldocumento);
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void insertarContratos() {

		try {

			System.out.println("insertando: "+estadodocumentacion);

			System.out.println("IdCatalogoEstadoDocumentacion" + contratoResponse.getEstadoDocumentacionDesc());

			seqContrato = (int) utilsBusiness.getNextSeq(Sequence.SEQ_CONTRATO).longValue();

			contrato.setIdcontrato(seqContrato);
			contrato.setIdgrupodocumento(contratoResponse.getIdDocumento());
			contrato.setDniespecialistaejecucion(contratoResponse.getDniEspEjecucion());
			contrato.setNombreespecialista(contratoResponse.getNomEspEjecucion());
			contrato.setFecharecepcionexpediente(new Date());
			contrato.setNroconsolid(contratoResponse.getNroConsolid());
			contrato.setNrocontrato(contratoResponse.getNroContrato());
			contrato.setAnio(contratoResponse.getAnoProceso());
			contrato.setEstadocontrato(contratoResponse.getEstadoContrato());
			contrato.setIdunidadejecutora(Constantes.unidadEjecutora.ID_UNIDAD_EJECUTORA_ABAS);
			contrato.setFechacreacionauditoria(Utils.currentTimeStamp());
			contrato.setUsuariocreacionauditoria(getUserLogin());
			// contrato.setGentablaIdcatalogoestadodocumentacion(gentablaIdcatalogoestadodocumentacion);
			contrato.setIdcatalogoestadodocumentacion(this.estadodocumentacion);
			contrato.setProgramaauditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
			contrato.setEquipoauditoria(getRemoteAddr());
			// contrato.setGentablaIdcatalogoestadodocumentacion(gentablaBusiness.selectByPrimaryKeyBasicFromList(contrato.getIdcatalogoestadodocumentacion(),listaGentablaIdcatalogoestadodocumentacion));
			contratoBusiness.insertBasic(contrato);
			/*
			 * System.out.println("el valor del idContrato es "
			 * +contrato.getIdcontrato());
			 */
			buscarContratos();

			// contratoBusiness.selectByPrimaryKeyBasic(requerimientoResponse.getIdPedido());

			/*
			 * evaldocumento.setIdevaluaciondocumento(((int)utilsBusiness.
			 * getNextSeq(Sequence.SEQ_EVALUACIONDOCUMENTO).longValue()));
			 * evaldocumento.setIdcontrato(contrato.getIdcontrato());
			 * evaldocumento.setIdcatalogoestadodocumentacion(contrato.
			 * getIdcatalogoestadodocumentacion());
			 * evalDocumentoBusiness.insertBasic(evaldocumento);
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	


	public String irAdenda() {
		boolean validado = false;
		try {
			securityControlValidate("btnAdenda");
			validateSelectedRow();
			String paramTitulo = new String((tituloParam != null ? tituloParam : "") + " " + tituloBase);
			adendaController.setTituloParam(paramTitulo);
			adendaController.init(contrato);

			validado = true;
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
			addMessageKey("msgsForm", e.getMessage(), FacesMessage.SEVERITY_ERROR);
			return null;
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
			return null;
		}
		if (validado)
			return "/pages/adenda/adendaBuscar.xhtml?faces-redirect=true";
		else
			return null;
	}

	public void validateSelectedRow() throws UnselectedRowException, CloneNotSupportedException {
		if (selectedContrato == null)
			throw new UnselectedRowException(Messages.getString("no.record.selected"));
		else
			contrato = (Contrato) selectedContrato.clone();
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
			((OrdenDto) event.getObject()).setIdGrupoDocumento(contratoResponse.getIdDocumento());
		}

		//generateEntregable(armadas, ((OrdenDto) event.getObject()).getPosicion());
		generateEntregable1(armadas, ((OrdenDto) event.getObject()));
		FacesContext.getCurrentInstance().addMessage(null, msg);

		System.err.println("Valor de posicion es :" + ((OrdenDto) event.getObject()).getPosicion());

	}
	
	
	
	
	
	public void onRowCancel2(RowEditEvent event) {
		/*FacesMessage msg = new FacesMessage("Se canceló la edición",
				"Orden: " + ((OrdenDto) event.getObject()).getNroOrden());
		FacesContext.getCurrentInstance().addMessage(null, msg);*/
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló la edición",
				"Orden: " + ((OrdenDto) event.getObject()).getNroOrden());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	

	public void onRowEdit2(RowEditEvent event) throws Exception{

		System.out.println("Descripcion es :"+((EntregableDto) event.getObject()).getDescripcion());
		
		String codigo = ((EntregableDto) event.getObject()).getEstado();
		Gentabla entregable = gentablaBusiness.selectByPrimaryKeyBasic(codigo);
		if (entregable != null)
			((EntregableDto) event.getObject()).setEstado(entregable.getVchregdescri());
		
		
	
			
		/*
		((EntregableDto) event.getObject()).getNroProveido();
		((EntregableDto) event.getObject()).getFecha();
		((EntregableDto) event.getObject()).getDescripcion();
		((EntregableDto) event.getObject()).getPlazo();
		((EntregableDto) event.getObject()).getImporte();
		((EntregableDto) event.getObject()).getMontoPenalidad();
		((EntregableDto) event.getObject()).getObservacion();
		((EntregableDto) event.getObject()).getEstado();*/
		
		
	}
	
	public void fer() throws Exception {
		
		System.out.println("Valor posicion es "+orden1.getPosicion());
		FacesMessage msg = new FacesMessage("posicion: " + orden1.getPosicion());
		
		List<Entregable> lista = entregableBusiness.getEntegablesByOrden(orden1.getIdOrden());
		System.out.println(lista.size());
		if(lista!=null&&lista.size()>0){
			
			//List<EntregableDto> entregableAux=new ArrayList<>(listaEntregable);
			if(listaEntregable!=null)
			  listaEntregable.clear();
			else
			  listaEntregable = new ArrayList<>();	
			for (int i = 0; i < lista.size(); i++) {
				EntregableDto dto = new EntregableDto();
				dto.setIdEntregable(lista.get(i).getIdentregable());
				dto.setDescripcion(lista.get(i).getNroentregable());
				dto.setNroProveido(lista.get(i).getNroproveido());
			    dto.setFecha(lista.get(i).getFechapresentacionentregable());
			    dto.setPlazo(lista.get(i).getPlazoentregable());
			    dto.setImporte(lista.get(i).getMontoentregable());
			    dto.setMontoPenalidad(lista.get(i).getMontopenalidadentregable());
			    dto.setObservacion(lista.get(i).getObservacionesentregable());
			    dto.setEstado(lista.get(i).getIdcatalogoestadoentregable());
				ContratoController.listaEntregable.add(dto);
			}

		}	else{
			ContratoController.listaEntregable = orden1.getEntregables();
			
		}
		
		
		
	
		PaoRequest pao = new PaoRequest();
		pao.setAnio(usuario.getPeriodo().getAnio());
		pao.setIdUnidadEjecutoraSiaf(Constantes.unidadEjecutora.PRONIED_SIAF);
		pao.setNroExpedienteSiaf(orden1.getNroExpedienteSiaf());
		
		
		this.listaSeguimientoPagosSiaf = programacionBusiness.getSeguimientoPagosSiaf(pao);
		
		
		System.out.println("size:"+listaSeguimientoPagosSiaf.size());
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void limpiar(){
		ContratoController.listaOrden.clear();
	
	}
	
	
	public ContratoRequest getContratoRequest() {
		return contratoRequest;
	}

	public void setContratoRequest(ContratoRequest contratoRequest) {
		this.contratoRequest = contratoRequest;
	}

	public List<ContratoResponse> getListaContratos() {
		return listaContratos;
	}

	public void setListaContratos(List<ContratoResponse> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public ContratoResponse getContratoResponse() {
		return contratoResponse;
	}

	public void setContratoResponse(ContratoResponse contratoResponse) {
		this.contratoResponse = contratoResponse;
	}

	public List<EstadoRequerimientoResponse> getListaEstadoRequerimiento() {
		return listaEstadoRequerimiento;
	}

	public void setListaEstadoRequerimiento(List<EstadoRequerimientoResponse> listaEstadoRequerimiento) {
		this.listaEstadoRequerimiento = listaEstadoRequerimiento;
	}

	public List<CentroCostoResponse> getListaCentroCosto() {
		return listaCentroCosto;
	}

	public void setListaCentroCosto(List<CentroCostoResponse> listaCentroCosto) {
		this.listaCentroCosto = listaCentroCosto;
	}

	public List<Gentabla> getListaEstadoFaseI() {
		return listaEstadoFaseI;
	}

	public void setListaEstadoFaseI(List<Gentabla> listaEstadoFaseI) {
		this.listaEstadoFaseI = listaEstadoFaseI;
	}

	public List<Gentabla> getListaEstadoFaseII() {
		return listaEstadoFaseII;
	}

	public void setListaEstadoFaseII(List<Gentabla> listaEstadoFaseII) {
		this.listaEstadoFaseII = listaEstadoFaseII;
	}

	public String getTituloParam() {
		return tituloParam;
	}

	public void setTituloParam(String tituloParam) {
		this.tituloParam = tituloParam;
	}

	public String getTituloBase() {
		return tituloBase;
	}

	public void setTituloBase(String tituloBase) {
		this.tituloBase = tituloBase;
	}

	public Contrato getContratoB() {
		return contratoB;
	}

	public void setContratoB(Contrato contratoB) {
		this.contratoB = contratoB;
	}

	public List<Gentabla> getListaGentablaIdcatalogosistemaadquisicion() {
		return listaGentablaIdcatalogosistemaadquisicion;
	}

	public void setListaGentablaIdcatalogosistemaadquisicion(List<Gentabla> listaGentablaIdcatalogosistemaadquisicion) {
		this.listaGentablaIdcatalogosistemaadquisicion = listaGentablaIdcatalogosistemaadquisicion;
	}

	public List<String> getListaIdcatalogosistemaadquisicionKeys() {
		return listaIdcatalogosistemaadquisicionKeys;
	}

	public void setListaIdcatalogosistemaadquisicionKeys(List<String> listaIdcatalogosistemaadquisicionKeys) {
		this.listaIdcatalogosistemaadquisicionKeys = listaIdcatalogosistemaadquisicionKeys;
	}

	public void setListaGentablaIdcatalogoestadodocumentacion(
			List<Gentabla> listaGentablaIdcatalogoestadodocumentacion) {
		this.listaGentablaIdcatalogoestadodocumentacion = listaGentablaIdcatalogoestadodocumentacion;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestadodocumentacion() {
		return listaGentablaIdcatalogoestadodocumentacion;
	}

	public String getEstadodocumentacion() {
		return estadodocumentacion;
	}

	public void setEstadodocumentacion(String estadodocumentacion) {
		this.estadodocumentacion = estadodocumentacion;
	}

	public Evaluaciondocumento getEvaldocumento() {
		return evaldocumento;
	}

	public void setEvaldocumento(Evaluaciondocumento evaldocumento) {
		this.evaldocumento = evaldocumento;
	}

	public List<SegResponse> getListaSeguimiento() {
		return listaSeguimiento;
	}

	public void setListaSeguimiento(List<SegResponse> listaSeguimiento) {
		this.listaSeguimiento = listaSeguimiento;
	}

	public SegResponse getSegResponse() {
		return segResponse;
	}

	public void setSegResponse(SegResponse segResponse) {
		this.segResponse = segResponse;
	}

	public List<OrdenDto> getListaOrden() {
		return listaOrden;
	}

	public void setListaOrden(List<OrdenDto> listaOrden) {
		ContratoController.listaOrden = listaOrden;
	}

	public List<SeguimientoPagosResponse> getListaSeguimientoPagosSiaf() {
		return listaSeguimientoPagosSiaf;
	}

	public void setListaSeguimientoPagosSiaf(List<SeguimientoPagosResponse> listaSeguimientoPagosSiaf) {
		this.listaSeguimientoPagosSiaf = listaSeguimientoPagosSiaf;
	}

	public List<Integer> getListaAnio() {
		return listaAnio;
	}

	public void setListaAnio(List<Integer> listaAnio) {
		this.listaAnio = listaAnio;
	}

	public OrdenListaDto getOrdenListaDto() {
		return ordenListaDto;
	}

	public void setOrdenListaDto(OrdenListaDto ordenListaDto) {
		this.ordenListaDto = ordenListaDto;
	}

	public List<OrdenDto> getListaOrden2() {
		return listaOrden2;
	}

	public void setListaOrden2(List<OrdenDto> listaOrden2) {
		this.listaOrden2 = listaOrden2;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public void addMessage() {
		String summary = value ? "Checked" : "Unchecked";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}

	public OrdenDto getSelectOrden() {
		return selectOrden;
	}

	public void setSelectOrden(OrdenDto selectOrden) {
		this.selectOrden = selectOrden;
	}

	public List<OrdenDto> getSelectListaOrden() {
		return selectListaOrden;
	}

	public void setSelectListaOrden(List<OrdenDto> selectListaOrden) {
		this.selectListaOrden = selectListaOrden;
	}

	public PaoResponse getCurrentPao() {
		return currentPao;
	}

	public void setCurrentPao(PaoResponse currentPao) {
		this.currentPao = currentPao;
	}

	public List<EntregableDto> getListaEntregable() {
		return listaEntregable;
	}

	public void setListaEntregable(List<EntregableDto> listaEntregable) {
		ContratoController.listaEntregable = listaEntregable;
	}


	public OrdenDto getOrden1() {
		return orden1;
	}

	public void setOrden1(OrdenDto orden1) {
		this.orden1 = orden1;
	}


	public Integer getSeqContrato() {
		return seqContrato;
	}

	public void setSeqContrato(Integer seqContrato) {
		this.seqContrato = seqContrato;
	}

	public List<SeguimientoPagosResponse> getDetallePago() {
		return detallePago;
	}

	public void setDetallePago(List<SeguimientoPagosResponse> detallePago) {
		ContratoController.detallePago = detallePago;
	}

	public List<SeguimientoPagosResponse> getListaSeguimientoPagosSiafT() {
		return listaSeguimientoPagosSiafT;
	}

	public void setListaSeguimientoPagosSiafT(List<SeguimientoPagosResponse> listaSeguimientoPagosSiafT) {
		this.listaSeguimientoPagosSiafT = listaSeguimientoPagosSiafT;
	}


    public List<OrdenDto> getOrdenesEliminar() {
		return ordenesEliminar;
	}

	public void setOrdenesEliminar(List<OrdenDto> ordenesEliminar) {
		ContratoController.ordenesEliminar = ordenesEliminar;
	}

	public boolean isAdicionales() {
		return adicionales;
	}

	public void setAdicionales(boolean adicionales) {
		this.adicionales = adicionales;
	}

	public List<AdendaDto> getListaAdendas() {
		return listaAdendas;
	}

	public void setListaAdendas(List<AdendaDto> listaAdendas) {
		ContratoController.listaAdendas = listaAdendas;
	}

	public AdendaDto getSelectAdenda() {
		return selectAdenda;
	}

	public void setSelectAdenda(AdendaDto selectAdenda) {
		this.selectAdenda = selectAdenda;
	}

	
     public void selectAdenda() throws Exception {
    	 
    	 System.out.println("Valor posicion es "+selectAdenda.getNroAdenda());
		//FacesMessage msg = new FacesMessage("posicion: " + selectAdenda.getNroAdenda());
		
		/*List<Entregable> lista = entregableBusiness.getEntegablesByOrden(orden1.getIdOrden());
		System.out.println(lista.size());*/
     }

	public boolean isValue1() {
		return value1;
	}

	public void setValue1(boolean value1) {
		this.value1 = value1;
	}

	public boolean isValue2() {
		return value2;
	}

	public void setValue2(boolean value2) {
		this.value2 = value2;
	}

	public boolean isValue3() {
		return value3;
	}

	public void setValue3(boolean value3) {
		this.value3 = value3;
	}

	public boolean isValue5() {
		return value5;
	}

	public void setValue5(boolean value5) {
		this.value5 = value5;
	}

	public boolean isValue4() {
		return value4;
	}

	public void setValue4(boolean value4) {
		this.value4 = value4;
	}

	public boolean isValue6() {
		return value6;
	}

	public void setValue6(boolean value6) {
		this.value6 = value6;
	}

	public boolean isValue7() {
		return value7;
	}

	public void setValue7(boolean value7) {
		this.value7 = value7;
	}

	public boolean isValue9() {
		return value9;
	}

	public void setValue9(boolean value9) {
		this.value9 = value9;
	}

	public boolean isValue8() {
		return value8;
	}

	public void setValue8(boolean value8) {
		this.value8 = value8;
	}

	public void postProcessXLS2(Object document) {  
	    HSSFWorkbook wb = (HSSFWorkbook) document;  
	    HSSFSheet sheet = wb.getSheetAt(0);  
	    HSSFRow header = sheet.getRow(0);  
	      
	    HSSFCellStyle cellStyle = wb.createCellStyle();    
	    cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);  
	    cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	    
	    for(int i=0; i < header.getPhysicalNumberOfCells();i++) {  
	        HSSFCell cell = header.getCell(i);  
	      
	        cell.setCellStyle(cellStyle);  
	    }  
	}

	public boolean isValue10() {
		return value10;
	}

	public void setValue10(boolean value10) {
		this.value10 = value10;
	}

	public boolean isValue11() {
		return value11;
	}

	public void setValue11(boolean value11) {
		this.value11 = value11;
	}  
	
	
	
	public List<ContratoExport> getListaExport() {
		return listaExport;
	}

	public void setListaExport(List<ContratoExport> listaExport) {
		this.listaExport = listaExport;
	}

	public void goExport() {
		STATUS_INIT();
		try {
			securityControlValidate("btnExport");
			
			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			if (usuario == null) {
				REGISTER_ERROR();
				addMessageKey("msgsDocumentotecnicoR", "Teminó la sesión", FacesMessage.SEVERITY_ERROR);
				return;
			}

			
			// resetRegisterForm();
			// accion = IMPRIMIR;
			tituloBase = "Proceso » " + IMPRIMIR;
			
			contratoRequest.setEjercicio(2017);
			contratoRequest.setCodUnidEjecutora(Integer.parseInt(Constantes.unidadEjecutora.PRONIED));
			contratoRequest.setEstado("0");
			contratoRequest.setPageNumber(1);
			contratoRequest.setPageSize(10);

			// contratoRequest
			listaExport = contratoBusiness.selectDynamicExport(contratoRequest);
			System.out.println("El tamanio es " + listaExport.size());

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

	public boolean isValue12() {
		return value12;
	}

	public void setValue12(boolean value12) {
		this.value12 = value12;
	}

}
