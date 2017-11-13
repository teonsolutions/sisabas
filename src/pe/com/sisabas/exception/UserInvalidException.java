package pe.com.sisabas.exception;

public class UserInvalidException extends Exception {

	private static final long serialVersionUID = 4972090745213160501L;

	private String code;

	public UserInvalidException(Throwable cause) {
		super(cause);
	}

	public UserInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserInvalidException(final String message) {
		super(message);
	}

	public UserInvalidException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public UserInvalidException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
