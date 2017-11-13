
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
import pe.com.sisabas.be.Vissigapaacconsolidado;
import pe.com.sisabas.persistence.VissigapaacconsolidadoMapper;
import pe.com.sisabas.business.VissigapaacconsolidadoBusiness;
import pe.com.sisabas.exception.BusinessException;
import pe.com.sisabas.exception.ValidateException;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Messages;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.Utils;
import pe.com.sisabas.resources.business.UtilsBusiness;


@Service
public class VissigapaacconsolidadoBusinessImpl implements VissigapaacconsolidadoBusiness, Serializable{

	private static Logger logger=Logger.getLogger(VissigapaacconsolidadoBusinessImpl.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	public VissigapaacconsolidadoMapper vissigapaacconsolidadoMapper;

	@Autowired
	public UtilsBusiness utilsBusiness;

	@Override
	public void deleteByPrimaryKeyBasic(Vissigapaacconsolidado par_record) throws Exception {
		validateDelete(par_record.getVisidsigapaacconsolidado());
		vissigapaacconsolidadoMapper.deleteByPrimaryKey(par_record.getVisidsigapaacconsolidado());
	}

	@Override
	public void insertBasic(Vissigapaacconsolidado record) throws Exception {
		record.setVisidsigapaacconsolidado((int)utilsBusiness.getNextSeq(Sequence.SEQ_VISSIGAPAACCONSOLIDADO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		validateInsert(record);
		Utils.convertPropertiesStringToUppercase(record);
		vissigapaacconsolidadoMapper.insert(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void insertFull(Vissigapaacconsolidado record) throws Exception {
		//Business Logic
		insertBasic(record);
	}

	@Override
	public void insertSelectiveBasic(Vissigapaacconsolidado record) throws Exception {
		record.setVisidsigapaacconsolidado((int)utilsBusiness.getNextSeq(Sequence.SEQ_VISSIGAPAACCONSOLIDADO).longValue());
		record.setFechacreacionauditoria(Utils.currentTimeStamp());
		record.setEstadoauditoria("1");
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		vissigapaacconsolidadoMapper.insertSelective(record);
	}

	@Override
	public Vissigapaacconsolidado selectByPrimaryKeyBasic(java.lang.Integer par_visidsigapaacconsolidado) throws Exception {
		return vissigapaacconsolidadoMapper.selectByPrimaryKeyBasic(par_visidsigapaacconsolidado);
	}

	@Override
	public Vissigapaacconsolidado selectByPrimaryKeyBasicFromList(java.lang.Integer par_visidsigapaacconsolidado, List<Vissigapaacconsolidado> list) throws Exception {
		Vissigapaacconsolidado record=null;
		for (Vissigapaacconsolidado row : list) {
			if(row.equals(new Vissigapaacconsolidado( par_visidsigapaacconsolidado))){
				record=row;
				break;
			}
		}
		if(record==null)
			record=selectByPrimaryKeyBasic( par_visidsigapaacconsolidado);

		return record;
	}

	@Override
	public Vissigapaacconsolidado selectByPrimaryKeyBasicActive(java.lang.Integer par_visidsigapaacconsolidado) throws Exception {
		return vissigapaacconsolidadoMapper.selectByPrimaryKeyBasicActive(par_visidsigapaacconsolidado);
	}

	@Override
	public Vissigapaacconsolidado selectByPrimaryKeyFull(java.lang.Integer par_visidsigapaacconsolidado) throws Exception {
		return vissigapaacconsolidadoMapper.selectByPrimaryKeyFull(par_visidsigapaacconsolidado);
	}

	@Override
	public Vissigapaacconsolidado selectByPrimaryKeyFullActive(java.lang.Integer par_visidsigapaacconsolidado) throws Exception {
		return vissigapaacconsolidadoMapper.selectByPrimaryKeyFullActive(par_visidsigapaacconsolidado);
	}

	@Override
	public List<Vissigapaacconsolidado> selectDynamicBasic(Vissigapaacconsolidado record) throws Exception {
		return vissigapaacconsolidadoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Vissigapaacconsolidado> selectDynamicBasicActives(Vissigapaacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return vissigapaacconsolidadoMapper.selectDynamicBasic(record);
	}

	@Override
	public List<Vissigapaacconsolidado> selectDynamicFull(Vissigapaacconsolidado record) throws Exception {
		List<Vissigapaacconsolidado> list=vissigapaacconsolidadoMapper.selectDynamicFull(record);
		if(Vissigapaacconsolidado.HAVE_BIGDECIMALS)
		for (Vissigapaacconsolidado row : list) {
			row.roundBigDecimals();
		}

		return list;
	}

	@Override
	public List<Vissigapaacconsolidado> selectDynamicFullActives(Vissigapaacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return vissigapaacconsolidadoMapper.selectDynamicFull(record);
	}

	@Override
	public List<Vissigapaacconsolidado> selectDynamicExtended(Vissigapaacconsolidado record) throws Exception {
		return vissigapaacconsolidadoMapper.selectDynamicExtended(record);
	}

	@Override
	public List<Vissigapaacconsolidado> selectDynamicExtendedActives(Vissigapaacconsolidado record) throws Exception {
		record.setEstadoauditoria("1");
		return vissigapaacconsolidadoMapper.selectDynamicExtended(record);
	}

	@Override
	public void updateByPrimaryKeySelectiveBasic(Vissigapaacconsolidado record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		Utils.convertPropertiesStringToUppercase(record);
		vissigapaacconsolidadoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeySelectiveFull(Vissigapaacconsolidado record) throws Exception {
		//Business Logic
		updateByPrimaryKeySelectiveBasic(record);
	}

	@Override
	public void updateByPrimaryKeyBasic(Vissigapaacconsolidado record) throws Exception {
		record.setFechamodificacionauditoria(Utils.currentTimeStamp());
		updateBooleanToChar(record);
		validateUpdate(record);
		Utils.convertPropertiesStringToUppercase(record);
		vissigapaacconsolidadoMapper.updateByPrimaryKey(record);
	}

	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateByPrimaryKeyFull(Vissigapaacconsolidado record) throws Exception {
		//Business Logic
		updateByPrimaryKeyBasic(record);
	}

	public void updateBooleanToChar(Vissigapaacconsolidado record) throws Exception {
	}

	public void validateInsert(Vissigapaacconsolidado record)throws Exception{
		if(record.getVisidsigapaacconsolidado()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.visidsigapaacconsolidado.required"));
		if(record.getCodigounidadejecutora()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.codigounidadejecutora.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.secejec.required"));
		if(record.getTipoconsolid()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.tipoconsolid.required"));
		if(record.getNroconsolid()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.nroconsolid.required"));

		if(record.getCodigounidadejecutora()!=null &&  record.getCodigounidadejecutora().length() > 3)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.codigounidadejecutora.length.error",record.getCodigounidadejecutora().length()));
		if(record.getTipoconsolid()!=null &&  record.getTipoconsolid().length() > 1)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.tipoconsolid.length.error",record.getTipoconsolid().length()));
		if(record.getEstadopaac()!=null &&  record.getEstadopaac().length() > 1)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.estadopaac.length.error",record.getEstadopaac().length()));
		if(record.getModalcompra()!=null &&  record.getModalcompra().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.modalcompra.length.error",record.getModalcompra().length()));
		if(record.getNropaac()!=null &&  record.getNropaac().length() > 4)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.nropaac.length.error",record.getNropaac().length()));
		if(record.getMesinicial()!=null &&  record.getMesinicial().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.mesinicial.length.error",record.getMesinicial().length()));
		if(record.getMesfinal()!=null &&  record.getMesfinal().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.mesfinal.length.error",record.getMesfinal().length()));
		if(record.getMespropuesto()!=null &&  record.getMespropuesto().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.mespropuesto.length.error",record.getMespropuesto().length()));
		if(record.getTipobien()!=null &&  record.getTipobien().length() > 1)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.tipobien.length.error",record.getTipobien().length()));
		if(record.getFlagpaac()!=null &&  record.getFlagpaac().length() > 1)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.flagpaac.length.error",record.getFlagpaac().length()));
		if(record.getTipoproceso()!=null &&  record.getTipoproceso().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.tipoproceso.length.error",record.getTipoproceso().length()));
		if(record.getDescripciontipoproceso()!=null &&  record.getDescripciontipoproceso().length() > 150)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.descripciontipoproceso.length.error",record.getDescripciontipoproceso().length()));
		if(record.getObjeto()!=null &&  record.getObjeto().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.objeto.length.error",record.getObjeto().length()));
		if(record.getEspecificaciontecnicas()!=null &&  record.getEspecificaciontecnicas().length() > 100)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.especificaciontecnicas.length.error",record.getEspecificaciontecnicas().length()));
		if(record.getPais()!=null &&  record.getPais().length() > 4)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.pais.length.error",record.getPais().length()));
		if(record.getDepartamento()!=null &&  record.getDepartamento().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.departamento.length.error",record.getDepartamento().length()));
		if(record.getProvincia()!=null &&  record.getProvincia().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.provincia.length.error",record.getProvincia().length()));
		if(record.getDistrito()!=null &&  record.getDistrito().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.distrito.length.error",record.getDistrito().length()));
		if(record.getExpsiaftipoejec()!=null &&  record.getExpsiaftipoejec().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.expsiaftipoejec.length.error",record.getExpsiaftipoejec().length()));
		if(record.getModalidadcsc()!=null &&  record.getModalidadcsc().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.modalidadcsc.length.error",record.getModalidadcsc().length()));
		if(record.getCodsnip()!=null &&  record.getCodsnip().length() > 20)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.codsnip.length.error",record.getCodsnip().length()));
		if(record.getDocviasnip()!=null &&  record.getDocviasnip().length() > 100)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.docviasnip.length.error",record.getDocviasnip().length()));
		if(record.getTipocontratacion()!=null &&  record.getTipocontratacion().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.tipocontratacion.length.error",record.getTipocontratacion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateUpdate(Vissigapaacconsolidado record)throws Exception{
		if(record.getVisidsigapaacconsolidado()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.visidsigapaacconsolidado.required"));
		if(record.getCodigounidadejecutora()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.codigounidadejecutora.required"));
		if(record.getAnio()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.anio.required"));
		if(record.getSecejec()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.secejec.required"));
		if(record.getTipoconsolid()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.tipoconsolid.required"));
		if(record.getNroconsolid()==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.nroconsolid.required"));

		if(record.getCodigounidadejecutora()!=null &&  record.getCodigounidadejecutora().length() > 3)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.codigounidadejecutora.length.error",record.getCodigounidadejecutora().length()));
		if(record.getTipoconsolid()!=null &&  record.getTipoconsolid().length() > 1)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.tipoconsolid.length.error",record.getTipoconsolid().length()));
		if(record.getEstadopaac()!=null &&  record.getEstadopaac().length() > 1)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.estadopaac.length.error",record.getEstadopaac().length()));
		if(record.getModalcompra()!=null &&  record.getModalcompra().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.modalcompra.length.error",record.getModalcompra().length()));
		if(record.getNropaac()!=null &&  record.getNropaac().length() > 4)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.nropaac.length.error",record.getNropaac().length()));
		if(record.getMesinicial()!=null &&  record.getMesinicial().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.mesinicial.length.error",record.getMesinicial().length()));
		if(record.getMesfinal()!=null &&  record.getMesfinal().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.mesfinal.length.error",record.getMesfinal().length()));
		if(record.getMespropuesto()!=null &&  record.getMespropuesto().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.mespropuesto.length.error",record.getMespropuesto().length()));
		if(record.getTipobien()!=null &&  record.getTipobien().length() > 1)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.tipobien.length.error",record.getTipobien().length()));
		if(record.getFlagpaac()!=null &&  record.getFlagpaac().length() > 1)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.flagpaac.length.error",record.getFlagpaac().length()));
		if(record.getTipoproceso()!=null &&  record.getTipoproceso().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.tipoproceso.length.error",record.getTipoproceso().length()));
		if(record.getDescripciontipoproceso()!=null &&  record.getDescripciontipoproceso().length() > 150)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.descripciontipoproceso.length.error",record.getDescripciontipoproceso().length()));
		if(record.getObjeto()!=null &&  record.getObjeto().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.objeto.length.error",record.getObjeto().length()));
		if(record.getEspecificaciontecnicas()!=null &&  record.getEspecificaciontecnicas().length() > 100)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.especificaciontecnicas.length.error",record.getEspecificaciontecnicas().length()));
		if(record.getPais()!=null &&  record.getPais().length() > 4)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.pais.length.error",record.getPais().length()));
		if(record.getDepartamento()!=null &&  record.getDepartamento().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.departamento.length.error",record.getDepartamento().length()));
		if(record.getProvincia()!=null &&  record.getProvincia().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.provincia.length.error",record.getProvincia().length()));
		if(record.getDistrito()!=null &&  record.getDistrito().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.distrito.length.error",record.getDistrito().length()));
		if(record.getExpsiaftipoejec()!=null &&  record.getExpsiaftipoejec().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.expsiaftipoejec.length.error",record.getExpsiaftipoejec().length()));
		if(record.getModalidadcsc()!=null &&  record.getModalidadcsc().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.modalidadcsc.length.error",record.getModalidadcsc().length()));
		if(record.getCodsnip()!=null &&  record.getCodsnip().length() > 20)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.codsnip.length.error",record.getCodsnip().length()));
		if(record.getDocviasnip()!=null &&  record.getDocviasnip().length() > 100)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.docviasnip.length.error",record.getDocviasnip().length()));
		if(record.getTipocontratacion()!=null &&  record.getTipocontratacion().length() > 2)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.tipocontratacion.length.error",record.getTipocontratacion().length()));
		if(record.getUsuariocreacionauditoria()!=null &&  record.getUsuariocreacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.usuariocreacionauditoria.length.error",record.getUsuariocreacionauditoria().length()));
		if(record.getUsuariomodificacionauditoria()!=null &&  record.getUsuariomodificacionauditoria().length() > 15)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.usuariomodificacionauditoria.length.error",record.getUsuariomodificacionauditoria().length()));
		if(record.getEquipoauditoria()!=null &&  record.getEquipoauditoria().length() > 45)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.equipoauditoria.length.error",record.getEquipoauditoria().length()));
		if(record.getProgramaauditoria()!=null &&  record.getProgramaauditoria().length() > 200)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.programaauditoria.length.error",record.getProgramaauditoria().length()));
		if(record.getEstadoauditoria()!=null &&  record.getEstadoauditoria().length() > 1)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.estadoauditoria.length.error",record.getEstadoauditoria().length()));

		//Here Bussines Validations.
	}

	public void validateDelete(java.lang.Integer par_visidsigapaacconsolidado)throws Exception{
		if(par_visidsigapaacconsolidado==null)
			throw new ValidateException(Messages.getString("vissigapaacconsolidado.visidsigapaacconsolidado.required"));

		//Here Bussines Validations.
	}


}

