import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Hospital {
    public String hospitalName;
    public String hospitalCity;
    public int timeOfDay = 0;

    DecimalFormat format = new DecimalFormat("0.00");

    // A list of patients in the wait queue
    Queue<Patient> patientList = new ArrayDeque<>();

    // Patients seen by doctors 1, 2, 3
    Patient[] currentPatient = new Patient[3];

    // set to false when the doctor has no patient, and true after a patient has been assigned
    boolean[] servingPatients = new boolean[3];

    // keeps track of the number of patients completed by doctor
    int[] checkedPatients = new int[3];

    // patients that have completed their exam
    List<Patient> completedPatients = new ArrayList<>();

    Patient[] currentPatients = new Patient[3];

    public Hospital(String name, String city) {
        this.hospitalName = name;
        this.hospitalCity = city;
    }

    public void addPatient(Patient patient) {
        patientList.offer(patient);
    }

    public void update(){
        timeOfDay += 1;
        for(int i = 0;i < servingPatients.length;i++){
            if(servingPatients[i]){
                currentPatient[i].setDocStartTime(currentPatient[i].getDocStartTime()+1);
                if (currentPatient[i].getDocStartTime() >= currentPatient[i].getExaminationTime()) {
                    completedPatients.add(currentPatient[i]);
                    checkedPatients[i]++;
                    currentPatient[i] = null;
                    servingPatients[i] = false;
                }
            }
        }

        for(int i = 0; i < servingPatients.length;i++){
            if(patientList.peek() != null) {
                if(!servingPatients[i]){
                    servingPatients[i] = true;
                    currentPatient[i] = patientList.peek();
                    patientList.poll();
                    currentPatient[i].setWaitTime(timeOfDay);
                    currentPatient[i].setDocStartTime(timeOfDay);
                }
            }
        }

        for (Patient e : patientList){
            e.setWaitTime(timeOfDay);
        }
    }

    public double getAvgWaitTime(){
        double sum = 0;
        for(Patient e : completedPatients) {
            sum += Math.abs(e.getArrivalTime() - e.getWaitTime());
        }
        return (sum / completedPatients.size());
    }

    public String statistics() {
        return "This is the output of " + this.hospitalName + " in the city of " + this.hospitalCity + "\n" +
                "The total number of patients that came to the hospital is " + completedPatients.size() + "\n" +
                "The number of patients remaining in the queue at the end of the measured time is " + patientList.size() + "\n" +
                "The number of patients seen and processed by doctor 0 is " + checkedPatients[0] + "\n" +
                "The number of patients seen and processed by doctor 1 is " + checkedPatients[1] + "\n" +
                "The number of patients seen and processed by doctor 2 is " + checkedPatients[2] + "\n" +
                "The average wait time for a patient who has completed the visit is " + format.format(getAvgWaitTime()) + " minutes in the waiting room.";
    }
}
