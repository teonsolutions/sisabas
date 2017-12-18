package pe.com.sisabas.business;

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
import pe.com.sisabas.dto.EspecificacionTecnicaDto;
import pe.com.sisabas.dto.Lugar;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;

public interface SeguimientoBusiness {
	
	
	public List<SeguimientoResponse> callpaSeguimientoRequerimiento(SeguimientoRequest seguimientoRequest) throws Exception;

	public List<SegEstadoReqResponse> callpaSeguimientoEstadoRequerimiento(SegEstadoReqRequest segEstadoRequest) throws Exception;
}
