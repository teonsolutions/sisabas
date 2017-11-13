
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
import pe.com.sisabas.be.Pacprogramado;
import pe.com.sisabas.business.PacprogramadoBusiness;
import pe.com.sisabas.be.Unidadejecutora;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;



@Component(value ="cc_pacprogramado")
@Scope(value = "session")
public class CC_PacprogramadoBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Pacprogramado pacprogramadoB;
	private Pacprogramado selectedPacprogramado;
	private List<Pacprogramado> listaPacprogramado;
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<Gentabla> listaGentablaIdcatalogoestado;


	@Autowired
	PacprogramadoBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;



	public CC_PacprogramadoBuscar(){
			pacprogramadoB = new Pacprogramado();
			listaPacprogramado= new ArrayList<Pacprogramado>();
	}


	@PostConstruct
	public void init(){
		try {
			pacprogramadoB = new Pacprogramado();
			listaPacprogramado= new ArrayList<Pacprogramado>();
			listaGentablaIdcatalogotipobien = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaGentablaIdcatalogoestado = gentablaBusiness.selectDynamicBasic(new Gentabla());

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			pacprogramadoB = new Pacprogramado();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_pacprogramado:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.pacprogramado.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(pacprogramadoB); //pasa a mayusculas los datos para la busqueda
			listaPacprogramado = business.selectDynamicFullActives(pacprogramadoB);
			if (listaPacprogramado.size() == 0)
			addMessageKey("msgsCC_Pacprogramado",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Pacprogramado", e);
		}
	}

	public void setPacprogramadoB(Pacprogramado pacprogramadoB){
		this.pacprogramadoB = pacprogramadoB;
	}

	public Pacprogramado getPacprogramadoB(){
		return pacprogramadoB;
	}

	public void setSelectedPacprogramado(Pacprogramado selectedPacprogramado){
		this.selectedPacprogramado = selectedPacprogramado;
	}

	public Pacprogramado getSelectedPacprogramado(){
		return selectedPacprogramado;
	}

	public void setListaPacprogramado(List<Pacprogramado> listaPacprogramado){
		this.listaPacprogramado=listaPacprogramado;
	}

	public List<Pacprogramado> getListaPacprogramado(){
		return listaPacprogramado;
	}

	public void setListaGentablaIdcatalogotipobien(List<Gentabla> listaGentablaIdcatalogotipobien){
		this.listaGentablaIdcatalogotipobien=listaGentablaIdcatalogotipobien;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipobien(){
		return listaGentablaIdcatalogotipobien;
	}

	public void setListaGentablaIdcatalogoestado(List<Gentabla> listaGentablaIdcatalogoestado){
		this.listaGentablaIdcatalogoestado=listaGentablaIdcatalogoestado;
	}

	public List<Gentabla> getListaGentablaIdcatalogoestado(){
		return listaGentablaIdcatalogoestado;
	}



}

