
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
import pe.com.sisabas.be.Itinerarioconveniomarco;
import pe.com.sisabas.persistence.ItinerarioconveniomarcoMapper;
import pe.com.sisabas.business.ItinerarioconveniomarcoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class ItinerarioconveniomarcoBusinessImpl implements ItinerarioconveniomarcoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(ItinerarioconveniomarcoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public ItinerarioconveniomarcoMapper itinerarioconveniomarcoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Itinerarioconveniomarco par_record) throws Exception {
		validateDelete(par_record.getIditinerarioconveniomarco());
		itinerarioconveniomarcoMapper.deleteByPrimaryKey(par_record.getIditinerarioconveniomarco());
	}

	@Override
	public void insertBasic(Itinerarioconveniomarco record) throws Exception {
		record.setIditinerarioconveniomarco((int)utilsBusiness.getNextSeq(Sequence.SEQ_ITINERARIOCONVENIOMARCO).longValue());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		itinerarioconveniomarcoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Itinerarioconveniomarco record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Itinerarioconveniomarco record) throws Exception {
		record.setIditinerarioconveniomarco((int)utilsBusiness.getNextSeq(Sequence.SEQ_ITINERARIOCONVENIOMARCO).longValue());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		itinerarioconveniomarcoMapper.insertSelective(record);
	}

	@Override
	public Itinerarioconveniomarco selectByPrimaryKeyBasic(java.lang.Integer par_iditinerarioconveniomarco) throws Exception {
		return itinerarioconveniomarcoMapper.selectByPrimaryKeyBasic(par_iditinerarioconveniomarco);
	}

	@Override
	public Itinerarioconveniomarco selectByPrimaryKeyBasicFromList(java.lang.Integer par_iditinerarioconveniomarco, List<Itinerarioconveniomarco> list) throws Exception {
		Itinerarioconveniomarco record=null;
		for (Itinerarioconveniomarco row : list) {
			if(row.equals(new Itinerarioconveniomarco( par_iditinerarioconveniomarco))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_iditinerarioconveniomarco);

		return record;
	}

	@Override
	public Itinerarioconveniomarco selectByPrimaryKeyBasicActive(java.lang.Integer par_iditinerarioconveniomarco) throws Exception {
		return itinerarioconveniomarcoMapper.selectByPrimaryKeyBasicActive(par_iditinerarioconveniomarco);
	}

	@Override
	public Itinerarioconveniomarco selectByPrimaryKeyFull(java.lang.Integer par_iditinerarioconveniomarco) throws Exception {
		return itinerarioconveniomarcoMapper.selectByPrimaryKeyFull(par_iditinerarioconveniomarco);
	}

	@Override
	public Itinerarioconveniomarco selectByPrimaryKeyFullActive(java.lang.Integer par_iditinerarioconveniomarco) throws Exception {
		return itinerarioconveniomarcoMapper.selectByPrimaryKeyFullActive(par_iditinerarioconveniomarco);
	}

	@Override
	public List<Itinerarioconveniomarco> selectDynamicBasic(Itinerarioconveniomarco record) throws Exception {
		return itinerarioconveniomarcoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Itinerarioconveniomarco> selectDynamicBasicActives(Itinerarioconveniomarco record) throws Exception {
		record.setEstadoauditoria("1");
		return itinerarioconveniomarcoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Itinerarioconveniomarco> selectDynamicFull(Itinerarioconveniomarco record) throws Exception {
		List<Itinerarioconveniomarco> list=itinerarioconveniomarcoMapper.selectDynamicFull(record);
		if(Itinerarioconveniomarco.HAVE_BIGDECIMALS)
		for (Itinerarioconveniomarco row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Itinerarioconveniomarco> selectDynamicFullActives(Itinerarioconveniomarco record) throws Exception {
		record.setEstadoauditoria("1");
		return itinerarioconveniomarcoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Itinerarioconveniomarco> selectDynamicExtended(Itinerarioconveniomarco record) throws Exception {
		return itinerarioconveniomarcoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Itinerarioconveniomarco> selectDynamicExtendedActives(Itinerarioconveniomarco record) throws Exception {
		record.setEstadoauditoria("1");
		return itinerarioconveniomarcoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Itinerarioconveniomarco record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		itinerarioconveniomarcoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Itinerarioconveniomarco record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Itinerarioconveniomarco record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		itinerarioconveniomarcoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Itinerarioconveniomarco record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Itinerarioconveniomarco record) throws Exception {
	}

	public void validateInsert(Itinerarioconveniomarco record)throws Exception{
		if(record.getIditinerarioconveniomarco()==null)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.iditinerarioconveniomarco.required"));
		if(record.getIddocumentotecnico()==null)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.iddocumentotecnico.required"));
		if(record.getTipoitinerario()==null)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.tipoitinerario.required"));

		if(record.getTipoitinerario()!=null &&  record.getTipoitinerario().length() > 3)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.tipoitinerario.length.error",record.getTipoitinerario().length()));
		if(record.getCiudadorigen()!=null &&  record.getCiudadorigen().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.ciudadorigen.length.error",record.getCiudadorigen().length()));
		if(record.getCiudaddestino()!=null &&  record.getCiudaddestino().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.ciudaddestino.length.error",record.getCiudaddestino().length()));
		if(record.getDni()!=null &&  record.getDni().length() > 8)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.dni.length.error",record.getDni().length()));
		if(record.getApellidopaterno()!=null &&  record.getApellidopaterno().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.apellidopaterno.length.error",record.getApellidopaterno().length()));
		if(record.getApellidomaterno()!=null &&  record.getApellidomaterno().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.apellidomaterno.length.error",record.getApellidomaterno().length()));
		if(record.getNombers()!=null &&  record.getNombers().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.nombers.length.error",record.getNombers().length()));
		if(record.getCorreo()!=null &&  record.getCorreo().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.correo.length.error",record.getCorreo().length()));
		if(record.getTelefono()!=null &&  record.getTelefono().length() > 20)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.telefono.length.error",record.getTelefono().length()));
		if(record.getTipocontratopersonal()!=null &&  record.getTipocontratopersonal().length() > 3)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.tipocontratopersonal.length.error",record.getTipocontratopersonal().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 20)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Itinerarioconveniomarco record)throws Exception{
		if(record.getIditinerarioconveniomarco()==null)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.iditinerarioconveniomarco.required"));
		if(record.getIddocumentotecnico()==null)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.iddocumentotecnico.required"));
		if(record.getTipoitinerario()==null)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.tipoitinerario.required"));

		if(record.getTipoitinerario()!=null &&  record.getTipoitinerario().length() > 3)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.tipoitinerario.length.error",record.getTipoitinerario().length()));
		if(record.getCiudadorigen()!=null &&  record.getCiudadorigen().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.ciudadorigen.length.error",record.getCiudadorigen().length()));
		if(record.getCiudaddestino()!=null &&  record.getCiudaddestino().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.ciudaddestino.length.error",record.getCiudaddestino().length()));
		if(record.getDni()!=null &&  record.getDni().length() > 8)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.dni.length.error",record.getDni().length()));
		if(record.getApellidopaterno()!=null &&  record.getApellidopaterno().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.apellidopaterno.length.error",record.getApellidopaterno().length()));
		if(record.getApellidomaterno()!=null &&  record.getApellidomaterno().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.apellidomaterno.length.error",record.getApellidomaterno().length()));
		if(record.getNombers()!=null &&  record.getNombers().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.nombers.length.error",record.getNombers().length()));
		if(record.getCorreo()!=null &&  record.getCorreo().length() > 100)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.correo.length.error",record.getCorreo().length()));
		if(record.getTelefono()!=null &&  record.getTelefono().length() > 20)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.telefono.length.error",record.getTelefono().length()));
		if(record.getTipocontratopersonal()!=null &&  record.getTipocontratopersonal().length() > 3)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.tipocontratopersonal.length.error",record.getTipocontratopersonal().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 20)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_iditinerarioconveniomarco)throws Exception{
		if(par_iditinerarioconveniomarco==null)
			throw new ValidateException(Messages.getString("itinerarioconveniomarco.iditinerarioconveniomarco.required"));

		//Here Bussines Validations.
	}


}

