package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnterParticulars extends View {

    public EnterParticulars(int userType, View nextView) {
        super("enterParticulars", userType, nextView);
    }

    public void display() {
        outputPageName("Booking: Enter Particulars");

        System.out.println("Chosen movie: '" + BookingController.getChosenMovie().getTitle() + "'"
                + "\nTotal booking price: $" + BookingController.getTotalPrice()
                + "\n");

        getEmail();
    }

    private void getEmail() {
        String email;
        System.out.print("Please input your email address (Input 0 to go back): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.nextLine();

        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(input);

        if(mat.matches()) {
            email = input;
            Customer existingCustomer = MainModel.customerWithEmail(email);
            if (existingCustomer != null) {
                System.out.println("You've already booked with us. It's good to see you again!");
                System.out.printf("Your name: %s\n", existingCustomer.getName());
                System.out.printf("Your phone: %s\n", existingCustomer.getPhoneNumber());
                getConfirmation(existingCustomer, null, null, null);
            } else {
                getName(email);
            }
        }
        else if (input.contentEquals("0")) {
            Navigation.goBack();
        }
        else{
            System.out.println("Not a valid email address.");
            getEmail();
        }
        sc.close();
    }

    private void getName(String email) {
        String name;
        System.out.print("Please input your name (Input 0 to go back): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.nextLine();
        if (input.contentEquals("0")) {
            getEmail();
        }
        else{
            name = input;
            getPhone(email, name);
        }
        sc.close();
    }

    private void getPhone(String email, String name) {
        String phone;
        System.out.print("Please input your 8-digit phone number (Input 0 to go back): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.nextLine();
        if (input.contentEquals("0")) {
            getName(email);
        }
        else if (isValidPhone(input)) {
            phone = input;
            getConfirmation(null, email, name, phone);
        }
        else {
            getPhone(email, name);
        }
    }
    private boolean isValidPhone(String mobile) {
        if (mobile == null || mobile.trim().length() <= 0) {
            return false;
        }
        mobile = removeAllSpace(mobile);
        Pattern pattern = Pattern.compile("[8-9][0-9]{7}");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }
    private String removeAllSpace(String s) {
        if (s == null) return "";
        return s.replaceAll("\\s", "");
    }
    private void getConfirmation(Customer customer, String email, String name, String phone) {
        int input = getChoice("Input 1 to confirm the payment, 0 to go back: ");
        if (input == 0) {
            if (customer != null)
                getEmail();
            else
                getPhone(email, name);
        }
        else if (input == 1) {
            if (customer == null) {
                customer = new Customer(email, name, phone);
                MainModel.addCustomer(customer);
            }
            customer.addBooking(BookingController.createBooking(email));
            BookingController.getChosenMovie().addTicketSales(BookingController.getNoOfSeats());
            BookingController.getChosenShowtime().setSeatLayout(BookingController.getSeatLayout());
            System.out.println("Thank you for your purchase. You will now be redirected to the main menu.");
            System.out.println(MainModel.getCustomerList().get(0).getBookingList().get(0).getTID());
            Navigation.goBackMainMenu();
        }
        else {
            System.out.println("Please enter a valid input.");
            getConfirmation(customer, email, name, phone);
        }
    }
}
