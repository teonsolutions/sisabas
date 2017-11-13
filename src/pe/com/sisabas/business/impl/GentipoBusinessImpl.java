
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
import pe.com.sisabas.be.Gentipo;
import pe.com.sisabas.persistence.GentipoMapper;
import pe.com.sisabas.business.GentipoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class GentipoBusinessImpl implements GentipoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(GentipoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public GentipoMapper gentipoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Gentipo par_record) throws Exception {
		validateDelete(par_record.getVchtipcodigo());
		gentipoMapper.deleteByPrimaryKey(par_record.getVchtipcodigo());
	}

	@Override
	public void insertBasic(Gentipo record) throws Exception {
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		gentipoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Gentipo record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Gentipo record) throws Exception {
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		gentipoMapper.insertSelective(record);
	}

	@Override
	public Gentipo selectByPrimaryKeyBasic(java.lang.String par_vchtipcodigo) throws Exception {
		return gentipoMapper.selectByPrimaryKeyBasic(par_vchtipcodigo);
	}

	@Override
	public Gentipo selectByPrimaryKeyBasicFromList(java.lang.String par_vchtipcodigo, List<Gentipo> list) throws Exception {
		Gentipo record=null;
		for (Gentipo row : list) {
			if(row.equals(new Gentipo( par_vchtipcodigo))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_vchtipcodigo);

		return record;
	}

	@Override
	public Gentipo selectByPrimaryKeyBasicActive(java.lang.String par_vchtipcodigo) throws Exception {
		return gentipoMapper.selectByPrimaryKeyBasicActive(par_vchtipcodigo);
	}

	@Override
	public Gentipo selectByPrimaryKeyFull(java.lang.String par_vchtipcodigo) throws Exception {
		return gentipoMapper.selectByPrimaryKeyFull(par_vchtipcodigo);
	}

	@Override
	public Gentipo selectByPrimaryKeyFullActive(java.lang.String par_vchtipcodigo) throws Exception {
		return gentipoMapper.selectByPrimaryKeyFullActive(par_vchtipcodigo);
	}

	@Override
	public List<Gentipo> selectDynamicBasic(Gentipo record) throws Exception {
		return gentipoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Gentipo> selectDynamicBasicActives(Gentipo record) throws Exception {
		record.setEstadoauditoria("1");
		return gentipoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Gentipo> selectDynamicFull(Gentipo record) throws Exception {
		List<Gentipo> list=gentipoMapper.selectDynamicFull(record);
		if(Gentipo.HAVE_BIGDECIMALS)
		for (Gentipo row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Gentipo> selectDynamicFullActives(Gentipo record) throws Exception {
		record.setEstadoauditoria("1");
		return gentipoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Gentipo> selectDynamicExtended(Gentipo record) throws Exception {
		return gentipoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Gentipo> selectDynamicExtendedActives(Gentipo record) throws Exception {
		record.setEstadoauditoria("1");
		return gentipoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Gentipo record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		gentipoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Gentipo record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Gentipo record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		gentipoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Gentipo record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Gentipo record) throws Exception {
		if(record.getBooleanestadoauditoria()!=null && record.getBooleanestadoauditoria()){
			record.setEstadoauditoria("1");
		}else{
			record.setEstadoauditoria("0");
		}

	}

	public void validateInsert(Gentipo record)throws Exception{
		if(record.getVchtipcodigo()==null)
			throw new ValidateException(Messages.getString("gentipo.vchtipcodigo.required"));
		if(record.getVchtipdescripcion()==null)
			throw new ValidateException(Messages.getString("gentipo.vchtipdescripcion.required"));
		if(record.getEstadoauditoria()==null)
			throw new ValidateException(Messages.getString("gentipo.estadoauditoria.required"));
		if(record.getUsuariocreacionauditoria()==null)
			throw new ValidateException(Messages.getString("gentipo.usuariocreacionauditoria.required"));
		if(record.getFechacreacionauditoria()==null)
			throw new ValidateException(Messages.getString("gentipo.fechacreacionauditoria.required"));
		if(record.getEquipoauditoria()==null)
			throw new ValidateException(Messages.getString("gentipo.equipoauditoria.required"));
		if(record.getProgramaauditoria()==null)
			throw new ValidateException(Messages.getString("gentipo.programaauditoria.required"));

		if(record.getVchtipcodigo()!=null &&  record.getVchtipcodigo().length() > 10)
			throw new ValidateException(Messages.getString("gentipo.vchtipcodigo.length.error",record.getVchtipcodigo().length()));
		if(record.getVchtipdescripcion()!=null &&  record.getVchtipdescripcion().length() > 80)
			throw new ValidateException(Messages.getString("gentipo.vchtipdescripcion.length.error",record.getVchtipdescripcion().length()));
		if(record.getVchtipdesadicional()!=null &&  record.getVchtipdesadicional().length() > 200)
			throw new ValidateException(Messages.getString("gentipo.vchtipdesadicional.length.error",record.getVchtipdesadicional().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("gentipo.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 10)
			throw new ValidateException(Messages.getString("gentipo.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 10)
			throw new ValidateException(Messages.getString("gentipo.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("gentipo.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("gentipo.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Gentipo record)throws Exception{
		if(record.getVchtipcodigo()==null)
			throw new ValidateException(Messages.getString("gentipo.vchtipcodigo.required"));
		if(record.getVchtipdescripcion()==null)
			throw new ValidateException(Messages.getString("gentipo.vchtipdescripcion.required"));
		if(record.getEstadoauditoria()==null)
			throw new ValidateException(Messages.getString("gentipo.estadoauditoria.required"));
		if(record.getUsuariocreacionauditoria()==null)
			throw new ValidateException(Messages.getString("gentipo.usuariocreacionauditoria.required"));
		if(record.getFechacreacionauditoria()==null)
			throw new ValidateException(Messages.getString("gentipo.fechacreacionauditoria.required"));
		if(record.getEquipoauditoria()==null)
			throw new ValidateException(Messages.getString("gentipo.equipoauditoria.required"));
		if(record.getProgramaauditoria()==null)
			throw new ValidateException(Messages.getString("gentipo.programaauditoria.required"));

		if(record.getVchtipcodigo()!=null &&  record.getVchtipcodigo().length() > 10)
			throw new ValidateException(Messages.getString("gentipo.vchtipcodigo.length.error",record.getVchtipcodigo().length()));
		if(record.getVchtipdescripcion()!=null &&  record.getVchtipdescripcion().length() > 80)
			throw new ValidateException(Messages.getString("gentipo.vchtipdescripcion.length.error",record.getVchtipdescripcion().length()));
		if(record.getVchtipdesadicional()!=null &&  record.getVchtipdesadicional().length() > 200)
			throw new ValidateException(Messages.getString("gentipo.vchtipdesadicional.length.error",record.getVchtipdesadicional().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("gentipo.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 10)
			throw new ValidateException(Messages.getString("gentipo.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 10)
			throw new ValidateException(Messages.getString("gentipo.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("gentipo.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("gentipo.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.String par_vchtipcodigo)throws Exception{
		if(par_vchtipcodigo==null)
			throw new ValidateException(Messages.getString("gentipo.vchtipcodigo.required"));

		//Here Bussines Validations.
	}


}

