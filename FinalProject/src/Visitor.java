import java.util.Random;

public class Visitor {
	private int timeOntoQueue;
	private int timeOutOfQueue;
	private int totalTimeInQueue;
	private int timeInGallery;
	private int timeRemainingInGallery;
	public static Random randy = new Random(2);

	public Visitor(int timeGotOnline) {
		setTimeOntoQueue(timeGotOnline);
		setTimeInGallery();
	}

	public void setTimeOntoQueue(int timeOntoQueue) {
		this.timeOntoQueue = timeOntoQueue;
	}

	public void setTimeOutOfQueue(int timeOutOfQueue) {
		this.timeOutOfQueue = timeOutOfQueue;
		this.totalTimeInQueue = timeOutOfQueue - this.getTimeOntoQueue();
	}

	public void setTimeInGallery() {
		this.timeRemainingInGallery = randy.nextInt(20);
	}

	public void decrementTimeRemainingInGallery() {
		this.timeRemainingInGallery = this.getTimeRemainingInGallery() - 1;
		this.timeInGallery++;
	}

	public int getTotalTimeInQueue() {
		return this.totalTimeInQueue;
	}

	public int getTimeOntoQueue() {
		return this.timeOntoQueue;
	}

	public int getTimeOutOfQueue(){
		return this.timeOutOfQueue;
	}


	public void setTotalTimeInQueue(int time){
		this.totalTimeInQueue = time;
	}

	public int getTimeRemainingInGallery() {
		return this.timeRemainingInGallery;
	}

}
