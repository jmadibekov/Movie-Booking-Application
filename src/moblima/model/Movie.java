package moblima.model;

import moblima.controller.DBController;

import java.io.IOException;
import java.util.ArrayList;

public class Movie {
	private ArrayList < Showtime > showtimeList;
	private String movieId;
	private String cineplexId;
	private int userCount;
	private int ticketSales;
	private String showingStatus;
	private String title;
	private String synopsis;
	private String[] director;
	private String[] cast;
	private double overallRating;
	private String ageRequirement;
	private int duration;

	public Movie(int userCount, String showingStatus, String title, String synopsis, String[] director, String[] cast,
				 double overallRating, String ageRequirement, int ticketSales, String cineplexId, String movieId, int duration) {
		this.movieId = movieId;
		this.cineplexId = cineplexId;
		this.ticketSales = ticketSales;
		this.showtimeList = new ArrayList<Showtime>();
		this.duration = duration;

		try {
			this.showtimeList = DBController.readShowtime("src/moblima/data/ShowtimeDB.txt", cineplexId, movieId);
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

	public void output() {
		System.out.printf("Title: %s\n", title);
		System.out.printf("Showing status: %s, Rating: %.2f\n", showingStatus, overallRating);
		System.out.printf("Age requirement: %s", ageRequirement);

	}

	public ArrayList<Showtime> getShowtimeList() {
		return showtimeList;
	}

	public void setShowtimeList(ArrayList<Showtime> showtimeList) {
		this.showtimeList = showtimeList;
	}

	public void addShowtime(Showtime showtime) {
		showtimeList.add(showtime);
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public String getShowingStatus() {
		return showingStatus;
	}

	public void setShowingStatus(String showingStatus) {
		this.showingStatus = showingStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String[] getDirector() {
		return director;
	}

	public void setDirector(String[] director) {
		this.director = director;
	}

	public String[] getCast() {
		return cast;
	}

	public void setCast(String[] cast) {
		this.cast = cast;
	}

	public double getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(double overallRating) {
		this.overallRating = overallRating;
	}

	public String getAgeRequirement() {
		return ageRequirement;
	}

	public void setAgeRequirement(String ageRequirement) {
		this.ageRequirement = ageRequirement;
	}

	public int getTicketSales() {
		return ticketSales;
	}

	public void addTicketSales(int noOfTickets) {
		ticketSales = ticketSales + noOfTickets;
	}

	public void setTicketSales(int ticketSales) {
		this.ticketSales = ticketSales;
	}

	public String getCineplexId() { return cineplexId; }

	public void setCineplexId(String cinemaId) { this.cineplexId = cinemaId; }

	public int getDuration() { return duration; }

	public void setDuration(int duration) { this.duration = duration; }
}
