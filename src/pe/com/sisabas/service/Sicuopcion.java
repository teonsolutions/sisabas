/**
 * Sicuopcion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.sisabas.service;

public class Sicuopcion  extends pe.com.sisabas.service.Sicurespuesta  implements java.io.Serializable {
    private java.lang.Integer intopccodigo;

    private java.lang.Integer intopccodigopadre;

    private java.lang.Integer intopcnivel;

    private java.lang.Integer intopcorden;

    private pe.com.sisabas.service.Sicucontrol[] listaSicucontrol;

    private java.lang.String vchopcaccion;

    private java.lang.String vchopcnombre;

    private java.lang.String vchopctipo;

    public Sicuopcion() {
    }

    public Sicuopcion(
           java.util.Date datAuxDatoDate,
           java.lang.String vchAuxDatoString,
           java.lang.String vchmensaje,
           java.lang.String vchstatus,
           java.lang.Integer intopccodigo,
           java.lang.Integer intopccodigopadre,
           java.lang.Integer intopcnivel,
           java.lang.Integer intopcorden,
           pe.com.sisabas.service.Sicucontrol[] listaSicucontrol,
           java.lang.String vchopcaccion,
           java.lang.String vchopcnombre,
           java.lang.String vchopctipo) {
        super(
            datAuxDatoDate,
            vchAuxDatoString,
            vchmensaje,
            vchstatus);
        this.intopccodigo = intopccodigo;
        this.intopccodigopadre = intopccodigopadre;
        this.intopcnivel = intopcnivel;
        this.intopcorden = intopcorden;
        this.listaSicucontrol = listaSicucontrol;
        this.vchopcaccion = vchopcaccion;
        this.vchopcnombre = vchopcnombre;
        this.vchopctipo = vchopctipo;
    }


    /**
     * Gets the intopccodigo value for this Sicuopcion.
     * 
     * @return intopccodigo
     */
    public java.lang.Integer getIntopccodigo() {
        return intopccodigo;
    }


    /**
     * Sets the intopccodigo value for this Sicuopcion.
     * 
     * @param intopccodigo
     */
    public void setIntopccodigo(java.lang.Integer intopccodigo) {
        this.intopccodigo = intopccodigo;
    }


    /**
     * Gets the intopccodigopadre value for this Sicuopcion.
     * 
     * @return intopccodigopadre
     */
    public java.lang.Integer getIntopccodigopadre() {
        return intopccodigopadre;
    }


    /**
     * Sets the intopccodigopadre value for this Sicuopcion.
     * 
     * @param intopccodigopadre
     */
    public void setIntopccodigopadre(java.lang.Integer intopccodigopadre) {
        this.intopccodigopadre = intopccodigopadre;
    }


    /**
     * Gets the intopcnivel value for this Sicuopcion.
     * 
     * @return intopcnivel
     */
    public java.lang.Integer getIntopcnivel() {
        return intopcnivel;
    }


    /**
     * Sets the intopcnivel value for this Sicuopcion.
     * 
     * @param intopcnivel
     */
    public void setIntopcnivel(java.lang.Integer intopcnivel) {
        this.intopcnivel = intopcnivel;
    }


    /**
     * Gets the intopcorden value for this Sicuopcion.
     * 
     * @return intopcorden
     */
    public java.lang.Integer getIntopcorden() {
        return intopcorden;
    }


    /**
     * Sets the intopcorden value for this Sicuopcion.
     * 
     * @param intopcorden
     */
    public void setIntopcorden(java.lang.Integer intopcorden) {
        this.intopcorden = intopcorden;
    }


    /**
     * Gets the listaSicucontrol value for this Sicuopcion.
     * 
     * @return listaSicucontrol
     */
    public pe.com.sisabas.service.Sicucontrol[] getListaSicucontrol() {
        return listaSicucontrol;
    }


    /**
     * Sets the listaSicucontrol value for this Sicuopcion.
     * 
     * @param listaSicucontrol
     */
    public void setListaSicucontrol(pe.com.sisabas.service.Sicucontrol[] listaSicucontrol) {
        this.listaSicucontrol = listaSicucontrol;
    }

    public pe.com.sisabas.service.Sicucontrol getListaSicucontrol(int i) {
        return this.listaSicucontrol[i];
    }

    public void setListaSicucontrol(int i, pe.com.sisabas.service.Sicucontrol _value) {
        this.listaSicucontrol[i] = _value;
    }


    /**
     * Gets the vchopcaccion value for this Sicuopcion.
     * 
     * @return vchopcaccion
     */
    public java.lang.String getVchopcaccion() {
        return vchopcaccion;
    }


    /**
     * Sets the vchopcaccion value for this Sicuopcion.
     * 
     * @param vchopcaccion
     */
    public void setVchopcaccion(java.lang.String vchopcaccion) {
        this.vchopcaccion = vchopcaccion;
    }


    /**
     * Gets the vchopcnombre value for this Sicuopcion.
     * 
     * @return vchopcnombre
     */
    public java.lang.String getVchopcnombre() {
        return vchopcnombre;
    }


    /**
     * Sets the vchopcnombre value for this Sicuopcion.
     * 
     * @param vchopcnombre
     */
    public void setVchopcnombre(java.lang.String vchopcnombre) {
        this.vchopcnombre = vchopcnombre;
    }


    /**
     * Gets the vchopctipo value for this Sicuopcion.
     * 
     * @return vchopctipo
     */
    public java.lang.String getVchopctipo() {
        return vchopctipo;
    }


    /**
     * Sets the vchopctipo value for this Sicuopcion.
     * 
     * @param vchopctipo
     */
    public void setVchopctipo(java.lang.String vchopctipo) {
        this.vchopctipo = vchopctipo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sicuopcion)) return false;
        Sicuopcion other = (Sicuopcion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.intopccodigo==null && other.getIntopccodigo()==null) || 
             (this.intopccodigo!=null &&
              this.intopccodigo.equals(other.getIntopccodigo()))) &&
            ((this.intopccodigopadre==null && other.getIntopccodigopadre()==null) || 
             (this.intopccodigopadre!=null &&
              this.intopccodigopadre.equals(other.getIntopccodigopadre()))) &&
            ((this.intopcnivel==null && other.getIntopcnivel()==null) || 
             (this.intopcnivel!=null &&
              this.intopcnivel.equals(other.getIntopcnivel()))) &&
            ((this.intopcorden==null && other.getIntopcorden()==null) || 
             (this.intopcorden!=null &&
              this.intopcorden.equals(other.getIntopcorden()))) &&
            ((this.listaSicucontrol==null && other.getListaSicucontrol()==null) || 
             (this.listaSicucontrol!=null &&
              java.util.Arrays.equals(this.listaSicucontrol, other.getListaSicucontrol()))) &&
            ((this.vchopcaccion==null && other.getVchopcaccion()==null) || 
             (this.vchopcaccion!=null &&
              this.vchopcaccion.equals(other.getVchopcaccion()))) &&
            ((this.vchopcnombre==null && other.getVchopcnombre()==null) || 
             (this.vchopcnombre!=null &&
              this.vchopcnombre.equals(other.getVchopcnombre()))) &&
            ((this.vchopctipo==null && other.getVchopctipo()==null) || 
             (this.vchopctipo!=null &&
              this.vchopctipo.equals(other.getVchopctipo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getIntopccodigo() != null) {
            _hashCode += getIntopccodigo().hashCode();
        }
        if (getIntopccodigopadre() != null) {
            _hashCode += getIntopccodigopadre().hashCode();
        }
        if (getIntopcnivel() != null) {
            _hashCode += getIntopcnivel().hashCode();
        }
        if (getIntopcorden() != null) {
            _hashCode += getIntopcorden().hashCode();
        }
        if (getListaSicucontrol() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaSicucontrol());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaSicucontrol(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVchopcaccion() != null) {
            _hashCode += getVchopcaccion().hashCode();
        }
        if (getVchopcnombre() != null) {
            _hashCode += getVchopcnombre().hashCode();
        }
        if (getVchopctipo() != null) {
            _hashCode += getVchopctipo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sicuopcion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.sisabas.com.pe/", "sicuopcion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intopccodigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intopccodigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intopccodigopadre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intopccodigopadre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intopcnivel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intopcnivel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intopcorden");
        elemField.setXmlName(new javax.xml.namespace.QName("", "intopcorden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaSicucontrol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaSicucontrol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.sisabas.com.pe/", "sicucontrol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchopcaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchopcaccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchopcnombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchopcnombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchopctipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchopctipo"));
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
