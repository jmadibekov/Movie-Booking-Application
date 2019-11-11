package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.ArrayList;

public class Top5Sales {

	public Top5Sales() {

	}

	public void display(Navigation navigation) {
		System.out.println(
				"=====================================\n"
						+ "-----Top 5 Movies by ticket sales----\n"
						+ "=====================================\n"
						+ "(0) Back\n");
		//function to get top 5 movies
		ArrayList < Movie > movieList = Top5Controller.getTop5MoviesSales();
		int index = 1;
		for (Movie i: movieList) {
			if (i.getShowingStatus().compareTo("End of Showing") != 0) {
				System.out.printf("(%s) %s, TicketSales: %s, ShowingStatus: %s\n",
						index, i.getTitle(), i.getTicketSales(), i.getShowingStatus());
				index++;
			}
			if (index == 5)
				break;
		}

		StackArg curView = navigation.getLastView();

		while (true) {
			int input = navigation.getChoice("Please select an option: ");
			if (input == 0) {
				Top5Controller.undoTop5Movies();
				navigation.goBack();
				break;
			}
			if (input < 6) {
				BookingController.setChosenMovie(movieList.get(input-1));
				Top5Controller.undoTop5Movies();
				navigation.goTo(new StackArg("movieInformation", curView.getUserType()));
				break;
			} else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
}
