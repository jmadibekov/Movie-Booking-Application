package moblima.view;

import java.util.Scanner;


/**
 * Represents the parent class of all the views
 * Abstract class with abstract methods implemented by its subclasses
 */
public abstract class View {
	/**
	 * the name of the view to be displayed
	 */
	private String viewName;
	/**
	 * the Next view to navigate to after current View
	 */
	private View nextView;
	/**
	 * User type ( -1(Null), 0(Staff), 1(Customer) )
	 */
	private int userType; // -1 = Null, 0 = Admin, 1 = Movie-goer

	/**
	 * Instantiates a new View.
	 *
	 * @param viewName the view's name
	 * @param userType the view's user type
	 * @param nextView the view's next view
	 */
	public View(String viewName, int userType, View nextView) {
		this.viewName = viewName;
		this.userType = userType;
		this.nextView = nextView;
	}

	/**
	 * Display method that should be overwritten by its subclasses
	 */
	public abstract void display();

	/**
	 * Output header of every subclass of view
	 *
	 * @param pageName the name of subclass of view
	 */
	protected void outputPageName(String pageName) {
		// 37 characters
		System.out.println("\n=====================================");

		int left = 37 - pageName.length();
		int a = left / 2;
		int b = left - a;

		for (int i = 0; i < a; i++)
			System.out.print("-");
		System.out.print(pageName);
		for (int i = 0; i < b; i++)
			System.out.print('-');

		System.out.println("\n=====================================\n");
	}

	/**
	 * Gets choice from user and return only if input is an integer
	 *
	 * @param toAsk text to be displayed for user input
	 * @return the user's choice
	 */
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

	/**
	 * Gets input from user and return only if input is a double
	 *
	 * @param toAsk text to be displayed for user input
	 * @return the user's input
	 */
	protected double getDouble(String toAsk) {
		Scanner sc = new Scanner(System.in);
		double input = 0;
		boolean loop = true;
		while (loop) {
			try {
				if (toAsk != null) {
					System.out.print(toAsk);
				}
				double userInput = Double.parseDouble(sc.nextLine());
				input = userInput;
				loop = false;
				return input;
			} catch (NumberFormatException ignore) {
				System.out.println("Invalid input");
			}
		}
		return input;
	}

	/**
	 * Check whether user input is in two decimal places
	 *
	 * @param input value of data type double
	 * @return the user's choice
	 */
	protected boolean checkTwoDecimal(double input){
		String str = String.valueOf(input);
		return str.length() - str.lastIndexOf('.') <= 3;
	}

	/**
	 * Gets view name.
	 *
	 * @return the view name
	 */
	public String getViewName() {
		return viewName;
	}

	/**
	 * Sets view name.
	 *
	 * @param viewName the view name
	 */
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	/**
	 * Gets next view.
	 *
	 * @return the next view
	 */
	public View getNextView() {
		return nextView;
	}

	/**
	 * Sets next view.
	 *
	 * @param nextView the next view
	 */
	public void setNextView(View nextView) {
		this.nextView = nextView;
	}

	/**
	 * Gets user type.
	 *
	 * @return the user type
	 */
	public int getUserType() {
		return userType;
	}

	/**
	 * Sets user type.
	 *
	 * @param userType the user type
	 */
	public void setUserType(int userType) {
		this.userType = userType;
	}
}
