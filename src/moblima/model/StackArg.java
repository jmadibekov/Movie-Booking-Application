package moblima.model;

public class StackArg {
	private String menuListVal;
	private String goNextView;
	private int userType; // -1 = Null, 0 = Admin, 1 = Movie-goer

	public StackArg() {
		menuListVal = "baseMenu";
		userType = -1;
		goNextView = null;
	}

	public StackArg(String menuListVal, int userType) {
		this.menuListVal = menuListVal;
		this.userType = userType;
		this.goNextView = null;
	}

	public StackArg(String menuListVal, int userType, String goNextView) {
		this.menuListVal = menuListVal;
		this.userType = userType;
		this.goNextView = goNextView;
	}
	
	public void setMenuListVal(String menuListVal) {
		this.menuListVal = menuListVal;
	}

	public String getMenuListVal() { return menuListVal; }

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getUserType() {
		return userType;
	}

	public String getGoNextView() {
		return goNextView;
	}

	public void setGoNextView(String goNextView) {
		this.goNextView = goNextView;
	}
}
