package at.fhv.msc.java;

import java.awt.geom.Point2D;
import java.text.DecimalFormat;

public class Vector {
    private double _x;
    private double _y;

    public Vector(Point2D point) {
        _x = point.getX();
        _y = point.getY();
    }

    public Vector(Point2D point1, Point2D point2) {
        _x = point2.getX() - point1.getX();
        _y = point2.getY() - point1.getY();
    }

    public Vector(double angle, double length) {
        _x = length * Math.cos(angle);
        _y = length * Math.sin(angle);
    }

    public void scalarMultiply(double factor) {
        _x *= factor;
        _y *= factor;
    }

    public double getLength() {
        return Math.sqrt(_x * _x + _y * _y);	//Norm-Vektorformel
    }

    public Vector normalVector() {
        return new Vector(-_y, _x);				//Normalvektorformel
    }

    public static String lineEquation(Point2D point1, Point2D point2) {
        double a = point2.getY() - point1.getY();
        double b = point1.getX() - point2.getX();
        double c = a * point1.getX() + b * point1.getY();

        return "Geradengleichung:\t\t\t" + a + "x + " + b + "y = " + c;
    }
    
	public static void main(String[] args) {
        Vector vector1 = new Vector(new Point2D.Double(1.0, 2.0));
        System.out.println("Initialisierung mit einem Punkt:\t( " + vector1.getX() + " | " + vector1.getY() + " )");
        
        Vector vector2 = new Vector(new Point2D.Double(1.0, 2.0), new Point2D.Double(3.0, 4.0));
        System.out.println("Initialisierung mit zwei Punkten:\t( " + vector2.getX() + " | " + vector2.getY() + " )");
        
        Vector vector3 = new Vector(Math.PI / 4, 5.0);
        DecimalFormat format = new DecimalFormat("#." + "0".repeat(3));
        System.out.println("Initialisierung durch Winkel und Länge:\t( " + format.format(vector3.getX()) + " | " + format.format(vector3.getY()) + " )");

        vector1.scalarMultiply(2.0);
        System.out.println("Skalarmultiplikation:\t\t\t( " + vector1.getX() + " | " + vector1.getY() + " )");

        System.out.println("Länge des Vektors:\t\t\t( " + format.format(vector2.getLength()) + " )");

        Vector normalVector = vector3.normalVector();
        System.out.println("Normalvektor:\t\t\t\t( " + format.format(normalVector.getX()) + " | " + format.format(normalVector.getY()) + " )");
        
        System.out.println(Vector.lineEquation(new Point2D.Double(1.0, 2.0), new Point2D.Double(3.0, 4.0)));
	}

	public double getX() {
		return _x;
	}
	
	public double getY() {
		return _y;
	}
}

