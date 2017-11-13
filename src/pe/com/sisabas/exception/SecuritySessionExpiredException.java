
package pe.com.sisabas.exception;

public class SecuritySessionExpiredException extends Exception {

	private static final long serialVersionUID = 4972090745213160501L;

	private String code;

	public SecuritySessionExpiredException(Throwable cause) {
		super(cause);
	}

	public SecuritySessionExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecuritySessionExpiredException(final String message) {
		super(message);
	}

	public SecuritySessionExpiredException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public SecuritySessionExpiredException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
