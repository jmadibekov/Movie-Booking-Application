package moblima.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import moblima.model.*;

/**
 * Represent a booking controller that assist moviegoer in their booking
 * Gets parameters from views that are visited by moviegoer
 */
public class BookingController {

	/**
	 * Showtime chosen by moviegoer
	 */
	private static Showtime chosenShowtime;
	/**
	 * Movie title chosen by moviegoer
	 */
	private static String chosenTitle;
	/**
	 * Movie chosen by moviegoer
	 */
	private static Movie chosenMovie;
	/**
	 * Cineplex chosen by moviegoer
	 */
	private static Cineplex chosenCineplex;
	/**
	 * Current customer that is making the booking
	 */
	private static Customer curCustomer;
	/**
	 * Total price of the booking
	 */
	private static double totalPrice = 0;
	/**
	 * Seat layout of the chosen showtime
	 */
	private static String[][] seatLayout = new String[8][9];
	/**
	 * Seat chosen by customer represented in the format {TicketType, Row, Column}
	 */
	private static ArrayList < Integer > seat = new ArrayList <Integer> ();
	/**
	 * An array of seats chosen by customer
	 */
	private static ArrayList<ArrayList<Integer>>  seatSelected = new ArrayList<ArrayList<Integer>> ();
	private static int noOfSeats;

	/**
	 * Gets chosen movie.
	 *
	 * @return Movie chosen by moviegoer
	 */
	public static Movie getChosenMovie() {
		return chosenMovie;
	}

	/**
	 * Sets chosen movie.
	 * Sets the chosen title.
	 *
	 * @param chosenMovie Movie chosen by moviegoer
	 */
	public static void setChosenMovie(Movie chosenMovie) {
		BookingController.chosenMovie = chosenMovie;
		if (chosenMovie != null)
			BookingController.chosenTitle = chosenMovie.getTitle();
	}

	/**
	 * Gets chosen cineplex.
	 *
	 * @return the chosen Cineplex
	 */
	public static Cineplex getChosenCineplex() {
		return chosenCineplex;
	}

	/**
	 * Sets chosen cineplex.
	 *
	 * @param chosenCineplex Cineplex chosen by moviegoer
	 */
	public static void setChosenCineplex(Cineplex chosenCineplex) {
		BookingController.chosenCineplex = chosenCineplex;
	}

	/**
	 * Gets chosen showtime.
	 *
	 * @return the chosen showtime
	 */
	public static Showtime getChosenShowtime() {
		return chosenShowtime;
	}

	/**
	 * Sets chosen showtime.
	 *
	 * @param chosenShowtime Showtime chosen by the moviegoer
	 */
	public static void setChosenShowtime(Showtime chosenShowtime) {
		BookingController.chosenShowtime = chosenShowtime;
	}

	/**
	 * Gets total price of booking
	 *
	 * @return the total price of booking
	 */
	public static double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Sets total price of booking
	 *
	 * @param totalPrice the total price of booking
	 */
	public static void setTotalPrice(double totalPrice) {
		BookingController.totalPrice = totalPrice;
	}

	/**
	 * Gets no of seats booked by customer
	 *
	 * @return the no of seats booked by customer
	 */
	public static int getNoOfSeats() {
		return noOfSeats;
	}

	/**
	 * Sets no of seats booked by customer
	 *
	 * @param noOfSeats the no of seats booked by customer
	 */
	public static void setNoOfSeats(int noOfSeats) {
		BookingController.noOfSeats = noOfSeats;
	}

	/**
	 * Get 2D array seat layout of chosen showtime
	 *
	 * @return 2D array seat layout of chosen showtime
	 */
	public static String[][] getSeatLayout() {
		return seatLayout;
	}

	/**
	 * Sets 2D array seat layout of chosen showtime
	 *
	 * @param seatLayout 2D array seat layout of chosen showtime
	 */
	public static void setSeatLayout(String[][] seatLayout) {
		for(int i=0; i<seatLayout.length; i++)
			for(int j=0; j<seatLayout[i].length; j++)
				BookingController.seatLayout[i][j] = seatLayout[i][j];
	}

	/**
	 * Print seat layout which includes entrance, screen, row number and column number.
	 * Allows user to have a picture of the cinema where the showtime will be displayed.
	 * Allows easy choosing of seats by row number and column number.
	 */
	public static void printSeatLayout() {
		System.out.println("-------------------------------------\n"
				+ "                Screen\n");
		for (int i=0;i<8;i++) {
			System.out.print("      ");
			for (int j=0;j<9;j++) {
				System.out.print("[");
				System.out.print(seatLayout[i][j]);
				System.out.print("]");
			}
			System.out.print("  "+ (i+1));
			if (i == 2)
				System.out.printf("  R");
			else if (i == 3)
				System.out.printf("  O");
			else if (i == 4)
				System.out.printf("  W");
			System.out.println();
		}
		System.out.println("       1  2  3  4  5  6  7  8  9\n"
				+ "             C O L U M N\n"
				+ "               Entrance\n"
				+ "Legend: \n"
				+ "0 - Available Slots\n"
				+ "1 - Occupied Slots\n"
				+ "-------------------------------------");
	}

