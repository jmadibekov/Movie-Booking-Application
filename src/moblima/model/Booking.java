package moblima.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Booking {
	private String email;
	private String date;
	private String TID;
	private ArrayList<ArrayList<Integer>> chosenSeats;
	private String theatreClass;
	private double totalPrice;
	private String cineplexId;
	private String movieId;
	private String cinemaId;

	public void output() {
		System.out.printf("Date: %s, Cinema Class: %s, Cost: %.2f, Transaction ID: %s\n", date, theatreClass, totalPrice, TID);
		System.out.println("Number of s2eats booked: " + chosenSeats.size());
		for (int i = 0;i < chosenSeats.size(); i++) {
			for (int j = 0; j < 3; j++) {
				switch(j) {
					case 0: switch(chosenSeats.get(i).get(j)) {
						case 1: System.out.printf("Ticket Type: Adult, ");
						break;
						case 2: System.out.printf("Ticket Type: Student, ");
						break;
						case 3: System.out.printf("Ticket Type: Senior Citizen, ");
						break;
					}
					break;
					case 1: System.out.printf("Row: %s, ", chosenSeats.get(i).get(j));
					break;
					case 2: System.out.printf("Column: %s\n", chosenSeats.get(i).get(j));
					break;
				}
			}
		}
	}

	public Booking(String email, String date, ArrayList<ArrayList<Integer>> chosenSeats, String theatreClass,
				   double totalPrice, String cineplexId, String movieId, String cinemaId) {
		this.cineplexId = cineplexId;
		this.movieId = movieId;
		this.cinemaId = cinemaId;
		this.email = email;
		this.date = date;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		if (month < 10) {
			TID = cinemaId + Integer.toString(year) + "0" + Integer.toString(month) +
					Integer.toString(day) + Integer.toString(hour) + Integer.toString(minute);
		}
		else {
			TID = cinemaId + Integer.toString(year) + Integer.toString(month) +
					Integer.toString(day) + Integer.toString(hour) + Integer.toString(minute);
		}
		this.chosenSeats = chosenSeats;
		this.theatreClass = theatreClass;
		this.totalPrice = totalPrice;
	}

	public Booking(String email, String date, String theatreClass, double totalPrice, String cineplexId,
				   String movieId, String cinemaId, String TID, ArrayList<ArrayList<Integer>> chosenSeats) {
		this.cineplexId = cineplexId;
		this.movieId = movieId;
		this.cinemaId = cinemaId;
		this.TID = TID;
		this.email = email;
		this.date = date;
		this.chosenSeats = chosenSeats;
		this.theatreClass = theatreClass;
		this.totalPrice = totalPrice;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTID() {
		return TID;
	}
	public void setTID(String tID) {
		TID = tID;
	}
	public String getTheatreClass() {
		return theatreClass;
	}
	public void setTheatreClass(String theatreClass) {
		this.theatreClass = theatreClass;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCineplexId() {
		return cineplexId;
	}
	public void setCineplexId(String cineplexId) {
		this.cineplexId = cineplexId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(String movieId) {
		this.cinemaId = cinemaId;
	}
	public ArrayList<ArrayList<Integer>> getChosenSeats() { return chosenSeats; }
	public void setChosenSeats(ArrayList<ArrayList<Integer>> movieId) {
		this.chosenSeats = chosenSeats;
	}

}
