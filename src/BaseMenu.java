package V1;

import java.util.Stack;

public class BaseMenu extends MenuList{
	public BaseMenu() {
		
	}
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "---------Welcome to MOBLIMA!---------\n"
				+ "=====================================\n"
				+ "(1) Admin\n"
				+ "(2) Movie-goer\n"
				+ "(3) Quit");
		while (true) {
			int input = super.getChoice();
			if (input == 1) {
				break;
			}
			else if (input == 2) {
				stackArg.setMenuListVal("moviegoerMenu");
				super.goTo(stackArg, stack);
				break;
			}
			else if (input == 3) {
				super.exit();
				break;
			}
			else {
				System.out.println("\nPlease enter a valid input\n");
			}
		}
	}
}
