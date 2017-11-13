
package pe.com.sisabas.resources;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.com.sisabas.util.SisabasConfig;
import pe.com.sisabas.be.Genparametro;
import pe.com.sisabas.business.GenparametroBusiness;
import pe.com.sisabas.exception.ValidateException;




public class Utils {
	public static void main(String []a)throws Exception{
		BigDecimal bruto=new BigDecimal("0.781330");
		System.out.println("ok:"+Utils.round(bruto));
		MathContext mc=new MathContext(3,RoundingMode.HALF_UP);
		System.out.println("ok2="+(bruto.round(mc)));
		System.out.println("ok2="+(bruto.round(mc).setScale(2,RoundingMode.HALF_UP)));
		
		System.out.println(fechaLetras(diaActual()));
		
	}
	private static final String DEFAULT_DATE_PATTERN = "dd/MM/yyyy";
	private static final String DEFAULT_DATE_PATTERN_LARGE = "dd/MM/yyyy HH:mm:ss";
	
	private static final String DEFAULT_TIME_PATTERN = "hh:mm a";
	
	
	public static String FECHA_MYSQL = "yyyy-MM-dd";
	
	public static String FECHA = "dd/MM/yyyy";
	public static String FECHA_HORA_MM = "dd/MM/yyyy HH:mm";
	public static String FECHA_HORA_MM_SS = "dd/MM/yyyy HH:mm:ss";
	
	public static String DIA_SEMANA[] = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
	public static String MES_ANIO[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};	
	
	
	/**
	 * Retorna una cadena con la fecha dada
	 * 
	 * @param date
	 *            fecha que enviamos a procesar
	 * @param pattern
	 *            patron de fechas que deseamos usar
	 * @return cadena de texto con el formato asignado
	 */
	public static String dateTimeToString(java.util.Date date, String pattern) {
		return dateToString(date, pattern);
	}

	/**
	 * dd/MM/yyyy HH:mm:ss
	 */
	public static String dateTimeToString(java.util.Date date) {
		return dateToString(date, DEFAULT_DATE_PATTERN_LARGE);
	}

	/**
	 * Recibe una cadena con fecha y la retorna en tipo Date
	 * 
	 * @param dateStr
	 * @return dd/MM/yyyy hh:mm:ss
	 */
	public static java.util.Date stringToDateTime(String dateStr) {
		return stringToDate(dateStr, DEFAULT_DATE_PATTERN_LARGE);
	}

	/**
	 * Recibe una cadena con fecha y la retorna en tipo Date
	 * 
	 * @param dateStr
	 * @param pattern
	 *            patron que desamos usar para el formato
	 * @return
	 */
	public static java.util.Date stringToDateTime(String dateStr, String pattern) {
		return stringToDate(dateStr, pattern);
	}
	
	
	/**
	 * Recibe una cadena con fecha y la retorna en tipo Date
	 * 
	 * @param dateStr
	 * @return dd/MM/yyyy hh:mm:ss
	 */
	public static java.util.Date stringToTime(String timeStr) {
		return stringToTime(timeStr, DEFAULT_TIME_PATTERN);
	}	
	

	public static String dateToString(java.util.Date date) {
		return dateToString(date, DEFAULT_DATE_PATTERN);
	}
	
	public static String timeToString(java.util.Date date) {
		return dateToString(date, DEFAULT_TIME_PATTERN);
	}	
	

	public static String dateToString(java.util.Date date, String pattern) {
		String result = null;
		if (date == null) {

		}
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		result = formatter.format(date);
		return result;
	}

	public static java.util.Date stringToDate(String dateStr) {
		return stringToDate(dateStr, DEFAULT_DATE_PATTERN);
	}

