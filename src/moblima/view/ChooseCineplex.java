package moblima.view;

import moblima.controller.*;
import moblima.model.*;

public class ChooseCineplex {

	public ChooseCineplex() {
	}
	
	public void display(Navigation navigation) {
		StackArg curView = navigation.getLastView();

		System.out.println(
				  "=====================================\n"
				+ "-Booking: Choose a Cineplex Location-\n"
				+ "=====================================");

		System.out.println(
				  "(0) Back\n"
				+ "(1) JurongPoint Cineplex\n"
				+ "(2) PayaLebar Cineplex\n"
				+ "(3) VivoCity Cineplex\n");

		boolean loop = true;
		while (loop) {
			int input = navigation.getChoice("Please select an option: ");
			switch (input) {
				case 0:
					navigation.goBack();
					loop = false;
					break;
				case 1:
				case 2:
				case 3:
					BookingController.setChosenCineplex(MainModel.getCineplexList().get(input - 1));
					Top5Controller.setChosenCineplex(MainModel.getCineplexList().get(input - 1));
					navigation.goTo(new StackArg(curView.getGoNextView(), curView.getUserType()));
					loop = false;
					break;
				default:
					System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}
