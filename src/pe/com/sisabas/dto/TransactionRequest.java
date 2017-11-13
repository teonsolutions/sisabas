package pe.com.sisabas.dto;

public class TransactionRequest<T> {
	private String equipoAuditoria;
	private String programaAuditoria;
	private String usuarioAuditoria;
	
	public String getEquipoAuditoria() {
		return equipoAuditoria;
	}
	public void setEquipoAuditoria(String equipoAuditoria) {
		this.equipoAuditoria = equipoAuditoria;
	}
	public String getProgramaAuditoria() {
		return programaAuditoria;
	}
	public void setProgramaAuditoria(String programaAuditoria) {
		this.programaAuditoria = programaAuditoria;
	}
	public String getUsuarioAuditoria() {
		return usuarioAuditoria;
	}
	public void setUsuarioAuditoria(String usuarioAuditoria) {
		this.usuarioAuditoria = usuarioAuditoria;
	}

	private T entityTransaction;

	public T getEntityTransaction() {
		return entityTransaction;
	}
	public void setEntityTransaction(T entityTransaction) {
		this.entityTransaction = entityTransaction;
	}	
}
