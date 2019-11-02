package moblima.view;

import moblima.model.StackArg;

public class ReviewList {
	
	public ReviewList() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "-------------All Reviews-------------\n"
				+ "=====================================\n");
		//function to get booking history
		while (true) {
			System.out.println("(0) Back");
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
