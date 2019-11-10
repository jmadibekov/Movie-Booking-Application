package moblima.view;

import moblima.controller.BookingController;
import moblima.model.Cineplex;
import moblima.model.MainModel;
import moblima.model.StackArg;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchMovie {

	public SearchMovie() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "------------Search a Movie-----------\n"
				+ "=====================================");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Please input a movie title (Input 0 to go back): ");
			String input = sc.nextLine();
			if (input.contentEquals("0")) {
				navigation.goBack();
				break;
			}

			boolean found = false;
			ArrayList < Cineplex > cur = MainModel.getCineplexList();
			for (Cineplex i : cur)
				if (i.hasMovieWithTitle(input) == true)
					found = true;

			if (found == true) {
				BookingController.setChosenTitle(input);
				navigation.goTo(new StackArg("chooseCineplex", navigation.getLastView().getUserType(), "movieInformation"));
				break;
			} else {
				System.out.println("\nMovie title was not found\n");
			}
		}
		sc.close();
	}
	
}
