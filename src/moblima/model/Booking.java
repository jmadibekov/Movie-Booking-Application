package moblima.model;

import java.util.Calendar;

public class Booking {
	private String email;
	private String date;
	private String TID;
	private String[] choosenSeats;
	private String theatreClass;
	private double totalPrice;
	private String cineplexId;
	private String movieId;
	private String cinemaId;

	public Booking(String email, String date, String[] choosenSeats, String theatreClass, double totalPrice, String cineplexId,
				   String movieId, String cinemaId) {
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
		this.choosenSeats = choosenSeats;
		this.theatreClass = theatreClass;
		this.totalPrice = totalPrice;
	}

	public Booking(String TID, String email, String date, String[] choosenSeats, String theatreClass, double totalPrice, String cineplexId,
				   String movieId, String cinemaId) {
		this.cineplexId = cineplexId;
		this.movieId = movieId;
		this.cinemaId = cinemaId;
		this.TID = TID;
		this.email = email;
		this.date = date;
		this.choosenSeats = choosenSeats;
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


}
