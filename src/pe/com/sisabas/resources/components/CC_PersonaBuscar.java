
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
import pe.com.sisabas.be.Persona;
import pe.com.sisabas.business.PersonaBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;



@Component(value ="cc_persona")
@Scope(value = "session")
public class CC_PersonaBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Persona personaB;
	private Persona selectedPersona;
	private List<Persona> listaPersona;
	public List<Gentabla> listaGentablaIdcatalogotipodocumento;


	@Autowired
	PersonaBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	public CC_PersonaBuscar(){
			personaB = new Persona();
			listaPersona= new ArrayList<Persona>();
	}


	@PostConstruct
	public void init(){
		try {
			personaB = new Persona();
			listaPersona= new ArrayList<Persona>();
			listaGentablaIdcatalogotipodocumento = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIDO));

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			personaB = new Persona();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_persona:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.persona.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(personaB); //pasa a mayusculas los datos para la busqueda
			listaPersona = business.selectDynamicFullActives(personaB);
			if (listaPersona.size() == 0)
			addMessageKey("msgsCC_Persona",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Persona", e);
		}
	}

	public void setPersonaB(Persona personaB){
		this.personaB = personaB;
	}

	public Persona getPersonaB(){
		return personaB;
	}

	public void setSelectedPersona(Persona selectedPersona){
		this.selectedPersona = selectedPersona;
	}

	public Persona getSelectedPersona(){
		return selectedPersona;
	}

	public void setListaPersona(List<Persona> listaPersona){
		this.listaPersona=listaPersona;
	}

	public List<Persona> getListaPersona(){
		return listaPersona;
	}

	public void setListaGentablaIdcatalogotipodocumento(List<Gentabla> listaGentablaIdcatalogotipodocumento){
		this.listaGentablaIdcatalogotipodocumento=listaGentablaIdcatalogotipodocumento;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipodocumento(){
		return listaGentablaIdcatalogotipodocumento;
	}



}

