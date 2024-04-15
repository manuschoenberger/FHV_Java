package at.fhv.msc.java;

import java.util.Arrays;

public class Rectangle {
	
	private Point _bottomLeft; //Wird in main initialisiert
	private Point _topRight; //Wird in main initialisiert
	private int _width;
	private int _height;
	
	private Circle _circle;
	
	//Erstellen eines Rechtecks:
	
	public Rectangle(Point a, Point b) {
		_bottomLeft = a;
		_topRight = b;
		_width = (b.get_x() - a.get_x());
		if (_width < 0) {
			_width = -_width;
			_topRight.set_x(_bottomLeft.get_x() + _width);
		}
		_height = (b.get_y() - a.get_y());
		if (_height < 0) {
			_height = -_height;
			_topRight.set_y(_bottomLeft.get_y() + _height);
		}
	}

	public Rectangle(Point a, int width, int height) {
		_bottomLeft = a;
		_width = width;
		_height = height;
	}
	
	//Getter und Setter:
	
	public Point get_bottomLeft() { return _bottomLeft; }

	public void set_bottomLeft(Point _bottomLeft) { _bottomLeft = _bottomLeft; }

	public Point get_topRight() { return _topRight; }

	public void set_topRight(Point _topRight) { _topRight = _topRight; }

	public int get_width() { return _width; }

	public void set_width(int _width) { _width = _width; }

	public int get_height() { return _height; }

	public void set_height(int _height) { _height = _height; }

	//Verschieben eines Rechtecks:
	
	public void move(int x, int y) {
		_bottomLeft.set_x(_bottomLeft.get_x() + x);
		_bottomLeft.set_y(_bottomLeft.get_y() + y);
		_topRight.set_x(_topRight.get_x() + x);
		_topRight.set_y(_topRight.get_y() + y);
	}
	
	//Prüfen auf Quadrat-Eigenschaft:
	
	public boolean square() {
		return (_width == _height);
	}
	
	//Bestimmen eines Umkreises:
	
	public Circle makeCircle(Rectangle rectangle) {
		_circle = new Circle(rectangle);
		return _circle;
	}
	
	//"Zoomen" eines Rechtecks:
	
	public void zoom(int zoomVal) {
		_width *= zoomVal;
		_height *= zoomVal;
		_topRight.set_x(_bottomLeft.get_x() + _width);
		_topRight.set_y(_bottomLeft.get_y() + _height);
	}
	
	//Teilen eines Rechtecks in 4:
	
	public Rectangle[] divideIntoFour() {
		Rectangle[] cutRectangles = new Rectangle[4];
		int halfWidth = _width / 2;
		int halfHeight = _height / 2;
		
		Point a1 = _bottomLeft;
		Point b1 = new Point(_bottomLeft.get_x() + halfWidth, _bottomLeft.get_y() + halfHeight);
		cutRectangles[0] = new Rectangle(a1,b1);
		
		Point a2 = new Point(_bottomLeft.get_x() + halfWidth, _bottomLeft.get_y());
		Point b2 = new Point(_topRight.get_x(), _bottomLeft.get_y() + halfHeight);
		cutRectangles[1] = new Rectangle(a2,b2);
		
		Point a3 = new Point(_bottomLeft.get_x(), _bottomLeft.get_y() + halfHeight);
		Point b3 = new Point(_bottomLeft.get_x() + halfWidth, _topRight.get_y());
		cutRectangles[2] = new Rectangle(a3,b3);
		
		Point a4 = new Point(_bottomLeft.get_x() + halfWidth, _bottomLeft.get_y() + halfHeight);
		Point b4 = _topRight;
		cutRectangles[3] = new Rectangle(a4,b4);
		
		return cutRectangles;
	}
	
	//Teilen eines Rechtecks diagonal:
	
