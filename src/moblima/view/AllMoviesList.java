package moblima.view;

import moblima.controller.BookingController;
import moblima.controller.Navigation;
import moblima.model.StackArg;
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

		ArrayList < String > curList = BookingController.getAllMovies();
		int ptr = 0;
		for (String i : curList) {
			ptr++;
			System.out.printf("(%d) '%s'\n", ptr, i);
		}

		StackArg curView = navigation.getLastView();
		while (true) {
			int input = navigation.getChoice("Please select a movie: ");
			if (input == 0) {
				navigation.goBack();
				break;
			} else if (input > 0 && input <= curList.size()) {
				BookingController.setChosenTitle(curList.get(input - 1));
				navigation.goTo(new StackArg("chooseCineplex", curView.getUserType(), "movieInformation"));
				break;
			} else {
				System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}
