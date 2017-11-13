
package pe.com.sisabas.exception;

public class UnselectedRowException extends Exception {
	private static final long serialVersionUID = 4972090745213160501L;

	private String code;

	public UnselectedRowException(Throwable cause) {
		super(cause);
	}

	public UnselectedRowException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnselectedRowException(final String message) {
		super(message);
	}

	public UnselectedRowException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public UnselectedRowException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
