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

		// The program starts here
		navigation.start();
		navigation.exit();
	}
}
