package at.fhv.msc.java;

import java.awt.Color;
import java.awt.Graphics;

public class Axes {
	
	private int _centerX;
	private int _centerY;
	private int _width;
	private int _height;
	private double _scaleAxisX;
	private double _zoomLevel;
	
	private static final int DEFAULT_AXES_SCALING_LINE_LENGTH = 5;

	public Axes(int centerX, int centerY, int width, int height, double xScaling, double zoomLevel) {
		_centerX = centerX;
		_centerY = centerY;
		_width = width;
		_height = height;
		_scaleAxisX = xScaling;
		_zoomLevel = zoomLevel;
	}
	
	public void axesConfig(Graphics graph) {
		graph.setColor(Color.GRAY);

		int scaledWidth =  (int) (_width );
        int scaledHeight = (int) (_height );
		
		// plot x axis
		graph.drawLine(0, _centerY, 2 * _centerX, _centerY);
		graph.drawString("x", 2 * _centerX - 10, _centerY - 10);
		
		// plot axis-scaling-lines on x axis
		for (int x = 0; x < scaledWidth / 2; x += 50 / _zoomLevel) {
			int factorXpos = _centerX + (int) (x * _zoomLevel);
			graph.drawLine(factorXpos, _centerY - DEFAULT_AXES_SCALING_LINE_LENGTH, factorXpos, _centerY + DEFAULT_AXES_SCALING_LINE_LENGTH);
			graph.drawString(Integer.toString((int)(x / _scaleAxisX)), factorXpos - 5, _centerY + 20);
			int factorXneg = _centerX - (int) (x * _zoomLevel);
			graph.drawLine(factorXneg, _centerY - DEFAULT_AXES_SCALING_LINE_LENGTH, factorXneg, _centerY + DEFAULT_AXES_SCALING_LINE_LENGTH);
			graph.drawString(Integer.toString((int)(x / _scaleAxisX)), factorXneg - 5, _centerY + 20);
		}
		
		// plot y axis
		graph.drawLine(_centerX, 0, _centerX, 2 * _centerY);
		graph.drawString("y", _centerX - 20, 20);
		
		// plot axis-scaling-lines on y axis
		for (int y = 0; y < scaledHeight / 2; y += 50 / _zoomLevel) {
			int factorYpos = _centerY - (int) (y * _zoomLevel);
			graph.drawLine(_centerX - DEFAULT_AXES_SCALING_LINE_LENGTH, factorYpos, _centerX + DEFAULT_AXES_SCALING_LINE_LENGTH, factorYpos);
			graph.drawString(Integer.toString(y), _centerX + 10, factorYpos + 5);
			int factorYneg = _centerY + (int) (y * _zoomLevel);
			graph.drawLine(_centerX - DEFAULT_AXES_SCALING_LINE_LENGTH, factorYneg, _centerX + DEFAULT_AXES_SCALING_LINE_LENGTH, factorYneg);
			graph.drawString(Integer.toString(y), _centerX + 10, factorYneg + 5);
		}			
	}
}
