
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
import pe.com.sisabas.be.Estadospordocumentosiga;
import pe.com.sisabas.persistence.EstadospordocumentosigaMapper;
import pe.com.sisabas.business.EstadospordocumentosigaBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class EstadospordocumentosigaBusinessImpl implements EstadospordocumentosigaBusiness, Serializable{

	private static Logger logger=Logger.getLogger(EstadospordocumentosigaBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public EstadospordocumentosigaMapper estadospordocumentosigaMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Estadospordocumentosiga par_record) throws Exception {
		validateDelete(par_record.getIdestadospordocumentosiga());
		estadospordocumentosigaMapper.deleteByPrimaryKey(par_record.getIdestadospordocumentosiga());
	}

	@Override
	public void insertBasic(Estadospordocumentosiga record) throws Exception {
		record.setIdestadospordocumentosiga((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORDOCUMENTOSIGA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadospordocumentosigaMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Estadospordocumentosiga record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Estadospordocumentosiga record) throws Exception {
		record.setIdestadospordocumentosiga((int)utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORDOCUMENTOSIGA).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadospordocumentosigaMapper.insertSelective(record);
	}

	@Override
	public Estadospordocumentosiga selectByPrimaryKeyBasic(java.lang.Integer par_idestadospordocumentosiga) throws Exception {
		return estadospordocumentosigaMapper.selectByPrimaryKeyBasic(par_idestadospordocumentosiga);
	}

	@Override
	public Estadospordocumentosiga selectByPrimaryKeyBasicFromList(java.lang.Integer par_idestadospordocumentosiga, List<Estadospordocumentosiga> list) throws Exception {
		Estadospordocumentosiga record=null;
		for (Estadospordocumentosiga row : list) {
			if(row.equals(new Estadospordocumentosiga( par_idestadospordocumentosiga))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idestadospordocumentosiga);

		return record;
	}

	@Override
	public Estadospordocumentosiga selectByPrimaryKeyBasicActive(java.lang.Integer par_idestadospordocumentosiga) throws Exception {
		return estadospordocumentosigaMapper.selectByPrimaryKeyBasicActive(par_idestadospordocumentosiga);
	}

	@Override
	public Estadospordocumentosiga selectByPrimaryKeyFull(java.lang.Integer par_idestadospordocumentosiga) throws Exception {
		return estadospordocumentosigaMapper.selectByPrimaryKeyFull(par_idestadospordocumentosiga);
	}

	@Override
	public Estadospordocumentosiga selectByPrimaryKeyFullActive(java.lang.Integer par_idestadospordocumentosiga) throws Exception {
		return estadospordocumentosigaMapper.selectByPrimaryKeyFullActive(par_idestadospordocumentosiga);
	}

	@Override
	public List<Estadospordocumentosiga> selectDynamicBasic(Estadospordocumentosiga record) throws Exception {
		return estadospordocumentosigaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Estadospordocumentosiga> selectDynamicBasicActives(Estadospordocumentosiga record) throws Exception {
		record.setEstadoauditoria("1");
		return estadospordocumentosigaMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Estadospordocumentosiga> selectDynamicFull(Estadospordocumentosiga record) throws Exception {
		List<Estadospordocumentosiga> list=estadospordocumentosigaMapper.selectDynamicFull(record);
		if(Estadospordocumentosiga.HAVE_BIGDECIMALS)
		for (Estadospordocumentosiga row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Estadospordocumentosiga> selectDynamicFullActives(Estadospordocumentosiga record) throws Exception {
		record.setEstadoauditoria("1");
		return estadospordocumentosigaMapper.selectDynamicFull(record);
	}

	@Override
	public List<Estadospordocumentosiga> selectDynamicExtended(Estadospordocumentosiga record) throws Exception {
		return estadospordocumentosigaMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Estadospordocumentosiga> selectDynamicExtendedActives(Estadospordocumentosiga record) throws Exception {
		record.setEstadoauditoria("1");
		return estadospordocumentosigaMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Estadospordocumentosiga record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadospordocumentosigaMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Estadospordocumentosiga record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Estadospordocumentosiga record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		estadospordocumentosigaMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Estadospordocumentosiga record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Estadospordocumentosiga record) throws Exception {
	}

	public void validateInsert(Estadospordocumentosiga record)throws Exception{
		if(record.getIdestadospordocumentosiga()==null)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.idestadospordocumentosiga.required"));

		if(record.getIdcatalogotipodocumentosiga()!=null &&  record.getIdcatalogotipodocumentosiga().length() > 10)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.idcatalogotipodocumentosiga.length.error",record.getIdcatalogotipodocumentosiga().length()));
		if(record.getCodigoestadopordocumentosiga()!=null &&  record.getCodigoestadopordocumentosiga().length() > 3)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.codigoestadopordocumentosiga.length.error",record.getCodigoestadopordocumentosiga().length()));
		if(record.getDescripcionestadospordocumentosiga()!=null &&  record.getDescripcionestadospordocumentosiga().length() > 150)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.descripcionestadospordocumentosiga.length.error",record.getDescripcionestadospordocumentosiga().length()));
		if(record.getCodigotipoproceso()!=null &&  record.getCodigotipoproceso().length() > 2)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.codigotipoproceso.length.error",record.getCodigotipoproceso().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Estadospordocumentosiga record)throws Exception{
		if(record.getIdestadospordocumentosiga()==null)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.idestadospordocumentosiga.required"));

		if(record.getIdcatalogotipodocumentosiga()!=null &&  record.getIdcatalogotipodocumentosiga().length() > 10)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.idcatalogotipodocumentosiga.length.error",record.getIdcatalogotipodocumentosiga().length()));
		if(record.getCodigoestadopordocumentosiga()!=null &&  record.getCodigoestadopordocumentosiga().length() > 3)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.codigoestadopordocumentosiga.length.error",record.getCodigoestadopordocumentosiga().length()));
		if(record.getDescripcionestadospordocumentosiga()!=null &&  record.getDescripcionestadospordocumentosiga().length() > 150)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.descripcionestadospordocumentosiga.length.error",record.getDescripcionestadospordocumentosiga().length()));
		if(record.getCodigotipoproceso()!=null &&  record.getCodigotipoproceso().length() > 2)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.codigotipoproceso.length.error",record.getCodigotipoproceso().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idestadospordocumentosiga)throws Exception{
		if(par_idestadospordocumentosiga==null)
			throw new ValidateException(Messages.getString("estadospordocumentosiga.idestadospordocumentosiga.required"));

		//Here Bussines Validations.
	}


}

