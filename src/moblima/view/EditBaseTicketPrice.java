package moblima.view;

public class EditBaseTicketPrice {

    public EditBaseTicketPrice() {

    }

    public void display(Navigation navigation) {
        System.out.println(
                "=====================================\n"
                        + "-----------Add Holiday Date----------\n"
                        + "=====================================\n"
                        + "(0) Back\n");

        getNewBasePrice(navigation);
    }

    public void getNewBasePrice(Navigation navigation) {
        double newPrice = navigation.getDouble("Please input new baseTicketPrice: ");
        if (newPrice == 0) {
            navigation.goBack();
        }
        else {
            System.out.println("BaseTicketPrice successfully change to $" + newPrice);
            navigation.goBack();
        }
    }
}
