package at.fhv.msc.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Verteilzentrum {

	public final static int _DEFAULT_DISTRIBUTION_SIZE = 5;
	private Zelle[][] _cells;
	private int _xMax;
	private int _yMax;
	private static Verteilzentrum _instance;
	private ArrayList<String> _products;
	
	private Verteilzentrum() {
		this(_DEFAULT_DISTRIBUTION_SIZE,_DEFAULT_DISTRIBUTION_SIZE);
	}
	
	private Verteilzentrum(int xMax, int yMax) {
		_xMax = xMax;
		_yMax = yMax;
		
		_cells = new Zelle[xMax][yMax];
		
		for (int x = 0; x < xMax; x++) {
			for (int y = 0; y < yMax; y++) {
				_cells[x][y] = new Zelle();
			}
		}
		
		_products = new ArrayList<String>();
	}
	
	public static Verteilzentrum instance(int xMax, int yMax) {
		if (_instance == null) {
			_instance = new Verteilzentrum(xMax,yMax);
		}
		
		return _instance;
	}

	public int getAreaXSize() {
		return _xMax;
	}

	public int getAreaYSize() {
		return _yMax;
	}
	
	// Fill cells with products:
	
	public ArrayList<String> getProducts() {
		return _products;
	}

	public void initProduct(String product) {
		_products.add(product);
	}
	
	// Methods for Trolley:

	public void setProductsInCell(int x, int y, ArrayList<String> products) {
		_cells[x][y].setProducts(products);
	}
	
	public ArrayList<String> getProductsFromCell(int x, int y) {
		return _cells[x][y].getProducts();
	}
	
	public ArrayList<String> peekProductsInCell(int x, int y) {
		return _cells[x][y].peekProducts();
	}

	@Override
	public String toString() {
		return "Verteilzentrum [_cells=" + Arrays.toString(_cells) + ", _xMax=" + _xMax + ", _yMax=" + _yMax
				+ ", _products=" + _products + ", getAreaXSize()=" + getAreaXSize() + ", getAreaYSize()="
				+ getAreaYSize() + "]";
	}

	public static void main(String[] args) {
		Verteilzentrum init = Verteilzentrum.instance(5,5);
		
		init.initProduct("Apfel");
		init.initProduct("Birne");
		init.setProductsInCell(3, 3, init.getProducts());
		
		System.out.println("\nShow what's in cell (3|3):\n" + init.peekProductsInCell(3, 3));
		
		Transportauftrag order1 = new Transportauftrag();
		
		System.out.println("\nOrder ID:\n" + order1.get_orderID());
		
		order1.loadAt(3, 3);

		System.out.println("\nShow what's in cell (3|3) after loading:\n" + init.peekProductsInCell(3, 3));
		
		System.out.println("\nShow what's in cell (4|4):\n" + init.peekProductsInCell(4, 4));
		
		order1.unloadAt(4, 4);
		
		System.out.println("\nShow what's in cell (4|4) after unloading:\n" + init.peekProductsInCell(4, 4));
		
		Transportauftrag order2 = new Transportauftrag();
		
		System.out.println("\nOrder ID:\n" + order2.get_orderID());
		
		order2.loadAt(4, 4);

		System.out.println("\nShow what's in cell (4|4): after loading\n" + init.peekProductsInCell(4, 4));
		
		System.out.println("\nShow what's in cell (3|3):\n" + init.peekProductsInCell(3, 3));
		
		order2.unloadAt(3, 3);
		
		System.out.println("\nShow what's in cell (3|3): after unloading\n" + init.peekProductsInCell(3, 3));

	
	}

}
