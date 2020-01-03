import java.text.DecimalFormat;

public class ReservedTicket extends Ticket implements TotalCostForTicket {

	private double totalPrice;
	public static double premium = 3.50;

	public ReservedTicket(int theaterNumber, int seatNumber, boolean reserved) {
		super(theaterNumber, seatNumber, reserved);

		this.totalPrice = calculateTotalPrice();
	}

	@Override
	public double calculateTotalPrice() {
		double tax = (basePrice + premium) * taxRate;
		return (basePrice + premium) + tax;
	}

	public String toString() {
		DecimalFormat formatNum = new DecimalFormat("00.00");
		return super.toString() + "RESERVED the price is $" + formatNum.format(this.totalPrice);
	}
}
