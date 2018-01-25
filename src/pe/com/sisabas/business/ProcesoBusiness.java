package pe.com.sisabas.business;

import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.persistence.PacconsolidadoMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.sisabas.dto.ProcesoDto;

public interface ProcesoBusiness {
	public List<ProcesoDto> searchProceso(ProcesoRequest request) throws Exception;
	public Resultado recibirProceso(TransactionRequest<Integer> request) throws Exception;	
	
}
