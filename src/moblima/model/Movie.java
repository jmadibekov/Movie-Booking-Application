package moblima.model;

import java.util.ArrayList;

public class Movie {

	private ArrayList<Showtime> showtimeList;
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
	private int noOfShowtime;

	public Movie(int noOfShowtime, int userCount, String showingStatus, String title,
				 String synopsis, String[] director, String[] cast,
				 double overallRating, String ageRequirement, int ticketSales, String cineplexId, String movieId) {
		this.movieId = movieId;
		this.cineplexId = cineplexId;
		this.noOfShowtime = noOfShowtime;
		this.ticketSales = ticketSales;
		this.showtimeList = new ArrayList<Showtime>();

		boolean a = movieId == "001" && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"));
		boolean b = movieId == "002" && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"));
		boolean c = movieId == "003" && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"));
		if (cineplexId == "001") {
			if (a) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A1234");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "IMAX", "A5678");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "Digital", "A1234");
				showtimeList.add(showtimeC);
			}
			else if (b) {
				Showtime showtimeA = new Showtime(1, 1100, "30/10/2019", "3D", "A5678");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "02/11/2019", "IMAX", "A5678");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "Digital", "A3456");
				showtimeList.add(showtimeC);
			}
			else if (c) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A1234");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "IMAX", "A5678");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "Digital", "A1234");
				showtimeList.add(showtimeC);
			}
		}

		else if (cineplexId == "002") {
			if (a) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A12345");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "IMAX", "A56789");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "Digital", "A12345");
				showtimeList.add(showtimeC);
			}
			else if (b) {
				Showtime showtimeA = new Showtime(1, 1100, "30/10/2019", "3D", "A56789");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "02/11/2019", "IMAX", "A56789");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "Digital", "A34567");
				showtimeList.add(showtimeC);
			}
			else if (c) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A12345");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "IMAX", "A56789");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "Digital", "A12345");
				showtimeList.add(showtimeC);
			}
		}
		else if (cineplexId == "003") {
			if (a) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A123456");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "IMAX", "A56789");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "Digital", "A123456");
				showtimeList.add(showtimeC);
			}
			else if (b) {
				Showtime showtimeA = new Showtime(1, 1100, "30/10/2019", "3D", "A345678");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "02/11/2019", "IMAX", "A56789");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "Digital", "A345678");
				showtimeList.add(showtimeC);
			}
			else if (c) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A123456");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "IMAX", "A56789");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "Digital", "A123456");
				showtimeList.add(showtimeC);
			}
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

	public ArrayList<Showtime> getShowtimeList() {
		return showtimeList;
	}

	public void setShowtimeList(ArrayList<Showtime> showtimeList) {
		this.showtimeList = showtimeList;
	}

	public void addShowtime(Showtime showtime) {
		showtimeList.add(showtime);
		noOfShowtime++;
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

	public int getNoOfShowtime() {
		return noOfShowtime;
	}

	public void setNoOfShowtime(int noOfShowtime) {
		this.noOfShowtime = noOfShowtime;
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

	public String getCinemaId() {return cineplexId;}

	public void setCinemaId(String cinemaId) {this.cineplexId = cinemaId;}
}
