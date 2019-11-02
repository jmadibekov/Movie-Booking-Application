package moblima.view;

import moblima.controller.BookingController;
import moblima.model.StackArg;

public class ChooseSeats {
	
	public ChooseSeats() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				  "=====================================\n"
				+ "------Booking: Choose your Seat-----\n"
				+ "=====================================\n\n"
				+ BookingController.getChosenMovie().getTitle() +"\n"
				+ BookingController.getChosenShowtime().getDate() + ", "
				+ BookingController.getChosenShowtime().getTime() + ", "
				+ BookingController.getChosenShowtime().getType() + ", "
				+ BookingController.getCinemaClass(BookingController.getChosenShowtime().getCinemaId())
				+ "\n\n(0) Back");

		BookingController.setSeatLayout(BookingController.getChosenShowtime().getSeatLayout());

		BookingController.printSeatLayout();
		
		while (true) {
			BookingController.setTotalPrice(0);
			BookingController.setNoOfSeats(0);

			int input = navigation.getChoice("Input number of seats: ");
			BookingController.setNoOfSeats(input);

			if (input == 0) {
				navigation.goBack();
			}

			else if (input > 3) {
				System.out.println("Maximum 3 seats allowed");
			}

			else if (input > 0) {
				int i;
				for (i = 0;i<input;i++) {
					while (true) {
						BookingController.clearSeat();
						//stack.peek().getBookingCtrl().clearSeatSelected();
						System.out.println("Seat " + (i+1));
						int ticketType = navigation.getChoice("Input ticket type (0 - Choose Seats again, 1 - Adult, 2 - Student, 3 - SeniorCitizen): ");
						if (ticketType == 0) {
							i = input;
							break;
						} else if (ticketType > 3 || ticketType < 0) {
							System.out.println("Please enter a valid input");
						} else {
							while (true) {
								BookingController.addSeat(ticketType);
								int row = navigation.getChoice("Input row: ");
								int col = navigation.getChoice("Input column: ");

								if (col > 0 && row > 0 && row < 9 && col < 10) {
									if (BookingController.getSeatLayout()[row - 1][col - 1] == 0) {
										BookingController.getSeatLayout()[row - 1][col - 1] = 1;
										BookingController.addSeat(row - 1);
										BookingController.addSeat(col - 1);
										BookingController.printSeatLayout();
										System.out.println("Price for that seat: $" + BookingController.calcPrice());
										//stack.peek().getBookingCtrl().addSeatSelected(stack.peek().getBookingCtrl().getSeat());
										break;
									} else if (BookingController.getSeatLayout()[row - 1][col - 1] == 1) {
										System.out.println("Seat is occupied. PLease input a different row and column");
									} else {
										System.out.println("Please enter a valid input");
									}
								} else {
									System.out.println("Please enter a valid input");
								}
							}
							break;
						}
					}
				}
				if (i == input) {
					System.out.println("The total price of booking: $" + BookingController.getTotalPrice());
					int confirm = navigation.getChoice("Input 1 to confirm your booking: ");
					if (confirm == 1) {
						navigation.goTo(new StackArg("enterParticulars", navigation.getLastView().getUserType()));
						break;
					}
				}
			}
			else {
				System.out.println("Please enter a valid input");
			}
		}
	}

}
