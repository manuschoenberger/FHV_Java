package at.fhv.msc.java;

public class Stack {

	public final static int DEFAULT_STACKSIZE = 128;
	private int[] _values = new int[32];
	private int _sp = 0;
	
	public Stack() {
		_values = new int[DEFAULT_STACKSIZE];
		_sp = 0; //number of items on stack
	}
	
	public Stack(int size) {
		_values = new int[size];
		_sp = 0; //number of items on stack		
	}
	
	public void push(int value) {
		_values[_sp++] = value;
	}
	
	public int pop() {
		return _values[--_sp];		
	}
	
	public int peek() { //give back top element of stack (Without decreasing or increasing)
		return _values[_sp - 1];
	}
	
	public boolean isEmpty() {
		return (_sp <= 0);
	}
	
	public boolean isFull() {
		return (_sp == _values.length);
	}
	
	public static void main(String[] args) {
//		System.out.println("Stack Tests");
//		Stack testStack = new Stack(1000);
//		testStack.push(12);
//		testStack.push(20);
//		testStack.push(1);
	}

}
