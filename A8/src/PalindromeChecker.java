import java.util.Scanner;

public class PalindromeChecker {
	
	public static Stack<Character> stack = new Stack<>();
	
	public static boolean isPalindrome(String input) {
		// Replace all special characters and spaces with no space and make string lower case
		String text = input.toLowerCase().replaceAll("([^a-zA-Z]|\\s)+", "");
		String result = "";

		for (int i = 0; i < text.length(); i++) {
			stack.push(text.charAt(i));
		}

		for (int i = 0; i < text.length(); i++) {
			result += stack.pop();
		}
		return text.equals(result);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the desired string to check if it is a palindrome");
		String palindrome = input.nextLine();
		
		System.out.printf("%s", isPalindrome(palindrome));

	}

}
