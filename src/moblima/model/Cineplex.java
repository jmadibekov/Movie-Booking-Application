package moblima.model;

import moblima.controller.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a Cineplex consisting of staff, movies and cinemas(theatre halls)
 */
public class Cineplex {
	/*
	* Name of the cineplex
	 */
	private String cineplexName;
	/**
	 * ID of cineplex
	 */
	private String cineplexId;
	/**
	 * Array of movie objects belonging to the cineplex
	 */
	private ArrayList < Movie > movieList;
	/**
	 * Array of Cinema objects belonging to the cineplex
	 */
	private ArrayList < Cinema > cinemaList;
	/**
	 * Array of Staff objects belonging to the cineplex
	 */
	private ArrayList < Staff > staffList;
	/**
	 * Base ticket price of the cineplex
	 */
	private double baseTicketCost;

	/**
	 * Create a new cineplex
	 * Reads from the database using DBController and get an arraylist of movie objects and store them to movieList
	 * Reads from the database using DBController and get an arraylist of staff objects and store them to staffList
	 * Reads from the database using DBController and get an arraylist of Cinema objects and store them to cinemaList
	 * @param cineplexName Name of a cineplex
	 * @param cineplexId ID of a cineplex
	 * @param baseTicketCost Base Ticket Cost of a cineplex
	 */
	public Cineplex(String cineplexName, String cineplexId, double baseTicketCost) {
		this.cineplexName = cineplexName;
		this.cineplexId = cineplexId;

		try {
			this.movieList = DBController.readMovies("src/moblima/data/MovieDB.txt", cineplexId);
			this.staffList = DBController.readStaff("src/moblima/data/StaffDB.txt", cineplexId);
			this.cinemaList = DBController.readCinema("src/moblima/data/CinemaDB.txt", cineplexId);
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
		this.baseTicketCost = baseTicketCost;
	}

	/**
	 * Print output information of all relevant attributes
	 */
	void output() {
		System.out.printf("Name: %s, Id: %s\n", cineplexName, cineplexId);
		System.out.printf("Movies:\n");
		for (Movie i : movieList) {
			System.out.println("===============");
			System.out.printf("%s %s\n", i.getMovieId(), i.getCineplexId());
			i.output();
		}
	}

	/**
	 * Return true if chosenTitle is found in the movielist of the cineplex
	 * @param chosenTitle Title to be checked for.
	 * @return boolean
	 */
	public boolean hasMovieWithTitle(String chosenTitle) {
		for (Movie i : movieList)
			if (i.getTitle().equalsIgnoreCase(chosenTitle) && i.getShowingStatus().compareTo("End of Showing") != 0)
				return true;
		return false;
	}

	/**
	 * Return movie if chosenTitle is found in the movielist of the cineplex
	 * Otherwise, return null
	 * @param chosenTitle Title to find with.
	 * @return Movie
	 */
	public Movie getMovieWithTitle(String chosenTitle) {
		for (Movie i : movieList)
			if (i.getTitle().equalsIgnoreCase(chosenTitle))
				return i;
		return null;
	}


	/**
	 * Gets Array of Cinema objects belonging to the cineplex.
	 *
	 * @return Value of Array of Cinema objects belonging to the cineplex.
	 */
	public ArrayList<Cinema> getCinemaList() {
		return cinemaList;
	}

	/**
	 * Sets new Array of movie objects belonging to the cineplex.
	 *
	 * @param movieList New value of Array of movie objects belonging to the cineplex.
	 */
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}

	/**
	 * Gets ID of cineplex.
	 *
	 * @return Value of ID of cineplex.
	 */
	public String getCineplexId() {
		return cineplexId;
	}

	/**
	 * Gets Array of Staff objects belonging to the cineplex.
	 *
	 * @return Value of Array of Staff objects belonging to the cineplex.
	 */
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	/**
	 * Sets new Array of Cinema objects belonging to the cineplex.
	 *
	 * @param cinemaList New value of Array of Cinema objects belonging to the cineplex.
	 */
	public void setCinemaList(ArrayList<Cinema> cinemaList) {
		this.cinemaList = cinemaList;
	}

	/**
	 * Gets Base ticket price of the cineplex.
	 *
	 * @return Value of Base ticket price of the cineplex.
	 */
	public double getBaseTicketCost() {
		return baseTicketCost;
	}

	/**
	 * Sets new cineplexName.
	 *
	 * @param cineplexName New value of cineplexName.
	 */
	public void setCineplexName(String cineplexName) {
		this.cineplexName = cineplexName;
	}

	/**
	 * Sets new Base ticket price of the cineplex.
	 *
	 * @param baseTicketCost New value of Base ticket price of the cineplex.
	 */
	public void setBaseTicketCost(double baseTicketCost) {
		this.baseTicketCost = baseTicketCost;
	}

	/**
	 * Sets new Array of Staff objects belonging to the cineplex.
	 *
	 * @param staffList New value of Array of Staff objects belonging to the cineplex.
	 */
	public void setStaffList(ArrayList<Staff> staffList) {
		this.staffList = staffList;
	}

	/**
	 * Sets new ID of cineplex.
	 *
	 * @param cineplexId New value of ID of cineplex.
	 */
	public void setCineplexId(String cineplexId) {
		this.cineplexId = cineplexId;
	}

	/**
	 * Gets Array of movie objects belonging to the cineplex.
	 *
	 * @return Value of Array of movie objects belonging to the cineplex.
	 */
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	/**
	 * Gets cineplexName.
	 *
	 * @return Value of cineplexName.
	 */
	public String getCineplexName() {
		return cineplexName;
	}
}