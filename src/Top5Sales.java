import java.util.Stack;

public class Top5Sales extends MoviegoerMenu {

	public Top5Sales() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "-----Top 5 Movies by ticket sales----\n"
				+ "=====================================\n"
				+ "(0) Back\n");
		//function to get top 5 movies
		int input = super.getChoice();
		while (true) {
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
