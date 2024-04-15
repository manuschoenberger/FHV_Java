package at.fhv.msc.java;

public class Key extends Item {
	
	private Door _door;
	
	public Key(String name) {
		super(name);
	}
	
	@Override 
	public String use(Player player) {
		String output = new String();
		if (player.getCurrentPosition() instanceof Door && ((Door)player.getCurrentPosition()).equals(_door)) {
			_door.setLocked(false);
			output += "\nYou unlocked the door";
			output += _door.enter(player, "");
			player.getInventory().removeItem(this);
		} else {
			return "\nYou are not standing on the right cell to use this key.";
		}
		
		return output;
	}
	
	public void addCorrespondingDoor(Door door) {
		_door = door;
	}
}