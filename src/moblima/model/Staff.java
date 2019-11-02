package moblima.model;

public class Staff {
	private String user;
	private String password;
	private String cineplexId;

	public Staff(String user, String password, String cineplexId) {
		this.user = user;
		this.password = password;
		this.cineplexId= cineplexId;
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

	public String getCineplexId() { return cineplexId; }

	public void setCineplexId(String cineplexId) { this.cineplexId = cineplexId; }
}
