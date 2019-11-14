package moblima.controller;

import moblima.model.*;
import moblima.view.*;

import java.util.Stack;

public class Navigation {
    /**
     * Static class which controls the stack of views.
	 * A stack of navigable views visited by the user in this navigation.
	 * Creates the navigation history by initializing an empty stack.
     */

    private static Stack < View > stack = new Stack < View > ();

    public static void goTo(View goToView) {
    	stack.push(goToView);
        MenuList.goToNext();
    }

    public static void goBack() {
    	stack.pop();
		MenuList.goToNext();
    }

    public static View getLastView() {
    	return stack.peek();
	}

    public static void goBackMainMenu() {
    	while (true) {
    		View curView = getLastView();
    		if (curView.getMenuListVal().contentEquals("baseMenu"))
    			break;
    		stack.pop();
    	}
		MenuList.goToNext();
    }

    public static void start() {
    	goTo(new View("baseMenu", -1));
	}

	public static void exit() {
		System.out.println("Thank you for using MOBLIMA. Goodbye!!!");
		MainModel.endProgramWriteBack();
		System.exit(1);
	}
}