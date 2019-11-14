package moblima.view;

import moblima.controller.Navigation;
import moblima.model.StackArg;
import moblima.controller.StaffController;

import java.util.Scanner;

public class LoginVerification {

    public LoginVerification() {
    }

    public void display(Navigation navigation) {
        int attempts = 0;
        final int maxAttempts = 3;
        System.out.println(
                "=====================================\n"
                        + "----------Login Verification---------\n"
                        + "=====================================\n"
                        + "(0) Back\n");

        getUsername(navigation, attempts, maxAttempts);
    }

    private void getUsername(Navigation navigation, int attempts, int maxAttempts) {
        if (attempts == maxAttempts) {
            System.out.println("You have exceeded the maximum number of attempts. You will now be redirected to the main menu");
            navigation.goBackMainMenu();
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your username: ");
        String username = sc.next();
        sc.nextLine();
        if (username.contentEquals("0")) {
            navigation.goBack();
        }
        else {
            getPassword(navigation, username, attempts, maxAttempts);
        }
    }

    private void getPassword(Navigation navigation, String username, int attempts, int maxAttempts) {
        boolean successful;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your password: ");
        String password = sc.next();
        sc.nextLine();
        successful = StaffController.login(username, password);
        if (username.contentEquals("0")) {
            getUsername(navigation, attempts, maxAttempts);
        }
        else if (successful){
            System.out.println("\nLogin Successful. Welcome " + username);
            navigation.goTo(new StackArg("adminMenu", navigation.getLastView().getUserType()));
        }
        else {
            System.out.println("Invalid username/password");
            attempts++;
            System.out.println("Number of attempts left: " + (maxAttempts-attempts));
            getUsername(navigation, attempts, maxAttempts);
        }
    }

}
