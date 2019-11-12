package moblima.view;

import moblima.controller.BookingController;
import moblima.model.Booking;
import moblima.model.StackArg;

import java.util.ArrayList;

public class ChooseSeats {

	private int noOfSeats;
	private int index;
	private double price;
	
	public ChooseSeats() {
	}
	
	public void display(Navigation navigation) {
		System.out.println(
				"=====================================\n"
			  + "------Booking: Choose your Seat-----\n"
			  + "=====================================\n");
		System.out.printf("'%s', %s, %s:%s%s, Cinema Class: %s, Type: %s\n\n",
				BookingController.getChosenMovie().getTitle(),
				BookingController.getChosenShowtime().getDate(),
				BookingController.getChosenShowtime().getTime()/100,
				(BookingController.getChosenShowtime().getTime()/10)%10,
				BookingController.getChosenShowtime().getTime()%10,
				BookingController.getCinemaClass(BookingController.getChosenShowtime().getCinemaId()),
				BookingController.getChosenShowtime().getType());

		getNoOfSeats(navigation);

		/*BookingController.getChosenShowtime().getSeatLayout();
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
			else if (input > BookingController.getNoOfSeatsLeft(BookingController.getChosenShowtime())) {
				System.out.println("Unable to book seats as number of seats exceeded number of seats left");
				System.out.println("No. of seats left: " + BookingController.getNoOfSeatsLeft(BookingController.getChosenShowtime()));
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
									if (BookingController.getSeatLayout()[row - 1][col - 1].contentEquals("0")) {
										BookingController.getSeatLayout()[row - 1][col - 1] = "1";
										BookingController.addSeat(row - 1);
										BookingController.addSeat(col - 1);
										BookingController.printSeatLayout();
										System.out.println("Price for that seat: $" + BookingController.calcPrice());
										//stack.peek().getBookingCtrl().addSeatSelected(stack.peek().getBookingCtrl().getSeat());
										break;
									} else if (BookingController.getSeatLayout()[row - 1][col - 1].contentEquals("1")) {
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
	}*/
	}

	private void getNoOfSeats(Navigation navigation) {
		BookingController.getChosenShowtime().getSeatLayout();
		BookingController.setSeatLayout(BookingController.getChosenShowtime().getSeatLayout());
		BookingController.printSeatLayout();
		BookingController.clearSeatSelected();
		BookingController.setTotalPrice(0);
		BookingController.setNoOfSeats(0);
		price = 0;
		index = 1;
		int input = navigation.getChoice("Input number of seats (0 - Back): ");
		BookingController.setNoOfSeats(input);

		if (input == 0) {
			navigation.goBack();
		}
		else if (input > BookingController.getNoOfSeatsLeft(BookingController.getChosenShowtime())) {
			System.out.println("Unable to book seats as number of seats exceeded number of seats left");
			System.out.println("No. of seats left: " + BookingController.getNoOfSeatsLeft(BookingController.getChosenShowtime()));
			getNoOfSeats(navigation);
		}
		else if (input > 5) {
			System.out.println("Maximum 5 seats allowed");
			getNoOfSeats(navigation);
		}
		else if (input > 0) {
			noOfSeats = input;
			getTicketType(navigation, 0);
		}
	}

	private void getTicketType(Navigation navigation, double price) {
		BookingController.setTotalPrice(BookingController.getTotalPrice() - price);
		BookingController.clearSeat();
		System.out.println("Seat " + (index));
		int ticketType = navigation.getChoice("Input ticket type (0 - Back, 1 - Adult, 2 - Student, 3 - SeniorCitizen): ");
		if (ticketType == 0 && index == 1) {
			getNoOfSeats(navigation);
		}
		else if (ticketType == 0) {
			index--;
			Integer[] oldSeat;
			oldSeat = BookingController.removeSeatSelected();
			BookingController.getSeatLayout()[oldSeat[0]][oldSeat[1]] = "0";
			getTicketType(navigation, this.price);
		}
		else if (ticketType > 3 || ticketType < 0) {
			System.out.println("Please enter a valid input");
			getTicketType(navigation, 0);
		} else {
			BookingController.addSeat(ticketType);
			getRowAndColumn(navigation);
		}
	}

	private void getRowAndColumn(Navigation navigation) {
		System.out.println("Input 0 to go back to choosing ticket type");
		int row = navigation.getChoice("Input row: ");
		if (row == 0) {
			getTicketType(navigation, 0);
		}
		else {
			int col = navigation.getChoice("Input column: ");
			if (col == 0) {
				getTicketType(navigation, 0);
			}
			else if (col > 0 && row > 0 && row < 9 && col < 10) {
				if (BookingController.getSeatLayout()[row - 1][col - 1].contentEquals("0")) {
					BookingController.getSeatLayout()[row - 1][col - 1] = "1";
					BookingController.addSeat(row);
					BookingController.addSeat(col);
					BookingController.printSeatLayout();
					price = BookingController.calcPrice();
					System.out.printf("Price for that seat: $%.2f\n", price);
					BookingController.addSeatSelected(BookingController.getSeat());
					System.out.println("Seat" + BookingController.getSeatSelected());
					if (index == noOfSeats) {
						getConfirmation(navigation);
					}
					else {
						index++;
						getTicketType(navigation, 0);
					}
				} else if (BookingController.getSeatLayout()[row - 1][col - 1].contentEquals("1")) {
					System.out.println("Seat is occupied. PLease input a different row and column");
					getRowAndColumn(navigation);
				} else {
					System.out.println("Please enter a valid input");
					getRowAndColumn(navigation);
				}
			} else {
				System.out.println("Please enter a valid input");
				getRowAndColumn(navigation);
			}
		}
	}

	private void getConfirmation(Navigation navigation) {
		System.out.println("The total price of booking: $" + BookingController.getTotalPrice());
		int confirm = navigation.getChoice("Input 1 to confirm your booking (0 - Back): ");
		if (confirm == 1) {
			navigation.goTo(new StackArg("enterParticulars", navigation.getLastView().getUserType()));
		}
		else {
			Integer[] oldSeat;
			oldSeat = BookingController.removeSeatSelected();
			BookingController.getSeatLayout()[oldSeat[0]][oldSeat[1]] = "0";
			getTicketType(navigation, price);
		}
	}

}
