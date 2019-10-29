public class Staff {
	private String user;
	private String password;
	private String cineplex;
	
	public Staff(String user, String password, String cineplex) {
		this.user = user;
		this.password = password;
		this.cineplex = cineplex;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCineplex() {
		return cineplex;
	}

	public void setCineplex(String cineplex) {
		this.cineplex = cineplex;
	}
}
