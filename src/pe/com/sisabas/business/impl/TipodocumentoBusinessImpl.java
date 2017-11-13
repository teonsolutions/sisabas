
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
import pe.com.sisabas.be.Tipodocumento;
import pe.com.sisabas.persistence.TipodocumentoMapper;
import pe.com.sisabas.business.TipodocumentoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class TipodocumentoBusinessImpl implements TipodocumentoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(TipodocumentoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public TipodocumentoMapper tipodocumentoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Tipodocumento par_record) throws Exception {
		validateDelete(par_record.getIdtipodocumento());
		tipodocumentoMapper.deleteByPrimaryKey(par_record.getIdtipodocumento());
	}

	@Override
	public void insertBasic(Tipodocumento record) throws Exception {
		record.setIdtipodocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_TIPODOCUMENTO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		tipodocumentoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Tipodocumento record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Tipodocumento record) throws Exception {
		record.setIdtipodocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_TIPODOCUMENTO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		tipodocumentoMapper.insertSelective(record);
	}

	@Override
	public Tipodocumento selectByPrimaryKeyBasic(java.lang.Integer par_idtipodocumento) throws Exception {
		return tipodocumentoMapper.selectByPrimaryKeyBasic(par_idtipodocumento);
	}

	@Override
	public Tipodocumento selectByPrimaryKeyBasicFromList(java.lang.Integer par_idtipodocumento, List<Tipodocumento> list) throws Exception {
		Tipodocumento record=null;
		for (Tipodocumento row : list) {
			if(row.equals(new Tipodocumento( par_idtipodocumento))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idtipodocumento);

		return record;
	}

	@Override
	public Tipodocumento selectByPrimaryKeyBasicActive(java.lang.Integer par_idtipodocumento) throws Exception {
		return tipodocumentoMapper.selectByPrimaryKeyBasicActive(par_idtipodocumento);
	}

	@Override
	public Tipodocumento selectByPrimaryKeyFull(java.lang.Integer par_idtipodocumento) throws Exception {
		return tipodocumentoMapper.selectByPrimaryKeyFull(par_idtipodocumento);
	}

	@Override
	public Tipodocumento selectByPrimaryKeyFullActive(java.lang.Integer par_idtipodocumento) throws Exception {
		return tipodocumentoMapper.selectByPrimaryKeyFullActive(par_idtipodocumento);
	}

	@Override
	public List<Tipodocumento> selectDynamicBasic(Tipodocumento record) throws Exception {
		return tipodocumentoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Tipodocumento> selectDynamicBasicActives(Tipodocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return tipodocumentoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Tipodocumento> selectDynamicFull(Tipodocumento record) throws Exception {
		List<Tipodocumento> list=tipodocumentoMapper.selectDynamicFull(record);
		if(Tipodocumento.HAVE_BIGDECIMALS)
		for (Tipodocumento row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Tipodocumento> selectDynamicFullActives(Tipodocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return tipodocumentoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Tipodocumento> selectDynamicExtended(Tipodocumento record) throws Exception {
		return tipodocumentoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Tipodocumento> selectDynamicExtendedActives(Tipodocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return tipodocumentoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Tipodocumento record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		tipodocumentoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Tipodocumento record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Tipodocumento record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		tipodocumentoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Tipodocumento record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Tipodocumento record) throws Exception {
	}

	public void validateInsert(Tipodocumento record)throws Exception{
		if(record.getIdtipodocumento()==null)
			throw new ValidateException(Messages.getString("tipodocumento.idtipodocumento.required"));

		if(record.getDescripciontipodocumento()!=null &&  record.getDescripciontipodocumento().length() > 100)
			throw new ValidateException(Messages.getString("tipodocumento.descripciontipodocumento.length.error",record.getDescripciontipodocumento().length()));
		if(record.getDescripcion()!=null &&  record.getDescripcion().length() > 300)
			throw new ValidateException(Messages.getString("tipodocumento.descripcion.length.error",record.getDescripcion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("tipodocumento.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("tipodocumento.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("tipodocumento.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("tipodocumento.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("tipodocumento.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Tipodocumento record)throws Exception{
		if(record.getIdtipodocumento()==null)
			throw new ValidateException(Messages.getString("tipodocumento.idtipodocumento.required"));

		if(record.getDescripciontipodocumento()!=null &&  record.getDescripciontipodocumento().length() > 100)
			throw new ValidateException(Messages.getString("tipodocumento.descripciontipodocumento.length.error",record.getDescripciontipodocumento().length()));
		if(record.getDescripcion()!=null &&  record.getDescripcion().length() > 300)
			throw new ValidateException(Messages.getString("tipodocumento.descripcion.length.error",record.getDescripcion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("tipodocumento.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("tipodocumento.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("tipodocumento.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("tipodocumento.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("tipodocumento.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idtipodocumento)throws Exception{
		if(par_idtipodocumento==null)
			throw new ValidateException(Messages.getString("tipodocumento.idtipodocumento.required"));

		//Here Bussines Validations.
	}


}

