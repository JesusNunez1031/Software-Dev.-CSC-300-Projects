
public class RegularVisitor extends Visitor {
	public static int regularCounter = 0;
	private String regularID;

	public RegularVisitor(int timeOntoQueue) {
		super(timeOntoQueue);
		setRegularID();
	}

	public void setRegularID() {
		regularCounter++;
		this.regularID = "Regular" + regularCounter;
	}

	public String getRegularID() {
		return this.regularID;
	}
}
