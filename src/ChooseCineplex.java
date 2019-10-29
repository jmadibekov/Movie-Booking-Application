import java.util.Stack;

public class ChooseCineplex extends MovieInformation{

	public ChooseCineplex() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		StackArg checkprevious;
		System.out.println("=====================================\n"
				+ "-Booking: Choose a Cineplex Location-\n"
				+ "=====================================\n");

		System.out.println("(0) Back\n"
				+ "(1) JurongPoint Cineplex\n"
				+ "(2) PayaLebar Cineplex\n"
				+ "(3) VivoCity Cineplex\n");
		boolean loop = true;
		while (loop) {
			int input = super.getChoice();
			switch (input) {
				case 0: super.goBack(stack);
				break;
				case 1: checkprevious = stack.pop();
				stackArg.getBookingCtrl().setCinema(Navigation.model.getCinemaList().get(input-1));
				if (stack.peek().getMenuListVal().contentEquals("movieInformation")) {
					stack.push(checkprevious);
					stackArg.setMenuListVal("chooseShowtime");
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
				stackArg.getBookingCtrl().setCinema(Navigation.model.getCinemaList().get(input-1));
				if (stack.peek().getMenuListVal().contentEquals("movieInformation")) {
					stack.push(checkprevious);
					stackArg.setMenuListVal("chooseShowtime");
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
				stackArg.getBookingCtrl().setCinema(Navigation.model.getCinemaList().get(input-1));
				if (stack.peek().getMenuListVal().contentEquals("movieInformation")) {
					stack.push(checkprevious);
					stackArg.setMenuListVal("chooseShowtime");
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
