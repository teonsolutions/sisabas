
package pe.com.sisabas.business.impl;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sisabas.be.Procesoseleccion;
import pe.com.sisabas.persistence.ProcesoseleccionMapper;
import pe.com.sisabas.business.ProcesoseleccionBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class ProcesoseleccionBusinessImpl implements ProcesoseleccionBusiness, Serializable{

	private static Logger logger=Logger.getLogger(ProcesoseleccionBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public ProcesoseleccionMapper procesoseleccionMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Procesoseleccion par_record) throws Exception {
		validateDelete(par_record.getIdprocesoseleccion());
		procesoseleccionMapper.deleteByPrimaryKey(par_record.getIdprocesoseleccion());
	}

	@Override
	public void insertBasic(Procesoseleccion record) throws Exception {
		record.setIdprocesoseleccion((int)utilsBusiness.getNextSeq(Sequence.SEQ_PROCESOSELECCION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		procesoseleccionMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Procesoseleccion record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Procesoseleccion record) throws Exception {
		record.setIdprocesoseleccion((int)utilsBusiness.getNextSeq(Sequence.SEQ_PROCESOSELECCION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		procesoseleccionMapper.insertSelective(record);
	}

	@Override
	public Procesoseleccion selectByPrimaryKeyBasic(java.lang.Integer par_idprocesoseleccion) throws Exception {
		return procesoseleccionMapper.selectByPrimaryKeyBasic(par_idprocesoseleccion);
	}

	@Override
	public Procesoseleccion selectByPrimaryKeyBasicFromList(java.lang.Integer par_idprocesoseleccion, List<Procesoseleccion> list) throws Exception {
		Procesoseleccion record=null;
		for (Procesoseleccion row : list) {
			if(row.equals(new Procesoseleccion( par_idprocesoseleccion))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idprocesoseleccion);

		return record;
	}

	@Override
	public Procesoseleccion selectByPrimaryKeyBasicActive(java.lang.Integer par_idprocesoseleccion) throws Exception {
		return procesoseleccionMapper.selectByPrimaryKeyBasicActive(par_idprocesoseleccion);
	}

	@Override
	public Procesoseleccion selectByPrimaryKeyFull(java.lang.Integer par_idprocesoseleccion) throws Exception {
		return procesoseleccionMapper.selectByPrimaryKeyFull(par_idprocesoseleccion);
	}

	@Override
	public Procesoseleccion selectByPrimaryKeyFullActive(java.lang.Integer par_idprocesoseleccion) throws Exception {
		return procesoseleccionMapper.selectByPrimaryKeyFullActive(par_idprocesoseleccion);
	}

	@Override
	public List<Procesoseleccion> selectDynamicBasic(Procesoseleccion record) throws Exception {
		return procesoseleccionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Procesoseleccion> selectDynamicBasicActives(Procesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return procesoseleccionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Procesoseleccion> selectDynamicFull(Procesoseleccion record) throws Exception {
		List<Procesoseleccion> list=procesoseleccionMapper.selectDynamicFull(record);
		if(Procesoseleccion.HAVE_BIGDECIMALS)
		for (Procesoseleccion row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Procesoseleccion> selectDynamicFullActives(Procesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return procesoseleccionMapper.selectDynamicFull(record);
	}

	@Override
	public List<Procesoseleccion> selectDynamicExtended(Procesoseleccion record) throws Exception {
		return procesoseleccionMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Procesoseleccion> selectDynamicExtendedActives(Procesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return procesoseleccionMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Procesoseleccion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		procesoseleccionMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Procesoseleccion record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Procesoseleccion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		procesoseleccionMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Procesoseleccion record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Procesoseleccion record) throws Exception {
	}

	public void validateInsert(Procesoseleccion record)throws Exception{
		if(record.getIdprocesoseleccion()==null)
			throw new ValidateException(Messages.getString("procesoseleccion.idprocesoseleccion.required"));
		if(record.getIdpacconsolidado()==null)
			throw new ValidateException(Messages.getString("procesoseleccion.idpacconsolidado.required"));

		if(record.getCodigotipoproceso()!=null &&  record.getCodigotipoproceso().length() > 2)
			throw new ValidateException(Messages.getString("procesoseleccion.codigotipoproceso.length.error",record.getCodigotipoproceso().length()));
		if(record.getDescripcionprocesoseleccion()!=null &&  record.getDescripcionprocesoseleccion().length() > 250)
			throw new ValidateException(Messages.getString("procesoseleccion.descripcionprocesoseleccion.length.error",record.getDescripcionprocesoseleccion().length()));
		if(record.getIdcatalogotipomodalidad()!=null &&  record.getIdcatalogotipomodalidad().length() > 10)
			throw new ValidateException(Messages.getString("procesoseleccion.idcatalogotipomodalidad.length.error",record.getIdcatalogotipomodalidad().length()));
		if(record.getDniespecialidadproceso()!=null &&  record.getDniespecialidadproceso().length() > 8)
			throw new ValidateException(Messages.getString("procesoseleccion.dniespecialidadproceso.length.error",record.getDniespecialidadproceso().length()));
		if(record.getNombreexpecialistaproceso()!=null &&  record.getNombreexpecialistaproceso().length() > 300)
			throw new ValidateException(Messages.getString("procesoseleccion.nombreexpecialistaproceso.length.error",record.getNombreexpecialistaproceso().length()));
		if(record.getNroactaproyectobase()!=null &&  record.getNroactaproyectobase().length() > 50)
			throw new ValidateException(Messages.getString("procesoseleccion.nroactaproyectobase.length.error",record.getNroactaproyectobase().length()));
		if(record.getObservacionesproyectobases()!=null &&  record.getObservacionesproyectobases().length() > 500)
			throw new ValidateException(Messages.getString("procesoseleccion.observacionesproyectobases.length.error",record.getObservacionesproyectobases().length()));
		if(record.getModalidadejecucion()!=null &&  record.getModalidadejecucion().length() > 1)
			throw new ValidateException(Messages.getString("procesoseleccion.modalidadejecucion.length.error",record.getModalidadejecucion().length()));
		if(record.getObservaciones()!=null &&  record.getObservaciones().length() > 500)
			throw new ValidateException(Messages.getString("procesoseleccion.observaciones.length.error",record.getObservaciones().length()));
		if(record.getComitenotificado()!=null &&  record.getComitenotificado().length() > 1)
			throw new ValidateException(Messages.getString("procesoseleccion.comitenotificado.length.error",record.getComitenotificado().length()));
		if(record.getIdcatalogosistemacontratacion()!=null &&  record.getIdcatalogosistemacontratacion().length() > 10)
			throw new ValidateException(Messages.getString("procesoseleccion.idcatalogosistemacontratacion.length.error",record.getIdcatalogosistemacontratacion().length()));
		if(record.getComiterecompuesto()!=null &&  record.getComiterecompuesto().length() > 1)
			throw new ValidateException(Messages.getString("procesoseleccion.comiterecompuesto.length.error",record.getComiterecompuesto().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("procesoseleccion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("procesoseleccion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("procesoseleccion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("procesoseleccion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("procesoseleccion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Procesoseleccion record)throws Exception{
		if(record.getIdprocesoseleccion()==null)
			throw new ValidateException(Messages.getString("procesoseleccion.idprocesoseleccion.required"));
		if(record.getIdpacconsolidado()==null)
			throw new ValidateException(Messages.getString("procesoseleccion.idpacconsolidado.required"));

		if(record.getCodigotipoproceso()!=null &&  record.getCodigotipoproceso().length() > 2)
			throw new ValidateException(Messages.getString("procesoseleccion.codigotipoproceso.length.error",record.getCodigotipoproceso().length()));
		if(record.getDescripcionprocesoseleccion()!=null &&  record.getDescripcionprocesoseleccion().length() > 250)
			throw new ValidateException(Messages.getString("procesoseleccion.descripcionprocesoseleccion.length.error",record.getDescripcionprocesoseleccion().length()));
		if(record.getIdcatalogotipomodalidad()!=null &&  record.getIdcatalogotipomodalidad().length() > 10)
			throw new ValidateException(Messages.getString("procesoseleccion.idcatalogotipomodalidad.length.error",record.getIdcatalogotipomodalidad().length()));
		if(record.getDniespecialidadproceso()!=null &&  record.getDniespecialidadproceso().length() > 8)
			throw new ValidateException(Messages.getString("procesoseleccion.dniespecialidadproceso.length.error",record.getDniespecialidadproceso().length()));
		if(record.getNombreexpecialistaproceso()!=null &&  record.getNombreexpecialistaproceso().length() > 300)
			throw new ValidateException(Messages.getString("procesoseleccion.nombreexpecialistaproceso.length.error",record.getNombreexpecialistaproceso().length()));
		if(record.getNroactaproyectobase()!=null &&  record.getNroactaproyectobase().length() > 50)
			throw new ValidateException(Messages.getString("procesoseleccion.nroactaproyectobase.length.error",record.getNroactaproyectobase().length()));
		if(record.getObservacionesproyectobases()!=null &&  record.getObservacionesproyectobases().length() > 500)
			throw new ValidateException(Messages.getString("procesoseleccion.observacionesproyectobases.length.error",record.getObservacionesproyectobases().length()));
		if(record.getModalidadejecucion()!=null &&  record.getModalidadejecucion().length() > 1)
			throw new ValidateException(Messages.getString("procesoseleccion.modalidadejecucion.length.error",record.getModalidadejecucion().length()));
		if(record.getObservaciones()!=null &&  record.getObservaciones().length() > 500)
			throw new ValidateException(Messages.getString("procesoseleccion.observaciones.length.error",record.getObservaciones().length()));
		if(record.getComitenotificado()!=null &&  record.getComitenotificado().length() > 1)
			throw new ValidateException(Messages.getString("procesoseleccion.comitenotificado.length.error",record.getComitenotificado().length()));
		if(record.getIdcatalogosistemacontratacion()!=null &&  record.getIdcatalogosistemacontratacion().length() > 10)
			throw new ValidateException(Messages.getString("procesoseleccion.idcatalogosistemacontratacion.length.error",record.getIdcatalogosistemacontratacion().length()));
		if(record.getComiterecompuesto()!=null &&  record.getComiterecompuesto().length() > 1)
			throw new ValidateException(Messages.getString("procesoseleccion.comiterecompuesto.length.error",record.getComiterecompuesto().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("procesoseleccion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("procesoseleccion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("procesoseleccion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("procesoseleccion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("procesoseleccion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idprocesoseleccion)throws Exception{
		if(par_idprocesoseleccion==null)
			throw new ValidateException(Messages.getString("procesoseleccion.idprocesoseleccion.required"));

		//Here Bussines Validations.
	}


}

