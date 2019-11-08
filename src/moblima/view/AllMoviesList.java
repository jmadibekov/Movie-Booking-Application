package moblima.view;

import moblima.controller.*;
import moblima.model.*;
import java.util.ArrayList;

public class AllMoviesList {
	public AllMoviesList() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "--------------All Movies-------------\n"
				+ "=====================================\n"
				+ "(0) Back");

		ArrayList < Movie > curList = BookingController.getAllMovies();
		int ptr = 0;
		for (Movie i : curList) {
			ptr++;
			System.out.printf("(%d) '%s'\n", ptr, i.getTitle());
		}

		StackArg curView = navigation.getLastView();
		while (true) {
			int input = navigation.getChoice("Please select a movie: ");
			if (input == 0) {
				navigation.goBack();
				break;
			} else if (input > 0 && input <= curList.size()) {
				BookingController.setChosenTitle(curList.get(input - 1).getTitle());
				navigation.goTo(new StackArg("chooseCineplex", curView.getUserType(), "movieInformation"));
				break;
			} else {
				System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}	
	
}
