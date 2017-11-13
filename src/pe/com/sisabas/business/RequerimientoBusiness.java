package pe.com.sisabas.business;

import java.util.List;

import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;

public interface RequerimientoBusiness {
	
	
	public List<RequerimientoResponse> selectDynamicFull(RequerimientoRequest request) throws Exception;;

}
