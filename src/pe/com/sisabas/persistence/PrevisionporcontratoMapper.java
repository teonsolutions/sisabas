
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Previsionporcontrato;

public interface PrevisionporcontratoMapper{

	int deleteByPrimaryKey(@Param("idprevisionporcontrato") java.lang.Integer idprevisionporcontrato) throws Exception;

	Previsionporcontrato selectByPrimaryKeyBasic(@Param("idprevisionporcontrato") java.lang.Integer idprevisionporcontrato) throws Exception;

	Previsionporcontrato selectByPrimaryKeyBasicActive(@Param("idprevisionporcontrato") java.lang.Integer idprevisionporcontrato) throws Exception;

	Previsionporcontrato selectByPrimaryKeyFull(@Param("idprevisionporcontrato") java.lang.Integer idprevisionporcontrato) throws Exception;

	Previsionporcontrato selectByPrimaryKeyFullActive(@Param("idprevisionporcontrato") java.lang.Integer idprevisionporcontrato) throws Exception;

	int updateByPrimaryKeySelective(Previsionporcontrato record) throws Exception;

	int updateByPrimaryKey(Previsionporcontrato record) throws Exception;

	int insert(Previsionporcontrato record) throws Exception;

	int insertSelective(Previsionporcontrato record) throws Exception;

	List<Previsionporcontrato> selectDynamicBasic(Previsionporcontrato record) throws Exception;

	List<Previsionporcontrato> selectDynamicFull(Previsionporcontrato record) throws Exception;

	List<Previsionporcontrato> selectDynamicExtended(Previsionporcontrato record) throws Exception;


}
