package pe.com.sisabas.business.impl;
import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sisabas.be.Estadosportipodocumento;
import pe.com.sisabas.be.Pacprogramado;
import pe.com.sisabas.be.Pedido;
import pe.com.sisabas.business.ProgramacionBusiness;
import pe.com.sisabas.controller.PedidoController;
import pe.com.sisabas.dto.Resultado;
import pe.com.sisabas.dto.TransactionRequest;
import pe.com.sisabas.persistence.DocumentotecnicoMapper;
import pe.com.sisabas.persistence.EstadosportipodocumentoMapper;
import pe.com.sisabas.persistence.PacprogramadoMapper;
import pe.com.sisabas.persistence.PedidoMapper;
import pe.com.sisabas.resources.Constantes;
import pe.com.sisabas.resources.business.UtilsBusiness;

@Service
public class ProgramacionBusinessImpl implements ProgramacionBusiness, Serializable {
	private static Logger logger=Logger.getLogger(ProgramacionBusinessImpl.class);

	private static final long serialVersionUID = 1L;
	
	@Autowired
	public PacprogramadoMapper pacprogramadoMapper;
	
	@Autowired
	public PedidoMapper pedidoMapper;
	
	@Autowired
	public EstadosportipodocumentoMapper estadosportipodocumentoMapper;	

	@Autowired
	public UtilsBusiness utilsBusiness;
	
	@Override
	public Resultado recibir(int idDocumento, String tipoNecesidad, TransactionRequest request)
			throws Exception {
		// TODO Auto-generated method stub		
		Resultado result = new Resultado(true, Constantes.mensajeGenerico.REGISTRO_CORRECTO);
		Date dateUpdate = new Date();
		
		if (tipoNecesidad.equals(Constantes.tipoNecesidad.TIPO_NECESIDAD_PROGRAMADO)){
			Pacprogramado programado = pacprogramadoMapper.selectByPrimaryKeyBasic(idDocumento);
			//programado.setGentablaIdcatalogoestado(gentablaIdcatalogoestado);			
			programado.setFechamodificacionauditoria(dateUpdate);
			programado.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			programado.setEquipoauditoria(request.getEquipoAuditoria());
			
			pacprogramadoMapper.updateByPrimaryKey(programado);
		}else{
			Pedido pedido = pedidoMapper.selectByPrimaryKeyBasic(idDocumento);
			pedido.setEstadopedido(Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
			pedido.setFechamodificacionauditoria(dateUpdate);
			pedido.setEquipoauditoria(request.getEquipoAuditoria());
			pedido.setUsuariomodificacionauditoria(request.getUsuarioAuditoria());
			
			pedidoMapper.updateByPrimaryKey(pedido);
			
		}
		
		//Insertamos históricos de estados
		Estadosportipodocumento estados = estadosportipodocumentoMapper.selectByEtapaTipoDocumento(Constantes.tipoDocumento.DOCUMENTO_TECNICO, Constantes.estadosPorEtapa.EN_REVISION_DE_DOCUMENTO_TECNICO);
		if (estados != null){
			
		}		
		
		return null;
	}

		
}
