package moblima.view;

import moblima.controller.*;

public class BaseMenu extends View {
	public BaseMenu(int userType, View nextView) {
		super("baseMenu", userType, nextView);
	}

	public void display() {
		outputPageName("Welcome to MOBLIMA!");

		System.out.println(
				  "(1) Admin\n"
				+ "(2) Movie-goer\n"
				+ "(3) Quit");

		while (true) {
			int input = getChoice("Please select an option: ");
			if (input == 1) {
				View nextView = new LoginVerification(getUserType(), null);
				Navigation.goTo(new ChooseCineplex(0, nextView));
				break;
			} else if (input == 2) {
				Navigation.goTo(new MoviegoerMenu(1, null));
				break;
			} else if (input == 3) {
				Navigation.exit();
			} else {
				System.out.println("\nPlease enter a valid input!\n");
			}
		}
	}
}
