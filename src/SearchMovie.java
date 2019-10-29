import java.util.Scanner;
import java.util.Stack;

public class SearchMovie extends MoviegoerMenu{

	public SearchMovie() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "------------Search a Movie-----------\n"
				+ "=====================================\n");
		while (true) {
			System.out.print("Please input Movie title (Input 0 to go back): ");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if (input.contentEquals("0")) {
				super.goBack(stack);
				break;
			}
			else if (input.contentEquals("Match")) {
				stackArg.setMenuListVal("movieInformation");
				super.goTo(stackArg, stack);
				break;
			}
			else {
				System.out.println("\nMovie Title not found\n");
			}
			sc.close();
		}
	}
	
}
