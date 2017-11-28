package pe.com.sisabas.dto;

import java.io.Serializable;
import java.util.List;

public class PrestacionDto implements  Serializable,Cloneable{
	
	private static final long serialVersionUID = 1L;
	
	private String dependencia;
	private String direccion;
	
	public String getDependencia() {
		return dependencia;
	}
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	
	

}
