import java.util.Stack;

public class ChooseMovie extends Navigation{

	public ChooseMovie() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "-------Booking: Choose a Movie-------\n"
				+ "=====================================\n"
				+ "(0) Back");
		//function to get movie based on cineplex chosen
		
		while (true) {
			int input = super.getChoice();
			if (input == 0) {
				super.goBack(stack);
				break;
			}
			else if (input == 1) {
				stackArg.setMenuListVal("chooseCinema");
				super.goTo(stackArg, stack);
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}
