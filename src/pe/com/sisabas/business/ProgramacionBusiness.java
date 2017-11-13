package pe.com.sisabas.business;

import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;

public interface ProgramacionBusiness {
	public Resultado recibir(int idDocumento, String tipoNecesidad, TransactionRequest request) throws Exception;
}
