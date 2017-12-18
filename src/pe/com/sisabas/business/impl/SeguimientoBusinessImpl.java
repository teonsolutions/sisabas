package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Dependenciadocumentotecnico;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Gentipo;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.be.Plazopagodocumentotecnico;
import pe.com.sisabas.be.RequerimientoInsertRequest;
import pe.com.sisabas.be.RequerimientoItemRequest;
import pe.com.sisabas.be.RequerimientoItemResponse;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;
import pe.com.sisabas.be.SegEstadoReqRequest;
import pe.com.sisabas.be.SegEstadoReqResponse;
import pe.com.sisabas.be.SeguimientoRequest;
import pe.com.sisabas.be.SeguimientoResponse;
import pe.com.sisabas.business.GentipoBusiness;
import pe.com.sisabas.business.RequerimientoBusiness;
import pe.com.sisabas.business.SeguimientoBusiness;
import pe.com.sisabas.dto.EspecificacionTecnicaDto;
import pe.com.sisabas.dto.Lugar;
import pe.com.sisabas.dto.Pago;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.persistence.ComiteprocesoMapper;
import pe.com.sisabas.persistence.DependenciadocumentotecnicoMapper;
import pe.com.sisabas.persistence.DocumentotecnicoMapper;
import pe.com.sisabas.persistence.GentipoMapper;
import pe.com.sisabas.persistence.MiembrocomiteporprocesoMapper;
import pe.com.sisabas.persistence.PedidoMapper;
import pe.com.sisabas.persistence.PlazopagodocumentotecnicoMapper;
import pe.com.sisabas.persistence.RequerimientoMapper;
import pe.com.sisabas.persistence.SeguimientoMapper;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.business.UtilsBusiness;

@Service
public class SeguimientoBusinessImpl implements SeguimientoBusiness, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger=Logger.getLogger(SeguimientoBusinessImpl.class);
	
	@Autowired
	public SeguimientoMapper seguimientoMapper;
	

	@Override
	public List<SeguimientoResponse> callpaSeguimientoRequerimiento(SeguimientoRequest seguimientoRequest) throws Exception {
		
		return seguimientoMapper.callpaSeguimientoRequerimiento(seguimientoRequest);
	}

	@Override
	public List<SegEstadoReqResponse> callpaSeguimientoEstadoRequerimiento(SegEstadoReqRequest segEstadoReqRequest) {

	
		
		return seguimientoMapper.callpaSeguimientoEstadoRequerimiento(segEstadoReqRequest);
	}


	
	
	

}
