package pe.com.sisabas.business;

import java.util.List;

import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;

public interface ContratoBusiness {
	
	public List<ContratoResponse> selectDynamicFull(ContratoRequest request) throws Exception;

}
