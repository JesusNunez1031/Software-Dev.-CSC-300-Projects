import java.util.Random;

public class PrintQueueSimulation {

    public Queue<Job> waitQueue;
    public int totalWaitTime;
    public Queue<Job> finishedQueue;
    public int currentTime = 0;
    public Printer[] printers;
    public Random randy;
    public int numberOfPrinters, numberOfPrintJobs;

    public PrintQueueSimulation(int numOfJobs, int numOfPrinters){
        randy = new Random();
        this.numberOfPrintJobs = numOfJobs;
        this.numberOfPrinters = numOfPrinters;
        this.waitQueue = new Queue<>(numberOfPrintJobs);
        this.finishedQueue = new Queue<>(numberOfPrintJobs);
        this.printers = new Printer[numberOfPrinters];

        for(int i = 0; i < numOfPrinters;i++) {
            printers[i] = new Printer("Printer" + i);
        }
    }

    public void simulate(){
        boolean flagDone = false;
        int jobCounter = 0;
        while(!flagDone) {
            if(this.currentTime % 100 == 0 && jobCounter != this.numberOfPrintJobs){
                Job job = new Job(this.currentTime, randy.nextInt((1000 - 10) + 1)  + 10);
                waitQueue.insert(job);
                jobCounter++;
            }

            //check if a job finished
            for(int i = 0; i < printers.length;i++){
                if(printers[i].getJob() != null) {
                    Job jobInProgress = printers[i].getJob();
                    if(printers[i].getTimePassed() >= jobInProgress.getTimeForTheJob()) {
                        jobInProgress.setEndTime(this.currentTime);
                        finishedQueue.insert(jobInProgress);
                        printers[i].setStartIdleTime(this.currentTime);
                        printers[i].setJob(null);
                        printers[i].resetTimer();
                        printers[i].incJobsProcessed();
                    }
                    else {
                        printers[i].incTimePassed();
                    }
                }
            }
            // check if printer is idle, if so and there is a job waiting, add it to printer if there is one
            for(int i = 0; i < printers.length;i++){
                if(printers[i].getJob() == null){
                    if(!waitQueue.isEmpty()) {
                        Job currentJob = waitQueue.remove();
                        currentJob.setStartTime(this.currentTime);
                        printers[i].setJob(currentJob);
                        printers[i].setStartInUseTime(this.currentTime);
                        this.totalWaitTime += currentJob.getWaitTime();
                    }
                    else {
                        printers[i].totalIdleTime++;
                    }
                }
            }
            this.currentTime++;

            if(finishedQueue.size() == this.numberOfPrintJobs && waitQueue.isEmpty()){
                flagDone = true;
                for (Printer printer : printers) {
                    if (printer.getJob() != null) {
                        flagDone = false;
                    }
                }
            }
        }
        displayStatistics();
    }

    private void displayStatistics() {
        System.out.printf("Simulation with %s printers lasted %d seconds processed %d jobs \n", this.numberOfPrinters, this.currentTime, this.numberOfPrintJobs);
        System.out.printf("The average time in the wait queue for a job is %d seconds \n", (this.totalWaitTime/this.numberOfPrintJobs));
        System.out.println("\nPrinter Statistics: ");
        String format = "%-5s %-12s %-12s %-10s\n";
        System.out.printf(format, "Name | ", "Jobs Processed | ", "Time in Use | ", "Time idle");
        for(int i = 0;i < printers.length;i++) {
            System.out.printf("%-10s %-15s %-15s %-10s\n", printers[i].getPrinterName(), printers[i].getTotalJobsProcessed(), printers[i].getTotalInUseTime(), printers[i].getTotalIdleTime());
        }
        System.out.println("\nJob Statistics: ");
        System.out.printf("%-5s %-12s %-12s \n", "Job No. | ", "Wait Time | ", "Length of Job");
        while (!finishedQueue.isEmpty()){
            Job j = finishedQueue.remove();
            System.out.printf("%-10s %-15s %-15s \n", j.getID(), j.getWaitTime(), j.getTimeForTheJob());
        }
    }
}
