
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Grupodocumento;

public interface GrupodocumentoMapper{

	int deleteByPrimaryKey(@Param("idgrupodocumento") java.lang.Integer idgrupodocumento) throws Exception;

	Grupodocumento selectByPrimaryKeyBasic(@Param("idgrupodocumento") java.lang.Integer idgrupodocumento) throws Exception;

	Grupodocumento selectByPrimaryKeyBasicActive(@Param("idgrupodocumento") java.lang.Integer idgrupodocumento) throws Exception;

	Grupodocumento selectByPrimaryKeyFull(@Param("idgrupodocumento") java.lang.Integer idgrupodocumento) throws Exception;

	Grupodocumento selectByPrimaryKeyFullActive(@Param("idgrupodocumento") java.lang.Integer idgrupodocumento) throws Exception;

	int updateByPrimaryKeySelective(Grupodocumento record) throws Exception;

	int updateByPrimaryKey(Grupodocumento record) throws Exception;

	int insert(Grupodocumento record) throws Exception;

	int insertSelective(Grupodocumento record) throws Exception;

	List<Grupodocumento> selectDynamicBasic(Grupodocumento record) throws Exception;

	List<Grupodocumento> selectDynamicFull(Grupodocumento record) throws Exception;

	List<Grupodocumento> selectDynamicExtended(Grupodocumento record) throws Exception;


}
