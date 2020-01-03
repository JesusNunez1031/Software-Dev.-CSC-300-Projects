import java.util.Scanner;

public class TestPrintQueueSimulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of printers: ");
        int printers = input.nextInt();
        System.out.println("Enter the number of print jobs: ");
        int numOfJobs = input.nextInt();
        PrintQueueSimulation sim = new PrintQueueSimulation(numOfJobs, printers);
        sim.simulate();
    }
}
