package pe.com.sisabas.dto;

public class CuadroComparativoRequest {
	private Integer idPacConsolidado;
	private Integer idCuadroComparativoFuente;
	private Integer nroConsolid;
	
	public Integer getIdPacConsolidado() {
		return idPacConsolidado;
	}
	public void setIdPacConsolidado(Integer idPacConsolidado) {
		this.idPacConsolidado = idPacConsolidado;
	}
	public Integer getIdCuadroComparativoFuente() {
		return idCuadroComparativoFuente;
	}
	public void setIdCuadroComparativoFuente(Integer idCuadroComparativoFuente) {
		this.idCuadroComparativoFuente = idCuadroComparativoFuente;
	}
	public Integer getNroConsolid() {
		return nroConsolid;
	}
	public void setNroConsolid(Integer nroConsolid) {
		this.nroConsolid = nroConsolid;
	}
	
}
