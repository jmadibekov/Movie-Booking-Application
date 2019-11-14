package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.ReviewController;
import moblima.model.*;

import java.util.ArrayList;

public class ReviewList extends View{

	public ReviewList(int userType, View nextView) {
		super("reviewList", userType, nextView);
	}
	
	public void display() {

		outputPageName("All Reviews");

		//function to get booking history
		ArrayList< Review > reviewList = ReviewController.getChosenMovie().getReviewList();
		if (reviewList.isEmpty()) {
			System.out.println("No reviews available. Please try another movie");
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
