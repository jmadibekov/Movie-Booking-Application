import java.util.Calendar;

public class Booking {
	private String email;
	private String date;
	private String TID;
	private int noOfSeats;
	private String theatreClass;
	private float totalCost;
	
	public Booking(String email, String date, String cinemaId, int noOfSeats, String theatreClass) {
		this.email = email;
		this.date = date;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		if (month < 10) {
			TID = cinemaId + Integer.toString(year) + "0" + Integer.toString(month) + 
					Integer.toString(day) + Integer.toString(hour) + Integer.toString(minute);
		}
		else {
			TID = cinemaId + Integer.toString(year) + Integer.toString(month) + 
					Integer.toString(day) + Integer.toString(hour) + Integer.toString(minute);
		}
		this.noOfSeats = noOfSeats;
		this.theatreClass = theatreClass;
		this.totalCost = noOfSeats * 2; // BaseCost TBC
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTID() {
		return TID;
	}
	public void setTID(String tID) {
		TID = tID;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getTheatreClass() {
		return theatreClass;
	}
	public void setTheatreClass(String theatreClass) {
		this.theatreClass = theatreClass;
	}
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
