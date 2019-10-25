public class MOBLIMA {
	public static void main(String[] args) {
		Navigation navigation = new Navigation();
		StackArg stackArg = new StackArg();
		navigation.goTo(stackArg, navigation.stack);
		navigation.exit();
		// comment
	}
}
