import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovieHouse {
	public List<Ticket> theater0 = new ArrayList<>();
	public List<Ticket> theater1 = new ArrayList<>();
	public List<Ticket> theater2 = new ArrayList<>();

	private PrintWriter outputWriter;
	private String movieHouseName;
	private boolean theaterSeats[][] = new boolean[3][];

	public MovieHouse(String theaterName, int seats0, int seats1, int seats2) {
		this.movieHouseName = theaterName;
		this.theaterSeats[0] = new boolean[seats0];
		this.theaterSeats[1] = new boolean[seats1];
		this.theaterSeats[2] = new boolean[seats2];
	}

	public void setOutputWriter(PrintWriter output) {
		this.outputWriter = output;
	}

	public void startSales(int theaterNumber) {
		Random randNum = new Random(5*(theaterNumber) + 10);
		int seatsToBeSold = randNum.nextInt(theaterSeats[theaterNumber].length / 2 - 1);
		seatsToBeSold += (theaterSeats[theaterNumber].length / 2);
		for (int i = 0; i < seatsToBeSold; i++) {
			int randSeat = randNum.nextInt(seatsToBeSold);
			if (i % 3 == 0) {
				ReservedTicket rTicket = new ReservedTicket(theaterNumber, randSeat, true);
				rTicket.setTheaterNumber(theaterNumber);
				rTicket.setSeatNumber(randSeat);
				int value = sellTicket(rTicket);
				if (value != 0) {
					i--;
				}
			} else {
				GeneralTicket gTicket = new GeneralTicket(theaterNumber, randSeat, true);
				gTicket.setTheaterNumber(theaterNumber);
				gTicket.setSeatNumber(randSeat);
				int value2 = sellTicket(gTicket);
				if (value2 != 0) {
					i--;
				}
			}
		}
	}

	public int sellTicket(Ticket ticket) {
		if (ticket.getTheaterNumber() < 0 || ticket.getTheaterNumber() > 2) {
			return 1;
		} else if (ticket.getSeatNumber() > theaterSeats[ticket.getTheaterNumber()].length - 1
				|| ticket.getSeatNumber() < 0) {
			return 2;
		} else if (theaterSeats[ticket.getTheaterNumber()][ticket.getSeatNumber()]) {
			return 3;
		} else {
			theaterSeats[ticket.getTheaterNumber()][ticket.getSeatNumber()] = true;
			ticket.setSold(true);
			ticket.setReserved(true);
			if (ticket.getTheaterNumber() == 0) {
				this.theater0.add(ticket);
			} else if (ticket.getTheaterNumber() == 1) {
				this.theater1.add(ticket);
			} else {
				this.theater2.add(ticket);
			}
		}
		return 0;
	}

	public void printSeatMaps() {
		outputWriter.println("Welcome to " + this.movieHouseName);
		for (int j = 0; j < 3; j++) {
			outputWriter.println("\nTheater " + j + " Seat Map");
			for (int i = 0; i < theaterSeats[j].length; i++) {
				if (i % 10 == 0) {
					outputWriter.print("\n");
				}
				if (theaterSeats[j][i]) {
					outputWriter.print("S ");
				} else {
					outputWriter.print("V ");
				}
			}
			outputWriter.println();
		}
		outputWriter.println();
	}

	public void printSalesRecords() {
		outputWriter.println("Ticket Record For Theater0\n");
		for (int i = 0; i < theater0.size(); i++) {
			outputWriter.println(theater0.get(i).toString());
		}

		outputWriter.println("\nTicket Record For Theater1\n");
		for (int i = 0; i < theater1.size(); i++) {
			outputWriter.println(theater1.get(i).toString());
		}

		outputWriter.println("\nTicket Record For Theater2\n");
		for (int i = 0; i < theater2.size(); i++) {
			outputWriter.println(theater2.get(i).toString());
		}
	}
}
