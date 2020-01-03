import java.io.IOException;
import java.util.Scanner;

public class TestLottery {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		StudentLottery lotto = new StudentLottery();

		System.out.println("Enter the name of the input file with names and ID's: ");
		String file = input.nextLine();

		lotto.addStudents(file);
		lotto.printUnduplicatedList();
		lotto.pickWinner();

	}

}
