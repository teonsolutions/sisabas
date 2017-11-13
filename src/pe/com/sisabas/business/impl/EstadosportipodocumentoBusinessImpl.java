
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
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.business.EstadosportipodocumentoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class EstadosportipodocumentoBusinessImpl implements EstadosportipodocumentoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(EstadosportipodocumentoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public EstadosportipodocumentoMapper estadosportipodocumentoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Estadosportipodocumento par_record) throws Exception {
		validateDelete(par_record.getIdestadosportipodocumento());
		estadosportipodocumentoMapper.deleteByPrimaryKey(par_record.getIdestadosportipodocumento());
	}

	@Override
	public void insertBasic(Estadosportipodocumento record) throws Exception {
		record.setIdestadosportipodocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORTIPODOCUMENTO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosportipodocumentoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Estadosportipodocumento record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Estadosportipodocumento record) throws Exception {
		record.setIdestadosportipodocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORTIPODOCUMENTO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosportipodocumentoMapper.insertSelective(record);
	}

	@Override
	public Estadosportipodocumento selectByPrimaryKeyBasic(java.lang.Integer par_idestadosportipodocumento) throws Exception {
		return estadosportipodocumentoMapper.selectByPrimaryKeyBasic(par_idestadosportipodocumento);
	}

	@Override
	public Estadosportipodocumento selectByPrimaryKeyBasicFromList(java.lang.Integer par_idestadosportipodocumento, List<Estadosportipodocumento> list) throws Exception {
		Estadosportipodocumento record=null;
		for (Estadosportipodocumento row : list) {
			if(row.equals(new Estadosportipodocumento( par_idestadosportipodocumento))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idestadosportipodocumento);

		return record;
	}

	@Override
	public Estadosportipodocumento selectByPrimaryKeyBasicActive(java.lang.Integer par_idestadosportipodocumento) throws Exception {
		return estadosportipodocumentoMapper.selectByPrimaryKeyBasicActive(par_idestadosportipodocumento);
	}

	@Override
	public Estadosportipodocumento selectByPrimaryKeyFull(java.lang.Integer par_idestadosportipodocumento) throws Exception {
		return estadosportipodocumentoMapper.selectByPrimaryKeyFull(par_idestadosportipodocumento);
	}

	@Override
	public Estadosportipodocumento selectByPrimaryKeyFullActive(java.lang.Integer par_idestadosportipodocumento) throws Exception {
		return estadosportipodocumentoMapper.selectByPrimaryKeyFullActive(par_idestadosportipodocumento);
	}

	@Override
	public List<Estadosportipodocumento> selectDynamicBasic(Estadosportipodocumento record) throws Exception {
		return estadosportipodocumentoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Estadosportipodocumento> selectDynamicBasicActives(Estadosportipodocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return estadosportipodocumentoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Estadosportipodocumento> selectDynamicFull(Estadosportipodocumento record) throws Exception {
		List<Estadosportipodocumento> list=estadosportipodocumentoMapper.selectDynamicFull(record);
		if(Estadosportipodocumento.HAVE_BIGDECIMALS)
		for (Estadosportipodocumento row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Estadosportipodocumento> selectDynamicFullActives(Estadosportipodocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return estadosportipodocumentoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Estadosportipodocumento> selectDynamicExtended(Estadosportipodocumento record) throws Exception {
		return estadosportipodocumentoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Estadosportipodocumento> selectDynamicExtendedActives(Estadosportipodocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return estadosportipodocumentoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Estadosportipodocumento record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosportipodocumentoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Estadosportipodocumento record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Estadosportipodocumento record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadosportipodocumentoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Estadosportipodocumento record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Estadosportipodocumento record) throws Exception {
	}

	public void validateInsert(Estadosportipodocumento record)throws Exception{
		if(record.getIdestadosportipodocumento()==null)
			throw new ValidateException(Messages.getString("estadosportipodocumento.idestadosportipodocumento.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosportipodocumento.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosportipodocumento.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("estadosportipodocumento.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("estadosportipodocumento.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("estadosportipodocumento.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Estadosportipodocumento record)throws Exception{
		if(record.getIdestadosportipodocumento()==null)
			throw new ValidateException(Messages.getString("estadosportipodocumento.idestadosportipodocumento.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosportipodocumento.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadosportipodocumento.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("estadosportipodocumento.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("estadosportipodocumento.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("estadosportipodocumento.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idestadosportipodocumento)throws Exception{
		if(par_idestadosportipodocumento==null)
			throw new ValidateException(Messages.getString("estadosportipodocumento.idestadosportipodocumento.required"));

		//Here Bussines Validations.
	}


}

