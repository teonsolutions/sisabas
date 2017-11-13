
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
import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.persistence.ComiteprocesoMapper;
import pe.com.sisabas.business.ComiteprocesoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class ComiteprocesoBusinessImpl implements ComiteprocesoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(ComiteprocesoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public ComiteprocesoMapper comiteprocesoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Comiteproceso par_record) throws Exception {
		validateDelete(par_record.getIdcomiteproceso());
		comiteprocesoMapper.deleteByPrimaryKey(par_record.getIdcomiteproceso());
	}

	@Override
	public void insertBasic(Comiteproceso record) throws Exception {
		record.setIdcomiteproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_COMITEPROCESO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		comiteprocesoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Comiteproceso record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Comiteproceso record) throws Exception {
		record.setIdcomiteproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_COMITEPROCESO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		comiteprocesoMapper.insertSelective(record);
	}

	@Override
	public Comiteproceso selectByPrimaryKeyBasic(java.lang.Integer par_idcomiteproceso) throws Exception {
		return comiteprocesoMapper.selectByPrimaryKeyBasic(par_idcomiteproceso);
	}

	@Override
	public Comiteproceso selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcomiteproceso, List<Comiteproceso> list) throws Exception {
		Comiteproceso record=null;
		for (Comiteproceso row : list) {
			if(row.equals(new Comiteproceso( par_idcomiteproceso))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idcomiteproceso);

		return record;
	}

	@Override
	public Comiteproceso selectByPrimaryKeyBasicActive(java.lang.Integer par_idcomiteproceso) throws Exception {
		return comiteprocesoMapper.selectByPrimaryKeyBasicActive(par_idcomiteproceso);
	}

	@Override
	public Comiteproceso selectByPrimaryKeyFull(java.lang.Integer par_idcomiteproceso) throws Exception {
		return comiteprocesoMapper.selectByPrimaryKeyFull(par_idcomiteproceso);
	}

	@Override
	public Comiteproceso selectByPrimaryKeyFullActive(java.lang.Integer par_idcomiteproceso) throws Exception {
		return comiteprocesoMapper.selectByPrimaryKeyFullActive(par_idcomiteproceso);
	}

	@Override
	public List<Comiteproceso> selectDynamicBasic(Comiteproceso record) throws Exception {
		return comiteprocesoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Comiteproceso> selectDynamicBasicActives(Comiteproceso record) throws Exception {
		record.setEstadoauditoria("1");
		return comiteprocesoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Comiteproceso> selectDynamicFull(Comiteproceso record) throws Exception {
		List<Comiteproceso> list=comiteprocesoMapper.selectDynamicFull(record);
		if(Comiteproceso.HAVE_BIGDECIMALS)
		for (Comiteproceso row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Comiteproceso> selectDynamicFullActives(Comiteproceso record) throws Exception {
		record.setEstadoauditoria("1");
		return comiteprocesoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Comiteproceso> selectDynamicExtended(Comiteproceso record) throws Exception {
		return comiteprocesoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Comiteproceso> selectDynamicExtendedActives(Comiteproceso record) throws Exception {
		record.setEstadoauditoria("1");
		return comiteprocesoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Comiteproceso record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		comiteprocesoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Comiteproceso record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Comiteproceso record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		comiteprocesoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Comiteproceso record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Comiteproceso record) throws Exception {
	}

	public void validateInsert(Comiteproceso record)throws Exception{
		if(record.getIdcomiteproceso()==null)
			throw new ValidateException(Messages.getString("comiteproceso.idcomiteproceso.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("comiteproceso.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("comiteproceso.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("comiteproceso.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("comiteproceso.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("comiteproceso.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Comiteproceso record)throws Exception{
		if(record.getIdcomiteproceso()==null)
			throw new ValidateException(Messages.getString("comiteproceso.idcomiteproceso.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("comiteproceso.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("comiteproceso.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("comiteproceso.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("comiteproceso.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("comiteproceso.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idcomiteproceso)throws Exception{
		if(par_idcomiteproceso==null)
			throw new ValidateException(Messages.getString("comiteproceso.idcomiteproceso.required"));

		//Here Bussines Validations.
	}


}

