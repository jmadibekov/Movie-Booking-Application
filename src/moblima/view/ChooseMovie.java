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
				+ "-----------Choose a Movie------------\n"
				+ "=====================================\n\n"
				+ BookingController.getChosenCineplex().getCineplexName()
				+ "\n");

		ArrayList < Movie > movieList = BookingController.getMovies();
		if (movieList.isEmpty()) {
			System.out.println("No movies are currently showing in this cinema. Please try another cineplex\n");
			navigation.goBack();
			return;
		}

		printMovies(curView, movieList);

		while (true) {
			int input = navigation.getChoice("Please select an option: ");
			if (input == 0) {
				navigation.goBack();
				break;
			} else if (input <= movieList.size()) {
				boolean doBreak = doMovie(navigation, curView, movieList.get(input - 1));
				if (doBreak == true)
					break;
				else {
					System.out.println();
					printMovies(curView, movieList);
				}
			} else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}

	private void printMovies(StackArg curView, ArrayList < Movie > movieList) {
		System.out.println("(0) Back");
		int index = 1;
		for (Movie i : movieList) {
			System.out.printf("(%s) '%s', Rating: %s, Showing status: %s\n",
					index, i.getTitle(), i.getOverallRating(), i.getShowingStatus());
			index++;
		}
	}

	private boolean doMovie(Navigation navigation, StackArg curView, Movie curMovie) {
		System.out.printf("\nChosen movie: '%s'\n\n", curMovie.getTitle());

		System.out.println("(0) Back");
		System.out.println("(1) Book this movie");
		System.out.println("(2) Movie information");

		while (true) {
			int input = navigation.getChoice("Please select an option: ");
			if (input == 0) {
				return false;
			} else if (input == 1) {
				String showingStatus = curMovie.getShowingStatus();
				if (!showingStatus.contentEquals("Now Showing") && !showingStatus.contentEquals("Preview")) {
					System.out.println("Sorry, this movie is not showing yet");
				} else {
					BookingController.setChosenMovie(curMovie);
					navigation.goTo(new StackArg("chooseShowtime", curView.getUserType()));
					return true;
				}
			} else if (input == 2) {
				BookingController.setChosenMovie(curMovie);
				ReviewController.setChosenMovie(curMovie);
				navigation.goTo(new StackArg("movieInformation", curView.getUserType()));
				return true;
			} else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
}
