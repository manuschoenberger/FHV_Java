package at.fhv.msc.java;

import java.util.HashMap;

public class Student {
	
	public final static int _DEFAULT_SIZE = 1;
	public final static int _DEFAULT_LENGTH = 5;
	private HashMap <String,Integer> _studentIDs;
	private Codeword _codeword;
	
	public Student() {
		this(_DEFAULT_SIZE,_DEFAULT_LENGTH);
	}
	
	public Student(int n) {
		this(n,_DEFAULT_LENGTH);
	}
	
	public Student(int n, int len) {
		_codeword = new Codeword(n);
		_studentIDs = _codeword.generateCodeword(len);
	}

	@Override
	public String toString() {
		return "Student [_codeword=" + _codeword + "]";
	}

	public static void main(String[] args) {
		Student test = new Student(10,2);
		System.out.println(test._studentIDs);
		
		Student test2 = new Student();
		System.out.println(test2._studentIDs);
	}

}
