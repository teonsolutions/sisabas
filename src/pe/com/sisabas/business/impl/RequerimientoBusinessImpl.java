package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Gentipo;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;
import pe.com.sisabas.business.GentipoBusiness;
import pe.com.sisabas.business.RequerimientoBusiness;
import pe.com.sisabas.persistence.GentipoMapper;
import pe.com.sisabas.persistence.RequerimientoMapper;

@Service
public class RequerimientoBusinessImpl implements RequerimientoBusiness, Serializable{
	private static Logger logger=Logger.getLogger(RequerimientoBusinessImpl.class);

	@Autowired
	public RequerimientoMapper requerimientoMapper;
	
	@Override
	public List<RequerimientoResponse> selectDynamicFull(RequerimientoRequest request) throws Exception {

		List<RequerimientoResponse> lista = requerimientoMapper.selectDynamicFull(request);
		if(RequerimientoResponse.HAVE_BIGDECIMALS)
			for (RequerimientoResponse row : lista) {
				row.roundBigDecimals();
			}

			return lista;
	}

}
