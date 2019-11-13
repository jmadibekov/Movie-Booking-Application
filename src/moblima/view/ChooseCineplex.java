package moblima.view;

import moblima.controller.BookingController;
import moblima.controller.StaffController;
import moblima.controller.Top5Controller;
import moblima.model.Cineplex;
import moblima.model.StackArg;
import moblima.model.MainModel;

import java.util.ArrayList;

public class ChooseCineplex {

	public ChooseCineplex() {
	}
	
	public void display(Navigation navigation) {
		StackArg curView = navigation.getLastView();

		System.out.println(
				  "=====================================\n"
				+ "------Choose a Cineplex Location-----\n"
				+ "=====================================");

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
			int input = navigation.getChoice("Please select a cineplex: ");
			if (input == 0) {
				navigation.goBack();
				break;
			} else if (input > 0 && input <= curCineplex.size()) {
				BookingController.setChosenCineplex(curCineplex.get(input - 1));
				Top5Controller.setChosenCineplex(curCineplex.get(input - 1));
				//Benedict, Fazli added a line below
				StaffController.setChosenCineplex(curCineplex.get(input - 1));
				navigation.goTo(new StackArg(curView.getGoNextView(), curView.getUserType()));
				break;
			} else {
				System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}
