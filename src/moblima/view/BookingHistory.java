package moblima.view;

import moblima.model.StackArg;

import java.util.Scanner;

public class BookingHistory {
	
	public BookingHistory() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "-----------Booking History-----------\n"
				+ "=====================================\n"
				+ "(0) Back\n");
		//function to get booking history
		while (true) {
			int input = navigation.getChoice();
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
