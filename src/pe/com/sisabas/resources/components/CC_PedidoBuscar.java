
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
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.business.PedidoBusiness;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.business.PeriodoBusiness;
import pe.com.sisabas.be.Periodo;
import pe.com.sisabas.be.Vcentrocosto;
import pe.com.sisabas.business.GentablaBusiness;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Unidadejecutora;
import pe.com.sisabas.be.Vispedido;



@Component(value ="cc_pedido")
@Scope(value = "session")
public class CC_PedidoBuscar extends BaseController {

	private static final long serialVersionUID = 1L;
	private Pedido pedidoB;
	private Pedido selectedPedido;
	private List<Pedido> listaPedido;
	public List<Gentabla> listaGentablaIdcatalogotipobien;
	public List<Periodo> listaPeriodoIdperiodo;
	public List<Gentabla> listaGentablaIdcatalogotiponecesidad;


	@Autowired
	PedidoBusiness business;

	@Autowired
	public GentablaBusiness gentablaBusiness;

	@Autowired
	public PeriodoBusiness periodoBusiness;



	public CC_PedidoBuscar(){
			pedidoB = new Pedido();
			listaPedido= new ArrayList<Pedido>();
	}


	@PostConstruct
	public void init(){
		try {
			pedidoB = new Pedido();
			listaPedido= new ArrayList<Pedido>();
			listaGentablaIdcatalogotipobien = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TIBI));
			listaPeriodoIdperiodo = periodoBusiness.selectDynamicBasic(new Periodo());
			listaGentablaIdcatalogotiponecesidad = gentablaBusiness.selectDynamicBasic(new Gentabla().getObjBusqueda(Constantes.tabla.TINE));

		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void init(String pk){
		try {
			pedidoB = new Pedido();
			pk=pk.substring(6);
			if(pk.length()>0){
				logger.debug("Init cc_pedido:"+ pk);
				buscar();
			}
		} catch (Exception e) {
			addErrorMessageKey("msgsForm", e);
		}
	}

	public void buscar() {
		try {
			logger.debug("cc.pedido.buscar...");
			pe.com.sisabas.resources.Utils.convertPropertiesStringToUppercase(pedidoB); //pasa a mayusculas los datos para la busqueda
			listaPedido = business.selectDynamicFullActives(pedidoB);
			if (listaPedido.size() == 0)
			addMessageKey("msgsCC_Pedido",
				Messages.getString("no.records.found"),
				FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			addErrorMessageKey("msgsCC_Pedido", e);
		}
	}

	public void setPedidoB(Pedido pedidoB){
		this.pedidoB = pedidoB;
	}

	public Pedido getPedidoB(){
		return pedidoB;
	}

	public void setSelectedPedido(Pedido selectedPedido){
		this.selectedPedido = selectedPedido;
	}

	public Pedido getSelectedPedido(){
		return selectedPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido){
		this.listaPedido=listaPedido;
	}

	public List<Pedido> getListaPedido(){
		return listaPedido;
	}

	public void setListaGentablaIdcatalogotipobien(List<Gentabla> listaGentablaIdcatalogotipobien){
		this.listaGentablaIdcatalogotipobien=listaGentablaIdcatalogotipobien;
	}

	public List<Gentabla> getListaGentablaIdcatalogotipobien(){
		return listaGentablaIdcatalogotipobien;
	}

	public void setListaPeriodoIdperiodo(List<Periodo> listaPeriodoIdperiodo){
		this.listaPeriodoIdperiodo=listaPeriodoIdperiodo;
	}

	public List<Periodo> getListaPeriodoIdperiodo(){
		return listaPeriodoIdperiodo;
	}

	public void setListaGentablaIdcatalogotiponecesidad(List<Gentabla> listaGentablaIdcatalogotiponecesidad){
		this.listaGentablaIdcatalogotiponecesidad=listaGentablaIdcatalogotiponecesidad;
	}

	public List<Gentabla> getListaGentablaIdcatalogotiponecesidad(){
		return listaGentablaIdcatalogotiponecesidad;
	}



}

