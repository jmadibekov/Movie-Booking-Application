package moblima.view;

import java.util.Scanner;
import java.util.Stack;
import moblima.model.StackArg;

public class Navigation {
    /**
     * A stack of navigable views visited by the user in this navigation.
	 * Creates the navigation history by initializing an empty stack.
     */

    private Stack < StackArg > stack;

    public Navigation() {
        stack = new Stack < StackArg > ();
    }

    private void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    
    protected int getChoice() {
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	boolean loop = true;
    	while (loop) {
    		try {
    			System.out.print("Please select an option: ");
    			int input = Integer.parseInt(sc.nextLine());
	    	    choice = input;
	    	    loop = false;
	    	    return choice;
	    	} catch (NumberFormatException ex) {
	    		System.out.println("Number entered is not an integer!");
	    	}
    	}
    	return choice;
    }

	protected int getIntInput() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		boolean loop = true;
		while (loop) {
			try
			{
				int input = Integer.parseInt(sc.nextLine());
				choice = input;
				loop = false;
				return choice;
			}
			catch (NumberFormatException ex)
			{
				System.out.println("Number entered is not an integer");
			}
		}
		return choice;
	}

    public void exit() {
        System.out.println("Thank you for using MOBLIMA. Goodbye!!!");
        System.exit(1); 
	}
    
    public void goTo(StackArg goToView) {
		stack.push(goToView);
        MenuList.goToNext(this);
    }

    protected void goBack() {
    	stack.pop();
		MenuList.goToNext(this);
    }

    protected StackArg getLastView() {
    	return stack.peek();
	}

	protected StackArg getPrevView() {
    	StackArg last = stack.pop();
    	StackArg prev = stack.peek();
    	stack.push(last);
    	return prev;
	}
    
    protected void goBackMainMenu() {
    	while (!stack.peek().getMenuListVal().contentEquals("baseMenu")) {
    		stack.pop();
    	}
		MenuList.goToNext(this);
    }
}
