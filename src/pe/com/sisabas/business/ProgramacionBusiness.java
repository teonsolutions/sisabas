package pe.com.sisabas.business;

import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;

public interface ProgramacionBusiness {
	public Resultado recibir(EvaluacionDocumentoResponse item, TransactionRequest request) throws Exception;
}
