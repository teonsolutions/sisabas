/**
 * Sicucontrol.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.sisabas.service;

public class Sicucontrol  implements java.io.Serializable {
    private java.lang.Integer intconcodigo;

    private java.lang.Integer intopccodigo;

    private java.lang.String vchcondescripcion;

    private java.lang.String vchconnombre;

    private java.lang.String vchcontipoDescrip;

    public Sicucontrol() {
    }

    public Sicucontrol(
           java.lang.Integer intconcodigo,
           java.lang.Integer intopccodigo,
           java.lang.String vchcondescripcion,
           java.lang.String vchconnombre,
           java.lang.String vchcontipoDescrip) {
           this.intconcodigo = intconcodigo;
           this.intopccodigo = intopccodigo;
           this.vchcondescripcion = vchcondescripcion;
           this.vchconnombre = vchconnombre;
           this.vchcontipoDescrip = vchcontipoDescrip;
    }


    /**
     * Gets the intconcodigo value for this Sicucontrol.
     * 
     * @return intconcodigo
     */
    public java.lang.Integer getIntconcodigo() {
        return intconcodigo;
    }


    /**
     * Sets the intconcodigo value for this Sicucontrol.
     * 
     * @param intconcodigo
     */
    public void setIntconcodigo(java.lang.Integer intconcodigo) {
        this.intconcodigo = intconcodigo;
    }


    /**
     * Gets the intopccodigo value for this Sicucontrol.
     * 
     * @return intopccodigo
     */
    public java.lang.Integer getIntopccodigo() {
        return intopccodigo;
    }


    /**
     * Sets the intopccodigo value for this Sicucontrol.
     * 
     * @param intopccodigo
     */
    public void setIntopccodigo(java.lang.Integer intopccodigo) {
        this.intopccodigo = intopccodigo;
    }


    /**
     * Gets the vchcondescripcion value for this Sicucontrol.
     * 
     * @return vchcondescripcion
     */
    public java.lang.String getVchcondescripcion() {
        return vchcondescripcion;
    }


    /**
     * Sets the vchcondescripcion value for this Sicucontrol.
     * 
     * @param vchcondescripcion
     */
    public void setVchcondescripcion(java.lang.String vchcondescripcion) {
        this.vchcondescripcion = vchcondescripcion;
    }


    /**
     * Gets the vchconnombre value for this Sicucontrol.
     * 
     * @return vchconnombre
     */
    public java.lang.String getVchconnombre() {
        return vchconnombre;
    }


    /**
     * Sets the vchconnombre value for this Sicucontrol.
     * 
     * @param vchconnombre
     */
    public void setVchconnombre(java.lang.String vchconnombre) {
        this.vchconnombre = vchconnombre;
    }


    /**
     * Gets the vchcontipoDescrip value for this Sicucontrol.
     * 
     * @return vchcontipoDescrip
     */
    public java.lang.String getVchcontipoDescrip() {
        return vchcontipoDescrip;
    }


    /**
     * Sets the vchcontipoDescrip value for this Sicucontrol.
     * 
     * @param vchcontipoDescrip
     */
    public void setVchcontipoDescrip(java.lang.String vchcontipoDescrip) {
        this.vchcontipoDescrip = vchcontipoDescrip;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sicucontrol)) return false;
        Sicucontrol other = (Sicucontrol) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.intconcodigo==null && other.getIntconcodigo()==null) || 
             (this.intconcodigo!=null &&
              this.intconcodigo.equals(other.getIntconcodigo()))) &&
            ((this.intopccodigo==null && other.getIntopccodigo()==null) || 
             (this.intopccodigo!=null &&
              this.intopccodigo.equals(other.getIntopccodigo()))) &&
            ((this.vchcondescripcion==null && other.getVchcondescripcion()==null) || 
             (this.vchcondescripcion!=null &&
              this.vchcondescripcion.equals(other.getVchcondescripcion()))) &&
            ((this.vchconnombre==null && other.getVchconnombre()==null) || 
             (this.vchconnombre!=null &&
              this.vchconnombre.equals(other.getVchconnombre()))) &&
            ((this.vchcontipoDescrip==null && other.getVchcontipoDescrip()==null) || 
             (this.vchcontipoDescrip!=null &&
              this.vchcontipoDescrip.equals(other.getVchcontipoDescrip())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIntconcodigo() != null) {
            _hashCode += getIntconcodigo().hashCode();
        }
        if (getIntopccodigo() != null) {
            _hashCode += getIntopccodigo().hashCode();
        }
        if (getVchcondescripcion() != null) {
            _hashCode += getVchcondescripcion().hashCode();
        }
        if (getVchconnombre() != null) {
            _hashCode += getVchconnombre().hashCode();
        }
        if (getVchcontipoDescrip() != null) {
            _hashCode += getVchcontipoDescrip().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sicucontrol.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.sisabas.com.pe/", "sicucontrol"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intconcodigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intconcodigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intopccodigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intopccodigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchcondescripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchcondescripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchconnombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchconnombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchcontipoDescrip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchcontipoDescrip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
