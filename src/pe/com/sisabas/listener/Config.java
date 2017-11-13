
package pe.com.sisabas.listener;


import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;

import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;


@WebListener
public class Config implements ServletContextListener {


private static Logger logger=Logger.getLogger(Config.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.setProperty("org.apache.el.parser.COERCE_TO_ZERO", "false");
		logger.debug("org.apache.el.parser.COERCE_TO_ZERO");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

}
