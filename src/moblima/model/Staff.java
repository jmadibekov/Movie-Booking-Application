package moblima.model;

/**
 * Represents a staff that belonging to a specific cineplex
 */
public class Staff {
	/**
	 * Username of the staff
	 */
	private String user;
	/**
	 * Password of the staff
	 */
	private String password;
	/**
	 * Cineplex the staff belongs to
	 */
	private String cineplexId;

	/**
	 * Instantiates a new Staff
	 * Retrieves data from database using DBController and passed them as parameters
	 *
	 * @param user       the user
	 * @param password   the password
	 * @param cineplexId the cineplex id
	 */
	public Staff(String user, String password, String cineplexId) {
		this.user = user;
		this.password = password;
		this.cineplexId= cineplexId;
	}

	/**
	 * Gets Username of the staff.
	 *
	 * @return Value of Username of the staff.
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets new Username of the staff.
	 *
	 * @param user New value of Username of the staff.
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Sets new Password of the staff.
	 *
	 * @param password New value of Password of the staff.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets Cineplex the staff belongs to.
	 *
	 * @return Value of Cineplex the staff belongs to.
	 */
	public String getCineplexId() {
		return cineplexId;
	}

	/**
	 * Sets new Cineplex the staff belongs to.
	 *
	 * @param cineplexId New value of Cineplex the staff belongs to.
	 */
	public void setCineplexId(String cineplexId) {
		this.cineplexId = cineplexId;
	}

	/**
	 * Gets Password of the staff.
	 *
	 * @return Value of Password of the staff.
	 */
	public String getPassword() {
		return password;
	}
}
