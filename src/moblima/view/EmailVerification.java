package moblima.view;

import moblima.controller.BookingController;
import moblima.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class EmailVerification {
	
	public EmailVerification() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				"\n=====================================\n"
				+ "----------Email Verification---------\n"
				+ "=====================================");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Please input your email address (Input 0 to go back): ");
			String input = sc.next();
			sc.nextLine();
			if (input.contentEquals("0")) {
				navigation.goBack();
				break;
			}

			Customer customer = MainModel.customerWithEmail(input);
			if (customer != null) {
				BookingController.setCurCustomer(customer);
				navigation.goTo(new StackArg("bookingHistory", navigation.getLastView().getUserType()));
				break;
			} else {
				System.out.println("Invalid email address.");
			}
		}
		sc.close();
	}
}
