package pe.com.sisabas.dto;

public class TransactionResponse<T> {
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
	private boolean estado;
	private String mensaje;		
	
	private T entityTransaction;

	public T getEntityTransaction() {
		return entityTransaction;
	}
	public void setEntityTransaction(T entityTransaction) {
		this.entityTransaction = entityTransaction;
	}
	
}
