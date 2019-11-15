package moblima.controller;

import moblima.model.*;
import moblima.view.*;

import java.util.Stack;

/**
 * Static class which controls the stack of views.
 * A stack of navigable views visited by the user in this navigation.
 * Creates the navigation history by initializing an empty stack.
 */
public class Navigation {

	/**
	 * A stack of View instances
	 */
	private static Stack < View > stack = new Stack < View > ();

	/**
	 * A function to display the next menu as the moviegoer navigates
	 * @param goToView attributes of the new View
	 */
    public static void goTo(View goToView) {
    	stack.push(goToView);
    	goToView.display();
    }

	/**
	 * A function to allow moviegoer to go back to the previous menu
	 */
	public static void goBack() {
    	stack.pop();
    	getLastView().display();
    }

	/**
	 * A function to get the View of the previous menu
	 * @return
	 */
	public static View getLastView() {
    	return stack.peek();
	}

	/**
	 * A function to allow moviegoer to go back to the main menu
	 */
    public static void goBackMainMenu() {
    	while (true) {
    		View curView = getLastView();
    		if (curView.getViewName().contentEquals("baseMenu"))
    			break;
    		stack.pop();
    	}
    	getLastView().display();
    }

	/**
	 * Display the main menu
	 * Executed at the start of the program
	 */
	public static void start() {
    	goTo(new BaseMenu(-1, null));
	}

	/**
	 * Exit the program
	 * Save the states of all instances of every classes in the database
	 */
	public static void exit() {
		System.out.println("Thank you for using MOBLIMA. Goodbye!!!");
		MainModel.endProgramWriteBack();
		System.exit(1);
	}
}