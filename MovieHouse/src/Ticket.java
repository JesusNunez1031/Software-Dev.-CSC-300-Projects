
public abstract class Ticket {
	public static double basePrice;
	private int theaterNumber;
	private int seatNumber;
	private boolean sold;
	public boolean reserved;

	public Ticket() {
	}

	public Ticket(int theaterNumber, int seatNumber, boolean reserved) {
	}

	public int getTheaterNumber() {
		return theaterNumber;
	}

	public void setTheaterNumber(int theaterNumber) {
		this.theaterNumber = theaterNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public boolean equals(Ticket a, Ticket b) {
		return a.getTheaterNumber() == b.getTheaterNumber() && a.getSeatNumber() == b.getSeatNumber();
	}

	public String toString() {
		return "For Theater " + this.theaterNumber + " Seat Number " + this.seatNumber + " which is ";
	}

}
