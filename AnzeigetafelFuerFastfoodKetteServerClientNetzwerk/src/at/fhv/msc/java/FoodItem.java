package at.fhv.msc.java;

import java.io.Serializable;

public class FoodItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String itemName;
    
    public FoodItem(String itemName) {
        this.itemName = itemName;
    }
    
    public String getItemName() {
        return itemName;
    }
}
