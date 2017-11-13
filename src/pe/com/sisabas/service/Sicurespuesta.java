/**
 * Sicurespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.sisabas.service;

public class Sicurespuesta  implements java.io.Serializable {
    private java.util.Date datAuxDatoDate;

    private java.lang.String vchAuxDatoString;

    private java.lang.String vchmensaje;

    private java.lang.String vchstatus;
    
    


    public Sicurespuesta() {
    }

    public Sicurespuesta(
           java.util.Date datAuxDatoDate,
           java.lang.String vchAuxDatoString,
           java.lang.String vchmensaje,
           java.lang.String vchstatus) {
           this.datAuxDatoDate = datAuxDatoDate;
           this.vchAuxDatoString = vchAuxDatoString;
           this.vchmensaje = vchmensaje;
           this.vchstatus = vchstatus;
    }








    /**
     * Gets the vchAuxDatoString value for this Sicurespuesta.
     * 
     * @return vchAuxDatoString
     */
    public java.lang.String getVchAuxDatoString() {
        return vchAuxDatoString;
    }


    /**
     * Sets the vchAuxDatoString value for this Sicurespuesta.
     * 
     * @param vchAuxDatoString
     */
    public void setVchAuxDatoString(java.lang.String vchAuxDatoString) {
        this.vchAuxDatoString = vchAuxDatoString;
    }


    /**
     * Gets the vchmensaje value for this Sicurespuesta.
     * 
     * @return vchmensaje
     */
    public java.lang.String getVchmensaje() {
        return vchmensaje;
    }


    /**
     * Sets the vchmensaje value for this Sicurespuesta.
     * 
     * @param vchmensaje
     */
    public void setVchmensaje(java.lang.String vchmensaje) {
        this.vchmensaje = vchmensaje;
    }


    /**
     * Gets the vchstatus value for this Sicurespuesta.
     * 
     * @return vchstatus
     */
    public java.lang.String getVchstatus() {
        return vchstatus;
    }


    /**
     * Sets the vchstatus value for this Sicurespuesta.
     * 
     * @param vchstatus
     */
    public void setVchstatus(java.lang.String vchstatus) {
        this.vchstatus = vchstatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sicurespuesta)) return false;
        Sicurespuesta other = (Sicurespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.datAuxDatoDate==null && other.getDatAuxDatoDate()==null) || 
             (this.datAuxDatoDate!=null &&
              this.datAuxDatoDate.equals(other.getDatAuxDatoDate()))) &&
            ((this.vchAuxDatoString==null && other.getVchAuxDatoString()==null) || 
             (this.vchAuxDatoString!=null &&
              this.vchAuxDatoString.equals(other.getVchAuxDatoString()))) &&
            ((this.vchmensaje==null && other.getVchmensaje()==null) || 
             (this.vchmensaje!=null &&
              this.vchmensaje.equals(other.getVchmensaje()))) &&
            ((this.vchstatus==null && other.getVchstatus()==null) || 
             (this.vchstatus!=null &&
              this.vchstatus.equals(other.getVchstatus())));
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
        if (getDatAuxDatoDate() != null) {
            _hashCode += getDatAuxDatoDate().hashCode();
        }
        if (getVchAuxDatoString() != null) {
            _hashCode += getVchAuxDatoString().hashCode();
        }
        if (getVchmensaje() != null) {
            _hashCode += getVchmensaje().hashCode();
        }
        if (getVchstatus() != null) {
            _hashCode += getVchstatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sicurespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.sisabas.com.pe/", "sicurespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datAuxDatoDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "datAuxDatoDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchAuxDatoString");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchAuxDatoString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchmensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchmensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchstatus"));
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

	public java.util.Date getDatAuxDatoDate() {
		return datAuxDatoDate;
	}

	public void setDatAuxDatoDate(java.util.Date datAuxDatoDate) {
		this.datAuxDatoDate = datAuxDatoDate;
	}

}
