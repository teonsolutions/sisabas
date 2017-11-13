
package pe.com.sisabas.exception;

public class SecurityValidateException extends Exception {

	private static final long serialVersionUID = 4972090745213160501L;

	private String code;

	public SecurityValidateException(Throwable cause) {
		super(cause);
	}

	public SecurityValidateException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecurityValidateException(final String message) {
		super(message);
	}

	public SecurityValidateException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public SecurityValidateException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
