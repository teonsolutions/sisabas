

/**
 * 
 */
package pe.com.sisabas.rest;


import org.apache.log4j.Logger;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SpringMobileController {
	private static final Logger logger = Logger.getLogger(SpringMobileController.class.getName());
	
	@RequestMapping(value="/")	
    public ModelAndView testUrl(SitePreference sitePreference, Device device, Model model) {
		logger.debug("SitePreference : " + sitePreference);
		logger.debug("Device : " + device);
		
        model.addAttribute("message", "Hello World!");
        model.addAttribute("device", device);
        
        String destino="login";
        if(sitePreference!=null){
        	if(sitePreference.toString().equalsIgnoreCase("MOBILE") || sitePreference.toString().equalsIgnoreCase("TABLET")){
        		destino="login_init_mobile";        		
        	}else if(sitePreference.toString().equalsIgnoreCase("NORMAL")){
        		destino="login";
        	}
        }
        
        if(device!=null){
        	if(device.isMobile() || device.isTablet()){
        		destino="login_init_mobile";            		
        	}else if(device.isNormal()){
        		destino="login";
        	}
        }
        
        ModelAndView models = new ModelAndView(destino);
    	models.addObject("msg", "hello world");
    	models.addObject("device", device);
        logger.debug("to "+destino);
        return models;
    }
	
	
}
