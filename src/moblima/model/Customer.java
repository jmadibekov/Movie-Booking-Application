package moblima.model;

import moblima.controller.DBController;

import java.io.IOException;
import java.util.ArrayList;

public class Customer {
	private String email;
	private String name;
	private String phoneNumber;
	private ArrayList<Booking> bookingList;

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

	public void outputBookingHistory() {
		System.out.println("Booking(s) made:");
		int ptr = 0;
		int len = bookingList.size();
		for (Booking i : bookingList) {
			i.output();
			ptr++;
			if (ptr != len)
				System.out.println();
		}
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<Booking> getBookList() {
		return bookingList;
	}
	public void setBookList(ArrayList<Booking> bookList) {
		this.bookingList = bookList;
	}
	public void addBooking(Booking booking) {
		bookingList.add(booking);
	}
}
