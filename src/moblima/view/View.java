package moblima.view;

import java.util.Scanner;

public class View {
	private String menuListVal;
	private String goNextView;
	private int userType; // -1 = Null, 0 = Admin, 1 = Movie-goer

	public View() {}

	public View(String menuListVal, int userType) {
		this.menuListVal = menuListVal;
		this.userType = userType;
		this.goNextView = null;
	}

	public View(String menuListVal, int userType, String goNextView) {
		this.menuListVal = menuListVal;
		this.userType = userType;
		this.goNextView = goNextView;
	}

	/**
	 * Display method that should be overwritten by its subclasses
	*/
	protected void display() {}

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
	
	public void setMenuListVal(String menuListVal) {
		this.menuListVal = menuListVal;
	}

	public String getMenuListVal() { return menuListVal; }

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getUserType() {
		return userType;
	}

	public String getGoNextView() {
		return goNextView;
	}

	public void setGoNextView(String goNextView) {
		this.goNextView = goNextView;
	}
}
