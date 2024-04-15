
public class Foo {
	
	@SuppressWarnings("removal")
	public static void doIt(Integer a, Integer b) {
		Integer temp = a;
		a = new Integer(b.intValue());
		b = new Integer(temp.intValue());
	}

	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Foo.doIt(a, b);
		System.out.println(a + ":" + b);

	}

}
