package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.StaffController;

import java.util.Scanner;

/**
 * Represents the screen for staff to login and henceforth verify his/her username and password
 */
public class LoginVerification extends View{

    /**
     * Instantiates a new Login verification view
     *
     * @param userType the user type
     * @param nextView the next view
     */
    public LoginVerification(int userType, View nextView) {
        super("loginVerification", userType, nextView);
    }

    /**
     * Maximum number of attempts to login
     */
    private final static int MAX_ATTEMPTS = 3;

    /**
     * Display the view
     */
    public void display() {
        outputPageName("Login Verification");

        System.out.println("(0) Back\n");

        int attempts = 0;
        getUsername(attempts);
    }

    /**
     * Display the view to get username of a staff
     *
     * @param attempts the staff's current number of attempts at logging in
     */
    private void getUsername(int attempts) {
        if (attempts == MAX_ATTEMPTS) {
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

    /**
     * Display the view to get password of a staff
     *
     * @param username the staff's username
     * @param attempts the staff's current number of attempts at logging in
     */
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
            System.out.println("Number of attempts left: " + (MAX_ATTEMPTS-attempts));
            getUsername(attempts);
        }
    }

}
