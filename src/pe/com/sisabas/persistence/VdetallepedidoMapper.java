
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Vdetallepedido;

public interface VdetallepedidoMapper{

	int deleteByPrimaryKey(@Param("idvdetallepedido") java.lang.Integer idvdetallepedido) throws Exception;

	Vdetallepedido selectByPrimaryKeyBasic(@Param("idvdetallepedido") java.lang.Integer idvdetallepedido) throws Exception;

	Vdetallepedido selectByPrimaryKeyBasicActive(@Param("idvdetallepedido") java.lang.Integer idvdetallepedido) throws Exception;

	Vdetallepedido selectByPrimaryKeyFull(@Param("idvdetallepedido") java.lang.Integer idvdetallepedido) throws Exception;

	Vdetallepedido selectByPrimaryKeyFullActive(@Param("idvdetallepedido") java.lang.Integer idvdetallepedido) throws Exception;

	int updateByPrimaryKeySelective(Vdetallepedido record) throws Exception;

	int updateByPrimaryKey(Vdetallepedido record) throws Exception;

	int insert(Vdetallepedido record) throws Exception;

	int insertSelective(Vdetallepedido record) throws Exception;

	List<Vdetallepedido> selectDynamicBasic(Vdetallepedido record) throws Exception;

	List<Vdetallepedido> selectDynamicFull(Vdetallepedido record) throws Exception;

	List<Vdetallepedido> selectDynamicExtended(Vdetallepedido record) throws Exception;


}
