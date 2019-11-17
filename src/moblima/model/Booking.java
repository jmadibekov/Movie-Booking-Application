package moblima.model;

import moblima.controller.BookingController;

import java.util.ArrayList;
import java.util.Calendar;

/**
 Represents a booking containing relevant booking information when customer booked seats for a showtime
 A booking corresponds to a customer
*/
public class Booking {
	/**
	 * The email of the customer
	 */
	private String email;
	/**
	 * The date of showtime booked
	 */
	private String date;
	/**
	 * Transaction ID of booking
	 * TID is of the format XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour, m : minutes, XXX : cinema code in letters).
	 */
	private String TID;
	/**
	 * 2D integer array to store the seats booked. Each seat is in the format {ticketType, row, column}
	 */
	private ArrayList<ArrayList<Integer>> chosenSeats;
	/**
	 * Cinema class (Platinum/Gold/Regular) of the showtime booked
	 */
	private String cinemaClass;
	/**
	 * Total price of booking
	 */
	private double totalPrice;
	/**
	 * Cineplex ID of booked showtime to allow customer to know at which cineplex he/she booked
	 */
	private String cineplexName;
	/**
	 * Movie Name of booked showtime to allow customer to know which movie he/she booked
	 */
	private String movieName;
	/**
	 * Cinema ID to allow customer to know which cinema he/she went to watch the movie
	 */
	private String cinemaId;

	/**
	 * Creates a new Booking when payment is made
	 * TID is generated based on the date booking is made
	 * @param email This booking's email.
	 * @param date This booking's date
	 * @param chosenSeats Information on seats booked.
	 * @param cinemaClass This booking's cinemaClass.
	 * @param totalPrice This booking's totalPrice
	 * @param cineplexName This booking's cineplexName
	 * @param movieName This booking's movieName
	 * @param cinemaId This booking's cinemaId
	 */
	public Booking(String email, String date, ArrayList<ArrayList<Integer>> chosenSeats, String cinemaClass,
				   double totalPrice, String cineplexName, String movieName, String cinemaId) {
		this.cineplexName = cineplexName;
		this.movieName = movieName;
		this.cinemaId = cinemaId;
		this.email = email;
		this.date = date;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
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
		this.cinemaClass = cinemaClass;
		this.totalPrice = totalPrice;
	}

	/**
	 * Creates a new Booking, parameters passed from database
	 * Initialize the model based on data in database
	 * @param email This booking's email.
	 * @param date This booking's date
	 * @param cinemaClass This booking's cinemaClass
	 * @param totalPrice This booking's totalPrice
	 * @param cineplexName This booking's cineplexName
	 * @param movieName This booking's movieName
	 * @param cinemaId This booking's cinemaId
	 * @param TID This booking's TID
	 * @param chosenSeats This booking's chosenSeats
	 */
	public Booking(String email, String date, String cinemaClass, double totalPrice, String cineplexName,
				   String movieName, String cinemaId, String TID, ArrayList<ArrayList<Integer>> chosenSeats) {
		this.cineplexName = cineplexName;
		this.movieName = movieName;
		this.cinemaId = cinemaId;
		this.TID = TID;
		this.email = email;
		this.date = date;
		this.chosenSeats = chosenSeats;
		this.cinemaClass = cinemaClass;
		this.totalPrice = totalPrice;
	}

	/**
	 * Print output information of all attributes stored in booking class
	 */
	public void output() {
		System.out.printf("Date: %s, Transaction ID: %s\n", date, TID);
		System.out.printf("Cineplex Name: '%s', Cinema Class: '%s'\n", cineplexName, cinemaClass);
		System.out.printf("Movie Title: '%s', Cost: %.2f\n", movieName, totalPrice);
		System.out.println("Number of seats booked: " + chosenSeats.size());
		BookingController.printSeatSelected(chosenSeats);
	}

