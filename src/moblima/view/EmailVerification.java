package moblima.view;

import moblima.controller.BookingController;
import moblima.controller.Navigation;
import moblima.model.*;

import java.util.Scanner;

/**
 * Represents the screen to verify email of a customer
 */
public class EmailVerification extends View{

	/**
	 * Instantiates a new Email verification view
	 *
	 * @param userType the user type
	 * @param nextView the next view
	 */
	public EmailVerification(int userType, View nextView) {
		super("emailVerification", userType, nextView);
	}

	/**
	 * Display the view
	 */
	public void display() {
		outputPageName("Email Verification");

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Please input your email address (Input 0 to go back): ");
			String input = sc.next();
			sc.nextLine();
			if (input.contentEquals("0")) {
				Navigation.goBack();
				break;
			}

			Customer customer = MainModel.customerWithEmail(input);
			if (customer != null) {
				BookingController.setCurCustomer(customer);
				Navigation.goTo(new BookingHistory(getUserType(), null));
				break;
			} else {
				System.out.println("Invalid email address.");
			}
		}
		sc.close();
	}
}
