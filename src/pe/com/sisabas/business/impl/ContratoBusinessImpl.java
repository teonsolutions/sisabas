package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;
import pe.com.sisabas.business.ContratoBusiness;
import pe.com.sisabas.persistence.ContratoMapper;


@Service
public class ContratoBusinessImpl implements ContratoBusiness, Serializable{

	@Autowired
	public ContratoMapper contratoMapper;

	private static final long serialVersionUID = 1L;

	@Override
	public List<ContratoResponse> selectDynamicFull(ContratoRequest request) throws Exception {
		
		List<ContratoResponse> lista = contratoMapper.selectDynamicFull(request); 
        
		for (ContratoResponse row : lista) {
			
			row.formatoFecha();
		}
		
		return lista;
	}
	
	
	
	
	
	
	
	

}
