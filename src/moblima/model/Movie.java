package moblima.model;

import moblima.controller.DBController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a Movie belonging to a particular cineplex
 */
public class Movie {
	/**
	 * ID of the movie
	 */
	private String movieId;

	// Specific to Cineplex
	/**
	 * Array of showtime objects belonging to the movie
	 */
	private ArrayList < Showtime > showtimeList;
	/**
	 * Array of review objects belonging to the movie
	 */
	private ArrayList < Review > reviewList;
	/**
	 * ID of cineplex containing the movie
	 */
	private String cineplexId;
	/**
	 * No of users who left a review
	 */
	private int userCount;
	/**
	 * Total number of ticket sales of the movie
	 */
	private int ticketSales;
	/**
	 * Showing status of the movie
	 */
	private String showingStatus;
	/**
	 * Overall Rating of the movie
	 */
	private double overallRating;
	// --------

	/**
	 * Title of the movie
	 */
	private String title;
	/**
	 * Synopsis of the movie
	 */
	private String synopsis;
	/**
	 * List of Directors of the movie
	 */
	private String[] director;
	/**
	 * List of the cast of the movie
	 */
	private String[] cast;
	/**
	 * Age requirement of the movie
	 */
	private String ageRequirement;
	/**
	 * Duration of the movie
	 */
	private int duration;

