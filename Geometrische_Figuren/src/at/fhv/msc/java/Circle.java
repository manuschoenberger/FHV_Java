package at.fhv.msc.java;

public class Circle {
	
	private Point _center = new Point(0,0);
	private double _radius;
	
	//Bestimmen eines Umkreises:
	
	public Circle(Rectangle rectangle) {
		_center.set_x(rectangle.get_bottomLeft().get_x() + (rectangle.get_width() / 2)); 
		_center.set_y(rectangle.get_bottomLeft().get_y() + (rectangle.get_height() / 2));
		
		_radius = Math.sqrt((rectangle.get_width() * rectangle.get_width()) + (rectangle.get_height() * rectangle.get_height()));
	}

	public Point get_center() { return _center; }

	public void set_center(Point _center) { _center = _center; }

	public double get_radius() { return _radius; }

	public void set_radius(double _radius) { _radius = _radius; }
}
	