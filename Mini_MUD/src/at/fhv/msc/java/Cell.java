package at.fhv.msc.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Cell implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String _cellName;
	protected String _description;
	private static int _staticCellNumber = 0;
	protected int _cellNumber;
	
	protected ArrayList<Item> _items;
	
	protected Cell _north;
	protected Cell _south;
	protected Cell _east;
	protected Cell _west;
	
	protected static LinkedList<Cell> _cells = new LinkedList<>();
	
	public Cell() {
		_cellName = "NONE";
	}
	
	public Cell(String cellName, String description) {
		_cellNumber = (_staticCellNumber++) + 1;
		
		_cellName = cellName;
		_description = description;
	}
	
	public void defineSurroundings(Cell north, Cell east, Cell south, Cell west) {
		_north = north;
		_south = south;
		_east = east;
		_west = west;
	}


	public abstract String printCellInfo();
	
	public abstract String enter(Player player, String direction);
    
    public String searchForItems(Player player) {
    	String output = new String();
    	
		if (player.getCurrentPosition() instanceof Field) {
			if (!player.getCurrentPosition().getItems().isEmpty()) {
		        for (Item item : player.getCurrentPosition().getItems()) {
		        	player.getInventory().addItem(item);
		            output += "You picked up " + item.getItemName() + " from the ground.";
		        }
		        player.getCurrentPosition().getItems().clear();
			}
		}
		
		return output;
    }
    
    public void addItem(Item item) {
        _items.add(item);
    }
    
    // GETTER/SETTER:

	public String getCellName() {
		return _cellName;
	}

	public void setCellName(String cellName) {
		_cellName = cellName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getCellNumber() {
		return _cellNumber;
	}

	public void setCellNumber(int cellNumber) {
		_cellNumber = cellNumber;
	}
	
	public Cell getNorth() {
		return _north;
	}

	public void setNorth(Cell north) {
		_north = north;
	}

	public Cell getSouth() {
		return _south;
	}

	public void setSouth(Cell south) {
		_south = south;
	}

	public Cell getEast() {
		return _east;
	}

	public void setEast(Cell east) {
		_east = east;
	}

	public Cell getWest() {
		return _west;
	}

	public void setWest(Cell west) {
		_west = west;
	}

	public ArrayList<Item> getItems() {
		return _items;
	}

	public void setItems(ArrayList<Item> items) {
		_items = items;
	}

	public static LinkedList<Cell> get_cells() {
		return _cells;
	}

	public static void set_cells(LinkedList<Cell> _cells) {
		Cell._cells = _cells;
	}

	@Override
	public String toString() {
		return "Cell [_cellName=" + _cellName + ", _description=" + _description + ", _cellNumber=" + _cellNumber
				+ ", _items=" + _items + ", _north=" + _north + ", _south=" + _south + ", _east=" + _east + ", _west="
				+ _west + ", printCellInfo()=" + printCellInfo() + ", getCellName()=" + getCellName()
				+ ", getDescription()=" + getDescription() + ", getCellNumber()=" + getCellNumber() + ", getNorth()="
				+ getNorth() + ", getSouth()=" + getSouth() + ", getEast()=" + getEast() + ", getWest()=" + getWest()
				+ ", getItems()=" + getItems() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
