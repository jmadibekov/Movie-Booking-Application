package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.ReviewController;
import moblima.model.*;

import java.util.ArrayList;

/**
 * Represents the screen that shows all reviews of a movie
 */
public class ReviewList extends View{

	/**
	 * Instantiates a new Review list.
	 *
	 * @param userType the user type
	 * @param nextView the next view
	 */
	public ReviewList(int userType, View nextView) {
		super("reviewList", userType, nextView);
	}

	/**
	 * Display the view
	 */
	public void display() {

		outputPageName("All Reviews");

		ArrayList< Review > reviewList = ReviewController.getChosenMovie().getReviewList();
		if (reviewList.isEmpty()) {
			System.out.println("No reviews available.");
			Navigation.goBack();
		}
		for (Review i : reviewList) {
			i.output();
		}
		while (true) {
			System.out.println("(0) Back\n"
			+ "(1) Leave a Review");
			int input = getChoice("Please select an option: ");
			if (input == 0) {
				Navigation.goBack();
				break;
			}
			else if (input == 1) {
				Navigation.goTo(new LeaveReview(getUserType(), null));
				break;
			}
		}
	}
	
}
