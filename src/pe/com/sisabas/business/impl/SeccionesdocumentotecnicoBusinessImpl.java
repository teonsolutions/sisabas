
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
import pe.com.sisabas.be.Seccionesdocumentotecnico;
import pe.com.sisabas.persistence.SeccionesdocumentotecnicoMapper;
import pe.com.sisabas.business.SeccionesdocumentotecnicoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class SeccionesdocumentotecnicoBusinessImpl implements SeccionesdocumentotecnicoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(SeccionesdocumentotecnicoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public SeccionesdocumentotecnicoMapper seccionesdocumentotecnicoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Seccionesdocumentotecnico par_record) throws Exception {
		validateDelete(par_record.getIdseccionesdocumentotecnico());
		seccionesdocumentotecnicoMapper.deleteByPrimaryKey(par_record.getIdseccionesdocumentotecnico());
	}

	@Override
	public void insertBasic(Seccionesdocumentotecnico record) throws Exception {
		record.setIdseccionesdocumentotecnico((int)utilsBusiness.getNextSeq(Sequence.SEQ_SECCIONESDOCUMENTOTECNICO).longValue());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		seccionesdocumentotecnicoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Seccionesdocumentotecnico record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Seccionesdocumentotecnico record) throws Exception {
		record.setIdseccionesdocumentotecnico((int)utilsBusiness.getNextSeq(Sequence.SEQ_SECCIONESDOCUMENTOTECNICO).longValue());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		seccionesdocumentotecnicoMapper.insertSelective(record);
	}

	@Override
	public Seccionesdocumentotecnico selectByPrimaryKeyBasic(java.lang.Integer par_idseccionesdocumentotecnico) throws Exception {
		return seccionesdocumentotecnicoMapper.selectByPrimaryKeyBasic(par_idseccionesdocumentotecnico);
	}

	@Override
	public Seccionesdocumentotecnico selectByPrimaryKeyBasicFromList(java.lang.Integer par_idseccionesdocumentotecnico, List<Seccionesdocumentotecnico> list) throws Exception {
		Seccionesdocumentotecnico record=null;
		for (Seccionesdocumentotecnico row : list) {
			if(row.equals(new Seccionesdocumentotecnico( par_idseccionesdocumentotecnico))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idseccionesdocumentotecnico);

		return record;
	}

	@Override
	public Seccionesdocumentotecnico selectByPrimaryKeyBasicActive(java.lang.Integer par_idseccionesdocumentotecnico) throws Exception {
		return seccionesdocumentotecnicoMapper.selectByPrimaryKeyBasicActive(par_idseccionesdocumentotecnico);
	}

	@Override
	public Seccionesdocumentotecnico selectByPrimaryKeyFull(java.lang.Integer par_idseccionesdocumentotecnico) throws Exception {
		return seccionesdocumentotecnicoMapper.selectByPrimaryKeyFull(par_idseccionesdocumentotecnico);
	}

	@Override
	public Seccionesdocumentotecnico selectByPrimaryKeyFullActive(java.lang.Integer par_idseccionesdocumentotecnico) throws Exception {
		return seccionesdocumentotecnicoMapper.selectByPrimaryKeyFullActive(par_idseccionesdocumentotecnico);
	}

	@Override
	public List<Seccionesdocumentotecnico> selectDynamicBasic(Seccionesdocumentotecnico record) throws Exception {
		return seccionesdocumentotecnicoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Seccionesdocumentotecnico> selectDynamicBasicActives(Seccionesdocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return seccionesdocumentotecnicoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Seccionesdocumentotecnico> selectDynamicFull(Seccionesdocumentotecnico record) throws Exception {
		List<Seccionesdocumentotecnico> list=seccionesdocumentotecnicoMapper.selectDynamicFull(record);
		if(Seccionesdocumentotecnico.HAVE_BIGDECIMALS)
		for (Seccionesdocumentotecnico row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Seccionesdocumentotecnico> selectDynamicFullActives(Seccionesdocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return seccionesdocumentotecnicoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Seccionesdocumentotecnico> selectDynamicExtended(Seccionesdocumentotecnico record) throws Exception {
		return seccionesdocumentotecnicoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Seccionesdocumentotecnico> selectDynamicExtendedActives(Seccionesdocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return seccionesdocumentotecnicoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Seccionesdocumentotecnico record) throws Exception {
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		seccionesdocumentotecnicoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Seccionesdocumentotecnico record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Seccionesdocumentotecnico record) throws Exception {
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		seccionesdocumentotecnicoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Seccionesdocumentotecnico record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Seccionesdocumentotecnico record) throws Exception {
	}

	public void validateInsert(Seccionesdocumentotecnico record)throws Exception{
		if(record.getIdseccionesdocumentotecnico()==null)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.idseccionesdocumentotecnico.required"));

		if(record.getIdcatalogotipodocumentotecnico()!=null &&  record.getIdcatalogotipodocumentotecnico().length() > 10)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.idcatalogotipodocumentotecnico.length.error",record.getIdcatalogotipodocumentotecnico().length()));
		if(record.getIdcatalogotipotdr()!=null &&  record.getIdcatalogotipotdr().length() > 10)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.idcatalogotipotdr.length.error",record.getIdcatalogotipotdr().length()));
		if(record.getDescripcionseccion()!=null &&  record.getDescripcionseccion().length() > 100)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.descripcionseccion.length.error",record.getDescripcionseccion().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Seccionesdocumentotecnico record)throws Exception{
		if(record.getIdseccionesdocumentotecnico()==null)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.idseccionesdocumentotecnico.required"));

		if(record.getIdcatalogotipodocumentotecnico()!=null &&  record.getIdcatalogotipodocumentotecnico().length() > 10)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.idcatalogotipodocumentotecnico.length.error",record.getIdcatalogotipodocumentotecnico().length()));
		if(record.getIdcatalogotipotdr()!=null &&  record.getIdcatalogotipotdr().length() > 10)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.idcatalogotipotdr.length.error",record.getIdcatalogotipotdr().length()));
		if(record.getDescripcionseccion()!=null &&  record.getDescripcionseccion().length() > 100)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.descripcionseccion.length.error",record.getDescripcionseccion().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idseccionesdocumentotecnico)throws Exception{
		if(par_idseccionesdocumentotecnico==null)
			throw new ValidateException(Messages.getString("seccionesdocumentotecnico.idseccionesdocumentotecnico.required"));

		//Here Bussines Validations.
	}


}

