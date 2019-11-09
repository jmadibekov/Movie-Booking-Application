package moblima.model;

public class Showtime {
	private int time;
	private String date;
	private String type;
	private String cinemaId;
	private int numRows = 8;
	private int numCols = 9;
	private String[][] seatLayout;

	public Showtime(int time, String date, String type, String cinemaId, String[][] seatLayout) {
		this.time = time;
		this.date = date;
		this.type = type;
		this.cinemaId = cinemaId;
		this.seatLayout = seatLayout;
	}

	public int getTime() {
		return time;
	}

	public void setTitle(int time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String[][] getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(String[][] seatLayout) {
		this.seatLayout = seatLayout;
	}
}
