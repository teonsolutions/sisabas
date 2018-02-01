
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
import pe.com.sisabas.be.Previsionporcontrato;
import pe.com.sisabas.persistence.PrevisionporcontratoMapper;
import pe.com.sisabas.business.PrevisionporcontratoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class PrevisionporcontratoBusinessImpl implements PrevisionporcontratoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(PrevisionporcontratoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public PrevisionporcontratoMapper previsionporcontratoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Previsionporcontrato par_record) throws Exception {
		validateDelete(par_record.getIdprevisionporcontrato());
		previsionporcontratoMapper.deleteByPrimaryKey(par_record.getIdprevisionporcontrato());
	}

	@Override
	public void insertBasic(Previsionporcontrato record) throws Exception {
		record.setIdprevisionporcontrato((int)utilsBusiness.getNextSeq(Sequence.SEQ_PREVISIONPORCONTRATO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		previsionporcontratoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Previsionporcontrato record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Previsionporcontrato record) throws Exception {
		record.setIdprevisionporcontrato((int)utilsBusiness.getNextSeq(Sequence.SEQ_PREVISIONPORCONTRATO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		previsionporcontratoMapper.insertSelective(record);
	}

	@Override
	public Previsionporcontrato selectByPrimaryKeyBasic(java.lang.Integer par_idprevisionporcontrato) throws Exception {
		return previsionporcontratoMapper.selectByPrimaryKeyBasic(par_idprevisionporcontrato);
	}

	@Override
	public Previsionporcontrato selectByPrimaryKeyBasicFromList(java.lang.Integer par_idprevisionporcontrato, List<Previsionporcontrato> list) throws Exception {
		Previsionporcontrato record=null;
		for (Previsionporcontrato row : list) {
			if(row.equals(new Previsionporcontrato( par_idprevisionporcontrato))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idprevisionporcontrato);

		return record;
	}

	@Override
	public Previsionporcontrato selectByPrimaryKeyBasicActive(java.lang.Integer par_idprevisionporcontrato) throws Exception {
		return previsionporcontratoMapper.selectByPrimaryKeyBasicActive(par_idprevisionporcontrato);
	}

	@Override
	public Previsionporcontrato selectByPrimaryKeyFull(java.lang.Integer par_idprevisionporcontrato) throws Exception {
		return previsionporcontratoMapper.selectByPrimaryKeyFull(par_idprevisionporcontrato);
	}

	@Override
	public Previsionporcontrato selectByPrimaryKeyFullActive(java.lang.Integer par_idprevisionporcontrato) throws Exception {
		return previsionporcontratoMapper.selectByPrimaryKeyFullActive(par_idprevisionporcontrato);
	}

	@Override
	public List<Previsionporcontrato> selectDynamicBasic(Previsionporcontrato record) throws Exception {
		return previsionporcontratoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Previsionporcontrato> selectDynamicBasicActives(Previsionporcontrato record) throws Exception {
		record.setEstadoauditoria("1");
		return previsionporcontratoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Previsionporcontrato> selectDynamicFull(Previsionporcontrato record) throws Exception {
		List<Previsionporcontrato> list=previsionporcontratoMapper.selectDynamicFull(record);
		if(Previsionporcontrato.HAVE_BIGDECIMALS)
		for (Previsionporcontrato row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Previsionporcontrato> selectDynamicFullActives(Previsionporcontrato record) throws Exception {
		record.setEstadoauditoria("1");
		return previsionporcontratoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Previsionporcontrato> selectDynamicExtended(Previsionporcontrato record) throws Exception {
		return previsionporcontratoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Previsionporcontrato> selectDynamicExtendedActives(Previsionporcontrato record) throws Exception {
		record.setEstadoauditoria("1");
		return previsionporcontratoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Previsionporcontrato record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		previsionporcontratoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Previsionporcontrato record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Previsionporcontrato record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		previsionporcontratoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Previsionporcontrato record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Previsionporcontrato record) throws Exception {
	}

	public void validateInsert(Previsionporcontrato record)throws Exception{
		if(record.getIdprevisionporcontrato()==null)
			throw new ValidateException(Messages.getString("previsionporcontrato.idprevisionporcontrato.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("previsionporcontrato.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("previsionporcontrato.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("previsionporcontrato.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("previsionporcontrato.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("previsionporcontrato.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Previsionporcontrato record)throws Exception{
		if(record.getIdprevisionporcontrato()==null)
			throw new ValidateException(Messages.getString("previsionporcontrato.idprevisionporcontrato.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("previsionporcontrato.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("previsionporcontrato.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("previsionporcontrato.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("previsionporcontrato.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("previsionporcontrato.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idprevisionporcontrato)throws Exception{
		if(par_idprevisionporcontrato==null)
			throw new ValidateException(Messages.getString("previsionporcontrato.idprevisionporcontrato.required"));

		//Here Bussines Validations.
	}


}

