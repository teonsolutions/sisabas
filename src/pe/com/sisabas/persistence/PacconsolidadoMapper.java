
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.dto.CertificacionItemsDto;
import pe.com.sisabas.dto.CertificacionRequest;
import pe.com.sisabas.dto.CompraDirectaDatosGeneralesDto;
import pe.com.sisabas.dto.CuadroComparativoItemsDto;
import pe.com.sisabas.dto.PacItemsDto;
import pe.com.sisabas.dto.PedidosPaoResponse;
import pe.com.sisabas.dto.RecepcionDTResponse;
import pe.com.sisabas.dto.PaoRequest;
import pe.com.sisabas.dto.PaoResponse;

public interface PacconsolidadoMapper{

	int deleteByPrimaryKey(@Param("idpacconsolidado") java.lang.Integer idpacconsolidado) throws Exception;

	Pacconsolidado selectByPrimaryKeyBasic(@Param("idpacconsolidado") java.lang.Integer idpacconsolidado) throws Exception;

	Pacconsolidado selectByPrimaryKeyBasicActive(@Param("idpacconsolidado") java.lang.Integer idpacconsolidado) throws Exception;

	Pacconsolidado selectByPrimaryKeyFull(@Param("idpacconsolidado") java.lang.Integer idpacconsolidado) throws Exception;

	Pacconsolidado selectByPrimaryKeyFullActive(@Param("idpacconsolidado") java.lang.Integer idpacconsolidado) throws Exception;

	int updateByPrimaryKeySelective(Pacconsolidado record) throws Exception;

	int updateByPrimaryKey(Pacconsolidado record) throws Exception;

	int insert(Pacconsolidado record) throws Exception;

	int insertSelective(Pacconsolidado record) throws Exception;

	List<Pacconsolidado> selectDynamicBasic(Pacconsolidado record) throws Exception;

	List<Pacconsolidado> selectDynamicFull(Pacconsolidado record) throws Exception;

	List<Pacconsolidado> selectDynamicExtended(Pacconsolidado record) throws Exception;
	
	//NEW CUSTOM METHODS

	List<PaoResponse> getPaoListado(PaoRequest record) throws Exception;
	
	List<PedidosPaoResponse> getPedidosPao(PaoRequest record) throws Exception;
	
	CompraDirectaDatosGeneralesDto getCompraDirectaDatosGenerales(PaoRequest record) throws Exception;
	
	List<PacItemsDto> getPacItems(PaoRequest record) throws Exception;
	
	List<CertificacionItemsDto> getCertificacionItems(CertificacionRequest record) throws Exception;
	
	RecepcionDTResponse getFechaRecepcionDT(PaoRequest record) throws Exception;
	
	List<CuadroComparativoItemsDto> getCuadroComparativoItems(Integer idPacConsolidado) throws Exception;
	
	
}
