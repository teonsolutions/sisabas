package pe.com.sisabas.controller;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
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
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;

@Component(value ="requerimiento")
@Scope(value = "session")
public class RequerimientoController extends BaseController{

	private static final long serialVersionUID = 1L;
	
	private Miembrocomiteporproceso miembrocomiteporprocesoB;
	private List<String> listaIdcatalogotipomiembroKeys;
	public List<Gentabla> listaGentablaIdcatalogotipomiembro;
	
	
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
	private static double totalPorcentaje=0;
	private boolean check;
	
	
	
	
	private static List<Lugar> lugares=new ArrayList<>();
	private static List<Pago> pagos=new ArrayList<>();
	private static List<Lugar> lugaresEliminar=new ArrayList<>();
	private static List<Pago> pagosEliminar=new ArrayList<>();
	private static List<ComiteDto> comites2 = new ArrayList<>();
	//private static List<Miembrocomiteporproceso> comites = new ArrayList<>();
	//private static List<Miembrocomiteporproceso> comitesEliminar = new ArrayList<>();
	
	
	
	private String fechaformato=null;
	
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
	

	
	private String tituloBase; //titulo de la opcion
	private String tituloParam;//titulo que llega como parametro (derivada padre)
	

	private String idOpcionText = "OPC_REQUERIMIENTO";
	
	public RequerimientoController() {
		
		//System.out.println("***************Fer0000000**************"+lugares.size());
		
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
	public void init(){
		
		try {
	
			miembrocomiteporprocesoB = new Miembrocomiteporproceso();
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
			miembrocomiteporprocesoB.setComiteprocesoIdcomiteproceso(new Comiteproceso());
			miembrocomiteporprocesoB.setPersonaIdpersona(new Persona());
			miembrocomiteporprocesoB.setGentablaIdcatalogotipomiembro(new Gentabla());
			
			listaIdcatalogotipomiembroKeys= new ArrayList<String>();
			listaGentablaIdcatalogotipomiembro = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.CAMI));
			
			
	        comite=new ComiteDto();
			lugar=new Lugar();
			pago=new Pago();
			
			documentotecnico = new Documentotecnico();
			dependenciadocumentotecnico = new Dependenciadocumentotecnico();
			requerimientoInsertRequest=new RequerimientoInsertRequest();
			
			documentotecnico2 = new Documentotecnico(); 
			
			requerimientoRequest = new RequerimientoRequest();
			requerimientoResponse = new RequerimientoResponse();
			requerimientoItemRequest = new RequerimientoItemRequest();
			requerimientoItemResponse = new RequerimientoItemResponse();
			
			
			tituloBase = "Requerimientos » ";
			if(SICU_SECURITY_ENABLE){
				idOpcion   = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}
		
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}
	
	public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	
	
