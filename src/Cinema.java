public class Cinema {
	private String cinemaId;
	private String CinemaClass;
	
	public Cinema(String cinemaId, String cinemaClass) {
		this.cinemaId = cinemaId;
		this.CinemaClass = cinemaClass;
	}

	public String getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getCinemaClass() {
		return CinemaClass;
	}

	public void setCinemaClass(String CinemaClass) {
		this.CinemaClass = CinemaClass;
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