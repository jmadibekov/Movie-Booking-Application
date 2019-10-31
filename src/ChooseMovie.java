import java.util.Stack;

public class ChooseMovie extends ChooseCineplex {

	public ChooseMovie() {
		
	}
	
	public void display(StackArg stackArg, Stack<StackArg> stack) {
		System.out.println("=====================================\n"
				+ "-------Booking: Choose a Movie-------\n"
				+ "=====================================\n\n"
				+ stack.peek().getBookingCtrl().getCineplex().getCinemaName()
				+ "\n\n(0) Back");
		//function to get movie based on cineplex chosen
		int gotMovies = 0;
		for (int i = 0; i<stack.peek().getBookingCtrl().getMoviesList().size();i++) {
			if (stack.peek().getBookingCtrl().getMoviesList().get(i).getShowingStatus().contentEquals("NowShowing") || 
					stack.peek().getBookingCtrl().getMoviesList().get(i).getShowingStatus().contentEquals("Preview")) {
				System.out.println("("+stack.peek().getBookingCtrl().getMoviesList().get(i).getMovieId()+") "+
				stack.peek().getBookingCtrl().getMoviesList().get(i).getTitle()+", Rating: "+
				stack.peek().getBookingCtrl().getMoviesList().get(i).getOverallRating()+", ShowingStatus: "+
				stack.peek().getBookingCtrl().getMoviesList().get(i).getShowingStatus());
				gotMovies++;
			}
		}
		System.out.print("\n");
		if (gotMovies == 0) {
			System.out.println("No movies are currently showing. Please try another cineplex location");
		}
		while (true) {
			int input = super.getChoice();
			if (input == 0) {
				super.goBack(stack);
				break;
			}
			int i;
			for (i = 0; i<stack.peek().getBookingCtrl().getMoviesList().size();i++) {
				if (input == stack.peek().getBookingCtrl().getMoviesList().get(i).getMovieId()) {
					if (stack.peek().getBookingCtrl().getMoviesList().get(i).getShowingStatus().contentEquals("NowShowing") || 
							stack.peek().getBookingCtrl().getMoviesList().get(i).getShowingStatus().contentEquals("Preview")) {
						stackArg.setMenuListVal("chooseShowtime");
						stackArg.setBookingCtrl(stack.peek().getBookingCtrl());
						stackArg.getBookingCtrl().setMovie(stack.peek().getBookingCtrl().getMoviesList().get(i));
						super.goTo(stackArg, stack);
						break;
					}
				}
			}
			if (i != stack.peek().getBookingCtrl().getMoviesList().size()) {
				break;
			}
			System.out.println("\nPlease enter a valid input\n");
		}
	}
	
}
