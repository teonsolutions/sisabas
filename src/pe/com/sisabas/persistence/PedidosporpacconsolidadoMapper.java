
package pe.com.sisabas.persistence;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.com.sisabas.be.Pedidosporpacconsolidado;

public interface PedidosporpacconsolidadoMapper{

	int deleteByPrimaryKey(@Param("idpedidoporpacconsolidado") java.lang.Integer idpedidoporpacconsolidado) throws Exception;

	Pedidosporpacconsolidado selectByPrimaryKeyBasic(@Param("idpedidoporpacconsolidado") java.lang.Integer idpedidoporpacconsolidado) throws Exception;

	Pedidosporpacconsolidado selectByPrimaryKeyBasicActive(@Param("idpedidoporpacconsolidado") java.lang.Integer idpedidoporpacconsolidado) throws Exception;

	Pedidosporpacconsolidado selectByPrimaryKeyFull(@Param("idpedidoporpacconsolidado") java.lang.Integer idpedidoporpacconsolidado) throws Exception;

	Pedidosporpacconsolidado selectByPrimaryKeyFullActive(@Param("idpedidoporpacconsolidado") java.lang.Integer idpedidoporpacconsolidado) throws Exception;

	int updateByPrimaryKeySelective(Pedidosporpacconsolidado record) throws Exception;

	int updateByPrimaryKey(Pedidosporpacconsolidado record) throws Exception;

	int insert(Pedidosporpacconsolidado record) throws Exception;

	int insertSelective(Pedidosporpacconsolidado record) throws Exception;

	List<Pedidosporpacconsolidado> selectDynamicBasic(Pedidosporpacconsolidado record) throws Exception;

	List<Pedidosporpacconsolidado> selectDynamicFull(Pedidosporpacconsolidado record) throws Exception;

	List<Pedidosporpacconsolidado> selectDynamicExtended(Pedidosporpacconsolidado record) throws Exception;


}
