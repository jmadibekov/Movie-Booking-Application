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
				  "=====================================\n"
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

			ArrayList < Customer > cur = MainModel.getCustomerList();
			boolean found = false;
			for (Customer i : cur)
				if (i.getEmail().contentEquals(input)) {
					found = true;
					BookingController.setCurCustomer(i);
					break;
				}

			if (found == true) {
				navigation.goTo(new StackArg("bookingHistory", navigation.getLastView().getUserType()));
				break;
			} else {
				System.out.println("Invalid email address.");
			}
		}
		sc.close();
	}
}
