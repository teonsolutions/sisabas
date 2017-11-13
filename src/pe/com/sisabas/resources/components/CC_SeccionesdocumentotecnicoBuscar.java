
package pe.com.sisabas.resources.components;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.be.Seccionesdocumentotecnico;
import pe.com.sisabas.business.SeccionesdocumentotecnicoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;



@Component(value ="cc_seccionesdocumentotecnico")
@Scope(value = "session")
public class CC_SeccionesdocumentotecnicoBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Seccionesdocumentotecnico seccionesdocumentotecnicoB;
	private Seccionesdocumentotecnico selectedSeccionesdocumentotecnico;
	private List<Seccionesdocumentotecnico> listaSeccionesdocumentotecnico;
	public List<Gentabla> listaGentablaIdcatalogotipodocumentotecnico;
	public List<Gentabla> listaGentablaIdcatalogotipotdr;


	@Autowired
	SeccionesdocumentotecnicoBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	public CC_SeccionesdocumentotecnicoBuscar(){
			seccionesdocumentotecnicoB = new Seccionesdocumentotecnico();
			listaSeccionesdocumentotecnico= new ArrayList<Seccionesdocumentotecnico>();
	}


	@PostConstruct
	public void init(){
		try {
			seccionesdocumentotecnicoB = new Seccionesdocumentotecnico();
			listaSeccionesdocumentotecnico= new ArrayList<Seccionesdocumentotecnico>();
			listaGentablaIdcatalogotipodocumentotecnico = gentablaBusiness.selectDynamicBasic(new Gentabla());
			listaGentablaIdcatalogotipotdr = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TITD));

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			seccionesdocumentotecnicoB = new Seccionesdocumentotecnico();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_seccionesdocumentotecnico:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.seccionesdocumentotecnico.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(seccionesdocumentotecnicoB); //pasa a mayusculas los datos para la busqueda
			listaSeccionesdocumentotecnico = business.selectDynamicFullActives(seccionesdocumentotecnicoB);
			if (listaSeccionesdocumentotecnico.size() == 0)
			addMessageKey("msgsCC_Seccionesdocumentotecnico",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Seccionesdocumentotecnico", e);
		}
	}

	public void setSeccionesdocumentotecnicoB(Seccionesdocumentotecnico seccionesdocumentotecnicoB){
		this.seccionesdocumentotecnicoB = seccionesdocumentotecnicoB;
	}

	public Seccionesdocumentotecnico getSeccionesdocumentotecnicoB(){
		return seccionesdocumentotecnicoB;
	}

	public void setSelectedSeccionesdocumentotecnico(Seccionesdocumentotecnico selectedSeccionesdocumentotecnico){
		this.selectedSeccionesdocumentotecnico = selectedSeccionesdocumentotecnico;
	}

	public Seccionesdocumentotecnico getSelectedSeccionesdocumentotecnico(){
		return selectedSeccionesdocumentotecnico;
	}

	public void setListaSeccionesdocumentotecnico(List<Seccionesdocumentotecnico> listaSeccionesdocumentotecnico){
		this.listaSeccionesdocumentotecnico=listaSeccionesdocumentotecnico;
	}

	public List<Seccionesdocumentotecnico> getListaSeccionesdocumentotecnico(){
		return listaSeccionesdocumentotecnico;
	}

	public void setListaGentablaIdcatalogotipodocumentotecnico(List<Gentabla> listaGentablaIdcatalogotipodocumentotecnico){
		this.listaGentablaIdcatalogotipodocumentotecnico=listaGentablaIdcatalogotipodocumentotecnico;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipodocumentotecnico(){
		return listaGentablaIdcatalogotipodocumentotecnico;
	}

	public void setListaGentablaIdcatalogotipotdr(List<Gentabla> listaGentablaIdcatalogotipotdr){
		this.listaGentablaIdcatalogotipotdr=listaGentablaIdcatalogotipotdr;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipotdr(){
		return listaGentablaIdcatalogotipotdr;
	}



}

