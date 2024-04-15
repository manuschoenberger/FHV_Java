package at.fhv.msc.java;

public class CDRom extends Product {
	
	private String _artist;
	private int _numTracks;

	public CDRom(String name, String artist, int numberOfTracks) {
		super(name);
		
		_artist = artist;
		_numTracks = numberOfTracks;
		
		Collection.instance().getCds().add(this);
		Collection.instance().getProducts().add(this);
	}
	
	@Override
	public StringBuilder printInfo() {
		StringBuilder output = new StringBuilder();
		
		output.append("  > CD - ROM\n");
		output.append(super.printInfo());
		output.append("Artist:\t\t" + _artist + "\n");
		output.append("Number of Tracks: " + _numTracks + "\n");
		
		return output;
	}
}
