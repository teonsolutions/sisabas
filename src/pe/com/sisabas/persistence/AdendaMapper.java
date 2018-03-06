
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Adenda;

public interface AdendaMapper{

	int deleteByPrimaryKey(@Param("idadenda") java.lang.Integer idadenda) throws Exception;

	Adenda selectByPrimaryKeyBasic(@Param("idadenda") java.lang.Integer idadenda) throws Exception;

	Adenda selectByPrimaryKeyBasicActive(@Param("idadenda") java.lang.Integer idadenda) throws Exception;

	Adenda selectByPrimaryKeyFull(@Param("idadenda") java.lang.Integer idadenda) throws Exception;

	Adenda selectByPrimaryKeyFullActive(@Param("idadenda") java.lang.Integer idadenda) throws Exception;

	int updateByPrimaryKeySelective(Adenda record) throws Exception;

	int updateByPrimaryKey(Adenda record) throws Exception;

	int insert(Adenda record) throws Exception;

	int insertSelective(Adenda record) throws Exception;

	List<Adenda> selectDynamicBasic(Adenda record) throws Exception;

	List<Adenda> selectDynamicFull(Adenda record) throws Exception;

	List<Adenda> selectDynamicExtended(Adenda record) throws Exception;
    
	List<Adenda> getAdendaByIdContrato(@Param("idContrato") java.lang.Integer idContrato) throws Exception;

}
