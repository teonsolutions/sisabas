package pe.com.sisabas.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class SessionTimeoutJob extends QuartzJobBean {

	private SessionTimeoutTask sessionTimeoutTask;
	 
	public void setSessionTimeoutTask(SessionTimeoutTask sessionTimeoutTask) {
		this.sessionTimeoutTask = sessionTimeoutTask;
	}
 
	protected void executeInternal(JobExecutionContext context)
		throws JobExecutionException {
		
		/*
		sessionTimeoutTask.elimiarSessionesDeAcceso();
		*/
		
		sessionTimeoutTask.tareaEjemplo();
		
 
	}

}
