package V1;

import java.util.Stack;

public class ChooseShowtime extends Navigation{

	public ChooseShowtime() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "------Booking: Choose a Showtime-----\n"
				+ "=====================================\n"
				+ "(0) Back\n"
				+ "(99) Go back to main menu\n");
		//function to get showtimes based on cineplex and movie and cinema chosen
		
		while (true) {
			int input = super.getChoice();
			if (input == 0) {
				super.goBack(stack);
				break;
			}
			else if (input == 99) {
				super.goBackMainMenu(stack);
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}
