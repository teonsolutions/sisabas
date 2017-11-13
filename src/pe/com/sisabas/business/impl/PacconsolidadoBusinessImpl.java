
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
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.persistence.PacconsolidadoMapper;
import pe.com.sisabas.business.PacconsolidadoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class PacconsolidadoBusinessImpl implements PacconsolidadoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(PacconsolidadoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public PacconsolidadoMapper pacconsolidadoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Pacconsolidado par_record) throws Exception {
		validateDelete(par_record.getIdpacconsolidado());
		pacconsolidadoMapper.deleteByPrimaryKey(par_record.getIdpacconsolidado());
	}

	@Override
	public void insertBasic(Pacconsolidado record) throws Exception {
		record.setIdpacconsolidado((int)utilsBusiness.getNextSeq(Sequence.SEQ_PACCONSOLIDADO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		pacconsolidadoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Pacconsolidado record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Pacconsolidado record) throws Exception {
		record.setIdpacconsolidado((int)utilsBusiness.getNextSeq(Sequence.SEQ_PACCONSOLIDADO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		pacconsolidadoMapper.insertSelective(record);
	}

	@Override
	public Pacconsolidado selectByPrimaryKeyBasic(java.lang.Integer par_idpacconsolidado) throws Exception {
		return pacconsolidadoMapper.selectByPrimaryKeyBasic(par_idpacconsolidado);
	}

	@Override
	public Pacconsolidado selectByPrimaryKeyBasicFromList(java.lang.Integer par_idpacconsolidado, List<Pacconsolidado> list) throws Exception {
		Pacconsolidado record=null;
		for (Pacconsolidado row : list) {
			if(row.equals(new Pacconsolidado( par_idpacconsolidado))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_idpacconsolidado);

		return record;
	}

	@Override
	public Pacconsolidado selectByPrimaryKeyBasicActive(java.lang.Integer par_idpacconsolidado) throws Exception {
		return pacconsolidadoMapper.selectByPrimaryKeyBasicActive(par_idpacconsolidado);
	}

	@Override
	public Pacconsolidado selectByPrimaryKeyFull(java.lang.Integer par_idpacconsolidado) throws Exception {
		return pacconsolidadoMapper.selectByPrimaryKeyFull(par_idpacconsolidado);
	}

	@Override
	public Pacconsolidado selectByPrimaryKeyFullActive(java.lang.Integer par_idpacconsolidado) throws Exception {
		return pacconsolidadoMapper.selectByPrimaryKeyFullActive(par_idpacconsolidado);
	}

	@Override
	public List<Pacconsolidado> selectDynamicBasic(Pacconsolidado record) throws Exception {
		return pacconsolidadoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Pacconsolidado> selectDynamicBasicActives(Pacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return pacconsolidadoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Pacconsolidado> selectDynamicFull(Pacconsolidado record) throws Exception {
		List<Pacconsolidado> list=pacconsolidadoMapper.selectDynamicFull(record);
		if(Pacconsolidado.HAVE_BIGDECIMALS)
		for (Pacconsolidado row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Pacconsolidado> selectDynamicFullActives(Pacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return pacconsolidadoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Pacconsolidado> selectDynamicExtended(Pacconsolidado record) throws Exception {
		return pacconsolidadoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Pacconsolidado> selectDynamicExtendedActives(Pacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return pacconsolidadoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Pacconsolidado record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		pacconsolidadoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Pacconsolidado record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Pacconsolidado record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		pacconsolidadoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Pacconsolidado record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Pacconsolidado record) throws Exception {
		if(record.getBooleantieneprevision()!=null && record.getBooleantieneprevision()){
			record.setTieneprevision("1");
		}else{
			record.setTieneprevision("0");
		}

		if(record.getBooleanflagaprobacionestandarizacion()!=null && record.getBooleanflagaprobacionestandarizacion()){
			record.setFlagaprobacionestandarizacion("1");
		}else{
			record.setFlagaprobacionestandarizacion("0");
		}

		if(record.getBooleanmodalidadseleccion()!=null && record.getBooleanmodalidadseleccion()){
			record.setModalidadseleccion("1");
		}else{
			record.setModalidadseleccion("0");
		}

		if(record.getBooleanmodalidadcontratacion()!=null && record.getBooleanmodalidadcontratacion()){
			record.setModalidadcontratacion("1");
		}else{
			record.setModalidadcontratacion("0");
		}

		if(record.getBooleanreajuste()!=null && record.getBooleanreajuste()){
			record.setReajuste("1");
		}else{
			record.setReajuste("0");
		}

		if(record.getBooleanflagcd()!=null && record.getBooleanflagcd()){
			record.setFlagcd("1");
		}else{
			record.setFlagcd("0");
		}

		if(record.getBooleanindagacionvalorestimado()!=null && record.getBooleanindagacionvalorestimado()){
			record.setIndagacionvalorestimado("1");
		}else{
			record.setIndagacionvalorestimado("0");
		}

	}

	public void validateInsert(Pacconsolidado record)throws Exception{
		if(record.getIdpacconsolidado()==null)
			throw new ValidateException(Messages.getString("pacconsolidado.idpacconsolidado.required"));
		if(record.getIdcatalogotipocontratacion()==null)
			throw new ValidateException(Messages.getString("pacconsolidado.idcatalogotipocontratacion.required"));
		if(record.getMesprevistoconvocatoria()==null)
			throw new ValidateException(Messages.getString("pacconsolidado.mesprevistoconvocatoria.required"));

		if(record.getNroconsolid()!=null &&  record.getNroconsolid().length() > 10)
			throw new ValidateException(Messages.getString("pacconsolidado.nroconsolid.length.error",record.getNroconsolid().length()));
		if(record.getAntecedenteprocesopacdsc()!=null &&  record.getAntecedenteprocesopacdsc().length() > 20)
			throw new ValidateException(Messages.getString("pacconsolidado.antecedenteprocesopacdsc.length.error",record.getAntecedenteprocesopacdsc().length()));
		if(record.getNropac()!=null &&  record.getNropac().length() > 6)
			throw new ValidateException(Messages.getString("pacconsolidado.nropac.length.error",record.getNropac().length()));
		if(record.getIdcatalogoestadopac()!=null &&  record.getIdcatalogoestadopac().length() > 10)
			throw new ValidateException(Messages.getString("pacconsolidado.idcatalogoestadopac.length.error",record.getIdcatalogoestadopac().length()));
		if(record.getCodigotipoprocesoinicial()!=null &&  record.getCodigotipoprocesoinicial().length() > 3)
			throw new ValidateException(Messages.getString("pacconsolidado.codigotipoprocesoinicial.length.error",record.getCodigotipoprocesoinicial().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("pacconsolidado.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getIdcatalogotiponecesidad()!=null &&  record.getIdcatalogotiponecesidad().length() > 10)
			throw new ValidateException(Messages.getString("pacconsolidado.idcatalogotiponecesidad.length.error",record.getIdcatalogotiponecesidad().length()));
		if(record.getIdcatalogotipocontratacion()!=null &&  record.getIdcatalogotipocontratacion().length() > 10)
			throw new ValidateException(Messages.getString("pacconsolidado.idcatalogotipocontratacion.length.error",record.getIdcatalogotipocontratacion().length()));
		if(record.getDescpac()!=null &&  record.getDescpac().length() > 500)
			throw new ValidateException(Messages.getString("pacconsolidado.descpac.length.error",record.getDescpac().length()));
		if(record.getNombreespecialistavr()!=null &&  record.getNombreespecialistavr().length() > 300)
			throw new ValidateException(Messages.getString("pacconsolidado.nombreespecialistavr.length.error",record.getNombreespecialistavr().length()));
		if(record.getTieneprevision()!=null &&  record.getTieneprevision().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.tieneprevision.length.error",record.getTieneprevision().length()));
		if(record.getCodigotipoproceso()!=null &&  record.getCodigotipoproceso().length() > 2)
			throw new ValidateException(Messages.getString("pacconsolidado.codigotipoproceso.length.error",record.getCodigotipoproceso().length()));
		if(record.getTiemposervicio()!=null &&  record.getTiemposervicio().length() > 50)
			throw new ValidateException(Messages.getString("pacconsolidado.tiemposervicio.length.error",record.getTiemposervicio().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pacconsolidado.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pacconsolidado.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getFlagaprobacionestandarizacion()!=null &&  record.getFlagaprobacionestandarizacion().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.flagaprobacionestandarizacion.length.error",record.getFlagaprobacionestandarizacion().length()));
		if(record.getDocaprobacionestandarizacion()!=null &&  record.getDocaprobacionestandarizacion().length() > 50)
			throw new ValidateException(Messages.getString("pacconsolidado.docaprobacionestandarizacion.length.error",record.getDocaprobacionestandarizacion().length()));
		if(record.getDetallehonorarios()!=null &&  record.getDetallehonorarios().length() > 150)
			throw new ValidateException(Messages.getString("pacconsolidado.detallehonorarios.length.error",record.getDetallehonorarios().length()));
		if(record.getResolucionpac()!=null &&  record.getResolucionpac().length() > 50)
			throw new ValidateException(Messages.getString("pacconsolidado.resolucionpac.length.error",record.getResolucionpac().length()));
		if(record.getDocumentonoprogramado()!=null &&  record.getDocumentonoprogramado().length() > 50)
			throw new ValidateException(Messages.getString("pacconsolidado.documentonoprogramado.length.error",record.getDocumentonoprogramado().length()));
		if(record.getDocumentoepom()!=null &&  record.getDocumentoepom().length() > 50)
			throw new ValidateException(Messages.getString("pacconsolidado.documentoepom.length.error",record.getDocumentoepom().length()));
		if(record.getSistemacontratacion()!=null &&  record.getSistemacontratacion().length() > 3)
			throw new ValidateException(Messages.getString("pacconsolidado.sistemacontratacion.length.error",record.getSistemacontratacion().length()));
		if(record.getModalidadseleccion()!=null &&  record.getModalidadseleccion().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.modalidadseleccion.length.error",record.getModalidadseleccion().length()));
		if(record.getModalidadcontratacion()!=null &&  record.getModalidadcontratacion().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.modalidadcontratacion.length.error",record.getModalidadcontratacion().length()));
		if(record.getReajuste()!=null &&  record.getReajuste().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.reajuste.length.error",record.getReajuste().length()));
		if(record.getFlagcd()!=null &&  record.getFlagcd().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.flagcd.length.error",record.getFlagcd().length()));
		if(record.getObjetoprocedimiento()!=null &&  record.getObjetoprocedimiento().length() > 3)
			throw new ValidateException(Messages.getString("pacconsolidado.objetoprocedimiento.length.error",record.getObjetoprocedimiento().length()));
		if(record.getIndagacionvalorestimado()!=null &&  record.getIndagacionvalorestimado().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.indagacionvalorestimado.length.error",record.getIndagacionvalorestimado().length()));
		if(record.getNroruc()!=null &&  record.getNroruc().length() > 11)
			throw new ValidateException(Messages.getString("pacconsolidado.nroruc.length.error",record.getNroruc().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("pacconsolidado.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("pacconsolidado.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Pacconsolidado record)throws Exception{
		if(record.getIdpacconsolidado()==null)
			throw new ValidateException(Messages.getString("pacconsolidado.idpacconsolidado.required"));
		if(record.getIdcatalogotipocontratacion()==null)
			throw new ValidateException(Messages.getString("pacconsolidado.idcatalogotipocontratacion.required"));
		if(record.getMesprevistoconvocatoria()==null)
			throw new ValidateException(Messages.getString("pacconsolidado.mesprevistoconvocatoria.required"));

		if(record.getNroconsolid()!=null &&  record.getNroconsolid().length() > 10)
			throw new ValidateException(Messages.getString("pacconsolidado.nroconsolid.length.error",record.getNroconsolid().length()));
		if(record.getAntecedenteprocesopacdsc()!=null &&  record.getAntecedenteprocesopacdsc().length() > 20)
			throw new ValidateException(Messages.getString("pacconsolidado.antecedenteprocesopacdsc.length.error",record.getAntecedenteprocesopacdsc().length()));
		if(record.getNropac()!=null &&  record.getNropac().length() > 6)
			throw new ValidateException(Messages.getString("pacconsolidado.nropac.length.error",record.getNropac().length()));
		if(record.getIdcatalogoestadopac()!=null &&  record.getIdcatalogoestadopac().length() > 10)
			throw new ValidateException(Messages.getString("pacconsolidado.idcatalogoestadopac.length.error",record.getIdcatalogoestadopac().length()));
		if(record.getCodigotipoprocesoinicial()!=null &&  record.getCodigotipoprocesoinicial().length() > 3)
			throw new ValidateException(Messages.getString("pacconsolidado.codigotipoprocesoinicial.length.error",record.getCodigotipoprocesoinicial().length()));
		if(record.getIdcatalogotipobien()!=null &&  record.getIdcatalogotipobien().length() > 10)
			throw new ValidateException(Messages.getString("pacconsolidado.idcatalogotipobien.length.error",record.getIdcatalogotipobien().length()));
		if(record.getIdcatalogotiponecesidad()!=null &&  record.getIdcatalogotiponecesidad().length() > 10)
			throw new ValidateException(Messages.getString("pacconsolidado.idcatalogotiponecesidad.length.error",record.getIdcatalogotiponecesidad().length()));
		if(record.getIdcatalogotipocontratacion()!=null &&  record.getIdcatalogotipocontratacion().length() > 10)
			throw new ValidateException(Messages.getString("pacconsolidado.idcatalogotipocontratacion.length.error",record.getIdcatalogotipocontratacion().length()));
		if(record.getDescpac()!=null &&  record.getDescpac().length() > 500)
			throw new ValidateException(Messages.getString("pacconsolidado.descpac.length.error",record.getDescpac().length()));
		if(record.getNombreespecialistavr()!=null &&  record.getNombreespecialistavr().length() > 300)
			throw new ValidateException(Messages.getString("pacconsolidado.nombreespecialistavr.length.error",record.getNombreespecialistavr().length()));
		if(record.getTieneprevision()!=null &&  record.getTieneprevision().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.tieneprevision.length.error",record.getTieneprevision().length()));
		if(record.getCodigotipoproceso()!=null &&  record.getCodigotipoproceso().length() > 2)
			throw new ValidateException(Messages.getString("pacconsolidado.codigotipoproceso.length.error",record.getCodigotipoproceso().length()));
		if(record.getTiemposervicio()!=null &&  record.getTiemposervicio().length() > 50)
			throw new ValidateException(Messages.getString("pacconsolidado.tiemposervicio.length.error",record.getTiemposervicio().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pacconsolidado.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("pacconsolidado.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getFlagaprobacionestandarizacion()!=null &&  record.getFlagaprobacionestandarizacion().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.flagaprobacionestandarizacion.length.error",record.getFlagaprobacionestandarizacion().length()));
		if(record.getDocaprobacionestandarizacion()!=null &&  record.getDocaprobacionestandarizacion().length() > 50)
			throw new ValidateException(Messages.getString("pacconsolidado.docaprobacionestandarizacion.length.error",record.getDocaprobacionestandarizacion().length()));
		if(record.getDetallehonorarios()!=null &&  record.getDetallehonorarios().length() > 150)
			throw new ValidateException(Messages.getString("pacconsolidado.detallehonorarios.length.error",record.getDetallehonorarios().length()));
		if(record.getResolucionpac()!=null &&  record.getResolucionpac().length() > 50)
			throw new ValidateException(Messages.getString("pacconsolidado.resolucionpac.length.error",record.getResolucionpac().length()));
		if(record.getDocumentonoprogramado()!=null &&  record.getDocumentonoprogramado().length() > 50)
			throw new ValidateException(Messages.getString("pacconsolidado.documentonoprogramado.length.error",record.getDocumentonoprogramado().length()));
		if(record.getDocumentoepom()!=null &&  record.getDocumentoepom().length() > 50)
			throw new ValidateException(Messages.getString("pacconsolidado.documentoepom.length.error",record.getDocumentoepom().length()));
		if(record.getSistemacontratacion()!=null &&  record.getSistemacontratacion().length() > 3)
			throw new ValidateException(Messages.getString("pacconsolidado.sistemacontratacion.length.error",record.getSistemacontratacion().length()));
		if(record.getModalidadseleccion()!=null &&  record.getModalidadseleccion().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.modalidadseleccion.length.error",record.getModalidadseleccion().length()));
		if(record.getModalidadcontratacion()!=null &&  record.getModalidadcontratacion().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.modalidadcontratacion.length.error",record.getModalidadcontratacion().length()));
		if(record.getReajuste()!=null &&  record.getReajuste().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.reajuste.length.error",record.getReajuste().length()));
		if(record.getFlagcd()!=null &&  record.getFlagcd().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.flagcd.length.error",record.getFlagcd().length()));
		if(record.getObjetoprocedimiento()!=null &&  record.getObjetoprocedimiento().length() > 3)
			throw new ValidateException(Messages.getString("pacconsolidado.objetoprocedimiento.length.error",record.getObjetoprocedimiento().length()));
		if(record.getIndagacionvalorestimado()!=null &&  record.getIndagacionvalorestimado().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.indagacionvalorestimado.length.error",record.getIndagacionvalorestimado().length()));
		if(record.getNroruc()!=null &&  record.getNroruc().length() > 11)
			throw new ValidateException(Messages.getString("pacconsolidado.nroruc.length.error",record.getNroruc().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("pacconsolidado.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("pacconsolidado.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("pacconsolidado.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_idpacconsolidado)throws Exception{
		if(par_idpacconsolidado==null)
			throw new ValidateException(Messages.getString("pacconsolidado.idpacconsolidado.required"));

		//Here Bussines Validations.
	}


}

