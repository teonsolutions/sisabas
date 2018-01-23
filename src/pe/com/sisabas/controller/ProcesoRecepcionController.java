package pe.com.sisabas.controller;

import java.rmi.RemoteException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.dto.ProcesoDto;
import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.TipoProcesoResponse;
import pe.com.sisabas.exception.SecurityRestrictedControlException;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.exception.SecurityValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;

@Component(value = "procesoRecepcion")
@Scope(value = "session")
public class ProcesoRecepcionController extends BaseController {
	private static final long serialVersionUID = 1L;

	private List<ProcesoDto> dataList;
	private ProcesoDto selectedRow;
	private ProcesoRequest searchParam;
	private ProcesoDto currentRow;
	
	//Title
	private String tituloBase;
	private String tituloParam;

	//DropDownList
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<TipoProcesoResponse> listaTipoProceso;
	
	//Redirect
	public static String SUCCESS_MIEMBROS = "/pages/pao/ordenRegistrar.xhtml?faces-redirect=true;";
	private String idOpcionText = "OPC_PROCESO";
	
	//Business layer section
	@Autowired
	public pe.com.sisabas.resources.business.UtilsBusiness utilsBusiness;
	@Autowired
	public GentablaBusiness gentablaBusiness; 
	
	public void ProcesoRecepcionController(){
		
	}
	
	public String load(){
		return "/pages/procesorecepcion/procesoRecepcionBuscar.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public void init(){
		searchParam = new ProcesoRequest();
		tituloBase = "Proceso » ";
		try{			
			if (SICU_SECURITY_ENABLE) {
				idOpcion = SicuCallService.obtenerIdOpcion(idOpcionText).toString();
				sicuopcion = SicuCallService.obtenercontroles(idOpcion);
			}					
			listaGentablaIdcatalogotipobien = gentablaBusiness
					.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));			
			//listaTipoProceso = gentablaBusiness.getTipoProceso(usuario.getPeriodo().getAnio());
			
			
		}catch (SecuritySessionExpiredException e) {
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
	
	
	
}
