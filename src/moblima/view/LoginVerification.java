package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.StaffController;

import java.util.Scanner;

public class LoginVerification extends View{

    public LoginVerification(int userType, View nextView) {
        super("loginVerification", userType, nextView);
    }

    private final static int maxAttempts = 3;

    public void display() {
        outputPageName("Login Verification");

        System.out.println("(0) Back\n");

        int attempts = 0;
        getUsername(attempts);
    }

    private void getUsername(int attempts) {
        if (attempts == maxAttempts) {
            System.out.println("\nYou have exceeded the maximum number of attempts. You will now be redirected to the main menu.");
            Navigation.goBackMainMenu();
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your username: ");
        String username = sc.next();
        sc.nextLine();
        if (username.contentEquals("0")) {
            Navigation.goBack();
        }
        else {
            getPassword(username, attempts);
        }
    }

    private void getPassword(String username, int attempts) {
        boolean successful;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your password: ");
        String password = sc.next();
        sc.nextLine();
        successful = StaffController.login(username, password);
        if (username.contentEquals("0")) {
            getUsername(attempts);
        }
        else if (successful){
            System.out.println("\nLogin Successful. Welcome " + username + "!");
            Navigation.goTo(new AdminMenu(getUserType(), null));
        }
        else {
            System.out.println("Invalid username/password");
            attempts++;
            System.out.println("Number of attempts left: " + (maxAttempts-attempts));
            getUsername(attempts);
        }
    }

}
