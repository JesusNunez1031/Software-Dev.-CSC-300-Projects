public class Printer {

    public Job job;
    public String name;
    public int startIdleTime, startInUseTime, totalIdleTime, totalInUseTime, totalJobsProcessed;
    public int timePassed;

    public Printer(String name){
        this.name = name;
    }

    public void setPrinterName(String printerName) {
        this.name = printerName;
    }

    public String getPrinterName() {
        return this.name;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return this.job;
    }

    public void setStartInUseTime(int startInUseTime) {
        this.startInUseTime = startInUseTime;
    }

    public void setStartIdleTime(int startIdleTime) {
        this.startIdleTime = startIdleTime;
        this.totalInUseTime += this.getJob().getTimeForTheJob();
    }

    public int getTotalIdleTime() {
        return this.totalIdleTime;
    }

    public int getStartIdleTime() {
        return this.startIdleTime;
    }

    public void incJobsProcessed(){
        this.totalJobsProcessed++;
    }

    public int getTotalInUseTime() {
        return this.totalInUseTime;
    }

    public int getTotalJobsProcessed() {
        return this.totalJobsProcessed;
    }
    public void incTimePassed(){
        this.timePassed++;
    }
    public void resetTimer(){
        this.timePassed = 0;
    }
    public int getTimePassed(){
        return this.timePassed;
    }
}
