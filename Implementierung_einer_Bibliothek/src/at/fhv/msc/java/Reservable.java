package at.fhv.msc.java;

public interface Reservable {
	public StringBuilder reserve(Customer customer);
	public StringBuilder unreserve(Customer customer) throws ProductNotReservedException;
}
