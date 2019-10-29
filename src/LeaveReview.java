import java.util.Scanner;
import java.util.Stack;

public class LeaveReview extends MovieInformation {

	public LeaveReview() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "------------Leave a Review-----------\n"
				+ "=====================================\n");
		while (true) {
			System.out.print("Please enter your name (Input 0 to go back): ");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if (input.contentEquals("0")) {
				super.goBack(stack);
				break;
			}
			else {
				System.out.print("Please enter your review (Input 0 to go back): ");
				input = sc.nextLine();
				sc.close();
				if (input.contentEquals("0")) {
					continue;
				}
				else {
					System.out.println("\nReview submitted successfully\n");
					super.goBack(stack);
					break;
				}
			}
		}
	}
	
}
