package at.fhv.msc.java;

public class Item {
	
	private static int _staticID = 0;
	private int _itemID = 1000;
	private String _item;
	
	public Item() {
		_item = "<>";
	}
	
	public Item(String item) {
		_item = item;
		_itemID += (_staticID++) + 1;
	}
	
	public int getItemID() {
		return _itemID;
	}

	public String getItem() {
		return _item;
	}

	public void setItem(String _item) {
		this._item = _item;
	}
	
	@Override
	public String toString() {
		return "Item [_item=" + _item + ", getItem()=" + getItem() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
