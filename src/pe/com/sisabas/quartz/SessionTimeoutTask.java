package pe.com.sisabas.quartz;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
import pe.com.sicu.be.Sculogacceso;
import pe.com.sicu.business.GenparametroBusiness;
import pe.com.sicu.business.SculogaccesoBusiness;
*/

import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Utils;


/*
import pe.com.sicu.service.Sicusecurity;
*/


@Service
@Component
public class SessionTimeoutTask {
	
	
	
	public void printMe() {
		System.out.println("Spring 3 + Quartz 1.8.6 ~");
	}
	
	
	
	/*
	@Autowired
	SculogaccesoBusiness sculogaccesoBusiness;
	
	@Autowired
	GenparametroBusiness genparametroBusiness;
	
	@Autowired
	protected Sicusecurity sicusecurity;
	*/





	public void tareaEjemplo(){
		System.out.println("tareaEjemplo....Inicio");
		try {
			Date now=Utils.currentTimeStamp();
			System.out.println("tareaEjemplo...."+now);
									
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("tareaEjemplo....Final");
	}

	
	
	
	/*
	
	public void elimiarSessionesDeAcceso(){
		System.out.println("elimiarSessionesDeAcceso....");
		try {
			Sculogacceso sculogacceso = new Sculogacceso();
			sculogacceso.setChractusulogeado("1");		
			List<Sculogacceso> listaSculogacceso =  sculogaccesoBusiness.selectDynamicBasic(sculogacceso);
			
			Date now=Utils.currentTimeStamp();						
			Integer session_timeout=Integer.parseInt(Utils.obtenerGenparametro(genparametroBusiness, Constantes.genparametro.SESSION_TIMEOUT).getVchparamvalor().trim());			
			for (Sculogacceso record : listaSculogacceso) {				
				if(diferenciaMinutos(record.getTmsactfecacceso(), now)>session_timeout){					
					sicusecurity.logout(record, "TLOUESP");//Logout Por tiempo de espera
					System.out.println("elimiarSessionesDeAcceso....logout...");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("elimiarSessionesDeAcceso....finish");
	}
	
	public static long diferenciaMinutos(Date fechaInicial,
			Date fechaFinal) {
		 // Crear 2 instancias de Calendar
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        // Establecer las fechas
        cal1.setTime(fechaInicial);
        cal2.setTime(fechaFinal);

        // conseguir la representacion de la fecha en milisegundos
        long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();

        // calcular la diferencia en milisengundos
        long diff = milis2 - milis1;

        // calcular la diferencia en segundos
        long diffSeconds = diff / 1000;

        // calcular la diferencia en minutos
        long diffMinutes = diff / (60 * 1000);

        // calcular la diferencia en horas
        long diffHours = diff / (60 * 60 * 1000);

        // calcular la diferencia en dias
        long diffDays = diff / (24 * 60 * 60 * 1000);

        System.out.println("En milisegundos: " + diff + " milisegundos.");
        System.out.println("En segundos: " + diffSeconds + " segundos.");
        System.out.println("En minutos: " + diffMinutes + " minutos.");
        System.out.println("En horas: " + diffHours + " horas.");
        System.out.println("En dias: " + diffDays + " dias.");
        
        return diffMinutes;
	}
	
	*/
		
}
