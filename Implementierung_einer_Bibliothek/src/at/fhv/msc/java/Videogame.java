package at.fhv.msc.java;

public class Videogame extends Product {
	
	private String _console;
	
	public Videogame(String name, String console) {
		super(name);
		
		_console = console;
		
		Collection.instance().getVideogames().add(this);
		Collection.instance().getProducts().add(this);
	}
	
	@Override
	public StringBuilder borrow(Customer customer) throws ReservingNotPossibleException {
		StringBuilder output = new StringBuilder();
		
		if ((super.getLoanStatus().equals(LoanStatus.borrowed) || super.getLoanStatus().equals(LoanStatus.extended))) {
			throw new ReservingNotPossibleException("This videogame is already borrowed and cannot be reserved");
		} 
		
		setCustomerBorrow(customer);
		setBorrowTime(customer.getCustomerType().getBorrowTime());
		setLoanStatus(LoanStatus.borrowed);
		customer.getCurrentlyBorrowedProducts().add(this);
		customer.addDueFees();
		output.append("Product has successfully been borrowed");
		return output;
	}

	@Override
	public StringBuilder printInfo() {
		StringBuilder output = new StringBuilder();
		
		output.append("  > VIDEOGAME\n");
		output.append(super.printInfo());
		output.append("Console:\t" + _console + "\n");
		
		return output;
	}
}
