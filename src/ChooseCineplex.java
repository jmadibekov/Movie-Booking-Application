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
				case 1:
				case 2:
				case 3: if (stack.peek().getLastInput() == 1) {
					stackArg.getBookingCtrl().setCineplex(Navigation.model.getCineplexList().get(input-1));
					stackArg.setMenuListVal("allMoviesList");
					super.goTo(stackArg, stack);
				}
				else if (stack.peek().getLastInput() == 2) {
					stackArg.getBookingCtrl().setCineplex(Navigation.model.getCineplexList().get(input-1));
					stackArg.setMenuListVal("searchMovie");
					super.goTo(stackArg, stack);
				}
				else if (stack.peek().getLastInput() == 3) {
					stackArg.getBookingCtrl().setCineplex(Navigation.model.getCineplexList().get(input-1));
					stackArg.setMenuListVal("chooseMovie");
					super.goTo(stackArg, stack);
				}
				else if (stack.peek().getLastInput() == 5) {
					stackArg.setMenuListVal("top5Sales");
					super.goTo(stackArg, stack);
				}
				else if (stack.peek().getLastInput() == 6) {
					stackArg.setMenuListVal("top5Rating");
					super.goTo(stackArg, stack);
				}
				loop = false;
				break;
				
				default: System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}
