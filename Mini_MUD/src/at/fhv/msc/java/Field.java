package at.fhv.msc.java;

import java.util.ArrayList;

public class Field extends Cell {
	
	public Field(String fieldName, String fieldDescription) {
		super(fieldName,fieldDescription);
		
		_items = new ArrayList<Item>();

		_cells.add(this);
	}
	
	public Field() {
		super();
	}
	
	@Override 
	public String printCellInfo() {
		String output = new String();

		if (this instanceof Field) {	//TODO: nicht nötig?
			output += "\n\nField: " + _cellNumber + ", " + _cellName;
			output += "\nDescription: " + _description;
		}
		
		output += "\n\nNorth --> Cell " + _north.getCellNumber() + ":\t" + _north.getCellName().toString();
		output += "\nEast  --> Cell " + _east.getCellNumber() + ":\t"  + _east.getCellName().toString();
		output += "\nSouth --> Cell " + _south.getCellNumber() + ":\t"  + _south.getCellName().toString();
		output += "\nWest  --> Cell " + _west.getCellNumber() + ":\t"  + _west.getCellName().toString();
		
		return output;
	}
	
	@Override 
	public String enter(Player player, String direction) {
		String output = new String();
		
		switch (direction) {
		case "N": 
			if (player.getCurrentPosition().getNorth().getCellName().equals("NONE")) {
				output = "There is nothing north of you!\n";
			} else if (player.getCurrentPosition().getNorth() instanceof Wall) {
				output = "There is a wall north of you!\n";
			} else {
				player.setCurrentPosition(this.getNorth());
			}
			break;
		case "E": 
			if (player.getCurrentPosition().getEast().getCellName().equals("NONE")) {
				output = "There is nothing east of you!\n";
			} else if (player.getCurrentPosition().getEast() instanceof Wall) {
				output = "There is a wall east of you!\n";
			} else {
				player.setCurrentPosition(this.getEast());
			}
			break;
		case "S": 
			if (player.getCurrentPosition().getSouth().getCellName().equals("NONE")) {
				output = "There is nothing south of you!\n";
			} else if (player.getCurrentPosition().getSouth() instanceof Wall) {
				output = "There is a wall south of you!\n";
			} else {
				player.setCurrentPosition(this.getSouth());
			}
			break;
		case "W": 
			if (player.getCurrentPosition().getWest().getCellName().equals("NONE")) {
				output = "There is nothing west of you!\n";
			} else if (player.getCurrentPosition().getWest() instanceof Wall) {
				output = "There is a wall west of you!\n";
			} else {
				player.setCurrentPosition(this.getWest());
			}
			break;
		}
		
		output += this.searchForItems(player);
		output += player.getCurrentPosition().printCellInfo();
		return output;
	}
}
