package V1;

import java.util.Stack;

public class ReviewList extends Navigation{
	
	public ReviewList() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "-------------All Reviews-------------\n"
				+ "=====================================\n");
		//function to get booking history
		while (true) {
			System.out.println("(0) Back");
			int input = super.getChoice();
			if (input == 0) {
				super.goBack(stack);
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}
