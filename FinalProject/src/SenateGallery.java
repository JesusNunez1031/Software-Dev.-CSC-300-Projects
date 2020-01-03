
public class SenateGallery {
    private Deque<Visitor> waitingLine = new Deque<>();
    private DLList<Visitor> visitorInGallery = new DLList<>();
    private DLList<Visitor> visitorFinished = new DLList<>();
    private String date;
    private int time;

    public SenateGallery() {
        setDate("");
    }

    public SenateGallery(String date) {
        setDate(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void initializeSenateGallery() {
        for (int i = 0; i < 96; i++) {
            waitingLine.addBack(new RegularVisitor(0));
        }

        for (int i = 0; i < 4; i++) {
            waitingLine.addFront(new VIPVisitor(0));
        }

        for (int i = 0; i < 70; i++) {
            Visitor v = waitingLine.removeFront();
            v.setTimeOutOfQueue(0);
            visitorInGallery.add(v);
        }
    }

    public void runSenateGallerySimulation(int simMinutes) {
        int counter = 0;
        for (time = 1; time < simMinutes; time++) {
            for (int j = 0; j < 3; j++) {
                waitingLine.addBack(new RegularVisitor(time));
            }

            if (time % 5 == 0) {
                waitingLine.addFront(new VIPVisitor(time));
            }

            // Remove people from gallery
            for (int i = 1; i < visitorInGallery.size() - 1; i++) {
                Visitor v = visitorInGallery.get(i);
                v.decrementTimeRemainingInGallery();

                if (v.getTimeRemainingInGallery() <= 0) {
                    Visitor finishedVis = visitorInGallery.remove(i);
                    visitorFinished.add(finishedVis);
                }
            }

            // Move people into the gallery
            while (visitorInGallery.size() <= 55 && !waitingLine.isEmpty()) {
                Visitor vi = waitingLine.removeFront();
                vi.setTimeOutOfQueue(time);
                visitorInGallery.add(vi);
                counter++;

                if (visitorInGallery.size() == 90 || counter == 35) {
                    break;
                }
            }
            counter = 0;
        }
    }

    public void outputStatistics() {
        System.out.printf("The date of the visit to the Senate Gallery is %s \n", this.date);
        System.out.printf("Total who finished viewing is %d \n", visitorFinished.size());
        System.out.printf("Total who are still in gallery is %d \n", visitorInGallery.size());
        System.out.printf("Total who are still waiting is %d \n", waitingLine.size());
        double vipAvgWaitTime = 0;
        double regAvgWaitTime = 0;

        for (int i = 1; i < visitorFinished.size() - 1; i++) {
            Visitor vis = visitorFinished.get(i);
            if (vis instanceof VIPVisitor) {
                vipAvgWaitTime += vis.getTotalTimeInQueue();
            } else {
                regAvgWaitTime += vis.getTotalTimeInQueue();
            }
        }

        for (int i = 1; i < visitorInGallery.size() - 1; i++) {
            Visitor vis = visitorInGallery.get(i);
            if (vis instanceof VIPVisitor) {
                vipAvgWaitTime += vis.getTotalTimeInQueue();
            } else {
                regAvgWaitTime += vis.getTotalTimeInQueue();
            }
        }

        System.out.printf(
                "The average wait time for VIP Visitors who are in the gallery or finished viewing is %.2f seconds \n", vipAvgWaitTime / time);
        System.out.printf(
                "The average wait time for Regular Visitors who are in the gallery or finished viewing is %.2f seconds \n", regAvgWaitTime / time);

    }

}
