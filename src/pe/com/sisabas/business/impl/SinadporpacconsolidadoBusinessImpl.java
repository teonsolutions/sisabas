
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
import pe.com.sisabas.be.Sinadporpacconsolidado;
import pe.com.sisabas.persistence.SinadporpacconsolidadoMapper;
import pe.com.sisabas.business.SinadporpacconsolidadoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class SinadporpacconsolidadoBusinessImpl implements SinadporpacconsolidadoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(SinadporpacconsolidadoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public SinadporpacconsolidadoMapper sinadporpacconsolidadoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Sinadporpacconsolidado par_record) throws Exception {
		validateDelete(par_record.getIdsinad());
		sinadporpacconsolidadoMapper.deleteByPrimaryKey(par_record.getIdsinad());
	}

	@Override
	public void insertBasic(Sinadporpacconsolidado record) throws Exception {
		record.setIdsinad((int)utilsBusiness.getNextSeq(Sequence.SEQ_SINADPORPACCONSOLIDADO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		sinadporpacconsolidadoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Sinadporpacconsolidado record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Sinadporpacconsolidado record) throws Exception {
		record.setIdsinad((int)utilsBusiness.getNextSeq(Sequence.SEQ_SINADPORPACCONSOLIDADO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		sinadporpacconsolidadoMapper.insertSelective(record);
	}

	@Override
	public Sinadporpacconsolidado selectByPrimaryKeyBasic(java.lang.Integer par_idsinad) throws Exception {
		return sinadporpacconsolidadoMapper.selectByPrimaryKeyBasic(par_idsinad);
	}

	@Override
	public Sinadporpacconsolidado selectByPrimaryKeyBasicFromList(java.lang.Integer par_idsinad, List<Sinadporpacconsolidado> list) throws Exception {
		Sinadporpacconsolidado record=null;
		for (Sinadporpacconsolidado row : list) {
			if(row.equals(new Sinadporpacconsolidado( par_idsinad))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idsinad);

		return record;
	}

	@Override
	public Sinadporpacconsolidado selectByPrimaryKeyBasicActive(java.lang.Integer par_idsinad) throws Exception {
		return sinadporpacconsolidadoMapper.selectByPrimaryKeyBasicActive(par_idsinad);
	}

	@Override
	public Sinadporpacconsolidado selectByPrimaryKeyFull(java.lang.Integer par_idsinad) throws Exception {
		return sinadporpacconsolidadoMapper.selectByPrimaryKeyFull(par_idsinad);
	}

	@Override
	public Sinadporpacconsolidado selectByPrimaryKeyFullActive(java.lang.Integer par_idsinad) throws Exception {
		return sinadporpacconsolidadoMapper.selectByPrimaryKeyFullActive(par_idsinad);
	}

	@Override
	public List<Sinadporpacconsolidado> selectDynamicBasic(Sinadporpacconsolidado record) throws Exception {
		return sinadporpacconsolidadoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Sinadporpacconsolidado> selectDynamicBasicActives(Sinadporpacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return sinadporpacconsolidadoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Sinadporpacconsolidado> selectDynamicFull(Sinadporpacconsolidado record) throws Exception {
		List<Sinadporpacconsolidado> list=sinadporpacconsolidadoMapper.selectDynamicFull(record);
		if(Sinadporpacconsolidado.HAVE_BIGDECIMALS)
		for (Sinadporpacconsolidado row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Sinadporpacconsolidado> selectDynamicFullActives(Sinadporpacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return sinadporpacconsolidadoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Sinadporpacconsolidado> selectDynamicExtended(Sinadporpacconsolidado record) throws Exception {
		return sinadporpacconsolidadoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Sinadporpacconsolidado> selectDynamicExtendedActives(Sinadporpacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return sinadporpacconsolidadoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Sinadporpacconsolidado record) throws Exception {
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		sinadporpacconsolidadoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Sinadporpacconsolidado record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Sinadporpacconsolidado record) throws Exception {
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		sinadporpacconsolidadoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Sinadporpacconsolidado record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Sinadporpacconsolidado record) throws Exception {
		if(record.getBooleanesprincipal()!=null && record.getBooleanesprincipal()){
			record.setEsprincipal("1");
		}else{
			record.setEsprincipal("0");
		}

		if(record.getBooleanesnuevoasignado()!=null && record.getBooleanesnuevoasignado()){
			record.setEsnuevoasignado("1");
		}else{
			record.setEsnuevoasignado("0");
		}

	}

	public void validateInsert(Sinadporpacconsolidado record)throws Exception{
		if(record.getIdsinad()==null)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.idsinad.required"));
		if(record.getIdpacconsolidado()==null)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.idpacconsolidado.required"));

		if(record.getNumeroexpediente()!=null &&  record.getNumeroexpediente().length() > 30)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.numeroexpediente.length.error",record.getNumeroexpediente().length()));
		if(record.getDescripciontipodocumento()!=null &&  record.getDescripciontipodocumento().length() > 2147483647)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.descripciontipodocumento.length.error",record.getDescripciontipodocumento().length()));
		if(record.getDescripcionoficinaexpediente()!=null &&  record.getDescripcionoficinaexpediente().length() > 2147483647)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.descripcionoficinaexpediente.length.error",record.getDescripcionoficinaexpediente().length()));
		if(record.getNumerodocumento()!=null &&  record.getNumerodocumento().length() > 100)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.numerodocumento.length.error",record.getNumerodocumento().length()));
		if(record.getEsprincipal()!=null &&  record.getEsprincipal().length() > 1)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.esprincipal.length.error",record.getEsprincipal().length()));
		if(record.getEsnuevoasignado()!=null &&  record.getEsnuevoasignado().length() > 1)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.esnuevoasignado.length.error",record.getEsnuevoasignado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Sinadporpacconsolidado record)throws Exception{
		if(record.getIdsinad()==null)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.idsinad.required"));
		if(record.getIdpacconsolidado()==null)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.idpacconsolidado.required"));

		if(record.getNumeroexpediente()!=null &&  record.getNumeroexpediente().length() > 30)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.numeroexpediente.length.error",record.getNumeroexpediente().length()));
		if(record.getDescripciontipodocumento()!=null &&  record.getDescripciontipodocumento().length() > 2147483647)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.descripciontipodocumento.length.error",record.getDescripciontipodocumento().length()));
		if(record.getDescripcionoficinaexpediente()!=null &&  record.getDescripcionoficinaexpediente().length() > 2147483647)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.descripcionoficinaexpediente.length.error",record.getDescripcionoficinaexpediente().length()));
		if(record.getNumerodocumento()!=null &&  record.getNumerodocumento().length() > 100)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.numerodocumento.length.error",record.getNumerodocumento().length()));
		if(record.getEsprincipal()!=null &&  record.getEsprincipal().length() > 1)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.esprincipal.length.error",record.getEsprincipal().length()));
		if(record.getEsnuevoasignado()!=null &&  record.getEsnuevoasignado().length() > 1)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.esnuevoasignado.length.error",record.getEsnuevoasignado().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idsinad)throws Exception{
		if(par_idsinad==null)
			throw new ValidateException(Messages.getString("sinadporpacconsolidado.idsinad.required"));

		//Here Bussines Validations.
	}


}

