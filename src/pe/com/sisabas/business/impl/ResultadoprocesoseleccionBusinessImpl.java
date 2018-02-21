
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
import pe.com.sisabas.be.Resultadoprocesoseleccion;
import pe.com.sisabas.persistence.ResultadoprocesoseleccionMapper;
import pe.com.sisabas.business.ResultadoprocesoseleccionBusiness;
import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.ProcesoResultadoItemDesiertoDto;
import pe.com.sisabas.dto.ProcesoResultadoItemDto;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class ResultadoprocesoseleccionBusinessImpl implements ResultadoprocesoseleccionBusiness, Serializable{

	private static Logger logger=Logger.getLogger(ResultadoprocesoseleccionBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public ResultadoprocesoseleccionMapper resultadoprocesoseleccionMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Resultadoprocesoseleccion par_record) throws Exception {
		validateDelete(par_record.getIdresultadoproceso());
		resultadoprocesoseleccionMapper.deleteByPrimaryKey(par_record.getIdresultadoproceso());
	}

	@Override
	public void insertBasic(Resultadoprocesoseleccion record) throws Exception {
		record.setIdresultadoproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_RESULTADOPROCESOSELECCION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		resultadoprocesoseleccionMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Resultadoprocesoseleccion record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Resultadoprocesoseleccion record) throws Exception {
		record.setIdresultadoproceso((int)utilsBusiness.getNextSeq(Sequence.SEQ_RESULTADOPROCESOSELECCION).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		resultadoprocesoseleccionMapper.insertSelective(record);
	}

	@Override
	public Resultadoprocesoseleccion selectByPrimaryKeyBasic(java.lang.Integer par_idresultadoproceso) throws Exception {
		return resultadoprocesoseleccionMapper.selectByPrimaryKeyBasic(par_idresultadoproceso);
	}

	@Override
	public Resultadoprocesoseleccion selectByPrimaryKeyBasicFromList(java.lang.Integer par_idresultadoproceso, List<Resultadoprocesoseleccion> list) throws Exception {
		Resultadoprocesoseleccion record=null;
		for (Resultadoprocesoseleccion row : list) {
			if(row.equals(new Resultadoprocesoseleccion( par_idresultadoproceso))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idresultadoproceso);

		return record;
	}

	@Override
	public Resultadoprocesoseleccion selectByPrimaryKeyBasicActive(java.lang.Integer par_idresultadoproceso) throws Exception {
		return resultadoprocesoseleccionMapper.selectByPrimaryKeyBasicActive(par_idresultadoproceso);
	}

	@Override
	public Resultadoprocesoseleccion selectByPrimaryKeyFull(java.lang.Integer par_idresultadoproceso) throws Exception {
		return resultadoprocesoseleccionMapper.selectByPrimaryKeyFull(par_idresultadoproceso);
	}

	@Override
	public Resultadoprocesoseleccion selectByPrimaryKeyFullActive(java.lang.Integer par_idresultadoproceso) throws Exception {
		return resultadoprocesoseleccionMapper.selectByPrimaryKeyFullActive(par_idresultadoproceso);
	}

	@Override
	public List<Resultadoprocesoseleccion> selectDynamicBasic(Resultadoprocesoseleccion record) throws Exception {
		return resultadoprocesoseleccionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Resultadoprocesoseleccion> selectDynamicBasicActives(Resultadoprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return resultadoprocesoseleccionMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Resultadoprocesoseleccion> selectDynamicFull(Resultadoprocesoseleccion record) throws Exception {
		List<Resultadoprocesoseleccion> list=resultadoprocesoseleccionMapper.selectDynamicFull(record);
		if(Resultadoprocesoseleccion.HAVE_BIGDECIMALS)
		for (Resultadoprocesoseleccion row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Resultadoprocesoseleccion> selectDynamicFullActives(Resultadoprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return resultadoprocesoseleccionMapper.selectDynamicFull(record);
	}

	@Override
	public List<Resultadoprocesoseleccion> selectDynamicExtended(Resultadoprocesoseleccion record) throws Exception {
		return resultadoprocesoseleccionMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Resultadoprocesoseleccion> selectDynamicExtendedActives(Resultadoprocesoseleccion record) throws Exception {
		record.setEstadoauditoria("1");
		return resultadoprocesoseleccionMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Resultadoprocesoseleccion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		resultadoprocesoseleccionMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Resultadoprocesoseleccion record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Resultadoprocesoseleccion record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		resultadoprocesoseleccionMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Resultadoprocesoseleccion record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Resultadoprocesoseleccion record) throws Exception {
	}

	public void validateInsert(Resultadoprocesoseleccion record)throws Exception{
		if(record.getIdresultadoproceso()==null)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.idresultadoproceso.required"));
		if(record.getIdconvocatoriaproceso()==null)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.idconvocatoriaproceso.required"));

		if(record.getNroitem()!=null &&  record.getNroitem().length() > 12)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.nroitem.length.error",record.getNroitem().length()));
		if(record.getNombreitem()!=null &&  record.getNombreitem().length() > 150)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.nombreitem.length.error",record.getNombreitem().length()));
		if(record.getNroruc()!=null &&  record.getNroruc().length() > 11)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.nroruc.length.error",record.getNroruc().length()));
		if(record.getNombreproveedor()!=null &&  record.getNombreproveedor().length() > 150)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.nombreproveedor.length.error",record.getNombreproveedor().length()));
		if(record.getIdcatalogoestadoresultado()!=null &&  record.getIdcatalogoestadoresultado().length() > 10)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.idcatalogoestadoresultado.length.error",record.getIdcatalogoestadoresultado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Resultadoprocesoseleccion record)throws Exception{
		if(record.getIdresultadoproceso()==null)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.idresultadoproceso.required"));
		if(record.getIdconvocatoriaproceso()==null)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.idconvocatoriaproceso.required"));

		if(record.getNroitem()!=null &&  record.getNroitem().length() > 12)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.nroitem.length.error",record.getNroitem().length()));
		if(record.getNombreitem()!=null &&  record.getNombreitem().length() > 150)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.nombreitem.length.error",record.getNombreitem().length()));
		if(record.getNroruc()!=null &&  record.getNroruc().length() > 11)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.nroruc.length.error",record.getNroruc().length()));
		if(record.getNombreproveedor()!=null &&  record.getNombreproveedor().length() > 150)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.nombreproveedor.length.error",record.getNombreproveedor().length()));
		if(record.getIdcatalogoestadoresultado()!=null &&  record.getIdcatalogoestadoresultado().length() > 10)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.idcatalogoestadoresultado.length.error",record.getIdcatalogoestadoresultado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idresultadoproceso)throws Exception{
		if(par_idresultadoproceso==null)
			throw new ValidateException(Messages.getString("resultadoprocesoseleccion.idresultadoproceso.required"));

		//Here Bussines Validations.
	}

	@Override
	public List<ProcesoResultadoItemDesiertoDto> selectResultadoByEstadoByIdProcesoSeleccion(ProcesoRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		return resultadoprocesoseleccionMapper.selectResultadoByEstadoByIdProcesoSeleccion(request);
	}


}

