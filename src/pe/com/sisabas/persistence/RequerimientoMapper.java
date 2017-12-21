package pe.com.sisabas.persistence;

import java.util.List;

import pe.com.sisabas.be.RequerimientoInsertRequest;
import pe.com.sisabas.be.RequerimientoItemRequest;
import pe.com.sisabas.be.RequerimientoItemResponse;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;
import pe.com.sisabas.be.SegEstadoReqRequest;
import pe.com.sisabas.be.SegEstadoReqResponse;
import pe.com.sisabas.be.SeguimientoRequest;
import pe.com.sisabas.be.SeguimientoResponse;

public interface RequerimientoMapper {
	
	List<RequerimientoResponse> selectDynamicFull(RequerimientoRequest record) throws Exception;
	
	List<RequerimientoResponse> selectDynamicFullProgramado(RequerimientoRequest record) throws Exception;
	
	List<RequerimientoItemResponse> selectDynamicBasic(RequerimientoItemRequest record) throws Exception;
	
	void insertBasic(RequerimientoInsertRequest record) throws Exception;

	List<SeguimientoResponse> callpaSeguimientoRequerimiento(SeguimientoRequest seguimientoRequest);

	List<SegEstadoReqResponse> callpaSeguimientoEstadoRequerimiento(SegEstadoReqRequest segEstadoReqRequest);
	
	void insertBasicProgramado(RequerimientoInsertRequest record) throws Exception;

}
