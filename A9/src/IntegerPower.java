import java.util.Scanner;

public class IntegerPower {
	
	public static double calculatePower(double n, int power) {
		if(power == 1) {
			return n;
		}
		return n * calculatePower(n, power-1);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number that will be raised to a power as a double: ");
		Double value = input.nextDouble();
		
		System.out.println("Enter the exponent as an integer: ");
		int exponent = input.nextInt();
		
		System.out.printf("%.2f raised to the power of %d is %,.2f ", value, exponent, calculatePower(value, exponent));

	}

}
