
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Etapagestionadministrativa;

public interface EtapagestionadministrativaMapper{

	int deleteByPrimaryKey(@Param("idetapaadministrativa") java.lang.Integer idetapaadministrativa) throws Exception;

	Etapagestionadministrativa selectByPrimaryKeyBasic(@Param("idetapaadministrativa") java.lang.Integer idetapaadministrativa) throws Exception;

	Etapagestionadministrativa selectByPrimaryKeyBasicActive(@Param("idetapaadministrativa") java.lang.Integer idetapaadministrativa) throws Exception;

	Etapagestionadministrativa selectByPrimaryKeyFull(@Param("idetapaadministrativa") java.lang.Integer idetapaadministrativa) throws Exception;

	Etapagestionadministrativa selectByPrimaryKeyFullActive(@Param("idetapaadministrativa") java.lang.Integer idetapaadministrativa) throws Exception;

	int updateByPrimaryKeySelective(Etapagestionadministrativa record) throws Exception;

	int updateByPrimaryKey(Etapagestionadministrativa record) throws Exception;

	int insert(Etapagestionadministrativa record) throws Exception;

	int insertSelective(Etapagestionadministrativa record) throws Exception;

	List<Etapagestionadministrativa> selectDynamicBasic(Etapagestionadministrativa record) throws Exception;

	List<Etapagestionadministrativa> selectDynamicFull(Etapagestionadministrativa record) throws Exception;

	List<Etapagestionadministrativa> selectDynamicExtended(Etapagestionadministrativa record) throws Exception;


}
