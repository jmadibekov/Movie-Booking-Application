package moblima.controller;

import moblima.view.*;

public class MenuList {
	/**
	 * An extension of Navigation.
	 * It creates a new View and calls it respectively.
	 */

	public static void goToNext() {
		View curView = Navigation.getLastView();
		switch (curView.getMenuListVal()) {
		 case "baseMenu":
			 BaseMenu baseMenu = new BaseMenu();
			 baseMenu.display();
			 break;

		 case "adminMenu":
		 	 AdminMenu adminMenu = new AdminMenu();
		 	 adminMenu.display();
		 	 break;

		case "moviegoerMenu":
			 MoviegoerMenu moviegoerMenu = new MoviegoerMenu();
			 moviegoerMenu.display();
			 break;

		 case "emailVerification":
			 EmailVerification emailVerification = new EmailVerification();
			 emailVerification.display();
			 break;

		 case "bookingHistory":
			 BookingHistory bookingHistory = new BookingHistory();
			 bookingHistory.display();
			 break;

		 case "allMoviesList":
			 AllMoviesList allMoviesList = new AllMoviesList();
			 allMoviesList.display();
			 break;

		 case "movieInformation":
			 MovieInformation movieInformation = new MovieInformation();
			 movieInformation.display();
			 break;

		 case "reviewList":
			 ReviewList reviewList = new ReviewList();
			 reviewList.display();
			 break;

		 case "leaveReview":
			 LeaveReview leaveReview = new LeaveReview();
			 leaveReview.display();
			 break;

		 case "searchMovie":
			 SearchMovie searchMovie = new SearchMovie();
			 searchMovie.display();
			 break;

		 case "top5Sales":
			 Top5Sales top5Sales = new Top5Sales();
			 top5Sales.display();
			 break;

		 case "top5Rating":
			 Top5Rating top5Rating = new Top5Rating();
			 top5Rating.display();
			 break;

		 case "chooseCineplex":
			 ChooseCineplex chooseCineplex = new ChooseCineplex();
			 chooseCineplex.display();
			 break;

		 case "chooseMovie":
			 ChooseMovie chooseMovie = new ChooseMovie();
			 chooseMovie.display();
			 break;

		 case "chooseShowtime":
			 ChooseShowtime chooseShowtime = new ChooseShowtime();
			 chooseShowtime.display();
			 break;

		 case "chooseSeats":
			 ChooseSeats chooseSeats = new ChooseSeats();
			 chooseSeats.display();
			 break;

		 case "enterParticulars":
		 	 EnterParticulars enterParticulars = new EnterParticulars();
		 	 enterParticulars.display();
		 	 break;

		 case "loginVerification":
			 LoginVerification loginVerification = new LoginVerification();
			 loginVerification.display();
			 break;

		 case "updateMovie":
			 UpdateMovie updateMovie = new UpdateMovie();
			 updateMovie.display();
			 break;

		 case "addMovie":
			 AddMovie addMovie = new AddMovie();
			 addMovie.display();
			 break;

		 case "addShowtime":
			 AddShowtime addShowtime = new AddShowtime();
			 addShowtime.display();
			 break;

		 case "editBaseTicketPrice":
			 EditBaseTicketPrice editBaseTicketPrice = new EditBaseTicketPrice();
			 editBaseTicketPrice.display();
			 break;

		 case "addHoliday":
		 	 AddHoliday addHoliday = new AddHoliday();
			 addHoliday.display();
			 break;

		 default: 
			 System.out.println("Something went wrong! The program is terminating.");
			 break;
		}
	}

}
