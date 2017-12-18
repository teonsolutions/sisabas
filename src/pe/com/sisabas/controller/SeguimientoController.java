package pe.com.sisabas.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Dependenciadocumentotecnico;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Persona;
import pe.com.sisabas.be.RequerimientoInsertRequest;
import pe.com.sisabas.be.RequerimientoItemRequest;
import pe.com.sisabas.be.RequerimientoItemResponse;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;
import pe.com.sisabas.be.SegEstadoReqRequest;
import pe.com.sisabas.be.SegEstadoReqResponse;
import pe.com.sisabas.be.SeguimientoRequest;
import pe.com.sisabas.be.SeguimientoResponse;
import pe.com.sisabas.be.Tipodocumento;
import pe.com.sisabas.business.RequerimientoBusiness;
import pe.com.sisabas.business.SeguimientoBusiness;
import pe.com.sisabas.business.TipodocumentoBusiness;
import pe.com.sisabas.dto.ComiteDto;
import pe.com.sisabas.dto.Lugar;
import pe.com.sisabas.dto.Pago;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicuusuario;



@Component(value ="seguimiento")
@Scope(value = "session")
public class SeguimientoController extends BaseController{

	private static final long serialVersionUID = 1L;
	
	//jasaro141217
		private List<SeguimientoResponse> listaSeguimientos = new ArrayList<SeguimientoResponse>();
		private List<SegEstadoReqResponse> listaSegEstados = new ArrayList<SegEstadoReqResponse>();
		private SeguimientoResponse selectedSeguimiento;

	
	//jasaro1312201711AM
		
		@Autowired
		public SeguimientoBusiness seguimientoBusiness;
		@Autowired
		public TipodocumentoBusiness tipodocumentoBusiness;
		
		private SeguimientoRequest seguimientoRequest;
		private List<Tipodocumento> listaTipodocumento;
		List<Integer> listTipoDocumentoKyes;
		
		
		
	
	
		@PostConstruct
		public void init(){
			try {
				seguimientoRequest=new SeguimientoRequest();
				listaTipodocumento=new ArrayList<>();
				listTipoDocumentoKyes=new ArrayList<>();
				selectedSeguimiento=new SeguimientoResponse();
			
			} catch (Exception e) {
				addErrorMessageKey("msgsForm", e);
			}
		}
	
		//jasaro151217
		public void buscarSegRequerimientos(){
				try {
					//jasaro1312201711AM
					/* ALTER PROCEDURE [abas].[paSeguimientoRequerimiento]
							 @EJERCICIO INT
							,@ID_TIPO_NECESIDAD VARCHAR(10) 
							,@ID_TIPO_DOCUMENTO INT 
							,@NRO_DOCUMENTO VARCHAR(20) =NULL
							,@TIPO_BIEN VARCHAR(10)=NULL  
					*/   
				
					Sicuusuario usuario = (Sicuusuario) getHttpSession().getAttribute("sicuusuarioSESSION");
					
					
					
					seguimientoRequest.setEjercicio(usuario.getPeriodo().getAnio());
					listaSeguimientos = seguimientoBusiness.callpaSeguimientoRequerimiento(seguimientoRequest);
					
					
					if (listaSeguimientos.size() == 0)
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
		
		
		public void resetFiltroSeg(){
			
			seguimientoRequest.setTipoNecesidad(null);
			seguimientoRequest.setTipoDocumento(null);
			seguimientoRequest.setNumeroDocumento(null);
			seguimientoRequest.setTipoBien(null);
		}
		
		


		public void changeTipoDocumento(ValueChangeEvent event){
			 	
			 	
				String tipoNecesidad = (String) event.getNewValue();
		
				if(tipoNecesidad==null){
					 listaTipodocumento.clear();
					 return;
				}
				
				listTipoDocumentoKyes.clear();
				
				if(tipoNecesidad.equalsIgnoreCase(Constantes.tipoNecesidad.TIPO_NECESIDAD_PROGRAMADO)){
					listTipoDocumentoKyes.add(Constantes.tipoDocumento.PEDIDO);
				}else{
					if(tipoNecesidad.equalsIgnoreCase(Constantes.tipoNecesidad.TIPO_NECESIDAD_NO_PROGRAMADO)){
						listTipoDocumentoKyes.add(Constantes.tipoDocumento.PEDIDO);listTipoDocumentoKyes.add(Constantes.tipoDocumento.PAO);
					}
				}
				cargarTipoDocumentos(listTipoDocumentoKyes);
				FacesContext.getCurrentInstance().renderResponse();
		}
		
		
		public void cargarTipoDocumentos(List<Integer> listTipoDocumentoKyes){
			
			Tipodocumento record=new Tipodocumento();
			record.addConditionInTipodocumento(listTipoDocumentoKyes);
			
			try {
				
				listaTipodocumento=tipodocumentoBusiness.selectDynamicFull(record);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void listarSegEstados(){
			SegEstadoReqRequest segEstadoReqRequest=new SegEstadoReqRequest();
			segEstadoReqRequest.setIdTipoDocumento(Integer.parseInt(seguimientoRequest.getTipoDocumento()));
			segEstadoReqRequest.setIdDocumento(Integer.parseInt(selectedSeguimiento.getId()));
			segEstadoReqRequest.setNroConsolidado(selectedSeguimiento.getNroConsolidado());
			
			try {
				
				listaSegEstados=seguimientoBusiness.callpaSeguimientoEstadoRequerimiento(segEstadoReqRequest);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	
	public SeguimientoRequest getSeguimientoRequest() {
		return seguimientoRequest;
	}

	public void setSeguimientoRequest(SeguimientoRequest seguimientoRequest) {
		this.seguimientoRequest = seguimientoRequest;
	}


	public List<SeguimientoResponse> getListaSeguimientos() {
		return listaSeguimientos;
	}


	public void setListaSeguimientos(List<SeguimientoResponse> listaSeguimientos) {
		this.listaSeguimientos = listaSeguimientos;
	}


	public List<SegEstadoReqResponse> getListaSegEstados() {
		return listaSegEstados;
	}


	public void setListaSegEstados(List<SegEstadoReqResponse> listaSegEstados) {
		this.listaSegEstados = listaSegEstados;
	}


	public SeguimientoResponse getSelectedSeguimiento() {
		return selectedSeguimiento;
	}


	public void setSelectedSeguimiento(SeguimientoResponse selectedSeguimiento) {
		this.selectedSeguimiento = selectedSeguimiento;
	}

	public List<Tipodocumento> getListaTipodocumento() {
		return listaTipodocumento;
	}

	public void setListaTipodocumento(List<Tipodocumento> listaTipodocumento) {
		this.listaTipodocumento = listaTipodocumento;
	}
	
	

}
