import java.util.Stack;

public class BookingHistory extends EmailVerification{
	
	public BookingHistory() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "-----------Booking History-----------\n"
				+ "=====================================\n"
				+ "(0) Back\n");
		//function to get booking history
		while (true) {
			int input = super.getChoice();
			if (input == 0) {
				super.goBack(stack);
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
	
}
