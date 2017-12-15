
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
import pe.com.sisabas.be.Pacprogramado;
import pe.com.sisabas.persistence.PacprogramadoMapper;
import pe.com.sisabas.business.PacprogramadoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class PacprogramadoBusinessImpl implements PacprogramadoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(PacprogramadoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public PacprogramadoMapper pacprogramadoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Pacprogramado par_record) throws Exception {
		validateDelete(par_record.getIdpacprogramado());
		pacprogramadoMapper.deleteByPrimaryKey(par_record.getIdpacprogramado());
	}

	@Override
	public void insertBasic(Pacprogramado record) throws Exception {
		record.setIdpacprogramado((int)utilsBusiness.getNextSeq(Sequence.SEQ_PACPROGRAMADO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		pacprogramadoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Pacprogramado record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Pacprogramado record) throws Exception {
		record.setIdpacprogramado((int)utilsBusiness.getNextSeq(Sequence.SEQ_PACPROGRAMADO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		pacprogramadoMapper.insertSelective(record);
	}

	@Override
	public Pacprogramado selectByPrimaryKeyBasic(java.lang.Integer par_idpacprogramado) throws Exception {
		return pacprogramadoMapper.selectByPrimaryKeyBasic(par_idpacprogramado);
	}

	@Override
	public Pacprogramado selectByPrimaryKeyBasicFromList(java.lang.Integer par_idpacprogramado, List<Pacprogramado> list) throws Exception {
		Pacprogramado record=null;
		for (Pacprogramado row : list) {
			if(row.equals(new Pacprogramado( par_idpacprogramado))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idpacprogramado);

		return record;
	}

	@Override
	public Pacprogramado selectByPrimaryKeyBasicActive(java.lang.Integer par_idpacprogramado) throws Exception {
		return pacprogramadoMapper.selectByPrimaryKeyBasicActive(par_idpacprogramado);
	}

	@Override
	public Pacprogramado selectByPrimaryKeyFull(java.lang.Integer par_idpacprogramado) throws Exception {
		return pacprogramadoMapper.selectByPrimaryKeyFull(par_idpacprogramado);
	}

	@Override
	public Pacprogramado selectByPrimaryKeyFullActive(java.lang.Integer par_idpacprogramado) throws Exception {
		return pacprogramadoMapper.selectByPrimaryKeyFullActive(par_idpacprogramado);
	}

	@Override
	public List<Pacprogramado> selectDynamicBasic(Pacprogramado record) throws Exception {
		return pacprogramadoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Pacprogramado> selectDynamicBasicActives(Pacprogramado record) throws Exception {
		record.setEstadoauditoria("1");
		return pacprogramadoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Pacprogramado> selectDynamicFull(Pacprogramado record) throws Exception {
		List<Pacprogramado> list=pacprogramadoMapper.selectDynamicFull(record);
		if(Pacprogramado.HAVE_BIGDECIMALS)
		for (Pacprogramado row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Pacprogramado> selectDynamicFullActives(Pacprogramado record) throws Exception {
		record.setEstadoauditoria("1");
		return pacprogramadoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Pacprogramado> selectDynamicExtended(Pacprogramado record) throws Exception {
		return pacprogramadoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Pacprogramado> selectDynamicExtendedActives(Pacprogramado record) throws Exception {
		record.setEstadoauditoria("1");
		return pacprogramadoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Pacprogramado record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		pacprogramadoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Pacprogramado record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Pacprogramado record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		pacprogramadoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Pacprogramado record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Pacprogramado record) throws Exception {
	}

	public void validateInsert(Pacprogramado record)throws Exception{
		if(record.getIdpacprogramado()==null)
			throw new ValidateException(Messages.getString("pacprogramado.idpacprogramado.required"));

		if(record.getNroconsolid()!=null &&  record.getNroconsolid().length() > 10)
			throw new ValidateException(Messages.getString("pacprogramado.nroconsolid.length.error",record.getNroconsolid().length()));
		if(record.getEspecificaciontecnica()!=null &&  record.getEspecificaciontecnica().length() > 100)
			throw new ValidateException(Messages.getString("pacprogramado.especificaciontecnica.length.error",record.getEspecificaciontecnica().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("pacprogramado.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("pacprogramado.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getNombredependencia()!=null &&  record.getNombredependencia().length() > 100)
			throw new ValidateException(Messages.getString("pacprogramado.nombredependencia.length.error",record.getNombredependencia().length()));
		if(record.getTipodocumentosinad()!=null &&  record.getTipodocumentosinad().length() > 50)
			throw new ValidateException(Messages.getString("pacprogramado.tipodocumentosinad.length.error",record.getTipodocumentosinad().length()));
		if(record.getNumerodocumentosinad()!=null &&  record.getNumerodocumentosinad().length() > 100)
			throw new ValidateException(Messages.getString("pacprogramado.numerodocumentosinad.length.error",record.getNumerodocumentosinad().length()));
		if(record.getNumeroexpedientesinad()!=null &&  record.getNumeroexpedientesinad().length() > 30)
			throw new ValidateException(Messages.getString("pacprogramado.numeroexpedientesinad.length.error",record.getNumeroexpedientesinad().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pacprogramado.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pacprogramado.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("pacprogramado.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("pacprogramado.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("pacprogramado.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Pacprogramado record)throws Exception{
		if(record.getIdpacprogramado()==null)
			throw new ValidateException(Messages.getString("pacprogramado.idpacprogramado.required"));

		if(record.getNroconsolid()!=null &&  record.getNroconsolid().length() > 10)
			throw new ValidateException(Messages.getString("pacprogramado.nroconsolid.length.error",record.getNroconsolid().length()));
		if(record.getEspecificaciontecnica()!=null &&  record.getEspecificaciontecnica().length() > 100)
			throw new ValidateException(Messages.getString("pacprogramado.especificaciontecnica.length.error",record.getEspecificaciontecnica().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("pacprogramado.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getCodigocentrocosto()!=null &&  record.getCodigocentrocosto().length() > 15)
			throw new ValidateException(Messages.getString("pacprogramado.codigocentrocosto.length.error",record.getCodigocentrocosto().length()));
		if(record.getNombredependencia()!=null &&  record.getNombredependencia().length() > 100)
			throw new ValidateException(Messages.getString("pacprogramado.nombredependencia.length.error",record.getNombredependencia().length()));
		if(record.getTipodocumentosinad()!=null &&  record.getTipodocumentosinad().length() > 50)
			throw new ValidateException(Messages.getString("pacprogramado.tipodocumentosinad.length.error",record.getTipodocumentosinad().length()));
		if(record.getNumerodocumentosinad()!=null &&  record.getNumerodocumentosinad().length() > 100)
			throw new ValidateException(Messages.getString("pacprogramado.numerodocumentosinad.length.error",record.getNumerodocumentosinad().length()));
		if(record.getNumeroexpedientesinad()!=null &&  record.getNumeroexpedientesinad().length() > 30)
			throw new ValidateException(Messages.getString("pacprogramado.numeroexpedientesinad.length.error",record.getNumeroexpedientesinad().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pacprogramado.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pacprogramado.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("pacprogramado.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("pacprogramado.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("pacprogramado.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idpacprogramado)throws Exception{
		if(par_idpacprogramado==null)
			throw new ValidateException(Messages.getString("pacprogramado.idpacprogramado.required"));

		//Here Bussines Validations.
	}


}

