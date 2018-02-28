
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Resultadoprocesoseleccion;
import pe.com.sisabas.dto.ContratoSigaRequest;
import pe.com.sisabas.dto.ContratoSigaResponse;
import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.ProcesoResultadoItemDesiertoDto;
import pe.com.sisabas.dto.ProcesoResultadoItemDto;

public interface ResultadoprocesoseleccionMapper{

	int deleteByPrimaryKey(@Param("idresultadoproceso") java.lang.Integer idresultadoproceso) throws Exception;

	Resultadoprocesoseleccion selectByPrimaryKeyBasic(@Param("idresultadoproceso") java.lang.Integer idresultadoproceso) throws Exception;

	Resultadoprocesoseleccion selectByPrimaryKeyBasicActive(@Param("idresultadoproceso") java.lang.Integer idresultadoproceso) throws Exception;

	Resultadoprocesoseleccion selectByPrimaryKeyFull(@Param("idresultadoproceso") java.lang.Integer idresultadoproceso) throws Exception;

	Resultadoprocesoseleccion selectByPrimaryKeyFullActive(@Param("idresultadoproceso") java.lang.Integer idresultadoproceso) throws Exception;

	int updateByPrimaryKeySelective(Resultadoprocesoseleccion record) throws Exception;

	int updateByPrimaryKey(Resultadoprocesoseleccion record) throws Exception;

	int insert(Resultadoprocesoseleccion record) throws Exception;

	int insertSelective(Resultadoprocesoseleccion record) throws Exception;

	List<Resultadoprocesoseleccion> selectDynamicBasic(Resultadoprocesoseleccion record) throws Exception;

	List<Resultadoprocesoseleccion> selectDynamicFull(Resultadoprocesoseleccion record) throws Exception;

	List<Resultadoprocesoseleccion> selectDynamicExtended(Resultadoprocesoseleccion record) throws Exception;

	//CUSTOM
	List<ProcesoResultadoItemDto> selectResultadoSiga(ProcesoRequest request) throws Exception;
	
	List<ProcesoResultadoItemDto> selectResultadoByIdConvocatoria(@Param("idconvocatoriaproceso") java.lang.Integer idconvocatoriaproceso) throws Exception;	
	
	List<ProcesoResultadoItemDesiertoDto> selectResultadoByEstadoByIdProcesoSeleccion(ProcesoRequest request) throws Exception;
	
	List<ContratoSigaResponse> selectContratoSigaByRucAndNroConsolid(ContratoSigaRequest request) throws Exception;

}
