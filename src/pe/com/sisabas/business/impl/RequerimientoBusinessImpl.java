package pe.com.sisabas.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Comiteproceso;
import pe.com.sisabas.be.Dependenciadocumentotecnico;
import pe.com.sisabas.be.Documentotecnico;
import pe.com.sisabas.be.Gentabla;
import pe.com.sisabas.be.Gentipo;
import pe.com.sisabas.be.Miembrocomiteporproceso;
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
import pe.com.sisabas.dto.Lugar;
import pe.com.sisabas.dto.Pago;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.persistence.ComiteprocesoMapper;
import pe.com.sisabas.persistence.DependenciadocumentotecnicoMapper;
import pe.com.sisabas.persistence.DocumentotecnicoMapper;
import pe.com.sisabas.persistence.GentipoMapper;
import pe.com.sisabas.persistence.MiembrocomiteporprocesoMapper;
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
	
	private Integer idGenerado;
	
	@Autowired
	public ComiteprocesoMapper comiteprocesoMapper;
	
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
	public MiembrocomiteporprocesoMapper miembrocomiteporprocesoMapper;
	
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
			System.out.println("sapppppppppppp 1");
			
			
			Pedido pedido= new Pedido();
			//Insertando...

					
			Integer idDocumentoTecnicoSeq = ((int)utilsBusiness.getNextSeq(Sequence.SEQ_DOCUMENTOTECNICO).longValue());
			System.out.println("Valor de idDocumento es: "+idDocumentoTecnicoSeq);
			documentoTecnico.setIddocumentotecnico(idDocumentoTecnicoSeq);
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
		    documentoTecnico.setNroanexoresponsable(especificacionTecnica.getNroAnexo());
		    
		    
		    Gentabla gentabla = new Gentabla();
		    gentabla.setVchregcodigo(especificacionTecnica.getTipoEsp()); 
		    
		    documentoTecnico.setGentablaIdcatalogotipotdr(gentabla);

		    

		     //Se creara ComiteProceso si check habilitada
			if(documentoTecnico.getIdcomiteproceso()==null&&especificacionTecnica.isBooleano()){
				Comiteproceso comiteproceso = new Comiteproceso();
				idGenerado = ((int)utilsBusiness.getNextSeq(Sequence.SEQ_COMITEPROCESO).longValue());
				comiteproceso.setIdcomiteproceso(idGenerado);
				comiteproceso.setFechacreacionauditoria(new Date());
				comiteproceso.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
				comiteproceso.setProgramaauditoria(request.getProgramaAuditoria());
				System.out.println("*****************************El valor de idGenerado es :" +idGenerado + "****************************************************");
				comiteprocesoMapper.insert(comiteproceso);
				
				// se inserta idcomiteproceso a documento tecnico
				documentoTecnico.setIdcomiteproceso(idGenerado);
				
			}
			
		    
		 
		    documentotecnicoMapper.insert(documentoTecnico);
			
			

			if (especificacionTecnica.getPrestaciones()!= null){				
				for (int i = 0; i < especificacionTecnica.getPrestaciones().size(); i++) {
					Dependenciadocumentotecnico nuevo = new Dependenciadocumentotecnico();
					nuevo.setIddependenciadocumentotecnico(((int)utilsBusiness.getNextSeq(Sequence.SEQ_DEPENDENCIADOCUMENTOTECNICO).longValue()));
					System.out.println("*******************El valor de setIddependenciadocumentotecnico es:"+nuevo.getIddependenciadocumentotecnico());
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
					
					nuevo.setCronograma(especificacionTecnica.getPagos().get(i).getCronograma());
					nuevo.setPlazo(especificacionTecnica.getPagos().get(i).getPlazo());
					nuevo.setNivelavance(especificacionTecnica.getPagos().get(i).getNivel());
					
					nuevo.setPorcentajeavance(especificacionTecnica.getPagos().get(i).getPorcentaje());
					nuevo.setFechacreacionauditoria(new Date());
					nuevo.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
					nuevo.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
					nuevo.setProgramaauditoria(request.getProgramaAuditoria());
					plazoPagoMapper.insert(nuevo);
				}
			}	

			
			
			
			
			
			
			if (especificacionTecnica.getComitesDto()!=null){
				
				System.out.println("================El tamanio de getcomitedto es "+especificacionTecnica.getComitesDto().size()+"============");
				
				
				for(int i=0; i<especificacionTecnica.getComitesDto().size(); i++){
				    Miembrocomiteporproceso nuevo = new Miembrocomiteporproceso();   	
				    nuevo.setIdmiembrocomiteproceso(((int)utilsBusiness.getNextSeq(Sequence.SEQ_MIEMBROCOMITEPORPROCESO).longValue()));
					nuevo.setIdpersona(especificacionTecnica.getComitesDto().get(i).getId());
					nuevo.setIdcatalogotipomiembro(especificacionTecnica.getComitesDto().get(i).getTipoMiembro());
					nuevo.setTelefono(especificacionTecnica.getComitesDto().get(i).getTelefono());
					nuevo.setAnexo(especificacionTecnica.getComitesDto().get(i).getAnexo());
					nuevo.setCorreo(especificacionTecnica.getComitesDto().get(i).getCorreo());
					System.out.println("El valor de Idmiembrocomiteproceso es :"+ nuevo.getIdmiembrocomiteproceso());
					//se enlaza al idComiteProceso
					if(especificacionTecnica.isBooleano())
					   nuevo.setIdcomiteproceso(idGenerado);
					miembrocomiteporprocesoMapper.insert(nuevo);
				}
		
			}
			
			
			
			//actualizando estado pedido
			
			Pedido pedido2 = pedidoMapper.selectByPrimaryKeyBasic(documentoTecnico.getIdpedido());
			pedido2.setEstadopedido(Constantes.estadosPorEtapa.CON_DOCUMENTO_TECNICO);
			pedidoMapper.updateByPrimaryKey(pedido2);
			
			
			
			
			
			//finalemnte se hace la insercicon de documento tecnico
		//	documentotecnicoMapper.insert(documentoTecnico);
			
			
			
		}else{
			
			
			System.out.println("sapeeeeeeeeeeeeeeeeeeeeeeeeee 2");
			
			//modificando...
			iddocumentoTecnico = especificacionTecnica.getIddocumentotecnico();	
			
			documentoTecnico.setIddocumentotecnico(iddocumentoTecnico);
			documentoTecnico.setIdpedido(especificacionTecnica.getIdPedido());
			documentoTecnico.setFechamodificacionauditoria(new Date());
		    documentoTecnico.setProgramaauditoria(request.getProgramaAuditoria());
		    documentoTecnico.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
		    		    
		    documentoTecnico.setFinalidadpublica(especificacionTecnica.getFinalidadpublica());
		    documentoTecnico.setDenominacioncontratacion(especificacionTecnica.getDenominacioncontratacion());
		    documentoTecnico.setObjetocontratacion(especificacionTecnica.getObjetocontratacion());
		    documentoTecnico.setAntecedentes(especificacionTecnica.getAntecedentes());
		    documentoTecnico.setIdcatalogotipotdr(especificacionTecnica.getTipoEsp());
		    documentoTecnico.setNropac(especificacionTecnica.getNroPac());
		    documentoTecnico.setNroanexoresponsable(especificacionTecnica.getNroAnexo());
		     
		    Gentabla gentabla = new Gentabla();
		    gentabla.setVchregcodigo(especificacionTecnica.getTipoEsp()); 
		    
		    documentoTecnico.setGentablaIdcatalogotipotdr(gentabla);
		    documentotecnicoMapper.updateByPrimaryKey(documentoTecnico);
		
		    
		    
		    //Actualizar Prestaciones

		    Dependenciadocumentotecnico dependenciadocumentotecnico2;
		    
		    List<Lugar> listaLugares= especificacionTecnica.getPrestaciones();
		    List<Lugar> listaLugaresEliminar = especificacionTecnica.getPrestacionesEliminar();
		    
		    System.out.println("*****************************Lugares a eliminar son "+listaLugaresEliminar.size()+"*******************************");
		    

		    if (listaLugares != null){
		    	System.out.println("Lista CON DATOS DE "+especificacionTecnica.getPrestaciones().size());
		    	for (int i = 0; i < listaLugares.size(); i++) {
		    		if (listaLugares.get(i).getIdDependenciaDocumentoTecnico() != null)
		    		{
		    			//update
		    			dependenciadocumentotecnico2 = dependenciadocumentotecnicoMapper.selectByPrimaryKeyBasicActive(especificacionTecnica.getPrestaciones().get(i).getIdDependenciaDocumentoTecnico());		    			
		    			dependenciadocumentotecnico2.setDireccion(especificacionTecnica.getPrestaciones().get(i).getDireccion());
		    			System.out.println("ooo " + dependenciadocumentotecnico2.getDireccion());
		    			dependenciadocumentotecnicoMapper.updateByPrimaryKey(dependenciadocumentotecnico2);
		    		}else
		    		{
		    			//Insert		    	  		
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
		    }
		    
		    Dependenciadocumentotecnico dependenciadocumentotecnico3;
		    if (listaLugaresEliminar != null){
		    	
		    	for (int i = 0; i < listaLugaresEliminar.size(); i++) {
					if(listaLugaresEliminar.get(i).getIdDependenciaDocumentoTecnico()!=null){
						//eliminar
						dependenciadocumentotecnico3 = dependenciadocumentotecnicoMapper.selectByPrimaryKeyBasicActive(especificacionTecnica.getPrestacionesEliminar().get(i).getIdDependenciaDocumentoTecnico());	
						System.out.println("xxx " + dependenciadocumentotecnico3.getDireccion());
						if(dependenciadocumentotecnico3!=null){
							dependenciadocumentotecnicoMapper.deleteByPrimaryKey(dependenciadocumentotecnico3.getIddependenciadocumentotecnico());
						}
					}
				}
		    	
		    	
		    }

		    
		  //Actualizar Plazos
		    

		    Plazopagodocumentotecnico plazopagodocumentotecnico2;
		    
		    List<Pago> listaPlazos= especificacionTecnica.getPagos();
		    List<Pago> listaPlazosEliminar= especificacionTecnica.getPagosEliminar();	 
		
		    		

		    if (listaPlazos != null){
		    	System.out.println("ListaPlazos CON DATOS DE "+especificacionTecnica.getPagos().size());
		    	for (int i = 0; i < listaPlazos.size(); i++) {
		    		if (listaPlazos.get(i).getIdDependenciaDocumentoTecnico() != null)
		    		{
		    			//update
		    			plazopagodocumentotecnico2 = plazoPagoMapper.selectByPrimaryKeyBasicActive(especificacionTecnica.getPagos().get(i).getIdDependenciaDocumentoTecnico());
		    			
		    			plazopagodocumentotecnico2.setCronograma(especificacionTecnica.getPagos().get(i).getCronograma());
		    			plazopagodocumentotecnico2.setPlazo(especificacionTecnica.getPagos().get(i).getPlazo());
		    			plazopagodocumentotecnico2.setNivelavance(especificacionTecnica.getPagos().get(i).getNivel());
		    			
		    			
		    			plazopagodocumentotecnico2.setPorcentajeavance(especificacionTecnica.getPagos().get(i).getPorcentaje());
		    			System.out.println("ooo PorcentajeAvance " + plazopagodocumentotecnico2.getPorcentajeavance());
		    			System.out.println("ooo Cronograma" + plazopagodocumentotecnico2.getCronograma());
		    			plazoPagoMapper.updateByPrimaryKey(plazopagodocumentotecnico2);
		    		}else
		    		{
		    			//Insert		    	  							
						Plazopagodocumentotecnico nuevo = new Plazopagodocumentotecnico();
						nuevo.setIdplazopagodocumentotecnico(((int)utilsBusiness.getNextSeq(Sequence.SEQ_PLAZOPAGODOCUMENTOTECNICO).longValue()));
						nuevo.setIddocumentotecnico(documentoTecnico.getIddocumentotecnico());
						
						nuevo.setCronograma(especificacionTecnica.getPagos().get(i).getCronograma());
						nuevo.setPlazo(especificacionTecnica.getPagos().get(i).getPlazo());
						nuevo.setNivelavance((especificacionTecnica.getPagos().get(i).getNivel()));
						
						nuevo.setPorcentajeavance(especificacionTecnica.getPagos().get(i).getPorcentaje());
						nuevo.setFechacreacionauditoria(new Date());
						nuevo.setEstadoauditoria(Constantes.estadoAuditoria.ACTIVO);
						nuevo.setUsuariocreacionauditoria(request.getUsuarioAuditoria());
						nuevo.setProgramaauditoria(request.getProgramaAuditoria());
						plazoPagoMapper.insert(nuevo);
		    		}		    		
				}
		    }
		    
		    Plazopagodocumentotecnico plazopagodocumentotecnico3;
		    if (listaPlazosEliminar != null){
		    	
		    	for (int i = 0; i < listaPlazosEliminar.size(); i++) {
					if(listaPlazosEliminar.get(i).getIdDependenciaDocumentoTecnico()!=null){
						//eliminar
						plazopagodocumentotecnico3 = plazoPagoMapper.selectByPrimaryKeyBasicActive(especificacionTecnica.getPagosEliminar().get(i).getIdDependenciaDocumentoTecnico());	
						//System.out.println("ccc " + plazopagodocumentotecnico3.getPorcentajeavance());
						if(plazopagodocumentotecnico3!=null){
							plazoPagoMapper.deleteByPrimaryKey(plazopagodocumentotecnico3.getIdplazopagodocumentotecnico());
						}
					}
				}
		    
		    
			
		   }
		
		
		
	   }
		
		return null;
	}
		

	@Override
	public List<Lugar> getLugaresPrestacion(Integer idDocumentoTecnico) throws Exception {
		
		return documentotecnicoMapper.getLugaresPrestacion(idDocumentoTecnico);
	}

	public Integer getIdGenerado() {
		return idGenerado;
	}

	public void setIdGenerado(Integer idGenerado) {
		this.idGenerado = idGenerado;
	}


	
	
	

}
