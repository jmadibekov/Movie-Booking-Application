public class StackArg {
	
	private String menuListVal;
	private int userType; //0 - Admin, 1 - Customer
	private BookingController bookingCtrl;
	private MainModel model;
	
	public StackArg() {
		menuListVal = "baseMenu";
		userType = -1;
		bookingCtrl = new BookingController();
	}
	
	public void setMenuListVal(String menuListVal) {
		this.menuListVal = menuListVal;
	}
	
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	public String getMenuListVal() {
		return menuListVal;
	}
	
	public int getUserType() {
		return userType;
	}
	public BookingController getBookingCtrl() {
		return bookingCtrl;
	}
	public void setBookingCtrl(BookingController bookingCtrl) {
		this.bookingCtrl = bookingCtrl;
	}
	public MainModel getModel() {
		return model;
	}
	public void setModel(MainModel model) {
		this.model = model;
	}

}
