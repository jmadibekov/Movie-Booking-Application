package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents the screen where a customer enters his/her particulars to complete his/her booking
 */
public class EnterParticulars extends View {

    /**
     * Instantiates a new Enter particulars view.
     *
     * @param userType the user type
     * @param nextView the next view
     */
    public EnterParticulars(int userType, View nextView) {
        super("enterParticulars", userType, nextView);
    }

    /**
     * Display the view
     */
    public void display() {
        outputPageName("Booking: Enter Particulars");

        System.out.println("Chosen movie: '" + BookingController.getChosenMovie().getTitle() + "'"
                + "\nTotal booking price: $" + BookingController.getTotalPrice()
                + "\n");

        getEmail();
    }

    /**
     * Display the view to get email address of a customer
     */
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

    /**
     * Display the view to get the name of a customer
     *
     * @param email the customer's email
     */
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

    /**
     * Display the view to get the phone number of a customer
     *
     * @param email the customer's email
     * @param name the customer's name
     */
    private void getPhone(String email, String name) {
        String phone;
        System.out.print("Please input your 8-digit Singaporean phone number (Input 0 to go back): ");
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

    /**
     * Check if the phone number of a customer is a valid 8-digit Singapore number
     *
     * @param mobile the customer's phone number
     * @return boolean value based on whether the phone number is a valid 8-digit Singapore number
     */
    private boolean isValidPhone(String mobile) {
        if (mobile == null || mobile.trim().length() <= 0) {
            return false;
        }
        mobile = removeAllSpace(mobile);
        Pattern pattern = Pattern.compile("[8-9][0-9]{7}");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    /**
     * Remove all spaces in a string text
     * @param s the string text
     * @return the string text without spaces
     */
    private String removeAllSpace(String s) {
        if (s == null) return "";
        return s.replaceAll("\\s", "");
    }

    /**
     * Display the view to get confirmation from customer
     *
     * @param customer the current customer
     * @param email the customer's email
     * @param name the customer's name
     * @param phone the customer's phone number
     */
    private void getConfirmation(Customer customer, String email, String name, String phone) {
        int input = getChoice("Input 1 to confirm the payment, 0 to go back: ");
        if (input == 0) {
            // existing customer
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

            Booking newBooking = BookingController.createBooking(email);
            customer.addBooking(newBooking);
            BookingController.getChosenMovie().addTicketSales(BookingController.getNoOfSeats());
            BookingController.getChosenShowtime().setSeatLayout(BookingController.getSeatLayout());

            System.out.println("\nTransaction ID: " + newBooking.getTID());
            System.out.println("Thank you for your purchase. You will now be redirected to the main menu.");
            Navigation.goBackMainMenu();
        }
        else {
            System.out.println("Please enter a valid input.");
            getConfirmation(customer, email, name, phone);
        }
    }
}
