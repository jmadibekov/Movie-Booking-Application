package moblima.model;

/**
 Represents a cinema in a particular cineplex
 A cinema corresponds to cineplex id
 */
public class Cinema {
	/**
	 * ID of the cinema
	 */
	private String cinemaId;
	/**
	 * Class of the cinema
	 */
	private String cinemaClass;

	/**
	 * Creates a new cinema in a particular cineplex
	 * @param cinemaId
	 * @param cinemaClass
	 */
	public Cinema(String cinemaId, String cinemaClass) {
		this.cinemaId = cinemaId;
		this.cinemaClass = cinemaClass;
	}


	/**
	 * Sets new cinemaClass.
	 *
	 * @param cinemaClass New value of cinemaClass.
	 */
	public void setCinemaClass(String cinemaClass) {
		this.cinemaClass = cinemaClass;
	}

	/**
	 * Sets new cinemaId.
	 *
	 * @param cinemaId New value of cinemaId.
	 */
	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}

	/**
	 * Gets cinemaId.
	 *
	 * @return Value of cinemaId.
	 */
	public String getCinemaId() {
		return cinemaId;
	}

	/**
	 * Gets cinemaClass.
	 *
	 * @return Value of cinemaClass.
	 */
	public String getCinemaClass() {
		return cinemaClass;
	}
}