	public Triangle[] divideIntoTwoTriangles(Rectangle rectangle, Point cutPointTop, Point cutPointBottom) {
		Triangle[] cutTriangles = new Triangle[2];
		
		Point a = new Point(cutPointTop.get_x(), cutPointTop.get_y() + _height);
		cutTriangles[0] = new Triangle(a, cutPointTop, cutPointBottom);
		
		Point b = new Point(cutPointBottom.get_x(), cutPointBottom.get_y() - _height);
		cutTriangles[1] = new Triangle(b, cutPointTop, cutPointBottom);
		
		return cutTriangles;
	}

	@Override
	public String toString() {
		return "Rectangle [_bottomLeft=" + _bottomLeft + ", _topRight=" + _topRight + ", _width=" + _width
				+ ", _height=" + _height + ", _circle=" + _circle + ", get_bottomLeft()=" + get_bottomLeft()
				+ ", get_topRight()=" + get_topRight() + ", get_width()=" + get_width() + ", get_height()="
				+ get_height() + ", square()=" + square() + ", divideIntoFour()=" + Arrays.toString(divideIntoFour())
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public static void main(String[] args) {
		 Point a = new Point(2,3);
		 Point b = new Point(5,5);
		 
		 Rectangle rect = new Rectangle(a,b);
		 
		 System.out.println("Rectangle");
		 System.out.println("Width: " + rect._width);
		 System.out.println("Height: " + rect._height);
		 
		 rect.move(1, 1);
		 
		 System.out.println("\nIs Square? " + rect.square());
		 
		 System.out.println("\nMoving Rectangle");
		 System.out.println("New X of Bottom Left: " + a.get_x());
		 System.out.println("New Y of Bottom Left: " + a.get_y());
		 System.out.println("New X of Top Right: " + b.get_x());
		 System.out.println("New Y of Top Right: " + b.get_y());
		 	 	 
		 Circle circ = new Circle(rect);
		 System.out.println("\nCircle\nRadius: " + circ.get_radius());
		 System.out.println("Center x: " + circ.get_center().get_x() + " | y: "+ circ.get_center().get_y());
		 
		 rect.zoom(2);

		 System.out.println("\nZooming Rectangle");
		 System.out.println("Width: " + rect._width);
		 System.out.println("Height: " + rect._height);
		 System.out.println("New X of Bottom Left: " + a.get_x());
		 System.out.println("New Y of Bottom Left: " + a.get_y());
		 System.out.println("New X of Top Right: " + b.get_x());
		 System.out.println("New Y of Top Right: " + b.get_y());

		 Rectangle[] fourRect = rect.divideIntoFour();
		 
		 System.out.println("\nCut Rectangles");
		 
		 for (int i = 0; i <= fourRect.length - 1; i++) {
			 System.out.println("Point a" + (i + 1) + " x: " + fourRect[i]._bottomLeft.get_x());
			 System.out.println("Point a" + (i + 1) + " y: " + fourRect[i]._bottomLeft.get_y());
			 System.out.println("Point b" + (i + 1) + " x: " + fourRect[i]._topRight.get_x());
			 System.out.println("Point b" + (i + 1) + " y: " + fourRect[i]._topRight.get_y() + "\n");
		 }
		 
		 Triangle[] twoTria = rect.divideIntoTwoTriangles(rect, a, b);
		 
		 System.out.println("Cut Triangles");
		 
		 for (int i = 0; i <= twoTria.length - 1; i++) {
			 System.out.println("Corner Point " + (i + 1) + " x: " + twoTria[i].get_a().get_x());
			 System.out.println("Corner Point " + (i + 1) + " y: " + twoTria[i].get_a().get_y());
			 System.out.println("1st Diagonal Point " + (i + 1) + " x: " + twoTria[i].get_b().get_x());
			 System.out.println("1st Diagonal Point " + (i + 1) + " y: " + twoTria[i].get_b().get_y());
			 System.out.println("2nd Diagonal Point " + (i + 1) + " x: " + twoTria[i].get_c().get_x());
			 System.out.println("2nd Diagonal Point " + (i + 1) + " y: " + twoTria[i].get_c().get_y() + "\n");
		 }
	}
}
