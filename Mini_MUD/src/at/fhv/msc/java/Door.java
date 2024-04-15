package at.fhv.msc.java;

public class Door extends Cell {
	
	private boolean _isLocked;
	private Item _key;
	private Cell _outCell;
	private Cell _inCell;
	private int _directionGuider;
	
	public Door(String doorName, String doorDescription, Item key, Cell inCell, Cell outCell) {
		super(doorName,doorDescription);
		_key = key;
		_isLocked = true;
		_inCell = inCell;
		_outCell = outCell;
		_directionGuider = 0;

		_cells.add(this);
	}
	
	@Override 
	public String printCellInfo() {
		String output = new String();
		
		if (this instanceof Door) {
			output += "\n\nDoor: " + _cellNumber + ", " + _cellName;
			output += "\nDescription: " + _description;
		}
		
		if (_directionGuider == 0) {
			output += "\nGoes to --> Cell " + _outCell.getCellNumber() + ":\t"  + _outCell.getCellName().toString();
		} else {
			output += "\nGoes to --> Cell " + _inCell.getCellNumber() + ":\t"  + _inCell.getCellName().toString();
		}
		
		return output;
	}
	
	@Override 
	public String enter(Player player, String direction) {
		String output = new String();
		
		if (_isLocked) {
			output = "\nDoor locked. Use " + _key.getItemName() + " to unlock the door.";
			if (_directionGuider == 0) {
		        player.setCurrentPosition(this._inCell);
			} else {
		        player.setCurrentPosition(this._outCell);
			}
		} else {
			if (_directionGuider == 0) {
		        player.setCurrentPosition(this._outCell);
			} else {
		        player.setCurrentPosition(this._inCell);
			}
			
			output += "\n" + player.getCurrentPosition().searchForItems(player);
			_directionGuider = (_directionGuider + 1) % 2;
		}
		
		output += player.getCurrentPosition().printCellInfo();
		return output;
	}
	
	// GETTER/SETTER:

	public boolean isLocked() {
		return _isLocked;
	}

	public void setLocked(boolean isLocked) {
		_isLocked = isLocked;
	}

	public Item getKey() {
		return _key;
	}

	public void setKey(Item key) {
		_key = key;
	}

	public Cell getNextCell() {
		return _outCell;
	}

	public void setNextCell(Cell nextCell) {
		_outCell = nextCell;
	}
}
