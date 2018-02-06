package pe.com.sisabas.business;

import java.util.List;
import pe.com.sisabas.be.Convocatoriaprocesoseleccion;

public interface ConvocatoriaprocesoseleccionBusiness {

	public void deleteByPrimaryKeyBasic(Convocatoriaprocesoseleccion par_record) throws Exception;

	public void insertBasic(Convocatoriaprocesoseleccion record) throws Exception;

	public void insertFull(Convocatoriaprocesoseleccion record) throws Exception;

	public void insertSelectiveBasic(Convocatoriaprocesoseleccion record) throws Exception;

	public Convocatoriaprocesoseleccion selectByPrimaryKeyBasic(java.lang.Integer par_idconvocatoriaproceso)
			throws Exception;

	public Convocatoriaprocesoseleccion selectByPrimaryKeyBasicFromList(java.lang.Integer par_idconvocatoriaproceso,
			List<Convocatoriaprocesoseleccion> list) throws Exception;

	public Convocatoriaprocesoseleccion selectByPrimaryKeyBasicActive(java.lang.Integer par_idconvocatoriaproceso)
			throws Exception;

	public Convocatoriaprocesoseleccion selectByPrimaryKeyFull(java.lang.Integer par_idconvocatoriaproceso)
			throws Exception;

	public Convocatoriaprocesoseleccion selectByPrimaryKeyFullActive(java.lang.Integer par_idconvocatoriaproceso)
			throws Exception;

	public List<Convocatoriaprocesoseleccion> selectDynamicBasic(Convocatoriaprocesoseleccion record) throws Exception;

	public List<Convocatoriaprocesoseleccion> selectDynamicBasicActives(Convocatoriaprocesoseleccion record)
			throws Exception;

	public List<Convocatoriaprocesoseleccion> selectDynamicFull(Convocatoriaprocesoseleccion record) throws Exception;

	public List<Convocatoriaprocesoseleccion> selectDynamicFullActives(Convocatoriaprocesoseleccion record)
			throws Exception;

	public List<Convocatoriaprocesoseleccion> selectDynamicExtended(Convocatoriaprocesoseleccion record)
			throws Exception;

	public List<Convocatoriaprocesoseleccion> selectDynamicExtendedActives(Convocatoriaprocesoseleccion record)
			throws Exception;

	public void updateByPrimaryKeySelectiveBasic(Convocatoriaprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeySelectiveFull(Convocatoriaprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeyBasic(Convocatoriaprocesoseleccion record) throws Exception;

	public void updateByPrimaryKeyFull(Convocatoriaprocesoseleccion record) throws Exception;

	// Custom
	public List<Convocatoriaprocesoseleccion> selectByIdProceso(Integer idProcesoSeleccion) throws Exception;

}
