package moblima.view;
import moblima.model.MainModel;
import moblima.model.StackArg;

public class MOBLIMA {
	public static void main(String[] args) {
		Navigation navigation = new Navigation();
		MainModel.init(3, 0);

		// goes to the main menu
		navigation.goTo(new StackArg());
		navigation.exit();
	}
}
