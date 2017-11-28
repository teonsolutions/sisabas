package pe.com.sisabas.business;

import java.util.List;

import pe.com.sisabas.be.RequerimientoInsertRequest;
import pe.com.sisabas.be.RequerimientoItemRequest;
import pe.com.sisabas.be.RequerimientoItemResponse;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;
import pe.com.sisabas.dto.EspecificacionTecnicaDto;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;

public interface RequerimientoBusiness {
	
	
	public List<RequerimientoResponse> selectDynamicFull(RequerimientoRequest request) throws Exception;
	
	public List<RequerimientoItemResponse> selectDynamicBasic(RequerimientoItemRequest request) throws Exception;
	
	public void insertBasic(RequerimientoInsertRequest request) throws Exception;
	
	public Resultado guardarEspecificacionTecnica(TransactionRequest<EspecificacionTecnicaDto> request) throws Exception;

}
