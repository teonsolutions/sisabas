package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Detallepedido;

public interface DetallepedidoBusiness{

	public void deleteByPrimaryKeyBasic(Detallepedido par_record) throws Exception;

	public void insertBasic(Detallepedido record) throws Exception;

	public void insertFull(Detallepedido record) throws Exception;

	public void insertSelectiveBasic(Detallepedido record) throws Exception;

	public Detallepedido selectByPrimaryKeyBasic(java.lang.Integer par_iddetallepedido) throws Exception;

	public Detallepedido selectByPrimaryKeyBasicFromList(java.lang.Integer par_iddetallepedido,List<Detallepedido> list) throws Exception;

	public Detallepedido selectByPrimaryKeyBasicActive(java.lang.Integer par_iddetallepedido) throws Exception;

	public Detallepedido selectByPrimaryKeyFull(java.lang.Integer par_iddetallepedido) throws Exception;

	public Detallepedido selectByPrimaryKeyFullActive(java.lang.Integer par_iddetallepedido) throws Exception;

	public List<Detallepedido> selectDynamicBasic(Detallepedido record) throws Exception;

	public List<Detallepedido> selectDynamicBasicActives(Detallepedido record) throws Exception;

	public List<Detallepedido> selectDynamicFull(Detallepedido record) throws Exception;

	public List<Detallepedido> selectDynamicFullActives(Detallepedido record) throws Exception;

	public List<Detallepedido> selectDynamicExtended(Detallepedido record) throws Exception;

	public List<Detallepedido> selectDynamicExtendedActives(Detallepedido record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Detallepedido record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Detallepedido record) throws Exception;

	public void updateByPrimaryKeyBasic(Detallepedido record) throws Exception;

	public void updateByPrimaryKeyFull(Detallepedido record) throws Exception;


}
