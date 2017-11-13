package pe.com.sisabas.shiro.filters;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import pe.com.sisabas.controller.LoginController;
import pe.com.sisabas.exception.SecuritySessionExpiredException;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.controller.BaseController;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicuopcion;
import pe.com.sisabas.service.Sicurespuesta;
import pe.com.sisabas.service.Sicuusuario;

public class UsuarioFilter implements Filter {
	public static Logger logger=Logger.getLogger(UsuarioFilter.class);
	FilterConfig filterConfig;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		String url = "/noaccess.xhtml";
		String urlRemoteException = "/error.xhtml";
		String sesionexpirada = BaseController.URL_SESSION_EXPIRED;
		
		System.out.println("UsuarioFilter..");
	    if (request instanceof HttpServletRequest) {
	    	HttpSession session = ((HttpServletRequest)request).getSession(false);
	        if (session != null) {
	        	
	        	LoginController login = (LoginController) session.getAttribute("loginBean");
	        	
	        	Sicuusuario  sicuusuario = (Sicuusuario)session.getAttribute("sicuusuarioSESSION");
	        	
				String uri       = ((HttpServletRequest) request).getRequestURI();
	        	
	            if (login != null){
	            
	            	
					//Excepciones para paginas 
					if (uri.equals("/sisabas/pages/custom/sincronizacion.xhtml") && sicuusuario.getVchusulogin().equals("ADMIN")){
	        			chain.doFilter(request, response);
	        			return;
					}
					

					if (uri.equals("/sisabas/pages/home.xhtml")){
	        			chain.doFilter(request, response);
	        			return;
					}				            	
	            	
	            		            
	            
	            	System.out.println("UsuarioFilter..::"+login.isAuthorized());
	            	if(login.getRole()!=null && login.getRole().equalsIgnoreCase(LoginController.ROLE_USER) && login.isAuthorized()){	            		
	            		System.out.println("doFilter ok.....");
	            		
	            		if(BaseController.SICU_SECURITY_ENABLE){
	            		
		            		boolean actualizarUltimoAccesoBD = true;
		            		actualizarUltimoAccesoBD = validaActualizarUltimoAcceso(login.getDatFechaHoraUltimoAcceso());
		            		
		            		//Actualizando ultimo acceso a la BD - Inicio
		            		if (actualizarUltimoAccesoBD){
			            		try{
				            		Sicurespuesta sicurespuesta = SicuCallService.actualizarfecacceso(sicuusuario.getVchsessionid());
				            		login.setDatFechaHoraUltimoAcceso(sicurespuesta.getDatAuxDatoDate());
				    	        	session.setAttribute("loginBean",login);			    	        	
			            		} catch (SecuritySessionExpiredException e) {
			            			login.setMessage(e.getMessage());
			            			customForward(filterConfig, request, response, sesionexpirada);
			            			return;
			            		} catch (RemoteException e) {		            			
			            			login.setMessage(Messages.getString("sicu.remote.exeption")+": "+e.getMessage());
			            			customForward(filterConfig, request, response, urlRemoteException);
			            			return;
			            		} catch (Exception e) {
			            			login.setMessage(e.getMessage());		            			
			            			customForward(filterConfig, request, response, urlRemoteException);
			            			return;
			            		}
		            		}
		            		//Actualizando ultimo acceso a la BD - Final 
		            		
		            		
		            		//Verificando si la url esta en la lista de opciones validas para el usuario - Inicio
		            		boolean opcion_valida=false;
		            		opcion_valida = validaOpcionUsuario(sicuusuario, uri);
		            		//opcion_valida = true;  //PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA
		            		if (opcion_valida==false){
		            			filterConfig.getServletContext().getRequestDispatcher(url).forward(request, response);       
		            			return;
		            		}
	            		
	            		}
	            		//Verificando si la url esta en la lista de opciones validas para el usuario - Final
	            		logger.debug("URI:"+((HttpServletRequest) request).getRequestURI());
            			chain.doFilter(request, response);
            			return;//OK
						
	            		//}
	            	}
	            	else{
	            		//url = "/login.jsf";
	            	}
	            }
	        }
	    }
	    filterConfig.getServletContext().getRequestDispatcher(url).forward(request, response);	    
	}
	
	public void customForward(FilterConfig filterConfig, ServletRequest request,ServletResponse response,String url)throws IOException, ServletException{
		if ("partial/ajax".equals(((HttpServletRequest) request).getHeader("Faces-Request"))) {
		    response.setContentType("text/xml");
		    response.getWriter()
		        .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
		        .printf("<partial-response><redirect url=\"%s\"></redirect></partial-response>", "/"+BaseController.PROYECT_NAME+url);
		    return;
		}else{
			filterConfig.getServletContext().getRequestDispatcher(url).forward(request, response);       
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
	}	
	
	/*Verifica si han transcurrido menos de un minuto desde la actualizacion anterior, si es asi no se actualiza la fecha de ultimo acceso en la BD*/
	private boolean validaActualizarUltimoAcceso(Date fechaHoraUltimoAcceso){
	boolean resp = true;	
	if (fechaHoraUltimoAcceso!=null){
		Date fechahoraactual = new Date();
		long diff = fechahoraactual.getTime() - fechaHoraUltimoAcceso.getTime();
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours   = diff / (60 * 60 * 1000) % 24;
		long diffTotalSeconds = (diffSeconds + (diffMinutes*60) + (diffHours*3600));     
		
		if (diffTotalSeconds<=60){
			resp=false;
		}
	}
	return resp;
	}
	
	/*Verificando si la url esta en la lista de opciones validas para el usuario*/	
	private boolean validaOpcionUsuario(Sicuusuario sicuusuario, String uri){
		boolean opcion_valida=false;
		if (sicuusuario!=null && sicuusuario.getListaSicuopcion()!=null){
			for(Sicuopcion itemopc:sicuusuario.getListaSicuopcion()){
				if (itemopc.getIntopcnivel()>0 && itemopc.getVchopcaccion()!=null){
					int posinicio = uri.indexOf("/pages/");
					int posfin = uri.indexOf("?");
					String var_ur = "";
					logger.debug("URI COMPLETO::"+uri);
										
					if(posfin==-1){
						var_ur = uri.substring(posinicio);
					}else{
						var_ur = uri.substring(posinicio,posfin);
					}	
					
					String var_accion=itemopc.getVchopcaccion();
					int posinicioAccion = uri.indexOf("/pages/");
					int posfinAccion = uri.indexOf("?");
					if(posfinAccion==-1){
						var_accion = uri.substring(posinicioAccion);
					}else{
						var_accion = uri.substring(posinicioAccion,posfinAccion);
					}
						
					logger.debug("validaOpcionUsuario:"+var_ur+"-"+itemopc.getVchopcaccion());
					logger.debug("var_ur:"+var_ur+"-"+var_accion);
					//if (itemopc.getVchopcaccion().equalsIgnoreCase(var_ur)){
					if (var_accion.equalsIgnoreCase(var_ur)){	
	    				opcion_valida=true;	    				
	    				break;
					}
				}
			}
		}
		logger.debug("validaOpcionUsuario opcion_valida:"+opcion_valida);
		return opcion_valida;
	}	
	
}