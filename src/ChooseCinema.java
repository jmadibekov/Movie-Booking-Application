import java.util.Stack;

public class ChooseCinema extends Navigation{

	public ChooseCinema() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "-------Booking: Choose a Cinema------\n"
				+ "=====================================\n"
				+ "(0) Back\n");
		//function to get cinema showtimes based on cineplex and movie chosen
		
		while (true) {
			int input = super.getChoice();
			if (input == 0) {
				super.goBack(stack);
				break;
			}
			else if (input == 1) {
				stackArg.setMenuListVal("chooseShowtime");
				super.goTo(stackArg, stack);
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}