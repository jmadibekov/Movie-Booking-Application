package moblima.model;

import java.util.ArrayList;

public class MainModel {
	private static int noOfCinema;
	private static int noOfCustomer;
	private static ArrayList<Cineplex> cineplexList;
	private static ArrayList<Customer> customerList;
	
	public static void init(int noOfCinema, int noOfCustomer) {
		MainModel.noOfCinema = noOfCinema;
		MainModel.noOfCustomer = noOfCustomer;
		cineplexList = new ArrayList<Cineplex>();
		customerList = new ArrayList<Customer>();
		Cineplex jurongPointCineplex = new Cineplex(3, 3, 3, "Jurong Point Cinema", 1, 10.0);
		cineplexList.add(jurongPointCineplex);
		Cineplex payaLebarCineplex = new Cineplex(3, 3, 3, "Paya Lebar Cinema", 2, 8.0);
		cineplexList.add(payaLebarCineplex);
		Cineplex vivoCityCineplex = new Cineplex(3, 3, 3, "Vivo City Cinema", 3, 12.0);
		cineplexList.add(vivoCityCineplex);
	}

	public static ArrayList<Cineplex> getCineplexList() {
		return cineplexList;
	}

	public static void setCineplexList(ArrayList<Cineplex> cineplexList) {
		MainModel.cineplexList = cineplexList;
	}
	
	public void addCinema(Cineplex cineplex) {
		cineplexList.add(cineplex);
		noOfCinema++;
	}

	public static ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public static void setCustomerList(ArrayList<Customer> customerList) {
		MainModel.customerList = customerList;
	}

	public static void addCustomer(Customer customer) {
		customerList.add(customer);
		noOfCustomer++;
	}
}
