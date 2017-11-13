
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Previsionpresupuestal;

public interface PrevisionpresupuestalMapper{

	int deleteByPrimaryKey(@Param("idprevisionpresupuestal") java.lang.Integer idprevisionpresupuestal) throws Exception;

	Previsionpresupuestal selectByPrimaryKeyBasic(@Param("idprevisionpresupuestal") java.lang.Integer idprevisionpresupuestal) throws Exception;

	Previsionpresupuestal selectByPrimaryKeyBasicActive(@Param("idprevisionpresupuestal") java.lang.Integer idprevisionpresupuestal) throws Exception;

	Previsionpresupuestal selectByPrimaryKeyFull(@Param("idprevisionpresupuestal") java.lang.Integer idprevisionpresupuestal) throws Exception;

	Previsionpresupuestal selectByPrimaryKeyFullActive(@Param("idprevisionpresupuestal") java.lang.Integer idprevisionpresupuestal) throws Exception;

	int updateByPrimaryKeySelective(Previsionpresupuestal record) throws Exception;

	int updateByPrimaryKey(Previsionpresupuestal record) throws Exception;

	int insert(Previsionpresupuestal record) throws Exception;

	int insertSelective(Previsionpresupuestal record) throws Exception;

	List<Previsionpresupuestal> selectDynamicBasic(Previsionpresupuestal record) throws Exception;

	List<Previsionpresupuestal> selectDynamicFull(Previsionpresupuestal record) throws Exception;

	List<Previsionpresupuestal> selectDynamicExtended(Previsionpresupuestal record) throws Exception;


}
