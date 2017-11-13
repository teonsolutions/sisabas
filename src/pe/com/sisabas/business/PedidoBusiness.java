package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Pedido;

public interface PedidoBusiness{

	public void deleteByPrimaryKeyBasic(Pedido par_record) throws Exception;

	public void insertBasic(Pedido record) throws Exception;

	public void insertFull(Pedido record) throws Exception;

	public void insertSelectiveBasic(Pedido record) throws Exception;

	public Pedido selectByPrimaryKeyBasic(java.lang.Integer par_idpedido) throws Exception;

	public Pedido selectByPrimaryKeyBasicFromList(java.lang.Integer par_idpedido,List<Pedido> list) throws Exception;

	public Pedido selectByPrimaryKeyBasicActive(java.lang.Integer par_idpedido) throws Exception;

	public Pedido selectByPrimaryKeyFull(java.lang.Integer par_idpedido) throws Exception;

	public Pedido selectByPrimaryKeyFullActive(java.lang.Integer par_idpedido) throws Exception;

	public List<Pedido> selectDynamicBasic(Pedido record) throws Exception;

	public List<Pedido> selectDynamicBasicActives(Pedido record) throws Exception;

	public List<Pedido> selectDynamicFull(Pedido record) throws Exception;

	public List<Pedido> selectDynamicFullActives(Pedido record) throws Exception;

	public List<Pedido> selectDynamicExtended(Pedido record) throws Exception;

	public List<Pedido> selectDynamicExtendedActives(Pedido record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Pedido record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Pedido record) throws Exception;

	public void updateByPrimaryKeyBasic(Pedido record) throws Exception;

	public void updateByPrimaryKeyFull(Pedido record) throws Exception;


}
