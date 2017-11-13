
package pe.com.sisabas.exception;

public class SecurityAccessDeniedException extends Exception {

	private static final long serialVersionUID = 4972090745213160501L;

	private String code;

	public SecurityAccessDeniedException(Throwable cause) {
		super(cause);
	}

	public SecurityAccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecurityAccessDeniedException(final String message) {
		super(message);
	}

	public SecurityAccessDeniedException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public SecurityAccessDeniedException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
