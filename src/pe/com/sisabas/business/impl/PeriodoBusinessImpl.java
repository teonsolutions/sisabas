
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
import pe.com.sisabas.be.Periodo;
import pe.com.sisabas.persistence.PeriodoMapper;
import pe.com.sisabas.business.PeriodoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class PeriodoBusinessImpl implements PeriodoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(PeriodoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public PeriodoMapper periodoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Periodo par_record) throws Exception {
		validateDelete(par_record.getIdperiodo());
		periodoMapper.deleteByPrimaryKey(par_record.getIdperiodo());
	}

	@Override
	public void insertBasic(Periodo record) throws Exception {
		record.setIdperiodo((int)utilsBusiness.getNextSeq(Sequence.SEQ_PERIODO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		periodoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Periodo record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Periodo record) throws Exception {
		record.setIdperiodo((int)utilsBusiness.getNextSeq(Sequence.SEQ_PERIODO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		periodoMapper.insertSelective(record);
	}

	@Override
	public Periodo selectByPrimaryKeyBasic(java.lang.Integer par_idperiodo) throws Exception {
		return periodoMapper.selectByPrimaryKeyBasic(par_idperiodo);
	}

	@Override
	public Periodo selectByPrimaryKeyBasicFromList(java.lang.Integer par_idperiodo, List<Periodo> list) throws Exception {
		Periodo record=null;
		for (Periodo row : list) {
			if(row.equals(new Periodo( par_idperiodo))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idperiodo);

		return record;
	}

	@Override
	public Periodo selectByPrimaryKeyBasicActive(java.lang.Integer par_idperiodo) throws Exception {
		return periodoMapper.selectByPrimaryKeyBasicActive(par_idperiodo);
	}

	@Override
	public Periodo selectByPrimaryKeyFull(java.lang.Integer par_idperiodo) throws Exception {
		return periodoMapper.selectByPrimaryKeyFull(par_idperiodo);
	}

	@Override
	public Periodo selectByPrimaryKeyFullActive(java.lang.Integer par_idperiodo) throws Exception {
		return periodoMapper.selectByPrimaryKeyFullActive(par_idperiodo);
	}

	@Override
	public List<Periodo> selectDynamicBasic(Periodo record) throws Exception {
		return periodoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Periodo> selectDynamicBasicActives(Periodo record) throws Exception {
		record.setEstadoauditoria("1");
		return periodoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Periodo> selectDynamicFull(Periodo record) throws Exception {
		List<Periodo> list=periodoMapper.selectDynamicFull(record);
		if(Periodo.HAVE_BIGDECIMALS)
		for (Periodo row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Periodo> selectDynamicFullActives(Periodo record) throws Exception {
		record.setEstadoauditoria("1");
		return periodoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Periodo> selectDynamicExtended(Periodo record) throws Exception {
		return periodoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Periodo> selectDynamicExtendedActives(Periodo record) throws Exception {
		record.setEstadoauditoria("1");
		return periodoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Periodo record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		periodoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Periodo record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Periodo record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		periodoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Periodo record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Periodo record) throws Exception {
		if(record.getBooleanestadoauditoria()!=null && record.getBooleanestadoauditoria()){
			record.setEstadoauditoria("1");
		}else{
			record.setEstadoauditoria("0");
		}

	}

	public void validateInsert(Periodo record)throws Exception{
		if(record.getIdperiodo()==null)
			throw new ValidateException(Messages.getString("periodo.idperiodo.required"));

		if(record.getNombreperiodo()!=null &&  record.getNombreperiodo().length() > 100)
			throw new ValidateException(Messages.getString("periodo.nombreperiodo.length.error",record.getNombreperiodo().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("periodo.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("periodo.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("periodo.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("periodo.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("periodo.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Periodo record)throws Exception{
		if(record.getIdperiodo()==null)
			throw new ValidateException(Messages.getString("periodo.idperiodo.required"));

		if(record.getNombreperiodo()!=null &&  record.getNombreperiodo().length() > 100)
			throw new ValidateException(Messages.getString("periodo.nombreperiodo.length.error",record.getNombreperiodo().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("periodo.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("periodo.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("periodo.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("periodo.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("periodo.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idperiodo)throws Exception{
		if(par_idperiodo==null)
			throw new ValidateException(Messages.getString("periodo.idperiodo.required"));

		//Here Bussines Validations.
	}


}

