package pe.com.sisabas.controller;

import pe.com.sisabas.be.SeguimientoRequest;
import pe.com.sisabas.resources.controller.BaseController;

public class SeguimientoController extends BaseController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private SeguimientoRequest seguimientoRequest;


	public SeguimientoRequest getSeguimientoRequest() {
		return seguimientoRequest;
	}


	public void setSeguimientoRequest(SeguimientoRequest seguimientoRequest) {
		this.seguimientoRequest = seguimientoRequest;
	}
	
	

}
