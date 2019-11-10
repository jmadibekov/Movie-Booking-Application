package moblima.model;

import moblima.controller.*;

import java.io.IOException;
import java.util.ArrayList;

public class Cineplex {
	private String cineplexName;
	private String cineplexId;
	private ArrayList < Movie > movieList;
	private ArrayList < Cinema > cinemaList;
	private ArrayList < Staff > staffList;
	private double baseTicketCost;

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

	void output() {
		System.out.printf("Name: %s, Id: %s\n", cineplexName, cineplexId);
		System.out.printf("Movies:\n");
		for (Movie i : movieList) {
			System.out.println("===============");
			System.out.printf("%s %s\n", i.getMovieId(), i.getCineplexId());
			i.output();
		}
	}

	public boolean hasMovieWithTitle(String chosenTitle) {
		for (Movie i : movieList)
			if (i.getTitle().compareTo(chosenTitle) == 0)
				return true;
		return false;
	}

	public Movie getMovieWithTitle(String chosenTitle) {
		for (Movie i : movieList)
			if (i.getTitle().compareTo(chosenTitle) == 0)
				return i;
		return null;
	}

	public String getCineplexName() {
		return cineplexName;
	}

	public void setCineplexName(String cineplexName) {
		this.cineplexName = cineplexName;
	}

	public String getCineplexId() {
		return cineplexId;
	}

	public void setCineplexId(String cineplexId) {
		this.cineplexId = cineplexId;
	}

	public ArrayList < Movie > getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList < Movie > movieList) {
		this.movieList = movieList;
	}

	public void addMovie(Movie movie) {
		movieList.add(movie);
	}

	public ArrayList < Cinema > getCinemaList() {
		return cinemaList;
	}

	public void setCinemaList(ArrayList < Cinema > cinemaList) {
		this.cinemaList = cinemaList;
	}

	public void addTheatre(Cinema cinema) {
		cinemaList.add(cinema);
	}

	public ArrayList < Staff > getStaffList() {
		return staffList;
	}

	public void setStaffList(ArrayList < Staff > staffList) {
		this.staffList = staffList;
	}

	public void addStaff(Staff staff) {
		staffList.add(staff);
	}

	public double getBaseTicketCost() {
		return baseTicketCost;
	}

	public void setBaseTicketCost(double baseTicketCost) {
		this.baseTicketCost = baseTicketCost;
	}
}