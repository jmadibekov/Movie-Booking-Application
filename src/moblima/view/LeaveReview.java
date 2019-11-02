package moblima.view;

import moblima.model.StackArg;
import java.util.Scanner;

public class LeaveReview {
	public LeaveReview() {
	}
	
	public void display(Navigation navigation) {
		StackArg curView = navigation.getLastView();
		System.out.println(
				  "=====================================\n"
				+ "------------Leave a Review-----------\n"
				+ "=====================================\n");
		while (true) {
			System.out.print("Please enter your name (Input 0 to go back): ");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if (input.contentEquals("0")) {
				navigation.goBack();
				break;
			}

			else {
				System.out.print("Please enter your review (Input 0 to go back): ");
				input = sc.nextLine();
				sc.close();
				if (input.contentEquals("0")) {
					continue;
				}
				else {
					System.out.println("\nReview submitted successfully\n");
					navigation.goBack();
					break;
				}
			}
		}
	}
	
}
