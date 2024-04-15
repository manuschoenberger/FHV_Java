package at.fhv.msc.java;

import java.util.LinkedList;

public class Product implements Borrowable, Reservable, Extendable {
	
	private static int _staticProductID;
	private int _productID;
	private int _productNumber;
	private String _name;
	private boolean _printable;
	
	private LoanStatus _loanStatus;
	
	private LinkedList<Product> _products;
	private Customer _customerReserve;
	private Customer _customerBorrow;
	
	private int _borrowTime;
	private int _extensionAmount;
	
	public Product(String name) {
		_productID = (_staticProductID++) + 1;
		
		_name = name;
		_loanStatus = LoanStatus.available;
		_products = new LinkedList<>();
		_customerReserve = null;
		_customerBorrow = null;
		_borrowTime = 0;
		_extensionAmount = 0;
	}
	
	public Product(String name, int number) {
		this(name);
		
		_productNumber = number;
	}
	
	public void addMultiple(int amount) {
		for (int i = 1; i < (amount + 1); i++) {
			Product p = new Product(this._name,i);
			_products.add(p);
		}
	}
	
	@Override
	public StringBuilder borrow(Customer customer) throws ReservingNotPossibleException {
		StringBuilder output = new StringBuilder();
		
		if ((_loanStatus.equals(LoanStatus.borrowed) || _loanStatus.equals(LoanStatus.extended))) {
			output.append(reserve(customer));
			return output;
		} 
		
		setCustomerBorrow(customer);
		setBorrowTime(customer.getCustomerType().getBorrowTime());
		setLoanStatus(LoanStatus.borrowed);
		customer.getCurrentlyBorrowedProducts().add(this);
		customer.addDueFees();
		output.append("\nProduct has successfully been borrowed");
		return output;
	}
	
	@Override
	public StringBuilder unborrow(Customer customer) {
		StringBuilder output = new StringBuilder();
		
		setCustomerBorrow(null);
		setBorrowTime(0);
		customer.getCurrentlyBorrowedProducts().remove(this);
		customer.getPastBorrowedProducts().add(this);
		output.append("Product successfully unborrowed");
		
		if (_loanStatus.equals(LoanStatus.reserved)) {
			Customer reserveCustomer = _customerReserve;
			try {
				this.unreserve(_customerReserve);
			} catch (ProductNotReservedException e) {
				output.append(e.getMessage());
			}
			try {
				this.borrow(reserveCustomer);
			} catch (ReservingNotPossibleException e) {
				output.append(e.getMessage());
			}
			
			setCustomerReserve(null);
		}
		
		setLoanStatus(LoanStatus.available);
		
		return output;
	}

	@Override
	public StringBuilder reserve(Customer customer) {
		StringBuilder output = new StringBuilder();
		
		if (_loanStatus.equals(LoanStatus.reserved)) {
			output.append("This product cannot be borrowed and is already reserved");
			return output;
		} else {
			output.append("Product is already borrowed, product got reserved instead");
			customer.getCurrentlyReservedProducts().add(this);
			setCustomerReserve(customer);
			setLoanStatus(LoanStatus.reserved);
			return output;
		}
	}
	
	@Override
	public StringBuilder unreserve(Customer customer) throws ProductNotReservedException {
		StringBuilder output = new StringBuilder();
		
		if (_loanStatus.equals(LoanStatus.reserved)) {
			setCustomerReserve(null);
			customer.getCurrentlyReservedProducts().remove(this);
			output.append("This product has successfully been unreserved");
		} else {
			throw new ProductNotReservedException("Product is not reserved");
		}
		
		return output;
	}
		
	@Override
	public StringBuilder extend(Customer customer, int amountDays) throws MaxExtensionsReachedException, ProductNotBorrowedException {
		StringBuilder output = new StringBuilder();
		
		for (Product product : customer.getCurrentlyBorrowedProducts()) {
			if (!this.equals(product)) {
				throw new ProductNotBorrowedException("Product not in possession");
			}
		}
		
		if (_extensionAmount >= customer.getCustomerType().getMaxExtensions()) {
			throw new MaxExtensionsReachedException("Max extensions reached!");
		} else {
			_borrowTime += amountDays;
			_extensionAmount++;
			_loanStatus = LoanStatus.extended;	
			output.append("Extended for " + amountDays + " days");
		}
		
		return output;
	}
	
	public StringBuilder printInfo() {
		StringBuilder output = new StringBuilder();
		
		output.append("Name:\t\t" + _name + "\n");
		output.append("Status:\t\t" + _loanStatus.toString() + "\n");
		
		if (_loanStatus.equals(LoanStatus.borrowed)) {
			output.append("Borrowed for " + _borrowTime + " days\n");				
		}
		
		if (_loanStatus.equals(LoanStatus.extended)) {
			output.append("Extended " + _extensionAmount + " times\n");
		}
		
		if (_loanStatus.equals(LoanStatus.reserved)) {
			output.append("Reserved\n");
		}
		
		return output;
	}
	
	// GETTER / SETTER:

	public int getProductID() {
		return _productID;
	}

	public void setProductID(int productID) {
		_productID = productID;
	}

	public int getProductNumber() {
		return _productNumber;
	}

	public void setProductNumber(int productNumber) {
		_productNumber = productNumber;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public LoanStatus getLoanStatus() {
		return _loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		_loanStatus = loanStatus;
	}

	public LinkedList<Product> getProducts() {
		return _products;
	}

	public void setProducts(LinkedList<Product> products) {
		_products = products;
	}

	public Customer getCustomerReserve() {
		return _customerReserve;
	}

	public void setCustomerReserve(Customer customerReserve) {
		_customerReserve = customerReserve;
	}

	public Customer getCustomerBorrow() {
		return _customerBorrow;
	}

	public void setCustomerBorrow(Customer customerBorrow) {
		_customerBorrow = customerBorrow;
	}

	public int getBorrowTime() {
		return _borrowTime;
	}

	public void setBorrowTime(int borrowTime) {
		_borrowTime = borrowTime;
	}

	public int getExtensionAmount() {
		return _extensionAmount;
	}

	public void setExtensionAmount(int extensionAmount) {
		_extensionAmount = extensionAmount;
	}

	public boolean isPrintable() {
		return _printable;
	}

	public void setPrintable(boolean printable) {
		_printable = printable;
	}
}
