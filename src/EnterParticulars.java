import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnterParticulars extends ChooseSeats{

    private String email;
    private String name;
    private String phone;

    public EnterParticulars() {

    }

    public void display(StackArg stackArg, Stack<StackArg> stack) {
        System.out.println("=====================================\n"
                + "------Booking: Enter Particulars-----\n"
                + "=====================================\n\n"
                + stack.peek().getBookingCtrl().getMovie().getTitle()
                + "Total booking price: $" + stack.peek().getBookingCtrl().getTotalPrice()
                + "\n\n(0) Back");

        getEmail(stackArg, stack);


    }

    public void getEmail(StackArg stackArg, Stack<StackArg> stack) {
        System.out.print("Please input your email address (Input 0 to go back): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.nextLine();
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(input);

        if(mat.matches()) {
            email = input;
            getName(stackArg, stack);
        }
        else if (input.contentEquals("0")) {
            super.goBack(stack);
        }
        else{
            System.out.println("Not a valid email address");
            getEmail(stackArg, stack);
        }
        sc.close();
    }

    public void getName(StackArg stackArg, Stack<StackArg> stack) {
        System.out.print("Please input your name (Input 0 to go back): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.nextLine();
        if (input.contentEquals("0")) {
            getEmail(stackArg, stack);
        }
        else{
            name = input;
            getPhone(stackArg, stack);
        }
        sc.close();
    }

    public void getPhone(StackArg stackArg, Stack<StackArg> stack) {
        System.out.print("Please input your 8-digit phone number (Input 0 to go back): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.nextLine();
        if (input.contentEquals("0")) {
            getName(stackArg, stack);
        }
        else if (isValidPhone(input)) {
            phone = input;
            getConfirmation(stackArg, stack);
        }
        else {
            getPhone(stackArg, stack);
        }
    }
    public boolean isValidPhone(String mobile) {
        if (mobile == null || mobile.trim().length() <= 0) {
            return false;
        }
        mobile = removeAllSpace(mobile);
        Pattern pattern = Pattern.compile("[7-9][0-9]{7}");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }
    public String removeAllSpace(String s) {
        if (s == null) return "";
        return s.replaceAll("\\s", "");
    }
    public void getConfirmation(StackArg stackArg, Stack<StackArg> stack) {
        System.out.print("Input 1 to confirm payment, 0 to go back: ");
        int input = super.getIntInput();
        if (input == 0) {
            getPhone(stackArg, stack);
        }
        else if (input == 1) {
            if (Navigation.model.getCustomerList() == null) {
                Customer customer = new Customer(email, name, phone);
                customer.addBooking(stack.peek().getBookingCtrl().createBooking(email));
                Navigation.model.addCustomer(customer);
            }
            else {
                boolean notfound = true;
                for (int i=0;i<Navigation.model.getCustomerList().size();i++) {
                    if (Navigation.model.getCustomerList().get(i).getEmail().contentEquals(email)) {
                        Navigation.model.getCustomerList().get(i).addBooking(stack.peek().getBookingCtrl().createBooking(email));
                        notfound = false;
                        break;
                    }
                }
                if (notfound) {
                    Customer customer = new Customer(email, name, phone);
                    customer.addBooking(stack.peek().getBookingCtrl().createBooking(email));
                    Navigation.model.addCustomer(customer);
                }
            }
            System.out.println("Thank you for your purchase. You will now be redirected to the main menu");
            super.goBackMainMenu(stack);
        }
        else {
            System.out.println("Please enter a valid input");
            getConfirmation(stackArg, stack);
        }
    }
}
