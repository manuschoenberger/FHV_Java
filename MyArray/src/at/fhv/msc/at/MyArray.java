package at.fhv.msc.at;

import java.util.Arrays;

public class MyArray {
	
	private int[] _values = new int[0]; 
	private int _index = 0;
	
	public MyArray() {
		_values = new int[8];
	}
	
	public MyArray(int size) {
		_values = new int[size];
	}
	
	public int get(int index) {
		return _values[index];
	}
	
	public void put(int index, int value) {
		if (index > _values.length) {
			int[] LarA = new int[_values.length + index];
			for (int i = 0; i < _values.length; i++) {
				LarA[i] = _values[i];
			}
			_values = LarA;
			_values[index] = value;
		} else {
			_values[index] = value;
		}
	}
	
	public int length() {
		return _values.length;
	}
	
	public void compress(int value) {
		int countComVal = 0;
		
		for (; _index < _values.length; _index++) {
			if (_values[_index] == value) {
				countComVal++;
			}
		}
		
		_index = 0;
		int[] comA = new int[_values.length - countComVal];
		int comIndex = 0;
		
		for (; _index < _values.length; _index++) {
			if (_values[_index] != value) {
				comA[comIndex] = _values[_index];
				comIndex++;
			}
		}
		
		_values = comA;
	}
	
	public void sort() {
		int len = _values.length;
		
		for (; len > 1; len--) {
			for (int i = 0; i < _values.length - 1; i++) {
				if (_values[i] > _values[i + 1]) {
					int swap = _values[i];
					_values[i] = _values[i + 1];
					_values[i + 1] = swap;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "MyArray [_values=" + Arrays.toString(_values) + ", _index=" + _index + "]";
	}
	
	public static void main(String[] args) {
		MyArray testArray = new MyArray();
		testArray.put(0, 0);
		testArray.put(1, 10);
		testArray.put(10, 1);
		
		testArray.compress(0);
		testArray.sort();

		System.out.println(testArray);
	}

}
