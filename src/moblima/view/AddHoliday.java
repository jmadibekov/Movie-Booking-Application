package moblima.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddHoliday {

    public AddHoliday() {
    }

    public void display(Navigation navigation) {
        System.out.println(
                "=====================================\n"
                        + "-----------Add Holiday Date----------\n"
                        + "=====================================\n"
                        + "(0) Back\n");

        getHolidayDate(navigation);
    }

    public void getHolidayDate(Navigation navigation) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input holiday date in this format: dd/mm/yyyy: ");
        String date = sc.next();
        sc.nextLine();
        if (date.contentEquals("0")) {
            navigation.goBack();
        }
        else if (isThisDateValid(date)) {
            System.out.println("Holiday date " + date + " successfully added");
            navigation.goBack();
        }
        else {
            System.out.println("Invalid date format. Please try again");
            getHolidayDate(navigation);
        }
    }

    public boolean isThisDateValid(String dateToValidate){
        if(dateToValidate == null){
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e) {
            return false;
        }
        //Date inputDate = new Date(dateToValidate);
        //Date today = new Date();
        //if (inputDate > today)
        return true;
    }
}
