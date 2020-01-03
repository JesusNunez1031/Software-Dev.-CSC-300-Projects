import java.util.Arrays;
import java.util.HashSet;

public class InfixToPostfixConverter {

	public StringBuilder infix = new StringBuilder();
	public StringBuilder postfix = new StringBuilder();
	public Stack<Character> stack = new Stack<>();
	HashSet<Character> match = new HashSet<Character>(Arrays.asList('+', '-', '*', '/', '%', '^'));

	public InfixToPostfixConverter(String input) {
		this.infix.append(input);
	}

	public int checkPrec(char c) {
		switch (c) {
		case '-':
		case '+':
			return 1;
		case '*':
		case '/':
		case '%':
			return 2;
		case '^':
			return 3;
		}
		return 1;
	}

	public StringBuilder convertToPostFix() {

		infix.append(')');

		for (int i = 0; i < infix.length(); i++) {
			Character value = infix.charAt(i);
			if (Character.isLetterOrDigit(value)) {
				postfix.append(value);
			}

			if (infix.charAt(i) == '(') {
				stack.push(infix.charAt(i));
			}

			if (value == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				stack.pop();
			} else if (match.contains(value)) {
				while (!stack.isEmpty() && checkPrec(value) <= checkPrec(stack.peek()) && stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				stack.push(value);
			}

		}
		return postfix;
	}

}
