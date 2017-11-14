package pe.com.sisabas.business;

import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;

public interface ProgramacionBusiness {
	public Resultado recibirDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request) throws Exception;
	public Resultado aprobarDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request) throws Exception;
	public Resultado observarDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request) throws Exception;
}
