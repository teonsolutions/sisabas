
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Convocatoriaprocesoseleccion;
import pe.com.sisabas.dto.ConvocatoriaDto;

public interface ConvocatoriaprocesoseleccionMapper{

	int deleteByPrimaryKey(@Param("idconvocatoriaproceso") java.lang.Integer idconvocatoriaproceso) throws Exception;

	Convocatoriaprocesoseleccion selectByPrimaryKeyBasic(@Param("idconvocatoriaproceso") java.lang.Integer idconvocatoriaproceso) throws Exception;

	Convocatoriaprocesoseleccion selectByPrimaryKeyBasicActive(@Param("idconvocatoriaproceso") java.lang.Integer idconvocatoriaproceso) throws Exception;

	Convocatoriaprocesoseleccion selectByPrimaryKeyFull(@Param("idconvocatoriaproceso") java.lang.Integer idconvocatoriaproceso) throws Exception;

	Convocatoriaprocesoseleccion selectByPrimaryKeyFullActive(@Param("idconvocatoriaproceso") java.lang.Integer idconvocatoriaproceso) throws Exception;

	int updateByPrimaryKeySelective(Convocatoriaprocesoseleccion record) throws Exception;

	int updateByPrimaryKey(Convocatoriaprocesoseleccion record) throws Exception;

	int insert(Convocatoriaprocesoseleccion record) throws Exception;

	int insertSelective(Convocatoriaprocesoseleccion record) throws Exception;

	List<Convocatoriaprocesoseleccion> selectDynamicBasic(Convocatoriaprocesoseleccion record) throws Exception;

	List<Convocatoriaprocesoseleccion> selectDynamicFull(Convocatoriaprocesoseleccion record) throws Exception;

	List<Convocatoriaprocesoseleccion> selectDynamicExtended(Convocatoriaprocesoseleccion record) throws Exception;

	//CUSTOM
	List<ConvocatoriaDto> selectConvocatoriaByIdProceso(@Param("idProcesoSeleccion") java.lang.Integer idProcesoSeleccion) throws Exception;
	
}
