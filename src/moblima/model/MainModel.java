package moblima.model;

import moblima.controller.*;

import java.io.IOException;
import java.util.ArrayList;

public class MainModel {
	private static ArrayList < Cineplex > cineplexList;
	private static ArrayList < Customer > customerList;
	private static ArrayList < Holiday > holidayList;
	
	public static void init() {
		try {
			cineplexList = DBController.readCineplex("src/moblima/data/CineplexDB.txt");
			customerList = DBController.readCustomer("src/moblima/data/CustomerDB.txt");
			holidayList = DBController.readHoliday("src/moblima/data/HolidayDB.txt");
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}

	public static void endProgramWriteBack() {
		try {
			DBController.saveCineplex("src/moblima/data/CineplexDB.txt", cineplexList, false);
			DBController.saveCustomer("src/moblima/data/CustomerDB.txt", customerList, false);
			DBController.saveHoliday("src/moblima/data/HolidayDB.txt", holidayList, false);
			for (int i = 0; i < cineplexList.size(); i++) {
				Cineplex cineplex = cineplexList.get(i);
				ArrayList<Movie> movieList = cineplex.getMovieList();
				ArrayList<Cinema> cinemaList = cineplex.getCinemaList();
				ArrayList<Staff> staffList = cineplex.getStaffList();

				if (i == 0) {
					DBController.saveMovies("src/moblima/data/MovieDB.txt", movieList, false);
					DBController.saveCinema("src/moblima/data/CinemaDB.txt", cinemaList, cineplex.getCineplexId(), false);
					DBController.saveStaff("src/moblima/data/StaffDB.txt", staffList, cineplex.getCineplexId(), false);
				}
				else {
					DBController.saveMovies("src/moblima/data/MovieDB.txt", movieList, true);
					DBController.saveCinema("src/moblima/data/CinemaDB.txt", cinemaList, cineplex.getCineplexId(), true);
					DBController.saveStaff("src/moblima/data/StaffDB.txt", staffList, cineplex.getCineplexId(), true);
				}
				for (int j = 0; j < movieList.size(); j++) {
					Movie movie = movieList.get(j);
					ArrayList<Showtime> showtimeList = movie.getShowtimeList();
					ArrayList<Review> reviewList = movie.getReviewList();
					if (i == 0 && j == 0) {
						DBController.saveShowtime("src/moblima/data/ShowtimeDB.txt", showtimeList, movie.getCineplexId(), movie.getMovieId(), false);
						DBController.saveReview("src/moblima/data/ReviewDB.txt", reviewList, movie.getCineplexId(), movie.getMovieId(), false);
					}
					else {
						DBController.saveShowtime("src/moblima/data/ShowtimeDB.txt", showtimeList, movie.getCineplexId(), movie.getMovieId(), true);
						DBController.saveReview("src/moblima/data/ReviewDB.txt", reviewList, movie.getCineplexId(), movie.getMovieId(), true);
					}
				}
			}
			for (int k = 0; k < customerList.size(); k++) {
				Customer customer = customerList.get(k);
				ArrayList<Booking> bookingList = customer.getBookList();
				if (k == 0) {
					DBController.saveBookingHistory("src/moblima/data/BookingHistoryDB.txt", bookingList, customer.getEmail(), false);
				}
				else {
					DBController.saveBookingHistory("src/moblima/data/BookingHistoryDB.txt", bookingList, customer.getEmail(), true);
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
