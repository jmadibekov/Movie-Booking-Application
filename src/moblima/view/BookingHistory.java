package moblima.view;

import moblima.controller.*;
import moblima.model.*;

public class BookingHistory {
	
	public BookingHistory() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				"\n=====================================\n"
				+ "-----------Booking History-----------\n"
				+ "=====================================");

		Customer cur = BookingController.getCurCustomer();
		cur.outputBookingHistory();

		System.out.println("(0) Back");
		System.out.println("(1) Back to the main menu");
		while (true) {
			int input = navigation.getChoice("Please select an option: ");
			if (input == 0) {
				navigation.goBack();
				break;
			} else if (input == 1) {
				navigation.goBackMainMenu();
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
}
