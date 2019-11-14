package moblima.view;

import java.util.Scanner;

public abstract class View {
	private String viewName;
	private View nextView;
	private int userType; // -1 = Null, 0 = Admin, 1 = Movie-goer

	public View(String viewName, int userType, View nextView) {
		this.viewName = viewName;
		this.userType = userType;
		this.nextView = nextView;
	}

	/**
	 * Display method that should be overwritten by its subclasses
	*/
	public abstract void display();

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

	protected double getDouble(String toAsk) {
		Scanner sc = new Scanner(System.in);
		double choice = 0;
		boolean loop = true;
		while (loop) {
			try {
				if (toAsk != null) {
					System.out.print(toAsk);
				}
				double input = Double.parseDouble(sc.nextLine());
				choice = input;
				loop = false;
				return choice;
			} catch (NumberFormatException ignore) {
				System.out.println("Invalid input");
			}
		}
		return choice;
	}

	protected boolean checkTwoDecimal(double rating){
		String str = String.valueOf(rating);
		return str.length() - str.lastIndexOf('.') <= 3;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public View getNextView() {
		return nextView;
	}

	public void setNextView(View nextView) {
		this.nextView = nextView;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
}
