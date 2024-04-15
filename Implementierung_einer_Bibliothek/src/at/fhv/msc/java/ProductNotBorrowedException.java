package at.fhv.msc.java;

public class ProductNotBorrowedException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductNotBorrowedException (String message) {
		super(message);
	}
}
