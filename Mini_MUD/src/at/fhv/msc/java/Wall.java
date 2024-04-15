package at.fhv.msc.java;

public class Wall extends Cell {

	public Wall(String wallName, String wallDescription) {
		super(wallName,wallDescription);
	}
	
	@Override 
	public String printCellInfo() {
		String output = new String();
		
		if (this instanceof Wall) {
			output += "\n\nField: " + _cellNumber + ", " + _cellName;
			output += "\nDescription: " + _description;
		}
		
		return output;
	}
	
	@Override
	public String enter(Player player, String direction) {
	    return null;
	}
}
