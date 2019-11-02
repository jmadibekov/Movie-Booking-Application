package moblima.view;

import moblima.model.StackArg;

public class MoviegoerMenu {
	public MoviegoerMenu() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "-----------Movie-goer Menu-----------\n"
				+ "=====================================\n"
				+ "(0) Back\n"
				+ "(1) List all movies\n"
				+ "(2) Search for a movie by title\n"
				+ "(3) Book and purchase ticket\n"
				+ "(4) View booking history\n"
				+ "(5) View top 5 movies by ticket sales\n"
				+ "(6) View top 5 movies by overall reviewers ratings");

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
				 	navigation.goTo(new StackArg("allMoviesList", curView.getUserType()));
				 	loop = false;
				 	break;

				 case 2:
				 	// add stuff
					break;

				 case 3:
					 navigation.goTo(new StackArg("chooseCineplex", curView.getUserType(), "chooseMovie"));
					 loop = false;
					 break;

				 case 5:
					 navigation.goTo(new StackArg("chooseCineplex", curView.getUserType(), "top5Sales"));
					 loop = false;
					 break;

				 case 6:
					navigation.goTo(new StackArg("chooseCineplex", curView.getUserType(), "top5Rating"));
					loop = false;
					break;

				 case 4:
				 	navigation.goTo(new StackArg("emailVerification", curView.getUserType()));
					loop = false;
					break;

				 default:
				 	System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}

