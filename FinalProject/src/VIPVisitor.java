
public class VIPVisitor extends Visitor {
	public static int vipCounter = 0;
	private String vipID;

	public VIPVisitor(int timeOntoQueue) {
		super(timeOntoQueue);
		setVIPID();
	}

	public void setVIPID() {
		vipCounter++;
		this.vipID = "VIP" + vipCounter;
	}

	public String getVIPID() {
		return this.vipID;
	}

}
