package pe.com.sisabas.resources.components;

import javax.el.MethodExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@FacesComponent(value = "customComponent")
@Scope(value = "session")
public class CustomComponent extends UIComponentBase implements NamingContainer {

	@Override

	public String getFamily() {

	return "javax.faces.NamingContainer";

	}

	public void ajaxEventListener(SelectEvent event) {		
		FacesContext context = FacesContext.getCurrentInstance();	
		MethodExpression ajaxEventListener = (MethodExpression) getAttributes().get("ajaxEventListener"); 
		ajaxEventListener.invoke(context.getELContext(), new Object[]{event});
	}
}
