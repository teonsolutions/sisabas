package pe.com.sisabas.resources.business.impl;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.resources.business.UtilsBusiness;
import pe.com.sisabas.resources.persistence.UtilsMapper;



@Service
public class UtilsBusinessImpl implements UtilsBusiness, Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	UtilsMapper utilsMapper;
	
	@Override
	public Long getNextSeq(String secuence) {
		Long var=utilsMapper.getNextSeq(secuence);
		return var;
		//return utilsMapper.getNextSeq(secuence);
	}
		
	@Override
	public Long getNextSeqTemporal(String secuence) {
		Long var=utilsMapper.getNextSeqTemporal(secuence)+1;
		return var;
		//return utilsMapper.getNextSeqTemporal(secuence);
	}
	
}

