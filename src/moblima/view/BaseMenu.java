package moblima.view;

import moblima.controller.*;

public class BaseMenu extends View {
	public BaseMenu() {
	}

	public void display() {
		outputPageName("Welcome to MOBLIMA!");

		System.out.println(
				"\n=====================================\n"
						+ "---------Welcome to MOBLIMA!---------\n"
						+ "=====================================\n"
				+ "(1) Admin\n"
				+ "(2) Movie-goer\n"
				+ "(3) Quit");

		View curView = Navigation.getLastView();
		while (true) {
			int input = getChoice("Please select an option: ");
			if (input == 1) {
				Navigation.goTo(new View("chooseCineplex", 0, "loginVerification"));
				break;
			} else if (input == 2) {
				Navigation.goTo(new View("moviegoerMenu", 1));
				break;
			} else if (input == 3) {
				Navigation.exit();
			} else {
				System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}
