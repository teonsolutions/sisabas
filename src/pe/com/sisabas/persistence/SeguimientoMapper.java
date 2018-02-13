package pe.com.sisabas.persistence;

import java.util.List;


import pe.com.sisabas.be.SegEstadoReqRequest;
import pe.com.sisabas.be.SegEstadoReqResponse;
import pe.com.sisabas.be.SeguimientoRequest;
import pe.com.sisabas.be.SeguimientoResponse;

public interface SeguimientoMapper {
	
	

	List<SeguimientoResponse> callpaSeguimientoRequerimiento(SeguimientoRequest seguimientoRequest);

	List<SegEstadoReqResponse> callpaSeguimientoEstadoRequerimiento(SegEstadoReqRequest segEstadoReqRequest);
	
	
	
}
