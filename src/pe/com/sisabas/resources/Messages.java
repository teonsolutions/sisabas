
package pe.com.sisabas.resources;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
private static final String BUNDLE_NAME = "pe.com.sisabas.resources.messages";
private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
		return '!' + key + '!';
		}
	}

	public static String getString(String key, Object... params  ) {
	try {
		return MessageFormat.format(RESOURCE_BUNDLE.getString(key), params);
		} catch (MissingResourceException e) {
		return '!' + key + '!';
		}
	}

}
