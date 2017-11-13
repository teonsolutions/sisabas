package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Vispedido;

public interface VispedidoBusiness{

	public void deleteByPrimaryKeyBasic(Vispedido par_record) throws Exception;

	public void insertBasic(Vispedido record) throws Exception;

	public void insertFull(Vispedido record) throws Exception;

	public void insertSelectiveBasic(Vispedido record) throws Exception;

	public Vispedido selectByPrimaryKeyBasic(java.lang.Integer par_idvpedido) throws Exception;

	public Vispedido selectByPrimaryKeyBasicFromList(java.lang.Integer par_idvpedido,List<Vispedido> list) throws Exception;

	public Vispedido selectByPrimaryKeyBasicActive(java.lang.Integer par_idvpedido) throws Exception;

	public Vispedido selectByPrimaryKeyFull(java.lang.Integer par_idvpedido) throws Exception;

	public Vispedido selectByPrimaryKeyFullActive(java.lang.Integer par_idvpedido) throws Exception;

	public List<Vispedido> selectDynamicBasic(Vispedido record) throws Exception;

	public List<Vispedido> selectDynamicBasicActives(Vispedido record) throws Exception;

	public List<Vispedido> selectDynamicFull(Vispedido record) throws Exception;

	public List<Vispedido> selectDynamicFullActives(Vispedido record) throws Exception;

	public List<Vispedido> selectDynamicExtended(Vispedido record) throws Exception;

	public List<Vispedido> selectDynamicExtendedActives(Vispedido record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Vispedido record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Vispedido record) throws Exception;

	public void updateByPrimaryKeyBasic(Vispedido record) throws Exception;

	public void updateByPrimaryKeyFull(Vispedido record) throws Exception;


}
