package pe.com.sisabas.resources.components;

import javax.el.MethodExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import org.primefaces.event.NodeSelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@FacesComponent(value = "customComponentNodeSelectEvent")
@Scope(value = "session")
public class CustomComponentNodeSelectEvent extends UIComponentBase implements NamingContainer {

	@Override

	public String getFamily() {

	return "javax.faces.NamingContainer";

	}
	
	public void ajaxEventListener(NodeSelectEvent event) {		
		FacesContext context = FacesContext.getCurrentInstance();	
		MethodExpression ajaxEventListener = (MethodExpression) getAttributes().get("ajaxEventListener"); 
		ajaxEventListener.invoke(context.getELContext(), new Object[]{event});
	}
}
