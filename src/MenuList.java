import java.util.Stack;

public class MenuList extends Navigation{
	
	public static void gotoNavigation(Stack<StackArg> stack) {
		StackArg stackArg = new StackArg();
		switch (stack.peek().getMenuListVal()) {
		 case "baseMenu": 
			 BaseMenu baseMenu = new BaseMenu();
			 baseMenu.display(stackArg, stack);
			 break;
			 
		 case "moviegoerMenu": 
			 MoviegoerMenu moviegoerMenu = new MoviegoerMenu();
			 moviegoerMenu.display(stackArg, stack);
			 break;
			 
		 case "emailVerification": 
			 EmailVerification emailVerification = new EmailVerification();
			 emailVerification.display(stackArg, stack);
			 break;
			 
		 case "bookingHistory": 
			 BookingHistory bookingHistory = new BookingHistory();
			 bookingHistory.display(stackArg, stack);
			 break;
			 
		 case "allMoviesList": 
			 AllMoviesList allMoviesList = new AllMoviesList();
			 allMoviesList.display(stackArg, stack);
			 break;
			 
		 case "movieInformation": 
			 MovieInformation movieInformation = new MovieInformation();
			 movieInformation.display(stackArg, stack);
			 break;
			 
		 case "reviewList": 
			 ReviewList reviewList = new ReviewList();
			 reviewList.display(stackArg, stack);
			 break;
			 
		 case "leaveReview": 
			 LeaveReview leaveReview = new LeaveReview();
			 leaveReview.display(stackArg, stack);
			 break;
			 
		 case "searchMovie": 
			 SearchMovie searchMovie = new SearchMovie();
			 searchMovie.display(stackArg, stack);
			 break;
			 
		 case "top5Sales": 
			 Top5Sales top5Sales = new Top5Sales();
			 top5Sales.display(stackArg, stack);
			 break;
			 
		 case "top5Rating": 
			 Top5Rating top5Rating = new Top5Rating();
			 top5Rating.display(stackArg, stack);
			 break;
			 
		 case "chooseCineplex": 
			 ChooseCineplex chooseCineplex = new ChooseCineplex();
			 chooseCineplex.display(stackArg, stack);
			 break;
			 
		 case "chooseMovie": 
			 ChooseMovie chooseMovie = new ChooseMovie();
			 chooseMovie.display(stackArg, stack);
			 break;
			 
		 case "chooseShowtime": 
			 ChooseShowtime chooseShowtime = new ChooseShowtime();
			 chooseShowtime.display(stackArg, stack);
			 break;
			 
		 case "chooseSeats": 
			 ChooseSeats chooseSeats = new ChooseSeats();
			 chooseSeats.display(stackArg, stack);
			 break;
			 
		 default: 
			 System.out.println("Program terminating �.");
			 break;
		}
	}

}
