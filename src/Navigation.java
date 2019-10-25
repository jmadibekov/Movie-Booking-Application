package V1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Navigation extends StackArg{

    /**
     * A stack of navigable views visited by the user in this navigation.
     */
    
	protected Stack<StackArg> stack;

    /**
     * Creates the navigation history by initializing an empty stack.
     */
    public Navigation() {
    	StackArg stackArg = new StackArg();
        stack = new Stack<StackArg>();
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
    		try
	    	{
    			System.out.print("Please select an option: ");
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
    
    protected void exit() {
        System.out.println("Thank you for using MOBLIMA. Goodbye!!!");
        System.exit(1); 
	}
    
    public void goTo(StackArg stackArg, Stack<StackArg> stackstore) {
    	//clearScreen();
    	stack = stackstore;
    	stack.push(stackArg);
        MenuList.gotoNavigation(stack);
    }

    public void goBack(Stack<StackArg> stackstore) {
    	//clearScreen();
    	stack = stackstore;
    	System.out.println(stack.peek().getMenuListVal());
    	stack.pop();
    	System.out.println(stack.peek().getMenuListVal());
    	MenuList.gotoNavigation(stack);
    }
    
    public void goBackMainMenu(Stack<StackArg> stackstore) {
    	stack = stackstore;
    	while (!stack.peek().getMenuListVal().contentEquals("baseMenu")) {
    		stack.pop();
    	}
    	MenuList.gotoNavigation(stack);
    }
}
