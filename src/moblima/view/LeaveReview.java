package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.ReviewController;
import moblima.model.Review;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Represents the screen to leave a review on a movie
 */
public class LeaveReview extends View{

	/**
	 * Instantiates a new Leave Review view
	 *
	 * @param userType the user type
	 * @param nextView the next view
	 */
	public LeaveReview(int userType, View nextView) {
		super("leaveReview", userType, nextView);
	}

	/**
	 * Display the view
	 */
	public void display() {
		outputPageName("Leave a Review");

		getName();
	}

	/**
	 * Display the view to get the name of reviewer
	 */
	private void getName() {
		String name;
		System.out.print("Please enter your name (Input 0 to go back): ");
		Scanner sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		if (inputName.contentEquals("0")) {
			Navigation.goBack();
		}
		else {
			name = inputName;
			getSubjectTitle(name);
		}
	}

	/**
	 * Display the view to get the title of a review
	 *
	 * @param name the reviewer's name
	 */
	private void getSubjectTitle(String name) {
		String title;
		System.out.print("Please enter the subject title of your review (Input 0 to go back): ");
		Scanner sc = new Scanner(System.in);
		String inputTitle = sc.nextLine();
		if (inputTitle.contentEquals("0")) {
			getName();
		}
		else {
			title = inputTitle;
			getRating(name, title);
		}
	}

	/**
	 * Display the view to get the rating of a review
	 *
	 * @param name the reviewer's name
	 * @param title the review's title
	 */
	private void getRating(String name, String title) {
		double rating;
		double inputRating = getDouble("Please enter your desired rating (1.00 - 5.00): ");
		if (inputRating == 0) {
			getSubjectTitle(name);
		}
		else if (inputRating < 1 || inputRating > 5) {
			System.out.println("Please input a number between 1.00 to 5.00.");
			getRating(name, title);
		}
		else if (checkTwoDecimal(inputRating)) {
			rating = inputRating;
			getSubjectBody(name, title, rating);
		}
		else {
			System.out.println("Please input a number with at most two decimal places.");
			getRating(name, title);
		}
	}

	/**
	 * Display the view to get the rating of a review
	 *
	 * @param name the reviewer's name
	 * @param title the review' title
	 * @param rating the review's rating
	 */
	private void getSubjectBody(String name, String title, double rating) {
		String body;
		System.out.print("Please enter the details of your review (Input 0 to go back): ");
		Scanner sc = new Scanner(System.in);
		String inputBody = sc.nextLine();
		if (inputBody.contentEquals("0")) {
			getRating(name, title);
		}
		else {
			body = inputBody;
			getConfirmation(name, title, rating, body);
		}
	}

	/**
	 * Display the view to get confirmation
	 *
	 * @param name the reviewer's name
	 * @param title the review's title
	 * @param rating the review's rating
	 * @param body the review's body details
	 */
	private void getConfirmation (String name, String title, double rating, String body) {
		int input = getChoice("Input 1 to confirm (0 - to go back): ");
		if (input == 0) {
			getSubjectBody(name, title, rating);
		}
		else if (input == 1) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date todayDate = new Date();
			String date = sdf.format(todayDate);
			Review review = new Review(name, title, body, date, rating);
			ReviewController.getChosenMovie().addReview(review);
			ReviewController.setAvgRating(rating);
			Navigation.goBack();
		}
		else {
			System.out.println("\nPlease enter a valid input!\n");
		}
	}

}
