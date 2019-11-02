package moblima.view;

import moblima.model.StackArg;

public class Top5Sales {

	public Top5Sales() {
		
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "-----Top 5 Movies by ticket sales----\n"
				+ "=====================================\n"
				+ "(0) Back\n");
		//function to get top 5 movies
		int input = navigation.getChoice("Please select an option: ");

		while (true) {
			if (input == 0) {
				navigation.goBack();
				break;
			}
			else if (input == 1) {
				navigation.goTo(new StackArg("movieInformation", navigation.getLastView().getUserType()));
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}
