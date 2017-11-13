
package pe.com.sisabas.resources;

public class Sequence{

	public static final String SEQ_ABAS="seq_abas";
	public static final String SEQ_CERTIFICADOPRESUPUESTAL="seq_certificadopresupuestal";
	public static final String SEQ_COMITEPROCESO="seq_comiteproceso";
	public static final String SEQ_CUADROCOMPARATIVOFUENTE="seq_cuadrocomparativofuente";
	public static final String SEQ_CUADROCOMPARATIVOITEM="seq_cuadrocomparativoitem";
	public static final String SEQ_CUADROCOMPARATIVOVR="seq_cuadrocomparativovr";
	public static final String SEQ_DEPENDENCIADOCUMENTOTECNICO="seq_dependenciadocumentotecnico";
	public static final String SEQ_DETALLECERTIFICADOPRESUPUESTAL="seq_detallecertificadopresupuestal";
	public static final String SEQ_DETALLEPEDIDO="seq_detallepedido";
	public static final String SEQ_DOCUMENTOTECNICO="seq_documentotecnico";
	public static final String SEQ_ENTREGABLE="seq_entregable";
	public static final String SEQ_ESTADOSPORDOCUMENTOSIGA="seq_estadospordocumentosiga";
	public static final String SEQ_ESTADOSPORETAPA="seq_estadosporetapa";
	public static final String SEQ_ESTADOSPORETAPAPORDOCUMENTO="seq_estadosporetapapordocumento";
	public static final String SEQ_ESTADOSPORTIPODOCUMENTO="seq_estadosportipodocumento";
	public static final String SEQ_ETAPAGESTIONADMINISTRATIVA="seq_etapagestionadministrativa";
	public static final String SEQ_GENPARAMETRO="seq_genparametro";
	public static final String SEQ_GENTABLA="seq_gentabla";
	public static final String SEQ_GENTIPO="seq_gentipo";
	public static final String SEQ_GRUPODOCUMENTO="seq_grupodocumento";
	public static final String SEQ_ITINERARIOCONVENIOMARCO="seq_itinerarioconveniomarco";
	public static final String SEQ_MIEMBROCOMITEPORPROCESO="seq_miembrocomiteporproceso";
	public static final String SEQ_OBSERVACIONESDOCUMENTOTECNICO="seq_observacionesdocumentotecnico";
	public static final String SEQ_ORDEN="seq_orden";
	public static final String SEQ_PACCONSOLIDADO="seq_pacconsolidado";
	public static final String SEQ_PACPROGRAMADO="seq_pacprogramado";
	public static final String SEQ_PEDIDO="seq_pedido";
	public static final String SEQ_PEDIDOSPORPACCONSOLIDADO="seq_pedidosporpacconsolidado";
	public static final String SEQ_PERIODO="seq_periodo";
	public static final String SEQ_PERSONA="seq_persona";
	public static final String SEQ_PLAZOPAGODOCUMENTOTECNICO="seq_plazopagodocumentotecnico";
	public static final String SEQ_PREVISIONPRESUPUESTAL="seq_previsionpresupuestal";
	public static final String SEQ_REQUISITOSCONFORMIDAD="seq_requisitosconformidad";
	public static final String SEQ_SECCIONESDOCUMENTOTECNICO="seq_seccionesdocumentotecnico";
	public static final String SEQ_SIAFEXPEDIENTESECUENCIA="seq_siafexpedientesecuencia";
	public static final String SEQ_SIAFLOG="seq_siaflog";
	public static final String SEQ_SINADPORPACCONSOLIDADO="seq_sinadporpacconsolidado";
	public static final String SEQ_TIPODOCUMENTO="seq_tipodocumento";
	public static final String SEQ_UNIDADEJECUTORA="seq_unidadejecutora";
	public static final String SEQ_VCENTROCOSTO="seq_vcentrocosto";
	public static final String SEQ_VCERTIFICACION="seq_vcertificacion";
	public static final String SEQ_VDETALLEPEDIDO="seq_vdetallepedido";
	public static final String SEQ_VISPEDIDO="seq_vispedido";
	public static final String SEQ_VISSIGAPAACCONSOLIDADO="seq_vissigapaacconsolidado";

}

/*
CREATE SEQUENCE [abas].[seq_abas] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_certificadopresupuestal] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_comiteproceso] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_cuadrocomparativofuente] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_cuadrocomparativoitem] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_cuadrocomparativovr] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_dependenciadocumentotecnico] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_detallecertificadopresupuestal] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_detallepedido] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_documentotecnico] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_entregable] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_estadospordocumentosiga] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_estadosporetapa] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_estadosporetapapordocumento] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_estadosportipodocumento] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_etapagestionadministrativa] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_genparametro] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_gentabla] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_gentipo] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_grupodocumento] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_itinerarioconveniomarco] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_miembrocomiteporproceso] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_observacionesdocumentotecnico] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_orden] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_pacconsolidado] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_pacprogramado] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_pedido] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_pedidosporpacconsolidado] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_periodo] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_persona] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_plazopagodocumentotecnico] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_previsionpresupuestal] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_requisitosconformidad] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_seccionesdocumentotecnico] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_siafexpedientesecuencia] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_siaflog] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_sinadporpacconsolidado] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_tipodocumento] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_unidadejecutora] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_vcentrocosto] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_vcertificacion] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_vdetallepedido] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_vispedido] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3
CREATE SEQUENCE [abas].[seq_vissigapaacconsolidado] AS [bigint] START WITH 100 INCREMENT BY 1 MINVALUE 100 MAXVALUE 9223372036854775807 CYCLE  CACHE  3

*/