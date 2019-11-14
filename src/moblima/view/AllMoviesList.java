package moblima.view;

import moblima.controller.*;

import java.util.ArrayList;

public class AllMoviesList extends View {
	public AllMoviesList(int userType, View nextView) {
		super("allMoviesList", userType, nextView);
	}
	
	public void display() {
		outputPageName("All Movies");

		System.out.println("(0) Back");

		ArrayList < String > curList = BookingController.getAllMovies();
		int ptr = 0;
		for (String i : curList) {
			ptr++;
			System.out.printf("(%d) '%s'\n", ptr, i);
		}

		while (true) {
			int input = getChoice("Please select a movie: ");
			if (input == 0) {
				Navigation.goBack();
				break;
			} else if (input > 0 && input <= curList.size()) {
				BookingController.setChosenTitle(curList.get(input - 1));
				View nextView = new MovieInformation(getUserType(), null);
				Navigation.goTo(new ChooseCineplex(getUserType(), nextView));
				break;
			} else {
				System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}
