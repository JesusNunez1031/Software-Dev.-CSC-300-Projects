import java.util.Scanner;

public class TestHospital {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the Hospital: ");
        String name = input.nextLine();

        System.out.println("What is the city? ");
        String city = input.nextLine();
        Hospital hospital = new Hospital(name, city);

        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        Patient patient3 = new Patient();
        Patient patient4 = new Patient();
        Patient patient5 = new Patient();
        Patient patient6 = new Patient();
        Patient patient7 = new Patient();
        Patient patient8 = new Patient();
        Patient patient9 = new Patient();
        Patient patient10 = new Patient();

        hospital.addPatient(patient1);
        hospital.addPatient(patient2);
        hospital.addPatient(patient3);
        hospital.addPatient(patient4);
        hospital.addPatient(patient5);
        hospital.addPatient(patient6);
        hospital.addPatient(patient7);
        hospital.addPatient(patient8);
        hospital.addPatient(patient9);
        hospital.addPatient(patient10);

        for(int i = 0; i <= 360;i++){
            if(i % 10 == 0){
                Patient n1 = new Patient();
                Patient n2 = new Patient();
                Patient n3 = new Patient();
                n1.setArrivalTime(i);
                n2.setArrivalTime(i);
                n3.setArrivalTime(i);
                hospital.addPatient(n1);
                hospital.addPatient(n2);
                hospital.addPatient(n3);
            }
            hospital.update();
        }
        System.out.println(hospital.statistics());
    }
}
