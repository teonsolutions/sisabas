
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
import pe.com.sisabas.be.Vcentrocosto;
import pe.com.sisabas.persistence.VcentrocostoMapper;
import pe.com.sisabas.business.VcentrocostoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class VcentrocostoBusinessImpl implements VcentrocostoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(VcentrocostoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public VcentrocostoMapper vcentrocostoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Vcentrocosto par_record) throws Exception {
		validateDelete(par_record.getCodigocentrocosto());
		vcentrocostoMapper.deleteByPrimaryKey(par_record.getCodigocentrocosto());
	}

	@Override
	public void insertBasic(Vcentrocosto record) throws Exception {
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		vcentrocostoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Vcentrocosto record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Vcentrocosto record) throws Exception {
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		vcentrocostoMapper.insertSelective(record);
	}

	@Override
	public Vcentrocosto selectByPrimaryKeyBasic(java.lang.String par_codigocentrocosto) throws Exception {
		return vcentrocostoMapper.selectByPrimaryKeyBasic(par_codigocentrocosto);
	}

	@Override
	public Vcentrocosto selectByPrimaryKeyBasicFromList(java.lang.String par_codigocentrocosto, List<Vcentrocosto> list) throws Exception {
		Vcentrocosto record=null;
		for (Vcentrocosto row : list) {
			if(row.equals(new Vcentrocosto( par_codigocentrocosto))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_codigocentrocosto);

		return record;
	}

	@Override
	public Vcentrocosto selectByPrimaryKeyBasicActive(java.lang.String par_codigocentrocosto) throws Exception {
		return vcentrocostoMapper.selectByPrimaryKeyBasicActive(par_codigocentrocosto);
	}

	@Override
	public Vcentrocosto selectByPrimaryKeyFull(java.lang.String par_codigocentrocosto) throws Exception {
		return vcentrocostoMapper.selectByPrimaryKeyFull(par_codigocentrocosto);
	}

	@Override
	public Vcentrocosto selectByPrimaryKeyFullActive(java.lang.String par_codigocentrocosto) throws Exception {
		return vcentrocostoMapper.selectByPrimaryKeyFullActive(par_codigocentrocosto);
	}

	@Override
	public List<Vcentrocosto> selectDynamicBasic(Vcentrocosto record) throws Exception {
		return vcentrocostoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Vcentrocosto> selectDynamicBasicActives(Vcentrocosto record) throws Exception {
		record.setEstadoauditoria("1");
		return vcentrocostoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Vcentrocosto> selectDynamicFull(Vcentrocosto record) throws Exception {
		List<Vcentrocosto> list=vcentrocostoMapper.selectDynamicFull(record);
		if(Vcentrocosto.HAVE_BIGDECIMALS)
		for (Vcentrocosto row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Vcentrocosto> selectDynamicFullActives(Vcentrocosto record) throws Exception {
		record.setEstadoauditoria("1");
		return vcentrocostoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Vcentrocosto> selectDynamicExtended(Vcentrocosto record) throws Exception {
		return vcentrocostoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Vcentrocosto> selectDynamicExtendedActives(Vcentrocosto record) throws Exception {
		record.setEstadoauditoria("1");
		return vcentrocostoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Vcentrocosto record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		vcentrocostoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Vcentrocosto record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Vcentrocosto record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		vcentrocostoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Vcentrocosto record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Vcentrocosto record) throws Exception {
	}

	public void validateInsert(Vcentrocosto record)throws Exception{
		if(record.getCodigocentrocosto()==null)
			throw new ValidateException(Messages.getString("vcentrocosto.codigocentrocosto.required"));

		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("vcentrocosto.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getNombredependencia()!=null &&  record.getNombredependencia().length() > 100)
			throw new ValidateException(Messages.getString("vcentrocosto.nombredependencia.length.error",record.getNombredependencia().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vcentrocosto.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vcentrocosto.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vcentrocosto.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vcentrocosto.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("vcentrocosto.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Vcentrocosto record)throws Exception{
		if(record.getCodigocentrocosto()==null)
			throw new ValidateException(Messages.getString("vcentrocosto.codigocentrocosto.required"));

		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("vcentrocosto.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getNombredependencia()!=null &&  record.getNombredependencia().length() > 100)
			throw new ValidateException(Messages.getString("vcentrocosto.nombredependencia.length.error",record.getNombredependencia().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vcentrocosto.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vcentrocosto.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vcentrocosto.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vcentrocosto.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("vcentrocosto.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.String par_codigocentrocosto)throws Exception{
		if(par_codigocentrocosto==null)
			throw new ValidateException(Messages.getString("vcentrocosto.codigocentrocosto.required"));

		//Here Bussines Validations.
	}


}

