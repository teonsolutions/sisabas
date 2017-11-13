
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
import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.persistence.EstadosporetapapordocumentoMapper;
import pe.com.sisabas.business.EstadosporetapapordocumentoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class EstadosporetapapordocumentoBusinessImpl implements EstadosporetapapordocumentoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(EstadosporetapapordocumentoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public EstadosporetapapordocumentoMapper estadosporetapapordocumentoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Estadosporetapapordocumento par_record) throws Exception {
		validateDelete(par_record.getIdestadosporetapapordocumento());
		estadosporetapapordocumentoMapper.deleteByPrimaryKey(par_record.getIdestadosporetapapordocumento());
	}

	@Override
	public void insertBasic(Estadosporetapapordocumento record) throws Exception {
		record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosporetapapordocumentoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Estadosporetapapordocumento record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Estadosporetapapordocumento record) throws Exception {
		record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosporetapapordocumentoMapper.insertSelective(record);
	}

	@Override
	public Estadosporetapapordocumento selectByPrimaryKeyBasic(java.lang.Integer par_idestadosporetapapordocumento) throws Exception {
		return estadosporetapapordocumentoMapper.selectByPrimaryKeyBasic(par_idestadosporetapapordocumento);
	}

	@Override
	public Estadosporetapapordocumento selectByPrimaryKeyBasicFromList(java.lang.Integer par_idestadosporetapapordocumento, List<Estadosporetapapordocumento> list) throws Exception {
		Estadosporetapapordocumento record=null;
		for (Estadosporetapapordocumento row : list) {
			if(row.equals(new Estadosporetapapordocumento( par_idestadosporetapapordocumento))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idestadosporetapapordocumento);

		return record;
	}

	@Override
	public Estadosporetapapordocumento selectByPrimaryKeyBasicActive(java.lang.Integer par_idestadosporetapapordocumento) throws Exception {
		return estadosporetapapordocumentoMapper.selectByPrimaryKeyBasicActive(par_idestadosporetapapordocumento);
	}

	@Override
	public Estadosporetapapordocumento selectByPrimaryKeyFull(java.lang.Integer par_idestadosporetapapordocumento) throws Exception {
		return estadosporetapapordocumentoMapper.selectByPrimaryKeyFull(par_idestadosporetapapordocumento);
	}

	@Override
	public Estadosporetapapordocumento selectByPrimaryKeyFullActive(java.lang.Integer par_idestadosporetapapordocumento) throws Exception {
		return estadosporetapapordocumentoMapper.selectByPrimaryKeyFullActive(par_idestadosporetapapordocumento);
	}

	@Override
	public List<Estadosporetapapordocumento> selectDynamicBasic(Estadosporetapapordocumento record) throws Exception {
		return estadosporetapapordocumentoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Estadosporetapapordocumento> selectDynamicBasicActives(Estadosporetapapordocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return estadosporetapapordocumentoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Estadosporetapapordocumento> selectDynamicFull(Estadosporetapapordocumento record) throws Exception {
		List<Estadosporetapapordocumento> list=estadosporetapapordocumentoMapper.selectDynamicFull(record);
		if(Estadosporetapapordocumento.HAVE_BIGDECIMALS)
		for (Estadosporetapapordocumento row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Estadosporetapapordocumento> selectDynamicFullActives(Estadosporetapapordocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return estadosporetapapordocumentoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Estadosporetapapordocumento> selectDynamicExtended(Estadosporetapapordocumento record) throws Exception {
		return estadosporetapapordocumentoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Estadosporetapapordocumento> selectDynamicExtendedActives(Estadosporetapapordocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return estadosporetapapordocumentoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Estadosporetapapordocumento record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosporetapapordocumentoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Estadosporetapapordocumento record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Estadosporetapapordocumento record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosporetapapordocumentoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Estadosporetapapordocumento record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Estadosporetapapordocumento record) throws Exception {
	}

	public void validateInsert(Estadosporetapapordocumento record)throws Exception{
		if(record.getIdestadosporetapapordocumento()==null)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.idestadosporetapapordocumento.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Estadosporetapapordocumento record)throws Exception{
		if(record.getIdestadosporetapapordocumento()==null)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.idestadosporetapapordocumento.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idestadosporetapapordocumento)throws Exception{
		if(par_idestadosporetapapordocumento==null)
			throw new ValidateException(Messages.getString("estadosporetapapordocumento.idestadosporetapapordocumento.required"));

		//Here Bussines Validations.
	}


}

