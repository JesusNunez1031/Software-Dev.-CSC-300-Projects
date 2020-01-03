public class Job {
    public int arrivalTime;
    public int timeForTheJob;
    public static int IDCounter = 0;
    public int ID;
    public int startTime, waitTime, endTime;

    public Job(int arrivalTime, int timeForTheJob){
        setArrivalTime(arrivalTime);
        setTimeForTheJob(timeForTheJob);
        ++IDCounter;
        ID = IDCounter;

    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTimeForTheJob() {
        return this.timeForTheJob;
    }

    public void setTimeForTheJob(int timeForTheJob) {
        this.timeForTheJob = timeForTheJob;
    }

    public int getID() {
        return this.ID;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
        this.waitTime = this.getStartTime() - this.getArrivalTime();
    }

    public int getWaitTime() {
        return this.waitTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
