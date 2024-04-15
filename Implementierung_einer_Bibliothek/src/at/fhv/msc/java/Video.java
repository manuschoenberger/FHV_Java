package at.fhv.msc.java;

public class Video extends Product {
	
	private String _genre;
	private int _lengthMinutes;
	
	public Video(String name, String genre, int lengthInMinutes) {
		super(name);
		
		_genre = genre;
		_lengthMinutes = lengthInMinutes;
		
		Collection.instance().getVideos().add(this);
		Collection.instance().getProducts().add(this);
	}

	@Override
	public StringBuilder printInfo() {
		StringBuilder output = new StringBuilder();
		
		output.append("  > VIDEO\n");
		output.append(super.printInfo());
		output.append("Genre:\t\t" + _genre + "\n");
		output.append("Length:\t\t" + _lengthMinutes + "min" + "\n");
		
		return output;
	}
}
