
package pe.com.sisabas.resources;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DatabaseProperties {
private static final String BUNDLE_DATABASE = "WEB-INF/config/database.properties";
private static final ResourceBundle RESOURCE_DATABASE = ResourceBundle.getBundle(BUNDLE_DATABASE);

	private DatabaseProperties() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_DATABASE.getString(key);
		} catch (MissingResourceException e) {
		return '!' + key + '!';
		}
	}

	public static String getString(String key, Object... params  ) {
	try {
		return MessageFormat.format(RESOURCE_DATABASE.getString(key), params);
		} catch (MissingResourceException e) {
		return '!' + key + '!';
		}
	}

}
