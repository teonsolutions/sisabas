package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Gentipo;
import pe.com.sisabas.be.RequerimientoInsertRequest;
import pe.com.sisabas.be.RequerimientoItemRequest;
import pe.com.sisabas.be.RequerimientoItemResponse;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;
import pe.com.sisabas.business.GentipoBusiness;
import pe.com.sisabas.business.RequerimientoBusiness;
import pe.com.sisabas.persistence.GentipoMapper;
import pe.com.sisabas.persistence.RequerimientoMapper;

@Service
public class RequerimientoBusinessImpl implements RequerimientoBusiness, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger=Logger.getLogger(RequerimientoBusinessImpl.class);

	@Autowired
	public RequerimientoMapper requerimientoMapper;
	
	@Override
	public List<RequerimientoResponse> selectDynamicFull(RequerimientoRequest request) throws Exception {

		List<RequerimientoResponse> lista = requerimientoMapper.selectDynamicFull(request);
		
		for (RequerimientoResponse row : lista) {
			
			row.formatoFecha();
		}
		
		if(RequerimientoResponse.HAVE_BIGDECIMALS)
			for (RequerimientoResponse row2 : lista) {
				
				row2.roundBigDecimals();
			}

			return lista;
	}

	@Override
	public List<RequerimientoItemResponse> selectDynamicBasic(RequerimientoItemRequest request) throws Exception {
		List<RequerimientoItemResponse> lista = requerimientoMapper.selectDynamicBasic(request);
		
		int i=1;
        for (RequerimientoItemResponse row : lista) {
			
			row.setNumeracion(i);
			i++;
		}
		
			return lista;
	}

	@Override
	public void insertBasic(RequerimientoInsertRequest request) throws Exception {
		requerimientoMapper.insertBasic(request);
		
	}
	
	
	
	

}
