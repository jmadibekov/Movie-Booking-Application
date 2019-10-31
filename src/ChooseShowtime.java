import java.util.Stack;

public class ChooseShowtime extends ChooseMovie{

	public ChooseShowtime() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "------Booking: Choose a Showtime-----\n"
				+ "=====================================\n\n"
				+ stack.peek().getBookingCtrl().getMovie().getTitle()
				+ "\n\n(0) Back");
		//function to get showtimes based on cineplex and movie and cinema chosen
		int gotShowtimes = 0;
		for (int i = 0; i<stack.peek().getBookingCtrl().getShowtimesList().size();i++) {
			System.out.println("("+stack.peek().getBookingCtrl().getShowtimesList().get(i).getShowtimeId()+") "+
			stack.peek().getBookingCtrl().getShowtimesList().get(i).getDate()+", "+
			stack.peek().getBookingCtrl().getShowtimesList().get(i).getTime()+", Type: "+
			stack.peek().getBookingCtrl().getShowtimesList().get(i).getType() +", CinemaClass: "+
			stack.peek().getBookingCtrl().getCinemaClass(stack.peek().getBookingCtrl().getShowtimesList().get(i).getCinemaId()));
			gotShowtimes++;
		}
		if (gotShowtimes == 0) {
			System.out.println("No showtimes available. Please try another movie");
		}
		System.out.println("(99) Go back to main menu\n");
		while (true) {
			int input = super.getChoice();
			if (input == 0) {
				super.goBack(stack);
				break;
			}
			int i;
			for (i = 0; i<stack.peek().getBookingCtrl().getShowtimesList().size();i++) {
				if (input == stack.peek().getBookingCtrl().getShowtimesList().get(i).getShowtimeId()) {
					stackArg.setMenuListVal("chooseSeats");
					stackArg.setBookingCtrl(stack.peek().getBookingCtrl());
					stackArg.getBookingCtrl().setShowtime(stack.peek().getBookingCtrl().getShowtimesList().get(i));
					super.goTo(stackArg, stack);
					break;
				}
			}
			if (i != stack.peek().getBookingCtrl().getShowtimesList().size()) {
				break;
			}
			System.out.println("\nPlease enter a valid input\n");
		}
	}
	
}
