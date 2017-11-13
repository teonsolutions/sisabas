package pe.com.sisabas.persistence;

import java.util.List;


import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;

public interface RequerimientoMapper {
	
	List<RequerimientoResponse> selectDynamicFull(RequerimientoRequest record) throws Exception;
	

}
