package V1;

import java.util.Stack;

public class ChooseCineplex extends Navigation{

	public ChooseCineplex() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		StackArg checkprevious;
		System.out.println("=====================================\n"
				+ "-----Booking: Choose a Cineplex-----\n"
				+ "=====================================\n");

		System.out.println("(0) Back\n"
				+ "(1) Cathay Cineplex\n"
				+ "(2) Shaw Cineplex\n"
				+ "(3) Golden Village Cineplex\n");
		boolean loop = true;
		while (loop) {
			int input = super.getChoice();
			switch (input) {
				case 0: super.goBack(stack);
				break;
				case 1: checkprevious = stack.pop();
				if (stack.peek().getMenuListVal().contentEquals("movieInformation")) {
					stack.push(checkprevious);
					stackArg.setMenuListVal("chooseCinema");
					super.goTo(stackArg, stack);
				}
				else if (stack.peek().getMenuListVal().contentEquals("moviegoerMenu")) {
					stack.push(checkprevious);
					stackArg.setMenuListVal("chooseMovie");
					super.goTo(stackArg, stack);
				}
				loop = false;
				break;
				
				case 2: checkprevious = stack.pop();
				if (stack.peek().getMenuListVal().contentEquals("movieInformation")) {
					stack.push(checkprevious);
					stackArg.setMenuListVal("chooseCinema");
					super.goTo(stackArg, stack);
				}
				else if (stack.peek().getMenuListVal().contentEquals("moviegoerMenu")) {
					stack.push(checkprevious);
					stackArg.setMenuListVal("chooseMovie");
					super.goTo(stackArg, stack);
				}
				loop = false;
				break;
				
				case 3: checkprevious = stack.pop();
				if (stack.peek().getMenuListVal().contentEquals("movieInformation")) {
					stack.push(checkprevious);
					stackArg.setMenuListVal("chooseCinema");
					super.goTo(stackArg, stack);
				}
				else if (stack.peek().getMenuListVal().contentEquals("moviegoerMenu")) {
					stack.push(checkprevious);
					stackArg.setMenuListVal("chooseMovie");
					super.goTo(stackArg, stack);
				}
				loop = false;
				break;
				
				default: System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}
