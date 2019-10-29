import java.util.Stack;

public class ChooseSeats extends ChooseShowtime{
	
	public ChooseSeats() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "------Booking: Choose your Seat-----\n"
				+ "=====================================\n\n"
				+ stack.peek().getBookingCtrl().getMovie().getTitle()
				+ "\n\n(0) Back");
		
		stack.peek().getBookingCtrl().printSeatLayout();
		
		while (true) {
			stack.peek().getBookingCtrl().setTotalPrice(0);
			System.out.print("Input number of seats: ");
			int input = super.getIntInput();
			if (input == 0) {
				super.goBack(stack);
			}
			else if (input > 3) {
				System.out.println("Maximum 3 seats allowed");
			}
			else if (input > 0) {
				int i;
				for (i = 0;i<input;i++) {
					while (true) {
						stack.peek().getBookingCtrl().clearSeat();
						//stack.peek().getBookingCtrl().clearSeatSelected();
						System.out.println("Seat " + i);
						System.out.println("(0) Choose number of seats again");
						System.out.print("Input ticket type (1 - Adult, 2 - Student, 3 - SeniorCitizen): ");
						int ticketType = super.getIntInput();
						if (ticketType == 0 && i == 0) {
							i = input;
							break;
						} else if (input > 3 || input < 0) {
							System.out.println("Please enter a valid input");
						} else {
							while (true) {
								stack.peek().getBookingCtrl().addSeat(ticketType);
								System.out.print("Input row: ");
								int row = super.getIntInput();
								System.out.print("Input column: ");
								int col = super.getIntInput();
								if (col > 0 && row > 0 && row < 9 && col < 15) {
									if (stack.peek().getBookingCtrl().getSeatLayout()[row - 1][col - 1] == 0) {
										stack.peek().getBookingCtrl().getSeatLayout()[row - 1][col - 1] = 1;
										stack.peek().getBookingCtrl().addSeat(row - 1);
										stack.peek().getBookingCtrl().addSeat(col - 1);
										stack.peek().getBookingCtrl().printSeatLayout();
										System.out.println("Price for that seat: $" + stack.peek().getBookingCtrl().calcPrice());
										//stack.peek().getBookingCtrl().addSeatSelected(stack.peek().getBookingCtrl().getSeat());
										break;
									} else if (stack.peek().getBookingCtrl().getSeatLayout()[row - 1][col - 1] == 1) {
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
					System.out.println("The total price of booking: $" + stack.peek().getBookingCtrl().getTotalPrice());
					System.out.println("Input 1 to confirm your booking: ");
					int confirm = getIntInput();
					if (confirm == 1) {
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
