import java.util.Stack;

public class MovieInformation extends AllMoviesList {

	public MovieInformation() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		boolean loop = true;
		System.out.println("=====================================\n"
				+ "----------Movie Information----------\n"
				+ "=====================================\n");
		//function to get movie information
		
		// only if movie is now showing
		System.out.println("(0) Back\n"
				+ "(1) Book movie\n"
				+ "(2) See all reviews\n"
				+ "(3) Leave a review\n");
		while (loop) {
			int input = super.getChoice();
			switch (input) {
				case 0: super.goBack(stack);
				loop = false;
				break;
				case 1: stackArg.setMenuListVal("chooseCineplex");
				super.goTo(stackArg, stack);
				loop = false;
				break;
				case 2: stackArg.setMenuListVal("reviewList");
				super.goTo(stackArg, stack);
				loop = false;
				break;
				case 3: stackArg.setMenuListVal("leaveReview");
				super.goTo(stackArg, stack);
				loop = false;
				break;
				default: System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}
