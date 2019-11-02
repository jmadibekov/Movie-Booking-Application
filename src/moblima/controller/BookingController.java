package moblima.controller;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import moblima.model.*;

public class BookingController {
	private static Showtime chosenShowtime;
	private static Movie chosenMovie;
	private static Cineplex chosenCineplex;

	private static double totalPrice = 0;
	private static int[][] seatLayout = new int[8][9];
	private static ArrayList < Integer > seat = new ArrayList <Integer> ();
	private static Stack<ArrayList<Integer>> seatSelected = new Stack<ArrayList<Integer>>();
	private static int noOfSeats;

	public static Movie getChosenMovie() {
		return chosenMovie;
	}

	public static void setChosenMovie(Movie chosenMovie) {
		BookingController.chosenMovie = chosenMovie;
	}

	public static Cineplex getChosenCineplex() {
		return chosenCineplex;
	}

	public static void setChosenCineplex(Cineplex chosenCineplex) {
		BookingController.chosenCineplex = chosenCineplex;
	}

	public static Showtime getChosenShowtime() {
		return chosenShowtime;
	}

	public static void setChosenShowtime(Showtime chosenShowtime) {
		BookingController.chosenShowtime = chosenShowtime;
	}

	public static double getTotalPrice() {
		return totalPrice;
	}

	public static void setTotalPrice(double totalPrice) {
		BookingController.totalPrice = totalPrice;
	}

	public static int getNoOfSeats() {
		return noOfSeats;
	}

	public static void setNoOfSeats(int noOfSeats) {
		BookingController.noOfSeats = noOfSeats;
	}

	public static int[][] getSeatLayout() {
		return seatLayout;
	}

	public static void setSeatLayout(int[][] seatLayout) {
		for(int i=0; i<seatLayout.length; i++)
			for(int j=0; j<seatLayout[i].length; j++)
				BookingController.seatLayout[i][j]=seatLayout[i][j];
	}

	public static ArrayList < Movie > getAllMovies() {
		ArrayList < Cineplex > curCineplexes = MainModel.getCineplexList();

		Map < Integer, Movie > tmp = new HashMap < Integer, Movie > ();

		for (Cineplex i : curCineplexes) {
			ArrayList < Movie > curMovies = i.getMovieList();
			for (Movie j : curMovies) {
				tmp.put(j.getMovieId(), j);
			}
		}

		for (Movie i : tmp.values()) {
			i.outputMovieInfo();
		}

		// ********* NEEDS TO BE UPDATED USING MOVIE MODEL *********
		ArrayList<Movie> allMovies = new ArrayList<Movie>();
		String[] directorC = new String[]{"Moham", "Faz"};
		String[] castC = new String[]{"Faz", "Moham"};
		Movie movieC = new Movie(0, 0, "NowShowing", "Mulan", "fgh", directorC, castC, 4.0, "M18", 1, 3, 4);
		allMovies.add(movieC);
		return allMovies;
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
	public void setSeat(ArrayList<Integer> newSeat) {
		seat = newSeat;
	}

	public static void addSeat(int newSeat) {
			BookingController.seat.add(newSeat);
	}

	public void removeSeat() {
		seat.remove(seat.size() - 1);
	}
	public static void clearSeat() {
		seat.clear();
	}

	public static ArrayList < Movie > getMovies() {
		return chosenCineplex.getMovieList();
	}

	public static ArrayList < Showtime > getShowtimesList() {
		return chosenMovie.getShowtimeList();
	}

	public static void printSeatLayout() {
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

	public static String getCinemaClass(String cinemaId) {
		for (int i = 0; i< chosenCineplex.getCinemaList().size(); i++) {
			if (cinemaId.contentEquals(chosenCineplex.getCinemaList().get(i).getCinemaId())) {
				return chosenCineplex.getCinemaList().get(i).getCinemaClass();
			}
		}
		return "Error";
	}

	public static double calcPrice() {
		double basePrice = chosenCineplex.getBaseTicketCost();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDateFormat(chosenShowtime.getDate()));
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		if(day == 1 || day == 7)
		{
			basePrice += 3;
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

	public static Booking createBooking(String email) {
		Booking booking = new Booking(email, chosenShowtime.getDate(), chosenCineplex.getCineplexId(),
				noOfSeats, getCinemaClass(chosenShowtime.getCinemaId()), totalPrice);
		return booking;
	}

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

}
