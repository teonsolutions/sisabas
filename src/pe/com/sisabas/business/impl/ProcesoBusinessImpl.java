package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Estadosporetapapordocumento;
import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Miembrocomiteporproceso;
import pe.com.sisabas.be.Pacconsolidado;
import pe.com.sisabas.business.ProcesoBusiness;
import pe.com.sisabas.dto.ComiteDto;
import pe.com.sisabas.dto.ProcesoDto;
import pe.com.sisabas.dto.ProcesoRequest;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.persistence.ComiteprocesoMapper;
import pe.com.sisabas.persistence.EstadosporetapapordocumentoMapper;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.persistence.MiembrocomiteporprocesoMapper;
import pe.com.sisabas.persistence.PacconsolidadoMapper;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.business.UtilsBusiness;

@Service
public class ProcesoBusinessImpl implements ProcesoBusiness, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public PacconsolidadoMapper pacconsolidadoMapper;

	@Autowired
	public EstadosporetapapordocumentoMapper estadosporetapapordocumentoMapper;
	
	@Autowired
	public UtilsBusiness utilsBusiness;
	
	@Autowired
	public EstadosportipodocumentoMapper estadosportipodocumentoMapper;	
	
	@Autowired
	public MiembrocomiteporprocesoMapper miembrocomiteporprocesoMapper;
	
	@Autowired
	public ComiteprocesoMapper comiteprocesoMapper;
	
	@Override
	public List<ProcesoDto> searchProceso(ProcesoRequest request) throws Exception {
		// TODO Auto-generated method stub
		return pacconsolidadoMapper.searchProceso(request);
	}

	@Override
	@Transactional
	public Resultado recibirProceso(TransactionRequest<ProcesoDto> request) throws Exception {
		// TODO Auto-generated method stub
		ProcesoDto procesoDto = request.getEntityTransaction();
		Pacconsolidado pacConsolid = pacconsolidadoMapper.selectByPrimaryKeyBasic(procesoDto.getIdPacConsolidado());	

		//Process
		Integer idProcesoSeleccion = 0;
		
		//Get miembros de comité de selección
		List<String> ordenListaCampos = new ArrayList<String>();
		ordenListaCampos.add("A1.IDMIEMBROCOMITEPROCESO");
		Miembrocomiteporproceso miembrocomiteporproceso = new Miembrocomiteporproceso();
		miembrocomiteporproceso.setOrdenListaCampos(ordenListaCampos);
		miembrocomiteporproceso.setOrdenTipo("DESC");

		// Add conditions IN clause
		miembrocomiteporproceso.addConditionInIdcatalogotipomiembro(null);
		miembrocomiteporproceso.addConditionInIdcatalogoestadomiembrocomite(null);
		miembrocomiteporproceso.setIdmiembrocomiteproceso(pacConsolid.getIdcomiteproceso());
		List<Miembrocomiteporproceso> listaMiembrocomiteporproceso = miembrocomiteporprocesoMapper.selectDynamicFull(miembrocomiteporproceso);
		
		Integer idComiteProceso = 0;
		if (listaMiembrocomiteporproceso != null && listaMiembrocomiteporproceso.size() > 0){
			boolean cmSaved = false;
			for (Miembrocomiteporproceso member : listaMiembrocomiteporproceso) {
				if (!cmSaved){
					//create new miembro comite
					Comiteproceso comiteMiembro = new Comiteproceso();
					comiteMiembro.setFechacreacionauditoria(new Date());
					comiteMiembro.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
					comiteMiembro.setEquipoauditoria(request.getEquipoAuditoria());
					comiteMiembro.setProgramaauditoria(request.getProgramaAuditoria());
					comiteMiembro.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
					idComiteProceso = (int) utilsBusiness.getNextSeq(Sequence.SEQ_COMITEPROCESO).longValue();
					comiteMiembro.setIdcomiteproceso(idComiteProceso);
					comiteprocesoMapper.insert(comiteMiembro);	
					cmSaved = true;
				}
				
				//members
				Miembrocomiteporproceso miembrocomiteporprocesoNew = (Miembrocomiteporproceso)member.clone();
				miembrocomiteporprocesoNew.setIdcomiteproceso(idComiteProceso);
				miembrocomiteporprocesoNew.setFechacreacionauditoria(new Date());
				miembrocomiteporprocesoNew.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				miembrocomiteporprocesoNew.setEquipoauditoria(request.getEquipoAuditoria());
				miembrocomiteporprocesoNew.setProgramaauditoria(request.getProgramaAuditoria());
				miembrocomiteporprocesoNew.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
				miembrocomiteporprocesoNew.setIdmiembrocomiteproceso(
						(int) utilsBusiness.getNextSeq(Sequence.SEQ_MIEMBROCOMITEPORPROCESO).longValue());
				miembrocomiteporprocesoMapper.insert(miembrocomiteporprocesoNew);							
			}
		}
		
		//create convocatoria by default
		
		//status
		Estadosportipodocumento param = new Estadosportipodocumento();
		param.setIdtipodocumento(Constantes.tipoDocumento.PROCESO);
		param.setIdestadosporetapa(Constantes.estadosPorEtapa.EN_COMITE_ESPECIAL);
		Estadosportipodocumento estado = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(param);
		if (estado != null) {
			java.util.Date date = new java.util.Date();
			Estadosporetapapordocumento record = new Estadosporetapapordocumento();
			record.setNrodocumento(idProcesoSeleccion); //Process number
			record.setIdestadosportipodocumento(estado.getIdestadosportipodocumento());
			record.setIdtipodocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO);
			record.setFechaingreso(date);
			record.setFechacreacionauditoria(date);
			record.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
			record.setEquipoauditoria(request.getEquipoAuditoria());

			// record.setIdestadosporetapapordocumento((int)utilsBusiness.getNextSeqTemporal(pe.com.sisabas.resources.Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

			record.setIdestadosporetapapordocumento(
					(int) utilsBusiness.getNextSeq(Sequence.SEQ_ESTADOSPORETAPAPORDOCUMENTO).longValue());

			record.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
			estadosporetapapordocumentoMapper.insert(record);
		}	
		
		//Miembros de comite de selección hace una copia de PAO
		
		
		return null;
	}

		
	
}
