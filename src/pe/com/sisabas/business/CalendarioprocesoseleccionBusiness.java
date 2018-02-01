package pe.com.sisabas.business;
import java.util.List;
import pe.com.sisabas.be.Calendarioprocesoseleccion;

public interface CalendarioprocesoseleccionBusiness{

	public void deleteByPrimaryKeyBasic(Calendarioprocesoseleccion par_record) throws Exception;

	public void insertBasic(Calendarioprocesoseleccion record) throws Exception;

	public void insertFull(Calendarioprocesoseleccion record) throws Exception;

	public void insertSelectiveBasic(Calendarioprocesoseleccion record) throws Exception;

	public Calendarioprocesoseleccion selectByPrimaryKeyBasic(java.lang.Integer par_idcalendarioproceso) throws Exception;

	public Calendarioprocesoseleccion selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcalendarioproceso,List<Calendarioprocesoseleccion> list) throws Exception;

	public Calendarioprocesoseleccion selectByPrimaryKeyBasicActive(java.lang.Integer par_idcalendarioproceso) throws Exception;

	public Calendarioprocesoseleccion selectByPrimaryKeyFull(java.lang.Integer par_idcalendarioproceso) throws Exception;

	public Calendarioprocesoseleccion selectByPrimaryKeyFullActive(java.lang.Integer par_idcalendarioproceso) throws Exception;

	public List<Calendarioprocesoseleccion> selectDynamicBasic(Calendarioprocesoseleccion record) throws Exception;

	public List<Calendarioprocesoseleccion> selectDynamicBasicActives(Calendarioprocesoseleccion record) throws Exception;

	public List<Calendarioprocesoseleccion> selectDynamicFull(Calendarioprocesoseleccion record) throws Exception;

	public List<Calendarioprocesoseleccion> selectDynamicFullActives(Calendarioprocesoseleccion record) throws Exception;

	public List<Calendarioprocesoseleccion> selectDynamicExtended(Calendarioprocesoseleccion record) throws Exception;

	public List<Calendarioprocesoseleccion> selectDynamicExtendedActives(Calendarioprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Calendarioprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Calendarioprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeyBasic(Calendarioprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeyFull(Calendarioprocesoseleccion record) throws Exception;


}
