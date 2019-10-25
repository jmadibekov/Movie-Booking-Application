public class StackArg {
	
	private String menuListVal;
	private int userType; //0 - Admin, 1 - Customer
	
	public StackArg() {
		menuListVal = "baseMenu";
		userType = -1;
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

}
