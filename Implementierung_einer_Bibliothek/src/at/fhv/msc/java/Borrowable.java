package at.fhv.msc.java;

public interface Borrowable {
	public StringBuilder borrow(Customer customer) throws ReservingNotPossibleException;
	public StringBuilder unborrow(Customer customer);
}
