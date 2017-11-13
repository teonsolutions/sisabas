
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
import pe.com.sisabas.be.Plazopagodocumentotecnico;
import pe.com.sisabas.persistence.PlazopagodocumentotecnicoMapper;
import pe.com.sisabas.business.PlazopagodocumentotecnicoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class PlazopagodocumentotecnicoBusinessImpl implements PlazopagodocumentotecnicoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(PlazopagodocumentotecnicoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public PlazopagodocumentotecnicoMapper plazopagodocumentotecnicoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Plazopagodocumentotecnico par_record) throws Exception {
		validateDelete(par_record.getIdplazopagodocumentotecnico());
		plazopagodocumentotecnicoMapper.deleteByPrimaryKey(par_record.getIdplazopagodocumentotecnico());
	}

	@Override
	public void insertBasic(Plazopagodocumentotecnico record) throws Exception {
		record.setIdplazopagodocumentotecnico((int)utilsBusiness.getNextSeq(Sequence.SEQ_PLAZOPAGODOCUMENTOTECNICO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		plazopagodocumentotecnicoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Plazopagodocumentotecnico record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Plazopagodocumentotecnico record) throws Exception {
		record.setIdplazopagodocumentotecnico((int)utilsBusiness.getNextSeq(Sequence.SEQ_PLAZOPAGODOCUMENTOTECNICO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		plazopagodocumentotecnicoMapper.insertSelective(record);
	}

	@Override
	public Plazopagodocumentotecnico selectByPrimaryKeyBasic(java.lang.Integer par_idplazopagodocumentotecnico) throws Exception {
		return plazopagodocumentotecnicoMapper.selectByPrimaryKeyBasic(par_idplazopagodocumentotecnico);
	}

	@Override
	public Plazopagodocumentotecnico selectByPrimaryKeyBasicFromList(java.lang.Integer par_idplazopagodocumentotecnico, List<Plazopagodocumentotecnico> list) throws Exception {
		Plazopagodocumentotecnico record=null;
		for (Plazopagodocumentotecnico row : list) {
			if(row.equals(new Plazopagodocumentotecnico( par_idplazopagodocumentotecnico))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idplazopagodocumentotecnico);

		return record;
	}

	@Override
	public Plazopagodocumentotecnico selectByPrimaryKeyBasicActive(java.lang.Integer par_idplazopagodocumentotecnico) throws Exception {
		return plazopagodocumentotecnicoMapper.selectByPrimaryKeyBasicActive(par_idplazopagodocumentotecnico);
	}

	@Override
	public Plazopagodocumentotecnico selectByPrimaryKeyFull(java.lang.Integer par_idplazopagodocumentotecnico) throws Exception {
		return plazopagodocumentotecnicoMapper.selectByPrimaryKeyFull(par_idplazopagodocumentotecnico);
	}

	@Override
	public Plazopagodocumentotecnico selectByPrimaryKeyFullActive(java.lang.Integer par_idplazopagodocumentotecnico) throws Exception {
		return plazopagodocumentotecnicoMapper.selectByPrimaryKeyFullActive(par_idplazopagodocumentotecnico);
	}

	@Override
	public List<Plazopagodocumentotecnico> selectDynamicBasic(Plazopagodocumentotecnico record) throws Exception {
		return plazopagodocumentotecnicoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Plazopagodocumentotecnico> selectDynamicBasicActives(Plazopagodocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return plazopagodocumentotecnicoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Plazopagodocumentotecnico> selectDynamicFull(Plazopagodocumentotecnico record) throws Exception {
		List<Plazopagodocumentotecnico> list=plazopagodocumentotecnicoMapper.selectDynamicFull(record);
		if(Plazopagodocumentotecnico.HAVE_BIGDECIMALS)
		for (Plazopagodocumentotecnico row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Plazopagodocumentotecnico> selectDynamicFullActives(Plazopagodocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return plazopagodocumentotecnicoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Plazopagodocumentotecnico> selectDynamicExtended(Plazopagodocumentotecnico record) throws Exception {
		return plazopagodocumentotecnicoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Plazopagodocumentotecnico> selectDynamicExtendedActives(Plazopagodocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return plazopagodocumentotecnicoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Plazopagodocumentotecnico record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		plazopagodocumentotecnicoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Plazopagodocumentotecnico record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Plazopagodocumentotecnico record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		plazopagodocumentotecnicoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Plazopagodocumentotecnico record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Plazopagodocumentotecnico record) throws Exception {
	}

	public void validateInsert(Plazopagodocumentotecnico record)throws Exception{
		if(record.getIdplazopagodocumentotecnico()==null)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.idplazopagodocumentotecnico.required"));

		if(record.getCronograma()!=null &&  record.getCronograma().length() > 50)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.cronograma.length.error",record.getCronograma().length()));
		if(record.getNivelavance()!=null &&  record.getNivelavance().length() > 100)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.nivelavance.length.error",record.getNivelavance().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Plazopagodocumentotecnico record)throws Exception{
		if(record.getIdplazopagodocumentotecnico()==null)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.idplazopagodocumentotecnico.required"));

		if(record.getCronograma()!=null &&  record.getCronograma().length() > 50)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.cronograma.length.error",record.getCronograma().length()));
		if(record.getNivelavance()!=null &&  record.getNivelavance().length() > 100)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.nivelavance.length.error",record.getNivelavance().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idplazopagodocumentotecnico)throws Exception{
		if(par_idplazopagodocumentotecnico==null)
			throw new ValidateException(Messages.getString("plazopagodocumentotecnico.idplazopagodocumentotecnico.required"));

		//Here Bussines Validations.
	}


}

