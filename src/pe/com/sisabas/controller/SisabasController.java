package pe.com.sisabas.controller;
import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.com.sisabas.be.Genparametro;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.Sicuopcion;
import pe.com.sisabas.service.Sicuusuario;

@Component(value ="sisabascontrol")
@Scope(value = "session")

public class SisabasController extends BaseController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String registros_mant = "14"; 
	
	private String rutaAplicacion;  /*Util para tener en una variable la ruta de la aplicacion*/
	private String rutaServer;      /*Util para tener en una variable la ruta del servidor*/	
	
	

	public SisabasController() {
    }
	
	@PostConstruct
	public void init(){
    	Genparametro genparametro = new Genparametro();   
		try {
			rutaAplicacion = Utils.getRutaAplicacion();
			rutaServer     = Utils.getRutaServer();			
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}	
	

    
    public String validaOpcion(Integer codigoOpcion) {
    		
    	Utils.eliminaObjetosSesion(); //elimina objetos de sesion
    	String url="";
    	try {
    		url=ubicarOpcion(codigoOpcion);
    		logger.debug("Go To URL:"+url);
			if(url.indexOf("?")==-1)
    			url+="?faces-redirect=true";
    		else
    			url+="&faces-redirect=true";
		} catch (Exception e) {
			addErrorMessage(e);
		}
    	return url;    	
    }    
    


    public String getRegistros_mant() {
		return registros_mant;
	}


	public void setRegistros_mant(String registros_mant) {
		this.registros_mant = registros_mant;
	}	


	public String getRutaAplicacion() {
		return rutaAplicacion;
	}
	public void setRutaAplicacion(String rutaAplicacion) {
		this.rutaAplicacion = rutaAplicacion;
	}
	public String getRutaServer() {
		return rutaServer;
	}
	public void setRutaServer(String rutaServer) {
		this.rutaServer = rutaServer;
	}	
	


	
	public String ubicarOpcion(Integer codigoOpcion){
		Sicuusuario sicuusuario  = (Sicuusuario)Utils.getHttpSession().getAttribute("sicuusuarioSESSION");		
		String urlRetorno = "";
		for(int i=0;i<sicuusuario.getListaSicuopcion().length;i++){
			Sicuopcion item = (Sicuopcion)sicuusuario.getListaSicuopcion(i);
			
			if (item!=null   && item.getIntopccodigo()!=null &&	(item.getIntopccodigo().compareTo(codigoOpcion)==0))
			urlRetorno = item.getVchopcaccion();
			
		}
		return urlRetorno;
	}


}  
                      



