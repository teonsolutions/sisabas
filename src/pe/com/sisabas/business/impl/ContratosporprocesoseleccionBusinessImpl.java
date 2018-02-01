
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
import pe.com.sisabas.be.Contratosporprocesoseleccion;
import pe.com.sisabas.persistence.ContratosporprocesoseleccionMapper;
import pe.com.sisabas.business.ContratosporprocesoseleccionBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class ContratosporprocesoseleccionBusinessImpl implements ContratosporprocesoseleccionBusiness, Serializable{

	private static Logger logger=Logger.getLogger(ContratosporprocesoseleccionBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public ContratosporprocesoseleccionMapper contratosporprocesoseleccionMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Contratosporprocesoseleccion par_record) throws Exception {
		validateDelete(par_record.getIdcontratoporproceso());
		contratosporprocesoseleccionMapper.deleteByPrimaryKey(par_record.getIdcontratoporproceso());
	}

	@Override
	public void insertBasic(Contratosporprocesoseleccion record) throws Exception {
		record.setIdcontratoporproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_CONVOCATORIAPROCESOSELECCION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		contratosporprocesoseleccionMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Contratosporprocesoseleccion record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Contratosporprocesoseleccion record) throws Exception {
		record.setIdcontratoporproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_CONVOCATORIAPROCESOSELECCION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		contratosporprocesoseleccionMapper.insertSelective(record);
	}

	@Override
	public Contratosporprocesoseleccion selectByPrimaryKeyBasic(java.lang.Integer par_idcontratoporproceso) throws Exception {
		return contratosporprocesoseleccionMapper.selectByPrimaryKeyBasic(par_idcontratoporproceso);
	}

	@Override
	public Contratosporprocesoseleccion selectByPrimaryKeyBasicFromList(java.lang.Integer par_idcontratoporproceso, List<Contratosporprocesoseleccion> list) throws Exception {
		Contratosporprocesoseleccion record=null;
		for (Contratosporprocesoseleccion row : list) {
			if(row.equals(new Contratosporprocesoseleccion( par_idcontratoporproceso))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idcontratoporproceso);

		return record;
	}

	@Override
	public Contratosporprocesoseleccion selectByPrimaryKeyBasicActive(java.lang.Integer par_idcontratoporproceso) throws Exception {
		return contratosporprocesoseleccionMapper.selectByPrimaryKeyBasicActive(par_idcontratoporproceso);
	}

	@Override
	public Contratosporprocesoseleccion selectByPrimaryKeyFull(java.lang.Integer par_idcontratoporproceso) throws Exception {
		return contratosporprocesoseleccionMapper.selectByPrimaryKeyFull(par_idcontratoporproceso);
	}

	@Override
	public Contratosporprocesoseleccion selectByPrimaryKeyFullActive(java.lang.Integer par_idcontratoporproceso) throws Exception {
		return contratosporprocesoseleccionMapper.selectByPrimaryKeyFullActive(par_idcontratoporproceso);
	}

	@Override
	public List<Contratosporprocesoseleccion> selectDynamicBasic(Contratosporprocesoseleccion record) throws Exception {
		return contratosporprocesoseleccionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Contratosporprocesoseleccion> selectDynamicBasicActives(Contratosporprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return contratosporprocesoseleccionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Contratosporprocesoseleccion> selectDynamicFull(Contratosporprocesoseleccion record) throws Exception {
		List<Contratosporprocesoseleccion> list=contratosporprocesoseleccionMapper.selectDynamicFull(record);
		if(Contratosporprocesoseleccion.HAVE_BIGDECIMALS)
		for (Contratosporprocesoseleccion row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Contratosporprocesoseleccion> selectDynamicFullActives(Contratosporprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return contratosporprocesoseleccionMapper.selectDynamicFull(record);
	}

	@Override
	public List<Contratosporprocesoseleccion> selectDynamicExtended(Contratosporprocesoseleccion record) throws Exception {
		return contratosporprocesoseleccionMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Contratosporprocesoseleccion> selectDynamicExtendedActives(Contratosporprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return contratosporprocesoseleccionMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Contratosporprocesoseleccion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		contratosporprocesoseleccionMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Contratosporprocesoseleccion record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Contratosporprocesoseleccion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		contratosporprocesoseleccionMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Contratosporprocesoseleccion record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Contratosporprocesoseleccion record) throws Exception {
	}

	public void validateInsert(Contratosporprocesoseleccion record)throws Exception{
		if(record.getIdcontratoporproceso()==null)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.idcontratoporproceso.required"));
		if(record.getIdprocesoseleccion()==null)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.idprocesoseleccion.required"));
		if(record.getIdcontrato()==null)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.idcontrato.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Contratosporprocesoseleccion record)throws Exception{
		if(record.getIdcontratoporproceso()==null)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.idcontratoporproceso.required"));
		if(record.getIdprocesoseleccion()==null)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.idprocesoseleccion.required"));
		if(record.getIdcontrato()==null)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.idcontrato.required"));

		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idcontratoporproceso)throws Exception{
		if(par_idcontratoporproceso==null)
			throw new ValidateException(Messages.getString("contratosporprocesoseleccion.idcontratoporproceso.required"));

		//Here Bussines Validations.
	}


}

