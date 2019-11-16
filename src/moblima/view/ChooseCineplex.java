package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.ArrayList;

/**
 * Represents the screen to choose a cineplex
 */
public class ChooseCineplex extends View {

	/**
	 * Instantiates a new Choose cineplex.
	 *
	 * @param userType the user type
	 * @param nextView the next view
	 */
	public ChooseCineplex(int userType, View nextView) {
		super("chooseCineplex", userType, nextView);
	}

	/**
	 * Display the view
	 */
	public void display() {
		outputPageName("Choose a Cineplex Location");

		System.out.println("(0) Back");

		ArrayList < Cineplex > curCineplex;

		if (BookingController.getChosenTitle() != null) {
			// If movie was chosen already
			curCineplex = new ArrayList < Cineplex > ();
			String chosenTitle = BookingController.getChosenTitle();
			for (Cineplex i : MainModel.getCineplexList()) {
				if (i.hasMovieWithTitle(chosenTitle)) {
					curCineplex.add(i);
				}
			}
		} else {
			curCineplex = MainModel.getCineplexList();
		}

		int ptr = 0;
		for (Cineplex i : curCineplex) {
			ptr++;
			System.out.printf("(%d) '%s'\n", ptr, i.getCineplexName());
		}

		while (true) {
			int input = getChoice("Please select a cineplex: ");
			if (input == 0) {
				Navigation.goBack();
				break;
			} else if (input > 0 && input <= curCineplex.size()) {
				BookingController.setChosenCineplex(curCineplex.get(input - 1));
				Top5Controller.setChosenCineplex(curCineplex.get(input - 1));
				StaffController.setChosenCineplex(curCineplex.get(input - 1));

				Navigation.goTo(getNextView());
				break;
			} else {
				System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}
