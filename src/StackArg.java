public class StackArg {
	
	private String menuListVal;
	private int userType; //0 - Admin, 1 - Customer
	private BookingController bookingCtrl;
	private int lastInput;
	
	public StackArg() {
		menuListVal = "baseMenu";
		userType = -1;
		bookingCtrl = new BookingController();

	}
	
	public void setMenuListVal(String menuListVal) {
		this.menuListVal = menuListVal;
	}

	public String getMenuListVal() { return menuListVal; }

	public void setLastInput(int lastInput) {
		this.lastInput = lastInput;
	}

	public int getLastInput() { return lastInput; }
	
	public void setUserType(int userType) {
		this.userType = userType;
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

}
