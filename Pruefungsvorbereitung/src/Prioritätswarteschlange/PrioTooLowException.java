package Prioritätswarteschlange;

public class PrioTooLowException extends Exception {
	public PrioTooLowException(String message) {
		super(message);
	}
}
