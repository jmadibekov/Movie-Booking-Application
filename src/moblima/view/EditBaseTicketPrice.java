package moblima.view;

import moblima.controller.Navigation;
import moblima.controller.StaffController;

public class EditBaseTicketPrice extends View{

    public EditBaseTicketPrice(int userType, View nextView) {
        super("editBaseTicketPrice", userType, nextView);
    }
    
    public void display() {
        outputPageName("Edit Base Ticket Price");

        System.out.println("(0) Back\n");
        System.out.printf("%s\nCurrent base ticket Price: $%.2f\n\n",
                StaffController.getChosenCineplex().getCineplexName(),
                StaffController.getChosenCineplex().getBaseTicketCost());

        getNewBasePrice();
    }

    private void getNewBasePrice() {
        double inputPrice = getDouble("Please enter a new base ticket price (5.00 - 20.00): ");
        if (inputPrice == 0) {
            Navigation.goBack();
        }
        else if (inputPrice < 5 || inputPrice > 20) {
            System.out.println("Please input a number between 5.00 - 20.00");
            getNewBasePrice();
        }
        else if (checkTwoDecimal(inputPrice)) {
            StaffController.getChosenCineplex().setBaseTicketCost(inputPrice);
            System.out.println("Base ticket price successfully changed to $ " + inputPrice);
            Navigation.goBack();
        }
        else {
            System.out.println("Please input a number with at most two decimal places");
            getNewBasePrice();
        }
    }
}
