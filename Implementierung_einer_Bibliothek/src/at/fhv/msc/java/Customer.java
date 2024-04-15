package at.fhv.msc.java;

import java.util.LinkedList;

public class Customer {
	
	private static int _staticCustomerID;
	private int _customerID;
	private String _name;
	private String _address;
	private double _dueFees;
	
	private LinkedList<Product> _currentlyBorrowedProducts;
	private LinkedList<Product> _pastBorrowedProducts;
	private LinkedList<Product> _currentlyReservedProducts;
	
	protected CustomerType _customerType;
	
	public Customer() {
	}
	
	public Customer(String name, String address, CustomerType customerType) {
		_customerID = (_staticCustomerID++) + 1;
		
		_name = name;
		_address = address;
		_dueFees = 0.0;
		
		_currentlyBorrowedProducts = new LinkedList<>();
		_pastBorrowedProducts = new LinkedList<>();
		_currentlyReservedProducts = new LinkedList<>();
		
		_customerType = customerType;
		
		Collection.instance().getCustomer().add(this);
	}
	
	public StringBuilder printCustomerBorrows() {
		StringBuilder output = new StringBuilder();
		
		output.append("\nName:\t\t" + _name + "\n");
		output.append("Address:\t" + _address + "\n");
		output.append("Due Fees:\t" + _dueFees + "\n");
		
		output.append("\nCurrently Borrowed Products:\n");
		
		if (_currentlyBorrowedProducts.isEmpty()) {
			output.append("None\n");
		} else {
			for (Product product : _currentlyBorrowedProducts) {
				output.append("> " + product.getName() + "\n");
			}
		}

		return output;
	}
	
	public StringBuilder printPastCustomerBorrows() {
		StringBuilder output = new StringBuilder();
		
		output.append("\nName:\t\t" + _name + "\n");
		output.append("Address:\t" + _address + "\n");
		output.append("Due Fees:\t" + _dueFees + "\n");
		
		output.append("\nHistory of Borrowed Products:\n");
		
		if (_pastBorrowedProducts.isEmpty()) {
			output.append("None\n");
		} else {
			for (Product product : _pastBorrowedProducts) {
				output.append("> " + product.getName() + "\n");
			}
		}

		return output;
	}
	
	public StringBuilder printCustomerReserve() {
		StringBuilder output = new StringBuilder();
		
		output.append("\nName:\t\t" + _name + "\n");
		output.append("Address:\t" + _address + "\n");
		output.append("Due Fees:\t" + _dueFees + "\n");
		
		output.append("\nCurrently Reserved Products:\n");
		
		if (_currentlyReservedProducts.isEmpty()) {
			output.append("None\n");
		} else {
			for (Product product : _currentlyReservedProducts) {
				output.append("> " + product.getName() + "\n");
			}
		}

		return output;
	}
	
	public void addDueFees() {
		_dueFees += this.getCustomerType().getFee();
	}
	
	public void removeDueFees() {
		_dueFees = 0.0;
	}
	
	// GETTER / SETTER:
	
	public int getCustomerID() {
		return _customerID;
	}

	public void setCustomerID(int customerID) {
		_customerID = customerID;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public LinkedList<Product> getCurrentlyBorrowedProducts() {
		return _currentlyBorrowedProducts;
	}

	public void setCurrentlyBorrowedProducts(LinkedList<Product> currentlyBorrowedProducts) {
		_currentlyBorrowedProducts = currentlyBorrowedProducts;
	}

	public LinkedList<Product> getPastBorrowedProducts() {
		return _pastBorrowedProducts;
	}

	public void setPastBorrowedProducts(LinkedList<Product> pastBorrowedProducts) {
		_pastBorrowedProducts = pastBorrowedProducts;
	}

	public CustomerType getCustomerType() {
		return _customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		_customerType = customerType;
	}

	public double getDueFees() {
		return _dueFees;
	}

	public void setDueFees(double dueFees) {
		_dueFees = dueFees;
	}

	public LinkedList<Product> getCurrentlyReservedProducts() {
		return _currentlyReservedProducts;
	}

	public void setCurrentlyReservedProducts(LinkedList<Product> currentlyReservedProducts) {
		_currentlyReservedProducts = currentlyReservedProducts;
	}
}
