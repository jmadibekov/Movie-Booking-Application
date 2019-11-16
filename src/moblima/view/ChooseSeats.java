package moblima.view;

import moblima.controller.*;

/**
 * Represents the screen where user choose seats for booking
 */
public class ChooseSeats extends View {

	/**
	 * Instantiates a new Choose seats view
	 *
	 * @param userType the user type
	 * @param nextView the next view
	 */
	public ChooseSeats(int userType, View nextView) {
		super("chooseSeats", userType, nextView);
	}

	/**
	 * Display the view
	 */
	public void display() {
		outputPageName("Booking: Choose your Seat");

		System.out.printf("'%s', %s, %s:%s%s, Cinema Class: %s, Type: %s\n\n",
				BookingController.getChosenMovie().getTitle(),
				BookingController.getChosenShowtime().getDate(),
				BookingController.getChosenShowtime().getTime()/100,
				(BookingController.getChosenShowtime().getTime()/10)%10,
				BookingController.getChosenShowtime().getTime()%10,
				BookingController.getCinemaClass(BookingController.getChosenShowtime().getCinemaId()),
				BookingController.getChosenShowtime().getType());

		getNoOfSeats();
	}

	/**
	 * Display the view to get the number of seats to be booked from user
	 */
	private void getNoOfSeats() {
		int noOfSeats;
		BookingController.getChosenShowtime().getSeatLayout();
		BookingController.setSeatLayout(BookingController.getChosenShowtime().getSeatLayout());
		BookingController.printSeatLayout();
		BookingController.clearSeatSelected();
		BookingController.setTotalPrice(0);
		BookingController.setNoOfSeats(0);
		int index = 1;
		int input = getChoice("\nInput number of seats (0 - Back): ");
		BookingController.setNoOfSeats(input);

		if (input == 0) {
			Navigation.goBack();
		}
		else if (input > BookingController.getNoOfSeatsLeft(BookingController.getChosenShowtime())) {
			System.out.println("Unable to book seats as number of seats exceeded number of seats left.");
			System.out.println("Number of seats left: " + BookingController.getNoOfSeatsLeft(BookingController.getChosenShowtime()));
			getNoOfSeats();
		}
		else if (input > 5) {
			System.out.println("Maximum 5 seats allowed.");
			getNoOfSeats();
		}
		else if (input > 0) {
			noOfSeats = input;
			getTicketType(0, 0, index, noOfSeats);
		}
	}

	/**
	 * Display the view to get the ticket type (Adult, Student, Senior Citizen) of a seat to be booked from user
	 *
	 * @param prevPrice the price of previous seat assuming number of seats are bigger than 1
	 * @param curPrice the price of current seat
	 * @param index the seat number
	 * @param noOfSeats the number of seats
	 */
	private void getTicketType(double prevPrice, double curPrice, int index, int noOfSeats) {
		BookingController.setTotalPrice(BookingController.getTotalPrice() - prevPrice);
		BookingController.clearSeat();
		outputPageName("Booking: Seat " + index);
		int ticketType = getChoice("Input ticket type (0 - Back, 1 - Adult, 2 - Student, 3 - SeniorCitizen): ");
		if (ticketType == 0 && index == 1) {
			getNoOfSeats();
		}
		else if (ticketType == 0) {
			index--;
			Integer[] oldSeat;
			oldSeat = BookingController.removeSeatSelected();
			BookingController.getSeatLayout()[oldSeat[0]][oldSeat[1]] = "0";
			getTicketType(curPrice, 0, index, noOfSeats);
		}
		else if (ticketType > 3 || ticketType < 0) {
			System.out.println("Please enter a valid input!");
			getTicketType(0, 0, index, noOfSeats);
		} else {
			BookingController.addSeat(ticketType);
			getRowAndColumn(index, noOfSeats);
		}
	}

	/**
	 * Display the view to get the row and column of a seat to be booked from user
	 *
	 * @param index the seat number
	 * @param noOfSeats the number of seats
	 */
	private void getRowAndColumn(int index, int noOfSeats) {
		System.out.println("Input 0 to go back to choosing ticket type.");
		int row = getChoice("Input row: ");
		if (row == 0) {
			getTicketType(0, 0, index, noOfSeats);
		}
		else {
			int col = getChoice("Input column: ");
			if (col == 0) {
				getTicketType(0, 0, index, noOfSeats);
			}
			else if (col > 0 && row > 0 && row < 9 && col < 10) {
				if (BookingController.getSeatLayout()[row - 1][col - 1].contentEquals("0")) {
					BookingController.getSeatLayout()[row - 1][col - 1] = "1";
					BookingController.addSeat(row);
					BookingController.addSeat(col);
					BookingController.printSeatLayout();
					double price = BookingController.calcPrice();
					System.out.printf("\nPrice for that seat: $%.2f\n", price);
					BookingController.addSeatSelected(BookingController.getSeat());
					System.out.println("\nChosen Seat(s):");
					BookingController.printSeatSelected(BookingController.getSeatSelected());
					System.out.println();
					if (index == noOfSeats) {
						getConfirmation(price, index, noOfSeats);
					}
					else {
						index++;
						getTicketType(0, price, index, noOfSeats);
					}
				} else if (BookingController.getSeatLayout()[row - 1][col - 1].contentEquals("1")) {
					System.out.println("Seat is occupied. PLease input a different row and column.");
					getRowAndColumn(index, noOfSeats);
				} else {
					System.out.println("Please enter a valid input!");
					getRowAndColumn(index, noOfSeats);
				}
			} else {
				System.out.println("Please enter a valid input!");
				getRowAndColumn(index, noOfSeats);
			}
		}
	}

	/**
	 * Display the view to get confirmation from user after choosing all the seats to be booked
	 *
	 * @param price price of last seat in case user changes his/her mind
	 * @param index the seat number
	 * @param noOfSeats the number of seats
	 */
	private void getConfirmation(double price, int index, int noOfSeats) {
		System.out.printf("The total price of booking: $%.2f\n", BookingController.getTotalPrice());
		int confirm = getChoice("Input 1 to confirm your booking (0 - Back): ");
		if (confirm == 1) {
			Navigation.goTo(new EnterParticulars(getUserType(), null));
		}
		else {
			Integer[] oldSeat;
			oldSeat = BookingController.removeSeatSelected();
			BookingController.getSeatLayout()[oldSeat[0]][oldSeat[1]] = "0";
			getTicketType(price, 0, index, noOfSeats);
		}
	}

}
