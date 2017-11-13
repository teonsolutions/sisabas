package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Vdetallepedido;

public interface VdetallepedidoBusiness{

	public void deleteByPrimaryKeyBasic(Vdetallepedido par_record) throws Exception;

	public void insertBasic(Vdetallepedido record) throws Exception;

	public void insertFull(Vdetallepedido record) throws Exception;

	public void insertSelectiveBasic(Vdetallepedido record) throws Exception;

	public Vdetallepedido selectByPrimaryKeyBasic(java.lang.Integer par_idvdetallepedido) throws Exception;

	public Vdetallepedido selectByPrimaryKeyBasicFromList(java.lang.Integer par_idvdetallepedido,List<Vdetallepedido> list) throws Exception;

	public Vdetallepedido selectByPrimaryKeyBasicActive(java.lang.Integer par_idvdetallepedido) throws Exception;

	public Vdetallepedido selectByPrimaryKeyFull(java.lang.Integer par_idvdetallepedido) throws Exception;

	public Vdetallepedido selectByPrimaryKeyFullActive(java.lang.Integer par_idvdetallepedido) throws Exception;

	public List<Vdetallepedido> selectDynamicBasic(Vdetallepedido record) throws Exception;

	public List<Vdetallepedido> selectDynamicBasicActives(Vdetallepedido record) throws Exception;

	public List<Vdetallepedido> selectDynamicFull(Vdetallepedido record) throws Exception;

	public List<Vdetallepedido> selectDynamicFullActives(Vdetallepedido record) throws Exception;

	public List<Vdetallepedido> selectDynamicExtended(Vdetallepedido record) throws Exception;

	public List<Vdetallepedido> selectDynamicExtendedActives(Vdetallepedido record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Vdetallepedido record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Vdetallepedido record) throws Exception;

	public void updateByPrimaryKeyBasic(Vdetallepedido record) throws Exception;

	public void updateByPrimaryKeyFull(Vdetallepedido record) throws Exception;


}
