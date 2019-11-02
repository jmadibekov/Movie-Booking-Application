package moblima.model;

public class Cinema {
	private String cinemaId;
	private String cinemaClass;

	public Cinema(String cinemaId, String cinemaClass) {
		this.cinemaId = cinemaId;
		this.cinemaClass = cinemaClass;
	}

	public String getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getCinemaClass() {
		return cinemaClass;
	}

	public void setCinemaClass(String cinemaClass) {
		this.cinemaClass = cinemaClass;
	}
}