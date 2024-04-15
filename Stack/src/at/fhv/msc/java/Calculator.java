package at.fhv.msc.java;

public class Calculator {
	
	public static int evaluate(String expression) {
		Stack stack = new Stack();
		String[] tokens = expression.split(" ");
	
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a + b);
			} else if (tokens[i].equals("-")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a - b);
			} else if (tokens[i].equals("*")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a * b);
			} else if (tokens[i].equals("/")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a / b);
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
	
	return stack.peek();
	}
	
	
	public static void main(String[] args) {
		System.out.println("C A L C U L A T O R");
		String expression = "14 3 * 4 * 12 3 - 5 * /";
		
//		Calculator calc = new Calculator();
//		int result = evaluate(expression);
		System.out.println("Expression = | " + expression + " |\nResult = " + evaluate(expression));
	}
}
