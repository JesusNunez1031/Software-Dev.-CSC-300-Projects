import java.util.Stack;

public class RecursiveStackPop {
	public static Stack<Integer> numStack = new Stack<>();
	public static Stack<Character> letterStack = new Stack<>();

	public static void populateStackInt() {
		int counter = 0;
		while (counter != 26) {
			numStack.add(counter);
			counter++;
		}
	}

	public static void populateStackChar() {
		int character = 'A';
		while (!(character > (int) 'Z')) {
			letterStack.add((char) character);
			character++;
		}
	}

	public static <E> void recursiveStackPoper(Stack<E> stack) {
		if (stack.isEmpty()) {
			System.out.print(" Stack is empty");
			return;
		} else {
			E i = stack.pop();
			System.out.print(" " + i);
			recursiveStackPoper(stack);
		}
	}

	public static void main(String[] args) {
		populateStackInt();
		populateStackChar();

		recursiveStackPoper(numStack);
		System.out.println();
		recursiveStackPoper(letterStack);

	}

}
