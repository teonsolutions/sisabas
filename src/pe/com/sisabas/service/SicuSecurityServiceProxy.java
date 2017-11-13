package pe.com.sisabas.service;

public class SicuSecurityServiceProxy implements pe.com.sisabas.service.SicuSecurityService_PortType {
  private String _endpoint = null;
  private pe.com.sisabas.service.SicuSecurityService_PortType sicuSecurityService_PortType = null;
  
  public SicuSecurityServiceProxy() {
    _initSicuSecurityServiceProxy();
  }
  
  public SicuSecurityServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSicuSecurityServiceProxy();
  }
  
  private void _initSicuSecurityServiceProxy() {
    try {
      sicuSecurityService_PortType = (new pe.com.sisabas.service.SicuSecurityService_ServiceLocator()).getSicuSecurityServicePort();
      if (sicuSecurityService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sicuSecurityService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sicuSecurityService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sicuSecurityService_PortType != null)
      ((javax.xml.rpc.Stub)sicuSecurityService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.com.sisabas.service.SicuSecurityService_PortType getSicuSecurityService_PortType() {
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType;
  }
  
  public pe.com.sisabas.service.Sicuusuario login(java.lang.String usuario, java.lang.String clave, java.lang.String sistema, java.lang.String ipuser) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.login(usuario, clave, sistema, ipuser);
  }
  
  public pe.com.sisabas.service.Sicurespuesta logout(java.lang.String sessionid) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.logout(sessionid);
  }
  
  public void setStatus(java.lang.String arg0) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    sicuSecurityService_PortType.setStatus(arg0);
  }
  
  public java.lang.String getStatus() throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.getStatus();
  }
  
  public java.lang.String loginTest(java.lang.String usuario, java.lang.String clave, java.lang.String sistema) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.loginTest(usuario, clave, sistema);
  }
  
  public pe.com.sisabas.service.Sicurespuesta usuariobaja(java.lang.String sessionid, java.lang.String usuariobaja, java.lang.String docbajatipo, java.lang.String docbajanumero) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.usuariobaja(sessionid, usuariobaja, docbajatipo, docbajanumero);
  }
  
  public java.lang.Integer obtenerIdOpcion(java.lang.String idOpcionText) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.obtenerIdOpcion(idOpcionText);
  }
  
  public pe.com.sisabas.service.Sicurespuesta solicitarCambioDeClave(java.lang.String usuario) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.solicitarCambioDeClave(usuario);
  }
  
  public pe.com.sisabas.service.Sicurespuesta realizarCambioDeClave(java.lang.String usuario, java.lang.String codigocambio, java.lang.String nuevaclave, java.lang.String ipuser) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.realizarCambioDeClave(usuario, codigocambio, nuevaclave, ipuser);
  }
  
  public void setResultMessage(java.lang.String arg0) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    sicuSecurityService_PortType.setResultMessage(arg0);
  }
  
  public pe.com.sisabas.service.Sicurespuesta validarControl(java.lang.String sessionid, java.lang.String opcion, java.lang.String control) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.validarControl(sessionid, opcion, control);
  }
  
  public pe.com.sisabas.service.Sicurespuesta registraractividad(java.lang.String sessionid, java.lang.String opcion, java.lang.String control, java.lang.String result, java.lang.String param, java.lang.String tipoexcepion, java.lang.String message, java.lang.String stacktrace) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.registraractividad(sessionid, opcion, control, result, param, tipoexcepion, message, stacktrace);
  }
  
  public pe.com.sisabas.service.Sicuopcion obtenercontroles(java.lang.String sessionid, java.lang.String opcion) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.obtenercontroles(sessionid, opcion);
  }
  
  public pe.com.sisabas.service.Sicurespuesta realizarCambioDeClaveApp(java.lang.String usuario, java.lang.String claveanterior, java.lang.String nuevaclave, java.lang.String ipuser) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.realizarCambioDeClaveApp(usuario, claveanterior, nuevaclave, ipuser);
  }
  
  public pe.com.sisabas.service.Sicurespuesta actualizarfecacceso(java.lang.String sessionid) throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.actualizarfecacceso(sessionid);
  }
  
  public java.lang.String getResultMessage() throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.getResultMessage();
  }
  
  public java.lang.String obtenerIpDesdeClienteWebservice() throws java.rmi.RemoteException{
    if (sicuSecurityService_PortType == null)
      _initSicuSecurityServiceProxy();
    return sicuSecurityService_PortType.obtenerIpDesdeClienteWebservice();
  }
  
  
}