package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.ArrayList;

/**
 * Represents the screen that shows top 5 movies by rating
 */
public class Top5Rating extends View{

	/**
	 * Instantiates a new Top 5 rating view
	 *
	 * @param userType the user type
	 * @param nextView the next view
	 */
	public Top5Rating(int userType, View nextView) {
		super("top5Rating", userType, nextView);
	}

	/**
	 * Display the view
	 */
	public void display() {

		outputPageName("Top 5 Movies by Overall Rating");
		System.out.println("(0) Back\n");

		//function to get top 5 movies
		ArrayList < Movie > movieList = Top5Controller.getTop5MoviesRating();
		int index = 0;
		for (Movie i: movieList) {
			if (i.getShowingStatus().compareTo("End of Showing") != 0) {
				System.out.printf("(%s) '%s, Rating: %s, Showing Status: %s\n",
						index + 1, i.getTitle(), i.getOverallRating(), i.getShowingStatus());
				index++;
			}
			if (index == 5)
				break;
		}

		while (true) {
			int input = getChoice("Please select an option: ");
			if (input == 0) {
				Top5Controller.undoTop5Movies();
				Navigation.goBack();
				break;
			}
			if (input < 6) {
				BookingController.setChosenMovie(movieList.get(input-1));
				Top5Controller.undoTop5Movies();
				Navigation.goTo(new MovieInformation(getUserType(), null));
				break;
			} else {
				System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}
