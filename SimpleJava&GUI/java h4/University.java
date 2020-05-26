import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class University {

    public String univName;
    ArrayList<Advisor> advList = new ArrayList<Advisor>();
    ArrayList<Student> freshmenStudList = new ArrayList<Student>();
    ArrayList<Student> sophomoreStudList = new ArrayList<Student>();
    ArrayList<Student> juniorStudList = new ArrayList<Student>();
    ArrayList<Student> seniorStudList = new ArrayList<Student>();

    Scanner input = new Scanner(System.in);

    public University() {
        univName = "";
    }

    public University(String name) {
        univName = name;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public void hireAdvisors() throws FileNotFoundException {

        try {

            // Read in file
            System.out.println("Enter the name of the file to read Advisors from: ");
            String file = input.nextLine();
            Scanner reader = new Scanner(new File(file));

            while (reader.hasNextLine()) {
                Advisor adv = new Advisor(reader.nextLine(), reader.nextLine());
                advList.add(adv);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error, file not found");
        }

    }

    public void admitStudents() throws FileNotFoundException {

        int counter = 0;
        String name;
        String year;

            // Read in file
            System.out.println("Enter the name of the file to read Students from: ");
            String file = input.next();
            Scanner reader = new Scanner(new File(file));

            while (reader.hasNextLine()) {

                name = reader.nextLine();
                year = reader.nextLine();
                if (year.equals("Freshman") || year.equals("freshman") || year.equals("Sophomore")
                        || year.equals("sophomore") || year.equals("Junior") || year.equals("junior")
                        || year.equals("Senior") || year.equals("senior")) {
                    Advisor adv = advList.get(counter);
                    Student std = new Student(name, adv, year);

                    if (year.equals("Freshman") || year.equals("freshman")) {
                        freshmenStudList.add(std);
                    } else if (year.equals("Sophomore") || year.equals("sophomore")) {
                        sophomoreStudList.add(std);
                    } else if (year.equals("Junior") || year.equals("junior")) {
                        juniorStudList.add(std);
                    } else if (year.equals("Senior") || year.equals("senior")) {
                        seniorStudList.add(std);
                    }
                    adv.addStudentToAdvisor(std);
                } else {
                    System.out.println(name + " has an illegal student year: " + year + " Rejected entry");
                }
                if (counter >= advList.size()-1) {
                    counter = 0;
                } else {
                    counter++;
                }
            }
            reader.close();
    }

    public void printUniversityCommunity() throws IOException {
        System.out.println("Enter the name of a file to print to: ");
        input.nextLine();
        String file = input.nextLine();

        FileWriter output = new FileWriter(file);
        PrintWriter writer = new PrintWriter(output);

        for (Advisor adv : advList) {
            writer.println("Students advised by " + adv.toString());
            for (int i = 0; i < adv.getNumStudentsInAdvisorList(); i++) {
                writer.println(adv.getStudentFromAdvisorList(i).toString());
            }

        }

        writer.println("FRESHMEN STUDENTS");
        for (Student std : freshmenStudList) {
            writer.println(std.toString());
        }

        writer.println("SOPHOMORE STUDENTS");
        for (Student std : sophomoreStudList) {
            writer.println(std.toString());
        }

        writer.println("JUNIOR STUDENTS");
        for (Student std : juniorStudList) {
            writer.println(std.toString());
        }

        writer.println("SENIOR STUDENTS");
        for (Student std : seniorStudList) {
            writer.println(std.toString());
        }

        writer.close();
    }

}