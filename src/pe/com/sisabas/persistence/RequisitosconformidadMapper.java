
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Requisitosconformidad;

public interface RequisitosconformidadMapper{

	int deleteByPrimaryKey(@Param("idrequisitoconformidad") java.lang.Integer idrequisitoconformidad) throws Exception;

	Requisitosconformidad selectByPrimaryKeyBasic(@Param("idrequisitoconformidad") java.lang.Integer idrequisitoconformidad) throws Exception;

	Requisitosconformidad selectByPrimaryKeyBasicActive(@Param("idrequisitoconformidad") java.lang.Integer idrequisitoconformidad) throws Exception;

	Requisitosconformidad selectByPrimaryKeyFull(@Param("idrequisitoconformidad") java.lang.Integer idrequisitoconformidad) throws Exception;

	Requisitosconformidad selectByPrimaryKeyFullActive(@Param("idrequisitoconformidad") java.lang.Integer idrequisitoconformidad) throws Exception;

	int updateByPrimaryKeySelective(Requisitosconformidad record) throws Exception;

	int updateByPrimaryKey(Requisitosconformidad record) throws Exception;

	int insert(Requisitosconformidad record) throws Exception;

	int insertSelective(Requisitosconformidad record) throws Exception;

	List<Requisitosconformidad> selectDynamicBasic(Requisitosconformidad record) throws Exception;

	List<Requisitosconformidad> selectDynamicFull(Requisitosconformidad record) throws Exception;

	List<Requisitosconformidad> selectDynamicExtended(Requisitosconformidad record) throws Exception;


}
