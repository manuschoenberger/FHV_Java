package at.fhv.msc.java;

public class Book extends Printable {

	private String _publisher;
	private String _isbn;
	private int _pages;
	
	
	public Book(String title, String isbn, String publisher, int pages) {
		super(title);
		
		_publisher = publisher;
		_isbn = isbn;
		_pages = pages;
		
		Collection.instance().getBooks().add(this);
		Collection.instance().getProducts().add(this);
	}
	
	@Override
	public StringBuilder printInfo() {
		StringBuilder output = new StringBuilder();
		
		output.append("  > BOOK\n");
		output.append(super.printInfo());
		output.append("Publisher:\t" + _publisher + "\n");
		output.append("ISBN:\t\t" + _isbn + "\n");
		output.append("Pages:\t\t" + _pages + "\n");
		
		return output;
	}
}
