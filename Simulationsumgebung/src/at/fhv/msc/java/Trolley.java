package at.fhv.msc.java;

import java.util.ArrayList;

public class Trolley {
	
	public final static int _DEFAULT_STARTING_POINT = 0;
	public final static int _DEFAULT_MAX_VOLUME = 10;
	
	private int _x;
	private int _y;
	private final int _maxVolume;
	private ArrayList<String> _currentlyLoaded;
	private Verteilzentrum _distribution;
	private static Trolley _instance;
	
	private Trolley() {
		this(_DEFAULT_STARTING_POINT,_DEFAULT_STARTING_POINT,_DEFAULT_MAX_VOLUME);
	}
	
	private Trolley(int x, int y, int volume) {
		_x = x;
		_y = y;
		_distribution = Verteilzentrum.instance(x, y);
		_currentlyLoaded = new ArrayList<String>();
		_maxVolume = volume;
	}
	
	public static Trolley instance(int x, int y, int volume) {
		if (_instance == null) {
			_instance = new Trolley(x,y,volume);
		}
		
		return _instance;
	}
	
	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}
	
	public ArrayList<String> getCurrentlyLoaded() {
		return _currentlyLoaded;
	}

	public Verteilzentrum getDistribution() {
		return _distribution;
	}

	public String move(int x, int y) {
		if ((x > _distribution.getAreaXSize()) || (y > _distribution.getAreaYSize())) {
			return "Coordinates should be set between (0|0) and (" + _distribution.getAreaXSize() + "|" + _distribution.getAreaYSize() + ").";
		}
		
		if (_x < x) {
			for (; _x < x; _x++);
		} else {
			for (; _x > x; _x--);
		}
		
		if (_y < y) {
			for (; _y < y; _y++);
		} else {
			for (; _y > y; _y--);
		}
		
		return "Moving successful!";
	}
	
	public String load() {
		if (_distribution.peekProductsInCell(_x, _y).isEmpty()) {
			return "No Products currently in Cell!";
		} else if ((_distribution.peekProductsInCell(_x, _y).size() + _currentlyLoaded.size()) > _maxVolume) {
			return "Attention: Cannot load all products. Loading limit reached!";
		} else {
			for (String product : _distribution.getProductsFromCell(_x, _y)) {
				_currentlyLoaded.add(product);
			}
		}

		return "Loading successful!";
	}
	
	public String unload() {
		if (_currentlyLoaded.isEmpty()) {
			return "No Products currently in Trolley!";
		} else {
			_distribution.setProductsInCell(_x, _y, _currentlyLoaded);
			_currentlyLoaded.clear();
		}
		
		return "Unloading successful!";
	}
}
