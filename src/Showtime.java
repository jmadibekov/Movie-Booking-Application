public class Showtime {
	private int showtimeId;
	private int time;
	private String date;
	private String type;
	private String theatreId;
	private int numRows = 8;
	private int numCols = 14;
	private int[][] seatLayout;
	
	public Showtime(int showtimeId, int time, String date, String type, String theatreId, String theatreType) {
		this.showtimeId = showtimeId;
		this.time = time;
		this.date = date;
		this.type = type;
		this.theatreId = theatreId;
		if (theatreType.contentEquals("Regular")) {
			seatLayout = new int[numRows][numCols];
			for (int i=0;i<numRows;i++) {
				for (int j=0;j<numCols;j++) {
					if (j < numCols-3 && j > 1) {
						seatLayout[i][j] = 0;
					}
					else {
						seatLayout[i][j] = 2;
					}
				}
			}
		}
		else if (theatreType.contentEquals("Gold")) {
			seatLayout = new int[numRows][numCols];
			for (int i=0;i<numRows;i++) {
				for (int j=0;j<numCols;j++) {
					if (j < numCols-4 && j > 2) {
						seatLayout[i][j] = 0;
					}
					else {
						seatLayout[i][j] = 2;
					}
				}
			}
		}
		else if (theatreType.contentEquals("Platinum")) {
			seatLayout = new int[numRows][numCols];
			for (int i=0;i<numRows;i++) {
				for (int j=0;j<numCols;j++) {
					if (j < numCols-5 && j > 3) {
						seatLayout[i][j] = 0;
					}
					else {
						seatLayout[i][j] = 2;
					}
				}
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
	
	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
	public int[][] getSeatLayout() {
		return seatLayout;
	}
	public void setSeatLayout(int[][] seatLayout) {
		for(int i=0; i<seatLayout.length; i++)
			for(int j=0; j<seatLayout[i].length; j++)
				this.seatLayout[i][j]=seatLayout[i][j];
	}
	public void printSeatLayout() {
		System.out.println("                Screen\n");
		for (int i=0;i<numRows;i++) {
			for (int j=0;j<numCols;j++) {
				if (seatLayout[i][j] == 2) {
					System.out.print("   ");
				}
				else {
					System.out.print("[");
					System.out.print(seatLayout[i][j]);
					System.out.print("]");
				}
			}
			System.out.print(i+1 + "\n");
		}
		System.out.println(" 1  2  3  4  5  6  7  8  9  10 11 12 13 14\n");
		System.out.println("\n                Entrance\n");
		System.out.println("Legend: \n"
				+ "0 - Available Slots\n"
				+ "1 - Occupied Slots\n");
	}
}
