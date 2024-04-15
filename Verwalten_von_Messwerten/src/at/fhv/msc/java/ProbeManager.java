package at.fhv.msc.java;

import java.util.LinkedList;

public class ProbeManager {
	
	public static final int _DEFAULT_PROBELIST_SIZE = 10;

	private LinkedList<Probe> _probes;
	private int _size;
	private static ProbeManager _instance;
	
	public ProbeManager() {
		this(_DEFAULT_PROBELIST_SIZE);
	}
	
	public ProbeManager(int size) {
		_probes = new LinkedList<Probe>();
		_size = size;
	}
	
	public static ProbeManager instance(int size) {
		if (_instance == null) {
			_instance = new ProbeManager(size);
		}
		
		return _instance;
	}
	
	public String addProbe(Probe probe) {
		if (_probes.size() < _size) {
			_probes.add(probe);
			
			return "Successful!";
		} else {
			Probe temporaryProbe = _probes.peekFirst();
			
			_probes.removeFirst();
			_probes.add(probe);
			
			return "Successful! Last probe: " + temporaryProbe.getTemperature() + " at " + temporaryProbe.getTime() + " deleted.";
		}
	}
	
	public float average() {
		int sum = 0;
		
		for (Probe probe : _probes) {
			sum += probe.getTemperature();
		}
		
		return sum / _probes.size();
	}
	
	public double maximum() {
		double max = 0;
		
		for (Probe probe : _probes) {
			if (probe.getTemperature() > max) {
				max = probe.getTemperature();
			}
		}
		
		return max;
	}
	
	public double minimum() {
		double min = _probes.peekFirst().getTemperature();
		
		for (Probe probe : _probes) {
			if (probe.getTemperature() < min) {
				min = probe.getTemperature();
			}
		}
		
		return min;
	}
	
	@Override
	public String toString() {
		return "ProbeManager [_probes=" + _probes + ", _size=" + _size + ", average()=" + average() + ", maximum()="
				+ maximum() + ", minimum()=" + minimum() + "]";
	}

	public static void main(String[] args) {
		ProbeManager probes = ProbeManager.instance(5);
		
		System.out.println(probes.addProbe(new Probe(1,15.3)));
		System.out.println(probes.addProbe(new Probe(2,15.7)));
		System.out.println(probes.addProbe(new Probe(3,15.9)));
		System.out.println(probes.addProbe(new Probe(4,17.6)));
		System.out.println(probes.addProbe(new Probe(5,17.1)));
		System.out.println(probes.addProbe(new Probe(6,16.6)));
		System.out.println(probes.addProbe(new Probe(7,16.0)));

		System.out.println("Average: " + probes.average());
		System.out.println("Maximum: " + probes.maximum());
		System.out.println("Minimum: " + probes.minimum());
	}

}
