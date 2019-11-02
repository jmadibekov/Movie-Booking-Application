package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.ArrayList;

public class ChooseMovie {
	public ChooseMovie() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "-------Booking: Choose a Movie-------\n"
				+ "=====================================\n\n"
				+ BookingController.getChosenCineplex().getCinemaName()
				+ "\n\n(0) Back");

		//function to get movie based on cineplex chosen

		int gotMovies = 0;
		ArrayList < Movie > movieList = BookingController.getMovies();

		for (Movie i: movieList) {
			if (i.getShowingStatus().contentEquals("NowShowing") || i.getShowingStatus().contentEquals("Preview")) {
				System.out.printf("(%s) %s, Rating: %s, ShowingStatus: %s\n", i.getMovieId(), i.getTitle(), i.getOverallRating(), i.getShowingStatus());

//				System.out.println("("+stack.peek().getBookingCtrl().getMoviesList().get(i).getMovieId()+") "+
//				stack.peek().getBookingCtrl().getMoviesList().get(i).getTitle()+", Rating: "+
//				stack.peek().getBookingCtrl().getMoviesList().get(i).getOverallRating()+", ShowingStatus: "+
//				stack.peek().getBookingCtrl().getMoviesList().get(i).getShowingStatus());

				gotMovies++;
			}
		}

		System.out.print("\n");
		if (gotMovies == 0) {
			System.out.println("No movies are currently showing. Please try another cineplex location");
		}

		StackArg curView = navigation.getLastView();

		while (true) {
			int input = navigation.getChoice("Please select an option: ");
			if (input == 0) {
				navigation.goBack();
				break;
			}

			boolean found = false;
			for (Movie i: movieList) {
				if (Integer.toString(input) == i.getMovieId()
						&& (i.getShowingStatus().contentEquals("NowShowing") || i.getShowingStatus().contentEquals("Preview"))) {
					BookingController.setChosenMovie(i);
					navigation.goTo(new StackArg("chooseShowtime", curView.getUserType()));
					found = true;
					break;
				}
			}

			if (found == true)
				break;

			System.out.println("\nPlease enter a valid input\n");
		}
	}
	
}