	public static java.util.Date stringToDate(String dateStr, String pattern) {
		java.util.Date date = null;
		if (dateStr == null || dateStr.trim().equals("")) {

		}
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException pe) {

		}
		return date;
	}
	
	
	public static java.util.Date stringToTime(String timeStr, String pattern) {
		java.util.Date date = null;
		if (timeStr == null || timeStr.trim().equals("")) {

		}
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		try {
			date = formatter.parse(timeStr);
		} catch (ParseException pe) {

		}
		return date;
	}	
	
	public static String getStackTrace(Exception ex) {
		StringWriter sr = new StringWriter(0);
		PrintWriter pw = new PrintWriter(sr, true);
		ex.printStackTrace(pw);
		return sr.toString();
		
	}
	
	public static BigDecimal round(BigDecimal numero){
		String s=numero.toPlainString();		
		if(s.indexOf(".")!=-1)
			s=s.substring(0,s.indexOf("."));		
		
		int nroDijitos=s.length()+Constantes.NRO_DECIMALES;
		MathContext mc=new MathContext(nroDijitos,RoundingMode.HALF_UP);		
		return numero.round(mc).setScale(Constantes.NRO_DECIMALES,RoundingMode.HALF_UP);
	}
	
	public static BigDecimal divide(BigDecimal n1,BigDecimal n2) throws Exception{		
		return Utils.round(n1.divide(n2, Constantes.NRO_DECIMALES, RoundingMode.HALF_UP));
	}
	
	public static String completarCadena(Integer numero,int dijitos,String caracter){		
		String s_numero=String.valueOf(numero);
		int lenght_numero=s_numero.length();
		int dijitos_faltantes=dijitos-lenght_numero;
		String ceros="";
		if(dijitos_faltantes>0)			
		for (int i = 0; i < dijitos_faltantes; i++) {
			ceros=ceros.concat(caracter);
		}		
		return ceros.concat(s_numero);
	}	
	
	public static Date currentTimeStamp(){
		return new Date();
	}
	public static Date currentDate(){
		Date now=new Date();
		String s=Utils.dateToString(now);
		now=Utils.stringToDate(s);		
		return now;
	}
	
	public static Date currentTime(){
		Date now=new Date();
		String s=Utils.timeToString(now);
		now=Utils.stringToTime(s);		
		return now;
	}	
	
	 /*Convierte las propiedades String de un objeto en Uppercase*/
    public static void convertPropertiesStringToUppercase(Object param){
		try{	    	
		if (param!=null){
			Method[] metodos=param.getClass().getMethods();
			for(int i=0;i<metodos.length;i++){
				Method metodo=metodos[i];
				
				String prefixOri=metodo.getName().substring(0,3);
				String sufixOri=metodo.getName().substring(3,metodo.getName().length());
				
				Class [] params=metodo.getParameterTypes();
				
				if ( (prefixOri.equals("set")) && 
					  params.length==1 && params[0].getName().equals("java.lang.String") 
					){
					//System.err.println("metodo:"+metodo);
					
					
					if (esCampoMayuscMinusc(metodo.getName())){
						/*Si el campo esta configurado para grabarse en mayusculas y minusculas no lo convierte a mayusculas*/
					}else{
						Method metodoObtener=getMethodbyName(metodos,"get"+sufixOri);
						Object [] argsdes =new Object[1];
						try{
						argsdes[0]=metodoObtener.invoke(param,null);
						//System.err.println("metodo:"+metodo+" Arg"+argsdes[0]);
						metodo.invoke(param, (argsdes[0]!=null?argsdes[0].toString().toUpperCase():argsdes[0]));
						}catch(Exception e){
							System.err.println("UtilVO: No pudo pasar a mayusculas:"+param.getClass().getName()+" "+metodo);
						}
					}
					
				}
			}
		}
		}catch(Exception e){
			System.err.println("UtilVO: No pudo pasar a mayusculas:"+param.getClass().getName());
		}

    }
    
    /*Busca un metodo por su nombre*/
	public static Method getMethodbyName(Method[] metodos,String name)
	{
		Method metodox=null;
		for(int i=0;i<metodos.length;i++)
		{
			Method metodo=metodos[i];
			if(metodo.getName().equals(name))
			{
				metodox=metodo;
				break;
			}	
		}	
		return metodox;
	}

	/*Convierte la fecha en Letras*/	
	public static String fechaLetras(java.util.Date fecha){
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		String fechaString=df.format(fecha);
		String dia  = fechaString.substring(0,2);
		String mes  = fechaString.substring(3,5);
		String anio = fechaString.substring(6,10);
		
		int numeroDia=0;
	    Calendar cal= Calendar.getInstance();
	    cal.setTime(fecha);
	    numeroDia=cal.get(Calendar.DAY_OF_WEEK);		
		
		return DIA_SEMANA[numeroDia-1] + ", " + dia + " de " + MES_ANIO[new Integer(mes).intValue()-1] +" de "+anio;
	}		
	

    public static java.sql.Date diaActual(){
  	  try{
  		return Utils.getSqlDate(new java.util.Date());
  	  }
  	  catch(Exception e){
  		  return null;
  	  }
  	}	

	public static java.sql.Date getSqlDate(java.util.Date dutil)
	{
			java.sql.Date dsql= new java.sql.Date(dutil.getTime());			
			return dsql;
	}	

	public static int bigDecimalToInt(BigDecimal numero){
		String val=numero.toString();
		int n=0;
		if(val.indexOf(".")!=-1){
			n=Integer.parseInt(val.substring(0,val.indexOf(".")));
		}else{
			n=Integer.parseInt(val);
		}		
		return n;
	}

	public static HttpServletRequest getRequest(){
		HttpServletRequest  httpServletRequest  = (HttpServletRequest)  FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return httpServletRequest;
	}

	public static HttpServletResponse getResponse(){
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		return httpServletResponse;
	}	
	
	public static String getRutaArchivo(String nombreArchivo){
		HttpServletRequest  httpServletRequest  = (HttpServletRequest)  FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String path    = httpServletRequest.getServletContext().getRealPath("/temporaltxt/");
		String archivo = path+"\\"+nombreArchivo;
		
		archivo = "c:\\temp"+"\\"+nombreArchivo; //pedro 2013-05-21
		return archivo;
	}
	
	public static String getRutaArchivoEnApp(String nombreArchivo){
		HttpServletRequest  httpServletRequest  = (HttpServletRequest)  FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String path    = httpServletRequest.getServletContext().getRealPath("/temporaltxt/");
		String archivo = path+"\\"+nombreArchivo;
		return archivo;
	}	
	

	/*Eliminar objetos en sesion*/
	public static void eliminaObjetosSesion() {  
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
    	Enumeration e = session.getAttributeNames();
    	while (e.hasMoreElements())
    	{
    	  String attr = (String)e.nextElement();
    	  //System.err.println("attr= "+ attr);
    	  if (attr!=null && attr.length()>0){
    		  if (!(attr.equalsIgnoreCase("Sisabascontrol") ||
    				  attr.equalsIgnoreCase("javax.faces.request.charset") || attr.equalsIgnoreCase("loginBean") || attr.equalsIgnoreCase("menuBean")
    				  || attr.equalsIgnoreCase("sicuusuarioSESSION")  
    				  
    		  )){     //control de la aplicacion 
    		  	    //attr.equalsIgnoreCase("repoBean") ||          //control de reportes 
    			    //attr.equalsIgnoreCase("usuarioController"))){ //control de usuario
    			  
    			  
    			  if (attr.contains("loginBean")){
    				  continue;
    			  }
    			  //if (attr.contains("Bean")){
    				  //System.err.println("Elimino de sesion:"+attr);
    				  session.removeAttribute(attr);
    			  //}
    			  
    		  }
    	  }
    	}
    }    	    

	
	public static String getLetter(int numero){
		String cad="";
		switch (numero) {
		case 0: cad=" "; break;		
		case 1: cad="A"; break;
		case 2: cad="B"; break;
		case 3: cad="C"; break;
		case 4: cad="D"; break;
		case 5: cad="E"; break;
		case 6: cad="F"; break;
		case 7: cad="G"; break;
		case 8: cad="H"; break;
		case 9: cad="I"; break;
		case 10: cad="J"; break;
		case 11: cad="K"; break;
		case 12: cad="L"; break;
		case 13: cad="M"; break;
		case 14: cad="N"; break;
		case 15: cad="O"; break;
		case 16: cad="P"; break;
		case 17: cad="Q"; break;
		case 18: cad="R"; break;
		case 19: cad="S"; break;
		case 20: cad="T"; break;
		case 21: cad="U"; break;
		case 22: cad="V"; break;
		case 23: cad="W"; break;
		case 24: cad="X"; break;
		case 25: cad="Y"; break;
		case 26: cad="Z"; break;
		default: cad=""+numero; break;
		}
				
		return cad;
	}
	
	
	public static String getMD5(String cadena)throws Exception
    {
		String md5="";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(cadena.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        //System.out.println("Digest(in hex format):: " + sb.toString());
 
        //convert the byte to hex format method 2
        /*StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}*/
    	md5=sb.toString();
    	System.out.println("Digest(in hex format):: " + md5);
    	return md5;
    }

	
	public static String left(String text, int length)
	{
		  return text.substring(0, length);
	}

	public static String right(String text, int length)
	{
		  return text.substring(text.length()- length, text.length());
	}	
	
	
	public static String getRutaAplicacion(){
		HttpServletRequest myRequest = getRequest();
		String rutaApp = "http://"+myRequest.getServerName()+":"+myRequest.getServerPort()+"/Sisabas/";
		System.out.println("Ruta Aplicacion: " + rutaApp);
		return rutaApp;
	}
			


	/*Devuelve true si el campo esta configurado para grabarse en mayusculas y minusculas*/
	public static boolean esCampoMayuscMinusc(String cadena){
		boolean resultado = false;
		String[] listFields=SisabasConfig.retornaFieldUpperLower();
		if (listFields!=null && listFields.length>=1){
			for( int i = 0; i <= listFields.length - 1; i++)
			{
				String compara = listFields[i];
				if (cadena.toLowerCase().indexOf(compara.toLowerCase())>=0){
					resultado =true;
					break;
				}
			}		
		}
		return resultado;
	}
	
	/**Borra a partir de la última coma encontrada inclusive*/
	public static String borrarComitaFinal(String cadena){
		if(cadena.length()>2){
			return cadena.substring(0,cadena.lastIndexOf(","));
		}
			return "";
	}
	
	public static Genparametro obtenerGenparametro(GenparametroBusiness genparametroBusiness, String key)throws Exception{		
		Genparametro genparametro=genparametroBusiness.selectByPrimaryKeyBasic(key);
		if(genparametro==null){
			throw new ValidateException(Utils.genparametroValidationMessage(key));
		}	
		return genparametro;
	}
	
	public static String genparametroValidationMessage(String vchparamcodigo){
		return "No se encuentra configurada la variable:GENPARAMETRO."+vchparamcodigo;
	}
	
	
		


	public static String getRutaServer(){
		HttpServletRequest myRequest = getRequest();
		String rutaApp = "http://"+myRequest.getServerName()+":"+myRequest.getServerPort()+"/";
		System.out.println("Ruta Server: " + rutaApp);
		return rutaApp;
	}		


	public static String obtenerPrograma(Class claseejb) throws Exception
	{
		String paquete=claseejb.getPackage().getName();
		String clase=claseejb.getName();
		clase=clase.substring(paquete.length()+1,clase.length());
		//truncar si es mayor a 60
		if (clase != null  && clase.length() > 60) {
			clase = clase.substring(0, 20);
		} 
		return clase;
	}	
	
	/**Pasa los valores de un objeto a otro por considencia de nombres de los atributos*/
    public static void pharse(Object from, Object to){
		try{	    	
			if (from!=null){
				Method[] metodos=from.getClass().getMethods();
				Method[] metodosTo=to.getClass().getMethods();
				for(int i=0;i<metodos.length;i++){
					Method metodo=metodos[i];
					Method metodoTo=metodosTo[i];
					
					String prefixOri=metodo.getName().substring(0,3);
					String sufixOri=metodo.getName().substring(3,metodo.getName().length());
					
					Class [] params=metodo.getParameterTypes();
					
					if ( (prefixOri.equals("set")) && params.length==1){
						//System.err.println("metodo:"+metodo);						
						Method metodoObtener=getMethodbyName(metodos,"get"+sufixOri);					
						Object [] argsdes =new Object[1];
						try{
							argsdes[0]=metodoObtener.invoke(from,null);					
							//System.err.println("metodo:"+metodo+" Arg"+argsdes[0]);
							//metodo.invoke(to, (argsdes[0]));
							metodoTo=getMethodbyName(metodosTo,metodo.getName());							
							if(metodoTo!=null)
								metodoTo.invoke(to, (argsdes[0]));
						}catch(Exception e){
							System.err.println("UtilVO: No pudo pasar a mayusculas:"+from.getClass().getName()+" "+metodo);
							e.printStackTrace();
						}					
					}
				}
			}
		}catch(Exception e){
			System.err.println("UtilVO: No pudo pasar a mayusculas:"+from.getClass().getName());
			e.printStackTrace();
		}
    }
    
    
    public static HttpSession getHttpSession(){
    	HttpServletRequest httpServletRequest= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();  
	    return httpServletRequest.getSession();	    
	}    
    
	//*Obtiene la etiqueta a utilizar desde una cadena.[NombreCampo]*/
    public static String getSecurityErrorCode(String vchmensaje) {
    	if(vchmensaje!=null && !vchmensaje.equalsIgnoreCase("")){
	    	if(vchmensaje.indexOf("[")==0 && vchmensaje.indexOf("]")!=-1){
	    		vchmensaje=vchmensaje.substring(1,vchmensaje.indexOf("]"));
	    	}else
	    		vchmensaje="FORMATO_INCORRECTO"; 
    	}else
    		vchmensaje=null;
    	return vchmensaje;
    }	
}
