package at.fhv.msc.java;

public enum CustomerType {
	external(30,14,1,0.5),student(30,14,1,0),teacher(60,14,2,0);
	
	private final int _borrowTimePrintable;
	private final int _borrowTime;
	private final int _maxExtensions;
	private final double _fee;
	
	CustomerType(int borrowTimeBM, int borrowTime, int maxExtensions, double fee) {
		_borrowTimePrintable = borrowTimeBM;
		_borrowTime = borrowTime;
		_maxExtensions = maxExtensions;
		_fee = fee;
	}

	// GETTER / SETTER:
	
	public int getBorrowTimePrintable() {
		return _borrowTimePrintable;
	}

	public int getBorrowTime() {
		return _borrowTime;
	}

	public int getMaxExtensions() {
		return _maxExtensions;
	}

	public double getFee() {
		return _fee;
	}
}
