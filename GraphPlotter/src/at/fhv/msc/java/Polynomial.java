package at.fhv.msc.java;

import java.awt.Color;

public class Polynomial {
	private double _a;
	private double _b;
	private double _c;
	private Color _color;
	
	public Polynomial(double a, double b, double c, Color color) {
		_a = a;
		_b = b;
		_c = c;
		_color = color;
	}

	public double getA() {
		return _a;
	}

	public void setA(double a) {
		_a = a;
	}

	public double getB() {
		return _b;
	}

	public void setB(double b) {
		_b = b;
	}

	public double getC() {
		return _c;
	}

	public void setC(double c) {
		_c = c;
	}

	public Color getColor() {
		return _color;
	}

	public void setColor(Color color) {
		_color = color;
	}
}
