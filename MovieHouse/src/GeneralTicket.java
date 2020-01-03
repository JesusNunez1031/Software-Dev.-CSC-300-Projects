import java.text.DecimalFormat;

public class GeneralTicket extends Ticket implements TotalCostForTicket {

	private double totalPrice;

	public GeneralTicket(int theaterNumber, int seatNumber, boolean reserved) {
		super(theaterNumber, seatNumber, reserved);

		this.totalPrice = calculateTotalPrice();
	}

	@Override
	public double calculateTotalPrice() {
		double tax = basePrice * taxRate;
		return basePrice + tax;
	}

	public String toString() {
		DecimalFormat formatNum = new DecimalFormat("00.00");
		return super.toString() + "GENERAL ADMISSION the price is $" + formatNum.format(this.totalPrice);
	}

}
