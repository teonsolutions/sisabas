
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
import pe.com.sisabas.be.Dependenciadocumentotecnico;
import pe.com.sisabas.persistence.DependenciadocumentotecnicoMapper;
import pe.com.sisabas.business.DependenciadocumentotecnicoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class DependenciadocumentotecnicoBusinessImpl implements DependenciadocumentotecnicoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(DependenciadocumentotecnicoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public DependenciadocumentotecnicoMapper dependenciadocumentotecnicoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Dependenciadocumentotecnico par_record) throws Exception {
		validateDelete(par_record.getIddependenciadocumentotecnico());
		dependenciadocumentotecnicoMapper.deleteByPrimaryKey(par_record.getIddependenciadocumentotecnico());
	}

	@Override
	public void insertBasic(Dependenciadocumentotecnico record) throws Exception {
		record.setIddependenciadocumentotecnico((int)utilsBusiness.getNextSeq(Sequence.SEQ_DEPENDENCIADOCUMENTOTECNICO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		dependenciadocumentotecnicoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Dependenciadocumentotecnico record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Dependenciadocumentotecnico record) throws Exception {
		record.setIddependenciadocumentotecnico((int)utilsBusiness.getNextSeq(Sequence.SEQ_DEPENDENCIADOCUMENTOTECNICO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		dependenciadocumentotecnicoMapper.insertSelective(record);
	}

	@Override
	public Dependenciadocumentotecnico selectByPrimaryKeyBasic(java.lang.Integer par_iddependenciadocumentotecnico) throws Exception {
		return dependenciadocumentotecnicoMapper.selectByPrimaryKeyBasic(par_iddependenciadocumentotecnico);
	}

	@Override
	public Dependenciadocumentotecnico selectByPrimaryKeyBasicFromList(java.lang.Integer par_iddependenciadocumentotecnico, List<Dependenciadocumentotecnico> list) throws Exception {
		Dependenciadocumentotecnico record=null;
		for (Dependenciadocumentotecnico row : list) {
			if(row.equals(new Dependenciadocumentotecnico( par_iddependenciadocumentotecnico))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_iddependenciadocumentotecnico);

		return record;
	}

	@Override
	public Dependenciadocumentotecnico selectByPrimaryKeyBasicActive(java.lang.Integer par_iddependenciadocumentotecnico) throws Exception {
		return dependenciadocumentotecnicoMapper.selectByPrimaryKeyBasicActive(par_iddependenciadocumentotecnico);
	}

	@Override
	public Dependenciadocumentotecnico selectByPrimaryKeyFull(java.lang.Integer par_iddependenciadocumentotecnico) throws Exception {
		return dependenciadocumentotecnicoMapper.selectByPrimaryKeyFull(par_iddependenciadocumentotecnico);
	}

	@Override
	public Dependenciadocumentotecnico selectByPrimaryKeyFullActive(java.lang.Integer par_iddependenciadocumentotecnico) throws Exception {
		return dependenciadocumentotecnicoMapper.selectByPrimaryKeyFullActive(par_iddependenciadocumentotecnico);
	}

	@Override
	public List<Dependenciadocumentotecnico> selectDynamicBasic(Dependenciadocumentotecnico record) throws Exception {
		return dependenciadocumentotecnicoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Dependenciadocumentotecnico> selectDynamicBasicActives(Dependenciadocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return dependenciadocumentotecnicoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Dependenciadocumentotecnico> selectDynamicFull(Dependenciadocumentotecnico record) throws Exception {
		List<Dependenciadocumentotecnico> list=dependenciadocumentotecnicoMapper.selectDynamicFull(record);
		if(Dependenciadocumentotecnico.HAVE_BIGDECIMALS)
		for (Dependenciadocumentotecnico row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Dependenciadocumentotecnico> selectDynamicFullActives(Dependenciadocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return dependenciadocumentotecnicoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Dependenciadocumentotecnico> selectDynamicExtended(Dependenciadocumentotecnico record) throws Exception {
		return dependenciadocumentotecnicoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Dependenciadocumentotecnico> selectDynamicExtendedActives(Dependenciadocumentotecnico record) throws Exception {
		record.setEstadoauditoria("1");
		return dependenciadocumentotecnicoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Dependenciadocumentotecnico record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		dependenciadocumentotecnicoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Dependenciadocumentotecnico record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Dependenciadocumentotecnico record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		dependenciadocumentotecnicoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Dependenciadocumentotecnico record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Dependenciadocumentotecnico record) throws Exception {
	}

	public void validateInsert(Dependenciadocumentotecnico record)throws Exception{
		if(record.getIddependenciadocumentotecnico()==null)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.iddependenciadocumentotecnico.required"));
		if(record.getIddocumentotecnico()==null)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.iddocumentotecnico.required"));
		if(record.getDireccion()==null)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.direccion.required"));

		if(record.getDireccion()!=null &&  record.getDireccion().length() > 100)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.direccion.length.error",record.getDireccion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Dependenciadocumentotecnico record)throws Exception{
		if(record.getIddependenciadocumentotecnico()==null)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.iddependenciadocumentotecnico.required"));
		if(record.getIddocumentotecnico()==null)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.iddocumentotecnico.required"));
		if(record.getDireccion()==null)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.direccion.required"));

		if(record.getDireccion()!=null &&  record.getDireccion().length() > 100)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.direccion.length.error",record.getDireccion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_iddependenciadocumentotecnico)throws Exception{
		if(par_iddependenciadocumentotecnico==null)
			throw new ValidateException(Messages.getString("dependenciadocumentotecnico.iddependenciadocumentotecnico.required"));

		//Here Bussines Validations.
	}


}

