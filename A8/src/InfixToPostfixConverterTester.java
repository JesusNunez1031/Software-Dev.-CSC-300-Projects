import java.util.Scanner;

public class InfixToPostfixConverterTester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter an infix expression:");
		String expression = input.nextLine();
		
		InfixToPostfixConverter exe = new InfixToPostfixConverter(expression);
		
		System.out.printf("The original infix expression is: \n %s", expression);
		System.out.printf("\nThe expression in postfix notation is: \n %s", exe.convertToPostFix());

	}

}
