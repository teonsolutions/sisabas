
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
import pe.com.sisabas.be.Grupodocumento;
import pe.com.sisabas.persistence.GrupodocumentoMapper;
import pe.com.sisabas.business.GrupodocumentoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class GrupodocumentoBusinessImpl implements GrupodocumentoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(GrupodocumentoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public GrupodocumentoMapper grupodocumentoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Grupodocumento par_record) throws Exception {
		validateDelete(par_record.getIdgrupodocumento());
		grupodocumentoMapper.deleteByPrimaryKey(par_record.getIdgrupodocumento());
	}

	@Override
	public void insertBasic(Grupodocumento record) throws Exception {
		record.setIdgrupodocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_GRUPODOCUMENTO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		grupodocumentoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Grupodocumento record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Grupodocumento record) throws Exception {
		record.setIdgrupodocumento((int)utilsBusiness.getNextSeq(Sequence.SEQ_GRUPODOCUMENTO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		grupodocumentoMapper.insertSelective(record);
	}

	@Override
	public Grupodocumento selectByPrimaryKeyBasic(java.lang.Integer par_idgrupodocumento) throws Exception {
		return grupodocumentoMapper.selectByPrimaryKeyBasic(par_idgrupodocumento);
	}

	@Override
	public Grupodocumento selectByPrimaryKeyBasicFromList(java.lang.Integer par_idgrupodocumento, List<Grupodocumento> list) throws Exception {
		Grupodocumento record=null;
		for (Grupodocumento row : list) {
			if(row.equals(new Grupodocumento( par_idgrupodocumento))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idgrupodocumento);

		return record;
	}

	@Override
	public Grupodocumento selectByPrimaryKeyBasicActive(java.lang.Integer par_idgrupodocumento) throws Exception {
		return grupodocumentoMapper.selectByPrimaryKeyBasicActive(par_idgrupodocumento);
	}

	@Override
	public Grupodocumento selectByPrimaryKeyFull(java.lang.Integer par_idgrupodocumento) throws Exception {
		return grupodocumentoMapper.selectByPrimaryKeyFull(par_idgrupodocumento);
	}

	@Override
	public Grupodocumento selectByPrimaryKeyFullActive(java.lang.Integer par_idgrupodocumento) throws Exception {
		return grupodocumentoMapper.selectByPrimaryKeyFullActive(par_idgrupodocumento);
	}

	@Override
	public List<Grupodocumento> selectDynamicBasic(Grupodocumento record) throws Exception {
		return grupodocumentoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Grupodocumento> selectDynamicBasicActives(Grupodocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return grupodocumentoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Grupodocumento> selectDynamicFull(Grupodocumento record) throws Exception {
		List<Grupodocumento> list=grupodocumentoMapper.selectDynamicFull(record);
		if(Grupodocumento.HAVE_BIGDECIMALS)
		for (Grupodocumento row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Grupodocumento> selectDynamicFullActives(Grupodocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return grupodocumentoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Grupodocumento> selectDynamicExtended(Grupodocumento record) throws Exception {
		return grupodocumentoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Grupodocumento> selectDynamicExtendedActives(Grupodocumento record) throws Exception {
		record.setEstadoauditoria("1");
		return grupodocumentoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Grupodocumento record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		grupodocumentoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Grupodocumento record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Grupodocumento record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		grupodocumentoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Grupodocumento record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Grupodocumento record) throws Exception {
	}

	public void validateInsert(Grupodocumento record)throws Exception{
		if(record.getIdgrupodocumento()==null)
			throw new ValidateException(Messages.getString("grupodocumento.idgrupodocumento.required"));
		if(record.getEquipoauditoria()==null)
			throw new ValidateException(Messages.getString("grupodocumento.equipoauditoria.required"));

		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 10)
			throw new ValidateException(Messages.getString("grupodocumento.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("grupodocumento.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("grupodocumento.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("grupodocumento.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("grupodocumento.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("grupodocumento.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Grupodocumento record)throws Exception{
		if(record.getIdgrupodocumento()==null)
			throw new ValidateException(Messages.getString("grupodocumento.idgrupodocumento.required"));
		if(record.getEquipoauditoria()==null)
			throw new ValidateException(Messages.getString("grupodocumento.equipoauditoria.required"));

		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 10)
			throw new ValidateException(Messages.getString("grupodocumento.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("grupodocumento.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("grupodocumento.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("grupodocumento.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("grupodocumento.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("grupodocumento.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idgrupodocumento)throws Exception{
		if(par_idgrupodocumento==null)
			throw new ValidateException(Messages.getString("grupodocumento.idgrupodocumento.required"));

		//Here Bussines Validations.
	}


}

