import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TestMovieHouse {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a name for the Movie House");
		String name = input.nextLine();

        System.out.println("Enter a number of seats in theaters 0, 1 ,2 as integers \nMinimum 40 seats per theater: ");
        String theaterSeats = input.nextLine();
        String[] numbers = theaterSeats.split(" ");
        int t0 = Integer.parseInt(numbers[0]);
        int t1 = Integer.parseInt(numbers[1]);
        int t2 = Integer.parseInt(numbers[2]);

		MovieHouse house = new MovieHouse(name, t0, t1, t2);

		System.out.println("Enter the base price of a ticket: ");
		Ticket.basePrice = input.nextDouble();

		input.nextLine();
		System.out.println("Enter the name of the output file: ");
		String file = input.nextLine();

		PrintWriter output = new PrintWriter(file, StandardCharsets.UTF_8);

		house.setOutputWriter(output);

		house.startSales(0);
		house.startSales(1);
		house.startSales(2);

		house.printSeatMaps();
		house.printSalesRecords();
		output.close();
	}
}
