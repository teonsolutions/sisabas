package pe.com.sisabas.dto;

public class Resultado {
	private boolean estado;
	private String mensaje;
	private Integer resultInt;
	
	
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Integer getResultInt() {
		return resultInt;
	}
	public void setResultInt(Integer resultInt) {
		this.resultInt = resultInt;
	}
	public Resultado(){
		
	}
	

	public Resultado(boolean estado, String mensaje){
		this.estado = estado;
		this.mensaje = mensaje;
	}
}
