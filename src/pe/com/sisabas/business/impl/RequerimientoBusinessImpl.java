package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Dependenciadocumentotecnico;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Gentipo;
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.be.Plazopagodocumentotecnico;
import pe.com.sisabas.be.RequerimientoInsertRequest;
import pe.com.sisabas.be.RequerimientoItemRequest;
import pe.com.sisabas.be.RequerimientoItemResponse;
import pe.com.sisabas.be.RequerimientoRequest;
import pe.com.sisabas.be.RequerimientoResponse;
import pe.com.sisabas.business.GentipoBusiness;
import pe.com.sisabas.business.RequerimientoBusiness;
import pe.com.sisabas.dto.EspecificacionTecnicaDto;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.persistence.DependenciadocumentotecnicoMapper;
import pe.com.sisabas.persistence.DocumentotecnicoMapper;
import pe.com.sisabas.persistence.GentipoMapper;
import pe.com.sisabas.persistence.PedidoMapper;
import pe.com.sisabas.persistence.PlazopagodocumentotecnicoMapper;
import pe.com.sisabas.persistence.RequerimientoMapper;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.Sequence;
import pe.com.sisabas.resources.business.UtilsBusiness;

@Service
public class RequerimientoBusinessImpl implements RequerimientoBusiness, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger=Logger.getLogger(RequerimientoBusinessImpl.class);
	
	@Autowired
	public PedidoMapper pedidoMapper;

	@Autowired
	public RequerimientoMapper requerimientoMapper;
	
	@Autowired
	public DocumentotecnicoMapper documentotecnicoMapper;

	@Autowired
	public PlazopagodocumentotecnicoMapper plazoPagoMapper;
	
	@Autowired
	public DependenciadocumentotecnicoMapper dependenciadocumentotecnicoMapper;
	
	@Autowired
	public UtilsBusiness utilsBusiness;
	
	@Override
	public List<RequerimientoResponse> selectDynamicFull(RequerimientoRequest request) throws Exception {

		List<RequerimientoResponse> lista = requerimientoMapper.selectDynamicFull(request);
		
		for (RequerimientoResponse row : lista) {
			
			row.formatoFecha();
		}
		
		if(RequerimientoResponse.HAVE_BIGDECIMALS)
			for (RequerimientoResponse row2 : lista) {
				
				row2.roundBigDecimals();
			}

			return lista;
	}

	@Override
	public List<RequerimientoItemResponse> selectDynamicBasic(RequerimientoItemRequest request) throws Exception {
		List<RequerimientoItemResponse> lista = requerimientoMapper.selectDynamicBasic(request);
		
		int i=1;
        for (RequerimientoItemResponse row : lista) {
			
			row.setNumeracion(i);
			i++;
		}
		
			return lista;
	}

	@Override
	public void insertBasic(RequerimientoInsertRequest request) throws Exception {
		requerimientoMapper.insertBasic(request);
		
	}

	@Override
	public Resultado guardarEspecificacionTecnica(TransactionRequest<EspecificacionTecnicaDto> request) throws Exception {
		// TODO Auto-generated method stub
		Documentotecnico documentoTecnico = new Documentotecnico();
		Dependenciadocumentotecnico dependenciadocumentotecnico = new Dependenciadocumentotecnico();
		
		
		
		//Grabar documento tecnico
		EspecificacionTecnicaDto especificacionTecnica = request.getEntityTransaction();
		//DocumentoTecnicoDto documentotecnicoDto = new DocumentotecnicoDto();
		Integer iddocumentoTecnico;
		
		
		
		if (especificacionTecnica.getIddocumentotecnico() == null){
			Pedido pedido= new Pedido();
			//Insertando...
			//pedido.setIdpedido(documentotecnico.);
			//documentotecnico.setIdpedido();
			
			
			
			
			Integer idDocumentoTecnico = ((int)utilsBusiness.getNextSeq(Sequence.SEQ_DOCUMENTOTECNICO).longValue());
			
			documentoTecnico.setIddocumentotecnico(idDocumentoTecnico);
			documentoTecnico.setFechacreacionauditoria(new Date());
		    documentoTecnico.setIdpedido(especificacionTecnica.getIdPedido());
		    documentoTecnico.setEquipoauditoria(request.getEquipoAuditoria());
		    documentoTecnico.setProgramaauditoria(request.getProgramaAuditoria());
		    documentoTecnico.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
		    
		    
		    documentoTecnico.setFinalidadpublica(especificacionTecnica.getFinalidadpublica());
		    documentoTecnico.setDenominacioncontratacion(especificacionTecnica.getDenominacioncontratacion());
		    documentoTecnico.setObjetocontratacion(especificacionTecnica.getObjetocontratacion());
		    documentoTecnico.setAntecedentes(especificacionTecnica.getAntecedentes());
		    documentoTecnico.setIdcatalogotipotdr(especificacionTecnica.getTipoEsp());
		    documentoTecnico.setNropac(especificacionTecnica.getNroPac());
		    
		    
		    Gentabla gentabla = new Gentabla();
		    gentabla.setVchregcodigo(especificacionTecnica.getTipoEsp()); 
		    
		    documentoTecnico.setGentablaIdcatalogotipotdr(gentabla);
			
			documentotecnicoMapper.insert(documentoTecnico);
			

			if (especificacionTecnica.getPrestaciones()!= null){				
				for (int i = 0; i < especificacionTecnica.getPrestaciones().size(); i++) {
					//Dependenciadocumentotecnico item = documentoTecnico.getListaDependenciadocumentotecnico().get(i);
					Dependenciadocumentotecnico nuevo = new Dependenciadocumentotecnico();
					nuevo.setIddependenciadocumentotecnico(((int)utilsBusiness.getNextSeq(Sequence.SEQ_DEPENDENCIADOCUMENTOTECNICO).longValue()));
					nuevo.setIddocumentotecnico(documentoTecnico.getIddocumentotecnico());
					nuevo.setDireccion(especificacionTecnica.getPrestaciones().get(i).getDireccion());
					nuevo.setFechacreacionauditoria(new Date());
					nuevo.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
					nuevo.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
					dependenciadocumentotecnicoMapper.insert(nuevo);
				}
			}	
			
			if (especificacionTecnica.getPagos()!=null){				
				for (int i = 0; i < especificacionTecnica.getPagos().size(); i++) {
					Plazopagodocumentotecnico nuevo = new Plazopagodocumentotecnico();
					nuevo.setIdplazopagodocumentotecnico(((int)utilsBusiness.getNextSeq(Sequence.SEQ_PLAZOPAGODOCUMENTOTECNICO).longValue()));
					nuevo.setIddocumentotecnico(documentoTecnico.getIddocumentotecnico());
					nuevo.setPorcentajeavance(especificacionTecnica.getPagos().get(i).getPorcentaje());
					nuevo.setFechacreacionauditoria(new Date());
					nuevo.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
					nuevo.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
					nuevo.setProgramaauditoria(request.getProgramaAuditoria());
					plazoPagoMapper.insert(nuevo);
				}
			}	
			
			//plazos
			
		}else{
			//modificando...
			iddocumentoTecnico = documentoTecnico.getIddocumentotecnico();
			documentoTecnico.setFechamodificacionauditoria(new Date());
			documentoTecnico.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			documentotecnicoMapper.updateByPrimaryKey(documentoTecnico);	
			
			//dependencias
			if (documentoTecnico.getListaDependenciadocumentotecnico() != null){
				for (int i = 0; i < documentoTecnico.getListaDependenciadocumentotecnico().size(); i++) {
					Dependenciadocumentotecnico item = documentoTecnico.getListaDependenciadocumentotecnico().get(i);
					if (item.getIddependenciadocumentotecnico() == null){
						dependenciadocumentotecnicoMapper.insert(item);	
					}else{
						
						//Modificando dependencia
						Dependenciadocumentotecnico itemEdit = dependenciadocumentotecnicoMapper.selectByPrimaryKeyBasic(item.getIddependenciadocumentotecnico());
						itemEdit.setDireccion(item.getDireccion());
						itemEdit.setFechamodificacionauditoria(new Date());
						itemEdit.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
						dependenciadocumentotecnicoMapper.updateByPrimaryKey(item);
					}
					
				}
			}		
			
			//Elimina Dependeica y vuelvo insertar
			
			
		}
		
		
		return null;
	}
	
	
	
	

}