	/**
	 * Gets all movies of all cineplexes
	 *
	 * @return Array of movie titles of all cineplexes
	 */
	public static ArrayList < String > getAllMovies() {
		ArrayList < Cineplex > curCineplexes = MainModel.getCineplexList();
		Map < String, Movie > tmp = new HashMap < String, Movie > ();
		for (Cineplex i : curCineplexes) {
			ArrayList < Movie > curMovies = i.getMovieList();
			for (Movie j : curMovies) {
				tmp.put(j.getMovieId(), j);
			}
		}
		ArrayList < String > res = new ArrayList < String > ();
		for (Movie i : tmp.values()) {
			res.add(i.getTitle());
		}
		Collections.sort(res);
		return res;
	}

	/**
	 * Gets Title of chosen Movie
	 *
	 * @return Title of chosen Movie
	 */
	public static String getChosenTitle() {
		return chosenTitle;
	}

	/**
	 * Sets Title of chosen Movie
	 *
	 * @param chosenTitle Title of chosen Movie
	 */
	public static void setChosenTitle(String chosenTitle) {
		BookingController.chosenTitle = chosenTitle;
	}

	/**
	 * Gets seat selected by customer
	 *
	 * @return 2D array of seat selected by customer
	 */
	public static ArrayList<ArrayList<Integer>> getSeatSelected() {
		return seatSelected;
	}

	/**
	 * Append a new seat chosen by customer to seat selected
	 *
	 * @param seat New seat chosen by customer
	 */
	public static void addSeatSelected(ArrayList<Integer> seat) {
		ArrayList<Integer> newSeat = new ArrayList<Integer>();
		newSeat.add(seat.get(0));
		newSeat.add(seat.get(1));
		newSeat.add(seat.get(2));
		seatSelected.add(newSeat);
	}

	/**
	 * Remove a seat from seat selected array
	 *
	 * @return the seat removed from seat selected
	 */
	public static Integer[] removeSeatSelected() {
		Integer[] oldSeat = new Integer[2];
		oldSeat[0] = seatSelected.get(seatSelected.size() - 1).get(1) - 1;
		oldSeat[1] = seatSelected.get(seatSelected.size() - 1).get(2) - 1;
		seatSelected.remove(seatSelected.size() - 1);
		return oldSeat;
	}

	/**
	 * Clear seat selected.
	 */
	public static void clearSeatSelected() {
		seatSelected.clear();
	}

	/**
	 * Gets seat chosen by customer in format {TicketType, Row, Column}
	 *
	 * @return the seat chosen by customer in format {TicketType, Row, Column}
	 */
	public static ArrayList<Integer> getSeat() {
		return seat;
	}

	/**
	 * Sets seat chosen by customer in format {TicketType, Row, Column}
	 *
	 * @param newSeat the seat chosen by customer in format {TicketType, Row, Column}
	 */
	public static void setSeat(ArrayList<Integer> newSeat) {
		seat = newSeat;
	}

	/**
	 * Add value of ticketType/Row/Column to seat
	 *
	 * @param attributeOfSeat the new value of ticketType/Row/Column
	 */
	public static void addSeat(int attributeOfSeat) {
		seat.add(attributeOfSeat);
	}

	/**
	 * Clear seat.
	 */
	public static void clearSeat() {
		seat.clear();
	}

	/**
	 * Gets movies list of chosen cineplex
	 *
	 * @return the movies list of chosen cineplex
	 */
	public static ArrayList < Movie > getMovies() {
		return chosenCineplex.getMovieList();
	}

	/**
	 * Gets showtimes list of chosen Movie
	 *
	 * @return the showtimes list of chosen Movie
	 */
	public static ArrayList < Showtime > getShowtimesList() {
		return chosenMovie.getShowtimeList();
	}

	/**
	 * Gets cinema class using cinema id
	 *
	 * @param cinemaId the cinema id
	 * @return the cinema class
	 */
	public static String getCinemaClass(String cinemaId) {
		for (int i = 0; i< chosenCineplex.getCinemaList().size(); i++) {
			if (cinemaId.contentEquals(chosenCineplex.getCinemaList().get(i).getCinemaId())) {
				return chosenCineplex.getCinemaList().get(i).getCinemaClass();
			}
		}
		return "Error";
	}

