
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
import pe.com.sisabas.be.Genparametro;
import pe.com.sisabas.persistence.GenparametroMapper;
import pe.com.sisabas.business.GenparametroBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class GenparametroBusinessImpl implements GenparametroBusiness, Serializable{

	private static Logger logger=Logger.getLogger(GenparametroBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public GenparametroMapper genparametroMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Genparametro par_record) throws Exception {
		validateDelete(par_record.getVchparamcodigo());
		genparametroMapper.deleteByPrimaryKey(par_record.getVchparamcodigo());
	}

	@Override
	public void insertBasic(Genparametro record) throws Exception {
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		genparametroMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Genparametro record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Genparametro record) throws Exception {
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		genparametroMapper.insertSelective(record);
	}

	@Override
	public Genparametro selectByPrimaryKeyBasic(java.lang.String par_vchparamcodigo) throws Exception {
		return genparametroMapper.selectByPrimaryKeyBasic(par_vchparamcodigo);
	}

	@Override
	public Genparametro selectByPrimaryKeyBasicFromList(java.lang.String par_vchparamcodigo, List<Genparametro> list) throws Exception {
		Genparametro record=null;
		for (Genparametro row : list) {
			if(row.equals(new Genparametro( par_vchparamcodigo))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_vchparamcodigo);

		return record;
	}

	@Override
	public Genparametro selectByPrimaryKeyBasicActive(java.lang.String par_vchparamcodigo) throws Exception {
		return genparametroMapper.selectByPrimaryKeyBasicActive(par_vchparamcodigo);
	}

	@Override
	public Genparametro selectByPrimaryKeyFull(java.lang.String par_vchparamcodigo) throws Exception {
		return genparametroMapper.selectByPrimaryKeyFull(par_vchparamcodigo);
	}

	@Override
	public Genparametro selectByPrimaryKeyFullActive(java.lang.String par_vchparamcodigo) throws Exception {
		return genparametroMapper.selectByPrimaryKeyFullActive(par_vchparamcodigo);
	}

	@Override
	public List<Genparametro> selectDynamicBasic(Genparametro record) throws Exception {
		return genparametroMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Genparametro> selectDynamicBasicActives(Genparametro record) throws Exception {
		record.setEstadoauditoria("1");
		return genparametroMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Genparametro> selectDynamicFull(Genparametro record) throws Exception {
		List<Genparametro> list=genparametroMapper.selectDynamicFull(record);
		if(Genparametro.HAVE_BIGDECIMALS)
		for (Genparametro row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Genparametro> selectDynamicFullActives(Genparametro record) throws Exception {
		record.setEstadoauditoria("1");
		return genparametroMapper.selectDynamicFull(record);
	}

	@Override
	public List<Genparametro> selectDynamicExtended(Genparametro record) throws Exception {
		return genparametroMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Genparametro> selectDynamicExtendedActives(Genparametro record) throws Exception {
		record.setEstadoauditoria("1");
		return genparametroMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Genparametro record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		genparametroMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Genparametro record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Genparametro record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		genparametroMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Genparametro record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Genparametro record) throws Exception {
	}

	public void validateInsert(Genparametro record)throws Exception{
		if(record.getVchparamcodigo()==null)
			throw new ValidateException(Messages.getString("genparametro.vchparamcodigo.required"));
		if(record.getVchparamvalor()==null)
			throw new ValidateException(Messages.getString("genparametro.vchparamvalor.required"));
		if(record.getVchparamdescri()==null)
			throw new ValidateException(Messages.getString("genparametro.vchparamdescri.required"));
		if(record.getVchparamgrupo()==null)
			throw new ValidateException(Messages.getString("genparametro.vchparamgrupo.required"));
		if(record.getEstadoauditoria()==null)
			throw new ValidateException(Messages.getString("genparametro.estadoauditoria.required"));
		if(record.getUsuariocreacionauditoria()==null)
			throw new ValidateException(Messages.getString("genparametro.usuariocreacionauditoria.required"));
		if(record.getFechacreacionauditoria()==null)
			throw new ValidateException(Messages.getString("genparametro.fechacreacionauditoria.required"));

		if(record.getVchparamcodigo()!=null &&  record.getVchparamcodigo().length() > 50)
			throw new ValidateException(Messages.getString("genparametro.vchparamcodigo.length.error",record.getVchparamcodigo().length()));
		if(record.getVchparamvalor()!=null &&  record.getVchparamvalor().length() > 200)
			throw new ValidateException(Messages.getString("genparametro.vchparamvalor.length.error",record.getVchparamvalor().length()));
		if(record.getVchparamdescri()!=null &&  record.getVchparamdescri().length() > 45)
			throw new ValidateException(Messages.getString("genparametro.vchparamdescri.length.error",record.getVchparamdescri().length()));
		if(record.getVchparamdescriadi()!=null &&  record.getVchparamdescriadi().length() > 200)
			throw new ValidateException(Messages.getString("genparametro.vchparamdescriadi.length.error",record.getVchparamdescriadi().length()));
		if(record.getVchparamgrupo()!=null &&  record.getVchparamgrupo().length() > 10)
			throw new ValidateException(Messages.getString("genparametro.vchparamgrupo.length.error",record.getVchparamgrupo().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("genparametro.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("genparametro.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("genparametro.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("genparametro.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("genparametro.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Genparametro record)throws Exception{
		if(record.getVchparamcodigo()==null)
			throw new ValidateException(Messages.getString("genparametro.vchparamcodigo.required"));
		if(record.getVchparamvalor()==null)
			throw new ValidateException(Messages.getString("genparametro.vchparamvalor.required"));
		if(record.getVchparamdescri()==null)
			throw new ValidateException(Messages.getString("genparametro.vchparamdescri.required"));
		if(record.getVchparamgrupo()==null)
			throw new ValidateException(Messages.getString("genparametro.vchparamgrupo.required"));
		if(record.getEstadoauditoria()==null)
			throw new ValidateException(Messages.getString("genparametro.estadoauditoria.required"));
		if(record.getUsuariocreacionauditoria()==null)
			throw new ValidateException(Messages.getString("genparametro.usuariocreacionauditoria.required"));
		if(record.getFechacreacionauditoria()==null)
			throw new ValidateException(Messages.getString("genparametro.fechacreacionauditoria.required"));

		if(record.getVchparamcodigo()!=null &&  record.getVchparamcodigo().length() > 50)
			throw new ValidateException(Messages.getString("genparametro.vchparamcodigo.length.error",record.getVchparamcodigo().length()));
		if(record.getVchparamvalor()!=null &&  record.getVchparamvalor().length() > 200)
			throw new ValidateException(Messages.getString("genparametro.vchparamvalor.length.error",record.getVchparamvalor().length()));
		if(record.getVchparamdescri()!=null &&  record.getVchparamdescri().length() > 45)
			throw new ValidateException(Messages.getString("genparametro.vchparamdescri.length.error",record.getVchparamdescri().length()));
		if(record.getVchparamdescriadi()!=null &&  record.getVchparamdescriadi().length() > 200)
			throw new ValidateException(Messages.getString("genparametro.vchparamdescriadi.length.error",record.getVchparamdescriadi().length()));
		if(record.getVchparamgrupo()!=null &&  record.getVchparamgrupo().length() > 10)
			throw new ValidateException(Messages.getString("genparametro.vchparamgrupo.length.error",record.getVchparamgrupo().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("genparametro.estadoauditoria.length.error",record.getEstadoauditoria().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("genparametro.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("genparametro.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("genparametro.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("genparametro.programaauditoria.length.error",record.getProgramaauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.String par_vchparamcodigo)throws Exception{
		if(par_vchparamcodigo==null)
			throw new ValidateException(Messages.getString("genparametro.vchparamcodigo.required"));

		//Here Bussines Validations.
	}


}

