import java.util.ArrayList;

public class Movie {
	
	private ArrayList<Showtime> showtimeList;
	private int movieId;
	private int userCount;
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
			double overallRating, String ageRequirement, int cinemaId, int movieId) {
		this.movieId = movieId;
		this.noOfShowtime = noOfShowtime;
		this.showtimeList = new ArrayList<Showtime>();
		
		if (cinemaId == 1) {
			if (movieId == 1 && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"))) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A1234", "Regular");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "Blockbuster", "A5678", "Platinum");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "3D", "A1234", "Regular");
				showtimeList.add(showtimeC);
			}
			else if (movieId == 2 && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"))) {
				Showtime showtimeA = new Showtime(1, 1100, "30/10/2019", "Blockbuster", "A5678", "Platinum");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "02/11/2019", "Blockbuster", "A5678", "Platinum");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "3D", "A3456", "Gold");
				showtimeList.add(showtimeC);
			}
			else if (movieId == 3 && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"))) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A1234", "Regular");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "Blockbuster", "A5678", "Platinum");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "3D", "A1234", "Regular");
				showtimeList.add(showtimeC);
			}
		}
		
		else if (cinemaId == 2) {
			if (movieId == 1 && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"))) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A12345", "Regular");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "Blockbuster", "A56789", "Platinum");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "3D", "A12345", "Regular");
				showtimeList.add(showtimeC);
			}
			else if (movieId == 2 && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"))) {
				Showtime showtimeA = new Showtime(1, 1100, "30/10/2019", "Blockbuster", "A56789", "Platinum");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "02/11/2019", "Blockbuster", "A56789", "Platinum");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "3D", "A34567", "Gold");
				showtimeList.add(showtimeC);
			}
			else if (movieId == 3 && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"))) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A12345", "Regular");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "Blockbuster", "A56789", "Platinum");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "3D", "A12345", "Regular");
				showtimeList.add(showtimeC);
			}
		}
		else if (cinemaId == 3 && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"))) {
			if (movieId == 1) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A123456", "Regular");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "Blockbuster", "A56789", "Platinum");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "3D", "A123456", "Regular");
				showtimeList.add(showtimeC);
			}
			else if (movieId == 2 && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"))) {
				Showtime showtimeA = new Showtime(1, 1100, "30/10/2019", "Blockbuster", "A345678", "Gold");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "02/11/2019", "Blockbuster", "A56789", "Platinum");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "3D", "A345678", "Gold");
				showtimeList.add(showtimeC);
			}
			else if (movieId == 3 && (showingStatus.contentEquals("NowShowing") || showingStatus.contentEquals("Preview"))) {
				Showtime showtimeA = new Showtime(1, 1100, "31/10/2019", "3D", "A123456", "Regular");
				showtimeList.add(showtimeA);
				Showtime showtimeB = new Showtime(2, 1400, "01/11/2019", "Blockbuster", "A56789", "Platinum");
				showtimeList.add(showtimeB);
				Showtime showtimeC = new Showtime(3, 2100, "03/11/2019", "3D", "A123456", "Regular");
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
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
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
	
}
