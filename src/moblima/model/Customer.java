package moblima.model;

import moblima.controller.DBController;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a customer who is a moviegoer
 */
public class Customer {
	/**
	 * Email of the customer
	 */
	private String email;
	/**
	 * Name of the customer
	 */
	private String name;
	/**
	 * Phone number of the customer
	 */
	private String phoneNumber;
	/**
	 * Array of booking objects belonging to the customer
	 */
	private ArrayList<Booking> bookingList;

	/**
	 * Create a new customer
	 * Reads from the database using DBController and get an arrayList of booking objects
	 * Store the arrayList of booking objects into bookingList
	 * @param email
	 * @param name
	 * @param phoneNumber
	 */
	public Customer(String email, String name, String phoneNumber) {
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
		try {
			this.bookingList = DBController.readBookingHistory("src/moblima/data/BookingHistoryDB.txt", email);
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}

	/**
	 * Print output information of relevant attributes
	 */
	public void outputBookingHistory() {
		System.out.println("Booking(s) made:\n");
		for (Booking i : bookingList) {
			i.output();
			System.out.println();
		}
	}

	/**
	 * Append new booking object to the bookingList
	 * @param booking
	 */
	public void addBooking(Booking booking) {
		bookingList.add(booking);
	}

	/**
	 * Sets new Name of the customer.
	 *
	 * @param name New value of Name of the customer.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets Phone number of the customer.
	 *
	 * @return Value of Phone number of the customer.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Gets Email of the customer.
	 *
	 * @return Value of Email of the customer.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets new Email of the customer.
	 *
	 * @param email New value of Email of the customer.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets new Array of booking objects belonging to the customer.
	 *
	 * @param bookingList New value of Array of booking objects belonging to the customer.
	 */
	public void setBookingList(ArrayList<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	/**
	 * Sets new Phone number of the customer.
	 *
	 * @param phoneNumber New value of Phone number of the customer.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets Name of the customer.
	 *
	 * @return Value of Name of the customer.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets Array of booking objects belonging to the customer.
	 *
	 * @return Value of Array of booking objects belonging to the customer.
	 */
	public ArrayList<Booking> getBookingList() {
		return bookingList;
	}
}
