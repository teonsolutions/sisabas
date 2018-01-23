package pe.com.sisabas.controller;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Dependenciadocumentotecnico;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Gentipo;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.be.Persona;
import pe.com.sisabas.be.Plazopagodocumentotecnico;
import pe.com.sisabas.be.RequerimientoInsertRequest;
import pe.com.sisabas.be.RequerimientoItemRequest;
import pe.com.sisabas.be.RequerimientoItemResponse;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;
import pe.com.sisabas.business.DependenciadocumentotecnicoBusiness;
import pe.com.sisabas.business.DocumentotecnicoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.business.PedidoBusiness;
import pe.com.sisabas.business.PedidosporpacconsolidadoBusiness;
import pe.com.sisabas.business.PersonaBusiness;
import pe.com.sisabas.business.PlazopagodocumentotecnicoBusiness;
import pe.com.sisabas.business.RequerimientoBusiness;

import pe.com.sisabas.dto.ComiteDto;
import pe.com.sisabas.dto.EspecificacionTecnicaDto;
import pe.com.sisabas.dto.Lugar;
import pe.com.sisabas.dto.Pago;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.persistence.PedidoMapper;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicuusuario;
import sun.security.action.GetLongAction;

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

	private String pdfURL = "/resources/pdfs/fer,pdf";
	private String pdf = "fer.pdf";

	private static final long serialVersionUID = 1L;

	private Miembrocomiteporproceso miembrocomiteporprocesoB;
	private List<String> listaIdcatalogotipomiembroKeys;
	public List<Gentabla> listaGentablaIdcatalogotipomiembro;

	@Autowired
	public PedidoMapper pedidoMapper;

	@Autowired
	public PedidoBusiness pedidoBusiness;

	@Autowired
	public GentablaBusiness gentablaBusiness;

	@Autowired
	public RequerimientoBusiness requerimientoBusiness;

	@Autowired
	public DependenciadocumentotecnicoBusiness dependenciaBusiness;

	@Autowired
	public PlazopagodocumentotecnicoBusiness plazoBusiness;

	@Autowired
	public DocumentotecnicoBusiness documentotecnicoBusiness;

	private boolean mostrarGrid = true;

	private Documentotecnico documentotecnico2;

	private int tam;

	private Lugar lugar;
	private ComiteDto comite;

	private Pago pago;
	private static double totalPorcentaje = 0;
	private boolean check;

	private static List<Lugar> lugares = new ArrayList<>();
	private static List<Pago> pagos = new ArrayList<>();
	private static List<Lugar> lugaresEliminar = new ArrayList<>();
	private static List<Pago> pagosEliminar = new ArrayList<>();
	private static List<ComiteDto> comites2 = new ArrayList<>();
	// private static List<Miembrocomiteporproceso> comites = new ArrayList<>();
	// private static List<Miembrocomiteporproceso> comitesEliminar = new
	// ArrayList<>();

	private String fechaformato = null;

	private Documentotecnico documentotecnico;
	private Dependenciadocumentotecnico dependenciadocumentotecnico;

	private RequerimientoInsertRequest requerimientoInsertRequest;

	private RequerimientoRequest requerimientoRequest;
	private RequerimientoResponse requerimientoResponse;

	private RequerimientoItemRequest requerimientoItemRequest;
	private RequerimientoItemResponse requerimientoItemResponse;

	private List<RequerimientoResponse> listaRequerimientos = new ArrayList<RequerimientoResponse>();
	private List<RequerimientoItemResponse> listaItemRequerimientos = new ArrayList<RequerimientoItemResponse>();

	private List<Dependenciadocumentotecnico> listaDependencias = new ArrayList<Dependenciadocumentotecnico>();

	private boolean auxiliar = true;

	private String tituloBase; // titulo de la opcion
	private String tituloParam;// titulo que llega como parametro (derivada
								// padre)

	private String idOpcionText = "OPC_REQUERIMIENTO";

	public ContratoController() {

		

	}

	public String getFechaformato() {
		return fechaformato;
	}

	public void setFechaformato(String fechaformato) {
		this.fechaformato = fechaformato;
	}

	public Documentotecnico getDocumentotecnico2() {
		return documentotecnico2;
	}

	public void setDocumentotecnico2(Documentotecnico documentotecnico2) {
		this.documentotecnico2 = documentotecnico2;
	}

	@PostConstruct
	public void init() {

		try {

			miembrocomiteporprocesoB = new Miembrocomiteporproceso();
			if (SICU_SECURITY_ENABLE) {
				idOpcion = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			miembrocomiteporprocesoB.setComiteprocesoIdcomiteproceso(new Comiteproceso());
			miembrocomiteporprocesoB.setPersonaIdpersona(new Persona());
			miembrocomiteporprocesoB.setGentablaIdcatalogotipomiembro(new Gentabla());

			listaIdcatalogotipomiembroKeys = new ArrayList<String>();
			listaGentablaIdcatalogotipomiembro = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.CAMI));

			comite = new ComiteDto();
			lugar = new Lugar();
			pago = new Pago();

			documentotecnico = new Documentotecnico();
			dependenciadocumentotecnico = new Dependenciadocumentotecnico();
			requerimientoInsertRequest = new RequerimientoInsertRequest();

			documentotecnico2 = new Documentotecnico();

			requerimientoRequest = new RequerimientoRequest();
			requerimientoResponse = new RequerimientoResponse();
			requerimientoItemRequest = new RequerimientoItemRequest();
			requerimientoItemResponse = new RequerimientoItemResponse();

			tituloBase = "Requerimientos » ";
			if (SICU_SECURITY_ENABLE) {
				idOpcion = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}

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
			this.documentotecnico.setRutaanexo(destination + pdf);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			addErrorMessage("handleFileUpload()" + e.getLocalizedMessage());
		}
	}

	public void buscarRequerimientos() {
	
		try {
			
			// Todos
			Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
			requerimientoRequest.setCodigoUnidadEjecutora(Constantes.unidadEjecutora.PRONIED);
			// requerimientoRequest.setPedido("08761");
			requerimientoRequest.setAnoEje(usuario.getPeriodo().getAnio());
			requerimientoRequest.setPagenumber(1);
			requerimientoRequest.setPageSize(10);
			requerimientoRequest.setCentroCosto(usuario.getPeriodo().getCodigoCentroCosto());

			System.err.println("----------------- tipo es: " + requerimientoRequest.getTipoNecesidad());

			if (requerimientoRequest.getTipoNecesidad().equals(Constantes.tipoNecesidad.TIPO_NECESIDAD_PROGRAMADO)) {
				listaRequerimientos = requerimientoBusiness.selectDynamicFullProgramado(requerimientoRequest);
				
			} else {
				listaRequerimientos = requerimientoBusiness.selectDynamicFull(requerimientoRequest);
				
			}
			System.out.println("El tamanio es :" + listaRequerimientos.size());
			for (int i = 0; i < listaRequerimientos.size(); i++) {
				
			}

			if (listaRequerimientos.size() == 0)
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

	public void buscarItemRequerimientos() {
		try {

			System.out.println("******************************GetEstadoSiga****************************"
					+ requerimientoResponse.getEstadoSiga());
			// Todos
			// getPedidosEvaluacion
			requerimientoItemRequest.setCodUnidadEjecutora("108");
			requerimientoItemRequest.setEjercicio(2017);

			requerimientoItemRequest.setNroPedido(requerimientoResponse.getNroPedido());

			if (requerimientoResponse.getTipobien().equalsIgnoreCase("Servicio"))
				requerimientoItemRequest.setTipoBien("S");
			else if (requerimientoResponse.getTipobien().equalsIgnoreCase("Bien"))
				requerimientoItemRequest.setTipoBien("B");

			listaItemRequerimientos = requerimientoBusiness.selectDynamicBasic(requerimientoItemRequest);

			if (listaItemRequerimientos.size() == 1)
				tam = 100;
			else
				tam = 200;

			if (listaItemRequerimientos.size() == 0)
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

	public void buscarItemRequerimientos2() {

		try {

			requerimientoItemRequest.setCodUnidadEjecutora("108");
			requerimientoItemRequest.setEjercicio(2017);
			requerimientoItemRequest.setNroPedido(requerimientoResponse.getNroPedido());
			if (requerimientoResponse.getTipobien().equalsIgnoreCase("Servicio"))
				requerimientoItemRequest.setTipoBien("S");
			else if (requerimientoResponse.getTipobien().equalsIgnoreCase("Bien"))
				requerimientoItemRequest.setTipoBien("B");

			listaItemRequerimientos = requerimientoBusiness.selectDynamicBasic(requerimientoItemRequest);

			System.out.println(
					"***********el tamanio de ListaItemRequerimientos es *********" + listaItemRequerimientos.size());
			System.out.println("***********el valor de nropedido es *********" + requerimientoResponse.getNroPedido());

			if (listaItemRequerimientos.size() == 1)
				tam = 100;
			else
				tam = 200;

			if (listaItemRequerimientos.size() == 0)
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

	
	public void remitir() {

		Pedido pedido = new Pedido();
		try {
			System.out.println("El idPedido seleccionado es " + requerimientoResponse.getIdPedido());
			pedido = pedidoBusiness.selectByPrimaryKeyBasic(requerimientoResponse.getIdPedido());
			pedido.setEstadopedido(Constantes.estadosPorEtapa.REMITIDO_A_PROGRAMACION);
			//pedidoMapper.updateByPrimaryKey(pedido);
			
			TransactionRequest<Pedido> request = new TransactionRequest<Pedido>();
			request.setEntityTransaction(pedido);
			request.setUsuarioAuditoria(getUserLogin());
			request.setEquipoAuditoria(getRemoteAddr());
					
			requerimientoBusiness.Remitir(request);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// this.requerimientoResponse.setEstadoPedidoIn(Constantes.estadosPorEtapa.REMITIDO_A_PROGRAMACION);
	}

	public void insertarRequerimientos() {
		try {
			System.out.println("***************Fer5**************" + requerimientoResponse.getNroPedido());

			System.out.println("[RequerimientoController - insertarRequerimientos] valor getNroPedido es: "
					+ requerimientoInsertRequest.getNroPedido());
			System.out.println("[RequerimientoController - insertarRequerimientos] valor getNumeroSinad es: "
					+ requerimientoResponse.getNumeroSinad());


			requerimientoInsertRequest.setNroPedido(requerimientoResponse.getNroPedido());
			requerimientoInsertRequest.setCodUnidadEjecutora(Constantes.unidadEjecutora.PRONIED);
			requerimientoInsertRequest.setAnoEje(2017);
			requerimientoInsertRequest.setTipoBien(requerimientoResponse.getTipobien());
			requerimientoInsertRequest.setIdPeriodo(1);

			System.out.println("Los parametros de entradas son: ");
			System.out.println("Nro Pedido :" + requerimientoInsertRequest.getNroPedido());
			System.out.println("Cod Unidad Ejecutora :" + requerimientoInsertRequest.getCodUnidadEjecutora());
			System.out.println("Ano Eje :" + requerimientoInsertRequest.getAnoEje());
			System.out.println("Tipo Bien :" + requerimientoInsertRequest.getTipoBien());
			System.out.println("Id Periodo : " + requerimientoInsertRequest.getIdPeriodo());
			
			
			//programado
			System.out.println("Nro Consolidad : " + requerimientoResponse.getNroConsolid());
			System.out.println("Descripcion : " + requerimientoResponse.getMotivoPedido());
			System.out.println("tipo de bien : " + requerimientoResponse.getTipobien());
			System.out.println("monto de pedido : " + requerimientoResponse.getMontoPedido());
			

			if (requerimientoResponse.getNroConsolid() != null && requerimientoResponse.getNroConsolid() != 0) {
				requerimientoInsertRequest.setTipoNecesidad(Constantes.tipoNecesidad.TIPO_NECESIDAD_PROGRAMADO);
				requerimientoInsertRequest.setIdUnidadEjectura(Constantes.unidadEjecutora.ID_UNIDAD_EJECUTORA_ABAS);
				requerimientoInsertRequest.setNroConsolid(requerimientoResponse.getNroConsolid());
				
				//requerimientoInsertRequest.setNroPedido(nroPedido);
				//requerimientoBusiness.insertBasic(requerimientoInsertRequest);
			}else{
				requerimientoInsertRequest.setTipoNecesidad(Constantes.tipoNecesidad.TIPO_NECESIDAD_NO_PROGRAMADO);
				
			}

			requerimientoBusiness.insertBasic(requerimientoInsertRequest);

			buscarRequerimientos();

			System.out.println("***********el valor de nropedidoZ es *********" + requerimientoResponse.getNroPedido());

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Mensaje", "Se Agrego al POI correctamente"));

			System.out.println("************************* Despues geT nroPedido***********************"
					+ requerimientoResponse.getNroPedido());

			if (listaItemRequerimientos.size() == 0)
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

	public List<RequerimientoItemResponse> getListaItemRequerimientos() {
		return listaItemRequerimientos;
	}

	public void setListaItemRequerimientos(List<RequerimientoItemResponse> listaItemRequerimientos) {
		this.listaItemRequerimientos = listaItemRequerimientos;
	}

	public List<RequerimientoResponse> getListaRequerimientos() {
		return listaRequerimientos;
	}

	public void setListaRequerimientos(List<RequerimientoResponse> listaRequerimientos) {
		this.listaRequerimientos = listaRequerimientos;
	}

	public RequerimientoRequest getRequerimientoRequest() {
		return requerimientoRequest;
	}

	public void setRequerimientoRequest(RequerimientoRequest requerimientoRequest) {
		this.requerimientoRequest = requerimientoRequest;
	}

	public RequerimientoResponse getRequerimientoResponse() {
		return requerimientoResponse;
	}

	public void setRequerimientoResponse(RequerimientoResponse requerimientoResponse) {
		this.requerimientoResponse = requerimientoResponse;
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

	public RequerimientoItemRequest getRequerimientoItemRequest() {
		return requerimientoItemRequest;
	}

	public void setRequerimientoItemRequest(RequerimientoItemRequest requerimientoItemRequest) {
		this.requerimientoItemRequest = requerimientoItemRequest;
	}

	public RequerimientoItemResponse getRequerimientoItemResponse() {
		return requerimientoItemResponse;
	}

	public void setRequerimientoItemResponse(RequerimientoItemResponse requerimientoItemResponse) {
		this.requerimientoItemResponse = requerimientoItemResponse;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public RequerimientoInsertRequest getRequerimientoInsertRequest() {
		return requerimientoInsertRequest;
	}

	public void setRequerimientoInsertRequest(RequerimientoInsertRequest requerimientoInsertRequest) {
		this.requerimientoInsertRequest = requerimientoInsertRequest;
	}

	public boolean isAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(boolean auxiliar) {
		this.auxiliar = auxiliar;
	}

	public Documentotecnico getDocumentotecnico() {
		return documentotecnico;
	}

	public void setDocumentotecnico(Documentotecnico documentotecnico) {
		this.documentotecnico = documentotecnico;
	}

	public Dependenciadocumentotecnico getDependenciadocumentotecnico() {
		return dependenciadocumentotecnico;
	}

	public void setDependenciadocumentotecnico(Dependenciadocumentotecnico dependenciadocumentotecnico) {
		this.dependenciadocumentotecnico = dependenciadocumentotecnico;
	}

	public void aceptarRequerimiento() {

		try {

			System.err.println("El valor de idPedido es :" + this.requerimientoResponse.getIdPedido());

			REGISTER_INIT();

			EspecificacionTecnicaDto dto = new EspecificacionTecnicaDto();

			/*********************** Pedido **************************/
			dto.setIdPedido(this.requerimientoResponse.getIdPedido());

			/******************** Documento Tecnico******************* *****/
			dto.setDenominacioncontratacion(this.documentotecnico.getDenominacioncontratacion());
			dto.setFinalidadpublica(this.documentotecnico.getFinalidadpublica());
			dto.setObjetocontratacion(this.documentotecnico.getObjetocontratacion());
			dto.setAntecedentes(this.documentotecnico.getAntecedentes());
			dto.setTipoEsp(this.documentotecnico.getIdcatalogotipotdr());	
			dto.setNroPac(this.documentotecnico.getNropac());
			dto.setNroAnexo(this.documentotecnico.getNroanexoresponsable());
			dto.setRutaAnexo(this.documentotecnico.getRutaanexo());
            dto.setIddocumentotecnico(this.documentotecnico.getIddocumentotecnico());
            
            System.out.println("----------- el valor es : "+this.requerimientoResponse.getIdTipoBien());
            
			if(this.requerimientoResponse.getIdTipoBien().equals("B"))
               dto.setIdCatalogoTipoDocumentoTecnico(Constantes.tipoDocumentoTecnico.ESPECIFICACION_TECNICA);
			if(this.requerimientoResponse.getIdTipoBien().equals("S"))
			   dto.setIdCatalogoTipoDocumentoTecnico(Constantes.tipoDocumentoTecnico.TERMINO_REFERENCIA);

			dto.setBooleano(this.check);

			dto.setPrestaciones(lugares);
			dto.setPagos(pagos);
			dto.setComitesDto(comites2);

			dto.setPrestacionesEliminar(lugaresEliminar);
			dto.setPagosEliminar(pagosEliminar);
			// dto.setComitesDtoEliminar(comites2);

			TransactionRequest<EspecificacionTecnicaDto> transaccionRequest = new TransactionRequest<EspecificacionTecnicaDto>();
			transaccionRequest.setEquipoAuditoria(getRemoteAddr());
			transaccionRequest.setUsuarioAuditoria(getUserLogin());
			transaccionRequest.setProgramaAuditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));

			transaccionRequest.setEntityTransaction(dto);

			showGrowlMessageSuccessfullyCompletedAction();

			requerimientoBusiness.guardarEspecificacionTecnica(transaccionRequest);
			buscarRequerimientos();

			REGISTER_SUCCESS();

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





	public void onRowEdit(RowEditEvent event) {

		FacesMessage msg = new FacesMessage("Se editó correctamente",
				"Direccion: " + ((Lugar) event.getObject()).getDireccion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló la edición",
				"Direccion: " + ((Lugar) event.getObject()).getDireccion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel2(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló la edición",
				"Numero de armada: " + ((Pago) event.getObject()).getNumero());
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void onRowCancel3(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Se canceló la edición",
				"Comité: " + ((ComiteDto) event.getObject()).getNroDocumento());
		;
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public List<Dependenciadocumentotecnico> getListaDependencias() {
		return listaDependencias;
	}

	public void setListaDependencias(List<Dependenciadocumentotecnico> listaDependencias) {
		this.listaDependencias = listaDependencias;
	}

	public boolean isMostrarGrid() {
		return mostrarGrid;
	}

	public void setMostrarGrid(boolean mostrarGrid) {
		this.mostrarGrid = mostrarGrid;
	}

	public double getTotalPorcentaje() {
		return totalPorcentaje;
	}


	public Miembrocomiteporproceso getMiembrocomiteporprocesoB() {
		return miembrocomiteporprocesoB;
	}

	public void setMiembrocomiteporprocesoB(Miembrocomiteporproceso miembrocomiteporprocesoB) {
		this.miembrocomiteporprocesoB = miembrocomiteporprocesoB;
	}


	public void mensajeCheck() {
		String summary = check ? "Comité Especial: Checked" : "Comité Especial: UnChecked";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}

	public void destroyWorld() {
		remitir();
		addMessage("Mensaje", "Remitido a Programación.");
		buscarRequerimientos();

	}

	public void imprimir() {

		System.out.println("Entro al metodo imprimir");

	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	

}
