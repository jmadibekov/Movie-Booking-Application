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

		StackArg curView = navigation.getLastView();
		ArrayList < Movie > curList = BookingController.getAllMovies();
		int ptr = 0;
		for (Movie i : curList) {
			ptr++;
			System.out.printf("(%d) '%s'\n", ptr, i.getTitle());
		}
		
		while (true) {
			int input = navigation.getChoice("Please select an option: ");
			if (input == 0) {
				navigation.goBack();
				break;
			} else if (input > 0 && input <= curList.size()) {
				BookingController.setChosenMovie(curList.get(input - 1));
				navigation.goTo(new StackArg("movieInformation", curView.getUserType()));
				break;
			} else {
				System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}	
	
}
