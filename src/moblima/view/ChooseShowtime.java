package moblima.view;

import moblima.controller.*;
import moblima.model.*;
import moblima.model.StackArg;

import java.util.ArrayList;

public class ChooseShowtime{

	public ChooseShowtime() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "------Booking: Choose a Showtime-----\n"
				+ "=====================================\n\n"
				+ BookingController.getChosenMovie().getTitle()
				+ "\n\n(0) Back");

		//function to get showtimes based on cineplex and movie and cinema chosen

		int gotShowtimes = 0;
		ArrayList< Showtime > showtimesList = BookingController.getShowtimesList();

		for (Showtime i : showtimesList) {
			System.out.printf("(%d) %s, %d, Type: %s, CinemaClass: %s\n", i.getShowtimeId(), i.getDate(), i.getTime(),
					i.getType(), BookingController.getCinemaClass(i.getCinemaId()));
//			System.out.println("("+stack.peek().getBookingCtrl().getShowtimesList().get(i).getShowtimeId()+") "+
//					stack.peek().getBookingCtrl().getShowtimesList().get(i).getDate()+", "+
//					stack.peek().getBookingCtrl().getShowtimesList().get(i).getTime()+", Type: "+
//					stack.peek().getBookingCtrl().getShowtimesList().get(i).getType() +", CinemaClass: "+
//					stack.peek().getBookingCtrl().getCinemaClass(stack.peek().getBookingCtrl().getShowtimesList().get(i).getCinemaId()));
			gotShowtimes++;
		}

		if (gotShowtimes == 0) {
			System.out.println("No showtimes available. Please try another movie");
		}

		System.out.println("(99) Go back to main menu\n");
		StackArg curView = navigation.getLastView();

		while (true) {
			int input = navigation.getChoice();
			if (input == 0) {
				navigation.goBack();
				break;
			}

			boolean found = false;
			for (Showtime i : showtimesList) {
				if (input == i.getShowtimeId()) {
					BookingController.setChosenShowtime(i);
					navigation.goTo(new StackArg("chooseSeats", curView.getUserType()));
					found = true;
					break;
				}
			}

			if (found == true)
				break;

			System.out.println("\nPlease enter a valid input\n");
		}
	}
	
}