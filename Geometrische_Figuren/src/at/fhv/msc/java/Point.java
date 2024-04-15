package at.fhv.msc.java;

public class Point {
	
	private int _x;
	private int _y;
	
	public Point(int x, int y) {
		_x = x;
		_y = y;	
	}
	
	public int get_x() { return _x; }
	
	public int get_y() { return _y; }
	
	public void set_x(int x) { _x = x; }
	
	public void set_y(int y) { _y = y; }
	
}
