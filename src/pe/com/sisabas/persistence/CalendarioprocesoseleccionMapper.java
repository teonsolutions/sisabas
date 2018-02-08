
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Calendarioprocesoseleccion;
import pe.com.sisabas.dto.CalendarioDto;

public interface CalendarioprocesoseleccionMapper{

	int deleteByPrimaryKey(@Param("idcalendarioproceso") java.lang.Integer idcalendarioproceso) throws Exception;

	Calendarioprocesoseleccion selectByPrimaryKeyBasic(@Param("idcalendarioproceso") java.lang.Integer idcalendarioproceso) throws Exception;

	Calendarioprocesoseleccion selectByPrimaryKeyBasicActive(@Param("idcalendarioproceso") java.lang.Integer idcalendarioproceso) throws Exception;

	Calendarioprocesoseleccion selectByPrimaryKeyFull(@Param("idcalendarioproceso") java.lang.Integer idcalendarioproceso) throws Exception;

	Calendarioprocesoseleccion selectByPrimaryKeyFullActive(@Param("idcalendarioproceso") java.lang.Integer idcalendarioproceso) throws Exception;

	int updateByPrimaryKeySelective(Calendarioprocesoseleccion record) throws Exception;

	int updateByPrimaryKey(Calendarioprocesoseleccion record) throws Exception;

	int insert(Calendarioprocesoseleccion record) throws Exception;

	int insertSelective(Calendarioprocesoseleccion record) throws Exception;

	List<Calendarioprocesoseleccion> selectDynamicBasic(Calendarioprocesoseleccion record) throws Exception;

	List<Calendarioprocesoseleccion> selectDynamicFull(Calendarioprocesoseleccion record) throws Exception;

	List<Calendarioprocesoseleccion> selectDynamicExtended(Calendarioprocesoseleccion record) throws Exception;

	//CUSTOM
	List<CalendarioDto> selectCalendarioByIdConvocatoria(@Param("idConvocatoriaProceso") java.lang.Integer idConvocatoriaProceso) throws Exception;	

}
