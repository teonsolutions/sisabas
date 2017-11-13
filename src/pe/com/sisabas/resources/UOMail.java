package pe.com.sisabas.resources;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.PostConstruct;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.sisabas.be.Genparametro;
import pe.com.sisabas.business.GenparametroBusiness;


/**Clase que permite el envío de mails<br>  
 *1. agregarAtributos(..)  <br>
 *2. adjuntarArchivo(..)<br>
 *3. setAcuseDeRecibo(..)<br>
 *4. start() thread de envio
 * @author jcaldas
 *
 */



public class UOMail extends Thread {
	
	GenparametroBusiness genparametroBusiness = null;
	
	public static void main(String []a)throws Exception{
		/*
		UOMail obj=new UOMail();
		String from="servicios.munisurco.gob.pe@gmail.com";
		String to="jaredcaldas@hotmail.com";
		String subject="Prueba inicio";
		String mensaje="Correo de prueba";
		obj.agregarAtributos(from, to, subject, mensaje);		
		System.out.println("Inicio de envio mail: "+new Date());
		obj.start();
		*/
	}
	
	public void run(){
		try {							
			System.out.println("From : "+this.msg.getFrom()[0]);
			System.out.println("To :"+this.to);
			System.out.println("Asunto :"+this.subject);
			System.out.println("Mensaje :"+this.contenido);
			enviarMail();
			System.out.println("Send mail ok: "+new Date());
		} catch (Exception e) {
			System.out.println("Send mail error: "+new Date());
			e.printStackTrace();
		}		
	}
	
	private MimeMessage msg=null;
	private Multipart multipart = null;
	private String contenido="";
	private static String defaultFrom=null;
	private String from;
	private String subject;
	private String to;
		
	
	
