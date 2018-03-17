public class Notation {

	private static boolean isSpace(char ch) {
		return (ch == ' ');
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static boolean isLeftParenthesis(char ch) {
		return ch == '(';
	}

	private static boolean isRightParenthesis(char ch) {
		return ch == ')';
	}

	private static int precedenceLevel(char op) {
		switch (op) {
		case '+':
		case '-':
			return 0;
		case '*':
		case '/':
			return 1;
		default:
			throw new IllegalArgumentException("Operator unknown: " + op);
		}
	}

	public static String convertInfixToPostfix(String Infix) {
		MyStack<Character> operatorStack = new MyStack<>(Infix.length());
		MyQueue<Character> soloutionQ = new MyQueue<>(Infix.length());

		for (int index = 0; index < Infix.length(); index++) {
			char ch = Infix.charAt(index);
			if (isSpace(ch)) {
				continue;
			} else if (Character.isDigit(ch)) {
				soloutionQ.enqueue(ch);
			} else if (isLeftParenthesis(ch)) {
				operatorStack.push(ch);
			} else if (isOperator(ch)) {
				if (operatorStack.isEmpty()) {
					throw new InvalidNotationFormatException();
				}
				if (isOperator(operatorStack.top()) && precedenceLevel(ch) >= precedenceLevel(operatorStack.top())) {
					soloutionQ.enqueue(operatorStack.pop());
					operatorStack.push(ch);
				} else {
					operatorStack.push(ch);
				}
			} else if (isRightParenthesis(ch)) {
				if (!operatorStack.isEmpty()) {
					char topToken = operatorStack.pop();
					while (topToken != '(') {
						soloutionQ.enqueue(topToken);
						topToken = operatorStack.pop();
					}
				} else {
					throw new InvalidNotationFormatException();
				}
			}
		}

		while (!operatorStack.isEmpty()) {
			soloutionQ.enqueue(operatorStack.pop());
		}

		return soloutionQ.toString();
	}

	public static String convertPostfixToInfix(String Postfix) {
		MyStack<String> operatorStack = new MyStack<>(Postfix.length());

		for (int index = 0; index < Postfix.length(); index++) {
			char ch = Postfix.charAt(index);
			if (isSpace(ch)) {
				continue;
			} else if (Character.isDigit(ch)) {
				operatorStack.push("" + ch);

			} else if (isOperator(ch)) {

				if (operatorStack.isEmpty() || operatorStack.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				String v1 = operatorStack.pop(), v2 = operatorStack.pop();
				operatorStack.push("(" + v2 + ch + v1 + ")");

			}
		}

		if (operatorStack.size() != 1) {
			throw new InvalidNotationFormatException();
		}

		return operatorStack.toString();
	}

	public static double evaluatePostfixExpression(String Postfix) {

		MyStack<Double> operatorStack = new MyStack<>(Postfix.length());

		for (int index = 0; index < Postfix.length(); index++) {
			char ch = Postfix.charAt(index);

			if (isSpace(ch)) {
				continue;
			} else if (Character.isDigit(ch)) {
				operatorStack.push((double) (ch - '0'));

			} else {
				if (operatorStack.isEmpty() || operatorStack.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				Double v1 = operatorStack.pop(), v2 = operatorStack.pop();
				switch (ch) {
				case '+':
					operatorStack.push(v2 + v1);
					break;

				case '-':
					operatorStack.push(v2 - v1);
					break;

				case '/':
					operatorStack.push(v2 / v1);
					break;

				case '*':
					operatorStack.push(v2 * v1);
					break;
				}
			}
		}
		return operatorStack.pop();
	}

}
