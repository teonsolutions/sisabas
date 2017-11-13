
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
import pe.com.sisabas.be.Persona;
import pe.com.sisabas.persistence.PersonaMapper;
import pe.com.sisabas.business.PersonaBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class PersonaBusinessImpl implements PersonaBusiness, Serializable{

	private static Logger logger=Logger.getLogger(PersonaBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public PersonaMapper personaMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Persona par_record) throws Exception {
		validateDelete(par_record.getIdpersona());
		personaMapper.deleteByPrimaryKey(par_record.getIdpersona());
	}

	@Override
	public void insertBasic(Persona record) throws Exception {
		record.setIdpersona((int)utilsBusiness.getNextSeq(Sequence.SEQ_PERSONA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		personaMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Persona record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Persona record) throws Exception {
		record.setIdpersona((int)utilsBusiness.getNextSeq(Sequence.SEQ_PERSONA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		personaMapper.insertSelective(record);
	}

	@Override
	public Persona selectByPrimaryKeyBasic(java.lang.Integer par_idpersona) throws Exception {
		return personaMapper.selectByPrimaryKeyBasic(par_idpersona);
	}

	@Override
	public Persona selectByPrimaryKeyBasicFromList(java.lang.Integer par_idpersona, List<Persona> list) throws Exception {
		Persona record=null;
		for (Persona row : list) {
			if(row.equals(new Persona( par_idpersona))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idpersona);

		return record;
	}

	@Override
	public Persona selectByPrimaryKeyBasicActive(java.lang.Integer par_idpersona) throws Exception {
		return personaMapper.selectByPrimaryKeyBasicActive(par_idpersona);
	}

	@Override
	public Persona selectByPrimaryKeyFull(java.lang.Integer par_idpersona) throws Exception {
		return personaMapper.selectByPrimaryKeyFull(par_idpersona);
	}

	@Override
	public Persona selectByPrimaryKeyFullActive(java.lang.Integer par_idpersona) throws Exception {
		return personaMapper.selectByPrimaryKeyFullActive(par_idpersona);
	}

	@Override
	public List<Persona> selectDynamicBasic(Persona record) throws Exception {
		return personaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Persona> selectDynamicBasicActives(Persona record) throws Exception {
		record.setEstadoauditoria("1");
		return personaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Persona> selectDynamicFull(Persona record) throws Exception {
		List<Persona> list=personaMapper.selectDynamicFull(record);
		if(Persona.HAVE_BIGDECIMALS)
		for (Persona row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Persona> selectDynamicFullActives(Persona record) throws Exception {
		record.setEstadoauditoria("1");
		return personaMapper.selectDynamicFull(record);
	}

	@Override
	public List<Persona> selectDynamicExtended(Persona record) throws Exception {
		return personaMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Persona> selectDynamicExtendedActives(Persona record) throws Exception {
		record.setEstadoauditoria("1");
		return personaMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Persona record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		personaMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Persona record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Persona record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		personaMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Persona record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Persona record) throws Exception {
	}

	public void validateInsert(Persona record)throws Exception{
		if(record.getIdpersona()==null)
			throw new ValidateException(Messages.getString("persona.idpersona.required"));
		if(record.getIdcatalogotipodocumento()==null)
			throw new ValidateException(Messages.getString("persona.idcatalogotipodocumento.required"));
		if(record.getNumerodocumento()==null)
			throw new ValidateException(Messages.getString("persona.numerodocumento.required"));
		if(record.getNombres()==null)
			throw new ValidateException(Messages.getString("persona.nombres.required"));
		if(record.getApellidopaterno()==null)
			throw new ValidateException(Messages.getString("persona.apellidopaterno.required"));
		if(record.getApellidomaterno()==null)
			throw new ValidateException(Messages.getString("persona.apellidomaterno.required"));
		if(record.getEstadoauditoria()==null)
			throw new ValidateException(Messages.getString("persona.estadoauditoria.required"));
		if(record.getUsuariocreacionauditoria()==null)
			throw new ValidateException(Messages.getString("persona.usuariocreacionauditoria.required"));
		if(record.getFechacreacionauditoria()==null)
			throw new ValidateException(Messages.getString("persona.fechacreacionauditoria.required"));
		if(record.getEquipoauditoria()==null)
			throw new ValidateException(Messages.getString("persona.equipoauditoria.required"));
		if(record.getProgramaauditoria()==null)
			throw new ValidateException(Messages.getString("persona.programaauditoria.required"));

		if(record.getIdcatalogotipodocumento()!=null &&  record.getIdcatalogotipodocumento().length() > 10)
			throw new ValidateException(Messages.getString("persona.idcatalogotipodocumento.length.error",record.getIdcatalogotipodocumento().length()));
		if(record.getNumerodocumento()!=null &&  record.getNumerodocumento().length() > 10)
			throw new ValidateException(Messages.getString("persona.numerodocumento.length.error",record.getNumerodocumento().length()));
		if(record.getNombres()!=null &&  record.getNombres().length() > 40)
			throw new ValidateException(Messages.getString("persona.nombres.length.error",record.getNombres().length()));
		if(record.getApellidopaterno()!=null &&  record.getApellidopaterno().length() > 40)
			throw new ValidateException(Messages.getString("persona.apellidopaterno.length.error",record.getApellidopaterno().length()));
		if(record.getApellidomaterno()!=null &&  record.getApellidomaterno().length() > 40)
			throw new ValidateException(Messages.getString("persona.apellidomaterno.length.error",record.getApellidomaterno().length()));
		if(record.getDireccion()!=null &&  record.getDireccion().length() > 100)
			throw new ValidateException(Messages.getString("persona.direccion.length.error",record.getDireccion().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("persona.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("persona.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("persona.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("persona.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("persona.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Persona record)throws Exception{
		if(record.getIdpersona()==null)
			throw new ValidateException(Messages.getString("persona.idpersona.required"));
		if(record.getIdcatalogotipodocumento()==null)
			throw new ValidateException(Messages.getString("persona.idcatalogotipodocumento.required"));
		if(record.getNumerodocumento()==null)
			throw new ValidateException(Messages.getString("persona.numerodocumento.required"));
		if(record.getNombres()==null)
			throw new ValidateException(Messages.getString("persona.nombres.required"));
		if(record.getApellidopaterno()==null)
			throw new ValidateException(Messages.getString("persona.apellidopaterno.required"));
		if(record.getApellidomaterno()==null)
			throw new ValidateException(Messages.getString("persona.apellidomaterno.required"));
		if(record.getEstadoauditoria()==null)
			throw new ValidateException(Messages.getString("persona.estadoauditoria.required"));
		if(record.getUsuariocreacionauditoria()==null)
			throw new ValidateException(Messages.getString("persona.usuariocreacionauditoria.required"));
		if(record.getFechacreacionauditoria()==null)
			throw new ValidateException(Messages.getString("persona.fechacreacionauditoria.required"));
		if(record.getEquipoauditoria()==null)
			throw new ValidateException(Messages.getString("persona.equipoauditoria.required"));
		if(record.getProgramaauditoria()==null)
			throw new ValidateException(Messages.getString("persona.programaauditoria.required"));

		if(record.getIdcatalogotipodocumento()!=null &&  record.getIdcatalogotipodocumento().length() > 10)
			throw new ValidateException(Messages.getString("persona.idcatalogotipodocumento.length.error",record.getIdcatalogotipodocumento().length()));
		if(record.getNumerodocumento()!=null &&  record.getNumerodocumento().length() > 10)
			throw new ValidateException(Messages.getString("persona.numerodocumento.length.error",record.getNumerodocumento().length()));
		if(record.getNombres()!=null &&  record.getNombres().length() > 40)
			throw new ValidateException(Messages.getString("persona.nombres.length.error",record.getNombres().length()));
		if(record.getApellidopaterno()!=null &&  record.getApellidopaterno().length() > 40)
			throw new ValidateException(Messages.getString("persona.apellidopaterno.length.error",record.getApellidopaterno().length()));
		if(record.getApellidomaterno()!=null &&  record.getApellidomaterno().length() > 40)
			throw new ValidateException(Messages.getString("persona.apellidomaterno.length.error",record.getApellidomaterno().length()));
		if(record.getDireccion()!=null &&  record.getDireccion().length() > 100)
			throw new ValidateException(Messages.getString("persona.direccion.length.error",record.getDireccion().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("persona.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("persona.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("persona.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("persona.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("persona.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idpersona)throws Exception{
		if(par_idpersona==null)
			throw new ValidateException(Messages.getString("persona.idpersona.required"));

		//Here Bussines Validations.
	}


}

