package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ChooseMovie {
	public ChooseMovie() {
	}
	
	public void display(Navigation navigation) {
		StackArg curView = navigation.getLastView();
		System.out.println(
				  "=====================================\n"
				+ "-------Booking: Choose a Movie-------\n"
				+ "=====================================\n\n"
				+ BookingController.getChosenCineplex().getCinemaName()
				+ "\n\n(0) Back");

		//function to get movie based on cineplex chosen

		int gotMovies = 0;
		int index = 1;
		ArrayList < Movie > movieList = BookingController.getMovies();
		HashMap<Integer, Movie> uniqueMovies = new HashMap<Integer, Movie>();
		for (Movie i: movieList) {
			if (curView.getUserType() == 1) {
				if (i.getShowingStatus().contentEquals("NowShowing") || i.getShowingStatus().contentEquals("Preview")) {
					System.out.printf("(%s) %s, Rating: %s, ShowingStatus: %s\n",
							index, i.getTitle(), i.getOverallRating(), i.getShowingStatus());
					uniqueMovies.put(index, i);
					gotMovies++;
					index++;
				}
			}
			else {
				System.out.printf("(%s) %s, Rating: %s, ShowingStatus: %s\n",
						index, i.getTitle(), i.getOverallRating(), i.getShowingStatus());
				uniqueMovies.put(index,i);
				gotMovies++;
				index++;
			}
		}

		System.out.print("\n");
		if (gotMovies == 0) {
			System.out.println("No movies are currently showing. Please try another cineplex\n");
			navigation.goBack();
		}

		while (true) {
			int input = navigation.getChoice("Please select an option: ");
			boolean found = false;
			if (input == 0) {
				navigation.goBack();
				break;
			}
			else if (input <= uniqueMovies.size()) {
				if (curView.getUserType() == 1) {
					BookingController.setChosenMovie(uniqueMovies.get(input));
					navigation.goTo(new StackArg("chooseShowtime", curView.getUserType()));
					found = true;
				} else {
					BookingController.setChosenMovie(uniqueMovies.get(input));
					break;
				}
			}
			if (found)
				break;
			System.out.println("\nPlease enter a valid input\n");
		}
	}
}
