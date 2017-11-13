package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Pedidosporpacconsolidado;

public interface PedidosporpacconsolidadoBusiness{

	public void deleteByPrimaryKeyBasic(Pedidosporpacconsolidado par_record) throws Exception;

	public void insertBasic(Pedidosporpacconsolidado record) throws Exception;

	public void insertFull(Pedidosporpacconsolidado record) throws Exception;

	public void insertSelectiveBasic(Pedidosporpacconsolidado record) throws Exception;

	public Pedidosporpacconsolidado selectByPrimaryKeyBasic(java.lang.Integer par_idpedidoporpacconsolidado) throws Exception;

	public Pedidosporpacconsolidado selectByPrimaryKeyBasicFromList(java.lang.Integer par_idpedidoporpacconsolidado,List<Pedidosporpacconsolidado> list) throws Exception;

	public Pedidosporpacconsolidado selectByPrimaryKeyBasicActive(java.lang.Integer par_idpedidoporpacconsolidado) throws Exception;

	public Pedidosporpacconsolidado selectByPrimaryKeyFull(java.lang.Integer par_idpedidoporpacconsolidado) throws Exception;

	public Pedidosporpacconsolidado selectByPrimaryKeyFullActive(java.lang.Integer par_idpedidoporpacconsolidado) throws Exception;

	public List<Pedidosporpacconsolidado> selectDynamicBasic(Pedidosporpacconsolidado record) throws Exception;

	public List<Pedidosporpacconsolidado> selectDynamicBasicActives(Pedidosporpacconsolidado record) throws Exception;

	public List<Pedidosporpacconsolidado> selectDynamicFull(Pedidosporpacconsolidado record) throws Exception;

	public List<Pedidosporpacconsolidado> selectDynamicFullActives(Pedidosporpacconsolidado record) throws Exception;

	public List<Pedidosporpacconsolidado> selectDynamicExtended(Pedidosporpacconsolidado record) throws Exception;

	public List<Pedidosporpacconsolidado> selectDynamicExtendedActives(Pedidosporpacconsolidado record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Pedidosporpacconsolidado record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Pedidosporpacconsolidado record) throws Exception;

	public void updateByPrimaryKeyBasic(Pedidosporpacconsolidado record) throws Exception;

	public void updateByPrimaryKeyFull(Pedidosporpacconsolidado record) throws Exception;


}
