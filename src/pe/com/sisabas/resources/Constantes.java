
package pe.com.sisabas.resources;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.mysql.jdbc.StreamingNotifiable;

public class Constantes {
	public class tabla {
		public static final String TSDP = "TSDP";
		public static final String TITI = "TITI";
		public static final String TITD = "TITD";
		public static final String TIPE = "TIPE";
		public static final String TINE = "TINE";
		public static final String TIMO = "TIMO";
		public static final String TIFU = "TIFU";
		public static final String TIET = "TIET";
		public static final String TIDO = "TIDO";
		public static final String TICP = "TICP";
		public static final String TICO = "TICO";
		public static final String TIBI = "TIBI";
		public static final String TDPL = "TDPL";
		public static final String TCON = "TCON";
		public static final String TAUS = "TAUS";
		public static final String SPAO = "SPAO";
		public static final String SICP = "SICP";
		public static final String SIAD = "SIAD";
		public static final String RCDI = "RCDI";
		public static final String PRVR = "PRVR";
		public static final String PACC = "PACC";
		public static final String OPCP = "OPCP";
		public static final String OBPP = "OBPP";
		public static final String OBCO = "OBCO";
		public static final String MOFU = "MOFU";
		public static final String MESS = "MESS";
		public static final String MCOM = "MCOM";
		public static final String LOGI = "LOGI";
		public static final String IUNI = "IUNI";
		public static final String ITSE = "ITSE";
		public static final String ITOA = "ITOA";
		public static final String ITIC = "ITIC";
		public static final String ITIB = "ITIB";
		public static final String ITDS = "ITDS";
		public static final String IMDE = "IMDE";
		public static final String IGLD = "IGLD";
		public static final String IEPR = "IEPR";
		public static final String ICOR = "ICOR";
		public static final String GGPA = "GGPA";
		public static final String FOPA = "FOPA";
		public static final String FANO = "FANO";
		public static final String FACA = "FACA";
		public static final String ETPS = "ETPS";
		public static final String ESRE = "ESRE";
		public static final String ESIG = "ESIG";
		public static final String ESIA = "ESIA";
		public static final String ESCO = "ESCO";
		public static final String EPRO = "EPRO";
		public static final String EPRI = "EPRI";
		public static final String EPIT = "EPIT";
		public static final String EPED = "EPED";
		public static final String EPAO = "EPAO";
		public static final String EPAC = "EPAC";
		public static final String EMCO = "EMCO";
		public static final String EFII = "EFII";
		public static final String EEPR = "EEPR";
		public static final String EENT = "EENT";
		public static final String EEFI = "EEFI";
		public static final String ECSI = "ECSI";
		public static final String ECPR = "ECPR";
		public static final String ECON = "ECON";
		public static final String ECIT = "ECIT";
		public static final String DPRO = "DPRO";
		public static final String CDSI = "CDSI";
		public static final String CAMI = "CAMI";
		public static final String CADM = "CADM";
		public static final String APRO = "APRO";
		public static final String ANIO = "ANIO";

		public static final String TIBI3 = "TIBI3";

	}

	public class accion {
		public static final String INSERT = "INSERT";
		public static final String UPDATE = "UPDATE";
		public static final String DELETE = "DELETE";
	}

	public class historial {
		public class sincronizacion {
			public static final String MARCA_INSERT_STRING = "REGISTRO-0";
			public static final String MARCA_UPDATE_STRING = "REGISTRO-1";
			public static final int MARCA_INSERT_NUMERIC = 0;
			public static final int MARCA_UPDATE_NUMERIC = -1;
		}
	}

	public class genparametro {
		public static final String INTENTOS_LOGIN_FALLIDOS_MAXIMO = "INTENTOS_LOGIN_FALLIDOS_MAXIMO";
		public static final String INTENTOS_LOGIN_FALLIDOS_MAXIMO_DIARIO = "INTENTOS_LOGIN_FALLIDOS_MAXIMO_DIARIO";
		public static final String CANTIDAD_LOGIN_OK_INFO = "CANTIDAD_LOGIN_OK_INFO";
		public static final String CANTIDAD_LOGIN_ERR_INFO = "CANTIDAD_LOGIN_ERR_INFO";
		public static final String TIEMPO_BLOQUEO_LOGOUT_ERR = "TIEMPO_BLOQUEO_LOGOUT_ERR";
		public static final String LOGIN_ACCESO_ACTIVO_FECHA_HORA = "LOGIN_ACCESO_ACTIVO_FECHA_HORA";
		public static final String SESSION_TIMEOUT = "SESSION_TIMEOUT";

