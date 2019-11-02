package moblima.view;

import moblima.model.*;

import java.util.Scanner;
import java.util.Stack;

public class Navigation {
    /**
     * A stack of navigable views visited by the user in this navigation.
	 * Creates the navigation history by initializing an empty stack.
     */

    private Stack < StackArg > stack;

    public Navigation() {
        stack = new Stack < StackArg > ();
    }

    protected int getChoice(String toAsk) {
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	boolean loop = true;
    	while (loop) {
    		try {
    			if (toAsk != null) {
					System.out.print(toAsk);
				}
    			int input = Integer.parseInt(sc.nextLine());
	    	    choice = input;
	    	    loop = false;
	    	    return choice;
	    	} catch (NumberFormatException ex) {
	    		System.out.println("The number entered is not an integer!");
	    	}
    	}
    	return choice;
    }

    protected void goTo(StackArg goToView) {
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

    protected void goBackMainMenu() {
    	while (!this.getLastView().getMenuListVal().contentEquals("baseMenu")) {
    		stack.pop();
    	}
		MenuList.goToNext(this);
    }

    public void start() {
    	this.goTo(new StackArg());
	}

	public void exit() {
		System.out.println("Thank you for using MOBLIMA. Goodbye!!!");
		System.exit(1);
	}
}
