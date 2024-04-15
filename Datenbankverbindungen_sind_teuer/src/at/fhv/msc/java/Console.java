package at.fhv.msc.java;

public class Console {

	private User _c1;
	private User _c2;
	private User _c3;
	private User _c4;
	private User _c5;
	private User _c6;
	private User _c7;
	private User _c8;
	
	public Console() {
		_c1 = new User();
		_c2 = new User();
		_c3 = new User();
		_c4 = new User();
		_c5 = new User();
		_c6 = new User();
		_c7 = new User();
		_c8 = new User();
	}

	public User getC1() {
		return _c1;
	}

	public void setC1(User c1) {
		_c1 = c1;
	}

	public User getC2() {
		return _c2;
	}

	public void setC2(User c2) {
		_c2 = c2;
	}

	public User getC3() {
		return _c3;
	}

	public void setC3(User c3) {
		_c3 = c3;
	}

	public User getC4() {
		return _c4;
	}

	public void setC4(User c4) {
		_c4 = c4;
	}

	public User getC5() {
		return _c5;
	}

	public void setC5(User c5) {
		_c5 = c5;
	}

	public User getC6() {
		return _c6;
	}

	public void setC6(User c6) {
		_c6 = c6;
	}

	public User getC7() {
		return _c7;
	}

	public void setC7(User c7) {
		_c7 = c7;
	}

	public User getC8() {
		return _c8;
	}

	public void setC8(User c8) {
		_c8 = c8;
	}

	public static void main(String[] args) {
		Console console = new Console();
		
		System.out.println("1. " + console.getC1().connect());
		System.out.println("2. " + console.getC2().connect());
		System.out.println("3. " + console.getC3().connect());
		System.out.println("4. " + console.getC4().connect());
		try {
			System.out.println("5. " + console.getC3().disconnect());
		} catch (NotConnectedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("6. " + console.getC4().connect());
		System.out.println("7. " + console.getC5().connect());
		try {
			System.out.println("8. " + console.getC2().disconnect());
		} catch (NotConnectedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("9. " + console.getC6().connect());
		try {
			System.out.println("10. " + console.getC7().disconnect());
		} catch (NotConnectedException e) {
			System.out.println("10.\nUser Error:" + e.getMessage());
		}
		System.out.println("11. " + console.getC7().connect());
		try {
			System.out.println("12. " + console.getC4().disconnect());
		} catch (NotConnectedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("13. " + console.getC8().connect());
		
		System.out.println("\nTotal Errors: " + User.get_exceptionCounter());
	}

}
