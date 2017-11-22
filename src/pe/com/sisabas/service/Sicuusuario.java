/**
 * Sicuusuario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.sisabas.service;

public class Sicuusuario  extends pe.com.sisabas.service.Sicurespuesta  implements java.io.Serializable {
    private pe.com.sisabas.service.Sicuopcion[] listaSicuopcion;

    private java.lang.String[] listaUltimosAccesosValidos;

    private java.lang.String[] listaUltimosIntentosFallidos;

    private java.lang.String vchsessionid;

    private java.lang.String vchusulogin;

    private java.lang.String vchusurol;
    
    //PARA GUARDAR PERIODO ACTIVO
    private Sicuperiodo periodo;

    public Sicuperiodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Sicuperiodo periodo) {
		this.periodo = periodo;
	}
	//END PARA GUARDAR PERIODO ACTIVO

	public Sicuusuario() {
    }

    public Sicuusuario(
           java.util.Date datAuxDatoDate,
           java.lang.String vchAuxDatoString,
           java.lang.String vchmensaje,
           java.lang.String vchstatus,
           pe.com.sisabas.service.Sicuopcion[] listaSicuopcion,
           java.lang.String[] listaUltimosAccesosValidos,
           java.lang.String[] listaUltimosIntentosFallidos,
           java.lang.String vchsessionid,
           java.lang.String vchusulogin,
           java.lang.String vchusurol) {
        super(
            datAuxDatoDate,
            vchAuxDatoString,
            vchmensaje,
            vchstatus);
        this.listaSicuopcion = listaSicuopcion;
        this.listaUltimosAccesosValidos = listaUltimosAccesosValidos;
        this.listaUltimosIntentosFallidos = listaUltimosIntentosFallidos;
        this.vchsessionid = vchsessionid;
        this.vchusulogin = vchusulogin;
        this.vchusurol = vchusurol;
    }


    /**
     * Gets the listaSicuopcion value for this Sicuusuario.
     * 
     * @return listaSicuopcion
     */
    public pe.com.sisabas.service.Sicuopcion[] getListaSicuopcion() {
        return listaSicuopcion;
    }


    /**
     * Sets the listaSicuopcion value for this Sicuusuario.
     * 
     * @param listaSicuopcion
     */
    public void setListaSicuopcion(pe.com.sisabas.service.Sicuopcion[] listaSicuopcion) {
        this.listaSicuopcion = listaSicuopcion;
    }

    public pe.com.sisabas.service.Sicuopcion getListaSicuopcion(int i) {
        return this.listaSicuopcion[i];
    }

    public void setListaSicuopcion(int i, pe.com.sisabas.service.Sicuopcion _value) {
        this.listaSicuopcion[i] = _value;
    }


    /**
     * Gets the listaUltimosAccesosValidos value for this Sicuusuario.
     * 
     * @return listaUltimosAccesosValidos
     */
    public java.lang.String[] getListaUltimosAccesosValidos() {
        return listaUltimosAccesosValidos;
    }


    /**
     * Sets the listaUltimosAccesosValidos value for this Sicuusuario.
     * 
     * @param listaUltimosAccesosValidos
     */
    public void setListaUltimosAccesosValidos(java.lang.String[] listaUltimosAccesosValidos) {
        this.listaUltimosAccesosValidos = listaUltimosAccesosValidos;
    }

    public java.lang.String getListaUltimosAccesosValidos(int i) {
        return this.listaUltimosAccesosValidos[i];
    }

    public void setListaUltimosAccesosValidos(int i, java.lang.String _value) {
        this.listaUltimosAccesosValidos[i] = _value;
    }


    /**
     * Gets the listaUltimosIntentosFallidos value for this Sicuusuario.
     * 
     * @return listaUltimosIntentosFallidos
     */
    public java.lang.String[] getListaUltimosIntentosFallidos() {
        return listaUltimosIntentosFallidos;
    }


    /**
     * Sets the listaUltimosIntentosFallidos value for this Sicuusuario.
     * 
     * @param listaUltimosIntentosFallidos
     */
    public void setListaUltimosIntentosFallidos(java.lang.String[] listaUltimosIntentosFallidos) {
        this.listaUltimosIntentosFallidos = listaUltimosIntentosFallidos;
    }

    public java.lang.String getListaUltimosIntentosFallidos(int i) {
        return this.listaUltimosIntentosFallidos[i];
    }

    public void setListaUltimosIntentosFallidos(int i, java.lang.String _value) {
        this.listaUltimosIntentosFallidos[i] = _value;
    }


    /**
     * Gets the vchsessionid value for this Sicuusuario.
     * 
     * @return vchsessionid
     */
    public java.lang.String getVchsessionid() {
        return vchsessionid;
    }


    /**
     * Sets the vchsessionid value for this Sicuusuario.
     * 
     * @param vchsessionid
     */
    public void setVchsessionid(java.lang.String vchsessionid) {
        this.vchsessionid = vchsessionid;
    }


    /**
     * Gets the vchusulogin value for this Sicuusuario.
     * 
     * @return vchusulogin
     */
    public java.lang.String getVchusulogin() {
        return vchusulogin;
    }


    /**
     * Sets the vchusulogin value for this Sicuusuario.
     * 
     * @param vchusulogin
     */
    public void setVchusulogin(java.lang.String vchusulogin) {
        this.vchusulogin = vchusulogin;
    }


    /**
     * Gets the vchusurol value for this Sicuusuario.
     * 
     * @return vchusurol
     */
    public java.lang.String getVchusurol() {
        return vchusurol;
    }


    /**
     * Sets the vchusurol value for this Sicuusuario.
     * 
     * @param vchusurol
     */
    public void setVchusurol(java.lang.String vchusurol) {
        this.vchusurol = vchusurol;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sicuusuario)) return false;
        Sicuusuario other = (Sicuusuario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.listaSicuopcion==null && other.getListaSicuopcion()==null) || 
             (this.listaSicuopcion!=null &&
              java.util.Arrays.equals(this.listaSicuopcion, other.getListaSicuopcion()))) &&
            ((this.listaUltimosAccesosValidos==null && other.getListaUltimosAccesosValidos()==null) || 
             (this.listaUltimosAccesosValidos!=null &&
              java.util.Arrays.equals(this.listaUltimosAccesosValidos, other.getListaUltimosAccesosValidos()))) &&
            ((this.listaUltimosIntentosFallidos==null && other.getListaUltimosIntentosFallidos()==null) || 
             (this.listaUltimosIntentosFallidos!=null &&
              java.util.Arrays.equals(this.listaUltimosIntentosFallidos, other.getListaUltimosIntentosFallidos()))) &&
            ((this.vchsessionid==null && other.getVchsessionid()==null) || 
             (this.vchsessionid!=null &&
              this.vchsessionid.equals(other.getVchsessionid()))) &&
            ((this.vchusulogin==null && other.getVchusulogin()==null) || 
             (this.vchusulogin!=null &&
              this.vchusulogin.equals(other.getVchusulogin()))) &&
            ((this.vchusurol==null && other.getVchusurol()==null) || 
             (this.vchusurol!=null &&
              this.vchusurol.equals(other.getVchusurol())));
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
        if (getListaSicuopcion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaSicuopcion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaSicuopcion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaUltimosAccesosValidos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaUltimosAccesosValidos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaUltimosAccesosValidos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaUltimosIntentosFallidos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaUltimosIntentosFallidos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaUltimosIntentosFallidos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVchsessionid() != null) {
            _hashCode += getVchsessionid().hashCode();
        }
        if (getVchusulogin() != null) {
            _hashCode += getVchusulogin().hashCode();
        }
        if (getVchusurol() != null) {
            _hashCode += getVchusurol().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sicuusuario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.sisabas.com.pe/", "sicuusuario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaSicuopcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaSicuopcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.sisabas.com.pe/", "sicuopcion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaUltimosAccesosValidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaUltimosAccesosValidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaUltimosIntentosFallidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaUltimosIntentosFallidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchsessionid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchsessionid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchusulogin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchusulogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vchusurol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vchusurol"));
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
