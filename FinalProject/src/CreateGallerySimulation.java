import java.util.Scanner;

public class CreateGallerySimulation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Month Day and Year of the simulation: ");
		String date = input.nextLine();

		SenateGallery gallery = new SenateGallery(date);

		System.out.println("Please enter the length of the simulation in minutes: ");
		int time = input.nextInt();

		gallery.initializeSenateGallery();
		gallery.runSenateGallerySimulation(time);

		gallery.outputStatistics();


	}

}
