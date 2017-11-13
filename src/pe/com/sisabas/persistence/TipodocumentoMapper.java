
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Tipodocumento;

public interface TipodocumentoMapper{

	int deleteByPrimaryKey(@Param("idtipodocumento") java.lang.Integer idtipodocumento) throws Exception;

	Tipodocumento selectByPrimaryKeyBasic(@Param("idtipodocumento") java.lang.Integer idtipodocumento) throws Exception;

	Tipodocumento selectByPrimaryKeyBasicActive(@Param("idtipodocumento") java.lang.Integer idtipodocumento) throws Exception;

	Tipodocumento selectByPrimaryKeyFull(@Param("idtipodocumento") java.lang.Integer idtipodocumento) throws Exception;

	Tipodocumento selectByPrimaryKeyFullActive(@Param("idtipodocumento") java.lang.Integer idtipodocumento) throws Exception;

	int updateByPrimaryKeySelective(Tipodocumento record) throws Exception;

	int updateByPrimaryKey(Tipodocumento record) throws Exception;

	int insert(Tipodocumento record) throws Exception;

	int insertSelective(Tipodocumento record) throws Exception;

	List<Tipodocumento> selectDynamicBasic(Tipodocumento record) throws Exception;

	List<Tipodocumento> selectDynamicFull(Tipodocumento record) throws Exception;

	List<Tipodocumento> selectDynamicExtended(Tipodocumento record) throws Exception;


}
