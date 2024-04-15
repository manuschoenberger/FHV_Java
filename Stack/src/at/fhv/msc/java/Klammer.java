package at.fhv.msc.java;

public class Klammer {
	
	public static boolean evaluate(String expression) {
	Stack stack = new Stack();
	String[] tokens = expression.split("");
	
		for(int i = 0; i < tokens.length; i++) {
			char c = expression.charAt(i);
			switch(c) {
			case '(':
			case '[':
			case '{':
				stack.push(c);
				break;
			case '}':
				if (stack.pop() != '{') {
					return false;
				}
				break;
			case ']':
				if (stack.pop() != '[') {
					return false;
				}
				break;
			case ')':
				if (stack.pop() != '(') {
					return false;
				}
				break;
			default:
			}
		}
		
		if (!stack.isEmpty()) {
			return false;
		}
		
		return true;
	}
	


	public static void main(String[] args) {
		System.out.println("K L A M M E R");
		String expression = "([bla(b)xy({}x)]y)";
		
	//	Calculator calc = new Calculator();
	//	int result = evaluate(expression);
		System.out.println("Expression = '" + expression + "'\nResult = " + evaluate(expression));
	}
} 