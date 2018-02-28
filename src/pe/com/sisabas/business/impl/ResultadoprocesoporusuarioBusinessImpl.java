
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
import pe.com.sisabas.be.Resultadoprocesoporusuario;
import pe.com.sisabas.persistence.ResultadoprocesoporusuarioMapper;
import pe.com.sisabas.business.ResultadoprocesoporusuarioBusiness;
import pe.com.sisabas.dto.ProcesoResultadoItemDesiertoAsigDto;
import pe.com.sisabas.dto.ResultadoItemsRequest;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class ResultadoprocesoporusuarioBusinessImpl implements ResultadoprocesoporusuarioBusiness, Serializable{

	private static Logger logger=Logger.getLogger(ResultadoprocesoporusuarioBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public ResultadoprocesoporusuarioMapper resultadoprocesoporusuarioMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Resultadoprocesoporusuario par_record) throws Exception {
		validateDelete(par_record.getIdresultadoprocesousuario());
		resultadoprocesoporusuarioMapper.deleteByPrimaryKey(par_record.getIdresultadoprocesousuario());
	}

	@Override
	public void insertBasic(Resultadoprocesoporusuario record) throws Exception {
		record.setIdresultadoprocesousuario((int)utilsBusiness.getNextSeq(Sequence.SEQ_RESULTADOPROCESOPORUSUARIO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		resultadoprocesoporusuarioMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Resultadoprocesoporusuario record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Resultadoprocesoporusuario record) throws Exception {
		record.setIdresultadoprocesousuario((int)utilsBusiness.getNextSeq(Sequence.SEQ_RESULTADOPROCESOPORUSUARIO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		resultadoprocesoporusuarioMapper.insertSelective(record);
	}

	@Override
	public Resultadoprocesoporusuario selectByPrimaryKeyBasic(java.lang.Integer par_idresultadoprocesousuario) throws Exception {
		return resultadoprocesoporusuarioMapper.selectByPrimaryKeyBasic(par_idresultadoprocesousuario);
	}

	@Override
	public Resultadoprocesoporusuario selectByPrimaryKeyBasicFromList(java.lang.Integer par_idresultadoprocesousuario, List<Resultadoprocesoporusuario> list) throws Exception {
		Resultadoprocesoporusuario record=null;
		for (Resultadoprocesoporusuario row : list) {
			if(row.equals(new Resultadoprocesoporusuario( par_idresultadoprocesousuario))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idresultadoprocesousuario);

		return record;
	}

	@Override
	public Resultadoprocesoporusuario selectByPrimaryKeyBasicActive(java.lang.Integer par_idresultadoprocesousuario) throws Exception {
		return resultadoprocesoporusuarioMapper.selectByPrimaryKeyBasicActive(par_idresultadoprocesousuario);
	}

	@Override
	public Resultadoprocesoporusuario selectByPrimaryKeyFull(java.lang.Integer par_idresultadoprocesousuario) throws Exception {
		return resultadoprocesoporusuarioMapper.selectByPrimaryKeyFull(par_idresultadoprocesousuario);
	}

	@Override
	public Resultadoprocesoporusuario selectByPrimaryKeyFullActive(java.lang.Integer par_idresultadoprocesousuario) throws Exception {
		return resultadoprocesoporusuarioMapper.selectByPrimaryKeyFullActive(par_idresultadoprocesousuario);
	}

	@Override
	public List<Resultadoprocesoporusuario> selectDynamicBasic(Resultadoprocesoporusuario record) throws Exception {
		return resultadoprocesoporusuarioMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Resultadoprocesoporusuario> selectDynamicBasicActives(Resultadoprocesoporusuario record) throws Exception {
		record.setEstadoauditoria("1");
		return resultadoprocesoporusuarioMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Resultadoprocesoporusuario> selectDynamicFull(Resultadoprocesoporusuario record) throws Exception {
		List<Resultadoprocesoporusuario> list=resultadoprocesoporusuarioMapper.selectDynamicFull(record);
		if(Resultadoprocesoporusuario.HAVE_BIGDECIMALS)
		for (Resultadoprocesoporusuario row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Resultadoprocesoporusuario> selectDynamicFullActives(Resultadoprocesoporusuario record) throws Exception {
		record.setEstadoauditoria("1");
		return resultadoprocesoporusuarioMapper.selectDynamicFull(record);
	}

	@Override
	public List<Resultadoprocesoporusuario> selectDynamicExtended(Resultadoprocesoporusuario record) throws Exception {
		return resultadoprocesoporusuarioMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Resultadoprocesoporusuario> selectDynamicExtendedActives(Resultadoprocesoporusuario record) throws Exception {
		record.setEstadoauditoria("1");
		return resultadoprocesoporusuarioMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Resultadoprocesoporusuario record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		resultadoprocesoporusuarioMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Resultadoprocesoporusuario record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Resultadoprocesoporusuario record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		resultadoprocesoporusuarioMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Resultadoprocesoporusuario record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Resultadoprocesoporusuario record) throws Exception {
	}

	public void validateInsert(Resultadoprocesoporusuario record)throws Exception{
		if(record.getIdresultadoprocesousuario()==null)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.idresultadoprocesousuario.required"));

		if(record.getNroitem()!=null &&  record.getNroitem().length() > 12)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.nroitem.length.error",record.getNroitem().length()));
		if(record.getNombreitem()!=null &&  record.getNombreitem().length() > 150)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.nombreitem.length.error",record.getNombreitem().length()));
		if(record.getUsuarioasignado()!=null &&  record.getUsuarioasignado().length() > 15)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.usuarioasignado.length.error",record.getUsuarioasignado().length()));
		if(record.getNumerodocumento()!=null &&  record.getNumerodocumento().length() > 20)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.numerodocumento.length.error",record.getNumerodocumento().length()));
		if(record.getNumeroadjsimplificada()!=null &&  record.getNumeroadjsimplificada().length() > 20)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.numeroadjsimplificada.length.error",record.getNumeroadjsimplificada().length()));
		if(record.getEsactivo()!=null &&  record.getEsactivo().length() > 1)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.esactivo.length.error",record.getEsactivo().length()));
		if(record.getEsprocesado()!=null &&  record.getEsprocesado().length() > 1)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.esprocesado.length.error",record.getEsprocesado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Resultadoprocesoporusuario record)throws Exception{
		if(record.getIdresultadoprocesousuario()==null)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.idresultadoprocesousuario.required"));

		if(record.getNroitem()!=null &&  record.getNroitem().length() > 12)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.nroitem.length.error",record.getNroitem().length()));
		if(record.getNombreitem()!=null &&  record.getNombreitem().length() > 150)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.nombreitem.length.error",record.getNombreitem().length()));
		if(record.getUsuarioasignado()!=null &&  record.getUsuarioasignado().length() > 15)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.usuarioasignado.length.error",record.getUsuarioasignado().length()));
		if(record.getNumerodocumento()!=null &&  record.getNumerodocumento().length() > 20)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.numerodocumento.length.error",record.getNumerodocumento().length()));
		if(record.getNumeroadjsimplificada()!=null &&  record.getNumeroadjsimplificada().length() > 20)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.numeroadjsimplificada.length.error",record.getNumeroadjsimplificada().length()));
		if(record.getEsactivo()!=null &&  record.getEsactivo().length() > 1)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.esactivo.length.error",record.getEsactivo().length()));
		if(record.getEsprocesado()!=null &&  record.getEsprocesado().length() > 1)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.esprocesado.length.error",record.getEsprocesado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idresultadoprocesousuario)throws Exception{
		if(par_idresultadoprocesousuario==null)
			throw new ValidateException(Messages.getString("resultadoprocesoporusuario.idresultadoprocesousuario.required"));

		//Here Bussines Validations.
	}

	@Override
	public List<ProcesoResultadoItemDesiertoAsigDto> selectResultadoAsignadosUsuario(ResultadoItemsRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		return resultadoprocesoporusuarioMapper.selectResultadoAsignadosUsuario(request);
	}


}

