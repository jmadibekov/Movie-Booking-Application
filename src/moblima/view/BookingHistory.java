package moblima.view;

import moblima.controller.BookingController;
import moblima.controller.Navigation;
import moblima.model.Customer;

public class BookingHistory extends View{

	public BookingHistory(int userType, View nextView) {
		super("bookingHistory", userType, nextView);
	}
	
	public void display() {
		outputPageName("Booking History");
		System.out.println();

		Customer cur = BookingController.getCurCustomer();
		cur.outputBookingHistory();

		System.out.println("(0) Back");
		System.out.println("(1) Back to the main menu");
		while (true) {
			int input = getChoice("Please select an option: ");
			if (input == 0) {
				Navigation.goBack();
				break;
			} else if (input == 1) {
				Navigation.goBackMainMenu();
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
}
