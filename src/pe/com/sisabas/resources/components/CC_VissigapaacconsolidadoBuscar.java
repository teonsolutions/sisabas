
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
import pe.com.sisabas.be.Vissigapaacconsolidado;
import pe.com.sisabas.business.VissigapaacconsolidadoBusiness;



@Component(value ="cc_vissigapaacconsolidado")
@Scope(value = "session")
public class CC_VissigapaacconsolidadoBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Vissigapaacconsolidado vissigapaacconsolidadoB;
	private Vissigapaacconsolidado selectedVissigapaacconsolidado;
	private List<Vissigapaacconsolidado> listaVissigapaacconsolidado;


	@Autowired
	VissigapaacconsolidadoBusiness business;



	public CC_VissigapaacconsolidadoBuscar(){
			vissigapaacconsolidadoB = new Vissigapaacconsolidado();
			listaVissigapaacconsolidado= new ArrayList<Vissigapaacconsolidado>();
	}


	@PostConstruct
	public void init(){
		try {
			vissigapaacconsolidadoB = new Vissigapaacconsolidado();
			listaVissigapaacconsolidado= new ArrayList<Vissigapaacconsolidado>();

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			vissigapaacconsolidadoB = new Vissigapaacconsolidado();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_vissigapaacconsolidado:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.vissigapaacconsolidado.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(vissigapaacconsolidadoB); //pasa a mayusculas los datos para la busqueda
			listaVissigapaacconsolidado = business.selectDynamicFullActives(vissigapaacconsolidadoB);
			if (listaVissigapaacconsolidado.size() == 0)
			addMessageKey("msgsCC_Vissigapaacconsolidado",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Vissigapaacconsolidado", e);
		}
	}

	public void setVissigapaacconsolidadoB(Vissigapaacconsolidado vissigapaacconsolidadoB){
		this.vissigapaacconsolidadoB = vissigapaacconsolidadoB;
	}

	public Vissigapaacconsolidado getVissigapaacconsolidadoB(){
		return vissigapaacconsolidadoB;
	}

	public void setSelectedVissigapaacconsolidado(Vissigapaacconsolidado selectedVissigapaacconsolidado){
		this.selectedVissigapaacconsolidado = selectedVissigapaacconsolidado;
	}

	public Vissigapaacconsolidado getSelectedVissigapaacconsolidado(){
		return selectedVissigapaacconsolidado;
	}

	public void setListaVissigapaacconsolidado(List<Vissigapaacconsolidado> listaVissigapaacconsolidado){
		this.listaVissigapaacconsolidado=listaVissigapaacconsolidado;
	}

	public List<Vissigapaacconsolidado> getListaVissigapaacconsolidado(){
		return listaVissigapaacconsolidado;
	}



}

