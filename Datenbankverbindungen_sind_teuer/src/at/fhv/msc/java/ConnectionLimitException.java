package at.fhv.msc.java;

public class ConnectionLimitException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConnectionLimitException (String message) {
		super(message);
	}
}
