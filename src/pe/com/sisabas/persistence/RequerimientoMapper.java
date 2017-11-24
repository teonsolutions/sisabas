package pe.com.sisabas.persistence;

import java.util.List;

import pe.com.sisabas.be.RequerimientoInsertRequest;
import pe.com.sisabas.be.RequerimientoItemRequest;
import pe.com.sisabas.be.RequerimientoItemResponse;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;

public interface RequerimientoMapper {
	
	List<RequerimientoResponse> selectDynamicFull(RequerimientoRequest record) throws Exception;
	
	List<RequerimientoItemResponse> selectDynamicBasic(RequerimientoItemRequest record) throws Exception;
	
	void insertBasic(RequerimientoInsertRequest record) throws Exception;
	
}
