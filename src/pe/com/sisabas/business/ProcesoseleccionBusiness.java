package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Procesoseleccion;

public interface ProcesoseleccionBusiness{

	public void deleteByPrimaryKeyBasic(Procesoseleccion par_record) throws Exception;

	public void insertBasic(Procesoseleccion record) throws Exception;

	public void insertFull(Procesoseleccion record) throws Exception;

	public void insertSelectiveBasic(Procesoseleccion record) throws Exception;

	public Procesoseleccion selectByPrimaryKeyBasic(java.lang.Integer par_idprocesoseleccion) throws Exception;

	public Procesoseleccion selectByPrimaryKeyBasicFromList(java.lang.Integer par_idprocesoseleccion,List<Procesoseleccion> list) throws Exception;

	public Procesoseleccion selectByPrimaryKeyBasicActive(java.lang.Integer par_idprocesoseleccion) throws Exception;

	public Procesoseleccion selectByPrimaryKeyFull(java.lang.Integer par_idprocesoseleccion) throws Exception;

	public Procesoseleccion selectByPrimaryKeyFullActive(java.lang.Integer par_idprocesoseleccion) throws Exception;

	public List<Procesoseleccion> selectDynamicBasic(Procesoseleccion record) throws Exception;

	public List<Procesoseleccion> selectDynamicBasicActives(Procesoseleccion record) throws Exception;

	public List<Procesoseleccion> selectDynamicFull(Procesoseleccion record) throws Exception;

	public List<Procesoseleccion> selectDynamicFullActives(Procesoseleccion record) throws Exception;

	public List<Procesoseleccion> selectDynamicExtended(Procesoseleccion record) throws Exception;

	public List<Procesoseleccion> selectDynamicExtendedActives(Procesoseleccion record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Procesoseleccion record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Procesoseleccion record) throws Exception;

	public void updateByPrimaryKeyBasic(Procesoseleccion record) throws Exception;

	public void updateByPrimaryKeyFull(Procesoseleccion record) throws Exception;


}
