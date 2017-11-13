
package pe.com.sisabas.resources;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.sisabas.be.Genparametro;
import pe.com.sisabas.business.GenparametroBusiness;





public class UtilsSecurity {

	
	
	public static void  main(String []a)throws Exception{
		/*
		paramDigitos1 = 6;
		paramDigitos2 = 8;
		paramDigitos3 = 10 ;
		paramEspeciales="&$#._-";
		
		System.out.println("1 :"+validaComplejidadClave("a2", 1));      //longitud
		System.out.println("2 :"+validaComplejidadClave("aaa", 1));     //letras
		System.out.println("3 :"+validaComplejidadClave("11", 1));      //especiales
		System.out.println("4 :"+validaComplejidadClave("}", 1));       //especiales
		System.out.println("5 :"+validaComplejidadClave("a12d21", 1));  //ok
		System.out.println("6 :"+validaComplejidadClave("a12d2}", 1));  //mal
		System.out.println("7 :"+validaComplejidadClave("a12d2&", 1));  //mal		
		System.out.println("");
		System.out.println("8 :"+validaComplejidadClave("a244", 2));     //longitud
		System.out.println("9 :"+validaComplejidadClave("aaaa", 2));     //letras
		System.out.println("10 :"+validaComplejidadClave("11", 2));      //especiales
		System.out.println("11 :"+validaComplejidadClave("}", 2));        //especiales
		System.out.println("12 :"+validaComplejidadClave("a12d21&1", 2));  //ok
		System.out.println("13 :"+validaComplejidadClave("0234&123", 2));  //mal no tiene letras
		System.out.println("14 :"+validaComplejidadClave("aaaaa&bZ", 2));  //mal no tiene numeros
		System.out.println("15 :"+validaComplejidadClave("0234AB23", 2));  //mal no tiene caracter especial		
		System.out.println("");
		System.out.println("16 :"+validaComplejidadClave("a244ZZ&&1", 3)); //longitud
		System.out.println("17 :"+validaComplejidadClave("aaaa", 3));      //letras
		System.out.println("18 :"+validaComplejidadClave("11", 3));        //numeros
		System.out.println("19 :"+validaComplejidadClave("&&&&", 3));      //especiales
		System.out.println("20 :"+validaComplejidadClave("aX1&d21#1v", 3));  //ok
		System.out.println("21 :"+validaComplejidadClave("&012121#19", 3));  //mal no tiene letras
		System.out.println("22 :"+validaComplejidadClave("&aAVeds#hJ", 3));  //mal no tiene numeros
		System.out.println("23 :"+validaComplejidadClave("1aAVeds6hJ", 3));  //mal no tiene caracter especial
		System.out.println("24 :"+validaComplejidadClave("1$AVeds6}J", 3));  //tiene caracter extraño
		*/		
	}	
	
	
	public static  boolean validaComplejidadClave(String clave, int nivelComplejidad, GenparametroBusiness  genparametroBusiness) {
		boolean retorno = true;
		try {
			
			int paramDigitos = 0;
			
			if (nivelComplejidad==1)
				paramDigitos = new Integer(Utils.obtenerGenparametro(genparametroBusiness, Constantes.genparametro.NIVEL_COMPLEJIDAD_CLAVE_DIGITOS_1).getVchparamvalor()).intValue();
			if (nivelComplejidad==2)
				paramDigitos = new Integer(Utils.obtenerGenparametro(genparametroBusiness, Constantes.genparametro.NIVEL_COMPLEJIDAD_CLAVE_DIGITOS_2).getVchparamvalor()).intValue();
			if (nivelComplejidad==2)
				paramDigitos = new Integer(Utils.obtenerGenparametro(genparametroBusiness, Constantes.genparametro.NIVEL_COMPLEJIDAD_CLAVE_DIGITOS_3).getVchparamvalor()).intValue();
			

   			String paramEspeciales = Utils.obtenerGenparametro(genparametroBusiness, Constantes.genparametro.NIVEL_COMPLEJIDAD_CLAVE_CARACTERES).getVchparamvalor();
   			
				                        
			//si la clave es null	
			if (clave==null) 
			retorno = false;

			//si la longitud de la clave es menor al minimo segun la complejidad
			if (clave!=null && clave.trim().length() < paramDigitos){
				retorno = false;			
			}
			
			
			boolean swincluyeNumeros    = false;
			boolean swincluyeLetras     = false;
			boolean swincluyeLetrasMin  = false;
			boolean swincluyeLetrasMay  = false;
			boolean swincluyeEspeciales = false;
			boolean swincluyeOtros      = false;

			
			for(int i=0;i<clave.trim().length();i++){
				String eval = clave.substring(i,i+1);
				
		        if (isLetraMin(eval))  swincluyeLetrasMin =true;
		        if (isLetraMay(eval))  swincluyeLetrasMay =true;
				
	 	        if (isNumero(eval))    swincluyeNumeros=true;else
		        if (isLetra(eval))     swincluyeLetras =true;else
		        if (isEspeciales(eval, paramEspeciales))  swincluyeEspeciales =true;else
		        swincluyeOtros = true;
			}

			
			
			if (nivelComplejidad==1){
				//Números y Letras
				if (!(swincluyeNumeros && swincluyeLetras && !swincluyeEspeciales && !swincluyeOtros))
					retorno = false;			
			}

			
			if (nivelComplejidad==2){
				//Números, Letras y Caracteres especiales definidos
				if (!(swincluyeNumeros && swincluyeLetras && swincluyeEspeciales && !swincluyeOtros))
					retorno = false;			
			}
			
			if (nivelComplejidad==3){
				//Números, Letras, Caracteres especiales definidos e incluir combinación de mayúsculas y minúsculas (10 dígitos)
				if (!(swincluyeNumeros && swincluyeLetras && swincluyeEspeciales && swincluyeLetrasMin && swincluyeLetrasMay && !swincluyeOtros))
					retorno = false;							
			}			
			
				                        
				                        
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	
	public static boolean isNumero(String evalString){
        Pattern patron = Pattern.compile("[^0-9]");
        Matcher encaja = patron.matcher(evalString);		
		return (!encaja.find()?true:false);
	}
	
	public static boolean isLetra(String evalString){
        Pattern patron = Pattern.compile("[^A-Za-z]");
        Matcher encaja = patron.matcher(evalString);		
		return (!encaja.find()?true:false);
	}
	
	public static boolean isLetraMin(String evalString){
        Pattern patron = Pattern.compile("[^a-z]");
        Matcher encaja = patron.matcher(evalString);		
		return (!encaja.find()?true:false);
	}
	
	public static boolean isLetraMay(String evalString){
        Pattern patron = Pattern.compile("[^A-Z]");
        Matcher encaja = patron.matcher(evalString);		
		return (!encaja.find()?true:false);
	}		
	
	public static boolean isEspeciales(String evalString, String caracteresEspeciales){
		return caracteresEspeciales.indexOf(evalString)>=0?true:false;
		
	}

	

	
    public static String getRemoteAddr(){
		HttpServletRequest request= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();  

		String ip = request.getHeader("X-Real-IP");
		if (null != ip && !"".equals(ip.trim())	&& !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (null != ip && !"".equals(ip.trim())	&& !"unknown".equalsIgnoreCase(ip)) {
			// get first ip from proxy ip
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		return request.getRemoteAddr();		
	    
	}	





    
    
    
    
    
    
    
    
    
    
	
}
