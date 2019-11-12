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
				+ "=====================================\n");

		if (BookingController.getChosenTitle() != null) {
			Movie actualMovie = BookingController.getChosenCineplex().getMovieWithTitle(BookingController.getChosenTitle());
			BookingController.setChosenMovie(actualMovie);
			ReviewController.setChosenMovie(actualMovie);
		}

		BookingController.getChosenMovie().output();
		System.out.println();

		System.out.println(
			"(0) Back\n"
		  + "(1) Book movie\n"
		  + "(2) See all reviews\n"
		  + "(3) Leave a review");

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
					if (BookingController.getChosenMovie().getShowingStatus().contentEquals("Coming Soon"))
						System.out.println("Sorry, this movie is not showing yet");
					else if (BookingController.getChosenMovie().getShowingStatus().contentEquals("End of Showing"))
						System.out.println("Sorry, this movie is no longer showing");
					else {
						navigation.goTo(new StackArg("chooseShowtime", curView.getUserType()));
						loop = false;
					}
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
