
package pe.com.sisabas.exception;

public class ValidateException extends Exception {

	private static final long serialVersionUID = 4972090745213160501L;

	private String code;

	public ValidateException(Throwable cause) {
		super(cause);
	}

	public ValidateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateException(final String message) {
		super(message);
	}

	public ValidateException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public ValidateException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
