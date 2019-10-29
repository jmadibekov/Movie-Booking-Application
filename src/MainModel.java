import java.util.ArrayList;

public class MainModel {
	private int noOfCinema;
	private ArrayList<Cinema> cinemaList;
	
	public MainModel(int noOfCinema) {
		this.noOfCinema = noOfCinema;
		this.cinemaList = new ArrayList<Cinema>();
		Cinema JurongPointCinema = new Cinema(3, 3, 3, "Jurong Point Cinema", 1, 10.0);
		cinemaList.add(JurongPointCinema);
		Cinema PayaLebarCinema = new Cinema(3, 3, 3, "Paya Lebar Cinema", 2, 8.0);
		cinemaList.add(PayaLebarCinema);
		Cinema VivoCityCinema = new Cinema(3, 3, 3, "Vivo City Cinema", 3, 12.0);
		cinemaList.add(VivoCityCinema);
		
	}

	public ArrayList<Cinema> getCinemaList() {
		return cinemaList;
	}

	public void setCinemaList(ArrayList<Cinema> cinemaList) {
		this.cinemaList = cinemaList;
	}
	
	public void addCinema(Cinema cinema) {
		cinemaList.add(cinema);
		noOfCinema++;
	}
}
