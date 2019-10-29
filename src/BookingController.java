import java.util.ArrayList;
import java.util.Stack;

public class BookingController {
	
	private Showtime showtime;
	private Movie movie;
	private Cinema cinema;
	private double totalPrice;
	private int[][] seatLayout = new int[8][14];
	private ArrayList<Integer> seat;
	private Stack<ArrayList<Integer>> seatSelected;
	
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
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
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
	public ArrayList<Movie> getMoviesList() {
		return cinema.getMovieList();
	}
	public ArrayList<Showtime> getShowtimesList() {
		return movie.getShowtimeList();
	}
	public void printSeatLayout() {
		System.out.println("                Screen\n");
		for (int i=0;i<8;i++) {
			for (int j=0;j<14;j++) {
				if (seatLayout[i][j] == 2) {
					System.out.print("   ");
				}
				else {
					System.out.print("[");
					System.out.print(seatLayout[i][j]);
					System.out.print("]");
				}
			}
			System.out.print(i+1 + "\n");
		}
		System.out.println(" 1  2  3  4  5  6  7  8  9  10 11 12 13 14\n");
		System.out.println("\n                Entrance\n");
		System.out.println("Legend: \n"
				+ "0 - Available Slots\n"
				+ "1 - Occupied Slots\n");
	}
	
	

}
