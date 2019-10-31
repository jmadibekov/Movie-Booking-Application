public class Showtime {
	private int showtimeId;
	private int time;
	private String date;
	private String type;
	private String cinemaId;
	private int numRows = 8;
	private int numCols = 9;
	private int[][] seatLayout;
	
	public Showtime(int showtimeId, int time, String date, String type, String cinemaId) {
		this.showtimeId = showtimeId;
		this.time = time;
		this.date = date;
		this.type = type;
		this.cinemaId = cinemaId;
		seatLayout = new int[numRows][numCols];
		for (int i=0;i<numRows;i++) {
			for (int j=0;j<numCols;j++) {
					seatLayout[i][j] = 0;
			}
		}
	}
	
	public int getShowtimeId() {
		return showtimeId;
	}
	
	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
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
	public int[][] getSeatLayout() {
		return seatLayout;
	}
	public void setSeatLayout(int[][] seatLayout) {
		for(int i=0; i<seatLayout.length; i++)
			for(int j=0; j<seatLayout[i].length; j++)
				this.seatLayout[i][j]=seatLayout[i][j];
	}
}
