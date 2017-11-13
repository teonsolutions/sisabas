
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Sinadporpacconsolidado;

public interface SinadporpacconsolidadoMapper{

	int deleteByPrimaryKey(@Param("idsinad") java.lang.Integer idsinad) throws Exception;

	Sinadporpacconsolidado selectByPrimaryKeyBasic(@Param("idsinad") java.lang.Integer idsinad) throws Exception;

	Sinadporpacconsolidado selectByPrimaryKeyBasicActive(@Param("idsinad") java.lang.Integer idsinad) throws Exception;

	Sinadporpacconsolidado selectByPrimaryKeyFull(@Param("idsinad") java.lang.Integer idsinad) throws Exception;

	Sinadporpacconsolidado selectByPrimaryKeyFullActive(@Param("idsinad") java.lang.Integer idsinad) throws Exception;

	int updateByPrimaryKeySelective(Sinadporpacconsolidado record) throws Exception;

	int updateByPrimaryKey(Sinadporpacconsolidado record) throws Exception;

	int insert(Sinadporpacconsolidado record) throws Exception;

	int insertSelective(Sinadporpacconsolidado record) throws Exception;

	List<Sinadporpacconsolidado> selectDynamicBasic(Sinadporpacconsolidado record) throws Exception;

	List<Sinadporpacconsolidado> selectDynamicFull(Sinadporpacconsolidado record) throws Exception;

	List<Sinadporpacconsolidado> selectDynamicExtended(Sinadporpacconsolidado record) throws Exception;


}
