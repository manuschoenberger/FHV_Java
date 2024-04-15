package at.fhv.msc.java;

public class ProductNotReservedException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductNotReservedException (String message) {
		super(message);
	}
}
