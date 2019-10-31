import java.util.ArrayList;
import java.util.Stack;

public class BookingController {
	
	private Showtime showtime;
	private Movie movie;
	private Cineplex cineplex;
	private double totalPrice;
	private int[][] seatLayout = new int[8][9];
	private ArrayList<Integer> seat;
	private Stack<ArrayList<Integer>> seatSelected;
	private int noOfSeats;
	
	public BookingController() {
		totalPrice = 0;
		seatSelected = new Stack<ArrayList<Integer>>();
		seat = new ArrayList<Integer>();
	}
	
	public Showtime getShowtime() {
		return showtime;
	}
	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Cineplex getCineplex() {
		return cineplex;
	}
	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int[][] getSeatLayout() {
		return seatLayout;
	}
	public void setSeatLayout(int[][] seatLayout) {
		for(int i=0; i<seatLayout.length; i++)
			  for(int j=0; j<seatLayout[i].length; j++)
				  this.seatLayout[i][j]=seatLayout[i][j];
	}
	public void addSeatSelected(ArrayList<Integer> seat) {
		seatSelected.push(seat);
	}
	public void removeSeatSelected() {
		seatSelected.pop();
	}
	public void clearSeatSelected() {
		seatSelected.clear();
	}
	public ArrayList<Integer> getSeat() {
		return seat;
	}
	public void setSeat(ArrayList<Integer> seat) {
		this.seat = seat;
	}
	public void addSeat(int seat) {
		this.seat.add(seat);
	}
	public void removeSeat() {
		seat.remove(seat.size() - 1);
	}
	public void clearSeat() {
		seat.clear();
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public ArrayList<Movie> getMoviesList() {
		return cineplex.getMovieList();
	}
	public ArrayList<Showtime> getShowtimesList() {
		return movie.getShowtimeList();
	}
	public void printSeatLayout() {
		System.out.println("                Screen\n");
		for (int i=0;i<8;i++) {
			System.out.print("      ");
			for (int j=0;j<9;j++) {
				System.out.print("[");
				System.out.print(seatLayout[i][j]);
				System.out.print("]");
			}
			System.out.print("  "+ (i+1) + "\n");
		}
		System.out.println("       1  2  3  4  5  6  7  8  9\n");
		System.out.println("                Entrance\n");
		System.out.println("Legend: \n"
				+ "0 - Available Slots\n"
				+ "1 - Occupied Slots\n");
	}

	public String getCinemaClass(String cinemaId) {
		for (int i = 0; i< cineplex.getCinemaList().size(); i++) {
			if (cinemaId.contentEquals(cineplex.getCinemaList().get(i).getCinemaId())) {
				return cineplex.getCinemaList().get(i).getCinemaClass();
			}
		}
		return "Error";
	}

	public double calcPrice() {
		double basePrice = cineplex.getBaseTicketCost();
		if (showtime.getType().contentEquals("IMAX")) {
			basePrice += 5;
		}
		else if (showtime.getType().contentEquals("3D")) {
			basePrice += 3;
		}
		if (getCinemaClass(showtime.getCinemaId()).contentEquals("Platinum")) {
			basePrice += 5;
		}
		else if (getCinemaClass(showtime.getCinemaId()).contentEquals("Gold")) {
			basePrice += 3;
		}
		if (seat.get(0) == 1) {
			basePrice += 2;
		}
		else if (seat.get(0) == 2) {
			basePrice += 1;
		}
		if (showtime.getTime() >= 1800) {
			basePrice += 2;
		}
		totalPrice += basePrice;
		return basePrice;
	}

	public Booking createBooking(String email) {
		Booking booking = new Booking(email, showtime.getDate(), cineplex.getCineplexId(),
				noOfSeats, getCinemaClass(showtime.getCinemaId()), totalPrice);
		return booking;
	}

}
