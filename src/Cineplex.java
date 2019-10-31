import java.util.ArrayList;

public class Cineplex {
	private String cinemaName;
	private int cineplexId;
	private ArrayList<Movie> movieList;
	private ArrayList<Cinema> cinemaList;
	private ArrayList<Staff> staffList;
	private double baseTicketCost;
	private int noOfMovie;
	private int noOfTheatre;
	private int noOfStaff;
	
	public Cineplex(int noOfTheatre, int noOfMovie, int noOfStaff, String cinemaName, int cineplexId, double baseTicketCost) {
		this.noOfTheatre = noOfTheatre;
		this.noOfMovie = noOfMovie;
		this.noOfStaff = noOfStaff;
		this.cinemaName = cinemaName;
		this.cineplexId = cineplexId;
		if (cineplexId == 1) {
			this.movieList = new ArrayList<Movie>();
			String[] directorA = new String[]{"Mohamed", "Fazli"};
			String[]castA = new String[]{"Fazli", "Mohamed"};
			Movie movieA = new Movie(3, 3, "NowShowing", "Bug's Life", "abc", directorA, castA, 4.2, "PG13", cineplexId, 1);
			movieList.add(movieA);
			String[] directorB = new String[]{"Mohame", "Fazl"};
			String[]castB = new String[]{"Fazl", "Mohame"};
			Movie movieB = new Movie(3, 3, "Preview", "John Wick", "cde", directorB, castB, 4.1, "NC16", cineplexId, 2);
			movieList.add(movieB);
			String[] directorC = new String[]{"Moham", "Faz"};
			String[]castC = new String[]{"Faz", "Moham"};
			Movie movieC = new Movie(0, 0, "ComingSoon", "Mulan", "fgh", directorC, castC, 4.0, "M18", cineplexId, 3);
			movieList.add(movieC);
			this.cinemaList = new ArrayList<Cinema>();
			Cinema cinemaA = new Cinema("A1234", "Regular");
			cinemaList.add(cinemaA);
			Cinema cinemaB = new Cinema("A3456", "Gold");
			cinemaList.add(cinemaB);
			Cinema cinemaC = new Cinema("A5678", "Platinum");
			cinemaList.add(cinemaC);
		}
		
		else if (cineplexId == 2) {
			this.movieList = new ArrayList<Movie>();
			String[] directorA = new String[]{"Mohamed", "Fazli"};
			String[]castA = new String[]{"Fazli", "Mohamed"};
			Movie movieA = new Movie(3, 3, "NowShowing", "Bug's Life", "abc", directorA, castA, 4.2, "PG13", cineplexId, 1);
			movieList.add(movieA);
			String[] directorB = new String[]{"Ju", "Xian"};
			String[]castB = new String[]{"Ju", "Xian"};
			Movie movieB = new Movie(3, 3, "Preview", "John Wick 2", "cdef", directorB, castB, 4.5, "NC16", cineplexId, 2);
			movieList.add(movieB);
			String[] directorC = new String[]{"Ju", "Xia"};
			String[]castC = new String[]{"Ju", "Xia"};
			Movie movieC = new Movie(3, 3, "NowShowing", "Mulan 2", "fghi", directorC, castC, 4.6, "M18", cineplexId, 3);
			movieList.add(movieC);
			this.cinemaList = new ArrayList<Cinema>();
			Cinema cinemaA = new Cinema("A12345", "Regular");
			cinemaList.add(cinemaA);
			Cinema cinemaB = new Cinema("A34567", "Gold");
			cinemaList.add(cinemaB);
			Cinema cinemaC = new Cinema("A56789", "Platinum");
			cinemaList.add(cinemaC);
		}
		
		else if (cineplexId == 3) {
			this.movieList = new ArrayList<Movie>();
			String[] directorA = new String[]{"Mohame", "Fazl"};
			String[]castA = new String[]{"Fazl", "Mohame"};
			Movie movieA = new Movie(3, 3, "Preview", "John Wick", "cde", directorA, castA, 4.1, "NC16", cineplexId, 1);
			movieList.add(movieA);
			String[] directorB = new String[]{"Ju", "Xian"};
			String[]castB = new String[]{"Ju", "Xian"};
			Movie movieB = new Movie(3, 3, "Preview", "John Wick 2", "cdef", directorB, castB, 4.5, "NC16", cineplexId, 2);
			movieList.add(movieB);
			String[] directorC = new String[]{"Nickk"};
			String[]castC = new String[]{"Benedi"};
			Movie movieC = new Movie(3, 3, "NowShowing", "Harry Potter", "fghij", directorC, castC, 4.2, "M18", cineplexId, 3);
			movieList.add(movieC);
			this.cinemaList = new ArrayList<Cinema>();
			Cinema cinemaA = new Cinema("A123456", "Regular");
			cinemaList.add(cinemaA);
			Cinema cinemaB = new Cinema("A345678", "Gold");
			cinemaList.add(cinemaB);
			Cinema cinemaC = new Cinema("A56789", "Platinum");
			cinemaList.add(cinemaC);
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

	public int getCineplexId() {
		return cineplexId;
	}

	public void setCineplexId(int cineplexId) {
		this.cineplexId = cineplexId;
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

	public ArrayList<Cinema> getCinemaList() {
		return cinemaList;
	}

	public void setCinemaList(ArrayList<Cinema> cinemaList) {
		this.cinemaList = cinemaList;
	}
	
	public void addTheatre(Cinema cinema) {
		cinemaList.add(cinema);
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
