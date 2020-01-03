import java.util.Random;

public class Patient {
    public int patientID;
    public int arrivalTime;
    public int waitTime;
    public int docStartTime;
    public int examinationTime;
    static int idCounter;

    Random random = new Random();

    public Patient() {
        this.idCounter++;
        this.patientID = idCounter;
        this.examinationTime = random.nextInt(15);
    }

    public int getPatientID() {
        return patientID;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDocStartTime() {
        return docStartTime;
    }

    public int getExaminationTime() {
        return examinationTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public void setDocStartTime(int docStartTime) {
        this.docStartTime = docStartTime;
    }
}
