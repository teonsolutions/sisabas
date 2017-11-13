
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
import pe.com.sisabas.be.Siaflog;
import pe.com.sisabas.persistence.SiaflogMapper;
import pe.com.sisabas.business.SiaflogBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class SiaflogBusinessImpl implements SiaflogBusiness, Serializable{

	private static Logger logger=Logger.getLogger(SiaflogBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public SiaflogMapper siaflogMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Siaflog par_record) throws Exception {
		validateDelete(par_record.getIdlog());
		siaflogMapper.deleteByPrimaryKey(par_record.getIdlog());
	}

	@Override
	public void insertBasic(Siaflog record) throws Exception {
		record.setIdlog((int)utilsBusiness.getNextSeq(Sequence.SEQ_SIAFLOG).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		siaflogMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Siaflog record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Siaflog record) throws Exception {
		record.setIdlog((int)utilsBusiness.getNextSeq(Sequence.SEQ_SIAFLOG).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		siaflogMapper.insertSelective(record);
	}

	@Override
	public Siaflog selectByPrimaryKeyBasic(java.lang.Integer par_idlog) throws Exception {
		return siaflogMapper.selectByPrimaryKeyBasic(par_idlog);
	}

	@Override
	public Siaflog selectByPrimaryKeyBasicFromList(java.lang.Integer par_idlog, List<Siaflog> list) throws Exception {
		Siaflog record=null;
		for (Siaflog row : list) {
			if(row.equals(new Siaflog( par_idlog))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idlog);

		return record;
	}

	@Override
	public Siaflog selectByPrimaryKeyBasicActive(java.lang.Integer par_idlog) throws Exception {
		return siaflogMapper.selectByPrimaryKeyBasicActive(par_idlog);
	}

	@Override
	public Siaflog selectByPrimaryKeyFull(java.lang.Integer par_idlog) throws Exception {
		return siaflogMapper.selectByPrimaryKeyFull(par_idlog);
	}

	@Override
	public Siaflog selectByPrimaryKeyFullActive(java.lang.Integer par_idlog) throws Exception {
		return siaflogMapper.selectByPrimaryKeyFullActive(par_idlog);
	}

	@Override
	public List<Siaflog> selectDynamicBasic(Siaflog record) throws Exception {
		return siaflogMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Siaflog> selectDynamicBasicActives(Siaflog record) throws Exception {
		record.setEstadoauditoria("1");
		return siaflogMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Siaflog> selectDynamicFull(Siaflog record) throws Exception {
		List<Siaflog> list=siaflogMapper.selectDynamicFull(record);
		if(Siaflog.HAVE_BIGDECIMALS)
		for (Siaflog row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Siaflog> selectDynamicFullActives(Siaflog record) throws Exception {
		record.setEstadoauditoria("1");
		return siaflogMapper.selectDynamicFull(record);
	}

	@Override
	public List<Siaflog> selectDynamicExtended(Siaflog record) throws Exception {
		return siaflogMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Siaflog> selectDynamicExtendedActives(Siaflog record) throws Exception {
		record.setEstadoauditoria("1");
		return siaflogMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Siaflog record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		siaflogMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Siaflog record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Siaflog record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		siaflogMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Siaflog record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Siaflog record) throws Exception {
	}

	public void validateInsert(Siaflog record)throws Exception{
		if(record.getIdlog()==null)
			throw new ValidateException(Messages.getString("siaflog.idlog.required"));
		if(record.getIdunidadejecutora()==null)
			throw new ValidateException(Messages.getString("siaflog.idunidadejecutora.required"));
		if(record.getFechainicio()==null)
			throw new ValidateException(Messages.getString("siaflog.fechainicio.required"));
		if(record.getFechafin()==null)
			throw new ValidateException(Messages.getString("siaflog.fechafin.required"));
		if(record.getEstado()==null)
			throw new ValidateException(Messages.getString("siaflog.estado.required"));

		if(record.getPeriodicidad()!=null &&  record.getPeriodicidad().length() > 2147483647)
			throw new ValidateException(Messages.getString("siaflog.periodicidad.length.error",record.getPeriodicidad().length()));
		if(record.getEstado()!=null &&  record.getEstado().length() > 1)
			throw new ValidateException(Messages.getString("siaflog.estado.length.error",record.getEstado().length()));
		if(record.getDescripcionestado()!=null &&  record.getDescripcionestado().length() > 2147483647)
			throw new ValidateException(Messages.getString("siaflog.descripcionestado.length.error",record.getDescripcionestado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("siaflog.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("siaflog.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("siaflog.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("siaflog.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("siaflog.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Siaflog record)throws Exception{
		if(record.getIdlog()==null)
			throw new ValidateException(Messages.getString("siaflog.idlog.required"));
		if(record.getIdunidadejecutora()==null)
			throw new ValidateException(Messages.getString("siaflog.idunidadejecutora.required"));
		if(record.getFechainicio()==null)
			throw new ValidateException(Messages.getString("siaflog.fechainicio.required"));
		if(record.getFechafin()==null)
			throw new ValidateException(Messages.getString("siaflog.fechafin.required"));
		if(record.getEstado()==null)
			throw new ValidateException(Messages.getString("siaflog.estado.required"));

		if(record.getPeriodicidad()!=null &&  record.getPeriodicidad().length() > 2147483647)
			throw new ValidateException(Messages.getString("siaflog.periodicidad.length.error",record.getPeriodicidad().length()));
		if(record.getEstado()!=null &&  record.getEstado().length() > 1)
			throw new ValidateException(Messages.getString("siaflog.estado.length.error",record.getEstado().length()));
		if(record.getDescripcionestado()!=null &&  record.getDescripcionestado().length() > 2147483647)
			throw new ValidateException(Messages.getString("siaflog.descripcionestado.length.error",record.getDescripcionestado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("siaflog.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("siaflog.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("siaflog.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("siaflog.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("siaflog.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idlog)throws Exception{
		if(par_idlog==null)
			throw new ValidateException(Messages.getString("siaflog.idlog.required"));

		//Here Bussines Validations.
	}


}

