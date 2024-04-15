package at.fhv.msc.java;

public class Transportauftrag {
	
	public static final int _DEFAULT_MAX_VOLUME = 10;
	public static final int _DEFAULT_NAN_ID = 1000000;
	
	private static int _staticOrderID = _DEFAULT_NAN_ID;
	private int _orderID;
	private Trolley _trolley = Trolley.instance(0,0,_DEFAULT_MAX_VOLUME);
	
	
	public Transportauftrag() {
		_orderID = (_staticOrderID++) + 1;
	}
	
	public int get_orderID() {
		return _orderID;
	}

	public void loadAt(int x, int y) {
		_trolley.move(x,y);
		_trolley.load();
	}
	
	public void unloadAt(int x, int y) {
		_trolley.move(x,y);
		_trolley.unload();
	}
}
