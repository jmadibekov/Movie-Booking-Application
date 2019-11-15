package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.ArrayList;

public class Top5Sales extends View{

	public Top5Sales(int userType, View nextView) {
		super("top5Sales", userType, nextView);
	}

	public void display() {

		outputPageName("Top 5 Movies by ticket sales");
		System.out.println("(0) Back\n");

		//function to get top 5 movies
		ArrayList < Movie > movieList = Top5Controller.getTop5MoviesSales();
		int index = 1;
		for (Movie i: movieList) {
			if (i.getShowingStatus().compareTo("End of Showing") != 0) {
				System.out.printf("(%s) '%s', Ticket Sales: %s, Showing Status: %s\n",
						index, i.getTitle(), i.getTicketSales(), i.getShowingStatus());
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
