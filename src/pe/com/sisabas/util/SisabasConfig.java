package pe.com.sisabas.util;

import org.apache.log4j.Logger;

public class SisabasConfig {
	private static Logger logger=Logger.getLogger(SisabasConfig.class);
	
	public static final String SEPARATOR_CHAR=";";

	/*Recuperar los campos en los que se permite mayusculas y minusculas*/
	public static String[] retornaFieldUpperLower(){
		String key="sisabas.config.fields.upperlower";
		String fields=Configuration.getString(key);
		if(fields==null || fields.equals(""))
			return null;
		
		String[] listFields=fields.split(SEPARATOR_CHAR);
		return listFields;
	}
	
	
	
	
	
}
