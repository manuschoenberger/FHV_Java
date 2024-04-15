package at.fhv.msc.java;

public class Printable extends Product {

	public Printable(String title) {
		super(title);
	}
	
	@Override
	public StringBuilder borrow(Customer customer) throws ReservingNotPossibleException {
		StringBuilder output = new StringBuilder();
		
		if ((super.getLoanStatus().equals(LoanStatus.borrowed) || super.getLoanStatus().equals(LoanStatus.extended))) {
			output.append(reserve(customer));
			return output;
		} 
		
		setCustomerBorrow(customer);
		setBorrowTime(customer.getCustomerType().getBorrowTimePrintable());
		setLoanStatus(LoanStatus.borrowed);
		customer.getCurrentlyBorrowedProducts().add(this);
		customer.addDueFees();
		output.append("\nProduct has successfully been borrowed");
		return output;
	}
	
	@Override
	public StringBuilder printInfo() {
		StringBuilder output = new StringBuilder();
		
		output.append("Name:\t\t" + super.getName() + "\n");
		output.append("Status:\t\t" + super.getLoanStatus().toString() + "\n");
		
		if (super.getLoanStatus().equals(LoanStatus.borrowed)) {
			output.append("Borrowed for " + super.getBorrowTime() / 30 + " month(s)\n");			
		}
		
		if (super.getLoanStatus().equals(LoanStatus.extended)) {
			output.append("Extended " + super.getExtensionAmount() + " times\n");
		}
		
		if (super.getLoanStatus().equals(LoanStatus.reserved)) {
			output.append("Reserved\n");
		}
		
		return output;
	}
}
