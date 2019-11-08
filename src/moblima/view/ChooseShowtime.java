package moblima.view;

import moblima.controller.*;
import moblima.model.*;
import moblima.model.StackArg;

import java.util.ArrayList;
import java.util.HashMap;

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
		int index = 1;
		ArrayList< Showtime > showtimesList = BookingController.getShowtimeSortedByDate();

		HashMap<Integer, Showtime> uniqueShowtimes = new HashMap<Integer, Showtime>();
		if (showtimesList.isEmpty()) {
			System.out.println("No showtimes available. Please try another movie");
			navigation.goBack();
		}
		for (Showtime i : showtimesList) {
			System.out.printf("(%s) %s, %s:%s%s, CinemaClass: %s, Type: %s\n",index, i.getDate(),
					i.getTime()/100, (i.getTime()/10)%10, i.getTime()%10,
					BookingController.getCinemaClass(i.getCinemaId()), i.getType());
			uniqueShowtimes.put(index, i);
			index++;
		}

		StackArg curView = navigation.getLastView();

		while (true) {
			int input = navigation.getChoice("Please select an option: ");
			boolean found = false;
			if (input == 0) {
				navigation.goBack();
				break;
			}
			else if (input <= uniqueShowtimes.size()) {
				if (curView.getUserType() == 1) {
					BookingController.setChosenShowtime(uniqueShowtimes.get(input));
					navigation.goTo(new StackArg("chooseSeats", curView.getUserType()));
					found = true;
				} else {
					BookingController.setChosenShowtime(uniqueShowtimes.get(input));
					break;
				}
			}
			if (found)
				break;
			System.out.println("\nPlease enter a valid input\n");
		}
	}
	
}
