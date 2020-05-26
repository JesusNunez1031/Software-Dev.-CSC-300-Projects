import java.io.IOException;
import java.util.Scanner;

public class CreateNewUniversity {

    public static void main(final String[] args) throws IOException {
        final Scanner input = new Scanner(System.in);

        System.out.println("What is the name of the university?");
        final String name = input.nextLine();

        final University uni = new University(name);

        uni.hireAdvisors();
        uni.admitStudents();
        uni.printUniversityCommunity();
        
    }
}