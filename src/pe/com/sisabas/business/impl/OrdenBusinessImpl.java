
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
import pe.com.sisabas.be.Orden;
import pe.com.sisabas.persistence.OrdenMapper;
import pe.com.sisabas.business.OrdenBusiness;
import pe.com.sisabas.dto.OrdenDto;
import pe.com.sisabas.dto.OrdenListaDto;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class OrdenBusinessImpl implements OrdenBusiness, Serializable{

	private static Logger logger=Logger.getLogger(OrdenBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public OrdenMapper ordenMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Orden par_record) throws Exception {
		validateDelete(par_record.getIdorden());
		ordenMapper.deleteByPrimaryKey(par_record.getIdorden());
	}

	@Override
	public void insertBasic(Orden record) throws Exception {
		record.setIdorden((int)utilsBusiness.getNextSeq(Sequence.SEQ_ORDEN).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		ordenMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Orden record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Orden record) throws Exception {
		record.setIdorden((int)utilsBusiness.getNextSeq(Sequence.SEQ_ORDEN).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		ordenMapper.insertSelective(record);
	}

	@Override
	public Orden selectByPrimaryKeyBasic(java.lang.Integer par_idorden) throws Exception {
		return ordenMapper.selectByPrimaryKeyBasic(par_idorden);
	}

	@Override
	public Orden selectByPrimaryKeyBasicFromList(java.lang.Integer par_idorden, List<Orden> list) throws Exception {
		Orden record=null;
		for (Orden row : list) {
			if(row.equals(new Orden( par_idorden))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idorden);

		return record;
	}

	@Override
	public Orden selectByPrimaryKeyBasicActive(java.lang.Integer par_idorden) throws Exception {
		return ordenMapper.selectByPrimaryKeyBasicActive(par_idorden);
	}

	@Override
	public Orden selectByPrimaryKeyFull(java.lang.Integer par_idorden) throws Exception {
		return ordenMapper.selectByPrimaryKeyFull(par_idorden);
	}

	@Override
	public Orden selectByPrimaryKeyFullActive(java.lang.Integer par_idorden) throws Exception {
		return ordenMapper.selectByPrimaryKeyFullActive(par_idorden);
	}

	@Override
	public List<Orden> selectDynamicBasic(Orden record) throws Exception {
		return ordenMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Orden> selectDynamicBasicActives(Orden record) throws Exception {
		record.setEstadoauditoria("1");
		return ordenMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Orden> selectDynamicFull(Orden record) throws Exception {
		List<Orden> list=ordenMapper.selectDynamicFull(record);
		if(Orden.HAVE_BIGDECIMALS)
		for (Orden row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Orden> selectDynamicFullActives(Orden record) throws Exception {
		record.setEstadoauditoria("1");
		return ordenMapper.selectDynamicFull(record);
	}

	@Override
	public List<Orden> selectDynamicExtended(Orden record) throws Exception {
		return ordenMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Orden> selectDynamicExtendedActives(Orden record) throws Exception {
		record.setEstadoauditoria("1");
		return ordenMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Orden record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		ordenMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Orden record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Orden record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		ordenMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Orden record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Orden record) throws Exception {
	}

	public void validateInsert(Orden record)throws Exception{
		if(record.getIdorden()==null)
			throw new ValidateException(Messages.getString("orden.idorden.required"));
		if(record.getIdgrupodocumento()==null)
			throw new ValidateException(Messages.getString("orden.idgrupodocumento.required"));

		if(record.getNroorden()!=null &&  record.getNroorden().length() > 10)
			throw new ValidateException(Messages.getString("orden.nroorden.length.error",record.getNroorden().length()));
		if(record.getNroexpedientesiaf()!=null &&  record.getNroexpedientesiaf().length() > 10)
			throw new ValidateException(Messages.getString("orden.nroexpedientesiaf.length.error",record.getNroexpedientesiaf().length()));
		if(record.getMoneda()!=null &&  record.getMoneda().length() > 10)
			throw new ValidateException(Messages.getString("orden.moneda.length.error",record.getMoneda().length()));
		if(record.getNroproceso()!=null &&  record.getNroproceso().length() > 15)
			throw new ValidateException(Messages.getString("orden.nroproceso.length.error",record.getNroproceso().length()));
		if(record.getNrocontrato()!=null &&  record.getNrocontrato().length() > 20)
			throw new ValidateException(Messages.getString("orden.nrocontrato.length.error",record.getNrocontrato().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("orden.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("orden.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 20)
			throw new ValidateException(Messages.getString("orden.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("orden.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("orden.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("orden.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Orden record)throws Exception{
		if(record.getIdorden()==null)
			throw new ValidateException(Messages.getString("orden.idorden.required"));
		if(record.getIdgrupodocumento()==null)
			throw new ValidateException(Messages.getString("orden.idgrupodocumento.required"));

		if(record.getNroorden()!=null &&  record.getNroorden().length() > 10)
			throw new ValidateException(Messages.getString("orden.nroorden.length.error",record.getNroorden().length()));
		if(record.getNroexpedientesiaf()!=null &&  record.getNroexpedientesiaf().length() > 10)
			throw new ValidateException(Messages.getString("orden.nroexpedientesiaf.length.error",record.getNroexpedientesiaf().length()));
		if(record.getMoneda()!=null &&  record.getMoneda().length() > 10)
			throw new ValidateException(Messages.getString("orden.moneda.length.error",record.getMoneda().length()));
		if(record.getNroproceso()!=null &&  record.getNroproceso().length() > 15)
			throw new ValidateException(Messages.getString("orden.nroproceso.length.error",record.getNroproceso().length()));
		if(record.getNrocontrato()!=null &&  record.getNrocontrato().length() > 20)
			throw new ValidateException(Messages.getString("orden.nrocontrato.length.error",record.getNrocontrato().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("orden.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("orden.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 20)
			throw new ValidateException(Messages.getString("orden.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("orden.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("orden.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("orden.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idorden)throws Exception{
		if(par_idorden==null)
			throw new ValidateException(Messages.getString("orden.idorden.required"));

		//Here Bussines Validations.
	}

	@Override
	public List<OrdenDto> getListaOrden(OrdenListaDto request) throws Exception {
		if(request.getEjercicio()==null)
		 request.setEjercicio("");
		return ordenMapper.getListaOrden(request);
	}

	@Override
	public List<Orden> getOrdenByIdContrato(Integer idContrato) throws Exception {
		
		return ordenMapper.getOrdenByIdContrato(idContrato);
	}


}

