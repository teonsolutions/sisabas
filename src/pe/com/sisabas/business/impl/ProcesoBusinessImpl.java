package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.business.ProcesoBusiness;
import pe.com.sisabas.dto.ProcesoDto;
import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.persistence.PacconsolidadoMapper;

@Service
public class ProcesoBusinessImpl implements ProcesoBusiness, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public PacconsolidadoMapper pacconsolidadoMapper;
	
	@Override
	public List<ProcesoDto> searchProceso(ProcesoRequest request) throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.searchProceso(request);
	}

	@Override
	@Transactional
	public Resultado recibirProceso(TransactionRequest<Integer> request) throws Exception {
		// TODO Auto-generated method stub
		Pacconsolidado pacConsolid = pacconsolidadoMapper.selectByPrimaryKeyBasic(request.getEntityTransaction());
		
		return null;
	}

		
	
}
