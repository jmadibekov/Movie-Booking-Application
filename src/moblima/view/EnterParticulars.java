package moblima.view;

import moblima.controller.*;
import moblima.model.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnterParticulars {

    private String email;
    private String name;
    private String phone;

    public EnterParticulars() {
    }

    public void display(Navigation navigation) {
        System.out.println(
                  "=====================================\n"
                + "------Booking: Enter Particulars-----\n"
                + "=====================================\n\n"
                + BookingController.getChosenMovie().getTitle()
                + "\nTotal booking price: $" + BookingController.getTotalPrice()
                + "\n\n(0) Back");

        getEmail(navigation);


    }

    private void getEmail(Navigation navigation) {
        System.out.print("Please input your email address (Input 0 to go back): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.nextLine();

        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(input);

        if(mat.matches()) {
            email = input;
            getName(navigation);
        }
        else if (input.contentEquals("0")) {
            navigation.goBack();
        }
        else{
            System.out.println("Not a valid email address");
            getEmail(navigation);
        }
        sc.close();
    }

    private void getName(Navigation navigation) {
        System.out.print("Please input your name (Input 0 to go back): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.nextLine();
        if (input.contentEquals("0")) {
            getEmail(navigation);
        }
        else{
            name = input;
            getPhone(navigation);
        }
        sc.close();
    }

    private void getPhone(Navigation navigation) {
        System.out.print("Please input your 8-digit phone number (Input 0 to go back): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.nextLine();
        if (input.contentEquals("0")) {
            getName(navigation);
        }
        else if (isValidPhone(input)) {
            phone = input;
            getConfirmation(navigation);
        }
        else {
            getPhone(navigation);
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
    private void getConfirmation(Navigation navigation) {
        int input = navigation.getChoice("Input 1 to confirm payment, 0 to go back: ");
        if (input == 0) {
            getPhone(navigation);
        }
        else if (input == 1) {
            if (MainModel.getCustomerList() == null) {
                Customer customer = new Customer(email, name, phone);
                customer.addBooking(BookingController.createBooking(email));
                MainModel.addCustomer(customer);
            }
            else {
                boolean notfound = true;
                for (int i=0;i < MainModel.getCustomerList().size();i++) {
                    if (MainModel.getCustomerList().get(i).getEmail().contentEquals(email)) {
                        MainModel.getCustomerList().get(i).addBooking(BookingController.createBooking(email));
                        notfound = false;
                        break;
                    }
                }
                if (notfound) {
                    Customer customer = new Customer(email, name, phone);
                    customer.addBooking(BookingController.createBooking(email));
                    MainModel.addCustomer(customer);
                }
            }
            BookingController.getChosenMovie().addTicketSales(BookingController.getNoOfSeats());
            BookingController.getChosenShowtime().setSeatLayout(BookingController.getSeatLayout());
            System.out.println("Thank you for your purchase. You will now be redirected to the main menu");
            System.out.println(MainModel.getCustomerList().get(0).getBookList().get(0).getTID());
            navigation.goBackMainMenu();
        }
        else {
            System.out.println("Please enter a valid input");
            getConfirmation(navigation);
        }
    }
}