		public static final String NIVEL_COMPLEJIDAD_CLAVE_ACTIVA = "NIVEL_COMPLEJIDAD_CLAVE_ACTIVA";
		public static final String NIVEL_COMPLEJIDAD_CLAVE_CARACTERES = "NIVEL_COMPLEJIDAD_CLAVE_CARACTERES";
		public static final String NIVEL_COMPLEJIDAD_CLAVE_DIGITOS_1 = "NIVEL_COMPLEJIDAD_CLAVE_DIGITOS_1";
		public static final String NIVEL_COMPLEJIDAD_CLAVE_DIGITOS_2 = "NIVEL_COMPLEJIDAD_CLAVE_DIGITOS_2";
		public static final String NIVEL_COMPLEJIDAD_CLAVE_DIGITOS_3 = "NIVEL_COMPLEJIDAD_CLAVE_DIGITOS_3";

		public static final String CLAVE_ANTERIOR_VERIFICAR_HISTORICO = "CLAVE_ANTERIOR_VERIFICAR_HISTORICO";

		public static final String CORREO_ORIGEN = "CORREO_ORIGEN";
		public static final String CORREO_TO = "CORREO_TO";
		public static final String CORREO_CC = "CORREO_CC";
		public static final String CORREO_BCC = "CORREO_BCC";
		public static final String CORREO_SMTP_ACTIVO = "CORREO_SMTP_ACTIVO";
		public static final String CORREO_SMTP_LOCAL = "CORREO_SMTP_LOCAL";
		public static final String CORREO_SMTP_TLS = "CORREO_SMTP_TLS";
		public static final String CORREO_PROXY_HOST = "CORREO_PROXY_HOST";
		public static final String CORREO_PROXY_PORT = "CORREO_PROXY_PORT";
	}

