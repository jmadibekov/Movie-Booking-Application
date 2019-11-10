package moblima;

import moblima.model.*;
import moblima.view.*;

public class MOBLIMA {
	public static void main(String[] args) {
		// Initialization
		Navigation navigation = new Navigation();
		MainModel.init();

		// To double-check
//		MainModel.output();
		// To check chosen seats is stored correctly in bookingList
//		System.out.println(MainModel.getCustomerList().get(0).getBookList().get(0).getChosenSeats());

		// The program starts here
		navigation.start();
		navigation.exit();
	}
}
