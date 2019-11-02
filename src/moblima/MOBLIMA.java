package moblima;

import moblima.model.*;
import moblima.view.*;

public class MOBLIMA {
	public static void main(String[] args) {
		// Initialization
		Navigation navigation = new Navigation();
		MainModel.init(3, 0);

		// The program starts here
		navigation.start();
		navigation.exit();
	}
}
