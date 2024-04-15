package at.fhv.msc.java;

public class Triangle {
	
	private Point _a;
	private Point _b;
	private Point _c;
	
	//Teilen eines Rechtecks diagonal:
	
	public Triangle(Point a, Point b, Point c) {
		_a = a;
		_b = b;
		_c = c;
	}

	public Point get_a() { return _a; }

	public void set_a(Point _a) { _a = _a; }

	public Point get_b() { return _b; }

	public void set_b(Point _b) { _b = _b; }

	public Point get_c() { return _c; }

	public void set_c(Point _c) { _c = _c; }
	
}
