package at.fhv.msc.java;

import java.io.Serializable;

public abstract class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String _DEFAULT_ITEM_NAME = "DEFAULT ITEM";
	
	protected String _itemName;
	
	public Item() {
		_itemName = _DEFAULT_ITEM_NAME;
	}
	
	public Item(String name) {
		_itemName = name;
	}

	public abstract String use(Player player);
	
	public String remove(Player player) {
		player.getInventory().removeItem(this);
		return "\nSuccesfully removed " + _itemName + ".";
	}
	
	// GETTER/SETTER:
	
	public String getItemName() {
		return _itemName;
	}
	
	public void setItemName(String itemName) {
		_itemName = itemName;
	}

	@Override
	public String toString() {
		return "Item [_itemName=" + _itemName + ", getItemName()=" + getItemName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
