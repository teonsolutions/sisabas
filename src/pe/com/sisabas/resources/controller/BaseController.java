package pe.com.sisabas.resources.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import pe.com.sisabas.be.Genparametro;
import pe.com.sisabas.be.SysTabla;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.exception.SecurityRestrictedControlException;   	
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.UtilPrinter;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.service.SicuCallService;
import pe.com.sisabas.service.Sicucontrol;
import pe.com.sisabas.service.Sicuopcion;
import pe.com.sisabas.service.Sicurespuesta;
import pe.com.sisabas.service.Sicuusuario;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;



public class BaseController implements Serializable{

	public static final boolean SICU_SECURITY_ENABLE=false;
	public static final String SICU_SECURITY_APLICATION_ID="SISABAS";	
	public static final boolean SICU_SECURITY_VALIDATE_CONTROL_REMOTE=true;
	public static final String URL_SESSION_EXPIRED="/sessionExpired.xhtml";
	public static final String PROYECT_NAME="anuncios";

	public boolean status;
	public boolean statusRegister;
	public static boolean ST_ERROR=false;
	public static boolean ST_SUCCESS=true;
	public static boolean ST_INIT=false;
	
	public static String REGISTRAR="Registrar";
	public static String EDITAR="Editar";
	public static String DETALLE="Detalle";
	public static String ANULAR="Anular";
	public static String ACTIVAR="Activar";
	public static String IMPRIMIR="Imprimir";
	
	private List<Genparametro> listaImpresoras = UtilPrinter.getPrintAvailableNames();
	protected String impresoraSeleccionada = UtilPrinter.getPrintDefault();
	
	protected boolean esSeleccionado;	
	
	protected String     idOpcion   = "";      //2014-06-26 pjunchaya
	protected Sicuopcion sicuopcion;       //2014-06-26 pjunchaya
	
	/*
	@Autowired
	protected RepoBeanController repoBean;
	*/   
	
