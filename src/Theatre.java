public class Theatre {
	private String theatreId;
	private String theatreType;
	private int[][] seatLayout;
	private int numRows;
	private int numCols;
	
	public Theatre(String theatreId, String theatreType) {
		this.theatreId = theatreId;
		this.theatreType = theatreType;
		numRows = 8;
		numCols = 14;
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

	public int[][] getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(int[][] seatLayout) {
		this.seatLayout = seatLayout;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreType() {
		return theatreType;
	}

	public void setTheatreType(String theatreType) {
		this.theatreType = theatreType;
	}	
	
	
}

// 			       Screen
//	  _	_ _ _ _ _          _ _ _ _ _ _ 
// J |_|_|_|_|_|_|        |_|_|_|_|_|_| J
// H |_|_|_|_|_|_|        |_|_|_|_|_|_| H
// G |_|_|_|_|_|_|        |_|_|_|_|_|_| G
// F |_|_|X|_|_|_| 	      |_|_|_|_|_|_| F
// E |_|_|_|_|_|_|        |_|_|_|_|_|_| E
// D |_|_|_|_|_|_|        |_|_|_|_|_|_| D
// C |_X_|_ _|_ _|        |_ _|_ _|_ _| C
// B |_ _|_ _|_ _|        |_ _|_ _|_ _| B	
// A |_ _|_ _|_ _|        |_ _|_ _|_ _| A
//                Entrance
//
// Legend