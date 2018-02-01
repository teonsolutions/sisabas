
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
import pe.com.sisabas.be.Calendarioprocesoseleccion;
import pe.com.sisabas.persistence.CalendarioprocesoseleccionMapper;
import pe.com.sisabas.business.CalendarioprocesoseleccionBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class CalendarioprocesoseleccionBusinessImpl implements CalendarioprocesoseleccionBusiness, Serializable{

	private static Logger logger=Logger.getLogger(CalendarioprocesoseleccionBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public CalendarioprocesoseleccionMapper calendarioprocesoseleccionMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Calendarioprocesoseleccion par_record) throws Exception {
		validateDelete(par_record.getIdcalendarioproceso());
		calendarioprocesoseleccionMapper.deleteByPrimaryKey(par_record.getIdcalendarioproceso());
	}

	@Override
	public void insertBasic(Calendarioprocesoseleccion record) throws Exception {
		record.setIdcalendarioproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_CALENDARIOPROCESOSELECCION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		calendarioprocesoseleccionMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Calendarioprocesoseleccion record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Calendarioprocesoseleccion record) throws Exception {
		record.setIdcalendarioproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_CALENDARIOPROCESOSELECCION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		calendarioprocesoseleccionMapper.insertSelective(record);
	}

	@Override
	public Calendarioprocesoseleccion selectByPrimaryKeyBasic(java.lang.Integer par_idcalendarioproceso) throws Exception {
		return calendarioprocesoseleccionMapper.selectByPrimaryKeyBasic(par_idcalendarioproceso);
	}

	@Override
	public Calendarioprocesoseleccion selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcalendarioproceso, List<Calendarioprocesoseleccion> list) throws Exception {
		Calendarioprocesoseleccion record=null;
		for (Calendarioprocesoseleccion row : list) {
			if(row.equals(new Calendarioprocesoseleccion( par_idcalendarioproceso))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idcalendarioproceso);

		return record;
	}

	@Override
	public Calendarioprocesoseleccion selectByPrimaryKeyBasicActive(java.lang.Integer par_idcalendarioproceso) throws Exception {
		return calendarioprocesoseleccionMapper.selectByPrimaryKeyBasicActive(par_idcalendarioproceso);
	}

	@Override
	public Calendarioprocesoseleccion selectByPrimaryKeyFull(java.lang.Integer par_idcalendarioproceso) throws Exception {
		return calendarioprocesoseleccionMapper.selectByPrimaryKeyFull(par_idcalendarioproceso);
	}

	@Override
	public Calendarioprocesoseleccion selectByPrimaryKeyFullActive(java.lang.Integer par_idcalendarioproceso) throws Exception {
		return calendarioprocesoseleccionMapper.selectByPrimaryKeyFullActive(par_idcalendarioproceso);
	}

	@Override
	public List<Calendarioprocesoseleccion> selectDynamicBasic(Calendarioprocesoseleccion record) throws Exception {
		return calendarioprocesoseleccionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Calendarioprocesoseleccion> selectDynamicBasicActives(Calendarioprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return calendarioprocesoseleccionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Calendarioprocesoseleccion> selectDynamicFull(Calendarioprocesoseleccion record) throws Exception {
		List<Calendarioprocesoseleccion> list=calendarioprocesoseleccionMapper.selectDynamicFull(record);
		if(Calendarioprocesoseleccion.HAVE_BIGDECIMALS)
		for (Calendarioprocesoseleccion row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Calendarioprocesoseleccion> selectDynamicFullActives(Calendarioprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return calendarioprocesoseleccionMapper.selectDynamicFull(record);
	}

	@Override
	public List<Calendarioprocesoseleccion> selectDynamicExtended(Calendarioprocesoseleccion record) throws Exception {
		return calendarioprocesoseleccionMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Calendarioprocesoseleccion> selectDynamicExtendedActives(Calendarioprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return calendarioprocesoseleccionMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Calendarioprocesoseleccion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		calendarioprocesoseleccionMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Calendarioprocesoseleccion record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Calendarioprocesoseleccion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		calendarioprocesoseleccionMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Calendarioprocesoseleccion record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Calendarioprocesoseleccion record) throws Exception {
	}

	public void validateInsert(Calendarioprocesoseleccion record)throws Exception{
		if(record.getIdcalendarioproceso()==null)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.idcalendarioproceso.required"));

		if(record.getIdcatalogocodigocalendario()!=null &&  record.getIdcatalogocodigocalendario().length() > 10)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.idcatalogocodigocalendario.length.error",record.getIdcatalogocodigocalendario().length()));
		if(record.getNombrecalendario()!=null &&  record.getNombrecalendario().length() > 100)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.nombrecalendario.length.error",record.getNombrecalendario().length()));
		if(record.getIdcatalogoestadopublicacion()!=null &&  record.getIdcatalogoestadopublicacion().length() > 10)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.idcatalogoestadopublicacion.length.error",record.getIdcatalogoestadopublicacion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Calendarioprocesoseleccion record)throws Exception{
		if(record.getIdcalendarioproceso()==null)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.idcalendarioproceso.required"));

		if(record.getIdcatalogocodigocalendario()!=null &&  record.getIdcatalogocodigocalendario().length() > 10)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.idcatalogocodigocalendario.length.error",record.getIdcatalogocodigocalendario().length()));
		if(record.getNombrecalendario()!=null &&  record.getNombrecalendario().length() > 100)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.nombrecalendario.length.error",record.getNombrecalendario().length()));
		if(record.getIdcatalogoestadopublicacion()!=null &&  record.getIdcatalogoestadopublicacion().length() > 10)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.idcatalogoestadopublicacion.length.error",record.getIdcatalogoestadopublicacion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idcalendarioproceso)throws Exception{
		if(par_idcalendarioproceso==null)
			throw new ValidateException(Messages.getString("calendarioprocesoseleccion.idcalendarioproceso.required"));

		//Here Bussines Validations.
	}


}

