
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Detallepedido;

public interface DetallepedidoMapper{

	int deleteByPrimaryKey(@Param("iddetallepedido") java.lang.Integer iddetallepedido) throws Exception;

	Detallepedido selectByPrimaryKeyBasic(@Param("iddetallepedido") java.lang.Integer iddetallepedido) throws Exception;

	Detallepedido selectByPrimaryKeyBasicActive(@Param("iddetallepedido") java.lang.Integer iddetallepedido) throws Exception;

	Detallepedido selectByPrimaryKeyFull(@Param("iddetallepedido") java.lang.Integer iddetallepedido) throws Exception;

	Detallepedido selectByPrimaryKeyFullActive(@Param("iddetallepedido") java.lang.Integer iddetallepedido) throws Exception;

	int updateByPrimaryKeySelective(Detallepedido record) throws Exception;

	int updateByPrimaryKey(Detallepedido record) throws Exception;

	int insert(Detallepedido record) throws Exception;

	int insertSelective(Detallepedido record) throws Exception;

	List<Detallepedido> selectDynamicBasic(Detallepedido record) throws Exception;

	List<Detallepedido> selectDynamicFull(Detallepedido record) throws Exception;

	List<Detallepedido> selectDynamicExtended(Detallepedido record) throws Exception;


}