	public void buscarRequerimientos() {
	//	System.out.println("***************FerRRRRRRRRRRR**************"+lugares.size());
		try {
			System.out.println("Metodo buscarRequerimientos");
			//Todos		
			requerimientoRequest.setCodigoUnidadEjecutora("108");
			//requerimientoRequest.setPedido("08761");
			requerimientoRequest.setAnoEje(2017); 
			requerimientoRequest.setPagenumber(1);  
			requerimientoRequest.setPageSize(10);
			

			listaRequerimientos = requerimientoBusiness.selectDynamicFull(requerimientoRequest);
			
			if (listaRequerimientos.size() == 0)
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
	
	
	public void buscarItemRequerimientos() {
		try {

			System.out.println("******************************GetEstadoSiga****************************"+requerimientoResponse.getEstadoSiga());
			//Todos		
			//getPedidosEvaluacion
			requerimientoItemRequest.setCodUnidadEjecutora("108");
			requerimientoItemRequest.setEjercicio(2017); 
			
			requerimientoItemRequest.setNroPedido(requerimientoResponse.getNroPedido());
			
			if(requerimientoResponse.getTipobien().equalsIgnoreCase("Servicio"))
				requerimientoItemRequest.setTipoBien("S");
			else if (requerimientoResponse.getTipobien().equalsIgnoreCase("Bien"))
				requerimientoItemRequest.setTipoBien("B");

			listaItemRequerimientos = requerimientoBusiness.selectDynamicBasic(requerimientoItemRequest);

			
			if(listaItemRequerimientos.size()==1)
				tam=100;
			else tam = 200;
			
			if (listaItemRequerimientos.size() == 0)
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
	
	public void buscarItemRequerimientos2() {

		try {

			requerimientoItemRequest.setCodUnidadEjecutora("108");
			requerimientoItemRequest.setEjercicio(2017); 
			requerimientoItemRequest.setNroPedido(requerimientoResponse.getNroPedido());
			if(requerimientoResponse.getTipobien().equalsIgnoreCase("Servicio"))
				requerimientoItemRequest.setTipoBien("S");
			else if (requerimientoResponse.getTipobien().equalsIgnoreCase("Bien"))
				requerimientoItemRequest.setTipoBien("B");

			listaItemRequerimientos = requerimientoBusiness.selectDynamicBasic(requerimientoItemRequest);
			
			System.out.println("***********el tamanio de ListaItemRequerimientos es *********"+listaItemRequerimientos.size());
			System.out.println("***********el valor de nropedido es *********"+requerimientoResponse.getNroPedido());
			
			if(listaItemRequerimientos.size()==1)
				tam=100;
			else tam = 200;
			
			if (listaItemRequerimientos.size() == 0)
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
	
	public void cargarItemRequerimientos() {
		this.mostrarGrid = false;

		try {
			
	        System.out.println("dfsddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"+ requerimientoResponse.getIdDocumentoTecnico());

	        documentotecnico = documentotecnicoBusiness.selectByPrimaryKeyBasic(requerimientoResponse.getIdDocumentoTecnico());
	        
	        List<Dependenciadocumentotecnico> dependencias = dependenciaBusiness.getDependenciasByDocumentoTecnico(documentotecnico.getIddocumentotecnico());
	        List<Plazopagodocumentotecnico> plazos = plazoBusiness.getPlazosByDocumentoTecnico(documentotecnico.getIddocumentotecnico());
	        
	        
	        System.out.println("***************id de documento tecnico es **********"+requerimientoResponse.getIdDocumentoTecnico());
	       //System.out.println("***************EL TAMANIO ES **********"+dependencias.size());
	        
	        if (dependencias != null)
	        {
		        lugares.clear();	        
		        for (int i = 0; i < dependencias.size(); i++) {
		        	Lugar item = new Lugar();
		        	
		        	item.setIdDependenciaDocumentoTecnico(dependencias.get(i).getIddependenciadocumentotecnico());
		        	item.setDireccion(dependencias.get(i).getDireccion());	        	
		        	RequerimientoController.lugares.add(item);
				}
	        }
	        
	        if (plazos != null)
	        {
		        pagos.clear();	        
		        for (int i = 0; i < plazos.size(); i++) {
		        	Pago item = new Pago();
		        	
		        	item.setIdDependenciaDocumentoTecnico(plazos.get(i).getIdplazopagodocumentotecnico());
		        	item.setCronograma(plazos.get(i).getCronograma());
		        	item.setPlazo(plazos.get(i).getPlazo());
		            item.setNivel(plazos.get(i).getNivelavance());
		        	item.setPorcentaje(plazos.get(i).getPorcentajeavance());	        	
		        	RequerimientoController.pagos.add(item);
				}
		        
		        
	        }
	       
	        sumaPorcentajes();
	        
			requerimientoItemRequest.setCodUnidadEjecutora("108");
			requerimientoItemRequest.setEjercicio(2017); 
			requerimientoItemRequest.setNroPedido(requerimientoResponse.getNroPedido());
			if(requerimientoResponse.getTipobien().equalsIgnoreCase("Servicio"))
				requerimientoItemRequest.setTipoBien("S");
			else if (requerimientoResponse.getTipobien().equalsIgnoreCase("Bien"))
				requerimientoItemRequest.setTipoBien("B");

			listaItemRequerimientos = requerimientoBusiness.selectDynamicBasic(requerimientoItemRequest);
			
			
			System.out.println("***********el tamanioListaRequerimientos es *********"+listaItemRequerimientos.size());
			System.out.println("***********el valor de nrPedido es *********"+requerimientoResponse.getNroPedido());
			
			if(listaItemRequerimientos.size()==1)
				tam=100;
			else tam = 200;
			
			if (listaItemRequerimientos.size() == 0)
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
	public void insertarRequerimientos() {
		try {
			System.out.println("***************Fer5**************"+requerimientoResponse.getNroPedido());
			
			System.out.println("[RequerimientoController - insertarRequerimientos] valor getNroPedido es: "+requerimientoInsertRequest.getNroPedido());
			System.out.println("[RequerimientoController - insertarRequerimientos] valor getNumeroSinad es: "+requerimientoResponse.getNumeroSinad());
			
	
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
			
			requerimientoBusiness.insertBasic(requerimientoInsertRequest); 
			buscarRequerimientos();
		
			System.out.println("***********el valor de nropedidoZ es *********"+requerimientoResponse.getNroPedido());
			
			 FacesContext context = FacesContext.getCurrentInstance();
			 context.addMessage(null, new FacesMessage("Mensaje", "Se Agrego al POI correctamente"));
			 
			 
			 System.out.println("************************* Despues geT nroPedido***********************"+requerimientoResponse.getNroPedido());
		
			if (listaItemRequerimientos.size() == 0)
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
	    	
	    	REGISTER_INIT();
	    		    	
	    	EspecificacionTecnicaDto dto = new EspecificacionTecnicaDto();
	    	
	    	/***********************Pedido**************************/
	    	dto.setIdPedido(this.requerimientoResponse.getIdPedido());
	    	
	    	
	    	/********************Documento Tecnico******************* *****/
	    	dto.setDenominacioncontratacion(this.documentotecnico.getDenominacioncontratacion());
	    	dto.setFinalidadpublica(this.documentotecnico.getFinalidadpublica());
	    	dto.setObjetocontratacion(this.documentotecnico.getObjetocontratacion());
	    	dto.setAntecedentes(this.documentotecnico.getAntecedentes());
            dto.setTipoEsp(this.documentotecnico.getIdcatalogotipotdr());              	    	
	    	dto.setNroPac(this.documentotecnico.getNropac());
	    	dto.setNroAnexo(this.documentotecnico.getNroanexoresponsable());

	    	
	    	dto.setIddocumentotecnico(this.documentotecnico.getIddocumentotecnico());
	    	
	    	
	    	System.err.println("---------------------------------------------getiddocumento----------------------------------------- = "+dto.getIddocumentotecnico());
	    	
	    	dto.setBooleano(this.check);  
	    	
            dto.setPrestaciones(lugares);
            dto.setPagos(pagos);
            dto.setComitesDto(comites2);
            
            dto.setPrestacionesEliminar(lugaresEliminar);
            dto.setPagosEliminar(pagosEliminar);
            //dto.setComitesDtoEliminar(comites2);
            
            
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
				addMessageKey("msgsForm", Messages.getString("no.access"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
			} catch (SecurityValidateException e) {
				addMessageKey("msgsForm",e.getMessage(), FacesMessage.SEVERITY_ERROR);
			} catch (RemoteException e) {
				addMessageKey("msgsForm", Messages.getString("sicu.remote.exeption"),e.getMessage(),FacesMessage.SEVERITY_ERROR);
			} catch (Exception e) {
				addErrorMessageKey("msgsForm", e);
			}   	
	    	
	    	
		}

	


	public Lugar getLugar() {
		return lugar;
	}


	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}


	public Pago getPago() {
		return pago;
	}


	public void setPago(Pago pago) {
		this.pago = pago;
	}


	public List<Lugar> getLugares() {
		return lugares;
	}


	public void setLugares(List<Lugar> lugares) {
		RequerimientoController.lugares = lugares;
	}


	public List<Pago> getPagos() {
		return pagos;
	}


	public void setPagos(List<Pago> pagos) {
		RequerimientoController.pagos = pagos;
	}

    
	public List<Pago> getPagosEliminar() {
		return pagosEliminar;
	}


	public void setPagosEliminar(List<Pago> pagosEliminar) {
		RequerimientoController.pagosEliminar = pagosEliminar;
	}


	public List<Lugar> getLugaresEliminar() {
		return lugaresEliminar;
	}


	public void setLugaresEliminar(List<Lugar> lugaresEliminar) {
		RequerimientoController.lugaresEliminar = lugaresEliminar;
	}


	public void limpiar() {
		//RequerimientoController.comites.clear();
		RequerimientoController.lugares.clear();
		RequerimientoController.pagos.clear();
		RequerimientoController.comites2.clear();
		RequerimientoController.lugaresEliminar.clear();
		RequerimientoController.pagosEliminar.clear();	
		this.documentotecnico.setDenominacioncontratacion(null);
		this.documentotecnico.setFinalidadpublica(null);
		this.documentotecnico.setAntecedentes(null);
		this.documentotecnico.setObjetocontratacion(null);
		this.documentotecnico.setNropac(null);
		this.documentotecnico.setIddocumentotecnico(null);
		this.check = false;
	}
	 
	
	public void agregarLugar(){ //adding new nationality and set its index
		System.out.println("*************************** El tamanio de listaLugar1 es: "+lugares.size()+" ***************************");
		RequerimientoController.lugares.add(this.lugar);
		lugar=new Lugar();
		System.out.println("*************************** El tamanio de listaLugar2 es: "+lugares.size()+" ***************************");
		FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se agregó lugar de prestación correctamente"));
		
	}
	
	public void agregarComite(){ //adding new nationality and set its index
	//	System.out.println("*************************** El tamanio de listaComite1 es: "+comites.size()+" ***************************");
		
		
		//Gentabla gentabla=new Gentabla();
		//if(miembrocomiteporprocesoB.getGentablaIdcatalogotipomiembro()!=null){
			String codigo=comite.getTipoMiembro();
			System.out.println("el valor de mi codigo es "+codigo);
			
			if(codigo.equals("CAMI1")){
				   //gentabla.setVchregcodigo("CAMI1");
				comite.setDescMiembro("PRESIDENTE");}
			if(codigo.equals("CAMI2")){
				   //gentabla.setVchregcodigo("CAMI2");
				comite.setDescMiembro("PRIMER MIEMBRO");}
			if(codigo.equals("CAMI3")){
				  // gentabla.setVchregcodigo("CAMI3");
				comite.setDescMiembro("SEGUNDO MIEMBRO");}
			if(codigo.equals("CAMI4")){
				  // gentabla.setVchregcodigo("CAMI4");
				comite.setDescMiembro("SUPLENTE PRESIDENTE");}
			if(codigo.equals("CAMI5")){
				   //gentabla.setVchregcodigo("CAMI5");
				comite.setDescMiembro("SUPLENTE PRIMER MIEMBRO");}
			if(codigo.equals("CAMI6")){
				  // gentabla.setVchregcodigo("CAMI6");
				comite.setDescMiembro("SUPLENTE SEGUNDO MIEMBRO");}
			
		//	}
			
	//	miembrocomiteporprocesoB.setGentablaIdcatalogotipomiembro(gentabla);
		
		//RequerimientoController.comites.add(this.miembrocomiteporprocesoB);
	//	miembrocomiteporprocesoB=new Miembrocomiteporproceso();
		//miembrocomiteporprocesoB.setGentablaIdcatalogotipomiembro(new Gentabla());

			RequerimientoController.comites2.add(this.comite);
			comite=new ComiteDto();
		
		
		System.out.println("*************************** El tamanio de listaComite2 es: "+comites2.size()+" ***************************");
		FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se agregó comité correctamente"));
		
	}
	
	
	public void eliminarLugar(Lugar lugar){ //adding new nationality and set its index
		//coleccion para eliminar de la base
		RequerimientoController.lugaresEliminar.add(lugar);
		
		System.out.println("*************************** El tamanio de listaLugar3 es: "+lugares.size()+" ***************************");
		RequerimientoController.lugares.remove(lugar);
		
		System.out.println("*************************** El tamanio de listaLugar4 es: "+lugares.size()+" ***************************");
		
		
		 FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se eliminó lugar de prestación correctamente"));
		
	     
	}
	
	public void eliminarComite(ComiteDto comite){ //adding new nationality and set its index
		//coleccion para eliminar de la base
	//	RequerimientoController.comitesEliminar.add(comite);
		
		System.out.println("*************************** El tamanio de listaLugar3 es: "+lugares.size()+" ***************************");
		RequerimientoController.comites2.remove(comite);
		
		System.out.println("*************************** El tamanio de listaLugar4 es: "+lugares.size()+" ***************************");
		
		
		 FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se eliminó lugar de prestación correctamente"));
		
	     
	}
	
	
	public void agregarPago(){ //adding new nationality and set its index

		RequerimientoController.pagos.add(this.pago);
		pago=new Pago();
		FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se agregó forma de pago correctamente"));
	     sumaPorcentajes();
		
	}
	
	public void eliminarPago(Pago pago){ //adding new nationality and set its index
		//coleccion para eliminar pago
	    RequerimientoController.pagosEliminar.add(pago);
		
		RequerimientoController.pagos.remove(pago);
		
		 FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se eliminó forma de pago correctamente"));
	     sumaPorcentajes();
	     
	}
		
	public void sumaPorcentajes(){
		
		RequerimientoController.totalPorcentaje = 0;
		if(RequerimientoController.pagos!=null){
		   for (Pago pago1 : RequerimientoController.pagos) {
			   //RequerimientoController.totalPorcentaje +=RequerimientoController.totalPorcentaje.add(pago1.getPorcentaje());
			   if(pago1.getPorcentaje()!=null)
			   
			   RequerimientoController.totalPorcentaje += pago1.getPorcentaje().doubleValue();
		   }
		}
	}
	
	
	
	public void onRowEdit(RowEditEvent event) {
		
        FacesMessage msg = new FacesMessage("Se editó correctamente","Dependencia: "+((Lugar) event.getObject()).getDependencia());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
	public void onRowEdit2(RowEditEvent event) {
		
        FacesMessage msg = new FacesMessage("Se editó correctamente","Numero de armada: "+((Pago) event.getObject()).getNumero());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        sumaPorcentajes();
    }
	
    public void onRowEdit3(RowEditEvent event) {
		
        FacesMessage msg = new FacesMessage("Se editó correctamente","Comité: "+((ComiteDto) event.getObject()).getNroDocumento());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        sumaPorcentajes();
    }
	
	
	
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se canceló la edición","Dependencia: "+((Lugar) event.getObject()).getDependencia());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel2(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se canceló la edición","Numero de armada: "+((Pago) event.getObject()).getNumero());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }

    public void onRowCancel3(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se canceló la edición","Comité: "+((ComiteDto) event.getObject()).getNroDocumento());;
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


	public void setTotalPorcentaje(double totalPorcentaje) {
		RequerimientoController.totalPorcentaje = totalPorcentaje;
	}


	public Miembrocomiteporproceso getMiembrocomiteporprocesoB() {
		return miembrocomiteporprocesoB;
	}


	public void setMiembrocomiteporprocesoB(Miembrocomiteporproceso miembrocomiteporprocesoB) {
		this.miembrocomiteporprocesoB = miembrocomiteporprocesoB;
	}

	public void loadMainIdpersona(org.primefaces.event.SelectEvent event) {
		try {
			logger.debug("loadMainPersona.event...");
			pe.com.sisabas.be.Persona item= (pe.com.sisabas.be.Persona) event.getObject();
			logger.debug("loadmiembrocomiteporproceso.event...:"+item.getIdpersona());
			miembrocomiteporprocesoB.setIdpersona(item.getIdpersona());
			miembrocomiteporprocesoB.setPersonaIdpersona(item);
			
			//agregando a vista 
			comite.setNroDocumento(miembrocomiteporprocesoB.getPersonaIdpersona().getNumerodocumento());
			comite.setApPaterno(miembrocomiteporprocesoB.getPersonaIdpersona().getApellidopaterno());
			comite.setApMaterno(miembrocomiteporprocesoB.getPersonaIdpersona().getApellidomaterno());
			comite.setNombres(miembrocomiteporprocesoB.getPersonaIdpersona().getNombres());
			
			comite.setId(miembrocomiteporprocesoB.getPersonaIdpersona().getIdpersona());
			
			
			logger.debug("loadPersona.event...ok");
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void resetMainIdpersona() {
		try {
			miembrocomiteporprocesoB.setIdpersona(null);
			miembrocomiteporprocesoB.setPersonaIdpersona(new Persona());
			comite.setNroDocumento(null);
			comite.setApPaterno(null);
			comite.setApMaterno(null);
			comite.setNombres(null);
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}


	public List<String> getListaIdcatalogotipomiembroKeys() {
		return listaIdcatalogotipomiembroKeys;
	}


	public void setListaIdcatalogotipomiembroKeys(List<String> listaIdcatalogotipomiembroKeys) {
		this.listaIdcatalogotipomiembroKeys = listaIdcatalogotipomiembroKeys;
	}
	
	public void setListaGentablaIdcatalogotipomiembro(List<Gentabla> listaGentablaIdcatalogotipomiembro){
		this.listaGentablaIdcatalogotipomiembro=listaGentablaIdcatalogotipomiembro;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipomiembro(){
		return listaGentablaIdcatalogotipomiembro;
	}


	public List<ComiteDto> getComites2() {
		return comites2;
	}


	public void setComites2(List<ComiteDto> comites2) {
		RequerimientoController.comites2 = comites2;
	}


	public ComiteDto getComite() {
		return comite;
	}


	public void setComite(ComiteDto comite) {
		this.comite = comite;
	}
	
	
	public void LimpiarInicio(){
		this.requerimientoRequest.setPedido(null);
		this.requerimientoRequest.setNroExpediente(null);
		this.requerimientoRequest.setTipoNecesidad("No Programado");
		this.requerimientoRequest.setTipoBien("TODOS");
		this.requerimientoRequest.setEstado("TODOS");
		
	}

	public boolean isCheck() {
		return check;
	}


	public void setCheck(boolean check) {
		this.check = check;
	}
	
	
	public void mensajeCheck() {
		String summary = check ? "Comité Especial: Checked" : "Comité Especial: UnChecked";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
	
	

	public void destroyWorld() {
        addMessage("System Error", "Please try again later.");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	
}
