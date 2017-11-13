
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Estadospordocumentosiga;

public interface EstadospordocumentosigaMapper{

	int deleteByPrimaryKey(@Param("idestadospordocumentosiga") java.lang.Integer idestadospordocumentosiga) throws Exception;

	Estadospordocumentosiga selectByPrimaryKeyBasic(@Param("idestadospordocumentosiga") java.lang.Integer idestadospordocumentosiga) throws Exception;

	Estadospordocumentosiga selectByPrimaryKeyBasicActive(@Param("idestadospordocumentosiga") java.lang.Integer idestadospordocumentosiga) throws Exception;

	Estadospordocumentosiga selectByPrimaryKeyFull(@Param("idestadospordocumentosiga") java.lang.Integer idestadospordocumentosiga) throws Exception;

	Estadospordocumentosiga selectByPrimaryKeyFullActive(@Param("idestadospordocumentosiga") java.lang.Integer idestadospordocumentosiga) throws Exception;

	int updateByPrimaryKeySelective(Estadospordocumentosiga record) throws Exception;

	int updateByPrimaryKey(Estadospordocumentosiga record) throws Exception;

	int insert(Estadospordocumentosiga record) throws Exception;

	int insertSelective(Estadospordocumentosiga record) throws Exception;

	List<Estadospordocumentosiga> selectDynamicBasic(Estadospordocumentosiga record) throws Exception;

	List<Estadospordocumentosiga> selectDynamicFull(Estadospordocumentosiga record) throws Exception;

	List<Estadospordocumentosiga> selectDynamicExtended(Estadospordocumentosiga record) throws Exception;


}
