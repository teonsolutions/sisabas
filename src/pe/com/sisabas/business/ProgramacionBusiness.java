package pe.com.sisabas.business;

import java.util.List;

import pe.com.sisabas.dto.EvaluacionDocumentoResponse;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;

public interface ProgramacionBusiness {
	public Resultado recibirDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request) throws Exception;
	public Resultado aprobarDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request) throws Exception;
	public Resultado observarDocumentoTecnico(EvaluacionDocumentoResponse item, TransactionRequest request) throws Exception;	
	public List<PaoResponse> getPaoListado(PaoRequest record) throws Exception;
}
