package pe.com.sisabas.controller;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Dependenciadocumentotecnico;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.be.Gentipo;
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.be.RequerimientoInsertRequest;
import pe.com.sisabas.be.RequerimientoItemRequest;
import pe.com.sisabas.be.RequerimientoItemResponse;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;
import pe.com.sisabas.business.DependenciadocumentotecnicoBusiness;
import pe.com.sisabas.business.PersonaBusiness;
import pe.com.sisabas.business.RequerimientoBusiness;
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
	
	@Autowired
	public RequerimientoBusiness requerimientoBusiness;
	
	@Autowired
	public DependenciadocumentotecnicoBusiness dependenciaBusiness;
	
	private int tam;
	
	private Lugar lugar; 
	private Pago pago;
	
	private static List<Lugar> lugares=new ArrayList<>();
	private static List<Pago> pagos=new ArrayList<>();
	
	
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


	@PostConstruct
	public void init(){
		
		try {
			
			lugar=new Lugar();
			pago=new Pago();
			
			documentotecnico = new Documentotecnico();
			dependenciadocumentotecnico = new Dependenciadocumentotecnico();
			requerimientoInsertRequest=new RequerimientoInsertRequest();
			
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
			System.out.println("Fer3");
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

			System.out.println("***************Fer4**************"+requerimientoResponse.getEstadoSiga());
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

			//if(auxiliar)
		//	System.out.println("***************Fer11111111111**************"+lugares.size());
		//	 lugares.add(lugar);
		//	 lugares = new ArrayList<Lugar>();
		//	 System.out.println("***************Fer2222222222**************"+lugares.size());
		//	auxiliar=false;
			
			
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
			
			System.out.println("***********el tamanioB es *********"+listaItemRequerimientos.size());
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
	
	public void insertarRequerimientos() {
		try {
			System.out.println("***************Fer5**************"+requerimientoResponse.getNroPedido());
			
			System.out.println("valor 1 es: "+requerimientoInsertRequest.getNroPedido());
			System.out.println("valor 3 es: "+requerimientoResponse.getNumeroSinad());
			
	
			requerimientoInsertRequest.setNroPedido(requerimientoResponse.getNroPedido());
			requerimientoInsertRequest.setCodUnidadEjecutora(Constantes.unidadEjecutora.PRONIED);
			requerimientoInsertRequest.setAnoEje(2017);
			requerimientoInsertRequest.setTipoBien(requerimientoResponse.getTipobien());
			requerimientoInsertRequest.setIdPeriodo(1);

			
			System.out.println("xxxxxxxxxxxxxxxxxx " +requerimientoInsertRequest.getNroPedido());
			System.out.println("xxxxxxxxxxxxxxxxxx " +requerimientoInsertRequest.getCodUnidadEjecutora());
			System.out.println("xxxxxxxxxxxxxxxxxx " +requerimientoInsertRequest.getAnoEje());
			System.out.println("xxxxxxxxxxxxxxxxxx " +requerimientoInsertRequest.getTipoBien());
			System.out.println("xxxxxxxxxxxxxxxxxx " +requerimientoInsertRequest.getIdPeriodo());
			
			
			//Todos		
			//getPedidosEvaluacion
            /*
			if(requerimientoResponse.getTipobien().equalsIgnoreCase("Servicio"))
				requerimientoItemRequest.setTipoBien("S");
			else if (requerimientoResponse.getTipobien().equalsIgnoreCase("Bien"))
				requerimientoItemRequest.setTipoBien("B");*/

			requerimientoBusiness.insertBasic(requerimientoInsertRequest); 
		
			System.out.println("***********el valor de nropedidoZ es *********"+requerimientoResponse.getNroPedido());
			
			 FacesContext context = FacesContext.getCurrentInstance();
			 context.addMessage(null, new FacesMessage("Mensaje", "Se Agrego al POI correctamente"));
			 
			 
			 System.out.println("***********llego o no *********"+requerimientoResponse.getNroPedido());
		
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
            
            dto.setPrestaciones(lugares);
            dto.setPagos(pagos);
            
	    	TransactionRequest<EspecificacionTecnicaDto> transaccionRequest = new TransactionRequest<EspecificacionTecnicaDto>();	    	
	    	transaccionRequest.setEquipoAuditoria(getRemoteAddr());
	    	transaccionRequest.setUsuarioAuditoria(getUserLogin());
	    	transaccionRequest.setProgramaAuditoria(pe.com.sisabas.resources.Utils.obtenerPrograma(this.getClass()));
	    	
	    	transaccionRequest.setEntityTransaction(dto);
	    	
	    	showGrowlMessageSuccessfullyCompletedAction();
	    	
	    	requerimientoBusiness.guardarEspecificacionTecnica(transaccionRequest);
	    	
	    	
	    	
	    	
	    	
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

    
	public void limpiar() {
		RequerimientoController.lugares.clear();
		RequerimientoController.pagos.clear();
		this.documentotecnico.setDenominacioncontratacion(null);
		this.documentotecnico.setFinalidadpublica(null);
		this.documentotecnico.setAntecedentes(null);
		this.documentotecnico.setObjetocontratacion(null);
		this.documentotecnico.setNropac(null);
	}
	 
	
	public void agregarLugar(){ //adding new nationality and set its index
		System.out.println("*************************** El tamanio de listaLugar1 es: "+lugares.size()+" ***************************");
		RequerimientoController.lugares.add(this.lugar);
		lugar=new Lugar();
		System.out.println("*************************** El tamanio de listaLugar2 es: "+lugares.size()+" ***************************");
		FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se agregó lugar de prestación correctamente"));
		
	}
	
	public void eliminarLugar(Lugar lugar){ //adding new nationality and set its index
		System.out.println("*************************** El tamanio de listaLugar3 es: "+lugares.size()+" ***************************");
		RequerimientoController.lugares.remove(lugar);
		
		System.out.println("*************************** El tamanio de listaLugar4 es: "+lugares.size()+" ***************************");
		
		 FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se eliminó lugar de prestación correctamente"));
		
	}
	
	
	public void agregarPago(){ //adding new nationality and set its index

		RequerimientoController.pagos.add(this.pago);
		pago=new Pago();
		FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se agregó forma de pago correctamente"));
		
	}
	
	public void eliminarPago(Pago pago){ //adding new nationality and set its index

		RequerimientoController.pagos.remove(pago);
		
		 FacesContext context = FacesContext.getCurrentInstance();
	     context.addMessage(null, new FacesMessage("Mensaje", "Se eliminó forma de pago correctamente"));
		
	}
		
	
	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se editó correctamente","Dependencia: "+((Lugar) event.getObject()).getDependencia());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
	public void onRowEdit2(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se editó correctamente","Numero de armada: "+((Pago) event.getObject()).getNumero());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se canceló la edición","Dependencia: "+((Lugar) event.getObject()).getDependencia());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel2(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se canceló la edición","Numero de armada: "+((Pago) event.getObject()).getNumero());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	 
}
