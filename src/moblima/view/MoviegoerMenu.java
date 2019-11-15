package moblima.view;

import moblima.controller.*;

public class MoviegoerMenu extends View {
	public MoviegoerMenu(int userType, View nextView) {
		super("moviegoerMenu", userType, nextView);
	}

	public void display() {
		outputPageName("Movie-goer Menu");

		BookingController.setChosenTitle(null);
		BookingController.setChosenMovie(null);
		BookingController.setChosenCineplex(null);

		System.out.println(
				  "(0) Back\n"
				+ "(1) List all movies\n"
				+ "(2) Search for a movie by title\n"
				+ "(3) Book and purchase ticket\n"
				+ "(4) View booking history\n"
				+ "(5) View top 5 movies by ticket sales\n"
				+ "(6) View top 5 movies by overall reviewers ratings");

		boolean loop = true;
		while (loop) {
			int input = getChoice("Please select an option: ");
			switch (input) {
				 case 0:
				 	 Navigation.goBack();
				 	 loop = false;
				 	 break;

				 case 1:
				 	 Navigation.goTo(new AllMoviesList(getUserType(), null));
				 	 loop = false;
				 	 break;

				 case 2:
					 Navigation.goTo(new SearchMovie(getUserType(), null));
					 loop = false;
					 break;

				 case 3:
				 	 View nextViewChooseMovie = new ChooseMovie(getUserType(), null);
					 Navigation.goTo(new ChooseCineplex(getUserType(), nextViewChooseMovie));
					 loop = false;
					 break;

				 case 5:
				 	 View nextViewTop5Sales = new Top5Sales(getUserType(), null);
					 Navigation.goTo(new ChooseCineplex(getUserType(), nextViewTop5Sales));
					 loop = false;
					 break;

				 case 6:
					 View nextViewTop5Rating = new Top5Rating(getUserType(), null);
					 Navigation.goTo(new ChooseCineplex(getUserType(), nextViewTop5Rating));
					 loop = false;
					 break;

				 case 4:
				 	 Navigation.goTo(new EmailVerification(getUserType(), null));
					 loop = false;
					 break;

				 default:
				 	System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}

