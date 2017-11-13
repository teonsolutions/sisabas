
package pe.com.sisabas.exception;

public class SecurityRestrictedControlException extends Exception {

	private static final long serialVersionUID = 4972090745213160501L;

	private String code;

	public SecurityRestrictedControlException(Throwable cause) {
		super(cause);
	}

	public SecurityRestrictedControlException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecurityRestrictedControlException(final String message) {
		super(message);
	}

	public SecurityRestrictedControlException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public SecurityRestrictedControlException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
