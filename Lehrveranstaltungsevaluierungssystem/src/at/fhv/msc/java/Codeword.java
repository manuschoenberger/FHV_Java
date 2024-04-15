package at.fhv.msc.java;

import java.util.Random;
import java.util.HashMap;

public class Codeword {
	
	public final static int _DEFAULT_SIZE = 10;
	private static HashMap <String, Integer> _totalCodewords;
	private static int _hashID = 0;
	private StringBuilder _codeword;
	private int _maxCodewords;
	
	public Codeword() {
		this(_DEFAULT_SIZE);
	}
	
	public Codeword(int n) {
		_totalCodewords = new HashMap<>(n * 2);
		_codeword = new StringBuilder();
		_maxCodewords = n;
	}
	
	public HashMap <String, Integer> generateCodeword(int len) {
		Random randomNumber = new Random();
		
		for (int i = 0; i < _maxCodewords; i++) {
			for (int j = 0; j < len; j++) {
				_codeword.append((char)randomNumber.nextInt('a','z' + 1));
			}
			
			if (!_totalCodewords.containsKey(_codeword.toString())) {
				_totalCodewords.put(_codeword.toString(), (_hashID++) + 1);
			} else {
				_codeword.delete(0, _codeword.length());
				generateCodeword(len);
			}
			
			_codeword.delete(0, _codeword.length());
		}
		
		return _totalCodewords;
	}

	@Override
	public String toString() {
		return "Codeword [_code=" + _codeword + ", _maxCodewords=" + _maxCodewords + "]";
	}

	public static void main(String[] args) {
		Codeword test = new Codeword(8);
		System.out.println(test.generateCodeword(5));

	}

}
