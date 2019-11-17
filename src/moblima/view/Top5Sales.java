package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.ArrayList;

/**
 * Represents the screen that shows top 5 movies by ticket sales
 */
public class Top5Sales extends View{

	/**
	 * Instantiates a new Top 5 sales view
	 *
	 * @param userType the user type
	 * @param nextView the next view
	 */
	public Top5Sales(int userType, View nextView) {
		super("top5Sales", userType, nextView);
	}

	/**
	 * Display the view
	 */
	public void display() {

		outputPageName("Top 5 Movies by ticket sales");
		System.out.println("(0) Back\n");

		//function to get top 5 movies
		ArrayList < Movie > movieList = Top5Controller.getTop5MoviesSales();
		int index = 0;
		for (Movie i: movieList) {
			if (i.getShowingStatus().compareTo("End of Showing") != 0) {
				System.out.printf("(%s) '%s', Ticket Sales: %s, Showing Status: %s\n",
						index + 1, i.getTitle(), i.getTicketSales(), i.getShowingStatus());
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
				BookingController.setChosenMovie(movieList.get(input));
				Top5Controller.undoTop5Movies();
				Navigation.goTo(new MovieInformation(getUserType(), null));
				break;
			} else {
				System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}
