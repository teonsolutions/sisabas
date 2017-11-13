
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
import pe.com.sisabas.be.Vcertificacion;
import pe.com.sisabas.business.VcertificacionBusiness;



@Component(value ="cc_vcertificacion")
@Scope(value = "session")
public class CC_VcertificacionBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Vcertificacion vcertificacionB;
	private Vcertificacion selectedVcertificacion;
	private List<Vcertificacion> listaVcertificacion;


	@Autowired
	VcertificacionBusiness business;



	public CC_VcertificacionBuscar(){
			vcertificacionB = new Vcertificacion();
			listaVcertificacion= new ArrayList<Vcertificacion>();
	}


	@PostConstruct
	public void init(){
		try {
			vcertificacionB = new Vcertificacion();
			listaVcertificacion= new ArrayList<Vcertificacion>();

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			vcertificacionB = new Vcertificacion();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_vcertificacion:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.vcertificacion.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(vcertificacionB); //pasa a mayusculas los datos para la busqueda
			listaVcertificacion = business.selectDynamicFullActives(vcertificacionB);
			if (listaVcertificacion.size() == 0)
			addMessageKey("msgsCC_Vcertificacion",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Vcertificacion", e);
		}
	}

	public void setVcertificacionB(Vcertificacion vcertificacionB){
		this.vcertificacionB = vcertificacionB;
	}

	public Vcertificacion getVcertificacionB(){
		return vcertificacionB;
	}

	public void setSelectedVcertificacion(Vcertificacion selectedVcertificacion){
		this.selectedVcertificacion = selectedVcertificacion;
	}

	public Vcertificacion getSelectedVcertificacion(){
		return selectedVcertificacion;
	}

	public void setListaVcertificacion(List<Vcertificacion> listaVcertificacion){
		this.listaVcertificacion=listaVcertificacion;
	}

	public List<Vcertificacion> getListaVcertificacion(){
		return listaVcertificacion;
	}



}

