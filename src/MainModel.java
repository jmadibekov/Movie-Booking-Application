import java.util.ArrayList;

public class MainModel {
	private int noOfCinema;
	private int noOfCustomer;
	private ArrayList<Cineplex> cineplexList;
	private ArrayList<Customer> customerList;
	
	public MainModel(int noOfCinema, int noOfCustomer) {
		this.noOfCinema = noOfCinema;
		this.noOfCustomer = noOfCustomer;
		cineplexList = new ArrayList<Cineplex>();
		customerList = new ArrayList<Customer>();
		Cineplex jurongPointCineplex = new Cineplex(3, 3, 3, "Jurong Point Cinema", 1, 10.0);
		cineplexList.add(jurongPointCineplex);
		Cineplex payaLebarCineplex = new Cineplex(3, 3, 3, "Paya Lebar Cinema", 2, 8.0);
		cineplexList.add(payaLebarCineplex);
		Cineplex vivoCityCineplex = new Cineplex(3, 3, 3, "Vivo City Cinema", 3, 12.0);
		cineplexList.add(vivoCityCineplex);
		
	}

	public ArrayList<Cineplex> getCineplexList() {
		return cineplexList;
	}

	public void setCineplexList(ArrayList<Cineplex> cineplexList) {
		this.cineplexList = cineplexList;
	}
	
	public void addCinema(Cineplex cineplex) {
		cineplexList.add(cineplex);
		noOfCinema++;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public void addCustomer(Customer customer) {
		customerList.add(customer);
		noOfCustomer++;
	}
}
