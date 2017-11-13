
package pe.com.sisabas.exception;

public class PrintException extends Exception {

	private static final long serialVersionUID = 4972090745213160501L;

	private String code;

	public PrintException(Throwable cause) {
		super(cause);
	}

	public PrintException(String message, Throwable cause) {
		super(message, cause);
	}

	public PrintException(final String message) {
		super(message);
	}

	public PrintException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public PrintException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
