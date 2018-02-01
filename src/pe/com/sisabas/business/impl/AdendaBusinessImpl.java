
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
import pe.com.sisabas.be.Adenda;
import pe.com.sisabas.persistence.AdendaMapper;
import pe.com.sisabas.business.AdendaBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class AdendaBusinessImpl implements AdendaBusiness, Serializable{

	private static Logger logger=Logger.getLogger(AdendaBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public AdendaMapper adendaMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Adenda par_record) throws Exception {
		validateDelete(par_record.getIdadenda());
		adendaMapper.deleteByPrimaryKey(par_record.getIdadenda());
	}

	@Override
	public void insertBasic(Adenda record) throws Exception {
		record.setIdadenda((int)utilsBusiness.getNextSeq(Sequence.SEQ_ADENDA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		adendaMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Adenda record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Adenda record) throws Exception {
		record.setIdadenda((int)utilsBusiness.getNextSeq(Sequence.SEQ_ADENDA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		adendaMapper.insertSelective(record);
	}

	@Override
	public Adenda selectByPrimaryKeyBasic(java.lang.Integer par_idadenda) throws Exception {
		return adendaMapper.selectByPrimaryKeyBasic(par_idadenda);
	}

	@Override
	public Adenda selectByPrimaryKeyBasicFromList(java.lang.Integer par_idadenda, List<Adenda> list) throws Exception {
		Adenda record=null;
		for (Adenda row : list) {
			if(row.equals(new Adenda( par_idadenda))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idadenda);

		return record;
	}

	@Override
	public Adenda selectByPrimaryKeyBasicActive(java.lang.Integer par_idadenda) throws Exception {
		return adendaMapper.selectByPrimaryKeyBasicActive(par_idadenda);
	}

	@Override
	public Adenda selectByPrimaryKeyFull(java.lang.Integer par_idadenda) throws Exception {
		return adendaMapper.selectByPrimaryKeyFull(par_idadenda);
	}

	@Override
	public Adenda selectByPrimaryKeyFullActive(java.lang.Integer par_idadenda) throws Exception {
		return adendaMapper.selectByPrimaryKeyFullActive(par_idadenda);
	}

	@Override
	public List<Adenda> selectDynamicBasic(Adenda record) throws Exception {
		return adendaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Adenda> selectDynamicBasicActives(Adenda record) throws Exception {
		record.setEstadoauditoria("1");
		return adendaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Adenda> selectDynamicFull(Adenda record) throws Exception {
		List<Adenda> list=adendaMapper.selectDynamicFull(record);
		if(Adenda.HAVE_BIGDECIMALS)
		for (Adenda row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Adenda> selectDynamicFullActives(Adenda record) throws Exception {
		record.setEstadoauditoria("1");
		return adendaMapper.selectDynamicFull(record);
	}

	@Override
	public List<Adenda> selectDynamicExtended(Adenda record) throws Exception {
		return adendaMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Adenda> selectDynamicExtendedActives(Adenda record) throws Exception {
		record.setEstadoauditoria("1");
		return adendaMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Adenda record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		adendaMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Adenda record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Adenda record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		adendaMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Adenda record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Adenda record) throws Exception {
	}

	public void validateInsert(Adenda record)throws Exception{
		if(record.getIdadenda()==null)
			throw new ValidateException(Messages.getString("adenda.idadenda.required"));
		if(record.getIdcontrato()==null)
			throw new ValidateException(Messages.getString("adenda.idcontrato.required"));

		if(record.getMotivoadenda()!=null &&  record.getMotivoadenda().length() > 500)
			throw new ValidateException(Messages.getString("adenda.motivoadenda.length.error",record.getMotivoadenda().length()));
		if(record.getRutaadenda()!=null &&  record.getRutaadenda().length() > 300)
			throw new ValidateException(Messages.getString("adenda.rutaadenda.length.error",record.getRutaadenda().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("adenda.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("adenda.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("adenda.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("adenda.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("adenda.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Adenda record)throws Exception{
		if(record.getIdadenda()==null)
			throw new ValidateException(Messages.getString("adenda.idadenda.required"));
		if(record.getIdcontrato()==null)
			throw new ValidateException(Messages.getString("adenda.idcontrato.required"));

		if(record.getMotivoadenda()!=null &&  record.getMotivoadenda().length() > 500)
			throw new ValidateException(Messages.getString("adenda.motivoadenda.length.error",record.getMotivoadenda().length()));
		if(record.getRutaadenda()!=null &&  record.getRutaadenda().length() > 300)
			throw new ValidateException(Messages.getString("adenda.rutaadenda.length.error",record.getRutaadenda().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("adenda.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("adenda.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("adenda.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("adenda.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("adenda.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idadenda)throws Exception{
		if(par_idadenda==null)
			throw new ValidateException(Messages.getString("adenda.idadenda.required"));

		//Here Bussines Validations.
	}


}

