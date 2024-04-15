package at.fhv.msc.java;

import java.util.ArrayList;

public class Zelle {
	
	private ArrayList<String> _products;
	
	public Zelle() {
		_products = new ArrayList<String>();
	}
	
	public void setProducts(ArrayList<String> products) {
		for (String product : products) {
			_products.add(product);
		}
	}
	
	public ArrayList<String> getProducts() {
		ArrayList<String> productsInCell = new ArrayList<String>();
		
		for (String product : _products) {
			productsInCell.add(product);
		}
		
		_products.clear();
		return productsInCell;
	}
	
	public ArrayList<String> peekProducts() {
		ArrayList<String> productsInCell = new ArrayList<String>();
		
		for (String product : _products) {
			productsInCell.add(product);
		}

		return productsInCell;
	}
}
