
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
import pe.com.sisabas.be.Etapagestionadministrativa;
import pe.com.sisabas.persistence.EtapagestionadministrativaMapper;
import pe.com.sisabas.business.EtapagestionadministrativaBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class EtapagestionadministrativaBusinessImpl implements EtapagestionadministrativaBusiness, Serializable{

	private static Logger logger=Logger.getLogger(EtapagestionadministrativaBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public EtapagestionadministrativaMapper etapagestionadministrativaMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Etapagestionadministrativa par_record) throws Exception {
		validateDelete(par_record.getIdetapaadministrativa());
		etapagestionadministrativaMapper.deleteByPrimaryKey(par_record.getIdetapaadministrativa());
	}

	@Override
	public void insertBasic(Etapagestionadministrativa record) throws Exception {
		record.setIdetapaadministrativa((int)utilsBusiness.getNextSeq(Sequence.SEQ_ETAPAGESTIONADMINISTRATIVA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		etapagestionadministrativaMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Etapagestionadministrativa record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Etapagestionadministrativa record) throws Exception {
		record.setIdetapaadministrativa((int)utilsBusiness.getNextSeq(Sequence.SEQ_ETAPAGESTIONADMINISTRATIVA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		etapagestionadministrativaMapper.insertSelective(record);
	}

	@Override
	public Etapagestionadministrativa selectByPrimaryKeyBasic(java.lang.Integer par_idetapaadministrativa) throws Exception {
		return etapagestionadministrativaMapper.selectByPrimaryKeyBasic(par_idetapaadministrativa);
	}

	@Override
	public Etapagestionadministrativa selectByPrimaryKeyBasicFromList(java.lang.Integer par_idetapaadministrativa, List<Etapagestionadministrativa> list) throws Exception {
		Etapagestionadministrativa record=null;
		for (Etapagestionadministrativa row : list) {
			if(row.equals(new Etapagestionadministrativa( par_idetapaadministrativa))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idetapaadministrativa);

		return record;
	}

	@Override
	public Etapagestionadministrativa selectByPrimaryKeyBasicActive(java.lang.Integer par_idetapaadministrativa) throws Exception {
		return etapagestionadministrativaMapper.selectByPrimaryKeyBasicActive(par_idetapaadministrativa);
	}

	@Override
	public Etapagestionadministrativa selectByPrimaryKeyFull(java.lang.Integer par_idetapaadministrativa) throws Exception {
		return etapagestionadministrativaMapper.selectByPrimaryKeyFull(par_idetapaadministrativa);
	}

	@Override
	public Etapagestionadministrativa selectByPrimaryKeyFullActive(java.lang.Integer par_idetapaadministrativa) throws Exception {
		return etapagestionadministrativaMapper.selectByPrimaryKeyFullActive(par_idetapaadministrativa);
	}

	@Override
	public List<Etapagestionadministrativa> selectDynamicBasic(Etapagestionadministrativa record) throws Exception {
		return etapagestionadministrativaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Etapagestionadministrativa> selectDynamicBasicActives(Etapagestionadministrativa record) throws Exception {
		record.setEstadoauditoria("1");
		return etapagestionadministrativaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Etapagestionadministrativa> selectDynamicFull(Etapagestionadministrativa record) throws Exception {
		List<Etapagestionadministrativa> list=etapagestionadministrativaMapper.selectDynamicFull(record);
		if(Etapagestionadministrativa.HAVE_BIGDECIMALS)
		for (Etapagestionadministrativa row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Etapagestionadministrativa> selectDynamicFullActives(Etapagestionadministrativa record) throws Exception {
		record.setEstadoauditoria("1");
		return etapagestionadministrativaMapper.selectDynamicFull(record);
	}

	@Override
	public List<Etapagestionadministrativa> selectDynamicExtended(Etapagestionadministrativa record) throws Exception {
		return etapagestionadministrativaMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Etapagestionadministrativa> selectDynamicExtendedActives(Etapagestionadministrativa record) throws Exception {
		record.setEstadoauditoria("1");
		return etapagestionadministrativaMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Etapagestionadministrativa record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		etapagestionadministrativaMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Etapagestionadministrativa record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Etapagestionadministrativa record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		etapagestionadministrativaMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Etapagestionadministrativa record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Etapagestionadministrativa record) throws Exception {
	}

	public void validateInsert(Etapagestionadministrativa record)throws Exception{
		if(record.getIdetapaadministrativa()==null)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.idetapaadministrativa.required"));

		if(record.getDescripcionetapaadministrativa()!=null &&  record.getDescripcionetapaadministrativa().length() > 150)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.descripcionetapaadministrativa.length.error",record.getDescripcionetapaadministrativa().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Etapagestionadministrativa record)throws Exception{
		if(record.getIdetapaadministrativa()==null)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.idetapaadministrativa.required"));

		if(record.getDescripcionetapaadministrativa()!=null &&  record.getDescripcionetapaadministrativa().length() > 150)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.descripcionetapaadministrativa.length.error",record.getDescripcionetapaadministrativa().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idetapaadministrativa)throws Exception{
		if(par_idetapaadministrativa==null)
			throw new ValidateException(Messages.getString("etapagestionadministrativa.idetapaadministrativa.required"));

		//Here Bussines Validations.
	}


}

