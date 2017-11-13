package pe.com.sisabas.exception;

public class ExpiredPasswordException extends Exception {

	private static final long serialVersionUID = 4972090745213160501L;

	private String code;

	public ExpiredPasswordException(Throwable cause) {
		super(cause);
	}

	public ExpiredPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExpiredPasswordException(final String message) {
		super(message);
	}

	public ExpiredPasswordException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public ExpiredPasswordException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
