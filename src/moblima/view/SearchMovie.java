package moblima.view;

import moblima.controller.BookingController;
import moblima.controller.Navigation;
import moblima.model.Cineplex;
import moblima.model.MainModel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the screen to search for any movie by title
 */
public class SearchMovie extends View{

	/**
	 * Instantiates a new Search movie view
	 *
	 * @param userType the user type
	 * @param nextView the next view
	 */
	public SearchMovie(int userType, View nextView) {
		super("searchMovie", userType, nextView);
	}

	/**
	 * Display the view
	 */
	public void display() {

		outputPageName("Search a Movie");

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Please input a movie title (Input 0 to go back): ");
			String input = sc.nextLine();
			if (input.contentEquals("0")) {
				Navigation.goBack();
				break;
			}

			boolean found = false;
			ArrayList < Cineplex > cur = MainModel.getCineplexList();
			for (Cineplex i : cur)
				if (i.hasMovieWithTitle(input))
					found = true;

			if (found) {
				BookingController.setChosenTitle(input);
				View nextView = new MovieInformation(getUserType(), null);
				Navigation.goTo(new ChooseCineplex(getUserType(), nextView));
				break;
			} else {
				System.out.println("\nMovie title was not found\n");
			}
		}
		sc.close();
	}
	
}
