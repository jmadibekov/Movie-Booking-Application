package moblima.view;

import moblima.controller.*;
import moblima.model.*;

public class MovieInformation {

	public MovieInformation() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "----------Movie Information----------\n"
				+ "=====================================");

		if (BookingController.getChosenMovie() == null) {
			Movie actualMovie = BookingController.getChosenCineplex().getMovieWithTitle(BookingController.getChosenTitle());
			BookingController.setChosenMovie(actualMovie);
		}

		BookingController.getChosenMovie().output();

		if (BookingController.getChosenMovie().getShowingStatus() == "Now Showing") {
			System.out.println(
				"(0) Back\n"
			  + "(1) Book movie\n"
			  + "(2) See all reviews\n"
			  + "(3) Leave a review\n");

			StackArg curView = navigation.getLastView();
			boolean loop = true;
			while (loop) {
				int input = navigation.getChoice("Please select an option: ");
				switch (input) {
					case 0:
						navigation.goBack();
						loop = false;
						break;

					case 1:
						navigation.goTo(new StackArg("chooseCineplex", curView.getUserType()));
						loop = false;
						break;

					case 2:
						navigation.goTo(new StackArg("reviewList", curView.getUserType()));
						loop = false;
						break;

					case 3:
						navigation.goTo(new StackArg("leaveReview", curView.getUserType()));
						loop = false;
						break;

					default:
						System.out.println("\nPlease enter a valid input\n");
				}
			}
		}
	}
}
