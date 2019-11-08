package moblima.model;

import moblima.controller.*;

import java.io.IOException;
import java.util.ArrayList;

public class MainModel {
	private static ArrayList < Cineplex > cineplexList;
	private static ArrayList < Customer > customerList;
	
	public static void init() {
		cineplexList = new ArrayList < Cineplex > ();
		cineplexList.add(new Cineplex( "Jurong Point Cinema", "001", 10.0));
		cineplexList.add(new Cineplex("Paya Lebar Cinema", "002", 8.0));
		cineplexList.add(new Cineplex("Vivo City Cinema", "003", 12.0));

		try {
			customerList = DBController.readCustomer("src/moblima/data/CustomerDB.txt");
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}

	public static void output() {
		for (Cineplex i : cineplexList) {
			i.output();
		}
	}

	public static ArrayList < Cineplex > getCineplexList() {
		return cineplexList;
	}

	public static void setCineplexList(ArrayList < Cineplex > cineplexList) {
		MainModel.cineplexList = cineplexList;
	}
	
	public void addCinema(Cineplex cineplex) {
		cineplexList.add(cineplex);
	}

	public static ArrayList < Customer > getCustomerList() {
		return customerList;
	}

	public static void setCustomerList(ArrayList < Customer > customerList) {
		MainModel.customerList = customerList;
	}

	public static void addCustomer(Customer customer) {
		customerList.add(customer);
	}
}
