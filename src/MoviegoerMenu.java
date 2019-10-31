import java.util.Stack;

public class MoviegoerMenu extends BaseMenu {
	
	public MoviegoerMenu() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		boolean loop = true;
		System.out.println("=====================================\n"
				+ "-----------Movie-goer Menu-----------\n"
				+ "=====================================\n"
				+ "(0) Back\n"
				+ "(1) List all movies\n"
				+ "(2) Search for a movie by title\n"
				+ "(3) Book and purchase ticket\n"
				+ "(4) View booking history\n"
				+ "(5) View Top 5 movies by ticket sales\n"
				+ "(6) View Top 5 movies by overall reviewers� ratings");
		while (loop) {
			int input = super.getChoice();
			switch (input) {
				 case 0: super.goBack(stack);
				 loop = false;
				 break;
				 
				 case 1:
				 case 2:
				 case 3:
				 case 5:
				 case 6: stackArg.setMenuListVal("chooseCineplex");
				 stackArg.setLastInput(input);
				 super.goTo(stackArg, stack);
				 loop = false;
				 break;

				 case 4: stackArg.setMenuListVal("emailVerification");
				 super.goTo(stackArg, stack);
				 loop = false;
				 break;
				 
				 default: System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
}

