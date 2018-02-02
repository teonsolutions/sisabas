package pe.com.sisabas.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {	
	
	ResourceBundle rbP=ResourceBundle.getBundle("pe.com.sitac.util.config");
	
	public Email(){
		
	}
	
	public int sendEmail(String[] para, String[] cc,String asunto, String mensaje, String url, boolean autenticar, String tipoSol, String detalle){
		
		try {
			//String url = (String)propiedades.getObject("url.main");
			
			Properties mailProps = new Properties();
			mailProps.put("mail.smtp.auth", "true");
			mailProps.put("mail.smtp.host", rbP.getString("correo.servidor"));
			mailProps.put("mail.smtp.port", rbP.getString("correo.puerto"));
			mailProps.put("mail.smtp.user", rbP.getString("correo.user"));
			mailProps.put("mail.smtp.password", rbP.getString("correo.clave"));
			
			
			// Get session
			Session mailSession;

			if(autenticar){
				mailSession = Session.getDefaultInstance(mailProps, new Authenticator() {
		          
					@Override
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(rbP.getString("correo.user"), rbP.getString("correo.clave"));
		            }
		        });

			} else {
				mailSession = Session.getDefaultInstance(mailProps);
			}
						
			// Define message
			MimeMessage message = new MimeMessage(mailSession);
			
			//De :
			InternetAddress from = new InternetAddress((String)rbP.getString("correo.from"));
			message.setFrom(from);
			
		
			
			//Para :
			//InternetAddress to = new InternetAddress(para);
			//message.addRecipient(Message.RecipientType.TO,to);			
			
			String[] emails = para;
			String[] emailsCc = cc;
	        InternetAddress dests[] = new InternetAddress[emails.length];
	        InternetAddress destsCc[] = new InternetAddress[emailsCc.length];
	   
	        
	        
	        for (int i = 0; i < emails.length; i++) {
	            dests[i] = new InternetAddress(emails[i].trim().toLowerCase());
	        }
	        
	        
	        for (int i = 0; i < emailsCc.length; i++) {
	        	destsCc[i] = new InternetAddress(emailsCc[i].trim().toLowerCase());
	        }
	        
	        
	        message.setRecipients(Message.RecipientType.TO, dests);	 
	        message.setRecipients(Message.RecipientType.CC, destsCc);	 
		      
	        
	        
	        message.setSubject(asunto, "UTF-8");			
			
			//Fecha actual		
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
			Date currentDate = new Date();
			String hoy = fecha.format(currentDate);
			
			String parrafo1=rbP.getString("correo.parrafo.uno");
			parrafo1=parrafo1.replace("$nombreCompleto", "" /*sol.getNombrecompleto()*/);
		
			String parrafo2=rbP.getString("correo.parrafo.dos");
			parrafo2=parrafo2.replace("$tipoSolicitud", tipoSol);
			parrafo2=parrafo2.replace("$hoy", hoy);	
			
			String parrafo4=rbP.getString("correo.parrafo.cuatro");
			parrafo4=parrafo4.replace("$tipoSolicitud", tipoSol);
			
			String parrafoDet="";
		
		/*
			if(sol.getTiposolictudcatalogo().equals(Constantes.tabla.TPSL001)){
				 parrafoDet=rbP.getString("correo.parrafo.inf");
			}else{
				if(sol.getTiposolictudcatalogo().equals(Constantes.tabla.TPSL002)){
					 parrafoDet=rbP.getString("correo.parrafo.que");
				}else{
					if(sol.getTiposolictudcatalogo().equals(Constantes.tabla.TPSL003)){
						 parrafoDet=rbP.getString("correo.parrafo.rec");
					}else{
						if(sol.getTiposolictudcatalogo().equals(Constantes.tabla.TPSL004)){
							 parrafoDet=rbP.getString("correo.parrafo.den");
						}else{
							if(sol.getTiposolictudcatalogo().equals(Constantes.tabla.TPSL005)){
								 parrafoDet=rbP.getString("correo.parrafo.con");
							}else{
								if(sol.getTiposolictudcatalogo().equals(Constantes.tabla.TPSL006)){
									parrafoDet=rbP.getString("correo.parrafo.reu");
								}
							}
						}
					}
				}
			}
		*/
			
					
			
			String parrafo5=rbP.getString("correo.parrafo.cinco");
			String parrafo6=rbP.getString("correo.parrafo.seis");
			String parrafo7=rbP.getString("correo.parrafo.siete");
			
				
			String htmlText ="<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+parrafo1+"</font>"+
					"<br><br>"+

					"<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+parrafo2+"</font>"+
					"<br><br>"+
					
					"<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+parrafo4+"</font>"+
					"<br><br>"+
					
					"<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+parrafoDet+"</font>"+
					"<br><br>"+
					
									
					"<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+detalle+"</font>"+
					"<br><br>"+

					"<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+parrafo5+"</font>"+
					"<br><br>"+

					"<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+parrafo6+"</font>"+
					"<br><br>"+

					"<font color='#000000' size='1' face='Verdana, Arial, Helvetica, sans-serif'>"+parrafo7+"</font>"+
					"<br>";
			
			
			
			if(url != null && !url.toString().equals("")){
				htmlText = htmlText.concat("Puede acceder haciendo click ... <a href='"+url+"'> aqui </a></font>");
			}
			
			//htmlText = htmlText.concat("<br><br><p><img src=\"http://www.sunarp.gob.pe/Images/logo_Sunarp_news.png\" width=\"182\" height=\"101\" />");
			
			Multipart mp = new MimeMultipart();
	        MimeBodyPart mbp = new MimeBodyPart();
	        mbp.setContent(htmlText, "text/html;charset=utf-8");
	        mp.addBodyPart(mbp);
	        message.setContent(mp);
	        message.setSentDate(currentDate);
	        
			// Send message
			Transport.send(message);
			return 1;

		} catch (SendFailedException s){
			s.printStackTrace();			
			return 9;
		} catch (AddressException a){
			//a.printStackTrace();
			return 8;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int sendEmail(String[] para, String[] cc, String asunto, String mensaje, boolean autenticar, String tipoSol, String detalle){
		return sendEmail(para, cc, asunto, mensaje, "", autenticar, tipoSol, detalle);
	}
		
	public int sendEmail(String[] para, String[] cc, String asunto, String mensaje, String url){
		return sendEmail(para, cc, asunto, mensaje, url, false, null, null);
	}

}
