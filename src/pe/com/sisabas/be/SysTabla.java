package pe.com.sisabas.be;

import java.util.HashMap;
import java.util.List;

import java.io.Serializable;


public class SysTabla implements  Serializable, Cloneable{

	private static final long serialVersionUID = 1L;

	/*Orden de Consulta*/	
	private List<String>     ordenListaCampos;
	private java.lang.String ordenTipo;
	private java.lang.Integer cantidadRegistros;
	private HashMap<String,Object> params=new HashMap<String, Object>();


	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	 }
	
	public SysTabla() {
		this.ordenTipo="ASC";
	}

	public SysTabla(String parOrdenTipo, List<String> parOrdenListaCampos) {
		this.ordenTipo        = parOrdenTipo;
		this.ordenListaCampos = parOrdenListaCampos;
	}
	
	public List<String> getOrdenListaCampos() {
		return ordenListaCampos;
	}

	public void setOrdenListaCampos(List<String> ordenListaCampos) {
		this.ordenListaCampos = ordenListaCampos;
	}

	public java.lang.String getOrdenTipo() {
		return ordenTipo;
	}

	public void setOrdenTipo(java.lang.String ordenTipo) {
		this.ordenTipo = ordenTipo;
	}

	public java.lang.Integer getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(java.lang.Integer cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public HashMap<String,Object> getParams() {
		return params;
	}

	public void setParams(HashMap<String,Object> params) {
		this.params = params;
	}


}
