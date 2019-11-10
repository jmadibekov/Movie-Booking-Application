package moblima.view;

import moblima.controller.ReviewController;
import moblima.model.StackArg;
import moblima.model.Review;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LeaveReview {

	private String name;
	private String title;
	private String body;
	private double rating;

	public LeaveReview() {
	}
	
	public void display(Navigation navigation) {
		StackArg curView = navigation.getLastView();
		System.out.println(
				  "=====================================\n"
				+ "------------Leave a Review-----------\n"
				+ "=====================================\n");
		getName(navigation);
	}

	private void getName(Navigation navigation) {
		System.out.print("Please enter your name (Input 0 to go back): ");
		Scanner sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		if (inputName.contentEquals("0")) {
			navigation.goBack();
		}
		else {
			name = inputName;
			getSubjectTitle(navigation);
		}
	}

	private void getSubjectTitle(Navigation navigation) {
		System.out.print("Please enter the subject title of your review (Input 0 to go back): ");
		Scanner sc = new Scanner(System.in);
		String inputTitle = sc.nextLine();
		if (inputTitle.contentEquals("0")) {
			getName(navigation);
		}
		else {
			title = inputTitle;
			getRating(navigation);
		}
	}

	private void getRating(Navigation navigation) {
		Scanner sc = new Scanner(System.in);
		double inputRating = navigation.getDouble("Please enter your desired rating (1.00 - 5.00): ");
		if (inputRating == 0) {
			getSubjectTitle(navigation);
		}
		else if (inputRating < 1 || inputRating > 5) {
			System.out.println("Please input a number between 1.00 to 5.00");
			getRating(navigation);
		}
		else if (checkOneDecimal(inputRating)) {
			rating = inputRating;
			getSubjectBody(navigation);
		}
		else {
			System.out.println("Please input a number with only two decimal place");
			getRating(navigation);
		}
	}

	private void getSubjectBody(Navigation navigation) {
		System.out.print("Please enter the details of your review (Input 0 to go back): ");
		Scanner sc = new Scanner(System.in);
		String inputBody = sc.nextLine();
		if (inputBody.contentEquals("0")) {
			getRating(navigation);
		}
		else {
			body = inputBody;
			getConfirmation(navigation);
		}
	}

	private void getConfirmation (Navigation navigation) {
		Scanner sc = new Scanner(System.in);
		int input = navigation.getChoice("Input 1 to confirm (0 - to go back): ");
		if (input == 0) {
			getSubjectBody(navigation);
		}
		else if (input == 1) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date todayDate = new Date();
			String date = sdf.format(todayDate);
			Review review = new Review(name, title, body, date, rating);
			ReviewController.getChosenMovie().addReview(review);
			ReviewController.setAvgRating(rating);
			navigation.goBack();
		}
		else {
			System.out.println("\nPlease enter a valid input\n");
		}
	}

	private boolean checkOneDecimal(double rating){
		String str = String.valueOf(rating);
		if(str.length() - str.lastIndexOf('.')>3){
			return false;
		}
		else
			return true;
	}

}
