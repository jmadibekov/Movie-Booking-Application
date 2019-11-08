/*
Static class used for functionality
*/

package moblima.view;
import moblima.model.StackArg;

public class MenuList {

	/*public enum menuView {
		baseMenu, adminMenu, moviegoerMenu, emailVerification, bookingHistory, allMoviesList, movieInformation,
		reviewList, leaveReview, searchMovie, top5Sales, top5Rating, chooseCineplex, chooseMovie, chooseShowtime,
		chooseSeats, enterParticulars, loginVerification, updateMovie, addMovie, addShowtime, editBaseTicketPrice,
		addHoliday;
	}*/

	public static void goToNext(Navigation navigation) {
		StackArg curView = navigation.getLastView();
		switch (curView.getMenuListVal()) {
		 case "baseMenu":
			 BaseMenu baseMenu = new BaseMenu();
			 baseMenu.display(navigation);
			 break;

		 case "adminMenu":
		 	 AdminMenu adminMenu = new AdminMenu();
		 	 adminMenu.display(navigation);
		 	 break;

		case "moviegoerMenu":
			 MoviegoerMenu moviegoerMenu = new MoviegoerMenu();
			 moviegoerMenu.display(navigation);
			 break;

		 case "emailVerification":
			 EmailVerification emailVerification = new EmailVerification();
			 emailVerification.display(navigation);
			 break;

		 case "bookingHistory":
			 BookingHistory bookingHistory = new BookingHistory();
			 bookingHistory.display(navigation);
			 break;

		 case "allMoviesList":
			 AllMoviesList allMoviesList = new AllMoviesList();
			 allMoviesList.display(navigation);
			 break;

		 case "movieInformation":
			 MovieInformation movieInformation = new MovieInformation();
			 movieInformation.display(navigation);
			 break;

		 case "reviewList":
			 ReviewList reviewList = new ReviewList();
			 reviewList.display(navigation);
			 break;

		 case "leaveReview":
			 LeaveReview leaveReview = new LeaveReview();
			 leaveReview.display(navigation);
			 break;

		 case "searchMovie":
			 SearchMovie searchMovie = new SearchMovie();
			 searchMovie.display(navigation);
			 break;

		 case "top5Sales":
			 Top5Sales top5Sales = new Top5Sales();
			 top5Sales.display(navigation);
			 break;

		 case "top5Rating":
			 Top5Rating top5Rating = new Top5Rating();
			 top5Rating.display(navigation);
			 break;

		 case "chooseCineplex":
			 ChooseCineplex chooseCineplex = new ChooseCineplex();
			 chooseCineplex.display(navigation);
			 break;

		 case "chooseMovie":
			 ChooseMovie chooseMovie = new ChooseMovie();
			 chooseMovie.display(navigation);
			 break;

		 case "chooseShowtime":
			 ChooseShowtime chooseShowtime = new ChooseShowtime();
			 chooseShowtime.display(navigation);
			 break;

		 case "chooseSeats":
			 ChooseSeats chooseSeats = new ChooseSeats();
			 chooseSeats.display(navigation);
			 break;

		 case "enterParticulars":
		 	 EnterParticulars enterParticulars = new EnterParticulars();
		 	 enterParticulars.display(navigation);
		 	 break;

		 case "loginVerification":
			 LoginVerification loginVerification = new LoginVerification();
			 loginVerification.display(navigation);
			 break;

		 case "updateMovie":
			 UpdateMovie updateMovie = new UpdateMovie();
			 updateMovie.display(navigation);
			 break;

		 case "addMovie":
			 AddMovie addMovie = new AddMovie();
			 addMovie.display(navigation);
			 break;

		 case "addShowtime":
			 AddShowtime addShowtime = new AddShowtime();
			 addShowtime.display(navigation);
			 break;

		 case "editBaseTicketPrice":
			 EditBaseTicketPrice editBaseTicketPrice = new EditBaseTicketPrice();
			 editBaseTicketPrice.display(navigation);
			 break;
		 case "addHoliday":
		 	 AddHoliday addHoliday = new AddHoliday();
			 addHoliday.display(navigation);
			 break;

		 default: 
			 System.out.println("Something went wrong! The program is terminating.");
			 break;
		}
	}

}
