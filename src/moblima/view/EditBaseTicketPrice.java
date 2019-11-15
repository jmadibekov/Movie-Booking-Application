package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.StaffController;

/**
 * Represents the screen where staff can edit the base price of tickets of the cineplex staff belongs to
 */
public class EditBaseTicketPrice extends View {

    /**
     * Instantiates a new Edit base ticket price view
     *
     * @param userType the user type
     * @param nextView the next view
     */
    public EditBaseTicketPrice(int userType, View nextView) {
        super("editBaseTicketPrice", userType, nextView);
    }

    /**
     * Display the view
     */
    public void display() {
        outputPageName("Edit Base Ticket Price");

        System.out.println("(0) Back\n");
        System.out.printf("%s\nCurrent base ticket Price: $%.2f\n\n",
                StaffController.getChosenCineplex().getCineplexName(),
                StaffController.getChosenCineplex().getBaseTicketCost());

        while (true) {
            double inputPrice = getDouble("Please enter a new base ticket price (5.00 - 20.00): ");
            if (inputPrice == 0) {
                Navigation.goBack();
                break;
            } else if (inputPrice < 5 || inputPrice > 20) {
                System.out.println("Please input a number between 5.00 - 20.00");
            } else if (checkTwoDecimal(inputPrice)) {
                StaffController.getChosenCineplex().setBaseTicketCost(inputPrice);
                System.out.printf("\nBase ticket price successfully changed to $%.2f\n", inputPrice);
                Navigation.goBack();
                break;
            } else {
                System.out.println("Please input a number with at most two decimal places");
            }
        }
    }
}
