package at.fhv.msc.java;

import java.time.LocalDate;

public class Magazine extends Printable {
	
	private LocalDate _publicationDate;
	
	public Magazine(String name, LocalDate publicationDate) {
		super(name);
		
		_publicationDate = publicationDate;
		
		Collection.instance().getMagazines().add(this);
		Collection.instance().getProducts().add(this);
	}

	@Override
	public StringBuilder printInfo() {
		StringBuilder output = new StringBuilder();
		
		output.append("  > MAGAZINE\n");
		output.append(super.printInfo());
		output.append("Published:\t" + _publicationDate + "\n");
		
		return output;
	}
}
