package moblima.model;

import moblima.controller.*;

import java.io.IOException;
import java.util.ArrayList;

public class MainModel {
	private static ArrayList < Cineplex > cineplexList;
	private static ArrayList < Customer > customerList;
	private static ArrayList < Holiday > holidayList;
	
	public static void init() {
		cineplexList = new ArrayList < Cineplex > ();
		cineplexList.add(new Cineplex( "Jurong Point Cinema", "001", 10.0));
		cineplexList.add(new Cineplex("Paya Lebar Cinema", "002", 8.0));
		cineplexList.add(new Cineplex("Vivo City Cinema", "003", 12.0));

		try {
			customerList = DBController.readCustomer("src/moblima/data/CustomerDB.txt");
			holidayList = DBController.readHoliday("src/moblima/data/HolidayDB.txt");
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}

	public static void endProgramWriteBack() {
		try {
			DBController.saveCustomer("CustomerDB.txt", customerList, false);
			DBController.saveHoliday("HolidayDB.txt", holidayList, false);
			for (int i = 0; i < cineplexList.size(); i++) {
				Cineplex cineplex = cineplexList.get(i);
				ArrayList<Movie> movieList = cineplex.getMovieList();
				ArrayList<Cinema> cinemaList = cineplex.getCinemaList();
				ArrayList<Staff> staffList = cineplex.getStaffList();

				if (i == 0) {
					DBController.saveMovies("MovieDB.txt", movieList, false);
					DBController.saveCinema("CinemaDB.txt", cinemaList, cineplex.getCineplexId(), false);
					DBController.saveStaff("StaffDB.txt", staffList, cineplex.getCineplexId(), false);
				}
				else {
					DBController.saveMovies("MovieDB.txt", movieList, true);
					DBController.saveCinema("CinemaDB.txt", cinemaList, cineplex.getCineplexId(), true);
					DBController.saveStaff("StaffDB.txt", staffList, cineplex.getCineplexId(), true);
				}
				for (int j = 0; j < movieList.size(); i++) {
					Movie movie = movieList.get(j);
					ArrayList<Showtime> showtimeList = movie.getShowtimeList();
					ArrayList<Review> reviewList = movie.getReviewList();
					if (i == 0 && j == 0) {
						DBController.saveShowtime("ShowtimeDB.txt", showtimeList, movie.getCineplexId(), movie.getMovieId(), false);
						DBController.saveReview("ReviewDB.txt", reviewList, movie.getCineplexId(), movie.getMovieId(), false);
					}
					else {
						DBController.saveShowtime("ShowtimeDB.txt", showtimeList, movie.getCineplexId(), movie.getMovieId(), true);
						DBController.saveReview("ReviewDB.txt", reviewList, movie.getCineplexId(), movie.getMovieId(), true);
					}
				}
			}
			for (int j = 0; j < customerList.size(); j++) {
				Customer customer = customerList.get(j);
				ArrayList<Booking> bookingList = customer.getBookList();
				if (j == 0) {
					DBController.saveBookingHistory("BookingHistoryDB.txt", bookingList, customer.getEmail(), false);
				}
				else {
					DBController.saveBookingHistory("BookingHistoryDB.txt", bookingList, customer.getEmail(), true);
				}
			}
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}

	public static void output() {
		for (Cineplex i : cineplexList) {
			i.output();
			System.out.println("======================");
			System.out.println("======================");
		}
	}

	public static ArrayList < Cineplex > getCineplexList() {
		return cineplexList;
	}

	public static void setCineplexList(ArrayList < Cineplex > cineplexList) {
		MainModel.cineplexList = cineplexList;
	}
	
	public void addCinema(Cineplex cineplex) {
		cineplexList.add(cineplex);
	}

	public static ArrayList < Customer > getCustomerList() {
		return customerList;
	}

	public static void setCustomerList(ArrayList < Customer > customerList) {
		MainModel.customerList = customerList;
	}

	public static void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	public static ArrayList < Holiday > getHolidayList() {
		return holidayList;
	}

	public static void setHolidayList(ArrayList < Holiday > staffList) {
		MainModel.holidayList = holidayList;
	}

	public static void addHoliday(Holiday holiday) {
		holidayList.add(holiday);
	}
}
