
package pe.com.sisabas.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 4972090745213160501L;

	private String code;

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(final String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public BusinessException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
