
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Itinerarioconveniomarco;

public interface ItinerarioconveniomarcoMapper{

	int deleteByPrimaryKey(@Param("iditinerarioconveniomarco") java.lang.Integer iditinerarioconveniomarco) throws Exception;

	Itinerarioconveniomarco selectByPrimaryKeyBasic(@Param("iditinerarioconveniomarco") java.lang.Integer iditinerarioconveniomarco) throws Exception;

	Itinerarioconveniomarco selectByPrimaryKeyBasicActive(@Param("iditinerarioconveniomarco") java.lang.Integer iditinerarioconveniomarco) throws Exception;

	Itinerarioconveniomarco selectByPrimaryKeyFull(@Param("iditinerarioconveniomarco") java.lang.Integer iditinerarioconveniomarco) throws Exception;

	Itinerarioconveniomarco selectByPrimaryKeyFullActive(@Param("iditinerarioconveniomarco") java.lang.Integer iditinerarioconveniomarco) throws Exception;

	int updateByPrimaryKeySelective(Itinerarioconveniomarco record) throws Exception;

	int updateByPrimaryKey(Itinerarioconveniomarco record) throws Exception;

	int insert(Itinerarioconveniomarco record) throws Exception;

	int insertSelective(Itinerarioconveniomarco record) throws Exception;

	List<Itinerarioconveniomarco> selectDynamicBasic(Itinerarioconveniomarco record) throws Exception;

	List<Itinerarioconveniomarco> selectDynamicFull(Itinerarioconveniomarco record) throws Exception;

	List<Itinerarioconveniomarco> selectDynamicExtended(Itinerarioconveniomarco record) throws Exception;


}
