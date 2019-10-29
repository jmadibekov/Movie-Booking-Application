import java.util.ArrayList;

public class Cinema {
	private String cinemaName;
	private int cinemaId;
	private ArrayList<Movie> movieList;
	private ArrayList<Theatre> theatreList;
	private ArrayList<Staff> staffList;
	private double baseTicketCost;
	private int noOfMovie;
	private int noOfTheatre;
	private int noOfStaff;
	
	public Cinema(int noOfTheatre, int noOfMovie,int noOfStaff, String cinemaName, int cinemaId, double baseTicketCost) {
		this.noOfTheatre = noOfTheatre;
		this.noOfMovie = noOfMovie;
		this.noOfStaff = noOfStaff;
		this.cinemaName = cinemaName;
		this.cinemaId = cinemaId;
		if (cinemaId == 1) {
			this.movieList = new ArrayList<Movie>();
			String[] directorA = new String[]{"Mohamed", "Fazli"};
			String[]castA = new String[]{"Fazli", "Mohamed"};
			Movie movieA = new Movie(3, 3, "NowShowing", "Bug's Life", "abc", directorA, castA, 4.2, "PG13", cinemaId, 1);
			movieList.add(movieA);
			String[] directorB = new String[]{"Mohame", "Fazl"};
			String[]castB = new String[]{"Fazl", "Mohame"};
			Movie movieB = new Movie(3, 3, "Preview", "John Wick", "cde", directorB, castB, 4.1, "NC16", cinemaId, 2);
			movieList.add(movieB);
			String[] directorC = new String[]{"Moham", "Faz"};
			String[]castC = new String[]{"Faz", "Moham"};
			Movie movieC = new Movie(0, 0, "ComingSoon", "Mulan", "fgh", directorC, castC, 4.0, "M18", cinemaId, 3);
			movieList.add(movieC);
			this.theatreList = new ArrayList<Theatre>();
			Theatre theatreA = new Theatre("A1234", "Regular");
			theatreList.add(theatreA);
			Theatre theatreB = new Theatre("A3456", "Gold");
			theatreList.add(theatreB);
			Theatre theatreC = new Theatre("A5678", "Platinum");
			theatreList.add(theatreC);
		}
		
		else if (cinemaId == 2) {
			this.movieList = new ArrayList<Movie>();
			String[] directorA = new String[]{"Mohamed", "Fazli"};
			String[]castA = new String[]{"Fazli", "Mohamed"};
			Movie movieA = new Movie(3, 3, "NowShowing", "Bug's Life", "abc", directorA, castA, 4.2, "PG13", cinemaId, 1);
			movieList.add(movieA);
			String[] directorB = new String[]{"Ju", "Xian"};
			String[]castB = new String[]{"Ju", "Xian"};
			Movie movieB = new Movie(3, 3, "Preview", "John Wick 2", "cdef", directorB, castB, 4.5, "NC16", cinemaId, 2);
			movieList.add(movieB);
			String[] directorC = new String[]{"Ju", "Xia"};
			String[]castC = new String[]{"Ju", "Xia"};
			Movie movieC = new Movie(3, 3, "NowShowing", "Mulan 2", "fghi", directorC, castC, 4.6, "M18", cinemaId, 3);
			movieList.add(movieC);
			this.theatreList = new ArrayList<Theatre>();
			Theatre theatreA = new Theatre("A12345", "Regular");
			theatreList.add(theatreA);
			Theatre theatreB = new Theatre("A34567", "Gold");
			theatreList.add(theatreB);
			Theatre theatreC = new Theatre("A56789", "Platinum");
			theatreList.add(theatreC);
		}
		
		else if (cinemaId == 3) {
			this.movieList = new ArrayList<Movie>();
			String[] directorA = new String[]{"Mohame", "Fazl"};
			String[]castA = new String[]{"Fazl", "Mohame"};
			Movie movieA = new Movie(3, 3, "Preview", "John Wick", "cde", directorA, castA, 4.1, "NC16", cinemaId, 1);
			movieList.add(movieA);
			String[] directorB = new String[]{"Ju", "Xian"};
			String[]castB = new String[]{"Ju", "Xian"};
			Movie movieB = new Movie(3, 3, "Preview", "John Wick 2", "cdef", directorB, castB, 4.5, "NC16", cinemaId, 2);
			movieList.add(movieB);
			String[] directorC = new String[]{"Nickk"};
			String[]castC = new String[]{"Benedi"};
			Movie movieC = new Movie(3, 3, "NowShowing", "Harry Potter", "fghij", directorC, castC, 4.2, "M18", cinemaId, 3);
			movieList.add(movieC);
			this.theatreList = new ArrayList<Theatre>();
			Theatre theatreA = new Theatre("A123456", "Regular");
			theatreList.add(theatreA);
			Theatre theatreB = new Theatre("A345678", "Gold");
			theatreList.add(theatreB);
			Theatre theatreC = new Theatre("A56789", "Platinum");
			theatreList.add(theatreC);
		}
		this.staffList = new ArrayList<Staff>();
		this.baseTicketCost = baseTicketCost;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public void addMovie(Movie movie) {
		movieList.add(movie);
		noOfMovie++;
	}

	public ArrayList<Theatre> getTheatreList() {
		return theatreList;
	}

	public void setTheatreList(ArrayList<Theatre> theatreList) {
		this.theatreList = theatreList;
	}
	
	public void addTheatre(Theatre theatre) {
		theatreList.add(theatre);
		noOfTheatre++;
	}
	 
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(ArrayList<Staff> staffList) {
		this.staffList = staffList;
	}
	
	public void addStaff(Staff staff) {
		staffList.add(staff);
		noOfStaff++;
	}
	
	public double getBaseTicketCost() {
		return baseTicketCost;
	}

	public void setBaseTicketCost(double baseTicketCost) {
		this.baseTicketCost = baseTicketCost;
	}
	
	
	
}