	/**Inicaliza atributos y setea valores*/
	public void init(){
		Properties props = new Properties();
			   try {
				    Genparametro genparametro_CORREO_SMTP_LOCAL=Utils.obtenerGenparametro(genparametroBusiness,Constantes.genparametro.CORREO_SMTP_LOCAL);
				    Genparametro genparametro_CORREO_ORIGEN    =Utils.obtenerGenparametro(genparametroBusiness,Constantes.genparametro.CORREO_ORIGEN);
				    //IP O NOMBRE DE EQUIPO DESDE DONDE SE ENVIA EL CORREO
				    props.put("mail.smtp.host", genparametro_CORREO_SMTP_LOCAL.getVchparamvalor().trim());
				    //CORREO ORIGEN DESDE DONDE SE ENVIA EL MENSAJE
				    defaultFrom = genparametro_CORREO_ORIGEN.getVchparamvalor().trim();
			   } catch (Exception e) {
				   e.printStackTrace();
			   } 			   
		Session session = Session.getInstance(props, null);  //2014-05-06    
		msg = new MimeMessage(session);	 
	}
		
	
	public void initTLS(){
		
		Session session = null;
		
	    try {
			Genparametro genparametro_CORREO_SMTP_TLS=Utils.obtenerGenparametro(genparametroBusiness,Constantes.genparametro.CORREO_SMTP_TLS);
		    Genparametro genparametro_CORREO_ORIGEN  =Utils.obtenerGenparametro(genparametroBusiness,Constantes.genparametro.CORREO_ORIGEN);

			Genparametro genparametro_CORREO_PROXY_HOST=Utils.obtenerGenparametro(genparametroBusiness,Constantes.genparametro.CORREO_PROXY_HOST);
		    Genparametro genparametro_CORREO_PROXY_PORT=Utils.obtenerGenparametro(genparametroBusiness,Constantes.genparametro.CORREO_PROXY_PORT);

		    
		    final String username = genparametro_CORREO_ORIGEN.getVchparamvalor();
		    final String password = "munisurco1$";
 
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
	//		props.put("mail.smtp.socketFactory.port", "587");//activar el puerto
	//      props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	//      props.put("mail.smtp.socketFactory.fallback", "false");
		
			
			
			
			String proxyHost = genparametro_CORREO_PROXY_HOST.getVchparamvalor();
			int proxyPort    = Integer.parseInt(genparametro_CORREO_PROXY_PORT.getVchparamvalor());
			Properties systemSettings = System.getProperties();
			systemSettings.put("http.proxyPort",proxyPort);
			systemSettings.put("http.proxyHost",proxyHost);

        
        
			session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
    	
			defaultFrom = genparametro_CORREO_ORIGEN.getVchparamvalor();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		
		
		
	    
		msg = new MimeMessage(session);
		
		
	}
	
	
	/**Contructor*/
	public UOMail(GenparametroBusiness genparametroBusinessParam){
		this.genparametroBusiness = genparametroBusinessParam;
		
		Genparametro genparametro_CORREO_SMTP_ACTIVO = null;
		try {
			genparametro_CORREO_SMTP_ACTIVO = Utils.obtenerGenparametro(genparametroBusiness,Constantes.genparametro.CORREO_SMTP_ACTIVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (genparametro_CORREO_SMTP_ACTIVO.getVchparamvalor().equalsIgnoreCase("LOCAL"))
			init();
		else
			initTLS();		
		
		
	}	
	
	
	
			
	/**Agrega valores a los atributos del mail a enviar
	 * */	
	public void agregarAtributos(String from, String to,
			String subject,String mensaje) 
			throws AddressException, MessagingException {
		  msg.setFrom(new InternetAddress(from));
		  msg.setRecipients(Message.RecipientType.TO,to);
		  msg.setSubject(subject);
		  msg.setSentDate(new Date());
	      
		  this.to=to;
		  this.contenido=mensaje;
		  this.from=from;
		  this.subject=subject;
	}
	
	
	/**Agrega valores a los atributos del mail a enviar
	 * */	
	public void agregarAtributos(String to,
			String subject,String mensaje) 
			throws AddressException, MessagingException {		  
		  agregarAtributos(defaultFrom, to, subject, mensaje);
	}
	
	/**Con con copia a. Sí envía a más de uno, separar por punto y coma(;)*/
	public void addCC(String cc)throws MessagingException{
	   if (cc != null)
			  msg.setRecipients(Message.RecipientType.CC,
								InternetAddress.parse(cc, true));
	}
	
	/**Con con copia OCULTA a. Sí envía a más de uno, separar por punto y coma(;)*/
	public void addBCC(String bcc)throws MessagingException{
	  if (bcc != null) 
		  msg.setRecipients(Message.RecipientType.BCC,
							InternetAddress.parse(bcc, false));
	}
	
	/**Adjunta un archivo a enviar con el mail*/
	public void adjuntarArchivo(String filename) 
	throws MessagingException, IOException {
		if( multipart==null){
			multipart = new MimeMultipart("related");
			BodyPart texto = new MimeBodyPart();
			texto.setContent(contenido,"text/html");
			multipart.addBodyPart(texto);
		}	
		
		MimeBodyPart imagen = new MimeBodyPart();
	   // imagen.attachFile(filename);
		FileDataSource fds = new FileDataSource(filename);
		imagen.setDataHandler(new DataHandler(fds));
		imagen.setFileName(fds.getName()); 
		
		multipart.addBodyPart(imagen);    		 
	}
	
	/**Mensaje requiere confirmación de lectura */
	public void setAcuseDeRecibo(boolean acuseDeRecibo)throws MessagingException {	      
		msg.addHeader("Disposition-Notification-To",this.msg.getFrom().toString());		
	}	
	
	/**Enviar mail*/
	private void enviarMail()throws MessagingException{
		if(multipart!=null)
			msg.setContent(multipart);
		else
			msg.setContent(contenido,"text/html");
				
		Transport.send(msg);				
	}

		
}
