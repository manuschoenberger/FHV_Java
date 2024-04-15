package at.fhv.msc.java;

public class PrimeTool {
	
	public final static int _DEFAULT_SIZE = 1048576;
	private static boolean[] _primes = new boolean[_DEFAULT_SIZE];
	private static String[] _allPrimes = new String[_DEFAULT_SIZE];
	private static int _thresh = 0;
	private static int _primesSize = 0;
	
	static {
		for (int i = 2; i < _primes.length; i++) {
			_primes[i] = true;
		}
	
		for (int i = 2; (i * i) < _primes.length; i++) {
			if (_primes[i] == true) {
				for (int j = (i * i); j < _primes.length; j += i) {
					_primes[j] = false;
				}
			}
		}
	}

	public static boolean isPrime(int num) {
		for (; _thresh <= num; _thresh++) {
			if (_primes[_thresh] == true) {
				_allPrimes[_primesSize] = Integer.toString(_thresh);
				_primesSize++;
			}
		}

		if ((num < 2) || (num > _primes.length)) {
			return false;
		} 
		
		for (int i = 0; ((i < _allPrimes.length - 1) && (_allPrimes[i] != null)); i++) {
			if (_allPrimes[i].equals(Integer.toString(num))) {
				return true;
			}
		}
			
		return false;
	}
	
	public static String[] getPrimesInRange(int lowerBound, int upperBound) {	
		if (upperBound > _primes.length ) {
			String[] errorMsg = new String[1];
			errorMsg[0] = "Number too high";
			return errorMsg;
		}
		
		String[] rangedPrimes = new String[_DEFAULT_SIZE];
		int startingPoint = 0;
		
		if ((upperBound > _thresh) || (lowerBound > _thresh)) {
			
			for (; _thresh <= upperBound; _thresh++) {
				if (_primes[_thresh] == true) {
					_allPrimes[_primesSize] = Integer.toString(_thresh);
					_primesSize++;
				}
			}
			
			for (; Integer.parseInt(_allPrimes[startingPoint]) <= lowerBound; startingPoint++) {}
			
			for (int i = 0; (_allPrimes[startingPoint] != null) && (Integer.parseInt(_allPrimes[startingPoint]) <= upperBound); i++) {
				rangedPrimes[i] = _allPrimes[startingPoint];
				startingPoint++;
			}
			
		} else {
			for (; Integer.parseInt(_allPrimes[startingPoint]) <= lowerBound; startingPoint++) {}
			
			for (int i = 0; (_allPrimes[startingPoint] != null) && (Integer.parseInt(_allPrimes[startingPoint]) <= upperBound); i++) {
				rangedPrimes[i] = _allPrimes[startingPoint];
				startingPoint++;
			}
		}
		
		return rangedPrimes;
	}

	public static void main(String[] args) {		
		boolean testIsPrime = PrimeTool.isPrime(51);
		System.out.println("Is Prime?\t" + testIsPrime);
		
		String[] testRangedPrimes = PrimeTool.getPrimesInRange(100,200);
		System.out.println("\nPrimes in range:");
		for (int i = 0; ((i < testRangedPrimes.length) && (testRangedPrimes[i] != null)); i++) {
			System.out.println(testRangedPrimes[i]);
		}

	}

	@Override
	public String toString() {
		return "PrimeTool [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
