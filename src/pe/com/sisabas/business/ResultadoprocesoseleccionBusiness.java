package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Resultadoprocesoseleccion;

public interface ResultadoprocesoseleccionBusiness{

	public void deleteByPrimaryKeyBasic(Resultadoprocesoseleccion par_record) throws Exception;

	public void insertBasic(Resultadoprocesoseleccion record) throws Exception;

	public void insertFull(Resultadoprocesoseleccion record) throws Exception;

	public void insertSelectiveBasic(Resultadoprocesoseleccion record) throws Exception;

	public Resultadoprocesoseleccion selectByPrimaryKeyBasic(java.lang.Integer par_idresultadoproceso) throws Exception;

	public Resultadoprocesoseleccion selectByPrimaryKeyBasicFromList(java.lang.Integer par_idresultadoproceso,List<Resultadoprocesoseleccion> list) throws Exception;

	public Resultadoprocesoseleccion selectByPrimaryKeyBasicActive(java.lang.Integer par_idresultadoproceso) throws Exception;

	public Resultadoprocesoseleccion selectByPrimaryKeyFull(java.lang.Integer par_idresultadoproceso) throws Exception;

	public Resultadoprocesoseleccion selectByPrimaryKeyFullActive(java.lang.Integer par_idresultadoproceso) throws Exception;

	public List<Resultadoprocesoseleccion> selectDynamicBasic(Resultadoprocesoseleccion record) throws Exception;

	public List<Resultadoprocesoseleccion> selectDynamicBasicActives(Resultadoprocesoseleccion record) throws Exception;

	public List<Resultadoprocesoseleccion> selectDynamicFull(Resultadoprocesoseleccion record) throws Exception;

	public List<Resultadoprocesoseleccion> selectDynamicFullActives(Resultadoprocesoseleccion record) throws Exception;

	public List<Resultadoprocesoseleccion> selectDynamicExtended(Resultadoprocesoseleccion record) throws Exception;

	public List<Resultadoprocesoseleccion> selectDynamicExtendedActives(Resultadoprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Resultadoprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Resultadoprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeyBasic(Resultadoprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeyFull(Resultadoprocesoseleccion record) throws Exception;


}
