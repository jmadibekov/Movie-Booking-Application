package moblima.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import moblima.model.*;

public class BookingController {

	private static Showtime chosenShowtime;
	private static String chosenTitle;
	private static Movie chosenMovie;
	private static Cineplex chosenCineplex;
	private static Customer curCustomer;
	private static double totalPrice = 0;
	private static String[][] seatLayout = new String[8][9];
	private static ArrayList < Integer > seat = new ArrayList <Integer> ();
	private static ArrayList<ArrayList<Integer>>  seatSelected = new ArrayList<ArrayList<Integer>> ();
	private static int noOfSeats;

	public static Movie getChosenMovie() {
		return chosenMovie;
	}
	public static void setChosenMovie(Movie chosenMovie) {
		BookingController.chosenMovie = chosenMovie;
		BookingController.chosenTitle = chosenMovie.getTitle();
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

	public static String[][] getSeatLayout() {
		return seatLayout;
	}
	public static void setSeatLayout(String[][] seatLayout) {
		for(int i=0; i<seatLayout.length; i++)
			for(int j=0; j<seatLayout[i].length; j++)
				BookingController.seatLayout[i][j] = seatLayout[i][j];
	}
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

	public static String getChosenTitle() {
		return chosenTitle;
	}
	public static void setChosenTitle(String chosenTitle) {
		BookingController.chosenTitle = chosenTitle;
	}

	public static ArrayList<ArrayList<Integer>> getSeatSelected() {
		return seatSelected;
	}
	public static void addSeatSelected(ArrayList<Integer> seat) {
		ArrayList<Integer> newSeat = new ArrayList<Integer>();
		newSeat.add(seat.get(0));
		newSeat.add(seat.get(1));
		newSeat.add(seat.get(2));
		seatSelected.add(newSeat);
	}
	public static Integer[] removeSeatSelected() {
		Integer[] oldSeat = new Integer[2];
		oldSeat[0] = seatSelected.get(seatSelected.size() - 1).get(1) - 1;
		oldSeat[1] = seatSelected.get(seatSelected.size() - 1).get(2) - 1;
		seatSelected.remove(seatSelected.size() - 1);
		return oldSeat;
	}
	public static void clearSeatSelected() {
		seatSelected.clear();
	}

	public static ArrayList<Integer> getSeat() {
		return seat;
	}
	public static void setSeat(ArrayList<Integer> newSeat) {
		seat = newSeat;
	}
	public static void addSeat(int newSeat) {
			seat.add(newSeat);
	}
	public static void removeSeat() {
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

	public static Booking createBooking(String email) {
		Booking booking = new Booking(email, chosenShowtime.getDate(), seatSelected, getCinemaClass(chosenShowtime.getCinemaId()),
				totalPrice, chosenCineplex.getCineplexId(), chosenMovie.getMovieId(), chosenShowtime.getCinemaId());
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

	public static ArrayList<Showtime> getShowtimeSortedByDate() {
		chosenMovie.getShowtimeList().sort(Comparator.comparing(Showtime::getDate).
				thenComparingInt(Showtime::getTime).thenComparing(Showtime::getCinemaId));
		return chosenMovie.getShowtimeList();
	}

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

	public static Customer getCurCustomer() {
		return curCustomer;
	}

	public static void setCurCustomer(Customer curCustomer) {
		BookingController.curCustomer = curCustomer;
	}

	public static void printSeatSelected(ArrayList<ArrayList<Integer>> chosenSeats) {
        for (int i = 0; i < chosenSeats.size(); i++) {
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
