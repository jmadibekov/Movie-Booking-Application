package moblima.model;

/**
 * The type Showtime.
 */
public class Showtime {
	/**
	 * Start time of showtime
	 */
	private int time;
	/**
	 * Date of showtime
	 */
	private String date;
	/**
	 * Type of showtime (IMAX/3D/Digital)
	 */
	private String type;
	/**
	 * Cinema where showtime is shown at
	 */
	private String cinemaId;
	/**
	 * 2D array to represent seating arrangement
	 */
	private String[][] seatLayout;

	/**
	 * Instantiates a new Showtime
	 *
	 * @param time       the start time
	 * @param date       the date
	 * @param type       the type
	 * @param cinemaId   the cinema id
	 * @param seatLayout the seat layout
	 */
	public Showtime(int time, String date, String type, String cinemaId, String[][] seatLayout) {
		this.time = time;
		this.date = date;
		this.type = type;
		this.cinemaId = cinemaId;
		this.seatLayout = seatLayout;
	}

	/**
	 * Calculates the ending time for the showtime
	 *
	 * @param duration the duration of the movie
	 * @return the ending time
	 */
	public int calcEnd(int duration) {
		int m = time % 100;
		int h = time / 100;

		int start = h * 60 + m;
		int end = (start + duration) % 1440;

		int mEnd = end % 60;
		int hEnd = end / 60;

		return hEnd * 100 + mEnd;
	}

	/**
	 * Returns the formatted string of int time for output
	 *
	 * @param time the time in HHMM format
	 * @return the formatted string
	 */
	public String inTimeFormat(int time) {
		return String.format("%04d", time);
	}

	/**
	 * Sets new Cinema where showtime is shown at.
	 *
	 * @param cinemaId New value of Cinema where showtime is shown at.
	 */
	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}

	/**
	 * Gets Date of showtime.
	 *
	 * @return Value of Date of showtime.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets new Time of showtime.
	 *
	 * @param time New value of Time of showtime.
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * Sets new Date of showtime.
	 *
	 * @param date New value of Date of showtime.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets 2D array to represent seating arrangement.
	 *
	 * @return Value of 2D array to represent seating arrangement.
	 */
	public String[][] getSeatLayout() {
		return seatLayout;
	}

	/**
	 * Gets Type of showtime IMAX3DDigital.
	 *
	 * @return Value of Type of showtime IMAX3DDigital.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets new 2D array to represent seating arrangement.
	 *
	 * @param seatLayout New value of 2D array to represent seating arrangement.
	 */
	public void setSeatLayout(String[][] seatLayout) {
		this.seatLayout = seatLayout;
	}

	/**
	 * Gets Time of showtime.
	 *
	 * @return Value of Time of showtime.
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Sets new Type of showtime IMAX3DDigital.
	 *
	 * @param type New value of Type of showtime IMAX3DDigital.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets Cinema where showtime is shown at.
	 *
	 * @return Value of Cinema where showtime is shown at.
	 */
	public String getCinemaId() {
		return cinemaId;
	}
}
