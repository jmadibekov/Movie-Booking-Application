package moblima.view;

import moblima.controller.*;

public class MoviegoerMenu extends View {
	public MoviegoerMenu(String menuListVal, int userType, View nextView) {
		super(menuListVal, userType, nextView);
	}

	public void display() {
		outputPageName("Movie-goer Menu");

		System.out.println(
				  "(0) Back\n"
				+ "(1) List all movies\n"
				+ "(2) Search for a movie by title\n"
				+ "(3) Book and purchase ticket\n"
				+ "(4) View booking history\n"
				+ "(5) View top 5 movies by ticket sales\n"
				+ "(6) View top 5 movies by overall reviewers ratings");

//		View curView = Navigation.getLastView();
		boolean loop = true;
		while (loop) {
			int input = getChoice("Please select an option: ");
			switch (input) {
				 case 0:
				 	 Navigation.goBack();
				 	 loop = false;
				 	 break;

//				 case 1:
//				 	 Navigation.goTo(new View("allMoviesList", curView.getUserType()));
//				 	 loop = false;
//				 	 break;
//
//				 case 2:
//					 Navigation.goTo(new View("searchMovie", curView.getUserType()));
//					 loop = false;
//					 break;
//
				 case 3:
				 	 View nextView = new ChooseMovie("chooseMovie", getUserType(), null);
					 Navigation.goTo(new ChooseCineplex("chooseCineplex", getUserType(), nextView));
					 loop = false;
					 break;
//
//				 case 5:
//					 Navigation.goTo(new View("chooseCineplex", curView.getUserType(), "top5Sales"));
//					 loop = false;
//					 break;
//
//				 case 6:
//					 Navigation.goTo(new View("chooseCineplex", curView.getUserType(), "top5Rating"));
//					 loop = false;
//					 break;
//
//				 case 4:
//				 	 Navigation.goTo(new View("emailVerification", curView.getUserType()));
//					 loop = false;
//					 break;

				 default:
				 	System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}

