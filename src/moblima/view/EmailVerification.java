package moblima.view;

import moblima.model.StackArg;

import java.util.Scanner;

public class EmailVerification {
	
	public EmailVerification() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "----------Email Verification---------\n"
				+ "=====================================\n");
		while (true) {
			System.out.print("Please input your email address (Input 0 to go back): ");
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			sc.nextLine();
			if (input.contentEquals("0")) {
				navigation.goBack();
				break;
			}
			else if (input.contentEquals("checkdatabase.returntrue")) {
				navigation.goTo(new StackArg("bookingHistory", navigation.getLastView().getUserType()));
				break;
			}
			else {
				System.out.println("Invalid email address");
			}
			sc.close();
		}
	}
	
}
