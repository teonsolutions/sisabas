package pe.com.sisabas.persistence;

import java.util.List;

import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;

public interface ContratoMapper {
	
	List<ContratoResponse> selectDynamicFull(ContratoRequest record) throws Exception;

}
