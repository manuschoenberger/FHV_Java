package at.fhv.msc.java;

public class Probe {
	
	private double _temperature;
	private int _time;
	
	public Probe(int time, double temperature) {
		_temperature = temperature;
		_time = time;
	}

	public double getTemperature() {
		return _temperature;
	}

	public int getTime() {
		return _time;
	}
}
