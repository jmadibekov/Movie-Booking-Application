import java.util.Stack;

public class AllMoviesList extends MoviegoerMenu {
	
	public AllMoviesList() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "--------------All Movies-------------\n"
				+ "=====================================\n"
				+ "(0) Back\n");
		//function to list down all movies
		
		while (true) {
			int input = super.getChoice();
			if (input == 0) {
				super.goBack(stack);
				break;
			}
			else if (input == 1) {
				stackArg.setMenuListVal("movieInformation");
				super.goTo(stackArg, stack);
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}	
	
}
