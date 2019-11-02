package moblima.view;

import moblima.model.StackArg;

import java.util.Scanner;

public class SearchMovie {

	public SearchMovie() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "------------Search a Movie-----------\n"
				+ "=====================================\n");

		while (true) {
			System.out.print("Please input Movie title (Input 0 to go back): ");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if (input.contentEquals("0")) {
				navigation.goBack();
				break;
			}
			else if (input.contentEquals("Match")) {
				navigation.goTo(new StackArg("movieInformation", navigation.getLastView().getUserType()));
				break;
			}
			else {
				System.out.println("\nMovie Title not found\n");
			}
			sc.close();
		}
	}
	
}
