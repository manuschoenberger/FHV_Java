package at.fhv.msc.java;

public interface Extendable {
	public StringBuilder extend(Customer customer, int amountDays) throws MaxExtensionsReachedException, ProductNotBorrowedException;
}
