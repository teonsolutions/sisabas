/**
 * SicuSecurityService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.sisabas.service;

public interface SicuSecurityService_PortType extends java.rmi.Remote {
    public pe.com.sisabas.service.Sicuusuario login(java.lang.String usuario, java.lang.String clave, java.lang.String sistema, java.lang.String ipuser) throws java.rmi.RemoteException;
    public pe.com.sisabas.service.Sicurespuesta logout(java.lang.String sessionid) throws java.rmi.RemoteException;
    public void setStatus(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getStatus() throws java.rmi.RemoteException;
    public java.lang.String loginTest(java.lang.String usuario, java.lang.String clave, java.lang.String sistema) throws java.rmi.RemoteException;
    public pe.com.sisabas.service.Sicurespuesta usuariobaja(java.lang.String sessionid, java.lang.String usuariobaja, java.lang.String docbajatipo, java.lang.String docbajanumero) throws java.rmi.RemoteException;
    public java.lang.Integer obtenerIdOpcion(java.lang.String idOpcionText) throws java.rmi.RemoteException;
    public pe.com.sisabas.service.Sicurespuesta solicitarCambioDeClave(java.lang.String usuario) throws java.rmi.RemoteException;
    public pe.com.sisabas.service.Sicurespuesta realizarCambioDeClave(java.lang.String usuario, java.lang.String codigocambio, java.lang.String nuevaclave, java.lang.String ipuser) throws java.rmi.RemoteException;
    public void setResultMessage(java.lang.String arg0) throws java.rmi.RemoteException;
    public pe.com.sisabas.service.Sicurespuesta validarControl(java.lang.String sessionid, java.lang.String opcion, java.lang.String control) throws java.rmi.RemoteException;
    public pe.com.sisabas.service.Sicurespuesta registraractividad(java.lang.String sessionid, java.lang.String opcion, java.lang.String control, java.lang.String result, java.lang.String param, java.lang.String tipoexcepion, java.lang.String message, java.lang.String stacktrace) throws java.rmi.RemoteException;
    public pe.com.sisabas.service.Sicuopcion obtenercontroles(java.lang.String sessionid, java.lang.String opcion) throws java.rmi.RemoteException;
    public pe.com.sisabas.service.Sicurespuesta realizarCambioDeClaveApp(java.lang.String usuario, java.lang.String claveanterior, java.lang.String nuevaclave, java.lang.String ipuser) throws java.rmi.RemoteException;
    public pe.com.sisabas.service.Sicurespuesta actualizarfecacceso(java.lang.String sessionid) throws java.rmi.RemoteException;
    public java.lang.String getResultMessage() throws java.rmi.RemoteException;
    public java.lang.String obtenerIpDesdeClienteWebservice() throws java.rmi.RemoteException;
}