	/**
	 * Instantiates a new Movie
	 * Includes data from database retrieved using DBController
	 *
	 * @param userCount      the user count
	 * @param showingStatus  the showing status
	 * @param title          the title
	 * @param synopsis       the synopsis
	 * @param director       the director
	 * @param cast           the cast
	 * @param overallRating  the overall rating
	 * @param ageRequirement the age requirement
	 * @param ticketSales    the ticket sales
	 * @param cineplexId     the cineplex id
	 * @param movieId        the movie id
	 * @param duration       the duration
	 */
	public Movie(int userCount, String showingStatus, String title, String synopsis, String[] director, String[] cast,
				 double overallRating, String ageRequirement, int ticketSales, String cineplexId, String movieId, int duration) {
		this.movieId = movieId;
		this.cineplexId = cineplexId;
		this.ticketSales = ticketSales;
		this.showtimeList = new ArrayList<Showtime>();
		this.duration = duration;

		try {
			this.showtimeList = DBController.readShowtime("src/moblima/data/ShowtimeDB.txt", cineplexId, movieId);
			this.reviewList = DBController.readReview("src/moblima/data/ReviewDB.txt", cineplexId, movieId);
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
		this.userCount = userCount;
		this.showingStatus = showingStatus;
		this.title = title;
		this.synopsis = synopsis;
		this.director = director;
		this.cast = cast;;
		this.overallRating = overallRating;
		this.ageRequirement = ageRequirement;
	}

	/**
	 * Print output information of relevant attributes to the user
	 */
	public void output() {
		System.out.printf("Title: '%s'\n", title);
		System.out.printf("Showing status: %s, ", showingStatus);
		System.out.printf("Rating: %s\n", getOverallRating());

		System.out.printf("Age requirement: %s\n", ageRequirement);
		System.out.printf("Number of ticket sales: %d\n", ticketSales);
		System.out.printf("Duration: %d minutes\n", duration);
		System.out.printf("Synopsis: %s\n", synopsis);

		System.out.printf("Cast: ");
		System.out.println(Arrays.toString(cast));

		System.out.printf("Director(s): ");
		System.out.println(Arrays.toString(director));
	}

	/**
	 * Update the movie's details according to the updated info from other Cineplexes by the admin
	 *
	 * @param updatedMovie updated info of the same movie
	 */
	public void updateTo(Movie updatedMovie) {
		this.title = updatedMovie.getTitle();
		this.synopsis = updatedMovie.getSynopsis();
		this.director = updatedMovie.getDirector();
		this.cast = updatedMovie.getCast();
		this.ageRequirement = updatedMovie.getAgeRequirement();
		this.duration = updatedMovie.getDuration();
	}

	/**
	 * Append a new showtime to the showtimeList
	 *
	 * @param showtime new showtime for the movie
	 */
	public void addShowtime(Showtime showtime) {
		showtimeList.add(showtime);
	}

	/**
	 * Append a new review to the reviewList
	 *
	 * @param review new review for the movie
	 */
	public void addReview(Review review) {
		reviewList.add(review);
	}

	/**
	 * Add ticket sales
	 *
	 * @param noOfTickets number of tickets to be added to initial total ticket sales
	 */
	public void addTicketSales(int noOfTickets) {
		ticketSales = ticketSales + noOfTickets;
	}


	/**
	 * Gets Title of the movie.
	 *
	 * @return Value of Title of the movie.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets ID of cineplex containing the movie.
	 *
	 * @return Value of ID of cineplex containing the movie.
	 */
	public String getCineplexId() {
		return cineplexId;
	}

	/**
	 * Gets Array of review objects belonging to the movie.
	 *
	 * @return Value of Array of review objects belonging to the movie.
	 */
	public ArrayList<Review> getReviewList() {
		return reviewList;
	}

	/**
	 * Sets new Showing status of the movie.
	 *
	 * @param showingStatus New value of Showing status of the movie.
	 */
	public void setShowingStatus(String showingStatus) {
		this.showingStatus = showingStatus;
	}

	/**
	 * Gets Age requirement of the movie.
	 *
	 * @return Value of Age requirement of the movie.
	 */
	public String getAgeRequirement() {
		return ageRequirement;
	}

	/**
	 * Returns the overall rating of the movie in case there's more than one input. Otherwise, NA is returned.
	 *
	 * @return Value of Overall Rating of the movie in String.
	 */
	public String getOverallRating() {
		if (userCount > 1) {
			String s = String.format("%.2f", overallRating);
			return s;
		} else {
			return "NA";
		}
	}

	/**
	 * Returns the overall rating in double.
	 *
	 * @return Returns the overall rating in double.
	 */
	public double getOverallRatingInDouble() {
		return overallRating;
	}

	/**
	 * Gets Total number of ticket sales of the movie.
	 *
	 * @return Value of Total number of ticket sales of the movie.
	 */
	public int getTicketSales() {
		return ticketSales;
	}

	/**
	 * Sets new ID of cineplex containing the movie.
	 *
	 * @param cineplexId New value of ID of cineplex containing the movie.
	 */
	public void setCineplexId(String cineplexId) {
		this.cineplexId = cineplexId;
	}

	/**
	 * Gets Duration of the movie.
	 *
	 * @return Value of Duration of the movie.
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Sets new Array of review objects belonging to the movie.
	 *
	 * @param reviewList New value of Array of review objects belonging to the movie.
	 */
	public void setReviewList(ArrayList<Review> reviewList) {
		this.reviewList = reviewList;
	}

	/**
	 * Sets new No of users who left a review.
	 *
	 * @param userCount New value of No of users who left a review.
	 */
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	/**
	 * Gets List of Directors of the movie.
	 *
	 * @return Value of List of Directors of the movie.
	 */
	public String[] getDirector() {
		return director;
	}

	/**
	 * Gets List of the cast of the movie.
	 *
	 * @return Value of List of the cast of the movie.
	 */
	public String[] getCast() {
		return cast;
	}

	/**
	 * Gets ID of the movie.
	 *
	 * @return Value of ID of the movie.
	 */
	public String getMovieId() {
		return movieId;
	}

	/**
	 * Sets new Total number of ticket sales of the movie.
	 *
	 * @param ticketSales New value of Total number of ticket sales of the movie.
	 */
	public void setTicketSales(int ticketSales) {
		this.ticketSales = ticketSales;
	}

	/**
	 * Gets Synopsis of the movie.
	 *
	 * @return Value of Synopsis of the movie.
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * Sets new Duration of the movie.
	 *
	 * @param duration New value of Duration of the movie.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Sets new Overall Rating of the movie.
	 *
	 * @param overallRating New value of Overall Rating of the movie.
	 */
	public void setOverallRating(double overallRating) {
		this.overallRating = overallRating;
	}

	/**
	 * Sets new Age requirement of the movie.
	 *
	 * @param ageRequirement New value of Age requirement of the movie.
	 */
	public void setAgeRequirement(String ageRequirement) {
		this.ageRequirement = ageRequirement;
	}

	/**
	 * Gets Showing status of the movie.
	 *
	 * @return Value of Showing status of the movie.
	 */
	public String getShowingStatus() {
		return showingStatus;
	}

	/**
	 * Sets new Title of the movie.
	 *
	 * @param title New value of Title of the movie.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets new Array of showtime objects belonging to the movie.
	 *
	 * @param showtimeList New value of Array of showtime objects belonging to the movie.
	 */
	public void setShowtimeList(ArrayList<Showtime> showtimeList) {
		this.showtimeList = showtimeList;
	}

	/**
	 * Sets new Synopsis of the movie.
	 *
	 * @param synopsis New value of Synopsis of the movie.
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	/**
	 * Gets Array of showtime objects belonging to the movie.
	 *
	 * @return Value of Array of showtime objects belonging to the movie.
	 */
	public ArrayList<Showtime> getShowtimeList() {
		return showtimeList;
	}

	/**
	 * Sets new ID of the movie.
	 *
	 * @param movieId New value of ID of the movie.
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	/**
	 * Sets new List of the cast of the movie.
	 *
	 * @param cast New value of List of the cast of the movie.
	 */
	public void setCast(String[] cast) {
		this.cast = cast;
	}

	/**
	 * Sets new List of Directors of the movie.
	 *
	 * @param director New value of List of Directors of the movie.
	 */
	public void setDirector(String[] director) {
		this.director = director;
	}

	/**
	 * Gets No of users who left a review.
	 *
	 * @return Value of No of users who left a review.
	 */
	public int getUserCount() {
		return userCount;
	}
}