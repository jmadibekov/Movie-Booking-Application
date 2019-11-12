package moblima.view;

import moblima.controller.StaffController;

public class EditBaseTicketPrice {

    public EditBaseTicketPrice() {

    }

    public void display(Navigation navigation) {
        System.out.println(
                "=====================================\n"
                        + "--------Edit Base Ticket Price-------\n"
                        + "=====================================\n"
                        + "(0) Back\n");
        System.out.printf("%s\nCurrent base ticket Price: $%.2f\n\n",
                StaffController.getChosenCineplex().getCineplexName(),
                StaffController.getChosenCineplex().getBaseTicketCost());
        getNewBasePrice(navigation);
    }

    private void getNewBasePrice(Navigation navigation) {
        double inputPrice = navigation.getDouble("Please enter a new base ticket price (5.00 - 20.00): ");
        if (inputPrice == 0) {
            navigation.goBack();
        }
        else if (inputPrice < 5 || inputPrice > 20) {
            System.out.println("Please input a number between 5.00 - 20.00");
            getNewBasePrice(navigation);
        }
        else if (navigation.checkTwoDecimal(inputPrice)) {
            StaffController.getChosenCineplex().setBaseTicketCost(inputPrice);
            System.out.println("Base ticket price successfully changed to $ " + inputPrice);
            navigation.goBack();
        }
        else {
            System.out.println("Please input a number with at most two decimal places");
            getNewBasePrice(navigation);
        }
    }
}
