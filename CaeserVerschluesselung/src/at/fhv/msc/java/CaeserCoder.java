package at.fhv.msc.java;

public class CaeserCoder {
	
	private int _shift;
	
	public CaeserCoder() {
		this(4);
	}
	
	public CaeserCoder(int shift) {
		_shift = shift;
	}
	
	public String encode(String in) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < in.length(); i++) {
			if ((in.charAt(i) >= 'A') && (in.charAt(i) <= 'Z')) {
				sb.append((char)(((in.charAt(i) + _shift - 'A') % 26) + 'A'));
			}
			if ((in.charAt(i) >= 'a') && (in.charAt(i) <= 'z')) {
				sb.append((char)(((in.charAt(i) + _shift - 'a') % 26) + 'a'));
			}
		}	
		
		return sb.toString();
	}
	
	public String decode(String in) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < in.length(); i++) {
			if ((in.charAt(i) >= 'A') && (in.charAt(i) <= 'Z')) {
				sb.append((char)(((in.charAt(i) - _shift + 'A') % 26) + 'A'));
			}
			if ((in.charAt(i) >= 'a') && (in.charAt(i) <= 'z')) {
				sb.append((char)(((in.charAt(i) - _shift + 'o') % 26) + 'a'));
			}
		}	
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return "CaeserCoder [_shift=" + _shift + "]";
	}

	public static void main(String[] args) {
		CaeserCoder test = new CaeserCoder();
		
		String testString = "xyz";
		String encString = test.encode(testString);
		
		System.out.println("encode: " + encString);
		System.out.println("decode: " + test.decode(encString));
	}

}