	/**
	 * Calculate price of booking for a seat using seat attributes (TicketType) and other factors
	 * Price is based on base ticket price of chosen Cineplex.
	 *
	 * @return price of booking for a seat
	 */
	public static double calcPrice() {
		double basePrice = chosenCineplex.getBaseTicketCost();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDateFormat(chosenShowtime.getDate()));
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		if(day == 1 || day == 7)
		{
			basePrice += 3;
		}
		else {
			for (int i=0;i<MainModel.getHolidayList().size();i++) {
				if (MainModel.getHolidayList().get(i).getHolidayDate().contentEquals(chosenShowtime.getDate())) {
					basePrice += 3;
					break;
				}
			}
		}
		if (chosenShowtime.getType().contentEquals("IMAX")) {
			basePrice += 5;
		}
		else if (chosenShowtime.getType().contentEquals("3D")) {
			basePrice += 3;
		}
		if (getCinemaClass(chosenShowtime.getCinemaId()).contentEquals("Platinum")) {
			basePrice += 5;
		}
		else if (getCinemaClass(chosenShowtime.getCinemaId()).contentEquals("Gold")) {
			basePrice += 3;
		}
		if (seat.get(0) == 1) {
			basePrice += 2;
		}
		else if (seat.get(0) == 2) {
			basePrice += 1;
		}
		if (chosenShowtime.getTime() >= 1800) {
			basePrice += 2;
		}
		totalPrice += basePrice;
		return basePrice;
	}

	/**
	 * Create new Booking after a customer have completed their booking
	 *
	 * @param email the email of customer
	 * @return Booking of customer
	 */
	public static Booking createBooking(String email) {
		Booking booking = new Booking(email, chosenShowtime.getDate(), seatSelected, getCinemaClass(chosenShowtime.getCinemaId()),
				totalPrice, chosenCineplex.getCineplexName(), chosenMovie.getTitle(), chosenShowtime.getCinemaId());
		return booking;
	}

	/**
	 * Gets date format (dd/MM/yyyy)
	 *
	 * @param dateString the date in string
	 * @return the date format in dd/MM/yyyy
	 */
	public static Date getDateFormat(String dateString) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateString);
			return date;
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Gets showtime list of chosen Cineplex sorted by date
	 *
	 * @return the showtime list of chosen Cineplex sorted by date
	 */
	public static ArrayList<Showtime> getShowtimeSortedByDate() {
		chosenMovie.getShowtimeList().sort(Comparator.comparing(Showtime::getDate).
				thenComparingInt(Showtime::getTime).thenComparing(Showtime::getCinemaId));
		return chosenMovie.getShowtimeList();
	}

	/**
	 * Gets no of seats left in a showtime
	 *
	 * @param showtime the showtime of a movie
	 * @return the no of seats left in a showtime
	 */
	public static int getNoOfSeatsLeft(Showtime showtime) {
		int noOfSeatsLeft = 0;
		for (int i=0;i<8;i++) {
			for (int j=0;j<9;j++) {
				if (showtime.getSeatLayout()[i][j].contentEquals("0")) {
					noOfSeatsLeft++;
				}
			}
		}
		return noOfSeatsLeft;
	}

	/**
	 * Gets current customer that is making a booking
	 *
	 * @return the current customer that is making a booking
	 */
	public static Customer getCurCustomer() {
		return curCustomer;
	}

	/**
	 * Sets current customer that is making a booking.
	 *
	 * @param curCustomer the current customer that is making a booking
	 */
	public static void setCurCustomer(Customer curCustomer) {
		BookingController.curCustomer = curCustomer;
	}

	/**
	 * Print seats selected by customer
	 *
	 * @param chosenSeats the seats selected by customer
	 */
	public static void printSeatSelected(ArrayList<ArrayList<Integer>> chosenSeats) {
		for (int i = 0; i < chosenSeats.size(); i++) {
			System.out.print("(" + (i + 1) + ") ");
			for (int j = 0; j < 3; j++) {
				switch (j) {
					case 0:
						switch (chosenSeats.get(i).get(j)) {
							case 1:
								System.out.printf("Ticket Type: Adult, ");
								break;
							case 2:
								System.out.printf("Ticket Type: Student, ");
								break;
							case 3:
								System.out.printf("Ticket Type: Senior Citizen, ");
								break;
						}
						break;
					case 1:
						System.out.printf("Row: %s, ", chosenSeats.get(i).get(j));
						break;
					case 2:
						System.out.printf("Column: %s\n", chosenSeats.get(i).get(j));
						break;
				}
			}
		}
	}
}
