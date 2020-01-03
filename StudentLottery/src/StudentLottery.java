import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class StudentLottery {

	private List<Student> lotto = new ArrayList<>();
	private Scanner input = new Scanner(System.in);

	StudentLottery() {
	}

	void addStudents(String file) {
		try {
			// Read in file
			Scanner input = new Scanner(new File(file));
			Student first = new Student(input.next(), input.nextInt());

			lotto.add(first);
			boolean foundDup = false;

			while (input.hasNextLine()) {
				Student student = new Student(input.next(), input.nextInt());

				for (Student students : lotto) {
					if (student.equals(students)) {
						System.out.println(
								"The student " + student.getName() + " " + student.getIdNum() + " is a duplicate");
						foundDup = true;
						break;
					}
				}

				if (!foundDup) {
					lotto.add(student);
				}
				foundDup = false;
			}
			input.close();
		} catch (Exception e) {
			System.out.print("Error, file not found.");
		}
	}

	void printUnduplicatedList() throws IOException {
		System.out.println("Enter the name of a file to print to: ");
		String file = input.nextLine();

		FileWriter output = new FileWriter(file);
		PrintWriter writer = new PrintWriter(output);

		writer.printf(lotto.toString());
		writer.close();
	}

	void pickWinner() {
		Random rand = new Random();
		int winner = rand.nextInt(lotto.size());
		System.out.println("The winner and Principle for a Day is Student " + lotto.get(winner).getName() + " with ID " + lotto.get(winner).getIdNum());
	}

}
