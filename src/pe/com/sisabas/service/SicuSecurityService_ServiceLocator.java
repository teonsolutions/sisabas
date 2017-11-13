/**
 * SicuSecurityService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.sisabas.service;

import pe.com.sisabas.resources.Constantes;

public class SicuSecurityService_ServiceLocator extends org.apache.axis.client.Service implements pe.com.sisabas.service.SicuSecurityService_Service {

    public SicuSecurityService_ServiceLocator() {
    }


    public SicuSecurityService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SicuSecurityService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SicuSecurityServicePort
    private static String    seguridad_ip = Constantes.getString("seguridad.ip");	
    private java.lang.String SicuSecurityServicePort_address = "http://"+seguridad_ip+":8888/services/SicuSecurityService";    
    

    public java.lang.String getSicuSecurityServicePortAddress() {
        return SicuSecurityServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SicuSecurityServicePortWSDDServiceName = "SicuSecurityServicePort";

    public java.lang.String getSicuSecurityServicePortWSDDServiceName() {
        return SicuSecurityServicePortWSDDServiceName;
    }

    public void setSicuSecurityServicePortWSDDServiceName(java.lang.String name) {
        SicuSecurityServicePortWSDDServiceName = name;
    }

    public pe.com.sisabas.service.SicuSecurityService_PortType getSicuSecurityServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SicuSecurityServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSicuSecurityServicePort(endpoint);
    }

    public pe.com.sisabas.service.SicuSecurityService_PortType getSicuSecurityServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.com.sisabas.service.SicuSecurityServicePortBindingStub _stub = new pe.com.sisabas.service.SicuSecurityServicePortBindingStub(portAddress, this);
            _stub.setPortName(getSicuSecurityServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSicuSecurityServicePortEndpointAddress(java.lang.String address) {
        SicuSecurityServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.com.sisabas.service.SicuSecurityService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.com.sisabas.service.SicuSecurityServicePortBindingStub _stub = new pe.com.sisabas.service.SicuSecurityServicePortBindingStub(new java.net.URL(SicuSecurityServicePort_address), this);
                _stub.setPortName(getSicuSecurityServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SicuSecurityServicePort".equals(inputPortName)) {
            return getSicuSecurityServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.sicu.com.pe/", "SicuSecurityService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.sicu.com.pe/", "SicuSecurityServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SicuSecurityServicePort".equals(portName)) {
            setSicuSecurityServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
