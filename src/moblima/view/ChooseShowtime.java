package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ChooseShowtime extends View {

	public ChooseShowtime(int userType, View nextView) {
		super("chooseShowtime", userType, nextView);
	}

	public void display() {
		outputPageName("Booking: Choose a Showtime");

		System.out.println("Chosen cineplex: '" + BookingController.getChosenCineplex().getCineplexName() + "'");
		System.out.println("Chosen movie: '" + BookingController.getChosenMovie().getTitle() + "'");
		System.out.println("\n(0) Back");

		int gotShowtimes = 0;
		int index = 1;
		ArrayList< Showtime > showtimesList = BookingController.getShowtimeSortedByDate();

		HashMap<Integer, Showtime> uniqueShowtimes = new HashMap<Integer, Showtime>();
		if (showtimesList.isEmpty()) {
			System.out.println("No showtimes available. Please try another movie.");
			Navigation.goBack();
		}
		for (Showtime i : showtimesList) {
			System.out.printf("(%s) %s, %s:%s%s, Cinema Class: %s, Type: %s\n",index, i.getDate(),
					i.getTime()/100, (i.getTime()/10)%10, i.getTime()%10,
					BookingController.getCinemaClass(i.getCinemaId()), i.getType());
			uniqueShowtimes.put(index, i);
			index++;
		}

		while (true) {
			int input = getChoice("Please select an option: ");
			boolean found = false;
			if (input == 0) {
				Navigation.goBack();
				break;
			}
			else if (input <= uniqueShowtimes.size()) {
				if (getUserType() == 1 && BookingController.getNoOfSeatsLeft(uniqueShowtimes.get(input)) != 0) {
					BookingController.setChosenShowtime(uniqueShowtimes.get(input));
					Navigation.goTo(new ChooseSeats(getUserType(), null));
					found = true;
				}
				else if (getUserType() == 0) {
					BookingController.setChosenShowtime(uniqueShowtimes.get(input));
					break;
				}
				else {
					System.out.println("No seats available for that showtime. Please input another showtime");
				}
			}
			if (found)
				break;
			System.out.println("\nPlease enter a valid input\n");
		}
	}
}