	/**
	 * Gets email of customer who made the booking.
	 * @return this booking's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets new email of booking.
	 *
	 * @param email New value of The email of booking.
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * Gets The date of showtime booked.
	 *
	 * @return Value of The date of showtime booked.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets new The date of showtime booked.
	 *
	 * @param date New value of The date of showtime booked.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Sets new 2D integer array to store the seats booked. Each seat is in the format {ticketType, row, column}.
	 *
	 * @param chosenSeats New value of 2D integer array to store the seats booked. Each seat is in the format {ticketType, row, column}.
	 */
	public void setChosenSeats(ArrayList<ArrayList<Integer>> chosenSeats) {
		this.chosenSeats = chosenSeats;
	}

	/**
	 * Gets Total price of booking.
	 *
	 * @return Value of Total price of booking.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Gets Cinema class PlatinumGoldRegular of the showtime booked.
	 *
	 * @return Value of Cinema class PlatinumGoldRegular of the showtime booked.
	 */
	public String getCinemaClass() {
		return cinemaClass;
	}

	/**
	 * Sets new Cinema class PlatinumGoldRegular of the showtime booked.
	 *
	 * @param cinemaClass New value of Cinema class PlatinumGoldRegular of the showtime booked.
	 */
	public void setCinemaClass(String cinemaClass) {
		this.cinemaClass = cinemaClass;
	}

	/**
	 * Sets new Cineplex Name of booked showtime to allow customer to know at which cineplex heshe booked.
	 *
	 * @param cineplexName New value of Cineplex ID of booked showtime to allow customer to know at which cineplex heshe booked.
	 */
	public void setCineplexName(String cineplexName) {
		this.cineplexName = cineplexName;
	}

	/**
	 * Gets 2D integer array to store the seats booked. Each seat is in the format {ticketType, row, column}.
	 *
	 * @return Value of 2D integer array to store the seats booked. Each seat is in the format {ticketType, row, column}.
	 */
	public ArrayList<ArrayList<Integer>> getChosenSeats() {
		return chosenSeats;
	}

	/**
	 * Gets Movie ID of booked showtime to allow customer to know which movie heshe booked.
	 *
	 * @return Value of Movie ID of booked showtime to allow customer to know which movie heshe booked.
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * Sets new Total price of booking.
	 *
	 * @param totalPrice New value of Total price of booking.
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Gets Cinema ID to allow customer to know which cinema heshe went to watch the movie.
	 *
	 * @return Value of Cinema ID to allow customer to know which cinema heshe went to watch the movie.
	 */
	public String getCinemaId() {
		return cinemaId;
	}

	/**
	 * Gets Transaction ID of booking
	 * TID is of the format XXXYYYYMMDDhhmm Y : year, M : month, D : day, h : hour, m : minutes, XXX : cinema code in letters..
	 *
	 * @return Value of Transaction ID of booking
	 * TID is of the format XXXYYYYMMDDhhmm Y : year, M : month, D : day, h : hour, m : minutes, XXX : cinema code in letters..
	 */
	public String getTID() {
		return TID;
	}

	/**
	 * Gets Cineplex Name of booked showtime to allow customer to know at which cineplex heshe booked.
	 *
	 * @return Value of Cineplex Name of booked showtime to allow customer to know at which cineplex heshe booked.
	 */
	public String getCineplexName() {
		return cineplexName;
	}

	/**
	 * Sets new Cinema ID to allow customer to know which cinema heshe went to watch the movie.
	 *
	 * @param cinemaId New value of Cinema ID to allow customer to know which cinema heshe went to watch the movie.
	 */
	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}

	/**
	 * Sets new Transaction ID of booking
	 * TID is of the format XXXYYYYMMDDhhmm Y : year, M : month, D : day, h : hour, m : minutes, XXX : cinema code in letters..
	 *
	 * @param TID New value of Transaction ID of booking
	 *            TID is of the format XXXYYYYMMDDhhmm Y : year, M : month, D : day, h : hour, m : minutes, XXX : cinema code in letters..
	 */
	public void setTID(String TID) {
		this.TID = TID;
	}

	/**
	 * Sets new Movie Name of booked showtime to allow customer to know which movie heshe booked.
	 *
	 * @param movieName New value of Movie ID of booked showtime to allow customer to know which movie heshe booked.
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}
