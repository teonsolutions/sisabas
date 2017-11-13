
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Estadosporetapapordocumento;

public interface EstadosporetapapordocumentoMapper{

	int deleteByPrimaryKey(@Param("idestadosporetapapordocumento") java.lang.Integer idestadosporetapapordocumento) throws Exception;

	Estadosporetapapordocumento selectByPrimaryKeyBasic(@Param("idestadosporetapapordocumento") java.lang.Integer idestadosporetapapordocumento) throws Exception;

	Estadosporetapapordocumento selectByPrimaryKeyBasicActive(@Param("idestadosporetapapordocumento") java.lang.Integer idestadosporetapapordocumento) throws Exception;

	Estadosporetapapordocumento selectByPrimaryKeyFull(@Param("idestadosporetapapordocumento") java.lang.Integer idestadosporetapapordocumento) throws Exception;

	Estadosporetapapordocumento selectByPrimaryKeyFullActive(@Param("idestadosporetapapordocumento") java.lang.Integer idestadosporetapapordocumento) throws Exception;

	int updateByPrimaryKeySelective(Estadosporetapapordocumento record) throws Exception;

	int updateByPrimaryKey(Estadosporetapapordocumento record) throws Exception;

	int insert(Estadosporetapapordocumento record) throws Exception;

	int insertSelective(Estadosporetapapordocumento record) throws Exception;

	List<Estadosporetapapordocumento> selectDynamicBasic(Estadosporetapapordocumento record) throws Exception;

	List<Estadosporetapapordocumento> selectDynamicFull(Estadosporetapapordocumento record) throws Exception;

	List<Estadosporetapapordocumento> selectDynamicExtended(Estadosporetapapordocumento record) throws Exception;


}
