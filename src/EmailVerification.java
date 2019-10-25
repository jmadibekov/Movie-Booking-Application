import java.util.Scanner;
import java.util.Stack;

public class EmailVerification extends Navigation{
	
	public EmailVerification() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "----------Email Verification---------\n"
				+ "=====================================\n");
		while (true) {
			System.out.print("Please input your email address (Input 0 to go back): ");
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			sc.nextLine();
			if (input.contentEquals("0")) {
				super.goBack(stack);
				break;
			}
			else if (input.contentEquals("checkdatabase.returntrue")) {
				stackArg.setMenuListVal("bookingHistory");
				super.goTo(stackArg, stack);
				break;
			}
			else {
				System.out.println("Invalid email address");
			}
			sc.close();
		}
	}
	
}