	public static void main(String[] a)throws Exception{
		
		Date fecha=Utils.stringToDate("05/05/2013");
		System.out.println("=>"+fecha);
		Calendar cal=new GregorianCalendar();
		cal.setTime(fecha);		
		cal.add(Calendar.DAY_OF_MONTH,1);
		System.out.println("Cal="+cal.getTime());
		BaseController o=new BaseController();
		o.setEsSeleccionado(false);
		
	}
	
	
	public static Logger logger=Logger.getLogger(BaseController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public void addMessage(String message,Severity severity){		
		addMessage(message, "", severity);
	}
	public void addMessageKey(String key,String message,Severity severity){		
		addMessageKey(key,message, "", severity);
	}
	
	public void addMessage(String message,String submessage,Severity severity){		
		logger.debug(message);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity,message, submessage));
	}
	
	public void addMessageKey(String key,String message,String submessage,Severity severity){		
		logger.debug(message);
		FacesContext.getCurrentInstance().addMessage(key, new FacesMessage(severity,message, submessage));
	}

	public void addErrorMessage(String mensaje){		
		logger.error(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error de sistema: "+mensaje,mensaje));
	}
	
	public void addErrorMessageKey(String key,String mensaje){		
		logger.error(mensaje);
		FacesContext.getCurrentInstance().addMessage(key, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error de sistema: "+mensaje,mensaje));
	}
	
	public void addErrorMessage(Exception e){
		e.printStackTrace();
		logger.error(Utils.getStackTrace(e));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error de sistema: "+e.getMessage(),e.getMessage()));
	}

	public void addErrorMessageKey(String key,Exception e){
		e.printStackTrace();
		logger.error(Utils.getStackTrace(e));
		FacesContext.getCurrentInstance().addMessage(key, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error de sistema: "+e.getMessage(),e.getMessage()));
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getParameter(String param) {
      FacesContext context = FacesContext.getCurrentInstance();
      Map<String, String> params = context.getExternalContext().
      getRequestParameterMap();
      return params.get(param);
    }
    
	public String getUserLogin(){
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    javax.servlet.http.HttpSession session = (javax.servlet.http.HttpSession) facesContext.getExternalContext().getSession(false);
	    pe.com.sisabas.controller.LoginController login = (pe.com.sisabas.controller.LoginController)session.getAttribute("loginBean");
		return login.getUser();
	}
	
	public HttpServletRequest getHttpServletRequest(){
		HttpServletRequest httpServletRequest= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();  
	    return httpServletRequest;	    
	}
    
    public HttpServletResponse getHttpServletResponse(){
    	HttpServletResponse httpServletResponse= (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
	    return httpServletResponse;	    
	}
    
    public HttpSession getHttpSession(){
    	HttpServletRequest httpServletRequest= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();  
	    return httpServletRequest.getSession();	    
	}
		
    public String getRemoteAddr(){
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
    
    
    
    
    public void reset(String object) {
		RequestContext.getCurrentInstance().reset(object);
	}
    
    public void postProcessXLS(Object document) {  
	    HSSFWorkbook wb = (HSSFWorkbook) document;  
	    HSSFSheet sheet = wb.getSheetAt(0);  
	    HSSFRow header = sheet.getRow(0);  
	      
	    HSSFCellStyle cellStyle = wb.createCellStyle();    
	    cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);  
	    cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	      
	    for(int i=0; i < header.getPhysicalNumberOfCells();i++) {  
	        HSSFCell cell = header.getCell(i);  
	          
	        cell.setCellStyle(cellStyle);  
	    }  
	}  
	  
	public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {  
	    Document pdf = (Document) document;  
	    pdf.open();  
	    pdf.setPageSize(PageSize.A4);  
	  
	    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
	    String logo = servletContext.getRealPath("") + File.separator + "resources"+File.separator +"img" + File.separator + "logo.gif";  
	    String logo2 = servletContext.getRealPath("") + File.separator + "resources"+File.separator +"img" + File.separator + "logo.jpg";	    
	    try {
	    	pdf.add(Image.getInstance(logo));	    	
		} catch (Exception e) {	
			System.err.println(e.getMessage());
			try {
		    	pdf.add(Image.getInstance(logo2));		    	
			} catch (Exception ex) {				
				addErrorMessage(ex);
			}
		}
	      
	    
	    Phrase phrase1 = new Phrase("  ");
	    Phrase phrase2 = new Phrase("  ");
	    Phrase phrase3 = new Phrase("Exportar informacion: ");
	     
	    pdf.add(phrase1);
	    pdf.add(phrase2);
	    pdf.add(phrase3);
	    
	}
	
	public void redirect(String para_url) throws IOException {
	    FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extContext = ctx.getExternalContext();
	    String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, para_url));
	    extContext.redirect(url);
    }
    
    public void redirectSessionExpiredPage(){
		try {
			String para_url=URL_SESSION_EXPIRED;
			redirect(para_url);
		} catch (Exception e) {
			logger.error(Utils.getStackTrace(e));
		}
		
    }
	
	 public void showGrowlMessageSuccessfullyCompletedAction(String headerMessage,String detailMessage,Severity severity){
    	addMessageKey("growl", headerMessage,detailMessage,severity);
	}
    
	public void showGrowlMessageSuccessfullyCompletedAction(){
		showGrowlMessageSuccessfullyCompletedAction(Messages.getString("growl.successfully.completed.action.header"),Messages.getString("growl.successfully.completed.action.detail"),
				FacesMessage.SEVERITY_INFO);
	}
	
	/**HIS: Valida si se ha registrado sustento para realizar cualquier registro ó modificación en el sistema. SESSION='LNGSUSCODIGO'*/
	protected void validarSustento()throws ValidateException{
		if(getHttpSession().getAttribute("LNGSUSCODIGO")==null)
			throw new ValidateException("Acción Cancelada! No cuenta con sustento para el registro ó modificación de datos.");
	}
	
	/**Valida y carga código de sustento desde sesión*/
	public void cargarCodigoDeSustento(SysTabla table)throws ValidateException{
		validarSustento();
		table.getParams().put("LNGSUSCODIGO", getHttpSession().getAttribute("LNGSUSCODIGO"));
	}
	
	private boolean acceso=false;
	    
	public boolean isAcceso() {
		System.out.println("isAcceso");
		return acceso;
	}
	public void setAcceso(boolean acceso) {
		this.acceso = acceso;
	}
	
	public boolean validateAcceso(String opcion,String control){
		System.out.println(">>>+"+opcion+"-"+control+"=>"+acceso);//Validacion
		if(control.equals("OK"))
		return false;
		else
		return true;
	}
	
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isStatusRegister() {
		return statusRegister;
	}
	public void setStatusRegister(boolean statusRegister) {
		this.statusRegister = statusRegister;
	}
	
	public void REGISTER_INIT(){
		this.setStatusRegister(ST_INIT);
	}
	
	public void REGISTER_ERROR(){
		this.setStatusRegister(ST_ERROR);
	}
	
	public void REGISTER_SUCCESS(){
		this.setStatusRegister(ST_SUCCESS);
	}	
	
	public void STATUS_INIT(){
		this.setStatus(ST_INIT);
	}
	
	public void STATUS_ERROR(){
		this.setStatus(ST_ERROR);
	}
	
	public void STATUS_SUCCESS(){
		this.setStatus(ST_SUCCESS);
	}
	public List<Genparametro> getListaImpresoras() {
		return listaImpresoras;
	}
	public void setListaImpresoras(List<Genparametro> listaImpresoras) {
		this.listaImpresoras = listaImpresoras;
	}
	public String getImpresoraSeleccionada() {
		return impresoraSeleccionada;
	}
	public void setImpresoraSeleccionada(String impresoraSeleccionada) {
		this.impresoraSeleccionada = impresoraSeleccionada;
	}
	

	
	/*seleccionado*/
	public void seleccionItem(SelectEvent e){		
		esSeleccionado=true;
	}

	public boolean isEsSeleccionado() {
		return esSeleccionado;
	}

	public void setEsSeleccionado(boolean esSeleccionado) {
		this.esSeleccionado = esSeleccionado;
	}

	
	

	
	//2014-06-26 pjunchaya
	//No mostrar los botones a los que no se tiene acceso (no se renderizan en la pagina
	public boolean renderButton(String paramButton){
		if(SICU_SECURITY_ENABLE){
			if (sicuopcion!=null && sicuopcion.getListaSicucontrol()!=null && sicuopcion.getListaSicucontrol().length>0){
				for (int i=0;i<sicuopcion.getListaSicucontrol().length;i++){
					Sicucontrol sicucontrol = (Sicucontrol)sicuopcion.getListaSicucontrol(i);
					if (sicucontrol.getVchconnombre().equalsIgnoreCase(paramButton)){
						return true;
					}
				}
			}
			return false;
		}else{
			return true;
		}
	}
	

	//2014-06-26 pjunchaya
	public boolean validarControl(String control)throws Exception{
		if(SICU_SECURITY_ENABLE){
			Sicurespuesta sicurespuesta = SicuCallService.validarControl(idOpcion, control);   
			
			if (sicurespuesta!=null && sicurespuesta.getVchstatus()!=null && sicurespuesta.getVchstatus().equalsIgnoreCase("OK"))
				return true;
						
			return false;
		}else{
			return true;
		}
	}	
	
	public String getSicuSessionId(){
		Sicuusuario  sicuusuario = (Sicuusuario)getHttpSession().getAttribute("sicuusuarioSESSION");
		return sicuusuario.getVchsessionid();
	}
	
	public void securityControlValidate(String control)throws Exception{
		/* Validacion de controles mediante WebService*/
		if(SICU_SECURITY_ENABLE)
		if(SICU_SECURITY_VALIDATE_CONTROL_REMOTE){
			if (!validarControl(control))
				throw new SecurityRestrictedControlException();				
			
		}else{/* Validacion mediante objeto sicuopcion (obtenercontroles en el init)*/		
			if (!renderButton(control))
				throw new SecurityRestrictedControlException();			
		}		
	}	
	
	public static boolean isSicuSecurityEnable() {
		return SICU_SECURITY_ENABLE;
	}	
	
}

