
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Resultadoprocesoporusuario;
import pe.com.sisabas.dto.ProcesoResultadoItemDesiertoAsigDto;
import pe.com.sisabas.dto.ResultadoItemsRequest;

public interface ResultadoprocesoporusuarioMapper{

	int deleteByPrimaryKey(@Param("idresultadoprocesousuario") java.lang.Integer idresultadoprocesousuario) throws Exception;

	Resultadoprocesoporusuario selectByPrimaryKeyBasic(@Param("idresultadoprocesousuario") java.lang.Integer idresultadoprocesousuario) throws Exception;

	Resultadoprocesoporusuario selectByPrimaryKeyBasicActive(@Param("idresultadoprocesousuario") java.lang.Integer idresultadoprocesousuario) throws Exception;

	Resultadoprocesoporusuario selectByPrimaryKeyFull(@Param("idresultadoprocesousuario") java.lang.Integer idresultadoprocesousuario) throws Exception;

	Resultadoprocesoporusuario selectByPrimaryKeyFullActive(@Param("idresultadoprocesousuario") java.lang.Integer idresultadoprocesousuario) throws Exception;

	int updateByPrimaryKeySelective(Resultadoprocesoporusuario record) throws Exception;

	int updateByPrimaryKey(Resultadoprocesoporusuario record) throws Exception;

	int insert(Resultadoprocesoporusuario record) throws Exception;

	int insertSelective(Resultadoprocesoporusuario record) throws Exception;

	List<Resultadoprocesoporusuario> selectDynamicBasic(Resultadoprocesoporusuario record) throws Exception;

	List<Resultadoprocesoporusuario> selectDynamicFull(Resultadoprocesoporusuario record) throws Exception;

	List<Resultadoprocesoporusuario> selectDynamicExtended(Resultadoprocesoporusuario record) throws Exception;

	//CUSTOM
	List<Resultadoprocesoporusuario> selectResultadoAsignados(@Param("idresultadoproceso") java.lang.Integer idresultadoproceso) throws Exception;
	
	List<ProcesoResultadoItemDesiertoAsigDto> selectResultadoAsignadosUsuario(ResultadoItemsRequest request) throws Exception;

}
