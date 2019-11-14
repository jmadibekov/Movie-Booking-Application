package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.ReviewController;
import moblima.model.*;

import java.util.ArrayList;

public class ReviewList {
	
	public ReviewList() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "-------------All Reviews-------------\n"
				+ "=====================================\n");
		//function to get booking history
		ArrayList< Review > reviewList = ReviewController.getChosenMovie().getReviewList();
		if (reviewList.isEmpty()) {
			System.out.println("No reviews available. Please try another movie");
			navigation.goBack();
		}
		for (Review i : reviewList) {
			i.output();
		}
		while (true) {
			System.out.println("(0) Back\n"
			+ "(1) Leave a Review");
			int input = navigation.getChoice("Please select an option: ");
			if (input == 0) {
				navigation.goBack();
				break;
			}
			else if (input == 1) {
				navigation.goTo(new StackArg("leaveReview", navigation.getLastView().getUserType()));
				break;
			}
		}
	}
	
}
