package moblima.model;

import moblima.controller.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents the main model that contains all the data
 */
public class MainModel {
	private static ArrayList < Cineplex > cineplexList;
	private static ArrayList < Customer > customerList;
	private static ArrayList < Holiday > holidayList;

	/**
	 * Starts the initialization of all the data by reading from the database using DBController
	 */
	public static void init() {
		try {
			cineplexList = DBController.readCineplex("src/moblima/data/CineplexDB.txt");
			customerList = DBController.readCustomer("src/moblima/data/CustomerDB.txt");
			holidayList = DBController.readHoliday("src/moblima/data/HolidayDB.txt");
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}

	/**
	 * Write back all the data stored in the program to the database using DBController at the end of the program
	 */
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
				ArrayList<Booking> bookingList = customer.getBookingList();
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

	/**
	 * Return customer with that email
	 *
	 * @param email Email of a customer
	 * @return Customer
	 */
	public static Customer customerWithEmail(String email) {
		for (Customer i : customerList)
			if (i.getEmail().contentEquals(email))
				return i;
		return null;
	}

	/**
	 * Print output of cineplex information for debugging purposes
	 */
	public static void output() {
		for (Cineplex i : cineplexList) {
			i.output();
			System.out.println("======================");
			System.out.println("======================");
		}
	}


	/**
	 * Add cinema.
	 *
	 * @param cineplex the cineplex
	 */
	public void addCinema(Cineplex cineplex) {
		cineplexList.add(cineplex);
	}

	/**
	 * Add customer.
	 *
	 * @param customer the customer
	 */
	public static void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	/**
	 * Append new holiday object to the holiday list
	 *
	 * @param holiday Holiday object
	 */
	public static void addHoliday(Holiday holiday) {
		holidayList.add(holiday);
	}

	/**
	 * Sets new customerList.
	 *
	 * @param customerList New value of customerList.
	 */
	public static void setCustomerList(ArrayList<Customer> customerList) {
		customerList = customerList;
	}

	/**
	 * Gets customerList.
	 *
	 * @return Value of customerList.
	 */
	public static ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	/**
	 * Sets new cineplexList.
	 *
	 * @param cineplexList New value of cineplexList.
	 */
	public static void setCineplexList(ArrayList<Cineplex> cineplexList) {
		cineplexList = cineplexList;
	}

	/**
	 * Gets cineplexList.
	 *
	 * @return Value of cineplexList.
	 */
	public static ArrayList<Cineplex> getCineplexList() {
		return cineplexList;
	}

	/**
	 * Gets holidayList.
	 *
	 * @return Value of holidayList.
	 */
	public static ArrayList<Holiday> getHolidayList() {
		return holidayList;
	}

	/**
	 * Sets new holidayList.
	 *
	 * @param holidayList New value of holidayList.
	 */
	public static void setHolidayList(ArrayList<Holiday> holidayList) {
		holidayList = holidayList;
	}
}
