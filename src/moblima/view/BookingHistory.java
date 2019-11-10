package moblima.view;

import moblima.controller.*;
import moblima.model.*;

public class BookingHistory {
	
	public BookingHistory() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "-----------Booking History-----------\n"
				+ "=====================================");

		Customer cur = BookingController.getCurCustomer();
		cur.outputBookingHistory();

		System.out.println("(0) Back");
		while (true) {
			int input = navigation.getChoice("Please select an option: ");
			if (input == 0) {
				navigation.goBack();
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}
