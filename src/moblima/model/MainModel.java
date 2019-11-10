package moblima.model;

import moblima.controller.*;

import java.io.IOException;
import java.util.ArrayList;

public class MainModel {
	private static ArrayList < Cineplex > cineplexList;
	private static ArrayList < Customer > customerList;
	private static ArrayList < Holiday > holidayList;
	
	public static void init() {
		ArrayList< Cineplex > cineplexList = new ArrayList < Cineplex > ();
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
			for (int i = 0; i < cineplexList.size(); i++) {
				Cineplex cineplex = cineplexList.get(i);
				ArrayList<Movie> movieList = cineplex.getMovieList();
				ArrayList<Cinema> cinemaList = cineplex.getCinemaList();
				ArrayList<Staff> staffList = cineplex.getStaffList();

				for (int j = 0; j < movieList.size(); i++) {
					Movie movie = movieList.get(j);
					ArrayList<Showtime> showtimeList = movie.getShowtimeList();
					if (i == 0 && j == 0) {
						DBController.saveShowtime("ShowtimeDB.txt", showtimeList, movie.getCineplexId(), movie.getMovieId(), false);
					}
					else {
						DBController.saveShowtime("ShowtimeDB.txt", showtimeList, movie.getCineplexId(), movie.getMovieId(), true);
					}
				}
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

	public ArrayList < Holiday > getHolidayList() {
		return holidayList;
	}

	public void setHolidayList(ArrayList < Holiday > staffList) {
		this.holidayList = holidayList;
	}

	public void addHoliday(Holiday holiday) {
		holidayList.add(holiday);
	}
}