	public static String NEW_LINE = "\n";
	public static String TAB = "\t";
	public static String COMSIMPLE = "\'";
	public static String COMDOBLE = "\"";
	public static String BARINVER = "\\";
	public static int NRO_DECIMALES = 2;
	public static String[] PAR_CAMPOS_MAY_MIN = { "" };
	private static final String BUNDLE_NAME = "pe.com.sisabas.resources.constantes";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Constantes() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static String getString(String key, Object... params) {
		try {
			return MessageFormat.format(RESOURCE_BUNDLE.getString(key), params);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	// Constantes personalizados
	public class tipoNecesidad {
		public static final String TIPO_NECESIDAD_PROGRAMADO = "TINE1";
		public static final String TIPO_NECESIDAD_NO_PROGRAMADO = "TINE2";
	}

	public class mensajeGenerico {
		public static final String REGISTRO_CORRECTO = "La operación se ejecutó exitosamente";
	}

	public class estadosPorEtapa {
		public static final int AUTORIZADO = 1;
		public static final int CON_DOCUMENTO_TECNICO = 2;
		public static final int REMITIDO_A_PROGRAMACION = 3;
		public static final int ASOCIADO_AL_POI = 40;
		public static final int EN_REVISION_DE_DOCUMENTO_TECNICO = 4;
		public static final int OBSERVADO_POR_DOCUMENTO_TECNICO = 5;
		public static final int DOCUMENTO_TECNICO_APROBADO = 6;

		// PAO
		public static final int EN_ESTUDIO_DE_MERCADO = 7;
		public static final int REMITIDO_A_PROCESOS = 12;
		public static final int EN_GIRO_DE_ORDEN = 33;

		// PROCESS
		public static final int EN_COMITE_ESPECIAL = 13;
		public static final int BASE_APROBADA = 14;
		public static final int REMITIDO_A_EJECUCION = 30;

		// EJECUCION
		public static final int EN_SUSCRIPCION_DE_CONTRATO = 31;
	}

	public class estadosPorTipoDocumento {
		public static final int REMITIDO_A_EJECUCION = 152;
		public static final int REMITIDO_A_PROCESOS = 20;
		public static final int REMITIDO_A_PROGRAMACION = 11;
		public static final int EN_COMITE_ESPECIAL = 21;
		public static final int BASE_APROBADA = 22;
	}

	public class estadosPorTipoDocumentoDesc {
		public static final String REMITIDO_A_EJECUCION = "REMITIDO A EJECUCION";
		public static final String REMITIDO_A_PROCESOS = "REMITIDO A PROCESOS";
		public static final String REMITIDO_A_PROGRAMACION = "REMITIDO A PROGRAMACIÓN";
	}

	public class tipoDocumento {
		public static final int PEDIDO = 1;
		public static final int DOCUMENTO_TECNICO = 2;
		public static final int PAO = 3;
		public static final int PROCESO = 4;
		public static final int CONTRATO = 5;
		public static final int ORDEN = 6;
		public static final int ENTREGABLE = 7;
		public static final int PAO_INICIAL = 8;
	}

	public class estadoAuditoria {
		public static final String ACTIVO = "1";
		public static final String INACTIVO = "0";
	}

	public class estadoAuditoriaFilter {
		public static final String ACTIVO = "1";
		public static final String INACTIVO = "0";
		public static final String TODOS = "";
	}
	
	public class unidadEjecutora {
		public static final String PRONIED = "108";
		public static final int PRONIED_SIAF = 1253;
		public static final int ID_UNIDAD_EJECUTORA_ABAS = 1;
	}

	public class tipoContratacion {
		public static final String PAC = "TCON1";
		public static final String NO_PAC = "TCON2";
	}

	public class maestroProcesoSiga {
		public static final String ADJUDIACION_SIN_PROCESO = "14";
	}

	public class procedimientoVR {
		public static final String COTIZACION_MENOR_PRECIO_OBTENIDA = "PRVR1";
	}

	public class moneda {
		public static final String SOLES = "S/.";
		public static final String DOLARES = "US$";
	}

	public class paramentro {
		public static final double PAC_VALOR = 31600;
	}

	public class etapaAdministrativa {
		public static final int REQUERIMIENTOS = 1;
		public static final int PROGRAMACION_Y_COSTOS = 2;
		public static final int PROCESOS_DE_SELECCION = 3;
		public static final int EJECUCION_CONTRACTUAL = 4;
	}
	// Constantes personalizados

	public class tipoDocumentoTecnico {
		public static final String ESPECIFICACION_TECNICA = "TDPL1";
		public static final String TERMINO_REFERENCIA = "TDPL2";
	}

	public class tipoModalidad {
		public static final String ITEM = "TIMO2";
		public static final String PAQUETE = "TIMO1";
	}

	public class estadoConvocatoriaItem {
		public static final int REGISTRADO = 1;
		public static final int REMITIDO = 2;
		public static final int CERRADO = 3;
	}

	public class destinoRemisionProceso {
		public static final int EJECUCION_CONTRACTUAL = 1;
		public static final int PROCESO_SELECCION = 2;
		public static final int PROGRAMACION_COSTOS = 3;
	}
	
	public class destinoRemisionProcesoDescripcion {
		public static final String EJECUCION_CONTRACTUAL = "EJECUCIÓN CONTRACTUAL";
		public static final String PROCESO_SELECCION = "COORDINADOR DE PROCESO DE SELECCIÓN";
		public static final String PROGRAMACION_COSTOS = "PROGRAMACIÓN Y COSTOS";
	}

	public class estadoResultadoProceso {
		public static final String DESIERTO = "EPRI7";
		public static final String BUENA_PRO_CONSENTIDA = "EPRI4";
	}
	
	public class estadoResultadoProcesoItem{
		public static final int REGISTRADO = 1;
		public static final int EN_EJECUCION_CONTRACTUAL = 2;
		public static final int EN_PROCESO_DESIERTO = 3;
		public static final int EN_PROGRAMACION_COSTOS = 4;
		public static final int ASIGNADO_ESPECIALISTA = 5;
		public static final int CERRADO_POR_OTRO_PROCESO = 6;		
	}
}
