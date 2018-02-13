package pe.com.sisabas.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.sisabas.be.Contrato;
import pe.com.sisabas.be.ContratoRequest;
import pe.com.sisabas.be.ContratoResponse;
import pe.com.sisabas.dto.SegRequest;
import pe.com.sisabas.dto.SegResponse;


public interface ContratoMapper {
	
	int deleteByPrimaryKey(@Param("idcontrato") java.lang.Integer idcontrato) throws Exception;

	Contrato selectByPrimaryKeyBasic(@Param("idcontrato") java.lang.Integer idcontrato) throws Exception;

	Contrato selectByPrimaryKeyBasicActive(@Param("idcontrato") java.lang.Integer idcontrato) throws Exception;

	Contrato selectByPrimaryKeyFull(@Param("idcontrato") java.lang.Integer idcontrato) throws Exception;

	Contrato selectByPrimaryKeyFullActive(@Param("idcontrato") java.lang.Integer idcontrato) throws Exception;

	int updateByPrimaryKeySelective(Contrato record) throws Exception;

	int updateByPrimaryKey(Contrato record) throws Exception;

	int insert(Contrato record) throws Exception;
	
	int insertBasic(Contrato record) throws Exception;

	int insertSelective(Contrato record) throws Exception;
	
	List<Contrato> selectDynamicBasic(Contrato record) throws Exception;
	
	List<ContratoResponse> selectDynamicFull(ContratoRequest record) throws Exception;
    
	List<Contrato> selectDynamicExtended(Contrato record) throws Exception;
	
	List<SegResponse> obtenerSeguimiento(SegRequest record) throws Exception;
	
	List<Integer> listaEjercicio() throws Exception;
}
