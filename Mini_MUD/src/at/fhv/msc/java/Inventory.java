package at.fhv.msc.java;

import java.io.Serializable;
import java.util.LinkedList;

public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	LinkedList<Item> _items;

    Inventory() {
        _items = new LinkedList<Item>();
    }

    void addItem(Item item) {
        _items.addFirst(item);
    }

    void removeItem(Item item) {
        if (_items.contains(item)) {
            _items.remove(item);
        }
    }
    
    // GETTER/SETTER:
    
	public LinkedList<Item> getItems() {
		return _items;
	}

	public void setItems(LinkedList<Item> items) {
		_items = items;
	}

	@Override
	public String toString() {
		return "Inventory [_items=" + _items + ", getItems()=" + getItems() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
