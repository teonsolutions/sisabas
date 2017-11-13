
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Pedido;

public interface PedidoMapper{

	int deleteByPrimaryKey(@Param("idpedido") java.lang.Integer idpedido) throws Exception;

	Pedido selectByPrimaryKeyBasic(@Param("idpedido") java.lang.Integer idpedido) throws Exception;

	Pedido selectByPrimaryKeyBasicActive(@Param("idpedido") java.lang.Integer idpedido) throws Exception;

	Pedido selectByPrimaryKeyFull(@Param("idpedido") java.lang.Integer idpedido) throws Exception;

	Pedido selectByPrimaryKeyFullActive(@Param("idpedido") java.lang.Integer idpedido) throws Exception;

	int updateByPrimaryKeySelective(Pedido record) throws Exception;

	int updateByPrimaryKey(Pedido record) throws Exception;

	int insert(Pedido record) throws Exception;

	int insertSelective(Pedido record) throws Exception;

	List<Pedido> selectDynamicBasic(Pedido record) throws Exception;

	List<Pedido> selectDynamicFull(Pedido record) throws Exception;

	List<Pedido> selectDynamicExtended(Pedido record) throws Exception;


}
